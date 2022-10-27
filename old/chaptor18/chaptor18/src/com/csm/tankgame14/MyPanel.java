package com.csm.tankgame14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @Author 快乐小柴
 * @Date 2022/9/8 19:00
 * @Version 1.0
 * 坦克大战绘图区域
 */
//创建一个绘图区域类，MyPanel继承JPanel,为了监听键盘事件 ，实现KeyListener
//为了让Panel不停的重绘子弹，需要将MyPanel实现Runnable,当作一个线程使用
public class MyPanel extends JPanel implements KeyListener, Runnable {
    //定义我方坦克
    Hero hero = null;
    //定义敌方坦克，放入到Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //敌方坦克数量
    int enemyTankSize = 3;
    //定义一个Vector，用于存放炸弹
    //当子弹击中坦克时，加入Bomb对象到bomb中
    Vector<Bomb> bombs = new Vector<>();
    //定义三张炸弹图片
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel() {//构造器，初始化画板，比如坦克
        //初始化自己的Hero坦克
        hero = new Hero(600, 400);
        //初始化敌方坦克
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            enemyTank.setDirection(2);
            enemyTank.setSpeed(3);
            //启动敌人坦克线程
            new Thread(enemyTank).start();
            //初始化Shot 给enemyTank 加入一颗子弹
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirection());
            //加入enemyTank的Vector成员
            enemyTank.shots.add(shot);
            //启动shot对象
            new Thread(shot).start();
            //加入
            enemyTanks.add(enemyTank);
        }
        //初始化图片
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/img1.jpg"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/img2.jpg"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/img3.jpg"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认是黑色
        //画出我方坦克-通过封装方法
        drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 1);
        //画出我方射击的子弹
        if (hero.shot != null && hero.shot.isLive == true) {
//            System.out.println("我方子弹被绘制....");
            g.fillOval(hero.shot.x, hero.shot.y, 5, 5);
        }
        //设置我方hero坦克的速度
        hero.setSpeed(5);
        //将hero的子弹集合shorts,遍历取出绘制
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot != null && shot.isLive == true) {
                g.fillOval(shot.x, shot.y, 5, 5);
            } else {//如果该shot对象已经无效，就从shots集合中拿掉
                hero.shots.remove(shot);
            }
        }
        //如果bombs集合中有对象，就画出
        for (int i = 0; i < bombs.size(); i++) {
            //取出炸弹
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Bomb bomb = bombs.get(i);
            //根据当前这个Bomb对象的life值去画出对应的图片
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 75, 100, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 75, 100, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 75, 100, this);
            }
            //让炸弹的生命值减少
            bomb.lifeDown();
            //如果Bomb life为0，就从bombs的集合中删除
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }
        //画出敌方坦克，遍历Vector
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank.isLive) {//当敌方坦克存活时再去绘制敌方坦克
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirection(), 0);
                //画出 enemyTank所有子弹
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    //取出子弹
                    Shot shot = enemyTank.shots.get(j);
                    //绘制子弹
                    if (shot.isLive) {
                        g.fillOval(shot.x, shot.y, 5, 5);
                    } else {
                        //从Vector中移除isLive==false的子弹，如果不移除就会一直绘制
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }

    }
    // 封装一个画坦克的方法
    //编写方法，画出坦克

    /**
     * @param x         坦克的左上角x坐标
     * @param y         坦克的左上角y坐标
     * @param g         画笔
     * @param direction 坦克的方向（上下左右）
     * @param type      坦克的类型 0我方坦克，1敌方坦克
     */
    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        //根据不同的类型，设置不同的颜色
        switch (type) {
            case 0://我方坦克
                g.setColor(Color.cyan);
                break;
            case 1://敌方坦克
                g.setColor(Color.yellow);
                break;
        }
        //根据坦克的方向，来绘制坦克
        switch (direction) {//0:向上 1:向右 2:向左 3: 向下
            case 0://向上
                g.fill3DRect(x, y, 10, 60, true);//画出坦克左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, true);//画出坦克右边的轮子
//                if(type==0) {
//                    g.setColor(Color.white);
//                    g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出中间的矩形
//                }
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出中间的矩形
                g.fillOval(x + 9, y + 20, 20, 20);//画出坦克的盖子
                g.drawLine(x + 20, y + 30, x + 20, y);//画出坦克的炮筒
                break;
            case 1://向右
                g.fill3DRect(x, y, 60, 10, true);//画出坦克左边的轮子
                g.fill3DRect(x, y + 30, 60, 10, true);//画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出中间的矩形
                g.fillOval(x + 20, y + 9, 20, 20);//画出坦克的盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//画出坦克的炮筒
                break;
            case 2://向下
                g.fill3DRect(x, y, 10, 60, true);//画出坦克左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, true);//画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出中间的矩形
                g.fillOval(x + 9, y + 20, 20, 20);//画出坦克的盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//画出坦克的炮筒
                break;
            case 3://向左
                g.fill3DRect(x, y, 60, 10, true);//画出坦克左边的轮子
                g.fill3DRect(x, y + 30, 60, 10, true);//画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出中间的矩形
                g.fillOval(x + 20, y + 9, 20, 20);//画出坦克的盖子
                g.drawLine(x + 30, y + 20, x, y + 20);//画出坦克的炮筒
                break;
        }
    }

    //如果我们的坦克可以发射多颗子弹
    //在判断我方子弹是否击中敌人坦克时，就需要把我们的子弹集合中
    //所有的子弹，都取出来和敌人的所有坦克进行比较
    public void hitEnemyTank() {
        //
        for (int j = 0; j < hero.shots.size(); j++) {
            Shot shot = hero.shots.get(j);
            if (shot != null && shot.isLive) {//当发射子弹且子弹存活
                //遍历敌人所有的坦克
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(shot, enemyTank);
                }
            }
        }
    }

    //编写方法，判断我方子弹是否击中敌方坦克。
    //什么时候去判断 我方子弹是否击中敌方坦克？run方法
    public void hitTank(Shot shot, EnemyTank enemyTank) {
        switch (enemyTank.getDirection()) {
            case 0://坦克向上
            case 2://向下
                if (shot.x > enemyTank.getX() && shot.x < enemyTank.getX() + 40 && shot.y > enemyTank.getY() && shot.y < enemyTank.getY() + 60) {
                    shot.isLive = false;
                    enemyTank.isLive = false;
                    //当我方坦克击中敌人坦克后，将enemyTank从Vector集合中移除
                    enemyTanks.remove(enemyTank);
                    //创建Bomb对象加入到Bombs集合
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1://向右
            case 3://向左
                if (shot.x > enemyTank.getX() && shot.x < enemyTank.getX() + 60 && shot.y > enemyTank.getY() && shot.y < enemyTank.getY() + 40) {
                    shot.isLive = false;
                    enemyTank.isLive = false;
                    //创建Bomb对象加入到Bombs集合
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理w，s，a，d 键按下的情况,改变坦克的方向,进行移动。
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirection(0);//向上
            if (hero.getY() > 0)
                hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirection(1);//向右
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirection(2);//向下
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirection(3);//向左
            if (hero.getX() > 0)
                hero.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_J) {
//            System.out.println("用户按下了J，开始射击");
            //当按下J键如果没有子弹就创建一个子弹，如果子弹的生命周期消亡了isLive==false（不等于子弹为空），就创建一个新的子弹
//            if (hero.shot==null||!hero.shot.isLive) {//单发子弹
//                hero.shotEnemyTank();
//            }
            hero.shotEnemyTank();//发射多颗子弹
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {//每隔100毫秒，重绘区域，子弹就移动
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //判断是否击中敌方坦克
            hitEnemyTank();
            this.repaint();
        }
    }
}
