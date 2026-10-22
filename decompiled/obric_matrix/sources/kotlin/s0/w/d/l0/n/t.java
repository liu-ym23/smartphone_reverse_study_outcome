package kotlin.s0.w.d.l0.n;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class t {
    private static /* synthetic */ void a(int r7) {
        if (r7 == 4) goto L5;
        String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r7 == 4) goto L9;
        int r3 = 3;
    L10:
        Object[] r4 = new Object[r3];
        switch(r7) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            default: goto L12;
        };
    L12:
        r4[0] = "typeParameters";
    L18:
        if (r7 == 4) goto L20;
        r4[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
    L21:
        if (r7 == 4) goto L23;
        r4[2] = "substituteTypeParameters";
    L23:
        String r2 = String.format(r1, r4);
        if (r7 == 4) goto L27;
        throw new IllegalArgumentException(r2);
    L27:
        throw new IllegalStateException(r2);
    L20:
        r4[1] = "substituteTypeParameters";
        goto L21
    L13:
        r4[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        goto L18
    L14:
        r4[0] = "result";
        goto L18
    L15:
        r4[0] = "newContainingDeclaration";
        goto L18
    L16:
        r4[0] = "originalSubstitution";
        goto L18
    L9:
        r3 = 2;
        goto L10
    L5:
        r1 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    public static l1 b(List<kotlin.s0.w.d.l0.c.f1> r1, j1 r2, kotlin.s0.w.d.l0.c.m r3, List<kotlin.s0.w.d.l0.c.f1> r4) {
        if (r1 == null) goto L21;
        if (r2 == null) goto L19;
        if (r3 == null) goto L17;
        if (r4 == null) goto L15;
        l1 r5 = c(r1, r2, r3, r4, null);
        if (r5 == null) goto L14;
        if (r5 == null) goto L11;
        return r5;
    L11:
        a(4);
        throw null;
    L14:
        throw new AssertionError("Substitution failed");
    L15:
        a(3);
        throw null;
    L17:
        a(2);
        throw null;
    L19:
        a(1);
        throw null;
    L21:
        a(0);
        throw null;
    }

    public static l1 c(List<kotlin.s0.w.d.l0.c.f1> r17, j1 r18, kotlin.s0.w.d.l0.c.m r19, List<kotlin.s0.w.d.l0.c.f1> r20, boolean[] r21) {
        if (r17 == null) goto L38;
        if (r18 == null) goto L36;
        if (r19 == null) goto L34;
        if (r20 == null) goto L32;
        HashMap r11 = new HashMap();
        HashMap r12 = new HashMap();
        Iterator<kotlin.s0.w.d.l0.c.f1> r13 = r17.iterator();
        int r8 = 0;
    L9:
        if (r13.hasNext() == false) goto L11;
        kotlin.s0.w.d.l0.c.f1 r15 = r13.next();
        kotlin.s0.w.d.l0.c.q1.k0 r3 = kotlin.s0.w.d.l0.c.q1.k0.R0(r19, r15.getAnnotations(), r15.D(), r15.n(), r15.getName(), r8, kotlin.s0.w.d.l0.c.a1.f18847a, r15.h0());
        r11.put(r15.k(), new i1(r3.s()));
        r12.put(r15, r3);
        r20.add(r3);
        r8 = r8 + 1;
        goto L9
    L11:
        f1 r1 = f1.j(r11);
        l1 r4 = l1.h(r18, r1);
        l1 r0 = l1.h(r18.h(), r1);
        Iterator<kotlin.s0.w.d.l0.c.f1> r2 = r17.iterator();
    L13:
        if (r2.hasNext() == false) goto L31;
        kotlin.s0.w.d.l0.c.f1 r5 = r2.next();
        kotlin.s0.w.d.l0.c.q1.k0 r6 = (kotlin.s0.w.d.l0.c.q1.k0) r12.get(r5);
        Iterator<e0> r7 = r5.getUpperBounds().iterator();
    L16:
        if (r7.hasNext() == false) goto L30;
        e0 r9 = r7.next();
        kotlin.s0.w.d.l0.c.h r10 = r9.O0().d();
        if ((r10 instanceof kotlin.s0.w.d.l0.c.f1) == true) goto L20;
    L22:
        l1 r14 = r0;
    L23:
        e0 r16 = r14.p(r9, r1.f21067j);
        if (r16 == null) goto L25;
        if (r16 == r9) goto L29;
        if (r21 == null) goto L29;
        r21[0] = true;
    L29:
        r6.N0(r16);
        goto L16
    L25:
        return null;
    L20:
        if (kotlin.s0.w.d.l0.n.x1.a.j((kotlin.s0.w.d.l0.c.f1) r10) == false) goto L22;
        r14 = r4;
        goto L23
    L30:
        r6.W0();
        goto L13
    L31:
        return r4;
    L32:
        a(8);
        throw null;
    L34:
        a(7);
        throw null;
    L36:
        a(6);
        throw null;
    L38:
        a(5);
        throw null;
    }
}
