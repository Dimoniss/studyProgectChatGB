import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    public static void main(String[] args) {
        Socket socket;
        try (ServerSocket serverSocket = new ServerSocket(7777)) {
            socket = serverSocket.accept();
            System.out.println("Client " + socket.getLocalAddress() + ":" + socket.getPort() +
                    " is connected :" + socket.isConnected());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String strFromClient = in.readUTF();
                            if (strFromClient.equalsIgnoreCase("/end")) {
                                break;
                            }
                            System.out.println("Client: " + strFromClient);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            while (true) {
                String message = reader.readLine();
                out.writeUTF(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}