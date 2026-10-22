package kotlin.s0.w.d.l0.b.p;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.i0.r;
import kotlin.i0.t0;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.c.l0;
import kotlin.s0.w.d.l0.g.f;
import kotlin.s0.w.d.l0.m.n;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements kotlin.s0.w.d.l0.c.p1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n f18750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h0 f18751b;

    public a(n r2, h0 r3) {
        o.f(r2, "storageManager");
        o.f(r3, "module");
        this.f18750a = r2;
        this.f18751b = r3;
    }

    @Override // kotlin.s0.w.d.l0.c.p1.b
    public Collection<kotlin.s0.w.d.l0.c.e> a(kotlin.s0.w.d.l0.g.c r1) {
        o.f(r1, "packageFqName");
        return t0.b();
    }

    @Override // kotlin.s0.w.d.l0.c.p1.b
    public boolean b(kotlin.s0.w.d.l0.g.c r4, f r5) {
        o.f(r4, "packageFqName");
        o.f(r5, "name");
        String r3 = r5.b();
        o.e(r3, "name.asString()");
        if (k.A(r3, "Function", false, 2, null) == true) goto L11;
        if (k.A(r3, "KFunction", false, 2, null) == true) goto L11;
        if (k.A(r3, "SuspendFunction", false, 2, null) == true) goto L11;
        if (k.A(r3, "KSuspendFunction", false, 2, null) == true) goto L11;
        return false;
    L11:
        if (c.f18756h.c(r3, r4) == null) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.p1.b
    public kotlin.s0.w.d.l0.c.e c(kotlin.s0.w.d.l0.g.b r7) {
        o.f(r7, "classId");
        if (r7.k() == false) goto L5;
    L31:
        return null;
    L5:
        if (r7.l() == true) goto L31;
        String r0 = r7.i().b();
        o.e(r0, "classId.relativeClassName.asString()");
        if (k.F(r0, "Function", false, 2, null) == true) goto L10;
        return null;
    L10:
        kotlin.s0.w.d.l0.g.c r8 = r7.h();
        o.e(r8, "classId.packageFqName");
        c.a.C0497a r1 = c.f18756h.c(r0, r8);
        if (r1 != null) goto L13;
        return null;
    L13:
        c r2 = r1.a();
        int r3 = r1.b();
        List<l0> r9 = this.f18751b.N(r8).G();
        ArrayList r4 = new ArrayList();
        Iterator<T> r10 = r9.iterator();
    L15:
        if (r10.hasNext() == false) goto L19;
        Object r5 = r10.next();
        if ((r5 instanceof kotlin.s0.w.d.l0.b.b) == false) goto L15;
        r4.add(r5);
        goto L15
    L19:
        ArrayList r11 = new ArrayList();
        Iterator r6 = r4.iterator();
    L21:
        if (r6.hasNext() == false) goto L25;
        Object r12 = r6.next();
        if ((r12 instanceof kotlin.s0.w.d.l0.b.f) == false) goto L21;
        r11.add(r12);
        goto L21
    L25:
        l0 r13 = (kotlin.s0.w.d.l0.b.f) r.R(r11);
        if (r13 != null) goto L30;
        r13 = (kotlin.s0.w.d.l0.b.b) r.P(r4);
    L30:
        return new b(this.f18750a, r13, r2, r3);
    }
}
