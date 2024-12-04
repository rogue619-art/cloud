import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class EavesdroppingProtection {
    public static void main(String[] args) throws Exception {
        String message = "Confidential data to protect from eavesdropping";

        // Generate secret key for encryption
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // AES key size
        SecretKey secretKey = keyGen.generateKey();

        // Encrypt the message
        Cipher encryptCipher = Cipher.getInstance("AES");
        encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = encryptCipher.doFinal(message.getBytes());
        String encryptedMessage = Base64.getEncoder().encodeToString(encryptedBytes);

        // Simulate eavesdropping prevention by encrypting the data
        System.out.println("Original Message: " + message);
        System.out.println("Encrypted Message (Protected): " + encryptedMessage);

        // Decrypt the message to verify
        Cipher decryptCipher = Cipher.getInstance("AES");
        decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = decryptCipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
        String decryptedMessage = new String(decryptedBytes);

        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}

