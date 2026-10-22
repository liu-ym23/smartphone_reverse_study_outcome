package l.b.a;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f21813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[][] f21815c;

    public y(InputStream r2) {
        this(r2, c2.c(r2));
    }

    public y(InputStream r1, int r2) {
        this.f21813a = r1;
        this.f21814b = r2;
        this.f21815c = new byte[11][];
    }

    private void e(boolean r2) {
        InputStream r1 = this.f21813a;
        if ((r1 instanceof x1) == false) goto L6;
        ((x1) r1).l(r2);
        return;
    }

    e a(int r3) {
        if (r3 == 4) goto L19;
        if (r3 == 8) goto L17;
        if (r3 == 16) goto L15;
        if (r3 != 17) goto L13;
        return new k0(this);
    L13:
        throw new h("unknown BER object encountered: 0x" + Integer.toHexString(r3));
    L15:
        return new i0(this);
    L17:
        return new r0(this);
    L19:
        return new g0(this);
    }

    public e b() {
        int r0 = this.f21813a.read();
        if (r0 != (-1)) goto L6;
        return null;
    L6:
        boolean r1 = false;
        e(false);
        int r2 = k.E(this.f21813a, r0);
        if ((r0 & 32) == 0) goto L9;
        boolean r3 = true;
    L10:
        InputStream r5 = this.f21813a;
        int r6 = this.f21814b;
        if (r2 == 4) goto L15;
        if (r2 == 16) goto L15;
        if (r2 == 17) goto L15;
        if (r2 == 8) goto L15;
    L16:
        int r4 = k.A(r5, r6, r1);
        if (r4 >= 0) goto L31;
        if (r3 == false) goto L30;
        y r7 = new y(new x1(this.f21813a, this.f21814b), this.f21814b);
        if ((r0 & 64) == 0) goto L24;
        return new d0(r2, r7);
    L24:
        if ((r0 & 128) == 0) goto L28;
        return new m0(true, r2, r7);
    L28:
        return r7.a(r2);
    L30:
        throw new IOException("indefinite-length primitive encoding encountered");
    L31:
        v1 r8 = new v1(this.f21813a, r4, this.f21814b);
        if ((r0 & 64) == 0) goto L36;
        return new k1(r3, r2, r8.s());
    L36:
        if ((r0 & 128) != 0) goto L38;
        if (r3 == false) goto L54;
        if (r2 == 4) goto L53;
        if (r2 == 8) goto L51;
        if (r2 == 16) goto L49;
        if (r2 != 17) goto L47;
        return new s1(new y(r8));
    L47:
        throw new IOException("unknown tag " + r2 + " encountered");
    L49:
        return new q1(new y(r8));
    L51:
        return new r0(new y(r8));
    L53:
        return new g0(new y(r8));
    L54:
        if (r2 == 4) goto L61;
        return k.b(r2, r8, this.f21815c);
    L57:
        e = move-exception;
        throw new h("corrupted stream detected", e);
    L61:
        return new z0(r8);
    L38:
        return new m0(r3, r2, new y(r8));
    L15:
        r1 = true;
        goto L16
    L9:
        r3 = false;
        goto L10
    }

    t c(boolean r3, int r4) {
        if (r3 == false) goto L5;
        f r5 = d();
        if ((this.f21813a instanceof x1) == false) goto L14;
        if (r5.f() != 1) goto L12;
        return new l0(true, r4, r5.d(0));
    L12:
        return new l0(false, r4, e0.a(r5));
    L14:
        if (r5.f() != 1) goto L17;
        return new t1(true, r4, r5.d(0));
    L17:
        return new t1(false, r4, n1.a(r5));
    L5:
        return new t1(false, r4, new y0(((v1) this.f21813a).s()));
    }

    f d() {
        e r0 = b();
        if (r0 == null) goto L5;
        f r1 = new f();
    L8:
        if ((r0 instanceof w1) == false) goto L10;
        t r2 = ((w1) r0).d();
    L11:
        r1.a(r2);
        r0 = b();
        if (r0 != null) goto L8;
        return r1;
    L10:
        r2 = r0.b();
        goto L11
    L5:
        return new f(0);
    }
}
