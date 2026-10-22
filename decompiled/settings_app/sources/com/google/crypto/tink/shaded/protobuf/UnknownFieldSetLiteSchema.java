package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
@CheckReturnValue
class UnknownFieldSetLiteSchema extends UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> {
    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    boolean shouldDiscardUnknownFields(Reader reader) {
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void addFixed32(UnknownFieldSetLite fields, int number, int value) {
        addFixed322(fields, number, value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void addFixed64(UnknownFieldSetLite fields, int number, long value) {
        addFixed642(fields, number, value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void addGroup(UnknownFieldSetLite fields, int number, UnknownFieldSetLite subFieldSet) {
        addGroup2(fields, number, subFieldSet);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void addLengthDelimited(UnknownFieldSetLite fields, int number, ByteString value) {
        addLengthDelimited2(fields, number, value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void addVarint(UnknownFieldSetLite fields, int number, long value) {
        addVarint2(fields, number, value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ UnknownFieldSetLite getBuilderFromMessage(Object message) {
        return getBuilderFromMessage(message);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ UnknownFieldSetLite getFromMessage(Object message) {
        return getFromMessage(message);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ int getSerializedSize(UnknownFieldSetLite unknowns) {
        return getSerializedSize2(unknowns);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ int getSerializedSizeAsMessageSet(UnknownFieldSetLite unknowns) {
        return getSerializedSizeAsMessageSet2(unknowns);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ UnknownFieldSetLite merge(UnknownFieldSetLite target, UnknownFieldSetLite source) {
        return merge2(target, source);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ UnknownFieldSetLite newBuilder() {
        return newBuilder();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void setBuilderToMessage(Object message, UnknownFieldSetLite fields) {
        setBuilderToMessage2(message, fields);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void setToMessage(Object message, UnknownFieldSetLite fields) {
        setToMessage2(message, fields);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ UnknownFieldSetLite toImmutable(UnknownFieldSetLite fields) {
        return toImmutable2(fields);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void writeAsMessageSetTo(UnknownFieldSetLite fields, Writer writer) throws IOException {
        writeAsMessageSetTo2(fields, writer);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void writeTo(UnknownFieldSetLite fields, Writer writer) throws IOException {
        writeTo2(fields, writer);
    }

    UnknownFieldSetLiteSchema() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    UnknownFieldSetLite newBuilder() {
        return UnknownFieldSetLite.newInstance();
    }

    /* JADX INFO: renamed from: addVarint, reason: avoid collision after fix types in other method */
    void addVarint2(UnknownFieldSetLite fields, int number, long value) {
        fields.storeField(WireFormat.makeTag(number, 0), Long.valueOf(value));
    }

    /* JADX INFO: renamed from: addFixed32, reason: avoid collision after fix types in other method */
    void addFixed322(UnknownFieldSetLite fields, int number, int value) {
        fields.storeField(WireFormat.makeTag(number, 5), Integer.valueOf(value));
    }

    /* JADX INFO: renamed from: addFixed64, reason: avoid collision after fix types in other method */
    void addFixed642(UnknownFieldSetLite fields, int number, long value) {
        fields.storeField(WireFormat.makeTag(number, 1), Long.valueOf(value));
    }

    /* JADX INFO: renamed from: addLengthDelimited, reason: avoid collision after fix types in other method */
    void addLengthDelimited2(UnknownFieldSetLite fields, int number, ByteString value) {
        fields.storeField(WireFormat.makeTag(number, 2), value);
    }

    /* JADX INFO: renamed from: addGroup, reason: avoid collision after fix types in other method */
    void addGroup2(UnknownFieldSetLite fields, int number, UnknownFieldSetLite subFieldSet) {
        fields.storeField(WireFormat.makeTag(number, 3), subFieldSet);
    }

    /* JADX INFO: renamed from: toImmutable, reason: avoid collision after fix types in other method */
    UnknownFieldSetLite toImmutable2(UnknownFieldSetLite fields) {
        fields.makeImmutable();
        return fields;
    }

    /* JADX INFO: renamed from: setToMessage, reason: avoid collision after fix types in other method */
    void setToMessage2(Object message, UnknownFieldSetLite fields) {
        ((GeneratedMessageLite) message).unknownFields = fields;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    UnknownFieldSetLite getFromMessage(Object message) {
        return ((GeneratedMessageLite) message).unknownFields;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    UnknownFieldSetLite getBuilderFromMessage(Object message) {
        UnknownFieldSetLite r0 = getFromMessage(message);
        if (r0 != UnknownFieldSetLite.getDefaultInstance()) goto L6;
        UnknownFieldSetLite r1 = UnknownFieldSetLite.newInstance();
        setToMessage2(message, r1);
        return r1;
    L6:
        return r0;
    }

    /* JADX INFO: renamed from: setBuilderToMessage, reason: avoid collision after fix types in other method */
    void setBuilderToMessage2(Object message, UnknownFieldSetLite fields) {
        setToMessage2(message, fields);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    void makeImmutable(Object message) {
        getFromMessage(message).makeImmutable();
    }

    /* JADX INFO: renamed from: writeTo, reason: avoid collision after fix types in other method */
    void writeTo2(UnknownFieldSetLite fields, Writer writer) throws IOException {
        fields.writeTo(writer);
    }

    /* JADX INFO: renamed from: writeAsMessageSetTo, reason: avoid collision after fix types in other method */
    void writeAsMessageSetTo2(UnknownFieldSetLite fields, Writer writer) throws IOException {
        fields.writeAsMessageSetTo(writer);
    }

    /* JADX INFO: renamed from: merge, reason: avoid collision after fix types in other method */
    UnknownFieldSetLite merge2(UnknownFieldSetLite target, UnknownFieldSetLite source) {
        if (UnknownFieldSetLite.getDefaultInstance().equals(source) == false) goto L6;
        return target;
    L6:
        if (UnknownFieldSetLite.getDefaultInstance().equals(target) == false) goto L10;
        return UnknownFieldSetLite.mutableCopyOf(target, source);
    L10:
        return target.mergeFrom(source);
    }

    /* JADX INFO: renamed from: getSerializedSize, reason: avoid collision after fix types in other method */
    int getSerializedSize2(UnknownFieldSetLite unknowns) {
        return unknowns.getSerializedSize();
    }

    /* JADX INFO: renamed from: getSerializedSizeAsMessageSet, reason: avoid collision after fix types in other method */
    int getSerializedSizeAsMessageSet2(UnknownFieldSetLite unknowns) {
        return unknowns.getSerializedSizeAsMessageSet();
    }
}
