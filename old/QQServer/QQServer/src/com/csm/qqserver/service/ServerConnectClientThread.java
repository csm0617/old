package com.csm.qqserver.service;

import com.csm.qqcommon.Message;
import com.csm.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @Author 快乐小柴
 * @Date 2022/9/16 22:35
 * @Version 1.0
 * 该类的一个对象和某个客户端保持通信
 */
public class ServerConnectClientThread extends Thread {

    private Socket socket;
    private String userId;//连接到服务端的用户id

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {//这里线程处于run状态，可以发送/接收消息
        while (true) {
            try {
                System.out.println("服务器和客户端" + userId + "保持通信，读取数据...");
                ObjectInputStream ois =
                        new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                //后面会使用message,根据message类型，做对应的业务处理

                //客户要求在线用户列表
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    //用户在线列表的形式  紫霞仙子 至尊宝 白晶晶 菩提老祖
                    System.out.println(message.getSender() + "  请求用户列表....");
                    String onlineUser = ManageClientThread.getOnlineUser();

                    // 拿到用户列表以后要构建一个message 对象，返回给客户端
                    Message message2 = new Message();
                    message2.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message2.setContent(onlineUser);
                    message2.setGetter(message.getSender());
                    //创建socket输出流返回给客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message2);
                }
                if (message.getMesType().equals(MessageType.MESSAGE_COM_MES)) {
                    //根据message获取getterId,然后得到对应线程
                    ServerConnectClientThread serverConnectClientThread = ManageClientThread.getServerConnectClientThread(message.getGetter());
                    //得到对应的socket的对象输出流，将 message对象转发给指定的客户端
                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);//提示：如果用户不在线，这里可以去实现一个离线转发的功能，可以先保存到数据库中，再进行转发
                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
                    System.out.println(message.getSender() + "  退出...");
                    //将这个客户端对应的线程从集合中删除
                    //通过获取发送的退出客户端请求的getSender  绑定userId的方式从集合删除
                    ManageClientThread.removeServerClientThread(message.getSender());
                    //移除后关闭连接
                    socket.close();
                    //退出线程
                    break;
                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
                    //需要遍历  管理线程的集合，所有线程的socket都得到，然后把message进行转发即可
                    HashMap<String, ServerConnectClientThread> hm = ManageClientThread.getHm();
                    //把keySet取出来用迭代器进行遍历
                    Iterator<String> iterator = hm.keySet().iterator();
                    while (iterator.hasNext()) {
                        //取出在线用户的userId
                        String onlineUserId = iterator.next().toString();

                        if (!onlineUserId.equals(message.getSender())) {//群发消息时排除发送者自己

                            //进行转发message
                            ObjectOutputStream oos = new ObjectOutputStream(hm.get(onlineUserId).getSocket().getOutputStream());
                            oos.writeObject(message);
                        }
                    }

                } else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {
                    //根据getterId获取到对应的线程，将message对象转发
                    ServerConnectClientThread serverConnectClientThread = ManageClientThread.getServerConnectClientThread(message.getGetter());
                    ObjectOutputStream oos =
                            new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);
                }
                //

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
