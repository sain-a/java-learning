package week2_day06_OOP.EmployeeSystem;

import java.util.ArrayList;
import java.util.List;

public class TestEmployeeSystem {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new FullTimeEmployee("张三",8000));
        list.add(new PartTimeEmployee("李四",20,50));
        for(Employee e : list){
            e.printInfo();
        }
    }
}
