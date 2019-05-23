package cn.wcn.lambda.test;

import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class FunctionDemo {
    public static void main(String[] args) {
        //断言函数接口
//        Predicate<Integer> predicate = i -> i > 0;
        IntPredicate predicate = i -> i > 0;
        System.out.println(predicate.test(-9));

        //消费函数接口   IntConsumer
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("输入的数据");

        

    }
}
