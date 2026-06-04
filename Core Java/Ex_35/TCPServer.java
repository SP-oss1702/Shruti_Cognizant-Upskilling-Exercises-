import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPServer {

    public static void main(String[] args) {
        int port = 5000;

        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║       TCP Chat Server            ║");
        System.out.println("╚══════════════════════════════════╝");
        System.out.println("Server starting on port " + port + "...");

        try {
            // Step 1 — Create ServerSocket that listens for connections
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("✅ Server is running! Waiting for client...\n");

            // Step 2 — Accept client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("✅ Client connected: "
                    + clientSocket.getInetAddress().getHostAddress());
            System.out.println("─────────────────────────────────────");
            System.out.println("💬 Chat started! Type your message.");
            System.out.println("   Type 'exit' to end the chat.");
            System.out.println("─────────────────────────────────────\n");

            // Step 3 — Set up InputStream and OutputStream
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    clientSocket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);

            // Step 4 — Two-way communication loop
            String clientMessage;
            while (true) {

                // Receive message from client
                clientMessage = input.readLine();
                if (clientMessage == null || 
                    clientMessage.equalsIgnoreCase("exit")) {
                    System.out.println("\n❌ Client has disconnected.");
                    break;
                }
                System.out.println("👤 Client: " + clientMessage);

                // Send reply to client
                System.out.print("🖥️  Server: ");
                String serverMessage = scanner.nextLine();

                if (serverMessage.equalsIgnoreCase("exit")) {
                    output.println("exit");
                    System.out.println("\n✅ Server closed the chat.");
                    break;
                }
                output.println(serverMessage);
            }

            // Step 5 — Close all connections
            input.close();
            output.close();
            clientSocket.close();
            serverSocket.close();
            scanner.close();
            System.out.println("🔌 Server shut down.");

        } catch (IOException e) {
            System.out.println("❌ Server error: " + e.getMessage());
        }
    }
}