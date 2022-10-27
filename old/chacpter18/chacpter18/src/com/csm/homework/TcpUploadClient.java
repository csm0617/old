package com.csm.homework;

import com.csm.upload.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author 快乐小柴
 * @Date 2022/9/16 17:12
 * @Version 1.0
 */
public class TcpUploadClient {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入下载文件名：");
        String downloadFileName = scanner.next();
        Socket socket = new Socket(InetAddress.getLocalHost(), 8926);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(downloadFileName.getBytes());
        socket.shutdownOutput();

        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        String filePath="d:\\" + downloadFileName +".jpg";
        BufferedOutputStream bos =
                new BufferedOutputStream(new FileOutputStream(filePath));
        bos.write(bytes);


        bos.close();
        bis.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端已完全退出");


    }
}
