package jsoniter_codegen.cfg1612486582.encoder.java.util.List_java.lang;
public class Integer implements com.github.tommyettinger.jsonbiter.spi.Encoder {
public void encode(java.lang.Object obj, com.github.tommyettinger.jsonbiter.output.JsonStream stream) throws java.io.IOException {
if (obj == null) { stream.writeNull(); return; }
encode_((java.util.List)obj, stream);
}
public static void encode_(java.lang.Object obj, com.github.tommyettinger.jsonbiter.output.JsonStream stream) throws java.io.IOException {
java.util.List list = (java.util.List)obj;
int size = list.size();
if (size == 0) { stream.write((byte)'[', (byte)']'); return; }
stream.writeArrayStart(); stream.writeIndentation();
java.lang.Object e = list.get(0);
if (e == null) { stream.writeNull(); } else {
stream.writeVal((java.lang.Integer)e);
}
for (int i = 1; i < size; i++) {
stream.writeMore();
e = list.get(i);
if (e == null) { stream.writeNull(); } else {
stream.writeVal((java.lang.Integer)e);
}
}
stream.writeArrayEnd();
}
}
