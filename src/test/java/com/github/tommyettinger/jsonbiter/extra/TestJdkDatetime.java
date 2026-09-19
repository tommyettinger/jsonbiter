package com.github.tommyettinger.jsonbiter.extra;

import com.github.tommyettinger.jsonbiter.JsonIterator;
import com.github.tommyettinger.jsonbiter.output.JsonStream;
import junit.framework.TestCase;

import java.text.SimpleDateFormat;
import java.util.Date;


public class TestJdkDatetime extends TestCase {

    public void testEpoch() {
        JdkDatetimeSupport.enable("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Date epoch = new Date(0);
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        assertEquals('"' + fmt.format(epoch) + '"', JsonStream.serialize(epoch));
        Date obj = JsonIterator.deserialize("\"1970-01-01T08:00:00.000+0800\"", Date.class);
        assertEquals(0, obj.getTime());
    }
}
