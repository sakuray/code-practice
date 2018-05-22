package com.sakuray.code.practice.jdk.io;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class PipedStreamTest {

    @Test
    public void test() throws IOException {
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream(pis);
        byte[] read = new byte[10];
        byte[] write = new byte[100];
        int count = 0;
        try {
            while(true) {
                pos.write(write);
                pis.read(read);
                System.out.println("完成写入读取次数："+(++count));
            }
        } finally {
            pos.close();
        }
    }

    @Test
    public void test2() throws IOException, InterruptedException {
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream(pis);
        CountDownLatch latch = new CountDownLatch(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                byte[] b = new byte[1025];
                b[1024] = 1;
                try {
                    pos.write(b , 0, 1022);
                    Thread.sleep(2000);
                    pos.write(b, 1022, b.length);
                    pos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 睡两秒
				/*try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}*/
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int len = 0;
                try {
                    while ((len = pis.read(buf)) != -1) {
                        baos.write(buf, 0, len);
                    }
                	/*byte b;
                	while((b = (byte) pis.read()) != -1) {
                		baos.write(b);
                	}*/
                } catch (IOException e) {
                    e.printStackTrace();
                }
                byte[] result = baos.toByteArray();
                System.out.println(result.length + ":" + Arrays.toString(result));
                latch.countDown();
            }
        }).start();
        latch.await();
    }

    static boolean end = false;
    @Test
    public void test3() throws IOException, InterruptedException {
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream(pis);
        Object monitor = new Object();
        CountDownLatch latch = new CountDownLatch(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 3;
                while(count-->0) {
                    synchronized (monitor) {
                        System.out.println(count);
                        byte[] b = new byte[1022];
                        try {
                            pos.write(b , 0, b.length);
                            Thread.sleep(2000);
                            pos.write(1);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        monitor.notifyAll();
                        try {
                            monitor.wait(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                end = true;
                try {
                    pos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int len = 0;
                try {
                    System.out.println("reading");
                    synchronized (monitor) {
                        while (!end) {
                            len = pis.read(buf);
                            System.out.println("reading...");
                            baos.write(buf, 0, len);
                            monitor.notifyAll();
                            try {
                                monitor.wait(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                byte[] result = baos.toByteArray();
                System.out.println(result.length + ":" + Arrays.toString(result));
                latch.countDown();
            }
        }).start();
        latch.await();
    }
}
