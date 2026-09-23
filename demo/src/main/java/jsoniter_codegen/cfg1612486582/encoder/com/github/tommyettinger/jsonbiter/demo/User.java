package jsoniter_codegen.cfg1612486582.encoder.com.github.tommyettinger.jsonbiter.demo;
public class User implements com.github.tommyettinger.jsonbiter.spi.Encoder {
public void encode(java.lang.Object obj, com.github.tommyettinger.jsonbiter.output.JsonStream stream) throws java.io.IOException {
if (obj == null) { stream.writeNull(); return; }
encode_((com.github.tommyettinger.jsonbiter.demo.User)obj, stream);
}
public static void encode_(com.github.tommyettinger.jsonbiter.demo.User obj, com.github.tommyettinger.jsonbiter.output.JsonStream stream) throws java.io.IOException {
stream.writeObjectStart();
boolean notFirst = false;
if (!(null == obj.firstName)) {
if (notFirst) { stream.writeMore(); } else { stream.writeIndentation(); notFirst = true; }
stream.writeObjectField("firstName");
stream.writeVal((java.lang.String)obj.firstName);
}
if (!(null == obj.lastName)) {
if (notFirst) { stream.writeMore(); } else { stream.writeIndentation(); notFirst = true; }
stream.writeObjectField("lastName");
stream.writeVal((java.lang.String)obj.lastName);
}
if (!(0 == obj.score)) {
if (notFirst) { stream.writeMore(); } else { stream.writeIndentation(); notFirst = true; }
stream.writeObjectField("score");
stream.writeVal((int)obj.score);
}
if (!(null == obj.attachment)) {
if (notFirst) { stream.writeMore(); } else { stream.writeIndentation(); notFirst = true; }
stream.writeObjectField("attachment");
stream.writeVal((com.github.tommyettinger.jsonbiter.any.Any)obj.attachment);
}
if (notFirst) { stream.writeObjectEnd(); } else { stream.write('}'); }
}
}
