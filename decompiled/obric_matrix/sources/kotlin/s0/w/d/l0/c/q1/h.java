package kotlin.s0.w.d.l0.c.q1;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.h1;
import kotlin.s0.w.d.l0.n.e1;

/* JADX INFO: loaded from: classes2.dex */
public class h extends g {
    private final kotlin.s0.w.d.l0.c.e0 n;
    private final kotlin.s0.w.d.l0.c.f o;
    private final e1 p;
    private kotlin.s0.w.d.l0.k.w.h q;
    private Set<kotlin.s0.w.d.l0.c.d> r;
    private kotlin.s0.w.d.l0.c.d s;

    static {
    }

    public h(kotlin.s0.w.d.l0.c.m r7, kotlin.s0.w.d.l0.g.f r8, kotlin.s0.w.d.l0.c.e0 r9, kotlin.s0.w.d.l0.c.f r10, Collection<kotlin.s0.w.d.l0.n.e0> r11, a1 r12, boolean r13, kotlin.s0.w.d.l0.m.n r14) {
        if (r7 == null) goto L24;
        if (r8 == null) goto L22;
        if (r9 == null) goto L20;
        if (r10 == null) goto L18;
        if (r11 == null) goto L16;
        if (r12 == null) goto L14;
        if (r14 == null) goto L12;
        super(r14, r7, r8, r12, r13);
        this.n = r9;
        this.o = r10;
        this.p = new kotlin.s0.w.d.l0.n.l(this, Collections.emptyList(), r11, r14);
        return;
    L12:
        A0(6);
        throw null;
    L14:
        A0(5);
        throw null;
    L16:
        A0(4);
        throw null;
    L18:
        A0(3);
        throw null;
    L20:
        A0(2);
        throw null;
    L22:
        A0(1);
        throw null;
    L24:
        A0(0);
        throw null;
    }

    private static /* synthetic */ void A0(int r6) {
        switch(r6) {
            case 9: goto L4;
            case 10: goto L4;
            case 11: goto L4;
            case 12: goto L3;
            case 13: goto L4;
            case 14: goto L4;
            case 15: goto L4;
            case 16: goto L4;
            case 17: goto L4;
            case 18: goto L4;
            case 19: goto L4;
            default: goto L3;
        };
    L3:
        String r0 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r6) {
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L8;
            case 12: goto L7;
            case 13: goto L8;
            case 14: goto L8;
            case 15: goto L8;
            case 16: goto L8;
            case 17: goto L8;
            case 18: goto L8;
            case 19: goto L8;
            default: goto L7;
        };
    L7:
        int r2 = 3;
    L9:
        Object[] r3 = new Object[r2];
        switch(r6) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L13;
            case 11: goto L13;
            case 12: goto L12;
            case 13: goto L13;
            case 14: goto L13;
            case 15: goto L13;
            case 16: goto L13;
            case 17: goto L13;
            case 18: goto L13;
            case 19: goto L13;
            default: goto L11;
        };
    L11:
        r3[0] = "containingDeclaration";
    L23:
        switch(r6) {
            case 9: goto L34;
            case 10: goto L33;
            case 11: goto L32;
            case 12: goto L24;
            case 13: goto L31;
            case 14: goto L30;
            case 15: goto L29;
            case 16: goto L28;
            case 17: goto L27;
            case 18: goto L26;
            case 19: goto L25;
            default: goto L24;
        };
    L24:
        r3[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
    L35:
        switch(r6) {
            case 7: goto L38;
            case 8: goto L38;
            case 9: goto L39;
            case 10: goto L39;
            case 11: goto L39;
            case 12: goto L37;
            case 13: goto L39;
            case 14: goto L39;
            case 15: goto L39;
            case 16: goto L39;
            case 17: goto L39;
            case 18: goto L39;
            case 19: goto L39;
            default: goto L36;
        };
    L36:
        r3[2] = "<init>";
        goto L39
    L37:
        r3[2] = "getUnsubstitutedMemberScope";
        goto L39
    L38:
        r3[2] = "initialize";
    L39:
        String r1 = String.format(r0, r3);
        switch(r6) {
            case 9: goto L43;
            case 10: goto L43;
            case 11: goto L43;
            case 12: goto L44;
            case 13: goto L43;
            case 14: goto L43;
            case 15: goto L43;
            case 16: goto L43;
            case 17: goto L43;
            case 18: goto L43;
            case 19: goto L43;
            default: goto L44;
        };
    L44:
        throw new IllegalArgumentException(r1);
    L43:
        throw new IllegalStateException(r1);
    L25:
        r3[1] = "getSealedSubclasses";
        goto L35
    L26:
        r3[1] = "getDeclaredTypeParameters";
        goto L35
    L27:
        r3[1] = "getVisibility";
        goto L35
    L28:
        r3[1] = "getModality";
        goto L35
    L29:
        r3[1] = "getKind";
        goto L35
    L30:
        r3[1] = "getStaticScope";
        goto L35
    L31:
        r3[1] = "getUnsubstitutedMemberScope";
        goto L35
    L32:
        r3[1] = "getConstructors";
        goto L35
    L33:
        r3[1] = "getTypeConstructor";
        goto L35
    L34:
        r3[1] = "getAnnotations";
        goto L35
    L12:
        r3[0] = "kotlinTypeRefiner";
        goto L23
    L13:
        r3[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
        goto L23
    L14:
        r3[0] = "constructors";
        goto L23
    L15:
        r3[0] = "unsubstitutedMemberScope";
        goto L23
    L16:
        r3[0] = "storageManager";
        goto L23
    L17:
        r3[0] = "source";
        goto L23
    L18:
        r3[0] = "supertypes";
        goto L23
    L19:
        r3[0] = "kind";
        goto L23
    L20:
        r3[0] = "modality";
        goto L23
    L21:
        r3[0] = "name";
        goto L23
    L8:
        r2 = 2;
        goto L9
    L4:
        r0 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public boolean B() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.d0
    public boolean E0() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public Collection<kotlin.s0.w.d.l0.c.e> H() {
        List r0 = Collections.emptyList();
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(19);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public boolean I() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.t
    public kotlin.s0.w.d.l0.k.w.h J(kotlin.s0.w.d.l0.n.t1.g r2) {
        if (r2 == null) goto L9;
        kotlin.s0.w.d.l0.k.w.h r1 = this.q;
        if (r1 == null) goto L7;
        return r1;
    L7:
        A0(13);
        throw null;
    L9:
        A0(12);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public boolean J0() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.d0
    public boolean L() {
        return false;
    }

    public final void L0(kotlin.s0.w.d.l0.k.w.h r2, Set<kotlin.s0.w.d.l0.c.d> r3, kotlin.s0.w.d.l0.c.d r4) {
        if (r2 == null) goto L9;
        if (r3 == null) goto L7;
        this.q = r2;
        this.r = r3;
        this.s = r4;
        return;
    L7:
        A0(8);
        throw null;
    L9:
        A0(7);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.i
    public boolean M() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public kotlin.s0.w.d.l0.c.d Q() {
        return this.s;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public kotlin.s0.w.d.l0.k.w.h R() {
        kotlin.s0.w.d.l0.k.w.h.b r0 = kotlin.s0.w.d.l0.k.w.h.b.f20650b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(14);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public kotlin.s0.w.d.l0.c.e T() {
        return null;
    }

    @Override // kotlin.s0.w.d.l0.c.o1.a
    public kotlin.s0.w.d.l0.c.o1.g getAnnotations() {
        kotlin.s0.w.d.l0.c.o1.g r0 = kotlin.s0.w.d.l0.c.o1.g.f18919b.b();
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(9);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.q, kotlin.s0.w.d.l0.c.d0
    public kotlin.s0.w.d.l0.c.u getVisibility() {
        kotlin.s0.w.d.l0.c.u r0 = kotlin.s0.w.d.l0.c.t.f19163e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(17);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public kotlin.s0.w.d.l0.c.f i() {
        kotlin.s0.w.d.l0.c.f r0 = this.o;
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(15);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.h
    public e1 k() {
        e1 r0 = this.p;
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(10);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.d0
    public kotlin.s0.w.d.l0.c.e0 l() {
        kotlin.s0.w.d.l0.c.e0 r0 = this.n;
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(16);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public Collection<kotlin.s0.w.d.l0.c.d> m() {
        Set<kotlin.s0.w.d.l0.c.d> r0 = this.r;
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(11);
        throw null;
    }

    public String toString() {
        return "class " + getName();
    }

    @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.i
    public List<f1> u() {
        List<f1> r0 = Collections.emptyList();
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(18);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public boolean x() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public h1<kotlin.s0.w.d.l0.n.m0> z0() {
        return null;
    }
}
