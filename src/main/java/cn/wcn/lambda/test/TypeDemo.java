package cn.wcn.lambda.test;

import java.util.function.BinaryOperator;
import java.util.function.Function;

@FunctionalInterface
interface IMath {
    int add(int x, int y);
}

@FunctionalInterface
interface IMath2 {
    int add(int x, int y);
}

public class TypeDemo {
    public static void main(String[] args) {

        //变量类型定义
        BinaryOperator<Integer> lambda = Integer::sum;

        //数组里
        IMath[] lambdas = {(x, y) -> x + y};

        //强转
        Object lambda2 = (IMath) (x, y) -> x + y;

       //通过返回类型
        IMath createLambda = createLambda();

        TypeDemo typeDemo = new TypeDemo();
        typeDemo.test((IMath)(x, y) -> x + y);
//        typeDemo.test((IMath)lambda2);

    }

    public void test(IMath iMath) {
        System.out.println(iMath.add(1,2));
    }

    public void test(IMath2 iMath) {
        System.out.println(iMath.add(1,2));
    }

    public static IMath createLambda() {
        return (x, y) -> x + y;
    }

}
