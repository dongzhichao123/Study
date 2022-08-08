package com.dongchao.BIO.BIO_TWO;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        //创建socket
        try {
            Socket socket = new Socket("127.0.0.1", 9999);
            //从socket对象获取一个字节输出流
            OutputStream outputStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
//            printStream.println("hello world");
//            printStream.flush();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("请说：");
                String msg = scanner.nextLine();
                printStream.println(msg);
                printStream.flush();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
