package d.c.c.g;

import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class j extends InputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final h f15409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f15410g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f15411h;

    public j(h r2) {
        d.c.c.d.i.b(!r2.isClosed());
        d.c.c.d.i.g(r2);
        this.f15409f = r2;
        this.f15410g = 0;
        this.f15411h = 0;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f15409f.size() - this.f15410g;
    }

    @Override // java.io.InputStream
    public void mark(int r1) {
        this.f15411h = this.f15410g;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        if (available() > 0) goto L6;
        return -1;
    L6:
        h r0 = this.f15409f;
        int r1 = this.f15410g;
        this.f15410g = r1 + 1;
        return r0.f(r1) & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] r3) {
        return read(r3, 0, r3.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] r3, int r4, int r5) {
        if (r4 < 0) goto L16;
        if (r5 < 0) goto L16;
        if ((r4 + r5) > r3.length) goto L16;
        int r0 = available();
        if (r0 > 0) goto L10;
        return -1;
    L10:
        if (r5 > 0) goto L13;
        return 0;
    L13:
        int r6 = Math.min(r0, r5);
        this.f15409f.h(this.f15410g, r3, r4, r6);
        this.f15410g += r6;
        return r6;
    L16:
        throw new ArrayIndexOutOfBoundsException("length=" + r3.length + "; regionStart=" + r4 + "; regionLength=" + r5);
    }

    @Override // java.io.InputStream
    public void reset() {
        this.f15410g = this.f15411h;
    }

    @Override // java.io.InputStream
    public long skip(long r3) {
        if (r3 < 0) goto L5;
        boolean r0 = true;
    L6:
        d.c.c.d.i.b(r0);
        int r4 = Math.min((int) r3, available());
        this.f15410g += r4;
        return r4;
    L5:
        r0 = false;
        goto L6
    }
}
