package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
class IterableByteBufferInputStream extends InputStream {
    private long currentAddress;
    private byte[] currentArray;
    private int currentArrayOffset;
    private ByteBuffer currentByteBuffer;
    private int currentByteBufferPos;
    private int currentIndex;
    private int dataSize;
    private boolean hasArray;
    private Iterator<ByteBuffer> iterator;

    IterableByteBufferInputStream(Iterable<ByteBuffer> data) {
        this.iterator = data.iterator();
        this.dataSize = 0;
        Iterator<ByteBuffer> r3 = data.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ByteBuffer r1 = r3.next();
        this.dataSize++;
        goto L4
    L6:
        this.currentIndex = -1;
        if (getNextByteBuffer() == true) goto L11;
        this.currentByteBuffer = Internal.EMPTY_BYTE_BUFFER;
        this.currentIndex = 0;
        this.currentByteBufferPos = 0;
        this.currentAddress = 0;
        return;
    }

    private boolean getNextByteBuffer() {
        this.currentIndex++;
        if (this.iterator.hasNext() == true) goto L5;
        return false;
    L5:
        ByteBuffer r0 = this.iterator.next();
        this.currentByteBuffer = r0;
        this.currentByteBufferPos = r0.position();
        if (this.currentByteBuffer.hasArray() == false) goto L8;
        this.hasArray = true;
        this.currentArray = this.currentByteBuffer.array();
        this.currentArrayOffset = this.currentByteBuffer.arrayOffset();
    L9:
        return true;
    L8:
        this.hasArray = false;
        this.currentAddress = UnsafeUtil.addressOffset(this.currentByteBuffer);
        this.currentArray = null;
        goto L9
    }

    private void updateCurrentByteBufferPos(int numberOfBytesRead) {
        int r0 = this.currentByteBufferPos + numberOfBytesRead;
        this.currentByteBufferPos = r0;
        if (r0 != this.currentByteBuffer.limit()) goto L6;
        getNextByteBuffer();
        return;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.currentIndex != this.dataSize) goto L7;
        return -1;
    L7:
        if (this.hasArray == false) goto L10;
        int r0 = this.currentArray[this.currentByteBufferPos + this.currentArrayOffset] & 255;
        updateCurrentByteBufferPos(1);
        return r0;
    L10:
        int r1 = UnsafeUtil.getByte(((long) this.currentByteBufferPos) + this.currentAddress) & 255;
        updateCurrentByteBufferPos(1);
        return r1;
    }

    @Override // java.io.InputStream
    public int read(byte[] output, int offset, int length) throws IOException {
        if (this.currentIndex != this.dataSize) goto L6;
        return -1;
    L6:
        int r0 = this.currentByteBuffer.limit();
        int r1 = this.currentByteBufferPos;
        int r2 = r0 - r1;
        if (length <= r2) goto L10;
        length = r2;
    L10:
        if (this.hasArray == false) goto L12;
        System.arraycopy(this.currentArray, r1 + this.currentArrayOffset, output, offset, length);
        updateCurrentByteBufferPos(length);
    L13:
        return length;
    L12:
        int r3 = this.currentByteBuffer.position();
        Java8Compatibility.position(this.currentByteBuffer, this.currentByteBufferPos);
        this.currentByteBuffer.get(output, offset, length);
        Java8Compatibility.position(this.currentByteBuffer, r3);
        updateCurrentByteBufferPos(length);
        goto L13
    }
}
