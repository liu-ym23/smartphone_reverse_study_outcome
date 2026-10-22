package kotlin.s0.w.d.l0.c.q1;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.h1;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.z0;
import kotlin.s0.w.d.l0.n.e1;

/* JADX INFO: loaded from: classes2.dex */
public class n extends g {
    private final e1 n;
    private final kotlin.s0.w.d.l0.k.w.h o;
    private final kotlin.s0.w.d.l0.m.i<Set<kotlin.s0.w.d.l0.g.f>> p;
    private final kotlin.s0.w.d.l0.c.o1.g q;

    private class a extends kotlin.s0.w.d.l0.k.w.i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.m.g<kotlin.s0.w.d.l0.g.f, Collection<? extends z0>> f19014b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.m.g<kotlin.s0.w.d.l0.g.f, Collection<? extends u0>> f19015c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.m.i<Collection<kotlin.s0.w.d.l0.c.m>> f19016d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ n f19017e;

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.c.q1.n$a$a, reason: collision with other inner class name */
        class C0505a implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.f, Collection<? extends z0>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ a f19018f;

            C0505a(a r1, n r2) {
                this.f19018f = r1;
            }

            public Collection<? extends z0> a(kotlin.s0.w.d.l0.g.f r1) {
                return a.i(this.f19018f, r1);
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ Collection<? extends z0> invoke(kotlin.s0.w.d.l0.g.f r1) {
                return a(r1);
            }
        }

        class b implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.f, Collection<? extends u0>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ a f19019f;

            b(a r1, n r2) {
                this.f19019f = r1;
            }

            public Collection<? extends u0> a(kotlin.s0.w.d.l0.g.f r1) {
                return a.j(this.f19019f, r1);
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ Collection<? extends u0> invoke(kotlin.s0.w.d.l0.g.f r1) {
                return a(r1);
            }
        }

        class c implements kotlin.n0.c.a<Collection<kotlin.s0.w.d.l0.c.m>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ a f19020f;

            c(a r1, n r2) {
                this.f19020f = r1;
            }

            public Collection<kotlin.s0.w.d.l0.c.m> a() {
                return a.k(this.f19020f);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ Collection<kotlin.s0.w.d.l0.c.m> invoke() {
                return a();
            }
        }

        class d extends kotlin.s0.w.d.l0.k.h {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Set f19021a;

            d(a r1, Set r2) {
                this.f19021a = r2;
            }

            private static /* synthetic */ void f(int r5) {
                Object[] r0 = new Object[3];
                if (r5 == 1) goto L7;
                if (r5 == 2) goto L6;
                r0[0] = "fakeOverride";
            L8:
                r0[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
                if (r5 == 1) goto L12;
                if (r5 == 2) goto L12;
                r0[2] = "addFakeOverride";
            L14:
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
            L12:
                r0[2] = "conflict";
                goto L14
            L6:
                r0[0] = "fromCurrent";
                goto L8
            L7:
                r0[0] = "fromSuper";
                goto L8
            }

            @Override // kotlin.s0.w.d.l0.k.i
            public void a(kotlin.s0.w.d.l0.c.b r2) {
                if (r2 == null) goto L6;
                kotlin.s0.w.d.l0.k.j.K(r2, null);
                this.f19021a.add(r2);
                return;
            L6:
                f(0);
                throw null;
            }

            @Override // kotlin.s0.w.d.l0.k.h
            protected void e(kotlin.s0.w.d.l0.c.b r1, kotlin.s0.w.d.l0.c.b r2) {
                if (r1 == null) goto L8;
                if (r2 == null) goto L6;
                return;
            L6:
                f(2);
                throw null;
            L8:
                f(1);
                throw null;
            }
        }

        static {
        }

        public a(n r2, kotlin.s0.w.d.l0.m.n r3) {
            if (r3 == null) goto L5;
            this.f19017e = r2;
            this.f19014b = r3.h(new C0505a(this, r2));
            this.f19015c = r3.h(new b(this, r2));
            this.f19016d = r3.d(new c(this, r2));
            return;
        L5:
            h(0);
            throw null;
        }

        private static /* synthetic */ void h(int r13) {
            if (r13 == 3) goto L9;
            if (r13 == 7) goto L9;
            if (r13 == 9) goto L9;
            if (r13 == 12) goto L9;
            switch(r13) {
                case 15: goto L9;
                case 16: goto L9;
                case 17: goto L9;
                case 18: goto L9;
                case 19: goto L9;
                default: goto L8;
            };
        L8:
            String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L11:
            if (r13 == 3) goto L17;
            if (r13 == 7) goto L62;
            if (r13 == 9) goto L63;
            if (r13 == 12) goto L64;
            switch(r13) {
                case 15: goto L65;
                case 16: goto L65;
                case 17: goto L65;
                case 18: goto L65;
                case 19: goto L65;
                default: goto L16;
            };
        L16:
            int r6 = 3;
        L18:
            Object[] r7 = new Object[r6];
            switch(r13) {
                case 1: goto L27;
                case 2: goto L26;
                case 3: goto L25;
                case 4: goto L27;
                case 5: goto L27;
                case 6: goto L26;
                case 7: goto L25;
                case 8: goto L27;
                case 9: goto L25;
                case 10: goto L27;
                case 11: goto L24;
                case 12: goto L25;
                case 13: goto L23;
                case 14: goto L22;
                case 15: goto L25;
                case 16: goto L25;
                case 17: goto L25;
                case 18: goto L25;
                case 19: goto L25;
                case 20: goto L21;
                default: goto L20;
            };
        L20:
            r7[0] = "storageManager";
        L29:
            if (r13 == 3) goto L43;
            if (r13 == 7) goto L42;
            if (r13 == 9) goto L41;
            if (r13 == 12) goto L40;
            switch(r13) {
                case 15: goto L39;
                case 16: goto L38;
                case 17: goto L37;
                case 18: goto L36;
                case 19: goto L35;
                default: goto L34;
            };
        L34:
            r7[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
        L44:
            switch(r13) {
                case 1: goto L52;
                case 2: goto L52;
                case 3: goto L53;
                case 4: goto L51;
                case 5: goto L50;
                case 6: goto L50;
                case 7: goto L53;
                case 8: goto L49;
                case 9: goto L53;
                case 10: goto L48;
                case 11: goto L48;
                case 12: goto L53;
                case 13: goto L47;
                case 14: goto L47;
                case 15: goto L53;
                case 16: goto L53;
                case 17: goto L53;
                case 18: goto L53;
                case 19: goto L53;
                case 20: goto L46;
                default: goto L45;
            };
        L45:
            r7[2] = "<init>";
            goto L53
        L46:
            r7[2] = "printScopeStructure";
            goto L53
        L47:
            r7[2] = "getContributedDescriptors";
            goto L53
        L48:
            r7[2] = "resolveFakeOverrides";
            goto L53
        L49:
            r7[2] = "computeFunctions";
            goto L53
        L50:
            r7[2] = "getContributedFunctions";
            goto L53
        L51:
            r7[2] = "computeProperties";
            goto L53
        L52:
            r7[2] = "getContributedVariables";
        L53:
            String r5 = String.format(r4, r7);
            if (r13 == 3) goto L61;
            if (r13 == 7) goto L61;
            if (r13 == 9) goto L61;
            if (r13 == 12) goto L61;
            switch(r13) {
                case 15: goto L61;
                case 16: goto L61;
                case 17: goto L61;
                case 18: goto L61;
                case 19: goto L61;
                default: goto L66;
            };
        L66:
            throw new IllegalArgumentException(r5);
        L61:
            throw new IllegalStateException(r5);
        L35:
            r7[1] = "getVariableNames";
            goto L44
        L36:
            r7[1] = "getClassifierNames";
            goto L44
        L37:
            r7[1] = "getFunctionNames";
            goto L44
        L38:
            r7[1] = "computeAllDeclarations";
            goto L44
        L39:
            r7[1] = "getContributedDescriptors";
            goto L44
        L40:
            r7[1] = "resolveFakeOverrides";
            goto L44
        L41:
            r7[1] = "getSupertypeScope";
            goto L44
        L42:
            r7[1] = "getContributedFunctions";
            goto L44
        L43:
            r7[1] = "getContributedVariables";
            goto L44
        L21:
            r7[0] = "p";
            goto L29
        L22:
            r7[0] = "nameFilter";
            goto L29
        L23:
            r7[0] = "kindFilter";
            goto L29
        L24:
            r7[0] = "fromSupertypes";
            goto L29
        L25:
            r7[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
            goto L29
        L26:
            r7[0] = LocationMonitorConst.LOCATION;
            goto L29
        L27:
            r7[0] = "name";
            goto L29
        L65:
            r6 = 2;
            goto L18
        L64:
            r6 = 2;
            goto L18
        L63:
            r6 = 2;
            goto L18
        L62:
            r6 = 2;
            goto L18
        L17:
            r6 = 2;
        L9:
            r4 = "@NotNull method %s.%s must not return null";
            goto L11
        }

        static /* synthetic */ Collection i(a r0, kotlin.s0.w.d.l0.g.f r1) {
            return r0.m(r1);
        }

        static /* synthetic */ Collection j(a r0, kotlin.s0.w.d.l0.g.f r1) {
            return r0.n(r1);
        }

        static /* synthetic */ Collection k(a r0) {
            return r0.l();
        }

        private Collection<kotlin.s0.w.d.l0.c.m> l() {
            HashSet r0 = new HashSet();
            Iterator r1 = ((Set) n.L0(this.f19017e).invoke()).iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            kotlin.s0.w.d.l0.g.f r2 = (kotlin.s0.w.d.l0.g.f) r1.next();
            kotlin.s0.w.d.l0.d.b.d r3 = kotlin.s0.w.d.l0.d.b.d.u;
            r0.addAll(a(r2, r3));
            r0.addAll(c(r2, r3));
            goto L4
        L6:
            return r0;
        }

        private Collection<? extends z0> m(kotlin.s0.w.d.l0.g.f r3) {
            if (r3 != null) goto L4;
            h(8);
            throw null;
        L4:
            return p(r3, o().a(r3, kotlin.s0.w.d.l0.d.b.d.u));
        }

        private Collection<? extends u0> n(kotlin.s0.w.d.l0.g.f r3) {
            if (r3 != null) goto L4;
            h(4);
            throw null;
        L4:
            return p(r3, o().c(r3, kotlin.s0.w.d.l0.d.b.d.u));
        }

        private kotlin.s0.w.d.l0.k.w.h o() {
            kotlin.s0.w.d.l0.k.w.h r0 = this.f19017e.k().a().iterator().next().q();
            if (r0 == null) goto L5;
            return r0;
        L5:
            h(9);
            throw null;
        }

        private <D extends kotlin.s0.w.d.l0.c.b> Collection<? extends D> p(kotlin.s0.w.d.l0.g.f r8, Collection<? extends D> r9) {
            if (r8 == null) goto L9;
            if (r9 == null) goto L7;
            LinkedHashSet r0 = new LinkedHashSet();
            kotlin.s0.w.d.l0.k.j.f20527f.v(r8, r9, Collections.emptySet(), this.f19017e, new d(this, r0));
            return r0;
        L7:
            h(11);
            throw null;
        L9:
            h(10);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
        public Collection<? extends z0> a(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
            if (r2 == null) goto L12;
            if (r3 == null) goto L10;
            Collection<? extends z0> r1 = this.f19014b.invoke(r2);
            if (r1 == null) goto L8;
            return r1;
        L8:
            h(7);
            throw null;
        L10:
            h(6);
            throw null;
        L12:
            h(5);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
        public Set<kotlin.s0.w.d.l0.g.f> b() {
            Set<kotlin.s0.w.d.l0.g.f> r0 = (Set) n.L0(this.f19017e).invoke();
            if (r0 == null) goto L5;
            return r0;
        L5:
            h(17);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
        public Collection<? extends u0> c(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
            if (r2 == null) goto L12;
            if (r3 == null) goto L10;
            Collection<? extends u0> r1 = this.f19015c.invoke(r2);
            if (r1 == null) goto L8;
            return r1;
        L8:
            h(3);
            throw null;
        L10:
            h(2);
            throw null;
        L12:
            h(1);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
        public Set<kotlin.s0.w.d.l0.g.f> d() {
            Set<kotlin.s0.w.d.l0.g.f> r0 = (Set) n.L0(this.f19017e).invoke();
            if (r0 == null) goto L5;
            return r0;
        L5:
            h(19);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
        public Set<kotlin.s0.w.d.l0.g.f> e() {
            Set<kotlin.s0.w.d.l0.g.f> r0 = Collections.emptySet();
            if (r0 == null) goto L5;
            return r0;
        L5:
            h(18);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.k
        public Collection<kotlin.s0.w.d.l0.c.m> g(kotlin.s0.w.d.l0.k.w.d r2, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r3) {
            if (r2 == null) goto L12;
            if (r3 == null) goto L10;
            Collection<kotlin.s0.w.d.l0.c.m> r1 = this.f19016d.invoke();
            if (r1 == null) goto L8;
            return r1;
        L8:
            h(15);
            throw null;
        L10:
            h(14);
            throw null;
        L12:
            h(13);
            throw null;
        }
    }

    static {
    }

    private n(kotlin.s0.w.d.l0.m.n r8, kotlin.s0.w.d.l0.c.e r9, kotlin.s0.w.d.l0.n.e0 r10, kotlin.s0.w.d.l0.g.f r11, kotlin.s0.w.d.l0.m.i<Set<kotlin.s0.w.d.l0.g.f>> r12, kotlin.s0.w.d.l0.c.o1.g r13, a1 r14) {
        if (r8 == null) goto L24;
        if (r9 == null) goto L22;
        if (r10 == null) goto L20;
        if (r11 == null) goto L18;
        if (r12 == null) goto L16;
        if (r13 == null) goto L14;
        if (r14 == null) goto L12;
        super(r8, r9, r11, r14, false);
        this.q = r13;
        this.n = new kotlin.s0.w.d.l0.n.l(this, Collections.emptyList(), Collections.singleton(r10), r8);
        this.o = new a(this, r8);
        this.p = r12;
        return;
    L12:
        A0(12);
        throw null;
    L14:
        A0(11);
        throw null;
    L16:
        A0(10);
        throw null;
    L18:
        A0(9);
        throw null;
    L20:
        A0(8);
        throw null;
    L22:
        A0(7);
        throw null;
    L24:
        A0(6);
        throw null;
    }

    private static /* synthetic */ void A0(int r6) {
        switch(r6) {
            case 14: goto L4;
            case 15: goto L4;
            case 16: goto L4;
            case 17: goto L4;
            case 18: goto L4;
            case 19: goto L4;
            case 20: goto L4;
            case 21: goto L4;
            case 22: goto L4;
            case 23: goto L4;
            default: goto L3;
        };
    L3:
        String r0 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r6) {
            case 14: goto L8;
            case 15: goto L8;
            case 16: goto L8;
            case 17: goto L8;
            case 18: goto L8;
            case 19: goto L8;
            case 20: goto L8;
            case 21: goto L8;
            case 22: goto L8;
            case 23: goto L8;
            default: goto L7;
        };
    L7:
        int r2 = 3;
    L9:
        Object[] r3 = new Object[r2];
        switch(r6) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L11;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L19;
            case 10: goto L18;
            case 11: goto L17;
            case 12: goto L16;
            case 13: goto L13;
            case 14: goto L12;
            case 15: goto L12;
            case 16: goto L12;
            case 17: goto L12;
            case 18: goto L12;
            case 19: goto L12;
            case 20: goto L12;
            case 21: goto L12;
            case 22: goto L12;
            case 23: goto L12;
            default: goto L11;
        };
    L11:
        r3[0] = "storageManager";
    L22:
        switch(r6) {
            case 14: goto L33;
            case 15: goto L32;
            case 16: goto L31;
            case 17: goto L30;
            case 18: goto L29;
            case 19: goto L28;
            case 20: goto L27;
            case 21: goto L26;
            case 22: goto L25;
            case 23: goto L24;
            default: goto L23;
        };
    L23:
        r3[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
    L34:
        switch(r6) {
            case 6: goto L37;
            case 7: goto L37;
            case 8: goto L37;
            case 9: goto L37;
            case 10: goto L37;
            case 11: goto L37;
            case 12: goto L37;
            case 13: goto L36;
            case 14: goto L38;
            case 15: goto L38;
            case 16: goto L38;
            case 17: goto L38;
            case 18: goto L38;
            case 19: goto L38;
            case 20: goto L38;
            case 21: goto L38;
            case 22: goto L38;
            case 23: goto L38;
            default: goto L35;
        };
    L35:
        r3[2] = "create";
        goto L38
    L36:
        r3[2] = "getUnsubstitutedMemberScope";
        goto L38
    L37:
        r3[2] = "<init>";
    L38:
        String r1 = String.format(r0, r3);
        switch(r6) {
            case 14: goto L42;
            case 15: goto L42;
            case 16: goto L42;
            case 17: goto L42;
            case 18: goto L42;
            case 19: goto L42;
            case 20: goto L42;
            case 21: goto L42;
            case 22: goto L42;
            case 23: goto L42;
            default: goto L43;
        };
    L43:
        throw new IllegalArgumentException(r1);
    L42:
        throw new IllegalStateException(r1);
    L24:
        r3[1] = "getSealedSubclasses";
        goto L34
    L25:
        r3[1] = "getDeclaredTypeParameters";
        goto L34
    L26:
        r3[1] = "getAnnotations";
        goto L34
    L27:
        r3[1] = "getVisibility";
        goto L34
    L28:
        r3[1] = "getModality";
        goto L34
    L29:
        r3[1] = "getKind";
        goto L34
    L30:
        r3[1] = "getTypeConstructor";
        goto L34
    L31:
        r3[1] = "getConstructors";
        goto L34
    L32:
        r3[1] = "getStaticScope";
        goto L34
    L33:
        r3[1] = "getUnsubstitutedMemberScope";
        goto L34
    L12:
        r3[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
        goto L22
    L13:
        r3[0] = "kotlinTypeRefiner";
        goto L22
    L14:
        r3[0] = "supertype";
        goto L22
    L15:
        r3[0] = "containingClass";
        goto L22
    L16:
        r3[0] = "source";
        goto L22
    L17:
        r3[0] = "annotations";
        goto L22
    L18:
        r3[0] = "enumMemberNames";
        goto L22
    L19:
        r3[0] = "name";
        goto L22
    L20:
        r3[0] = "enumClass";
        goto L22
    L8:
        r2 = 2;
        goto L9
    L4:
        r0 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    static /* synthetic */ kotlin.s0.w.d.l0.m.i L0(n r0) {
        return r0.p;
    }

    public static n M0(kotlin.s0.w.d.l0.m.n r9, kotlin.s0.w.d.l0.c.e r10, kotlin.s0.w.d.l0.g.f r11, kotlin.s0.w.d.l0.m.i<Set<kotlin.s0.w.d.l0.g.f>> r12, kotlin.s0.w.d.l0.c.o1.g r13, a1 r14) {
        if (r9 == null) goto L21;
        if (r10 == null) goto L19;
        if (r11 == null) goto L17;
        if (r12 == null) goto L15;
        if (r13 == null) goto L13;
        if (r14 != null) goto L10;
        A0(5);
        throw null;
    L10:
        return new n(r9, r10, r10.s(), r11, r12, r13, r14);
    L13:
        A0(4);
        throw null;
    L15:
        A0(3);
        throw null;
    L17:
        A0(2);
        throw null;
    L19:
        A0(1);
        throw null;
    L21:
        A0(0);
        throw null;
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
        A0(23);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public boolean I() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.t
    public kotlin.s0.w.d.l0.k.w.h J(kotlin.s0.w.d.l0.n.t1.g r2) {
        if (r2 == null) goto L9;
        kotlin.s0.w.d.l0.k.w.h r1 = this.o;
        if (r1 == null) goto L7;
        return r1;
    L7:
        A0(14);
        throw null;
    L9:
        A0(13);
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

    @Override // kotlin.s0.w.d.l0.c.i
    public boolean M() {
        return false;
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
        A0(15);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public kotlin.s0.w.d.l0.c.e T() {
        return null;
    }

    @Override // kotlin.s0.w.d.l0.c.o1.a
    public kotlin.s0.w.d.l0.c.o1.g getAnnotations() {
        kotlin.s0.w.d.l0.c.o1.g r0 = this.q;
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(21);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.q, kotlin.s0.w.d.l0.c.d0
    public kotlin.s0.w.d.l0.c.u getVisibility() {
        kotlin.s0.w.d.l0.c.u r0 = kotlin.s0.w.d.l0.c.t.f19163e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(20);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public kotlin.s0.w.d.l0.c.f i() {
        kotlin.s0.w.d.l0.c.f r0 = kotlin.s0.w.d.l0.c.f.f18868i;
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(18);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.h
    public e1 k() {
        e1 r0 = this.n;
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(17);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.d0
    public kotlin.s0.w.d.l0.c.e0 l() {
        kotlin.s0.w.d.l0.c.e0 r0 = kotlin.s0.w.d.l0.c.e0.f18860g;
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(19);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public Collection<kotlin.s0.w.d.l0.c.d> m() {
        List r0 = Collections.emptyList();
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(16);
        throw null;
    }

    public String toString() {
        return "enum entry " + getName();
    }

    @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.i
    public List<f1> u() {
        List<f1> r0 = Collections.emptyList();
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(22);
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
