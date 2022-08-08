package com.dongchao.BIO.Three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThreadReader extends Thread{
    private Socket socket;
    ServerThreadReader(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        try {
            InputStream inputStream=socket.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String msg;
            while ((msg=bufferedReader.readLine())!=null){
                System.out.println(Thread.currentThread().getName()+":"+msg);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
