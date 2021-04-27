package com.jilingy.demo01;

/**
 * @Description: 多个线程同时操作同一个对象，火车票的例子
 * @Author: yangjiling
 * @Email: jilingy@foxmail.com
 * @Date: 2021/4/27
 **/

//大仙问题：多个线程操作同一个资源的情况下，线程不安全，数据紊乱，并发的问题
public class TestThread3 implements Runnable{
    private int ticketNum =10;

    @Override
    public void run() {
        while (true){
            if (ticketNum<0){
                break;
            }
            //模拟延迟
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketNum--+"张票");
        }
    }

    public static void main(String[] args) {
        TestThread3 ticket = new TestThread3();
        new Thread(ticket,"小明").start();
        new Thread(ticket,"老师").start();
        new Thread(ticket,"黄牛党").start();



    }
}
