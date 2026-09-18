package com.github.tommyettinger.jsonbiter.suite;

import com.github.tommyettinger.jsonbiter.extra.TestBase64;
import com.github.tommyettinger.jsonbiter.extra.TestNamingStrategy;
import com.github.tommyettinger.jsonbiter.extra.TestPreciseFloat;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestBase64.class, TestNamingStrategy.class, TestPreciseFloat.class})
public class ExtraTests {

}
