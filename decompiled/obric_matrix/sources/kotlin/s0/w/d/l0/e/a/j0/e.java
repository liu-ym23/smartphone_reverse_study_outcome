package kotlin.s0.w.d.l0.e.a.j0;

import java.util.Map;
import kotlin.a0;
import kotlin.i0.m0;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;
import kotlin.s0.w.d.l0.k.r.v;
import kotlin.s0.w.d.l0.m.m;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final /* synthetic */ l<Object>[] f19314h = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i f19315g;

    static final class a extends q implements kotlin.n0.c.a<Map<kotlin.s0.w.d.l0.g.f, ? extends v>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f19316f = null;

        static {
            f19316f = new a();
        }

        a() {
            super(0);
        }

        public final Map<kotlin.s0.w.d.l0.g.f, v> a() {
            return m0.e(a0.a(c.f19305a.b(), new v("Deprecated in Java")));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Map<kotlin.s0.w.d.l0.g.f, ? extends v> invoke() {
            return a();
        }
    }

    static {
        f19314h = new l[]{e0.g(new y(e0.b(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    }

    public e(kotlin.s0.w.d.l0.e.a.n0.a r2, kotlin.s0.w.d.l0.e.a.l0.g r3) {
        o.f(r3, "c");
        super(r3, r2, kotlin.s0.w.d.l0.b.k.a.n);
        this.f19315g = r3.e().d(a.f19316f);
    }

    @Override // kotlin.s0.w.d.l0.e.a.j0.b, kotlin.s0.w.d.l0.c.o1.c
    public Map<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.k.r.g<?>> a() {
        return (Map) m.a(this.f19315g, this, f19314h[0]);
    }
}
