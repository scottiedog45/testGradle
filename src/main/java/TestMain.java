import ej.wadapps.app.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TestMain implements BackgroundService {

    public static void main(String[] args) {

        System.out.println("startingg");

        try {

            final ServerSocket server = new ServerSocket(8080);
            System.out.println("Listening for connection on port 8080 ....");
            while (true) {
                Socket clientSocket = server.accept();
                InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
                BufferedReader reader = new BufferedReader(isr);
                String line = reader.readLine();
                while (!line.isEmpty()) {
                    System.out.println(line);
                    line = reader.readLine();
                }
            }
        } catch (java.io.IOException e) {
            System.out.println(e.getLocalizedMessage());
        }


    }

    @Override
    public void onStart() {
        main(null);
    }

    @Override
    public void onStop() {
        System.out.println("stoppped");
    }
}
