package l.b.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends t implements z {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final char[] f21514h = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final byte[] f21515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final int f21516g;

    static {
        f21514h = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public b(byte[] r2, int r3) {
        Objects.requireNonNull(r2, "'data' cannot be null");
        if (r2.length != 0) goto L9;
        if (r3 == 0) goto L9;
        throw new IllegalArgumentException("zero length data with non-zero pad bits");
    L9:
        if (r3 > 7) goto L14;
        if (r3 < 0) goto L14;
        this.f21515f = l.b.h.a.d(r2);
        this.f21516g = r3;
        return;
    L14:
        throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
    }

    static b w(int r3, InputStream r4) {
        if (r3 < 1) goto L20;
        int r1 = r4.read();
        int r5 = r3 - 1;
        byte[] r2 = new byte[r5];
        if (r5 == 0) goto L18;
        if (l.b.h.i.a.c(r4, r2) != r5) goto L16;
        if (r1 <= 0) goto L18;
        if (r1 >= 8) goto L18;
        int r6 = r5 - 1;
        if (r2[r6] == ((byte) (r2[r6] & (255 << r1)))) goto L18;
        return new l1(r2, r1);
    L16:
        throw new EOFException("EOF encountered in middle of BIT STRING");
    L18:
        return new p0(r2, r1);
    L20:
        throw new IllegalArgumentException("truncated BIT STRING detected");
    }

    @Override // l.b.a.z
    public String c() {
        StringBuffer r0 = new StringBuffer("#");
        byte[] r4 = getEncoded();     // Catch: IOException -> L10
        int r1 = 0;
    L6:
        if (r1 == r4.length) goto L9;
        char[] r2 = f21514h;
        r0.append(r2[(r4[r1] >>> 4) & 15]);
        r0.append(r2[r4[r1] & 15]);
        r1 = r1 + 1;
        goto L6
    L9:
        return r0.toString();
    L10:
        e = move-exception;
        throw new s("Internal error encoding BitString: " + e.getMessage(), e);
    }

    @Override // l.b.a.n
    public int hashCode() {
        byte[] r0 = this.f21515f;
        int r1 = r0.length - 1;
        if (r1 >= 0) goto L7;
        return 1;
    L7:
        return this.f21516g ^ ((l.b.h.a.k(r0, 0, r1) * 257) ^ ((byte) (r0[r1] & (255 << this.f21516g))));
    }

    @Override // l.b.a.t
    boolean n(t r8) {
        if ((r8 instanceof b) == true) goto L5;
        return false;
    L5:
        b r9 = (b) r8;
        if (this.f21516g == r9.f21516g) goto L8;
        return false;
    L8:
        byte[] r0 = this.f21515f;
        byte[] r10 = r9.f21515f;
        int r2 = r0.length;
        if (r2 == r10.length) goto L11;
        return false;
    L11:
        int r3 = r2 - 1;
        if (r3 >= 0) goto L14;
        return true;
    L14:
        int r4 = 0;
    L15:
        if (r4 >= r3) goto L20;
        if (r0[r4] != r10[r4]) goto L18;
        r4 = r4 + 1;
        goto L15
    L18:
        return false;
    L20:
        byte r1 = r0[r3];
        int r7 = this.f21516g;
        if (((byte) (r1 & (255 << r7))) == ((byte) ((255 << r7) & r10[r3]))) goto L23;
        return false;
    L23:
        return true;
    }

    public String toString() {
        return c();
    }

    @Override // l.b.a.t
    t u() {
        return new p0(this.f21515f, this.f21516g);
    }

    @Override // l.b.a.t
    t v() {
        return new l1(this.f21515f, this.f21516g);
    }

    public byte[] x() {
        byte[] r0 = this.f21515f;
        if (r0.length != 0) goto L5;
        return r0;
    L5:
        byte[] r1 = l.b.h.a.d(r0);
        int r2 = this.f21515f.length - 1;
        r1[r2] = (byte) ((255 << this.f21516g) & r1[r2]);
        return r1;
    }

    public byte[] y() {
        if (this.f21516g != 0) goto L7;
        return l.b.h.a.d(this.f21515f);
    L7:
        throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
    }
}
