package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class NioByteString extends ByteString.LeafByteString {
    private final ByteBuffer buffer;

    static /* synthetic */ ByteBuffer access$000(NioByteString r0) {
        return r0.buffer;
    }

    NioByteString(ByteBuffer buffer) {
        Internal.checkNotNull(buffer, "buffer");
        this.buffer = buffer.slice().order(ByteOrder.nativeOrder());
    }

    private Object writeReplace() {
        return ByteString.copyFrom(this.buffer.slice());
    }

    private void readObject(ObjectInputStream in) throws IOException {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public byte byteAt(int index) {
        return this.buffer.get(index);
    L7:
        e = move-exception;
        throw e;
    L4:
        e = move-exception;
        throw new ArrayIndexOutOfBoundsException(e.getMessage());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public byte internalByteAt(int index) {
        return byteAt(index);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public int size() {
        return this.buffer.remaining();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public ByteString substring(int beginIndex, int endIndex) {
        return new NioByteString(slice(beginIndex, endIndex));
    L7:
        e = move-exception;
        throw e;
    L4:
        e = move-exception;
        throw new ArrayIndexOutOfBoundsException(e.getMessage());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    protected void copyToInternal(byte[] target, int sourceOffset, int targetOffset, int numberToCopy) {
        ByteBuffer r0 = this.buffer.slice();
        Java8Compatibility.position(r0, sourceOffset);
        r0.get(target, targetOffset, numberToCopy);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public void copyTo(ByteBuffer target) {
        target.put(this.buffer.slice());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public void writeTo(OutputStream out) throws IOException {
        out.write(toByteArray());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LeafByteString
    boolean equalsRange(ByteString other, int offset, int length) {
        return substring(0, length).equals(other.substring(offset, length + offset));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    void writeToInternal(OutputStream out, int sourceOffset, int numberToWrite) throws IOException {
        if (this.buffer.hasArray() == false) goto L6;
        int r0 = (this.buffer.arrayOffset() + this.buffer.position()) + sourceOffset;
        out.write(this.buffer.array(), r0, numberToWrite);
        return;
    L6:
        ByteBufferWriter.write(slice(sourceOffset, numberToWrite + sourceOffset), out);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    void writeTo(ByteOutput output) throws IOException {
        output.writeLazy(this.buffer.slice());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return this.buffer.asReadOnlyBuffer();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        return Collections.singletonList(asReadOnlyByteBuffer());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    protected String toStringInternal(Charset charset) {
        if (this.buffer.hasArray() == false) goto L5;
        byte[] r0 = this.buffer.array();
        int r1 = this.buffer.arrayOffset() + this.buffer.position();
        int r3 = this.buffer.remaining();
    L7:
        return new String(r0, r1, r3, charset);
    L5:
        r0 = toByteArray();
        r3 = r0.length;
        r1 = 0;
        goto L7
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public boolean isValidUtf8() {
        return Utf8.isValidUtf8(this.buffer);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    protected int partialIsValidUtf8(int state, int offset, int length) {
        return Utf8.partialIsValidUtf8(state, this.buffer, offset, length + offset);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public boolean equals(Object other) {
        if (other != this) goto L6;
        return true;
    L6:
        if ((other instanceof ByteString) == true) goto L8;
        return false;
    L8:
        ByteString r1 = (ByteString) other;
        if (size() == r1.size()) goto L12;
        return false;
    L12:
        if (size() != 0) goto L15;
        return true;
    L15:
        if ((other instanceof NioByteString) == false) goto L19;
        return this.buffer.equals(((NioByteString) other).buffer);
    L19:
        if ((other instanceof RopeByteString) == false) goto L23;
        return other.equals(this);
    L23:
        return this.buffer.equals(r1.asReadOnlyByteBuffer());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    protected int partialHash(int h, int offset, int length) {
        int r0 = offset;
    L4:
        if (r0 >= (offset + length)) goto L6;
        h = (h * 31) + this.buffer.get(r0);
        r0 = r0 + 1;
        goto L4
    L6:
        return h;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public InputStream newInput() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this.buffer, true);
    }

    private ByteBuffer slice(int beginIndex, int endIndex) {
        if (beginIndex < this.buffer.position()) goto L10;
        if (endIndex > this.buffer.limit()) goto L10;
        if (beginIndex > endIndex) goto L10;
        ByteBuffer r0 = this.buffer.slice();
        Java8Compatibility.position(r0, beginIndex - this.buffer.position());
        Java8Compatibility.limit(r0, endIndex - this.buffer.position());
        return r0;
    L10:
        throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", new Object[]{Integer.valueOf(beginIndex), Integer.valueOf(endIndex)}));
    }
}
