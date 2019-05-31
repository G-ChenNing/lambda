package cn.wcn.lambda.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class StreamDemo3 {
    public static void main(String[] args) {

        String str = "My name is 007";

        //把每个单词的长度打印出来
        Stream.of(str.split(" ")).filter(s->s.length()>2).map(s -> s.length()).forEach(System.out::println);

        //flatMap A->B属性（是个集合）,最终得到所有A元素里面的所有B属性
        Stream.of(str.split(" ")).flatMap(s -> s.chars().boxed()).forEach(
                i -> System.out.println((char) i.intValue())
        );

        System.out.println("----------------------------------------------------------------");

       //peek 用于debug，是个中间操作，和foreach是终止操作
        Stream.of(str.split(" ")).peek(System.out::println).forEach(System.out::println);


        //limit使用，主要用于无限流
        new Random().ints().filter(i->i>100&&i<1000).limit(10).forEach(System.out::println);


        List<Integer> ints = new ArrayList<>();
        new Random().ints().filter(i->i>100&&i<1000).limit(10).forEach(li->{
            System.out.println(li);
            ints.add(li);
        });
        System.out.println(ints);

    }
}
