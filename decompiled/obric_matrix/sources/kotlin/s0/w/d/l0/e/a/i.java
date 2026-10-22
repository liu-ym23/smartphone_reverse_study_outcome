package kotlin.s0.w.d.l0.e.a;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f19290a = null;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.c.b, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f19291f = null;

        static {
            f19291f = new a();
        }

        a() {
            super(1);
        }

        public final Boolean a(kotlin.s0.w.d.l0.c.b r1) {
            kotlin.n0.d.o.f(r1, "it");
            return Boolean.valueOf(i.f19290a.b(r1));
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(kotlin.s0.w.d.l0.c.b r1) {
            return a(r1);
        }
    }

    static {
        f19290a = new i();
    }

    private i() {
    }

    private final boolean c(kotlin.s0.w.d.l0.c.b r5) {
        if (kotlin.i0.r.J(g.f19258a.c(), kotlin.s0.w.d.l0.k.t.a.d(r5)) == false) goto L8;
        if (r5.h().isEmpty() == false) goto L8;
        return true;
    L8:
        if (kotlin.s0.w.d.l0.b.h.f0(r5) == true) goto L10;
        return false;
    L10:
        Collection<? extends kotlin.s0.w.d.l0.c.b> r4 = r5.f();
        kotlin.n0.d.o.e(r4, "overriddenDescriptors");
        if (r4.isEmpty() == true) goto L18;
        Iterator<T> r6 = r4.iterator();
    L15:
        if (r6.hasNext() == false) goto L18;
        kotlin.s0.w.d.l0.c.b r7 = (kotlin.s0.w.d.l0.c.b) r6.next();
        i r2 = f19290a;
        kotlin.n0.d.o.e(r7, "it");
        if (r2.b(r7) == false) goto L15;
        return true;
    L18:
        return false;
    }

    public final String a(kotlin.s0.w.d.l0.c.b r4) {
        kotlin.n0.d.o.f(r4, "<this>");
        kotlin.s0.w.d.l0.b.h.f0(r4);
        kotlin.s0.w.d.l0.c.b r3 = kotlin.s0.w.d.l0.k.t.a.c(kotlin.s0.w.d.l0.k.t.a.o(r4), false, a.f19291f, 1, null);
        if (r3 != null) goto L5;
        return null;
    L5:
        kotlin.s0.w.d.l0.g.f r5 = g.f19258a.a().get(kotlin.s0.w.d.l0.k.t.a.h(r3));
        if (r5 != null) goto L8;
        return null;
    L8:
        return r5.b();
    }

    public final boolean b(kotlin.s0.w.d.l0.c.b r3) {
        kotlin.n0.d.o.f(r3, "callableMemberDescriptor");
        if (g.f19258a.d().contains(r3.getName()) == true) goto L7;
        return false;
    L7:
        return c(r3);
    }
}
