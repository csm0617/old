package com.csm.tankgame3;

import javax.swing.*;

/**
 * @Author 快乐小柴
 * @Date 2022/9/8 19:09
 * @Version 1.3
 * 实现了我方坦克发射子弹的功能
 */
public class
CsmTankGame03 extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        CsmTankGame03 csmTankGame03 = new CsmTankGame03();
    }

    public CsmTankGame03() {
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
