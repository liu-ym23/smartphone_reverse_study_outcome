package kotlin.s0.w.d.l0.n.y1;

import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f21197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f21198b;

    public a(T r1, T r2) {
        this.f21197a = r1;
        this.f21198b = r2;
    }

    public final T a() {
        return this.f21197a;
    }

    public final T b() {
        return this.f21198b;
    }

    public final T c() {
        return this.f21197a;
    }

    public final T d() {
        return this.f21198b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (o.a(this.f21197a, r6.f21197a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f21198b, r6.f21198b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        T r0 = this.f21197a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        T r4 = this.f21198b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ApproximationBounds(lower=" + this.f21197a + ", upper=" + this.f21198b + ')';
    }
}
