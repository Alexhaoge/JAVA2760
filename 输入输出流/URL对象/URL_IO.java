import java.io.*;
import java.net.*;
public class URL_IO{
    public static void main(String[] args){
        URL_IO u = new URL_IO();
        InputStream is = null;
        String path = u.getClass().getResource("/").getPath();
        String fileName = path+ new String("test.html");
        byte buffer[] = new byte[1000];
        try{
            URL fileLocation = new URL("file","localhost",fileName);
            is = fileLocation.openStream();
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            is.read(buffer, 0, buffer.length);
            System.out.write(buffer);
        }catch(IOException e1){
            e1.printStackTrace();
        }
    }
}