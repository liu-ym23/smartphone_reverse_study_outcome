package kotlin.s0.w.d.l0.c.s1.a;

import java.io.InputStream;
import kotlin.s0.w.d.l0.e.b.o;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ClassLoader f19089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.l.b.f0.d f19090b;

    public g(ClassLoader r2) {
        kotlin.n0.d.o.f(r2, "classLoader");
        this.f19089a = r2;
        this.f19090b = new kotlin.s0.w.d.l0.l.b.f0.d();
    }

    private final o.a d(String r3) {
        Class<?> r2 = e.a(this.f19089a, r3);
        if (r2 == null) goto L8;
        f r4 = f.f19086c.a(r2);
        if (r4 != null) goto L7;
        return null;
    L7:
        return new o.a.b(r4, null, 2, null);
    L8:
        return null;
    }

    @Override // kotlin.s0.w.d.l0.e.b.o
    public o.a a(kotlin.s0.w.d.l0.e.a.n0.g r2) {
        kotlin.n0.d.o.f(r2, "javaClass");
        kotlin.s0.w.d.l0.g.c r3 = r2.e();
        if (r3 == null) goto L9;
        String r4 = r3.b();
        if (r4 != null) goto L8;
        return null;
    L8:
        return d(r4);
    L9:
        return null;
    }

    @Override // kotlin.s0.w.d.l0.l.b.u
    public InputStream b(kotlin.s0.w.d.l0.g.c r2) {
        kotlin.n0.d.o.f(r2, "packageFqName");
        if (r2.i(kotlin.s0.w.d.l0.b.k.f18714j) == true) goto L7;
        return null;
    L7:
        return this.f19090b.a(kotlin.s0.w.d.l0.l.b.f0.a.m.n(r2));
    }

    @Override // kotlin.s0.w.d.l0.e.b.o
    public o.a c(kotlin.s0.w.d.l0.g.b r2) {
        kotlin.n0.d.o.f(r2, "classId");
        return d(h.a(r2));
    }
}
