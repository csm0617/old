package com.csm.tankgame11;

import javax.swing.*;

/**
 * @Author 快乐小柴
 * @Date 2022/9/9 12:09
 * @Version 1.11
 * 1.9版本是实现了将我方坦克子弹消亡后才可以进行发射，1.11版本是对1.9版本的改进。
 * 1.11版本实现了敌方坦克子弹消亡后发射
 *
 */
public class
CsmTankGame11 extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        CsmTankGame11 csmTankGame11 = new CsmTankGame11();
    }

    public CsmTankGame11() {
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
