//类如果有自定义构造函数，系统不会用默认的构造函数
//所以如果自定义构造函数没有无参形式的，而之后调用了无参构造，会报错
class Employee{
    public int rate;
    public Employee(int rate){
        this.rate=rate;
    }
    protected void GetDetail(){
        System.out.println(this.rate);
    }
}
class Manager extends Employee{
    public String department;
    public Manager(int rate, String department){
        super(rate);//good
        //super(rate); compile error
        this.department = department;
    }
    public void GetDetail(){
        //super.GetDetail();
        System.out.println(this.rate + "\n" + this.department);
    }
}
public class construct_func {
    public static void main(final String[] args) {
        Manager m = new Manager(0,"U");
        m.GetDetail();
    }
}