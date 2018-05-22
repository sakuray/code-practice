package com.sakuray.code.practice.jdk.io;

import org.junit.Test;

public class HookTest {

    @Test
    public void test() {
        System.out.println("开始运行");
        Runtime.getRuntime().addShutdownHook(new Task());
        System.out.println("运行结束");
    }

    private class Task extends Thread{

        @Override
        public void run() {
            System.out.println("123");
        }

    }
}
