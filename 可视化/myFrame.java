import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class myFrame extends Frame{
    public static void main(String args[]){
        myFrame fr = new myFrame("Hello out There!");
        Panel pan = new Panel();
        fr.setSize(200, 200);
        fr.setBackground(Color.red);
        fr.setLayout(null);
        pan.setSize(100,100);
        pan.setLayout(null);
        pan.setBackground(Color.yellow);
        fr.add(pan);
        fr.addWindowListener(new MyWin());
        fr.setVisible(true);
    }
    public myFrame(String str){
        super(str);
    }
}
class MyWin extends WindowAdapter{
    public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
 }