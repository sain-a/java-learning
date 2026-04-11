//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Test01 {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "Tom";
        System.out.println(s.name);
        change01(s);
        System.out.println(s.name);
    }
    public static void change01(Student stu){
        stu.name = "Jack";
    }
    public static void change02(Student stu) {
        stu = new Student();
        stu.name = "Alice";
    }
}