package com.github.tommyettinger.jsonbiter.output;

import com.github.tommyettinger.jsonbiter.spi.Encoder;
import com.github.tommyettinger.jsonbiter.spi.JsonException;
import com.github.tommyettinger.jsonbiter.any.Any;
import com.github.tommyettinger.jsonbiter.spi.JsoniterSpi;
import com.github.tommyettinger.jsonbiter.spi.TypeLiteral;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

class CodegenImplNative {
    public static final Map<Type, Encoder.ReflectionEncoder> NATIVE_ENCODERS = new IdentityHashMap<Type, Encoder.ReflectionEncoder>() {{
        put(boolean.class, new Encoder.ReflectionEncoder() {
            @Override
            public void encode(Object obj, JsonStream stream) throws IOException {
                stream.writeVal((Boolean) obj);
            }

            @Override
            public Any wrap(Object obj) {
                Boolean val = (Boolean) obj;
                return Any.wrap((boolean) val);
            }
        });
        put(Boolean.class, new Encoder.ReflectionEncoder() {
            @Override
            public void encode(Object obj, JsonStream stream) throws IOException {
                stream.writeVal((Boolean) obj);
            }

            @Override
            public Any wrap(Object obj) {
                Boolean val = (Boolean) obj;
                return Any.wrap((boolean) val);
            }
        });
        put(byte.class, new Encoder.ReflectionEncoder() {
            @Override
            public void encode(Object obj, JsonStream stream) throws IOException {
                stream.writeVal(((Byte) obj).shortValue());
            }

            @Override
            public Any wrap(Object obj) {
                Byte val = (Byte) obj;
                return Any.wrap((int) val);
            }
        });
        put(Byte.class, new Encoder.ReflectionEncoder() {
            @Override
            public void encode(Object obj, JsonStream stream) throws IOException {
                stream.writeVal(((Byte) obj).shortValue());
            }

            @Override
            public Any wrap(Object obj) {
                Byte val = (Byte) obj;
                return Any.wrap((int) val);
            }
        });
        put(short.class, new Encoder.ReflectionEncoder() {
            @Override
            public void encode(Object obj, JsonStream stream) throws IOException {
                stream.writeVal((Short) obj);
            }

            @Override
            public Any wrap(Object obj) {
                Short val = (Short) obj;
                return Any.wrap((int) val);
            }
        });
        put(Short.class, new Encoder.ReflectionEncoder() {
            @Override
            public void encode(Object obj, JsonStream stream) throws IOException {
                stream.writeVal((Short) obj);
            }

            @Override
            public Any wrap(Object obj) {
                Short val = (Short) obj;
                return Any.wrap((int) val);
            }
        });
        put(int.class, new Encoder.ReflectionEncoder() {
            @Override
            public void encode(Object obj, JsonStream stream) throws IOException {
                stream.writeVal((Integer) obj);
            }

            @Override
            public Any wrap(Object obj) {
                Integer val = (Integer) obj;
                return Any.wrap((int) val);
            }
        });
        put(Integer.class, new Encoder.ReflectionEncoder() {
            @Override
            public void encode(Object obj, JsonStream stream) throws IOException {
                stream.writeVal((Integer) obj);
            }

            @Override
            public Any wrap(Object obj) {
                Integer val = (Integer) obj;
                return Any.wrap((int) val);
            }
        });
        put(char.class, new Encoder.ReflectionEncoder() {
            @Override
            public void encode(Object obj, JsonStream stream) throws IOException {
                stream.writeVal(((Character) obj).charValue());
            }

            @Override
            public Any wrap(Object obj) {
                Character val = (Character) obj;
                return Any.wrap((int) val);
            }
        });
        put(Character.class, new Encoder.ReflectionEncoder() {
            @Override
            public void encode(Object obj, JsonStream stream) throws IOException {
                stream.writeVal(((Character) obj).charValue());
            }

            @Override
            public Any wrap(Object obj) {
                Character val = (Character) obj;
                return Any.wrap((int) val);
            }
        });
        put(long.class, new Encoder.ReflectionEncoder() {
            @Override
            public void encode(Object obj, JsonStream stream) throws IOException {
                stream.writeVal((Long) obj);
            }

            @Override
            public Any wrap(Object obj) {
                Long val = (Long) obj;
                return Any.wrap((long) val);
            }
        });
        put(Long.class, new Encoder.ReflectionEncoder() {
            @Override
            public void encode(Object obj, JsonStream stream) throws IOException {
                stream.writeVal((Long) obj);
            }

            @Override
            public Any wrap(Object obj) {
                Long val = (Long) obj;
                return Any.wrap((long) val);
            }
        });
        put(float.class, new Encoder.ReflectionEncoder() {
            @Override
            public void encode(Object obj, JsonStream stream) throws IOException {
                stream.writeVal((Float) obj);
            }

            @Override
            public Any wrap(Object obj) {
                Float val = (Float) obj;
                return Any.wrap((float) val);
            }
        });
        put(Float.class, new Encoder.ReflectionEncoder() {
            @Override
            public void encode(Object obj, JsonStream stream) throws IOException {
                stream.writeVal((Float) obj);
            }

            @Override
            public Any wrap(Object obj) {
                Float val = (Float) obj;
                return Any.wrap((float) val);
            }
        });
        put(double.class, new Encoder.ReflectionEncoder() {
            @Override
            public void encode(Object obj, JsonStream stream) throws IOException {
                stream.writeVal((Double) obj);
            }

            @Override
            public Any wrap(Object obj) {
                Double val = (Double) obj;
                return Any.wrap((double) val);
            }
        });
        put(Double.class, new Encoder.ReflectionEncoder() {
            @Override
            public void encode(Object obj, JsonStream stream) throws IOException {
                stream.writeVal((Double) obj);
            }

            @Override
            public Any wrap(Object obj) {
                Double val = (Double) obj;
                return Any.wrap((double) val);
            }
        });
        put(String.class, new Encoder.ReflectionEncoder() {
            @Override
            public void encode(Object obj, JsonStream stream) throws IOException {
                stream.writeVal((String) obj);
            }

            @Override
            public Any wrap(Object obj) {
                String val = (String) obj;
                return Any.wrap(val);
            }
        });
        put(Object.class, new Encoder.ReflectionEncoder() {
            @Override
            public void encode(Object obj, JsonStream stream) throws IOException {
                if (obj != null && obj.getClass() == Object.class) {
                    stream.writeEmptyObject();
                    return;
                }
                stream.writeVal(obj);
            }

            @Override
            public Any wrap(Object obj) {
                if (obj != null && obj.getClass() == Object.class) {
                    return Any.rewrap(new HashMap<String, Any>());
                }
                return CodegenAccess.wrap(obj);
            }
        });

        put(BigDecimal.class, new Encoder.ReflectionEncoder() {
            @Override
            public void encode(Object obj, JsonStream stream) throws IOException {
                BigDecimal val = (BigDecimal) obj;
                stream.writeRaw(val.toString());
            }

            @Override
            public Any wrap(Object obj) {
                return Any.wrap(obj.toString());
            }
        });
        put(BigInteger.class, new Encoder.ReflectionEncoder() {
            @Override
            public void encode(Object obj, JsonStream stream) throws IOException {
                BigInteger val = (BigInteger) obj;
                stream.writeRaw(val.toString());
            }

            @Override
            public Any wrap(Object obj) {
                return Any.wrap(obj.toString());
            }
        });
    }};

    public static void genWriteOp(CodegenResult ctx, String code, Type valueType, boolean isNullable) {
        genWriteOp(ctx, code, valueType, isNullable, true);
    }

    public static void genWriteOp(CodegenResult ctx, String code, Type valueType, boolean isNullable, boolean isCollectionValueNullable) {
        boolean noIndentation = JsoniterSpi.getCurrentConfig().indentationStep() == 0;
        String cacheKey = TypeLiteral.create(valueType).getEncoderCacheKey();
        if (JsoniterSpi.getEncoder(cacheKey) == null) {
            if (noIndentation && !isNullable && String.class == valueType) {
                ctx.buffer('"');
                ctx.append("com.github.tommyettinger.jsonbiter.output.CodegenAccess.writeStringWithoutQuote((java.lang.String)" + code + ", stream);");
                ctx.buffer('"');
                return;
            }
            if (NATIVE_ENCODERS.containsKey(valueType)) {
                ctx.append("stream.writeVal((" + getTypeName(valueType) + ")" + code + ");");
                return;
            }
            if (valueType instanceof WildcardType) {
                ctx.append("stream.writeVal((" + getTypeName(Object.class) + ")" + code + ");");
                return;
            }
        }

        if (!isCollectionValueNullable) {
            cacheKey = cacheKey + "__value_not_nullable";
        }
        Codegen.getEncoder(cacheKey, valueType);
        CodegenResult generatedSource = Codegen.getGeneratedSource(cacheKey);
        if (generatedSource != null) {
            if (isNullable) {
                ctx.appendBuffer();
                ctx.append(CodegenResult.bufferToWriteOp(generatedSource.prelude));
                ctx.append(cacheKey + ".encode_((" + getTypeName(valueType) + ")" + code + ", stream);");
                ctx.append(CodegenResult.bufferToWriteOp(generatedSource.epilogue));
            } else {
                ctx.buffer(generatedSource.prelude);
                ctx.append(cacheKey + ".encode_((" + getTypeName(valueType) + ")" + code + ", stream);");
                ctx.buffer(generatedSource.epilogue);
            }
        } else {
            ctx.append("com.github.tommyettinger.jsonbiter.output.CodegenAccess.writeVal(\"" + cacheKey + "\", (" + getTypeName(valueType) + ")" + code + ", stream);");
        }
    }

    public static String getTypeName(Type fieldType) {
        if (fieldType instanceof Class) {
            Class clazz = (Class) fieldType;
            return clazz.getCanonicalName();
        } else if (fieldType instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) fieldType;
            Class clazz = (Class) pType.getRawType();
            return clazz.getCanonicalName();
        } else if (fieldType instanceof WildcardType) {
            return Object.class.getCanonicalName();
        } else {
            throw new JsonException("unsupported type: " + fieldType);
        }
    }
    public static CodegenResult genEnum(Class clazz) {
        boolean noIndentation = JsoniterSpi.getCurrentConfig().indentationStep() == 0;
        CodegenResult ctx = new CodegenResult();
        // this was a malformed format call, should it be this or...
        ctx.append("public static void encode_(java.lang.Object obj, com.github.tommyettinger.jsonbiter.output.JsonStream stream) throws java.io.IOException {");
        // should it be this?
//        ctx.append("public static void encode_("+clazz.getCanonicalName()+" obj, com.github.tommyettinger.jsonbiter.output.JsonStream stream) throws java.io.IOException {");
        ctx.append("if (obj == null) { stream.writeNull(); return; }");
        if (noIndentation) {
            ctx.buffer('"');
        } else {
            ctx.append("stream.write('\"');");
        }
        ctx.append("stream.writeRaw(obj.toString());");
        if (noIndentation) {
            ctx.buffer('"');
        } else {
            ctx.append("stream.write('\"');");
        }
        ctx.append("}");
        return ctx;
    }
}
