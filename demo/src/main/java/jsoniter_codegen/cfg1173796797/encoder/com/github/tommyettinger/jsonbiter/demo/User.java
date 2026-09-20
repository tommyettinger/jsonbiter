package jsoniter_codegen.cfg1173796797.encoder.com.github.tommyettinger.jsonbiter.demo;
public class User implements com.github.tommyettinger.jsonbiter.spi.Encoder {
public void encode(java.lang.Object obj, com.github.tommyettinger.jsonbiter.output.JsonStream stream) throws java.io.IOException {
if (obj == null) { stream.writeNull(); return; }
encode_((com.github.tommyettinger.jsonbiter.demo.User)obj, stream);
}
public static void encode_(com.github.tommyettinger.jsonbiter.demo.User obj, com.github.tommyettinger.jsonbiter.output.JsonStream stream) throws java.io.IOException {
stream.writeObjectStart();
stream.writeIndention();
stream.writeObjectField("firstName");
if (obj.firstName == null) { stream.writeNull(); } else {
stream.writeVal((java.lang.String)obj.firstName);
}
stream.writeMore();
stream.writeObjectField("lastName");
if (obj.lastName == null) { stream.writeNull(); } else {
stream.writeVal((java.lang.String)obj.lastName);
}
stream.writeMore();
stream.writeObjectField("score");
stream.writeVal((int)obj.score);
stream.writeMore();
stream.writeObjectField("attachment");
if (obj.attachment == null) { stream.writeNull(); } else {
stream.writeVal((com.github.tommyettinger.jsonbiter.any.Any)obj.attachment);
}
stream.writeObjectEnd();
}
}
