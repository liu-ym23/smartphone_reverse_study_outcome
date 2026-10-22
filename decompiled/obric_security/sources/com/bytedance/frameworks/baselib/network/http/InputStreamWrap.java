package com.bytedance.frameworks.baselib.network.http;

import com.bytedance.retrofit2.client.SsCall;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class InputStreamWrap extends InputStream {
    private SsCall mRealCall;
    private InputStream mRealIn;

    public InputStreamWrap(InputStream r1, SsCall r2) {
        this.mRealIn = r1;
        this.mRealCall = r2;
    }

    public InputStreamWrap() {
    }

    @Override // java.io.InputStream
    public int read(byte[] r2) throws IOException {
        InputStream r0 = this.mRealIn;
        if (r0 == null) goto L7;
        return r0.read(r2);
    L7:
        return super.read(r2);
    }

    @Override // java.io.InputStream
    public int read(byte[] r2, int r3, int r4) throws IOException {
        InputStream r0 = this.mRealIn;
        if (r0 == null) goto L7;
        return r0.read(r2, r3, r4);
    L7:
        return super.read(r2, r3, r4);
    }

    @Override // java.io.InputStream
    public long skip(long r2) throws IOException {
        InputStream r0 = this.mRealIn;
        if (r0 == null) goto L7;
        return r0.skip(r2);
    L7:
        return super.skip(r2);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InputStream r0 = this.mRealIn;
        if (r0 == null) goto L7;
        return r0.available();
    L7:
        return super.available();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int r2) {
        monitor-enter(this);
        InputStream r0 = this.mRealIn;     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        r0.mark(r2);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        super.mark(r2);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        monitor-enter(this);
        InputStream r0 = this.mRealIn;     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        r0.reset();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        super.reset();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        InputStream r0 = this.mRealIn;
        if (r0 == null) goto L7;
        return r0.markSupported();
    L7:
        return super.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InputStream r0 = this.mRealIn;
        if (r0 != null) goto L5;
        return -1;
    L5:
        return r0.read();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream r0 = this.mRealIn;     // Catch: Throwable -> L9
        if (r0 == null) goto L5;
        r0.close();     // Catch: Throwable -> L9
    L5:
        SsCall r1 = this.mRealCall;     // Catch: Throwable -> L9
        if (r1 == null) goto L11;
        r1.cancel();     // Catch: Throwable -> L9
    L11:
        super.close();
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }
}
