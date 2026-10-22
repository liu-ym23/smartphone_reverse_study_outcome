package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
@CheckReturnValue
final class CodedOutputStreamWriter implements Writer {
    private final CodedOutputStream output;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.CodedOutputStreamWriter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r0 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0;
            r0[WireFormat.FieldType.BOOL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L30:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L36:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L50:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L32:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L38:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L42:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L46:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L28:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L34:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L40:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L44:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 12;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    public static CodedOutputStreamWriter forCodedOutput(CodedOutputStream output) {
        if (output.wrapper == null) goto L7;
        return output.wrapper;
    L7:
        return new CodedOutputStreamWriter(output);
    }

    private CodedOutputStreamWriter(CodedOutputStream output) {
        CodedOutputStream r2 = (CodedOutputStream) Internal.checkNotNull(output, "output");
        this.output = r2;
        r2.wrapper = this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.ASCENDING;
    }

    public int getTotalBytesWritten() {
        return this.output.getTotalBytesWritten();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeSFixed32(int fieldNumber, int value) throws IOException {
        this.output.writeSFixed32(fieldNumber, value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeInt64(int fieldNumber, long value) throws IOException {
        this.output.writeInt64(fieldNumber, value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeSFixed64(int fieldNumber, long value) throws IOException {
        this.output.writeSFixed64(fieldNumber, value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeFloat(int fieldNumber, float value) throws IOException {
        this.output.writeFloat(fieldNumber, value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeDouble(int fieldNumber, double value) throws IOException {
        this.output.writeDouble(fieldNumber, value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeEnum(int fieldNumber, int value) throws IOException {
        this.output.writeEnum(fieldNumber, value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeUInt64(int fieldNumber, long value) throws IOException {
        this.output.writeUInt64(fieldNumber, value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeInt32(int fieldNumber, int value) throws IOException {
        this.output.writeInt32(fieldNumber, value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeFixed64(int fieldNumber, long value) throws IOException {
        this.output.writeFixed64(fieldNumber, value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeFixed32(int fieldNumber, int value) throws IOException {
        this.output.writeFixed32(fieldNumber, value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeBool(int fieldNumber, boolean value) throws IOException {
        this.output.writeBool(fieldNumber, value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeString(int fieldNumber, String value) throws IOException {
        this.output.writeString(fieldNumber, value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeBytes(int fieldNumber, ByteString value) throws IOException {
        this.output.writeBytes(fieldNumber, value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeUInt32(int fieldNumber, int value) throws IOException {
        this.output.writeUInt32(fieldNumber, value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeSInt32(int fieldNumber, int value) throws IOException {
        this.output.writeSInt32(fieldNumber, value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeSInt64(int fieldNumber, long value) throws IOException {
        this.output.writeSInt64(fieldNumber, value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeMessage(int fieldNumber, Object value) throws IOException {
        this.output.writeMessage(fieldNumber, (MessageLite) value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeMessage(int fieldNumber, Object value, Schema schema) throws IOException {
        this.output.writeMessage(fieldNumber, (MessageLite) value, schema);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    @Deprecated
    public void writeGroup(int fieldNumber, Object value) throws IOException {
        this.output.writeGroup(fieldNumber, (MessageLite) value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeGroup(int fieldNumber, Object value, Schema schema) throws IOException {
        this.output.writeGroup(fieldNumber, (MessageLite) value, schema);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    @Deprecated
    public void writeStartGroup(int fieldNumber) throws IOException {
        this.output.writeTag(fieldNumber, 3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    @Deprecated
    public void writeEndGroup(int fieldNumber) throws IOException {
        this.output.writeTag(fieldNumber, 4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeMessageSetItem(int fieldNumber, Object value) throws IOException {
        if ((value instanceof ByteString) == false) goto L5;
        this.output.writeRawMessageSetExtension(fieldNumber, (ByteString) value);
        return;
    L5:
        this.output.writeMessageSetExtension(fieldNumber, (MessageLite) value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeInt32List(int fieldNumber, List<Integer> value, boolean packed) throws IOException {
        int r0 = 0;
        if (packed == false) goto L13;
        this.output.writeTag(fieldNumber, 2);
        int r3 = 0;
        int r5 = 0;
    L6:
        if (r3 >= value.size()) goto L8;
        r5 = r5 + CodedOutputStream.computeInt32SizeNoTag(value.get(r3).intValue());
        r3 = r3 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r5);
    L10:
        if (r0 >= value.size()) goto L15;
        this.output.writeInt32NoTag(value.get(r0).intValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= value.size()) goto L19;
        this.output.writeInt32(fieldNumber, value.get(r0).intValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeFixed32List(int fieldNumber, List<Integer> value, boolean packed) throws IOException {
        int r0 = 0;
        if (packed == false) goto L13;
        this.output.writeTag(fieldNumber, 2);
        int r3 = 0;
        int r5 = 0;
    L6:
        if (r3 >= value.size()) goto L8;
        r5 = r5 + CodedOutputStream.computeFixed32SizeNoTag(value.get(r3).intValue());
        r3 = r3 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r5);
    L10:
        if (r0 >= value.size()) goto L15;
        this.output.writeFixed32NoTag(value.get(r0).intValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= value.size()) goto L19;
        this.output.writeFixed32(fieldNumber, value.get(r0).intValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeInt64List(int fieldNumber, List<Long> value, boolean packed) throws IOException {
        int r0 = 0;
        if (packed == false) goto L13;
        this.output.writeTag(fieldNumber, 2);
        int r4 = 0;
        int r6 = 0;
    L6:
        if (r4 >= value.size()) goto L8;
        r6 = r6 + CodedOutputStream.computeInt64SizeNoTag(value.get(r4).longValue());
        r4 = r4 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r6);
    L10:
        if (r0 >= value.size()) goto L15;
        this.output.writeInt64NoTag(value.get(r0).longValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= value.size()) goto L19;
        this.output.writeInt64(fieldNumber, value.get(r0).longValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeUInt64List(int fieldNumber, List<Long> value, boolean packed) throws IOException {
        int r0 = 0;
        if (packed == false) goto L13;
        this.output.writeTag(fieldNumber, 2);
        int r4 = 0;
        int r6 = 0;
    L6:
        if (r4 >= value.size()) goto L8;
        r6 = r6 + CodedOutputStream.computeUInt64SizeNoTag(value.get(r4).longValue());
        r4 = r4 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r6);
    L10:
        if (r0 >= value.size()) goto L15;
        this.output.writeUInt64NoTag(value.get(r0).longValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= value.size()) goto L19;
        this.output.writeUInt64(fieldNumber, value.get(r0).longValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeFixed64List(int fieldNumber, List<Long> value, boolean packed) throws IOException {
        int r0 = 0;
        if (packed == false) goto L13;
        this.output.writeTag(fieldNumber, 2);
        int r4 = 0;
        int r6 = 0;
    L6:
        if (r4 >= value.size()) goto L8;
        r6 = r6 + CodedOutputStream.computeFixed64SizeNoTag(value.get(r4).longValue());
        r4 = r4 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r6);
    L10:
        if (r0 >= value.size()) goto L15;
        this.output.writeFixed64NoTag(value.get(r0).longValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= value.size()) goto L19;
        this.output.writeFixed64(fieldNumber, value.get(r0).longValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeFloatList(int fieldNumber, List<Float> value, boolean packed) throws IOException {
        int r0 = 0;
        if (packed == false) goto L13;
        this.output.writeTag(fieldNumber, 2);
        int r3 = 0;
        int r5 = 0;
    L6:
        if (r3 >= value.size()) goto L8;
        r5 = r5 + CodedOutputStream.computeFloatSizeNoTag(value.get(r3).floatValue());
        r3 = r3 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r5);
    L10:
        if (r0 >= value.size()) goto L15;
        this.output.writeFloatNoTag(value.get(r0).floatValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= value.size()) goto L19;
        this.output.writeFloat(fieldNumber, value.get(r0).floatValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeDoubleList(int fieldNumber, List<Double> value, boolean packed) throws IOException {
        int r0 = 0;
        if (packed == false) goto L13;
        this.output.writeTag(fieldNumber, 2);
        int r4 = 0;
        int r6 = 0;
    L6:
        if (r4 >= value.size()) goto L8;
        r6 = r6 + CodedOutputStream.computeDoubleSizeNoTag(value.get(r4).doubleValue());
        r4 = r4 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r6);
    L10:
        if (r0 >= value.size()) goto L15;
        this.output.writeDoubleNoTag(value.get(r0).doubleValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= value.size()) goto L19;
        this.output.writeDouble(fieldNumber, value.get(r0).doubleValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeEnumList(int fieldNumber, List<Integer> value, boolean packed) throws IOException {
        int r0 = 0;
        if (packed == false) goto L13;
        this.output.writeTag(fieldNumber, 2);
        int r3 = 0;
        int r5 = 0;
    L6:
        if (r3 >= value.size()) goto L8;
        r5 = r5 + CodedOutputStream.computeEnumSizeNoTag(value.get(r3).intValue());
        r3 = r3 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r5);
    L10:
        if (r0 >= value.size()) goto L15;
        this.output.writeEnumNoTag(value.get(r0).intValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= value.size()) goto L19;
        this.output.writeEnum(fieldNumber, value.get(r0).intValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeBoolList(int fieldNumber, List<Boolean> value, boolean packed) throws IOException {
        int r0 = 0;
        if (packed == false) goto L13;
        this.output.writeTag(fieldNumber, 2);
        int r3 = 0;
        int r5 = 0;
    L6:
        if (r3 >= value.size()) goto L8;
        r5 = r5 + CodedOutputStream.computeBoolSizeNoTag(value.get(r3).booleanValue());
        r3 = r3 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r5);
    L10:
        if (r0 >= value.size()) goto L15;
        this.output.writeBoolNoTag(value.get(r0).booleanValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= value.size()) goto L19;
        this.output.writeBool(fieldNumber, value.get(r0).booleanValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeStringList(int fieldNumber, List<String> value) throws IOException {
        int r1 = 0;
        if ((value instanceof LazyStringList) == false) goto L9;
        LazyStringList r0 = (LazyStringList) value;
    L6:
        if (r1 >= value.size()) goto L11;
        writeLazyString(fieldNumber, r0.getRaw(r1));
        r1 = r1 + 1;
        goto L6
    L11:
        return;
    L9:
        if (r1 >= value.size()) goto L14;
        this.output.writeString(fieldNumber, value.get(r1));
        r1 = r1 + 1;
        goto L9
    }

    private void writeLazyString(int fieldNumber, Object value) throws IOException {
        if ((value instanceof String) == false) goto L5;
        this.output.writeString(fieldNumber, (String) value);
        return;
    L5:
        this.output.writeBytes(fieldNumber, (ByteString) value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeBytesList(int fieldNumber, List<ByteString> value) throws IOException {
        int r0 = 0;
    L4:
        if (r0 >= value.size()) goto L6;
        this.output.writeBytes(fieldNumber, value.get(r0));
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeUInt32List(int fieldNumber, List<Integer> value, boolean packed) throws IOException {
        int r0 = 0;
        if (packed == false) goto L13;
        this.output.writeTag(fieldNumber, 2);
        int r3 = 0;
        int r5 = 0;
    L6:
        if (r3 >= value.size()) goto L8;
        r5 = r5 + CodedOutputStream.computeUInt32SizeNoTag(value.get(r3).intValue());
        r3 = r3 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r5);
    L10:
        if (r0 >= value.size()) goto L15;
        this.output.writeUInt32NoTag(value.get(r0).intValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= value.size()) goto L19;
        this.output.writeUInt32(fieldNumber, value.get(r0).intValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeSFixed32List(int fieldNumber, List<Integer> value, boolean packed) throws IOException {
        int r0 = 0;
        if (packed == false) goto L13;
        this.output.writeTag(fieldNumber, 2);
        int r3 = 0;
        int r5 = 0;
    L6:
        if (r3 >= value.size()) goto L8;
        r5 = r5 + CodedOutputStream.computeSFixed32SizeNoTag(value.get(r3).intValue());
        r3 = r3 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r5);
    L10:
        if (r0 >= value.size()) goto L15;
        this.output.writeSFixed32NoTag(value.get(r0).intValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= value.size()) goto L19;
        this.output.writeSFixed32(fieldNumber, value.get(r0).intValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeSFixed64List(int fieldNumber, List<Long> value, boolean packed) throws IOException {
        int r0 = 0;
        if (packed == false) goto L13;
        this.output.writeTag(fieldNumber, 2);
        int r4 = 0;
        int r6 = 0;
    L6:
        if (r4 >= value.size()) goto L8;
        r6 = r6 + CodedOutputStream.computeSFixed64SizeNoTag(value.get(r4).longValue());
        r4 = r4 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r6);
    L10:
        if (r0 >= value.size()) goto L15;
        this.output.writeSFixed64NoTag(value.get(r0).longValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= value.size()) goto L19;
        this.output.writeSFixed64(fieldNumber, value.get(r0).longValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeSInt32List(int fieldNumber, List<Integer> value, boolean packed) throws IOException {
        int r0 = 0;
        if (packed == false) goto L13;
        this.output.writeTag(fieldNumber, 2);
        int r3 = 0;
        int r5 = 0;
    L6:
        if (r3 >= value.size()) goto L8;
        r5 = r5 + CodedOutputStream.computeSInt32SizeNoTag(value.get(r3).intValue());
        r3 = r3 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r5);
    L10:
        if (r0 >= value.size()) goto L15;
        this.output.writeSInt32NoTag(value.get(r0).intValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= value.size()) goto L19;
        this.output.writeSInt32(fieldNumber, value.get(r0).intValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeSInt64List(int fieldNumber, List<Long> value, boolean packed) throws IOException {
        int r0 = 0;
        if (packed == false) goto L13;
        this.output.writeTag(fieldNumber, 2);
        int r4 = 0;
        int r6 = 0;
    L6:
        if (r4 >= value.size()) goto L8;
        r6 = r6 + CodedOutputStream.computeSInt64SizeNoTag(value.get(r4).longValue());
        r4 = r4 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r6);
    L10:
        if (r0 >= value.size()) goto L15;
        this.output.writeSInt64NoTag(value.get(r0).longValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= value.size()) goto L19;
        this.output.writeSInt64(fieldNumber, value.get(r0).longValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeMessageList(int fieldNumber, List<?> value) throws IOException {
        int r0 = 0;
    L4:
        if (r0 >= value.size()) goto L6;
        writeMessage(fieldNumber, value.get(r0));
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeMessageList(int fieldNumber, List<?> value, Schema schema) throws IOException {
        int r0 = 0;
    L4:
        if (r0 >= value.size()) goto L6;
        writeMessage(fieldNumber, value.get(r0), schema);
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    @Deprecated
    public void writeGroupList(int fieldNumber, List<?> value) throws IOException {
        int r0 = 0;
    L4:
        if (r0 >= value.size()) goto L6;
        writeGroup(fieldNumber, value.get(r0));
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeGroupList(int fieldNumber, List<?> value, Schema schema) throws IOException {
        int r0 = 0;
    L4:
        if (r0 >= value.size()) goto L6;
        writeGroup(fieldNumber, value.get(r0), schema);
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public <K, V> void writeMap(int fieldNumber, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        if (this.output.isSerializationDeterministic() == false) goto L6;
        writeDeterministicMap(fieldNumber, metadata, map);
        return;
    L6:
        Iterator<Map.Entry<K, V>> r7 = map.entrySet().iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        Map.Entry<K, V> r0 = r7.next();
        this.output.writeTag(fieldNumber, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, r0.getKey(), r0.getValue()));
        MapEntryLite.writeTo(this.output, metadata, r0.getKey(), r0.getValue());
        goto L8
    }

    private <K, V> void writeDeterministicMap(int fieldNumber, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[metadata.keyType.ordinal()]) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L7;
            case 9: goto L7;
            case 10: goto L7;
            case 11: goto L7;
            case 12: goto L6;
            default: goto L5;
        };
    L6:
        writeDeterministicStringMap(fieldNumber, metadata, map);
        return;
    L7:
        writeDeterministicLongMap(fieldNumber, metadata, map);
        return;
    L8:
        writeDeterministicIntegerMap(fieldNumber, metadata, map);
        return;
    L9:
        V r0 = map.get(Boolean.FALSE);
        if (r0 == null) goto L12;
        writeDeterministicBooleanMapEntry(fieldNumber, false, r0, metadata);
    L12:
        V r5 = map.get(Boolean.TRUE);
        if (r5 == null) goto L19;
        writeDeterministicBooleanMapEntry(fieldNumber, true, r5, metadata);
        return;
    L19:
        return;
    L5:
        throw new IllegalArgumentException("does not support key type: " + metadata.keyType);
    }

    private <V> void writeDeterministicBooleanMapEntry(int fieldNumber, boolean key, V value, MapEntryLite.Metadata<Boolean, V> metadata) throws IOException {
        this.output.writeTag(fieldNumber, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Boolean.valueOf(key), value));
        MapEntryLite.writeTo(this.output, metadata, Boolean.valueOf(key), value);
    }

    private <V> void writeDeterministicIntegerMap(int fieldNumber, MapEntryLite.Metadata<Integer, V> metadata, Map<Integer, V> map) throws IOException {
        int r0 = map.size();
        int[] r1 = new int[r0];
        Iterator<Integer> r2 = map.keySet().iterator();
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r2.hasNext() == false) goto L6;
        r1[r4] = r2.next().intValue();
        r4 = r4 + 1;
        goto L4
    L6:
        Arrays.sort(r1);
    L7:
        if (r3 >= r0) goto L9;
        int r5 = r1[r3];
        V r6 = map.get(Integer.valueOf(r5));
        this.output.writeTag(fieldNumber, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Integer.valueOf(r5), r6));
        MapEntryLite.writeTo(this.output, metadata, Integer.valueOf(r5), r6);
        r3 = r3 + 1;
        goto L7
    }

    private <V> void writeDeterministicLongMap(int fieldNumber, MapEntryLite.Metadata<Long, V> metadata, Map<Long, V> map) throws IOException {
        int r0 = map.size();
        long[] r1 = new long[r0];
        Iterator<Long> r2 = map.keySet().iterator();
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r2.hasNext() == false) goto L6;
        r1[r4] = r2.next().longValue();
        r4 = r4 + 1;
        goto L4
    L6:
        Arrays.sort(r1);
    L7:
        if (r3 >= r0) goto L9;
        long r5 = r1[r3];
        V r6 = map.get(Long.valueOf(r5));
        this.output.writeTag(fieldNumber, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Long.valueOf(r5), r6));
        MapEntryLite.writeTo(this.output, metadata, Long.valueOf(r5), r6);
        r3 = r3 + 1;
        goto L7
    }

    private <V> void writeDeterministicStringMap(int fieldNumber, MapEntryLite.Metadata<String, V> metadata, Map<String, V> map) throws IOException {
        int r0 = map.size();
        String[] r1 = new String[r0];
        Iterator<String> r2 = map.keySet().iterator();
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r2.hasNext() == false) goto L6;
        r1[r4] = r2.next();
        r4 = r4 + 1;
        goto L4
    L6:
        Arrays.sort(r1);
    L7:
        if (r3 >= r0) goto L9;
        String r5 = r1[r3];
        V r6 = map.get(r5);
        this.output.writeTag(fieldNumber, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, r5, r6));
        MapEntryLite.writeTo(this.output, metadata, r5, r6);
        r3 = r3 + 1;
        goto L7
    }
}
