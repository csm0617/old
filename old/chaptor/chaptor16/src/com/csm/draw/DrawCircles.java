package com.csm.draw;

import javax.swing.*;
import java.awt.*;

public class DrawCircles extends JFrame{
    private MyPanel mp=null;
    public static void main(String[] args) {
        new DrawCircles();
    }
    public DrawCircles(){
        mp=new MyPanel();
        this.add(mp);
        this.setSize(400,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyPanel extends JPanel{


    public void paint(Graphics g) {

        super.paint(g);
        System.out.println("paint方法被调用");
        g.drawOval(10,10,100,100);
    }
}