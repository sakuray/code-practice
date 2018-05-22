package com.sakuray.code.practice.jdk.io;

import org.junit.Test;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class StreamTokenizerTest {

    @Test
    public void test() throws IOException {
        String text = "都比 阿斯顿,打算 ; 士大夫 123 fda";
        StringReader r = new StringReader(text);
        StreamTokenizer tokenizer = new StreamTokenizer(r);
        tokenizer.ordinaryChar(',');
        while(tokenizer.nextToken()!=StreamTokenizer.TT_EOF) {
            if(tokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                System.out.println(tokenizer.nval);
            } else {
                System.out.println(tokenizer.sval);
            }
        }
    }

    @Test
    public void test2() throws IOException {
        String text = "她说：\"这个 5 元!\"";
        StringReader reader = new StringReader(text);
        StreamTokenizer tokenizer = new StreamTokenizer(reader);
//      tokenizer.ordinaryChar('\"');
        while(tokenizer.nextToken()!=StreamTokenizer.TT_EOF) {
            if(tokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                System.out.println(tokenizer.nval);
            } else if(tokenizer.ttype == StreamTokenizer.TT_WORD){
                System.out.println(tokenizer.sval);
            } else if(tokenizer.ttype == StreamTokenizer.TT_EOL){
                System.out.println("换行符");
            } else {
                System.out.println(tokenizer.sval);
            }
        }
    }
}
