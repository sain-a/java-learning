package week2_day06_OOP.EmployeeSystem;

public abstract class Employee implements Payable{
    private int id;
    private String name;
    private int age;
    private String department;
    public Employee(){}
    public Employee(int id,String name,int age,String department){
        this.age = age;
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge(){
       return age;
    }

    public String getName() {
        return name;
    }

    public  void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public  void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public  void setDepartment(String department) {
        this.department = department;
    }
    public abstract void showInfo();
}
