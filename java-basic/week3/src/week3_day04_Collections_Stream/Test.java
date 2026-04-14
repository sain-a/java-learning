package week3_day04_Collections_Stream;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"张无忌","周芷若","赵敏","张强","张三丰");
//        list.stream()
//                .filter(s -> s.startsWith("张"))
//                .filter(s->s.length()==3)
//                .forEach(s-> System.out.println(s));

//        list.stream().filter(new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.startsWith("张")&&s.length()==3;
//            }
//        }).forEach(s -> System.out.println(s));

        //其他类
//        list.stream()
//                .filter(new StringOperation()::stringJudge)
//                .forEach(s -> System.out.println(s));

        //本类
        list.stream()
                .filter(Test::stringJudge)
                .forEach(s -> System.out.println(s));

    }
    public static boolean stringJudge(String s){
        return s.startsWith("张")&&s.length()==3;
    }
}

