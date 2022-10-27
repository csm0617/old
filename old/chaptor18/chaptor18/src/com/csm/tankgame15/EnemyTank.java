package com.csm.tankgame15;

import java.util.Vector;

/**
 * @Author 快乐小柴
 * @Date 2022/9/8 22:35
 * @Version 1.0
 */
public class EnemyTank extends Tank implements Runnable {//要让敌方坦克自由移动需要将敌方的坦克方程一个线程
    //在敌人坦克类，使用Vector 保存多个Shot
    Vector<Shot> shots = new Vector<>();

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (true) {
            //这里我们判断如果shots.size()==0,创建一颗子弹放入到
            //shots集合，并启动
            if (isLive && shots.size() <= 5) {//先判断坦克是否存活
                Shot s = null;
                //判断坦克的方向，并创建子弹
                switch (getDirection()) {
                    case 0:
                        s = new Shot(getX() + 20, getY(), 0);
                        break;
                    case 1:
                        s = new Shot(getX() + 60, getY() + 20, 1);
                        break;
                    case 2:
                        s = new Shot(getX() + 20, getY() + 60, 2);
                        break;
                    case 3:
                        s = new Shot(getX(), getY() + 20, 3);
                        break;
                }
                //加入子弹
                shots.add(s);
                //启动
                new Thread(s).start();
            }
            //根据坦克的方向继续移动
            switch (getDirection()) {//顺时针方向
                case 0:
                    for (int i = 0; i < 30; i++) {
                        moveUp();
                        try {
                            //休眠50毫秒
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                        moveRight();
                        try {
                            //休眠50毫秒
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        moveDown();
                        try {
                            //休眠50毫秒
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        moveLeft();
                        try {
                            //休眠50毫秒
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }
            //随机改变坦克的方向 0-1
            //random取值[0,1)
            setDirection((int) (Math.random() * 4));
//            setDirection(1);
            //写并发程序，一定要想清楚，该线程什么时候线程结束
            if (!isLive) {//当敌方坦克被击中时线程结束，退出线程
                break;
            }
        }
    }
}
