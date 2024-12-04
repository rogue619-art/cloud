import java.security.*;
import javax.crypto.Cipher;

public class RSAExample {
    public static void main(String[] args) throws Exception {
        String message = "This is a test message.";

        // Generate RSA key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // Encrypt the message
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedMessage = encryptCipher.doFinal(message.getBytes());

        // Decrypt the message
        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedMessage = decryptCipher.doFinal(encryptedMessage);

        System.out.println("Original Message: " + message);
        System.out.println("Encrypted Message: " + new String(encryptedMessage));
        System.out.println("Decrypted Message: " + new String(decryptedMessage));
    }
}

