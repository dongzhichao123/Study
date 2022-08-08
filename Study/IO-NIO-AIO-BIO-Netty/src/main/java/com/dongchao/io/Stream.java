package com.dongchao.io;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author dong
 * @title: Stream
 * @projectName IO-NIO-AIO-BIO-Netty
 * @description: 文件字节流
 * @date 2022/1/30 23:18
 **/
public class Stream {
    public static void main(String[] args) {

        try {
            File file = new File("D:"+File.separator+"笔记"+File.separator+"IO.txt");

//              FileInputStream fileInputStream=new FileInputStream("D:\\笔记\\IO.txt");
            FileInputStream fileInputStream = new FileInputStream(file);
            int n = -1;
            int len =0;
            byte[] a = new byte[(int) file.length()];
            //int read() 输入流调用该方法从源中读取单个字节的数据，返回值在（0-255）之间，没有为-1
            while ((n=fileInputStream.read()) != -1) {
                a[len]= (byte) n;
                len++;

            }
            System.out.println(new String(a,0,len));
//            while (  fileInputStream.read(a) != -1){
//                String string=new String(a);
//                System.out.println(string);
//            }

            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}