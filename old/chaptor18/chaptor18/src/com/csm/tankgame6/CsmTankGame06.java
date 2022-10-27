package com.csm.tankgame6;

import javax.swing.*;

/**
 * @Author 快乐小柴
 * @Date 2022/9/9 12:09
 * @Version 1.6
 *实现了子弹击中敌方坦克爆炸的效果
 */
public class
CsmTankGame06 extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        CsmTankGame06 csmTankGame06 = new CsmTankGame06();
    }

    public CsmTankGame06() {
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
