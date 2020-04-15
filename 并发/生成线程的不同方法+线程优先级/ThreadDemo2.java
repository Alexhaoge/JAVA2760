public class ThreadDemo2 extends Thread{
    //2种不同方式生成线程t1和t2
    public void run(){
        for(int i=1;i<10;i++){
            compute();
            //try{
            //    Thread.sleep(10);
            //}catch(InterruptedException e){}
            //Thread.yield();
        }
    }
    public static void main(String[] args){
        ThreadDemo2 t1 = new ThreadDemo2();
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i=1;i<10;i++){
                    compute();
                    //try{
                    //    Thread.sleep(100);
                    //}catch(InterruptedException e){}
                    //Thread.yield();
                }
            }
        });
        t1.setPriority(10);
        t2.setPriority(1);
        t1.start();
        t2.start();
        //try{
        //    Thread.sleep(100);
        //}catch(InterruptedException e){}
        Thread.yield();

        for(int i=1; i<10; i++){
            //if(i == 1){
            //    System.out.println(Thread.currentThread().getName()+" ready for compute");
            //    System.out.flush();
            //}
            compute();
            //try{
            //    Thread.sleep(50);
            //}catch(InterruptedException e){}
            Thread.yield();
        }
    }
    static ThreadLocal<Integer> numberOfCalls = new ThreadLocal<Integer> ();
    static synchronized void compute(){
        Integer n = (Integer) numberOfCalls.get();
        if(n == null) n = new Integer(1);
        else n = new Integer(n.intValue()+1);
        numberOfCalls.set(n);
        for(int i=0,j=0;i<20000000;i++) j+=i;
        //System.out.println(Thread.currentThread().getName()+": "+n+"sleep");
        //System.out.flush();
        try{
            Thread.sleep(200);
            //Thread.sleep((int)(Math.random()*100+1));
        }catch(InterruptedException e){}
        System.out.println(Thread.currentThread().getName());
        //System.out.printf("\t%d\n",n);
        System.out.flush();
        //if(Thread.currentThread().getPriority() < Thread.NORM_PRIORITY)
        //Thread.yield();
    }
}