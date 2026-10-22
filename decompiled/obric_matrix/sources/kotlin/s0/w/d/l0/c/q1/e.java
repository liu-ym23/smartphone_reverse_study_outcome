package kotlin.s0.w.d.l0.c.q1;

import com.bytedance.common.wschannel.WsConstants;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.s0.w.d.l0.c.d1;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.n.a1;
import kotlin.s0.w.d.l0.n.e1;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e extends k implements f1 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final r1 f18984j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f18985k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f18986l;
    private final kotlin.s0.w.d.l0.m.i<e1> m;
    private final kotlin.s0.w.d.l0.m.i<kotlin.s0.w.d.l0.n.m0> n;
    private final kotlin.s0.w.d.l0.m.n o;

    class a implements kotlin.n0.c.a<e1> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.m.n f18987f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d1 f18988g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ e f18989h;

        a(e r1, kotlin.s0.w.d.l0.m.n r2, d1 r3) {
            this.f18989h = r1;
            this.f18987f = r2;
            this.f18988g = r3;
        }

        public e1 a() {
            return new c(this.f18989h, this.f18987f, this.f18988g);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ e1 invoke() {
            return a();
        }
    }

    class b implements kotlin.n0.c.a<kotlin.s0.w.d.l0.n.m0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.g.f f18990f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f18991g;

        class a implements kotlin.n0.c.a<kotlin.s0.w.d.l0.k.w.h> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f18992f;

            a(b r1) {
                this.f18992f = r1;
            }

            public kotlin.s0.w.d.l0.k.w.h a() {
                return kotlin.s0.w.d.l0.k.w.n.j("Scope for type parameter " + this.f18992f.f18990f.b(), this.f18992f.f18991g.getUpperBounds());
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.k.w.h invoke() {
                return a();
            }
        }

        b(e r1, kotlin.s0.w.d.l0.g.f r2) {
            this.f18991g = r1;
            this.f18990f = r2;
        }

        public kotlin.s0.w.d.l0.n.m0 a() {
            return kotlin.s0.w.d.l0.n.f0.j(a1.f20943g.h(), this.f18991g.k(), Collections.emptyList(), false, new kotlin.s0.w.d.l0.k.w.g(new a(this)));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.n.m0 invoke() {
            return a();
        }
    }

    private class c extends kotlin.s0.w.d.l0.n.g {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final d1 f18993d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ e f18994e;

        public c(e r1, kotlin.s0.w.d.l0.m.n r2, d1 r3) {
            if (r2 == null) goto L5;
            this.f18994e = r1;
            super(r2);
            this.f18993d = r3;
            return;
        L5:
            v(0);
            throw null;
        }

        private static /* synthetic */ void v(int r11) {
            if (r11 == 1) goto L10;
            if (r11 == 2) goto L10;
            if (r11 == 3) goto L10;
            if (r11 == 4) goto L10;
            if (r11 == 5) goto L10;
            if (r11 == 8) goto L10;
            String r6 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L11:
            if (r11 == 1) goto L18;
            if (r11 == 2) goto L18;
            if (r11 == 3) goto L18;
            if (r11 == 4) goto L18;
            if (r11 == 5) goto L18;
            if (r11 == 8) goto L18;
            int r7 = 3;
        L19:
            Object[] r8 = new Object[r7];
            switch(r11) {
                case 1: goto L25;
                case 2: goto L25;
                case 3: goto L25;
                case 4: goto L25;
                case 5: goto L25;
                case 6: goto L24;
                case 7: goto L23;
                case 8: goto L25;
                case 9: goto L22;
                default: goto L21;
            };
        L21:
            r8[0] = "storageManager";
        L27:
            if (r11 == 1) goto L39;
            if (r11 == 2) goto L38;
            if (r11 == 3) goto L37;
            if (r11 == 4) goto L36;
            if (r11 == 5) goto L35;
            if (r11 == 8) goto L34;
            r8[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
        L40:
            switch(r11) {
                case 1: goto L45;
                case 2: goto L45;
                case 3: goto L45;
                case 4: goto L45;
                case 5: goto L45;
                case 6: goto L44;
                case 7: goto L43;
                case 8: goto L45;
                case 9: goto L42;
                default: goto L41;
            };
        L41:
            r8[2] = "<init>";
            goto L45
        L42:
            r8[2] = "isSameClassifier";
            goto L45
        L43:
            r8[2] = "processSupertypesWithoutCycles";
            goto L45
        L44:
            r8[2] = "reportSupertypeLoopError";
        L45:
            String r9 = String.format(r6, r8);
            if (r11 == 1) goto L54;
            if (r11 == 2) goto L54;
            if (r11 == 3) goto L54;
            if (r11 == 4) goto L54;
            if (r11 == 5) goto L54;
            if (r11 == 8) goto L54;
            throw new IllegalArgumentException(r9);
        L54:
            throw new IllegalStateException(r9);
        L34:
            r8[1] = "processSupertypesWithoutCycles";
            goto L40
        L35:
            r8[1] = "getSupertypeLoopChecker";
            goto L40
        L36:
            r8[1] = "getBuiltIns";
            goto L40
        L37:
            r8[1] = "getDeclarationDescriptor";
            goto L40
        L38:
            r8[1] = "getParameters";
            goto L40
        L39:
            r8[1] = "computeSupertypes";
            goto L40
        L22:
            r8[0] = "classifier";
            goto L27
        L23:
            r8[0] = "supertypes";
            goto L27
        L24:
            r8[0] = WsConstants.KEY_CONNECTION_TYPE;
            goto L27
        L25:
            r8[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
        L18:
            r7 = 2;
        L10:
            r6 = "@NotNull method %s.%s must not return null";
            goto L11
        }

        @Override // kotlin.s0.w.d.l0.n.m, kotlin.s0.w.d.l0.n.e1
        public kotlin.s0.w.d.l0.c.h d() {
            e r0 = this.f18994e;
            if (r0 == null) goto L5;
            return r0;
        L5:
            v(3);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.n.e1
        public boolean e() {
            return true;
        }

        @Override // kotlin.s0.w.d.l0.n.e1
        public List<f1> getParameters() {
            List<f1> r0 = Collections.emptyList();
            if (r0 == null) goto L5;
            return r0;
        L5:
            v(2);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.n.m
        protected boolean i(kotlin.s0.w.d.l0.c.h r3) {
            if (r3 != null) goto L4;
            v(9);
            throw null;
        L4:
            if ((r3 instanceof f1) == true) goto L6;
        L8:
            return false;
        L6:
            if (kotlin.s0.w.d.l0.k.b.f20507a.f(this.f18994e, (f1) r3, true) == false) goto L8;
            return true;
        }

        @Override // kotlin.s0.w.d.l0.n.g
        protected Collection<kotlin.s0.w.d.l0.n.e0> l() {
            List<kotlin.s0.w.d.l0.n.e0> r0 = this.f18994e.M0();
            if (r0 == null) goto L5;
            return r0;
        L5:
            v(1);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.n.g
        protected kotlin.s0.w.d.l0.n.e0 m() {
            return kotlin.s0.w.d.l0.n.u1.k.d(kotlin.s0.w.d.l0.n.u1.j.z, new String[0]);
        }

        @Override // kotlin.s0.w.d.l0.n.e1
        public kotlin.s0.w.d.l0.b.h o() {
            kotlin.s0.w.d.l0.b.h r0 = kotlin.s0.w.d.l0.k.t.a.f(this.f18994e);
            if (r0 == null) goto L5;
            return r0;
        L5:
            v(4);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.n.g
        protected d1 q() {
            d1 r0 = this.f18993d;
            if (r0 == null) goto L5;
            return r0;
        L5:
            v(5);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.n.g
        protected List<kotlin.s0.w.d.l0.n.e0> s(List<kotlin.s0.w.d.l0.n.e0> r2) {
            if (r2 == null) goto L9;
            List<kotlin.s0.w.d.l0.n.e0> r1 = this.f18994e.F0(r2);
            if (r1 == null) goto L7;
            return r1;
        L7:
            v(8);
            throw null;
        L9:
            v(7);
            throw null;
        }

        public String toString() {
            return this.f18994e.getName().toString();
        }

        @Override // kotlin.s0.w.d.l0.n.g
        protected void u(kotlin.s0.w.d.l0.n.e0 r1) {
            if (r1 == null) goto L5;
            this.f18994e.L0(r1);
            return;
        L5:
            v(6);
            throw null;
        }
    }

    protected e(kotlin.s0.w.d.l0.m.n r2, kotlin.s0.w.d.l0.c.m r3, kotlin.s0.w.d.l0.c.o1.g r4, kotlin.s0.w.d.l0.g.f r5, r1 r6, boolean r7, int r8, kotlin.s0.w.d.l0.c.a1 r9, d1 r10) {
        if (r2 == null) goto L24;
        if (r3 == null) goto L22;
        if (r4 == null) goto L20;
        if (r5 == null) goto L18;
        if (r6 == null) goto L16;
        if (r9 == null) goto L14;
        if (r10 == null) goto L12;
        super(r3, r4, r5, r9);
        this.f18984j = r6;
        this.f18985k = r7;
        this.f18986l = r8;
        this.m = r2.d(new a(this, r2, r10));
        this.n = r2.d(new b(this, r5));
        this.o = r2;
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

    private static /* synthetic */ void F(int r6) {
        switch(r6) {
            case 7: goto L4;
            case 8: goto L4;
            case 9: goto L4;
            case 10: goto L4;
            case 11: goto L4;
            case 12: goto L3;
            case 13: goto L4;
            case 14: goto L4;
            default: goto L3;
        };
    L3:
        String r0 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r6) {
            case 7: goto L8;
            case 8: goto L8;
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L8;
            case 12: goto L7;
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
            case 8: goto L13;
            case 9: goto L13;
            case 10: goto L13;
            case 11: goto L13;
            case 12: goto L12;
            case 13: goto L13;
            case 14: goto L13;
            default: goto L11;
        };
    L11:
        r3[0] = "storageManager";
    L21:
        switch(r6) {
            case 7: goto L29;
            case 8: goto L28;
            case 9: goto L27;
            case 10: goto L26;
            case 11: goto L25;
            case 12: goto L22;
            case 13: goto L24;
            case 14: goto L23;
            default: goto L22;
        };
    L22:
        r3[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
    L30:
        switch(r6) {
            case 7: goto L33;
            case 8: goto L33;
            case 9: goto L33;
            case 10: goto L33;
            case 11: goto L33;
            case 12: goto L32;
            case 13: goto L33;
            case 14: goto L33;
            default: goto L31;
        };
    L31:
        r3[2] = "<init>";
        goto L33
    L32:
        r3[2] = "processBoundsWithoutCycles";
    L33:
        String r1 = String.format(r0, r3);
        switch(r6) {
            case 7: goto L37;
            case 8: goto L37;
            case 9: goto L37;
            case 10: goto L37;
            case 11: goto L37;
            case 12: goto L38;
            case 13: goto L37;
            case 14: goto L37;
            default: goto L38;
        };
    L38:
        throw new IllegalArgumentException(r1);
    L37:
        throw new IllegalStateException(r1);
    L23:
        r3[1] = "getStorageManager";
        goto L30
    L24:
        r3[1] = "processBoundsWithoutCycles";
        goto L30
    L25:
        r3[1] = "getOriginal";
        goto L30
    L26:
        r3[1] = "getDefaultType";
        goto L30
    L27:
        r3[1] = "getTypeConstructor";
        goto L30
    L28:
        r3[1] = "getUpperBounds";
        goto L30
    L29:
        r3[1] = "getVariance";
        goto L30
    L12:
        r3[0] = "bounds";
        goto L21
    L13:
        r3[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
        goto L21
    L14:
        r3[0] = "supertypeLoopChecker";
        goto L21
    L15:
        r3[0] = "source";
        goto L21
    L16:
        r3[0] = "variance";
        goto L21
    L17:
        r3[0] = "name";
        goto L21
    L18:
        r3[0] = "annotations";
        goto L21
    L19:
        r3[0] = "containingDeclaration";
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
        return a();
    }

    @Override // kotlin.s0.w.d.l0.c.f1
    public boolean D() {
        return this.f18985k;
    }

    protected List<kotlin.s0.w.d.l0.n.e0> F0(List<kotlin.s0.w.d.l0.n.e0> r1) {
        if (r1 == null) goto L8;
        if (r1 == null) goto L6;
        return r1;
    L6:
        F(13);
        throw null;
    L8:
        F(12);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.m
    public <R, D> R K(kotlin.s0.w.d.l0.c.o<R, D> r1, D r2) {
        return r1.m(this, r2);
    }

    protected abstract void L0(kotlin.s0.w.d.l0.n.e0 r1);

    protected abstract List<kotlin.s0.w.d.l0.n.e0> M0();

    @Override // kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public f1 a() {
        f1 r0 = (f1) super.A0();
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(11);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.h a() {
        return a();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.m a() {
        return a();
    }

    @Override // kotlin.s0.w.d.l0.c.f1
    public List<kotlin.s0.w.d.l0.n.e0> getUpperBounds() {
        List<kotlin.s0.w.d.l0.n.e0> r0 = ((c) k()).r();
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(8);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.f1
    public kotlin.s0.w.d.l0.m.n h0() {
        kotlin.s0.w.d.l0.m.n r0 = this.o;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(14);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.f1
    public int j() {
        return this.f18986l;
    }

    @Override // kotlin.s0.w.d.l0.c.f1, kotlin.s0.w.d.l0.c.h
    public final e1 k() {
        e1 r0 = this.m.invoke();
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(9);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.f1
    public r1 n() {
        r1 r0 = this.f18984j;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(7);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.f1
    public boolean o0() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.h
    public kotlin.s0.w.d.l0.n.m0 s() {
        kotlin.s0.w.d.l0.n.m0 r0 = this.n.invoke();
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(10);
        throw null;
    }
}
