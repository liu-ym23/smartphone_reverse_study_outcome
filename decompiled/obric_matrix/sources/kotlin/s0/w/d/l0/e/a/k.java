package kotlin.s0.w.d.l0.e.a;

import kotlin.s0.w.d.l0.c.u0;

/* JADX INFO: loaded from: classes2.dex */
public final class k {
    private static /* synthetic */ void a(int r6) {
        Object[] r1 = new Object[3];
        if (r6 == 1) goto L8;
        if (r6 == 2) goto L8;
        if (r6 == 3) goto L7;
        r1[0] = "propertyDescriptor";
    L9:
        r1[1] = "kotlin/reflect/jvm/internal/impl/load/java/DescriptorsJvmAbiUtil";
        if (r6 == 1) goto L16;
        if (r6 == 2) goto L15;
        if (r6 == 3) goto L14;
        r1[2] = "isPropertyWithBackingFieldInOuterClass";
    L18:
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r1));
    L14:
        r1[2] = "hasJvmFieldAnnotation";
        goto L18
    L15:
        r1[2] = "isMappedIntrinsicCompanionObject";
        goto L18
    L16:
        r1[2] = "isClassCompanionObjectWithBackingFieldsInOuter";
        goto L18
    L7:
        r1[0] = "memberDescriptor";
    L8:
        r1[0] = "companionObject";
        goto L9
    }

    public static boolean b(kotlin.s0.w.d.l0.c.b r2) {
        if (r2 != null) goto L4;
        a(3);
        throw null;
    L4:
        if ((r2 instanceof u0) == false) goto L12;
        kotlin.s0.w.d.l0.c.w r0 = ((u0) r2).q0();
        if (r0 == null) goto L12;
        if (r0.getAnnotations().k(z.f19663b) == false) goto L12;
        return true;
    L12:
        return r2.getAnnotations().k(z.f19663b);
    }

    public static boolean c(kotlin.s0.w.d.l0.c.m r2) {
        if (r2 != null) goto L5;
        a(1);
        throw null;
    L5:
        if (kotlin.s0.w.d.l0.k.d.x(r2) == true) goto L7;
    L11:
        return false;
    L7:
        if (kotlin.s0.w.d.l0.k.d.w(r2.c()) == false) goto L11;
        if (d((kotlin.s0.w.d.l0.c.e) r2) == true) goto L11;
        return true;
    }

    public static boolean d(kotlin.s0.w.d.l0.c.e r1) {
        if (r1 != null) goto L4;
        a(2);
        throw null;
    L4:
        return kotlin.s0.w.d.l0.b.d.a(kotlin.s0.w.d.l0.b.c.f18671a, r1);
    }

    public static boolean e(u0 r3) {
        if (r3 != null) goto L5;
        a(0);
        throw null;
    L5:
        if (r3.i() != kotlin.s0.w.d.l0.c.b.a.f18849g) goto L8;
        return false;
    L8:
        if (c(r3.c()) == false) goto L11;
        return true;
    L11:
        if (kotlin.s0.w.d.l0.k.d.x(r3.c()) == true) goto L13;
        return false;
    L13:
        if (b(r3) == true) goto L15;
        return false;
    L15:
        return true;
    }
}
