package kotlin.s0.w.d.l0.c.s1.a;

import java.util.Set;
import kotlin.s0.w.d.l0.c.s1.b.w;
import kotlin.s0.w.d.l0.e.a.n0.u;
import kotlin.s0.w.d.l0.e.a.o;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ClassLoader f19085a;

    public d(ClassLoader r2) {
        kotlin.n0.d.o.f(r2, "classLoader");
        this.f19085a = r2;
    }

    @Override // kotlin.s0.w.d.l0.e.a.o
    public kotlin.s0.w.d.l0.e.a.n0.g a(o.b r8) {
        kotlin.n0.d.o.f(r8, "request");
        kotlin.s0.w.d.l0.g.b r9 = r8.a();
        kotlin.s0.w.d.l0.g.c r0 = r9.h();
        kotlin.n0.d.o.e(r0, "classId.packageFqName");
        String r1 = r9.i().b();
        kotlin.n0.d.o.e(r1, "classId.relativeClassName.asString()");
        String r10 = kotlin.u0.k.v(r1, '.', '$', false, 4, null);
        if (r0.d() == true) goto L6;
        r10 = r0.b() + '.' + r10;
    L6:
        Class<?> r7 = e.a(this.f19085a, r10);
        if (r7 != null) goto L11;
        return null;
    L11:
        return new kotlin.s0.w.d.l0.c.s1.b.l(r7);
    }

    @Override // kotlin.s0.w.d.l0.e.a.o
    public Set<String> b(kotlin.s0.w.d.l0.g.c r1) {
        kotlin.n0.d.o.f(r1, "packageFqName");
        return null;
    }

    @Override // kotlin.s0.w.d.l0.e.a.o
    public u c(kotlin.s0.w.d.l0.g.c r1, boolean r2) {
        kotlin.n0.d.o.f(r1, "fqName");
        return new w(r1);
    }
}
