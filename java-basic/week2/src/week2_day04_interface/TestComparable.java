package week2_day04_interface;


import java.util.Arrays;


public class TestComparable {
    public static void main(String[] args){
        Student[] students = {
                new Student("张三",12),
                new Student("李四",10),
                new Student("王五",11)
        };
        Arrays.sort(students);
        for(Student s:students){
            System.out.println(s.getName()+" "+s.getAge());
        }
    }
}
