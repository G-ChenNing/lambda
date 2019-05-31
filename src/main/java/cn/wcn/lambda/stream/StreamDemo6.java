package cn.wcn.lambda.stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StreamDemo6 {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        new Random().ints().filter(i->i>100&&i<1000).limit(10).forEach(li->{
            System.out.println(li);
            ints.add(li);
        });
        System.out.println(ints);


        List<Double> v = new ArrayList<>();
//        new Random().doubles().filter(i->i>100&&i<220).limit(1).forEach(ints2::add);
        new Random().doubles().filter(i->i>0.218&&i<0.222).limit(1).forEach(li->{
            BigDecimal b = new BigDecimal(li*1000);
            v.add(b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        });
        System.out.println(v);

        List<Double> e = new ArrayList<>();
//        new Random().doubles().filter(i->i>100&&i<220).limit(1).forEach(ints2::add);
        new Random().doubles().filter(i->i>0.5812&&i<0.6295).limit(1).forEach(li->{
            BigDecimal b = new BigDecimal(li*10);
            e.add(b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        });
        System.out.println(e);

    }
}
