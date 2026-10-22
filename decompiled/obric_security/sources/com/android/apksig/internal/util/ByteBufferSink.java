package com.android.apksig.internal.util;

import com.android.apksig.util.DataSink;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class ByteBufferSink implements DataSink {
    private final ByteBuffer mBuffer;

    public ByteBufferSink(ByteBuffer r1) {
        this.mBuffer = r1;
    }

    @Override // com.android.apksig.util.DataSink
    public void consume(byte[] r2, int r3, int r4) throws IOException {
        this.mBuffer.put(r2, r3, r4);     // Catch: BufferOverflowException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException("Insufficient space in output buffer for " + r4 + " bytes", e);
    }

    public ByteBuffer getBuffer() {
        return this.mBuffer;
    }

    @Override // com.android.apksig.util.DataSink
    public void consume(ByteBuffer r4) throws IOException {
        int r0 = r4.remaining();
        this.mBuffer.put(r4);     // Catch: BufferOverflowException -> L5
        return;
    L5:
        e = move-exception;
        throw new IOException("Insufficient space in output buffer for " + r0 + " bytes", e);
    }
}
