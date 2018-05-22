package com.sakuray.code.practice.jdk.io;

import org.junit.Test;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.io.StringWriter;

public class LineNumberReaderTest {

    @Test
    public void test() throws IOException {
        String line = "123\r\t134\n43\n\rdad\n";
        StringReader reader = new StringReader(line);
        LineNumberReader numberReader = new LineNumberReader(reader);
        StringWriter writer = new StringWriter();
        int length;
        char[] buffer = new char[1024];
        while((length = numberReader.read(buffer))!=-1) {
            writer.write(buffer, 0, length);
        }
        System.out.println(writer);
    }
}
