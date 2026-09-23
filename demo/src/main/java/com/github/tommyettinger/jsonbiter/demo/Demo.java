package com.github.tommyettinger.jsonbiter.demo;

import com.github.tommyettinger.jsonbiter.JsonIterator;
import com.github.tommyettinger.jsonbiter.any.Any;
import com.github.tommyettinger.jsonbiter.output.EncodingMode;
import com.github.tommyettinger.jsonbiter.output.JsonStream;
import com.github.tommyettinger.jsonbiter.spi.Config;
import com.github.tommyettinger.jsonbiter.spi.DecodingMode;

public class Demo {
    static {
        // ensure that JsonBiter is properly set up
        new DemoCodegenConfig().setup();
    }

    public static void main(String[] args) {
        Config cfg = new Config.Builder().omitDefaultValue(true).escapeUnicode(false).indentationStep(2)
                .encodingMode(EncodingMode.STATIC_MODE).decodingMode(DecodingMode.STATIC_MODE).build();
        User user = JsonIterator.deserialize(cfg, "{\"firstName\": \"tao\", \"lastName\": \"wen\", \"score\": \"1024\"}", User.class);
        System.out.println(user.firstName);
        System.out.println(user.lastName);
        System.out.println(user.score);
        user.attachment = Any.wrapArray(new int[]{1, 2, 3});
        System.out.println(JsonStream.serialize(user));
    }
}
