package com.csm.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author 快乐小柴
 * @Date 2022/9/16 11:39
 * @Version 1.0
 */
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端socket返回="+socket.getClass());
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("客户端打招呼，hello,server 字符流");
        bufferedWriter.newLine();//插入一个换行符，表示写入的内容结束，要求对方使用readline()来读否则不知道写入结束
        bufferedWriter.flush();//!!!如果使用字符流，需要进行一个手动的刷新
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        System.out.println("客户端退出");
    }
}
