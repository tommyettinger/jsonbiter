package com.github.tommyettinger.jsonbiter.output;

public enum EncodingMode {
    /**
     * statically codegen
     */
    STATIC_MODE,
    /**
     * decoding only using reflection, do not need code generation
     */
    REFLECTION_MODE
}
