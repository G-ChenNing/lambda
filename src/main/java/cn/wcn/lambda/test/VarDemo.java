package cn.wcn.lambda.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class VarDemo {
    public static void main(String[] args) {
//        String str = "我们的时间";
        List<String> list = new ArrayList<>();
        Consumer<String> consumer = s -> System.out.println(s + list);
//        Consumer<String> consumer2 =System.out::println;
        consumer.accept("1211");

    }
}
