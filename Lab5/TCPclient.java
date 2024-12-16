package Lab5;

import java.io.*;
import java.net.*;

public class TCPclient {
    private Socket sc;
    private BufferedReader consoleInput;
    private DataOutputStream out;

    public TCPclient(String address, int port) {
        try {
            sc = new Socket(address, port);
            System.out.println("Client ready");
            System.out.println("Type any string and type 'out' to exit");
            
            consoleInput = new BufferedReader(new InputStreamReader(System.in));
            out = new DataOutputStream(sc.getOutputStream());

            String str = "";
            while (!str.equals("out")) {
                str = consoleInput.readLine(); // Reading from console
                out.writeUTF(str); // Sending to server
            }

            consoleInput.close();
            out.close();
            sc.close();
        } catch (UnknownHostException u) {
            System.out.println("Unknown host: " + u);
        } catch (IOException e) {
            System.out.println("I/O error: " + e);
        }
    }

    public static void main(String[] args) {
        new TCPclient("localhost", 9999);
    }
}
