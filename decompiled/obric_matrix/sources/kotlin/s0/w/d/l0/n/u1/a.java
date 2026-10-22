package kotlin.s0.w.d.l0.n.u1;

import java.util.List;
import kotlin.i0.r;
import kotlin.i0.t0;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.e0;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.c.n;
import kotlin.s0.w.d.l0.c.t;
import kotlin.s0.w.d.l0.n.j1;
import kotlin.s0.w.d.l0.n.l1;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends kotlin.s0.w.d.l0.c.q1.h {
    public a(kotlin.s0.w.d.l0.g.f r21) {
        o.f(r21, "name");
        k r10 = k.f21165a;
        h0 r1 = r10.i();
        e0 r3 = e0.f18862i;
        kotlin.s0.w.d.l0.c.f r4 = kotlin.s0.w.d.l0.c.f.f18865f;
        List r5 = r.g();
        a1 r11 = a1.f18847a;
        super(r1, r21, r3, r4, r5, r11, false, kotlin.s0.w.d.l0.m.f.f20912e);
        kotlin.s0.w.d.l0.c.q1.f r0 = kotlin.s0.w.d.l0.c.q1.f.o1(this, kotlin.s0.w.d.l0.c.o1.g.f18919b.b(), true, r11);
        r0.r1(r.g(), t.f19162d);
        o.e(r0, "create(this, Annotations…          )\n            }");
        g r2 = g.o;
        String r6 = r0.getName().toString();
        o.e(r6, "errorConstructor.name.toString()");
        kotlin.s0.w.d.l0.k.w.h r7 = k.b(r2, new String[]{r6, ""});
        j r14 = j.y0;
        r0.h1(new h(r10.e(r14, new String[0]), r7, r14, null, false, new String[0], 24, null));
        L0(r7, t0.a(r0), r0);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.a, kotlin.s0.w.d.l0.c.q1.t
    public kotlin.s0.w.d.l0.k.w.h F(j1 r3, kotlin.s0.w.d.l0.n.t1.g r4) {
        o.f(r3, "typeSubstitution");
        o.f(r4, "kotlinTypeRefiner");
        g r5 = g.o;
        String r2 = getName().toString();
        o.e(r2, "name.toString()");
        return k.b(r5, new String[]{r2, r3.toString()});
    }

    @Override // kotlin.s0.w.d.l0.c.q1.a
    public kotlin.s0.w.d.l0.c.e F0(l1 r2) {
        o.f(r2, "substitutor");
        return this;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.a, kotlin.s0.w.d.l0.c.c1
    public /* bridge */ /* synthetic */ n d(l1 r1) {
        F0(r1);
        return this;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.h
    public String toString() {
        String r1 = getName().b();
        o.e(r1, "name.asString()");
        return r1;
    }
}
