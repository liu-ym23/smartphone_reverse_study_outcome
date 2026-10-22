package kotlin.s0.w.d.l0.c.q1;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.r0;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.n.l1;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends j implements x0 {
    public c(kotlin.s0.w.d.l0.c.o1.g r2) {
        if (r2 == null) goto L5;
        super(r2, kotlin.s0.w.d.l0.g.h.f20278e);
        return;
    L5:
        F(0);
        throw null;
    }

    private static /* synthetic */ void F(int r6) {
        switch(r6) {
            case 2: goto L4;
            case 3: goto L4;
            case 4: goto L4;
            case 5: goto L4;
            case 6: goto L4;
            case 7: goto L4;
            case 8: goto L4;
            case 9: goto L4;
            default: goto L3;
        };
    L3:
        String r0 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r6) {
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L8;
            case 9: goto L8;
            default: goto L7;
        };
    L7:
        int r2 = 3;
    L9:
        Object[] r3 = new Object[r2];
        switch(r6) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L12;
            case 7: goto L12;
            case 8: goto L12;
            case 9: goto L12;
            default: goto L11;
        };
    L11:
        r3[0] = "annotations";
    L15:
        switch(r6) {
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            default: goto L16;
        };
    L16:
        r3[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
    L25:
        switch(r6) {
            case 1: goto L27;
            case 2: goto L28;
            case 3: goto L28;
            case 4: goto L28;
            case 5: goto L28;
            case 6: goto L28;
            case 7: goto L28;
            case 8: goto L28;
            case 9: goto L28;
            default: goto L26;
        };
    L26:
        r3[2] = "<init>";
        goto L28
    L27:
        r3[2] = "substitute";
    L28:
        String r1 = String.format(r0, r3);
        switch(r6) {
            case 2: goto L32;
            case 3: goto L32;
            case 4: goto L32;
            case 5: goto L32;
            case 6: goto L32;
            case 7: goto L32;
            case 8: goto L32;
            case 9: goto L32;
            default: goto L33;
        };
    L33:
        throw new IllegalArgumentException(r1);
    L32:
        throw new IllegalStateException(r1);
    L17:
        r3[1] = "getSource";
        goto L25
    L18:
        r3[1] = "getOriginal";
        goto L25
    L19:
        r3[1] = "getVisibility";
        goto L25
    L20:
        r3[1] = "getOverriddenDescriptors";
        goto L25
    L21:
        r3[1] = "getValueParameters";
        goto L25
    L22:
        r3[1] = "getType";
        goto L25
    L23:
        r3[1] = "getTypeParameters";
        goto L25
    L24:
        r3[1] = "getContextReceiverParameters";
        goto L25
    L12:
        r3[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
        goto L15
    L13:
        r3[0] = "substitutor";
        goto L15
    L8:
        r2 = 2;
        goto L9
    L4:
        r0 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    public r0 A0() {
        return this;
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public boolean E() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.m
    public <R, D> R K(kotlin.s0.w.d.l0.c.o<R, D> r1, D r2) {
        return r1.l(this, r2);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.a a() {
        A0();
        return this;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.m a() {
        A0();
        return this;
    }

    @Override // kotlin.s0.w.d.l0.c.i1
    public kotlin.s0.w.d.l0.n.e0 b() {
        kotlin.s0.w.d.l0.n.e0 r0 = getValue().b();
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(4);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.c1
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.n d(l1 r1) {
        return d(r1);
    }

    @Override // kotlin.s0.w.d.l0.c.x0, kotlin.s0.w.d.l0.c.c1
    public x0 d(l1 r4) {
        if (r4 != null) goto L5;
        F(1);
        throw null;
    L5:
        if (r4.k() == false) goto L8;
        return this;
    L8:
        if ((c() instanceof kotlin.s0.w.d.l0.c.e) == false) goto L10;
        kotlin.s0.w.d.l0.n.e0 r1 = b();
        r1 r2 = r1.f21067j;
    L11:
        kotlin.s0.w.d.l0.n.e0 r5 = r4.p(r1, r2);
        if (r5 != null) goto L15;
        return null;
    L15:
        if (r5 != b()) goto L18;
        return this;
    L18:
        return new f0(c(), new kotlin.s0.w.d.l0.k.w.o.i(r5), getAnnotations());
    L10:
        r1 = b();
        r2 = r1.f21065h;
        goto L11
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public Collection<? extends kotlin.s0.w.d.l0.c.a> f() {
        Set r0 = Collections.emptySet();
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(6);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public x0 f0() {
        return null;
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public kotlin.s0.w.d.l0.n.e0 getReturnType() {
        return b();
    }

    @Override // kotlin.s0.w.d.l0.c.p
    public a1 getSource() {
        a1 r0 = a1.f18847a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(9);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public List<f1> getTypeParameters() {
        List<f1> r0 = Collections.emptyList();
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(3);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q, kotlin.s0.w.d.l0.c.d0
    public kotlin.s0.w.d.l0.c.u getVisibility() {
        kotlin.s0.w.d.l0.c.u r0 = kotlin.s0.w.d.l0.c.t.f19164f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(7);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public List<j1> h() {
        List<j1> r0 = Collections.emptyList();
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(5);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public x0 m0() {
        return null;
    }
}
