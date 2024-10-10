package Lab8_1;

public class FixedSalary extends Employees{
    protected double salary;


    public FixedSalary(String first, String last, String ssn,double salary) {
        super(first, last, ssn);
        this.salary = salary;
    }

    @Override
    public double earnings() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString()+"\n"+String.format("monthly salary: $%s", this.salary);
    }
    



    
}
