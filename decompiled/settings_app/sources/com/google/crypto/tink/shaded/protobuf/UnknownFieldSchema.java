package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
@CheckReturnValue
abstract class UnknownFieldSchema<T, B> {
    abstract void addFixed32(B fields, int number, int value);

    abstract void addFixed64(B fields, int number, long value);

    abstract void addGroup(B fields, int number, T subFieldSet);

    abstract void addLengthDelimited(B fields, int number, ByteString value);

    abstract void addVarint(B fields, int number, long value);

    abstract B getBuilderFromMessage(Object message);

    abstract T getFromMessage(Object message);

    abstract int getSerializedSize(T unknowns);

    abstract int getSerializedSizeAsMessageSet(T message);

    abstract void makeImmutable(Object message);

    abstract T merge(T destination, T source);

    abstract B newBuilder();

    abstract void setBuilderToMessage(Object message, B builder);

    abstract void setToMessage(Object message, T fields);

    abstract boolean shouldDiscardUnknownFields(Reader reader);

    abstract T toImmutable(B fields);

    abstract void writeAsMessageSetTo(T unknownFields, Writer writer) throws IOException;

    abstract void writeTo(T unknownFields, Writer writer) throws IOException;

    UnknownFieldSchema() {
    }

    final boolean mergeOneFieldFrom(B unknownFields, Reader reader) throws IOException {
        int r0 = reader.getTag();
        int r1 = WireFormat.getTagFieldNumber(r0);
        int r2 = WireFormat.getTagWireType(r0);
        if (r2 == 0) goto L28;
        if (r2 != 1) goto L6;
        addFixed64(unknownFields, r1, reader.readFixed64());
        return true;
    L6:
        if (r2 != 2) goto L8;
        addLengthDelimited(unknownFields, r1, reader.readBytes());
        return true;
    L8:
        if (r2 == 3) goto L18;
        if (r2 != 4) goto L11;
        return false;
    L11:
        if (r2 != 5) goto L15;
        addFixed32(unknownFields, r1, reader.readFixed32());
        return true;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L18:
        B r3 = newBuilder();
        int r4 = WireFormat.makeTag(r1, 4);
        mergeFrom(r3, reader);
        if (r4 != reader.getTag()) goto L23;
        addGroup(unknownFields, r1, toImmutable(r3));
        return true;
    L23:
        throw InvalidProtocolBufferException.invalidEndTag();
    L28:
        addVarint(unknownFields, r1, reader.readInt64());
        return true;
    }

    final void mergeFrom(B unknownFields, Reader reader) throws IOException {
    L3:
        if (reader.getFieldNumber() == Integer.MAX_VALUE) goto L6;
        if (mergeOneFieldFrom(unknownFields, reader) == true) goto L3;
        return;
    }
}
