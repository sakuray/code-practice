package com.sakuray.code.practice.jdk.util;

import com.sakuray.code.practice.jdk.util.test.TestService;

import java.util.ServiceLoader;

public class ServiceLoaderTest {

    public static void main(String[] args) {
        ServiceLoader<TestService> loader = ServiceLoader.load(TestService.class);
        for(TestService service : loader) {
            System.out.println(service.sayHello());
        }
    }
}
