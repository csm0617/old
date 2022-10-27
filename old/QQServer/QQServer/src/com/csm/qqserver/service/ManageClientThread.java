package com.csm.qqserver.service;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @Author 快乐小柴
 * @Date 2022/9/16 23:47
 * @Version 1.0
 * 该类用于管理和客户端通信的线程
 */
public class ManageClientThread {
    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();

    public static HashMap<String, ServerConnectClientThread> getHm() {
        return hm;
    }

    //添加线程对象到hm集合
    public static void addClientThread(
            String userId, ServerConnectClientThread serverConnectClientThread) {

        hm.put(userId, serverConnectClientThread);

    }

    //从hm集合中移除服务端和客户端保持通信的某个线程对象
    public static void removeServerClientThread(String userId) {
        hm.remove(userId);
    }

    //根据userId返回ServerConnectClientThread线程
    public static ServerConnectClientThread getServerConnectClientThread(String userId) {
        return hm.get(userId);
    }

    //返回用户在线列表
    public static String getOnlineUser() {
        //集合遍历，遍历HashMap的key

        //使用迭代器iterator的方式遍历HashMap取出key，即userId
        Iterator<String> iterator = hm.keySet().iterator();
        String onlineUserList = "";

        while (iterator.hasNext()) {
            onlineUserList += iterator.next().toString() + " ";
        }
        return onlineUserList;
    }

}
