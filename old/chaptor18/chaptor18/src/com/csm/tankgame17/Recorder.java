package com.csm.tankgame17;

import java.io.*;

/**
 * @Author 快乐小柴
 * @Date 2022/9/16 9:34
 * @Version 1.0
 */
public class Recorder {
    //定义被击中的敌人坦克数量
    private static int allEnemyTankNum=0;
    //定义IO对象，准备写入到文件中
    private static FileWriter fw=null;
    private static BufferedWriter bw =null;
    private static String recordFile ="e:\\myRecord.txt";

    public static void keepRecord(){
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(allEnemyTankNum);
            bw.newLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (bw!=null) {
                    bw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static int getAllEnemyTankNum(){
        return allEnemyTankNum;
    }
    public static void setAllEnemyTankNum(int allEnemyTankNum){
        Recorder.allEnemyTankNum =allEnemyTankNum;
    }
    //当我方坦克机会一个敌人坦克，就应当allEnemyTankNum++
    public static void addAllEnemyTankNum(){
        Recorder.allEnemyTankNum++;
    }
}
