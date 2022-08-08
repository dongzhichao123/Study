package com.dongchao.BIO.Three;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("127.0.0.1",9999);
            PrintStream printStream=new PrintStream(socket.getOutputStream());
            Scanner scanner=new Scanner(System.in);
            while(true){
            System.out.println("请说：");
            String msg=scanner.nextLine();
            printStream.println(msg);
            printStream.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
