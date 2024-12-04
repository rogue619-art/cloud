import java.security.*;

public class DigitalSignatureExample {
    public static void main(String[] args) throws Exception {
        String data = "This is a confidential message.";

        // KeyPair generation
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
        keyGen.initialize(1024);
        KeyPair keyPair = keyGen.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        // Signing the data
        Signature signature = Signature.getInstance("SHA256withDSA");
        signature.initSign(privateKey);
        signature.update(data.getBytes());
        byte[] digitalSignature = signature.sign();

        System.out.println("Digital Signature Generated: " + new String(digitalSignature));

        // Verifying the signature
        signature.initVerify(publicKey);
        signature.update(data.getBytes());
        boolean isVerified = signature.verify(digitalSignature);

        System.out.println("Signature verification: " + isVerified);
    }
}

