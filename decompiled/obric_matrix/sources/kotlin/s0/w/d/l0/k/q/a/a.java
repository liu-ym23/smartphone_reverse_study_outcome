package kotlin.s0.w.d.l0.k.q.a;

import java.util.List;
import kotlin.i0.r;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.k.w.h;
import kotlin.s0.w.d.l0.n.a1;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.e1;
import kotlin.s0.w.d.l0.n.g1;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.q1;
import kotlin.s0.w.d.l0.n.u1.k;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends m0 implements kotlin.s0.w.d.l0.n.w1.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final g1 f20554g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final b f20555h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f20556i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final a1 f20557j;

    public a(g1 r2, b r3, boolean r4, a1 r5) {
        o.f(r2, "typeProjection");
        o.f(r3, "constructor");
        o.f(r5, "attributes");
        this.f20554g = r2;
        this.f20555h = r3;
        this.f20556i = r4;
        this.f20557j = r5;
    }

    public /* synthetic */ a(g1 r1, b r2, boolean r3, a1 r4, int r5, g r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = new c(r1);
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = false;
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = a1.f20943g.h();
    L11:
        this(r1, r2, r3, r4);
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public List<g1> M0() {
        return r.g();
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public a1 N0() {
        return this.f20557j;
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public /* bridge */ /* synthetic */ e1 O0() {
        return X0();
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public boolean P0() {
        return this.f20556i;
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public /* bridge */ /* synthetic */ e0 Q0(kotlin.s0.w.d.l0.n.t1.g r1) {
        return Z0(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.m0, kotlin.s0.w.d.l0.n.q1
    public /* bridge */ /* synthetic */ q1 S0(boolean r1) {
        return Y0(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.q1
    public /* bridge */ /* synthetic */ q1 T0(kotlin.s0.w.d.l0.n.t1.g r1) {
        return Z0(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.m0
    public /* bridge */ /* synthetic */ m0 V0(boolean r1) {
        return Y0(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.m0
    public m0 W0(a1 r4) {
        o.f(r4, "newAttributes");
        return new a(this.f20554g, X0(), P0(), r4);
    }

    public b X0() {
        return this.f20555h;
    }

    public a Y0(boolean r4) {
        if (r4 != P0()) goto L6;
        return this;
    L6:
        return new a(this.f20554g, X0(), r4, N0());
    }

    public a Z0(kotlin.s0.w.d.l0.n.t1.g r4) {
        o.f(r4, "kotlinTypeRefiner");
        g1 r5 = this.f20554g.c(r4);
        o.e(r5, "typeProjection.refine(kotlinTypeRefiner)");
        return new a(r5, X0(), P0(), N0());
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public h q() {
        return k.a(kotlin.s0.w.d.l0.n.u1.g.f21141g, true, new String[0]);
    }

    @Override // kotlin.s0.w.d.l0.n.m0
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("Captured(");
        r0.append(this.f20554g);
        r0.append(')');
        if (P0() == false) goto L5;
        String r2 = "?";
    L6:
        r0.append(r2);
        return r0.toString();
    L5:
        r2 = "";
        goto L6
    }
}
