package cn.wcn.lambda.stream;

import java.util.stream.IntStream;

public class StreamDemo {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        //外部迭代
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        System.out.println("结果为：" + sum);

        //使用stream的内部迭代
        //map就是中间操作(返回stream的操作)
        //sum就是终止操作
//        int sum1 = IntStream.of(nums).parallel().map(i -> i * 2).sum();
        int sum1 = IntStream.of(nums).map(StreamDemo::doubleNum).sum();
        System.out.println("结果为：" + sum1);

        System.out.println("惰性求值就是终止没有调用的情况下，中间操作不会执行");
        IntStream intStream = IntStream.of(nums).map(StreamDemo::doubleNum);


    }

    public static int doubleNum(int i) {
        System.out.println("执行了乘以2");
        return i * 2;
    }
}
