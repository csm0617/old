package com.csm.tankgame4;

import javax.swing.*;

/**
 * @Author 快乐小柴
 * @Date 2022/9/9 11:09
 * @Version 1.4
 * 实现了了敌方坦克发射子弹的功能
 */
public class
CsmTankGame04 extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        CsmTankGame04 csmTankGame04 = new CsmTankGame04();
    }

    public CsmTankGame04() {
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
