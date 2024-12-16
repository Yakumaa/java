package Lab5;

import java.io.*;
import java.net.*;
public class TCPserver {
    private ServerSocket server;
    private Socket client;
    private DataInputStream in;
    public TCPserver(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server ready, waiting for client...");
            client = server.accept(); // Accept client connection
            System.out.println("Client connected");
            in = new DataInputStream(client.getInputStream());
            String message = "";
            while (!message.equals("out")) {
                message = in.readUTF(); // Reading from client
                System.out.println("Client says: " + message);
                if (message.equals("Hello")) {
                    System.out.println("Welcome");
                } else if (!message.equals("out")) {
                    System.out.println("Error in input");
                }            }
            in.close();
            client.close();
            server.close();
        } catch (IOException e) {
            System.out.println("I/O error: " + e);        }    }
    public static void main(String[] args) {
        new TCPserver(9999);
    }
}

