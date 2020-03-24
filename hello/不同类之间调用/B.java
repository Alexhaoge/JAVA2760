public class B{
    public int b;
    B(int x){
        b=x;
    }
    public void print(){
        System.out.printf("B:%d\n",b);
    }
    public static void main(String[] args){
        B x = new B(1);
        x.print();
    }
}