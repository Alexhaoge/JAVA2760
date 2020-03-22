import java.io.*;

class hello1{
    private int a=1;
	public void work(){
		System.out.println(a);
	}
}
public class Hello {
    /* 第一个Java程序
     * 它将打印字符串 hello World
     */
    public static void main(String []args) {
        hello1 b = new hello1();
        b.work();
        System.out.println("hello World"); // 打印 hello World
    }
}
