package com.csm.socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

/**
 * @Author 快乐小柴
 * @Date 2022/9/16 11:34
 * @Version 1.0
 */
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器在端口9999监听，等待连接。。。");
        Socket socket = serverSocket.accept();
        System.out.println("服务器端socket="+socket.getClass());
        InputStream inputStream = socket.getInputStream();
        byte[] buf =new byte[1024];
        int readLen=0;

        while ((readLen=inputStream.read(buf))!=-1){

            System.out.println(new String(buf,0,readLen));
        }
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,client，字节流".getBytes());
        socket.shutdownOutput();
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
