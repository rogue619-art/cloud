import javax.net.ssl.*;
import java.io.*;

public class SSLClient {
    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.trustStore", "keystore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "password");

        try (SSLSocket clientSocket = (SSLSocket) SSLSocketFactory.getDefault().createSocket("localhost", 8443);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {
            System.out.println("Connected to SSL Server!");

            // Send a message to the server
            writer.println("Hello, SSL Server!");
            
            // Receive and print the server's response
            String response = reader.readLine();
            System.out.println("Server: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

