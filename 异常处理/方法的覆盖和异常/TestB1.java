public class TestB1 extends TestA {
    public void methodA(Boolean x)
        throws ArithmeticException, ArrayIndexOutOfBoundsException {
        if(x)
            throw new ArithmeticException();
        else
            throw new ArrayIndexOutOfBoundsException();
    }
    public static void main(String[] args){
        TestA a = new TestB1();
        a.methodA(false);
    }
}