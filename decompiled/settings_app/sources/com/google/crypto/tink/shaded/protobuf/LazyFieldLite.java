package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class LazyFieldLite {
    private static final ExtensionRegistryLite EMPTY_REGISTRY = null;
    private ByteString delayedBytes;
    private ExtensionRegistryLite extensionRegistry;
    private volatile ByteString memoizedBytes;
    protected volatile MessageLite value;

    public int hashCode() {
        return 1;
    }

    static {
        EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();
    }

    public LazyFieldLite(ExtensionRegistryLite extensionRegistry, ByteString bytes) {
        checkArguments(extensionRegistry, bytes);
        this.extensionRegistry = extensionRegistry;
        this.delayedBytes = bytes;
    }

    public LazyFieldLite() {
    }

    public static LazyFieldLite fromValue(MessageLite value) {
        LazyFieldLite r0 = new LazyFieldLite();
        r0.setValue(value);
        return r0;
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if ((o instanceof LazyFieldLite) == true) goto L9;
        return false;
    L9:
        LazyFieldLite r3 = (LazyFieldLite) o;
        MessageLite r0 = this.value;
        MessageLite r1 = r3.value;
        if (r0 != null) goto L14;
        if (r1 != null) goto L14;
        return toByteString().equals(r3.toByteString());
    L14:
        if (r0 == null) goto L18;
        if (r1 == null) goto L18;
        return r0.equals(r1);
    L18:
        if (r0 == null) goto L22;
        return r0.equals(r3.getValue(r0.getDefaultInstanceForType()));
    L22:
        return getValue(r1.getDefaultInstanceForType()).equals(r1);
    }

    public boolean containsDefaultInstance() {
        if (this.memoizedBytes != ByteString.EMPTY) goto L5;
    L12:
        return true;
    L5:
        if (this.value != null) goto L11;
        ByteString r2 = this.delayedBytes;
        if (r2 == null) goto L12;
        if (r2 == ByteString.EMPTY) goto L12;
    L11:
        return false;
    }

    public void clear() {
        this.delayedBytes = null;
        this.value = null;
        this.memoizedBytes = null;
    }

    public void set(LazyFieldLite other) {
        this.delayedBytes = other.delayedBytes;
        this.value = other.value;
        this.memoizedBytes = other.memoizedBytes;
        ExtensionRegistryLite r2 = other.extensionRegistry;
        if (r2 == null) goto L6;
        this.extensionRegistry = r2;
        return;
    }

    public MessageLite getValue(MessageLite defaultInstance) {
        ensureInitialized(defaultInstance);
        return this.value;
    }

    public MessageLite setValue(MessageLite value) {
        MessageLite r0 = this.value;
        this.delayedBytes = null;
        this.memoizedBytes = null;
        this.value = value;
        return r0;
    }

    public void merge(LazyFieldLite other) {
        if (other.containsDefaultInstance() == false) goto L6;
        return;
    L6:
        if (containsDefaultInstance() == false) goto L10;
        set(other);
        return;
    L10:
        if (this.extensionRegistry != null) goto L12;
        this.extensionRegistry = other.extensionRegistry;
    L12:
        ByteString r0 = this.delayedBytes;
        if (r0 == null) goto L19;
        ByteString r1 = other.delayedBytes;
        if (r1 == null) goto L19;
        this.delayedBytes = r0.concat(r1);
        return;
    L19:
        if (this.value != null) goto L25;
        if (other.value == null) goto L25;
        setValue(mergeValueAndBytes(other.value, this.delayedBytes, this.extensionRegistry));
        return;
    L25:
        if (this.value != null) goto L27;
    L30:
        setValue(this.value.toBuilder().mergeFrom(other.value).build());
        return;
    L27:
        if (other.value != null) goto L30;
        setValue(mergeValueAndBytes(this.value, other.delayedBytes, other.extensionRegistry));
    }

    public void mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        if (containsDefaultInstance() == false) goto L7;
        setByteString(input.readBytes(), extensionRegistry);
        return;
    L7:
        if (this.extensionRegistry != null) goto L9;
        this.extensionRegistry = extensionRegistry;
    L9:
        ByteString r0 = this.delayedBytes;
        if (r0 == null) goto L16;
        setByteString(r0.concat(input.readBytes()), this.extensionRegistry);
        return;
    L16:
        setValue(this.value.toBuilder().mergeFrom(input, extensionRegistry).build());     // Catch: InvalidProtocolBufferException -> L15
        return;
    }

    private static MessageLite mergeValueAndBytes(MessageLite value, ByteString otherBytes, ExtensionRegistryLite extensionRegistry) {
        return value.toBuilder().mergeFrom(otherBytes, extensionRegistry).build();
    L7:
        return value;
    }

    public void setByteString(ByteString bytes, ExtensionRegistryLite extensionRegistry) {
        checkArguments(extensionRegistry, bytes);
        this.delayedBytes = bytes;
        this.extensionRegistry = extensionRegistry;
        this.value = null;
        this.memoizedBytes = null;
    }

    public int getSerializedSize() {
        if (this.memoizedBytes != null) goto L5;
        ByteString r0 = this.delayedBytes;
        if (r0 == null) goto L11;
        return r0.size();
    L11:
        if (this.value != null) goto L13;
        return 0;
    L13:
        return this.value.getSerializedSize();
    L5:
        return this.memoizedBytes.size();
    }

    public ByteString toByteString() {
        if (this.memoizedBytes != null) goto L5;
        ByteString r0 = this.delayedBytes;
        if (r0 == null) goto L9;
        return r0;
    L9:
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L11:
        if (this.memoizedBytes == null) goto L16;
        ByteString r1 = this.memoizedBytes;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return r1;
    L16:
        if (this.value != null) goto L18;
        this.memoizedBytes = ByteString.EMPTY;     // Catch: Throwable -> L22
    L19:
        ByteString r2 = this.memoizedBytes;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return r2;
    L18:
        this.memoizedBytes = this.value.toByteString();     // Catch: Throwable -> L22
        goto L19
    L5:
        return this.memoizedBytes;
    }

    void writeTo(Writer writer, int fieldNumber) throws IOException {
        if (this.memoizedBytes == null) goto L5;
        writer.writeBytes(fieldNumber, this.memoizedBytes);
        return;
    L5:
        ByteString r0 = this.delayedBytes;
        if (r0 == null) goto L9;
        writer.writeBytes(fieldNumber, r0);
        return;
    L9:
        if (this.value == null) goto L11;
        writer.writeMessage(fieldNumber, this.value);
        return;
    L11:
        writer.writeBytes(fieldNumber, ByteString.EMPTY);
    }

    protected void ensureInitialized(MessageLite defaultInstance) {
        if (this.value == null) goto L5;
        return;
    L5:
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (this.value == null) goto L22;
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L22:
    L15:
        this.value = defaultInstance;     // Catch: Throwable -> L18
        this.memoizedBytes = ByteString.EMPTY;     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L11:
        if (this.delayedBytes == null) goto L13;
        this.value = defaultInstance.getParserForType().parseFrom(this.delayedBytes, this.extensionRegistry);     // Catch: InvalidProtocolBufferException -> L15 Throwable -> L18
        this.memoizedBytes = this.delayedBytes;     // Catch: InvalidProtocolBufferException -> L15 Throwable -> L18
    L21:
    L13:
        this.value = defaultInstance;     // Catch: InvalidProtocolBufferException -> L15 Throwable -> L18
        this.memoizedBytes = ByteString.EMPTY;     // Catch: InvalidProtocolBufferException -> L15 Throwable -> L18
        goto L21
    }

    private static void checkArguments(ExtensionRegistryLite extensionRegistry, ByteString bytes) {
        if (extensionRegistry == null) goto L8;
        if (bytes == null) goto L6;
        return;
    L6:
        throw new NullPointerException("found null ByteString");
    L8:
        throw new NullPointerException("found null ExtensionRegistry");
    }
}
