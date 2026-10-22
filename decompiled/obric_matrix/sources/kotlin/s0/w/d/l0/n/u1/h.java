package kotlin.s0.w.d.l0.n.u1;

import java.util.Arrays;
import java.util.List;
import kotlin.i0.r;
import kotlin.n0.d.i0;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.n.a1;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.e1;
import kotlin.s0.w.d.l0.n.g1;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.q1;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends m0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final e1 f21148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.k.w.h f21149h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final j f21150i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List<g1> f21151j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f21152k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String[] f21153l;
    private final String m;

    /* JADX WARN: Multi-variable type inference failed */
    public h(e1 r2, kotlin.s0.w.d.l0.k.w.h r3, j r4, List<? extends g1> r5, boolean r6, String... r7) {
        o.f(r2, "constructor");
        o.f(r3, "memberScope");
        o.f(r4, "kind");
        o.f(r5, "arguments");
        o.f(r7, "formatParams");
        this.f21148g = r2;
        this.f21149h = r3;
        this.f21150i = r4;
        this.f21151j = r5;
        this.f21152k = r6;
        this.f21153l = r7;
        i0 r8 = i0.f18445a;
        String r9 = r4.b();
        Object[] r10 = Arrays.copyOf(r7, r7.length);
        String r11 = String.format(r9, Arrays.copyOf(r10, r10.length));
        o.e(r11, "format(format, *args)");
        this.m = r11;
    }

    public /* synthetic */ h(e1 r8, kotlin.s0.w.d.l0.k.w.h r9, j r10, List r11, boolean r12, String[] r13, int r14, kotlin.n0.d.g r15) {
        if ((r14 & 8) == 0) goto L5;
        r11 = r.g();
    L5:
        List r4 = r11;
        if ((r14 & 16) == 0) goto L8;
        r12 = false;
    L8:
        this(r8, r9, r10, r4, r12, r13);
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public List<g1> M0() {
        return this.f21151j;
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public a1 N0() {
        return a1.f20943g.h();
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public e1 O0() {
        return this.f21148g;
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public boolean P0() {
        return this.f21152k;
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public /* bridge */ /* synthetic */ e0 Q0(kotlin.s0.w.d.l0.n.t1.g r1) {
        Z0(r1);
        return this;
    }

    @Override // kotlin.s0.w.d.l0.n.q1
    public /* bridge */ /* synthetic */ q1 T0(kotlin.s0.w.d.l0.n.t1.g r1) {
        Z0(r1);
        return this;
    }

    @Override // kotlin.s0.w.d.l0.n.m0, kotlin.s0.w.d.l0.n.q1
    public /* bridge */ /* synthetic */ q1 U0(a1 r1) {
        W0(r1);
        return this;
    }

    @Override // kotlin.s0.w.d.l0.n.m0
    public m0 V0(boolean r9) {
        e1 r1 = O0();
        kotlin.s0.w.d.l0.k.w.h r2 = q();
        j r3 = this.f21150i;
        List<g1> r4 = M0();
        String[] r8 = this.f21153l;
        return new h(r1, r2, r3, r4, r9, (String[]) Arrays.copyOf(r8, r8.length));
    }

    @Override // kotlin.s0.w.d.l0.n.m0
    public m0 W0(a1 r2) {
        o.f(r2, "newAttributes");
        return this;
    }

    public final String X0() {
        return this.m;
    }

    public final j Y0() {
        return this.f21150i;
    }

    public h Z0(kotlin.s0.w.d.l0.n.t1.g r2) {
        o.f(r2, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public kotlin.s0.w.d.l0.k.w.h q() {
        return this.f21149h;
    }
}
