package com.github.tommyettinger.jsonbiter.spi;

import java.lang.reflect.Type;

public interface OmitValue {

    boolean shouldOmit(Object val);

    String prefix();
    
    String suffix();

    class Null implements OmitValue {

        @Override
        public boolean shouldOmit(Object val) {
            return val == null;
        }

        @Override
        public String prefix() {
            return "null == ";
        }

        @Override
        public String suffix() {
            return "";
        }
    }

    class ZeroByte implements OmitValue {

        @Override
        public boolean shouldOmit(Object val) {
            return (Byte) val == 0;
        }

        @Override
        public String prefix() {
            return "0 == ";
        }

        @Override
        public String suffix() {
            return "";
        }
    }

    class ZeroShort implements OmitValue {

        @Override
        public boolean shouldOmit(Object val) {
            return (Short) val == 0;
        }

        @Override
        public String prefix() {
            return "0 == ";
        }

        @Override
        public String suffix() {
            return "";
        }
    }

    class ZeroInt implements OmitValue {

        @Override
        public boolean shouldOmit(Object val) {
            return ((Integer) val) == 0;
        }

        @Override
        public String prefix() {
            return "0 == ";
        }

        @Override
        public String suffix() {
            return "";
        }
    }

    class ZeroLong implements OmitValue {

        @Override
        public boolean shouldOmit(Object val) {
            return ((Long) val) == 0;
        }

        @Override
        public String prefix() {
            return "0 == ";
        }

        @Override
        public String suffix() {
            return "";
        }
    }

    class ZeroFloat implements OmitValue {

        @Override
        public boolean shouldOmit(Object val) {
            return ((Float) val) == 0;
        }

        @Override
        public String prefix() {
            return "0 == ";
        }

        @Override
        public String suffix() {
            return "";
        }
    }

    class ZeroDouble implements OmitValue {

        @Override
        public boolean shouldOmit(Object val) {
            return ((Double) val) == 0;
        }

        @Override
        public String prefix() {
            return "0 == ";
        }

        @Override
        public String suffix() {
            return "";
        }
    }

    class ZeroChar implements OmitValue {

        @Override
        public boolean shouldOmit(Object val) {
            return (Character) val == 0;
        }

        @Override
        public String prefix() {
            return "0 == ";
        }

        @Override
        public String suffix() {
            return "";
        }
    }

    class False implements OmitValue {

        @Override
        public boolean shouldOmit(Object val) {
            return !((Boolean) val);
        }

        @Override
        public String prefix() {
            return "!";
        }

        @Override
        public String suffix() {
            return "";
        }
    }

    class Parsed implements OmitValue {

        private final Object defaultValue;
        private final String prefix, suffix;

        public Parsed(Object defaultValue, String prefix, String suffix) {
            this.defaultValue = defaultValue;
            this.prefix = prefix;
            this.suffix = suffix;
        }

        public static OmitValue parse(Type valueType, String defaultValueToOmit) {
            if ("void".equals(defaultValueToOmit)) {
                return null;
            } else if ("null".equals(defaultValueToOmit)) {
                return new OmitValue.Null();
            } else if (boolean.class.equals(valueType)) {
                Boolean defaultValue = Boolean.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + " == ", "");
            } else if (Boolean.class.equals(valueType)) {
                Boolean defaultValue = Boolean.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + " == ", ".booleanValue()");
            } else if (int.class.equals(valueType)) {
                Integer defaultValue = Integer.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + " == ", "");
            } else if (Integer.class.equals(valueType)) {
                Integer defaultValue = Integer.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + " == ", ".intValue()");
            } else if (byte.class.equals(valueType)) {
                Byte defaultValue = Byte.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + " == ", "");
            } else if (Byte.class.equals(valueType)) {
                Byte defaultValue = Byte.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + " == ", ".byteValue()");
            } else if (short.class.equals(valueType)) {
                Short defaultValue = Short.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + " == ", "");
            } else if (Short.class.equals(valueType)) {
                Short defaultValue = Short.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + " == ", ".shortValue()");
            } else if (long.class.equals(valueType)) {
                Long defaultValue = Long.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + "L == ", "");
            } else if (Long.class.equals(valueType)) {
                Long defaultValue = Long.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + "L == ", ".longValue()");
            } else if (float.class.equals(valueType)) {
                Float defaultValue = Float.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + "F == ", "");
            } else if (Float.class.equals(valueType)) {
                Float defaultValue = Float.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + "F == ", ".floatValue()");
            } else if (double.class.equals(valueType)) {
                Double defaultValue = Double.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + "D == ", "");
            } else if (Double.class.equals(valueType)) {
                Double defaultValue = Double.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + "D == ", ".doubleValue()");
            } else if (char.class.equals(valueType) && defaultValueToOmit.length() == 1) {
                Character defaultValue = defaultValueToOmit.charAt(0);
                return new OmitValue.Parsed(defaultValue, "'" + defaultValueToOmit + "' == ", "");
            } else if (Character.class.equals(valueType) && defaultValueToOmit.length() == 1) {
                Character defaultValue = defaultValueToOmit.charAt(0);
                return new OmitValue.Parsed(defaultValue, "'" + defaultValueToOmit + "' == ", ".charValue()");
            } else {
                throw new UnsupportedOperationException("failed to parse defaultValueToOmit: " + defaultValueToOmit);
            }
        }

        @Override
        public boolean shouldOmit(Object val) {
            return defaultValue.equals(val);
        }

        @Override
        public String prefix() {
            return prefix;
        }

        @Override
        public String suffix() {
            return suffix;
        }
    }
}
