package d.c.c.j;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class b extends FilterInputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f15439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f15440g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f15441h;

    public b(InputStream r1, byte[] r2) {
        super(r1);
        Objects.requireNonNull(r1);
        Objects.requireNonNull(r2);
        this.f15439f = r2;
    }

    private int a() {
        int r0 = this.f15440g;
        byte[] r1 = this.f15439f;
        if (r0 < r1.length) goto L6;
        return -1;
    L6:
        this.f15440g = r0 + 1;
        return r1[r0] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int r2) {
        if (((FilterInputStream) this).in.markSupported() == false) goto L6;
        super.mark(r2);
        this.f15441h = this.f15440g;
        return;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int r0 = ((FilterInputStream) this).in.read();
        if (r0 == (-1)) goto L6;
        return r0;
    L6:
        return a();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r3) {
        return read(r3, 0, r3.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r5, int r6, int r7) {
        int r0 = ((FilterInputStream) this).in.read(r5, r6, r7);
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        if (r7 != 0) goto L8;
        return 0;
    L8:
        if (r1 >= r7) goto L13;
        int r2 = a();
        if (r2 == (-1)) goto L13;
        r5[r6 + r1] = (byte) r2;
        r1 = r1 + 1;
    L13:
        if (r1 > 0) goto L15;
        return -1;
    L15:
        return r1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        if (((FilterInputStream) this).in.markSupported() == false) goto L7;
        ((FilterInputStream) this).in.reset();
        this.f15440g = this.f15441h;
        return;
    L7:
        throw new IOException("mark is not supported");
    }
}
