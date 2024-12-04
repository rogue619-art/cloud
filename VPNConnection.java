import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;

public class VPNConnection {
    public static void main(String[] args) {
        try {
            int port = 12345; // Example port for VPN
            System.out.println("Simulating VPN connection...");

            // Create server
            Thread serverThread = new Thread(() -> {
                try (ServerSocket serverSocket = new ServerSocket(port)) {
                    System.out.println("VPN Server is running...");
                    Socket clientSocket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                    String line;
                    while ((line = in.readLine()) != null) {
                        System.out.println("Received: " + line);
                        out.println("Acknowledged: " + line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            // Start server
            serverThread.start();

            // Simulate client
            Thread.sleep(1000); // Wait for the server to start
            try (Socket socket = new Socket("localhost", port);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                System.out.println("Connected to VPN Server!");
                out.println("Hello from VPN Client!");
                System.out.println("Server Response: " + in.readLine());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

