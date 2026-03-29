//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println("s1 age= "+s1.getAge());
        Student s2 = new Student(18,"TOM",88,88);
        System.out.println("s2 age = "+s2.getAge());

    }
}