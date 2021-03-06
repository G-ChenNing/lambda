package cn.wcn.lambda.test;

import java.util.function.Function;

/**
 * @author Musk
 * 级联表达式和柯里化
 */
public class CurryDemo {
    public static void main(String[] args) {
        //x->y->x+y
        Function<Integer, Function<Integer, Integer>> fun = x -> y -> x + y;
        System.out.println(fun.apply(2).apply(3));

        Function<Integer, Function<Integer, Function<Integer, Integer>>> fun2 = x -> y -> z -> x + y + z;
        System.out.println(fun2.apply(2).apply(3).apply(4));


        //高阶函数，返回函数的函数
        int[] nums = {2, 3, 4};
        Function f = fun2;
        for (int num : nums) {
            if (f instanceof Function) {
                Object obj = f.apply(num);
                if (obj instanceof Function) {
                    f = (Function) obj;
                } else {
                    System.out.println("调用结束：结果为" + obj);
                }
            }
        }
    }
}
