package kotlin.s0.w.d.l0.l.b.g0;

import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.e0;
import kotlin.s0.w.d.l0.c.q1.c0;
import kotlin.s0.w.d.l0.c.u;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.i.q;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends c0 implements b {
    private final kotlin.s0.w.d.l0.f.n H;
    private final kotlin.s0.w.d.l0.f.z.c I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.f.z.g f20817J;
    private final kotlin.s0.w.d.l0.f.z.h K;
    private final f L;

    public j(kotlin.s0.w.d.l0.c.m r18, u0 r19, kotlin.s0.w.d.l0.c.o1.g r20, e0 r21, u r22, boolean r23, kotlin.s0.w.d.l0.g.f r24, kotlin.s0.w.d.l0.c.b.a r25, boolean r26, boolean r27, boolean r28, boolean r29, boolean r30, kotlin.s0.w.d.l0.f.n r31, kotlin.s0.w.d.l0.f.z.c r32, kotlin.s0.w.d.l0.f.z.g r33, kotlin.s0.w.d.l0.f.z.h r34, f r35) {
        o.f(r18, "containingDeclaration");
        o.f(r20, "annotations");
        o.f(r21, "modality");
        o.f(r22, "visibility");
        o.f(r24, "name");
        o.f(r25, "kind");
        o.f(r31, "proto");
        o.f(r32, "nameResolver");
        o.f(r33, "typeTable");
        o.f(r34, "versionRequirementTable");
        super(r18, r19, r20, r21, r22, r23, r24, r25, a1.f18847a, r26, r27, r30, false, r28, r29);
        this.H = r31;
        this.I = r32;
        this.f20817J = r33;
        this.K = r34;
        this.L = r35;
    }

    @Override // kotlin.s0.w.d.l0.l.b.g0.g
    public /* bridge */ /* synthetic */ q C() {
        return g1();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.c0
    protected c0 Q0(kotlin.s0.w.d.l0.c.m r21, e0 r22, u r23, u0 r24, kotlin.s0.w.d.l0.c.b.a r25, kotlin.s0.w.d.l0.g.f r26, a1 r27) {
        o.f(r21, "newOwner");
        o.f(r22, "newModality");
        o.f(r23, "newVisibility");
        o.f(r25, "kind");
        o.f(r26, "newName");
        o.f(r27, "source");
        return new j(r21, r24, getAnnotations(), r22, r23, j0(), r26, r25, s0(), y(), isExternal(), O(), L(), g1(), Z(), S(), h1(), c0());
    }

    @Override // kotlin.s0.w.d.l0.l.b.g0.g
    public kotlin.s0.w.d.l0.f.z.g S() {
        return this.f20817J;
    }

    @Override // kotlin.s0.w.d.l0.l.b.g0.g
    public kotlin.s0.w.d.l0.f.z.c Z() {
        return this.I;
    }

    @Override // kotlin.s0.w.d.l0.l.b.g0.g
    public f c0() {
        return this.L;
    }

    public kotlin.s0.w.d.l0.f.n g1() {
        return this.H;
    }

    public kotlin.s0.w.d.l0.f.z.h h1() {
        return this.K;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.c0, kotlin.s0.w.d.l0.c.d0
    public boolean isExternal() {
        Boolean r1 = kotlin.s0.w.d.l0.f.z.b.D.g(g1().a0());
        o.e(r1, "IS_EXTERNAL_PROPERTY.get(proto.flags)");
        return r1.booleanValue();
    }
}
