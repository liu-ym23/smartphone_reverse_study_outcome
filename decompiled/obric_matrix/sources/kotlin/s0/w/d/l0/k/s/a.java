package kotlin.s0.w.d.l0.k.s;

import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements Comparable<a> {
    public a() {
    }

    public int a(a r3) {
        o.f(r3, "other");
        int r0 = b().compareTo(r3.b());
        if (r0 == 0) goto L5;
        return r0;
    L5:
        if (c() == false) goto L7;
        return r0;
    L7:
        if (r3.c() == false) goto L12;
        return 1;
    L12:
        return r0;
    }

    public abstract b b();

    public abstract boolean c();

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(a r1) {
        return a(r1);
    }
}
