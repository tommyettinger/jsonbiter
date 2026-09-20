package com.github.tommyettinger.jsonbiter.demo;

import com.github.tommyettinger.jsonbiter.JsonIterator;
import com.github.tommyettinger.jsonbiter.any.Any;
import com.github.tommyettinger.jsonbiter.output.EncodingMode;
import com.github.tommyettinger.jsonbiter.output.JsonStream;
import com.github.tommyettinger.jsonbiter.spi.Decoder;
import com.github.tommyettinger.jsonbiter.spi.DecodingMode;
import com.github.tommyettinger.jsonbiter.spi.JsoniterSpi;
import com.github.tommyettinger.jsonbiter.spi.TypeLiteral;
import com.github.tommyettinger.jsonbiter.static_codegen.StaticCodegenConfig;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DemoCodegenConfig implements StaticCodegenConfig {

    @Override
    public void setup() {
        // register custom decoder or extensions before codegen
        // so that we can do codegen, we know in which case, we need to callback
        Any.registerEncoders();
        JsonIterator.setMode(DecodingMode.STATIC_MODE);
        JsonStream.setMode(EncodingMode.STATIC_MODE);
        JsonStream.setIndentionStep(2);
        JsoniterSpi.registerPropertyDecoder(User.class, "score", new Decoder.IntDecoder() {
            @Override
            public int decodeInt(JsonIterator iter) throws IOException {
                return Integer.valueOf(iter.readString());
            }
        });
    }

    @Override
    public TypeLiteral[] whatToCodegen() {
        return new TypeLiteral[]{
                // generic types, need to use this syntax
                new TypeLiteral<List<Integer>>() {
                },
                new TypeLiteral<List<User>>() {
                },
                new TypeLiteral<Map<String, Object>>() {
                },
                // array
                TypeLiteral.create(int[].class),
                // object
                TypeLiteral.create(User.class)
        };
    }
}
