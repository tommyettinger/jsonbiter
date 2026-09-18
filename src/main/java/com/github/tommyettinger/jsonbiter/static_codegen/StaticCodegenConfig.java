package com.github.tommyettinger.jsonbiter.static_codegen;

import com.github.tommyettinger.jsonbiter.spi.TypeLiteral;

public interface StaticCodegenConfig {
    /**
     * register decoder/encoder before codegen
     * register extension before codegen
     */
    void setup();

    /**
     * what to codegen
     * @return generate encoder/decoder for the types
     */
    TypeLiteral[] whatToCodegen();
}
