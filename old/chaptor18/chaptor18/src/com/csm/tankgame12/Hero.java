package com.csm.tankgame12;

/**
 * @author 快乐小柴
 * @version 1.0
 * 我方坦克
 */
public class Hero extends Tank {
    Shot shot = null;//定义一个Shot对象，表示一个射击线程

    public Hero(int x, int y) {
        super(x, y);
    }

    public void shotEnemyTank() {
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
        //启动Shot线程
        new Thread(shot).start();
    }
}
