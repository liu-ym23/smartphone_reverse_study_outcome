package l.b.a;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class o0 extends t implements z {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final char[] f21645f;

    o0(char[] r2) {
        Objects.requireNonNull(r2, "'string' cannot be null");
        this.f21645f = r2;
    }

    @Override // l.b.a.z
    public String c() {
        return new String(this.f21645f);
    }

    @Override // l.b.a.n
    public int hashCode() {
        return l.b.h.a.l(this.f21645f);
    }

    @Override // l.b.a.t
    protected boolean n(t r2) {
        if ((r2 instanceof o0) == true) goto L7;
        return false;
    L7:
        return l.b.h.a.b(this.f21645f, ((o0) r2).f21645f);
    }

    @Override // l.b.a.t
    void o(r r12, boolean r13) {
        int r0 = this.f21645f.length;
        if (r13 == false) goto L5;
        r12.f(30);
    L5:
        r12.r(r0 * 2);
        byte[] r1 = new byte[8];
        int r2 = r0 & (-4);
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L9;
        char[] r6 = this.f21645f;
        char r7 = r6[r4];
        char r8 = r6[r4 + 1];
        char r9 = r6[r4 + 2];
        char r10 = r6[r4 + 3];
        r4 = r4 + 4;
        r1[0] = (byte) (r7 >> '\b');
        r1[1] = (byte) r7;
        r1[2] = (byte) (r8 >> '\b');
        r1[3] = (byte) r8;
        r1[4] = (byte) (r9 >> '\b');
        r1[5] = (byte) r9;
        r1[6] = (byte) (r10 >> '\b');
        r1[7] = (byte) r10;
        r12.g(r1, 0, 8);
        goto L7
    L9:
        if (r4 >= r0) goto L18;
        int r14 = 0;
    L11:
        char r3 = this.f21645f[r4];
        r4 = r4 + 1;
        int r11 = r14 + 1;
        r1[r14] = (byte) (r3 >> '\b');
        r14 = r11 + 1;
        r1[r11] = (byte) r3;
        if (r4 < r0) goto L11;
        r12.g(r1, 0, r14);
        return;
    }

    @Override // l.b.a.t
    int p() {
        return (c2.a(this.f21645f.length * 2) + 1) + (this.f21645f.length * 2);
    }

    @Override // l.b.a.t
    boolean t() {
        return false;
    }

    public String toString() {
        return c();
    }
}
