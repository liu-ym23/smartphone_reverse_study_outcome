package kotlin.s0.w.d.l0.c.q1;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.t0;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.v0;

/* JADX INFO: loaded from: classes2.dex */
public class d0 extends b0 implements v0 {
    private kotlin.s0.w.d.l0.n.e0 r;
    private final v0 s;

    /* JADX WARN: Multi-variable type inference failed */
    public d0(u0 r13, kotlin.s0.w.d.l0.c.o1.g r14, kotlin.s0.w.d.l0.c.e0 r15, kotlin.s0.w.d.l0.c.u r16, boolean r17, boolean r18, boolean r19, kotlin.s0.w.d.l0.c.b.a r20, v0 r21, a1 r22) {
        if (r13 == null) goto L25;
        if (r14 == null) goto L23;
        if (r15 == null) goto L21;
        if (r16 == null) goto L19;
        if (r20 == null) goto L17;
        if (r22 == null) goto L15;
        super(r15, r16, r13, r14, kotlin.s0.w.d.l0.g.f.n("<get-" + r13.getName() + ">"), r17, r18, r19, r20, r22);
        if (r21 == null) goto L12;
        d0 r1 = this;
        v0 r0 = r21;
    L13:
        r1.s = r0;
        return;
    L12:
        r0 = this;
        r1 = r0;
        goto L13
    L15:
        F(5);
        throw null;
    L17:
        F(4);
        throw null;
    L19:
        F(3);
        throw null;
    L21:
        F(2);
        throw null;
    L23:
        F(1);
        throw null;
    L25:
        F(0);
        throw null;
    }

    private static /* synthetic */ void F(int r9) {
        if (r9 == 6) goto L7;
        if (r9 == 7) goto L7;
        if (r9 == 8) goto L7;
        String r3 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r9 == 6) goto L13;
        if (r9 == 7) goto L13;
        if (r9 == 8) goto L13;
        int r5 = 3;
    L14:
        Object[] r6 = new Object[r5];
        switch(r9) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L17;
            case 8: goto L17;
            default: goto L16;
        };
    L16:
        r6[0] = "correspondingProperty";
    L24:
        if (r9 == 6) goto L30;
        if (r9 == 7) goto L29;
        if (r9 == 8) goto L28;
        r6[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
    L31:
        if (r9 == 6) goto L35;
        if (r9 == 7) goto L35;
        if (r9 == 8) goto L35;
        r6[2] = "<init>";
    L35:
        String r4 = String.format(r3, r6);
        if (r9 == 6) goto L41;
        if (r9 == 7) goto L41;
        if (r9 == 8) goto L41;
        throw new IllegalArgumentException(r4);
    L41:
        throw new IllegalStateException(r4);
    L28:
        r6[1] = "getOriginal";
        goto L31
    L29:
        r6[1] = "getValueParameters";
        goto L31
    L30:
        r6[1] = "getOverriddenDescriptors";
        goto L31
    L17:
        r6[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
        goto L24
    L18:
        r6[0] = "source";
        goto L24
    L19:
        r6[0] = "kind";
        goto L24
    L20:
        r6[0] = "visibility";
        goto L24
    L21:
        r6[0] = "modality";
        goto L24
    L22:
        r6[0] = "annotations";
    L13:
        r5 = 2;
    L7:
        r3 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    @Override // kotlin.s0.w.d.l0.c.q1.b0, kotlin.s0.w.d.l0.c.q1.k
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.p A0() {
        return Q0();
    }

    @Override // kotlin.s0.w.d.l0.c.m
    public <R, D> R K(kotlin.s0.w.d.l0.c.o<R, D> r1, D r2) {
        return r1.b(this, r2);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.b0
    public /* bridge */ /* synthetic */ t0 L0() {
        return Q0();
    }

    public v0 Q0() {
        v0 r0 = this.s;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(8);
        throw null;
    }

    public void R0(kotlin.s0.w.d.l0.n.e0 r1) {
        if (r1 != null) goto L4;
        r1 = B0().b();
    L4:
        this.r = r1;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.b0, kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.a a() {
        return Q0();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.b0, kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.b a() {
        return Q0();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.b0, kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.m a() {
        return Q0();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.b0, kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y a() {
        return Q0();
    }

    @Override // kotlin.s0.w.d.l0.c.y, kotlin.s0.w.d.l0.c.b, kotlin.s0.w.d.l0.c.a
    public Collection<? extends v0> f() {
        Collection<t0> r1 = super.M0(true);
        if (r1 == null) goto L5;
        return r1;
    L5:
        F(6);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public kotlin.s0.w.d.l0.n.e0 getReturnType() {
        return this.r;
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public List<j1> h() {
        List<j1> r0 = Collections.emptyList();
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(7);
        throw null;
    }
}
