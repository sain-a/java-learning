package week2_day06_OOP.EmployeeSystem;

public interface EmployeeService {
    void addEmployee(Employee employee);
    void deleteEmployee(int id);
    Employee findEmployeeById(int id);
    void showAllEmployees();
    void updateEmployee(int id);
}
