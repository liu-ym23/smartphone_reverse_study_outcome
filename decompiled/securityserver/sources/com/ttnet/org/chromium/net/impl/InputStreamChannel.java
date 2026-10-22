package com.ttnet.org.chromium.net.impl;

import androidx.annotation.NonNull;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
final class InputStreamChannel implements ReadableByteChannel {
    private static final int MAX_TMP_BUFFER_SIZE = 16384;
    private static final int MIN_TMP_BUFFER_SIZE = 4096;
    private final InputStream mInputStream;
    private final AtomicBoolean mIsOpen;

    private InputStreamChannel(@NonNull InputStream r3) {
        this.mIsOpen = new AtomicBoolean(true);
        this.mInputStream = r3;
    }

    public static ReadableByteChannel wrap(@NonNull InputStream r1) {
        if ((r1 instanceof FileInputStream) == false) goto L7;
        return ((FileInputStream) r1).getChannel();
    L7:
        return new InputStreamChannel(r1);
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.mIsOpen.compareAndSet(true, false) == false) goto L6;
        this.mInputStream.close();
        return;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.mIsOpen.get();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer r4) {
        if (r4.hasArray() == false) goto L7;
        InputStream r3 = this.mInputStream;
        byte[] r0 = r4.array();
        int r1 = r4.arrayOffset();
        int r5 = r3.read(r0, r4.position() + r1, r4.remaining());
        if (r5 <= 0) goto L10;
        r4.position(r4.position() + r5);
    L10:
        return r5;
    L7:
        byte[] r2 = new byte[Math.min(16384, Math.min(Math.max(this.mInputStream.available(), 4096), r4.remaining()))];
        r5 = this.mInputStream.read(r2);
        if (r5 <= 0) goto L10;
        r4.put(r2, 0, r5);
        goto L10
    }
}
