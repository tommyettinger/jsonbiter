package com.github.tommyettinger.jsonbiter.suite;

import com.github.tommyettinger.jsonbiter.StreamingCategory;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.ExcludeCategory(StreamingCategory.class)
@Suite.SuiteClasses({AllTestCases.class})
public class NonStreamingTests {

}
