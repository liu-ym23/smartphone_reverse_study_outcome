package d.c.c.j;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class a extends FilterInputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f15437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f15438g;

    public a(InputStream r1, int r2) {
        super(r1);
        Objects.requireNonNull(r1);
        if (r2 < 0) goto L7;
        this.f15437f = r2;
        this.f15438g = -1;
        return;
    L7:
        throw new IllegalArgumentException("limit must be >= 0");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        return Math.min(((FilterInputStream) this).in.available(), this.f15437f);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int r2) {
        if (((FilterInputStream) this).in.markSupported() == false) goto L6;
        ((FilterInputStream) this).in.mark(r2);
        this.f15438g = this.f15437f;
        return;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        if (this.f15437f != 0) goto L5;
        return -1;
    L5:
        int r0 = ((FilterInputStream) this).in.read();
        if (r0 == (-1)) goto L8;
        this.f15437f--;
    L8:
        return r0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r2, int r3, int r4) {
        int r0 = this.f15437f;
        if (r0 != 0) goto L6;
        return -1;
    L6:
        int r5 = ((FilterInputStream) this).in.read(r2, r3, Math.min(r4, r0));
        if (r5 <= 0) goto L9;
        this.f15437f -= r5;
    L9:
        return r5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        if (((FilterInputStream) this).in.markSupported() == false) goto L11;
        if (this.f15438g == (-1)) goto L9;
        ((FilterInputStream) this).in.reset();
        this.f15437f = this.f15438g;
        return;
    L9:
        throw new IOException("mark not set");
    L11:
        throw new IOException("mark is not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long r3) {
        long r4 = ((FilterInputStream) this).in.skip(Math.min(r3, this.f15437f));
        this.f15437f = (int) (((long) this.f15437f) - r4);
        return r4;
    }
}
