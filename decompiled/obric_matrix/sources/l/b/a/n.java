package l.b.a;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n implements e, l.b.h.c {
    public n() {
    }

    @Override // l.b.a.e
    public abstract t b();

    public boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof e) == true) goto L10;
        return false;
    L10:
        return b().r(((e) r2).b());
    }

    public void g(OutputStream r1) {
        r.a(r1).s(this);
    }

    @Override // l.b.h.c
    public byte[] getEncoded() {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        g(r0);
        return r0.toByteArray();
    }

    public int hashCode() {
        return b().hashCode();
    }

    public void l(OutputStream r1, String r2) {
        r.b(r1, r2).s(this);
    }

    public byte[] m(String r2) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        l(r0, r2);
        return r0.toByteArray();
    }
}
