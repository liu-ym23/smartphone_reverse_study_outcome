package kotlin.s0.w.d.l0.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class n0 implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Collection<l0> f18897a;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<l0, kotlin.s0.w.d.l0.g.c> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f18898f = null;

        static {
            f18898f = new a();
        }

        a() {
            super(1);
        }

        public final kotlin.s0.w.d.l0.g.c a(l0 r1) {
            kotlin.n0.d.o.f(r1, "it");
            return r1.e();
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.g.c invoke(l0 r1) {
            return a(r1);
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.c, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.g.c f18899f;

        b(kotlin.s0.w.d.l0.g.c r1) {
            this.f18899f = r1;
            super(1);
        }

        public final Boolean a(kotlin.s0.w.d.l0.g.c r2) {
            kotlin.n0.d.o.f(r2, "it");
            if (r2.d() == false) goto L5;
        L7:
            boolean r1 = false;
        L9:
            return Boolean.valueOf(r1);
        L5:
            if (kotlin.n0.d.o.a(r2.e(), this.f18899f) == false) goto L7;
            r1 = true;
            goto L9
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(kotlin.s0.w.d.l0.g.c r1) {
            return a(r1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n0(Collection<? extends l0> r2) {
        kotlin.n0.d.o.f(r2, "packageFragments");
        this.f18897a = r2;
    }

    @Override // kotlin.s0.w.d.l0.c.m0
    public List<l0> a(kotlin.s0.w.d.l0.g.c r4) {
        kotlin.n0.d.o.f(r4, "fqName");
        Collection<l0> r3 = this.f18897a;
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r1 = r5.next();
        if (kotlin.n0.d.o.a(((l0) r1).e(), r4) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.s0.w.d.l0.c.p0
    public void b(kotlin.s0.w.d.l0.g.c r3, Collection<l0> r4) {
        kotlin.n0.d.o.f(r3, "fqName");
        kotlin.n0.d.o.f(r4, "packageFragments");
        Iterator<T> r2 = this.f18897a.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r0 = r2.next();
        if (kotlin.n0.d.o.a(((l0) r0).e(), r3) == false) goto L4;
        r4.add(r0);
        goto L4
    }

    @Override // kotlin.s0.w.d.l0.c.p0
    public boolean c(kotlin.s0.w.d.l0.g.c r3) {
        kotlin.n0.d.o.f(r3, "fqName");
        Collection<l0> r2 = this.f18897a;
        if ((r2 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L18;
        if (kotlin.n0.d.o.a(((l0) r4.next()).e(), r3) == false) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (r2.isEmpty() == false) goto L7;
        return true;
    }

    @Override // kotlin.s0.w.d.l0.c.m0
    public Collection<kotlin.s0.w.d.l0.g.c> p(kotlin.s0.w.d.l0.g.c r2, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r3) {
        kotlin.n0.d.o.f(r2, "fqName");
        kotlin.n0.d.o.f(r3, "nameFilter");
        return kotlin.t0.k.z(kotlin.t0.k.n(kotlin.t0.k.t(kotlin.i0.r.I(this.f18897a), a.f18898f), new b(r2)));
    }
}
