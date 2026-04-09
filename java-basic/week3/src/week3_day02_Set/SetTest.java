package week3_day02_Set;

import java.util.HashSet;
import java.util.Set;

public class SetTest{
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("a");
        System.out.println(set);

        Set<Person> studentSet = new HashSet<>();
        studentSet.add(new Person("Jack",18));
        studentSet.add(new Person("John",18));
        studentSet.add(new Person("Jack",18));
        System.out.println(studentSet);
    }
}
