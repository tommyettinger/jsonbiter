package com.github.tommyettinger.jsonbiter.demo;

import com.github.tommyettinger.jsonbiter.JsonIterator;
import com.github.tommyettinger.jsonbiter.any.Any;
import com.github.tommyettinger.jsonbiter.output.JsonStream;

public class Demo {
    static {
        // ensure that JsonBiter is properly set up
        new DemoCodegenConfig().setup();
    }

    public static void main(String[] args) {
        User user = JsonIterator.deserialize("{\"firstName\": \"tao\", \"lastName\": \"wen\", \"score\": \"1024\"}", User.class);
        System.out.println(user.firstName);
        System.out.println(user.lastName);
        System.out.println(user.score);
        user.attachment = Any.wrapArray(new int[]{1, 2, 3});
        System.out.println(JsonStream.serialize(user));
    }
}
