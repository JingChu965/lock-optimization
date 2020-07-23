package com.jingchu.juc.optimization;

/**
 * @description: 减少锁持有时间的测试
 * @author: JingChu
 * @createtime :2020-07-23 18:06:50
 **/
public class ReduceLockTime {
    //未减少锁持有时间的代码
    public synchronized void syncMeth() {
        task1();
        task2();
        task3();
    }

    public void task1() {
        System.out.println("task1 running");
    }

    public void task2() {
        System.out.println("task2 running");
    }

    public void task3() {
        System.out.println("task3 running");
    }

    //减少锁持有时间后
    public void syncMeth1() {
        task1();
        synchronized (this) {
            task2();
        }
        task3();
    }


    public void coarseningLock(){
        //锁粗化之前
        int n = 10;
        for(int i=0;i<n;i++){
            synchronized (this) {
                //TODO： 要做的事情
            }
        }
        //锁粗化之后
        synchronized (this){
            for(int i=0;i<n;i++){
                //TODO： 要做的事情
            }
        }
    }
}
