package com.dongchao.BIO.Four;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 开发实现伪异步通信架构
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(9999);
            //初始话线程池对象
            HandleSocketServerPool pool = new HandleSocketServerPool(6, 10);

            while (true) {
                Socket socket1 = socket.accept();
                //把socket交给线程池进行处理
                Runnable target = new ServerRunnableTarget(socket1);
                pool.execute(target);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
