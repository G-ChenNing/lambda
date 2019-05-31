//package cn.wcn.lambda.test;
//
//import sun.misc.Unsafe;
//
//import java.lang.reflect.Field;
//import java.util.Arrays;
//import java.util.Collections;
//public class OrderOfObjectsAfterGCMain {
//    static final Unsafe unsafe = getUnsafe();
//    static final boolean is64bit = true; // auto detect if possible.
//
//    public static void main(String... args) {
//        Double[] ascending = new Double[16];
//        for(int i=0;i<ascending.length;i++)
//            ascending[i] = (double) i;
//
//        Double[] descending = new Double[16];
//        for(int i=descending.length-1; i>=0; i--)
//            descending[i] = (double) i;
//
//        Double[] shuffled=new Double[16];
//        for(int i=0;i<shuffled.length;i++)
//            shuffled[i] = (double) i;
//        Collections.shuffle(Arrays.asList(shuffled));
//
//        System.out.println("Before GC");
//        printAddresses("ascending", ascending);
//        printAddresses("descending", descending);
//        printAddresses("shuffled", shuffled);
//
//        System.gc();
//        System.out.println("\nAfter GC");
//        printAddresses("ascending", ascending);
//        printAddresses("descending", descending);
//        printAddresses("shuffled", shuffled);
//
//        System.gc();
//        System.out.println("\nAfter GC 2");
//        printAddresses("ascending", ascending);
//        printAddresses("descending", descending);
//        printAddresses("shuffled", shuffled);
//    }
//
//    public static void printAddresses(String label, Object... objects) {
//        System.out.print(label + ": 0x");
//        long last = 0;
//        int offset = unsafe.arrayBaseOffset(objects.getClass());
//        int scale = unsafe.arrayIndexScale(objects.getClass());
//        switch (scale) {
//            case 4:
//                long factor = is64bit ? 8 : 1;
//                final long i1 = (unsafe.getInt(objects, offset) & 0xFFFFFFFFL) * factor;
//                System.out.print(Long.toHexString(i1));
//                last = i1;
//                for (int i = 1; i < objects.length; i++) {
//                    final long i2 = (unsafe.getInt(objects, offset + i * 4) & 0xFFFFFFFFL) * factor;
//                    if (i2 > last)
//                        System.out.print(", +" + Long.toHexString(i2 - last));
//                    else
//                        System.out.print(", -" + Long.toHexString( last - i2));
//                    last = i2;
//                }
//                break;
//            case 8:
//                throw new AssertionError("Not supported");
//        }
//        System.out.println();
//    }
//
//    private static Unsafe getUnsafe() {
//        try {
//            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
//            theUnsafe.setAccessible(true);
//            return (Unsafe) theUnsafe.get(null);
//        } catch (Exception e) {
//            throw new AssertionError(e);
//        }
//    }
//}
