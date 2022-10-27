package com.csm.tankgame8;

import javax.swing.*;

/**
 * @Author 快乐小柴
 * @Date 2022/9/9 12:09
 * @Version 1.8
 *控制坦克的移动范围
 */
public class
CsmTankGame08 extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        CsmTankGame08 csmTankGame08 = new CsmTankGame08();
    }

    public CsmTankGame08() {
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
