package com.github.tommyettinger.jsonbiter;

import com.github.tommyettinger.jsonbiter.any.Any;
import com.github.tommyettinger.jsonbiter.spi.Slice;

import java.io.IOException;

final class IterImpl {
    private IterImpl() {}

    public static IterSurface INSTANCE = new IterImplNonStreaming();

    public static Slice readObjectFieldAsSlice(JsonIterator iter) throws IOException {
        return INSTANCE.readObjectFieldAsSlice(iter);
    }

    public static void skipArray(JsonIterator iter) throws IOException {
        INSTANCE.skipArray(iter);
    }

    public static void skipObject(JsonIterator iter) throws IOException{
        INSTANCE.skipObject(iter);
    }

    public static void skipString(JsonIterator iter) throws IOException{
        INSTANCE.skipString(iter);
    }

    public static void skipUntilBreak(JsonIterator iter) throws IOException{
        INSTANCE.skipUntilBreak(iter);
    }

    public static boolean skipNumber(JsonIterator iter) throws IOException{
        return INSTANCE.skipNumber(iter);
    }

    public static Slice readSlice(JsonIterator iter) throws IOException{
        return INSTANCE.readSlice(iter);
    }

    public static byte nextToken(JsonIterator iter) throws IOException{
        return INSTANCE.nextToken(iter);
    }

    public static byte readByte(JsonIterator iter) throws IOException{
        return INSTANCE.readByte(iter);
    }

    public static Any readAny(JsonIterator iter) throws IOException{
        return INSTANCE.readAny(iter);
    }

    public static void skipFixedBytes(JsonIterator iter, int n) throws IOException{
        INSTANCE.skipFixedBytes(iter, n);
    }

    public static boolean loadMore(JsonIterator iter) throws IOException{
        return INSTANCE.loadMore(iter);
    }

    public static int readStringSlowPath(JsonIterator iter, int j) throws IOException{
        return INSTANCE.readStringSlowPath(iter, j);
    }

    public static int updateStringCopyBound(JsonIterator iter, int bound){
        return INSTANCE.updateStringCopyBound(iter, bound);
    }

    public static int readInt(JsonIterator iter, byte c) throws IOException{
        return INSTANCE.readInt(iter, c);
    }

    public static long readLong(JsonIterator iter, byte c) throws IOException{
        return INSTANCE.readLong(iter, c);
    }

    public static double readDouble(JsonIterator iter) throws IOException{
        return INSTANCE.readDouble(iter);
    }


    public static void assertNotLeadingZero(JsonIterator iter) throws IOException {
        try {
            byte nextByte = iter.buf[iter.head++];
            iter.unreadByte();
            int ind2 = IterImplNumber.intDigits[nextByte];
            if (ind2 == IterImplNumber.INVALID_CHAR_FOR_NUMBER) {
                return;
            }
            throw iter.reportError("assertNotLeadingZero", "leading zero is invalid");
        } catch (ArrayIndexOutOfBoundsException e) {
            iter.head = iter.tail;
        }
    }
    public static long readLongSlowPath(final JsonIterator iter, long value) throws IOException {
        value = -value; // add negatives to avoid redundant checks for Long.MIN_VALUE on each iteration
        long multmin = -922337203685477580L; // limit / 10
        for (; ; ) {
            for (int i = iter.head; i < iter.tail; i++) {
                int ind = IterImplNumber.intDigits[iter.buf[i]];
                if (ind == IterImplNumber.INVALID_CHAR_FOR_NUMBER) {
                    iter.head = i;
                    return value;
                }
                if (value < multmin) {
                    throw iter.reportError("readLongSlowPath", "value is too large for long");
                }
                value = (value << 3) + (value << 1) - ind;
                if (value >= 0) {
                    throw iter.reportError("readLongSlowPath", "value is too large for long");
                }
            }
            if (!loadMore(iter)) {
                iter.head = iter.tail;
                return value;
            }
        }
    }

    public static int readIntSlowPath(final JsonIterator iter, int value) throws IOException {
        value = -value; // add negatives to avoid redundant checks for Integer.MIN_VALUE on each iteration
        int multmin = -214748364; // limit / 10
        for (; ; ) {
            for (int i = iter.head; i < iter.tail; i++) {
                int ind = IterImplNumber.intDigits[iter.buf[i]];
                if (ind == IterImplNumber.INVALID_CHAR_FOR_NUMBER) {
                    iter.head = i;
                    return value;
                }
                if (value < multmin) {
                    throw iter.reportError("readIntSlowPath", "value is too large for int");
                }
                value = (value << 3) + (value << 1) - ind;
                if (value >= 0) {
                    throw iter.reportError("readIntSlowPath", "value is too large for int");
                }
            }
            if (!loadMore(iter)) {
                iter.head = iter.tail;
                return value;
            }
        }
    }

    public static double readDoubleSlowPath(final JsonIterator iter) throws IOException {
        try {
            NumberChars numberChars = readNumber(iter);
            if (numberChars.charsLength == 0 && iter.whatIsNext() == ValueType.STRING) {
                String possibleInf = iter.readString();
                if ("infinity".equals(possibleInf)) {
                    return Double.POSITIVE_INFINITY;
                }
                if ("-infinity".equals(possibleInf)) {
                    return Double.NEGATIVE_INFINITY;
                }
                throw iter.reportError("readDoubleSlowPath", "expect number but found string: " + possibleInf);
            }
            return Double.valueOf(new String(numberChars.chars, 0, numberChars.charsLength));
        } catch (NumberFormatException e) {
            throw iter.reportError("readDoubleSlowPath", e.toString());
        }
    }
    public static class NumberChars {
        char[] chars;
        int charsLength;
        boolean dotFound;
    }

    public static NumberChars readNumber(final JsonIterator iter) throws IOException {
        int j = 0;
        boolean dotFound = false;
        for (; ; ) {
            for (int i = iter.head; i < iter.tail; i++) {
                if (j == iter.reusableChars.length) {
                    char[] newBuf = new char[iter.reusableChars.length * 2];
                    System.arraycopy(iter.reusableChars, 0, newBuf, 0, iter.reusableChars.length);
                    iter.reusableChars = newBuf;
                }
                byte c = iter.buf[i];
                switch (c) {
                    case '.':
                    case 'e':
                    case 'E':
                        dotFound = true;
                        // fallthrough
                    case '-':
                    case '+':
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        iter.reusableChars[j++] = (char) c;
                        break;
                    default:
                        iter.head = i;
                        NumberChars numberChars = new NumberChars();
                        numberChars.chars = iter.reusableChars;
                        numberChars.charsLength = j;
                        numberChars.dotFound = dotFound;
                        return numberChars;
                }
            }
            if (!loadMore(iter)) {
                iter.head = iter.tail;
                NumberChars numberChars = new NumberChars();
                numberChars.chars = iter.reusableChars;
                numberChars.charsLength = j;
                numberChars.dotFound = dotFound;
                return numberChars;
            }
        }
    }

}