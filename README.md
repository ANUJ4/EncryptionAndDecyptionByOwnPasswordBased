# Security for encryption and decryption based
main class EncryptionAndDecyptionByOwnPasswordBased create object that takes 16 bit length string as key.

# Example 


```java
public static void main(String[] args) {
          EncryptionAndDecyptionByOwnPasswordBased s = new EncryptionAndDecyptionByOwnPasswordBased("AJAJTYEFERTDGHSD");
		String hel = s.EncryptionWithAKT("Hello");
		System.out.println("hel: " + hel);
		System.out.println(s.isEncrypted(hel));
		String dec = s.DecryptionWithAKT(hel);
		System.out.println("dec: " + dec);
	}


```
