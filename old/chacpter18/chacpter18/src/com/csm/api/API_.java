package com.csm.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author 快乐小柴
 * @Date 2022/9/16 11:13
 * @Version 1.0
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
//        InetAddress[] allByName = InetAddress.getAllByName("www.baidu.com");
//        System.out.println(allByName);
        String hostAddress = localHost.getHostAddress();
        System.out.println(hostAddress);
    }
}
