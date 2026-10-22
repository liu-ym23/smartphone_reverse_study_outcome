package kotlin.s0.w.d.l0.l.b.g0;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.d1;
import kotlin.s0.w.d.l0.f.s;
import kotlin.s0.w.d.l0.l.b.a0;
import kotlin.s0.w.d.l0.l.b.d0;
import kotlin.s0.w.d.l0.l.b.x;
import kotlin.s0.w.d.l0.n.e0;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends kotlin.s0.w.d.l0.c.q1.b {
    private final kotlin.s0.w.d.l0.l.b.m p;
    private final s q;
    private final kotlin.s0.w.d.l0.l.b.g0.a r;

    static final class a extends q implements kotlin.n0.c.a<List<? extends kotlin.s0.w.d.l0.c.o1.c>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ m f20819f;

        a(m r1) {
            this.f20819f = r1;
            super(0);
        }

        public final List<kotlin.s0.w.d.l0.c.o1.c> a() {
            return r.z0(m.N0(this.f20819f).c().d().a(this.f20819f.P0(), m.N0(this.f20819f).g()));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<? extends kotlin.s0.w.d.l0.c.o1.c> invoke() {
            return a();
        }
    }

    public m(kotlin.s0.w.d.l0.l.b.m r12, s r13, int r14) {
        o.f(r12, "c");
        o.f(r13, "proto");
        kotlin.s0.w.d.l0.m.n r2 = r12.h();
        kotlin.s0.w.d.l0.c.m r3 = r12.e();
        kotlin.s0.w.d.l0.c.o1.g r4 = kotlin.s0.w.d.l0.c.o1.g.f18919b.b();
        kotlin.s0.w.d.l0.g.f r5 = x.b(r12.g(), r13.N());
        a0 r0 = a0.f20690a;
        s.c r1 = r13.T();
        o.e(r1, "proto.variance");
        super(r2, r3, r4, r5, r0.d(r1), r13.O(), r14, a1.f18847a, d1.a.f18858a);
        this.p = r12;
        this.q = r13;
        this.r = new kotlin.s0.w.d.l0.l.b.g0.a(r12.h(), new a(this));
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.l.b.m N0(m r0) {
        return r0.p;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.e
    public /* bridge */ /* synthetic */ void L0(e0 r1) {
        Q0(r1);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.e
    protected List<e0> M0() {
        List<kotlin.s0.w.d.l0.f.q> r0 = kotlin.s0.w.d.l0.f.z.f.p(this.q, this.p.j());
        if (r0.isEmpty() == true) goto L5;
        d0 r3 = this.p.i();
        ArrayList r1 = new ArrayList(r.q(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r1.add(r3.q((kotlin.s0.w.d.l0.f.q) r2.next()));
        goto L8
    L10:
        return r1;
    L5:
        return r.d(kotlin.s0.w.d.l0.k.t.a.f(this).y());
    }

    public kotlin.s0.w.d.l0.l.b.g0.a O0() {
        return this.r;
    }

    public final s P0() {
        return this.q;
    }

    protected Void Q0(e0 r3) {
        o.f(r3, WsConstants.KEY_CONNECTION_TYPE);
        throw new IllegalStateException("There should be no cycles for deserialized type parameters, but found for: " + this);
    }

    @Override // kotlin.s0.w.d.l0.c.o1.b, kotlin.s0.w.d.l0.c.o1.a
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.o1.g getAnnotations() {
        return O0();
    }
}
