package com.csm.tankgame12;

import javax.swing.*;

/**
 * @Author 快乐小柴
 * @Date 2022/9/9 12:09
 * @Version 1.12
 *
 * 1.12相比1.11版本实现了敌方坦克子弹多发
 *
 */
public class
CsmTankGame12 extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        CsmTankGame12 csmTankGame12 = new CsmTankGame12();
    }

    public CsmTankGame12() {
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
