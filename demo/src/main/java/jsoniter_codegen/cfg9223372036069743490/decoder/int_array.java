package jsoniter_codegen.cfg9223372036069743490.decoder;
public class int_array implements com.github.tommyettinger.jsonbiter.spi.Decoder {
public static java.lang.Object decode_(com.github.tommyettinger.jsonbiter.JsonIterator iter) throws java.io.IOException { com.github.tommyettinger.jsonbiter.CodegenAccess.resetExistingObject(iter);
byte nextToken = com.github.tommyettinger.jsonbiter.CodegenAccess.readByte(iter);
if (nextToken != '[') {
if (nextToken == 'n') {
com.github.tommyettinger.jsonbiter.CodegenAccess.skipFixedBytes(iter, 3);
com.github.tommyettinger.jsonbiter.CodegenAccess.resetExistingObject(iter); return null;
} else {
nextToken = com.github.tommyettinger.jsonbiter.CodegenAccess.nextToken(iter);
if (nextToken == 'n') {
com.github.tommyettinger.jsonbiter.CodegenAccess.skipFixedBytes(iter, 3);
com.github.tommyettinger.jsonbiter.CodegenAccess.resetExistingObject(iter); return null;
}
}
}
nextToken = com.github.tommyettinger.jsonbiter.CodegenAccess.nextToken(iter);
if (nextToken == ']') {
return new int[0];
}
com.github.tommyettinger.jsonbiter.CodegenAccess.unreadByte(iter);
int a1 = (int)iter.readInt();
if (!com.github.tommyettinger.jsonbiter.CodegenAccess.nextTokenIsComma(iter)) {
return new int[]{ a1 };
}
int a2 = (int)iter.readInt();
if (!com.github.tommyettinger.jsonbiter.CodegenAccess.nextTokenIsComma(iter)) {
return new int[]{ a1, a2 };
}
int a3 = (int)iter.readInt();
if (!com.github.tommyettinger.jsonbiter.CodegenAccess.nextTokenIsComma(iter)) {
return new int[]{ a1, a2, a3 };
}
int a4 = (int) (int)iter.readInt();
if (!com.github.tommyettinger.jsonbiter.CodegenAccess.nextTokenIsComma(iter)) {
return new int[]{ a1, a2, a3, a4 };
}
int a5 = (int) (int)iter.readInt();
int[] arr = new int[10];
arr[0] = a1;
arr[1] = a2;
arr[2] = a3;
arr[3] = a4;
arr[4] = a5;
int i = 5;
while (com.github.tommyettinger.jsonbiter.CodegenAccess.nextTokenIsComma(iter)) {
if (i == arr.length) {
int[] newArr = new int[arr.length * 2];
System.arraycopy(arr, 0, newArr, 0, arr.length);
arr = newArr;
}
arr[i++] = (int)iter.readInt();
}
int[] result = new int[i];
System.arraycopy(arr, 0, result, 0, i);
return result;
}public java.lang.Object decode(com.github.tommyettinger.jsonbiter.JsonIterator iter) throws java.io.IOException {
return decode_(iter);
}
}
