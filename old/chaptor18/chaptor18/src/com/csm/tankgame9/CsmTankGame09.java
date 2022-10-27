package com.csm.tankgame9;

import javax.swing.*;

/**
 * @Author 快乐小柴
 * @Date 2022/9/9 12:09
 * @Version 1.9
 *bug：原先每按一下J，就会产生一颗新的子弹
 * 修复：1.我方坦克在发射的子弹消亡后，才能发射新的子弹。
 */
public class
CsmTankGame09 extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        CsmTankGame09 csmTankGame09 = new CsmTankGame09();
    }

    public CsmTankGame09() {
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
