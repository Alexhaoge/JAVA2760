import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.logging.Logger;

/**
 * DatagramSocket example from runoob.com.
 * https://www.runoob.com/java/java-networking.html
 */
public class Client {
    public static final Logger log = Logger.getLogger("UDP Client");
    public static void main(String[] args){
        try (
            DatagramSocket client = new DatagramSocket(5070);
            DatagramPacket packet = new DatagramPacket(new byte[1024],1024)
        ) {
            packet.setPort(5060);
            packet.setAddress(InetAddress.getLocalHost());
            packet.setData("Hello Server".getBytes());
            client.send(packet);
            client.receive(packet);
            log.info(packet.getAddress().getHostName() + "(" + packet.getPort() + "):" + new String(packet.getData()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
