package com.csm.qqclient.service;

import java.util.HashMap;

/**
 * @Author 快乐小柴
 * @Date 2022/9/16 21:28
 * @Version 1.0
 * 该类管理客户端连接到服务器端的线程的类
 */
public class ManageClientConnectServerThread {
    //我们把多个线程放入到一个HashMap集合中，key就是用户id，value就是线程
    private static HashMap<String, ClientConnectServerThread> hm = new HashMap<>();

    //将某个线程加入到集合
    public static void addClientConnectServerThread(
            String userId, ClientConnectServerThread clientConnectServerThread) {

        hm.put(userId, clientConnectServerThread);
    }

    public static ClientConnectServerThread getClientConnectServerThread(String userId) {
        return hm.get(userId);
    }

}
