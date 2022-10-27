package com.csm.qqclient.service;

import com.csm.qqcommon.Message;
import com.csm.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @Author 快乐小柴
 * @Date 2022/9/17 10:58
 * @Version 1.0
 */

public class MessageClientService {

    public void sendMessageToAll(String content,String senderId){
        //构建message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_TO_ALL_MES);//群发消息类型
        message.setSender(senderId);//发送者的
        message.setContent(content);//消息内容
        message.setSendTime(new Date().toString());//消息发送时间
        System.out.println(senderId + " 对 大家说" + " 说 " + content);

        //发送给服务端
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(
                            ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void sendMessageToOne(String content, String senderId, String getterId) {
        //构建message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COM_MES);//普通的聊天消息类型
        message.setSender(senderId);//发送者的
        message.setGetter(getterId);//接收者的
        message.setContent(content);//消息内容
        message.setSendTime(new Date().toString());//消息发送时间
        System.out.println(senderId + " 对 你" + " 说 " + content);

        //发送给服务端
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(
                            ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
