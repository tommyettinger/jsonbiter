package com.github.tommyettinger.jsonbiter.output;

import com.github.tommyettinger.jsonbiter.spi.Config;
import junit.framework.TestCase;

import java.util.HashSet;

public class TestCollection extends TestCase {

    public void test_indentation() {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(1);
        Config cfg = new Config.Builder()
                .encodingMode(EncodingMode.REFLECTION_MODE)
                .indentationStep(2)
                .build();
        assertEquals("[\n" +
                "  1\n" +
                "]", JsonStream.serialize(cfg, set));
        cfg = new Config.Builder()
                .encodingMode(EncodingMode.REFLECTION_MODE)
                .indentationStep(2)
                .build();
        assertEquals("[\n" +
                "  1\n" +
                "]", JsonStream.serialize(cfg, set));
    }

    public void test_indentation_with_empty_array() {
        Config cfg = new Config.Builder()
                .encodingMode(EncodingMode.REFLECTION_MODE)
                .indentationStep(2)
                .build();
        assertEquals("[]", JsonStream.serialize(cfg, new HashSet<Integer>()));
        cfg = new Config.Builder()
                .encodingMode(EncodingMode.REFLECTION_MODE)
                .indentationStep(2)
                .build();
        assertEquals("[]", JsonStream.serialize(cfg, new HashSet<Integer>()));
    }
}
