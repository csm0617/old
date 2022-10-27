package com.csm.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @Author 快乐小柴
 * @Date 2022/9/8 20:27
 * @Version 1.0
 */
//窗口
public class BallMove extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        BallMove ballMove = new BallMove();

    }

    //构造器
    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(mp);
    }
}

// 面板画出小球
class MyPanel extends JPanel implements KeyListener {
    int x = 10;
    int y = 20;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.cyan);
        g.fillOval(x, y, 20, 20);//默认是黑色
    }

    //当有字符输出时，方法触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //当有某个键按下时，该方法会触发
    @Override
    public void keyPressed(KeyEvent e) {
        // System.out.println((char) e.getKeyCode()+"被按下。。。");
        //根据用户按下的不同的方向键，来处理小球的移动
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y++;
        } else if (e.getKeyCode() == KeyEvent.VK_UP &&y>0) {
            y--;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT&&x>0) {
            x--;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }
        this.repaint();
    }

    //当有某个键松开时，该方法会触发
    @Override
    public void keyReleased(KeyEvent e) {
    }
}