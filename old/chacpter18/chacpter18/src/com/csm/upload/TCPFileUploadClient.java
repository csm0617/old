package com.csm.upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Author 快乐小柴
 * @Date 2022/9/16 14:37
 * @Version 1.0
 */
public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {
        //客户端连接8888窗口，得到socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //创建读取磁盘文件的输入流
        String filePath="e:\\hjj.jpg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        //bytes就是filePath文件对应的字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //通过socket获取到输入流中，将bytes数据发送给服务器端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);//将文件对应的字节数组的内容，写入到数据通道；
        socket.shutdownOutput();//设置写入结束标志!!!!!!!!!!写完后紧跟着写结束标志
        //==========
        InputStream inputStream = socket.getInputStream();
        //使用StreamUtils工具类的方法，直接将inputStream读取到的内容转成字符串；
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);
        bos.close();
        //关闭相关的流
        bis.close();
        socket.close();






   }
}
