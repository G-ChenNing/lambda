package cn.wcn.lambda.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class StreamDemo5 {
    public static void main(String[] args) throws InterruptedException {
        //调用parallel产生一个并行流
//        IntStream.range(1, 100).parallel().peek(StreamDemo5::debug).count();

        // 现在要实现一个这样的效果：先并行，再串行
        //多次调用 parallel/sequential ,以最后一次调用为准
//        IntStream.range(1, 100)
//                //调用 parallel 产生并行流
//                .parallel().peek(StreamDemo5::debug)
//                //调用 sequential 产生串行流
//                .sequential().peek(StreamDemo5::debug2).count();

        //并行流使用的线程池：ForkJoinPool.commonPool
        //默认的线程数是 当前机器的cpu个数
        //使用这个属性可以修改默认的线程数
//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
//        IntStream.range(1, 100).parallel().peek(StreamDemo5::debug).count();

//         使用自己的线程池，不使用默认的线程池，防止任务被阻塞
        ForkJoinPool forkJoinPool = new ForkJoinPool(20);
        forkJoinPool.submit(() ->IntStream.range(1, 100).parallel().peek(StreamDemo5::debug).max());
        forkJoinPool.shutdown();
//
        synchronized (forkJoinPool) {
            forkJoinPool.wait();
        }

//        IntStream peek = IntStream.range(1, 100).parallel().peek(StreamDemo5::debug);
////        long count = peek.count();
////        System.out.println(peek.count());
//        System.out.println(peek.max());

    }

    public static void debug(int i) {
        log.info(Thread.currentThread().getName() + "debug " + i);
        System.out.println(Thread.currentThread().getName() + "debug " + i);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void debug2(int i) {
        log.info(Thread.currentThread().getName() + "debug " + i);
        System.err.println("debug2 " + i);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
