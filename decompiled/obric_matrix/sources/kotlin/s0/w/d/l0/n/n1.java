package kotlin.s0.w.d.l0.n;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m0 f21051a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m0 f21052b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m0 f21053c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m0 f21054d = null;

    public static class a extends r {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f21055g;

        public a(String r1) {
            this.f21055g = r1;
        }

        private static /* synthetic */ void a1(int r9) {
            if (r9 == 1) goto L6;
            if (r9 == 4) goto L6;
            String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L8:
            if (r9 == 1) goto L11;
            if (r9 == 4) goto L11;
            int r5 = 3;
        L12:
            Object[] r6 = new Object[r5];
            if (r9 == 1) goto L20;
            if (r9 == 2) goto L19;
            if (r9 == 3) goto L18;
            if (r9 == 4) goto L20;
            r6[0] = "newAttributes";
        L22:
            if (r9 == 1) goto L26;
            if (r9 == 4) goto L25;
            r6[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
        L27:
            if (r9 == 1) goto L34;
            if (r9 == 2) goto L33;
            if (r9 == 3) goto L32;
            if (r9 == 4) goto L34;
            r6[2] = "replaceAttributes";
            goto L34
        L32:
            r6[2] = "refine";
            goto L34
        L33:
            r6[2] = "replaceDelegate";
        L34:
            String r3 = String.format(r2, r6);
            if (r9 == 1) goto L39;
            if (r9 == 4) goto L39;
            throw new IllegalArgumentException(r3);
        L39:
            throw new IllegalStateException(r3);
        L25:
            r6[1] = "refine";
            goto L27
        L26:
            r6[1] = "toString";
            goto L27
        L18:
            r6[0] = "kotlinTypeRefiner";
            goto L22
        L19:
            r6[0] = "delegate";
        L20:
            r6[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
        L11:
            r5 = 2;
        L6:
            r2 = "@NotNull method %s.%s must not return null";
            goto L8
        }

        @Override // kotlin.s0.w.d.l0.n.r, kotlin.s0.w.d.l0.n.e0
        public /* bridge */ /* synthetic */ e0 Q0(kotlin.s0.w.d.l0.n.t1.g r1) {
            b1(r1);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.n.m0, kotlin.s0.w.d.l0.n.q1
        public /* bridge */ /* synthetic */ q1 S0(boolean r1) {
            V0(r1);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.n.r, kotlin.s0.w.d.l0.n.q1
        public /* bridge */ /* synthetic */ q1 T0(kotlin.s0.w.d.l0.n.t1.g r1) {
            b1(r1);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.n.m0, kotlin.s0.w.d.l0.n.q1
        public /* bridge */ /* synthetic */ q1 U0(a1 r1) {
            W0(r1);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.n.m0
        public m0 V0(boolean r1) {
            throw new IllegalStateException(this.f21055g);
        }

        @Override // kotlin.s0.w.d.l0.n.m0
        public m0 W0(a1 r1) {
            if (r1 != null) goto L6;
            a1(0);
            throw null;
        L6:
            throw new IllegalStateException(this.f21055g);
        }

        @Override // kotlin.s0.w.d.l0.n.r
        protected m0 X0() {
            throw new IllegalStateException(this.f21055g);
        }

        @Override // kotlin.s0.w.d.l0.n.r
        public /* bridge */ /* synthetic */ m0 Y0(kotlin.s0.w.d.l0.n.t1.g r1) {
            b1(r1);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.n.r
        public r Z0(m0 r1) {
            if (r1 != null) goto L6;
            a1(2);
            throw null;
        L6:
            throw new IllegalStateException(this.f21055g);
        }

        public a b1(kotlin.s0.w.d.l0.n.t1.g r1) {
            if (r1 == null) goto L4;
            return this;
        L4:
            a1(3);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.n.m0
        public String toString() {
            String r0 = this.f21055g;
            if (r0 == null) goto L5;
            return r0;
        L5:
            a1(1);
            throw null;
        }
    }

    static {
        f21051a = kotlin.s0.w.d.l0.n.u1.k.d(kotlin.s0.w.d.l0.n.u1.j.f21157J, new String[0]);
        f21052b = kotlin.s0.w.d.l0.n.u1.k.d(kotlin.s0.w.d.l0.n.u1.j.C, new String[0]);
        f21053c = new a("NO_EXPECTED_TYPE");
        f21054d = new a("UNIT_EXPECTED_TYPE");
    }

    private static /* synthetic */ void a(int r24) {
        if (r24 == 4) goto L17;
        if (r24 == 9) goto L17;
        if (r24 == 11) goto L17;
        if (r24 == 15) goto L17;
        if (r24 == 17) goto L17;
        if (r24 == 19) goto L17;
        if (r24 == 26) goto L17;
        if (r24 == 35) goto L17;
        if (r24 == 47) goto L17;
        if (r24 == 52) goto L17;
        if (r24 == 6) goto L17;
        if (r24 == 7) goto L17;
        switch(r24) {
            case 55: goto L17;
            case 56: goto L17;
            case 57: goto L17;
            case 58: goto L17;
            default: goto L16;
        };
    L16:
        String r13 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L19:
        if (r24 == 4) goto L33;
        if (r24 == 9) goto L132;
        if (r24 == 11) goto L133;
        if (r24 == 15) goto L134;
        if (r24 == 17) goto L135;
        if (r24 == 19) goto L136;
        if (r24 == 26) goto L137;
        if (r24 == 35) goto L138;
        if (r24 == 47) goto L139;
        if (r24 == 52) goto L140;
        if (r24 == 6) goto L141;
        if (r24 == 7) goto L142;
        switch(r24) {
            case 55: goto L143;
            case 56: goto L143;
            case 57: goto L143;
            case 58: goto L143;
            default: goto L32;
        };
    L32:
        int r15 = 3;
    L34:
        Object[] r16 = new Object[r15];
        switch(r24) {
            case 4: goto L59;
            case 5: goto L36;
            case 6: goto L59;
            case 7: goto L59;
            case 8: goto L36;
            case 9: goto L59;
            case 10: goto L36;
            case 11: goto L59;
            case 12: goto L58;
            case 13: goto L57;
            case 14: goto L56;
            case 15: goto L59;
            case 16: goto L55;
            case 17: goto L59;
            case 18: goto L36;
            case 19: goto L59;
            case 20: goto L54;
            case 21: goto L53;
            case 22: goto L52;
            case 23: goto L36;
            case 24: goto L51;
            case 25: goto L36;
            case 26: goto L59;
            case 27: goto L36;
            case 28: goto L36;
            case 29: goto L36;
            case 30: goto L36;
            case 31: goto L50;
            case 32: goto L49;
            case 33: goto L50;
            case 34: goto L48;
            case 35: goto L59;
            case 36: goto L47;
            case 37: goto L46;
            case 38: goto L36;
            case 39: goto L45;
            case 40: goto L36;
            case 41: goto L44;
            case 42: goto L43;
            case 43: goto L42;
            case 44: goto L42;
            case 45: goto L41;
            case 46: goto L40;
            case 47: goto L59;
            case 48: goto L39;
            case 49: goto L39;
            case 50: goto L40;
            case 51: goto L38;
            case 52: goto L59;
            case 53: goto L37;
            case 54: goto L38;
            case 55: goto L59;
            case 56: goto L59;
            case 57: goto L59;
            case 58: goto L59;
            default: goto L36;
        };
    L36:
        r16[0] = WsConstants.KEY_CONNECTION_TYPE;
    L61:
        if (r24 == 4) goto L83;
        if (r24 == 9) goto L82;
        if (r24 == 11) goto L81;
        if (r24 == 15) goto L81;
        if (r24 == 17) goto L80;
        if (r24 == 19) goto L79;
        if (r24 == 26) goto L78;
        if (r24 == 35) goto L77;
        if (r24 == 47) goto L76;
        if (r24 == 52) goto L75;
        if (r24 == 6) goto L82;
        if (r24 == 7) goto L82;
        switch(r24) {
            case 55: goto L75;
            case 56: goto L75;
            case 57: goto L75;
            case 58: goto L75;
            default: goto L74;
        };
    L74:
        r16[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
    L84:
        switch(r24) {
            case 1: goto L114;
            case 2: goto L113;
            case 3: goto L112;
            case 4: goto L115;
            case 5: goto L111;
            case 6: goto L115;
            case 7: goto L115;
            case 8: goto L111;
            case 9: goto L115;
            case 10: goto L110;
            case 11: goto L115;
            case 12: goto L109;
            case 13: goto L109;
            case 14: goto L109;
            case 15: goto L115;
            case 16: goto L108;
            case 17: goto L115;
            case 18: goto L107;
            case 19: goto L115;
            case 20: goto L106;
            case 21: goto L106;
            case 22: goto L106;
            case 23: goto L105;
            case 24: goto L105;
            case 25: goto L104;
            case 26: goto L115;
            case 27: goto L103;
            case 28: goto L102;
            case 29: goto L101;
            case 30: goto L100;
            case 31: goto L99;
            case 32: goto L99;
            case 33: goto L98;
            case 34: goto L98;
            case 35: goto L115;
            case 36: goto L97;
            case 37: goto L97;
            case 38: goto L96;
            case 39: goto L96;
            case 40: goto L95;
            case 41: goto L95;
            case 42: goto L94;
            case 43: goto L94;
            case 44: goto L94;
            case 45: goto L93;
            case 46: goto L92;
            case 47: goto L115;
            case 48: goto L92;
            case 49: goto L91;
            case 50: goto L90;
            case 51: goto L90;
            case 52: goto L115;
            case 53: goto L90;
            case 54: goto L90;
            case 55: goto L115;
            case 56: goto L115;
            case 57: goto L115;
            case 58: goto L115;
            case 59: goto L89;
            case 60: goto L88;
            case 61: goto L87;
            case 62: goto L86;
            default: goto L85;
        };
    L85:
        r16[2] = "noExpectedType";
        goto L115
    L86:
        r16[2] = "getTypeParameterDescriptorOrNull";
        goto L115
    L87:
        r16[2] = "isNonReifiedTypeParameter";
        goto L115
    L88:
        r16[2] = "isReifiedTypeParameter";
        goto L115
    L89:
        r16[2] = "isTypeParameter";
        goto L115
    L90:
        r16[2] = "getPrimitiveNumberType";
        goto L115
    L91:
        r16[2] = "findByFqName";
        goto L115
    L92:
        r16[2] = "getDefaultPrimitiveNumberType";
        goto L115
    L93:
        r16[2] = "makeStarProjection";
        goto L115
    L94:
        r16[2] = "contains";
        goto L115
    L95:
        r16[2] = "dependsOnTypeConstructors";
        goto L115
    L96:
        r16[2] = "dependsOnTypeParameters";
        goto L115
    L97:
        r16[2] = "equalTypes";
        goto L115
    L98:
        r16[2] = "substituteProjectionsForParameters";
        goto L115
    L99:
        r16[2] = "substituteParameters";
        goto L115
    L100:
        r16[2] = "getClassDescriptor";
        goto L115
    L101:
        r16[2] = "hasNullableSuperType";
        goto L115
    L102:
        r16[2] = "acceptsNullable";
        goto L115
    L103:
        r16[2] = "isNullableType";
        goto L115
    L104:
        r16[2] = "getAllSupertypes";
        goto L115
    L105:
        r16[2] = "collectAllSupertypes";
        goto L115
    L106:
        r16[2] = "createSubstitutedSupertype";
        goto L115
    L107:
        r16[2] = "getImmediateSupertypes";
        goto L115
    L108:
        r16[2] = "getDefaultTypeProjections";
        goto L115
    L109:
        r16[2] = "makeUnsubstitutedType";
        goto L115
    L110:
        r16[2] = "canHaveSubtypes";
        goto L115
    L111:
        r16[2] = "makeNullableIfNeeded";
        goto L115
    L112:
        r16[2] = "makeNullableAsSpecified";
        goto L115
    L113:
        r16[2] = "makeNotNullable";
        goto L115
    L114:
        r16[2] = "makeNullable";
    L115:
        String r14 = String.format(r13, r16);
        if (r24 == 4) goto L131;
        if (r24 == 9) goto L131;
        if (r24 == 11) goto L131;
        if (r24 == 15) goto L131;
        if (r24 == 17) goto L131;
        if (r24 == 19) goto L131;
        if (r24 == 26) goto L131;
        if (r24 == 35) goto L131;
        if (r24 == 47) goto L131;
        if (r24 == 52) goto L131;
        if (r24 == 6) goto L131;
        if (r24 == 7) goto L131;
        switch(r24) {
            case 55: goto L131;
            case 56: goto L131;
            case 57: goto L131;
            case 58: goto L131;
            default: goto L144;
        };
    L144:
        throw new IllegalArgumentException(r14);
    L131:
        throw new IllegalStateException(r14);
    L75:
        r16[1] = "getPrimitiveNumberType";
        goto L84
    L76:
        r16[1] = "getDefaultPrimitiveNumberType";
        goto L84
    L77:
        r16[1] = "substituteProjectionsForParameters";
        goto L84
    L78:
        r16[1] = "getAllSupertypes";
        goto L84
    L79:
        r16[1] = "getImmediateSupertypes";
        goto L84
    L80:
        r16[1] = "getDefaultTypeProjections";
    L81:
        r16[1] = "makeUnsubstitutedType";
    L82:
        r16[1] = "makeNullableIfNeeded";
        goto L84
    L83:
        r16[1] = "makeNullableAsSpecified";
        goto L84
    L37:
        r16[0] = "literalTypeConstructor";
        goto L61
    L38:
        r16[0] = "expectedType";
        goto L61
    L39:
        r16[0] = "supertypes";
        goto L61
    L40:
        r16[0] = "numberValueTypeConstructor";
        goto L61
    L41:
        r16[0] = "parameterDescriptor";
        goto L61
    L42:
        r16[0] = "isSpecialType";
        goto L61
    L43:
        r16[0] = "specialType";
        goto L61
    L44:
        r16[0] = "typeParameterConstructors";
        goto L61
    L45:
        r16[0] = "typeParameters";
        goto L61
    L46:
        r16[0] = "b";
        goto L61
    L47:
        r16[0] = "a";
        goto L61
    L48:
        r16[0] = "projections";
        goto L61
    L49:
        r16[0] = "typeArguments";
        goto L61
    L50:
        r16[0] = "clazz";
        goto L61
    L51:
        r16[0] = "result";
        goto L61
    L52:
        r16[0] = "substitutor";
        goto L61
    L53:
        r16[0] = "superType";
        goto L61
    L54:
        r16[0] = "subType";
        goto L61
    L55:
        r16[0] = "parameters";
        goto L61
    L56:
        r16[0] = "refinedTypeFactory";
        goto L61
    L57:
        r16[0] = "unsubstitutedMemberScope";
        goto L61
    L58:
        r16[0] = "typeConstructor";
        goto L61
    L59:
        r16[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
        goto L61
    L143:
        r15 = 2;
        goto L34
    L142:
        r15 = 2;
        goto L34
    L141:
        r15 = 2;
        goto L34
    L140:
        r15 = 2;
        goto L34
    L139:
        r15 = 2;
        goto L34
    L138:
        r15 = 2;
        goto L34
    L137:
        r15 = 2;
        goto L34
    L136:
        r15 = 2;
        goto L34
    L135:
        r15 = 2;
        goto L34
    L134:
        r15 = 2;
        goto L34
    L133:
        r15 = 2;
        goto L34
    L132:
        r15 = 2;
        goto L34
    L33:
        r15 = 2;
    L17:
        r13 = "@NotNull method %s.%s must not return null";
        goto L19
    }

    public static boolean b(e0 r2) {
        if (r2 != null) goto L4;
        a(28);
        throw null;
    L4:
        if (r2.P0() == false) goto L7;
        return true;
    L7:
        if (b0.b(r2) == true) goto L9;
        return false;
    L9:
        if (b(b0.a(r2).X0()) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public static boolean c(e0 r1, kotlin.n0.c.l<q1, Boolean> r2) {
        if (r2 != null) goto L5;
        a(43);
        throw null;
    L5:
        return d(r1, r2, null);
    }

    private static boolean d(e0 r5, kotlin.n0.c.l<q1, Boolean> r6, kotlin.s0.w.d.l0.p.f<e0> r7) {
        y r0 = null;
        if (r6 != null) goto L5;
        a(44);
        throw null;
    L5:
        if (r5 != null) goto L7;
        return false;
    L7:
        q1 r2 = r5.R0();
        if (v(r5) == true) goto L10;
        if (r7 == null) goto L16;
        if (r7.contains(r5) == false) goto L16;
        return false;
    L16:
        if (r6.invoke(r2).booleanValue() == false) goto L18;
        return true;
    L18:
        if (r7 != null) goto L20;
        r7 = kotlin.s0.w.d.l0.p.f.a();
    L20:
        r7.add(r5);
        if ((r2 instanceof y) == false) goto L23;
        r0 = (y) r2;
    L23:
        if (r0 == null) goto L30;
        if (d(r0.W0(), r6, r7) == false) goto L27;
    L28:
        return true;
    L27:
        if (d(r0.X0(), r6, r7) == true) goto L28;
    L30:
        if ((r2 instanceof p) == true) goto L32;
    L34:
        e1 r1 = r5.O0();
        if ((r1 instanceof d0) == false) goto L43;
        Iterator<e0> r8 = ((d0) r1).a().iterator();
    L38:
        if (r8.hasNext() == false) goto L42;
        if (d(r8.next(), r6, r7) == false) goto L38;
        return true;
    L42:
        return false;
    L43:
        Iterator<g1> r9 = r5.M0().iterator();
    L45:
        if (r9.hasNext() == false) goto L52;
        g1 r3 = r9.next();
        if (r3.d() == true) goto L45;
        if (d(r3.b(), r6, r7) == false) goto L45;
        return true;
    L52:
        return false;
    L32:
        if (d(((p) r2).a1(), r6, r7) == false) goto L34;
        return true;
    L10:
        return r6.invoke(r2).booleanValue();
    }

    public static e0 e(e0 r2, e0 r3, l1 r4) {
        if (r2 == null) goto L15;
        if (r3 == null) goto L13;
        if (r4 == null) goto L11;
        e0 r5 = r4.p(r3, r1.f21065h);
        if (r5 != null) goto L9;
        return null;
    L9:
        return q(r5, r2.P0());
    L11:
        a(22);
        throw null;
    L13:
        a(21);
        throw null;
    L15:
        a(20);
        throw null;
    }

    public static kotlin.s0.w.d.l0.c.e f(e0 r2) {
        if (r2 == null) goto L9;
        kotlin.s0.w.d.l0.c.h r3 = r2.O0().d();
        if ((r3 instanceof kotlin.s0.w.d.l0.c.e) == true) goto L7;
        return null;
    L7:
        return (kotlin.s0.w.d.l0.c.e) r3;
    L9:
        a(30);
        throw null;
    }

    public static List<g1> g(List<kotlin.s0.w.d.l0.c.f1> r4) {
        if (r4 == null) goto L13;
        ArrayList r1 = new ArrayList(r4.size());
        Iterator<kotlin.s0.w.d.l0.c.f1> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        r1.add(new i1(r5.next().s()));
        goto L6
    L8:
        List<g1> r6 = kotlin.i0.r.z0(r1);
        if (r6 == null) goto L11;
        return r6;
    L11:
        a(17);
        throw null;
    L13:
        a(16);
        throw null;
    }

    public static List<e0> h(e0 r4) {
        if (r4 == null) goto L10;
        l1 r0 = l1.f(r4);
        Collection<e0> r1 = r4.O0().a();
        ArrayList r2 = new ArrayList(r1.size());
        Iterator<e0> r3 = r1.iterator();
    L5:
        if (r3.hasNext() == false) goto L9;
        e0 r5 = e(r4, r3.next(), r0);
        if (r5 == null) goto L5;
        r2.add(r5);
        goto L5
    L9:
        return r2;
    L10:
        a(18);
        throw null;
    }

    public static kotlin.s0.w.d.l0.c.f1 i(e0 r2) {
        if (r2 != null) goto L5;
        a(62);
        throw null;
    L5:
        if ((r2.O0().d() instanceof kotlin.s0.w.d.l0.c.f1) == true) goto L7;
        return null;
    L7:
        return (kotlin.s0.w.d.l0.c.f1) r2.O0().d();
    }

    public static boolean j(e0 r2) {
        if (r2 != null) goto L4;
        a(29);
        throw null;
    L4:
        if ((r2.O0().d() instanceof kotlin.s0.w.d.l0.c.e) == false) goto L6;
        return false;
    L6:
        Iterator<e0> r3 = h(r2).iterator();
    L8:
        if (r3.hasNext() == false) goto L13;
        if (l(r3.next()) == false) goto L8;
        return true;
    L13:
        return false;
    }

    public static boolean k(e0 r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (r1.O0() != f21051a.O0()) goto L6;
        return true;
    }

    public static boolean l(e0 r3) {
        if (r3 != null) goto L4;
        a(27);
        throw null;
    L4:
        if (r3.P0() == false) goto L7;
        return true;
    L7:
        if (b0.b(r3) == false) goto L12;
        if (l(b0.a(r3).X0()) == false) goto L12;
        return true;
    L12:
        if (q0.c(r3) == false) goto L15;
        return false;
    L15:
        if (m(r3) == false) goto L19;
        return j(r3);
    L19:
        if ((r3 instanceof e) == false) goto L27;
        kotlin.s0.w.d.l0.c.f1 r4 = ((e) r3).X0().b();
        if (r4 != null) goto L23;
        return true;
    L23:
        if (j(r4.s()) == false) goto L26;
        return true;
    L26:
        return false;
    L27:
        e1 r5 = r3.O0();
        if ((r5 instanceof d0) == false) goto L35;
        Iterator<e0> r6 = r5.a().iterator();
    L31:
        if (r6.hasNext() == false) goto L35;
        if (l(r6.next()) == false) goto L31;
        return true;
    L35:
        return false;
    }

    public static boolean m(e0 r1) {
        if (r1 != null) goto L4;
        a(59);
        throw null;
    L4:
        if (i(r1) == null) goto L6;
    L9:
        return true;
    L6:
        if ((r1.O0() instanceof kotlin.s0.w.d.l0.n.t1.n) == true) goto L9;
        return false;
    }

    public static e0 n(e0 r1) {
        if (r1 != null) goto L4;
        a(2);
        throw null;
    L4:
        return p(r1, false);
    }

    public static e0 o(e0 r1) {
        if (r1 != null) goto L5;
        a(1);
        throw null;
    L5:
        return p(r1, true);
    }

    public static e0 p(e0 r1, boolean r2) {
        if (r1 == null) goto L9;
        q1 r3 = r1.R0().S0(r2);
        if (r3 == null) goto L7;
        return r3;
    L7:
        a(4);
        throw null;
    L9:
        a(3);
        throw null;
    }

    public static e0 q(e0 r1, boolean r2) {
        if (r1 == null) goto L11;
        if (r2 == true) goto L6;
        if (r1 == null) goto L9;
        return r1;
    L9:
        a(9);
        throw null;
    L6:
        return o(r1);
    L11:
        a(8);
        throw null;
    }

    public static m0 r(m0 r1, boolean r2) {
        if (r1 == null) goto L14;
        if (r2 == false) goto L10;
        m0 r3 = r1.V0(true);
        if (r3 == null) goto L8;
        return r3;
    L8:
        a(6);
        throw null;
    L10:
        if (r1 == null) goto L12;
        return r1;
    L12:
        a(7);
        throw null;
    L14:
        a(5);
        throw null;
    }

    public static g1 s(kotlin.s0.w.d.l0.c.f1 r1) {
        if (r1 != null) goto L4;
        a(45);
        throw null;
    L4:
        return new s0(r1);
    }

    public static m0 t(kotlin.s0.w.d.l0.c.h r1, kotlin.s0.w.d.l0.k.w.h r2, kotlin.n0.c.l<kotlin.s0.w.d.l0.n.t1.g, m0> r3) {
        if (kotlin.s0.w.d.l0.n.u1.k.m(r1) == false) goto L10;
        kotlin.s0.w.d.l0.n.u1.h r4 = kotlin.s0.w.d.l0.n.u1.k.d(kotlin.s0.w.d.l0.n.u1.j.I, new String[]{r1.toString()});
        if (r4 == null) goto L7;
        return r4;
    L7:
        a(11);
        throw null;
    L10:
        return u(r1.k(), r2, r3);
    }

    public static m0 u(e1 r8, kotlin.s0.w.d.l0.k.w.h r9, kotlin.n0.c.l<kotlin.s0.w.d.l0.n.t1.g, m0> r10) {
        if (r8 == null) goto L15;
        if (r9 == null) goto L13;
        if (r10 == null) goto L11;
        List<g1> r4 = g(r8.getParameters());
        m0 r11 = f0.k(a1.f20943g.h(), r8, r4, false, r9, r10);
        if (r11 == null) goto L9;
        return r11;
    L9:
        a(15);
        throw null;
    L11:
        a(14);
        throw null;
    L13:
        a(13);
        throw null;
    L15:
        a(12);
        throw null;
    }

    public static boolean v(e0 r2) {
        if (r2 != null) goto L5;
        a(0);
        throw null;
    L5:
        if (r2 != f21053c) goto L7;
    L8:
        return true;
    L7:
        if (r2 == f21054d) goto L8;
        return false;
    }
}
