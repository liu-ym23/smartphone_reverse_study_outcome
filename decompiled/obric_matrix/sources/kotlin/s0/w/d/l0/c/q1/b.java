package kotlin.s0.w.d.l0.c.q1;

import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.d1;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends e {
    public b(kotlin.s0.w.d.l0.m.n r2, kotlin.s0.w.d.l0.c.m r3, kotlin.s0.w.d.l0.c.o1.g r4, kotlin.s0.w.d.l0.g.f r5, r1 r6, boolean r7, int r8, a1 r9, d1 r10) {
        if (r2 == null) goto L24;
        if (r3 == null) goto L22;
        if (r4 == null) goto L20;
        if (r5 == null) goto L18;
        if (r6 == null) goto L16;
        if (r9 == null) goto L14;
        if (r10 == null) goto L12;
        super(r2, r3, r4, r5, r6, r7, r8, r9, r10);
        return;
    L12:
        F(6);
        throw null;
    L14:
        F(5);
        throw null;
    L16:
        F(4);
        throw null;
    L18:
        F(3);
        throw null;
    L20:
        F(2);
        throw null;
    L22:
        F(1);
        throw null;
    L24:
        F(0);
        throw null;
    }

    private static /* synthetic */ void F(int r2) {
        Object[] r0 = new Object[3];
        switch(r2) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        r0[0] = "storageManager";
    L11:
        r0[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        r0[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
    L5:
        r0[0] = "supertypeLoopChecker";
        goto L11
    L6:
        r0[0] = "source";
        goto L11
    L7:
        r0[0] = "variance";
        goto L11
    L8:
        r0[0] = "name";
        goto L11
    L9:
        r0[0] = "annotations";
        goto L11
    L10:
        r0[0] = "containingDeclaration";
        goto L11
    }

    @Override // kotlin.s0.w.d.l0.c.q1.j
    public String toString() {
        Object[] r0 = new Object[3];
        String r2 = "";
        if (D() == false) goto L5;
        String r1 = "reified ";
    L6:
        r0[0] = r1;
        if (n() == r1.f21065h) goto L10;
        r2 = n() + " ";
    L10:
        r0[1] = r2;
        r0[2] = getName();
        return String.format("%s%s%s", r0);
    L5:
        r1 = "";
        goto L6
    }
}
