package l.b.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
class v1 extends a2 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final byte[] f21766j = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f21767h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f21768i;

    static {
        f21766j = new byte[0];
    }

    v1(InputStream r1, int r2, int r3) {
        super(r1, r3);
        if (r2 < 0) goto L9;
        this.f21767h = r2;
        this.f21768i = r2;
        if (r2 != 0) goto L10;
        b(true);
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("negative lengths not allowed");
    }

    int g() {
        return this.f21768i;
    }

    void l(byte[] r4) {
        int r0 = this.f21768i;
        if (r0 != r4.length) goto L17;
        if (r0 != 0) goto L6;
        return;
    L6:
        int r1 = a();
        int r2 = this.f21768i;
        if (r2 >= r1) goto L15;
        int r3 = r2 - l.b.h.i.a.c(this.f21512f, r4);
        this.f21768i = r3;
        if (r3 != 0) goto L13;
        b(true);
        return;
    L13:
        throw new EOFException("DEF length " + this.f21767h + " object truncated by " + this.f21768i);
    L15:
        throw new IOException("corrupted stream - out of bounds length found: " + this.f21768i + " >= " + r1);
    L17:
        throw new IllegalArgumentException("buffer length not right for data");
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f21768i != 0) goto L6;
        return -1;
    L6:
        int r0 = this.f21512f.read();
        if (r0 < 0) goto L13;
        int r1 = this.f21768i - 1;
        this.f21768i = r1;
        if (r1 != 0) goto L11;
        b(true);
    L11:
        return r0;
    L13:
        throw new EOFException("DEF length " + this.f21767h + " object truncated by " + this.f21768i);
    }

    @Override // java.io.InputStream
    public int read(byte[] r2, int r3, int r4) {
        int r0 = this.f21768i;
        if (r0 != 0) goto L6;
        return -1;
    L6:
        int r5 = this.f21512f.read(r2, r3, Math.min(r4, r0));
        if (r5 < 0) goto L13;
        int r6 = this.f21768i - r5;
        this.f21768i = r6;
        if (r6 != 0) goto L11;
        b(true);
    L11:
        return r5;
    L13:
        throw new EOFException("DEF length " + this.f21767h + " object truncated by " + this.f21768i);
    }

    byte[] s() {
        if (this.f21768i == 0) goto L5;
        int r0 = a();
        int r1 = this.f21768i;
        if (r1 >= r0) goto L15;
        byte[] r2 = new byte[r1];
        int r3 = r1 - l.b.h.i.a.c(this.f21512f, r2);
        this.f21768i = r3;
        if (r3 != 0) goto L13;
        b(true);
        return r2;
    L13:
        throw new EOFException("DEF length " + this.f21767h + " object truncated by " + this.f21768i);
    L15:
        throw new IOException("corrupted stream - out of bounds length found: " + this.f21768i + " >= " + r0);
    L5:
        return f21766j;
    }
}
