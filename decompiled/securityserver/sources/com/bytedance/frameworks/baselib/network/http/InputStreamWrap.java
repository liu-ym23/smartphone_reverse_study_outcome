package com.bytedance.frameworks.baselib.network.http;

import com.bytedance.retrofit2.client.SsCall;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class InputStreamWrap extends InputStream {
    private SsCall mRealCall;
    private InputStream mRealIn;

    public InputStreamWrap(InputStream r1, SsCall r2) {
        this.mRealIn = r1;
        this.mRealCall = r2;
    }

    @Override // java.io.InputStream
    public int available() {
        InputStream r0 = this.mRealIn;
        if (r0 == null) goto L7;
        return r0.available();
    L7:
        return super.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InputStream r0 = this.mRealIn;     // Catch: Throwable -> L5
        if (r0 == null) goto L7;
        r0.close();     // Catch: Throwable -> L5
    L7:
        SsCall r1 = this.mRealCall;     // Catch: Throwable -> L5
        if (r1 == null) goto L12;
        r1.cancel();     // Catch: Throwable -> L5
    L12:
        super.close();
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L12
    }

    @Override // java.io.InputStream
    public synchronized void mark(int r2) {
        monitor-enter(this);
        InputStream r0 = this.mRealIn;     // Catch: Throwable -> L6
        if (r0 == null) goto L8;
        r0.mark(r2);     // Catch: Throwable -> L6
    L9:
        monitor-exit(this);
        return;
    L8:
        super.mark(r2);     // Catch: Throwable -> L6
    L6:
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
    public int read(byte[] r2) {
        InputStream r0 = this.mRealIn;
        if (r0 == null) goto L7;
        return r0.read(r2);
    L7:
        return super.read(r2);
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        monitor-enter(this);
        InputStream r0 = this.mRealIn;     // Catch: Throwable -> L6
        if (r0 == null) goto L8;
        r0.reset();     // Catch: Throwable -> L6
    L9:
        monitor-exit(this);
        return;
    L8:
        super.reset();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public long skip(long r2) {
        InputStream r0 = this.mRealIn;
        if (r0 == null) goto L7;
        return r0.skip(r2);
    L7:
        return super.skip(r2);
    }

    public InputStreamWrap() {
    }

    @Override // java.io.InputStream
    public int read(byte[] r2, int r3, int r4) {
        InputStream r0 = this.mRealIn;
        if (r0 == null) goto L7;
        return r0.read(r2, r3, r4);
    L7:
        return super.read(r2, r3, r4);
    }

    @Override // java.io.InputStream
    public int read() {
        InputStream r0 = this.mRealIn;
        if (r0 != null) goto L5;
        return -1;
    L5:
        return r0.read();
    }
}
