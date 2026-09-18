package com.github.tommyettinger.jsonbiter.fuzzy;

import com.github.tommyettinger.jsonbiter.CodegenAccess;
import com.github.tommyettinger.jsonbiter.JsonIterator;
import com.github.tommyettinger.jsonbiter.spi.Decoder;

import java.io.IOException;

public class MaybeStringFloatDecoder extends Decoder.FloatDecoder {

    @Override
    public float decodeFloat(JsonIterator iter) throws IOException {
        byte c = CodegenAccess.nextToken(iter);
        if (c != '"') {
            CodegenAccess.unreadByte(iter);
            return iter.readFloat();
        }
        float val = iter.readFloat();
        c = CodegenAccess.nextToken(iter);
        if (c != '"') {
            throw iter.reportError("StringFloatDecoder", "expect \", but found: " + (char) c);
        }
        return val;
    }
}
