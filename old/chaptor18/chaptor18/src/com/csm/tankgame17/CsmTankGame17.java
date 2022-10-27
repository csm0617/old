package com.csm.tankgame17;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @Author 快乐小柴
 * @Date 2022/9/9 12:09
 * @Version 1.17
 *坦克多发子弹：
 * 1.14实现了敌方和我方坦克之间子弹的多发
 * 1.15实现了敌方坦克可射击我方坦克
 * 1.17增加了防止坦克重叠的功能
 */
public class
 CsmTankGame17 extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        CsmTankGame17 csmTankGame17 = new CsmTankGame17();
    }

    public CsmTankGame17() {
        mp = new MyPanel();
        //将mp放入Thread,并启动
        new Thread(mp).start();
        this.add(mp);
        this.setSize(1200, 950);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(mp);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("监听到窗口关闭了");
                System.exit(0);
                Recorder.keepRecord();
            }
        });

    }
}
