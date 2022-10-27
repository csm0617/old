package com.csm.tankgame14;

import javax.swing.*;

/**
 * @Author 快乐小柴
 * @Date 2022/9/9 12:09
 * @Version 1.14
 *坦克多发子弹：
 * 实现了敌方和我方坦克之间子弹的多发
 */
public class
CsmTankGame14 extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        CsmTankGame14 csmTankGame14 = new CsmTankGame14();
    }

    public CsmTankGame14() {
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
