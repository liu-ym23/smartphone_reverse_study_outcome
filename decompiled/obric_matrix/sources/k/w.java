package k;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public final class w extends h {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final transient byte[][] f18313k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final transient int[] f18314l;

    public w(byte[][] r2, int[] r3) {
        kotlin.n0.d.o.g(r2, "segments");
        kotlin.n0.d.o.g(r3, "directory");
        super(h.f18266i.m());
        this.f18313k = r2;
        this.f18314l = r3;
    }

    private final h J() {
        return new h(E());
    }

    @Override // k.h
    public h D() {
        return J().D();
    }

    @Override // k.h
    public byte[] E() {
        byte[] r0 = new byte[size()];
        int r1 = I().length;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r2 >= r1) goto L5;
        int r5 = H()[r1 + r2];
        int r6 = H()[r2];
        int r7 = r6 - r3;
        kotlin.i0.i.e(I()[r2], r0, r4, r5, r5 + r7);
        r4 = r4 + r7;
        r2 = r2 + 1;
        r3 = r6;
        goto L3
    L5:
        return r0;
    }

    @Override // k.h
    public void G(e r11, int r12, int r13) {
        kotlin.n0.d.o.g(r11, "buffer");
        int r14 = r13 + r12;
        int r0 = k.c0.c.b(this, r12);
    L3:
        if (r12 >= r14) goto L20;
        if (r0 != 0) goto L6;
        int r1 = 0;
    L7:
        int r2 = H()[r0] - r1;
        int r3 = H()[I().length + r0];
        int r4 = Math.min(r14, r2 + r1) - r12;
        int r6 = r3 + (r12 - r1);
        u r5 = new u(I()[r0], r6, r6 + r4, true, false);
        u r7 = r11.f18255f;
        if (r7 != null) goto L11;
        r5.f18309g = r5;
        r5.f18308f = r5;
        r11.f18255f = r5;
    L15:
        r12 = r12 + r4;
        r0 = r0 + 1;
        goto L3
    L11:
        if (r7 == null) goto L18;
        u r8 = r7.f18309g;
        if (r8 == null) goto L16;
        r8.c(r5);
        goto L15
    L16:
        kotlin.n0.d.o.p();
        throw null;
    L18:
        kotlin.n0.d.o.p();
        throw null;
    L6:
        r1 = H()[r0 - 1];
        goto L7
    L20:
        r11.j0(r11.k0() + ((long) size()));
    }

    public final int[] H() {
        return this.f18314l;
    }

    public final byte[][] I() {
        return this.f18313k;
    }

    @Override // k.h
    public String a() {
        return J().a();
    }

    @Override // k.h
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == false) goto L13;
        h r6 = (h) r5;
        if (r6.size() != size()) goto L13;
        if (w(0, r6, 0, size()) == false) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // k.h
    public h g(String r7) {
        kotlin.n0.d.o.g(r7, "algorithm");
        MessageDigest r8 = MessageDigest.getInstance(r7);
        int r0 = I().length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int r3 = H()[r0 + r1];
        int r4 = H()[r1];
        r8.update(I()[r1], r3, r4 - r2);
        r1 = r1 + 1;
        r2 = r4;
        goto L3
    L5:
        byte[] r9 = r8.digest();
        kotlin.n0.d.o.b(r9, "digest.digest()");
        return new h(r9);
    }

    @Override // k.h
    public int hashCode() {
        int r0 = n();
        if (r0 != 0) goto L15;
        int r1 = I().length;
        int r2 = 0;
        int r3 = 1;
        int r4 = 0;
    L6:
        if (r2 >= r1) goto L11;
        int r5 = H()[r1 + r2];
        int r6 = H()[r2];
        byte[] r7 = I()[r2];
        int r8 = (r6 - r4) + r5;
    L8:
        if (r5 >= r8) goto L10;
        r3 = (r3 * 31) + r7[r5];
        r5 = r5 + 1;
        goto L8
    L10:
        r2 = r2 + 1;
        r4 = r6;
        goto L6
    L11:
        y(r3);
        return r3;
    L15:
        return r0;
    }

    @Override // k.h
    public int o() {
        return H()[I().length - 1];
    }

    @Override // k.h
    public String q() {
        return J().q();
    }

    @Override // k.h
    public byte[] r() {
        return E();
    }

    @Override // k.h
    public byte s(int r8) {
        c.b(H()[I().length - 1], r8, 1);
        int r0 = k.c0.c.b(this, r8);
        if (r0 != 0) goto L5;
        int r1 = 0;
    L7:
        return I()[r0][(r8 - r1) + H()[I().length + r0]];
    L5:
        r1 = H()[r0 - 1];
        goto L7
    }

    @Override // k.h
    public String toString() {
        return J().toString();
    }

    @Override // k.h
    public boolean w(int r7, h r8, int r9, int r10) {
        kotlin.n0.d.o.g(r8, "other");
        if (r7 >= 0) goto L5;
        return false;
    L5:
        if (r7 > (size() - r10)) goto L21;
        int r11 = r10 + r7;
        int r1 = k.c0.c.b(this, r7);
    L8:
        if (r7 >= r11) goto L16;
        if (r1 != 0) goto L11;
        int r2 = 0;
    L12:
        int r3 = H()[r1] - r2;
        int r4 = H()[I().length + r1];
        int r5 = Math.min(r11, r3 + r2) - r7;
        if (r8.x(r9, I()[r1], r4 + (r7 - r2), r5) == false) goto L22;
        r9 = r9 + r5;
        r7 = r7 + r5;
        r1 = r1 + 1;
        goto L8
    L22:
        return false;
    L11:
        r2 = H()[r1 - 1];
        goto L12
    L16:
        return true;
    L21:
        return false;
    }

    @Override // k.h
    public boolean x(int r7, byte[] r8, int r9, int r10) {
        kotlin.n0.d.o.g(r8, "other");
        if (r7 >= 0) goto L5;
        return false;
    L5:
        if (r7 > (size() - r10)) goto L24;
        if (r9 >= 0) goto L8;
        return false;
    L8:
        if (r9 > (r8.length - r10)) goto L26;
        int r11 = r10 + r7;
        int r1 = k.c0.c.b(this, r7);
    L11:
        if (r7 >= r11) goto L19;
        if (r1 != 0) goto L14;
        int r2 = 0;
    L15:
        int r3 = H()[r1] - r2;
        int r4 = H()[I().length + r1];
        int r5 = Math.min(r11, r3 + r2) - r7;
        if (c.a(I()[r1], r4 + (r7 - r2), r8, r9, r5) == false) goto L27;
        r9 = r9 + r5;
        r7 = r7 + r5;
        r1 = r1 + 1;
        goto L11
    L27:
        return false;
    L14:
        r2 = H()[r1 - 1];
        goto L15
    L19:
        return true;
    L26:
        return false;
    L24:
        return false;
    }
}
