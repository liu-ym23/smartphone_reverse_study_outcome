package kotlin.s0.w.d.l0.k;

import java.util.Collections;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.q1.d0;
import kotlin.s0.w.d.l0.c.q1.f0;
import kotlin.s0.w.d.l0.c.q1.g0;
import kotlin.s0.w.d.l0.c.q1.l0;
import kotlin.s0.w.d.l0.c.t;
import kotlin.s0.w.d.l0.c.u;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.c.y;
import kotlin.s0.w.d.l0.c.z0;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    private static class a extends kotlin.s0.w.d.l0.c.q1.f {
        public a(kotlin.s0.w.d.l0.c.e r9, a1 r10, boolean r11) {
            if (r9 == null) goto L9;
            if (r10 == null) goto L7;
            super(r9, null, kotlin.s0.w.d.l0.c.o1.g.f18919b.b(), true, kotlin.s0.w.d.l0.c.b.a.f18848f, r10);
            r1(Collections.emptyList(), d.k(r9, r11));
            return;
        L7:
            F(1);
            throw null;
        L9:
            F(0);
            throw null;
        }

        private static /* synthetic */ void F(int r3) {
            Object[] r0 = new Object[3];
            if (r3 == 1) goto L5;
            r0[0] = "containingClass";
        L6:
            r0[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory$DefaultClassConstructorDescriptor";
            r0[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
        L5:
            r0[0] = "source";
            goto L6
        }
    }

    private static /* synthetic */ void a(int r11) {
        if (r11 == 12) goto L7;
        if (r11 == 23) goto L7;
        if (r11 == 25) goto L7;
        String r3 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r11 == 12) goto L13;
        if (r11 == 23) goto L13;
        if (r11 == 25) goto L13;
        int r5 = 3;
    L14:
        Object[] r6 = new Object[r5];
        switch(r11) {
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L16;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L16;
            case 8: goto L26;
            case 9: goto L25;
            case 10: goto L23;
            case 11: goto L24;
            case 12: goto L22;
            case 13: goto L16;
            case 14: goto L26;
            case 15: goto L16;
            case 16: goto L26;
            case 17: goto L16;
            case 18: goto L26;
            case 19: goto L24;
            case 20: goto L21;
            case 21: goto L20;
            case 22: goto L19;
            case 23: goto L22;
            case 24: goto L19;
            case 25: goto L22;
            case 26: goto L18;
            case 27: goto L18;
            case 28: goto L18;
            case 29: goto L17;
            case 30: goto L26;
            case 31: goto L17;
            case 32: goto L26;
            case 33: goto L17;
            case 34: goto L26;
            default: goto L16;
        };
    L16:
        r6[0] = "propertyDescriptor";
    L28:
        if (r11 == 12) goto L34;
        if (r11 == 23) goto L33;
        if (r11 == 25) goto L32;
        r6[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
    L35:
        switch(r11) {
            case 3: goto L48;
            case 4: goto L48;
            case 5: goto L48;
            case 6: goto L48;
            case 7: goto L48;
            case 8: goto L48;
            case 9: goto L48;
            case 10: goto L48;
            case 11: goto L48;
            case 12: goto L49;
            case 13: goto L47;
            case 14: goto L47;
            case 15: goto L46;
            case 16: goto L46;
            case 17: goto L46;
            case 18: goto L46;
            case 19: goto L46;
            case 20: goto L45;
            case 21: goto L45;
            case 22: goto L44;
            case 23: goto L49;
            case 24: goto L43;
            case 25: goto L49;
            case 26: goto L42;
            case 27: goto L41;
            case 28: goto L40;
            case 29: goto L39;
            case 30: goto L39;
            case 31: goto L38;
            case 32: goto L38;
            case 33: goto L37;
            case 34: goto L37;
            default: goto L36;
        };
    L36:
        r6[2] = "createDefaultSetter";
        goto L49
    L37:
        r6[2] = "createContextReceiverParameterForClass";
        goto L49
    L38:
        r6[2] = "createContextReceiverParameterForCallable";
        goto L49
    L39:
        r6[2] = "createExtensionReceiverParameterForCallable";
        goto L49
    L40:
        r6[2] = "isEnumSpecialMethod";
        goto L49
    L41:
        r6[2] = "isEnumValueOfMethod";
        goto L49
    L42:
        r6[2] = "isEnumValuesMethod";
        goto L49
    L43:
        r6[2] = "createEnumValueOfMethod";
        goto L49
    L44:
        r6[2] = "createEnumValuesMethod";
        goto L49
    L45:
        r6[2] = "createPrimaryConstructorForObject";
        goto L49
    L46:
        r6[2] = "createGetter";
        goto L49
    L47:
        r6[2] = "createDefaultGetter";
        goto L49
    L48:
        r6[2] = "createSetter";
    L49:
        String r4 = String.format(r3, r6);
        if (r11 == 12) goto L55;
        if (r11 == 23) goto L55;
        if (r11 == 25) goto L55;
        throw new IllegalArgumentException(r4);
    L55:
        throw new IllegalStateException(r4);
    L32:
        r6[1] = "createEnumValueOfMethod";
        goto L35
    L33:
        r6[1] = "createEnumValuesMethod";
        goto L35
    L34:
        r6[1] = "createSetter";
        goto L35
    L17:
        r6[0] = "owner";
        goto L28
    L18:
        r6[0] = "descriptor";
        goto L28
    L19:
        r6[0] = "enumClass";
        goto L28
    L20:
        r6[0] = "source";
        goto L28
    L21:
        r6[0] = "containingClass";
        goto L28
    L22:
        r6[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
        goto L28
    L23:
        r6[0] = "visibility";
        goto L28
    L24:
        r6[0] = "sourceElement";
        goto L28
    L25:
        r6[0] = "parameterAnnotations";
        goto L28
    L26:
        r6[0] = "annotations";
    L13:
        r5 = 2;
    L7:
        r3 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    public static x0 b(kotlin.s0.w.d.l0.c.a r3, e0 r4, kotlin.s0.w.d.l0.c.o1.g r5) {
        if (r3 == null) goto L11;
        if (r5 == null) goto L9;
        if (r4 != null) goto L8;
        return null;
    L8:
        return new f0(r3, new kotlin.s0.w.d.l0.k.w.o.c(r3, r4, null), r5);
    L9:
        a(32);
        throw null;
    L11:
        a(31);
        throw null;
    }

    public static x0 c(kotlin.s0.w.d.l0.c.e r3, e0 r4, kotlin.s0.w.d.l0.c.o1.g r5) {
        if (r3 == null) goto L11;
        if (r5 == null) goto L9;
        if (r4 != null) goto L8;
        return null;
    L8:
        return new f0(r3, new kotlin.s0.w.d.l0.k.w.o.b(r3, r4, null), r5);
    L9:
        a(34);
        throw null;
    L11:
        a(33);
        throw null;
    }

    public static d0 d(u0 r2, kotlin.s0.w.d.l0.c.o1.g r3) {
        if (r2 == null) goto L9;
        if (r3 != null) goto L6;
        a(14);
        throw null;
    L6:
        return i(r2, r3, true, false, false);
    L9:
        a(13);
        throw null;
    }

    public static kotlin.s0.w.d.l0.c.q1.e0 e(u0 r8, kotlin.s0.w.d.l0.c.o1.g r9, kotlin.s0.w.d.l0.c.o1.g r10) {
        if (r8 == null) goto L12;
        if (r9 == null) goto L10;
        if (r10 != null) goto L7;
        a(2);
        throw null;
    L7:
        return m(r8, r9, r10, true, false, false, r8.getSource());
    L10:
        a(1);
        throw null;
    L12:
        a(0);
        throw null;
    }

    public static z0 f(kotlin.s0.w.d.l0.c.e r19) {
        if (r19 == null) goto L9;
        kotlin.s0.w.d.l0.c.o1.g.a r2 = kotlin.s0.w.d.l0.c.o1.g.f18919b;
        g0 r3 = g0.m1(r19, r2.b(), kotlin.s0.w.d.l0.b.k.f18707c, kotlin.s0.w.d.l0.c.b.a.f18851i, r19.getSource());
        l0 r4 = new l0(r3, null, 0, r2.b(), kotlin.s0.w.d.l0.g.f.k("value"), kotlin.s0.w.d.l0.k.t.a.f(r19).W(), false, false, false, null, r19.getSource());
        g0 r0 = r3.o1(null, null, Collections.emptyList(), Collections.emptyList(), Collections.singletonList(r4), r19.s(), kotlin.s0.w.d.l0.c.e0.f18860g, t.f19163e);
        if (r0 == null) goto L7;
        return r0;
    L7:
        a(25);
        throw null;
    L9:
        a(24);
        throw null;
    }

    public static z0 g(kotlin.s0.w.d.l0.c.e r14) {
        if (r14 == null) goto L9;
        g0 r15 = g0.m1(r14, kotlin.s0.w.d.l0.c.o1.g.f18919b.b(), kotlin.s0.w.d.l0.b.k.f18706b, kotlin.s0.w.d.l0.c.b.a.f18851i, r14.getSource()).o1(null, null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), kotlin.s0.w.d.l0.k.t.a.f(r14).l(r1.f21065h, r14.s()), kotlin.s0.w.d.l0.c.e0.f18860g, t.f19163e);
        if (r15 == null) goto L7;
        return r15;
    L7:
        a(23);
        throw null;
    L9:
        a(22);
        throw null;
    }

    public static x0 h(kotlin.s0.w.d.l0.c.a r3, e0 r4, kotlin.s0.w.d.l0.c.o1.g r5) {
        if (r3 == null) goto L11;
        if (r5 == null) goto L9;
        if (r4 != null) goto L8;
        return null;
    L8:
        return new f0(r3, new kotlin.s0.w.d.l0.k.w.o.d(r3, r4, null), r5);
    L9:
        a(30);
        throw null;
    L11:
        a(29);
        throw null;
    }

    public static d0 i(u0 r7, kotlin.s0.w.d.l0.c.o1.g r8, boolean r9, boolean r10, boolean r11) {
        if (r7 == null) goto L9;
        if (r8 != null) goto L6;
        a(16);
        throw null;
    L6:
        return j(r7, r8, r9, r10, r11, r7.getSource());
    L9:
        a(15);
        throw null;
    }

    public static d0 j(u0 r12, kotlin.s0.w.d.l0.c.o1.g r13, boolean r14, boolean r15, boolean r16, a1 r17) {
        if (r12 == null) goto L12;
        if (r13 == null) goto L10;
        if (r17 != null) goto L7;
        a(19);
        throw null;
    L7:
        return new d0(r12, r13, r12.l(), r12.getVisibility(), r14, r15, r16, kotlin.s0.w.d.l0.c.b.a.f18848f, null, r17);
    L10:
        a(18);
        throw null;
    L12:
        a(17);
        throw null;
    }

    public static kotlin.s0.w.d.l0.c.q1.f k(kotlin.s0.w.d.l0.c.e r2, a1 r3) {
        if (r2 == null) goto L9;
        if (r3 != null) goto L6;
        a(21);
        throw null;
    L6:
        return new a(r2, r3, false);
    L9:
        a(20);
        throw null;
    }

    public static kotlin.s0.w.d.l0.c.q1.e0 l(u0 r13, kotlin.s0.w.d.l0.c.o1.g r14, kotlin.s0.w.d.l0.c.o1.g r15, boolean r16, boolean r17, boolean r18, u r19, a1 r20) {
        if (r13 == null) goto L18;
        if (r14 == null) goto L16;
        if (r15 == null) goto L14;
        if (r19 == null) goto L12;
        if (r20 == null) goto L10;
        kotlin.s0.w.d.l0.c.q1.e0 r1 = new kotlin.s0.w.d.l0.c.q1.e0(r13, r14, r13.l(), r19, r16, r17, r18, kotlin.s0.w.d.l0.c.b.a.f18848f, null, r20);
        r1.S0(kotlin.s0.w.d.l0.c.q1.e0.Q0(r1, r13.b(), r15));
        return r1;
    L10:
        a(11);
        throw null;
    L12:
        a(10);
        throw null;
    L14:
        a(9);
        throw null;
    L16:
        a(8);
        throw null;
    L18:
        a(7);
        throw null;
    }

    public static kotlin.s0.w.d.l0.c.q1.e0 m(u0 r9, kotlin.s0.w.d.l0.c.o1.g r10, kotlin.s0.w.d.l0.c.o1.g r11, boolean r12, boolean r13, boolean r14, a1 r15) {
        if (r9 == null) goto L15;
        if (r10 == null) goto L13;
        if (r11 == null) goto L11;
        if (r15 != null) goto L8;
        a(6);
        throw null;
    L8:
        return l(r9, r10, r11, r12, r13, r14, r9.getVisibility(), r15);
    L11:
        a(5);
        throw null;
    L13:
        a(4);
        throw null;
    L15:
        a(3);
        throw null;
    }

    private static boolean n(y r2) {
        if (r2 != null) goto L4;
        a(28);
        throw null;
    L4:
        if (r2.i() == kotlin.s0.w.d.l0.c.b.a.f18851i) goto L6;
    L8:
        return false;
    L6:
        if (d.A(r2.c()) == false) goto L8;
        return true;
    }

    public static boolean o(y r2) {
        if (r2 != null) goto L4;
        a(27);
        throw null;
    L4:
        if (r2.getName().equals(kotlin.s0.w.d.l0.b.k.f18707c) == true) goto L6;
    L8:
        return false;
    L6:
        if (n(r2) == false) goto L8;
        return true;
    }

    public static boolean p(y r2) {
        if (r2 != null) goto L4;
        a(26);
        throw null;
    L4:
        if (r2.getName().equals(kotlin.s0.w.d.l0.b.k.f18706b) == true) goto L6;
    L8:
        return false;
    L6:
        if (n(r2) == false) goto L8;
        return true;
    }
}
