package week3_day05_CourseSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseServiceImpl implements CourseService{

    private Map<Integer, Student> studentMap = new HashMap<>();

    private Map<Integer, Course> courseMap = new HashMap<>();

    private Map<Integer, List<Course>> studentCourseMap = new HashMap<>();

    @Override
    public void addStudent(Student student) {
        studentMap.put(student.getId(),student);
    }

    @Override
    public void addCourse(Course course) {
        courseMap.put(course.getId(),course);
    }

    @Override
    public void chooseCourse(int studentID, int courseID) {
        List<Course> list = studentCourseMap.get(studentID);
        if (!studentMap.containsKey(studentID)) {
            System.out.println("学生不存在！");
            return;
        }
        if(list == null){
            list = new ArrayList<>();
            studentCourseMap.put(studentID,list);
        }
        Course course = courseMap.get(courseID);
        if(course==null){
            System.out.println("课程不存在！");
            return;
        }
        list.add(course);
    }

    @Override
    public void showStudentCourses(int studentID) {
        Student student = studentMap.get(studentID);
        if (student == null) {
            System.out.println("学生不存在！");
            return;
        }
        System.out.println(student);
        List<Course> courseList = studentCourseMap.get(studentID);
        if(courseList==null||courseList.isEmpty()){
            System.out.println("该学生还没有选课");
            return;
        }
        for (Course c : courseList){
            System.out.println(c);
        }
    }

    @Override
    public void showAllInfo() {
        for(Integer i : studentMap.keySet()){
            showStudentCourses(i);
        }
    }
}
