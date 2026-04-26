package app;

import pojo.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentSystemApp {
    public static void main(String[] args) {
        StudentService studentService = new StudentServiceImpl();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("===== 学生管理系统 =====");
            System.out.println("1. 查询所有学生");
            System.out.println("2. 查询学生");
            System.out.println("3. 新增学生");
            System.out.println("4. 修改学生");
            System.out.println("5. 删除学生");
            System.out.println("0. 退出");

            System.out.print("请输入选择：");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    List<Student> students = new ArrayList<>();
                    students = studentService.findAll();
                    students.forEach(student -> System.out.println(student));
                    break;
                case 2:
                    System.out.print("输入要查询的学生id：");
                    int findId = scanner.nextInt();
                    scanner.nextLine();
                    Student student = studentService.findById(findId);
                    if(student!=null){
                        System.out.println(student);
                    }else{
                        System.out.println("未查到该学生");
                    }
                    break;
                case 3:
                    System.out.print("输入新增学生姓名：");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.print("输入新增学生年龄：");
                    Integer age = scanner.nextInt();
                    scanner.nextLine();
                    Student newStudent = new Student(null,name,age);
                    boolean addResult = studentService.addStudent(newStudent);
                    if (addResult) {
                        System.out.println("添加成功");
                    } else {
                        System.out.println("添加失败");
                    }
                    break;
                case 4:
                    System.out.print("输入修改学生id：");
                    Integer updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("输入新姓名：");
                    String updateName = scanner.nextLine();
                    System.out.print("输入新年龄：");
                    Integer updateAge = scanner.nextInt();
                    scanner.nextLine();
                    Student updateStudent = new Student(updateId,updateName,updateAge);
                    boolean updateResult = studentService.updateStudent(updateStudent);
                    if (updateResult) {
                        System.out.println("修改成功");
                    } else {
                        System.out.println("修改失败");
                    }
                    break;
                case 5:
                    System.out.print("输入删除学生id:");
                    Integer deleteId = scanner.nextInt();
                    boolean deleteResult = studentService.deleteById(deleteId);
                    if (deleteResult) {
                        System.out.println("删除成功");
                    } else {
                        System.out.println("删除失败");
                    }
                    break;
                case 0:
                    System.out.println("退出系统");
                    scanner.close();
                    return;
                default:
                    System.out.println("输入错误");
            }
        }
    }
}
