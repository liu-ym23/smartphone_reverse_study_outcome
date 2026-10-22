package kotlin.s0.w.d.l0.f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends kotlin.s0.w.d.l0.i.i implements kotlin.s0.w.d.l0.i.r {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final b f19892l = null;
    public static kotlin.s0.w.d.l0.i.s<b> m;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.i.d f19893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f19894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f19895h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<C0541b> f19896i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private byte f19897j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f19898k;

    static class a extends kotlin.s0.w.d.l0.i.b<b> {
        a() {
        }

        @Override // kotlin.s0.w.d.l0.i.s
        public /* bridge */ /* synthetic */ Object b(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            return m(r1, r2);
        }

        public b m(kotlin.s0.w.d.l0.i.e r2, kotlin.s0.w.d.l0.i.g r3) {
            return new b(r2, r3, null);
        }
    }

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.f.b$b, reason: collision with other inner class name */
    public static final class C0541b extends kotlin.s0.w.d.l0.i.i implements kotlin.s0.w.d.l0.i.r {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final C0541b f19899l = null;
        public static kotlin.s0.w.d.l0.i.s<C0541b> m;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.i.d f19900f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f19901g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f19902h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private c f19903i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private byte f19904j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f19905k;

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.f.b$b$a */
        static class a extends kotlin.s0.w.d.l0.i.b<C0541b> {
            a() {
            }

            @Override // kotlin.s0.w.d.l0.i.s
            public /* bridge */ /* synthetic */ Object b(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
                return m(r1, r2);
            }

            public C0541b m(kotlin.s0.w.d.l0.i.e r2, kotlin.s0.w.d.l0.i.g r3) {
                return new C0541b(r2, r3, null);
            }
        }

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.f.b$b$b, reason: collision with other inner class name */
        public static final class C0542b extends kotlin.s0.w.d.l0.i.i.b<C0541b, C0542b> implements Object {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private int f19906g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private int f19907h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private c f19908i;

            private C0542b() {
                this.f19908i = c.L();
                v();
            }

            static /* synthetic */ C0542b p() {
                return u();
            }

            private static C0542b u() {
                return new C0542b();
            }

            private void v() {
            }

            public C0542b B(int r2) {
                this.f19906g |= 1;
                this.f19907h = r2;
                return this;
            }

            @Override // kotlin.s0.w.d.l0.i.q.a
            public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q build() {
                return q();
            }

            @Override // kotlin.s0.w.d.l0.i.i.b
            public /* bridge */ /* synthetic */ Object clone() {
                return t();
            }

            @Override // kotlin.s0.w.d.l0.i.a.AbstractC0550a
            public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.a.AbstractC0550a i(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
                y(r1, r2);
                return this;
            }

            @Override // kotlin.s0.w.d.l0.i.i.b
            public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b k() {
                return t();
            }

            @Override // kotlin.s0.w.d.l0.i.i.b
            public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b n(kotlin.s0.w.d.l0.i.i r1) {
                w((C0541b) r1);
                return this;
            }

            public C0541b q() {
                C0541b r1 = r();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw kotlin.s0.w.d.l0.i.a.AbstractC0550a.j(r1);
            }

            public C0541b r() {
                C0541b r0 = new C0541b(this, null);
                int r1 = this.f19906g;
                int r3 = 1;
                if ((r1 & 1) == 1) goto L6;
                r3 = 0;
            L6:
                C0541b.q(r0, this.f19907h);
                if ((r1 & 2) != 2) goto L9;
                r3 = r3 | 2;
            L9:
                C0541b.r(r0, this.f19908i);
                C0541b.s(r0, r3);
                return r0;
            }

            public C0542b t() {
                C0542b r0 = u();
                r0.w(r());
                return r0;
            }

            public C0542b w(C0541b r2) {
                if (r2 != C0541b.u()) goto L6;
                return this;
            L6:
                if (r2.y() == false) goto L9;
                B(r2.v());
            L9:
                if (r2.z() == false) goto L11;
                z(r2.w());
            L11:
                o(m().b(C0541b.t(r2)));
                return this;
            }

            @Override // kotlin.s0.w.d.l0.i.a.AbstractC0550a, kotlin.s0.w.d.l0.i.q.a
            public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a x(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
                y(r1, r2);
                return this;
            }

            public C0542b y(kotlin.s0.w.d.l0.i.e r3, kotlin.s0.w.d.l0.i.g r4) {
                C0541b r0 = null;
                C0541b r5 = C0541b.m.b(r3, r4);     // Catch: Throwable -> L7 kotlin.s0.w.d.l0.i.k -> L9
                if (r5 == null) goto L6;
                w(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                C0541b r6 = (C0541b) e.a();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r0 = r6;
            L14:
                if (r0 == null) goto L16;
                w(r0);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            public C0542b z(c r4) {
                if ((this.f19906g & 2) == 2) goto L5;
            L7:
                this.f19908i = r4;
                this.f19906g |= 2;
                return this;
            L5:
                if (this.f19908i == c.L()) goto L7;
                c.C0543b r0 = c.f0(this.f19908i);
                r0.z(r4);
                r4 = r0.r();
                goto L7
            }
        }

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.f.b$b$c */
        public static final class c extends kotlin.s0.w.d.l0.i.i implements kotlin.s0.w.d.l0.i.r {
            private static final c u = null;
            public static kotlin.s0.w.d.l0.i.s<c> v;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final kotlin.s0.w.d.l0.i.d f19909f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private int f19910g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private EnumC0544c f19911h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private long f19912i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private float f19913j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private double f19914k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            private int f19915l;
            private int m;
            private int n;
            private b o;
            private List<c> p;
            private int q;
            private int r;
            private byte s;
            private int t;

            /* JADX INFO: renamed from: kotlin.s0.w.d.l0.f.b$b$c$a */
            static class a extends kotlin.s0.w.d.l0.i.b<c> {
                a() {
                }

                @Override // kotlin.s0.w.d.l0.i.s
                public /* bridge */ /* synthetic */ Object b(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
                    return m(r1, r2);
                }

                public c m(kotlin.s0.w.d.l0.i.e r2, kotlin.s0.w.d.l0.i.g r3) {
                    return new c(r2, r3, null);
                }
            }

            /* JADX INFO: renamed from: kotlin.s0.w.d.l0.f.b$b$c$b, reason: collision with other inner class name */
            public static final class C0543b extends kotlin.s0.w.d.l0.i.i.b<c, C0543b> implements Object {

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                private int f19916g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                private EnumC0544c f19917h;

                /* JADX INFO: renamed from: i, reason: collision with root package name */
                private long f19918i;

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                private float f19919j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                private double f19920k;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                private int f19921l;
                private int m;
                private int n;
                private b o;
                private List<c> p;
                private int q;
                private int r;

                private C0543b() {
                    this.f19917h = EnumC0544c.f19922g;
                    this.o = b.z();
                    this.p = Collections.emptyList();
                    w();
                }

                static /* synthetic */ C0543b p() {
                    return u();
                }

                private static C0543b u() {
                    return new C0543b();
                }

                private void v() {
                    if ((this.f19916g & 256) == 256) goto L6;
                    this.p = new ArrayList(this.p);
                    this.f19916g |= 256;
                    return;
                }

                private void w() {
                }

                public C0543b B(kotlin.s0.w.d.l0.i.e r3, kotlin.s0.w.d.l0.i.g r4) {
                    c r0 = null;
                    c r5 = c.v.b(r3, r4);     // Catch: Throwable -> L7 kotlin.s0.w.d.l0.i.k -> L9
                    if (r5 == null) goto L6;
                    z(r5);
                L6:
                    return this;
                L9:
                    e = move-exception;
                    c r6 = (c) e.a();     // Catch: Throwable -> L7
                    throw e;     // Catch: Throwable -> L12
                L12:
                    th = th;
                    r0 = r6;
                L14:
                    if (r0 == null) goto L16;
                    z(r0);
                L16:
                    throw th;
                L7:
                    th = th;
                    goto L14
                }

                public C0543b C(int r2) {
                    this.f19916g |= 512;
                    this.q = r2;
                    return this;
                }

                public C0543b D(int r2) {
                    this.f19916g |= 32;
                    this.m = r2;
                    return this;
                }

                public C0543b E(double r2) {
                    this.f19916g |= 8;
                    this.f19920k = r2;
                    return this;
                }

                public C0543b F(int r2) {
                    this.f19916g |= 64;
                    this.n = r2;
                    return this;
                }

                public C0543b G(int r2) {
                    this.f19916g |= 1024;
                    this.r = r2;
                    return this;
                }

                public C0543b H(float r2) {
                    this.f19916g |= 4;
                    this.f19919j = r2;
                    return this;
                }

                public C0543b I(long r2) {
                    this.f19916g |= 2;
                    this.f19918i = r2;
                    return this;
                }

                public C0543b J(int r2) {
                    this.f19916g |= 16;
                    this.f19921l = r2;
                    return this;
                }

                public C0543b K(EnumC0544c r2) {
                    Objects.requireNonNull(r2);
                    this.f19916g |= 1;
                    this.f19917h = r2;
                    return this;
                }

                @Override // kotlin.s0.w.d.l0.i.q.a
                public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q build() {
                    return q();
                }

                @Override // kotlin.s0.w.d.l0.i.i.b
                public /* bridge */ /* synthetic */ Object clone() {
                    return t();
                }

                @Override // kotlin.s0.w.d.l0.i.a.AbstractC0550a
                public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.a.AbstractC0550a i(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
                    B(r1, r2);
                    return this;
                }

                @Override // kotlin.s0.w.d.l0.i.i.b
                public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b k() {
                    return t();
                }

                @Override // kotlin.s0.w.d.l0.i.i.b
                public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b n(kotlin.s0.w.d.l0.i.i r1) {
                    z((c) r1);
                    return this;
                }

                public c q() {
                    c r1 = r();
                    if (r1.isInitialized() == false) goto L6;
                    return r1;
                L6:
                    throw kotlin.s0.w.d.l0.i.a.AbstractC0550a.j(r1);
                }

                public c r() {
                    c r0 = new c(this, null);
                    int r1 = this.f19916g;
                    int r3 = 1;
                    if ((r1 & 1) == 1) goto L6;
                    r3 = 0;
                L6:
                    c.q(r0, this.f19917h);
                    if ((r1 & 2) != 2) goto L9;
                    r3 = r3 | 2;
                L9:
                    c.r(r0, this.f19918i);
                    if ((r1 & 4) != 4) goto L12;
                    r3 = r3 | 4;
                L12:
                    c.s(r0, this.f19919j);
                    if ((r1 & 8) != 8) goto L15;
                    r3 = r3 | 8;
                L15:
                    c.t(r0, this.f19920k);
                    if ((r1 & 16) != 16) goto L18;
                    r3 = r3 | 16;
                L18:
                    c.u(r0, this.f19921l);
                    if ((r1 & 32) != 32) goto L21;
                    r3 = r3 | 32;
                L21:
                    c.v(r0, this.m);
                    if ((r1 & 64) != 64) goto L24;
                    r3 = r3 | 64;
                L24:
                    c.w(r0, this.n);
                    if ((r1 & 128) != 128) goto L27;
                    r3 = r3 | 128;
                L27:
                    c.y(r0, this.o);
                    if ((this.f19916g & 256) != 256) goto L30;
                    this.p = Collections.unmodifiableList(this.p);
                    this.f19916g &= -257;
                L30:
                    c.A(r0, this.p);
                    if ((r1 & 512) != 512) goto L33;
                    r3 = r3 | 256;
                L33:
                    c.B(r0, this.q);
                    if ((r1 & 1024) != 1024) goto L36;
                    r3 = r3 | 512;
                L36:
                    c.C(r0, this.r);
                    c.D(r0, r3);
                    return r0;
                }

                public C0543b t() {
                    C0543b r0 = u();
                    r0.z(r());
                    return r0;
                }

                @Override // kotlin.s0.w.d.l0.i.a.AbstractC0550a, kotlin.s0.w.d.l0.i.q.a
                public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a x(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
                    B(r1, r2);
                    return this;
                }

                public C0543b y(b r4) {
                    if ((this.f19916g & 128) == 128) goto L5;
                L7:
                    this.o = r4;
                    this.f19916g |= 128;
                    return this;
                L5:
                    if (this.o == b.z()) goto L7;
                    c r0 = b.E(this.o);
                    r0.y(r4);
                    r4 = r0.r();
                    goto L7
                }

                public C0543b z(c r3) {
                    if (r3 != c.L()) goto L6;
                    return this;
                L6:
                    if (r3.c0() == false) goto L9;
                    K(r3.S());
                L9:
                    if (r3.a0() == false) goto L12;
                    I(r3.Q());
                L12:
                    if (r3.Z() == false) goto L15;
                    H(r3.P());
                L15:
                    if (r3.W() == false) goto L18;
                    E(r3.M());
                L18:
                    if (r3.b0() == false) goto L21;
                    J(r3.R());
                L21:
                    if (r3.V() == false) goto L24;
                    D(r3.K());
                L24:
                    if (r3.X() == false) goto L27;
                    F(r3.N());
                L27:
                    if (r3.T() == false) goto L30;
                    y(r3.F());
                L30:
                    if (c.z(r3).isEmpty() == true) goto L36;
                    if (this.p.isEmpty() == false) goto L34;
                    this.p = c.z(r3);
                    this.f19916g &= -257;
                    goto L36
                L34:
                    v();
                    this.p.addAll(c.z(r3));
                L36:
                    if (r3.U() == false) goto L39;
                    C(r3.G());
                L39:
                    if (r3.Y() == false) goto L41;
                    G(r3.O());
                L41:
                    o(m().b(c.E(r3)));
                    return this;
                }
            }

            /* JADX INFO: renamed from: kotlin.s0.w.d.l0.f.b$b$c$c, reason: collision with other inner class name */
            public static final enum EnumC0544c extends Enum<EnumC0544c> implements kotlin.s0.w.d.l0.i.j.a {

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                public static final EnumC0544c f19922g = null;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                public static final EnumC0544c f19923h = null;

                /* JADX INFO: renamed from: i, reason: collision with root package name */
                public static final EnumC0544c f19924i = null;

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public static final EnumC0544c f19925j = null;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public static final EnumC0544c f19926k = null;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                public static final EnumC0544c f19927l = null;
                public static final EnumC0544c m = null;
                public static final EnumC0544c n = null;
                public static final EnumC0544c o = null;
                public static final EnumC0544c p = null;
                public static final EnumC0544c q = null;
                public static final EnumC0544c r = null;
                public static final EnumC0544c s = null;
                private static final /* synthetic */ EnumC0544c[] t = null;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final int f19928f;

                static {
                    EnumC0544c r0 = new EnumC0544c("BYTE", 0, 0, 0);
                    f19922g = r0;
                    EnumC0544c r1 = new EnumC0544c("CHAR", 1, 1, 1);
                    f19923h = r1;
                    EnumC0544c r3 = new EnumC0544c("SHORT", 2, 2, 2);
                    f19924i = r3;
                    EnumC0544c r5 = new EnumC0544c("INT", 3, 3, 3);
                    f19925j = r5;
                    EnumC0544c r7 = new EnumC0544c("LONG", 4, 4, 4);
                    f19926k = r7;
                    EnumC0544c r9 = new EnumC0544c("FLOAT", 5, 5, 5);
                    f19927l = r9;
                    EnumC0544c r11 = new EnumC0544c("DOUBLE", 6, 6, 6);
                    m = r11;
                    EnumC0544c r13 = new EnumC0544c("BOOLEAN", 7, 7, 7);
                    n = r13;
                    EnumC0544c r15 = new EnumC0544c("STRING", 8, 8, 8);
                    o = r15;
                    EnumC0544c r14 = new EnumC0544c("CLASS", 9, 9, 9);
                    p = r14;
                    EnumC0544c r12 = new EnumC0544c("ENUM", 10, 10, 10);
                    q = r12;
                    EnumC0544c r10 = new EnumC0544c("ANNOTATION", 11, 11, 11);
                    r = r10;
                    EnumC0544c r8 = new EnumC0544c("ARRAY", 12, 12, 12);
                    s = r8;
                    t = new EnumC0544c[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
                }

                private EnumC0544c(String r1, int r2, int r3, int r4) {
                    super(r1, r2);
                    this.f19928f = r4;
                }

                public static EnumC0544c a(int r0) {
                    switch(r0) {
                        case 0: goto L30;
                        case 1: goto L28;
                        case 2: goto L26;
                        case 3: goto L24;
                        case 4: goto L22;
                        case 5: goto L20;
                        case 6: goto L18;
                        case 7: goto L16;
                        case 8: goto L14;
                        case 9: goto L12;
                        case 10: goto L10;
                        case 11: goto L8;
                        case 12: goto L6;
                        default: goto L3;
                    };
                L3:
                    return null;
                L6:
                    return s;
                L8:
                    return r;
                L10:
                    return q;
                L12:
                    return p;
                L14:
                    return o;
                L16:
                    return n;
                L18:
                    return m;
                L20:
                    return f19927l;
                L22:
                    return f19926k;
                L24:
                    return f19925j;
                L26:
                    return f19924i;
                L28:
                    return f19923h;
                L30:
                    return f19922g;
                }

                public static EnumC0544c valueOf(String r1) {
                    return (EnumC0544c) Enum.valueOf(EnumC0544c.class, r1);
                }

                public static EnumC0544c[] values() {
                    return (EnumC0544c[]) t.clone();
                }

                @Override // kotlin.s0.w.d.l0.i.j.a
                public final int d() {
                    return this.f19928f;
                }
            }

            static {
                v = new a();
                c r0 = new c(true);
                u = r0;
                r0.d0();
            }

            private c(kotlin.s0.w.d.l0.i.e r10, kotlin.s0.w.d.l0.i.g r11) {
                this.s = -1;
                this.t = -1;
                d0();
                kotlin.s0.w.d.l0.i.d.b r0 = kotlin.s0.w.d.l0.i.d.t();
                kotlin.s0.w.d.l0.i.f r2 = kotlin.s0.w.d.l0.i.f.J(r0, 1);
                boolean r3 = false;
                int r4 = 0;
            L4:
                if (r3 == true) goto L54;
                int r6 = r10.K();     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                switch(r6) {
                    case 0: goto L32;
                    case 8: goto L27;
                    case 16: goto L26;
                    case 29: goto L25;
                    case 33: goto L24;
                    case 40: goto L23;
                    case 48: goto L22;
                    case 56: goto L21;
                    case 66: goto L14;
                    case 74: goto L11;
                    case 80: goto L9;
                    case 88: goto L8;
                    default: goto L33;
                };     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
            L8:
                this.f19910g |= 256;     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                this.q = r10.s();     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                goto L4
            L9:
                this.f19910g |= 512;     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                this.r = r10.s();     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                goto L4
            L11:
                if ((r4 & 256) == 256) goto L13;
                this.p = new ArrayList();     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                r4 = r4 | 256;     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
            L13:
                this.p.add((c) r10.u(v, r11));     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                goto L4
            L14:
                c r7 = null;
                if ((this.f19910g & 128) != 128) goto L17;
                r7 = this.o.G();     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
            L17:
                b r8 = (b) r10.u(b.m, r11);     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                this.o = r8;     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                if (r7 == null) goto L20;
                r7.y(r8);     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                this.o = r7.r();     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
            L20:
                this.f19910g |= 128;     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                goto L4
            L21:
                this.f19910g |= 64;     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                this.n = r10.s();     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                goto L4
            L22:
                this.f19910g |= 32;     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                this.m = r10.s();     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                goto L4
            L23:
                this.f19910g |= 16;     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                this.f19915l = r10.s();     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                goto L4
            L24:
                this.f19910g |= 8;     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                this.f19914k = r10.m();     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                goto L4
            L25:
                this.f19910g |= 4;     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                this.f19913j = r10.q();     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                goto L4
            L26:
                this.f19910g |= 2;     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                this.f19912i = r10.H();     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                goto L4
            L27:
                int r9 = r10.n();     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                EnumC0544c r12 = EnumC0544c.a(r9);     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                if (r12 == null) goto L29;
                this.f19910g |= 1;     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                this.f19911h = r12;     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                goto L4
            L29:
                r2.o0(r6);     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
                r2.o0(r9);     // Catch: Throwable -> L35 IOException -> L37 kotlin.s0.w.d.l0.i.k -> L40
            L32:
                r3 = true;
                goto L4
            L33:
                if (o(r10, r2, r11, r6) == true) goto L4;
            L35:
                th = move-exception;
                if ((r4 & 256) != 256) goto L66;
                this.p = Collections.unmodifiableList(this.p);
            L66:
                r2.I();     // Catch: IOException -> L64 Throwable -> L48
            L48:
                th = move-exception;
                this.f19909f = r0.l();
                throw th;
            L47:
                this.f19909f = r0.l();
                l();
                throw th;
            L40:
                e = move-exception;
                e.i(this);     // Catch: Throwable -> L35
                throw e;     // Catch: Throwable -> L35
            L37:
                e = move-exception;
                kotlin.s0.w.d.l0.i.k r13 = new kotlin.s0.w.d.l0.i.k(e.getMessage());     // Catch: Throwable -> L35
                r13.i(this);     // Catch: Throwable -> L35
                throw r13;     // Catch: Throwable -> L35
            L54:
                if ((r4 & 256) != 256) goto L68;
                this.p = Collections.unmodifiableList(this.p);
            L68:
                r2.I();     // Catch: IOException -> L63 Throwable -> L58
            L58:
                th = move-exception;
                this.f19909f = r0.l();
                throw th;
            L57:
                this.f19909f = r0.l();
                l();
            }

            /* synthetic */ c(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2, kotlin.s0.w.d.l0.f.a r3) {
                this(r1, r2);
            }

            private c(kotlin.s0.w.d.l0.i.i.b r2) {
                super(r2);
                this.s = -1;
                this.t = -1;
                this.f19909f = r2.m();
            }

            /* synthetic */ c(kotlin.s0.w.d.l0.i.i.b r1, kotlin.s0.w.d.l0.f.a r2) {
                this(r1);
            }

            private c(boolean r1) {
                this.s = -1;
                this.t = -1;
                this.f19909f = kotlin.s0.w.d.l0.i.d.f20305f;
            }

            static /* synthetic */ List A(c r0, List r1) {
                r0.p = r1;
                return r1;
            }

            static /* synthetic */ int B(c r0, int r1) {
                r0.q = r1;
                return r1;
            }

            static /* synthetic */ int C(c r0, int r1) {
                r0.r = r1;
                return r1;
            }

            static /* synthetic */ int D(c r0, int r1) {
                r0.f19910g = r1;
                return r1;
            }

            static /* synthetic */ kotlin.s0.w.d.l0.i.d E(c r0) {
                return r0.f19909f;
            }

            public static c L() {
                return u;
            }

            private void d0() {
                this.f19911h = EnumC0544c.f19922g;
                this.f19912i = 0;
                this.f19913j = 0.0f;
                this.f19914k = 0.0d;
                this.f19915l = 0;
                this.m = 0;
                this.n = 0;
                this.o = b.z();
                this.p = Collections.emptyList();
                this.q = 0;
                this.r = 0;
            }

            public static C0543b e0() {
                return C0543b.p();
            }

            public static C0543b f0(c r1) {
                C0543b r0 = e0();
                r0.z(r1);
                return r0;
            }

            static /* synthetic */ EnumC0544c q(c r0, EnumC0544c r1) {
                r0.f19911h = r1;
                return r1;
            }

            static /* synthetic */ long r(c r0, long r1) {
                r0.f19912i = r1;
                return r1;
            }

            static /* synthetic */ float s(c r0, float r1) {
                r0.f19913j = r1;
                return r1;
            }

            static /* synthetic */ double t(c r0, double r1) {
                r0.f19914k = r1;
                return r1;
            }

            static /* synthetic */ int u(c r0, int r1) {
                r0.f19915l = r1;
                return r1;
            }

            static /* synthetic */ int v(c r0, int r1) {
                r0.m = r1;
                return r1;
            }

            static /* synthetic */ int w(c r0, int r1) {
                r0.n = r1;
                return r1;
            }

            static /* synthetic */ b y(c r0, b r1) {
                r0.o = r1;
                return r1;
            }

            static /* synthetic */ List z(c r0) {
                return r0.p;
            }

            public b F() {
                return this.o;
            }

            public int G() {
                return this.q;
            }

            public c H(int r1) {
                return this.p.get(r1);
            }

            public int I() {
                return this.p.size();
            }

            public List<c> J() {
                return this.p;
            }

            public int K() {
                return this.m;
            }

            public double M() {
                return this.f19914k;
            }

            public int N() {
                return this.n;
            }

            public int O() {
                return this.r;
            }

            public float P() {
                return this.f19913j;
            }

            public long Q() {
                return this.f19912i;
            }

            public int R() {
                return this.f19915l;
            }

            public EnumC0544c S() {
                return this.f19911h;
            }

            public boolean T() {
                if ((this.f19910g & 128) != 128) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean U() {
                if ((this.f19910g & 256) != 256) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean V() {
                if ((this.f19910g & 32) != 32) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean W() {
                if ((this.f19910g & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean X() {
                if ((this.f19910g & 64) != 64) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean Y() {
                if ((this.f19910g & 512) != 512) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean Z() {
                if ((this.f19910g & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean a0() {
                if ((this.f19910g & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean b0() {
                if ((this.f19910g & 16) != 16) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // kotlin.s0.w.d.l0.i.q
            public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a c() {
                return h0();
            }

            public boolean c0() {
                if ((this.f19910g & 1) == 1) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // kotlin.s0.w.d.l0.i.q
            public void d(kotlin.s0.w.d.l0.i.f r6) {
                e();
                if ((this.f19910g & 1) != 1) goto L6;
                r6.S(1, this.f19911h.d());
            L6:
                if ((this.f19910g & 2) != 2) goto L9;
                r6.t0(2, this.f19912i);
            L9:
                if ((this.f19910g & 4) != 4) goto L12;
                r6.W(3, this.f19913j);
            L12:
                if ((this.f19910g & 8) != 8) goto L15;
                r6.Q(4, this.f19914k);
            L15:
                if ((this.f19910g & 16) != 16) goto L18;
                r6.a0(5, this.f19915l);
            L18:
                if ((this.f19910g & 32) != 32) goto L21;
                r6.a0(6, this.m);
            L21:
                if ((this.f19910g & 64) != 64) goto L24;
                r6.a0(7, this.n);
            L24:
                if ((this.f19910g & 128) != 128) goto L26;
                r6.d0(8, this.o);
            L26:
                int r0 = 0;
            L28:
                if (r0 >= this.p.size()) goto L31;
                r6.d0(9, this.p.get(r0));
                r0 = r0 + 1;
                goto L28
            L31:
                if ((this.f19910g & 512) != 512) goto L34;
                r6.a0(10, this.r);
            L34:
                if ((this.f19910g & 256) != 256) goto L36;
                r6.a0(11, this.q);
            L36:
                r6.i0(this.f19909f);
            }

            @Override // kotlin.s0.w.d.l0.i.q
            public int e() {
                int r0 = this.t;
                if (r0 == (-1)) goto L5;
                return r0;
            L5:
                int r2 = 0;
                if ((this.f19910g & 1) != 1) goto L8;
                int r1 = kotlin.s0.w.d.l0.i.f.h(1, this.f19911h.d()) + 0;
            L10:
                if ((this.f19910g & 2) != 2) goto L13;
                r1 = r1 + kotlin.s0.w.d.l0.i.f.A(2, this.f19912i);
            L13:
                if ((this.f19910g & 4) != 4) goto L16;
                r1 = r1 + kotlin.s0.w.d.l0.i.f.l(3, this.f19913j);
            L16:
                if ((this.f19910g & 8) != 8) goto L19;
                r1 = r1 + kotlin.s0.w.d.l0.i.f.f(4, this.f19914k);
            L19:
                if ((this.f19910g & 16) != 16) goto L22;
                r1 = r1 + kotlin.s0.w.d.l0.i.f.o(5, this.f19915l);
            L22:
                if ((this.f19910g & 32) != 32) goto L25;
                r1 = r1 + kotlin.s0.w.d.l0.i.f.o(6, this.m);
            L25:
                if ((this.f19910g & 64) != 64) goto L28;
                r1 = r1 + kotlin.s0.w.d.l0.i.f.o(7, this.n);
            L28:
                if ((this.f19910g & 128) != 128) goto L31;
                r1 = r1 + kotlin.s0.w.d.l0.i.f.s(8, this.o);
            L31:
                if (r2 >= this.p.size()) goto L34;
                r1 = r1 + kotlin.s0.w.d.l0.i.f.s(9, this.p.get(r2));
                r2 = r2 + 1;
                goto L31
            L34:
                if ((this.f19910g & 512) != 512) goto L37;
                r1 = r1 + kotlin.s0.w.d.l0.i.f.o(10, this.r);
            L37:
                if ((this.f19910g & 256) != 256) goto L39;
                r1 = r1 + kotlin.s0.w.d.l0.i.f.o(11, this.q);
            L39:
                int r3 = r1 + this.f19909f.size();
                this.t = r3;
                return r3;
            L8:
                r1 = 0;
                goto L10
            }

            @Override // kotlin.s0.w.d.l0.i.q
            public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a f() {
                return g0();
            }

            public C0543b g0() {
                return e0();
            }

            @Override // kotlin.s0.w.d.l0.i.i, kotlin.s0.w.d.l0.i.q
            public kotlin.s0.w.d.l0.i.s<c> h() {
                return v;
            }

            public C0543b h0() {
                return f0(this);
            }

            @Override // kotlin.s0.w.d.l0.i.r
            public final boolean isInitialized() {
                byte r0 = this.s;
                if (r0 != 1) goto L6;
                return true;
            L6:
                if (r0 != 0) goto L9;
                return false;
            L9:
                if (T() == true) goto L11;
            L14:
                int r1 = 0;
            L16:
                if (r1 >= I()) goto L22;
                if (H(r1).isInitialized() == false) goto L19;
                r1 = r1 + 1;
                goto L16
            L19:
                this.s = 0;
                return false;
            L22:
                this.s = 1;
                return true;
            L11:
                if (F().isInitialized() == true) goto L14;
                this.s = 0;
                return false;
            }
        }

        static {
            m = new a();
            C0541b r0 = new C0541b(true);
            f19899l = r0;
            r0.A();
        }

        private C0541b(kotlin.s0.w.d.l0.i.e r8, kotlin.s0.w.d.l0.i.g r9) {
            this.f19904j = -1;
            this.f19905k = -1;
            A();
            kotlin.s0.w.d.l0.i.d.b r0 = kotlin.s0.w.d.l0.i.d.t();
            kotlin.s0.w.d.l0.i.f r2 = kotlin.s0.w.d.l0.i.f.J(r0, 1);
            boolean r3 = false;
        L3:
            if (r3 == true) goto L51;
            int r4 = r8.K();     // Catch: Throwable -> L23 IOException -> L25 kotlin.s0.w.d.l0.i.k -> L28
            if (r4 == 0) goto L22;
            if (r4 != 8) goto L9;
            this.f19901g |= 1;     // Catch: Throwable -> L23 IOException -> L25 kotlin.s0.w.d.l0.i.k -> L28
            this.f19902h = r8.s();     // Catch: Throwable -> L23 IOException -> L25 kotlin.s0.w.d.l0.i.k -> L28
            goto L3
        L9:
            if (r4 != 18) goto L11;
            c.C0543b r5 = null;
            if ((this.f19901g & 2) != 2) goto L16;
            r5 = this.f19903i.h0();     // Catch: Throwable -> L23 IOException -> L25 kotlin.s0.w.d.l0.i.k -> L28
        L16:
            c r6 = (c) r8.u(c.v, r9);     // Catch: Throwable -> L23 IOException -> L25 kotlin.s0.w.d.l0.i.k -> L28
            this.f19903i = r6;     // Catch: Throwable -> L23 IOException -> L25 kotlin.s0.w.d.l0.i.k -> L28
            if (r5 == null) goto L19;
            r5.z(r6);     // Catch: Throwable -> L23 IOException -> L25 kotlin.s0.w.d.l0.i.k -> L28
            this.f19903i = r5.r();     // Catch: Throwable -> L23 IOException -> L25 kotlin.s0.w.d.l0.i.k -> L28
        L19:
            this.f19901g |= 2;     // Catch: Throwable -> L23 IOException -> L25 kotlin.s0.w.d.l0.i.k -> L28
            goto L3
        L11:
            if (o(r8, r2, r9, r4) == true) goto L3;
        L22:
            r3 = true;
            goto L3
        L23:
            th = move-exception;
            r2.I();     // Catch: IOException -> L45 Throwable -> L33
        L33:
            th = move-exception;
            this.f19900f = r0.l();
            throw th;
        L32:
            this.f19900f = r0.l();
            l();
            throw th;
        L28:
            e = move-exception;
            e.i(this);     // Catch: Throwable -> L23
            throw e;     // Catch: Throwable -> L23
        L25:
            e = move-exception;
            kotlin.s0.w.d.l0.i.k r10 = new kotlin.s0.w.d.l0.i.k(e.getMessage());     // Catch: Throwable -> L23
            r10.i(this);     // Catch: Throwable -> L23
            throw r10;     // Catch: Throwable -> L23
        L51:
            r2.I();     // Catch: IOException -> L46 Throwable -> L40
        L40:
            th = move-exception;
            this.f19900f = r0.l();
            throw th;
        L39:
            this.f19900f = r0.l();
            l();
        }

        /* synthetic */ C0541b(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2, kotlin.s0.w.d.l0.f.a r3) {
            this(r1, r2);
        }

        private C0541b(kotlin.s0.w.d.l0.i.i.b r2) {
            super(r2);
            this.f19904j = -1;
            this.f19905k = -1;
            this.f19900f = r2.m();
        }

        /* synthetic */ C0541b(kotlin.s0.w.d.l0.i.i.b r1, kotlin.s0.w.d.l0.f.a r2) {
            this(r1);
        }

        private C0541b(boolean r1) {
            this.f19904j = -1;
            this.f19905k = -1;
            this.f19900f = kotlin.s0.w.d.l0.i.d.f20305f;
        }

        private void A() {
            this.f19902h = 0;
            this.f19903i = c.L();
        }

        public static C0542b B() {
            return C0542b.p();
        }

        public static C0542b C(C0541b r1) {
            C0542b r0 = B();
            r0.w(r1);
            return r0;
        }

        static /* synthetic */ int q(C0541b r0, int r1) {
            r0.f19902h = r1;
            return r1;
        }

        static /* synthetic */ c r(C0541b r0, c r1) {
            r0.f19903i = r1;
            return r1;
        }

        static /* synthetic */ int s(C0541b r0, int r1) {
            r0.f19901g = r1;
            return r1;
        }

        static /* synthetic */ kotlin.s0.w.d.l0.i.d t(C0541b r0) {
            return r0.f19900f;
        }

        public static C0541b u() {
            return f19899l;
        }

        public C0542b D() {
            return B();
        }

        public C0542b E() {
            return C(this);
        }

        @Override // kotlin.s0.w.d.l0.i.q
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a c() {
            return E();
        }

        @Override // kotlin.s0.w.d.l0.i.q
        public void d(kotlin.s0.w.d.l0.i.f r3) {
            e();
            if ((this.f19901g & 1) != 1) goto L6;
            r3.a0(1, this.f19902h);
        L6:
            if ((this.f19901g & 2) != 2) goto L8;
            r3.d0(2, this.f19903i);
        L8:
            r3.i0(this.f19900f);
        }

        @Override // kotlin.s0.w.d.l0.i.q
        public int e() {
            int r0 = this.f19905k;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r1 = 0;
            if ((this.f19901g & 1) != 1) goto L9;
            r1 = 0 + kotlin.s0.w.d.l0.i.f.o(1, this.f19902h);
        L9:
            if ((this.f19901g & 2) != 2) goto L11;
            r1 = r1 + kotlin.s0.w.d.l0.i.f.s(2, this.f19903i);
        L11:
            int r2 = r1 + this.f19900f.size();
            this.f19905k = r2;
            return r2;
        }

        @Override // kotlin.s0.w.d.l0.i.q
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a f() {
            return D();
        }

        @Override // kotlin.s0.w.d.l0.i.i, kotlin.s0.w.d.l0.i.q
        public kotlin.s0.w.d.l0.i.s<C0541b> h() {
            return m;
        }

        @Override // kotlin.s0.w.d.l0.i.r
        public final boolean isInitialized() {
            byte r0 = this.f19904j;
            if (r0 != 1) goto L6;
            return true;
        L6:
            if (r0 != 0) goto L9;
            return false;
        L9:
            if (y() == true) goto L13;
            this.f19904j = 0;
            return false;
        L13:
            if (z() == true) goto L17;
            this.f19904j = 0;
            return false;
        L17:
            if (w().isInitialized() == true) goto L20;
            this.f19904j = 0;
            return false;
        L20:
            this.f19904j = 1;
            return true;
        }

        public int v() {
            return this.f19902h;
        }

        public c w() {
            return this.f19903i;
        }

        public boolean y() {
            if ((this.f19901g & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean z() {
            if ((this.f19901g & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class c extends kotlin.s0.w.d.l0.i.i.b<b, c> implements Object {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f19929g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f19930h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private List<C0541b> f19931i;

        private c() {
            this.f19931i = Collections.emptyList();
            w();
        }

        static /* synthetic */ c p() {
            return u();
        }

        private static c u() {
            return new c();
        }

        private void v() {
            if ((this.f19929g & 2) == 2) goto L6;
            this.f19931i = new ArrayList(this.f19931i);
            this.f19929g |= 2;
            return;
        }

        private void w() {
        }

        public c B(int r2) {
            this.f19929g |= 1;
            this.f19930h = r2;
            return this;
        }

        @Override // kotlin.s0.w.d.l0.i.q.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q build() {
            return q();
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ Object clone() {
            return t();
        }

        @Override // kotlin.s0.w.d.l0.i.a.AbstractC0550a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.a.AbstractC0550a i(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            z(r1, r2);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b k() {
            return t();
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b n(kotlin.s0.w.d.l0.i.i r1) {
            y((b) r1);
            return this;
        }

        public b q() {
            b r1 = r();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw kotlin.s0.w.d.l0.i.a.AbstractC0550a.j(r1);
        }

        public b r() {
            b r0 = new b(this, null);
            int r2 = 1;
            if ((this.f19929g & 1) == 1) goto L6;
            r2 = 0;
        L6:
            b.q(r0, this.f19930h);
            if ((this.f19929g & 2) != 2) goto L9;
            this.f19931i = Collections.unmodifiableList(this.f19931i);
            this.f19929g &= -3;
        L9:
            b.s(r0, this.f19931i);
            b.t(r0, r2);
            return r0;
        }

        public c t() {
            c r0 = u();
            r0.y(r());
            return r0;
        }

        @Override // kotlin.s0.w.d.l0.i.a.AbstractC0550a, kotlin.s0.w.d.l0.i.q.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a x(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            z(r1, r2);
            return this;
        }

        public c y(b r3) {
            if (r3 != b.z()) goto L6;
            return this;
        L6:
            if (r3.B() == false) goto L9;
            B(r3.A());
        L9:
            if (b.r(r3).isEmpty() == false) goto L11;
        L14:
            o(m().b(b.u(r3)));
            return this;
        L11:
            if (this.f19931i.isEmpty() == false) goto L13;
            this.f19931i = b.r(r3);
            this.f19929g &= -3;
            goto L14
        L13:
            v();
            this.f19931i.addAll(b.r(r3));
            goto L14
        }

        public c z(kotlin.s0.w.d.l0.i.e r3, kotlin.s0.w.d.l0.i.g r4) {
            b r0 = null;
            b r5 = b.m.b(r3, r4);     // Catch: Throwable -> L7 kotlin.s0.w.d.l0.i.k -> L9
            if (r5 == null) goto L6;
            y(r5);
        L6:
            return this;
        L9:
            e = move-exception;
            b r6 = (b) e.a();     // Catch: Throwable -> L7
            throw e;     // Catch: Throwable -> L12
        L12:
            th = th;
            r0 = r6;
        L14:
            if (r0 == null) goto L16;
            y(r0);
        L16:
            throw th;
        L7:
            th = th;
            goto L14
        }
    }

    static {
        m = new a();
        b r0 = new b(true);
        f19892l = r0;
        r0.C();
    }

    private b(kotlin.s0.w.d.l0.i.e r9, kotlin.s0.w.d.l0.i.g r10) {
        this.f19897j = -1;
        this.f19898k = -1;
        C();
        kotlin.s0.w.d.l0.i.d.b r0 = kotlin.s0.w.d.l0.i.d.t();
        kotlin.s0.w.d.l0.i.f r2 = kotlin.s0.w.d.l0.i.f.J(r0, 1);
        boolean r3 = false;
        int r4 = 0;
    L4:
        if (r3 == true) goto L40;
        int r6 = r9.K();     // Catch: Throwable -> L21 IOException -> L23 kotlin.s0.w.d.l0.i.k -> L26
        if (r6 == 0) goto L20;
        if (r6 != 8) goto L10;
        this.f19894g |= 1;     // Catch: Throwable -> L21 IOException -> L23 kotlin.s0.w.d.l0.i.k -> L26
        this.f19895h = r9.s();     // Catch: Throwable -> L21 IOException -> L23 kotlin.s0.w.d.l0.i.k -> L26
        goto L4
    L10:
        if (r6 != 18) goto L12;
        if ((r4 & 2) == 2) goto L17;
        this.f19896i = new ArrayList();     // Catch: Throwable -> L21 IOException -> L23 kotlin.s0.w.d.l0.i.k -> L26
        r4 = r4 | 2;     // Catch: Throwable -> L21 IOException -> L23 kotlin.s0.w.d.l0.i.k -> L26
    L17:
        this.f19896i.add((C0541b) r9.u(C0541b.m, r10));     // Catch: Throwable -> L21 IOException -> L23 kotlin.s0.w.d.l0.i.k -> L26
        goto L4
    L12:
        if (o(r9, r2, r10, r6) == true) goto L4;
    L20:
        r3 = true;
        goto L4
    L21:
        th = move-exception;
        if ((r4 & 2) != 2) goto L52;
        this.f19896i = Collections.unmodifiableList(this.f19896i);
    L52:
        r2.I();     // Catch: IOException -> L50 Throwable -> L34
    L34:
        th = move-exception;
        this.f19893f = r0.l();
        throw th;
    L33:
        this.f19893f = r0.l();
        l();
        throw th;
    L26:
        e = move-exception;
        e.i(this);     // Catch: Throwable -> L21
        throw e;     // Catch: Throwable -> L21
    L23:
        e = move-exception;
        kotlin.s0.w.d.l0.i.k r11 = new kotlin.s0.w.d.l0.i.k(e.getMessage());     // Catch: Throwable -> L21
        r11.i(this);     // Catch: Throwable -> L21
        throw r11;     // Catch: Throwable -> L21
    L40:
        if ((r4 & 2) != 2) goto L54;
        this.f19896i = Collections.unmodifiableList(this.f19896i);
    L54:
        r2.I();     // Catch: IOException -> L49 Throwable -> L44
    L44:
        th = move-exception;
        this.f19893f = r0.l();
        throw th;
    L43:
        this.f19893f = r0.l();
        l();
    }

    /* synthetic */ b(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2, kotlin.s0.w.d.l0.f.a r3) {
        this(r1, r2);
    }

    private b(kotlin.s0.w.d.l0.i.i.b r2) {
        super(r2);
        this.f19897j = -1;
        this.f19898k = -1;
        this.f19893f = r2.m();
    }

    /* synthetic */ b(kotlin.s0.w.d.l0.i.i.b r1, kotlin.s0.w.d.l0.f.a r2) {
        this(r1);
    }

    private b(boolean r1) {
        this.f19897j = -1;
        this.f19898k = -1;
        this.f19893f = kotlin.s0.w.d.l0.i.d.f20305f;
    }

    private void C() {
        this.f19895h = 0;
        this.f19896i = Collections.emptyList();
    }

    public static c D() {
        return c.p();
    }

    public static c E(b r1) {
        c r0 = D();
        r0.y(r1);
        return r0;
    }

    static /* synthetic */ int q(b r0, int r1) {
        r0.f19895h = r1;
        return r1;
    }

    static /* synthetic */ List r(b r0) {
        return r0.f19896i;
    }

    static /* synthetic */ List s(b r0, List r1) {
        r0.f19896i = r1;
        return r1;
    }

    static /* synthetic */ int t(b r0, int r1) {
        r0.f19894g = r1;
        return r1;
    }

    static /* synthetic */ kotlin.s0.w.d.l0.i.d u(b r0) {
        return r0.f19893f;
    }

    public static b z() {
        return f19892l;
    }

    public int A() {
        return this.f19895h;
    }

    public boolean B() {
        if ((this.f19894g & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public c F() {
        return D();
    }

    public c G() {
        return E(this);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a c() {
        return G();
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public void d(kotlin.s0.w.d.l0.i.f r4) {
        e();
        if ((this.f19894g & 1) != 1) goto L5;
        r4.a0(1, this.f19895h);
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.f19896i.size()) goto L9;
        r4.d0(2, this.f19896i.get(r0));
        r0 = r0 + 1;
        goto L7
    L9:
        r4.i0(this.f19893f);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public int e() {
        int r0 = this.f19898k;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r2 = 0;
        if ((this.f19894g & 1) != 1) goto L8;
        int r1 = kotlin.s0.w.d.l0.i.f.o(1, this.f19895h) + 0;
    L10:
        if (r2 >= this.f19896i.size()) goto L12;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(2, this.f19896i.get(r2));
        r2 = r2 + 1;
        goto L10
    L12:
        int r3 = r1 + this.f19893f.size();
        this.f19898k = r3;
        return r3;
    L8:
        r1 = 0;
        goto L10
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a f() {
        return F();
    }

    @Override // kotlin.s0.w.d.l0.i.i, kotlin.s0.w.d.l0.i.q
    public kotlin.s0.w.d.l0.i.s<b> h() {
        return m;
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public final boolean isInitialized() {
        byte r0 = this.f19897j;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 0) goto L9;
        return false;
    L9:
        if (B() == true) goto L12;
        this.f19897j = 0;
        return false;
    L12:
        int r1 = 0;
    L14:
        if (r1 >= w()) goto L20;
        if (v(r1).isInitialized() == false) goto L17;
        r1 = r1 + 1;
        goto L14
    L17:
        this.f19897j = 0;
        return false;
    L20:
        this.f19897j = 1;
        return true;
    }

    public C0541b v(int r1) {
        return this.f19896i.get(r1);
    }

    public int w() {
        return this.f19896i.size();
    }

    public List<C0541b> y() {
        return this.f19896i;
    }
}
