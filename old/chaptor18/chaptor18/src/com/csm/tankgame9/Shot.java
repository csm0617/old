package com.csm.tankgame9;

/**
 * @Author 快乐小柴
 * @Date 2022/9/9 10:02
 * @Version 1.0
 * 子弹射击线程
 * description:当发射一颗子弹相当于启动一个进程
 */
public class Shot implements Runnable {
    int x;// 子弹的x坐标
    int y;// 子弹的y坐标
    int direction;//子弹的方向
    int speed = 4;//子弹的速度
    boolean isLive = true;//子弹是否存活

    //构造器
    public Shot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public void run() {//子弹的射击行为
        while (true) {
            try {
                //子弹休眠50毫秒
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //根据方向来改变子弹的x,y坐标
            switch (direction) {
                case 0://向上
                    y -= speed;//子弹的y坐标-子弹的速度
                    break;
                case 1://向右
                    x += speed;//子弹的y坐标-子弹的速度
                    break;
                case 2://向下
                    y += speed;
                    break;
                case 3://向左
                    x -= speed;
                    break;
            }
            System.out.println("子弹x:" + x + "y:" + y);
            //当子弹移动到面板的边界时，就销毁子弹线程
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750&&isLive)) {
                System.out.println("子弹线程退出...");
                isLive = false;
                break;
            }
        }

    }
}
