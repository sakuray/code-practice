package com.sakuray.code.practice.jdk.io;

import org.junit.Test;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;

public class FileDescriptorTest {

    @Test
    public void test() throws IOException {
        FileDescriptor descriptor = new FileDescriptor();
        FileInputStream fis = new FileInputStream(descriptor);
        try {
            System.out.println(fis.read());
        } catch (IOException e) {
            System.out.println("fis执行异常");
        }
        String path = this.getClass().getResource("test.txt").getPath();
        File file = new File(path);
        fis = new FileInputStream(file);
        descriptor = fis.getFD();
        FileInputStream nfis = new FileInputStream(descriptor);
        System.out.println("nfis>>>"+nfis.read());
        FileInputStream sfis = new FileInputStream(descriptor);
        System.out.println("sfis>>>"+sfis.read());
        System.out.println("nfis>>>"+nfis.read());
        nfis.close();
        try {
            System.out.println("sfis>>>"+sfis.read());
        } catch(Exception e) {
            System.out.println("nfis执行异常");
        }
        sfis.close();
        fis.close();
    }
}
