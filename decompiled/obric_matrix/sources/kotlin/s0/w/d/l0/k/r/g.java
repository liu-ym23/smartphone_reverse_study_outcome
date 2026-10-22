package kotlin.s0.w.d.l0.k.r;

import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.n.e0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f20565a;

    public g(T r1) {
        this.f20565a = r1;
    }

    public abstract e0 a(h0 r1);

    public T b() {
        return this.f20565a;
    }

    public boolean equals(Object r3) {
        if (this == r3) goto L13;
        T r2 = b();
        Object r1 = null;
        if ((r3 instanceof g) == false) goto L6;
        g r4 = (g) r3;
    L7:
        if (r4 == null) goto L10;
        r1 = r4.b();
    L10:
        if (kotlin.n0.d.o.a(r2, r1) == true) goto L13;
        return false;
    L6:
        r4 = null;
    L13:
        return true;
    }

    public int hashCode() {
        T r0 = b();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return String.valueOf(b());
    }
}
