import java.lang.Thread;

//currenThread获取对当前线程的引用
//用timeToQuit作为run()退出的标志
class NameRunner implements Runnable{
    private boolean timeToQuit = false;
    public void run(){
        while(!timeToQuit){
            System.out.println(Thread.currentThread().getName() + " Running");
        }
    }
    public void stopRunning(){
        timeToQuit = true;
    }
}
public class ThreadController{
    private NameRunner r = new NameRunner();
    private Thread t = new Thread(r);
    public static void main(String[] args){
        ThreadController a = new ThreadController();
        a.t.start();
        try{
            Thread.sleep(1);
        }catch(InterruptedException e){}
        a.r.stopRunning();
    }
}