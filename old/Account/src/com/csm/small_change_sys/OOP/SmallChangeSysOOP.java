package com.csm.small_change_sys.OOP;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSysOOP {

    boolean loop = true;
    double money = 0;
    double balance = 0;
    String note;
    String choice = "";
    String details = "\n--------------零钱通明细--------------";
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    Scanner scanner = new Scanner(System.in);
    public void ShowMenu() {
            do {
                System.out.println("-----------零钱通菜单-----------");
                System.out.println("\t\t\t\t1.零钱通明细");
                System.out.println("\t\t\t\t2.收益入帐");
                System.out.println("\t\t\t\t3.消费");
                System.out.println("\t\t\t\t4.退出");
                System.out.println("请输入1-4：");
                String key = scanner.next();
                switch (key){
                    case "1":
                        Details();
                        break;
                    case "2":
                        Income();
                        break;
                    case "3":
                        Consume();
                        break;
                    case "4":
                        Exit();
                        break;
                }

            } while (loop);
    }

    public void Details() {
        System.out.println(details);
    }

    public void Income() {
        System.out.println("收益入账金额：");
        money = scanner.nextDouble();
        if (money < 0) {
            System.out.println("收益金额应该大于0！！！");
            return;
        }
        balance += money;
        date = new Date();
        details += "\n" + "收益入账" + "\t+" + money + "\t" + sdf.format(date) + "\t余额\t" + balance;
        return;
    }

    public void Consume() {
        System.out.println("==========消费============");
        System.out.println("消费金额");
        money = scanner.nextDouble();
        if (money < 0 || money > balance) {
            System.out.println("消费必须大于0，且小于余额！！！");
            return;
        }
        System.out.println("消费说明");
        note = scanner.next();
        balance -= money;
        details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t余额\t" + balance;
        return;
    }

    public void Exit() {
        System.out.println("请确认是否退出零钱通 y/n？");
        choice = scanner.next();
        if ("y".equals(choice)) {
            loop = false;
            System.out.println("========零钱通已退出=======");
            return;
        }
    }
}
