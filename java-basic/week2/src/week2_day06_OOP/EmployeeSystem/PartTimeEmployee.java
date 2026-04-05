package week2_day06_OOP.EmployeeSystem;

public class PartTimeEmployee extends Employee {
    private double hours;
    private double rate;
    public PartTimeEmployee(String name,double hours,double rate){
        super(name);
        this.hours = hours;
        this.rate = rate;
    }
     @Override
    public double calculateSalary(){
        return hours*rate;
     }
}
