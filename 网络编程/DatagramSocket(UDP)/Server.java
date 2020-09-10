import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.logging.Logger;

/**
 * DatagramSocket example from runoob.com.
 * https://www.runoob.com/java/java-networking.html
 */
public class Server {
    public static final Logger log = Logger.getLogger("UDP Server");
    public static void main(String[] args) {
        try (
            DatagramSocket server = new DatagramSocket(5060);
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024)
        ) {
            server.receive(packet);
            log.info(packet.getAddress().getHostName() + "(" + packet.getPort() + "):" + new String(packet.getData()));
            packet.setData("Hello Client".getBytes());
            packet.setPort(5070);
            packet.setAddress(InetAddress.getLocalHost());
            server.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
