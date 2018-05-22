package com.sakuray.code.practice.jdk.math;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalTest {

    @Test
    public void test() {
        BigDecimal b = new BigDecimal(-1.22);
        System.out.println(b.unscaledValue());
        System.out.println(b.scale());
        System.out.println(b);
        String a = "2199999999999999733546474089962430298328399658203125";
        System.out.println(a.length());
        System.out.println(b.precision());
        BigDecimal lon = new BigDecimal(123L);
        System.out.println(lon.longValue());
        BigDecimal divisor = new BigDecimal(11);
        System.out.println(lon.remainder(divisor));
        System.out.println(lon.pow(2));
    }

    @Test
    public void testMathContext() {
        BigDecimal add = new BigDecimal("1.17");
        BigDecimal a = new BigDecimal("12.324", new MathContext(3, RoundingMode.UP));
        BigDecimal b = new BigDecimal("12.324", new MathContext(2, RoundingMode.UP));
        BigDecimal d = new BigDecimal("12.324", new MathContext(1, RoundingMode.UP));
        BigDecimal c = new BigDecimal("12.324", new MathContext(0, RoundingMode.UP));
        System.out.println(a);
        System.out.println(a.add(add)); // a变成12.4
        System.out.println(b.add(add));	// a变成14
        System.out.println(d.add(add)); // a变成20
        System.out.println(c.add(add));
    }

    @Test
    public void tests() {
        System.out.println(Math.pow(2, 31)-1);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(0 & 0xff);
    }
}
