package cn.wcn.lambda.test;

@FunctionalInterface
interface Interface1 {
    int doubleNum(int i);

    default int add(int x, int y) {
        return x + y;
    }
}
@FunctionalInterface
interface Interface2 {
    int doubleNum(int i);

    default int add(int x, int y) {
        return x + y;
    }
}
@FunctionalInterface
interface Interface3 extends Interface1,Interface2{

    @Override
    default int add(int x, int y) {
        return Interface1.super.add(x, y);
    }
}

public class LambdaDemo1 {

    public static void main(String[] args) {
        Interface1 i1 = (i) -> i * 2;
        Interface1 i2 = i -> i * 2;
        Interface1 i3 = (int i) -> i * 2;
        Interface1 i4 = (int i) -> {
            System.out.println("------------");
            return i * 2;
        };


        System.out.println(i4.doubleNum(2));
        System.out.println(i4.add(3,7));


    }


}
