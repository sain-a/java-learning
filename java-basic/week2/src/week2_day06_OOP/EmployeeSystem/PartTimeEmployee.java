package week2_day06_OOP.EmployeeSystem;

public class PartTimeEmployee extends Employee {
   private double hourlyRate;
   private double workHours;
   public PartTimeEmployee(int id,String name,int age,String department,double hourlyRate,double workHours){
       super(id, name, age, department);
       this.hourlyRate = hourlyRate;
       this.workHours = workHours;
   }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getWorkHours() {
        return workHours;
    }

    public void setWorkHours(double workHours) {
        this.workHours = workHours;
    }

    @Override
    public void showInfo() {
        System.out.println("员工类型：兼职");
        System.out.println("ID:"+getId());
        System.out.println("姓名："+getName());
        System.out.println("年龄："+getAge());
        System.out.println("部门："+getDepartment());
        System.out.println("时薪："+getHourlyRate());
        System.out.println("工时："+getWorkHours());
        System.out.println("总工资："+calculateSalary());
    }

    @Override
    public double calculateSalary() {
        return (hourlyRate*workHours);
    }
}
