package kotlin.s0.w.d.l0.e.b;

import kotlin.s0.w.d.l0.c.b1;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements kotlin.s0.w.d.l0.l.b.g0.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.k.u.d f19773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.k.u.d f19774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final q f19775d;

    public k(q r11, kotlin.s0.w.d.l0.f.l r12, kotlin.s0.w.d.l0.f.z.c r13, kotlin.s0.w.d.l0.l.b.t<kotlin.s0.w.d.l0.f.a0.b.e> r14, boolean r15, kotlin.s0.w.d.l0.l.b.g0.e r16) {
        kotlin.n0.d.o.f(r11, "kotlinClass");
        kotlin.n0.d.o.f(r12, "packageProto");
        kotlin.n0.d.o.f(r13, "nameResolver");
        kotlin.n0.d.o.f(r16, "abiStability");
        kotlin.s0.w.d.l0.k.u.d r2 = kotlin.s0.w.d.l0.k.u.d.b(r11.f());
        kotlin.n0.d.o.e(r2, "byClassId(kotlinClass.classId)");
        String r0 = r11.a().e();
        kotlin.s0.w.d.l0.k.u.d r1 = null;
        if (r0 != null) goto L5;
    L10:
        this(r2, r1, r12, r13, r14, r15, r16, r11);
        return;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L10;
        r1 = kotlin.s0.w.d.l0.k.u.d.d(r0);
        goto L10
    L7:
        r3 = false;
        goto L8
    }

    public k(kotlin.s0.w.d.l0.k.u.d r1, kotlin.s0.w.d.l0.k.u.d r2, kotlin.s0.w.d.l0.f.l r3, kotlin.s0.w.d.l0.f.z.c r4, kotlin.s0.w.d.l0.l.b.t<kotlin.s0.w.d.l0.f.a0.b.e> r5, boolean r6, kotlin.s0.w.d.l0.l.b.g0.e r7, q r8) {
        kotlin.n0.d.o.f(r1, "className");
        kotlin.n0.d.o.f(r3, "packageProto");
        kotlin.n0.d.o.f(r4, "nameResolver");
        kotlin.n0.d.o.f(r7, "abiStability");
        this.f19773b = r1;
        this.f19774c = r2;
        this.f19775d = r8;
        kotlin.s0.w.d.l0.i.i.f<kotlin.s0.w.d.l0.f.l, Integer> r0 = kotlin.s0.w.d.l0.f.a0.a.m;
        kotlin.n0.d.o.e(r0, "packageModuleName");
        Integer r9 = (Integer) kotlin.s0.w.d.l0.f.z.e.a(r3, r0);
        if (r9 == null) goto L6;
        r4.b(r9.intValue());
        return;
    }

    @Override // kotlin.s0.w.d.l0.c.a1
    public b1 a() {
        b1 r1 = b1.f18854a;
        kotlin.n0.d.o.e(r1, "NO_SOURCE_FILE");
        return r1;
    }

    @Override // kotlin.s0.w.d.l0.l.b.g0.f
    public String c() {
        return "Class '" + d().b().b() + '\'';
    }

    public final kotlin.s0.w.d.l0.g.b d() {
        return new kotlin.s0.w.d.l0.g.b(e().g(), h());
    }

    public kotlin.s0.w.d.l0.k.u.d e() {
        return this.f19773b;
    }

    public kotlin.s0.w.d.l0.k.u.d f() {
        return this.f19774c;
    }

    public final q g() {
        return this.f19775d;
    }

    public final kotlin.s0.w.d.l0.g.f h() {
        String r3 = e().f();
        kotlin.n0.d.o.e(r3, "className.internalName");
        kotlin.s0.w.d.l0.g.f r4 = kotlin.s0.w.d.l0.g.f.k(kotlin.u0.k.A0(r3, '/', null, 2, null));
        kotlin.n0.d.o.e(r4, "identifier(className.int….substringAfterLast('/'))");
        return r4;
    }

    public String toString() {
        return k.class.getSimpleName() + ": " + e();
    }
}
