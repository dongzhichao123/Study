package com.dongchao.io;

import javax.xml.stream.XMLInputFactory;
import java.io.*;

/**
 * 缓冲区读取文件
 */
public class BufferClass {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\笔记\\IO.txt"), "UTF-8"));
        while (bufferedReader.read() != -1) {
//            System.out.println(bufferedReader.read());

            System.out.println(bufferedReader.readLine());
        }
    }
}
