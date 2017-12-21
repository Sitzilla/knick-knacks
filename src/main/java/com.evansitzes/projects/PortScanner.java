import java.net.Socket;
import java.net.InetSocketAddress;
import java.io.IOException;

/*
    A simple program that takes a domain/IP and a range of ports, and pings them on a 1 second timeout to confirm if they are open.
    Prints whether the port is open and information about the port.
    params:
        - domain/IP address
        - starting port
        - ending port

    *** DISCLAIMER: unathorized port scanning is widely considered to be a malicious act. Only scan networks that you own or are authorized to scan.
*/
public class PortScanner {

    private static final int TIMEOUT = 1000;

    public static void main(String[] args) {

        final String domain = args[0];
        final int startingPort = Integer.parseInt(args[1]);
        final int endingPort = Integer.parseInt(args[2]);

        for (int i = startingPort; i <= endingPort; i++) {
            connectToPort(domain, i);
        }
    }

    private static void connectToPort(final String domain, final int port) {
        try {
            final Socket socket = new Socket();
            socket.connect(new InetSocketAddress(domain, port), TIMEOUT);

            System.out.println("Connected to port " + socket.getPort());
            System.out.println("Connected to local port " + socket.getLocalPort());
            System.out.println("Connected to local port " + socket.getRemoteSocketAddress());

            socket.close();
        } catch (IOException e) {
            System.out.println("Error connecting to port " + port + ". " + e.getMessage());
        }
    }
}