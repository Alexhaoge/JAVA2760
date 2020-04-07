//实现一个文本输入和回显
//下方的单行textfield输入
//回车后字符串在上方textarea输出
import java.awt.*;
import java.awt.event.*;

public class SampleTextField{
    private Frame f;
    private TextField tf;
    private TextArea ta;
    private MenuBar mb;
    public SampleTextField(int depth, int width){
        f = new Frame("TextField");
        tf = new TextField("", width);
        ta = new TextArea("", depth, width,0);
        ta.setEditable(false);
        mb = new MenuBar();
        Menu m1 = new Menu("Mode");
        Menu m2 = new Menu("Clear");
        MenuItem mi2 = new MenuItem("Clear");
        mi2.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    ta.getText();
                    ta.setText("");
                    ta.repaint();
                }
            }
        );
        m2.add(mi2);
        // ButtonGroup bg = new ButtonGroup();
        // RadioButtonMenuItem mi1 = new RadioButtonMenuItem("Text");
        // RadioButtonMenuItem mi2 = new RadioButtonMenuItem("Console");
        // m1.add(mi1);
        // m1.add(mi2);
        mb.add(m1);
        mb.add(m2);
        f.setMenuBar(mb);
        tf.addKeyListener( new NameHandler());
        f.addWindowListener( new MyWin());
        f.add(tf, BorderLayout.SOUTH);
        f.add(ta, BorderLayout.CENTER);
        f.pack();
        f.setLocationRelativeTo(null);
    }
    public SampleTextField(){
        this(25, 60);
    }
    public void go(){
        f.setVisible(true);
    }
    public void appendTextArea() {
        String s = tf.getText();
        tf.setText("");
        //清空textfield前需要，这是源码实现的规则导致的
        //https://bbs.csdn.net/topics/392050789
        ta.append(s+'\n');
    }
    class NameHandler extends KeyAdapter {
        public void keyPressed(KeyEvent e){
            if( e.getKeyCode() == KeyEvent.VK_ENTER){
                //System.out.println(text);
                SampleTextField.this.appendTextArea();
            }
        }
    }
    class MyWin extends WindowAdapter{
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
    public static void main(String[] args){
        SampleTextField txtf = new SampleTextField();
        txtf.go();
    }
}