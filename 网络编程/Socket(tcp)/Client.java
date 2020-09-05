import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Client {
    public static final Logger log = Logger.getLogger("Socket Client");
    public static void main(String[] args) {
        String hostname = null;
        InetAddress host = null;
        int port = 8888;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-h")) {
                hostname = args[i+1];
            } else if (args[i].equals("-p")) {
                try {
                    port = Integer.parseInt(args[i+1]);
                } catch (NumberFormatException e) {
                    // pass
                }
            }
        }
        try {
            if (hostname == null) {
                host = InetAddress.getLocalHost();
            } else {
                host = InetAddress.getByName(hostname);
            }
        } catch (Exception e) {
            log.info("Available host not found!");
            return ;
        }
        try (
            Socket socket = new Socket(host, port);
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            PrintWriter writer = new PrintWriter(
                socket.getOutputStream(), true);
            Scanner s = new Scanner(System.in)
        ) {
            String message = null;
            
            while(true){
                message = s.nextLine();
                if(message.equals("exit")){
                    break;
                }
                writer.println(message);
                writer.flush();
                Client.log.info(reader.readLine());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
