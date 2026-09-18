package com.github.tommyettinger.jsonbiter.suite;

import com.github.tommyettinger.jsonbiter.*;
import com.github.tommyettinger.jsonbiter.TestFloat;
import com.github.tommyettinger.jsonbiter.TestGenerics;
import com.github.tommyettinger.jsonbiter.TestNested;
import com.github.tommyettinger.jsonbiter.TestObject;
import com.github.tommyettinger.jsonbiter.TestString;
import com.github.tommyettinger.jsonbiter.output.*;
import com.github.tommyettinger.jsonbiter.output.TestAnnotationJsonIgnore;
import com.github.tommyettinger.jsonbiter.output.TestAnnotationJsonProperty;
import com.github.tommyettinger.jsonbiter.output.TestArray;
import com.github.tommyettinger.jsonbiter.output.TestInteger;
import com.github.tommyettinger.jsonbiter.output.TestMap;
import com.github.tommyettinger.jsonbiter.any.TestList;
import com.github.tommyettinger.jsonbiter.any.TestLong;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        com.github.tommyettinger.jsonbiter.TestAnnotationJsonIgnore.class,
        TestAnnotationJsonIgnore.class,
        com.github.tommyettinger.jsonbiter.TestAnnotationJsonProperty.class,
        TestAnnotationJsonProperty.class,
        TestAnnotationJsonWrapper.class,
        TestAnnotationJsonUnwrapper.class,
        TestAnnotation.class,
        TestAnnotationJsonCreator.class,
        TestGenerics.class,
        TestCustomizeType.class, TestDemo.class,
        TestExisting.class, TestGenerics.class, TestGenerics.class, TestIO.class,
        TestNested.class,
        com.github.tommyettinger.jsonbiter.output.TestNested.class,
        TestObject.class,
        TestObject.class,
        TestReadAny.class, TestSkip.class, TestSlice.class,
        TestString.class,
        TestString.class,
        TestWhatIsNext.class,
        TestAny.class,
        TestArray.class,
        com.github.tommyettinger.jsonbiter.any.TestArray.class,
        com.github.tommyettinger.jsonbiter.TestArray.class,
        TestSpiPropertyEncoder.class,
        com.github.tommyettinger.jsonbiter.TestMap.class,
        TestMap.class,
        TestNative.class,
        TestBoolean.class, TestFloat.class, TestFloat.class,
        TestList.class, TestInteger.class, TestInteger.class,
        TestSpiTypeEncoder.class,
        TestSpiTypeDecoder.class,
        TestSpiPropertyDecoder.class,
        TestStreamBuffer.class,
        IterImplForStreamingTest.class,
        TestCollection.class,
        TestList.class,
        TestAnnotationJsonObject.class,
        TestLong.class,
        TestOmitValue.class})
public abstract class AllTestCases {
}
