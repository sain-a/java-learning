package week3_day05_CourseSystem;

import java.util.Scanner;

public class CourseSystemApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseService service = new CourseServiceImpl();
        while (true){
            System.out.println("=====学生选课系统=====");
            System.out.println("1.添加学生");
            System.out.println("2.添加课程");
            System.out.println("3.学生选课");
            System.out.println("4.查询学生选课");
            System.out.println("5.显示所有信息");
            System.out.println("6.退出");
            System.out.print("输入你的操作：");
            int key = sc.nextInt();
            switch (key){
                case 1:
                    System.out.print("输入学生ID：");
                    int sId =sc.nextInt();
                    sc.nextLine();

                    System.out.print("输入学生姓名：");
                    String sName = sc.nextLine();

                    System.out.print("输入学生年龄：");
                    int age = sc.nextInt();
                    sc.nextLine();

                    Student student = new Student(sId,sName,age);
                    service.addStudent(student);
                    break;
                case 2:
                    System.out.print("输入课程ID：");
                    int cId =sc.nextInt();
                    sc.nextLine();

                    System.out.print("输入课程姓名：");
                    String CName = sc.nextLine();

                    System.out.print("输入课程老师：");
                    String TName = sc.nextLine();

                    Course course = new Course(cId,CName,TName);
                    service.addCourse(course);
                    break;
                case 3:
                    System.out.print("输入学生ID：");
                    int studentID = sc.nextInt();
                    sc.nextLine();
                    System.out.print("输入添加课程ID：");
                    int courseID = sc.nextInt();
                    sc.nextLine();
                    service.chooseCourse(studentID,courseID);
                    break;
                case 4:
                    System.out.print("输入学生ID：");
                    int studentID1 = sc.nextInt();
                    sc.nextLine();
                    service.showStudentCourses(studentID1);
                    break;
                case 5:
                    service.showAllInfo();
                    break;
                case 6:
                    return;
            }

        }
    }
}
