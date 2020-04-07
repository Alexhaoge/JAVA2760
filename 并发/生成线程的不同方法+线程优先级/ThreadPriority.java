public class ThreadPriority {
    public static void main(String[] args) {
        System.out.println("once Main Thread Priority = " + Thread.currentThread().getPriority());
        MyThread1 myThread1 = new MyThread1();
        myThread1.setPriority(6);
        Thread.currentThread().setPriority(8);
        System.out.println("twice Main Thread Priority = " + Thread.currentThread().getPriority());
        myThread1.start();
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        super.run();
        //输出线程级别
        System.out.println("MyThread1 Priority = " + this.getPriority());
        //启动线程MyThread2
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
    }
}
class MyThread2 extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("MyThread2 Priority = " + this.getPriority());
    }
}