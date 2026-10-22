package com.google.crypto.tink.shaded.protobuf;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
final class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    static final int COMPLETE = 0;
    static final int MALFORMED = -1;
    static final int MAX_BYTES_PER_CHAR = 3;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final Processor processor = null;

    private static class DecodeUtil {
        private static char highSurrogate(int codePoint) {
            return (char) ((codePoint >>> 10) + okio.Utf8.HIGH_SURROGATE_HEADER);
        }

        private static boolean isNotTrailingByte(byte b) {
            if (b <= (-65)) goto L5;
            return true;
        L5:
            return false;
        }

        private static boolean isOneByte(byte b) {
            if (b < 0) goto L4;
            return true;
        L4:
            return false;
        }

        private static boolean isThreeBytes(byte b) {
            if (b >= (-16)) goto L5;
            return true;
        L5:
            return false;
        }

        private static boolean isTwoBytes(byte b) {
            if (b >= (-32)) goto L5;
            return true;
        L5:
            return false;
        }

        private static char lowSurrogate(int codePoint) {
            return (char) ((codePoint & 1023) + okio.Utf8.LOG_SURROGATE_HEADER);
        }

        private static int trailingByteValue(byte b) {
            return b & okio.Utf8.REPLACEMENT_BYTE;
        }

        private DecodeUtil() {
        }

        static /* synthetic */ void access$1000(byte r0, byte r1, byte r2, byte r3, char[] r4, int r5) throws InvalidProtocolBufferException {
            handleFourBytes(r0, r1, r2, r3, r4, r5);
        }

        static /* synthetic */ boolean access$400(byte r0) {
            return isOneByte(r0);
        }

        static /* synthetic */ void access$500(byte r0, char[] r1, int r2) {
            handleOneByte(r0, r1, r2);
        }

        static /* synthetic */ boolean access$600(byte r0) {
            return isTwoBytes(r0);
        }

        static /* synthetic */ void access$700(byte r0, byte r1, char[] r2, int r3) throws InvalidProtocolBufferException {
            handleTwoBytes(r0, r1, r2, r3);
        }

        static /* synthetic */ boolean access$800(byte r0) {
            return isThreeBytes(r0);
        }

        static /* synthetic */ void access$900(byte r0, byte r1, byte r2, char[] r3, int r4) throws InvalidProtocolBufferException {
            handleThreeBytes(r0, r1, r2, r3, r4);
        }

        private static void handleOneByte(byte byte1, char[] resultArr, int resultPos) {
            resultArr[resultPos] = (char) byte1;
        }

        private static void handleTwoBytes(byte byte1, byte byte2, char[] resultArr, int resultPos) throws InvalidProtocolBufferException {
            if (byte1 < (-62)) goto L9;
            if (isNotTrailingByte(byte2) == true) goto L9;
            resultArr[resultPos] = (char) (((byte1 & Ascii.US) << 6) | trailingByteValue(byte2));
            return;
        L9:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        private static void handleThreeBytes(byte byte1, byte byte2, byte byte3, char[] resultArr, int resultPos) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(byte2) == true) goto L15;
            if (byte1 != (-32)) goto L8;
            if (byte2 < (-96)) goto L15;
        L8:
            if (byte1 != (-19)) goto L11;
            if (byte2 >= (-96)) goto L15;
        L11:
            if (isNotTrailingByte(byte3) == true) goto L15;
            resultArr[resultPos] = (char) ((((byte1 & 15) << 12) | (trailingByteValue(byte2) << 6)) | trailingByteValue(byte3));
            return;
        L15:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        private static void handleFourBytes(byte byte1, byte byte2, byte byte3, byte byte4, char[] resultArr, int resultPos) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(byte2) == true) goto L13;
            if ((((byte1 << 28) + (byte2 + 112)) >> 30) != 0) goto L13;
            if (isNotTrailingByte(byte3) == true) goto L13;
            if (isNotTrailingByte(byte4) == true) goto L13;
            int r2 = ((((byte1 & 7) << 18) | (trailingByteValue(byte2) << 12)) | (trailingByteValue(byte3) << 6)) | trailingByteValue(byte4);
            resultArr[resultPos] = highSurrogate(r2);
            resultArr[resultPos + 1] = lowSurrogate(r2);
            return;
        L13:
            throw InvalidProtocolBufferException.invalidUtf8();
        }
    }

    static abstract class Processor {
        abstract String decodeUtf8(byte[] bytes, int index, int size) throws InvalidProtocolBufferException;

        abstract String decodeUtf8Direct(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException;

        abstract int encodeUtf8(CharSequence in, byte[] out, int offset, int length);

        abstract void encodeUtf8Direct(CharSequence in, ByteBuffer out);

        abstract int partialIsValidUtf8(int state, byte[] bytes, int index, int limit);

        abstract int partialIsValidUtf8Direct(final int state, final ByteBuffer buffer, int index, final int limit);

        Processor() {
        }

        final boolean isValidUtf8(byte[] bytes, int index, int limit) {
            if (partialIsValidUtf8(0, bytes, index, limit) != 0) goto L6;
            return true;
        L6:
            return false;
        }

        final boolean isValidUtf8(ByteBuffer buffer, int index, int limit) {
            if (partialIsValidUtf8(0, buffer, index, limit) != 0) goto L6;
            return true;
        L6:
            return false;
        }

        final int partialIsValidUtf8(final int state, final ByteBuffer buffer, int index, final int limit) {
            if (buffer.hasArray() == false) goto L7;
            int r0 = buffer.arrayOffset();
            return partialIsValidUtf8(state, buffer.array(), index + r0, r0 + limit);
        L7:
            if (buffer.isDirect() == false) goto L11;
            return partialIsValidUtf8Direct(state, buffer, index, limit);
        L11:
            return partialIsValidUtf8Default(state, buffer, index, limit);
        }

        final int partialIsValidUtf8Default(final int state, final ByteBuffer buffer, int index, final int limit) {
            if (state == 0) goto L55;
            if (index < limit) goto L5;
            return state;
        L5:
            byte r5 = (byte) state;
            if (r5 >= (-32)) goto L15;
            if (r5 < (-62)) goto L13;
            int r6 = index + 1;
            if (buffer.get(index) > (-65)) goto L13;
        L12:
            index = r6;
        L13:
            return -1;
        L15:
            if (r5 >= (-16)) goto L33;
            byte r7 = (byte) (~(state >> 8));
            if (r7 != 0) goto L23;
            int r8 = index + 1;
            byte r9 = buffer.get(index);
            if (r8 >= limit) goto L21;
            index = r8;
            r7 = r9;
            goto L23
        L21:
            return Utf8.access$000(r5, r9);
        L23:
            if (r7 <= (-65)) goto L25;
        L32:
            return -1;
        L25:
            if (r5 != (-32)) goto L28;
            if (r7 < (-96)) goto L32;
        L28:
            if (r5 != (-19)) goto L30;
            if (r7 >= (-96)) goto L32;
        L30:
            r6 = index + 1;
            if (buffer.get(index) <= (-65)) goto L12;
        L33:
            byte r0 = (byte) (~(state >> 8));
            if (r0 != 0) goto L40;
            int r10 = index + 1;
            r0 = buffer.get(index);
            if (r10 >= limit) goto L38;
            byte r11 = 0;
        L41:
            if (r11 != 0) goto L47;
            int r12 = r10 + 1;
            byte r13 = buffer.get(r10);
            if (r12 >= limit) goto L45;
            r11 = r13;
            r10 = r12;
            goto L47
        L45:
            return Utf8.access$100(r5, r0, r13);
        L47:
            if (r0 <= (-65)) goto L49;
        L53:
            return -1;
        L49:
            if ((((r5 << 28) + (r0 + 112)) >> 30) != 0) goto L53;
            if (r11 > (-65)) goto L53;
            index = r10 + 1;
            if (buffer.get(r10) <= (-65)) goto L55;
        L38:
            return Utf8.access$000(r5, r0);
        L40:
            r11 = (byte) (state >> 16);
            r10 = index;
        L55:
            return partialIsValidUtf8(buffer, index, limit);
        }

        private static int partialIsValidUtf8(final ByteBuffer buffer, int index, final int limit) {
            int r7 = index + Utf8.access$200(buffer, index, limit);
        L3:
            if (r7 >= limit) goto L4;
            int r0 = r7 + 1;
            byte r8 = buffer.get(r7);
            if (r8 >= 0) goto L51;
            if (r8 < (-32)) goto L10;
            if (r8 < (-16)) goto L22;
            if (r0 >= (limit - 2)) goto L41;
            int r1 = r0 + 1;
            byte r2 = buffer.get(r0);
            if (r2 > (-65)) goto L50;
            if ((((r8 << 28) + (r2 + 112)) >> 30) != 0) goto L50;
            int r9 = r1 + 1;
            if (buffer.get(r1) > (-65)) goto L50;
            r0 = r9 + 1;
            if (buffer.get(r9) <= (-65)) goto L51;
        L50:
            return -1;
        L41:
            return Utf8.access$300(buffer, r8, r0, limit - r0);
        L22:
            if (r0 >= (limit - 1)) goto L24;
            int r4 = r0 + 1;
            byte r3 = buffer.get(r0);
            if (r3 > (-65)) goto L37;
            if (r8 != (-32)) goto L31;
            if (r3 < (-96)) goto L37;
        L31:
            if (r8 != (-19)) goto L34;
            if (r3 >= (-96)) goto L37;
        L34:
            if (buffer.get(r4) > (-65)) goto L37;
            r7 = r4 + 1;
        L37:
            return -1;
        L24:
            return Utf8.access$300(buffer, r8, r0, limit - r0);
        L10:
            if (r0 >= limit) goto L11;
            if (r8 < (-62)) goto L18;
            if (buffer.get(r0) > (-65)) goto L18;
            r0 = r0 + 1;
        L18:
            return -1;
        L11:
            return r8;
        L51:
            r7 = r0;
            goto L3
        L4:
            return 0;
        }

        final String decodeUtf8(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
            if (buffer.hasArray() == false) goto L7;
            int r0 = buffer.arrayOffset();
            return decodeUtf8(buffer.array(), r0 + index, size);
        L7:
            if (buffer.isDirect() == false) goto L11;
            return decodeUtf8Direct(buffer, index, size);
        L11:
            return decodeUtf8Default(buffer, index, size);
        }

        final String decodeUtf8Default(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
            if (((index | size) | ((buffer.limit() - index) - size)) < 0) goto L42;
            int r10 = index + size;
            char[] r13 = new char[size];
            int r2 = 0;
        L5:
            if (index >= r10) goto L10;
            byte r3 = buffer.get(index);
            if (DecodeUtil.access$400(r3) == false) goto L10;
            index = index + 1;
            DecodeUtil.access$500(r3, r13, r2);
            r2 = r2 + 1;
        L10:
            int r7 = r2;
        L11:
            if (index >= r10) goto L40;
            int r4 = index + 1;
            byte r12 = buffer.get(index);
            if (DecodeUtil.access$400(r12) == true) goto L14;
            if (DecodeUtil.access$600(r12) == true) goto L23;
            if (DecodeUtil.access$800(r12) == true) goto L30;
            if (r4 >= (r10 - 2)) goto L38;
            int r5 = r4 + 1;
            byte r6 = buffer.get(r4);
            int r8 = r5 + 1;
            DecodeUtil.access$1000(r12, r6, buffer.get(r5), buffer.get(r8), r13, r7);
            index = r8 + 1;
            r7 = (r7 + 1) + 1;
            goto L11
        L38:
            throw InvalidProtocolBufferException.invalidUtf8();
        L30:
            if (r4 >= (r10 - 1)) goto L33;
            int r9 = r4 + 1;
            DecodeUtil.access$900(r12, buffer.get(r4), buffer.get(r9), r13, r7);
            index = r9 + 1;
            r7 = r7 + 1;
            goto L11
        L33:
            throw InvalidProtocolBufferException.invalidUtf8();
        L23:
            if (r4 >= r10) goto L26;
            DecodeUtil.access$700(r12, buffer.get(r4), r13, r7);
            index = r4 + 1;
            r7 = r7 + 1;
            goto L11
        L26:
            throw InvalidProtocolBufferException.invalidUtf8();
        L14:
            int r11 = r7 + 1;
            DecodeUtil.access$500(r12, r13, r7);
        L15:
            if (r4 >= r10) goto L20;
            byte r14 = buffer.get(r4);
            if (DecodeUtil.access$400(r14) == false) goto L20;
            r4 = r4 + 1;
            DecodeUtil.access$500(r14, r13, r11);
            r11 = r11 + 1;
        L20:
            index = r4;
            r7 = r11;
            goto L11
        L40:
            return new String(r13, 0, r7);
        L42:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(buffer.limit()), Integer.valueOf(index), Integer.valueOf(size)}));
        }

        final void encodeUtf8(CharSequence in, ByteBuffer out) {
            if (out.hasArray() == false) goto L6;
            int r3 = out.arrayOffset();
            Java8Compatibility.position(out, Utf8.encode(in, out.array(), out.position() + r3, out.remaining()) - r3);
            return;
        L6:
            if (out.isDirect() == false) goto L8;
            encodeUtf8Direct(in, out);
            return;
        L8:
            encodeUtf8Default(in, out);
        }

        final void encodeUtf8Default(CharSequence in, ByteBuffer out) {
            int r6 = in.length();
            int r0 = out.position();
            int r1 = 0;
        L4:
            if (r1 >= r6) goto L8;
            char r3 = in.charAt(r1);     // Catch: IndexOutOfBoundsException -> L55
            if (r3 >= 128) goto L8;
            out.put(r0 + r1, (byte) r3);     // Catch: IndexOutOfBoundsException -> L55
            r1 = r1 + 1;     // Catch: IndexOutOfBoundsException -> L55
        L53:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + in.charAt(r1) + " at index " + (out.position() + Math.max(r1, (r0 - out.position()) + 1)));
        L8:
            if (r1 != r6) goto L11;
            Java8Compatibility.position(out, r0 + r1);     // Catch: IndexOutOfBoundsException -> L55
            return;
        L11:
            r0 = r0 + r1;     // Catch: IndexOutOfBoundsException -> L55
        L12:
            if (r1 >= r6) goto L50;
            char r4 = in.charAt(r1);     // Catch: IndexOutOfBoundsException -> L55
            if (r4 >= 128) goto L18;
            out.put(r0, (byte) r4);     // Catch: IndexOutOfBoundsException -> L55
        L49:
            r1 = r1 + 1;     // Catch: IndexOutOfBoundsException -> L55
            r0 = r0 + 1;     // Catch: IndexOutOfBoundsException -> L55
            goto L12
        L18:
            if (r4 >= 2048) goto L24;
            int r5 = r0 + 1;
            out.put(r0, (byte) ((r4 >>> 6) | 192));     // Catch: IndexOutOfBoundsException -> L22
            out.put(r5, (byte) ((r4 & '?') | 128));     // Catch: IndexOutOfBoundsException -> L22
            r0 = r5;
        L22:
            r0 = r5;
            goto L53
        L24:
            if (r4 >= 55296) goto L26;
        L45:
            int r7 = r0 + 1;
            out.put(r0, (byte) ((r4 >>> '\f') | 224));     // Catch: IndexOutOfBoundsException -> L22
            r0 = r7 + 1;
            out.put(r7, (byte) (((r4 >>> 6) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L55
            out.put(r0, (byte) ((r4 & '?') | 128));     // Catch: IndexOutOfBoundsException -> L55
            goto L49
        L26:
            if (57343 < r4) goto L45;
            int r8 = r1 + 1;
            if (r8 == r6) goto L44;
            char r2 = in.charAt(r8);     // Catch: IndexOutOfBoundsException -> L54
            if (Character.isSurrogatePair(r4, r2) == false) goto L41;
            int r9 = Character.toCodePoint(r4, r2);     // Catch: IndexOutOfBoundsException -> L54
            int r10 = r0 + 1;
            out.put(r0, (byte) ((r9 >>> 18) | 240));     // Catch: IndexOutOfBoundsException -> L40
            r0 = r10 + 1;
            out.put(r10, (byte) (((r9 >>> 12) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L54
            r10 = r0 + 1;
            out.put(r0, (byte) (((r9 >>> 6) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L40
            out.put(r10, (byte) ((r9 & 63) | 128));     // Catch: IndexOutOfBoundsException -> L40
            r0 = r10;
            r1 = r8;
        L40:
            r0 = r10;
            goto L42
        L41:
            r1 = r8;
        L42:
            r1 = r8;
        L44:
            throw new UnpairedSurrogateException(r1, r6);     // Catch: IndexOutOfBoundsException -> L55
        L50:
            Java8Compatibility.position(out, r0);     // Catch: IndexOutOfBoundsException -> L55
        }
    }

    static final class SafeProcessor extends Processor {
        SafeProcessor() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        int partialIsValidUtf8(int state, byte[] bytes, int index, int limit) {
            if (state == 0) goto L55;
            if (index < limit) goto L5;
            return state;
        L5:
            byte r5 = (byte) state;
            if (r5 >= (-32)) goto L15;
            if (r5 < (-62)) goto L13;
            int r6 = index + 1;
            if (bytes[index] > (-65)) goto L13;
        L12:
            index = r6;
        L13:
            return -1;
        L15:
            if (r5 >= (-16)) goto L33;
            byte r7 = (byte) (~(state >> 8));
            if (r7 != 0) goto L23;
            int r8 = index + 1;
            byte r9 = bytes[index];
            if (r8 >= limit) goto L21;
            index = r8;
            r7 = r9;
            goto L23
        L21:
            return Utf8.access$000(r5, r9);
        L23:
            if (r7 <= (-65)) goto L25;
        L32:
            return -1;
        L25:
            if (r5 != (-32)) goto L28;
            if (r7 < (-96)) goto L32;
        L28:
            if (r5 != (-19)) goto L30;
            if (r7 >= (-96)) goto L32;
        L30:
            r6 = index + 1;
            if (bytes[index] <= (-65)) goto L12;
        L33:
            byte r0 = (byte) (~(state >> 8));
            if (r0 != 0) goto L40;
            int r10 = index + 1;
            r0 = bytes[index];
            if (r10 >= limit) goto L38;
            byte r11 = 0;
        L41:
            if (r11 != 0) goto L47;
            int r12 = r10 + 1;
            byte r13 = bytes[r10];
            if (r12 >= limit) goto L45;
            r11 = r13;
            r10 = r12;
            goto L47
        L45:
            return Utf8.access$100(r5, r0, r13);
        L47:
            if (r0 <= (-65)) goto L49;
        L53:
            return -1;
        L49:
            if ((((r5 << 28) + (r0 + 112)) >> 30) != 0) goto L53;
            if (r11 > (-65)) goto L53;
            index = r10 + 1;
            if (bytes[r10] <= (-65)) goto L55;
        L38:
            return Utf8.access$000(r5, r0);
        L40:
            r11 = (byte) (state >> 16);
            r10 = index;
        L55:
            return partialIsValidUtf8(bytes, index, limit);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        int partialIsValidUtf8Direct(int state, ByteBuffer buffer, int index, int limit) {
            return partialIsValidUtf8Default(state, buffer, index, limit);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        String decodeUtf8(byte[] bytes, int index, int size) throws InvalidProtocolBufferException {
            if (((index | size) | ((bytes.length - index) - size)) < 0) goto L42;
            int r10 = index + size;
            char[] r13 = new char[size];
            int r2 = 0;
        L5:
            if (index >= r10) goto L10;
            byte r3 = bytes[index];
            if (DecodeUtil.access$400(r3) == false) goto L10;
            index = index + 1;
            DecodeUtil.access$500(r3, r13, r2);
            r2 = r2 + 1;
        L10:
            int r7 = r2;
        L11:
            if (index >= r10) goto L40;
            int r4 = index + 1;
            byte r12 = bytes[index];
            if (DecodeUtil.access$400(r12) == true) goto L14;
            if (DecodeUtil.access$600(r12) == true) goto L23;
            if (DecodeUtil.access$800(r12) == true) goto L30;
            if (r4 >= (r10 - 2)) goto L38;
            int r5 = r4 + 1;
            byte r6 = bytes[r4];
            int r8 = r5 + 1;
            DecodeUtil.access$1000(r12, r6, bytes[r5], bytes[r8], r13, r7);
            index = r8 + 1;
            r7 = (r7 + 1) + 1;
            goto L11
        L38:
            throw InvalidProtocolBufferException.invalidUtf8();
        L30:
            if (r4 >= (r10 - 1)) goto L33;
            int r9 = r4 + 1;
            DecodeUtil.access$900(r12, bytes[r4], bytes[r9], r13, r7);
            index = r9 + 1;
            r7 = r7 + 1;
            goto L11
        L33:
            throw InvalidProtocolBufferException.invalidUtf8();
        L23:
            if (r4 >= r10) goto L26;
            DecodeUtil.access$700(r12, bytes[r4], r13, r7);
            index = r4 + 1;
            r7 = r7 + 1;
            goto L11
        L26:
            throw InvalidProtocolBufferException.invalidUtf8();
        L14:
            int r11 = r7 + 1;
            DecodeUtil.access$500(r12, r13, r7);
        L15:
            if (r4 >= r10) goto L20;
            byte r14 = bytes[r4];
            if (DecodeUtil.access$400(r14) == false) goto L20;
            r4 = r4 + 1;
            DecodeUtil.access$500(r14, r13, r11);
            r11 = r11 + 1;
        L20:
            index = r4;
            r7 = r11;
            goto L11
        L40:
            return new String(r13, 0, r7);
        L42:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bytes.length), Integer.valueOf(index), Integer.valueOf(size)}));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        String decodeUtf8Direct(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
            return decodeUtf8Default(buffer, index, size);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        int encodeUtf8(CharSequence in, byte[] out, int offset, int length) {
            int r6 = in.length();
            int r10 = length + offset;
            int r0 = 0;
        L4:
            if (r0 >= r6) goto L10;
            int r2 = r0 + offset;
            if (r2 >= r10) goto L10;
            char r3 = in.charAt(r0);
            if (r3 >= 128) goto L10;
            out[r2] = (byte) r3;
            r0 = r0 + 1;
        L10:
            if (r0 == r6) goto L12;
            int r9 = offset + r0;
        L14:
            if (r0 >= r6) goto L52;
            char r4 = in.charAt(r0);
            if (r4 >= 128) goto L21;
            if (r9 >= r10) goto L21;
            int r5 = r9 + 1;
            out[r9] = (byte) r4;
        L19:
            r9 = r5;
        L38:
            r0 = r0 + 1;
        L21:
            if (r4 >= 2048) goto L26;
            if (r9 > (r10 - 2)) goto L26;
            int r7 = r9 + 1;
            out[r9] = (byte) ((r4 >>> 6) | 960);
            r9 = r7 + 1;
            out[r7] = (byte) ((r4 & '?') | 128);
        L26:
            if (r4 < 55296) goto L29;
            if (57343 < r4) goto L29;
        L32:
            if (r9 > (r10 - 4)) goto L42;
            int r8 = r0 + 1;
            if (r8 == in.length()) goto L41;
            char r1 = in.charAt(r8);
            if (Character.isSurrogatePair(r4, r1) == false) goto L39;
            int r11 = Character.toCodePoint(r4, r1);
            int r12 = r9 + 1;
            out[r9] = (byte) ((r11 >>> 18) | 240);
            int r13 = r12 + 1;
            out[r12] = (byte) (((r11 >>> 12) & 63) | 128);
            int r14 = r13 + 1;
            out[r13] = (byte) (((r11 >>> 6) & 63) | 128);
            r9 = r14 + 1;
            out[r14] = (byte) ((r11 & 63) | 128);
            r0 = r8;
            goto L38
        L39:
            r0 = r8;
        L41:
            throw new UnpairedSurrogateException(r0 - 1, r6);
        L42:
            if (55296 > r4) goto L51;
            if (r4 > 57343) goto L51;
            int r15 = r0 + 1;
            if (r15 == in.length()) goto L49;
            if (Character.isSurrogatePair(r4, in.charAt(r15)) == true) goto L51;
        L49:
            throw new UnpairedSurrogateException(r0, r6);
        L51:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r4 + " at index " + r9);
        L29:
            if (r9 > (r10 - 3)) goto L32;
            int r16 = r9 + 1;
            out[r9] = (byte) ((r4 >>> '\f') | 480);
            int r17 = r16 + 1;
            out[r16] = (byte) (((r4 >>> 6) & 63) | 128);
            r5 = r17 + 1;
            out[r17] = (byte) ((r4 & '?') | 128);
            goto L19
        L52:
            return r9;
        L12:
            return offset + r6;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        void encodeUtf8Direct(CharSequence in, ByteBuffer out) {
            encodeUtf8Default(in, out);
        }

        private static int partialIsValidUtf8(byte[] bytes, int index, int limit) {
        L2:
            if (index >= limit) goto L6;
            if (bytes[index] < 0) goto L6;
            index = index + 1;
        L6:
            if (index < limit) goto L9;
            return 0;
        L9:
            return partialIsValidUtf8NonAscii(bytes, index, limit);
        }

        private static int partialIsValidUtf8NonAscii(byte[] bytes, int index, int limit) {
        L2:
            if (index >= limit) goto L3;
            int r0 = index + 1;
            byte r7 = bytes[index];
            if (r7 >= 0) goto L46;
            if (r7 < (-32)) goto L9;
            if (r7 < (-16)) goto L19;
            if (r0 >= (limit - 2)) goto L36;
            int r1 = r0 + 1;
            byte r2 = bytes[r0];
            if (r2 > (-65)) goto L45;
            if ((((r7 << 28) + (r2 + 112)) >> 30) != 0) goto L45;
            int r8 = r1 + 1;
            if (bytes[r1] > (-65)) goto L45;
            r0 = r8 + 1;
            if (bytes[r8] <= (-65)) goto L46;
        L45:
            return -1;
        L36:
            return Utf8.access$1100(bytes, r0, limit);
        L19:
            if (r0 >= (limit - 1)) goto L21;
            int r4 = r0 + 1;
            byte r3 = bytes[r0];
            if (r3 > (-65)) goto L32;
            if (r7 != (-32)) goto L28;
            if (r3 < (-96)) goto L32;
        L28:
            if (r7 != (-19)) goto L30;
            if (r3 >= (-96)) goto L32;
        L30:
            index = r4 + 1;
            if (bytes[r4] <= (-65)) goto L2;
        L32:
            return -1;
        L21:
            return Utf8.access$1100(bytes, r0, limit);
        L9:
            if (r0 >= limit) goto L10;
            if (r7 < (-62)) goto L15;
            index = r0 + 1;
            if (bytes[r0] <= (-65)) goto L2;
        L15:
            return -1;
        L10:
            return r7;
        L46:
            index = r0;
            goto L2
        L3:
            return 0;
        }
    }

    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int index, int length) {
            super("Unpaired surrogate at index " + index + " of " + length);
        }
    }

    static final class UnsafeProcessor extends Processor {
        UnsafeProcessor() {
        }

        static boolean isAvailable() {
            if (UnsafeUtil.hasUnsafeArrayOperations() == true) goto L5;
        L7:
            return false;
        L5:
            if (UnsafeUtil.hasUnsafeByteBufferOperations() == false) goto L7;
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        int partialIsValidUtf8(int state, byte[] bytes, final int index, final int limit) {
            byte r0 = 0;
            if (((index | limit) | (bytes.length - limit)) < 0) goto L63;
            long r1 = index;
            long r13 = limit;
            if (state == 0) goto L61;
            if (r1 < r13) goto L9;
            return state;
        L9:
            byte r10 = (byte) state;
            if (r10 >= (-32)) goto L19;
            if (r10 < (-62)) goto L17;
            long r6 = 1 + r1;
            if (UnsafeUtil.getByte(bytes, r1) > (-65)) goto L17;
            r1 = r6;
        L17:
            return -1;
        L19:
            if (r10 >= (-16)) goto L39;
            byte r11 = (byte) (~(state >> 8));
            if (r11 != 0) goto L27;
            long r8 = r1 + 1;
            r11 = UnsafeUtil.getByte(bytes, r1);
            if (r8 >= r13) goto L25;
            r1 = r8;
            goto L27
        L25:
            return Utf8.access$000(r10, r11);
        L27:
            if (r11 <= (-65)) goto L29;
        L38:
            return -1;
        L29:
            if (r10 != (-32)) goto L32;
            if (r11 < (-96)) goto L38;
        L32:
            if (r10 != (-19)) goto L34;
            if (r11 >= (-96)) goto L38;
        L34:
            long r12 = r1 + 1;
            if (UnsafeUtil.getByte(bytes, r1) > (-65)) goto L38;
        L37:
            r1 = r12;
            goto L61
        L39:
            byte r3 = (byte) (~(state >> 8));
            if (r3 != 0) goto L46;
            long r9 = r1 + 1;
            r3 = UnsafeUtil.getByte(bytes, r1);
            if (r9 >= r13) goto L44;
            r1 = r9;
        L47:
            if (r0 != 0) goto L53;
            long r14 = r1 + 1;
            r0 = UnsafeUtil.getByte(bytes, r1);
            if (r14 >= r13) goto L51;
            r1 = r14;
            goto L53
        L51:
            return Utf8.access$100(r10, r3, r0);
        L53:
            if (r3 <= (-65)) goto L55;
        L59:
            return -1;
        L55:
            if ((((r10 << 28) + (r3 + 112)) >> 30) != 0) goto L59;
            if (r0 > (-65)) goto L59;
            r12 = r1 + 1;
            if (UnsafeUtil.getByte(bytes, r1) <= (-65)) goto L37;
        L44:
            return Utf8.access$000(r10, r3);
        L46:
            r0 = (byte) (state >> 16);
        L61:
            return partialIsValidUtf8(bytes, r1, (int) (r13 - r1));
        L63:
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(bytes.length), Integer.valueOf(index), Integer.valueOf(limit)}));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        int partialIsValidUtf8Direct(final int state, ByteBuffer buffer, final int index, final int limit) {
            byte r0 = 0;
            if (((index | limit) | (buffer.limit() - limit)) < 0) goto L63;
            long r1 = UnsafeUtil.addressOffset(buffer) + ((long) index);
            long r11 = ((long) (limit - index)) + r1;
            if (state == 0) goto L61;
            if (r1 < r11) goto L9;
            return state;
        L9:
            byte r9 = (byte) state;
            if (r9 >= (-32)) goto L19;
            if (r9 < (-62)) goto L17;
            long r5 = 1 + r1;
            if (UnsafeUtil.getByte(r1) > (-65)) goto L17;
            r1 = r5;
        L17:
            return -1;
        L19:
            if (r9 >= (-16)) goto L39;
            byte r10 = (byte) (~(state >> 8));
            if (r10 != 0) goto L27;
            long r7 = r1 + 1;
            r10 = UnsafeUtil.getByte(r1);
            if (r7 >= r11) goto L25;
            r1 = r7;
            goto L27
        L25:
            return Utf8.access$000(r9, r10);
        L27:
            if (r10 <= (-65)) goto L29;
        L38:
            return -1;
        L29:
            if (r9 != (-32)) goto L32;
            if (r10 < (-96)) goto L38;
        L32:
            if (r9 != (-19)) goto L34;
            if (r10 >= (-96)) goto L38;
        L34:
            long r12 = r1 + 1;
            if (UnsafeUtil.getByte(r1) > (-65)) goto L38;
        L37:
            r1 = r12;
            goto L61
        L39:
            byte r13 = (byte) (~(state >> 8));
            if (r13 != 0) goto L46;
            long r8 = r1 + 1;
            r13 = UnsafeUtil.getByte(r1);
            if (r8 >= r11) goto L44;
            r1 = r8;
        L47:
            if (r0 != 0) goto L53;
            long r14 = r1 + 1;
            r0 = UnsafeUtil.getByte(r1);
            if (r14 >= r11) goto L51;
            r1 = r14;
            goto L53
        L51:
            return Utf8.access$100(r9, r13, r0);
        L53:
            if (r13 <= (-65)) goto L55;
        L59:
            return -1;
        L55:
            if ((((r9 << 28) + (r13 + 112)) >> 30) != 0) goto L59;
            if (r0 > (-65)) goto L59;
            r12 = r1 + 1;
            if (UnsafeUtil.getByte(r1) <= (-65)) goto L37;
        L44:
            return Utf8.access$000(r9, r13);
        L46:
            r0 = (byte) (state >> 16);
        L61:
            return partialIsValidUtf8(r1, (int) (r11 - r1));
        L63:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(buffer.limit()), Integer.valueOf(index), Integer.valueOf(limit)}));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        String decodeUtf8(byte[] bytes, int index, int size) throws InvalidProtocolBufferException {
            String r1 = new String(bytes, index, size, Internal.UTF_8);
            if (r1.contains("�") == true) goto L6;
            return r1;
        L6:
            if (Arrays.equals(r1.getBytes(Internal.UTF_8), Arrays.copyOfRange(bytes, index, size + index)) == false) goto L9;
            return r1;
        L9:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        String decodeUtf8Direct(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
            if (((index | size) | ((buffer.limit() - index) - size)) < 0) goto L46;
            long r5 = UnsafeUtil.addressOffset(buffer) + ((long) index);
            long r7 = ((long) size) + r5;
            char[] r0 = new char[size];
            int r1 = 0;
        L6:
            if (r5 >= r7) goto L11;
            byte r2 = UnsafeUtil.getByte(r5);
            if (DecodeUtil.access$400(r2) == false) goto L11;
            r5 = r5 + 1;
            DecodeUtil.access$500(r2, r0, r1);
            r1 = r1 + 1;
        L11:
            int r14 = r1;
        L13:
            if (r5 >= r7) goto L44;
            long r3 = r5 + 1;
            byte r9 = UnsafeUtil.getByte(r5);
            if (DecodeUtil.access$400(r9) == true) goto L16;
            if (DecodeUtil.access$600(r9) == true) goto L27;
            if (DecodeUtil.access$800(r9) == false) goto L39;
            if (r3 >= (r7 - 1)) goto L37;
            long r6 = r3 + 1;
            DecodeUtil.access$900(r9, UnsafeUtil.getByte(r3), UnsafeUtil.getByte(r6), r0, r14);
            r14 = r14 + 1;
            r5 = r6 + 1;
            goto L13
        L37:
            throw InvalidProtocolBufferException.invalidUtf8();
        L39:
            if (r3 >= (r7 - 2)) goto L42;
            long r8 = r3 + 1;
            byte r10 = UnsafeUtil.getByte(r3);
            long r4 = r8 + 1;
            byte r11 = UnsafeUtil.getByte(r8);
            r5 = r4 + 1;
            DecodeUtil.access$1000(r9, r10, r11, UnsafeUtil.getByte(r4), r0, r14);
            r1 = (r14 + 1) + 1;
            goto L11
        L42:
            throw InvalidProtocolBufferException.invalidUtf8();
        L27:
            if (r3 >= r7) goto L30;
            r5 = r3 + 1;
            DecodeUtil.access$700(r9, UnsafeUtil.getByte(r3), r0, r14);
            r14 = r14 + 1;
            goto L13
        L30:
            throw InvalidProtocolBufferException.invalidUtf8();
        L16:
            int r12 = r14 + 1;
            DecodeUtil.access$500(r9, r0, r14);
        L18:
            if (r3 >= r7) goto L23;
            byte r13 = UnsafeUtil.getByte(r3);
            if (DecodeUtil.access$400(r13) == false) goto L23;
            r3 = r3 + 1;
            DecodeUtil.access$500(r13, r0, r12);
            r12 = r12 + 1;
        L23:
            r14 = r12;
            r5 = r3;
            goto L13
        L44:
            return new String(r0, 0, r14);
        L46:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(buffer.limit()), Integer.valueOf(index), Integer.valueOf(size)}));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        int encodeUtf8(final CharSequence in, final byte[] out, final int offset, final int length) {
            long r4 = offset;
            long r6 = ((long) length) + r4;
            int r8 = in.length();
            if (r8 > length) goto L56;
            if ((out.length - length) < offset) goto L56;
            int r2 = 0;
        L7:
            char r3 = 128;
            long r11 = 1;
            if (r2 >= r8) goto L12;
            char r13 = in.charAt(r2);
            if (r13 >= 128) goto L12;
            UnsafeUtil.putByte(out, r4, (byte) r13);
            r2 = r2 + 1;
            r4 = 1 + r4;
        L12:
            if (r2 == r8) goto L14;
        L15:
            if (r2 >= r8) goto L54;
            char r14 = in.charAt(r2);
            if (r14 >= r3) goto L22;
            if (r4 >= r6) goto L22;
            long r15 = r4 + r11;
            UnsafeUtil.putByte(out, r4, (byte) r14);
            long r5 = r11;
            long r12 = r15;
            char r16 = r3;
        L39:
            r2 = r2 + 1;
            r3 = r16;
            long r18 = r5;
            r4 = r12;
            r11 = r18;
        L22:
            if (r14 >= 2048) goto L27;
            if (r4 > (r6 - 2)) goto L27;
            long r17 = r4 + r11;
            UnsafeUtil.putByte(out, r4, (byte) ((r14 >>> 6) | 960));
            long r7 = r17 + r11;
            UnsafeUtil.putByte(out, r17, (byte) ((r14 & '?') | 128));
            long r19 = r11;
            r16 = 128;
            r12 = r7;
            r5 = r19;
        L27:
            if (r14 < 55296) goto L30;
            if (57343 < r14) goto L30;
        L33:
            if (r4 > (r6 - 4)) goto L43;
            int r9 = r2 + 1;
            if (r9 == r8) goto L42;
            char r10 = in.charAt(r9);
            if (Character.isSurrogatePair(r14, r10) == false) goto L40;
            int r20 = Character.toCodePoint(r14, r10);
            long r110 = r4 + 1;
            UnsafeUtil.putByte(out, r4, (byte) ((r20 >>> 18) | 240));
            long r21 = r110 + 1;
            r16 = 128;
            UnsafeUtil.putByte(out, r110, (byte) (((r20 >>> 12) & 63) | 128));
            long r111 = r21 + 1;
            UnsafeUtil.putByte(out, r21, (byte) (((r20 >>> 6) & 63) | 128));
            r5 = 1;
            r12 = r111 + 1;
            UnsafeUtil.putByte(out, r111, (byte) ((r20 & 63) | 128));
            r2 = r9;
            goto L39
        L40:
            r2 = r9;
        L42:
            throw new UnpairedSurrogateException(r2 - 1, r8);
        L43:
            if (55296 > r14) goto L52;
            if (r14 > 57343) goto L52;
            int r1 = r2 + 1;
            if (r1 == r8) goto L50;
            if (Character.isSurrogatePair(r14, in.charAt(r1)) == true) goto L52;
        L50:
            throw new UnpairedSurrogateException(r2, r8);
        L52:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r14 + " at index " + r4);
        L30:
            if (r4 > (r6 - 3)) goto L33;
            long r112 = r4 + r11;
            UnsafeUtil.putByte(out, r4, (byte) ((r14 >>> '\f') | 480));
            long r22 = r112 + r11;
            UnsafeUtil.putByte(out, r112, (byte) (((r14 >>> 6) & 63) | 128));
            UnsafeUtil.putByte(out, r22, (byte) ((r14 & '?') | 128));
            r12 = r22 + 1;
            r5 = 1;
            r16 = 128;
            goto L39
        L54:
            return (int) r4;
        L14:
            return (int) r4;
        L56:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + in.charAt(r8 - 1) + " at index " + (offset + length));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.Processor
        void encodeUtf8Direct(CharSequence in, ByteBuffer out) {
            long r2 = UnsafeUtil.addressOffset(out);
            long r4 = ((long) out.position()) + r2;
            long r6 = ((long) out.limit()) + r2;
            int r8 = in.length();
            if (r8 > (r6 - r4)) goto L55;
            int r9 = 0;
        L5:
            char r12 = 128;
            if (r9 >= r8) goto L10;
            char r15 = in.charAt(r9);
            if (r15 >= 128) goto L10;
            UnsafeUtil.putByte(r4, (byte) r15);
            r9 = r9 + 1;
            r4 = r4 + 1;
        L10:
            if (r9 != r8) goto L13;
            Java8Compatibility.position(out, (int) (r4 - r2));
            return;
        L13:
            if (r9 >= r8) goto L52;
            char r16 = in.charAt(r9);
            if (r16 >= r12) goto L20;
            if (r4 >= r6) goto L20;
            UnsafeUtil.putByte(r4, (byte) r16);
            int r1 = r9;
            char r10 = r12;
            r4 = r4 + 1;
            long r17 = r2;
        L38:
            r12 = r10;
            r2 = r17;
            r6 = r6;
            r9 = r1 + 1;
        L20:
            if (r16 < 2048) goto L22;
        L25:
            r17 = r2;
            if (r16 < 55296) goto L29;
            if (57343 < r16) goto L29;
        L32:
            if (r4 > (r6 - 4)) goto L42;
            r1 = r9 + 1;
            if (r1 == r8) goto L41;
            char r3 = in.charAt(r1);
            if (Character.isSurrogatePair(r16, r3) == false) goto L39;
            int r5 = Character.toCodePoint(r16, r3);
            long r7 = r4 + 1;
            UnsafeUtil.putByte(r4, (byte) ((r5 >>> 18) | 240));
            long r11 = r7 + 1;
            r10 = 128;
            UnsafeUtil.putByte(r7, (byte) (((r5 >>> 12) & 63) | 128));
            long r13 = r11 + 1;
            UnsafeUtil.putByte(r11, (byte) (((r5 >>> 6) & 63) | 128));
            UnsafeUtil.putByte(r13, (byte) ((r5 & 63) | 128));
            r4 = r13 + 1;
            goto L38
        L39:
            r9 = r1;
        L41:
            throw new UnpairedSurrogateException(r9 - 1, r8);
        L42:
            if (55296 > r16) goto L51;
            if (r16 > 57343) goto L51;
            int r14 = r9 + 1;
            if (r14 == r8) goto L49;
            if (Character.isSurrogatePair(r16, in.charAt(r14)) == true) goto L51;
        L49:
            throw new UnpairedSurrogateException(r9, r8);
        L51:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r16 + " at index " + r4);
        L29:
            if (r4 > (r6 - 3)) goto L32;
            long r18 = r4 + 1;
            UnsafeUtil.putByte(r4, (byte) ((r16 >>> '\f') | 480));
            long r19 = r18 + 1;
            UnsafeUtil.putByte(r18, (byte) (((r16 >>> 6) & 63) | 128));
            UnsafeUtil.putByte(r19, (byte) ((r16 & '?') | 128));
            r4 = r19 + 1;
        L24:
            r1 = r9;
            r10 = 128;
            goto L38
        L22:
            if (r4 > (r6 - 2)) goto L25;
            r17 = r2;
            long r20 = r4 + 1;
            UnsafeUtil.putByte(r4, (byte) ((r16 >>> 6) | 960));
            UnsafeUtil.putByte(r20, (byte) ((r16 & '?') | 128));
            r4 = r20 + 1;
            goto L24
        L52:
            Java8Compatibility.position(out, (int) (r4 - r2));
            return;
        L55:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + in.charAt(r8 - 1) + " at index " + out.limit());
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] bytes, long offset, final int maxChars) {
            int r1 = 0;
            if (maxChars >= 16) goto L5;
            return 0;
        L5:
            int r0 = 8 - (((int) offset) & 7);
        L7:
            if (r1 >= r0) goto L12;
            long r2 = 1 + offset;
            if (UnsafeUtil.getByte(bytes, offset) < 0) goto L10;
            r1 = r1 + 1;
            offset = r2;
            goto L7
        L10:
            return r1;
        L12:
            int r3 = r1 + 8;
            if (r3 > maxChars) goto L18;
            if ((UnsafeUtil.getLong(bytes, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + offset) & Utf8.ASCII_MASK_LONG) != 0) goto L18;
            offset = offset + 8;
            r1 = r3;
        L18:
            if (r1 >= maxChars) goto L23;
            long r4 = offset + 1;
            if (UnsafeUtil.getByte(bytes, offset) < 0) goto L21;
            r1 = r1 + 1;
            offset = r4;
            goto L18
        L21:
            return r1;
        L23:
            return maxChars;
        }

        private static int unsafeEstimateConsecutiveAscii(long address, final int maxChars) {
            if (maxChars >= 16) goto L6;
            return 0;
        L6:
            int r0 = (int) ((-address) & 7);
            int r1 = r0;
        L7:
            if (r1 <= 0) goto L13;
            long r2 = 1 + address;
            if (UnsafeUtil.getByte(address) < 0) goto L11;
            r1 = r1 - 1;
            address = r2;
            goto L7
        L11:
            return r0 - r1;
        L13:
            int r3 = maxChars - r0;
        L15:
            if (r3 < 8) goto L20;
            if ((UnsafeUtil.getLong(address) & Utf8.ASCII_MASK_LONG) != 0) goto L20;
            address = address + 8;
            r3 = r3 - 8;
        L20:
            return maxChars - r3;
        }

        private static int partialIsValidUtf8(final byte[] bytes, long offset, int remaining) {
            int r0 = unsafeEstimateConsecutiveAscii(bytes, offset, remaining);
            int r11 = remaining - r0;
            long r9 = offset + ((long) r0);
        L3:
            byte r1 = 0;
        L5:
            if (r11 <= 0) goto L10;
            long r4 = r9 + 1;
            r1 = UnsafeUtil.getByte(bytes, r9);
            if (r1 < 0) goto L9;
            r11 = r11 - 1;
            r9 = r4;
            goto L5
        L9:
            r9 = r4;
        L10:
            if (r11 == 0) goto L11;
            int r12 = r11 - 1;
            if (r1 >= (-32)) goto L24;
            if (r12 == 0) goto L15;
            r11 = r12 - 1;
            if (r1 < (-62)) goto L22;
            long r2 = 1 + r9;
            if (UnsafeUtil.getByte(bytes, r9) > (-65)) goto L22;
        L21:
            r9 = r2;
        L22:
            return -1;
        L15:
            return r1;
        L24:
            if (r1 >= (-16)) goto L41;
            if (r12 < 2) goto L28;
            r11 = r12 - 2;
            long r6 = r9 + 1;
            byte r10 = UnsafeUtil.getByte(bytes, r9);
            if (r10 > (-65)) goto L39;
            if (r1 != (-32)) goto L35;
            if (r10 < (-96)) goto L39;
        L35:
            if (r1 != (-19)) goto L37;
            if (r10 >= (-96)) goto L39;
        L37:
            r2 = 1 + r6;
            if (UnsafeUtil.getByte(bytes, r6) <= (-65)) goto L21;
        L39:
            return -1;
        L28:
            return unsafeIncompleteStateFor(bytes, r1, r9, r12);
        L41:
            if (r12 < 3) goto L43;
            r11 = r12 - 3;
            long r7 = r9 + 1;
            byte r13 = UnsafeUtil.getByte(bytes, r9);
            if (r13 > (-65)) goto L52;
            if ((((r1 << 28) + (r13 + 112)) >> 30) != 0) goto L52;
            long r14 = r7 + 1;
            if (UnsafeUtil.getByte(bytes, r7) > (-65)) goto L52;
            r2 = 1 + r14;
            if (UnsafeUtil.getByte(bytes, r14) <= (-65)) goto L21;
        L52:
            return -1;
        L43:
            return unsafeIncompleteStateFor(bytes, r1, r9, r12);
        L11:
            return 0;
        }

        private static int partialIsValidUtf8(long address, int remaining) {
            int r0 = unsafeEstimateConsecutiveAscii(address, remaining);
            long r8 = address + ((long) r0);
            int r10 = remaining - r0;
        L3:
            byte r1 = 0;
        L5:
            if (r10 <= 0) goto L10;
            long r4 = r8 + 1;
            r1 = UnsafeUtil.getByte(r8);
            if (r1 < 0) goto L9;
            r10 = r10 - 1;
            r8 = r4;
            goto L5
        L9:
            r8 = r4;
        L10:
            if (r10 == 0) goto L11;
            int r11 = r10 - 1;
            if (r1 >= (-32)) goto L24;
            if (r11 == 0) goto L15;
            r10 = r11 - 1;
            if (r1 < (-62)) goto L22;
            long r2 = 1 + r8;
            if (UnsafeUtil.getByte(r8) > (-65)) goto L22;
        L21:
            r8 = r2;
        L22:
            return -1;
        L15:
            return r1;
        L24:
            if (r1 >= (-16)) goto L41;
            if (r11 < 2) goto L28;
            r10 = r11 - 2;
            long r6 = r8 + 1;
            byte r9 = UnsafeUtil.getByte(r8);
            if (r9 > (-65)) goto L39;
            if (r1 != (-32)) goto L35;
            if (r9 < (-96)) goto L39;
        L35:
            if (r1 != (-19)) goto L37;
            if (r9 >= (-96)) goto L39;
        L37:
            r2 = 1 + r6;
            if (UnsafeUtil.getByte(r6) <= (-65)) goto L21;
        L39:
            return -1;
        L28:
            return unsafeIncompleteStateFor(r8, r1, r11);
        L41:
            if (r11 < 3) goto L43;
            r10 = r11 - 3;
            long r7 = r8 + 1;
            byte r12 = UnsafeUtil.getByte(r8);
            if (r12 > (-65)) goto L52;
            if ((((r1 << 28) + (r12 + 112)) >> 30) != 0) goto L52;
            long r13 = r7 + 1;
            if (UnsafeUtil.getByte(r7) > (-65)) goto L52;
            r2 = 1 + r13;
            if (UnsafeUtil.getByte(r13) <= (-65)) goto L21;
        L52:
            return -1;
        L43:
            return unsafeIncompleteStateFor(r8, r1, r11);
        L11:
            return 0;
        }

        private static int unsafeIncompleteStateFor(byte[] bytes, int byte1, long offset, int remaining) {
            if (remaining == 0) goto L14;
            if (remaining == 1) goto L12;
            if (remaining != 2) goto L10;
            return Utf8.access$100(byte1, UnsafeUtil.getByte(bytes, offset), UnsafeUtil.getByte(bytes, offset + 1));
        L10:
            throw new AssertionError();
        L12:
            return Utf8.access$000(byte1, UnsafeUtil.getByte(bytes, offset));
        L14:
            return Utf8.access$1200(byte1);
        }

        private static int unsafeIncompleteStateFor(long address, final int byte1, int remaining) {
            if (remaining == 0) goto L14;
            if (remaining == 1) goto L12;
            if (remaining != 2) goto L10;
            return Utf8.access$100(byte1, UnsafeUtil.getByte(address), UnsafeUtil.getByte(address + 1));
        L10:
            throw new AssertionError();
        L12:
            return Utf8.access$000(byte1, UnsafeUtil.getByte(address));
        L14:
            return Utf8.access$1200(byte1);
        }
    }

    private static int incompleteStateFor(int byte1) {
        if (byte1 <= (-12)) goto L6;
        return -1;
    L6:
        return byte1;
    }

    private static int incompleteStateFor(int byte1, int byte2) {
        if (byte1 <= (-12)) goto L5;
    L8:
        return -1;
    L5:
        if (byte2 > (-65)) goto L8;
        return byte1 ^ (byte2 << 8);
    }

    private static int incompleteStateFor(int byte1, int byte2, int byte3) {
        if (byte1 <= (-12)) goto L5;
    L9:
        return -1;
    L5:
        if (byte2 > (-65)) goto L9;
        if (byte3 > (-65)) goto L9;
        return (byte1 ^ (byte2 << 8)) ^ (byte3 << 16);
    }

    static /* synthetic */ int access$000(int r0, int r1) {
        return incompleteStateFor(r0, r1);
    }

    static /* synthetic */ int access$100(int r0, int r1, int r2) {
        return incompleteStateFor(r0, r1, r2);
    }

    static /* synthetic */ int access$1100(byte[] r0, int r1, int r2) {
        return incompleteStateFor(r0, r1, r2);
    }

    static /* synthetic */ int access$1200(int r0) {
        return incompleteStateFor(r0);
    }

    static /* synthetic */ int access$200(ByteBuffer r0, int r1, int r2) {
        return estimateConsecutiveAscii(r0, r1, r2);
    }

    static /* synthetic */ int access$300(ByteBuffer r0, int r1, int r2, int r3) {
        return incompleteStateFor(r0, r1, r2, r3);
    }

    static {
        if (UnsafeProcessor.isAvailable() == true) goto L5;
    L7:
        Processor r0 = new SafeProcessor();
    L8:
        processor = r0;
        return;
    L5:
        if (Android.isOnAndroidDevice() == true) goto L7;
        r0 = new UnsafeProcessor();
        goto L8
    }

    static boolean isValidUtf8(byte[] bytes) {
        return processor.isValidUtf8(bytes, 0, bytes.length);
    }

    static boolean isValidUtf8(byte[] bytes, int index, int limit) {
        return processor.isValidUtf8(bytes, index, limit);
    }

    static int partialIsValidUtf8(int state, byte[] bytes, int index, int limit) {
        return processor.partialIsValidUtf8(state, bytes, index, limit);
    }

    private static int incompleteStateFor(byte[] bytes, int index, int limit) {
        byte r0 = bytes[index - 1];
        int r5 = limit - index;
        if (r5 == 0) goto L15;
        if (r5 == 1) goto L13;
        if (r5 != 2) goto L11;
        return incompleteStateFor(r0, bytes[index], bytes[index + 1]);
    L11:
        throw new AssertionError();
    L13:
        return incompleteStateFor(r0, bytes[index]);
    L15:
        return incompleteStateFor(r0);
    }

    private static int incompleteStateFor(final ByteBuffer buffer, final int byte1, final int index, final int remaining) {
        if (remaining == 0) goto L14;
        if (remaining == 1) goto L12;
        if (remaining != 2) goto L10;
        return incompleteStateFor(byte1, buffer.get(index), buffer.get(index + 1));
    L10:
        throw new AssertionError();
    L12:
        return incompleteStateFor(byte1, buffer.get(index));
    L14:
        return incompleteStateFor(byte1);
    }

    static int encodedLength(CharSequence sequence) {
        int r0 = sequence.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L7;
        if (sequence.charAt(r1) >= 128) goto L7;
        r1 = r1 + 1;
    L7:
        int r2 = r0;
    L8:
        if (r1 >= r0) goto L13;
        char r3 = sequence.charAt(r1);
        if (r3 >= 2048) goto L12;
        r2 = r2 + ((127 - r3) >>> 31);
        r1 = r1 + 1;
        goto L8
    L12:
        r2 = r2 + encodedLengthGeneral(sequence, r1);
    L13:
        if (r2 < r0) goto L16;
        return r2;
    L16:
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) r2) + 4294967296L));
    }

    private static int encodedLengthGeneral(CharSequence sequence, int start) {
        int r0 = sequence.length();
        int r1 = 0;
    L3:
        if (start >= r0) goto L17;
        char r2 = sequence.charAt(start);
        if (r2 >= 2048) goto L7;
        r1 = r1 + ((127 - r2) >>> 31);
    L16:
        start = start + 1;
        goto L3
    L7:
        r1 = r1 + 2;
        if (55296 > r2) goto L16;
        if (r2 > 57343) goto L16;
        if (Character.codePointAt(sequence, start) < 65536) goto L15;
        start = start + 1;
        goto L16
    L15:
        throw new UnpairedSurrogateException(start, r0);
    L17:
        return r1;
    }

    static int encode(CharSequence in, byte[] out, int offset, int length) {
        return processor.encodeUtf8(in, out, offset, length);
    }

    static boolean isValidUtf8(ByteBuffer buffer) {
        return processor.isValidUtf8(buffer, buffer.position(), buffer.remaining());
    }

    static int partialIsValidUtf8(int state, ByteBuffer buffer, int index, int limit) {
        return processor.partialIsValidUtf8(state, buffer, index, limit);
    }

    static String decodeUtf8(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(buffer, index, size);
    }

    static String decodeUtf8(byte[] bytes, int index, int size) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(bytes, index, size);
    }

    static void encodeUtf8(CharSequence in, ByteBuffer out) {
        processor.encodeUtf8(in, out);
    }

    private static int estimateConsecutiveAscii(ByteBuffer buffer, int index, int limit) {
        int r7 = limit - 7;
        int r0 = index;
    L3:
        if (r0 >= r7) goto L8;
        if ((buffer.getLong(r0) & ASCII_MASK_LONG) != 0) goto L8;
        r0 = r0 + 8;
    L8:
        return r0 - index;
    }

    private Utf8() {
    }
}
