package cn.wcn.lambda.test;

public class ThreadDemo {
    public static void main(String[] args) {
        Object ok = new Runnable() {
            @Override
            public void run() {
                System.out.println("ok");
            }
        };

        new Thread((Runnable) ok).start();


        Object ok1 = (Runnable)() -> System.out.println("ok");
        Runnable ok2 = () -> System.out.println("ok");

        System.out.println(ok1==ok2);
        new Thread((Runnable) ok1).start();
    }


}
