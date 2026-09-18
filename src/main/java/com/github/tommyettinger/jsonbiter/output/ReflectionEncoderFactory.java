package com.github.tommyettinger.jsonbiter.output;

import com.github.tommyettinger.jsonbiter.spi.ClassInfo;
import com.github.tommyettinger.jsonbiter.spi.Encoder;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ReflectionEncoderFactory {

    public static Encoder.ReflectionEncoder create(ClassInfo classInfo) {
        Class clazz = classInfo.clazz;
        Type[] typeArgs = classInfo.typeArgs;
        if (clazz.isArray()) {
            return new ReflectionArrayEncoder(clazz, typeArgs);
        }
        if (List.class.isAssignableFrom(clazz)) {
            return new ReflectionListEncoder(clazz, typeArgs);
        }
        if (Collection.class.isAssignableFrom(clazz)) {
            return new ReflectionCollectionEncoder(clazz, typeArgs);
        }
        if (Map.class.isAssignableFrom(clazz)) {
            return new ReflectionMapEncoder(clazz, typeArgs);
        }
        if (clazz.isEnum()) {
            return new ReflectionEnumEncoder(clazz);
        }
        return new ReflectionObjectEncoder(classInfo);
    }
}
