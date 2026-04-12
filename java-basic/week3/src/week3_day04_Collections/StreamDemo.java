package week3_day04_Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        Collections.addAll(names,"Tom","Jack","Alice","Bob","Anna");
        //1.filter:筛选以A开头的名字
        List<String> result1 = names.stream()
                .filter(name->name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("filter结果："+result1);
        //2.map:转为大小写
        List<String> result2 = names.stream()
                .map(name->name.toUpperCase())
                .collect(Collectors.toList());
        System.out.println("map结果："+result2);
        //3.sorted:排序
        List<String> result3 = names.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("sorted结果: " + result3);


    }
}
