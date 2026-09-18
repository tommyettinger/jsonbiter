package com.github.tommyettinger.jsonbiter.extra;

import com.github.tommyettinger.jsonbiter.spi.JsonException;
import com.github.tommyettinger.jsonbiter.JsonIterator;
import com.github.tommyettinger.jsonbiter.any.Any;
import com.github.tommyettinger.jsonbiter.output.JsonStream;
import com.github.tommyettinger.jsonbiter.spi.Decoder;
import com.github.tommyettinger.jsonbiter.spi.Encoder;
import com.github.tommyettinger.jsonbiter.spi.JsoniterSpi;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * there is no official way to encode/decode datetime, this is just an option for you
 */
public class JdkDatetimeSupport {

    private static String pattern;
    private final static ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(pattern);
        }
    };

    public static synchronized void enable(String pattern) {
        if (JdkDatetimeSupport.pattern != null) {
            throw new JsonException("JdkDatetimeSupport.enable can only be called once");
        }
        JdkDatetimeSupport.pattern = pattern;
        JsoniterSpi.registerTypeEncoder(Date.class, new Encoder.ReflectionEncoder() {
            @Override
            public void encode(Object obj, JsonStream stream) throws IOException {
                stream.writeVal(sdf.get().format(obj));
            }

            @Override
            public Any wrap(Object obj) {
                return Any.wrap(sdf.get().format(obj));
            }
        });
        JsoniterSpi.registerTypeDecoder(Date.class, new Decoder() {
            @Override
            public Object decode(JsonIterator iter) throws IOException {
                try {
                    return sdf.get().parse(iter.readString());
                } catch (ParseException e) {
                    throw new JsonException(e);
                }
            }
        });
    }
}
