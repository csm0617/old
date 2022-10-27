package com.csm.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Author 快乐小柴
 * @Date 2022/9/10 12:08
 * @Version 1.0
 */
public class FileCreat {
    public static void main(String[] args) {

    }
    @Test
    public void fileCreat(){
        String filePath ="e:\\news1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
