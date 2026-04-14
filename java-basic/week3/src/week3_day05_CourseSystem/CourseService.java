package week3_day05_CourseSystem;

public interface CourseService {
    public abstract void addStudent(Student student);
    public abstract void addCourse(Course course);
    public abstract void chooseCourse(int studentID,int courseID);
    public abstract void showStudentCourses(int studentID);
    public abstract void showAllInfo();
}
