package kotlin.s0.w.d.l0.e.b;

import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.f0;
import kotlin.s0.w.d.l0.n.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements kotlin.s0.w.d.l0.l.b.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f19772a = null;

    static {
        f19772a = new i();
    }

    private i() {
    }

    @Override // kotlin.s0.w.d.l0.l.b.s
    public e0 a(kotlin.s0.w.d.l0.f.q r2, String r3, m0 r4, m0 r5) {
        kotlin.n0.d.o.f(r2, "proto");
        kotlin.n0.d.o.f(r3, "flexibleId");
        kotlin.n0.d.o.f(r4, "lowerBound");
        kotlin.n0.d.o.f(r5, "upperBound");
        if (kotlin.n0.d.o.a(r3, "kotlin.jvm.PlatformType") == true) goto L7;
        return kotlin.s0.w.d.l0.n.u1.k.d(kotlin.s0.w.d.l0.n.u1.j.O, new String[]{r3, r4.toString(), r5.toString()});
    L7:
        if (r2.w(kotlin.s0.w.d.l0.f.a0.a.f19806g) == false) goto L11;
        return new kotlin.s0.w.d.l0.e.a.l0.m.f(r4, r5);
    L11:
        return f0.d(r4, r5);
    }
}
