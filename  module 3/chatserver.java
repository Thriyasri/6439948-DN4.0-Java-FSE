import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started. Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String clientMessage, serverMessage;

        while (true) {
            clientMessage = reader.readLine();
            if (clientMessage == null || clientMessage.equalsIgnoreCase("exit")) {
                System.out.println("Client disconnected.");
                break;
            }
            System.out.println("Client: " + clientMessage);

            System.out.print("You: ");
            serverMessage = console.readLine();
            writer.println(serverMessage);
        }

        socket.close();
        serverSocket.close();
    }
}
