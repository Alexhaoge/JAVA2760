public class ThreadDemo extends Thread{
    //2种不同方式生成线程t1和t2
    public void run(){
        for(int i=1;i<10;i++){
            //if(i == 1){
            //    System.out.println(getName()+" ready for compute");
            //    System.out.flush();
            //}
            compute();
            //Thread.yield();
        }
    }
    public static void main(String[] args){
        ThreadDemo t1 = new ThreadDemo();
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i=1;i<10;i++){
                //    if(i == 1){
                //        System.out.println(Thread.currentThread().getName()+" ready for compute");
                //        System.out.flush();
                //    }
                    compute();
                    //Thread.yield();
                }
            }
        });
        //System.out.println(t1.getName());
        //Thread.currentThread().setPriority(5);
        if(args.length >= 1) t1.setPriority(Integer.parseInt(args[0]));
        if(args.length >= 2) t2.setPriority(Integer.parseInt(args[1]));
        t1.start();
        t2.start();
        // try{
        //     Thread.sleep(2000);
        // }catch(InterruptedException e){}
        // Thread.yield();
        for(int i=1; i<10; i++){
            //if(i == 1){
            //    System.out.println(Thread.currentThread().getName()+" ready for compute");
            //    System.out.flush();
            //}
            compute();
            //Thread.yield();
        }
        //System.out.println(Thread.currentThread().getPriority());
        //System.out.println(t1.getPriority());
        //System.out.println(t2.getPriority());
    }
    static ThreadLocal<Integer> numberOfCalls = new ThreadLocal<Integer> ();
    static synchronized void compute(){
        Integer n = (Integer) numberOfCalls.get();
        if(n == null) n = new Integer(1);
        else n = new Integer(n.intValue()+1);
        numberOfCalls.set(n);
        //System.out.println(Thread.currentThread().getName()+": "+n+"start");
        //System.out.flush();
        for(int i=0,j=0;i<2000000000;i++) j+=i;
        //System.out.println(Thread.currentThread().getName()+": "+n+"sleep");
        //System.out.flush();
        try{
            Thread.sleep(1000);
            //Thread.sleep((int)(Math.random()*100+1));
        }catch(InterruptedException e){}
        //System.out.println(Thread.currentThread().getName()+": "+n+"end");
        System.out.println(Thread.currentThread().getName());
        System.out.flush();
        Thread.yield();
    }
}