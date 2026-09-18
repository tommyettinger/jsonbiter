package com.github.tommyettinger.jsonbiter.extra;

import com.github.tommyettinger.jsonbiter.JsonIterator;
import com.github.tommyettinger.jsonbiter.output.JsonStream;
import junit.framework.TestCase;

import java.util.Date;


public class TestJdkDatetime extends TestCase {

    public void testEpoch() {
        JdkDatetimeSupport.enable("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        assertEquals("0", JsonStream.serialize(new Date(0)));
        Date obj = JsonIterator.deserialize("0", Date.class);
        assertEquals(0, obj.getTime());
    }
}
