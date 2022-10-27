package com.csm.tankgame7;

import javax.swing.*;

/**
 * @Author 快乐小柴
 * @Date 2022/9/9 12:09
 * @Version 1.7
 *移除了被击中的坦克，让敌方坦克可以自由随机的移动
 */
public class
CsmTankGame07 extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        CsmTankGame07 csmTankGame07 = new CsmTankGame07();
    }

    public CsmTankGame07() {
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
