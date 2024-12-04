import java.security.*;

public class KeyExchangeExample {
    public static void main(String[] args) throws Exception {
        // Generate key pairs for two users
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        
        KeyPair user1Keys = keyGen.generateKeyPair();
        KeyPair user2Keys = keyGen.generateKeyPair();

        // Exchange public keys (simulated)
        PublicKey user1PublicKey = user1Keys.getPublic();
        PublicKey user2PublicKey = user2Keys.getPublic();

        System.out.println("User 1's Public Key: " + user1PublicKey);
        System.out.println("User 2's Public Key: " + user2PublicKey);

        // The secret keys remain private and are used for secure communication.
    }
}

