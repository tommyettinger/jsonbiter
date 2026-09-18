package com.github.tommyettinger.jsonbiter.fuzzy;

import com.github.tommyettinger.jsonbiter.CodegenAccess;
import com.github.tommyettinger.jsonbiter.JsonIterator;
import com.github.tommyettinger.jsonbiter.spi.Decoder;

import java.io.IOException;

public class StringShortDecoder extends Decoder.ShortDecoder {

    @Override
    public short decodeShort(JsonIterator iter) throws IOException {
        byte c = CodegenAccess.nextToken(iter);
        if (c != '"') {
            throw iter.reportError("StringShortDecoder", "expect \", but found: " + (char) c);
        }
        short val = iter.readShort();
        c = CodegenAccess.nextToken(iter);
        if (c != '"') {
            throw iter.reportError("StringShortDecoder", "expect \", but found: " + (char) c);
        }
        return val;
    }
}
