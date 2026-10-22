package kotlin.s0.w.d.l0.c.q1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.h1;
import kotlin.s0.w.d.l0.n.e1;

/* JADX INFO: loaded from: classes2.dex */
public class y extends g {
    private final kotlin.s0.w.d.l0.c.f n;
    private final boolean o;
    private kotlin.s0.w.d.l0.c.e0 p;
    private kotlin.s0.w.d.l0.c.u q;
    private e1 r;
    private List<f1> s;
    private final Collection<kotlin.s0.w.d.l0.n.e0> t;
    private final kotlin.s0.w.d.l0.m.n u;

    static {
    }

    public y(kotlin.s0.w.d.l0.c.m r7, kotlin.s0.w.d.l0.c.f r8, boolean r9, boolean r10, kotlin.s0.w.d.l0.g.f r11, a1 r12, kotlin.s0.w.d.l0.m.n r13) {
        if (r7 == null) goto L18;
        if (r8 == null) goto L16;
        if (r11 == null) goto L14;
        if (r12 == null) goto L12;
        if (r13 == null) goto L10;
        super(r13, r7, r11, r12, r10);
        this.t = new ArrayList();
        this.u = r13;
        this.n = r8;
        this.o = r9;
        return;
    L10:
        A0(4);
        throw null;
    L12:
        A0(3);
        throw null;
    L14:
        A0(2);
        throw null;
    L16:
        A0(1);
        throw null;
    L18:
        A0(0);
        throw null;
    }

    private static /* synthetic */ void A0(int r6) {
        switch(r6) {
            case 5: goto L4;
            case 6: goto L3;
            case 7: goto L4;
            case 8: goto L4;
            case 9: goto L3;
            case 10: goto L4;
            case 11: goto L4;
            case 12: goto L3;
            case 13: goto L4;
            case 14: goto L3;
            case 15: goto L4;
            case 16: goto L3;
            case 17: goto L4;
            case 18: goto L4;
            case 19: goto L4;
            default: goto L3;
        };
    L3:
        String r0 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r6) {
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L8;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L8;
            case 11: goto L8;
            case 12: goto L7;
            case 13: goto L8;
            case 14: goto L7;
            case 15: goto L8;
            case 16: goto L7;
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
            case 7: goto L17;
            case 8: goto L17;
            case 9: goto L15;
            case 10: goto L17;
            case 11: goto L17;
            case 12: goto L14;
            case 13: goto L17;
            case 14: goto L13;
            case 15: goto L17;
            case 16: goto L12;
            case 17: goto L17;
            case 18: goto L17;
            case 19: goto L17;
            default: goto L11;
        };
    L11:
        r3[0] = "containingDeclaration";
    L23:
        switch(r6) {
            case 5: goto L34;
            case 6: goto L24;
            case 7: goto L33;
            case 8: goto L32;
            case 9: goto L24;
            case 10: goto L31;
            case 11: goto L30;
            case 12: goto L24;
            case 13: goto L29;
            case 14: goto L24;
            case 15: goto L28;
            case 16: goto L24;
            case 17: goto L27;
            case 18: goto L26;
            case 19: goto L25;
            default: goto L24;
        };
    L24:
        r3[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
    L35:
        switch(r6) {
            case 5: goto L42;
            case 6: goto L41;
            case 7: goto L42;
            case 8: goto L42;
            case 9: goto L40;
            case 10: goto L42;
            case 11: goto L42;
            case 12: goto L39;
            case 13: goto L42;
            case 14: goto L38;
            case 15: goto L42;
            case 16: goto L37;
            case 17: goto L42;
            case 18: goto L42;
            case 19: goto L42;
            default: goto L36;
        };
    L36:
        r3[2] = "<init>";
        goto L42
    L37:
        r3[2] = "getUnsubstitutedMemberScope";
        goto L42
    L38:
        r3[2] = "setTypeParameterDescriptors";
        goto L42
    L39:
        r3[2] = "addSupertype";
        goto L42
    L40:
        r3[2] = "setVisibility";
        goto L42
    L41:
        r3[2] = "setModality";
    L42:
        String r1 = String.format(r0, r3);
        switch(r6) {
            case 5: goto L46;
            case 6: goto L47;
            case 7: goto L46;
            case 8: goto L46;
            case 9: goto L47;
            case 10: goto L46;
            case 11: goto L46;
            case 12: goto L47;
            case 13: goto L46;
            case 14: goto L47;
            case 15: goto L46;
            case 16: goto L47;
            case 17: goto L46;
            case 18: goto L46;
            case 19: goto L46;
            default: goto L47;
        };
    L47:
        throw new IllegalArgumentException(r1);
    L46:
        throw new IllegalStateException(r1);
    L25:
        r3[1] = "getSealedSubclasses";
        goto L35
    L26:
        r3[1] = "getStaticScope";
        goto L35
    L27:
        r3[1] = "getUnsubstitutedMemberScope";
        goto L35
    L28:
        r3[1] = "getDeclaredTypeParameters";
        goto L35
    L29:
        r3[1] = "getConstructors";
        goto L35
    L30:
        r3[1] = "getTypeConstructor";
        goto L35
    L31:
        r3[1] = "getVisibility";
        goto L35
    L32:
        r3[1] = "getKind";
        goto L35
    L33:
        r3[1] = "getModality";
        goto L35
    L34:
        r3[1] = "getAnnotations";
        goto L35
    L12:
        r3[0] = "kotlinTypeRefiner";
        goto L23
    L13:
        r3[0] = "typeParameters";
        goto L23
    L14:
        r3[0] = "supertype";
        goto L23
    L15:
        r3[0] = "visibility";
        goto L23
    L16:
        r3[0] = "modality";
        goto L23
    L17:
        r3[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
        goto L23
    L18:
        r3[0] = "storageManager";
        goto L23
    L19:
        r3[0] = "source";
        goto L23
    L20:
        r3[0] = "name";
        goto L23
    L21:
        r3[0] = "kind";
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
    public kotlin.s0.w.d.l0.k.w.h J(kotlin.s0.w.d.l0.n.t1.g r1) {
        if (r1 == null) goto L9;
        kotlin.s0.w.d.l0.k.w.h.b r2 = kotlin.s0.w.d.l0.k.w.h.b.f20650b;
        if (r2 == null) goto L7;
        return r2;
    L7:
        A0(17);
        throw null;
    L9:
        A0(16);
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

    public void L0() {
        this.r = new kotlin.s0.w.d.l0.n.l(this, this.s, this.t, this.u);
        Iterator<kotlin.s0.w.d.l0.c.d> r0 = M0().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).h1(s());
        goto L4
    }

    @Override // kotlin.s0.w.d.l0.c.i
    public boolean M() {
        return this.o;
    }

    public Set<kotlin.s0.w.d.l0.c.d> M0() {
        Set<kotlin.s0.w.d.l0.c.d> r0 = Collections.emptySet();
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(13);
        throw null;
    }

    public void N0(kotlin.s0.w.d.l0.c.e0 r1) {
        if (r1 == null) goto L5;
        this.p = r1;
        return;
    L5:
        A0(6);
        throw null;
    }

    public void O0(List<f1> r3) {
        if (r3 != null) goto L4;
        A0(14);
        throw null;
    L4:
        if (this.s != null) goto L8;
        this.s = new ArrayList(r3);
        return;
    L8:
        throw new IllegalStateException("Type parameters are already set for " + getName());
    }

    public void P0(kotlin.s0.w.d.l0.c.u r1) {
        if (r1 == null) goto L5;
        this.q = r1;
        return;
    L5:
        A0(9);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public kotlin.s0.w.d.l0.c.d Q() {
        return null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public kotlin.s0.w.d.l0.k.w.h R() {
        kotlin.s0.w.d.l0.k.w.h.b r0 = kotlin.s0.w.d.l0.k.w.h.b.f20650b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(18);
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
        A0(5);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.q, kotlin.s0.w.d.l0.c.d0
    public kotlin.s0.w.d.l0.c.u getVisibility() {
        kotlin.s0.w.d.l0.c.u r0 = this.q;
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(10);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public kotlin.s0.w.d.l0.c.f i() {
        kotlin.s0.w.d.l0.c.f r0 = this.n;
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(8);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.h
    public e1 k() {
        e1 r0 = this.r;
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(11);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.d0
    public kotlin.s0.w.d.l0.c.e0 l() {
        kotlin.s0.w.d.l0.c.e0 r0 = this.p;
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(7);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public /* bridge */ /* synthetic */ Collection m() {
        return M0();
    }

    public String toString() {
        return j.J(this);
    }

    @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.i
    public List<f1> u() {
        List<f1> r0 = this.s;
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(15);
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
