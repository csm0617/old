package com.csm.qqserver.service;

import com.csm.qqcommon.Message;
import com.csm.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @Author 快乐小柴
 * @Date 2022/9/17 20:26
 * @Version 1.0
 */
public class SendNewsToAllService implements Runnable {

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        //为了可以推送多次新闻
        while (true) {

            System.out.println("请输入服务器要推送的新闻/消息(输入exit表示退出消息推送服务线程)");
            String news = scanner.next();
            if ("exit".equals(news)) {
                break;
            }
            Message message = new Message();
            message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
            message.setSender("服务器");
            message.setContent(news);
            message.setSendTime(new Date().toString());
            System.out.println("服务器推送消息给所有人 说：" + news);

            HashMap<String, ServerConnectClientThread> hm = ManageClientThread.getHm();
            Iterator<String> iterator = hm.keySet().iterator();
            while (iterator.hasNext()) {
                String onlineUserId = iterator.next().toString();
                ObjectOutputStream oos =
                        null;
                try {
                    oos = new ObjectOutputStream(hm.get(onlineUserId).getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

        }
    }
}
