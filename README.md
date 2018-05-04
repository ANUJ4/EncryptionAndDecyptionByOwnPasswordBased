# Security for encryption and decryption based
main class EncryptionAndDecyptionByOwnPasswordBased create object that takes 16 bit length string as key.

# Example 

public static void main(String[] args) {
		EncryptionAndDecyptionByOwnPasswordBased s = new EncryptionAndDecyptionByOwnPasswordBased("AJAJTYEFERTDGHSD");
		String hel = s.EncryptionWithAKT("a constructor with arguments or no-argument then compiler does not create default "
						+ "constructor. Default constructor provides the default values to the object like 0, null etc. depending on the type");
		System.out.println("hel: " + hel);
		System.out.println(Base64.isBase64(hel));
		String dec = s.DecryptionWithAKT(hel);
		System.out.println("dec: " + dec);
	}
