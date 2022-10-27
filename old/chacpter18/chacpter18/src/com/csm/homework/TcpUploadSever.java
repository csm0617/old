package com.csm.homework;

import com.csm.upload.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author 快乐小柴
 * @Date 2022/9/16 16:47
 * @Version 1.0
 */
public class TcpUploadSever {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8926);
        System.out.println("服务端正在在8926监听");
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] buf= new byte[1024];
        int length = 0;
        String downLoadFileName="";
        while ((length=inputStream.read(buf))!=-1){
            downLoadFileName+=new String(buf,0,length);
        }
        System.out.println("客户端想要下载的文件名："+downLoadFileName);
        String resFile="";
        if ("中秋快乐".equals(downLoadFileName)){
            resFile="e:\\中秋快乐.jpg";
        }else {
            resFile="e:\\国庆快乐.jpg";
        }
        BufferedInputStream bis =
                new BufferedInputStream(new FileInputStream(resFile));
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        BufferedOutputStream bos =
                new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        socket.shutdownOutput();
        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}
