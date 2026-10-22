package kotlin.s0.w.d.l0.e.a.l0.l;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.e.a.n0.y;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.f0;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends kotlin.s0.w.d.l0.c.q1.b {
    private final kotlin.s0.w.d.l0.e.a.l0.g p;
    private final y q;

    public m(kotlin.s0.w.d.l0.e.a.l0.g r12, y r13, int r14, kotlin.s0.w.d.l0.c.m r15) {
        o.f(r12, "c");
        o.f(r13, "javaTypeParameter");
        o.f(r15, "containingDeclaration");
        super(r12.e(), r15, new kotlin.s0.w.d.l0.e.a.l0.d(r12, r13, false, 4, null), r13.getName(), r1.f21065h, false, r14, a1.f18847a, r12.a().v());
        this.p = r12;
        this.q = r13;
    }

    private final List<e0> N0() {
        Collection<kotlin.s0.w.d.l0.e.a.n0.j> r0 = this.q.getUpperBounds();
        if (r0.isEmpty() == false) goto L6;
        m0 r1 = this.p.d().o().i();
        o.e(r1, "c.module.builtIns.anyType");
        m0 r8 = this.p.d().o().I();
        o.e(r8, "c.module.builtIns.nullableAnyType");
        return r.d(f0.d(r1, r8));
    L6:
        ArrayList r2 = new ArrayList(r.q(r0, 10));
        Iterator<T> r3 = r0.iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        kotlin.s0.w.d.l0.e.a.n0.j r4 = (kotlin.s0.w.d.l0.e.a.n0.j) r3.next();
        r2.add(this.p.g().o(r4, kotlin.s0.w.d.l0.e.a.l0.m.d.d(kotlin.s0.w.d.l0.e.a.j0.k.f19333g, false, this, 1, null)));
        goto L8
    L10:
        return r2;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.e
    protected List<e0> F0(List<? extends e0> r3) {
        o.f(r3, "bounds");
        return this.p.a().r().i(this, r3, this.p);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.e
    protected void L0(e0 r1) {
        o.f(r1, WsConstants.KEY_CONNECTION_TYPE);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.e
    protected List<e0> M0() {
        return N0();
    }
}
