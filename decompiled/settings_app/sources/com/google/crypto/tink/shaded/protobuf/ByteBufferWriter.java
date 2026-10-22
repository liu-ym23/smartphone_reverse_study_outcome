package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes4.dex */
final class ByteBufferWriter {
    private static final ThreadLocal<SoftReference<byte[]>> BUFFER = null;
    private static final float BUFFER_REALLOCATION_THRESHOLD = 0.5f;
    private static final long CHANNEL_FIELD_OFFSET = 0;
    private static final Class<?> FILE_OUTPUT_STREAM_CLASS = null;
    private static final int MAX_CACHED_BUFFER_SIZE = 16384;
    private static final int MIN_CACHED_BUFFER_SIZE = 1024;

    private static boolean needToReallocate(int requestedSize, int bufferLength) {
        if (bufferLength < requestedSize) goto L4;
    L6:
        return false;
    L4:
        if (bufferLength >= (requestedSize * 0.5f)) goto L6;
        return true;
    }

    private ByteBufferWriter() {
    }

    static {
        BUFFER = new ThreadLocal();
        Class<?> r0 = safeGetClass("java.io.FileOutputStream");
        FILE_OUTPUT_STREAM_CLASS = r0;
        CHANNEL_FIELD_OFFSET = getChannelFieldOffset(r0);
    }

    static void clearCachedBuffer() {
        BUFFER.set(null);
    }

    static void write(ByteBuffer buffer, OutputStream output) throws IOException {
        int r0 = buffer.position();
    L15:
        th = move-exception;
        Java8Compatibility.position(buffer, r0);
        throw th;
    L4:
        if (buffer.hasArray() == false) goto L7;
        output.write(buffer.array(), buffer.arrayOffset() + buffer.position(), buffer.remaining());     // Catch: Throwable -> L15
    L13:
        Java8Compatibility.position(buffer, r0);
        return;
    L7:
        if (writeToChannel(buffer, output) == true) goto L13;
        byte[] r1 = getOrCreateBuffer(buffer.remaining());     // Catch: Throwable -> L15
    L10:
        if (buffer.hasRemaining() == false) goto L13;
        int r2 = Math.min(buffer.remaining(), r1.length);     // Catch: Throwable -> L15
        buffer.get(r1, 0, r2);     // Catch: Throwable -> L15
        output.write(r1, 0, r2);     // Catch: Throwable -> L15
        goto L10
    }

    private static byte[] getOrCreateBuffer(int requestedSize) {
        int r2 = Math.max(requestedSize, 1024);
        byte[] r0 = getBuffer();
        if (r0 != null) goto L5;
    L6:
        r0 = new byte[r2];
        if (r2 > 16384) goto L9;
        setBuffer(r0);
    L9:
        return r0;
    L5:
        if (needToReallocate(r2, r0.length) == false) goto L9;
        goto L6
    }

    private static byte[] getBuffer() {
        SoftReference<byte[]> r0 = BUFFER.get();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.get();
    }

    private static void setBuffer(byte[] value) {
        BUFFER.set(new SoftReference(value));
    }

    private static boolean writeToChannel(ByteBuffer buffer, OutputStream output) throws IOException {
        long r0 = CHANNEL_FIELD_OFFSET;
        if (r0 >= 0) goto L5;
        return false;
    L5:
        if (FILE_OUTPUT_STREAM_CLASS.isInstance(output) == false) goto L16;
        WritableByteChannel r5 = (WritableByteChannel) UnsafeUtil.getObject(output, r0);     // Catch: ClassCastException -> L8
    L9:
        if (r5 == null) goto L17;
        r5.write(buffer);
        return true;
    L17:
        return false;
    L8:
        r5 = null;
        goto L9
    L16:
        return false;
    }

    private static Class<?> safeGetClass(String className) {
        return Class.forName(className);
    L4:
        return null;
    }

    private static long getChannelFieldOffset(Class<?> clazz) {
        if (clazz != null) goto L10;
        return -1;
    L10:
        if (UnsafeUtil.hasUnsafeArrayOperations() == false) goto L12;
        return UnsafeUtil.objectFieldOffset(clazz.getDeclaredField("channel"));
    L12:
        return -1;
    L13:
        return -1;
    }
}
