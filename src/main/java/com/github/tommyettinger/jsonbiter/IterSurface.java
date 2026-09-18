package com.github.tommyettinger.jsonbiter;

import com.github.tommyettinger.jsonbiter.any.Any;
import com.github.tommyettinger.jsonbiter.spi.Slice;

import java.io.IOException;

interface IterSurface {
    Slice readObjectFieldAsSlice(JsonIterator iter) throws IOException;

    void skipArray(JsonIterator iter) throws IOException;

    void skipObject(JsonIterator iter) throws IOException;

    void skipString(JsonIterator iter) throws IOException;

    void skipUntilBreak(JsonIterator iter) throws IOException;

    boolean skipNumber(JsonIterator iter) throws IOException;

    // read the bytes between " "
    Slice readSlice(JsonIterator iter) throws IOException;

    byte nextToken(JsonIterator iter) throws IOException;

    byte readByte(JsonIterator iter) throws IOException;

    Any readAny(JsonIterator iter) throws IOException;

    void skipFixedBytes(JsonIterator iter, int n) throws IOException;

    boolean loadMore(JsonIterator iter) throws IOException;

    int readStringSlowPath(JsonIterator iter, int j) throws IOException;

    int updateStringCopyBound(JsonIterator iter, int bound);

    int readInt(JsonIterator iter, byte c) throws IOException;

    long readLong(JsonIterator iter, byte c) throws IOException;

    double readDouble(JsonIterator iter) throws IOException;
}
