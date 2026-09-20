package jsoniter_codegen.cfg1173796797.encoder;
public class int_array implements com.github.tommyettinger.jsonbiter.spi.Encoder {
public void encode(java.lang.Object obj, com.github.tommyettinger.jsonbiter.output.JsonStream stream) throws java.io.IOException {
if (obj == null) { stream.writeNull(); return; }
encode_((int[])obj, stream);
}
public static void encode_(java.lang.Object obj, com.github.tommyettinger.jsonbiter.output.JsonStream stream) throws java.io.IOException {
int[] arr = (int[])obj;
if (arr.length == 0) { stream.write((byte)'[', (byte)']'); return; }
stream.writeArrayStart(); stream.writeIndention();
int i = 0;
int e = arr[i++];
stream.writeVal((int)e);
while (i < arr.length) {
stream.writeMore();
e = arr[i++];
stream.writeVal((int)e);
}
stream.writeArrayEnd();
}
}
