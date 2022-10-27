package com.csm.qqclient.service;

import com.csm.qqcommon.Message;
import com.csm.qqcommon.MessageType;

import java.io.*;

/**
 * @Author 快乐小柴
 * @Date 2022/9/17 17:47
 * @Version 1.0
 * 该类/对象完成 文件传输服务
 */
public class FileClientService {
    public void sendFileToOne(String src,String dest,String senderId,String getterId){
        //读取src文件  ————>message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_FILE_MES);
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setSrc(src);
        message.setDest(dest);

        //需要将文件读取
        FileInputStream fileInputStream=null;
        byte[] fileBytes =new byte[(int) new File(src).length()];

        try {
            fileInputStream =new FileInputStream(src);
            fileInputStream.read(fileBytes);//将src文件读入到程序的字节数组
            //将文件对应的字节数组设置message
            message.setFileBytes(fileBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            if (fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        System.out.println("\n"+senderId+" 给 " +getterId+" 发送文件 "+src
        +" 到对方对方电脑的电脑目录 "+ dest);
        //发送
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
