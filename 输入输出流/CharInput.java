//过滤流+字节转字符，文件字节流->输入字符流->缓冲字符流
//字符不能转字节，纯文本用字符，否则用字节
import java.io.*;
public class CharInput{
    public static void main(String[] args)
        throws FileNotFoundException, IOException{
        String s;
        FileInputStream is = new FileInputStream("test.txt");
        InputStreamReader ir = new InputStreamReader(is);
        BufferedReader in = new BufferedReader(ir);
        while((s=in.readLine()) != null)
            System.out.println("Read: "+s);
        in.close();
    }
}