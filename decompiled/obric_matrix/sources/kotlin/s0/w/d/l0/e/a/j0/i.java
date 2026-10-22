package kotlin.s0.w.d.l0.e.a.j0;

import java.util.List;
import java.util.Map;
import kotlin.a0;
import kotlin.i0.m0;
import kotlin.i0.r;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;
import kotlin.s0.w.d.l0.e.a.n0.m;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final /* synthetic */ l<Object>[] f19322h = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i f19323g;

    static final class a extends q implements kotlin.n0.c.a<Map<kotlin.s0.w.d.l0.g.f, ? extends kotlin.s0.w.d.l0.k.r.g<? extends Object>>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ i f19324f;

        a(i r1) {
            this.f19324f = r1;
            super(0);
        }

        public final Map<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.k.r.g<Object>> a() {
            kotlin.s0.w.d.l0.e.a.n0.b r0 = this.f19324f.c();
            Map<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.k.r.g<Object>> r2 = null;
            if ((r0 instanceof kotlin.s0.w.d.l0.e.a.n0.e) == false) goto L7;
            d r1 = d.f19310a;
            List<kotlin.s0.w.d.l0.e.a.n0.b> r3 = ((kotlin.s0.w.d.l0.e.a.n0.e) this.f19324f.c()).e();
        L5:
            kotlin.s0.w.d.l0.k.r.g<?> r4 = r1.c(r3);
        L10:
            if (r4 == null) goto L12;
            r2 = m0.e(a0.a(c.f19305a.d(), r4));
        L12:
            if (r2 == null) goto L14;
            return r2;
        L14:
            return m0.h();
        L7:
            if ((r0 instanceof m) == false) goto L9;
            r1 = d.f19310a;
            r3 = r.d(this.f19324f.c());
            goto L5
        L9:
            r4 = null;
            goto L10
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Map<kotlin.s0.w.d.l0.g.f, ? extends kotlin.s0.w.d.l0.k.r.g<? extends Object>> invoke() {
            return a();
        }
    }

    static {
        f19322h = new l[]{e0.g(new y(e0.b(i.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    }

    public i(kotlin.s0.w.d.l0.e.a.n0.a r2, kotlin.s0.w.d.l0.e.a.l0.g r3) {
        o.f(r2, "annotation");
        o.f(r3, "c");
        super(r3, r2, kotlin.s0.w.d.l0.b.k.a.u);
        this.f19323g = r3.e().d(new a(this));
    }

    @Override // kotlin.s0.w.d.l0.e.a.j0.b, kotlin.s0.w.d.l0.c.o1.c
    public Map<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.k.r.g<Object>> a() {
        return (Map) kotlin.s0.w.d.l0.m.m.a(this.f19323g, this, f19322h[0]);
    }
}
