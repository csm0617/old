package com.csm.qqclient.service;

import com.csm.qqcommon.Message;
import com.csm.qqcommon.MessageType;
import com.csm.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author 快乐小柴
 * @Date 2022/9/16 20:34
 * @Version 1.0
 * 该类完成用户登录验证和用户注册功能
 */
public class UserClientService {
    //因为在其他敌方可能用到user信息，因此作出成员属性
    private User u = new User();
    //因为Socket在其他敌方也可能使用，因此作出属性
    private Socket socket;

    //根据uerId和pwd到服务器验证该用户是否合法
    public boolean checkUser(String uerId, String pwd) {
        boolean b = false;
        //创建User对象
        u.setUserId(uerId);
        u.setPasswd(pwd);

        try {
            //连接到服务端，发送u对象
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9527);
            //得到一个ObjectOutputStream的对象
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);//发送User对象

            //读取从服务器回复的Message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();

            if (ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {//成功登录
                //创建一个和服务器保持通信的线程->创建一个类ClientConnectServerThread
                ClientConnectServerThread clientConnectServerThread =
                        new ClientConnectServerThread(socket);
                //启动客户端线程
                clientConnectServerThread.start();
                //这里为了后面客户端的扩展，我们将线程放入到集合管理
                ManageClientConnectServerThread.addClientConnectServerThread(
                        uerId, clientConnectServerThread);

                b = true;
                //等待
            } else {
                //如果登录失败，我们就不能启动和服务器通信的线程，关闭socket
                socket.close();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //
        return b;
    }

    //项服务器端请求在线用户列表
    public void onlineFriendList() {
        //发送一个message,类型为MESSAGE_GET_ONLINE_FRIEND
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserId());

        //发送给服务器，

        try {
            //从管理线程的集合中，通过u.getUserId()，得到这个线程对象
            ClientConnectServerThread clientConnectServerThread = ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId());
            //通过这个线程得到关联的socket
            Socket socket = clientConnectServerThread.getSocket();
            //得到当前线程的Socket对应的ObjectOutputStream对象
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            //发送一个message对象，向服务端请求在线用户列表
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //编写一个方法，退出客户端。
    public void logout() {
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserId());//因为要退出客户端，所以要指明是哪个客户端id

        //发送message
        try {
            //创建socket输出流
            //第一种
//            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectOutputStream oos =
                    new ObjectOutputStream(
                            ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());

            oos.writeObject(message);

            System.out.println(u.getUserId() + "  退出了系统");
            System.exit(0);//结束进程
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
