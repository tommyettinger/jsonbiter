package com.github.tommyettinger.jsonbiter.extra;

import com.github.tommyettinger.jsonbiter.JsonIterator;
import com.github.tommyettinger.jsonbiter.output.JsonStream;
import junit.framework.TestCase;

public class TestBase64 extends TestCase {
    static {
        Base64Support.enable();
    }

    public void test_encode() {
        assertEquals("\"YWJj\"", JsonStream.serialize("abc".getBytes()));
    }

    public void test_decode() {
        assertEquals("abc", new String(JsonIterator.deserialize("\"YWJj\"", byte[].class)));
    }
}
