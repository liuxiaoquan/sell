package com.itcast.sell.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author LXQ
 * @create 2019-01-28 10:07
 */
public class KeyUtils {

    /**
     * 生成唯一的主键
     * 格式：时间+随机数
     * synchronized 防止高并发下主键重复，代表这个方法加锁
     * 相当于不管哪一个线程（例如线程A），运行到这个方法时,都要检查有没有其它线程B（或者C、 D等）正在用这个方法(或者该类的其他同步方法)，有的话要等正在使用synchronized方法的线程B（或者C 、D）运行完这个方法后再运行此线程A,没有的话,锁定调用者,然后直接运行。它包括两种用法：synchronized 方法和 synchronized 块。
     * @return
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        int number = random.nextInt(900000) + 100000;
        return  System.currentTimeMillis()+String.valueOf(number);
    }
//    public static  String genUniqueKey2(){
//        List<String> strings = new ArrayList<>();
//        synchronized (strings){
//            Random random = new Random();
//            int number = random.nextInt(900000) + 100000;
//            return  System.currentTimeMillis()+String.valueOf(number);
//        }
//    }

}
