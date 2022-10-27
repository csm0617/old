package com.csm.udp;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Author 快乐小柴
 * @Date 2022/9/16 16:02
 * @Version 1.0
 */
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(9999);

        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        System.out.println("接受端A 等待接收数据......");
        socket.receive(packet);//阻塞和tcp的accept方法一样
        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);
        System.out.println("A端退出......");


    }
}
