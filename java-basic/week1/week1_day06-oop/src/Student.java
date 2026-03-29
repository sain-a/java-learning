public class Student {
    private int id;
    private String name;
    private int age;
    private double score;
    //无参构造
    public Student(){
        this.age = 99;
    }
    //有参构造
    public Student(int id,String name,int age,double score){
        this.name = name;
        this .id = id;
        this.age = age;
        this.score = score;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        if(age<0||age>100){
            System.out.println("年龄不合法！");
            return;
        }
        this.age=age;
    }
    public double getScore(){
        return score;
    }
    public void setScore(double score){
        if(score<0||score>100){
            System.out.println("成绩不合法！");
            return;
        }
        this.score =score;
    }
}

