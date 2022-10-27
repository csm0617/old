package com.csm.tankgame;

import javax.swing.*;
import java.awt.*;

/**
 * @Author 快乐小柴
 * @Date 2022/9/8 19:00
 * @Version 1.0
 * 坦克大战绘图区域
 */
//创建一个绘图区域类，MyPanel继承JPanel
public class MyPanel extends JPanel {
    Hero hero = null;

    public MyPanel() {
        hero = new Hero(100, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);//填充矩形，默认是黑色
        drawTank(hero.getX(),hero.getY(),g,0,0);
        drawTank(hero.getX()+60,hero.getY(),g,0,1);
    }
    // 封装一个画坦克的方法
    //编写方法，画出坦克

    /**
     *
     * @param x 坦克的左上角x坐标
     * @param y 坦克的左上角y坐标
     * @param g 画笔
     * @param direction 坦克的方向（上下左右）
     * @param type 坦克的类型 0我方坦克，1敌方坦克
     */
    public void drawTank(int x,int y,Graphics g,int direction,int type){
        //根据不同的类型，设置不同的颜色
        switch (type){
            case 0://我方坦克
                g.setColor(Color.cyan);
                break;
            case 1://敌方坦克
                g.setColor(Color.yellow);
                break;
        }
        //根据坦克的方向，来绘制坦克
        switch (direction){
            case 0:
                g.fill3DRect(x,y,10,60,true);//画出坦克左边的轮子
                g.fill3DRect(x+30,y,10,60,true);//画出坦克右边的轮子
//                if(type==0) {
//                    g.setColor(Color.white);
//                    g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出中间的矩形
//                }
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出中间的矩形
                g.fillOval(x+9,y+20,20,20);//画出坦克的盖子
                g.drawLine(x+20,y+30,x+20,y);//画出坦克的炮筒
                break;
            default:
                System.out.println("其他的方向暂时没有处理");
        }
    }
}
