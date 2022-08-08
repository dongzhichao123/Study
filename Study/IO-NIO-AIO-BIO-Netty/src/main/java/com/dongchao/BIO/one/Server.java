package com.dongchao.BIO.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * <p>
 * 客户端发送消息，服务端接收消息
 */
public class Server {
    public static void main(String[] args) {
        try {
            //定义一个serversocket对象进行服务端的端口的注册
            ServerSocket ss = new ServerSocket(999);
            //监听客户段的socket的链接情趣
            Socket socket = ss.accept();
            //从socket
            InputStream inputStream = socket.getInputStream();
            //把字节输入流包装成一个缓冲字节输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String msg = null;
            while ((msg = br.readLine()) != null) {
                System.out.println("服务端接收到的消息：" + msg);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
