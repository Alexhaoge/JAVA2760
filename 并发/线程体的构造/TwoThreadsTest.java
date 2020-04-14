//通过继承Thread构造线程体
class SimpleThread extends Thread{
    public SimpleThread(String str){super(str);}
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println(i+" "+getName());
            try{
                sleep((int)(Math.random()*1000));
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Done! "+getName());
    }
}
public class TwoThreadsTest{
    public static void main(String[] args) {
        new SimpleThread("First").start();
        new SimpleThread("Second").start();
    }
}