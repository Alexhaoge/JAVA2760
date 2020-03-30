//写一个继承component的子类，
//重载paint方法，使用Graphics2D
//使用Graphics2D好处
//1. 可以使用中心构造方法
//2. setRenderingHint抗锯齿
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
public class circle2{
    private Frame f;
    public int width,height;
    public static void main(String[] args){
        circle2 c = new circle2();
        c.go();
    }
    public circle2(){
        f = new Frame("circle2");
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
            Graphics2D g2 = (Graphics2D) g;
            Ellipse2D circle = new Ellipse2D.Double();
            int r = height/3;
            int centerx = width/2;
            int centery = height/2;
            circle.setFrameFromCenter(centerx,centery,centerx+r,centery+r);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
            g2.setStroke(new BasicStroke(2.5f));
            g2.draw(circle);
        }
    }
    public void go(){
        f.setVisible(true);
    }
    
}