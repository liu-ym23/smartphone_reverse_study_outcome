package l.b.a;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OutputStream f21668a;

    public r(OutputStream r1) {
        this.f21668a = r1;
    }

    public static r a(OutputStream r1) {
        return new r(r1);
    }

    public static r b(OutputStream r1, String r2) {
        if (r2.equals("DER") == false) goto L7;
        return new a1(r1);
    L7:
        if (r2.equals("DL") == false) goto L11;
        return new o1(r1);
    L11:
        return new r(r1);
    }

    void c() {
    }

    a1 d() {
        return new a1(this.f21668a);
    }

    r e() {
        return new o1(this.f21668a);
    }

    final void f(int r1) {
        this.f21668a.write(r1);
    }

    final void g(byte[] r1, int r2, int r3) {
        this.f21668a.write(r1, r2, r3);
    }

    final void h(Enumeration r3) {
    L3:
        if (r3.hasMoreElements() == false) goto L5;
        u(((e) r3.nextElement()).b(), true);
        goto L3
    }

    final void i(e[] r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        u(r5[r1].b(), true);
        r1 = r1 + 1;
        goto L3
    }

    final void j(boolean r1, int r2, byte r3) {
        if (r1 == false) goto L4;
        f(r2);
    L4:
        r(1);
        f(r3);
    }

    final void k(boolean r1, int r2, byte r3, byte[] r4) {
        if (r1 == false) goto L4;
        f(r2);
    L4:
        r(r4.length + 1);
        f(r3);
        g(r4, 0, r4.length);
    }

    final void l(boolean r1, int r2, byte r3, byte[] r4, int r5, int r6, byte r7) {
        if (r1 == false) goto L4;
        f(r2);
    L4:
        r(r6 + 2);
        f(r3);
        g(r4, r5, r6);
        f(r7);
    }

    final void m(boolean r1, int r2, int r3, byte[] r4) {
        v(r1, r2, r3);
        r(r4.length);
        g(r4, 0, r4.length);
    }

    final void n(boolean r1, int r2, byte[] r3) {
        if (r1 == false) goto L4;
        f(r2);
    L4:
        r(r3.length);
        g(r3, 0, r3.length);
    }

    final void o(boolean r1, int r2, int r3, byte[] r4) {
        v(r1, r2, r3);
        f(128);
        g(r4, 0, r4.length);
        f(0);
        f(0);
    }

    final void p(boolean r1, int r2, Enumeration r3) {
        if (r1 == false) goto L4;
        f(r2);
    L4:
        f(128);
        h(r3);
        f(0);
        f(0);
    }

    final void q(boolean r1, int r2, e[] r3) {
        if (r1 == false) goto L4;
        f(r2);
    L4:
        f(128);
        i(r3);
        f(0);
        f(0);
    }

    final void r(int r4) {
        if (r4 <= 127) goto L11;
        int r1 = r4;
        int r2 = 1;
    L5:
        r1 = r1 >>> 8;
        if (r1 == 0) goto L8;
        r2 = r2 + 1;
        goto L5
    L8:
        f((byte) (r2 | 128));
        int r3 = (r2 - 1) * 8;
    L9:
        if (r3 < 0) goto L15;
        f((byte) (r4 >> r3));
        r3 = r3 - 8;
        goto L9
    L15:
        return;
    L11:
        f((byte) r4);
    }

    public void s(e r2) {
        if (r2 == null) goto L6;
        u(r2.b(), true);
        c();
        return;
    L6:
        throw new IOException("null object detected");
    }

    public void t(t r2) {
        if (r2 == null) goto L6;
        u(r2, true);
        c();
        return;
    L6:
        throw new IOException("null object detected");
    }

    void u(t r1, boolean r2) {
        r1.o(this, r2);
    }

    final void v(boolean r3, int r4, int r5) {
        if (r3 == true) goto L5;
        return;
    L5:
        if (r5 >= 31) goto L7;
        f(r4 | r5);
        return;
    L7:
        f(31 | r4);
        if (r5 >= 128) goto L10;
        f(r5);
        return;
    L10:
        byte[] r6 = new byte[5];
        int r0 = 4;
        r6[4] = (byte) (r5 & 127);
    L11:
        r5 = r5 >> 7;
        r0 = r0 - 1;
        r6[r0] = (byte) ((r5 & 127) | 128);
        if (r5 > 127) goto L11;
        g(r6, r0, 5 - r0);
    }
}
