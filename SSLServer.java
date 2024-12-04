import javax.net.ssl.*;
import java.io.*;
import java.net.Socket;

public class SSLServer {
    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.keyStore", "keystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "password");

        try (SSLServerSocket serverSocket = (SSLServerSocket) SSLServerSocketFactory.getDefault().createServerSocket(8443)) {
            System.out.println("SSL server listening on port 8443...");
            try (SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {
                writer.println("Welcome to SSL Server!");
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Client: " + line);
                    writer.println("Echo: " + line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

