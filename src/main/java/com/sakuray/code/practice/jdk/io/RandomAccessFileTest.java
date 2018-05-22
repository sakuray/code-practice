package com.sakuray.code.practice.jdk.io;

import org.junit.Test;

import java.io.*;

public class RandomAccessFileTest {

    @Test
    public void test() throws IOException {
        String path = getClass().getResource("").getPath();
        String filePath = path+"test.txt";
        File file = new File(filePath);
        if(file.exists()) {
            file.delete();
            file.createNewFile();
        } else {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        fos.write("0123456789".getBytes());
        fos.flush();
        fos.close();
        RandomAccessFile accessFile = new RandomAccessFile(filePath, "rw");
        accessFile.seek(2);
        System.out.println((char)accessFile.read());
        accessFile.seek(4);
        System.out.println((char)accessFile.read());
        accessFile.write("abcd".getBytes());
        accessFile.close();
        FileReader reader = new FileReader(filePath);
        int length;
        char[] buffer = new char[1024];
        StringWriter writer = new StringWriter();
        while((length = reader.read(buffer))!=-1) {
            writer.write(buffer, 0, length);
        }
        System.out.println(writer.toString());
        reader.close();
        writer.close();
    }
}
