import java.applet.*;
import java.util.Date;

import javax.swing.JFrame;
import java.awt.*;
import java.lang.InterruptedException;

public class Clock extends Applet implements Runnable{
    //applet用渐长的方式显示图象，所以显示图象的速度非常慢会有闪屏
    //需要双缓冲，但是时间在变化，和图片不一样，不知道怎么做
    //https://blog.csdn.net/kai_wei_zhang/article/details/8120382
    //JComponent没有这个问题
    private static final long serialVersionUID = 1L;
    Thread clockThread;
    private Image iBuffer;
    private Graphics gBuffer;
    public void start(){
        if(clockThread == null){
            clockThread = new Thread(this, "Clock");
            clockThread.start();
        }
    }
    public void run(){
        while(clockThread!=null){
            repaint();
            try{
                clockThread.sleep(200);
            }catch(InterruptedException e){}
        }
    }
    @Override
    public void update(Graphics g) {
        if(iBuffer==null){
            iBuffer=createImage(this.getSize().width,this.getSize().height);
            gBuffer=iBuffer.getGraphics();
        }
        gBuffer.setColor(getBackground());
        gBuffer.fillRect(0,0,this.getSize().width,this.getSize().height);
        paint(gBuffer);
        g.drawImage(iBuffer,0,0,this);
    }
    @Override
    public void paint(Graphics g){
        Date now = new Date();
        g.setColor(Color.black);
        g.drawString(now.toString(), 5, 10);
    }
    @Deprecated
    public void stop(){
        clockThread.stop();
        clockThread = null;
    }
    public static void main(String[] args) {
        JFrame jf = new JFrame("Clock");
        Clock c = new Clock();
        jf.add(c);
        jf.setSize(300, 150);
        jf.setLocationByPlatform(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.start();
        jf.setVisible(true);
    }
}