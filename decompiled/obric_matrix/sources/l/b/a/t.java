package l.b.a;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class t extends n {
    t() {
    }

    public static t s(byte[] r1) {
        k r0 = new k(r1);
        t r2 = r0.C();     // Catch: ClassCastException -> L8
        if (r0.available() != 0) goto L7;
        return r2;
    L7:
        throw new IOException("Extra data detected in stream");     // Catch: ClassCastException -> L8
    L9:
        throw new IOException("cannot recognise object in stream");
    }

    @Override // l.b.a.n, l.b.a.e
    public final t b() {
        return this;
    }

    @Override // l.b.a.n
    public final boolean equals(Object r3) {
        if (this != r3) goto L6;
        return true;
    L6:
        if ((r3 instanceof e) == true) goto L8;
    L10:
        return false;
    L8:
        if (n(((e) r3).b()) == false) goto L10;
        return true;
    }

    @Override // l.b.a.n
    public void g(OutputStream r1) {
        r.a(r1).t(this);
    }

    @Override // l.b.a.n
    public void l(OutputStream r1, String r2) {
        r.b(r1, r2).t(this);
    }

    abstract boolean n(t r1);

    abstract void o(r r1, boolean r2);

    abstract int p();

    public final boolean q(e r1) {
        if (this == r1) goto L8;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (n(r1.b()) == false) goto L7;
    L8:
        return true;
    }

    public final boolean r(t r1) {
        if (this != r1) goto L4;
    L7:
        return true;
    L4:
        if (n(r1) == true) goto L7;
        return false;
    }

    abstract boolean t();

    t u() {
        return this;
    }

    t v() {
        return this;
    }
}
