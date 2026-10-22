package kotlin.s0.w.d.l0.c.o1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<g> f18928f;

    static final class a extends q implements kotlin.n0.c.l<g, c> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.g.c f18929f;

        a(kotlin.s0.w.d.l0.g.c r1) {
            this.f18929f = r1;
            super(1);
        }

        public final c a(g r2) {
            o.f(r2, "it");
            return r2.i(this.f18929f);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ c invoke(g r1) {
            return a(r1);
        }
    }

    static final class b extends q implements kotlin.n0.c.l<g, kotlin.t0.h<? extends c>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f18930f = null;

        static {
            f18930f = new b();
        }

        b() {
            super(1);
        }

        public final kotlin.t0.h<c> a(g r1) {
            o.f(r1, "it");
            return r.I(r1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.t0.h<? extends c> invoke(g r1) {
            return a(r1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(List<? extends g> r2) {
        o.f(r2, "delegates");
        this.f18928f = r2;
    }

    public k(g... r2) {
        o.f(r2, "delegates");
        this(kotlin.i0.i.e0(r2));
    }

    @Override // kotlin.s0.w.d.l0.c.o1.g
    public c i(kotlin.s0.w.d.l0.g.c r2) {
        o.f(r2, "fqName");
        return (c) kotlin.t0.k.q(kotlin.t0.k.u(r.I(this.f18928f), new a(r2)));
    }

    @Override // kotlin.s0.w.d.l0.c.o1.g
    public boolean isEmpty() {
        List<g> r2 = this.f18928f;
        if ((r2 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L18;
        if (((g) r3.next()).isEmpty() == true) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (r2.isEmpty() == false) goto L7;
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<c> iterator() {
        return kotlin.t0.k.r(r.I(this.f18928f), b.f18930f).iterator();
    }

    @Override // kotlin.s0.w.d.l0.c.o1.g
    public boolean k(kotlin.s0.w.d.l0.g.c r2) {
        o.f(r2, "fqName");
        Iterator r1 = r.I(this.f18928f).iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        if (((g) r1.next()).k(r2) == false) goto L4;
        return true;
    L8:
        return false;
    }
}
