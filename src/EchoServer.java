import java.net.*;
import java.io.*;

public class EchoServer {
    public static final int portNumber = 6013;

    public static void main(String[] args) {
        try {
            // Start listening on the specified port
            ServerSocket socket = new ServerSocket(portNumber);

            // Run forever, which is common for server style services
            while (true) {
                // Wait until someone connects, thereby requesting a date
                Socket client = socket.accept();
                System.out.println("Got a request!");

                InputStream input = client.getInputStream();
                OutputStream output = client.getOutputStream();

                int b;

                while ((b = input.read())!= -1) {
                    output.write(b);
                }
            }
            // *Very* minimal error handling.
        } catch (IOException ioe) {
            System.out.println("We caught an unexpected exception");
            ioe.printStackTrace();
        }
    }
}