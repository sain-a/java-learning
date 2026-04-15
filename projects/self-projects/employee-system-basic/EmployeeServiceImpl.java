package week2_day06_OOP.EmployeeSystem;

import java.util.ArrayList;

public class EmployeeServiceImpl implements EmployeeService{
    ArrayList<Employee> employees = new ArrayList<>();
    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("添加成功！");
    }

    @Override
    public void deleteEmployee(int id) {
        for(int i = 0; i < employees.size();i++){
            if(employees.get(i).getId()==id){
                employees.remove(i);
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println("不存在！");
    }

    @Override
    public Employee findEmployeeById(int id) {
        for(Employee e : employees){
            if(e.getId()==id){
                System.out.println("找到员工！");
                e.showInfo();
                return e;
            }
        }
        System.out.println("员工不存在！");
        return null;
    }

    @Override
    public void showAllEmployees() {
        for(Employee e : employees){
            e.showInfo();
        }
        if(employees.isEmpty()){
            System.out.println("当前没有员工");
            return;
        }
    }

    @Override
    public void updateEmployee(int id) {
        System.out.println("修改成功！");
    }
}
