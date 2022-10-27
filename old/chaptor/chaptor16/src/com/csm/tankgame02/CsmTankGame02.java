package com.csm.tankgame02;

import javax.swing.*;

/**
 * @Author 快乐小柴
 * @Date 2022/9/8 19:09
 * @Version 1.0
 */
public class CsmTankGame02 extends JFrame {
    MyPanel mp=null;
    public static void main(String[] args) {
        CsmTankGame02 csmTankGame02 = new CsmTankGame02();
    }
    public CsmTankGame02(){
        mp=new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(mp);

    }
}
