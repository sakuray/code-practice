package com.sakuray.code.practice.jdk.io;

import org.junit.Test;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;

public class PushbackReaderTest {

    @Test
    public void test() throws IOException {
        String line = "123";
        StringReader reader = new StringReader(line);
        PushbackReader pushReader = new PushbackReader(reader, 2);
        int c;
        c = reader.read();
        pushReader.unread(c);
        c = reader.read();
        pushReader.unread(c);
        while((c=pushReader.read()) != -1) {
            System.out.println((char)c);
        }
    }
}
