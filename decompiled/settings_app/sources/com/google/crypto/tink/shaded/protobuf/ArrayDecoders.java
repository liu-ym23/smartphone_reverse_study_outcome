package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
@CheckReturnValue
final class ArrayDecoders {

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.ArrayDecoders$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r0 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0;
            r0[WireFormat.FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L62:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L46:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L58:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L64:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L48:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L52:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L74:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 8;     // Catch: NoSuchFieldError -> L29
        L42:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 9;     // Catch: NoSuchFieldError -> L30
        L68:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 10;     // Catch: NoSuchFieldError -> L31
        L70:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 11;     // Catch: NoSuchFieldError -> L32
        L54:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 12;     // Catch: NoSuchFieldError -> L33
        L60:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 13;     // Catch: NoSuchFieldError -> L34
        L44:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 14;     // Catch: NoSuchFieldError -> L35
        L50:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 15;     // Catch: NoSuchFieldError -> L36
        L72:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 16;     // Catch: NoSuchFieldError -> L37
        L40:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 17;     // Catch: NoSuchFieldError -> L38
        L66:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 18;     // Catch: NoSuchFieldError -> L39
            return;
        }
    }

    static final class Registers {
        public final ExtensionRegistryLite extensionRegistry;
        public int int1;
        public long long1;
        public Object object1;

        Registers() {
            this.extensionRegistry = ExtensionRegistryLite.getEmptyRegistry();
        }

        Registers(ExtensionRegistryLite extensionRegistry) {
            extensionRegistry.getClass();
            this.extensionRegistry = extensionRegistry;
        }
    }

    private ArrayDecoders() {
    }

    static int decodeVarint32(byte[] data, int position, Registers registers) {
        int r0 = position + 1;
        byte r2 = data[position];
        if (r2 < 0) goto L7;
        registers.int1 = r2;
        return r0;
    L7:
        return decodeVarint32(r2, data, r0, registers);
    }

    static int decodeVarint32(int firstByte, byte[] data, int position, Registers registers) {
        int r1 = firstByte & 127;
        int r0 = position + 1;
        byte r3 = data[position];
        if (r3 < 0) goto L6;
        registers.int1 = r1 | (r3 << 7);
        return r0;
    L6:
        int r2 = r1 | ((r3 & 127) << 7);
        int r4 = r0 + 1;
        byte r5 = data[r0];
        if (r5 < 0) goto L10;
        registers.int1 = r2 | (r5 << 14);
        return r4;
    L10:
        int r6 = r2 | ((r5 & 127) << 14);
        int r7 = r4 + 1;
        byte r8 = data[r4];
        if (r8 < 0) goto L14;
        registers.int1 = r6 | (r8 << 21);
        return r7;
    L14:
        int r9 = r6 | ((r8 & 127) << 21);
        int r10 = r7 + 1;
        byte r11 = data[r7];
        if (r11 < 0) goto L18;
        registers.int1 = r9 | (r11 << 28);
        return r10;
    L18:
        int r12 = r9 | ((r11 & 127) << 28);
    L19:
        int r13 = r10 + 1;
        if (data[r10] >= 0) goto L22;
        r10 = r13;
        goto L19
    L22:
        registers.int1 = r12;
        return r13;
    }

    static int decodeVarint64(byte[] data, int position, Registers registers) {
        int r0 = position + 1;
        long r1 = data[position];
        if (r1 < 0) goto L7;
        registers.long1 = r1;
        return r0;
    L7:
        return decodeVarint64(r1, data, r0, registers);
    }

    static int decodeVarint64(long firstByte, byte[] data, int position, Registers registers) {
        int r0 = position + 1;
        byte r10 = data[position];
        long r7 = (firstByte & 127) | (((long) (r10 & 127)) << 7);
        int r1 = 7;
    L3:
        if (r10 >= 0) goto L5;
        int r11 = r0 + 1;
        byte r2 = data[r0];
        r1 = r1 + 7;
        r7 = r7 | (((long) (r2 & 127)) << r1);
        r0 = r11;
        r10 = r2;
        goto L3
    L5:
        registers.long1 = r7;
        return r0;
    }

    static int decodeFixed32(byte[] data, int position) {
        int r0 = ((data[position] & 255) | ((data[position + 1] & 255) << 8)) | ((data[position + 2] & 255) << 16);
        return ((data[position + 3] & 255) << 24) | r0;
    }

    static long decodeFixed64(byte[] data, int position) {
        long r0 = ((((((((long) data[position]) & 255) | ((((long) data[position + 1]) & 255) << 8)) | ((((long) data[position + 2]) & 255) << 16)) | ((((long) data[position + 3]) & 255) << 24)) | ((((long) data[position + 4]) & 255) << 32)) | ((((long) data[position + 5]) & 255) << 40)) | ((((long) data[position + 6]) & 255) << 48);
        return ((((long) data[position + 7]) & 255) << 56) | r0;
    }

    static double decodeDouble(byte[] data, int position) {
        return Double.longBitsToDouble(decodeFixed64(data, position));
    }

    static float decodeFloat(byte[] data, int position) {
        return Float.intBitsToFloat(decodeFixed32(data, position));
    }

    static int decodeString(byte[] data, int position, Registers registers) throws InvalidProtocolBufferException {
        int r4 = decodeVarint32(data, position, registers);
        int r0 = registers.int1;
        if (r0 < 0) goto L10;
        if (r0 != 0) goto L7;
        registers.object1 = "";
        return r4;
    L7:
        registers.object1 = new String(data, r4, r0, Internal.UTF_8);
        return r4 + r0;
    L10:
        throw InvalidProtocolBufferException.negativeSize();
    }

    static int decodeStringRequireUtf8(byte[] data, int position, Registers registers) throws InvalidProtocolBufferException {
        int r2 = decodeVarint32(data, position, registers);
        int r0 = registers.int1;
        if (r0 < 0) goto L10;
        if (r0 != 0) goto L7;
        registers.object1 = "";
        return r2;
    L7:
        registers.object1 = Utf8.decodeUtf8(data, r2, r0);
        return r2 + r0;
    L10:
        throw InvalidProtocolBufferException.negativeSize();
    }

    static int decodeBytes(byte[] data, int position, Registers registers) throws InvalidProtocolBufferException {
        int r3 = decodeVarint32(data, position, registers);
        int r0 = registers.int1;
        if (r0 < 0) goto L14;
        if (r0 > (data.length - r3)) goto L12;
        if (r0 != 0) goto L9;
        registers.object1 = ByteString.EMPTY;
        return r3;
    L9:
        registers.object1 = ByteString.copyFrom(data, r3, r0);
        return r3 + r0;
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    L14:
        throw InvalidProtocolBufferException.negativeSize();
    }

    static int decodeMessageField(Schema schema, byte[] data, int position, int limit, Registers registers) throws IOException {
        Object r6 = schema.newInstance();
        int r8 = mergeMessageField(r6, schema, data, position, limit, registers);
        schema.makeImmutable(r6);
        registers.object1 = r6;
        return r8;
    }

    static int decodeGroupField(Schema schema, byte[] data, int position, int limit, int endGroup, Registers registers) throws IOException {
        Object r7 = schema.newInstance();
        int r9 = mergeGroupField(r7, schema, data, position, limit, endGroup, registers);
        schema.makeImmutable(r7);
        registers.object1 = r7;
        return r9;
    }

    static int mergeMessageField(Object msg, Schema schema, byte[] data, int position, int limit, Registers registers) throws IOException {
        int r0 = position + 1;
        int r9 = data[position];
        if (r9 >= 0) goto L5;
        r0 = decodeVarint32(r9, data, r0, registers);
        r9 = registers.int1;
    L5:
        int r3 = r0;
        if (r9 < 0) goto L12;
        if (r9 > (limit - r3)) goto L12;
        int r10 = r9 + r3;
        schema.mergeFrom(msg, data, r3, r10, registers);
        registers.object1 = msg;
        return r10;
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int mergeGroupField(Object msg, Schema schema, byte[] data, int position, int limit, int endGroup, Registers registers) throws IOException {
        int r8 = ((MessageSchema) schema).parseMessage(msg, data, position, limit, endGroup, registers);
        registers.object1 = msg;
        return r8;
    }

    static int decodeVarint32List(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        IntArrayList r6 = (IntArrayList) list;
        int r4 = decodeVarint32(data, position, registers);
        r6.addInt(registers.int1);
    L3:
        if (r4 >= limit) goto L8;
        int r0 = decodeVarint32(data, r4, registers);
        if (tag != registers.int1) goto L8;
        r4 = decodeVarint32(data, r0, registers);
        r6.addInt(registers.int1);
    L8:
        return r4;
    }

    static int decodeVarint64List(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        LongArrayList r6 = (LongArrayList) list;
        int r4 = decodeVarint64(data, position, registers);
        r6.addLong(registers.long1);
    L3:
        if (r4 >= limit) goto L8;
        int r0 = decodeVarint32(data, r4, registers);
        if (tag != registers.int1) goto L8;
        r4 = decodeVarint64(data, r0, registers);
        r6.addLong(registers.long1);
    L8:
        return r4;
    }

    static int decodeFixed32List(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        IntArrayList r6 = (IntArrayList) list;
        r6.addInt(decodeFixed32(data, position));
        int r4 = position + 4;
    L3:
        if (r4 >= limit) goto L8;
        int r0 = decodeVarint32(data, r4, registers);
        if (tag != registers.int1) goto L8;
        r6.addInt(decodeFixed32(data, r0));
        r4 = r0 + 4;
    L8:
        return r4;
    }

    static int decodeFixed64List(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        LongArrayList r7 = (LongArrayList) list;
        r7.addLong(decodeFixed64(data, position));
        int r5 = position + 8;
    L3:
        if (r5 >= limit) goto L8;
        int r0 = decodeVarint32(data, r5, registers);
        if (tag != registers.int1) goto L8;
        r7.addLong(decodeFixed64(data, r0));
        r5 = r0 + 8;
    L8:
        return r5;
    }

    static int decodeFloatList(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        FloatArrayList r6 = (FloatArrayList) list;
        r6.addFloat(decodeFloat(data, position));
        int r4 = position + 4;
    L3:
        if (r4 >= limit) goto L8;
        int r0 = decodeVarint32(data, r4, registers);
        if (tag != registers.int1) goto L8;
        r6.addFloat(decodeFloat(data, r0));
        r4 = r0 + 4;
    L8:
        return r4;
    }

    static int decodeDoubleList(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        DoubleArrayList r7 = (DoubleArrayList) list;
        r7.addDouble(decodeDouble(data, position));
        int r5 = position + 8;
    L3:
        if (r5 >= limit) goto L8;
        int r0 = decodeVarint32(data, r5, registers);
        if (tag != registers.int1) goto L8;
        r7.addDouble(decodeDouble(data, r0));
        r5 = r0 + 8;
    L8:
        return r5;
    }

    static int decodeBoolList(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        BooleanArrayList r11 = (BooleanArrayList) list;
        int r9 = decodeVarint64(data, position, registers);
        if (registers.long1 == 0) goto L5;
        boolean r0 = true;
    L6:
        r11.addBoolean(r0);
    L7:
        if (r9 >= limit) goto L16;
        int r1 = decodeVarint32(data, r9, registers);
        if (tag != registers.int1) goto L16;
        r9 = decodeVarint64(data, r1, registers);
        if (registers.long1 == 0) goto L14;
        boolean r2 = true;
    L15:
        r11.addBoolean(r2);
        goto L7
    L14:
        r2 = false;
    L16:
        return r9;
    L5:
        r0 = false;
        goto L6
    }

    static int decodeSInt32List(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        IntArrayList r6 = (IntArrayList) list;
        int r4 = decodeVarint32(data, position, registers);
        r6.addInt(CodedInputStream.decodeZigZag32(registers.int1));
    L3:
        if (r4 >= limit) goto L8;
        int r0 = decodeVarint32(data, r4, registers);
        if (tag != registers.int1) goto L8;
        r4 = decodeVarint32(data, r0, registers);
        r6.addInt(CodedInputStream.decodeZigZag32(registers.int1));
    L8:
        return r4;
    }

    static int decodeSInt64List(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        LongArrayList r6 = (LongArrayList) list;
        int r4 = decodeVarint64(data, position, registers);
        r6.addLong(CodedInputStream.decodeZigZag64(registers.long1));
    L3:
        if (r4 >= limit) goto L8;
        int r0 = decodeVarint32(data, r4, registers);
        if (tag != registers.int1) goto L8;
        r4 = decodeVarint64(data, r0, registers);
        r6.addLong(CodedInputStream.decodeZigZag64(registers.long1));
    L8:
        return r4;
    }

    static int decodePackedVarint32List(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        IntArrayList r4 = (IntArrayList) list;
        int r3 = decodeVarint32(data, position, registers);
        int r0 = registers.int1 + r3;
    L3:
        if (r3 >= r0) goto L5;
        r3 = decodeVarint32(data, r3, registers);
        r4.addInt(registers.int1);
        goto L3
    L5:
        if (r3 != r0) goto L8;
        return r3;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedVarint64List(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        LongArrayList r5 = (LongArrayList) list;
        int r4 = decodeVarint32(data, position, registers);
        int r0 = registers.int1 + r4;
    L3:
        if (r4 >= r0) goto L5;
        r4 = decodeVarint64(data, r4, registers);
        r5.addLong(registers.long1);
        goto L3
    L5:
        if (r4 != r0) goto L8;
        return r4;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedFixed32List(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        IntArrayList r3 = (IntArrayList) list;
        int r2 = decodeVarint32(data, position, registers);
        int r4 = registers.int1 + r2;
    L3:
        if (r2 >= r4) goto L5;
        r3.addInt(decodeFixed32(data, r2));
        r2 = r2 + 4;
        goto L3
    L5:
        if (r2 != r4) goto L8;
        return r2;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedFixed64List(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        LongArrayList r4 = (LongArrayList) list;
        int r3 = decodeVarint32(data, position, registers);
        int r5 = registers.int1 + r3;
    L3:
        if (r3 >= r5) goto L5;
        r4.addLong(decodeFixed64(data, r3));
        r3 = r3 + 8;
        goto L3
    L5:
        if (r3 != r5) goto L8;
        return r3;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedFloatList(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        FloatArrayList r3 = (FloatArrayList) list;
        int r2 = decodeVarint32(data, position, registers);
        int r4 = registers.int1 + r2;
    L3:
        if (r2 >= r4) goto L5;
        r3.addFloat(decodeFloat(data, r2));
        r2 = r2 + 4;
        goto L3
    L5:
        if (r2 != r4) goto L8;
        return r2;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedDoubleList(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        DoubleArrayList r4 = (DoubleArrayList) list;
        int r3 = decodeVarint32(data, position, registers);
        int r5 = registers.int1 + r3;
    L3:
        if (r3 >= r5) goto L5;
        r4.addDouble(decodeDouble(data, r3));
        r3 = r3 + 8;
        goto L3
    L5:
        if (r3 != r5) goto L8;
        return r3;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedBoolList(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        BooleanArrayList r7 = (BooleanArrayList) list;
        int r6 = decodeVarint32(data, position, registers);
        int r0 = registers.int1 + r6;
    L3:
        if (r6 >= r0) goto L9;
        r6 = decodeVarint64(data, r6, registers);
        if (registers.long1 == 0) goto L7;
        boolean r1 = true;
    L8:
        r7.addBoolean(r1);
        goto L3
    L7:
        r1 = false;
        goto L8
    L9:
        if (r6 != r0) goto L12;
        return r6;
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedSInt32List(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        IntArrayList r4 = (IntArrayList) list;
        int r3 = decodeVarint32(data, position, registers);
        int r0 = registers.int1 + r3;
    L3:
        if (r3 >= r0) goto L5;
        r3 = decodeVarint32(data, r3, registers);
        r4.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        goto L3
    L5:
        if (r3 != r0) goto L8;
        return r3;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedSInt64List(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        LongArrayList r5 = (LongArrayList) list;
        int r4 = decodeVarint32(data, position, registers);
        int r0 = registers.int1 + r4;
    L3:
        if (r4 >= r0) goto L5;
        r4 = decodeVarint64(data, r4, registers);
        r5.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        goto L3
    L5:
        if (r4 != r0) goto L8;
        return r4;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodeStringList(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) throws InvalidProtocolBufferException {
        int r6 = decodeVarint32(data, position, registers);
        int r0 = registers.int1;
        if (r0 < 0) goto L22;
        if (r0 != 0) goto L7;
        list.add("");
    L9:
        if (r6 >= limit) goto L20;
        int r1 = decodeVarint32(data, r6, registers);
        if (tag != registers.int1) goto L20;
        r6 = decodeVarint32(data, r1, registers);
        int r2 = registers.int1;
        if (r2 < 0) goto L19;
        if (r2 == 0) goto L16;
        list.add(new String(data, r6, r2, Internal.UTF_8));
        r6 = r6 + r2;
        goto L9
    L16:
        list.add("");
        goto L9
    L19:
        throw InvalidProtocolBufferException.negativeSize();
    L20:
        return r6;
    L7:
        list.add(new String(data, r6, r0, Internal.UTF_8));
        r6 = r6 + r0;
        goto L9
    L22:
        throw InvalidProtocolBufferException.negativeSize();
    }

    static int decodeStringListRequireUtf8(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) throws InvalidProtocolBufferException {
        int r7 = decodeVarint32(data, position, registers);
        int r0 = registers.int1;
        if (r0 < 0) goto L30;
        if (r0 != 0) goto L7;
        list.add("");
    L11:
        if (r7 >= limit) goto L26;
        int r1 = decodeVarint32(data, r7, registers);
        if (tag != registers.int1) goto L26;
        r7 = decodeVarint32(data, r1, registers);
        int r2 = registers.int1;
        if (r2 < 0) goto L25;
        if (r2 == 0) goto L18;
        int r3 = r7 + r2;
        if (Utf8.isValidUtf8(data, r7, r3) == false) goto L23;
        list.add(new String(data, r7, r2, Internal.UTF_8));
        r7 = r3;
        goto L11
    L23:
        throw InvalidProtocolBufferException.invalidUtf8();
    L18:
        list.add("");
        goto L11
    L25:
        throw InvalidProtocolBufferException.negativeSize();
    L26:
        return r7;
    L7:
        int r4 = r7 + r0;
        if (Utf8.isValidUtf8(data, r7, r4) == false) goto L28;
        list.add(new String(data, r7, r0, Internal.UTF_8));
        r7 = r4;
        goto L11
    L28:
        throw InvalidProtocolBufferException.invalidUtf8();
    L30:
        throw InvalidProtocolBufferException.negativeSize();
    }

    static int decodeBytesList(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) throws InvalidProtocolBufferException {
        int r4 = decodeVarint32(data, position, registers);
        int r0 = registers.int1;
        if (r0 < 0) goto L29;
        if (r0 > (data.length - r4)) goto L27;
        if (r0 != 0) goto L8;
        list.add(ByteString.EMPTY);
    L10:
        if (r4 >= limit) goto L25;
        int r1 = decodeVarint32(data, r4, registers);
        if (tag != registers.int1) goto L25;
        r4 = decodeVarint32(data, r1, registers);
        int r2 = registers.int1;
        if (r2 < 0) goto L24;
        if (r2 > (data.length - r4)) goto L22;
        if (r2 == 0) goto L19;
        list.add(ByteString.copyFrom(data, r4, r2));
        r4 = r4 + r2;
        goto L10
    L19:
        list.add(ByteString.EMPTY);
        goto L10
    L22:
        throw InvalidProtocolBufferException.truncatedMessage();
    L24:
        throw InvalidProtocolBufferException.negativeSize();
    L25:
        return r4;
    L8:
        list.add(ByteString.copyFrom(data, r4, r0));
        r4 = r4 + r0;
        goto L10
    L27:
        throw InvalidProtocolBufferException.truncatedMessage();
    L29:
        throw InvalidProtocolBufferException.negativeSize();
    }

    static int decodeMessageList(Schema<?> schema, int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        int r5 = decodeMessageField(schema, data, position, limit, registers);
        list.add(registers.object1);
    L3:
        if (r5 >= limit) goto L8;
        int r0 = decodeVarint32(data, r5, registers);
        if (tag != registers.int1) goto L8;
        r5 = decodeMessageField(schema, data, r0, limit, registers);
        list.add(registers.object1);
    L8:
        return r5;
    }

    static int decodeGroupList(Schema schema, int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        int r0 = (tag & (-8)) | 4;
        int r10 = decodeGroupField(schema, data, position, limit, r0, registers);
        list.add(registers.object1);
    L3:
        if (r10 >= limit) goto L8;
        int r3 = decodeVarint32(data, r10, registers);
        if (tag != registers.int1) goto L8;
        r10 = decodeGroupField(schema, data, r3, limit, r0, registers);
        list.add(registers.object1);
    L8:
        return r10;
    }

    static int decodeExtensionOrUnknownField(int tag, byte[] data, int position, int limit, Object message, MessageLite defaultInstance, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> unknownFieldSchema, Registers registers) throws IOException {
        ExtensionRegistryLite r1 = registers.extensionRegistry;
        GeneratedMessageLite.GeneratedExtension r5 = r1.findLiteExtensionByNumber(defaultInstance, tag >>> 3);
        if (r5 == null) goto L5;
        GeneratedMessageLite.ExtendableMessage r4 = (GeneratedMessageLite.ExtendableMessage) message;
        r4.ensureExtensionsAreMutable();
        return decodeExtension(tag, data, position, limit, r4, r5, unknownFieldSchema, registers);
    L5:
        return decodeUnknownField(tag, data, position, limit, MessageSchema.getMutableUnknownFields(message), registers);
    }

    static int decodeExtension(int tag, byte[] data, int position, int limit, GeneratedMessageLite.ExtendableMessage<?, ?> message, GeneratedMessageLite.GeneratedExtension<?, ?> extension, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> unknownFieldSchema, Registers registers) throws IOException {
        FieldSet<GeneratedMessageLite.ExtensionDescriptor> r0 = message.extensions;
        int r2 = tag >>> 3;
        if (extension.descriptor.isRepeated() == true) goto L5;
    L20:
        Object r3 = null;
        if (extension.getLiteType() != WireFormat.FieldType.ENUM) goto L28;
        position = decodeVarint32(data, position, registers);
        if (extension.descriptor.getEnumType().findValueByNumber(registers.int1) != null) goto L26;
        SchemaUtil.storeUnknownEnum(message, r2, registers.int1, null, unknownFieldSchema);
        return position;
    L26:
        r3 = Integer.valueOf(registers.int1);
    L66:
        if (extension.isRepeated() == false) goto L68;
        r0.addRepeatedField(extension.descriptor, r3);
    L70:
        return position;
    L68:
        r0.setField(extension.descriptor, r3);
        goto L70
    L28:
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[extension.getLiteType().ordinal()]) {
            case 1: goto L63;
            case 2: goto L61;
            case 3: goto L60;
            case 4: goto L60;
            case 5: goto L59;
            case 6: goto L59;
            case 7: goto L58;
            case 8: goto L58;
            case 9: goto L57;
            case 10: goto L57;
            case 11: goto L52;
            case 12: goto L51;
            case 13: goto L50;
            case 14: goto L49;
            case 15: goto L47;
            case 16: goto L46;
            case 17: goto L38;
            case 18: goto L30;
            default: goto L66;
        };
    L30:
        Schema r4 = Protobuf.getInstance().schemaFor(extension.getMessageDefaultInstance().getClass());
        if (extension.isRepeated() == false) goto L33;
        int r8 = decodeMessageField(r4, data, position, limit, registers);
        r0.addRepeatedField(extension.descriptor, registers.object1);
        return r8;
    L33:
        Object r9 = r0.getField(extension.descriptor);
        if (r9 != null) goto L37;
        r9 = r4.newInstance();
        r0.setField(extension.descriptor, r9);
    L37:
        return mergeMessageField(r9, r4, data, position, limit, registers);
    L38:
        int r6 = (r2 << 3) | 4;
        Schema r5 = Protobuf.getInstance().schemaFor(extension.getMessageDefaultInstance().getClass());
        if (extension.isRepeated() == false) goto L41;
        int r10 = decodeGroupField(r5, data, position, limit, r6, registers);
        r0.addRepeatedField(extension.descriptor, registers.object1);
        return r10;
    L41:
        Object r11 = r0.getField(extension.descriptor);
        if (r11 != null) goto L45;
        r11 = r5.newInstance();
        r0.setField(extension.descriptor, r11);
    L45:
        return mergeGroupField(r11, r5, data, position, limit, r6, registers);
    L46:
        position = decodeString(data, position, registers);
        r3 = registers.object1;
        goto L66
    L47:
        position = decodeBytes(data, position, registers);
        r3 = registers.object1;
        goto L66
    L50:
        position = decodeVarint64(data, position, registers);
        r3 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
        goto L66
    L51:
        position = decodeVarint32(data, position, registers);
        r3 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
        goto L66
    L52:
        position = decodeVarint64(data, position, registers);
        if (registers.long1 == 0) goto L55;
        boolean r12 = true;
    L56:
        r3 = Boolean.valueOf(r12);
        goto L66
    L55:
        r12 = false;
        goto L56
    L57:
        r3 = Integer.valueOf(decodeFixed32(data, position));
    L62:
        position = position + 4;
        goto L66
    L58:
        r3 = Long.valueOf(decodeFixed64(data, position));
    L64:
        position = position + 8;
        goto L66
    L59:
        position = decodeVarint32(data, position, registers);
        r3 = Integer.valueOf(registers.int1);
        goto L66
    L60:
        position = decodeVarint64(data, position, registers);
        r3 = Long.valueOf(registers.long1);
        goto L66
    L61:
        r3 = Float.valueOf(decodeFloat(data, position));
        goto L62
    L63:
        r3 = Double.valueOf(decodeDouble(data, position));
        goto L64
    L49:
        throw new IllegalStateException("Shouldn't reach here.");
    L5:
        if (extension.descriptor.isPacked() == false) goto L20;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[extension.getLiteType().ordinal()]) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L14;
            case 11: goto L13;
            case 12: goto L12;
            case 13: goto L11;
            case 14: goto L10;
            default: goto L9;
        };
    L10:
        IntArrayList r13 = new IntArrayList();
        int r14 = decodePackedVarint32List(data, position, r13, registers);
        SchemaUtil.filterUnknownEnumList(message, r2, r13, extension.descriptor.getEnumType(), null, unknownFieldSchema);
        r0.setField(extension.descriptor, r13);
        return r14;
    L11:
        LongArrayList r15 = new LongArrayList();
        int r16 = decodePackedSInt64List(data, position, r15, registers);
        r0.setField(extension.descriptor, r15);
        return r16;
    L12:
        IntArrayList r17 = new IntArrayList();
        int r18 = decodePackedSInt32List(data, position, r17, registers);
        r0.setField(extension.descriptor, r17);
        return r18;
    L13:
        BooleanArrayList r19 = new BooleanArrayList();
        int r20 = decodePackedBoolList(data, position, r19, registers);
        r0.setField(extension.descriptor, r19);
        return r20;
    L14:
        IntArrayList r21 = new IntArrayList();
        int r22 = decodePackedFixed32List(data, position, r21, registers);
        r0.setField(extension.descriptor, r21);
        return r22;
    L15:
        LongArrayList r23 = new LongArrayList();
        int r24 = decodePackedFixed64List(data, position, r23, registers);
        r0.setField(extension.descriptor, r23);
        return r24;
    L16:
        IntArrayList r25 = new IntArrayList();
        int r26 = decodePackedVarint32List(data, position, r25, registers);
        r0.setField(extension.descriptor, r25);
        return r26;
    L17:
        LongArrayList r27 = new LongArrayList();
        int r28 = decodePackedVarint64List(data, position, r27, registers);
        r0.setField(extension.descriptor, r27);
        return r28;
    L18:
        FloatArrayList r29 = new FloatArrayList();
        int r30 = decodePackedFloatList(data, position, r29, registers);
        r0.setField(extension.descriptor, r29);
        return r30;
    L19:
        DoubleArrayList r31 = new DoubleArrayList();
        int r32 = decodePackedDoubleList(data, position, r31, registers);
        r0.setField(extension.descriptor, r31);
        return r32;
    L9:
        throw new IllegalStateException("Type cannot be packed: " + extension.descriptor.getLiteType());
    }

    static int decodeUnknownField(int tag, byte[] data, int position, int limit, UnknownFieldSetLite unknownFields, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(tag) == 0) goto L48;
        int r0 = WireFormat.getTagWireType(tag);
        if (r0 != 0) goto L7;
        int r10 = decodeVarint64(data, position, registers);
        unknownFields.storeField(tag, Long.valueOf(registers.long1));
        return r10;
    L7:
        if (r0 != 1) goto L9;
        unknownFields.storeField(tag, Long.valueOf(decodeFixed64(data, position)));
        return position + 8;
    L9:
        if (r0 != 2) goto L11;
        int r11 = decodeVarint32(data, position, registers);
        int r12 = registers.int1;
        if (r12 < 0) goto L42;
        if (r12 > (data.length - r11)) goto L40;
        if (r12 != 0) goto L36;
        unknownFields.storeField(tag, ByteString.EMPTY);
    L38:
        return r11 + r12;
    L36:
        unknownFields.storeField(tag, ByteString.copyFrom(data, r11, r12));
        goto L38
    L40:
        throw InvalidProtocolBufferException.truncatedMessage();
    L42:
        throw InvalidProtocolBufferException.negativeSize();
    L11:
        if (r0 != 3) goto L13;
        UnknownFieldSetLite r6 = UnknownFieldSetLite.newInstance();
        int r7 = (tag & (-8)) | 4;
        int r1 = 0;
    L19:
        if (position >= limit) goto L24;
        int r2 = decodeVarint32(data, position, registers);
        int r13 = registers.int1;
        if (r13 == r7) goto L22;
        r1 = r13;
        position = decodeUnknownField(r13, data, r2, limit, r6, registers);
        goto L19
    L22:
        r1 = r13;
        position = r2;
    L24:
        if (position > limit) goto L29;
        if (r1 != r7) goto L29;
        unknownFields.storeField(tag, r6);
        return position;
    L29:
        throw InvalidProtocolBufferException.parseFailure();
    L13:
        if (r0 != 5) goto L17;
        unknownFields.storeField(tag, Integer.valueOf(decodeFixed32(data, position)));
        return position + 4;
    L17:
        throw InvalidProtocolBufferException.invalidTag();
    L48:
        throw InvalidProtocolBufferException.invalidTag();
    }

    static int skipField(int tag, byte[] data, int position, int limit, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(tag) == 0) goto L36;
        int r0 = WireFormat.getTagWireType(tag);
        if (r0 == 0) goto L34;
        if (r0 == 1) goto L32;
        if (r0 == 2) goto L30;
        if (r0 != 3) goto L13;
        int r2 = (tag & (-8)) | 4;
        int r1 = 0;
    L19:
        if (position >= limit) goto L24;
        position = decodeVarint32(data, position, registers);
        r1 = registers.int1;
        if (r1 == r2) goto L24;
        position = skipField(r1, data, position, limit, registers);
    L24:
        if (position > limit) goto L28;
        if (r1 != r2) goto L28;
        return position;
    L28:
        throw InvalidProtocolBufferException.parseFailure();
    L13:
        if (r0 != 5) goto L17;
        return position + 4;
    L17:
        throw InvalidProtocolBufferException.invalidTag();
    L30:
        return decodeVarint32(data, position, registers) + registers.int1;
    L32:
        return position + 8;
    L34:
        return decodeVarint64(data, position, registers);
    L36:
        throw InvalidProtocolBufferException.invalidTag();
    }
}
