import java.io.*;
public class TestNodeStreams{
    public static void main(final String[] args) {
        try {
            final FileReader input = new FileReader(args[0]);
            final FileWriter output = new FileWriter(args[1]);
            final char[] buffer = new char[128];
            int charsRead;
            charsRead = input.read(buffer);
            while (charsRead != -1) {
                output.write(buffer, 0, charsRead);
                charsRead = input.read(buffer);
            }
            input.close();
            output.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}