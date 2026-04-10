package week3_day03_HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PersonMap {
    public static void main(String[] args) {
        HashMap<Person,String> map = new HashMap<>();
        map.put(new Person("张三",18),"北京");
        map.put(new Person("李四",18),"天津");
        map.put(new Person("张三",18),"南京");

        for(Person key : map.keySet()){
            System.out.println(key+".."+map.get(key));
        }
        System.out.println("================");
        for(Map.Entry<Person,String> entry : map.entrySet()){
            System.out.println(entry.getKey()+".."+entry.getValue());
        }
    }
}
