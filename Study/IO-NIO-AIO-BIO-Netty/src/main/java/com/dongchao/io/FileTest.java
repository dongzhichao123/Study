package com.dongchao.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dong
 * @title: File
 * @projectName
 * @description: 文件的操作
 * @date 2022/1/301:33
 **/
public class FileTest {

    public static void main(String[] args) {

        File file = new File("D:\\笔记\\IO.txt");
        //获取文件名称
        System.out.println(file.getName());
        //获取文件大小
        System.out.println(file.getTotalSpace());
        //判断文件是否可读
        System.out.println("文件是否可读:" + file.canRead());
        //判断文件是否存在
        System.out.println("文件是否存在:" + file.exists());
        //判断文件是否是一个文件
        System.out.println("文件是否是一个文件：" + file.isFile());
        //获取文件的父目录
        System.out.println("文件的父目录：" + file.getParent());
        //判断是否是一个目录
        System.out.println("文件是否是一个目录：" + file.isDirectory());
        //获取文件最后的更新时间
        System.out.println("文件的最后更新时间:" + file.lastModified());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:dd:ss");
        String data = dateFormat.format(new Date(file.lastModified()));
        if (!data.isEmpty()) {
        System.out.println("文件的最后更新时间(格式化化):" + data);
        }

        //如果文件不存在创建一个文件
        if (!file.exists()) {
            try {
                file.createNewFile();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
