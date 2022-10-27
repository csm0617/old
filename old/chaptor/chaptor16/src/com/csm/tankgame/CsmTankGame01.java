package com.csm.tankgame;
import javax.swing.*;

/**
 * @Author 快乐小柴
 * @Date 2022/9/8 19:09
 * @Version 1.0
 */
public class CsmTankGame01 extends JFrame {
    MyPanel mp=null;
    public static void main(String[] args) {
        CsmTankGame01 csmTankGame01 = new CsmTankGame01();
    }
    public CsmTankGame01(){
        mp=new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
