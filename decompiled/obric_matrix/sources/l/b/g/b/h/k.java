package l.b.g.b.h;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f22128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f22129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f22130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f22131d;

    k(m r3) {
        Objects.requireNonNull(r3, "params == null");
        this.f22128a = r3;
        int r0 = r3.c();
        this.f22129b = new h(r3.b(), r0);
        this.f22130c = new byte[r0];
        this.f22131d = new byte[r0];
    }

    private byte[] a(byte[] r7, int r8, int r9, j r10) {
        int r0 = this.f22128a.c();
        Objects.requireNonNull(r7, "startHash == null");
        if (r7.length != r0) goto L16;
        Objects.requireNonNull(r10, "otsHashAddress == null");
        Objects.requireNonNull(r10.d(), "otsHashAddress byte array == null");
        int r1 = r8 + r9;
        if (r1 > (this.f22128a.d() - 1)) goto L14;
        if (r9 != 0) goto L8;
        return r7;
    L8:
        byte[] r11 = a(r7, r8, r9 - 1, r10);
        j.b r12 = new j.b().g(r10.b()).h(r10.c());
        r12.p(r10.g());
        r12.n(r10.e());
        r12.o(r1 - 1);
        int r13 = 0;
        j r14 = (j) r12.f(0).l();
        byte[] r15 = this.f22129b.c(this.f22131d, r14.d());
        j.b r2 = new j.b().g(r14.b()).h(r14.c());
        r2.p(r14.g());
        r2.n(r14.e());
        r2.o(r14.f());
        byte[] r16 = this.f22129b.c(this.f22131d, ((j) r2.f(1).l()).d());
        byte[] r3 = new byte[r0];
    L9:
        if (r13 >= r0) goto L12;
        r3[r13] = (byte) (r11[r13] ^ r16[r13]);
        r13 = r13 + 1;
        goto L9
    L12:
        return this.f22129b.a(r15, r3);
    L14:
        throw new IllegalArgumentException("max chain length must not be greater than w");
    L16:
        throw new IllegalArgumentException("startHash needs to be " + r0 + "bytes");
    }

    private byte[] b(int r4) {
        if (r4 < 0) goto L8;
        if (r4 >= this.f22128a.a()) goto L8;
        return this.f22129b.c(this.f22130c, a0.q(r4, 32));
    L8:
        throw new IllegalArgumentException("index out of bounds");
    }

    protected h c() {
        return this.f22129b;
    }

    protected m d() {
        return this.f22128a;
    }

    n e(j r7) {
        Objects.requireNonNull(r7, "otsHashAddress == null");
        byte[][] r0 = new byte[this.f22128a.a()][];
        int r2 = 0;
    L4:
        if (r2 >= this.f22128a.a()) goto L7;
        j.b r3 = new j.b().g(r7.b()).h(r7.c());
        r3.p(r7.g());
        r3.n(r2);
        r3.o(r7.f());
        r7 = (j) r3.f(r7.a()).l();
        r0[r2] = a(b(r2), 0, this.f22128a.d() - 1, r7);
        r2 = r2 + 1;
        goto L4
    L7:
        return new n(this.f22128a, r0);
    }

    protected byte[] f() {
        return l.b.h.a.d(this.f22131d);
    }

    protected byte[] g(byte[] r4, j r5) {
        j.b r0 = new j.b().g(r5.b()).h(r5.c());
        r0.p(r5.g());
        j r6 = (j) r0.l();
        return this.f22129b.c(r4, r6.d());
    }

    void h(byte[] r3, byte[] r4) {
        Objects.requireNonNull(r3, "secretKeySeed == null");
        if (r3.length != this.f22128a.c()) goto L11;
        Objects.requireNonNull(r4, "publicSeed == null");
        if (r4.length != this.f22128a.c()) goto L9;
        this.f22130c = r3;
        this.f22131d = r4;
        return;
    L9:
        throw new IllegalArgumentException("size of publicSeed needs to be equal to size of digest");
    L11:
        throw new IllegalArgumentException("size of secretKeySeed needs to be equal to size of digest");
    }
}
