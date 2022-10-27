package com.csm.qqclient.service;

import com.csm.qqcommon.Message;
import com.csm.qqcommon.MessageType;
import jdk.net.Sockets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @Author 快乐小柴
 * @Date 2022/9/16 21:07
 * @Version 1.0
 * 创建一个客户端连接服务线程
 */
public class ClientConnectServerThread extends Thread {
    //该线程需要持有Socket
    private Socket socket;

    //该构造器可以接收一个Socket对象
    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //因为Thread需要一直和后台通信，因此我们while循环
        while (true) {
            try {
                System.out.println("客户端线程,等待读取从服务器端发送的消息");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //如果服务器没有发送Message对象，线程会阻塞在这里。
                Message message = (Message) ois.readObject();//注意后面会用到这个Message

                //判断这个Message类型，然后做对应的业务处理
                //如果读取到的是  服务端返回的在线用列表
                if (message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {
                    //取出在线用户的列表并显示
                    //规定
                    System.out.println("\n========当前在线用户列表=========");
                    String[] onlineUsers = message.getContent().split(" ");
                    for (int i = 0; i < onlineUsers.length; i++) {
                        System.out.println("用户： " + onlineUsers[i]);
                    }
                } else if (message.getMesType().equals(MessageType.MESSAGE_COM_MES)) {
                    //把从服务器转发的消息，显示到控制台即可
                    System.out.println("\n" + message.getSender() +
                            " 对 " + message.getGetter() + " 说 " + message.getContent());
                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)){
                    //显示在客户端的的控制台
                    System.out.println("\n"+message.getSender()+"  对大家说  "+message.getContent());
                }else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)){
                    System.out.println("\n"+message.getSender()+" 给 "+message.getGetter()+" 发文件："+message.getSrc()+" 到我的电脑的目录 "+message.getDest());
                    //取出message的字节文件数组，通过文件输出流写出到磁盘
                    FileOutputStream fileOutputStream = new FileOutputStream(message.getDest());
                    fileOutputStream.write(message.getFileBytes());
                    fileOutputStream.close();// flush或者close才能关闭流，将文件写入
                    System.out.println("\n======保存文件成功！======");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    //为了方便得到Socket
    public Socket getSocket() {
        return socket;
    }

}
