package com.csm.small_change_sys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangSys {
    public static void main(String[] args) {

        boolean loop = true;
        double money = 0;
        double balance = 0;
        String note;
        String choice = "";

        String details = "\n--------------零钱通明细--------------";
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        do {

            System.out.println("-----------零钱通菜单-----------");
            System.out.println("\t\t\t\t1.零钱通明细");
            System.out.println("\t\t\t\t2.收益入帐");
            System.out.println("\t\t\t\t3.消费");
            System.out.println("\t\t\t\t4.退出");
            System.out.println("请输入1-4：");
            Scanner scanner = new Scanner(System.in);
            String key = scanner.next();
            switch (key) {
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.println("收益入账金额：");
                    money = scanner.nextDouble();
                    if (money < 0) {
                        System.out.println("收益金额应该大于0！！！");
                        break;
                    }
                    balance += money;
                    date = new Date();
                    details += "\n" + "收益入账" + "\t+" + money + "\t" + sdf.format(date) + "\t余额\t" + balance;
                    break;
                case "3":
                    System.out.println("==========消费============");
                    System.out.println("消费金额");
                    money = scanner.nextDouble();
                    if (money < 0 || money > balance) {
                        System.out.println("消费必须大于0，且小于余额！！！");
                        break;
                    }
                    System.out.println("消费说明");
                    note = scanner.next();
                    balance -= money;
                    details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t余额\t" + balance;
                    break;
                case "4":
                    System.out.println("请确认是否退出零钱通 y/n？");
                    choice = scanner.next();
                    if ("y".equals(choice)) {
                        loop = false;
                        System.out.println("========零钱通已退出=======");
                        break;
                    }
            }
        } while (loop);
    }
}