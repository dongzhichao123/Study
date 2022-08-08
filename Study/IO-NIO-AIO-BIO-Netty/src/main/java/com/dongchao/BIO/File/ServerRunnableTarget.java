package com.dongchao.BIO.File;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

public class ServerRunnableTarget implements Runnable {

    private Socket socket;

    public ServerRunnableTarget(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            //读取客户端发送的文件类型
            String Suffix = inputStream.readUTF();
            //定义一个字节输出管道
            OutputStream outputStream = new FileOutputStream("E:\\服务器文件\\" + UUID.randomUUID().toString() + Suffix);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream  .read(bytes)) > 0) {
                outputStream.write(bytes, 0, len);
            }
            outputStream.close();
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//            String msg = null;
//            while ((msg = bufferedReader.readLine()) != null) {
//                System.out.println(Thread.currentThread().getName() + ":" + msg);
//
//            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
