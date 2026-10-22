package kotlin.s0.w.d.l0.e.a.j0;

import java.util.Map;
import kotlin.a0;
import kotlin.i0.m0;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;
import kotlin.s0.w.d.l0.m.m;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final /* synthetic */ l<Object>[] f19319h = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i f19320g;

    static final class a extends q implements kotlin.n0.c.a<Map<kotlin.s0.w.d.l0.g.f, ? extends kotlin.s0.w.d.l0.k.r.g<?>>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h f19321f;

        a(h r1) {
            this.f19321f = r1;
            super(0);
        }

        public final Map<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.k.r.g<?>> a() {
            kotlin.s0.w.d.l0.k.r.g<?> r1 = d.f19310a.a(this.f19321f.c());
            if (r1 == null) goto L5;
            Map<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.k.r.g<?>> r2 = m0.e(a0.a(c.f19305a.c(), r1));
        L6:
            if (r2 == null) goto L8;
            return r2;
        L8:
            return m0.h();
        L5:
            r2 = null;
            goto L6
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Map<kotlin.s0.w.d.l0.g.f, ? extends kotlin.s0.w.d.l0.k.r.g<?>> invoke() {
            return a();
        }
    }

    static {
        f19319h = new l[]{e0.g(new y(e0.b(h.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    }

    public h(kotlin.s0.w.d.l0.e.a.n0.a r2, kotlin.s0.w.d.l0.e.a.l0.g r3) {
        o.f(r2, "annotation");
        o.f(r3, "c");
        super(r3, r2, kotlin.s0.w.d.l0.b.k.a.x);
        this.f19320g = r3.e().d(new a(this));
    }

    @Override // kotlin.s0.w.d.l0.e.a.j0.b, kotlin.s0.w.d.l0.c.o1.c
    public Map<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.k.r.g<?>> a() {
        return (Map) m.a(this.f19320g, this, f19319h[0]);
    }
}
