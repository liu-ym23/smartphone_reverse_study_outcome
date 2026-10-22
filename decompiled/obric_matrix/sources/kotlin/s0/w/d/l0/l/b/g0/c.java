package kotlin.s0.w.d.l0.l.b.g0;

import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.q1.p;
import kotlin.s0.w.d.l0.c.y;
import kotlin.s0.w.d.l0.i.q;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends kotlin.s0.w.d.l0.c.q1.f implements b {
    private final kotlin.s0.w.d.l0.f.d K;
    private final kotlin.s0.w.d.l0.f.z.c L;
    private final kotlin.s0.w.d.l0.f.z.g M;
    private final kotlin.s0.w.d.l0.f.z.h N;
    private final f O;

    public c(kotlin.s0.w.d.l0.c.e r13, kotlin.s0.w.d.l0.c.l r14, kotlin.s0.w.d.l0.c.o1.g r15, boolean r16, kotlin.s0.w.d.l0.c.b.a r17, kotlin.s0.w.d.l0.f.d r18, kotlin.s0.w.d.l0.f.z.c r19, kotlin.s0.w.d.l0.f.z.g r20, kotlin.s0.w.d.l0.f.z.h r21, f r22, a1 r23) {
        o.f(r13, "containingDeclaration");
        o.f(r15, "annotations");
        o.f(r17, "kind");
        o.f(r18, "proto");
        o.f(r19, "nameResolver");
        o.f(r20, "typeTable");
        o.f(r21, "versionRequirementTable");
        if (r23 != null) goto L5;
        a1 r6 = a1.f18847a;
    L6:
        super(r13, r14, r15, r16, r17, r6);
        this.K = r18;
        this.L = r19;
        this.M = r20;
        this.N = r21;
        this.O = r22;
        return;
    L5:
        r6 = r23;
        goto L6
    }

    public /* synthetic */ c(kotlin.s0.w.d.l0.c.e r14, kotlin.s0.w.d.l0.c.l r15, kotlin.s0.w.d.l0.c.o1.g r16, boolean r17, kotlin.s0.w.d.l0.c.b.a r18, kotlin.s0.w.d.l0.f.d r19, kotlin.s0.w.d.l0.f.z.c r20, kotlin.s0.w.d.l0.f.z.g r21, kotlin.s0.w.d.l0.f.z.h r22, f r23, a1 r24, int r25, kotlin.n0.d.g r26) {
        if ((r25 & 1024) == 0) goto L5;
        a1 r12 = null;
    L6:
        this(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r12);
        return;
    L5:
        r12 = r24;
        goto L6
    }

    @Override // kotlin.s0.w.d.l0.l.b.g0.g
    public /* bridge */ /* synthetic */ q C() {
        return u1();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.f, kotlin.s0.w.d.l0.c.q1.p
    public /* bridge */ /* synthetic */ p M0(kotlin.s0.w.d.l0.c.m r1, y r2, kotlin.s0.w.d.l0.c.b.a r3, kotlin.s0.w.d.l0.g.f r4, kotlin.s0.w.d.l0.c.o1.g r5, a1 r6) {
        return t1(r1, r2, r3, r4, r5, r6);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.y
    public boolean P() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.l.b.g0.g
    public kotlin.s0.w.d.l0.f.z.g S() {
        return this.M;
    }

    @Override // kotlin.s0.w.d.l0.l.b.g0.g
    public kotlin.s0.w.d.l0.f.z.c Z() {
        return this.L;
    }

    @Override // kotlin.s0.w.d.l0.l.b.g0.g
    public f c0() {
        return this.O;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.d0
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.y
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.p, kotlin.s0.w.d.l0.c.y
    public boolean isSuspend() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.f
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.q1.f p1(kotlin.s0.w.d.l0.c.m r1, y r2, kotlin.s0.w.d.l0.c.b.a r3, kotlin.s0.w.d.l0.g.f r4, kotlin.s0.w.d.l0.c.o1.g r5, a1 r6) {
        return t1(r1, r2, r3, r4, r5, r6);
    }

    protected c t1(kotlin.s0.w.d.l0.c.m r15, y r16, kotlin.s0.w.d.l0.c.b.a r17, kotlin.s0.w.d.l0.g.f r18, kotlin.s0.w.d.l0.c.o1.g r19, a1 r20) {
        o.f(r15, "newOwner");
        o.f(r17, "kind");
        o.f(r19, "annotations");
        o.f(r20, "source");
        c r1 = new c((kotlin.s0.w.d.l0.c.e) r15, (kotlin.s0.w.d.l0.c.l) r16, r19, this.f18995J, r17, u1(), Z(), S(), v1(), c0(), r20);
        r1.Z0(R0());
        return r1;
    }

    public kotlin.s0.w.d.l0.f.d u1() {
        return this.K;
    }

    public kotlin.s0.w.d.l0.f.z.h v1() {
        return this.N;
    }
}
