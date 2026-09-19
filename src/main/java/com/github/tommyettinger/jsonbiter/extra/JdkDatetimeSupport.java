package com.github.tommyettinger.jsonbiter.extra;

import com.github.tommyettinger.jsonbiter.spi.JsonException;
import com.github.tommyettinger.jsonbiter.JsonIterator;
import com.github.tommyettinger.jsonbiter.any.Any;
import com.github.tommyettinger.jsonbiter.output.JsonStream;
import com.github.tommyettinger.jsonbiter.spi.Decoder;
import com.github.tommyettinger.jsonbiter.spi.Encoder;
import com.github.tommyettinger.jsonbiter.spi.JsoniterSpi;

import java.io.IOException;
import java.util.Date;

/**
 * There is no official way to encode/decode datetime, this is just an option for you.
 */
public class JdkDatetimeSupport {

    private static boolean enabled = false;

    public static synchronized void enable(String pattern) {
        if (JdkDatetimeSupport.enabled) {
            throw new JsonException("JdkDatetimeSupport.enable can only be called once");
        }
        enabled = true;
        JsoniterSpi.registerTypeEncoder(Date.class, new Encoder.ReflectionEncoder() {
            @Override
            public void encode(Object obj, JsonStream stream) throws IOException {
                stream.writeVal(((Date)obj).getTime());
            }

            @Override
            public Any wrap(Object obj) {
                return Any.wrap(((Date)obj).getTime());
            }
        });
        JsoniterSpi.registerTypeDecoder(Date.class, new Decoder() {
            @Override
            public Object decode(JsonIterator iter) throws IOException {
                return new Date(iter.readLong());
            }
        });
    }
}
