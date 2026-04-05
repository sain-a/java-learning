package week2_day06_OOP.EmployeeSystem;

public class FullTimeEmployee extends Employee {
    private double monthlySalary;
    public FullTimeEmployee(String name,double monthlySalary){
        super(name);
        this.monthlySalary = monthlySalary;
    }
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}
