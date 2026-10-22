package kotlin.s0.w.d.l0.e.a;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class d0<T> implements c0<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<kotlin.s0.w.d.l0.g.c, T> f19246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.f f19247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.h<kotlin.s0.w.d.l0.g.c, T> f19248d;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.c, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d0<T> f19249f;

        a(d0<T> r1) {
            this.f19249f = r1;
            super(1);
        }

        public final T a(kotlin.s0.w.d.l0.g.c r2) {
            kotlin.n0.d.o.e(r2, "it");
            return (T) kotlin.s0.w.d.l0.g.e.a(r2, this.f19249f.b());
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Object invoke(kotlin.s0.w.d.l0.g.c r1) {
            return a(r1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d0(Map<kotlin.s0.w.d.l0.g.c, ? extends T> r2) {
        kotlin.n0.d.o.f(r2, "states");
        this.f19246b = r2;
        kotlin.s0.w.d.l0.m.f r3 = new kotlin.s0.w.d.l0.m.f("Java nullability annotation states");
        this.f19247c = r3;
        kotlin.s0.w.d.l0.m.h<kotlin.s0.w.d.l0.g.c, T> r4 = r3.i(new a(this));
        kotlin.n0.d.o.e(r4, "storageManager.createMem…cificFqname(states)\n    }");
        this.f19248d = r4;
    }

    @Override // kotlin.s0.w.d.l0.e.a.c0
    public T a(kotlin.s0.w.d.l0.g.c r2) {
        kotlin.n0.d.o.f(r2, "fqName");
        return this.f19248d.invoke(r2);
    }

    public final Map<kotlin.s0.w.d.l0.g.c, T> b() {
        return this.f19246b;
    }
}
