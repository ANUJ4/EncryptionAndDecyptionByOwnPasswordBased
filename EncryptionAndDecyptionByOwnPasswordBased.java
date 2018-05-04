package com.akt.security.use;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author Anuj kumar tiwari
 * @version 1.0.2018
 * @category Security
 * @param EncryptionAndDecyptionByOwnPasswordBased
 *            Constructor Takes only 16bit length string as a key. Key must me
 *            same for encrypt and decrypt.
 * @param Method
 *            EncryptionWithAKT takes string to encrypt, Method
 *            DecryptionWithAKT takes encrypted string, Method isEncrypted takes
 *            encrypted string.
 * @return Method EncryptionWithAKT return String that is encoded, Method
 *         DecryptionWithAKT return String that is decoded means original
 *         String, isEncrypted return boolean value.
 */

public class EncryptionAndDecyptionByOwnPasswordBased implements Serializable{
	private static final long serialVersionUID = 1L;
	String key = "AKTTEMPVAL6723IU";
	private static String initVector = "AKTENCRTPYIUOWER";
	public EncryptionAndDecyptionByOwnPasswordBased(){
		this.key = "AKTTEMSPVL6923IU";	
	}

	public EncryptionAndDecyptionByOwnPasswordBased(String pwd) {
		if (pwd == null || pwd.equals("") || pwd.length() != 16) {
			throw new IllegalArgumentException(
					"String Key Should have length = 16 only.But you passed length = " + pwd.length() + ".");
		}
		this.key = pwd.toUpperCase();
	}

	private String encrypt(String key, String initVector, String value) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
			byte[] encrypted = cipher.doFinal(value.getBytes());
			return Base64.encodeBase64String(encrypted);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private String decrypt(String key, String initVector, String encrypted) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
			return new String(original);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public String DecryptionWithAKT(String dec) {
		try {

			return decrypt(this.key, initVector, dec);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String EncryptionWithAKT(String enc) {
		try {

			return encrypt(this.key, initVector, enc);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean isEncrypted(String string) {
		String pattern = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(string);
		if (m.find()) {
			return true;
		} else {
			return false;
		}
	}
}
