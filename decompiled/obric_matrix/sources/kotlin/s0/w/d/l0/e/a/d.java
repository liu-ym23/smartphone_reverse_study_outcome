package kotlin.s0.w.d.l0.e.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends a<kotlin.s0.w.d.l0.c.o1.c> {
    public d(w r2) {
        kotlin.n0.d.o.f(r2, "javaTypeEnhancementState");
        super(r2);
    }

    private final List<String> y(kotlin.s0.w.d.l0.k.r.g<?> r3) {
        if ((r3 instanceof kotlin.s0.w.d.l0.k.r.b) == false) goto L9;
        List<? extends kotlin.s0.w.d.l0.k.r.g<?>> r4 = ((kotlin.s0.w.d.l0.k.r.b) r3).b();
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L15;
        kotlin.i0.r.v(r0, y((kotlin.s0.w.d.l0.k.r.g) r5.next()));
        goto L6
    L15:
        return r0;
    L9:
        if ((r3 instanceof kotlin.s0.w.d.l0.k.r.j) == false) goto L12;
        return kotlin.i0.r.d(((kotlin.s0.w.d.l0.k.r.j) r3).c().g());
    L12:
        return kotlin.i0.r.g();
    }

    @Override // kotlin.s0.w.d.l0.e.a.a
    public /* bridge */ /* synthetic */ Iterable b(kotlin.s0.w.d.l0.c.o1.c r1, boolean r2) {
        return u(r1, r2);
    }

    @Override // kotlin.s0.w.d.l0.e.a.a
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.g.c i(kotlin.s0.w.d.l0.c.o1.c r1) {
        return v(r1);
    }

    @Override // kotlin.s0.w.d.l0.e.a.a
    public /* bridge */ /* synthetic */ Object j(kotlin.s0.w.d.l0.c.o1.c r1) {
        return w(r1);
    }

    @Override // kotlin.s0.w.d.l0.e.a.a
    public /* bridge */ /* synthetic */ Iterable<kotlin.s0.w.d.l0.c.o1.c> k(kotlin.s0.w.d.l0.c.o1.c r1) {
        return x(r1);
    }

    protected Iterable<String> u(kotlin.s0.w.d.l0.c.o1.c r5, boolean r6) {
        kotlin.n0.d.o.f(r5, "<this>");
        Map<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.k.r.g<?>> r7 = r5.a();
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.k.r.g<?>>> r8 = r7.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L13;
        Map.Entry<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.k.r.g<?>> r1 = r8.next();
        kotlin.s0.w.d.l0.g.f r2 = r1.getKey();
        kotlin.s0.w.d.l0.k.r.g<?> r3 = r1.getValue();
        if (r6 == true) goto L8;
    L11:
        List<String> r4 = y(r3);
    L12:
        kotlin.i0.r.v(r0, r4);
        goto L4
    L8:
        if (kotlin.n0.d.o.a(r2, a0.f19205b) == true) goto L11;
        r4 = kotlin.i0.r.g();
        goto L12
    L13:
        return r0;
    }

    protected kotlin.s0.w.d.l0.g.c v(kotlin.s0.w.d.l0.c.o1.c r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        return r1.e();
    }

    protected Object w(kotlin.s0.w.d.l0.c.o1.c r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.s0.w.d.l0.c.e r0 = kotlin.s0.w.d.l0.k.t.a.e(r1);
        kotlin.n0.d.o.c(r0);
        return r0;
    }

    protected Iterable<kotlin.s0.w.d.l0.c.o1.c> x(kotlin.s0.w.d.l0.c.o1.c r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.s0.w.d.l0.c.e r0 = kotlin.s0.w.d.l0.k.t.a.e(r1);
        if (r0 == null) goto L8;
        kotlin.s0.w.d.l0.c.o1.g r2 = r0.getAnnotations();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return kotlin.i0.r.g();
    }
}
