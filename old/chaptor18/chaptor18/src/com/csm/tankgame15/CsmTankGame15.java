package com.csm.tankgame15;

import javax.swing.*;

/**
 * @Author 快乐小柴
 * @Date 2022/9/9 12:09
 * @Version 1.15
 *坦克多发子弹：
 * 1.14实现了敌方和我方坦克之间子弹的多发
 * 1.15实现了敌方坦克可射击我方坦克
 */
public class
CsmTankGame15 extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        CsmTankGame15 csmTankGame15 = new CsmTankGame15();
    }

    public CsmTankGame15() {
        mp = new MyPanel();
        //将mp放入Thread,并启动
        new Thread(mp).start();
        this.add(mp);
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(mp);

    }
}
