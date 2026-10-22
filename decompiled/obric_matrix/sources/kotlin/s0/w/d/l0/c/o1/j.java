package kotlin.s0.w.d.l0.c.o1;

import java.util.Map;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.b.h f18923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.g.c f18924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.k.r.g<?>> f18925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.h f18926d;

    static final class a extends q implements kotlin.n0.c.a<m0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f18927f;

        a(j r1) {
            this.f18927f = r1;
            super(0);
        }

        public final m0 a() {
            return j.c(this.f18927f).o(this.f18927f.e()).s();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ m0 invoke() {
            return a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(kotlin.s0.w.d.l0.b.h r2, kotlin.s0.w.d.l0.g.c r3, Map<kotlin.s0.w.d.l0.g.f, ? extends kotlin.s0.w.d.l0.k.r.g<?>> r4) {
        o.f(r2, "builtIns");
        o.f(r3, "fqName");
        o.f(r4, "allValueArguments");
        this.f18923a = r2;
        this.f18924b = r3;
        this.f18925c = r4;
        this.f18926d = kotlin.i.a(kotlin.l.f18418g, new a(this));
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.b.h c(j r0) {
        return r0.f18923a;
    }

    @Override // kotlin.s0.w.d.l0.c.o1.c
    public Map<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.k.r.g<?>> a() {
        return this.f18925c;
    }

    @Override // kotlin.s0.w.d.l0.c.o1.c
    public e0 b() {
        Object r1 = this.f18926d.getValue();
        o.e(r1, "<get-type>(...)");
        return (e0) r1;
    }

    @Override // kotlin.s0.w.d.l0.c.o1.c
    public kotlin.s0.w.d.l0.g.c e() {
        return this.f18924b;
    }

    @Override // kotlin.s0.w.d.l0.c.o1.c
    public a1 getSource() {
        a1 r1 = a1.f18847a;
        o.e(r1, "NO_SOURCE");
        return r1;
    }
}
