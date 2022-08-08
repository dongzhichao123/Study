package com.dongchao.BIO.File;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * 上传任意类型的文件
 */
public class Client {
    public static void main(String[] args) {
        try {
            //1.请求服务段的Socket链接
            Socket socket = new Socket("127.0.0.1", 8888);
            //2.把字节输出流做一个包装
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            //3.先发送上传文件的后缀给服务端
            dos.writeUTF(".txt");
            //4.把文件数据发送给服务端
            InputStream inputStream = new FileInputStream("D:\\笔记\\IO.txt");
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) > 0) {
                dos.write(buffer, 0, len);
            }
            dos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
