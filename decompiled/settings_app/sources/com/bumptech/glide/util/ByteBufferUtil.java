package com.bumptech.glide.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class ByteBufferUtil {
    private static final AtomicReference<byte[]> BUFFER_REF = null;
    private static final int BUFFER_SIZE = 16384;

    private static class ByteBufferStream extends InputStream {
        private static final int UNSET = -1;
        private final ByteBuffer byteBuffer;
        private int markPos;

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        ByteBufferStream(ByteBuffer r2) {
            this.markPos = -1;
            this.byteBuffer = r2;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.byteBuffer.remaining();
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.byteBuffer.hasRemaining() == true) goto L7;
            return -1;
        L7:
            return this.byteBuffer.get() & 255;
        }

        @Override // java.io.InputStream
        public synchronized void mark(int r1) {
            monitor-enter(this);
            this.markPos = this.byteBuffer.position();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // java.io.InputStream
        public int read(byte[] r2, int r3, int r4) {
            if (this.byteBuffer.hasRemaining() == true) goto L6;
            return -1;
        L6:
            int r5 = Math.min(r4, available());
            this.byteBuffer.get(r2, r3, r5);
            return r5;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            monitor-enter(this);
            int r0 = this.markPos;     // Catch: Throwable -> L10
            if (r0 == (-1)) goto L9;
            this.byteBuffer.position(r0);     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L9:
            throw new IOException("Cannot reset to unset mark position");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        @Override // java.io.InputStream
        public long skip(long r3) {
            if (this.byteBuffer.hasRemaining() == true) goto L6;
            return -1;
        L6:
            long r4 = Math.min(r3, available());
            ByteBuffer r2 = this.byteBuffer;
            r2.position((int) (((long) r2.position()) + r4));
            return r4;
        }
    }

    static final class SafeArray {
        final byte[] data;
        final int limit;
        final int offset;

        SafeArray(byte[] r1, int r2, int r3) {
            this.data = r1;
            this.offset = r2;
            this.limit = r3;
        }
    }

    static {
        BUFFER_REF = new AtomicReference();
    }

    private ByteBufferUtil() {
    }

    public static ByteBuffer fromFile(File r8) throws IOException {
        FileChannel r0 = null;
        long r5 = r8.length();     // Catch: Throwable -> L19
        if (r5 > 2147483647L) goto L18;
        if (r5 == 0) goto L16;
        RandomAccessFile r7 = new RandomAccessFile(r8, "r");     // Catch: Throwable -> L19
        r0 = r7.getChannel();     // Catch: Throwable -> L13
        MappedByteBuffer r9 = r0.map(FileChannel.MapMode.READ_ONLY, 0, r5).load();     // Catch: Throwable -> L13
        if (r0 != null) goto L37;
    L35:
        r7.close();     // Catch: IOException -> L27
    L12:
        return r9;
    L37:
        r0.close();     // Catch: IOException -> L26
    L13:
        th = th;
    L21:
        if (r0 != null) goto L39;
    L23:
        if (r7 == null) goto L41;
        r7.close();     // Catch: IOException -> L29
        throw th;
    L42:
        throw th;
    L41:
        throw th;
    L39:
        r0.close();     // Catch: IOException -> L28
        goto L23
    L16:
        throw new IOException("File unsuitable for memory mapping");     // Catch: Throwable -> L19
    L18:
        throw new IOException("File too large to map into memory");     // Catch: Throwable -> L19
    L19:
        th = th;
        r7 = null;
        goto L21
    }

    public static void toFile(ByteBuffer r3, File r4) throws IOException {
        rewind(r3);
        FileChannel r0 = null;
        RandomAccessFile r1 = new RandomAccessFile(r4, "rw");     // Catch: Throwable -> L11
        r0 = r1.getChannel();     // Catch: Throwable -> L9
        r0.write(r3);     // Catch: Throwable -> L9
        r0.force(false);     // Catch: Throwable -> L9
        r0.close();     // Catch: Throwable -> L9
        r1.close();     // Catch: Throwable -> L9
        if (r0 != null) goto L30;
    L26:
        r1.close();     // Catch: IOException -> L19
        return;
    L34:
        return;
    L30:
        r0.close();     // Catch: IOException -> L18
    L9:
        th = th;
    L13:
        if (r0 != null) goto L32;
    L15:
        if (r1 == null) goto L35;
        r1.close();     // Catch: IOException -> L21
        throw th;
    L36:
        throw th;
    L35:
        throw th;
    L32:
        r0.close();     // Catch: IOException -> L20
    L11:
        th = th;
        r1 = null;
        goto L13
    }

    public static void toStream(ByteBuffer r3, OutputStream r4) throws IOException {
        SafeArray r0 = getSafeArray(r3);
        if (r0 == null) goto L5;
        r4.write(r0.data, r0.offset, r0.offset + r0.limit);
        return;
    L5:
        byte[] r1 = BUFFER_REF.getAndSet(null);
        if (r1 != null) goto L9;
        r1 = new byte[16384];
    L9:
        if (r3.remaining() <= 0) goto L11;
        int r2 = Math.min(r3.remaining(), r1.length);
        r3.get(r1, 0, r2);
        r4.write(r1, 0, r2);
        goto L9
    L11:
        BUFFER_REF.set(r1);
    }

    public static byte[] toBytes(ByteBuffer r2) {
        SafeArray r0 = getSafeArray(r2);
        if (r0 != null) goto L5;
    L9:
        ByteBuffer r3 = r2.asReadOnlyBuffer();
        byte[] r1 = new byte[r3.limit()];
        rewind(r3);
        r3.get(r1);
        return r1;
    L5:
        if (r0.offset != 0) goto L9;
        if (r0.limit != r0.data.length) goto L9;
        return r2.array();
    }

    public static InputStream toStream(ByteBuffer r1) {
        return new ByteBufferStream(r1);
    }

    public static ByteBuffer fromStream(InputStream r4) throws IOException {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(16384);
        byte[] r2 = BUFFER_REF.getAndSet(null);
        if (r2 != null) goto L5;
        r2 = new byte[16384];
    L5:
        int r1 = r4.read(r2);
        if (r1 < 0) goto L8;
        r0.write(r2, 0, r1);
        goto L5
    L8:
        BUFFER_REF.set(r2);
        byte[] r5 = r0.toByteArray();
        return rewind(ByteBuffer.allocateDirect(r5.length).put(r5));
    }

    public static ByteBuffer rewind(ByteBuffer r1) {
        return (ByteBuffer) r1.position(0);
    }

    private static SafeArray getSafeArray(ByteBuffer r3) {
        if (r3.isReadOnly() == false) goto L5;
        return null;
    L5:
        if (r3.hasArray() == true) goto L7;
        return null;
    L7:
        return new SafeArray(r3.array(), r3.arrayOffset(), r3.limit());
    }
}
