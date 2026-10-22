package l.b.g.b.h;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l.b.b.a f22114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f22115b;

    protected h(l.b.a.o r2, int r3) {
        Objects.requireNonNull(r2, "digest == null");
        this.f22114a = f.a(r2);
        this.f22115b = r3;
    }

    private byte[] d(int r4, byte[] r5, byte[] r6) {
        byte[] r7 = a0.q(r4, this.f22115b);
        this.f22114a.b(r7, 0, r7.length);
        this.f22114a.b(r5, 0, r5.length);
        this.f22114a.b(r6, 0, r6.length);
        int r8 = this.f22115b;
        byte[] r9 = new byte[r8];
        l.b.b.a r3 = this.f22114a;
        if ((r3 instanceof l.b.b.b) == false) goto L5;
        ((l.b.b.b) r3).d(r9, 0, r8);
    L6:
        return r9;
    L5:
        r3.a(r9, 0);
        goto L6
    }

    protected byte[] a(byte[] r3, byte[] r4) {
        int r0 = r3.length;
        int r1 = this.f22115b;
        if (r0 != r1) goto L11;
        if (r4.length != r1) goto L9;
        return d(0, r3, r4);
    L9:
        throw new IllegalArgumentException("wrong in length");
    L11:
        throw new IllegalArgumentException("wrong key length");
    }

    protected byte[] b(byte[] r3, byte[] r4) {
        int r0 = r3.length;
        int r1 = this.f22115b;
        if (r0 != r1) goto L11;
        if (r4.length != (r1 * 2)) goto L9;
        return d(1, r3, r4);
    L9:
        throw new IllegalArgumentException("wrong in length");
    L11:
        throw new IllegalArgumentException("wrong key length");
    }

    protected byte[] c(byte[] r3, byte[] r4) {
        if (r3.length != this.f22115b) goto L11;
        if (r4.length != 32) goto L9;
        return d(3, r3, r4);
    L9:
        throw new IllegalArgumentException("wrong address length");
    L11:
        throw new IllegalArgumentException("wrong key length");
    }
}
