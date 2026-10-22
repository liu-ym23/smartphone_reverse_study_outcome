package d.c.c.g;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class g extends InputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final InputStream f15403f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final byte[] f15404g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final d.c.c.h.c<byte[]> f15405h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f15406i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f15407j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f15408k;

    public g(InputStream r1, byte[] r2, d.c.c.h.c<byte[]> r3) {
        d.c.c.d.i.g(r1);
        this.f15403f = r1;
        d.c.c.d.i.g(r2);
        this.f15404g = r2;
        d.c.c.d.i.g(r3);
        this.f15405h = r3;
        this.f15406i = 0;
        this.f15407j = 0;
        this.f15408k = false;
    }

    private boolean a() {
        if (this.f15407j >= this.f15406i) goto L5;
        return true;
    L5:
        int r0 = this.f15403f.read(this.f15404g);
        if (r0 > 0) goto L8;
        return false;
    L8:
        this.f15406i = r0;
        this.f15407j = 0;
        return true;
    }

    private void b() {
        if (this.f15408k == true) goto L6;
        return;
    L6:
        throw new IOException("stream already closed");
    }

    @Override // java.io.InputStream
    public int available() {
        if (this.f15407j > this.f15406i) goto L5;
        boolean r0 = true;
    L6:
        d.c.c.d.i.i(r0);
        b();
        return (this.f15406i - this.f15407j) + this.f15403f.available();
    L5:
        r0 = false;
        goto L6
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f15408k == true) goto L6;
        this.f15408k = true;
        this.f15405h.release(this.f15404g);
        super.close();
        return;
    }

    protected void finalize() {
        if (this.f15408k == true) goto L5;
        d.c.c.e.a.j("PooledByteInputStream", "Finalized without closing");
        close();
    L5:
        super.finalize();
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f15407j > this.f15406i) goto L5;
        boolean r0 = true;
    L6:
        d.c.c.d.i.i(r0);
        b();
        if (a() == true) goto L10;
        return -1;
    L10:
        byte[] r1 = this.f15404g;
        int r2 = this.f15407j;
        this.f15407j = r2 + 1;
        return r1[r2] & 255;
    L5:
        r0 = false;
        goto L6
    }

    @Override // java.io.InputStream
    public int read(byte[] r3, int r4, int r5) {
        if (this.f15407j > this.f15406i) goto L5;
        boolean r0 = true;
    L6:
        d.c.c.d.i.i(r0);
        b();
        if (a() == true) goto L10;
        return -1;
    L10:
        int r6 = Math.min(this.f15406i - this.f15407j, r5);
        System.arraycopy(this.f15404g, this.f15407j, r3, r4, r6);
        this.f15407j += r6;
        return r6;
    L5:
        r0 = false;
        goto L6
    }

    @Override // java.io.InputStream
    public long skip(long r6) {
        if (this.f15407j > this.f15406i) goto L5;
        boolean r0 = true;
    L6:
        d.c.c.d.i.i(r0);
        b();
        int r1 = this.f15406i;
        int r2 = this.f15407j;
        long r3 = r1 - r2;
        if (r3 < r6) goto L10;
        this.f15407j = (int) (((long) r2) + r6);
        return r6;
    L10:
        this.f15407j = r1;
        return r3 + this.f15403f.skip(r6 - r3);
    L5:
        r0 = false;
        goto L6
    }
}
