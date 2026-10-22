package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
@CheckReturnValue
final class CodedInputStreamReader implements Reader {
    private static final int FIXED32_MULTIPLE_MASK = 3;
    private static final int FIXED64_MULTIPLE_MASK = 7;
    private static final int NEXT_TAG_UNSET = 0;
    private int endGroupTag;
    private final CodedInputStream input;
    private int nextTag;
    private int tag;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.CodedInputStreamReader$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r0 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0;
            r0[WireFormat.FieldType.BOOL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L60:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L44:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L56:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L62:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L46:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L50:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L70:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L40:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L64:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L30
        L66:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 11;     // Catch: NoSuchFieldError -> L31
        L52:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 12;     // Catch: NoSuchFieldError -> L32
        L58:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 13;     // Catch: NoSuchFieldError -> L33
        L42:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 14;     // Catch: NoSuchFieldError -> L34
        L48:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 15;     // Catch: NoSuchFieldError -> L35
        L68:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 16;     // Catch: NoSuchFieldError -> L36
        L38:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 17;     // Catch: NoSuchFieldError -> L37
            return;
        }
    }

    public static CodedInputStreamReader forCodedInput(CodedInputStream input) {
        if (input.wrapper == null) goto L7;
        return input.wrapper;
    L7:
        return new CodedInputStreamReader(input);
    }

    private CodedInputStreamReader(CodedInputStream input) {
        this.nextTag = 0;
        CodedInputStream r2 = (CodedInputStream) Internal.checkNotNull(input, "input");
        this.input = r2;
        r2.wrapper = this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public boolean shouldDiscardUnknownFields() {
        return this.input.shouldDiscardUnknownFields();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public int getFieldNumber() throws IOException {
        int r0 = this.nextTag;
        if (r0 == 0) goto L5;
        this.tag = r0;
        this.nextTag = 0;
    L6:
        int r1 = this.tag;
        if (r1 != 0) goto L9;
        return Integer.MAX_VALUE;
    L9:
        if (r1 != this.endGroupTag) goto L12;
        return Integer.MAX_VALUE;
    L12:
        return WireFormat.getTagFieldNumber(r1);
    L5:
        this.tag = this.input.readTag();
        goto L6
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public int getTag() {
        return this.tag;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public boolean skipField() throws IOException {
        if (this.input.isAtEnd() == true) goto L9;
        int r0 = this.tag;
        if (r0 != this.endGroupTag) goto L8;
        return false;
    L8:
        return this.input.skipField(r0);
    L9:
        return false;
    }

    private void requireWireType(int requiredWireType) throws IOException {
        if (WireFormat.getTagWireType(this.tag) != requiredWireType) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public double readDouble() throws IOException {
        requireWireType(1);
        return this.input.readDouble();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public float readFloat() throws IOException {
        requireWireType(5);
        return this.input.readFloat();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public long readUInt64() throws IOException {
        requireWireType(0);
        return this.input.readUInt64();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public long readInt64() throws IOException {
        requireWireType(0);
        return this.input.readInt64();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public int readInt32() throws IOException {
        requireWireType(0);
        return this.input.readInt32();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public long readFixed64() throws IOException {
        requireWireType(1);
        return this.input.readFixed64();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public int readFixed32() throws IOException {
        requireWireType(5);
        return this.input.readFixed32();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public boolean readBool() throws IOException {
        requireWireType(0);
        return this.input.readBool();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public String readString() throws IOException {
        requireWireType(2);
        return this.input.readString();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public String readStringRequireUtf8() throws IOException {
        requireWireType(2);
        return this.input.readStringRequireUtf8();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public <T> T readMessage(Class<T> r2, ExtensionRegistryLite r3) throws IOException {
        requireWireType(2);
        return (T) readMessage(Protobuf.getInstance().schemaFor(r2), r3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public <T> T readMessageBySchemaWithCheck(Schema<T> r2, ExtensionRegistryLite r3) throws IOException {
        requireWireType(2);
        return (T) readMessage(r2, r3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    @Deprecated
    public <T> T readGroup(Class<T> r2, ExtensionRegistryLite r3) throws IOException {
        requireWireType(3);
        return (T) readGroup(Protobuf.getInstance().schemaFor(r2), r3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    @Deprecated
    public <T> T readGroupBySchemaWithCheck(Schema<T> r2, ExtensionRegistryLite r3) throws IOException {
        requireWireType(3);
        return (T) readGroup(r2, r3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public <T> void mergeMessageField(T target, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        requireWireType(2);
        mergeMessageFieldInternal(target, schema, extensionRegistry);
    }

    private <T> void mergeMessageFieldInternal(T target, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        int r0 = this.input.readUInt32();
        if (this.input.recursionDepth >= this.input.recursionLimit) goto L7;
        int r1 = this.input.pushLimit(r0);
        this.input.recursionDepth++;
        schema.mergeFrom(target, this, extensionRegistry);
        this.input.checkLastTagWas(0);
        this.input.recursionDepth--;
        this.input.popLimit(r1);
        return;
    L7:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    private <T> T readMessage(Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        T r0 = schema.newInstance();
        mergeMessageFieldInternal(r0, schema, extensionRegistry);
        schema.makeImmutable(r0);
        return r0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public <T> void mergeGroupField(T target, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        requireWireType(3);
        mergeGroupFieldInternal(target, schema, extensionRegistry);
    }

    private <T> void mergeGroupFieldInternal(T target, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        int r0 = this.endGroupTag;
        this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
        schema.mergeFrom(target, this, extensionRegistry);     // Catch: Throwable -> L9
        if (this.tag != this.endGroupTag) goto L8;
        this.endGroupTag = r0;
        return;
    L8:
        throw InvalidProtocolBufferException.parseFailure();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        this.endGroupTag = r0;
        throw th;
    }

    private <T> T readGroup(Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        T r0 = schema.newInstance();
        mergeGroupFieldInternal(r0, schema, extensionRegistry);
        schema.makeImmutable(r0);
        return r0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public ByteString readBytes() throws IOException {
        requireWireType(2);
        return this.input.readBytes();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public int readUInt32() throws IOException {
        requireWireType(0);
        return this.input.readUInt32();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public int readEnum() throws IOException {
        requireWireType(0);
        return this.input.readEnum();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public int readSFixed32() throws IOException {
        requireWireType(5);
        return this.input.readSFixed32();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public long readSFixed64() throws IOException {
        requireWireType(1);
        return this.input.readSFixed64();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public int readSInt32() throws IOException {
        requireWireType(0);
        return this.input.readSInt32();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public long readSInt64() throws IOException {
        requireWireType(0);
        return this.input.readSInt64();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readDoubleList(List<Double> target) throws IOException {
        if ((target instanceof DoubleArrayList) == false) goto L20;
        DoubleArrayList r0 = (DoubleArrayList) target;
        int r5 = WireFormat.getTagWireType(this.tag);
        if (r5 == 1) goto L13;
        if (r5 != 2) goto L12;
        int r6 = this.input.readUInt32();
        verifyPackedFixed64Length(r6);
        int r1 = this.input.getTotalBytesRead() + r6;
    L8:
        r0.addDouble(this.input.readDouble());
        if (this.input.getTotalBytesRead() < r1) goto L8;
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.addDouble(this.input.readDouble());
        if (this.input.isAtEnd() == true) goto L15;
        int r7 = this.input.readTag();
        if (r7 == this.tag) goto L13;
        this.nextTag = r7;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.getTagWireType(this.tag);
        if (r2 == 1) goto L29;
        if (r2 != 2) goto L28;
        int r3 = this.input.readUInt32();
        verifyPackedFixed64Length(r3);
        int r4 = this.input.getTotalBytesRead() + r3;
    L24:
        target.add(Double.valueOf(this.input.readDouble()));
        if (this.input.getTotalBytesRead() < r4) goto L24;
        return;
    L28:
        throw InvalidProtocolBufferException.invalidWireType();
    L29:
        target.add(Double.valueOf(this.input.readDouble()));
        if (this.input.isAtEnd() == true) goto L31;
        int r8 = this.input.readTag();
        if (r8 == this.tag) goto L29;
        this.nextTag = r8;
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readFloatList(List<Float> target) throws IOException {
        if ((target instanceof FloatArrayList) == false) goto L20;
        FloatArrayList r0 = (FloatArrayList) target;
        int r5 = WireFormat.getTagWireType(this.tag);
        if (r5 == 2) goto L16;
        if (r5 != 5) goto L15;
    L7:
        r0.addFloat(this.input.readFloat());
        if (this.input.isAtEnd() == true) goto L9;
        int r6 = this.input.readTag();
        if (r6 == this.tag) goto L7;
        this.nextTag = r6;
        return;
    L9:
        return;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L16:
        int r7 = this.input.readUInt32();
        verifyPackedFixed32Length(r7);
        int r3 = this.input.getTotalBytesRead() + r7;
    L17:
        r0.addFloat(this.input.readFloat());
        if (this.input.getTotalBytesRead() < r3) goto L17;
        return;
    L20:
        int r1 = WireFormat.getTagWireType(this.tag);
        if (r1 == 2) goto L32;
        if (r1 != 5) goto L31;
    L23:
        target.add(Float.valueOf(this.input.readFloat()));
        if (this.input.isAtEnd() == true) goto L25;
        int r2 = this.input.readTag();
        if (r2 == this.tag) goto L23;
        this.nextTag = r2;
        return;
    L25:
        return;
    L31:
        throw InvalidProtocolBufferException.invalidWireType();
    L32:
        int r4 = this.input.readUInt32();
        verifyPackedFixed32Length(r4);
        int r8 = this.input.getTotalBytesRead() + r4;
    L33:
        target.add(Float.valueOf(this.input.readFloat()));
        if (this.input.getTotalBytesRead() < r8) goto L33;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readUInt64List(List<Long> target) throws IOException {
        if ((target instanceof LongArrayList) == false) goto L20;
        LongArrayList r0 = (LongArrayList) target;
        int r5 = WireFormat.getTagWireType(this.tag);
        if (r5 == 0) goto L13;
        if (r5 != 2) goto L12;
        int r6 = this.input.readUInt32();
        int r1 = this.input.getTotalBytesRead() + r6;
    L8:
        r0.addLong(this.input.readUInt64());
        if (this.input.getTotalBytesRead() < r1) goto L8;
        requirePosition(r1);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.addLong(this.input.readUInt64());
        if (this.input.isAtEnd() == true) goto L15;
        int r7 = this.input.readTag();
        if (r7 == this.tag) goto L13;
        this.nextTag = r7;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.getTagWireType(this.tag);
        if (r2 == 0) goto L30;
        if (r2 != 2) goto L29;
        int r3 = this.input.readUInt32();
        int r4 = this.input.getTotalBytesRead() + r3;
    L24:
        target.add(Long.valueOf(this.input.readUInt64()));
        if (this.input.getTotalBytesRead() < r4) goto L24;
        requirePosition(r4);
        return;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        target.add(Long.valueOf(this.input.readUInt64()));
        if (this.input.isAtEnd() == true) goto L32;
        int r8 = this.input.readTag();
        if (r8 == this.tag) goto L30;
        this.nextTag = r8;
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readInt64List(List<Long> target) throws IOException {
        if ((target instanceof LongArrayList) == false) goto L20;
        LongArrayList r0 = (LongArrayList) target;
        int r5 = WireFormat.getTagWireType(this.tag);
        if (r5 == 0) goto L13;
        if (r5 != 2) goto L12;
        int r6 = this.input.readUInt32();
        int r1 = this.input.getTotalBytesRead() + r6;
    L8:
        r0.addLong(this.input.readInt64());
        if (this.input.getTotalBytesRead() < r1) goto L8;
        requirePosition(r1);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.addLong(this.input.readInt64());
        if (this.input.isAtEnd() == true) goto L15;
        int r7 = this.input.readTag();
        if (r7 == this.tag) goto L13;
        this.nextTag = r7;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.getTagWireType(this.tag);
        if (r2 == 0) goto L30;
        if (r2 != 2) goto L29;
        int r3 = this.input.readUInt32();
        int r4 = this.input.getTotalBytesRead() + r3;
    L24:
        target.add(Long.valueOf(this.input.readInt64()));
        if (this.input.getTotalBytesRead() < r4) goto L24;
        requirePosition(r4);
        return;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        target.add(Long.valueOf(this.input.readInt64()));
        if (this.input.isAtEnd() == true) goto L32;
        int r8 = this.input.readTag();
        if (r8 == this.tag) goto L30;
        this.nextTag = r8;
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readInt32List(List<Integer> target) throws IOException {
        if ((target instanceof IntArrayList) == false) goto L20;
        IntArrayList r0 = (IntArrayList) target;
        int r3 = WireFormat.getTagWireType(this.tag);
        if (r3 == 0) goto L13;
        if (r3 != 2) goto L12;
        int r4 = this.input.readUInt32();
        int r1 = this.input.getTotalBytesRead() + r4;
    L8:
        r0.addInt(this.input.readInt32());
        if (this.input.getTotalBytesRead() < r1) goto L8;
        requirePosition(r1);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.addInt(this.input.readInt32());
        if (this.input.isAtEnd() == true) goto L15;
        int r5 = this.input.readTag();
        if (r5 == this.tag) goto L13;
        this.nextTag = r5;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.getTagWireType(this.tag);
        if (r2 == 0) goto L30;
        if (r2 != 2) goto L29;
        int r6 = this.input.readUInt32();
        int r7 = this.input.getTotalBytesRead() + r6;
    L24:
        target.add(Integer.valueOf(this.input.readInt32()));
        if (this.input.getTotalBytesRead() < r7) goto L24;
        requirePosition(r7);
        return;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        target.add(Integer.valueOf(this.input.readInt32()));
        if (this.input.isAtEnd() == true) goto L32;
        int r8 = this.input.readTag();
        if (r8 == this.tag) goto L30;
        this.nextTag = r8;
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readFixed64List(List<Long> target) throws IOException {
        if ((target instanceof LongArrayList) == false) goto L20;
        LongArrayList r0 = (LongArrayList) target;
        int r5 = WireFormat.getTagWireType(this.tag);
        if (r5 == 1) goto L13;
        if (r5 != 2) goto L12;
        int r6 = this.input.readUInt32();
        verifyPackedFixed64Length(r6);
        int r1 = this.input.getTotalBytesRead() + r6;
    L8:
        r0.addLong(this.input.readFixed64());
        if (this.input.getTotalBytesRead() < r1) goto L8;
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.addLong(this.input.readFixed64());
        if (this.input.isAtEnd() == true) goto L15;
        int r7 = this.input.readTag();
        if (r7 == this.tag) goto L13;
        this.nextTag = r7;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.getTagWireType(this.tag);
        if (r2 == 1) goto L29;
        if (r2 != 2) goto L28;
        int r3 = this.input.readUInt32();
        verifyPackedFixed64Length(r3);
        int r4 = this.input.getTotalBytesRead() + r3;
    L24:
        target.add(Long.valueOf(this.input.readFixed64()));
        if (this.input.getTotalBytesRead() < r4) goto L24;
        return;
    L28:
        throw InvalidProtocolBufferException.invalidWireType();
    L29:
        target.add(Long.valueOf(this.input.readFixed64()));
        if (this.input.isAtEnd() == true) goto L31;
        int r8 = this.input.readTag();
        if (r8 == this.tag) goto L29;
        this.nextTag = r8;
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readFixed32List(List<Integer> target) throws IOException {
        if ((target instanceof IntArrayList) == false) goto L20;
        IntArrayList r0 = (IntArrayList) target;
        int r5 = WireFormat.getTagWireType(this.tag);
        if (r5 == 2) goto L16;
        if (r5 != 5) goto L15;
    L7:
        r0.addInt(this.input.readFixed32());
        if (this.input.isAtEnd() == true) goto L9;
        int r6 = this.input.readTag();
        if (r6 == this.tag) goto L7;
        this.nextTag = r6;
        return;
    L9:
        return;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L16:
        int r7 = this.input.readUInt32();
        verifyPackedFixed32Length(r7);
        int r3 = this.input.getTotalBytesRead() + r7;
    L17:
        r0.addInt(this.input.readFixed32());
        if (this.input.getTotalBytesRead() < r3) goto L17;
        return;
    L20:
        int r1 = WireFormat.getTagWireType(this.tag);
        if (r1 == 2) goto L32;
        if (r1 != 5) goto L31;
    L23:
        target.add(Integer.valueOf(this.input.readFixed32()));
        if (this.input.isAtEnd() == true) goto L25;
        int r2 = this.input.readTag();
        if (r2 == this.tag) goto L23;
        this.nextTag = r2;
        return;
    L25:
        return;
    L31:
        throw InvalidProtocolBufferException.invalidWireType();
    L32:
        int r4 = this.input.readUInt32();
        verifyPackedFixed32Length(r4);
        int r8 = this.input.getTotalBytesRead() + r4;
    L33:
        target.add(Integer.valueOf(this.input.readFixed32()));
        if (this.input.getTotalBytesRead() < r8) goto L33;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readBoolList(List<Boolean> target) throws IOException {
        if ((target instanceof BooleanArrayList) == false) goto L20;
        BooleanArrayList r0 = (BooleanArrayList) target;
        int r3 = WireFormat.getTagWireType(this.tag);
        if (r3 == 0) goto L13;
        if (r3 != 2) goto L12;
        int r4 = this.input.readUInt32();
        int r1 = this.input.getTotalBytesRead() + r4;
    L8:
        r0.addBoolean(this.input.readBool());
        if (this.input.getTotalBytesRead() < r1) goto L8;
        requirePosition(r1);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.addBoolean(this.input.readBool());
        if (this.input.isAtEnd() == true) goto L15;
        int r5 = this.input.readTag();
        if (r5 == this.tag) goto L13;
        this.nextTag = r5;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.getTagWireType(this.tag);
        if (r2 == 0) goto L30;
        if (r2 != 2) goto L29;
        int r6 = this.input.readUInt32();
        int r7 = this.input.getTotalBytesRead() + r6;
    L24:
        target.add(Boolean.valueOf(this.input.readBool()));
        if (this.input.getTotalBytesRead() < r7) goto L24;
        requirePosition(r7);
        return;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        target.add(Boolean.valueOf(this.input.readBool()));
        if (this.input.isAtEnd() == true) goto L32;
        int r8 = this.input.readTag();
        if (r8 == this.tag) goto L30;
        this.nextTag = r8;
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readStringList(List<String> target) throws IOException {
        readStringListInternal(target, false);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readStringListRequireUtf8(List<String> target) throws IOException {
        readStringListInternal(target, true);
    }

    public void readStringListInternal(List<String> target, boolean requireUtf8) throws IOException {
        if (WireFormat.getTagWireType(this.tag) != 2) goto L26;
        if ((target instanceof LazyStringList) == false) goto L15;
        if (requireUtf8 == true) goto L15;
        LazyStringList r0 = (LazyStringList) target;
    L8:
        r0.add(readBytes());
        if (this.input.isAtEnd() == true) goto L10;
        int r3 = this.input.readTag();
        if (r3 == this.tag) goto L8;
        this.nextTag = r3;
        return;
    L10:
        return;
    L15:
        if (requireUtf8 == false) goto L17;
        String r1 = readStringRequireUtf8();
    L18:
        target.add(r1);
        if (this.input.isAtEnd() == true) goto L20;
        int r2 = this.input.readTag();
        if (r2 == this.tag) goto L15;
        this.nextTag = r2;
        return;
    L20:
        return;
    L17:
        r1 = readString();
        goto L18
    L26:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public <T> void readMessageList(List<T> target, Class<T> targetType, ExtensionRegistryLite extensionRegistry) throws IOException {
        readMessageList(target, Protobuf.getInstance().schemaFor(targetType), extensionRegistry);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public <T> void readMessageList(List<T> target, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        if (WireFormat.getTagWireType(this.tag) != 2) goto L15;
        int r0 = this.tag;
    L5:
        target.add(readMessage(schema, extensionRegistry));
        if (this.input.isAtEnd() == true) goto L20;
        if (this.nextTag != 0) goto L21;
        int r1 = this.input.readTag();
        if (r1 == r0) goto L5;
        this.nextTag = r1;
        return;
    L21:
        return;
    L20:
        return;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    @Deprecated
    public <T> void readGroupList(List<T> target, Class<T> targetType, ExtensionRegistryLite extensionRegistry) throws IOException {
        readGroupList(target, Protobuf.getInstance().schemaFor(targetType), extensionRegistry);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    @Deprecated
    public <T> void readGroupList(List<T> target, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        if (WireFormat.getTagWireType(this.tag) != 3) goto L15;
        int r0 = this.tag;
    L5:
        target.add(readGroup(schema, extensionRegistry));
        if (this.input.isAtEnd() == true) goto L20;
        if (this.nextTag != 0) goto L21;
        int r1 = this.input.readTag();
        if (r1 == r0) goto L5;
        this.nextTag = r1;
        return;
    L21:
        return;
    L20:
        return;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readBytesList(List<ByteString> target) throws IOException {
        if (WireFormat.getTagWireType(this.tag) != 2) goto L12;
    L4:
        target.add(readBytes());
        if (this.input.isAtEnd() == true) goto L6;
        int r0 = this.input.readTag();
        if (r0 == this.tag) goto L4;
        this.nextTag = r0;
        return;
    L6:
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readUInt32List(List<Integer> target) throws IOException {
        if ((target instanceof IntArrayList) == false) goto L20;
        IntArrayList r0 = (IntArrayList) target;
        int r3 = WireFormat.getTagWireType(this.tag);
        if (r3 == 0) goto L13;
        if (r3 != 2) goto L12;
        int r4 = this.input.readUInt32();
        int r1 = this.input.getTotalBytesRead() + r4;
    L8:
        r0.addInt(this.input.readUInt32());
        if (this.input.getTotalBytesRead() < r1) goto L8;
        requirePosition(r1);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.addInt(this.input.readUInt32());
        if (this.input.isAtEnd() == true) goto L15;
        int r5 = this.input.readTag();
        if (r5 == this.tag) goto L13;
        this.nextTag = r5;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.getTagWireType(this.tag);
        if (r2 == 0) goto L30;
        if (r2 != 2) goto L29;
        int r6 = this.input.readUInt32();
        int r7 = this.input.getTotalBytesRead() + r6;
    L24:
        target.add(Integer.valueOf(this.input.readUInt32()));
        if (this.input.getTotalBytesRead() < r7) goto L24;
        requirePosition(r7);
        return;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        target.add(Integer.valueOf(this.input.readUInt32()));
        if (this.input.isAtEnd() == true) goto L32;
        int r8 = this.input.readTag();
        if (r8 == this.tag) goto L30;
        this.nextTag = r8;
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readEnumList(List<Integer> target) throws IOException {
        if ((target instanceof IntArrayList) == false) goto L20;
        IntArrayList r0 = (IntArrayList) target;
        int r3 = WireFormat.getTagWireType(this.tag);
        if (r3 == 0) goto L13;
        if (r3 != 2) goto L12;
        int r4 = this.input.readUInt32();
        int r1 = this.input.getTotalBytesRead() + r4;
    L8:
        r0.addInt(this.input.readEnum());
        if (this.input.getTotalBytesRead() < r1) goto L8;
        requirePosition(r1);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.addInt(this.input.readEnum());
        if (this.input.isAtEnd() == true) goto L15;
        int r5 = this.input.readTag();
        if (r5 == this.tag) goto L13;
        this.nextTag = r5;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.getTagWireType(this.tag);
        if (r2 == 0) goto L30;
        if (r2 != 2) goto L29;
        int r6 = this.input.readUInt32();
        int r7 = this.input.getTotalBytesRead() + r6;
    L24:
        target.add(Integer.valueOf(this.input.readEnum()));
        if (this.input.getTotalBytesRead() < r7) goto L24;
        requirePosition(r7);
        return;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        target.add(Integer.valueOf(this.input.readEnum()));
        if (this.input.isAtEnd() == true) goto L32;
        int r8 = this.input.readTag();
        if (r8 == this.tag) goto L30;
        this.nextTag = r8;
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readSFixed32List(List<Integer> target) throws IOException {
        if ((target instanceof IntArrayList) == false) goto L20;
        IntArrayList r0 = (IntArrayList) target;
        int r5 = WireFormat.getTagWireType(this.tag);
        if (r5 == 2) goto L16;
        if (r5 != 5) goto L15;
    L7:
        r0.addInt(this.input.readSFixed32());
        if (this.input.isAtEnd() == true) goto L9;
        int r6 = this.input.readTag();
        if (r6 == this.tag) goto L7;
        this.nextTag = r6;
        return;
    L9:
        return;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L16:
        int r7 = this.input.readUInt32();
        verifyPackedFixed32Length(r7);
        int r3 = this.input.getTotalBytesRead() + r7;
    L17:
        r0.addInt(this.input.readSFixed32());
        if (this.input.getTotalBytesRead() < r3) goto L17;
        return;
    L20:
        int r1 = WireFormat.getTagWireType(this.tag);
        if (r1 == 2) goto L32;
        if (r1 != 5) goto L31;
    L23:
        target.add(Integer.valueOf(this.input.readSFixed32()));
        if (this.input.isAtEnd() == true) goto L25;
        int r2 = this.input.readTag();
        if (r2 == this.tag) goto L23;
        this.nextTag = r2;
        return;
    L25:
        return;
    L31:
        throw InvalidProtocolBufferException.invalidWireType();
    L32:
        int r4 = this.input.readUInt32();
        verifyPackedFixed32Length(r4);
        int r8 = this.input.getTotalBytesRead() + r4;
    L33:
        target.add(Integer.valueOf(this.input.readSFixed32()));
        if (this.input.getTotalBytesRead() < r8) goto L33;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readSFixed64List(List<Long> target) throws IOException {
        if ((target instanceof LongArrayList) == false) goto L20;
        LongArrayList r0 = (LongArrayList) target;
        int r5 = WireFormat.getTagWireType(this.tag);
        if (r5 == 1) goto L13;
        if (r5 != 2) goto L12;
        int r6 = this.input.readUInt32();
        verifyPackedFixed64Length(r6);
        int r1 = this.input.getTotalBytesRead() + r6;
    L8:
        r0.addLong(this.input.readSFixed64());
        if (this.input.getTotalBytesRead() < r1) goto L8;
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.addLong(this.input.readSFixed64());
        if (this.input.isAtEnd() == true) goto L15;
        int r7 = this.input.readTag();
        if (r7 == this.tag) goto L13;
        this.nextTag = r7;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.getTagWireType(this.tag);
        if (r2 == 1) goto L29;
        if (r2 != 2) goto L28;
        int r3 = this.input.readUInt32();
        verifyPackedFixed64Length(r3);
        int r4 = this.input.getTotalBytesRead() + r3;
    L24:
        target.add(Long.valueOf(this.input.readSFixed64()));
        if (this.input.getTotalBytesRead() < r4) goto L24;
        return;
    L28:
        throw InvalidProtocolBufferException.invalidWireType();
    L29:
        target.add(Long.valueOf(this.input.readSFixed64()));
        if (this.input.isAtEnd() == true) goto L31;
        int r8 = this.input.readTag();
        if (r8 == this.tag) goto L29;
        this.nextTag = r8;
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readSInt32List(List<Integer> target) throws IOException {
        if ((target instanceof IntArrayList) == false) goto L20;
        IntArrayList r0 = (IntArrayList) target;
        int r3 = WireFormat.getTagWireType(this.tag);
        if (r3 == 0) goto L13;
        if (r3 != 2) goto L12;
        int r4 = this.input.readUInt32();
        int r1 = this.input.getTotalBytesRead() + r4;
    L8:
        r0.addInt(this.input.readSInt32());
        if (this.input.getTotalBytesRead() < r1) goto L8;
        requirePosition(r1);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.addInt(this.input.readSInt32());
        if (this.input.isAtEnd() == true) goto L15;
        int r5 = this.input.readTag();
        if (r5 == this.tag) goto L13;
        this.nextTag = r5;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.getTagWireType(this.tag);
        if (r2 == 0) goto L30;
        if (r2 != 2) goto L29;
        int r6 = this.input.readUInt32();
        int r7 = this.input.getTotalBytesRead() + r6;
    L24:
        target.add(Integer.valueOf(this.input.readSInt32()));
        if (this.input.getTotalBytesRead() < r7) goto L24;
        requirePosition(r7);
        return;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        target.add(Integer.valueOf(this.input.readSInt32()));
        if (this.input.isAtEnd() == true) goto L32;
        int r8 = this.input.readTag();
        if (r8 == this.tag) goto L30;
        this.nextTag = r8;
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readSInt64List(List<Long> target) throws IOException {
        if ((target instanceof LongArrayList) == false) goto L20;
        LongArrayList r0 = (LongArrayList) target;
        int r5 = WireFormat.getTagWireType(this.tag);
        if (r5 == 0) goto L13;
        if (r5 != 2) goto L12;
        int r6 = this.input.readUInt32();
        int r1 = this.input.getTotalBytesRead() + r6;
    L8:
        r0.addLong(this.input.readSInt64());
        if (this.input.getTotalBytesRead() < r1) goto L8;
        requirePosition(r1);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.addLong(this.input.readSInt64());
        if (this.input.isAtEnd() == true) goto L15;
        int r7 = this.input.readTag();
        if (r7 == this.tag) goto L13;
        this.nextTag = r7;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.getTagWireType(this.tag);
        if (r2 == 0) goto L30;
        if (r2 != 2) goto L29;
        int r3 = this.input.readUInt32();
        int r4 = this.input.getTotalBytesRead() + r3;
    L24:
        target.add(Long.valueOf(this.input.readSInt64()));
        if (this.input.getTotalBytesRead() < r4) goto L24;
        requirePosition(r4);
        return;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        target.add(Long.valueOf(this.input.readSInt64()));
        if (this.input.isAtEnd() == true) goto L32;
        int r8 = this.input.readTag();
        if (r8 == this.tag) goto L30;
        this.nextTag = r8;
        return;
    }

    private void verifyPackedFixed64Length(int bytes) throws IOException {
        if ((bytes & 7) != 0) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.parseFailure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public <K, V> void readMap(Map<K, V> target, MapEntryLite.Metadata<K, V> metadata, ExtensionRegistryLite extensionRegistry) throws IOException {
        requireWireType(2);
        int r1 = this.input.readUInt32();
        int r2 = this.input.pushLimit(r1);
        Object r3 = metadata.defaultKey;
        Object r4 = metadata.defaultValue;
    L30:
        int r5 = getFieldNumber();     // Catch: Throwable -> L27
        if (r5 == Integer.MAX_VALUE) goto L24;
        if (this.input.isAtEnd() == true) goto L24;
        if (r5 != 1) goto L10;
        r3 = readField(metadata.keyType, null, null);     // Catch: InvalidProtocolBufferException.InvalidWireTypeException -> L19 Throwable -> L27
        goto L30
    L10:
        if (r5 == 2) goto L16;
        if (skipField() == true) goto L30;
        throw new InvalidProtocolBufferException("Unable to parse map entry.");     // Catch: InvalidProtocolBufferException.InvalidWireTypeException -> L19 Throwable -> L27
    L20:
        if (skipField() == true) goto L30;
        throw new InvalidProtocolBufferException("Unable to parse map entry.");     // Catch: Throwable -> L27
    L16:
        r4 = readField(metadata.valueType, metadata.defaultValue.getClass(), extensionRegistry);     // Catch: InvalidProtocolBufferException.InvalidWireTypeException -> L19 Throwable -> L27
    L24:
        target.put(r3, r4);     // Catch: Throwable -> L27
        this.input.popLimit(r2);
        return;
    L27:
        th = move-exception;
        this.input.popLimit(r2);
        throw th;
    }

    private Object readField(WireFormat.FieldType fieldType, Class<?> messageType, ExtensionRegistryLite extensionRegistry) throws IOException {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1: goto L39;
            case 2: goto L37;
            case 3: goto L35;
            case 4: goto L33;
            case 5: goto L31;
            case 6: goto L29;
            case 7: goto L27;
            case 8: goto L25;
            case 9: goto L23;
            case 10: goto L21;
            case 11: goto L19;
            case 12: goto L17;
            case 13: goto L15;
            case 14: goto L13;
            case 15: goto L11;
            case 16: goto L9;
            case 17: goto L7;
            default: goto L5;
        };
    L5:
        throw new IllegalArgumentException("unsupported field type.");
    L7:
        return Long.valueOf(readUInt64());
    L9:
        return Integer.valueOf(readUInt32());
    L11:
        return readStringRequireUtf8();
    L13:
        return Long.valueOf(readSInt64());
    L15:
        return Integer.valueOf(readSInt32());
    L17:
        return Long.valueOf(readSFixed64());
    L19:
        return Integer.valueOf(readSFixed32());
    L21:
        return readMessage(messageType, extensionRegistry);
    L23:
        return Long.valueOf(readInt64());
    L25:
        return Integer.valueOf(readInt32());
    L27:
        return Float.valueOf(readFloat());
    L29:
        return Long.valueOf(readFixed64());
    L31:
        return Integer.valueOf(readFixed32());
    L33:
        return Integer.valueOf(readEnum());
    L35:
        return Double.valueOf(readDouble());
    L37:
        return readBytes();
    L39:
        return Boolean.valueOf(readBool());
    }

    private void verifyPackedFixed32Length(int bytes) throws IOException {
        if ((bytes & 3) != 0) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.parseFailure();
    }

    private void requirePosition(int expectedPosition) throws IOException {
        if (this.input.getTotalBytesRead() != expectedPosition) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.truncatedMessage();
    }
}
