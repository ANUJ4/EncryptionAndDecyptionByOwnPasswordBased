package com.akt.security.use;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author Anuj kumar tiwari
 * @version 1.0.2018
 * @category Security
 * @param EncryptionAndDecyptionByOwnPasswordBased
 *            Constructor Takes only 16bit length string as a key. Key must me
 *            same for encrypt and decrypt
 * @param Method
 *            EncryptionWithAKT takes string to encrypt, Method
 *            DecryptionWithAKT takes encrypted string
 * @return Method EncryptionWithAKT return String that is encoded, Method
 *         DecryptionWithAKT return String that is decoded means original String
 */

public class EncryptionAndDecyptionByOwnPasswordBased {
	String key = "AKTTEMPVAL6723IU";
	private static String initVector = "AKTENCRTPYIUOWER";

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
	
	public boolean isEncrypted(String enc) {
		try {
			return Base64.isBase64(enc);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
