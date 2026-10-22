package com.google.crypto.tink.shaded.protobuf;

import cz.msebera.android.httpclient.message.TokenParser;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes4.dex */
@CheckReturnValue
final class SchemaUtil {
    private static final int DEFAULT_LOOK_UP_START_NUMBER = 40;
    private static final Class<?> GENERATED_MESSAGE_CLASS = null;
    private static final UnknownFieldSchema<?, ?> UNKNOWN_FIELD_SET_FULL_SCHEMA = null;
    private static final UnknownFieldSchema<?, ?> UNKNOWN_FIELD_SET_LITE_SCHEMA = null;

    public static boolean shouldUseTableSwitch(int lo, int hi, int numFields) {
        if (hi >= 40) goto L5;
        return true;
    L5:
        long r2 = (((long) hi) - ((long) lo)) + 1;
        long r10 = numFields;
        if ((r2 + 9) <= (((2 * r10) + 3) + ((r10 + 3) * 3))) goto L10;
        return false;
    L10:
        return true;
    }

    static {
        GENERATED_MESSAGE_CLASS = getGeneratedMessageClass();
        UNKNOWN_FIELD_SET_FULL_SCHEMA = getUnknownFieldSetSchema();
        UNKNOWN_FIELD_SET_LITE_SCHEMA = new UnknownFieldSetLiteSchema();
    }

    private SchemaUtil() {
    }

    public static void requireGeneratedMessage(Class<?> messageType) {
        if (GeneratedMessageLite.class.isAssignableFrom(messageType) == true) goto L11;
        Class<?> r0 = GENERATED_MESSAGE_CLASS;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isAssignableFrom(messageType) == false) goto L10;
        return;
    L10:
        throw new IllegalArgumentException("Message classes must extend GeneratedMessageV3 or GeneratedMessageLite");
    }

    public static void writeDouble(int fieldNumber, double value, Writer writer) throws IOException {
        if (Double.doubleToRawLongBits(value) == 0) goto L6;
        writer.writeDouble(fieldNumber, value);
        return;
    }

    public static void writeFloat(int fieldNumber, float value, Writer writer) throws IOException {
        if (Float.floatToRawIntBits(value) == 0) goto L6;
        writer.writeFloat(fieldNumber, value);
        return;
    }

    public static void writeInt64(int fieldNumber, long value, Writer writer) throws IOException {
        if (value == 0) goto L6;
        writer.writeInt64(fieldNumber, value);
        return;
    }

    public static void writeUInt64(int fieldNumber, long value, Writer writer) throws IOException {
        if (value == 0) goto L6;
        writer.writeUInt64(fieldNumber, value);
        return;
    }

    public static void writeSInt64(int fieldNumber, long value, Writer writer) throws IOException {
        if (value == 0) goto L6;
        writer.writeSInt64(fieldNumber, value);
        return;
    }

    public static void writeFixed64(int fieldNumber, long value, Writer writer) throws IOException {
        if (value == 0) goto L6;
        writer.writeFixed64(fieldNumber, value);
        return;
    }

    public static void writeSFixed64(int fieldNumber, long value, Writer writer) throws IOException {
        if (value == 0) goto L6;
        writer.writeSFixed64(fieldNumber, value);
        return;
    }

    public static void writeInt32(int fieldNumber, int value, Writer writer) throws IOException {
        if (value == 0) goto L5;
        writer.writeInt32(fieldNumber, value);
        return;
    }

    public static void writeUInt32(int fieldNumber, int value, Writer writer) throws IOException {
        if (value == 0) goto L5;
        writer.writeUInt32(fieldNumber, value);
        return;
    }

    public static void writeSInt32(int fieldNumber, int value, Writer writer) throws IOException {
        if (value == 0) goto L5;
        writer.writeSInt32(fieldNumber, value);
        return;
    }

    public static void writeFixed32(int fieldNumber, int value, Writer writer) throws IOException {
        if (value == 0) goto L5;
        writer.writeFixed32(fieldNumber, value);
        return;
    }

    public static void writeSFixed32(int fieldNumber, int value, Writer writer) throws IOException {
        if (value == 0) goto L5;
        writer.writeSFixed32(fieldNumber, value);
        return;
    }

    public static void writeEnum(int fieldNumber, int value, Writer writer) throws IOException {
        if (value == 0) goto L5;
        writer.writeEnum(fieldNumber, value);
        return;
    }

    public static void writeBool(int fieldNumber, boolean value, Writer writer) throws IOException {
        if (value == false) goto L5;
        writer.writeBool(fieldNumber, true);
        return;
    }

    public static void writeString(int fieldNumber, Object value, Writer writer) throws IOException {
        if ((value instanceof String) == false) goto L5;
        writeStringInternal(fieldNumber, (String) value, writer);
        return;
    L5:
        writeBytes(fieldNumber, (ByteString) value, writer);
    }

    private static void writeStringInternal(int fieldNumber, String value, Writer writer) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeString(fieldNumber, value);
        return;
    }

    public static void writeBytes(int fieldNumber, ByteString value, Writer writer) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeBytes(fieldNumber, value);
        return;
    }

    public static void writeMessage(int fieldNumber, Object value, Writer writer) throws IOException {
        if (value == null) goto L5;
        writer.writeMessage(fieldNumber, value);
        return;
    }

    public static void writeDoubleList(int fieldNumber, List<Double> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeDoubleList(fieldNumber, value, packed);
        return;
    }

    public static void writeFloatList(int fieldNumber, List<Float> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeFloatList(fieldNumber, value, packed);
        return;
    }

    public static void writeInt64List(int fieldNumber, List<Long> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeInt64List(fieldNumber, value, packed);
        return;
    }

    public static void writeUInt64List(int fieldNumber, List<Long> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeUInt64List(fieldNumber, value, packed);
        return;
    }

    public static void writeSInt64List(int fieldNumber, List<Long> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeSInt64List(fieldNumber, value, packed);
        return;
    }

    public static void writeFixed64List(int fieldNumber, List<Long> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeFixed64List(fieldNumber, value, packed);
        return;
    }

    public static void writeSFixed64List(int fieldNumber, List<Long> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeSFixed64List(fieldNumber, value, packed);
        return;
    }

    public static void writeInt32List(int fieldNumber, List<Integer> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeInt32List(fieldNumber, value, packed);
        return;
    }

    public static void writeUInt32List(int fieldNumber, List<Integer> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeUInt32List(fieldNumber, value, packed);
        return;
    }

    public static void writeSInt32List(int fieldNumber, List<Integer> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeSInt32List(fieldNumber, value, packed);
        return;
    }

    public static void writeFixed32List(int fieldNumber, List<Integer> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeFixed32List(fieldNumber, value, packed);
        return;
    }

    public static void writeSFixed32List(int fieldNumber, List<Integer> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeSFixed32List(fieldNumber, value, packed);
        return;
    }

    public static void writeEnumList(int fieldNumber, List<Integer> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeEnumList(fieldNumber, value, packed);
        return;
    }

    public static void writeBoolList(int fieldNumber, List<Boolean> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeBoolList(fieldNumber, value, packed);
        return;
    }

    public static void writeStringList(int fieldNumber, List<String> value, Writer writer) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeStringList(fieldNumber, value);
        return;
    }

    public static void writeBytesList(int fieldNumber, List<ByteString> value, Writer writer) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeBytesList(fieldNumber, value);
        return;
    }

    public static void writeMessageList(int fieldNumber, List<?> value, Writer writer) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeMessageList(fieldNumber, value);
        return;
    }

    public static void writeMessageList(int fieldNumber, List<?> value, Writer writer, Schema schema) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeMessageList(fieldNumber, value, schema);
        return;
    }

    public static void writeLazyFieldList(int fieldNumber, List<?> value, Writer writer) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L11;
        Iterator<?> r2 = value.iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        ((LazyFieldLite) r2.next()).writeTo(writer, fieldNumber);
        goto L7
    L12:
        return;
    }

    public static void writeGroupList(int fieldNumber, List<?> value, Writer writer) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeGroupList(fieldNumber, value);
        return;
    }

    public static void writeGroupList(int fieldNumber, List<?> value, Writer writer, Schema schema) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeGroupList(fieldNumber, value, schema);
        return;
    }

    static int computeSizeInt64ListNoTag(List<Long> list) {
        int r0 = list.size();
        int r1 = 0;
        if (r0 != 0) goto L6;
        return 0;
    L6:
        if ((list instanceof LongArrayList) == false) goto L10;
        LongArrayList r5 = (LongArrayList) list;
        int r2 = 0;
    L8:
        if (r1 >= r0) goto L13;
        r2 = r2 + CodedOutputStream.computeInt64SizeNoTag(r5.getLong(r1));
        r1 = r1 + 1;
    L13:
        return r2;
    L10:
        r2 = 0;
    L11:
        if (r1 >= r0) goto L13;
        r2 = r2 + CodedOutputStream.computeInt64SizeNoTag(list.get(r1).longValue());
        r1 = r1 + 1;
        goto L11
    }

    static int computeSizeInt64List(int fieldNumber, List<Long> list, boolean packed) {
        if (list.size() != 0) goto L6;
        return 0;
    L6:
        int r0 = computeSizeInt64ListNoTag(list);
        if (packed == false) goto L11;
        return CodedOutputStream.computeTagSize(fieldNumber) + CodedOutputStream.computeLengthDelimitedFieldSize(r0);
    L11:
        return r0 + (list.size() * CodedOutputStream.computeTagSize(fieldNumber));
    }

    static int computeSizeUInt64ListNoTag(List<Long> list) {
        int r0 = list.size();
        int r1 = 0;
        if (r0 != 0) goto L6;
        return 0;
    L6:
        if ((list instanceof LongArrayList) == false) goto L10;
        LongArrayList r5 = (LongArrayList) list;
        int r2 = 0;
    L8:
        if (r1 >= r0) goto L13;
        r2 = r2 + CodedOutputStream.computeUInt64SizeNoTag(r5.getLong(r1));
        r1 = r1 + 1;
    L13:
        return r2;
    L10:
        r2 = 0;
    L11:
        if (r1 >= r0) goto L13;
        r2 = r2 + CodedOutputStream.computeUInt64SizeNoTag(list.get(r1).longValue());
        r1 = r1 + 1;
        goto L11
    }

    static int computeSizeUInt64List(int fieldNumber, List<Long> list, boolean packed) {
        int r0 = list.size();
        if (r0 != 0) goto L6;
        return 0;
    L6:
        int r2 = computeSizeUInt64ListNoTag(list);
        if (packed == false) goto L11;
        return CodedOutputStream.computeTagSize(fieldNumber) + CodedOutputStream.computeLengthDelimitedFieldSize(r2);
    L11:
        return r2 + (r0 * CodedOutputStream.computeTagSize(fieldNumber));
    }

    static int computeSizeSInt64ListNoTag(List<Long> list) {
        int r0 = list.size();
        int r1 = 0;
        if (r0 != 0) goto L6;
        return 0;
    L6:
        if ((list instanceof LongArrayList) == false) goto L10;
        LongArrayList r5 = (LongArrayList) list;
        int r2 = 0;
    L8:
        if (r1 >= r0) goto L13;
        r2 = r2 + CodedOutputStream.computeSInt64SizeNoTag(r5.getLong(r1));
        r1 = r1 + 1;
    L13:
        return r2;
    L10:
        r2 = 0;
    L11:
        if (r1 >= r0) goto L13;
        r2 = r2 + CodedOutputStream.computeSInt64SizeNoTag(list.get(r1).longValue());
        r1 = r1 + 1;
        goto L11
    }

    static int computeSizeSInt64List(int fieldNumber, List<Long> list, boolean packed) {
        int r0 = list.size();
        if (r0 != 0) goto L6;
        return 0;
    L6:
        int r2 = computeSizeSInt64ListNoTag(list);
        if (packed == false) goto L11;
        return CodedOutputStream.computeTagSize(fieldNumber) + CodedOutputStream.computeLengthDelimitedFieldSize(r2);
    L11:
        return r2 + (r0 * CodedOutputStream.computeTagSize(fieldNumber));
    }

    static int computeSizeEnumListNoTag(List<Integer> list) {
        int r0 = list.size();
        int r1 = 0;
        if (r0 != 0) goto L6;
        return 0;
    L6:
        if ((list instanceof IntArrayList) == false) goto L10;
        IntArrayList r4 = (IntArrayList) list;
        int r2 = 0;
    L8:
        if (r1 >= r0) goto L13;
        r2 = r2 + CodedOutputStream.computeEnumSizeNoTag(r4.getInt(r1));
        r1 = r1 + 1;
    L13:
        return r2;
    L10:
        r2 = 0;
    L11:
        if (r1 >= r0) goto L13;
        r2 = r2 + CodedOutputStream.computeEnumSizeNoTag(list.get(r1).intValue());
        r1 = r1 + 1;
        goto L11
    }

    static int computeSizeEnumList(int fieldNumber, List<Integer> list, boolean packed) {
        int r0 = list.size();
        if (r0 != 0) goto L6;
        return 0;
    L6:
        int r2 = computeSizeEnumListNoTag(list);
        if (packed == false) goto L11;
        return CodedOutputStream.computeTagSize(fieldNumber) + CodedOutputStream.computeLengthDelimitedFieldSize(r2);
    L11:
        return r2 + (r0 * CodedOutputStream.computeTagSize(fieldNumber));
    }

    static int computeSizeInt32ListNoTag(List<Integer> list) {
        int r0 = list.size();
        int r1 = 0;
        if (r0 != 0) goto L6;
        return 0;
    L6:
        if ((list instanceof IntArrayList) == false) goto L10;
        IntArrayList r4 = (IntArrayList) list;
        int r2 = 0;
    L8:
        if (r1 >= r0) goto L13;
        r2 = r2 + CodedOutputStream.computeInt32SizeNoTag(r4.getInt(r1));
        r1 = r1 + 1;
    L13:
        return r2;
    L10:
        r2 = 0;
    L11:
        if (r1 >= r0) goto L13;
        r2 = r2 + CodedOutputStream.computeInt32SizeNoTag(list.get(r1).intValue());
        r1 = r1 + 1;
        goto L11
    }

    static int computeSizeInt32List(int fieldNumber, List<Integer> list, boolean packed) {
        int r0 = list.size();
        if (r0 != 0) goto L6;
        return 0;
    L6:
        int r2 = computeSizeInt32ListNoTag(list);
        if (packed == false) goto L11;
        return CodedOutputStream.computeTagSize(fieldNumber) + CodedOutputStream.computeLengthDelimitedFieldSize(r2);
    L11:
        return r2 + (r0 * CodedOutputStream.computeTagSize(fieldNumber));
    }

    static int computeSizeUInt32ListNoTag(List<Integer> list) {
        int r0 = list.size();
        int r1 = 0;
        if (r0 != 0) goto L6;
        return 0;
    L6:
        if ((list instanceof IntArrayList) == false) goto L10;
        IntArrayList r4 = (IntArrayList) list;
        int r2 = 0;
    L8:
        if (r1 >= r0) goto L13;
        r2 = r2 + CodedOutputStream.computeUInt32SizeNoTag(r4.getInt(r1));
        r1 = r1 + 1;
    L13:
        return r2;
    L10:
        r2 = 0;
    L11:
        if (r1 >= r0) goto L13;
        r2 = r2 + CodedOutputStream.computeUInt32SizeNoTag(list.get(r1).intValue());
        r1 = r1 + 1;
        goto L11
    }

    static int computeSizeUInt32List(int fieldNumber, List<Integer> list, boolean packed) {
        int r0 = list.size();
        if (r0 != 0) goto L6;
        return 0;
    L6:
        int r2 = computeSizeUInt32ListNoTag(list);
        if (packed == false) goto L11;
        return CodedOutputStream.computeTagSize(fieldNumber) + CodedOutputStream.computeLengthDelimitedFieldSize(r2);
    L11:
        return r2 + (r0 * CodedOutputStream.computeTagSize(fieldNumber));
    }

    static int computeSizeSInt32ListNoTag(List<Integer> list) {
        int r0 = list.size();
        int r1 = 0;
        if (r0 != 0) goto L6;
        return 0;
    L6:
        if ((list instanceof IntArrayList) == false) goto L10;
        IntArrayList r4 = (IntArrayList) list;
        int r2 = 0;
    L8:
        if (r1 >= r0) goto L13;
        r2 = r2 + CodedOutputStream.computeSInt32SizeNoTag(r4.getInt(r1));
        r1 = r1 + 1;
    L13:
        return r2;
    L10:
        r2 = 0;
    L11:
        if (r1 >= r0) goto L13;
        r2 = r2 + CodedOutputStream.computeSInt32SizeNoTag(list.get(r1).intValue());
        r1 = r1 + 1;
        goto L11
    }

    static int computeSizeSInt32List(int fieldNumber, List<Integer> list, boolean packed) {
        int r0 = list.size();
        if (r0 != 0) goto L6;
        return 0;
    L6:
        int r2 = computeSizeSInt32ListNoTag(list);
        if (packed == false) goto L11;
        return CodedOutputStream.computeTagSize(fieldNumber) + CodedOutputStream.computeLengthDelimitedFieldSize(r2);
    L11:
        return r2 + (r0 * CodedOutputStream.computeTagSize(fieldNumber));
    }

    static int computeSizeFixed32ListNoTag(List<?> list) {
        return list.size() * 4;
    }

    static int computeSizeFixed32List(int fieldNumber, List<?> list, boolean packed) {
        int r2 = list.size();
        if (r2 != 0) goto L5;
        return 0;
    L5:
        if (packed == false) goto L9;
        return CodedOutputStream.computeTagSize(fieldNumber) + CodedOutputStream.computeLengthDelimitedFieldSize(r2 * 4);
    L9:
        return r2 * CodedOutputStream.computeFixed32Size(fieldNumber, 0);
    }

    static int computeSizeFixed64ListNoTag(List<?> list) {
        return list.size() * 8;
    }

    static int computeSizeFixed64List(int fieldNumber, List<?> list, boolean packed) {
        int r3 = list.size();
        if (r3 != 0) goto L6;
        return 0;
    L6:
        if (packed == false) goto L10;
        return CodedOutputStream.computeTagSize(fieldNumber) + CodedOutputStream.computeLengthDelimitedFieldSize(r3 * 8);
    L10:
        return r3 * CodedOutputStream.computeFixed64Size(fieldNumber, 0);
    }

    static int computeSizeBoolListNoTag(List<?> list) {
        return list.size();
    }

    static int computeSizeBoolList(int fieldNumber, List<?> list, boolean packed) {
        int r1 = list.size();
        if (r1 != 0) goto L6;
        return 0;
    L6:
        if (packed == false) goto L10;
        return CodedOutputStream.computeTagSize(fieldNumber) + CodedOutputStream.computeLengthDelimitedFieldSize(r1);
    L10:
        return r1 * CodedOutputStream.computeBoolSize(fieldNumber, true);
    }

    static int computeSizeStringList(int fieldNumber, List<?> list) {
        int r0 = list.size();
        int r1 = 0;
        if (r0 != 0) goto L5;
        return 0;
    L5:
        int r4 = CodedOutputStream.computeTagSize(fieldNumber) * r0;
        if ((list instanceof LazyStringList) == false) goto L14;
        LazyStringList r5 = (LazyStringList) list;
    L8:
        if (r1 >= r0) goto L20;
        Object r2 = r5.getRaw(r1);
        if ((r2 instanceof ByteString) == false) goto L12;
        int r3 = CodedOutputStream.computeBytesSizeNoTag((ByteString) r2);
    L13:
        r4 = r4 + r3;
        r1 = r1 + 1;
        goto L8
    L12:
        r3 = CodedOutputStream.computeStringSizeNoTag((String) r2);
    L20:
        return r4;
    L14:
        if (r1 >= r0) goto L20;
        Object r6 = list.get(r1);
        if ((r6 instanceof ByteString) == false) goto L18;
        int r7 = CodedOutputStream.computeBytesSizeNoTag((ByteString) r6);
    L19:
        r4 = r4 + r7;
        r1 = r1 + 1;
        goto L14
    L18:
        r7 = CodedOutputStream.computeStringSizeNoTag((String) r6);
        goto L19
    }

    static int computeSizeMessage(int fieldNumber, Object value, Schema schema) {
        if ((value instanceof LazyFieldLite) == false) goto L7;
        return CodedOutputStream.computeLazyFieldSize(fieldNumber, (LazyFieldLite) value);
    L7:
        return CodedOutputStream.computeMessageSize(fieldNumber, (MessageLite) value, schema);
    }

    static int computeSizeMessageList(int fieldNumber, List<?> list) {
        int r0 = list.size();
        int r1 = 0;
        if (r0 != 0) goto L5;
        return 0;
    L5:
        int r4 = CodedOutputStream.computeTagSize(fieldNumber) * r0;
    L6:
        if (r1 >= r0) goto L12;
        Object r2 = list.get(r1);
        if ((r2 instanceof LazyFieldLite) == false) goto L10;
        int r3 = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) r2);
    L11:
        r4 = r4 + r3;
        r1 = r1 + 1;
        goto L6
    L10:
        r3 = CodedOutputStream.computeMessageSizeNoTag((MessageLite) r2);
        goto L11
    L12:
        return r4;
    }

    static int computeSizeMessageList(int fieldNumber, List<?> list, Schema schema) {
        int r0 = list.size();
        int r1 = 0;
        if (r0 != 0) goto L5;
        return 0;
    L5:
        int r4 = CodedOutputStream.computeTagSize(fieldNumber) * r0;
    L6:
        if (r1 >= r0) goto L12;
        Object r2 = list.get(r1);
        if ((r2 instanceof LazyFieldLite) == false) goto L10;
        int r3 = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) r2);
    L11:
        r4 = r4 + r3;
        r1 = r1 + 1;
        goto L6
    L10:
        r3 = CodedOutputStream.computeMessageSizeNoTag((MessageLite) r2, schema);
        goto L11
    L12:
        return r4;
    }

    static int computeSizeByteStringList(int fieldNumber, List<ByteString> list) {
        int r0 = list.size();
        int r1 = 0;
        if (r0 != 0) goto L5;
        return 0;
    L5:
        int r2 = r0 * CodedOutputStream.computeTagSize(fieldNumber);
    L7:
        if (r1 >= list.size()) goto L9;
        r2 = r2 + CodedOutputStream.computeBytesSizeNoTag(list.get(r1));
        r1 = r1 + 1;
        goto L7
    L9:
        return r2;
    }

    static int computeSizeGroupList(int fieldNumber, List<MessageLite> list) {
        int r0 = list.size();
        int r1 = 0;
        if (r0 != 0) goto L5;
        return 0;
    L5:
        int r2 = 0;
    L6:
        if (r1 >= r0) goto L8;
        r2 = r2 + CodedOutputStream.computeGroupSize(fieldNumber, list.get(r1));
        r1 = r1 + 1;
        goto L6
    L8:
        return r2;
    }

    static int computeSizeGroupList(int fieldNumber, List<MessageLite> list, Schema schema) {
        int r0 = list.size();
        int r1 = 0;
        if (r0 != 0) goto L5;
        return 0;
    L5:
        int r2 = 0;
    L6:
        if (r1 >= r0) goto L8;
        r2 = r2 + CodedOutputStream.computeGroupSize(fieldNumber, list.get(r1), schema);
        r1 = r1 + 1;
        goto L6
    L8:
        return r2;
    }

    public static boolean shouldUseTableSwitch(FieldInfo[] fields) {
        if (fields.length != 0) goto L6;
        return false;
    L6:
        return shouldUseTableSwitch(fields[0].getFieldNumber(), fields[fields.length - 1].getFieldNumber(), fields.length);
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetFullSchema() {
        return UNKNOWN_FIELD_SET_FULL_SCHEMA;
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetLiteSchema() {
        return UNKNOWN_FIELD_SET_LITE_SCHEMA;
    }

    private static UnknownFieldSchema<?, ?> getUnknownFieldSetSchema() {
        Class<?> r1 = getUnknownFieldSetSchemaClass();     // Catch: Throwable -> L8
        if (r1 != null) goto L6;
        return null;
    L6:
        return (UnknownFieldSchema) r1.getConstructor(new Class[0]).newInstance(new Object[0]);
    L8:
        return null;
    }

    private static Class<?> getGeneratedMessageClass() {
        return Class.forName("com.google.crypto.tink.shaded.protobuf.GeneratedMessageV3");
    L4:
        return null;
    }

    private static Class<?> getUnknownFieldSetSchemaClass() {
        return Class.forName("com.google.crypto.tink.shaded.protobuf.UnknownFieldSetSchema");
    L4:
        return null;
    }

    static Object getMapDefaultEntry(Class<?> clazz, String name) {
        java.lang.reflect.Field[] r1 = Class.forName(clazz.getName() + "$" + toCamelCase(name, true) + "DefaultEntryHolder").getDeclaredFields();     // Catch: Throwable -> L9
        if (r1.length != 1) goto L8;
        return UnsafeUtil.getStaticObject(r1[0]);
    L8:
        throw new IllegalStateException("Unable to look up map field default entry holder class for " + name + " in " + clazz.getName());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw new RuntimeException(th);
    }

    static String toCamelCase(String name, boolean capNext) {
        StringBuilder r0 = new StringBuilder();
        int r2 = 0;
    L4:
        if (r2 >= name.length()) goto L29;
        char r3 = name.charAt(r2);
        if ('a' > r3) goto L14;
        if (r3 > 'z') goto L14;
        if (capNext == false) goto L11;
        r0.append((char) (r3 - ' '));
    L12:
        capNext = false;
    L27:
        r2 = r2 + 1;
        goto L4
    L11:
        r0.append(r3);
    L14:
        if ('A' > r3) goto L22;
        if (r3 > 'Z') goto L22;
        if (r2 != 0) goto L20;
        if (capNext == true) goto L20;
        r0.append((char) (r3 + TokenParser.SP));
    L20:
        r0.append(r3);
    L22:
        if ('0' <= r3) goto L24;
    L26:
        capNext = true;
        goto L27
    L24:
        if (r3 > '9') goto L26;
        r0.append(r3);
        goto L26
    L29:
        return r0.toString();
    }

    static boolean safeEquals(Object a, Object b) {
        if (a == b) goto L8;
        if (a != null) goto L5;
    L7:
        return false;
    L5:
        if (a.equals(b) == false) goto L7;
    L8:
        return true;
    }

    static <T> void mergeMap(MapFieldSchema mapFieldSchema, T message, T o, long offset) {
        UnsafeUtil.putObject(message, offset, mapFieldSchema.mergeFrom(UnsafeUtil.getObject(message, offset), UnsafeUtil.getObject(o, offset)));
    }

    static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void mergeExtensions(ExtensionSchema<FT> schema, T message, T other) {
        FieldSet<T> r3 = schema.getExtensions(other);
        if (r3.isEmpty() == true) goto L6;
        schema.getMutableExtensions(message).mergeFrom(r3);
        return;
    }

    static <T, UT, UB> void mergeUnknownFields(UnknownFieldSchema<UT, UB> schema, T message, T other) {
        schema.setToMessage(message, schema.merge(schema.getFromMessage(message), schema.getFromMessage(other)));
    }

    static <UT, UB> UB filterUnknownEnumList(Object r5, int r6, List<Integer> r7, Internal.EnumLiteMap<?> r8, UB r9, UnknownFieldSchema<UT, UB> r10) {
        if (r8 != null) goto L5;
        return r9;
    L5:
        if ((r7 instanceof RandomAccess) == false) goto L17;
        int r0 = r7.size();
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= r0) goto L15;
        int r3 = r7.get(r1).intValue();
        if (r8.findValueByNumber(r3) == null) goto L13;
        if (r1 == r2) goto L12;
        r7.set(r2, Integer.valueOf(r3));
    L12:
        r2 = r2 + 1;
    L14:
        r1 = r1 + 1;
        goto L7
    L13:
        r9 = (UB) storeUnknownEnum(r5, r6, r3, r9, r10);
        goto L14
    L15:
        if (r2 == r0) goto L23;
        r7.subList(r2, r0).clear();
    L23:
        return r9;
    L17:
        Iterator<Integer> r11 = r7.iterator();
    L19:
        if (r11.hasNext() == false) goto L23;
        int r4 = r11.next().intValue();
        if (r8.findValueByNumber(r4) != null) goto L19;
        r9 = (UB) storeUnknownEnum(r5, r6, r4, r9, r10);
        r11.remove();
        goto L19
    }

    static <UT, UB> UB filterUnknownEnumList(Object r5, int r6, List<Integer> r7, Internal.EnumVerifier r8, UB r9, UnknownFieldSchema<UT, UB> r10) {
        if (r8 != null) goto L5;
        return r9;
    L5:
        if ((r7 instanceof RandomAccess) == false) goto L17;
        int r0 = r7.size();
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= r0) goto L15;
        int r3 = r7.get(r1).intValue();
        if (r8.isInRange(r3) == false) goto L13;
        if (r1 == r2) goto L12;
        r7.set(r2, Integer.valueOf(r3));
    L12:
        r2 = r2 + 1;
    L14:
        r1 = r1 + 1;
        goto L7
    L13:
        r9 = (UB) storeUnknownEnum(r5, r6, r3, r9, r10);
        goto L14
    L15:
        if (r2 == r0) goto L23;
        r7.subList(r2, r0).clear();
    L23:
        return r9;
    L17:
        Iterator<Integer> r11 = r7.iterator();
    L19:
        if (r11.hasNext() == false) goto L23;
        int r4 = r11.next().intValue();
        if (r8.isInRange(r4) == true) goto L19;
        r9 = (UB) storeUnknownEnum(r5, r6, r4, r9, r10);
        r11.remove();
        goto L19
    }

    static <UT, UB> UB storeUnknownEnum(Object r2, int r3, int r4, UB r5, UnknownFieldSchema<UT, UB> r6) {
        if (r5 != null) goto L4;
        r5 = r6.getBuilderFromMessage(r2);
    L4:
        r6.addVarint(r5, r3, r4);
        return r5;
    }
}
