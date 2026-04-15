package week3_day05_CourseSystem;

public class Course {
    private int id;
    private  String courseName;
    private  String teacherName;

    public Course(){}

    public Course(int id,String courseName,String teacherName){
        this.id = id;
        this.courseName = courseName;
        this.teacherName = teacherName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    @Override
    public String toString() {
        return "课程ID："+id+" 课程名："+courseName+" 老师："+teacherName;
    }
}
