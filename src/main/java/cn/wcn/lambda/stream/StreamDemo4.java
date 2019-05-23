package cn.wcn.lambda.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo4 {
    public static void main(String[] args) {

        String str = "my name is 007";

        // 使用并行流
        str.chars().parallel().forEach(i -> System.out.println((char) i));
        System.out.println();
        // 使用forEachOrdered保证顺序
        str.chars().parallel().forEachOrdered(i -> System.out.println((char) i));

        //collect  /  toArray
        List<String> collect = Stream.of(str.split(" ")).collect(Collectors.toList());
        Set<String> collect1 = Stream.of(str.split(" ")).collect(Collectors.toSet());
        System.out.println(collect);

        //使用reduce拼接字符串
        Optional<String> letters = Stream.of(str.split(" ")).reduce((s1, s2) -> s1 + "|" + s2);
        System.out.println(letters.orElse(""));

        String reduce = Stream.of(str.split(" ")).reduce("", (s1, s2) -> s1 + "|" + s2);
        System.out.println(reduce);

        //计算所有单词总长度
        Integer reduce1 = Stream.of(str.split(" ")).map(s -> s.length()).reduce(0, (s1, s2) -> s1 + s2);
        System.out.println(reduce1);

//        Stream.of(str.split(" ")).max((s1, s2) -> s1.length() - s2.length());
        Optional<String> max = Stream.of(str.split(" ")).max(Comparator.comparingInt(String::length));
        System.out.println(max.get());

        //使用findFirst短路操作
        OptionalInt first = new Random().ints().findFirst();
        System.out.println(first.getAsInt());
    }
}
