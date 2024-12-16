package Lab5;
import java.io.*;
import java.net.*;
public class UDPclient {
    private DatagramSocket socket;
    private InetAddress serverAddress;
    private BufferedReader consoleInput;
    public UDPclient(String address, int port) {
        try {
            socket = new DatagramSocket();
            serverAddress = InetAddress.getByName(address);
            consoleInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Client is ready");
            System.out.println("Enter numbers to check if even or odd. Type 'exit' to quit.");
            String input;
            while (true) {
                System.out.print("Enter number: ");
                input = consoleInput.readLine();
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Client exiting...");
                    break;
                }
                byte[] sendData = input.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, port);
                socket.send(sendPacket);
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Server response: " + response);
            }
        } catch (IOException e) {
            System.out.println("I/O error: " + e);
        } finally {
            try {
                if (consoleInput != null) consoleInput.close();
                if (socket != null && !socket.isClosed()) socket.close();
            } catch (IOException e) {
                System.out.println("Error closing resources: " + e);
            }
        }
    }


    public static void main(String[] args) {
        new UDPclient("localhost", 9999);
    }
}
