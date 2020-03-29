//mouseclicked是高级事件,鼠标点击
//mousepressed,mousereleased是低级事件，按下和松开
//所以他们仨都存在的时候，press会最先出现，而release会被click覆盖
import java.awt.*;
import java.awt.event.*;

public class myListen implements MouseMotionListener,
    MouseListener, WindowListener{
    private Frame f;
    private Panel p;
    private TextField t,tt;
    public static void main(String[] args){
        myListen my = new myListen();
        my.go();
    }
    public void go(){
        f = new Frame("My Listener");
        f.add(new Label("Click and drag!"),BorderLayout.NORTH);
        t = new TextField(30);
        tt = new TextField(30);
        p = new Panel();
        p.setLayout(new GridLayout(2,1));
        p.add(t);
        p.add(tt);
        f.add(p,BorderLayout.SOUTH);
        f.addMouseMotionListener(this);
        f.addMouseListener(this);
        f.addWindowListener(this);
        f.setSize(300,300);
        f.setLocationByPlatform(true);
        f.setVisible(true);
    }
    public void mouseDragged(MouseEvent e){
        String s = "Mouse dragging:X="+e.getX()+",Y="+e.getY();
        t.setText(s);
    }
    public void mouseMoved(MouseEvent e){
        t.setText("The mouse is moving.");
    }
    public void mouseClicked(MouseEvent e){
        t.setText("The mouse has clicked.");
    }
    public void mouseEntered(MouseEvent e){
        t.setText("The mouse has entered.");
    }
    public void mouseExited(MouseEvent e){
        t.setText("The mouse has left.");
    }
    public void mousePressed(MouseEvent e){
        t.setText("The mouse has pressed.");
    }
    public void mouseReleased(MouseEvent e){
        t.setText("The mouse has Released.");
    }
    public void windowClosing(WindowEvent e){System.exit(1);}
    public void windowOpened(WindowEvent e){
        tt.setText("The window is open.");
    }
    public void windowIconified(WindowEvent e){
        tt.setText("The window is iconified.");
    }
    public void windowDeiconified(WindowEvent e){
        tt.setText("The window is deconified.");
    }
    public void windowClosed(WindowEvent e){
        tt.setText("The window is closed.");
    }
    public void windowActivated(WindowEvent e){
        tt.setText("The window is activated.");
    }
    public void windowDeactivated(WindowEvent e){
        tt.setText("The window is deactivated.");
    }
}