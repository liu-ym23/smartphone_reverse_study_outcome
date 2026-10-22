package com.ttnet.org.chromium.net;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public abstract class UploadDataProvider implements Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    public abstract long getLength() throws IOException;

    public abstract void read(UploadDataSink r1, ByteBuffer r2) throws IOException;

    public abstract void rewind(UploadDataSink r1) throws IOException;

    public UploadDataProvider() {
    }
}
