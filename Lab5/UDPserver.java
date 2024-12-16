package Lab5;
import java.io.*;
import java.net.*;
public class UDPserver {
    private DatagramSocket socket;
    public UDPserver(int port) {
        try {
            socket = new DatagramSocket(port);
            System.out.println("Server is ready, waiting for client...");
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            while (true) {
                socket.receive(packet);
                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received from client: " + received);
                try {
                    int number = Integer.parseInt(received.trim());
                    String response = (number % 2 == 0) ? "Even" : "Odd";
                    byte[] responseBytes = response.getBytes();
                    InetAddress clientAddress = packet.getAddress();
                    int clientPort = packet.getPort();
                    DatagramPacket responsePacket = new DatagramPacket(responseBytes, responseBytes.length, clientAddress, clientPort);
                    socket.send(responsePacket);
                    System.out.println("Sent to client: " + response);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number received from client.");
                }
            }
        } catch (IOException e) {
            System.out.println("I/O error: " + e);
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
    public static void main(String[] args) {
        new UDPserver(9999);
    }
}
