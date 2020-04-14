public class SyncStack{
    private int index = 0;
    private char []buffer;
    SyncStack(int size){
        buffer = new char[size];
    }
    public synchronized void push(char c){
        while(index == buffer.length){
            try{
                this.wait();
            }catch(InterruptedException e){}
        }
        this.notify();
        buffer[index]=c;
        index++;
        System.out.println("Push "+c);
    }
    public synchronized char pop(){
        while(index == 0){
            try{
                this.wait();
            }catch(InterruptedException e){}
        }
        this.notify();
        index--;
        System.out.println("Pop "+buffer[index]);
        return buffer[index];
    }
    public static void main(String[] args) {
        SyncStack st = new SyncStack(100);
        Runnable r =()->{
            for(int i=0;i<=9;i++){
                st.push((char)(i+'0'));
                try{
                    Thread.sleep(10);
                }catch(InterruptedException e){}
            }
        };
        Thread t = new Thread(r);
        Runnable r1 =()->{
            for(int i=0;i<=9;i++){
                st.push((char)(i+'A'));
                try{
                    Thread.sleep(10);
                }catch(InterruptedException e){}
            }
        };
        Thread t1 = new Thread(r1);
        Runnable r2 =()->{
            for(int i=0;i<20;i++){
                st.pop();
                try{
                    Thread.sleep(10);
                }catch(InterruptedException e){}
            }
        };
        Thread t2 = new Thread(r2);
        t.start();
        t1.start();
        t2.start();
    }
}