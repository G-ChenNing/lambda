package cn.wcn.lambda.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class MethodRefrenceDemo {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat(3);
        //方法引用
        Consumer<String> consumer = System.out::println;
        consumer.accept("接收的数据");

        //静态方法的方法引用
        Consumer<Dog> consumer1 = Dog::bark;
        consumer1.accept(dog);

        //非静态方法，使用对象实例来引用
//        Function<Integer, Integer> function = dog::eat;
//        UnaryOperator<Integer> function = dog::eat;
        IntUnaryOperator function = dog::eat;
        dog = null;
        System.out.println("还剩下" + function.applyAsInt(2) + "斤");
//
        dog = new Dog();
        dog.eat(3);


        //使用类名来方法引用
        BiFunction<Dog,Integer,Integer> biFunction = Dog::eat;
        System.out.println("还剩下" + biFunction.apply(dog, 2) + "斤");

        //构造函数的方法引用
        Supplier<Dog> supplier = Dog::new;
        System.out.println("创建了新对象： " + supplier.get());

        //带参数的构造函数方法引用
        Function<String, Dog> function1 = Dog::new;
        System.out.println("创建了新对象： " + function1.apply("旺财"));

        List<String> list = new ArrayList<>();
        //OrderOfObjectsAfterGCMain.printAddresses("1", list);
        test(list);
        System.out.println(list);
//
//
//
//        String s = "1";
//        //OrderOfObjectsAfterGCMain.printAddresses("4", s);
//        test(s);
//        System.out.println(Integer.toHexString(s.hashCode()));
//        Dog dog1 = new Dog();
//        test(dog1);
//        System.out.println(dog1.getFood());
    }

    private static void test(List<String> list) {
        //OrderOfObjectsAfterGCMain.printAddresses("2", list);
        list.add("1");
        list.add("1");
        List<String> list2 = new ArrayList<>();
        list = list2;
        list.add("2");
    }

    private static void test(String str) {
        //OrderOfObjectsAfterGCMain.printAddresses("3", str);
        str = "123";

    }

    private static void test(Dog dog) {
        dog.setFood(1000);
        dog = null;
    }
}

class Dog {
    private String name = "哮天犬";
    private int food = 10;

    public Dog() {

    }

    public Dog(String name) {
        this.name = name;
    }

    /**
     * @param dog
     */
    public static void bark(Dog dog) {
        System.out.println(dog + "叫了");
    }

    /**
     * @param num
     * @return
     */
//    public int eat(Dog this,int num) {
    public int eat(int num) {
        System.out.println("吃了" + num + "斤狗粮");
        this.food -= num;
        return this.food;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }
}
