package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
@CheckReturnValue
final class ExtensionSchemaLite extends ExtensionSchema<GeneratedMessageLite.ExtensionDescriptor> {

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.ExtensionSchemaLite$1, reason: invalid class name */
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
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L52:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L74:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L29
        L42:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 9;     // Catch: NoSuchFieldError -> L30
        L68:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 10;     // Catch: NoSuchFieldError -> L31
        L70:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 11;     // Catch: NoSuchFieldError -> L32
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

    ExtensionSchemaLite() {
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ExtensionSchema
    boolean hasExtensions(MessageLite prototype) {
        return prototype instanceof GeneratedMessageLite.ExtendableMessage;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ExtensionSchema
    FieldSet<GeneratedMessageLite.ExtensionDescriptor> getExtensions(Object message) {
        return ((GeneratedMessageLite.ExtendableMessage) message).extensions;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ExtensionSchema
    void setExtensions(Object message, FieldSet<GeneratedMessageLite.ExtensionDescriptor> extensions) {
        ((GeneratedMessageLite.ExtendableMessage) message).extensions = extensions;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ExtensionSchema
    FieldSet<GeneratedMessageLite.ExtensionDescriptor> getMutableExtensions(Object message) {
        return ((GeneratedMessageLite.ExtendableMessage) message).ensureExtensionsAreMutable();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ExtensionSchema
    void makeImmutable(Object message) {
        getExtensions(message).makeImmutable();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ExtensionSchema
    <UT, UB> UB parseExtension(Object r7, Reader r8, Object r9, ExtensionRegistryLite r10, FieldSet<GeneratedMessageLite.ExtensionDescriptor> r11, UB r12, UnknownFieldSchema<UT, UB> r13) throws IOException {
        GeneratedMessageLite.GeneratedExtension r14 = (GeneratedMessageLite.GeneratedExtension) r9;
        int r1 = r14.getNumber();
        if (r14.descriptor.isRepeated() == false) goto L26;
        if (r14.descriptor.isPacked() == false) goto L26;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r14.getLiteType().ordinal()]) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L16;
            case 9: goto L15;
            case 10: goto L14;
            case 11: goto L13;
            case 12: goto L12;
            case 13: goto L11;
            case 14: goto L10;
            default: goto L9;
        };
    L10:
        ArrayList r6 = new ArrayList();
        r8.readEnumList(r6);
        r12 = (UB) SchemaUtil.filterUnknownEnumList(r7, r1, r6, r14.descriptor.getEnumType(), r12, r13);
    L24:
        r11.setField(r14.descriptor, r6);
    L84:
        return r12;
    L11:
        r6 = new ArrayList();
        r8.readSInt64List(r6);
        goto L24
    L12:
        r6 = new ArrayList();
        r8.readSInt32List(r6);
        goto L24
    L13:
        r6 = new ArrayList();
        r8.readSFixed64List(r6);
        goto L24
    L14:
        r6 = new ArrayList();
        r8.readSFixed32List(r6);
        goto L24
    L15:
        r6 = new ArrayList();
        r8.readUInt32List(r6);
        goto L24
    L16:
        r6 = new ArrayList();
        r8.readBoolList(r6);
        goto L24
    L17:
        r6 = new ArrayList();
        r8.readFixed32List(r6);
        goto L24
    L18:
        r6 = new ArrayList();
        r8.readFixed64List(r6);
        goto L24
    L19:
        r6 = new ArrayList();
        r8.readInt32List(r6);
        goto L24
    L20:
        r6 = new ArrayList();
        r8.readUInt64List(r6);
        goto L24
    L21:
        r6 = new ArrayList();
        r8.readInt64List(r6);
        goto L24
    L22:
        r6 = new ArrayList();
        r8.readFloatList(r6);
        goto L24
    L23:
        r6 = new ArrayList();
        r8.readDoubleList(r6);
        goto L24
    L9:
        throw new IllegalStateException("Type cannot be packed: " + r14.descriptor.getLiteType());
    L26:
        if (r14.getLiteType() != WireFormat.FieldType.ENUM) goto L33;
        int r15 = r8.readInt32();
        if (r14.descriptor.getEnumType().findValueByNumber(r15) == null) goto L30;
        Object r16 = Integer.valueOf(r15);
    L73:
        if (r14.isRepeated() == false) goto L75;
        r11.addRepeatedField(r14.descriptor, r16);
        goto L84
    L75:
        int r17 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r14.getLiteType().ordinal()];
        if (r17 != 17) goto L78;
    L80:
        Object r18 = r11.getField(r14.descriptor);
        if (r18 == null) goto L83;
        r16 = Internal.mergeMessage(r18, r16);
    L83:
        r11.setField(r14.descriptor, r16);
        goto L84
    L78:
        if (r17 == 18) goto L80;
    L30:
        return (UB) SchemaUtil.storeUnknownEnum(r7, r1, r15, r12, r13);
    L33:
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r14.getLiteType().ordinal()]) {
            case 1: goto L71;
            case 2: goto L70;
            case 3: goto L69;
            case 4: goto L68;
            case 5: goto L67;
            case 6: goto L66;
            case 7: goto L65;
            case 8: goto L64;
            case 9: goto L63;
            case 10: goto L62;
            case 11: goto L61;
            case 12: goto L60;
            case 13: goto L59;
            case 14: goto L58;
            case 15: goto L56;
            case 16: goto L55;
            case 17: goto L46;
            case 18: goto L36;
            default: goto L34;
        };
    L34:
        r16 = null;
        goto L73
    L55:
        r16 = r8.readString();
        goto L73
    L56:
        r16 = r8.readBytes();
        goto L73
    L59:
        r16 = Long.valueOf(r8.readSInt64());
        goto L73
    L60:
        r16 = Integer.valueOf(r8.readSInt32());
        goto L73
    L61:
        r16 = Long.valueOf(r8.readSFixed64());
        goto L73
    L62:
        r16 = Integer.valueOf(r8.readSFixed32());
        goto L73
    L63:
        r16 = Integer.valueOf(r8.readUInt32());
        goto L73
    L64:
        r16 = Boolean.valueOf(r8.readBool());
        goto L73
    L65:
        r16 = Integer.valueOf(r8.readFixed32());
        goto L73
    L66:
        r16 = Long.valueOf(r8.readFixed64());
        goto L73
    L67:
        r16 = Integer.valueOf(r8.readInt32());
        goto L73
    L68:
        r16 = Long.valueOf(r8.readUInt64());
        goto L73
    L69:
        r16 = Long.valueOf(r8.readInt64());
        goto L73
    L70:
        r16 = Float.valueOf(r8.readFloat());
        goto L73
    L71:
        r16 = Double.valueOf(r8.readDouble());
        goto L73
    L36:
        if (r14.isRepeated() == true) goto L44;
        Object r19 = r11.getField(r14.descriptor);
        if ((r19 instanceof GeneratedMessageLite) == false) goto L44;
        Schema r20 = Protobuf.getInstance().schemaFor(r19);
        if (((GeneratedMessageLite) r19).isMutable() == true) goto L42;
        Object r110 = r20.newInstance();
        r20.mergeFrom(r110, r19);
        r11.setField(r14.descriptor, r110);
        r19 = r110;
    L42:
        r8.mergeMessageField(r19, r20, r10);
        return r12;
    L44:
        r16 = r8.readMessage(r14.getMessageDefaultInstance().getClass(), r10);
        goto L73
    L46:
        if (r14.isRepeated() == true) goto L54;
        Object r21 = r11.getField(r14.descriptor);
        if ((r21 instanceof GeneratedMessageLite) == false) goto L54;
        Schema r22 = Protobuf.getInstance().schemaFor(r21);
        if (((GeneratedMessageLite) r21).isMutable() == true) goto L52;
        Object r111 = r22.newInstance();
        r22.mergeFrom(r111, r21);
        r11.setField(r14.descriptor, r111);
        r21 = r111;
    L52:
        r8.mergeGroupField(r21, r22, r10);
        return r12;
    L54:
        r16 = r8.readGroup(r14.getMessageDefaultInstance().getClass(), r10);
        goto L73
    L58:
        throw new IllegalStateException("Shouldn't reach here.");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ExtensionSchema
    int extensionNumber(Map.Entry<?, ?> extension) {
        return ((GeneratedMessageLite.ExtensionDescriptor) extension.getKey()).getNumber();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ExtensionSchema
    void serializeExtension(Writer writer, Map.Entry<?, ?> extension) throws IOException {
        GeneratedMessageLite.ExtensionDescriptor r3 = (GeneratedMessageLite.ExtensionDescriptor) extension.getKey();
        if (r3.isRepeated() == false) goto L34;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r3.getLiteType().ordinal()]) {
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L27;
            case 7: goto L26;
            case 8: goto L25;
            case 9: goto L24;
            case 10: goto L23;
            case 11: goto L22;
            case 12: goto L21;
            case 13: goto L20;
            case 14: goto L19;
            case 15: goto L18;
            case 16: goto L17;
            case 17: goto L12;
            case 18: goto L7;
            default: goto L94;
        };
    L7:
        List r0 = (List) extension.getValue();
        if (r0 != null) goto L10;
        return;
    L10:
        if (r0.isEmpty() == true) goto L56;
        SchemaUtil.writeMessageList(r3.getNumber(), (List) extension.getValue(), writer, Protobuf.getInstance().schemaFor(r0.get(0).getClass()));
        return;
    L56:
        return;
    L12:
        List r1 = (List) extension.getValue();
        if (r1 != null) goto L15;
        return;
    L15:
        if (r1.isEmpty() == true) goto L59;
        SchemaUtil.writeGroupList(r3.getNumber(), (List) extension.getValue(), writer, Protobuf.getInstance().schemaFor(r1.get(0).getClass()));
        return;
    L59:
        return;
    L17:
        SchemaUtil.writeStringList(r3.getNumber(), (List) extension.getValue(), writer);
        return;
    L18:
        SchemaUtil.writeBytesList(r3.getNumber(), (List) extension.getValue(), writer);
        return;
    L19:
        SchemaUtil.writeInt32List(r3.getNumber(), (List) extension.getValue(), writer, r3.isPacked());
        return;
    L20:
        SchemaUtil.writeSInt64List(r3.getNumber(), (List) extension.getValue(), writer, r3.isPacked());
        return;
    L21:
        SchemaUtil.writeSInt32List(r3.getNumber(), (List) extension.getValue(), writer, r3.isPacked());
        return;
    L22:
        SchemaUtil.writeSFixed64List(r3.getNumber(), (List) extension.getValue(), writer, r3.isPacked());
        return;
    L23:
        SchemaUtil.writeSFixed32List(r3.getNumber(), (List) extension.getValue(), writer, r3.isPacked());
        return;
    L24:
        SchemaUtil.writeUInt32List(r3.getNumber(), (List) extension.getValue(), writer, r3.isPacked());
        return;
    L25:
        SchemaUtil.writeBoolList(r3.getNumber(), (List) extension.getValue(), writer, r3.isPacked());
        return;
    L26:
        SchemaUtil.writeFixed32List(r3.getNumber(), (List) extension.getValue(), writer, r3.isPacked());
        return;
    L27:
        SchemaUtil.writeFixed64List(r3.getNumber(), (List) extension.getValue(), writer, r3.isPacked());
        return;
    L28:
        SchemaUtil.writeInt32List(r3.getNumber(), (List) extension.getValue(), writer, r3.isPacked());
        return;
    L29:
        SchemaUtil.writeUInt64List(r3.getNumber(), (List) extension.getValue(), writer, r3.isPacked());
        return;
    L30:
        SchemaUtil.writeInt64List(r3.getNumber(), (List) extension.getValue(), writer, r3.isPacked());
        return;
    L31:
        SchemaUtil.writeFloatList(r3.getNumber(), (List) extension.getValue(), writer, r3.isPacked());
        return;
    L32:
        SchemaUtil.writeDoubleList(r3.getNumber(), (List) extension.getValue(), writer, r3.isPacked());
        return;
    L94:
        return;
    L34:
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r3.getLiteType().ordinal()]) {
            case 1: goto L53;
            case 2: goto L52;
            case 3: goto L51;
            case 4: goto L50;
            case 5: goto L49;
            case 6: goto L48;
            case 7: goto L47;
            case 8: goto L46;
            case 9: goto L45;
            case 10: goto L44;
            case 11: goto L43;
            case 12: goto L42;
            case 13: goto L41;
            case 14: goto L40;
            case 15: goto L39;
            case 16: goto L38;
            case 17: goto L37;
            case 18: goto L36;
            default: goto L95;
        };
    L36:
        writer.writeMessage(r3.getNumber(), extension.getValue(), Protobuf.getInstance().schemaFor(extension.getValue().getClass()));
        return;
    L37:
        writer.writeGroup(r3.getNumber(), extension.getValue(), Protobuf.getInstance().schemaFor(extension.getValue().getClass()));
        return;
    L38:
        writer.writeString(r3.getNumber(), (String) extension.getValue());
        return;
    L39:
        writer.writeBytes(r3.getNumber(), (ByteString) extension.getValue());
        return;
    L40:
        writer.writeInt32(r3.getNumber(), ((Integer) extension.getValue()).intValue());
        return;
    L41:
        writer.writeSInt64(r3.getNumber(), ((Long) extension.getValue()).longValue());
        return;
    L42:
        writer.writeSInt32(r3.getNumber(), ((Integer) extension.getValue()).intValue());
        return;
    L43:
        writer.writeSFixed64(r3.getNumber(), ((Long) extension.getValue()).longValue());
        return;
    L44:
        writer.writeSFixed32(r3.getNumber(), ((Integer) extension.getValue()).intValue());
        return;
    L45:
        writer.writeUInt32(r3.getNumber(), ((Integer) extension.getValue()).intValue());
        return;
    L46:
        writer.writeBool(r3.getNumber(), ((Boolean) extension.getValue()).booleanValue());
        return;
    L47:
        writer.writeFixed32(r3.getNumber(), ((Integer) extension.getValue()).intValue());
        return;
    L48:
        writer.writeFixed64(r3.getNumber(), ((Long) extension.getValue()).longValue());
        return;
    L49:
        writer.writeInt32(r3.getNumber(), ((Integer) extension.getValue()).intValue());
        return;
    L50:
        writer.writeUInt64(r3.getNumber(), ((Long) extension.getValue()).longValue());
        return;
    L51:
        writer.writeInt64(r3.getNumber(), ((Long) extension.getValue()).longValue());
        return;
    L52:
        writer.writeFloat(r3.getNumber(), ((Float) extension.getValue()).floatValue());
        return;
    L53:
        writer.writeDouble(r3.getNumber(), ((Double) extension.getValue()).doubleValue());
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ExtensionSchema
    Object findExtensionByNumber(ExtensionRegistryLite extensionRegistry, MessageLite defaultInstance, int number) {
        return extensionRegistry.findLiteExtensionByNumber(defaultInstance, number);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ExtensionSchema
    void parseLengthPrefixedMessageSetItem(Reader reader, Object extensionObject, ExtensionRegistryLite extensionRegistry, FieldSet<GeneratedMessageLite.ExtensionDescriptor> extensions) throws IOException {
        GeneratedMessageLite.GeneratedExtension r2 = (GeneratedMessageLite.GeneratedExtension) extensionObject;
        Object r0 = reader.readMessage(r2.getMessageDefaultInstance().getClass(), extensionRegistry);
        extensions.setField(r2.descriptor, r0);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ExtensionSchema
    void parseMessageSetItem(ByteString data, Object extensionObject, ExtensionRegistryLite extensionRegistry, FieldSet<GeneratedMessageLite.ExtensionDescriptor> extensions) throws IOException {
        GeneratedMessageLite.GeneratedExtension r2 = (GeneratedMessageLite.GeneratedExtension) extensionObject;
        MessageLite.Builder r0 = r2.getMessageDefaultInstance().newBuilderForType();
        CodedInputStream r1 = data.newCodedInput();
        r0.mergeFrom(r1, extensionRegistry);
        extensions.setField(r2.descriptor, r0.buildPartial());
        r1.checkLastTagWas(0);
    }
}
