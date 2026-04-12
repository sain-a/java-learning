package week2_day06_OOP.EmployeeSystem;

public class FullTimeEmployee extends Employee {
    private double monthlySalary;
    private double bonus;
    public FullTimeEmployee(int id,String name,int age,String department,double monthlySalary,double bonus){
        super(id, name, age, department);
        this.monthlySalary = monthlySalary;
        this.bonus = bonus;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void showInfo() {
        System.out.println("员工类型：全职");
        System.out.println("ID:"+getId());
        System.out.println("姓名："+getName());
        System.out.println("年龄："+getAge());
        System.out.println("部门："+getDepartment());
        System.out.println("月薪："+ getMonthlySalary());
        System.out.println("奖金："+getBonus());
        System.out.println("总工资："+calculateSalary());
    }

    @Override
    public double calculateSalary() {
        return (monthlySalary+bonus);
    }
}
