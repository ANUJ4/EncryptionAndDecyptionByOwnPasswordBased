# Security for encryption and decryption based
main class EncryptionAndDecyptionByOwnPasswordBased create object that takes 16 bit length string as key.

# Example 


```java
public static void main(String[] args) {
      	EncryptionAndDecyptionByOwnPasswordBased s = new EncryptionAndDecyptionByOwnPasswordBased("AJAJTYEFERTDGHSD");
		String hel = s.EncryptionWithAKT(
				"Hello 4e543  453q4sfd  et6546 er 4ee4 534 tretgeqt5tre t43fd1344v3!!#!@#!@#!#@$@dfrt");
		System.out.println("hel: " + hel);
		System.out.println(s.isEncrypted(hel));
		EncryptionAndDecyptionByOwnPasswordBased Ss = new EncryptionAndDecyptionByOwnPasswordBased("AJAJTYEFERTDGHSD");
		
		String dec = Ss.DecryptionWithAKT(hel);
		System.out.println("dec: " + dec);
		System.out.println(s.isEncrypted(dec));
	}


```
