import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClient {

    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 5000;

        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║       TCP Chat Client            ║");
        System.out.println("╚══════════════════════════════════╝");
        System.out.println("Connecting to server at "
                + serverAddress + ":" + port + "...");

        try {
            // Step 1 — Connect to the server using Socket
            Socket socket = new Socket(serverAddress, port);
            System.out.println("✅ Connected to server!");
            System.out.println("─────────────────────────────────────");
            System.out.println("💬 Chat started! Type your message.");
            System.out.println("   Type 'exit' to end the chat.");
            System.out.println("─────────────────────────────────────\n");

            // Step 2 — Set up InputStream and OutputStream
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);

            // Step 3 — Two-way communication loop
            String serverMessage;
            while (true) {

                // Send message to server
                System.out.print("👤 Client: ");
                String clientMessage = scanner.nextLine();

                if (clientMessage.equalsIgnoreCase("exit")) {
                    output.println("exit");
                    System.out.println("\n✅ Client closed the chat.");
                    break;
                }
                output.println(clientMessage);

                // Receive reply from server
                serverMessage = input.readLine();
                if (serverMessage == null || 
                    serverMessage.equalsIgnoreCase("exit")) {
                    System.out.println("\n❌ Server has disconnected.");
                    break;
                }
                System.out.println("🖥️  Server: " + serverMessage);
            }

            // Step 4 — Close all connections
            input.close();
            output.close();
            socket.close();
            scanner.close();
            System.out.println("🔌 Connection closed.");

        } catch (ConnectException e) {
            System.out.println("❌ Cannot connect to server.");
            System.out.println("   Make sure TCPServer is running first!");
        } catch (IOException e) {
            System.out.println("❌ Client error: " + e.getMessage());
        }
    }
}