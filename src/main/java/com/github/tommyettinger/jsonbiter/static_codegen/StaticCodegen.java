package com.github.tommyettinger.jsonbiter.static_codegen;

import com.github.tommyettinger.jsonbiter.output.CodegenAccess;
import com.github.tommyettinger.jsonbiter.spi.DecodingMode;
import com.github.tommyettinger.jsonbiter.JsonIterator;
import com.github.tommyettinger.jsonbiter.output.EncodingMode;
import com.github.tommyettinger.jsonbiter.output.JsonStream;
import com.github.tommyettinger.jsonbiter.spi.JsonException;

import java.io.File;

/**
 * The {@link #main(String...)} method here can be called from your code, not just at the command line.
 * It expects the package and name of a class that extends {@link StaticCodegenConfig}, and can optionally
 * take an output directory. The class in the first argument should be on the classpath.
 * <br>
 * The simplest way to use this is to have a file with contents like this in your project source root:
 * <pre>
 * <code>
 * public class StaticGenerator {
 *     public static void main(String[] args) throws Exception {
 *         com.github.tommyettinger.jsonbiter.static_codegen.StaticCodegen.main("my.project.MyCodegenConfig");
 *     }
 * }
 * </code>
 * </pre>
 * Which you can then run with the working directory set to the project source root to generate files there.
 */
public class StaticCodegen {
    public static void main(String... args) throws Exception {
        if (args.length == 0) {
            System.out.println("StaticCodegen configClassName [outputDir]");
            System.out.println("configClassName: like a.b.Config, a class extending StaticCodegenConfig");
            System.out.println("outputDir: if not specified, will write to source directory of configClass");
            return;
        }
        String configClassName = args[0];
        String configJavaFile = configClassName.replace('.', '/') + ".java";
        String outputDir;
        if (args.length > 1) {
            outputDir = args[1];
        } else {
            if (!new File(configJavaFile).exists()) {
                throw new JsonException("must execute static code generator in the java source code directory which contains: " + configJavaFile);
            }
            outputDir = new File(".").getAbsolutePath();
        }
        Class<?> clazz = Class.forName(configClassName);
        StaticCodegenConfig config = (StaticCodegenConfig) clazz.newInstance();
        JsonIterator.setMode(DecodingMode.REFLECTION_MODE);
        JsonStream.setMode(EncodingMode.REFLECTION_MODE);
        config.setup();
        com.github.tommyettinger.jsonbiter.CodegenAccess.staticGenDecoders(
                config.whatToCodegen(), new com.github.tommyettinger.jsonbiter.CodegenAccess.StaticCodegenTarget(outputDir));
        CodegenAccess.staticGenEncoders(
                config.whatToCodegen(), new CodegenAccess.StaticCodegenTarget(outputDir));
    }
}
