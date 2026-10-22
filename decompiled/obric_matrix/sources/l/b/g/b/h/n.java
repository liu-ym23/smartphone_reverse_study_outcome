package l.b.g.b.h;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[][] f22142a;

    protected n(m r4, byte[][] r5) {
        Objects.requireNonNull(r4, "params == null");
        Objects.requireNonNull(r5, "publicKey == null");
        if (a0.k(r5) == true) goto L19;
        if (r5.length != r4.a()) goto L17;
        int r0 = 0;
    L8:
        if (r0 >= r5.length) goto L14;
        if (r5[r0].length != r4.c()) goto L13;
        r0 = r0 + 1;
        goto L8
    L13:
        throw new IllegalArgumentException("wrong publicKey format");
    L14:
        this.f22142a = a0.d(r5);
        return;
    L17:
        throw new IllegalArgumentException("wrong publicKey size");
    L19:
        throw new NullPointerException("publicKey byte array == null");
    }

    protected byte[][] a() {
        return a0.d(this.f22142a);
    }
}
