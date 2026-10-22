package com.android.apksig.internal.util;

import com.android.apksig.util.DataSink;
import com.android.apksig.util.DataSource;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes.dex */
public class FileChannelDataSource implements DataSource {
    private static final int MAX_READ_CHUNK_SIZE = 1048576;
    private final FileChannel mChannel;
    private final long mOffset;
    private final long mSize;

    public FileChannelDataSource(FileChannel r3) {
        this.mChannel = r3;
        this.mOffset = 0;
        this.mSize = -1;
    }

    private static void checkChunkValid(long r7, long r9, long r11) {
        if (r7 < 0) goto L22;
        if (r9 < 0) goto L20;
        if (r7 > r11) goto L18;
        long r4 = r7 + r9;
        if (r4 < r7) goto L16;
        if (r4 > r11) goto L14;
        return;
    L14:
        throw new IndexOutOfBoundsException("offset (" + r7 + ") + size (" + r9 + ") > source size (" + r11 + ")");
    L16:
        throw new IndexOutOfBoundsException("offset (" + r7 + ") + size (" + r9 + ") overflow");
    L18:
        throw new IndexOutOfBoundsException("offset (" + r7 + ") > source size (" + r11 + ")");
    L20:
        throw new IndexOutOfBoundsException("size: " + r9);
    L22:
        throw new IndexOutOfBoundsException("offset: " + r7);
    }

    @Override // com.android.apksig.util.DataSource
    public void copyTo(long r7, int r9, ByteBuffer r10) throws IOException {
        checkChunkValid(r7, r9, size());
        if (r9 != 0) goto L6;
        return;
    L6:
        if (r9 > r10.remaining()) goto L24;
        long r0 = this.mOffset + r7;
        int r8 = r10.limit();
        r10.limit(r10.position() + r9);     // Catch: Throwable -> L20
    L9:
        if (r9 <= 0) goto L18;
        FileChannel r11 = this.mChannel;     // Catch: Throwable -> L20
        monitor-enter(r11);     // Catch: Throwable -> L20
        this.mChannel.position(r0);     // Catch: Throwable -> L15
        int r2 = this.mChannel.read(r10);     // Catch: Throwable -> L15
        monitor-exit(r11);     // Catch: Throwable -> L15
        r0 = r0 + ((long) r2);     // Catch: Throwable -> L15
        r9 = r9 - r2;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L18:
        r10.limit(r8);
        return;
    L20:
        th = move-exception;
        r10.limit(r8);
        throw th;
    L24:
        throw new BufferOverflowException();
    }

    @Override // com.android.apksig.util.DataSource
    public void feed(long r8, long r10, DataSink r12) throws IOException {
        checkChunkValid(r8, r10, size());
        if (r10 != 0) goto L5;
        return;
    L5:
        long r2 = this.mOffset + r8;
        ByteBuffer r9 = ByteBuffer.allocateDirect((int) Math.min(r10, 1048576));
    L7:
        if (r10 <= 0) goto L22;
        int r11 = (int) Math.min(r10, r9.capacity());
        r9.limit(r11);
        FileChannel r4 = this.mChannel;
        monitor-enter(r4);
        this.mChannel.position(r2);     // Catch: Throwable -> L19
        int r5 = r11;
    L11:
        if (r5 <= 0) goto L17;
        int r6 = this.mChannel.read(r9);     // Catch: Throwable -> L19
        if (r6 < 0) goto L16;
        r5 = r5 - r6;     // Catch: Throwable -> L19
        goto L11
    L16:
        throw new IOException("Unexpected EOF encountered");     // Catch: Throwable -> L19
    L17:
        monitor-exit(r4);     // Catch: Throwable -> L19
        r9.flip();
        r12.consume(r9);
        r9.clear();
        long r7 = r11;
        r2 = r2 + r7;
        r10 = r10 - r7;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // com.android.apksig.util.DataSource
    public ByteBuffer getByteBuffer(long r2, int r4) throws IOException {
        if (r4 < 0) goto L6;
        ByteBuffer r0 = ByteBuffer.allocate(r4);
        copyTo(r2, r4, r0);
        r0.flip();
        return r0;
    L6:
        throw new IndexOutOfBoundsException("size: " + r4);
    }

    @Override // com.android.apksig.util.DataSource
    public long size() {
        long r0 = this.mSize;
        if (r0 != (-1)) goto L10;
        return this.mChannel.size();
    L6:
        return 0;
    L10:
        return r0;
    }

    @Override // com.android.apksig.util.DataSource
    public /* bridge */ /* synthetic */ DataSource slice(long r1, long r3) {
        return slice(r1, r3);
    }

    @Override // com.android.apksig.util.DataSource
    public FileChannelDataSource slice(long r9, long r11) {
        long r6 = size();
        checkChunkValid(r9, r11, r6);
        if (r9 != 0) goto L8;
        if (r11 != r6) goto L8;
        return this;
    L8:
        return new FileChannelDataSource(this.mChannel, this.mOffset + r9, r11);
    }

    public FileChannelDataSource(FileChannel r4, long r5, long r7) {
        if (r5 < 0) goto L11;
        if (r7 < 0) goto L9;
        this.mChannel = r4;
        this.mOffset = r5;
        this.mSize = r7;
        return;
    L9:
        throw new IndexOutOfBoundsException("size: " + r7);
    L11:
        throw new IndexOutOfBoundsException("offset: " + r7);
    }
}
