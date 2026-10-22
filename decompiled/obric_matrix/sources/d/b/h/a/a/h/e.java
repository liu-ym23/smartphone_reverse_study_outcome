package d.b.h.a.a.h;

import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class e extends InputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private InputStream f13382f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d.b.r.h0.e f13383g;

    public e(InputStream r1, d.b.r.h0.e r2) {
        this.f13382f = r1;
        this.f13383g = r2;
    }

    @Override // java.io.InputStream
    public int available() {
        InputStream r0 = this.f13382f;
        if (r0 == null) goto L7;
        return r0.available();
    L7:
        return super.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InputStream r0 = this.f13382f;     // Catch: Throwable -> L10
        if (r0 == null) goto L5;
        r0.close();     // Catch: Throwable -> L10
    L5:
        d.b.r.h0.e r1 = this.f13383g;     // Catch: Throwable -> L10
        if (r1 == null) goto L8;
        r1.cancel();     // Catch: Throwable -> L10
    L8:
        super.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int r2) {
        monitor-enter(this);
        InputStream r0 = this.f13382f;     // Catch: Throwable -> L9
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
    public boolean markSupported() {
        InputStream r0 = this.f13382f;
        if (r0 == null) goto L7;
        return r0.markSupported();
    L7:
        return super.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        InputStream r0 = this.f13382f;
        if (r0 != null) goto L5;
        return -1;
    L5:
        return r0.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] r2) {
        InputStream r0 = this.f13382f;
        if (r0 == null) goto L7;
        return r0.read(r2);
    L7:
        return super.read(r2);
    }

    @Override // java.io.InputStream
    public int read(byte[] r2, int r3, int r4) {
        InputStream r0 = this.f13382f;
        if (r0 == null) goto L7;
        return r0.read(r2, r3, r4);
    L7:
        return super.read(r2, r3, r4);
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        monitor-enter(this);
        InputStream r0 = this.f13382f;     // Catch: Throwable -> L9
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
    public long skip(long r2) {
        InputStream r0 = this.f13382f;
        if (r0 == null) goto L7;
        return r0.skip(r2);
    L7:
        return super.skip(r2);
    }
}
