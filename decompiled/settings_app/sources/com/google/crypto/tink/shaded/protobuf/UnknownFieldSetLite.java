package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class UnknownFieldSetLite {
    private static final UnknownFieldSetLite DEFAULT_INSTANCE = null;
    private static final int MIN_CAPACITY = 8;
    private int count;
    private boolean isMutable;
    private int memoizedSerializedSize;
    private Object[] objects;
    private int[] tags;

    static {
        DEFAULT_INSTANCE = new UnknownFieldSetLite(0, new int[0], new Object[0], false);
    }

    public static UnknownFieldSetLite getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    static UnknownFieldSetLite newInstance() {
        return new UnknownFieldSetLite();
    }

    static UnknownFieldSetLite mutableCopyOf(UnknownFieldSetLite first, UnknownFieldSetLite second) {
        int r0 = first.count + second.count;
        int[] r1 = Arrays.copyOf(first.tags, r0);
        System.arraycopy(second.tags, 0, r1, first.count, second.count);
        Object[] r2 = Arrays.copyOf(first.objects, r0);
        System.arraycopy(second.objects, 0, r2, first.count, second.count);
        return new UnknownFieldSetLite(r0, r1, r2, true);
    }

    private UnknownFieldSetLite() {
        this(0, new int[8], new Object[8], true);
    }

    private UnknownFieldSetLite(int count, int[] tags, Object[] objects, boolean isMutable) {
        this.memoizedSerializedSize = -1;
        this.count = count;
        this.tags = tags;
        this.objects = objects;
        this.isMutable = isMutable;
    }

    public void makeImmutable() {
        if (this.isMutable == false) goto L6;
        this.isMutable = false;
        return;
    }

    void checkMutable() {
        if (this.isMutable == false) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        int r0 = 0;
    L4:
        if (r0 >= this.count) goto L23;
        int r1 = this.tags[r0];
        int r2 = WireFormat.getTagFieldNumber(r1);
        int r3 = WireFormat.getTagWireType(r1);
        if (r3 != 0) goto L8;
        output.writeUInt64(r2, ((Long) this.objects[r0]).longValue());
    L22:
        r0 = r0 + 1;
        goto L4
    L8:
        if (r3 != 1) goto L10;
        output.writeFixed64(r2, ((Long) this.objects[r0]).longValue());
        goto L22
    L10:
        if (r3 != 2) goto L12;
        output.writeBytes(r2, (ByteString) this.objects[r0]);
        goto L22
    L12:
        if (r3 != 3) goto L14;
        output.writeTag(r2, 3);
        ((UnknownFieldSetLite) this.objects[r0]).writeTo(output);
        output.writeTag(r2, 4);
        goto L22
    L14:
        if (r3 != 5) goto L17;
        output.writeFixed32(r2, ((Integer) this.objects[r0]).intValue());
        goto L22
    L17:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public void writeAsMessageSetTo(CodedOutputStream output) throws IOException {
        int r0 = 0;
    L4:
        if (r0 >= this.count) goto L6;
        output.writeRawMessageSetExtension(WireFormat.getTagFieldNumber(this.tags[r0]), (ByteString) this.objects[r0]);
        r0 = r0 + 1;
        goto L4
    }

    void writeAsMessageSetTo(Writer writer) throws IOException {
        if (writer.fieldOrder() != Writer.FieldOrder.DESCENDING) goto L7;
        int r0 = this.count - 1;
    L5:
        if (r0 < 0) goto L11;
        writer.writeMessageSetItem(WireFormat.getTagFieldNumber(this.tags[r0]), this.objects[r0]);
        r0 = r0 - 1;
        goto L5
    L11:
        return;
    L7:
        int r1 = 0;
    L9:
        if (r1 >= this.count) goto L14;
        writer.writeMessageSetItem(WireFormat.getTagFieldNumber(this.tags[r1]), this.objects[r1]);
        r1 = r1 + 1;
        goto L9
    }

    public void writeTo(Writer writer) throws IOException {
        if (this.count != 0) goto L6;
        return;
    L6:
        if (writer.fieldOrder() != Writer.FieldOrder.ASCENDING) goto L11;
        int r0 = 0;
    L9:
        if (r0 >= this.count) goto L14;
        writeField(this.tags[r0], this.objects[r0], writer);
        r0 = r0 + 1;
        goto L9
    L14:
        return;
    L11:
        int r1 = this.count - 1;
    L12:
        if (r1 < 0) goto L17;
        writeField(this.tags[r1], this.objects[r1], writer);
        r1 = r1 - 1;
        goto L12
    }

    private static void writeField(int tag, Object object, Writer writer) throws IOException {
        int r0 = WireFormat.getTagFieldNumber(tag);
        int r2 = WireFormat.getTagWireType(tag);
        if (r2 != 0) goto L5;
        writer.writeInt64(r0, ((Long) object).longValue());
        return;
    L5:
        if (r2 != 1) goto L7;
        writer.writeFixed64(r0, ((Long) object).longValue());
        return;
    L7:
        if (r2 != 2) goto L9;
        writer.writeBytes(r0, (ByteString) object);
        return;
    L9:
        if (r2 == 3) goto L16;
        if (r2 != 5) goto L14;
        writer.writeFixed32(r0, ((Integer) object).intValue());
        return;
    L14:
        throw new RuntimeException(InvalidProtocolBufferException.invalidWireType());
    L16:
        if (writer.fieldOrder() != Writer.FieldOrder.ASCENDING) goto L18;
        writer.writeStartGroup(r0);
        ((UnknownFieldSetLite) object).writeTo(writer);
        writer.writeEndGroup(r0);
        return;
    L18:
        writer.writeEndGroup(r0);
        ((UnknownFieldSetLite) object).writeTo(writer);
        writer.writeStartGroup(r0);
    }

    public int getSerializedSizeAsMessageSet() {
        int r0 = this.memoizedSerializedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= this.count) goto L9;
        r2 = r2 + CodedOutputStream.computeRawMessageSetExtensionSize(WireFormat.getTagFieldNumber(this.tags[r1]), (ByteString) this.objects[r1]);
        r1 = r1 + 1;
        goto L7
    L9:
        this.memoizedSerializedSize = r2;
        return r2;
    }

    public int getSerializedSize() {
        int r0 = this.memoizedSerializedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= this.count) goto L26;
        int r3 = this.tags[r1];
        int r4 = WireFormat.getTagFieldNumber(r3);
        int r5 = WireFormat.getTagWireType(r3);
        if (r5 != 0) goto L11;
        int r6 = CodedOutputStream.computeUInt64Size(r4, ((Long) this.objects[r1]).longValue());
    L25:
        r2 = r2 + r6;
        r1 = r1 + 1;
        goto L7
    L11:
        if (r5 != 1) goto L13;
        r6 = CodedOutputStream.computeFixed64Size(r4, ((Long) this.objects[r1]).longValue());
        goto L25
    L13:
        if (r5 != 2) goto L15;
        r6 = CodedOutputStream.computeBytesSize(r4, (ByteString) this.objects[r1]);
        goto L25
    L15:
        if (r5 != 3) goto L17;
        r6 = (CodedOutputStream.computeTagSize(r4) * 2) + ((UnknownFieldSetLite) this.objects[r1]).getSerializedSize();
        goto L25
    L17:
        if (r5 != 5) goto L20;
        r6 = CodedOutputStream.computeFixed32Size(r4, ((Integer) this.objects[r1]).intValue());
        goto L25
    L20:
        throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
    L26:
        this.memoizedSerializedSize = r2;
        return r2;
    }

    private static boolean tagsEquals(int[] tags1, int[] tags2, int count) {
        int r1 = 0;
    L3:
        if (r1 >= count) goto L8;
        if (tags1[r1] != tags2[r1]) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    private static boolean objectsEquals(Object[] objects1, Object[] objects2, int count) {
        int r1 = 0;
    L3:
        if (r1 >= count) goto L8;
        if (objects1[r1].equals(objects2[r1]) == false) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public boolean equals(Object obj) {
        if (this != obj) goto L6;
        return true;
    L6:
        if (obj != null) goto L9;
        return false;
    L9:
        if ((obj instanceof UnknownFieldSetLite) == true) goto L11;
        return false;
    L11:
        UnknownFieldSetLite r6 = (UnknownFieldSetLite) obj;
        int r2 = this.count;
        if (r2 == r6.count) goto L14;
    L19:
        return false;
    L14:
        if (tagsEquals(this.tags, r6.tags, r2) == false) goto L19;
        if (objectsEquals(this.objects, r6.objects, this.count) == false) goto L19;
        return true;
    }

    private static int hashCode(int[] tags, int count) {
        int r0 = 17;
        int r1 = 0;
    L3:
        if (r1 >= count) goto L5;
        r0 = (r0 * 31) + tags[r1];
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    private static int hashCode(Object[] objects, int count) {
        int r0 = 17;
        int r1 = 0;
    L3:
        if (r1 >= count) goto L5;
        r0 = (r0 * 31) + objects[r1].hashCode();
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    public int hashCode() {
        int r0 = this.count;
        return ((((527 + r0) * 31) + hashCode(this.tags, r0)) * 31) + hashCode(this.objects, this.count);
    }

    final void printWithIndent(StringBuilder buffer, int indent) {
        int r0 = 0;
    L4:
        if (r0 >= this.count) goto L6;
        MessageLiteToString.printField(buffer, indent, String.valueOf(WireFormat.getTagFieldNumber(this.tags[r0])), this.objects[r0]);
        r0 = r0 + 1;
        goto L4
    }

    void storeField(int tag, Object value) {
        checkMutable();
        ensureCapacity(this.count + 1);
        int[] r0 = this.tags;
        int r1 = this.count;
        r0[r1] = tag;
        this.objects[r1] = value;
        this.count = r1 + 1;
    }

    private void ensureCapacity(int minCapacity) {
        int[] r0 = this.tags;
        if (minCapacity <= r0.length) goto L13;
        int r1 = this.count;
        int r2 = r1 + (r1 / 2);
        if (r2 < minCapacity) goto L9;
        minCapacity = r2;
    L9:
        if (minCapacity >= 8) goto L11;
        minCapacity = 8;
    L11:
        this.tags = Arrays.copyOf(r0, minCapacity);
        this.objects = Arrays.copyOf(this.objects, minCapacity);
        return;
    }

    boolean mergeFieldFrom(final int tag, final CodedInputStream input) throws IOException {
        checkMutable();
        int r0 = WireFormat.getTagFieldNumber(tag);
        int r1 = WireFormat.getTagWireType(tag);
        if (r1 == 0) goto L24;
        if (r1 != 1) goto L6;
        storeField(tag, Long.valueOf(input.readFixed64()));
        return true;
    L6:
        if (r1 != 2) goto L8;
        storeField(tag, input.readBytes());
        return true;
    L8:
        if (r1 == 3) goto L18;
        if (r1 != 4) goto L11;
        return false;
    L11:
        if (r1 != 5) goto L15;
        storeField(tag, Integer.valueOf(input.readFixed32()));
        return true;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L18:
        UnknownFieldSetLite r2 = new UnknownFieldSetLite();
        r2.mergeFrom(input);
        input.checkLastTagWas(WireFormat.makeTag(r0, 4));
        storeField(tag, r2);
        return true;
    L24:
        storeField(tag, Long.valueOf(input.readInt64()));
        return true;
    }

    UnknownFieldSetLite mergeVarintField(int fieldNumber, int value) {
        checkMutable();
        if (fieldNumber == 0) goto L7;
        storeField(WireFormat.makeTag(fieldNumber, 0), Long.valueOf(value));
        return this;
    L7:
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    UnknownFieldSetLite mergeLengthDelimitedField(final int fieldNumber, final ByteString value) {
        checkMutable();
        if (fieldNumber == 0) goto L7;
        storeField(WireFormat.makeTag(fieldNumber, 2), value);
        return this;
    L7:
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    private UnknownFieldSetLite mergeFrom(final CodedInputStream input) throws IOException {
    L2:
        int r0 = input.readTag();
        if (r0 == 0) goto L6;
        if (mergeFieldFrom(r0, input) == true) goto L2;
    L6:
        return this;
    }

    UnknownFieldSetLite mergeFrom(UnknownFieldSetLite other) {
        if (other.equals(getDefaultInstance()) == false) goto L5;
        return this;
    L5:
        checkMutable();
        int r0 = this.count + other.count;
        ensureCapacity(r0);
        System.arraycopy(other.tags, 0, this.tags, this.count, other.count);
        System.arraycopy(other.objects, 0, this.objects, this.count, other.count);
        this.count = r0;
        return this;
    }
}
