package kotlin.s0.w.d.l0.n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h1 implements g1 {
    public h1() {
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g1) == true) goto L8;
        return false;
    L8:
        g1 r6 = (g1) r5;
        if (d() == r6.d()) goto L12;
        return false;
    L12:
        if (a() == r6.a()) goto L15;
        return false;
    L15:
        if (b().equals(r6.b()) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = a().hashCode();
        int r1 = r0 * 31;
        if (n1.v(b()) == false) goto L6;
        return r1 + 19;
    L6:
        if (d() == false) goto L8;
        int r2 = 17;
    L10:
        return r1 + r2;
    L8:
        r2 = b().hashCode();
        goto L10
    }

    public String toString() {
        if (d() == false) goto L7;
        return "*";
    L7:
        if (a() != r1.f21065h) goto L11;
        return b().toString();
    L11:
        return a() + " " + b();
    }
}
