package com.sakuray.code.practice.jdk.io;

import org.junit.Test;

import java.io.*;

public class DataStreamTest {

    @Test
    public void test() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeByte(1);
        dos.writeInt(234);
        dos.writeShort(56);
        dos.writeLong(789L);
        dos.writeDouble(11.11);
        dos.writeFloat(22.22f);
        dos.writeChar('a');
        dos.writeBoolean(false);
        dos.writeUTF("你好！");
        dos.close();
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        DataInputStream dis = new DataInputStream(bais);
        System.out.println(dis.readByte());
        System.out.println(dis.readInt());
        System.out.println(dis.readShort());
        System.out.println(dis.readLong());
        System.out.println(dis.readDouble());
        System.out.println(dis.readFloat());
        System.out.println(dis.readChar());
        System.out.println(dis.readBoolean());
        System.out.println(dis.readUTF());
        dis.close();
    }
}
