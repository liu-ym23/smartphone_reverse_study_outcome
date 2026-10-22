package kotlin.s0.w.d.l0.n;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class t0 {

    public static final class a extends f1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<e1> f21075c;

        /* JADX WARN: Multi-variable type inference failed */
        a(List<? extends e1> r1) {
            this.f21075c = r1;
        }

        @Override // kotlin.s0.w.d.l0.n.f1
        public g1 k(e1 r2) {
            kotlin.n0.d.o.f(r2, "key");
            if (this.f21075c.contains(r2) == false) goto L5;
            kotlin.s0.w.d.l0.c.h r1 = r2.d();
            kotlin.n0.d.o.d(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
            return n1.s((kotlin.s0.w.d.l0.c.f1) r1);
        L5:
            return null;
        }
    }

    private static final e0 a(List<? extends e1> r1, List<? extends e0> r2, kotlin.s0.w.d.l0.b.h r3) {
        e0 r4 = l1.g(new a(r1)).p((e0) kotlin.i0.r.P(r2), r1.f21067j);
        if (r4 != null) goto L5;
        r4 = r3.y();
    L5:
        kotlin.n0.d.o.e(r4, "typeParameters: List<Typ… ?: builtIns.defaultBound");
        return r4;
    }

    public static final e0 b(kotlin.s0.w.d.l0.c.f1 r5) {
        kotlin.n0.d.o.f(r5, "<this>");
        kotlin.s0.w.d.l0.c.m r0 = r5.c();
        kotlin.n0.d.o.e(r0, "this.containingDeclaration");
        if ((r0 instanceof kotlin.s0.w.d.l0.c.i) == false) goto L10;
        List<kotlin.s0.w.d.l0.c.f1> r1 = ((kotlin.s0.w.d.l0.c.i) r0).k().getParameters();
        kotlin.n0.d.o.e(r1, "descriptor.typeConstructor.parameters");
        ArrayList r2 = new ArrayList(kotlin.i0.r.q(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        e1 r4 = ((kotlin.s0.w.d.l0.c.f1) r3.next()).k();
        kotlin.n0.d.o.e(r4, "it.typeConstructor");
        r2.add(r4);
    L8:
        List<e0> r6 = r5.getUpperBounds();
        kotlin.n0.d.o.e(r6, "upperBounds");
        return a(r2, r6, kotlin.s0.w.d.l0.k.t.a.f(r5));
    L10:
        if ((r0 instanceof kotlin.s0.w.d.l0.c.y) == false) goto L17;
        List<kotlin.s0.w.d.l0.c.f1> r7 = ((kotlin.s0.w.d.l0.c.y) r0).getTypeParameters();
        kotlin.n0.d.o.e(r7, "descriptor.typeParameters");
        r2 = new ArrayList(kotlin.i0.r.q(r7, 10));
        Iterator<T> r8 = r7.iterator();
    L13:
        if (r8.hasNext() == false) goto L8;
        e1 r9 = ((kotlin.s0.w.d.l0.c.f1) r8.next()).k();
        kotlin.n0.d.o.e(r9, "it.typeConstructor");
        r2.add(r9);
        goto L13
    L17:
        throw new IllegalArgumentException("Unsupported descriptor type to build star projection type based on type parameters of it");
    }
}
