package kotlin.s0.w.d.l0.n;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends g implements e1 {
    public b(kotlin.s0.w.d.l0.m.n r1) {
        if (r1 == null) goto L5;
        super(r1);
        return;
    L5:
        v(0);
        throw null;
    }

    private static /* synthetic */ void v(int r9) {
        if (r9 == 1) goto L7;
        if (r9 == 3) goto L7;
        if (r9 == 4) goto L7;
        String r3 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r9 == 1) goto L13;
        if (r9 == 3) goto L13;
        if (r9 == 4) goto L13;
        int r5 = 3;
    L14:
        Object[] r6 = new Object[r5];
        if (r9 == 1) goto L21;
        if (r9 == 2) goto L20;
        if (r9 == 3) goto L21;
        if (r9 == 4) goto L21;
        r6[0] = "storageManager";
    L22:
        if (r9 == 1) goto L27;
        if (r9 == 3) goto L26;
        if (r9 == 4) goto L26;
        r6[1] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
    L28:
        if (r9 == 1) goto L34;
        if (r9 == 2) goto L33;
        if (r9 == 3) goto L34;
        if (r9 == 4) goto L34;
        r6[2] = "<init>";
        goto L34
    L33:
        r6[2] = "isSameClassifier";
    L34:
        String r4 = String.format(r3, r6);
        if (r9 == 1) goto L40;
        if (r9 == 3) goto L40;
        if (r9 == 4) goto L40;
        throw new IllegalArgumentException(r4);
    L40:
        throw new IllegalStateException(r4);
    L26:
        r6[1] = "getAdditionalNeighboursInSupertypeGraph";
        goto L28
    L27:
        r6[1] = "getBuiltIns";
        goto L28
    L20:
        r6[0] = "classifier";
    L21:
        r6[0] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
    L13:
        r5 = 2;
    L7:
        r3 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    @Override // kotlin.s0.w.d.l0.n.m, kotlin.s0.w.d.l0.n.e1
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.h d() {
        return w();
    }

    @Override // kotlin.s0.w.d.l0.n.m
    protected boolean i(kotlin.s0.w.d.l0.c.h r2) {
        if (r2 != null) goto L4;
        v(2);
        throw null;
    L4:
        if ((r2 instanceof kotlin.s0.w.d.l0.c.e) == true) goto L6;
    L8:
        return false;
    L6:
        if (g(w(), r2) == false) goto L8;
        return true;
    }

    @Override // kotlin.s0.w.d.l0.n.g
    protected e0 m() {
        if (kotlin.s0.w.d.l0.b.h.t0(w()) == false) goto L7;
        return null;
    L7:
        return o().i();
    }

    @Override // kotlin.s0.w.d.l0.n.g
    protected Collection<e0> n(boolean r3) {
        kotlin.s0.w.d.l0.c.m r2 = w().c();
        if ((r2 instanceof kotlin.s0.w.d.l0.c.e) == true) goto L9;
        List r4 = Collections.emptyList();
        if (r4 == null) goto L7;
        return r4;
    L7:
        v(3);
        throw null;
    L9:
        kotlin.s0.w.d.l0.p.e r0 = new kotlin.s0.w.d.l0.p.e();
        kotlin.s0.w.d.l0.c.e r5 = (kotlin.s0.w.d.l0.c.e) r2;
        r0.add(r5.s());
        kotlin.s0.w.d.l0.c.e r6 = r5.T();
        if (r3 == false) goto L13;
        if (r6 == null) goto L13;
        r0.add(r6.s());
    L13:
        return r0;
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public kotlin.s0.w.d.l0.b.h o() {
        kotlin.s0.w.d.l0.b.h r0 = kotlin.s0.w.d.l0.k.t.a.f(w());
        if (r0 == null) goto L5;
        return r0;
    L5:
        v(1);
        throw null;
    }

    public abstract kotlin.s0.w.d.l0.c.e w();
}
