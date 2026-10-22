package s9;

import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f21877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bi.f f21878b;

    public c(InputStream r5, bi.f r10) {
        this.f21877a = r5;
        this.f21878b = r10;
    }

    @Override // java.io.InputStream
    public final int available() {
        InputStream r5 = this.f21877a;
        if (r5 == null) goto L7;
        return r5.available();
    L7:
        return super.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        InputStream r5 = this.f21877a;     // Catch: Throwable -> L5
        if (r5 == null) goto L7;
        r5.close();     // Catch: Throwable -> L5
    L7:
        bi.f r10 = this.f21878b;     // Catch: Throwable -> L5
        if (r10 == null) goto L12;
        r10.cancel();     // Catch: Throwable -> L5
    L12:
        super.close();
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L12
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int r5) {
        monitor-enter(this);
        InputStream r10 = this.f21877a;     // Catch: Throwable -> L6
        if (r10 == null) goto L8;
        r10.mark(r5);     // Catch: Throwable -> L6
    L9:
        monitor-exit(this);
        return;
    L8:
        super.mark(r5);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        InputStream r5 = this.f21877a;
        if (r5 == null) goto L7;
        return r5.markSupported();
    L7:
        return super.markSupported();
    }

    @Override // java.io.InputStream
    public final int read(byte[] r5) {
        InputStream r10 = this.f21877a;
        if (r10 == null) goto L7;
        return r10.read(r5);
    L7:
        return super.read(r5);
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        monitor-enter(this);
        InputStream r5 = this.f21877a;     // Catch: Throwable -> L6
        if (r5 == null) goto L8;
        r5.reset();     // Catch: Throwable -> L6
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
    public final long skip(long r5) {
        InputStream r10 = this.f21877a;
        if (r10 == null) goto L7;
        return r10.skip(r5);
    L7:
        return super.skip(r5);
    }

    @Override // java.io.InputStream
    public final int read(byte[] r5, int r10, int r11) {
        InputStream r12 = this.f21877a;
        if (r12 == null) goto L7;
        return r12.read(r5, r10, r11);
    L7:
        return super.read(r5, r10, r11);
    }

    @Override // java.io.InputStream
    public final int read() {
        InputStream r5 = this.f21877a;
        if (r5 != null) goto L5;
        return -1;
    L5:
        return r5.read();
    }
}
