package com.github.tommyettinger.jsonbiter.output;

import com.github.tommyettinger.jsonbiter.any.Any;
import com.github.tommyettinger.jsonbiter.spi.Encoder;

import java.io.IOException;

class ReflectionEnumEncoder implements Encoder.ReflectionEncoder {
    public ReflectionEnumEncoder(Class clazz) {
    }

    @Override
    public void encode(Object obj, JsonStream stream) throws IOException {
        stream.write('"');
        stream.writeRaw(obj.toString());
        stream.write('"');
    }

    @Override
    public Any wrap(Object obj) {
        return Any.wrap(obj.toString());
    }
}
