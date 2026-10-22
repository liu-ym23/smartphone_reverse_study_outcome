package kotlin.s0.w.d.l0.n;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class l1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l1 f21038b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j1 f21039a;

    static class a implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.c, Boolean> {
        a() {
        }

        private static /* synthetic */ void a(int r2) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"}));
        }

        public Boolean b(kotlin.s0.w.d.l0.g.c r1) {
            if (r1 != null) goto L4;
            a(0);
            throw null;
        L4:
            return Boolean.valueOf(!r1.equals(kotlin.s0.w.d.l0.b.k.a.A));
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(kotlin.s0.w.d.l0.g.c r1) {
            return b(r1);
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f21040a = null;

        static {
            int[] r0 = new int[d.values().length];
            f21040a = r0;
            r0[d.f21043h.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f21040a[d.f21042g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f21040a[d.f21041f.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    private static final class c extends Exception {
        public c(String r1) {
            super(r1);
        }
    }

    private static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f21041f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final d f21042g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final d f21043h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ d[] f21044i = null;

        static {
            d r0 = new d("NO_CONFLICT", 0);
            f21041f = r0;
            d r1 = new d("IN_IN_OUT_POSITION", 1);
            f21042g = r1;
            d r3 = new d("OUT_IN_IN_POSITION", 2);
            f21043h = r3;
            f21044i = new d[]{r0, r1, r3};
        }

        private d(String r1, int r2) {
            super(r1, r2);
        }

        public static d valueOf(String r1) {
            return (d) Enum.valueOf(d.class, r1);
        }

        public static d[] values() {
            return (d[]) f21044i.clone();
        }
    }

    static {
        f21038b = g(j1.f21031a);
    }

    protected l1(j1 r1) {
        if (r1 == null) goto L5;
        this.f21039a = r1;
        return;
    L5:
        a(7);
        throw null;
    }

    private static /* synthetic */ void a(int r13) {
        if (r13 == 1) goto L13;
        if (r13 == 2) goto L13;
        if (r13 == 8) goto L13;
        if (r13 == 34) goto L13;
        if (r13 == 37) goto L13;
        switch(r13) {
            case 11: goto L13;
            case 12: goto L13;
            case 13: goto L13;
            default: goto L9;
        };
    L9:
        switch(r13) {
            case 19: goto L13;
            case 20: goto L13;
            case 21: goto L13;
            case 22: goto L13;
            case 23: goto L13;
            case 24: goto L13;
            case 25: goto L13;
            default: goto L10;
        };
    L10:
        switch(r13) {
            case 29: goto L13;
            case 30: goto L13;
            case 31: goto L13;
            case 32: goto L13;
            default: goto L11;
        };
    L11:
        switch(r13) {
            case 40: goto L13;
            case 41: goto L13;
            case 42: goto L13;
            default: goto L12;
        };
    L12:
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L14:
        if (r13 == 1) goto L24;
        if (r13 == 2) goto L85;
        if (r13 == 8) goto L86;
        if (r13 == 34) goto L87;
        if (r13 == 37) goto L88;
        switch(r13) {
            case 11: goto L89;
            case 12: goto L89;
            case 13: goto L89;
            default: goto L20;
        };
    L20:
        switch(r13) {
            case 19: goto L90;
            case 20: goto L90;
            case 21: goto L90;
            case 22: goto L90;
            case 23: goto L90;
            case 24: goto L90;
            case 25: goto L90;
            default: goto L21;
        };
    L21:
        switch(r13) {
            case 29: goto L91;
            case 30: goto L91;
            case 31: goto L91;
            case 32: goto L91;
            default: goto L22;
        };
    L22:
        switch(r13) {
            case 40: goto L92;
            case 41: goto L92;
            case 42: goto L92;
            default: goto L23;
        };
    L23:
        int r6 = 3;
    L25:
        Object[] r7 = new Object[r6];
        switch(r13) {
            case 1: goto L41;
            case 2: goto L41;
            case 3: goto L40;
            case 4: goto L39;
            case 5: goto L38;
            case 6: goto L37;
            case 7: goto L27;
            case 8: goto L41;
            case 9: goto L36;
            case 10: goto L35;
            case 11: goto L41;
            case 12: goto L41;
            case 13: goto L41;
            case 14: goto L36;
            case 15: goto L35;
            case 16: goto L34;
            case 17: goto L34;
            case 18: goto L33;
            case 19: goto L41;
            case 20: goto L41;
            case 21: goto L41;
            case 22: goto L41;
            case 23: goto L41;
            case 24: goto L41;
            case 25: goto L41;
            case 26: goto L32;
            case 27: goto L31;
            case 28: goto L33;
            case 29: goto L41;
            case 30: goto L41;
            case 31: goto L41;
            case 32: goto L41;
            case 33: goto L30;
            case 34: goto L41;
            case 35: goto L29;
            case 36: goto L34;
            case 37: goto L41;
            case 38: goto L29;
            case 39: goto L28;
            case 40: goto L41;
            case 41: goto L41;
            case 42: goto L41;
            default: goto L27;
        };
    L27:
        r7[0] = "substitution";
    L43:
        if (r13 == 1) goto L60;
        if (r13 == 2) goto L59;
        if (r13 == 8) goto L58;
        if (r13 == 34) goto L57;
        if (r13 == 37) goto L56;
        switch(r13) {
            case 11: goto L55;
            case 12: goto L55;
            case 13: goto L55;
            default: goto L49;
        };
    L49:
        switch(r13) {
            case 19: goto L54;
            case 20: goto L54;
            case 21: goto L54;
            case 22: goto L54;
            case 23: goto L54;
            case 24: goto L54;
            case 25: goto L54;
            default: goto L50;
        };
    L50:
        switch(r13) {
            case 29: goto L53;
            case 30: goto L53;
            case 31: goto L53;
            case 32: goto L53;
            default: goto L51;
        };
    L51:
        switch(r13) {
            case 40: goto L56;
            case 41: goto L56;
            case 42: goto L56;
            default: goto L52;
        };
    L52:
        r7[1] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
    L61:
        switch(r13) {
            case 1: goto L72;
            case 2: goto L72;
            case 3: goto L71;
            case 4: goto L71;
            case 5: goto L62;
            case 6: goto L62;
            case 7: goto L70;
            case 8: goto L72;
            case 9: goto L69;
            case 10: goto L69;
            case 11: goto L72;
            case 12: goto L72;
            case 13: goto L72;
            case 14: goto L68;
            case 15: goto L68;
            case 16: goto L68;
            case 17: goto L67;
            case 18: goto L66;
            case 19: goto L72;
            case 20: goto L72;
            case 21: goto L72;
            case 22: goto L72;
            case 23: goto L72;
            case 24: goto L72;
            case 25: goto L72;
            case 26: goto L65;
            case 27: goto L65;
            case 28: goto L65;
            case 29: goto L72;
            case 30: goto L72;
            case 31: goto L72;
            case 32: goto L72;
            case 33: goto L64;
            case 34: goto L72;
            case 35: goto L63;
            case 36: goto L63;
            case 37: goto L72;
            case 38: goto L63;
            case 39: goto L63;
            case 40: goto L72;
            case 41: goto L72;
            case 42: goto L72;
            default: goto L62;
        };
    L62:
        r7[2] = "create";
        goto L72
    L63:
        r7[2] = "combine";
        goto L72
    L64:
        r7[2] = "filterOutUnsafeVariance";
        goto L72
    L65:
        r7[2] = "projectedTypeForConflictedTypeWithUnsafeVariance";
        goto L72
    L66:
        r7[2] = "unsafeSubstitute";
        goto L72
    L67:
        r7[2] = "substituteWithoutApproximation";
        goto L72
    L68:
        r7[2] = "substitute";
        goto L72
    L69:
        r7[2] = "safeSubstitute";
        goto L72
    L70:
        r7[2] = "<init>";
        goto L72
    L71:
        r7[2] = "createChainedSubstitutor";
    L72:
        String r8 = String.format(r5, r7);
        if (r13 == 1) goto L84;
        if (r13 == 2) goto L84;
        if (r13 == 8) goto L84;
        if (r13 == 34) goto L84;
        if (r13 == 37) goto L84;
        switch(r13) {
            case 11: goto L84;
            case 12: goto L84;
            case 13: goto L84;
            default: goto L79;
        };
    L79:
        switch(r13) {
            case 19: goto L84;
            case 20: goto L84;
            case 21: goto L84;
            case 22: goto L84;
            case 23: goto L84;
            case 24: goto L84;
            case 25: goto L84;
            default: goto L80;
        };
    L80:
        switch(r13) {
            case 29: goto L84;
            case 30: goto L84;
            case 31: goto L84;
            case 32: goto L84;
            default: goto L81;
        };
    L81:
        switch(r13) {
            case 40: goto L84;
            case 41: goto L84;
            case 42: goto L84;
            default: goto L93;
        };
    L93:
        throw new IllegalArgumentException(r8);
    L84:
        throw new IllegalStateException(r8);
    L53:
        r7[1] = "projectedTypeForConflictedTypeWithUnsafeVariance";
        goto L61
    L54:
        r7[1] = "unsafeSubstitute";
        goto L61
    L55:
        r7[1] = "safeSubstitute";
    L56:
        r7[1] = "combine";
        goto L61
    L57:
        r7[1] = "filterOutUnsafeVariance";
        goto L61
    L58:
        r7[1] = "getSubstitution";
        goto L61
    L59:
        r7[1] = "replaceWithContravariantApproximatingSubstitution";
        goto L61
    L60:
        r7[1] = "replaceWithNonApproximatingSubstitution";
        goto L61
    L28:
        r7[0] = "projectionKind";
        goto L43
    L29:
        r7[0] = "typeParameterVariance";
        goto L43
    L30:
        r7[0] = "annotations";
        goto L43
    L31:
        r7[0] = "substituted";
        goto L43
    L32:
        r7[0] = "originalType";
        goto L43
    L33:
        r7[0] = "originalProjection";
        goto L43
    L34:
        r7[0] = "typeProjection";
        goto L43
    L35:
        r7[0] = "howThisTypeIsUsed";
        goto L43
    L36:
        r7[0] = WsConstants.KEY_CONNECTION_TYPE;
        goto L43
    L37:
        r7[0] = "context";
        goto L43
    L38:
        r7[0] = "substitutionContext";
        goto L43
    L39:
        r7[0] = "second";
        goto L43
    L40:
        r7[0] = "first";
        goto L43
    L41:
        r7[0] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
        goto L43
    L92:
        r6 = 2;
        goto L25
    L91:
        r6 = 2;
        goto L25
    L90:
        r6 = 2;
        goto L25
    L89:
        r6 = 2;
        goto L25
    L88:
        r6 = 2;
        goto L25
    L87:
        r6 = 2;
        goto L25
    L86:
        r6 = 2;
        goto L25
    L85:
        r6 = 2;
        goto L25
    L24:
        r6 = 2;
    L13:
        r5 = "@NotNull method %s.%s must not return null";
        goto L14
    }

    private static void b(int r2, g1 r3, j1 r4) {
        if (r2 > 100) goto L6;
        return;
    L6:
        throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + o(r3) + "; substitution: " + o(r4));
    }

    public static r1 c(r1 r2, g1 r3) {
        if (r2 == null) goto L16;
        if (r3 != null) goto L6;
        a(36);
        throw null;
    L6:
        if (r3.d() == false) goto L13;
        r1 r4 = r1.f21067j;
        if (r4 == null) goto L10;
        return r4;
    L10:
        a(37);
        throw null;
    L13:
        return d(r2, r3.a());
    L16:
        a(35);
        throw null;
    }

    public static r1 d(r1 r3, r1 r4) {
        if (r3 == null) goto L25;
        if (r4 == null) goto L23;
        r1 r1 = r1.f21065h;
        if (r3 != r1) goto L11;
        if (r4 == null) goto L9;
        return r4;
    L9:
        a(40);
        throw null;
    L11:
        if (r4 != r1) goto L16;
        if (r3 == null) goto L14;
        return r3;
    L14:
        a(41);
        throw null;
    L16:
        if (r3 != r4) goto L22;
        if (r4 == null) goto L19;
        return r4;
    L19:
        a(42);
        throw null;
    L22:
        throw new AssertionError("Variance conflict: type parameter variance '" + r3 + "' and projection kind '" + r4 + "' cannot be combined");
    L23:
        a(39);
        throw null;
    L25:
        a(38);
        throw null;
    }

    private static d e(r1 r2, r1 r3) {
        r1 r0 = r1.f21066i;
        if (r2 != r0) goto L9;
        if (r3 != r1.f21067j) goto L9;
        return d.f21043h;
    L9:
        if (r2 != r1.f21067j) goto L14;
        if (r3 != r0) goto L14;
        return d.f21042g;
    L14:
        return d.f21041f;
    }

    public static l1 f(e0 r1) {
        if (r1 != null) goto L4;
        a(6);
        throw null;
    L4:
        return g(f1.i(r1.O0(), r1.M0()));
    }

    public static l1 g(j1 r1) {
        if (r1 != null) goto L4;
        a(0);
        throw null;
    L4:
        return new l1(r1);
    }

    public static l1 h(j1 r1, j1 r2) {
        if (r1 == null) goto L9;
        if (r2 != null) goto L6;
        a(4);
        throw null;
    L6:
        return g(u.i(r1, r2));
    L9:
        a(3);
        throw null;
    }

    private static kotlin.s0.w.d.l0.c.o1.g i(kotlin.s0.w.d.l0.c.o1.g r2) {
        if (r2 != null) goto L5;
        a(33);
        throw null;
    L5:
        if (r2.k(kotlin.s0.w.d.l0.b.k.a.A) == true) goto L11;
        if (r2 == null) goto L8;
        return r2;
    L8:
        a(34);
        throw null;
    L11:
        return new kotlin.s0.w.d.l0.c.o1.l(r2, new a());
    }

    private static g1 l(e0 r3, g1 r4, kotlin.s0.w.d.l0.c.f1 r5, g1 r6) {
        if (r3 == null) goto L39;
        if (r4 == null) goto L37;
        if (r6 != null) goto L7;
        a(28);
        throw null;
    L7:
        if (r3.getAnnotations().k(kotlin.s0.w.d.l0.b.k.a.A) == true) goto L12;
        if (r4 == null) goto L10;
        return r4;
    L10:
        a(29);
        throw null;
    L12:
        e1 r7 = r4.b().O0();
        if ((r7 instanceof kotlin.s0.w.d.l0.n.t1.j) == true) goto L18;
        if (r4 == null) goto L16;
        return r4;
    L16:
        a(30);
        throw null;
    L18:
        g1 r8 = ((kotlin.s0.w.d.l0.n.t1.j) r7).f();
        r1 r1 = r8.a();
        d r9 = e(r6.a(), r1);
        d r2 = d.f21043h;
        if (r9 == r2) goto L21;
        if (r5 != null) goto L28;
        if (r4 == null) goto L25;
        return r4;
    L25:
        a(31);
        throw null;
    L28:
        if (e(r5.n(), r1) == r2) goto L30;
        if (r4 == null) goto L33;
        return r4;
    L33:
        a(32);
        throw null;
    L30:
        return new i1(r8.b());
    L21:
        return new i1(r8.b());
    L37:
        a(27);
        throw null;
    L39:
        a(26);
        throw null;
    }

    private static String o(Object r2) {
        return r2.toString();
    L4:
        th = move-exception;
        if (kotlin.s0.w.d.l0.p.c.a(th) == true) goto L10;
        return "[Exception while computing toString(): " + th + "]";
    L10:
        throw th;
    }

    private g1 r(g1 r5, int r6) {
        e0 r0 = r5.b();
        r1 r1 = r5.a();
        if ((r0.O0().d() instanceof kotlin.s0.w.d.l0.c.f1) == false) goto L5;
        return r5;
    L5:
        e0 r7 = null;
        m0 r2 = q0.b(r0);
        if (r2 == null) goto L8;
        r7 = m().p(r2, r1.f21065h);
    L8:
        e0 r4 = k1.b(r0, s(r0.O0().getParameters(), r0.M0(), r6), this.f21039a.d(r0.getAnnotations()));
        if ((r4 instanceof m0) == false) goto L14;
        if ((r7 instanceof m0) == false) goto L14;
        r4 = q0.j((m0) r4, (m0) r7);
    L14:
        return new i1(r1, r4);
    }

    private List<g1> s(List<kotlin.s0.w.d.l0.c.f1> r11, List<g1> r12, int r13) {
        ArrayList r0 = new ArrayList(r11.size());
        int r1 = 0;
        boolean r2 = false;
    L4:
        if (r1 >= r11.size()) goto L21;
        kotlin.s0.w.d.l0.c.f1 r3 = r11.get(r1);
        g1 r4 = r12.get(r1);
        g1 r6 = u(r4, r3, r13 + 1);
        int r7 = b.f21040a[e(r3.n(), r6.a()).ordinal()];
        if (r7 != 1) goto L8;
    L17:
        r6 = n1.s(r3);
    L18:
        if (r6 == r4) goto L20;
        r2 = true;
    L20:
        r0.add(r6);
        r1 = r1 + 1;
        goto L4
    L8:
        if (r7 == 2) goto L17;
        if (r7 != 3) goto L18;
        r1 r5 = r3.n();
        r1 r8 = r1.f21065h;
        if (r5 == r8) goto L18;
        if (r6.d() == true) goto L18;
        r6 = new i1(r8, r6.b());
        goto L18
    L21:
        if (r2 == true) goto L23;
        return r12;
    L23:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private g1 u(g1 r7, kotlin.s0.w.d.l0.c.f1 r8, int r9) {
        if (r7 == null) goto L91;
        b(r9, r7, this.f21039a);
        if (r7.d() == false) goto L10;
        if (r7 == null) goto L8;
        return r7;
    L8:
        a(19);
        throw null;
    L10:
        e0 r1 = r7.b();
        if ((r1 instanceof o1) == false) goto L21;
        o1 r2 = (o1) r1;
        q1 r3 = r2.F0();
        e0 r4 = r2.F();
        g1 r10 = u(new i1(r7.a(), r3), r8, r9 + 1);
        if (r10.d() == false) goto L19;
        if (r10 == null) goto L16;
        return r10;
    L16:
        a(20);
        throw null;
    L19:
        return new i1(r10.a(), p1.d(r10.b().R0(), p(r4, r7.a())));
    L21:
        if (w.a(r1) == false) goto L23;
    L87:
        if (r7 == null) goto L89;
        return r7;
    L89:
        a(21);
        throw null;
    L23:
        if ((r1.R0() instanceof l0) == true) goto L87;
        g1 r5 = this.f21039a.e(r1);
        if (r5 == null) goto L28;
        g1 r6 = l(r1, r5, r8, r7);
    L29:
        r1 r11 = r7.a();
        if (r6 != null) goto L46;
        if (b0.b(r1) == false) goto L46;
        if (c1.b(r1) == true) goto L46;
        y r12 = b0.a(r1);
        int r13 = r9 + 1;
        g1 r14 = u(new i1(r11, r12.W0()), r8, r13);
        g1 r15 = u(new i1(r11, r12.X0()), r8, r13);
        r1 r16 = r14.a();
        if (r14.b() != r12.W0()) goto L44;
        if (r15.b() != r12.X0()) goto L44;
        if (r7 == null) goto L41;
        return r7;
    L41:
        a(22);
        throw null;
    L44:
        return new i1(r16, f0.d(k1.a(r14.b()), k1.a(r15.b())));
    L46:
        if (kotlin.s0.w.d.l0.b.h.m0(r1) == false) goto L48;
    L83:
        if (r7 == null) goto L85;
        return r7;
    L85:
        a(23);
        throw null;
    L48:
        if (g0.a(r1) == true) goto L83;
        if (r6 == null) goto L78;
        d r17 = e(r11, r6.a());
        if (kotlin.s0.w.d.l0.k.q.a.d.d(r1) == true) goto L61;
        int r18 = b.f21040a[r17.ordinal()];
        if (r18 == 1) goto L60;
        if (r18 != 2) goto L61;
        return new i1(r1.f21067j, r1.O0().o().I());
    L60:
        throw new c("Out-projection in in-position");
    L61:
        n r19 = c1.a(r1);
        if (r6.d() == false) goto L67;
        if (r6 == null) goto L65;
        return r6;
    L65:
        a(24);
        throw null;
    L67:
        if (r19 == null) goto L69;
        e0 r20 = r19.J(r6.b());
    L71:
        if (r1.getAnnotations().isEmpty() == true) goto L74;
        r20 = kotlin.s0.w.d.l0.n.x1.a.u(r20, new kotlin.s0.w.d.l0.c.o1.k(new kotlin.s0.w.d.l0.c.o1.g[]{r20.getAnnotations(), i(this.f21039a.d(r1.getAnnotations()))}));
    L74:
        if (r17 != d.f21041f) goto L77;
        r11 = d(r11, r6.a());
    L77:
        return new i1(r11, r20);
    L69:
        r20 = n1.q(r6.b(), r1.P0());
        goto L71
    L78:
        g1 r21 = r(r7, r9);
        if (r21 == null) goto L81;
        return r21;
    L81:
        a(25);
        throw null;
    L28:
        r6 = null;
        goto L29
    L91:
        a(18);
        throw null;
    }

    public j1 j() {
        j1 r0 = this.f21039a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        a(8);
        throw null;
    }

    public boolean k() {
        return this.f21039a.f();
    }

    public l1 m() {
        j1 r0 = this.f21039a;
        if ((r0 instanceof c0) == true) goto L5;
    L9:
        return this;
    L5:
        if (r0.b() == false) goto L9;
        return new l1(new c0(((c0) this.f21039a).j(), ((c0) this.f21039a).i(), false));
    }

    public e0 n(e0 r4, r1 r5) {
        if (r4 == null) goto L25;
        if (r5 != null) goto L6;
        a(10);
        throw null;
    L6:
        if (k() == false) goto L27;
        if (r4 == null) goto L9;
        return r4;
    L9:
        a(11);
        throw null;
    L27:
        e0 r3 = u(new i1(r5, r4), null, 0).b();     // Catch: c -> L17
        if (r3 == null) goto L15;
        return r3;
    L15:
        a(12);
        throw null;
    L17:
        e = move-exception;
        kotlin.s0.w.d.l0.n.u1.h r6 = kotlin.s0.w.d.l0.n.u1.k.d(kotlin.s0.w.d.l0.n.u1.j.I, new String[]{e.getMessage()});
        if (r6 == null) goto L21;
        return r6;
    L21:
        a(13);
        throw null;
    L25:
        a(9);
        throw null;
    }

    public e0 p(e0 r4, r1 r5) {
        if (r4 == null) goto L12;
        if (r5 == null) goto L10;
        g1 r3 = q(new i1(r5, j().g(r4, r5)));
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.b();
    L10:
        a(15);
        throw null;
    L12:
        a(14);
        throw null;
    }

    public g1 q(g1 r2) {
        if (r2 == null) goto L10;
        g1 r3 = t(r2);
        if (this.f21039a.a() == true) goto L9;
        if (this.f21039a.b() == true) goto L9;
        return r3;
    L9:
        return kotlin.s0.w.d.l0.n.y1.b.c(r3, this.f21039a.b());
    L10:
        a(16);
        throw null;
    }

    public g1 t(g1 r3) {
        if (r3 != null) goto L5;
        a(17);
        throw null;
    L5:
        if (k() == false) goto L13;
        return r3;
    L13:
        return u(r3, null, 0);
    L10:
        return null;
    }
}
