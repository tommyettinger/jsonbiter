package com.github.tommyettinger.jsonbiter.output;

import com.github.tommyettinger.jsonbiter.spi.ClassInfo;
import com.github.tommyettinger.jsonbiter.spi.JsoniterSpi;

import java.lang.reflect.Type;

class CodegenImplMap {
    public static CodegenResult genMap(String cacheKey, ClassInfo classInfo) {
        boolean noIndention = JsoniterSpi.getCurrentConfig().indentionStep() == 0;
        Type[] typeArgs = classInfo.typeArgs;
        boolean isCollectionValueNullable = true;
        if (cacheKey.endsWith("__value_not_nullable")) {
            isCollectionValueNullable = false;
        }
        Type keyType = Object.class;
        Type valueType = Object.class;
        if (typeArgs.length == 2) {
            keyType = typeArgs[0];
            valueType = typeArgs[1];
        }
        CodegenResult ctx = new CodegenResult();
        ctx.append("public static void encode_(java.lang.Object obj, output.com.github.tommyettinger.jsonbiter.JsonStream stream) throws java.io.IOException {");
        ctx.append("if (obj == null) { stream.writeNull(); return; }");
        ctx.append("java.util.Map map = (java.util.Map)obj;");
        ctx.append("java.util.Iterator iter = map.entrySet().iterator();");
        if (noIndention) {
            ctx.append("if(!iter.hasNext()) { return; }");
        } else {
            ctx.append("if(!iter.hasNext()) { stream.write((byte)'{', (byte)'}'); return; }");
        }
        ctx.append("java.util.Map.Entry entry = (java.util.Map.Entry)iter.next();");
        if (noIndention) {
            ctx.buffer('{');
        } else {
            ctx.append("stream.writeObjectStart(); stream.writeIndention();");
        }
        genWriteMapKey(ctx, keyType, noIndention);
        if (isCollectionValueNullable) {
            ctx.append("if (entry.getValue() == null) { stream.writeNull(); } else {");
            CodegenImplNative.genWriteOp(ctx, "entry.getValue()", valueType, true);
            ctx.append("}");
        } else {
            CodegenImplNative.genWriteOp(ctx, "entry.getValue()", valueType, false);
        }
        ctx.append("while(iter.hasNext()) {");
        ctx.append("entry = (java.util.Map.Entry)iter.next();");
        if (noIndention) {
            ctx.append("stream.write(',');");
        } else {
            ctx.append("stream.writeMore();");
        }
        genWriteMapKey(ctx, keyType, noIndention);
        if (isCollectionValueNullable) {
            ctx.append("if (entry.getValue() == null) { stream.writeNull(); } else {");
            CodegenImplNative.genWriteOp(ctx, "entry.getValue()", valueType, true);
            ctx.append("}");
        } else {
            CodegenImplNative.genWriteOp(ctx, "entry.getValue()", valueType, false);
        }
        ctx.append("}");
        if (noIndention) {
            ctx.buffer('}');
        } else {
            ctx.append("stream.writeObjectEnd();");
        }
        ctx.append("}");
        return ctx;
    }

    private static void genWriteMapKey(CodegenResult ctx, Type keyType, boolean noIndention) {
        if (keyType == Object.class) {
            ctx.append("stream.writeObjectField(entry.getKey());");
            return;
        }
        if (keyType == String.class) {
            ctx.append("stream.writeVal((java.lang.String)entry.getKey());");
        } else if (CodegenImplNative.NATIVE_ENCODERS.containsKey(keyType)) {
            ctx.append("stream.write('\"');");
            ctx.append("stream.writeVal((" + CodegenImplNative.getTypeName(keyType) + ")entry.getKey());");
            ctx.append("stream.write('\"');");
        } else {
            String mapCacheKey = JsoniterSpi.getMapKeyEncoderCacheKey(keyType);
            ctx.append("output.com.github.tommyettinger.jsonbiter.CodegenAccess.writeMapKey(\"" + mapCacheKey + "\", entry.getKey(), stream);");
        }
        if (noIndention) {
            ctx.append("stream.write(':');");
        } else {
            ctx.append("stream.write((byte)':', (byte)' ');");
        }
    }
}
