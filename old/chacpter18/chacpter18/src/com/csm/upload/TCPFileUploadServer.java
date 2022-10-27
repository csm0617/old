package com.csm.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author 快乐小柴
 * @Date 2022/9/16 14:36
 * @Version 1.0
 */
public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {
        //1.服务段在本机监听8888窗口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务员在8888窗口监听......");
        //2.等待连接
        Socket socket = serverSocket.accept();
        //3.读取客户端发送的数据
        //通过socket得到输入流
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes=StreamUtils.streamToByteArray(bis);
        //将得到得bytes数组写入到，指定得路径，就得到一个文件
        String destFilePath="src\\hjj.jpg";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);
        bos.close();
        //向客户端回复“收到图片”
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("收到图片");
        bw.flush();//把内容书信到数据通道
        socket.shutdownOutput();
        bw.close();

        //关闭其他资源
        bis.close();
        socket.close();
        serverSocket.close();//服务端会比客户端多一个serverSocket
    }
}
