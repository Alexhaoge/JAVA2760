//importance of 
public class Employee{
    public String name = "";
    public double salary;
    public Date birthDate;
    public Employee(final int rate){
        this.rate=rate;
    }

    protected void GetDetail() {
        System.out.println(this.rate);
    }
}

class Manager extends Employee {
    public String department;

    public Manager(final int rate, final String department) {
        super(rate);
        this.department = department;
    }

    public void GetDetail() {
        // super.GetDetail();
        System.out.println(this.rate + "\n" + this.department);
    }
}

public class overload {
    public void findTaxRate(final Employee e) {
        if (e instanceof Manager) {
            System.out.println("M");
            final Manager m = (Manager) e;
            System.out.println("This manager is of " + m.department);
        }
        if (e instanceof Employee) {
            System.out.println("E");
        }
    }

    public static void main(final String[] args) {
        final Manager m = new Manager(0, "U");
        m.GetDetail();
    }
}