public class Deadlock{
    public static void main(String[] args){
        final Object res1 = "resource1";
        final Object res2 = "resource2";
        Thread t1 = new Thread(){
            public void run(){
                synchronized(res1){
                    System.out.println("Thread1: locked res1");
                    try{Thread.sleep(50);}
                    catch(InterruptedException e){}
                    synchronized(res2){
                        System.out.println("Thread1: locked res2");
                    }
                }
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                synchronized(res2){
                    System.out.println("Thread2: locked res2");
                    try{Thread.sleep(50);}
                    catch(InterruptedException e){}
                    synchronized(res1){
                        System.out.println("Thread2: locked res1");
                    }
                }
            }
        };
        t1.start();t2.start();
    }
}