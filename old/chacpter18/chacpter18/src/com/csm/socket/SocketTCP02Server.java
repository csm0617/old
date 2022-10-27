package com.csm.socket;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author 快乐小柴
 * @Date 2022/9/16 11:34
 * @Version 1.0
 */
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器在端口9999监听，等待连接。。。");
        Socket socket = serverSocket.accept();
        System.out.println("服务器端socket="+socket.getClass());
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("服务端打招呼，hello,client 字符流");
        bufferedWriter.newLine();//写入结束标志！！！！！！！
        bufferedWriter.flush();
        bufferedWriter.close();
        socket.close();
        serverSocket.close();
    }
}
