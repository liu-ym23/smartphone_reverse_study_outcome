package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
@CheckReturnValue
final class MessageSetSchema<T> implements Schema<T> {
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;

    private MessageSetSchema(UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MessageLite defaultInstance) {
        this.unknownFieldSchema = unknownFieldSchema;
        this.hasExtensions = extensionSchema.hasExtensions(defaultInstance);
        this.extensionSchema = extensionSchema;
        this.defaultInstance = defaultInstance;
    }

    static <T> MessageSetSchema<T> newSchema(UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MessageLite defaultInstance) {
        return new MessageSetSchema(unknownFieldSchema, extensionSchema, defaultInstance);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public T newInstance() {
        MessageLite r1 = this.defaultInstance;
        if ((r1 instanceof GeneratedMessageLite) == false) goto L7;
        return (T) ((GeneratedMessageLite) r1).newMutableInstance();
    L7:
        return (T) r1.newBuilderForType().buildPartial();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public boolean equals(T message, T other) {
        if (this.unknownFieldSchema.getFromMessage(message).equals(this.unknownFieldSchema.getFromMessage(other)) == true) goto L7;
        return false;
    L7:
        if (this.hasExtensions == true) goto L9;
        return true;
    L9:
        return this.extensionSchema.getExtensions(message).equals(this.extensionSchema.getExtensions(other));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public int hashCode(T message) {
        int r0 = this.unknownFieldSchema.getFromMessage(message).hashCode();
        if (this.hasExtensions == true) goto L5;
        return r0;
    L5:
        return (r0 * 53) + this.extensionSchema.getExtensions(message).hashCode();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void mergeFrom(T message, T other) {
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, message, other);
        if (this.hasExtensions == false) goto L6;
        SchemaUtil.mergeExtensions(this.extensionSchema, message, other);
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void writeTo(T message, Writer writer) throws IOException {
        Iterator r0 = this.extensionSchema.getExtensions(message).iterator();
    L4:
        if (r0.hasNext() == false) goto L17;
        Map.Entry r1 = (Map.Entry) r0.next();
        FieldSet.FieldDescriptorLite r2 = (FieldSet.FieldDescriptorLite) r1.getKey();
        if (r2.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L16;
        if (r2.isRepeated() == true) goto L16;
        if (r2.isPacked() == true) goto L16;
        if ((r1 instanceof LazyField.LazyEntry) == true) goto L13;
        writer.writeMessageSetItem(r2.getNumber(), r1.getValue());
        goto L4
    L13:
        writer.writeMessageSetItem(r2.getNumber(), ((LazyField.LazyEntry) r1).getField().toByteString());
    L16:
        throw new IllegalStateException("Found invalid MessageSet item.");
    L17:
        writeUnknownFieldsHelper(this.unknownFieldSchema, message, writer);
    }

    private <UT, UB> void writeUnknownFieldsHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema, T message, Writer writer) throws IOException {
        unknownFieldSchema.writeAsMessageSetTo(unknownFieldSchema.getFromMessage(message), writer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void mergeFrom(T message, byte[] data, int position, int limit, ArrayDecoders.Registers registers) throws IOException {
        GeneratedMessageLite r0 = (GeneratedMessageLite) message;
        UnknownFieldSetLite r1 = r0.unknownFields;
        if (r1 != UnknownFieldSetLite.getDefaultInstance()) goto L5;
        r1 = UnknownFieldSetLite.newInstance();
        r0.unknownFields = r1;
    L5:
        FieldSet<GeneratedMessageLite.ExtensionDescriptor> r11 = ((GeneratedMessageLite.ExtendableMessage) message).ensureExtensionsAreMutable();
        GeneratedMessageLite.GeneratedExtension r2 = null;
    L6:
        if (position >= limit) goto L37;
        int r4 = ArrayDecoders.decodeVarint32(data, position, registers);
        int r13 = registers.int1;
        if (r13 != WireFormat.MESSAGE_SET_ITEM_TAG) goto L10;
        int r14 = 0;
        ByteString r3 = null;
    L18:
        if (r4 >= limit) goto L34;
        r4 = ArrayDecoders.decodeVarint32(data, r4, registers);
        int r6 = registers.int1;
        int r7 = WireFormat.getTagFieldNumber(r6);
        int r8 = WireFormat.getTagWireType(r6);
        if (r7 != 2) goto L22;
        if (r8 != 0) goto L31;
        r4 = ArrayDecoders.decodeVarint32(data, r4, registers);
        r14 = registers.int1;
        r2 = (GeneratedMessageLite.GeneratedExtension) this.extensionSchema.findExtensionByNumber(registers.extensionRegistry, this.defaultInstance, r14);
    L31:
        if (r6 == WireFormat.MESSAGE_SET_ITEM_END_TAG) goto L34;
        r4 = ArrayDecoders.skipField(r6, data, r4, limit, registers);
        goto L18
    L22:
        if (r7 != 3) goto L31;
        if (r2 != null) goto L25;
        if (r8 != 2) goto L31;
        r4 = ArrayDecoders.decodeBytes(data, r4, registers);
        r3 = (ByteString) registers.object1;
        goto L18
    L25:
        r4 = ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor(r2.getMessageDefaultInstance().getClass()), data, r4, limit, registers);
        r11.setField(r2.descriptor, registers.object1);
    L34:
        if (r3 == null) goto L36;
        r1.storeField(WireFormat.makeTag(r14, 2), r3);
    L36:
        position = r4;
        goto L6
    L10:
        if (WireFormat.getTagWireType(r13) == 2) goto L11;
        position = ArrayDecoders.skipField(r13, data, r4, limit, registers);
        goto L6
    L11:
        GeneratedMessageLite.GeneratedExtension r9 = (GeneratedMessageLite.GeneratedExtension) this.extensionSchema.findExtensionByNumber(registers.extensionRegistry, this.defaultInstance, WireFormat.getTagFieldNumber(r13));
        if (r9 == null) goto L14;
        position = ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor(r9.getMessageDefaultInstance().getClass()), data, r4, limit, registers);
        r11.setField(r9.descriptor, registers.object1);
    L15:
        r2 = r9;
        goto L6
    L14:
        position = ArrayDecoders.decodeUnknownField(r13, data, r4, limit, r1, registers);
        goto L15
    L37:
        if (position != limit) goto L40;
        return;
    L40:
        throw InvalidProtocolBufferException.parseFailure();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void mergeFrom(T message, Reader reader, ExtensionRegistryLite extensionRegistry) throws IOException {
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, message, reader, extensionRegistry);
    }

    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema, ExtensionSchema<ET> extensionSchema, T message, Reader reader, ExtensionRegistryLite extensionRegistry) throws IOException {
        UB r7 = unknownFieldSchema.getBuilderFromMessage(message);
        FieldSet<ET> r8 = extensionSchema.getMutableExtensions(message);
    L17:
    L14:
        th = move-exception;
        unknownFieldSchema.setBuilderToMessage(message, r7);
        throw th;
    L5:
        if (reader.getFieldNumber() == Integer.MAX_VALUE) goto L6;
        if (parseMessageSetItemOrUnknownField(reader, extensionRegistry, extensionSchema, r8, unknownFieldSchema, r7) == true) goto L17;
        unknownFieldSchema.setBuilderToMessage(message, r7);
        return;
    L6:
        unknownFieldSchema.setBuilderToMessage(message, r7);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void makeImmutable(T message) {
        this.unknownFieldSchema.makeImmutable(message);
        this.extensionSchema.makeImmutable(message);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> boolean parseMessageSetItemOrUnknownField(Reader reader, ExtensionRegistryLite extensionRegistry, ExtensionSchema<ET> extensionSchema, FieldSet<ET> extensions, UnknownFieldSchema<UT, UB> unknownFieldSchema, UB unknownFields) throws IOException {
        int r0 = reader.getTag();
        if (r0 != WireFormat.MESSAGE_SET_ITEM_TAG) goto L5;
        Object r1 = null;
        int r3 = 0;
        ByteString r2 = null;
    L16:
        if (reader.getFieldNumber() == Integer.MAX_VALUE) goto L29;
        int r4 = reader.getTag();
        if (r4 == WireFormat.MESSAGE_SET_TYPE_ID_TAG) goto L20;
        if (r4 == WireFormat.MESSAGE_SET_MESSAGE_TAG) goto L23;
        if (reader.skipField() == true) goto L16;
    L23:
        if (r1 != null) goto L24;
        r2 = reader.readBytes();
        goto L16
    L24:
        extensionSchema.parseLengthPrefixedMessageSetItem(reader, r1, extensionRegistry, extensions);
        goto L16
    L20:
        r3 = reader.readUInt32();
        r1 = extensionSchema.findExtensionByNumber(extensionRegistry, this.defaultInstance, r3);
    L29:
        if (reader.getTag() != WireFormat.MESSAGE_SET_ITEM_END_TAG) goto L36;
        if (r2 == null) goto L34;
        if (r1 == null) goto L33;
        extensionSchema.parseMessageSetItem(r2, r1, extensionRegistry, extensions);
        goto L34
    L33:
        unknownFieldSchema.addLengthDelimited(unknownFields, r3, r2);
    L34:
        return true;
    L36:
        throw InvalidProtocolBufferException.invalidEndTag();
    L5:
        if (WireFormat.getTagWireType(r0) != 2) goto L13;
        Object r6 = extensionSchema.findExtensionByNumber(extensionRegistry, this.defaultInstance, WireFormat.getTagFieldNumber(r0));
        if (r6 == null) goto L11;
        extensionSchema.parseLengthPrefixedMessageSetItem(reader, r6, extensionRegistry, extensions);
        return true;
    L11:
        return unknownFieldSchema.mergeOneFieldFrom(unknownFields, reader);
    L13:
        return reader.skipField();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final boolean isInitialized(T message) {
        return this.extensionSchema.getExtensions(message).isInitialized();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public int getSerializedSize(T message) {
        int r0 = getUnknownFieldsSerializedSize(this.unknownFieldSchema, message) + 0;
        if (this.hasExtensions == true) goto L5;
        return r0;
    L5:
        return r0 + this.extensionSchema.getExtensions(message).getMessageSetSerializedSize();
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> schema, T message) {
        return schema.getSerializedSizeAsMessageSet(schema.getFromMessage(message));
    }
}
