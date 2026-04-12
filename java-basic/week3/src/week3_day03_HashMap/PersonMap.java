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
        for(Map.Entry<Person,String> entry : map.entrySet()){
            System.out.println(entry.getKey()+".."+entry.getValue());
        }
        map.forEach((Person,String)-> System.out.println(Person+"->"+ String));

        System.out.println("根据key取值："+map.get(new Person("张三",18)));
        System.out.println("是否包含key:"+map.containsKey(new Person("张三",18)));
        System.out.println("是否包含value："+map.containsValue("天津"));
        System.out.println("元素个数："+map.size());

    }
}
