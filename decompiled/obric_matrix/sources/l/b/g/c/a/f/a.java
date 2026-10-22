package l.b.g.c.a.f;

import java.security.PrivateKey;
import java.util.Arrays;
import l.b.a.r2.e;
import l.b.a.w0;
import l.b.g.a.f;

/* JADX INFO: loaded from: classes2.dex */
public class a implements PrivateKey {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private short[][] f22234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private short[] f22235g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private short[][] f22236h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private short[] f22237i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private l.b.g.b.e.a[] f22238j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int[] f22239k;

    public a(l.b.g.c.b.a r8) {
        this(r8.c(), r8.a(), r8.d(), r8.b(), r8.f(), r8.e());
    }

    public a(short[][] r1, short[] r2, short[][] r3, short[] r4, int[] r5, l.b.g.b.e.a[] r6) {
        this.f22234f = r1;
        this.f22235g = r2;
        this.f22236h = r3;
        this.f22237i = r4;
        this.f22239k = r5;
        this.f22238j = r6;
    }

    public short[] a() {
        return this.f22235g;
    }

    public short[] b() {
        return this.f22237i;
    }

    public short[][] c() {
        return this.f22234f;
    }

    public short[][] d() {
        return this.f22236h;
    }

    public l.b.g.b.e.a[] e() {
        return this.f22238j;
    }

    public boolean equals(Object r6) {
        if (r6 != null) goto L5;
    L38:
        return false;
    L5:
        if ((r6 instanceof a) == false) goto L38;
        a r7 = (a) r6;
        if (l.b.g.b.e.b.a.j(this.f22234f, r7.c()) == false) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L13;
    L15:
        boolean r2 = false;
    L16:
        if (r2 == true) goto L18;
    L20:
        boolean r3 = false;
    L21:
        if (r3 == true) goto L23;
    L25:
        boolean r4 = false;
    L26:
        if (r4 == true) goto L28;
    L30:
        boolean r5 = false;
    L32:
        if (this.f22238j.length == r7.e().length) goto L34;
        return false;
    L34:
        int r0 = this.f22238j.length - 1;
    L35:
        if (r0 < 0) goto L37;
        r5 = r5 & this.f22238j[r0].equals(r7.e()[r0]);
        r0 = r0 - 1;
        goto L35
    L37:
        return r5;
    L28:
        if (Arrays.equals(this.f22239k, r7.f()) == false) goto L30;
        r5 = true;
        goto L32
    L23:
        if (l.b.g.b.e.b.a.i(this.f22237i, r7.b()) == false) goto L25;
        r4 = true;
        goto L26
    L18:
        if (l.b.g.b.e.b.a.i(this.f22235g, r7.a()) == false) goto L20;
        r3 = true;
        goto L21
    L13:
        if (l.b.g.b.e.b.a.j(this.f22236h, r7.d()) == false) goto L15;
        r2 = true;
        goto L16
    L10:
        r1 = false;
        goto L11
    }

    public int[] f() {
        return this.f22239k;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "Rainbow";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        f r7 = new f(this.f22234f, this.f22235g, this.f22236h, this.f22237i, this.f22239k, this.f22238j);
        return new e(new l.b.a.v2.a(l.b.g.a.e.f21929a, w0.f21794f), r7).getEncoded();
    L9:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        int r0 = (((((((((this.f22238j.length * 37) + l.b.h.a.o(this.f22234f)) * 37) + l.b.h.a.n(this.f22235g)) * 37) + l.b.h.a.o(this.f22236h)) * 37) + l.b.h.a.n(this.f22237i)) * 37) + l.b.h.a.m(this.f22239k);
        int r1 = this.f22238j.length - 1;
    L3:
        if (r1 < 0) goto L5;
        r0 = (r0 * 37) + this.f22238j[r1].hashCode();
        r1 = r1 - 1;
        goto L3
    L5:
        return r0;
    }
}
