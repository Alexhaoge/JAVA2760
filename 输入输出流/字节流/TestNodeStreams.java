import java.io.*;

public class TestNodeStreams{
    public static void main(String[] args){
        try{
            FileReader input = new FileReader(args[0]);
            FileWriter output = new FileWriter(args[1]);
            char[] buffer = new char[128];
            int charsRead;
            charsRead = input.read(buffer);
            while(charsRead != -1) {
                output.write(buffer, 0, charsRead);
                charsRead =  input.read(buffer);
            }
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}