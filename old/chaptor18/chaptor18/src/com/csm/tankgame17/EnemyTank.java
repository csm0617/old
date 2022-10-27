package com.csm.tankgame17;

import java.util.Vector;

/**
 * @Author 快乐小柴
 * @Date 2022/9/8 22:35
 * @Version 1.17
 */
public class EnemyTank extends Tank implements Runnable {//要让敌方坦克自由移动需要将敌方的坦克方程一个线程
    //在敌人坦克类，使用Vector 保存多个Shot
    Vector<Shot> shots = new Vector<>();
    //增加成员，EnemyTank 可以得到敌人坦克的Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();

    //这里提供一个方法，可以将MyPanel的成员Vector<EnemyTank> enemyTanks = new Vector<>();
    //设置到EnemyTank的成员enemyTanks
    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    //编写方法，判断当前的这个敌人坦克，是否和enemyTanks中的其他坦克发射的重叠或者碰撞
    public boolean isTouchEnemyTank() {
        switch (this.getDirection()) {
            case 0://向上
                //让当前敌人坦克和其他所有敌人坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector中取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较。和自己比较一定碰撞
                    if (enemyTank != this) {
                        //如果敌人坦克是上/下
                        //1.如果敌人坦克是上/下 x的范围[enemyTank.getX(),enemyTank.getX()+40]
                        //                  y的范围[enemyTank.getY(),enemyTank.getY()+60]

                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) {
                            //2.当前坦克的左上角坐标[this.getX(),this.getY()]
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                            //3.当前坦克的右上角坐标[this.getX()+40,this.getY()]
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }

                        //如果敌人坦克是右/左
                        //1.如果敌人坦克是右/左 x的范围[enemyTank.getX(),enemyTank.getX()+60]
                        //                  y的范围[enemyTank.getY(),enemyTank.getY()+40]
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
                            //2.当前坦克的左上角坐标[this.getX(),this.getY()]
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                            //3.当前坦克的右上角坐标[this.getX()+40,this.getY()]
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }

                    }
                }
                break;
            case 1://右
                //让当前敌人坦克和其他所有敌人坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector中取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较。和自己比较一定碰撞
                    if (enemyTank != this) {
                        //如果敌人坦克是上/下
                        //1.如果敌人坦克是上/下 x的范围[enemyTank.getX(),enemyTank.getX()+40]
                        //                  y的范围[enemyTank.getY(),enemyTank.getY()+60]

                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) {
                            //2.当前坦克的右上角坐标[this.getX()+60,this.getY()]
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                            //3.当前坦克的右下角坐标[this.getX()+60,this.getY()+40]
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 40
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }

                        //如果敌人坦克是右/左
                        //1.如果敌人坦克是右/左 x的范围[enemyTank.getX(),enemyTank.getX()+60]
                        //                  y的范围[enemyTank.getY(),enemyTank.getY()+40]
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
                            //2.当前坦克的右上角坐标[this.getX()+60,this.getY()]
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                            //3.当前坦克的右下角坐标[this.getX()+60,this.getY()+40]
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 60
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2://下
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector中取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较。和自己比较一定碰撞
                    if (enemyTank != this) {
                        //如果敌人坦克是上/下
                        //1.如果敌人坦克是上/下 x的范围[enemyTank.getX(),enemyTank.getX()+40]
                        //                  y的范围[enemyTank.getY(),enemyTank.getY()+60]

                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) {
                            //2.当前坦克的左下角坐标[this.getX(),this.getY()+60]
                            if (this.getX()  >= enemyTank.getX()
                                    && this.getX()  <= enemyTank.getX() + 40
                                    && this.getY()+60 >= enemyTank.getY()
                                    && this.getY()+60 <= enemyTank.getY() + 60) {
                                return true;
                            }
                            //3.当前坦克的右下角坐标[this.getX()+40,this.getY()+60]
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 40
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }

                        //如果敌人坦克是右/左
                        //1.如果敌人坦克是右/左 x的范围[enemyTank.getX(),enemyTank.getX()+60]
                        //                  y的范围[enemyTank.getY(),enemyTank.getY()+40]
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
                            //2.当前坦克的左下角坐标[this.getX(),this.getY()+60]
                            if (this.getX()  >= enemyTank.getX()
                                    && this.getX()  <= enemyTank.getX() + 60
                                    && this.getY() + 60>= enemyTank.getY()
                                    && this.getY() + 60<= enemyTank.getY() + 40) {
                                return true;
                            }
                            //3.当前坦克的右下角坐标[this.getX()+40,this.getY()+60]
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 60
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3://左
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector中取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较。和自己比较一定碰撞
                    if (enemyTank != this) {
                        //如果敌人坦克是上/下
                        //1.如果敌人坦克是上/下 x的范围[enemyTank.getX(),enemyTank.getX()+40]
                        //                  y的范围[enemyTank.getY(),enemyTank.getY()+60]

                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) {
                            //2.当前坦克的左上角坐标[this.getX(),this.getY()]
                            if (this.getX()  >= enemyTank.getX()
                                    && this.getX()  <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                            //3.当前坦克的左下角坐标[this.getX(),this.getY()+40]
                            if (this.getX()  >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }

                        //如果敌人坦克是右/左
                        //1.如果敌人坦克是右/左 x的范围[enemyTank.getX(),enemyTank.getX()+60]
                        //                  y的范围[enemyTank.getY(),enemyTank.getY()+40]
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
                            //2.当前坦克的左上角坐标[this.getX(),this.getY()]
                            if (this.getX()  >= enemyTank.getX()
                                    && this.getX()  <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                            //3.当前坦克的左下角坐标[this.getX(),this.getY()+40]
                            if (this.getX()  >= enemyTank.getX()
                                    && this.getX()  <= enemyTank.getX() + 60
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
        }
        //如果进入到switch语句说明没有发生碰撞返回false
        return false;

    }


    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (true) {
            //这里我们判断如果shots.size()==0,创建一颗子弹放入到
            //shots集合，并启动
            if (isLive && shots.size() <= 5) {//先判断坦克是否存活
                Shot s = null;
                //判断坦克的方向，并创建子弹
                switch (getDirection()) {
                    case 0:
                        s = new Shot(getX() + 20, getY(), 0);
                        break;
                    case 1:
                        s = new Shot(getX() + 60, getY() + 20, 1);
                        break;
                    case 2:
                        s = new Shot(getX() + 20, getY() + 60, 2);
                        break;
                    case 3:
                        s = new Shot(getX(), getY() + 20, 3);
                        break;
                }
                //加入子弹
                shots.add(s);
                //启动
                new Thread(s).start();
            }
            //根据坦克的方向继续移动
            switch (getDirection()) {//顺时针方向
                case 0:
                    for (int i = 0; i < 30; i++) {
                        if (getY()>0&&!isTouchEnemyTank()) {
                            moveUp();
                        }
                        try {
                            //休眠50毫秒
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                        if (getX()+60<1000&&isTouchEnemyTank()) {
                            moveRight();
                        }
                        try {
                            //休眠50毫秒
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        if (getY()+60<750&&!isTouchEnemyTank()) {
                            moveDown();
                        }
                        try {
                            //休眠50毫秒
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        if (getX()>0&&!isTouchEnemyTank()) {
                            moveLeft();
                        }
                        try {
                            //休眠50毫秒
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }
            //随机改变坦克的方向 0-1
            //random取值[0,1)
            setDirection((int) (Math.random() * 4));
//            setDirection(1);
            //写并发程序，一定要想清楚，该线程什么时候线程结束
            if (!isLive) {//当敌方坦克被击中时线程结束，退出线程
                break;
            }
        }
    }
}
