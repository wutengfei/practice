package com.company.others;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Created by Administrator on 2017/11/7.
 */
public class ThreadPool {
    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "执行中。。。");
        }
    }

    public static void main(String[] args) {
//        newSingleThreadExecutor();
        // newFixedThreadPool();
        // newCachedThreadPool();
        newScheduledThreadPool();
    }

    public static void newSingleThreadExecutor() {
        //创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newSingleThreadExecutor();
        //创建实现了Runnable接口对象
        Thread tt1 = new MyThread();
        Thread tt2 = new MyThread();
        Thread tt3 = new MyThread();
        Thread tt4 = new MyThread();
        Thread tt5 = new MyThread();
        //将线程放入池中并执行
        pool.execute(tt1);
        pool.execute(tt2);
        pool.execute(tt3);
        pool.execute(tt4);
        pool.execute(tt5);
        //关闭
        pool.shutdown();
    }

    public static void newFixedThreadPool() {
        //创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        //创建实现了Runnable接口对象
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
        //将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        //关闭线程池
        pool.shutdown();
    }

    public static void newCachedThreadPool() {
        //创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newCachedThreadPool();
        //创建实现了Runnable接口对象
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
        //将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        //关闭线程池
        pool.shutdown();
    }

    public static void newScheduledThreadPool() {
        ExecutorService pool = Executors.newScheduledThreadPool(3);
        // ExecutorService pool  = new  ScheduledThreadPoolExecutor(3);
        //创建实现了Runnable接口对象
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
        //将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        //关闭线程池
        pool.shutdown();
    }
}
