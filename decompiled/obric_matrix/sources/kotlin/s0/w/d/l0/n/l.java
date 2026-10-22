package kotlin.s0.w.d.l0.n;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class l extends b implements e1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.c.e f21035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<kotlin.s0.w.d.l0.c.f1> f21036e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Collection<e0> f21037f;

    public l(kotlin.s0.w.d.l0.c.e r2, List<? extends kotlin.s0.w.d.l0.c.f1> r3, Collection<e0> r4, kotlin.s0.w.d.l0.m.n r5) {
        if (r2 == null) goto L15;
        if (r3 == null) goto L13;
        if (r4 == null) goto L11;
        if (r5 == null) goto L9;
        super(r5);
        this.f21035d = r2;
        this.f21036e = Collections.unmodifiableList(new ArrayList(r3));
        this.f21037f = Collections.unmodifiableCollection(r4);
        return;
    L9:
        v(3);
        throw null;
    L11:
        v(2);
        throw null;
    L13:
        v(1);
        throw null;
    L15:
        v(0);
        throw null;
    }

    private static /* synthetic */ void v(int r10) {
        if (r10 == 4) goto L8;
        if (r10 == 5) goto L8;
        if (r10 == 6) goto L8;
        if (r10 == 7) goto L8;
        String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L10:
        if (r10 == 4) goto L15;
        if (r10 == 5) goto L15;
        if (r10 == 6) goto L15;
        if (r10 == 7) goto L15;
        int r6 = 3;
    L16:
        Object[] r7 = new Object[r6];
        switch(r10) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L19;
            default: goto L18;
        };
    L18:
        r7[0] = "classDescriptor";
    L24:
        if (r10 == 4) goto L32;
        if (r10 == 5) goto L31;
        if (r10 == 6) goto L30;
        if (r10 == 7) goto L29;
        r7[1] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
    L33:
        if (r10 == 4) goto L38;
        if (r10 == 5) goto L38;
        if (r10 == 6) goto L38;
        if (r10 == 7) goto L38;
        r7[2] = "<init>";
    L38:
        String r5 = String.format(r4, r7);
        if (r10 == 4) goto L45;
        if (r10 == 5) goto L45;
        if (r10 == 6) goto L45;
        if (r10 == 7) goto L45;
        throw new IllegalArgumentException(r5);
    L45:
        throw new IllegalStateException(r5);
    L29:
        r7[1] = "getSupertypeLoopChecker";
        goto L33
    L30:
        r7[1] = "computeSupertypes";
        goto L33
    L31:
        r7[1] = "getDeclarationDescriptor";
        goto L33
    L32:
        r7[1] = "getParameters";
        goto L33
    L19:
        r7[0] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
        goto L24
    L20:
        r7[0] = "storageManager";
        goto L24
    L21:
        r7[0] = "supertypes";
        goto L24
    L22:
        r7[0] = "parameters";
    L15:
        r6 = 2;
    L8:
        r4 = "@NotNull method %s.%s must not return null";
        goto L10
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public boolean e() {
        return true;
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public List<kotlin.s0.w.d.l0.c.f1> getParameters() {
        List<kotlin.s0.w.d.l0.c.f1> r0 = this.f21036e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        v(4);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.n.g
    protected Collection<e0> l() {
        Collection<e0> r0 = this.f21037f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        v(6);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.n.g
    protected kotlin.s0.w.d.l0.c.d1 q() {
        kotlin.s0.w.d.l0.c.d1.a r0 = kotlin.s0.w.d.l0.c.d1.a.f18858a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        v(7);
        throw null;
    }

    public String toString() {
        return kotlin.s0.w.d.l0.k.d.m(this.f21035d).b();
    }

    @Override // kotlin.s0.w.d.l0.n.b
    public kotlin.s0.w.d.l0.c.e w() {
        kotlin.s0.w.d.l0.c.e r0 = this.f21035d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        v(5);
        throw null;
    }
}
