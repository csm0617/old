package com.csm.tankgame17;

public class Tank {
    private int x;//坦克的横坐标
    private int y;//坦克的纵坐标
    private int direction;//坦克的方向0上1右2下3左
    private int speed = 2;
    boolean isLive=true;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void moveUp() {
        if (getY()>0) {
            y -= speed;
        }
    }

    public void moveDown() {
        if (getY()+110<750){
            y += speed;
        }
    }

    public void moveRight() {
        if (getX()+80<1000){
            x += speed;
        }
    }

    public void moveLeft() {
        if (getX()>0) {
            x -= speed;
        }
    }
}
