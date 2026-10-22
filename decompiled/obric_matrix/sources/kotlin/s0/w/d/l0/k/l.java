package kotlin.s0.w.d.l0.k;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.f0;
import kotlin.i0.r;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: Add missing generic type declarations: [H] */
    static final class a<H> extends q implements kotlin.n0.c.l<H, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.p.f<H> f20552f;

        a(kotlin.s0.w.d.l0.p.f<H> r1) {
            this.f20552f = r1;
            super(1);
        }

        public final void a(H r2) {
            kotlin.s0.w.d.l0.p.f<H> r1 = this.f20552f;
            kotlin.n0.d.o.e(r2, "it");
            r1.add(r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Object r1) {
            a(r1);
            return f0.f18324a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <H> Collection<H> a(Collection<? extends H> r8, kotlin.n0.c.l<? super H, ? extends kotlin.s0.w.d.l0.c.a> r9) {
        kotlin.n0.d.o.f(r8, "<this>");
        kotlin.n0.d.o.f(r9, "descriptorByHandle");
        if (r8.size() > 1) goto L5;
        return r8;
    L5:
        LinkedList r0 = new LinkedList(r8);
        kotlin.s0.w.d.l0.p.f r10 = kotlin.s0.w.d.l0.p.f.f21288h.a();
    L7:
        if ((!r0.isEmpty()) == false) goto L23;
        Object r2 = r.P(r0);
        kotlin.s0.w.d.l0.p.f r3 = kotlin.s0.w.d.l0.p.f.f21288h.a();
        Collection r4 = j.p(r2, r0, r9, new a(r3));
        kotlin.n0.d.o.e(r4, "val conflictedHandles = …nflictedHandles.add(it) }");
        if (r4.size() != 1) goto L13;
        if (r3.isEmpty() == false) goto L13;
        Object r5 = r.n0(r4);
        kotlin.n0.d.o.e(r5, "overridableGroup.single()");
        r10.add(r5);
    L13:
        a.b.a.a.d.a r6 = (Object) j.L(r4, r9);
        kotlin.n0.d.o.e(r6, "selectMostSpecificMember…roup, descriptorByHandle)");
        kotlin.s0.w.d.l0.c.a r7 = r9.invoke(r6);
        Iterator r11 = r4.iterator();
    L15:
        if (r11.hasNext() == false) goto L20;
        a.b.a.a.d.a r12 = (Object) r11.next();
        kotlin.n0.d.o.e(r12, "it");
        if (j.B(r7, r9.invoke(r12)) == true) goto L15;
        r3.add(r12);
        goto L15
    L20:
        if ((!r3.isEmpty()) == false) goto L22;
        r10.addAll(r3);
    L22:
        r10.add(r6);
        goto L7
    L23:
        return r10;
    }
}
