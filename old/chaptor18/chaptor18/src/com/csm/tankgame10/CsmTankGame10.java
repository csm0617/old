package com.csm.tankgame10;

import javax.swing.*;

/**
 * @Author 快乐小柴
 * @Date 2022/9/9 12:09
 * @Version 1.10
 *坦克多发子弹：
 * 我方坦克在发射的子弹消亡后，才能发射新的子弹。-->扩展发射多颗子弹
 */
public class
CsmTankGame10 extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        CsmTankGame10 csmTankGame10 = new CsmTankGame10();
    }

    public CsmTankGame10() {
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
