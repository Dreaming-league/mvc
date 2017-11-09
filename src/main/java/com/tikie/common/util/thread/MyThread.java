package com.tikie.common.util.thread;

/**
 * @author zcs
 * @desc 目的
 * @date 2017/1/3
 */
public class MyThread extends Thread {
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("输出内容:线程"+getName()+"正在打印"+ i);
        }
    }

    public static void main (String[] args){
        //获取当前线程的名字
        String name = Thread.currentThread().getName();
        System.out.println("输出内容:"+ name +"开始执行");

        //创建线程对象
        MyThread myThread = new MyThread();
        myThread.start();

        for(int i=0;i<10;i++){
            System.out.println("输出内容:线程"+name+"正在打印" +i );
        }

        System.out.println("输出内容:"+ name +"执行完毕");
    }
}
