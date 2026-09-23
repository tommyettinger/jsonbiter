package jsoniter_codegen.cfg9223372036069743490.decoder.java.util.Map_java.lang.String_java.lang;
public class Object implements com.github.tommyettinger.jsonbiter.spi.Decoder {
public static java.lang.Object decode_(com.github.tommyettinger.jsonbiter.JsonIterator iter) throws java.io.IOException { java.util.HashMap map = (java.util.HashMap)com.github.tommyettinger.jsonbiter.CodegenAccess.resetExistingObject(iter);
if (iter.readNull()) { return null; }
if (map == null) { map = new java.util.HashMap(); }
if (!com.github.tommyettinger.jsonbiter.CodegenAccess.readObjectStart(iter)) {
return map;
}
do {
java.lang.Object mapKey = com.github.tommyettinger.jsonbiter.CodegenAccess.readObjectFieldAsString(iter);
map.put(mapKey, (java.lang.Object)iter.read());
} while (com.github.tommyettinger.jsonbiter.CodegenAccess.nextToken(iter) == ',');
return map;
}public java.lang.Object decode(com.github.tommyettinger.jsonbiter.JsonIterator iter) throws java.io.IOException {
return decode_(iter);
}
}
