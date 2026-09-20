package jsoniter_codegen.cfg1173796797.decoder.com.github.tommyettinger.jsonbiter.demo;
public class User implements com.github.tommyettinger.jsonbiter.spi.Decoder {
public static java.lang.Object decode_(com.github.tommyettinger.jsonbiter.JsonIterator iter) throws java.io.IOException { java.lang.Object existingObj = com.github.tommyettinger.jsonbiter.CodegenAccess.resetExistingObject(iter);
if (iter.readNull()) { return null; }
com.github.tommyettinger.jsonbiter.demo.User obj = (existingObj == null ? new com.github.tommyettinger.jsonbiter.demo.User() : (com.github.tommyettinger.jsonbiter.demo.User)existingObj);
if (!com.github.tommyettinger.jsonbiter.CodegenAccess.readObjectStart(iter)) {
return obj;
}
com.github.tommyettinger.jsonbiter.spi.Slice field = com.github.tommyettinger.jsonbiter.CodegenAccess.readObjectFieldAsSlice(iter);
boolean once = true;
while (once) {
once = false;
switch (field.len()) {
case 5: 
if (
field.at(0)==115 && 
field.at(1)==99 && 
field.at(2)==111 && 
field.at(3)==114 && 
field.at(4)==101
) {
obj.score= (int)com.github.tommyettinger.jsonbiter.CodegenAccess.readInt("score@jsoniter_codegen.cfg1173796797.decoder.com.github.tommyettinger.jsonbiter.demo.User", iter);
continue;
}
break;
case 8: 
if (
field.at(0)==108 && 
field.at(1)==97 && 
field.at(2)==115 && 
field.at(3)==116 && 
field.at(4)==78 && 
field.at(5)==97 && 
field.at(6)==109 && 
field.at(7)==101
) {
obj.lastName= (java.lang.String)iter.readString();
continue;
}
break;
case 9: 
if (
field.at(0)==102 && 
field.at(1)==105 && 
field.at(2)==114 && 
field.at(3)==115 && 
field.at(4)==116 && 
field.at(5)==78 && 
field.at(6)==97 && 
field.at(7)==109 && 
field.at(8)==101
) {
obj.firstName= (java.lang.String)iter.readString();
continue;
}
break;
case 10: 
if (
field.at(0)==97 && 
field.at(1)==116 && 
field.at(2)==116 && 
field.at(3)==97 && 
field.at(4)==99 && 
field.at(5)==104 && 
field.at(6)==109 && 
field.at(7)==101 && 
field.at(8)==110 && 
field.at(9)==116
) {
obj.attachment= (com.github.tommyettinger.jsonbiter.any.Any)iter.readAny();
continue;
}
break;

}
iter.skip();
}
while (com.github.tommyettinger.jsonbiter.CodegenAccess.nextToken(iter) == ',') {
field = com.github.tommyettinger.jsonbiter.CodegenAccess.readObjectFieldAsSlice(iter);
switch (field.len()) {
case 5: 
if (
field.at(0)==115 && 
field.at(1)==99 && 
field.at(2)==111 && 
field.at(3)==114 && 
field.at(4)==101
) {
obj.score= (int)com.github.tommyettinger.jsonbiter.CodegenAccess.readInt("score@jsoniter_codegen.cfg1173796797.decoder.com.github.tommyettinger.jsonbiter.demo.User", iter);
continue;
}
break;
case 8: 
if (
field.at(0)==108 && 
field.at(1)==97 && 
field.at(2)==115 && 
field.at(3)==116 && 
field.at(4)==78 && 
field.at(5)==97 && 
field.at(6)==109 && 
field.at(7)==101
) {
obj.lastName= (java.lang.String)iter.readString();
continue;
}
break;
case 9: 
if (
field.at(0)==102 && 
field.at(1)==105 && 
field.at(2)==114 && 
field.at(3)==115 && 
field.at(4)==116 && 
field.at(5)==78 && 
field.at(6)==97 && 
field.at(7)==109 && 
field.at(8)==101
) {
obj.firstName= (java.lang.String)iter.readString();
continue;
}
break;
case 10: 
if (
field.at(0)==97 && 
field.at(1)==116 && 
field.at(2)==116 && 
field.at(3)==97 && 
field.at(4)==99 && 
field.at(5)==104 && 
field.at(6)==109 && 
field.at(7)==101 && 
field.at(8)==110 && 
field.at(9)==116
) {
obj.attachment= (com.github.tommyettinger.jsonbiter.any.Any)iter.readAny();
continue;
}
break;

}
iter.skip();
}
return obj;
}public java.lang.Object decode(com.github.tommyettinger.jsonbiter.JsonIterator iter) throws java.io.IOException {
return decode_(iter);
}
}
