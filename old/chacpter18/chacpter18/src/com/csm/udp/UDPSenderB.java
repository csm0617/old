package com.csm.udp;

import java.io.IOException;
import java.net.*;

/**
 * @Author 快乐小柴
 * @Date 2022/9/16 16:02
 * @Version 1.0
 */
public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        //发送端也可以成为接收端，用来结收数据，所以要新建一个端口来接收数据，不是用来发送的！！！
        DatagramSocket socket = new DatagramSocket(9998);
        byte[] data = "hello,明天你好！".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("127.0.0.1"), 9999);
        socket.send(packet);
        socket.close();
        System.out.println("B端退出");
    }
}
