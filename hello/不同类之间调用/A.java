//在同一文件夹下不需要import B.*;
public class A{
    int a;
    public static void main(String[] args){
        B b = new B(1);
        b.print();
    }
}