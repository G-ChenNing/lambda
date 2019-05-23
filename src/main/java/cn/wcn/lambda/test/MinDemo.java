package cn.wcn.lambda.test;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class MinDemo {
    public static void main(String[] args) {
        int[] nums = {33, 55, -55, 90, -666, 90};
        int min = Integer.MAX_VALUE;

        for (int i : nums) {
            if (i < min) {
                min = i;
            }
        }
        System.out.println(min);

        OptionalInt min1 = IntStream.of(nums).parallel().min();
        System.out.println(min1.isPresent());
        System.out.println(min1.getAsInt());

    }
}
