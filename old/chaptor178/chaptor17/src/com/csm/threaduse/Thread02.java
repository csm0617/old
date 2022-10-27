package com.csm.threaduse;

/**
 * @Author 快乐小柴
 * @Date 2022/9/9 6:49
 * @Version 1.0
 */
public class Thread02 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread thread = new Thread(t1);
        thread.start();
        Thread thread1 = new Thread(t2);
        thread1.start();
    }
}

class T1 implements Runnable {
    private int count1 = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("hello world" + (++count1) + "  " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count1==10)
                break;
        }
    }
}
class T2 implements Runnable {
    private int count2 = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("hi" + (++count2) + "  " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count2==10)
                break;
        }
    }
}