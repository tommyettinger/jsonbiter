package com.github.tommyettinger.jsonbiter;

import com.github.tommyettinger.jsonbiter.spi.ClassInfo;
import com.github.tommyettinger.jsonbiter.spi.TypeLiteral;

import java.lang.reflect.Type;

class CodegenImplMap {

    public static String genMap(ClassInfo classInfo) {
        Type keyType = classInfo.typeArgs[0];
        Type valueType = classInfo.typeArgs[1];
        StringBuilder lines = new StringBuilder();
        append(lines, "{{clazz}} map = ({{clazz}})com.github.tommyettinger.jsonbiter.CodegenAccess.resetExistingObject(iter);");
        append(lines, "if (iter.readNull()) { return null; }");
        append(lines, "if (map == null) { map = new {{clazz}}(); }");
        append(lines, "if (!com.github.tommyettinger.jsonbiter.CodegenAccess.readObjectStart(iter)) {");
        append(lines, "return map;");
        append(lines, "}");
        append(lines, "do {");
        if (keyType == String.class) {
            append(lines, "java.lang.Object mapKey = com.github.tommyettinger.jsonbiter.CodegenAccess.readObjectFieldAsString(iter);");
        } else {
            append(lines, "java.lang.Object mapKey = com.github.tommyettinger.jsonbiter.CodegenAccess.readMapKey(\"" +
                    TypeLiteral.create(keyType).getDecoderCacheKey() +"\", iter);");
        }
        append(lines, "map.put(mapKey, {{op}});");
        append(lines, "} while (com.github.tommyettinger.jsonbiter.CodegenAccess.nextToken(iter) == ',');");
        append(lines, "return map;");
        return lines.toString()
                .replace("{{clazz}}", classInfo.clazz.getName())
                .replace("{{op}}", CodegenImplNative.genReadOp(valueType));
    }

    private static void append(StringBuilder lines, String str) {
        lines.append(str);
        lines.append("\n");
    }
}
