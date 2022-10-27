package com.csm.tankgame6;

import java.util.Vector;

/**
 * @Author 快乐小柴
 * @Date 2022/9/8 22:35
 * @Version 1.0
 */
public class EnemyTank extends Tank {
    //在敌人坦克类，使用Vector 保存多个Shot
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;
    public EnemyTank(int x, int y) {
        super(x, y);
    }
}
