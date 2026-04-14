package week3_day04_Collections_Stream;

public class Student {
    private String name;
    private int age;
    public Student(){
    }

    public Student(String str) {
        String[] arr = str.split(",");
        String name = arr[0];
        int age = Integer.parseInt(arr[1]);
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
