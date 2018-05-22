package com.sakuray.code.practice.jdk.io;

import org.junit.Test;

public class FileSystemTest {

    @Test
    public void test() {
        System.out.println(System.getProperty("file.separator"));
        System.out.println(System.getProperty("path.separator"));
    }
}
