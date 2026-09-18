package com.github.tommyettinger.jsonbiter.fuzzy;

import com.github.tommyettinger.jsonbiter.CodegenAccess;
import com.github.tommyettinger.jsonbiter.JsonIterator;
import com.github.tommyettinger.jsonbiter.spi.Decoder;

import java.io.IOException;

public class MaybeStringIntDecoder extends Decoder.IntDecoder {

    @Override
    public int decodeInt(JsonIterator iter) throws IOException {
        byte c = CodegenAccess.nextToken(iter);
        if (c != '"') {
            CodegenAccess.unreadByte(iter);
            return iter.readInt();
        }
        int val = iter.readInt();
        c = CodegenAccess.nextToken(iter);
        if (c != '"') {
            throw iter.reportError("StringIntDecoder", "expect \", but found: " + (char) c);
        }
        return val;
    }
}
