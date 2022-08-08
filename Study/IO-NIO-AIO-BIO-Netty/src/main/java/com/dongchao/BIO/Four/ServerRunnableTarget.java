package com.dongchao.BIO.Four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerRunnableTarget implements Runnable {

    private Socket socket;

    public ServerRunnableTarget(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String msg = null;
            while ((msg = bufferedReader.readLine()) != null) {
                System.out.println(Thread.currentThread().getName() + ":" + msg);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
