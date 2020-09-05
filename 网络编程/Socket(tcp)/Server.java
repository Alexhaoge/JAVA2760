import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import java.nio.charset.StandardCharsets;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import java.io.*;

public class Server implements AutoCloseable {
    private ServerSocket serverSocket;
    
    private ExecutorService threadPool;

    protected static Logger log = Logger.getLogger("ServerSocket");

    public Server(int port) throws IOException{
        this(port, 10);
    }

    public Server(int port, int nThreads) throws IOException{
        serverSocket = new ServerSocket(port, nThreads * 2, InetAddress.getLocalHost());   
        threadPool = Executors.newFixedThreadPool(nThreads);
        
    }

    public void start() throws IOException{
        Socket socket = this.serverSocket.accept();
        this.threadPool.execute(new Handler(socket));
    }

    @Override
    public void close() throws Exception {
        this.serverSocket.close();
        this.threadPool.shutdown();
    }

    static class Handler implements Runnable{
        Socket socket = null;
        public Handler(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
            try (
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                PrintWriter writer = new PrintWriter(
                    new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8))
            ) {
                String readMessage = null;
                while(true){
                    log.info("server reading... ");
                    if((readMessage = reader.readLine()) == null){
                        break;
                    }
                    log.info(readMessage);
                    writer.println("server recive : " + readMessage);
                    writer.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }

    public static void main(String[] args) {
        int port;
        try{
            port = Integer.parseInt(args[0]);
        }catch(Exception e){
            port = 8888;
        }
        try (Server s = new Server(port)) {
            Server.log.info("Server start!");
            while (true) {
                s.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}