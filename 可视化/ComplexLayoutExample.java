import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class ComplexLayoutExample{
    private Frame f;
    private Panel p;
    private Button bw,bc;
    private Button bfile, bhelp;
    public ComplexLayoutExample(){
        f = new Frame("GUI example 3");
        bw = new Button("West");
        bc = new Button("Work space region");
        bfile = new Button("File");
        bhelp = new Button("Help");
    }
    public void launchFrame(){
        f.add(bw, BorderLayout.WEST);
        f.add(bc, BorderLayout.CENTER);
        p = new Panel();
        p.add(bfile);
        p.add(bhelp);
        f.add(p, BorderLayout.NORTH);
        f.addWindowListener(
            new WindowAdapter(){
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        f.pack();
        f.setVisible(true);
    }
    public static void main(String[] args){
        ComplexLayoutExample gui = new ComplexLayoutExample();
        gui.launchFrame();
    }
}