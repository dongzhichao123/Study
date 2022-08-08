package com.dongchao.io;

import java.io.*;

public class WriterAndRead {
    public static void main(String[] args) {
        Read();
    }

    public static void Writer() {

        File f = new File("D:" + File.separator + "笔记" + File.separator + "WriterAndRead.txt");
        Writer writer = null;
        try {
            writer = new FileWriter(f, true);
            writer.write("追加内容");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void Read() {

        File f = new File("D:" + File.separator + "笔记" + File.separator + "WriterAndRead.txt");
            Reader read = null;
        try {
            read = new FileReader(f);
            char c[]=new char[(int) f.length()];
            read.read(c);
            read.close();
            System.out.println(c);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
