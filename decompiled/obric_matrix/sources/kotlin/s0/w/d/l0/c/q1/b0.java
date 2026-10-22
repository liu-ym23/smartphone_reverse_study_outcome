package kotlin.s0.w.d.l0.c.q1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.t0;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.n.l1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b0 extends k implements t0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f18963j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f18964k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.c.e0 f18965l;
    private final u0 m;
    private final boolean n;
    private final kotlin.s0.w.d.l0.c.b.a o;
    private kotlin.s0.w.d.l0.c.u p;
    private kotlin.s0.w.d.l0.c.y q;

    static {
    }

    public b0(kotlin.s0.w.d.l0.c.e0 r3, kotlin.s0.w.d.l0.c.u r4, u0 r5, kotlin.s0.w.d.l0.c.o1.g r6, kotlin.s0.w.d.l0.g.f r7, boolean r8, boolean r9, boolean r10, kotlin.s0.w.d.l0.c.b.a r11, a1 r12) {
        if (r3 == null) goto L21;
        if (r4 == null) goto L19;
        if (r5 == null) goto L17;
        if (r6 == null) goto L15;
        if (r7 == null) goto L13;
        if (r12 == null) goto L11;
        super(r5.c(), r6, r7, r12);
        this.q = null;
        this.f18965l = r3;
        this.p = r4;
        this.m = r5;
        this.f18963j = r8;
        this.f18964k = r9;
        this.n = r10;
        this.o = r11;
        return;
    L11:
        F(5);
        throw null;
    L13:
        F(4);
        throw null;
    L15:
        F(3);
        throw null;
    L17:
        F(2);
        throw null;
    L19:
        F(1);
        throw null;
    L21:
        F(0);
        throw null;
    }

    private static /* synthetic */ void F(int r6) {
        switch(r6) {
            case 6: goto L4;
            case 7: goto L3;
            case 8: goto L4;
            case 9: goto L4;
            case 10: goto L4;
            case 11: goto L4;
            case 12: goto L4;
            case 13: goto L4;
            case 14: goto L4;
            default: goto L3;
        };
    L3:
        String r0 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r6) {
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L8;
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L8;
            case 12: goto L8;
            case 13: goto L8;
            case 14: goto L8;
            default: goto L7;
        };
    L7:
        int r2 = 3;
    L9:
        Object[] r3 = new Object[r2];
        switch(r6) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L14;
            case 9: goto L14;
            case 10: goto L14;
            case 11: goto L14;
            case 12: goto L14;
            case 13: goto L14;
            case 14: goto L14;
            case 15: goto L12;
            default: goto L11;
        };
    L11:
        r3[0] = "modality";
    L21:
        switch(r6) {
            case 6: goto L30;
            case 7: goto L22;
            case 8: goto L29;
            case 9: goto L28;
            case 10: goto L27;
            case 11: goto L26;
            case 12: goto L25;
            case 13: goto L24;
            case 14: goto L23;
            default: goto L22;
        };
    L22:
        r3[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
    L31:
        switch(r6) {
            case 6: goto L35;
            case 7: goto L34;
            case 8: goto L35;
            case 9: goto L35;
            case 10: goto L35;
            case 11: goto L35;
            case 12: goto L35;
            case 13: goto L35;
            case 14: goto L35;
            case 15: goto L33;
            default: goto L32;
        };
    L32:
        r3[2] = "<init>";
        goto L35
    L33:
        r3[2] = "setOverriddenDescriptors";
        goto L35
    L34:
        r3[2] = "substitute";
    L35:
        String r1 = String.format(r0, r3);
        switch(r6) {
            case 6: goto L39;
            case 7: goto L40;
            case 8: goto L39;
            case 9: goto L39;
            case 10: goto L39;
            case 11: goto L39;
            case 12: goto L39;
            case 13: goto L39;
            case 14: goto L39;
            default: goto L40;
        };
    L40:
        throw new IllegalArgumentException(r1);
    L39:
        throw new IllegalStateException(r1);
    L23:
        r3[1] = "getOverriddenDescriptors";
        goto L31
    L24:
        r3[1] = "getContextReceiverParameters";
        goto L31
    L25:
        r3[1] = "getCorrespondingProperty";
        goto L31
    L26:
        r3[1] = "getCorrespondingVariable";
        goto L31
    L27:
        r3[1] = "getVisibility";
        goto L31
    L28:
        r3[1] = "getModality";
        goto L31
    L29:
        r3[1] = "getTypeParameters";
        goto L31
    L30:
        r3[1] = "getKind";
        goto L31
    L12:
        r3[0] = "overriddenDescriptors";
        goto L21
    L13:
        r3[0] = "substitutor";
        goto L21
    L14:
        r3[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
        goto L21
    L15:
        r3[0] = "source";
        goto L21
    L16:
        r3[0] = "name";
        goto L21
    L17:
        r3[0] = "annotations";
        goto L21
    L18:
        r3[0] = "correspondingProperty";
        goto L21
    L19:
        r3[0] = "visibility";
        goto L21
    L8:
        r2 = 2;
        goto L9
    L4:
        r0 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.p A0() {
        return L0();
    }

    @Override // kotlin.s0.w.d.l0.c.t0
    public u0 B0() {
        u0 r0 = this.m;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(12);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.y
    public boolean C0() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public boolean E() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.d0
    public boolean E0() {
        return false;
    }

    public t0 F0(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.e0 r2, kotlin.s0.w.d.l0.c.u r3, kotlin.s0.w.d.l0.c.b.a r4, boolean r5) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override // kotlin.s0.w.d.l0.c.d0
    public boolean L() {
        return false;
    }

    public abstract t0 L0();

    protected Collection<t0> M0(boolean r3) {
        ArrayList r0 = new ArrayList(0);
        Iterator<? extends u0> r2 = B0().f().iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        u0 r1 = r2.next();
        if (r3 == false) goto L8;
        kotlin.s0.w.d.l0.c.o1.a r4 = r1.g();
    L9:
        if (r4 == null) goto L4;
        r0.add(r4);
        goto L4
    L8:
        r4 = r1.Y();
        goto L9
    L11:
        return r0;
    }

    public void N0(boolean r1) {
        this.f18963j = r1;
    }

    public void O0(kotlin.s0.w.d.l0.c.y r1) {
        this.q = r1;
    }

    @Override // kotlin.s0.w.d.l0.c.y
    public boolean P() {
        return false;
    }

    public void P0(kotlin.s0.w.d.l0.c.u r1) {
        this.p = r1;
    }

    @Override // kotlin.s0.w.d.l0.c.t0
    public boolean U() {
        return this.f18963j;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.a a() {
        return L0();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.b a() {
        return L0();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.m a() {
        return L0();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y a() {
        return L0();
    }

    @Override // kotlin.s0.w.d.l0.c.c1
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.n d(l1 r1) {
        d(r1);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.y, kotlin.s0.w.d.l0.c.c1
    public kotlin.s0.w.d.l0.c.y d(l1 r1) {
        if (r1 != null) goto L6;
        F(7);
        throw null;
    L6:
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.s0.w.d.l0.c.y
    public kotlin.s0.w.d.l0.c.y d0() {
        return this.q;
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public x0 f0() {
        return B0().f0();
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public List<f1> getTypeParameters() {
        List<f1> r0 = Collections.emptyList();
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(8);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q, kotlin.s0.w.d.l0.c.d0
    public kotlin.s0.w.d.l0.c.u getVisibility() {
        kotlin.s0.w.d.l0.c.u r0 = this.p;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(10);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.b
    public kotlin.s0.w.d.l0.c.b.a i() {
        kotlin.s0.w.d.l0.c.b.a r0 = this.o;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(6);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public <V> V i0(kotlin.s0.w.d.l0.c.a.InterfaceC0500a<V> r1) {
        return null;
    }

    @Override // kotlin.s0.w.d.l0.c.d0
    public boolean isExternal() {
        return this.f18964k;
    }

    @Override // kotlin.s0.w.d.l0.c.y
    public boolean isInfix() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.y
    public boolean isInline() {
        return this.n;
    }

    @Override // kotlin.s0.w.d.l0.c.y
    public boolean isOperator() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.y
    public boolean isSuspend() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.b
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.b k0(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.e0 r2, kotlin.s0.w.d.l0.c.u r3, kotlin.s0.w.d.l0.c.b.a r4, boolean r5) {
        F0(r1, r2, r3, r4, r5);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.d0
    public kotlin.s0.w.d.l0.c.e0 l() {
        kotlin.s0.w.d.l0.c.e0 r0 = this.f18965l;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(9);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public x0 m0() {
        return B0().m0();
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public List<x0> r0() {
        List<x0> r0 = B0().r0();
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(13);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.y
    public boolean w0() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.b
    public void x0(Collection<? extends kotlin.s0.w.d.l0.c.b> r1) {
        if (r1 == null) goto L4;
        return;
    L4:
        F(15);
        throw null;
    }
}
