package week3_day04_TreeMap;

import week3_day03_HashMap.Person;

import java.util.Comparator;
import java.util.TreeMap;

public class Demo02TreeMap {
    public static void main(String[] args) {
        TreeMap<String,String> map1 = new TreeMap<>();
        map1.put("a","张三");
        map1.put("b","李四");
        map1.put("c","王五");
        System.out.println(map1);
        System.out.println("===================");
        TreeMap<Person,String> map2 = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        map2.put(new Person("张三",18),"北京");
        map2.put(new Person("李四",19),"北京");
        map2.put(new Person("王五",20),"北京");
        System.out.println(map2);
    }
}
