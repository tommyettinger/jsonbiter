package com.github.tommyettinger.jsonbiter.fuzzy;

import com.github.tommyettinger.jsonbiter.CodegenAccess;
import com.github.tommyettinger.jsonbiter.JsonIterator;
import com.github.tommyettinger.jsonbiter.spi.Decoder;

import java.io.IOException;

public class StringLongDecoder extends Decoder.LongDecoder {

    @Override
    public long decodeLong(JsonIterator iter) throws IOException {
        byte c = CodegenAccess.nextToken(iter);
        if (c != '"') {
            throw iter.reportError("StringLongDecoder", "expect \", but found: " + (char) c);
        }
        long val = iter.readLong();
        c = CodegenAccess.nextToken(iter);
        if (c != '"') {
            throw iter.reportError("StringLongDecoder", "expect \", but found: " + (char) c);
        }
        return val;
    }
}
