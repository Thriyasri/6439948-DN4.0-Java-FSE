import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        System.out.println("Connected to server.");

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String serverMessage, clientMessage;

        while (true) {
            System.out.print("You: ");
            clientMessage = console.readLine();
            writer.println(clientMessage);

            if (clientMessage.equalsIgnoreCase("exit")) break;

            serverMessage = reader.readLine();
            if (serverMessage == null) break;
            System.out.println("Server: " + serverMessage);
        }

        socket.close();
    }
}
