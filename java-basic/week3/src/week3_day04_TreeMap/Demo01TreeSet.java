package week3_day04_TreeMap;

import week3_day03_HashMap.Person;

import java.util.Comparator;
import java.util.TreeSet;

public class Demo01TreeSet {
    public static void main(String[] args) {
        TreeSet<String> set1 = new TreeSet<>();
        set1.add("a.张三");
        set1.add("b.李四");
        set1.add("c.王五");
        System.out.println(set1);
        System.out.println("======================");
        TreeSet<Person> set2 = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        set2.add(new Person("张三",18));
        set2.add(new Person("李四",19));
        set2.add(new Person("王五",20));
        System.out.println(set2);
    }
}
