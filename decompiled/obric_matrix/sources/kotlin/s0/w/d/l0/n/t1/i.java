package kotlin.s0.w.d.l0.n.t1;

import java.util.List;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.n.a1;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.e1;
import kotlin.s0.w.d.l0.n.g1;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.q1;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends m0 implements kotlin.s0.w.d.l0.n.w1.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.n.w1.b f21082g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final j f21083h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final q1 f21084i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final a1 f21085j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f21086k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f21087l;

    public i(kotlin.s0.w.d.l0.n.w1.b r11, q1 r12, g1 r13, f1 r14) {
        kotlin.n0.d.o.f(r11, "captureStatus");
        kotlin.n0.d.o.f(r13, "projection");
        kotlin.n0.d.o.f(r14, "typeParameter");
        this(r11, new j(r13, null, null, r14, 6, null), r12, null, false, false, 56, null);
    }

    public i(kotlin.s0.w.d.l0.n.w1.b r2, j r3, q1 r4, a1 r5, boolean r6, boolean r7) {
        kotlin.n0.d.o.f(r2, "captureStatus");
        kotlin.n0.d.o.f(r3, "constructor");
        kotlin.n0.d.o.f(r5, "attributes");
        this.f21082g = r2;
        this.f21083h = r3;
        this.f21084i = r4;
        this.f21085j = r5;
        this.f21086k = r6;
        this.f21087l = r7;
    }

    public /* synthetic */ i(kotlin.s0.w.d.l0.n.w1.b r8, j r9, q1 r10, a1 r11, boolean r12, boolean r13, int r14, kotlin.n0.d.g r15) {
        if ((r14 & 8) == 0) goto L5;
        r11 = a1.f20943g.h();
    L5:
        a1 r4 = r11;
        if ((r14 & 16) == 0) goto L8;
        boolean r5 = false;
    L10:
        if ((r14 & 32) == 0) goto L12;
        boolean r6 = false;
    L13:
        this(r8, r9, r10, r4, r5, r6);
        return;
    L12:
        r6 = r13;
        goto L13
    L8:
        r5 = r12;
        goto L10
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public List<g1> M0() {
        return kotlin.i0.r.g();
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public a1 N0() {
        return this.f21085j;
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public /* bridge */ /* synthetic */ e1 O0() {
        return Y0();
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public boolean P0() {
        return this.f21086k;
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public /* bridge */ /* synthetic */ e0 Q0(g r1) {
        return c1(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.m0, kotlin.s0.w.d.l0.n.q1
    public /* bridge */ /* synthetic */ q1 S0(boolean r1) {
        return b1(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.q1
    public /* bridge */ /* synthetic */ q1 T0(g r1) {
        return c1(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.m0
    public /* bridge */ /* synthetic */ m0 V0(boolean r1) {
        return b1(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.m0
    public m0 W0(a1 r9) {
        kotlin.n0.d.o.f(r9, "newAttributes");
        return new i(this.f21082g, Y0(), this.f21084i, r9, P0(), this.f21087l);
    }

    public final kotlin.s0.w.d.l0.n.w1.b X0() {
        return this.f21082g;
    }

    public j Y0() {
        return this.f21083h;
    }

    public final q1 Z0() {
        return this.f21084i;
    }

    public final boolean a1() {
        return this.f21087l;
    }

    public i b1(boolean r11) {
        return new i(this.f21082g, Y0(), this.f21084i, N0(), r11, false, 32, null);
    }

    public i c1(g r11) {
        kotlin.n0.d.o.f(r11, "kotlinTypeRefiner");
        kotlin.s0.w.d.l0.n.w1.b r2 = this.f21082g;
        j r3 = Y0().k(r11);
        q1 r0 = this.f21084i;
        if (r0 == null) goto L5;
        q1 r12 = r11.h(r0).R0();
    L7:
        return new i(r2, r3, r12, N0(), P0(), false, 32, null);
    L5:
        r12 = null;
        goto L7
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public kotlin.s0.w.d.l0.k.w.h q() {
        return kotlin.s0.w.d.l0.n.u1.k.a(kotlin.s0.w.d.l0.n.u1.g.f21141g, true, new String[0]);
    }
}
