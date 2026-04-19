package com.study.advanced.pojo;

//类名就是数据库表的t_后面的单词全写
public class Student {
    private Integer studentId;
    private String studentName;
    private Integer studentAge;

    public Student() {}

    public Student(Integer studentId, String studentName, Integer studentAge) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student{"+
                "studentId = "+ studentId+
                ",studentName = "+studentName+
                ",studentAge = "+studentAge
                +"}";
    }
}

