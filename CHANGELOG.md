# 1.0.0

* Forked from jsoniter (hard fork, left network)
* Merged jsoniter's PR 345 by jefimm https://github.com/json-iterator/java/pull/345
* Removed dynamic encoder and decoder modes, including optional dependency on Javassist; they didn't work on JDK 9+
* Removed optional dependencies on Jackson and Gson, along with their compatibility code
* Remove nullity checks for items and collection values, which weren't compatible with reflection mode
* Fix streaming code without dynamic mode being needed and without any class rewriting at runtime
* Replace String.format() usage with String concatenation, for possible GWT support
* Make extra/JdkDatetimeSupport write Dates as long values to avoid java.text (GWT support)
* ~~Add jsonbiter.gwt.xml file, also to try to support GWT~~ Reflection usage makes GWT non-viable.
* Changed package from com.jsoniter to com.github.tommyettinger.jsonbiter , so both libraries can be tested at once
