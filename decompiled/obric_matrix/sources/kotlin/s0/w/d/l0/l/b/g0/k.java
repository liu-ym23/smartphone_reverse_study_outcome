package kotlin.s0.w.d.l0.l.b.g0;

import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.q1.g0;
import kotlin.s0.w.d.l0.c.q1.p;
import kotlin.s0.w.d.l0.c.y;
import kotlin.s0.w.d.l0.c.z0;
import kotlin.s0.w.d.l0.i.q;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends g0 implements b {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.f.i f20818J;
    private final kotlin.s0.w.d.l0.f.z.c K;
    private final kotlin.s0.w.d.l0.f.z.g L;
    private final kotlin.s0.w.d.l0.f.z.h M;
    private final f N;

    public k(kotlin.s0.w.d.l0.c.m r13, z0 r14, kotlin.s0.w.d.l0.c.o1.g r15, kotlin.s0.w.d.l0.g.f r16, kotlin.s0.w.d.l0.c.b.a r17, kotlin.s0.w.d.l0.f.i r18, kotlin.s0.w.d.l0.f.z.c r19, kotlin.s0.w.d.l0.f.z.g r20, kotlin.s0.w.d.l0.f.z.h r21, f r22, a1 r23) {
        o.f(r13, "containingDeclaration");
        o.f(r15, "annotations");
        o.f(r16, "name");
        o.f(r17, "kind");
        o.f(r18, "proto");
        o.f(r19, "nameResolver");
        o.f(r20, "typeTable");
        o.f(r21, "versionRequirementTable");
        if (r23 != null) goto L5;
        a1 r6 = a1.f18847a;
    L6:
        super(r13, r14, r15, r16, r17, r6);
        this.f20818J = r18;
        this.K = r19;
        this.L = r20;
        this.M = r21;
        this.N = r22;
        return;
    L5:
        r6 = r23;
        goto L6
    }

    public /* synthetic */ k(kotlin.s0.w.d.l0.c.m r14, z0 r15, kotlin.s0.w.d.l0.c.o1.g r16, kotlin.s0.w.d.l0.g.f r17, kotlin.s0.w.d.l0.c.b.a r18, kotlin.s0.w.d.l0.f.i r19, kotlin.s0.w.d.l0.f.z.c r20, kotlin.s0.w.d.l0.f.z.g r21, kotlin.s0.w.d.l0.f.z.h r22, f r23, a1 r24, int r25, kotlin.n0.d.g r26) {
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
        return q1();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.g0, kotlin.s0.w.d.l0.c.q1.p
    protected p M0(kotlin.s0.w.d.l0.c.m r14, y r15, kotlin.s0.w.d.l0.c.b.a r16, kotlin.s0.w.d.l0.g.f r17, kotlin.s0.w.d.l0.c.o1.g r18, a1 r19) {
        o.f(r14, "newOwner");
        o.f(r16, "kind");
        o.f(r18, "annotations");
        o.f(r19, "source");
        z0 r3 = (z0) r15;
        if (r17 != null) goto L5;
        kotlin.s0.w.d.l0.g.f r1 = getName();
        o.e(r1, "name");
        kotlin.s0.w.d.l0.g.f r5 = r1;
    L6:
        k r0 = new k(r14, r3, r18, r5, r16, q1(), Z(), S(), r1(), c0(), r19);
        r0.Z0(R0());
        return r0;
    L5:
        r5 = r17;
        goto L6
    }

    @Override // kotlin.s0.w.d.l0.l.b.g0.g
    public kotlin.s0.w.d.l0.f.z.g S() {
        return this.L;
    }

    @Override // kotlin.s0.w.d.l0.l.b.g0.g
    public kotlin.s0.w.d.l0.f.z.c Z() {
        return this.K;
    }

    @Override // kotlin.s0.w.d.l0.l.b.g0.g
    public f c0() {
        return this.N;
    }

    public kotlin.s0.w.d.l0.f.i q1() {
        return this.f20818J;
    }

    public kotlin.s0.w.d.l0.f.z.h r1() {
        return this.M;
    }
}
