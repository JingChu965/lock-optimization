package com.jingchu.juc.optimization;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: ThreadLocal使用
 * @author: JingChu
 * @createtime :2020-07-23 19:22:25
 **/
public class MyThreadLocal {
    static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>();
    public static class ParesDate implements Runnable {
        int i = 0;

        public ParesDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                if(threadLocal.get()==null){
                    threadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:sss"));
                }
                Date d = threadLocal.get().parse("2020-07-23 19:25:" + i % 60);
                System.out.println(d.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            } finally {

            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<100;i++){
            executorService.execute(new ParesDate(i));
        }
    }
}
