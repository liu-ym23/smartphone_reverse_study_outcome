package kotlin.s0.w.d.l0.c.q1;

import java.util.Collections;
import java.util.List;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.k1;
import kotlin.s0.w.d.l0.c.x0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m0 extends k implements k1 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected kotlin.s0.w.d.l0.n.e0 f19013j;

    static {
    }

    public m0(kotlin.s0.w.d.l0.c.m r2, kotlin.s0.w.d.l0.c.o1.g r3, kotlin.s0.w.d.l0.g.f r4, kotlin.s0.w.d.l0.n.e0 r5, a1 r6) {
        if (r2 == null) goto L15;
        if (r3 == null) goto L13;
        if (r4 == null) goto L11;
        if (r6 == null) goto L9;
        super(r2, r3, r4, r6);
        this.f19013j = r5;
        return;
    L9:
        F(3);
        throw null;
    L11:
        F(2);
        throw null;
    L13:
        F(1);
        throw null;
    L15:
        F(0);
        throw null;
    }

    private static /* synthetic */ void F(int r6) {
        switch(r6) {
            case 4: goto L4;
            case 5: goto L4;
            case 6: goto L4;
            case 7: goto L4;
            case 8: goto L4;
            case 9: goto L4;
            case 10: goto L4;
            default: goto L3;
        };
    L3:
        String r0 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r6) {
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L8;
            case 9: goto L8;
            case 10: goto L8;
            default: goto L7;
        };
    L7:
        int r2 = 3;
    L9:
        Object[] r3 = new Object[r2];
        switch(r6) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L12;
            case 7: goto L12;
            case 8: goto L12;
            case 9: goto L12;
            case 10: goto L12;
            default: goto L11;
        };
    L11:
        r3[0] = "containingDeclaration";
    L17:
        switch(r6) {
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L20;
            case 10: goto L19;
            default: goto L18;
        };
    L18:
        r3[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
    L26:
        switch(r6) {
            case 4: goto L28;
            case 5: goto L28;
            case 6: goto L28;
            case 7: goto L28;
            case 8: goto L28;
            case 9: goto L28;
            case 10: goto L28;
            default: goto L27;
        };
    L27:
        r3[2] = "<init>";
    L28:
        String r1 = String.format(r0, r3);
        switch(r6) {
            case 4: goto L32;
            case 5: goto L32;
            case 6: goto L32;
            case 7: goto L32;
            case 8: goto L32;
            case 9: goto L32;
            case 10: goto L32;
            default: goto L33;
        };
    L33:
        throw new IllegalArgumentException(r1);
    L32:
        throw new IllegalStateException(r1);
    L19:
        r3[1] = "getReturnType";
        goto L26
    L20:
        r3[1] = "getContextReceiverParameters";
        goto L26
    L21:
        r3[1] = "getTypeParameters";
        goto L26
    L22:
        r3[1] = "getOverriddenDescriptors";
        goto L26
    L23:
        r3[1] = "getValueParameters";
        goto L26
    L24:
        r3[1] = "getOriginal";
        goto L26
    L25:
        r3[1] = "getType";
        goto L26
    L12:
        r3[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
        goto L17
    L13:
        r3[0] = "source";
        goto L17
    L14:
        r3[0] = "name";
        goto L17
    L15:
        r3[0] = "annotations";
        goto L17
    L8:
        r2 = 2;
        goto L9
    L4:
        r0 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public boolean E() {
        return false;
    }

    public void F0(kotlin.s0.w.d.l0.n.e0 r1) {
        this.f19013j = r1;
    }

    @Override // kotlin.s0.w.d.l0.c.i1
    public kotlin.s0.w.d.l0.n.e0 b() {
        kotlin.s0.w.d.l0.n.e0 r0 = this.f19013j;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(4);
        throw null;
    }

    public x0 f0() {
        return null;
    }

    public kotlin.s0.w.d.l0.n.e0 getReturnType() {
        kotlin.s0.w.d.l0.n.e0 r0 = b();
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(10);
        throw null;
    }

    public List<f1> getTypeParameters() {
        List<f1> r0 = Collections.emptyList();
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(8);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public List<j1> h() {
        List<j1> r0 = Collections.emptyList();
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(6);
        throw null;
    }

    public x0 m0() {
        return null;
    }
}
