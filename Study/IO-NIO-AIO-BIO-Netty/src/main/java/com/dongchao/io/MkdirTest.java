package com.dongchao.io;

import java.io.*;
/**
 * @author dong
 * @title: MkdirTest
 * @projectName IO-NIO-AIO-BIO-Netty
 * @description: TODO
 * @date 2022/1/3023:03
 **/
public class MkdirTest {

    public static void main(String[] args) {
        File file = new File(".");
        getFileList(file);

    }

    public static void  getFileList(File file) {
        File[] list=file.listFiles();
        for (File file1 : list) {
            if (file1.isDirectory()) {
                System.out.println("文件夹：" + file1.getName());
                getFileList(file1);
            } else {
                System.out.println("文件：" + file1.getName());
            }
        }
    }
}
