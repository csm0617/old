package com.csm.tankgame17;

import java.util.Vector;

/**
 * @author 快乐小柴
 * @version 1.0
 * 我方坦克
 */
public class Hero extends Tank {
    Shot shot = null;//定义一个Shot对象，表示一个射击线程
    //可以发射多颗子弹
    Vector<Shot> shots=new Vector<>();

    public Hero(int x, int y) {
        super(x, y);
    }

    public void shotEnemyTank() {
        //发射多颗子弹控制，面板上只有5个
        if (shots.size()==5) {
            return;
        }
        //创建Shot对象，根据当前Hero对象的位置和方向来创建Shot
        switch (getDirection()) {//获得hero坦克的方向
            case 0://向上
                shot = new Shot(getX() + 20, getY(), 0);
                break;
            case 1://向上
                shot = new Shot(getX() + 60, getY()+20, 1);
                break;
            case 2://向上
                shot = new Shot(getX() + 20, getY()+60, 2);
                break;
            case 3://向上
                shot = new Shot(getX(), getY()+20, 3);
                break;
        }
        //把新创建的shot放入到shots
        shots.add(shot);//------>需要去重新采用遍历的方式绘制子弹
        //启动Shot线程
        new Thread(shot).start();
    }
}
