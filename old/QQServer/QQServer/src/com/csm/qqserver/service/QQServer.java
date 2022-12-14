package com.csm.qqserver.service;

import com.csm.qqcommon.Message;
import com.csm.qqcommon.MessageType;
import com.csm.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author 快乐小柴
 * @Date 2022/9/16 21:54
 * @Version 1.0
 * 这是服务器，在监听9527，等待客户端的连接，并保持通信
 */
public class QQServer {
    private ServerSocket ss = null;
    //创建一个集合，存放多个用户，如果是这些用户登录，就认为是合法
    //这里也可以用ConcurrentHashMap，优点是可以处理并发的集合
    //HashMap 没有处理线程安全，因此在多线程情况下是不安全的
    //ConcurrentHashMap处理的线程安全，即线程同步处理，在多线程情况下是安全的
    private static HashMap<String, User> validUsers = new HashMap<>();

    static {
        validUsers.put("100", new User("100", "123456"));
        validUsers.put("200", new User("200", "123456"));
        validUsers.put("300", new User("300", "123456"));
        validUsers.put("至尊宝", new User("至尊宝", "123456"));
        validUsers.put("紫霞仙子", new User("紫霞仙子", "123456"));
        validUsers.put("白晶晶", new User("白晶晶", "123456"));
    }

    //编写一个方法来验证用户
    private boolean checkUser(String UserId, String passwd) {
        User user = validUsers.get(UserId);
        if (user == null) {
            return false;
        }
        if (!user.getPasswd().equals(passwd)) {
            return false;
        }
        return true;
    }

    public QQServer() {
        //注意端口可以写在一个配置文件里
        try {
            System.out.println("服务器端口9527正在监听....");
            ss = new ServerSocket(9527);
            new Thread(new SendNewsToAllService()).start();

            while (true) {//当和某个客户端连接后，会继续监听，因此while
                Socket socket = ss.accept();
                //得到socket关联的对象输入流
                ObjectInputStream ois =
                        new ObjectInputStream(socket.getInputStream());
                //得到socket关联的对象输入流
                ObjectOutputStream oos =
                        new ObjectOutputStream(socket.getOutputStream());
                Message message = new Message();
                User u = (User) ois.readObject();//读取客户端发送的User对象
                //验证客户端发来的登录信息
                if (checkUser(u.getUserId(), u.getPasswd())) {
                    System.out.println("用户 id " + u.getUserId() + "  pwd " + u.getPasswd() + "  验证成功......");

                    //将message的mesType设置为1
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //将message对象回复客户端
                    oos.writeObject(message);
                    //登陆成功，创建一个线程和客户端保持通信，该线程需要持有socket对象
                    ServerConnectClientThread serverConnectClientThread =
                            new ServerConnectClientThread(socket, u.getUserId());

                    //把线程对象，放入到一个集合中，进行管理。
                    ManageClientThread.addClientThread(u.getUserId(), serverConnectClientThread);
                    //启动该线程
                    serverConnectClientThread.start();

                } else {//登录失败
                    System.out.println("用户 id " + u.getUserId() + "  pwd " + u.getPasswd() + "  验证失败......");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    //关闭socket
                    socket.close();
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //如果服务器退出了while循环，说明服务器不再监听了，因此需要关闭ServerSocket
            try {
                ss.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
