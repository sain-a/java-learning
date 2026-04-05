package week2_day06_OOP.EmployeeSystem;

abstract class Employee {
    protected String name;
    public Employee(String name){
        this.name = name;
    }
    public abstract double calculateSalary();
    public void printInfo(){
        System.out.println("员工"+name+",工资"+calculateSalary());
    }

}
