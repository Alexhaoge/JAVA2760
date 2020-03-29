//实现一个文本输入和回显
//下方的单行textfield输入
//回车后字符串在上方textarea输出
import java.awt.*;
import java.awt.event.*;

public class FakeConsole{
    private Frame f;
    private TextField tf;
    private TextArea ta;
    public String text;
    public FakeConsole (int depth, int width){
        text = new String();
        f = new Frame("TextField");
        tf = new TextField("", width);
        ta = new TextArea("", depth, width,0);
        ta.setEditable(false);
        tf.addKeyListener( new NameHandler());
        f.addWindowListener( new MyWin());
        f.add(tf, BorderLayout.SOUTH);
        f.add(ta, BorderLayout.CENTER);
        f.pack();
        f.setLocationRelativeTo(null);
    }
    public FakeConsole (){
        this(25, 60);
    }
    public void go(){
        f.setVisible(true);
    }
    public void appendTextArea() {
        tf.getText();
        tf.setText("");
        //清空textfield前需要，这是源码实现的规则导致的
        //https://bbs.csdn.net/topics/392050789
        ta.append(text);
    }
    class NameHandler extends KeyAdapter {
        public void keyPressed(KeyEvent e){
            if( e.getKeyCode() == KeyEvent.VK_ENTER){
                //System.out.println(text);
                FakeConsole.this.appendTextArea();
                text = "";
            }
        }
        public void keyTyped(KeyEvent e){
            char c = e.getKeyChar();
            if(c == '\n')
                e.consume();
            //System.out.println(c);
            text = text + c;
        }
    }
    class MyWin extends WindowAdapter{
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
    public static void main(String[] args){
        FakeConsole txtf = new FakeConsole();
        txtf.go();
    }
}