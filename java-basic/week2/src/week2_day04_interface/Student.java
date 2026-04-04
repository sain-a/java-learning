package week2_day04_interface;

public class Student implements Comparable<Student>{
    private String name;
    private int age;
    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }

    @Override
    public int compareTo(Student o){
        //年龄升序：this.age - o.age
        //年龄降序：o.age - this.age
//        return this.age - o.age;
//        按姓名长度排序
//        if(this.name.length()!=o.name.length()){
//            return this.name.length() - o.name.length();
//        }else{
//            //this.name.comparaTo(o.name)字符串自带排序（字典序）
//            return this.name.compareTo(o.name);
//        }
        //先按姓名长度排序，一样则按年龄升序
        if(this.name.length()!=o.name.length()){
            return this.name.length()-o.name.length();
        }else{
            return this.age-o.age;
        }
    }
}
