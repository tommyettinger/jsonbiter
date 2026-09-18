package com.github.tommyettinger.jsonbiter;

import com.github.tommyettinger.jsonbiter.spi.Decoder;
import com.github.tommyettinger.jsonbiter.spi.JsoniterSpi;
import com.github.tommyettinger.jsonbiter.spi.TypeLiteral;
import junit.framework.TestCase;

import java.io.IOException;

public class TestSpiPropertyDecoder extends TestCase {

    public static class TestObject1<A> {
        public String field;
    }

    public void test_PropertyDecoder() {
        JsoniterSpi.registerPropertyDecoder(TestObject1.class, "field", new Decoder() {
            @Override
            public Object decode(JsonIterator iter) throws IOException {
                iter.skip();
                return "hello";
            }
        });
        TestObject1 obj = JsonIterator.deserialize("{\"field\":100}", TestObject1.class);
        assertEquals("hello", obj.field);
    }

    public void test_PropertyDecoder_for_type_literal() {
        TypeLiteral<TestObject1<Object>> typeLiteral = new TypeLiteral<TestObject1<Object>>() {
        };
        JsoniterSpi.registerPropertyDecoder(typeLiteral, "field", new Decoder() {
            @Override
            public Object decode(JsonIterator iter) throws IOException {
                iter.skip();
                return "world";
            }
        });
        TestObject1 obj = JsonIterator.deserialize("{\"field\":100}", typeLiteral);
        assertEquals("world", obj.field);
    }
}
