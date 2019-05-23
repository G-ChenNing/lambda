package cn.wcn.lambda.test;

import java.text.DecimalFormat;
import java.util.function.Function;

//interface IMoneyFormat{
//    String format(int i);
//}

class MyMoney {
    private final int money;

    public MyMoney(int money) {
        this.money = money;
    }

    public void printMoney(Function<Integer, String> moneyFormat) {
        System.out.println("我的存款：" + moneyFormat.apply(this.money));
    }
}


public class MoneyDemo {

    public static void main(String[] args) {
        MyMoney me = new MyMoney(1999999999);

        Function<Integer, String> integerStringFunction = i -> new DecimalFormat("#,###").format(i);
        me.printMoney(integerStringFunction.andThen(s -> "人民币" + s));
    }
}
