/*
自定义异常要写进同一个文件，不同文件中可能需要打包，不然会包这样的错误
Error: A JNI error has occurred, please check your installation and try again
Exception in thread "main" java.lang.NoClassDefFoundError: SeverTimedOutException
*/
import java.io.*;
import java.net.*;
public class ExceptionSplit{
    String defaultServer, alternativeServer;
    public void connectMe(String serverName)
        throws ServerTimedOutException {
            int portToConnect = 80;
            try(Socket s = new Socket(serverName, portToConnect)){
                //带资源的try语句
            }
            catch(IOException e) {
                throw new ServerTimedOutException(
                    "Could not connect",
                    portToConnect);
            }
        }
    public void findServer(){
        try{
            connectMe(defaultServer);
        } catch (ServerTimedOutException e) {
            System.out.println("Sever timed out, trying alternative");
            try {
                connectMe(alternativeServer);
                System.out.println("Alternative work");
            } catch (ServerTimedOutException e1) {
                System.out.println("Error: " + 
                    e1.getMessage() + 
                    " connecting to port " +
                    e1.getPort());
            }
        }
    }
    public static void main(String []args){
        STOException_Test a = new STOException_Test();
        a.defaultServer = "39.106.83.23";
        a.alternativeServer = "www.baidu.com";
        a.findServer();
        a.alternativeServer = "39.106.83.23";
        a.findServer();
    }
}