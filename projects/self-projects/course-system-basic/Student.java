package week3_day05_CourseSystem;

public class Student {
    private int id;
    private String name;
    private int age;

    public Student(){}
    public Student(int id,String name,int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "学生ID："+id+" 姓名："+name+" 年龄："+age;
    }
}
