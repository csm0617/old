package com.csm.tankgame02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @Author 快乐小柴
 * @Date 2022/9/8 19:00
 * @Version 1.0
 * 坦克大战绘图区域
 */
//创建一个绘图区域类，MyPanel继承JPanel,为了监听键盘事件 ，实现KeyListener
public class MyPanel extends JPanel implements KeyListener {
    Hero hero = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTanksize =3;
    public MyPanel() {
        hero = new Hero(600, 400);
        for (int i = 0; i < enemyTanksize; i++) {
            EnemyTank enemyTank = new EnemyTank(100*(i+1),0);
            enemyTank.setDirection(2);
            enemyTanks.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认是黑色
        drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 0);
        hero.setSpeed(5);
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirection(),1);
        }
    }
    // 封装一个画坦克的方法
    //编写方法，画出坦克

    /**
     * @param x         坦克的左上角x坐标
     * @param y         坦克的左上角y坐标
     * @param g         画笔
     * @param direction 坦克的方向（上下左右）
     * @param type      坦克的类型 0我方坦克，1敌方坦克
     */
    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        //根据不同的类型，设置不同的颜色
        switch (type) {
            case 0://我方坦克
                g.setColor(Color.cyan);
                break;
            case 1://敌方坦克
                g.setColor(Color.yellow);
                break;
        }
        //根据坦克的方向，来绘制坦克
        switch (direction) {//0:向上 1:向右 2:向左 3: 向下
            case 0://向上
                g.fill3DRect(x, y, 10, 60, true);//画出坦克左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, true);//画出坦克右边的轮子
//                if(type==0) {
//                    g.setColor(Color.white);
//                    g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出中间的矩形
//                }
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出中间的矩形
                g.fillOval(x + 9, y + 20, 20, 20);//画出坦克的盖子
                g.drawLine(x + 20, y + 30, x + 20, y);//画出坦克的炮筒
                break;
            case 1://向右
                g.fill3DRect(x, y, 60, 10, true);//画出坦克左边的轮子
                g.fill3DRect(x, y + 30, 60, 10, true);//画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出中间的矩形
                g.fillOval(x + 20, y + 9, 20, 20);//画出坦克的盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//画出坦克的炮筒
                break;
            case 2://向下
                g.fill3DRect(x, y, 10, 60, true);//画出坦克左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, true);//画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出中间的矩形
                g.fillOval(x + 9, y + 20, 20, 20);//画出坦克的盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//画出坦克的炮筒
                break;
            case 3://向左
                g.fill3DRect(x, y, 60, 10, true);//画出坦克左边的轮子
                g.fill3DRect(x, y + 30, 60, 10, true);//画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出中间的矩形
                g.fillOval(x + 20, y + 9, 20, 20);//画出坦克的盖子
                g.drawLine(x + 30, y + 20, x, y + 20);//画出坦克的炮筒
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理w，s，a，d 键按下的情况,改变坦克的方向,进行移动。
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirection(0);//向上
            if (hero.getY() > 0)
                hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirection(1);//向右
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirection(2);//向下
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirection(3);//向左
            if (hero.getX() > 0)
                hero.moveLeft();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
