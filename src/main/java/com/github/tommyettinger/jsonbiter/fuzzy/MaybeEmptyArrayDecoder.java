package com.github.tommyettinger.jsonbiter.fuzzy;

import com.github.tommyettinger.jsonbiter.JsonIterator;
import com.github.tommyettinger.jsonbiter.ValueType;
import com.github.tommyettinger.jsonbiter.spi.Binding;
import com.github.tommyettinger.jsonbiter.spi.Decoder;

import java.io.IOException;

public class MaybeEmptyArrayDecoder implements Decoder {

    private Binding binding;

    public MaybeEmptyArrayDecoder(Binding binding) {
        this.binding = binding;
    }

    @Override
    public Object decode(JsonIterator iter) throws IOException {
        if (iter.whatIsNext() == ValueType.ARRAY) {
            if (iter.readArray()) {
                throw iter.reportError("MaybeEmptyArrayDecoder", "this field is object. if input is array, it can only be empty");
            } else {
                // empty array parsed as null
                return null;
            }
        } else {
            return iter.read(binding.valueTypeLiteral);
        }
    }
}
