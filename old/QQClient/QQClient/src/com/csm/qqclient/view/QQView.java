package com.csm.qqclient.view;

import com.csm.qqclient.service.FileClientService;
import com.csm.qqclient.service.ManageClientConnectServerThread;
import com.csm.qqclient.service.MessageClientService;
import com.csm.qqclient.service.UserClientService;

import java.*;
import java.util.Scanner;

/**
 * @Author 快乐小柴
 * @Date 2022/9/16 19:25
 * @Version 1.0
 * 客户端的菜单界面
 */
public class QQView {
    //控制是否显示菜单
    private boolean loop = true;
    //接受用户的键盘输入
    private String key = "";
    //该对象用于登录服务/注册用户
    private UserClientService userClientService = new UserClientService();
    //该对象用于户信息的私聊群聊
    private MessageClientService messageClientService = new MessageClientService();
    // 该对象用于传输文件
    private FileClientService fileClientService=new FileClientService();

    public static void main(String[] args) {
        new QQView().mainMenu();
        System.out.println("客户端退出系统.......");
    }

    //显示菜单
    private void mainMenu() {
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("==================欢迎登录QQ==================");
            System.out.println("\t\t1  登录系统");
            System.out.println("\t\t9  退出系统");
            System.out.println("请输入你的选择:");

//

            key = scanner.next();
            switch (key) {

                case "1":
                    System.out.print("请输入用户号：");
                    String userId = scanner.next();
                    System.out.print("请输入密  码：");
                    String pwd = scanner.next();
                    //需要到服务端验证是否合法
                    if (userClientService.checkUser(userId, pwd)) {
                        System.out.println("============欢迎(用户" + userId + "登录成功)=============");
                        //进入到二级菜单
                        while (loop) {
                            System.out.println("============QQ二级菜单欢迎(用户" + userId + ")=============");
                            System.out.println("\t\t1 显示在线用户列表");
                            System.out.println("\t\t2 群发消息");
                            System.out.println("\t\t3 私聊消息");
                            System.out.println("\t\t4 发送文件");
                            System.out.println("\t\t9 退出系统");
                            System.out.println("请输入你的选择:");
                            key = scanner.next();
                            switch (key) {
                                case "1":
                                    userClientService.onlineFriendList();
                                    System.out.println("显示在线用户列表");

                                    break;
                                case "2":
                                    System.out.println("请输入想对大家说的话");
                                    String words =scanner.next();
                                    //调用一个方法，将消息封装成一个message对象
                                    messageClientService.sendMessageToAll(words,userId);
                                    break;
                                case "3":
                                    System.out.println("\t\t 请输入想要聊天的用户号（在线）：");
                                    String getterId = scanner.next();
                                    System.out.println("\t\t 请输入想说的话");
                                    String content = scanner.next();
                                    //调用方法，将私聊的信息发送给服务端
                                    messageClientService.sendMessageToOne(content, userId, getterId);
                                    break;
                                case "4":
                                    System.out.println("\t\t 请输入你想把文件发送给哪个（在线）用户：");
                                    getterId=scanner.next();
                                    System.out.println("请输入发送文件的路径（形式 d:\\xx.jpg）");
                                    String src =scanner.next();
                                    System.out.println("请输入把文件发送到哪个位置（形式 d:\\xx.jpg）");
                                    String dest =scanner.next();
                                    fileClientService.sendFileToOne(src,dest,userId,getterId);
                                    break;
                                case "9":
                                    //调用方法，给服务器发送一个退出系统的message
                                    userClientService.logout();
                                    loop = false;
                                    break;
                            }
                        }

                    } else {
                        System.out.println("登录失败");
                    }
                    break;
                case "9":
                    System.out.println("退出系统");
                    break;
            }

        }
    }
}
