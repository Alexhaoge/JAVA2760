//瞬时状态量不能串化的加transient关键字
//串化只能保存非静态成员变量
import java.io.*;
import java.util.Date;

public class SerializeDate {
    SerializeDate() {
        Date d =new Date();
        try{
            FileOutputStream f = new FileOutputStream("date.ser");
            ObjectOutputStream s = new ObjectOutputStream(f);
            s.writeObject(d);
            s.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new SerializeDate();
    }
}
