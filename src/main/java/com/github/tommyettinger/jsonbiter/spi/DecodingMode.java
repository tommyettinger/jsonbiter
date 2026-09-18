package com.github.tommyettinger.jsonbiter.spi;

public enum DecodingMode {
    /**
     * statically codegen
     */
    STATIC_MODE,
    /**
     * decoding only using reflection, do not need code generation
     */
    REFLECTION_MODE
}
