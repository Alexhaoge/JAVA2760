public class ThreadDemo extends Thread{
    //2种不同方式生成线程t1和t2
    public void run(){
        for(int i=1;i<5;i++) compute();
    }
    public static void main(String[] args){
        ThreadDemo t1 = new ThreadDemo();
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i=1;i<5;i++) compute();
            }
        });
        System.out.println(t1.getName());
        //Thread.currentThread().setPriority(5);
        if(args.length >= 1) t1.setPriority(Integer.parseInt(args[0]));
        if(args.length >= 2) t2.setPriority(Integer.parseInt(args[1]));
        System.out.println(t1.getPriority());
        t1.start();t2.start();
        for(int i=0; i<5; i++) compute();
    }
    static ThreadLocal<Integer> numberOfCalls = new ThreadLocal<Integer> ();
    static synchronized void compute(){
        Integer n = (Integer) numberOfCalls.get();
        if(n == null) n = new Integer(1);
        else n = new Integer(n.intValue()+1);
        numberOfCalls.set(n);
        System.out.println(Thread.currentThread().getName()+": "+n);
        for(int i=0,j=0;i<1000000;i++) j+=i;
        try{
            Thread.sleep((int)(Math.random()*100+1));
        }catch(InterruptedException e){}
        Thread.yield();
    }
}