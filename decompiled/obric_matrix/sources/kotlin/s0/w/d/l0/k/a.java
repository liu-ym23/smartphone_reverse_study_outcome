package kotlin.s0.w.d.l0.k;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.i0.r;
import kotlin.s0.w.d.l0.c.e0;
import kotlin.s0.w.d.l0.c.e1;
import kotlin.s0.w.d.l0.c.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20506a = null;

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.k.a$a, reason: collision with other inner class name */
    public static final class C0558a<T> implements Comparator {
        public C0558a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return kotlin.j0.a.a(kotlin.s0.w.d.l0.k.t.a.h((kotlin.s0.w.d.l0.c.e) r1).b(), kotlin.s0.w.d.l0.k.t.a.h((kotlin.s0.w.d.l0.c.e) r2).b());
        }
    }

    static {
        f20506a = new a();
    }

    private a() {
    }

    private static final void b(kotlin.s0.w.d.l0.c.e r4, LinkedHashSet<kotlin.s0.w.d.l0.c.e> r5, kotlin.s0.w.d.l0.k.w.h r6, boolean r7) {
        Iterator r0 = kotlin.s0.w.d.l0.k.w.k.a.a(r6, kotlin.s0.w.d.l0.k.w.d.q, null, 2, null).iterator();
    L4:
        if (r0.hasNext() == false) goto L23;
        kotlin.s0.w.d.l0.c.m r2 = (kotlin.s0.w.d.l0.c.m) r0.next();
        if ((r2 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L4;
        kotlin.s0.w.d.l0.c.e r3 = (kotlin.s0.w.d.l0.c.e) r2;
        if (r3.L() == false) goto L16;
        kotlin.s0.w.d.l0.g.f r8 = r3.getName();
        kotlin.n0.d.o.e(r8, "descriptor.name");
        kotlin.s0.w.d.l0.c.h r9 = r6.f(r8, kotlin.s0.w.d.l0.d.b.d.r);
        if ((r9 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L13;
        r3 = (kotlin.s0.w.d.l0.c.e) r9;
        goto L16
    L13:
        if ((r9 instanceof e1) == false) goto L15;
        r3 = ((e1) r9).r();
        goto L16
    L15:
        r3 = null;
    L16:
        if (r3 == null) goto L4;
        if (d.z(r3, r4) == false) goto L21;
        r5.add(r3);
    L21:
        if (r7 == false) goto L4;
        kotlin.s0.w.d.l0.k.w.h r10 = r3.y0();
        kotlin.n0.d.o.e(r10, "refinedDescriptor.unsubstitutedInnerClassesScope");
        b(r4, r5, r10, r7);
        goto L4
    }

    public Collection<kotlin.s0.w.d.l0.c.e> a(kotlin.s0.w.d.l0.c.e r4, boolean r5) {
        kotlin.n0.d.o.f(r4, "sealedClass");
        if (r4.l() != e0.f18861h) goto L5;
        LinkedHashSet r3 = new LinkedHashSet();
        if (r5 == true) goto L9;
        kotlin.s0.w.d.l0.c.m r0 = r4.c();
    L18:
        if ((r0 instanceof l0) == false) goto L20;
        b(r4, r3, ((l0) r0).q(), r5);
    L20:
        kotlin.s0.w.d.l0.k.w.h r6 = r4.y0();
        kotlin.n0.d.o.e(r6, "sealedClass.unsubstitutedInnerClassesScope");
        b(r4, r3, r6, true);
        return r.s0(r3, new C0558a());
    L9:
        Iterator<kotlin.s0.w.d.l0.c.m> r1 = kotlin.s0.w.d.l0.k.t.a.m(r4).iterator();
    L11:
        if (r1.hasNext() == false) goto L15;
        kotlin.s0.w.d.l0.c.m r2 = r1.next();
        if ((r2 instanceof l0) == false) goto L11;
    L16:
        r0 = r2;
        goto L18
    L15:
        r2 = null;
        goto L16
    L5:
        return r.g();
    }
}
