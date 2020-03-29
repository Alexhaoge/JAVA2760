//用java.awt重载component的paint方法，使用Graphics中的drawoval
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class circle1{
    private Frame f;
    public int width,height;
    public static void main(String[] args){
        circle1 c = new circle1();
        c.go();
    }
    public circle1(){
        f = new Frame("circle1");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        width = screenSize.height/4;
        height = screenSize.height/4;
        f.setSize(width, height);
        f.setLocationByPlatform(true);
        f.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    System.exit(0);
                }
            });
        f.add(new myComp());
    }
    class myComp extends Component{
		private static final long serialVersionUID = 1L;
		public myComp(){
            super();
            setSize(width, height);
        }
        @Override
        public void paint(Graphics g){
            int d = height / 2;
            g.drawOval((width-d)/2,(height-d)/2,d,d);
        }
    }
    public void go(){
        f.setVisible(true);
    }
    
}