package com.android.apksig.internal.util;

import com.android.apksig.util.DataSink;
import com.android.apksig.util.DataSource;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class ByteBufferDataSource implements DataSource {
    private final ByteBuffer mBuffer;
    private final int mSize;

    public ByteBufferDataSource(ByteBuffer r2) {
        this(r2, true);
    }

    private void checkChunkValid(long r10, long r12) {
        if (r10 < 0) goto L22;
        if (r12 < 0) goto L20;
        long r0 = this.mSize;
        if (r10 > r0) goto L18;
        long r6 = r10 + r12;
        if (r6 < r10) goto L16;
        if (r6 > r0) goto L14;
        return;
    L14:
        throw new IndexOutOfBoundsException("offset (" + r10 + ") + size (" + r12 + ") > source size (" + this.mSize + ")");
    L16:
        throw new IndexOutOfBoundsException("offset (" + r10 + ") + size (" + r12 + ") overflow");
    L18:
        throw new IndexOutOfBoundsException("offset (" + r10 + ") > source size (" + this.mSize + ")");
    L20:
        throw new IndexOutOfBoundsException("size: " + r12);
    L22:
        throw new IndexOutOfBoundsException("offset: " + r10);
    }

    @Override // com.android.apksig.util.DataSource
    public void copyTo(long r1, int r3, ByteBuffer r4) {
        r4.put(getByteBuffer(r1, r3));
    }

    @Override // com.android.apksig.util.DataSource
    public void feed(long r3, long r5, DataSink r7) throws IOException {
        if (r5 < 0) goto L9;
        if (r5 > this.mSize) goto L9;
        r7.consume(getByteBuffer(r3, (int) r5));
        return;
    L9:
        throw new IndexOutOfBoundsException("size: " + r5 + ", source size: " + this.mSize);
    }

    @Override // com.android.apksig.util.DataSource
    public ByteBuffer getByteBuffer(long r3, int r5) {
        checkChunkValid(r3, r5);
        int r4 = (int) r3;
        int r6 = r5 + r4;
        ByteBuffer r7 = this.mBuffer;
        monitor-enter(r7);
        this.mBuffer.position(0);     // Catch: Throwable -> L7
        this.mBuffer.limit(r6);     // Catch: Throwable -> L7
        this.mBuffer.position(r4);     // Catch: Throwable -> L7
        ByteBuffer r2 = this.mBuffer.slice();     // Catch: Throwable -> L7
        monitor-exit(r7);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.apksig.util.DataSource
    public long size() {
        return this.mSize;
    }

    @Override // com.android.apksig.util.DataSource
    public /* bridge */ /* synthetic */ DataSource slice(long r1, long r3) {
        return slice(r1, r3);
    }

    private ByteBufferDataSource(ByteBuffer r1, boolean r2) {
        if (r2 == false) goto L5;
        ByteBuffer r3 = r1.slice();
    L6:
        this.mBuffer = r3;
        this.mSize = r1.remaining();
        return;
    L5:
        r3 = r1;
        goto L6
    }

    @Override // com.android.apksig.util.DataSource
    public ByteBufferDataSource slice(long r5, long r7) {
        if (r5 != 0) goto L8;
        if (r7 != this.mSize) goto L8;
        return this;
    L8:
        if (r7 < 0) goto L14;
        if (r7 > this.mSize) goto L14;
        return new ByteBufferDataSource(getByteBuffer(r5, (int) r7), false);
    L14:
        throw new IndexOutOfBoundsException("size: " + r7 + ", source size: " + this.mSize);
    }
}
