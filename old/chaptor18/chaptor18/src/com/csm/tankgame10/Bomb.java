package com.csm.tankgame10;

/**
 * @Author 快乐小柴
 * @Date 2022/9/9 13:09
 * @Version 1.6
 * 炸弹
 */
public class Bomb {
    int x, y;//炸弹坐标
    int life = 9;//炸弹的生命周期
    boolean isLive = true;//炸弹是否还存活

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //渐少生命值
    public void  lifeDown(){
        if (life>0){
            life--;
        }else {
            isLive=false;

        }

    }
}
