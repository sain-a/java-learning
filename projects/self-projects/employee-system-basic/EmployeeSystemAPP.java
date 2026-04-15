package week2_day06_OOP.EmployeeSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeSystemAPP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeServiceImpl();
        while(true){
            System.out.println("=====员工系统=====");
            System.out.println("1. 添加员工");
            System.out.println("2. 删除员工");
            System.out.println("3. 查询员工");
            System.out.println("4.修改员工信息");
            System.out.println("5. 显示所有员工");
            System.out.println("6. 退出系统");
            System.out.print("输入想做的功能：");
            int key = sc.nextInt();
            switch (key){
                case 1:
                    System.out.println("输入添加员工信息：");
                    System.out.println("选择员工类型：1.全职员工   2.兼职员工");
                    int type = sc.nextInt();
                    if(type==1){
                        System.out.println("全职员工输入：");
                        System.out.print("id：");
                        int id= sc.nextInt();
                        sc.nextLine();

                        System.out.print("name:");
                        String name = sc.nextLine();

                        System.out.print("age:");
                        int age = sc.nextInt();
                        sc.nextLine();

                        System.out.print("department:");
                        String department = sc.nextLine();

                        System.out.print("monthlySalary:");
                        double monthlySalary = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("bonus:");
                        double bonus = sc.nextDouble();
                        sc.nextLine();

                        Employee fullTime = new FullTimeEmployee(id,name,age,department,monthlySalary,bonus);
                        service.addEmployee(fullTime);
                    }
                    else {
                        System.out.println("兼职员工输入：");

                        System.out.print("id：");
                        int id= sc.nextInt();
                        sc.nextLine();

                        System.out.print("name:");
                        String name = sc.nextLine();

                        System.out.print("age:");
                        int age = sc.nextInt();
                        sc.nextLine();

                        System.out.print("department:");
                        String department = sc.nextLine();

                        System.out.print("hourlyRate:");
                        double hourlyRate = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("workHours:");
                        double workHours = sc.nextDouble();
                        sc.nextLine();

                        Employee partTime = new PartTimeEmployee(id,name,age,department,hourlyRate,workHours);
                        service.addEmployee(partTime);
                    }
                    break;
                case 2:
                    System.out.print("输入删除员工ID：");
                    int id1 = sc.nextInt();
                    service.deleteEmployee(id1);
                    break;
                case 3:
                    System.out.print("输入查找员工ID：");
                    int id2 = sc.nextInt();
                    service.findEmployeeById(id2);
                    break;
                case 4:
                    System.out.println("输入要修改的员工ID");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Employee employee = service.findEmployeeById(id);
                    if(employee==null){
                        System.out.println("员工不存在");
                    }else {
                        System.out.println("输入新姓名：");
                        String newName = sc.nextLine();
                        employee.setName(newName);

                        service.updateEmployee(id);
                    }
                    break;
                case 5:
                    service.showAllEmployees();
                    break;
                case 6:
                    return;
            }
        }
    }
}
