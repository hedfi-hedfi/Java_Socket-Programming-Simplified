import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket sock = new Socket("127.0.0.1",9999);

        System.out.println("Connected to server...");

        InputStream in = sock.getInputStream();
        OutputStream out = sock.getOutputStream();

        out.write("Hello from client...".getBytes());

        byte[] response = new byte[1024];
        in.read(response);

        System.out.println("Received from server -- " + new String(response).trim());

        sock.close();
    }
}
