package com.sakuray.code.practice.jdk.io;

import org.junit.Test;

import java.io.*;

public class OtherStream {

    @Test
    public void test() throws IOException {
        System.out.println("123\r汗😰2\t\n456\r\n789\r\n");
        ByteArrayInputStream bais = new ByteArrayInputStream("123\r汗😰2\t\n456\r\n789\r\n".getBytes());
        LineNumberInputStream lnis = new LineNumberInputStream(bais);
        byte[] buffer = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int length;
        while((length = lnis.read(buffer)) != -1) {
            baos.write(buffer, 0, length);
        }
        System.out.println(new String(baos.toByteArray()));
        System.out.println(lnis.getLineNumber());
    }

    @Test
    public void test2() throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream("你好".getBytes());
        ByteArrayInputStream bais2 = new ByteArrayInputStream(",张三".getBytes());
        SequenceInputStream sis = new SequenceInputStream(bais, bais2);
        byte[] buffer = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int length;
        while((length = sis.read(buffer)) != -1) {
            baos.write(buffer, 0, length);
        }
        System.out.println(new String(baos.toByteArray()));
    }

    @Test
    public void test3() {
        byte[] a = new byte[]{-1};
        ByteArrayInputStream bis = new ByteArrayInputStream(a);
        System.out.println(bis.read());
        System.out.println((byte)bis.read());
    }
}
