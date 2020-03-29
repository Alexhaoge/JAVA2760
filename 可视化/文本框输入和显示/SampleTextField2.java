//实现一个文本输入和回显
//下方的单行textfield输入
//回车后字符串在上方textarea输出
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class SampleTextField2{
    private JFrame f;
    private JTextField tf;
    private JTextArea ta;
    public String text;
    private JScrollPane sp;
    public SampleTextField2(int depth, int width){
        text = new String();
        f = new JFrame("TextField");
        tf = new JTextField("", width);
        ta = new JTextArea("", depth, width);
        sp = new JScrollPane(ta);
        tf.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                ta.append(tf.getText());
                tf.setText("");
            }
        });
        f.addWindowListener( new MyWin());
        f.add(tf, BorderLayout.SOUTH);
        f.add(ta, BorderLayout.CENTER);
        f.pack();
        f.setLocationRelativeTo(null);
    }
    public SampleTextField2(){
        this(25, 60);
    }
    public void go(){
        f.setVisible(true);
    }
    class MyWin extends WindowAdapter{
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
    public static void main(String[] args){
        SampleTextField2 txtf = new SampleTextField2();
        txtf.go();
    }
}