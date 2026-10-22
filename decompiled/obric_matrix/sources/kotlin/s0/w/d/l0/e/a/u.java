package kotlin.s0.w.d.l0.e.a;

import kotlin.i0.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.g.c f19640a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.g.c f19641b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final c0<v> f19642c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final v f19643d = null;

    static {
        kotlin.s0.w.d.l0.g.c r0 = new kotlin.s0.w.d.l0.g.c("org.jspecify.nullness");
        f19640a = r0;
        kotlin.s0.w.d.l0.g.c r1 = new kotlin.s0.w.d.l0.g.c("org.checkerframework.checker.nullness.compatqual");
        f19641b = r1;
        kotlin.s0.w.d.l0.g.c r4 = new kotlin.s0.w.d.l0.g.c("org.jetbrains.annotations");
        v.a r5 = v.f19644d;
        kotlin.s0.w.d.l0.g.c r2 = new kotlin.s0.w.d.l0.g.c("androidx.annotation.RecentlyNullable");
        f0 r14 = f0.f19254h;
        kotlin.f r6 = new kotlin.f(1, 8);
        f0 r7 = f0.f19255i;
        f19642c = new d0(m0.k(new kotlin.u[]{kotlin.a0.a(r4, r5.a()), kotlin.a0.a(new kotlin.s0.w.d.l0.g.c("androidx.annotation"), r5.a()), kotlin.a0.a(new kotlin.s0.w.d.l0.g.c("android.support.annotation"), r5.a()), kotlin.a0.a(new kotlin.s0.w.d.l0.g.c("android.annotation"), r5.a()), kotlin.a0.a(new kotlin.s0.w.d.l0.g.c("com.android.annotations"), r5.a()), kotlin.a0.a(new kotlin.s0.w.d.l0.g.c("org.eclipse.jdt.annotation"), r5.a()), kotlin.a0.a(new kotlin.s0.w.d.l0.g.c("org.checkerframework.checker.nullness.qual"), r5.a()), kotlin.a0.a(r1, r5.a()), kotlin.a0.a(new kotlin.s0.w.d.l0.g.c("javax.annotation"), r5.a()), kotlin.a0.a(new kotlin.s0.w.d.l0.g.c("edu.umd.cs.findbugs.annotations"), r5.a()), kotlin.a0.a(new kotlin.s0.w.d.l0.g.c("io.reactivex.annotations"), r5.a()), kotlin.a0.a(r2, new v(r14, null, null, 4, null)), kotlin.a0.a(new kotlin.s0.w.d.l0.g.c("androidx.annotation.RecentlyNonNull"), new v(r14, null, null, 4, null)), kotlin.a0.a(new kotlin.s0.w.d.l0.g.c("lombok"), r5.a()), kotlin.a0.a(r0, new v(r14, r6, r7)), kotlin.a0.a(new kotlin.s0.w.d.l0.g.c("io.reactivex.rxjava3.annotations"), new v(r14, new kotlin.f(1, 8), r7))}));
        f19643d = new v(r14, null, null, 4, null);
    }

    public static final y a(kotlin.f r6) {
        kotlin.n0.d.o.f(r6, "configuredKotlinVersion");
        v r0 = f19643d;
        if (r0.d() != null) goto L5;
    L7:
        f0 r7 = r0.c();
    L8:
        f0 r1 = r7;
        return new y(r1, c(r1), null, 4, null);
    L5:
        if (r0.d().a(r6) > 0) goto L7;
        r7 = r0.b();
        goto L8
    }

    public static /* synthetic */ y b(kotlin.f r0, int r1, Object r2) {
        if ((r1 & 1) == 0) goto L6;
        r0 = kotlin.f.f18319j;
    L6:
        return a(r0);
    }

    public static final f0 c(f0 r1) {
        kotlin.n0.d.o.f(r1, "globalReportLevel");
        if (r1 != f0.f19254h) goto L6;
        return null;
    L6:
        return r1;
    }

    public static final f0 d(kotlin.s0.w.d.l0.g.c r3) {
        kotlin.n0.d.o.f(r3, "annotationFqName");
        return g(r3, c0.f19243a.a(), null, 4, null);
    }

    public static final kotlin.s0.w.d.l0.g.c e() {
        return f19640a;
    }

    public static final f0 f(kotlin.s0.w.d.l0.g.c r1, c0<? extends f0> r2, kotlin.f r3) {
        kotlin.n0.d.o.f(r1, "annotation");
        kotlin.n0.d.o.f(r2, "configuredReportLevels");
        kotlin.n0.d.o.f(r3, "configuredKotlinVersion");
        f0 r4 = r2.a(r1);
        if (r4 == null) goto L5;
        return r4;
    L5:
        v r5 = f19642c.a(r1);
        if (r5 != null) goto L10;
        return f0.f19253g;
    L10:
        if (r5.d() == null) goto L15;
        if (r5.d().a(r3) > 0) goto L15;
        return r5.b();
    L15:
        return r5.c();
    }

    public static /* synthetic */ f0 g(kotlin.s0.w.d.l0.g.c r1, c0 r2, kotlin.f r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = new kotlin.f(1, 7, 0);
    L6:
        return f(r1, r2, r3);
    }
}
