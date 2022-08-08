package com.dongchao.BIO.File;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端，实现接受客户段的任意类型的文件，并保存在服务段
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            while (true) {
                Socket socket = ss.accept();
                ServerReaderThread serverReaderThread = new ServerReaderThread(6, 10);
                Runnable runnable = new ServerRunnableTarget(socket);
                serverReaderThread.execute(runnable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
