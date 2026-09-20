# JsonBiter

Fork of jsoniter, https://github.com/json-iterator/java , which appears unmaintained.

This fork removes more than it adds; jsoniter had a "dynamic mode" that only worked on Java 8 and older.
This removes that mode, leaving "reflection mode" and "static mode".
That means JsonBiter is **compatible with Java 8 and all later versions**.
It does not use `sun.misc.Unsafe` nor does it generate classes/bytecode at runtime.
It can use reflection, and usually does, to exchange JSON with Java objects.

## Get!

You can depend on this library via [JitPack.io](https://jitpack.io/#tommyettinger/jsonbiter/).
Currently, you'll want a recent commit, but a stable version 1.0.0 should be released soon.

Using Gradle:

```gradle
dependencies {
    implementation 'com.github.tommyettinger:jsonbiter:ed9519a9ac'
}
```

Or using Maven:

```xml
	<dependency>
	    <groupId>com.github.tommyettinger</groupId>
	    <artifactId>jsonbiter</artifactId>
	    <version>ed9519a9ac</version>
	</dependency>
```

## Why?

You might want to use this library because:

 - It has rather fast JSON reading support, even using reflection.
 - It never uses internal parts of the JDK scheduled for removal.
 - If you want to use an iterator-based approach to reading JSON, this is a good fit.

You might not want to use this library because:

 - It isn't GWT-compatible, though it *might* be able to work on TeaVM.
 - Heavy usage of reflection may not work well on some platforms, like GraalVM Native Image.
 - Writing JSON with this isn't as fast as with some competing libraries, like ForyJson.

In addition to removing dynamic mode, this also removes an ancient Android demo.

## License

This project is [MIT Licensed](LICENSE).
