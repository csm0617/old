package com.csm.tankgame5;

import javax.swing.*;

/**
 * @Author 快乐小柴
 * @Date 2022/9/9 12:09
 * @Version 1.5
 *实现了子弹击中敌方坦克使其消失的功能
 */
public class
CsmTankGame05 extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        CsmTankGame05 csmTankGame05 = new CsmTankGame05();
    }

    public CsmTankGame05() {
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
