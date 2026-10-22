package kotlin.s0.w.d.l0.f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends kotlin.s0.w.d.l0.i.i implements kotlin.s0.w.d.l0.i.r {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final o f20068j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static kotlin.s0.w.d.l0.i.s<o> f20069k;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.i.d f20070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<c> f20071g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private byte f20072h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f20073i;

    static class a extends kotlin.s0.w.d.l0.i.b<o> {
        a() {
        }

        @Override // kotlin.s0.w.d.l0.i.s
        public /* bridge */ /* synthetic */ Object b(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            return m(r1, r2);
        }

        public o m(kotlin.s0.w.d.l0.i.e r2, kotlin.s0.w.d.l0.i.g r3) {
            return new o(r2, r3, null);
        }
    }

    public static final class b extends kotlin.s0.w.d.l0.i.i.b<o, b> implements Object {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f20074g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private List<c> f20075h;

        private b() {
            this.f20075h = Collections.emptyList();
            w();
        }

        static /* synthetic */ b p() {
            return u();
        }

        private static b u() {
            return new b();
        }

        private void v() {
            if ((this.f20074g & 1) == 1) goto L6;
            this.f20075h = new ArrayList(this.f20075h);
            this.f20074g |= 1;
            return;
        }

        private void w() {
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
            y((o) r1);
            return this;
        }

        public o q() {
            o r1 = r();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw kotlin.s0.w.d.l0.i.a.AbstractC0550a.j(r1);
        }

        public o r() {
            o r0 = new o(this, null);
            if ((this.f20074g & 1) != 1) goto L5;
            this.f20075h = Collections.unmodifiableList(this.f20075h);
            this.f20074g &= -2;
        L5:
            o.r(r0, this.f20075h);
            return r0;
        }

        public b t() {
            b r0 = u();
            r0.y(r());
            return r0;
        }

        @Override // kotlin.s0.w.d.l0.i.a.AbstractC0550a, kotlin.s0.w.d.l0.i.q.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a x(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            z(r1, r2);
            return this;
        }

        public b y(o r3) {
            if (r3 != o.t()) goto L6;
            return this;
        L6:
            if (o.q(r3).isEmpty() == false) goto L8;
        L11:
            o(m().b(o.s(r3)));
            return this;
        L8:
            if (this.f20075h.isEmpty() == false) goto L10;
            this.f20075h = o.q(r3);
            this.f20074g &= -2;
            goto L11
        L10:
            v();
            this.f20075h.addAll(o.q(r3));
            goto L11
        }

        public b z(kotlin.s0.w.d.l0.i.e r3, kotlin.s0.w.d.l0.i.g r4) {
            o r0 = null;
            o r5 = o.f20069k.b(r3, r4);     // Catch: Throwable -> L7 kotlin.s0.w.d.l0.i.k -> L9
            if (r5 == null) goto L6;
            y(r5);
        L6:
            return this;
        L9:
            e = move-exception;
            o r6 = (o) e.a();     // Catch: Throwable -> L7
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

    public static final class c extends kotlin.s0.w.d.l0.i.i implements kotlin.s0.w.d.l0.i.r {
        private static final c m = null;
        public static kotlin.s0.w.d.l0.i.s<c> n;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.i.d f20076f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f20077g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f20078h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f20079i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private EnumC0546c f20080j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private byte f20081k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f20082l;

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

        public static final class b extends kotlin.s0.w.d.l0.i.i.b<c, b> implements Object {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private int f20083g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private int f20084h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private int f20085i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private EnumC0546c f20086j;

            private b() {
                this.f20084h = -1;
                this.f20086j = EnumC0546c.f20088h;
                v();
            }

            static /* synthetic */ b p() {
                return u();
            }

            private static b u() {
                return new b();
            }

            private void v() {
            }

            public b B(int r2) {
                this.f20083g |= 1;
                this.f20084h = r2;
                return this;
            }

            public b C(int r2) {
                this.f20083g |= 2;
                this.f20085i = r2;
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
                w((c) r1);
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
                int r1 = this.f20083g;
                int r3 = 1;
                if ((r1 & 1) == 1) goto L6;
                r3 = 0;
            L6:
                c.u(r0, this.f20084h);
                if ((r1 & 2) != 2) goto L9;
                r3 = r3 | 2;
            L9:
                c.q(r0, this.f20085i);
                if ((r1 & 4) != 4) goto L12;
                r3 = r3 | 4;
            L12:
                c.r(r0, this.f20086j);
                c.s(r0, r3);
                return r0;
            }

            public b t() {
                b r0 = u();
                r0.w(r());
                return r0;
            }

            public b w(c r2) {
                if (r2 != c.v()) goto L6;
                return this;
            L6:
                if (r2.B() == false) goto L9;
                B(r2.y());
            L9:
                if (r2.C() == false) goto L12;
                C(r2.z());
            L12:
                if (r2.A() == false) goto L14;
                z(r2.w());
            L14:
                o(m().b(c.t(r2)));
                return this;
            }

            @Override // kotlin.s0.w.d.l0.i.a.AbstractC0550a, kotlin.s0.w.d.l0.i.q.a
            public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a x(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
                y(r1, r2);
                return this;
            }

            public b y(kotlin.s0.w.d.l0.i.e r3, kotlin.s0.w.d.l0.i.g r4) {
                c r0 = null;
                c r5 = c.n.b(r3, r4);     // Catch: Throwable -> L7 kotlin.s0.w.d.l0.i.k -> L9
                if (r5 == null) goto L6;
                w(r5);
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
                w(r0);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            public b z(EnumC0546c r2) {
                Objects.requireNonNull(r2);
                this.f20083g |= 4;
                this.f20086j = r2;
                return this;
            }
        }

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.f.o$c$c, reason: collision with other inner class name */
        public static final enum EnumC0546c extends Enum<EnumC0546c> implements kotlin.s0.w.d.l0.i.j.a {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final EnumC0546c f20087g = null;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public static final EnumC0546c f20088h = null;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public static final EnumC0546c f20089i = null;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private static final /* synthetic */ EnumC0546c[] f20090j = null;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final int f20091f;

            static {
                EnumC0546c r0 = new EnumC0546c("CLASS", 0, 0, 0);
                f20087g = r0;
                EnumC0546c r1 = new EnumC0546c("PACKAGE", 1, 1, 1);
                f20088h = r1;
                EnumC0546c r3 = new EnumC0546c("LOCAL", 2, 2, 2);
                f20089i = r3;
                f20090j = new EnumC0546c[]{r0, r1, r3};
            }

            private EnumC0546c(String r1, int r2, int r3, int r4) {
                super(r1, r2);
                this.f20091f = r4;
            }

            public static EnumC0546c a(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return f20089i;
            L12:
                return f20088h;
            L14:
                return f20087g;
            }

            public static EnumC0546c valueOf(String r1) {
                return (EnumC0546c) Enum.valueOf(EnumC0546c.class, r1);
            }

            public static EnumC0546c[] values() {
                return (EnumC0546c[]) f20090j.clone();
            }

            @Override // kotlin.s0.w.d.l0.i.j.a
            public final int d() {
                return this.f20091f;
            }
        }

        static {
            n = new a();
            c r0 = new c(true);
            m = r0;
            r0.D();
        }

        private c(kotlin.s0.w.d.l0.i.e r8, kotlin.s0.w.d.l0.i.g r9) {
            this.f20081k = -1;
            this.f20082l = -1;
            D();
            kotlin.s0.w.d.l0.i.d.b r0 = kotlin.s0.w.d.l0.i.d.t();
            kotlin.s0.w.d.l0.i.f r2 = kotlin.s0.w.d.l0.i.f.J(r0, 1);
            boolean r3 = false;
        L3:
            if (r3 == true) goto L51;
            int r4 = r8.K();     // Catch: Throwable -> L23 IOException -> L25 kotlin.s0.w.d.l0.i.k -> L28
            if (r4 == 0) goto L22;
            if (r4 != 8) goto L9;
            this.f20077g |= 1;     // Catch: Throwable -> L23 IOException -> L25 kotlin.s0.w.d.l0.i.k -> L28
            this.f20078h = r8.s();     // Catch: Throwable -> L23 IOException -> L25 kotlin.s0.w.d.l0.i.k -> L28
            goto L3
        L9:
            if (r4 != 16) goto L11;
            this.f20077g |= 2;     // Catch: Throwable -> L23 IOException -> L25 kotlin.s0.w.d.l0.i.k -> L28
            this.f20079i = r8.s();     // Catch: Throwable -> L23 IOException -> L25 kotlin.s0.w.d.l0.i.k -> L28
            goto L3
        L11:
            if (r4 != 24) goto L13;
            int r5 = r8.n();     // Catch: Throwable -> L23 IOException -> L25 kotlin.s0.w.d.l0.i.k -> L28
            EnumC0546c r6 = EnumC0546c.a(r5);     // Catch: Throwable -> L23 IOException -> L25 kotlin.s0.w.d.l0.i.k -> L28
            if (r6 == null) goto L17;
            this.f20077g |= 4;     // Catch: Throwable -> L23 IOException -> L25 kotlin.s0.w.d.l0.i.k -> L28
            this.f20080j = r6;     // Catch: Throwable -> L23 IOException -> L25 kotlin.s0.w.d.l0.i.k -> L28
            goto L3
        L17:
            r2.o0(r4);     // Catch: Throwable -> L23 IOException -> L25 kotlin.s0.w.d.l0.i.k -> L28
            r2.o0(r5);     // Catch: Throwable -> L23 IOException -> L25 kotlin.s0.w.d.l0.i.k -> L28
            goto L3
        L13:
            if (o(r8, r2, r9, r4) == true) goto L3;
        L22:
            r3 = true;
            goto L3
        L23:
            th = move-exception;
            r2.I();     // Catch: IOException -> L45 Throwable -> L33
        L33:
            th = move-exception;
            this.f20076f = r0.l();
            throw th;
        L32:
            this.f20076f = r0.l();
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
            this.f20076f = r0.l();
            throw th;
        L39:
            this.f20076f = r0.l();
            l();
        }

        /* synthetic */ c(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2, kotlin.s0.w.d.l0.f.a r3) {
            this(r1, r2);
        }

        private c(kotlin.s0.w.d.l0.i.i.b r2) {
            super(r2);
            this.f20081k = -1;
            this.f20082l = -1;
            this.f20076f = r2.m();
        }

        /* synthetic */ c(kotlin.s0.w.d.l0.i.i.b r1, kotlin.s0.w.d.l0.f.a r2) {
            this(r1);
        }

        private c(boolean r1) {
            this.f20081k = -1;
            this.f20082l = -1;
            this.f20076f = kotlin.s0.w.d.l0.i.d.f20305f;
        }

        private void D() {
            this.f20078h = -1;
            this.f20079i = 0;
            this.f20080j = EnumC0546c.f20088h;
        }

        public static b E() {
            return b.p();
        }

        public static b F(c r1) {
            b r0 = E();
            r0.w(r1);
            return r0;
        }

        static /* synthetic */ int q(c r0, int r1) {
            r0.f20079i = r1;
            return r1;
        }

        static /* synthetic */ EnumC0546c r(c r0, EnumC0546c r1) {
            r0.f20080j = r1;
            return r1;
        }

        static /* synthetic */ int s(c r0, int r1) {
            r0.f20077g = r1;
            return r1;
        }

        static /* synthetic */ kotlin.s0.w.d.l0.i.d t(c r0) {
            return r0.f20076f;
        }

        static /* synthetic */ int u(c r0, int r1) {
            r0.f20078h = r1;
            return r1;
        }

        public static c v() {
            return m;
        }

        public boolean A() {
            if ((this.f20077g & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean B() {
            if ((this.f20077g & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean C() {
            if ((this.f20077g & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public b G() {
            return E();
        }

        public b H() {
            return F(this);
        }

        @Override // kotlin.s0.w.d.l0.i.q
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a c() {
            return H();
        }

        @Override // kotlin.s0.w.d.l0.i.q
        public void d(kotlin.s0.w.d.l0.i.f r3) {
            e();
            if ((this.f20077g & 1) != 1) goto L6;
            r3.a0(1, this.f20078h);
        L6:
            if ((this.f20077g & 2) != 2) goto L9;
            r3.a0(2, this.f20079i);
        L9:
            if ((this.f20077g & 4) != 4) goto L11;
            r3.S(3, this.f20080j.d());
        L11:
            r3.i0(this.f20076f);
        }

        @Override // kotlin.s0.w.d.l0.i.q
        public int e() {
            int r0 = this.f20082l;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r1 = 0;
            if ((this.f20077g & 1) != 1) goto L9;
            r1 = 0 + kotlin.s0.w.d.l0.i.f.o(1, this.f20078h);
        L9:
            if ((this.f20077g & 2) != 2) goto L12;
            r1 = r1 + kotlin.s0.w.d.l0.i.f.o(2, this.f20079i);
        L12:
            if ((this.f20077g & 4) != 4) goto L14;
            r1 = r1 + kotlin.s0.w.d.l0.i.f.h(3, this.f20080j.d());
        L14:
            int r2 = r1 + this.f20076f.size();
            this.f20082l = r2;
            return r2;
        }

        @Override // kotlin.s0.w.d.l0.i.q
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a f() {
            return G();
        }

        @Override // kotlin.s0.w.d.l0.i.i, kotlin.s0.w.d.l0.i.q
        public kotlin.s0.w.d.l0.i.s<c> h() {
            return n;
        }

        @Override // kotlin.s0.w.d.l0.i.r
        public final boolean isInitialized() {
            byte r0 = this.f20081k;
            if (r0 != 1) goto L6;
            return true;
        L6:
            if (r0 != 0) goto L9;
            return false;
        L9:
            if (C() == true) goto L12;
            this.f20081k = 0;
            return false;
        L12:
            this.f20081k = 1;
            return true;
        }

        public EnumC0546c w() {
            return this.f20080j;
        }

        public int y() {
            return this.f20078h;
        }

        public int z() {
            return this.f20079i;
        }
    }

    static {
        f20069k = new a();
        o r0 = new o(true);
        f20068j = r0;
        r0.w();
    }

    private o(kotlin.s0.w.d.l0.i.e r8, kotlin.s0.w.d.l0.i.g r9) {
        this.f20072h = -1;
        this.f20073i = -1;
        w();
        kotlin.s0.w.d.l0.i.d.b r0 = kotlin.s0.w.d.l0.i.d.t();
        kotlin.s0.w.d.l0.i.f r2 = kotlin.s0.w.d.l0.i.f.J(r0, 1);
        boolean r3 = false;
        boolean r4 = false;
    L3:
        if (r3 == true) goto L36;
        int r5 = r8.K();     // Catch: Throwable -> L17 IOException -> L19 kotlin.s0.w.d.l0.i.k -> L22
        if (r5 == 0) goto L16;
        if (r5 != 10) goto L9;
        if ((r4 & true) == true) goto L14;
        this.f20071g = new ArrayList();     // Catch: Throwable -> L17 IOException -> L19 kotlin.s0.w.d.l0.i.k -> L22
        r4 = r4 | true;     // Catch: Throwable -> L17 IOException -> L19 kotlin.s0.w.d.l0.i.k -> L22
    L14:
        this.f20071g.add((c) r8.u(c.n, r9));     // Catch: Throwable -> L17 IOException -> L19 kotlin.s0.w.d.l0.i.k -> L22
        goto L3
    L9:
        if (o(r8, r2, r9, r5) == true) goto L3;
    L16:
        r3 = true;
        goto L3
    L17:
        th = move-exception;
        if ((r4 & true) != true) goto L51;
        this.f20071g = Collections.unmodifiableList(this.f20071g);
    L51:
        r2.I();     // Catch: IOException -> L46 Throwable -> L30
    L30:
        th = move-exception;
        this.f20070f = r0.l();
        throw th;
    L29:
        this.f20070f = r0.l();
        l();
        throw th;
    L22:
        e = move-exception;
        e.i(this);     // Catch: Throwable -> L17
        throw e;     // Catch: Throwable -> L17
    L19:
        e = move-exception;
        kotlin.s0.w.d.l0.i.k r10 = new kotlin.s0.w.d.l0.i.k(e.getMessage());     // Catch: Throwable -> L17
        r10.i(this);     // Catch: Throwable -> L17
        throw r10;     // Catch: Throwable -> L17
    L36:
        if ((r4 & true) != true) goto L48;
        this.f20071g = Collections.unmodifiableList(this.f20071g);
    L48:
        r2.I();     // Catch: IOException -> L45 Throwable -> L40
    L40:
        th = move-exception;
        this.f20070f = r0.l();
        throw th;
    L39:
        this.f20070f = r0.l();
        l();
    }

    /* synthetic */ o(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2, kotlin.s0.w.d.l0.f.a r3) {
        this(r1, r2);
    }

    private o(kotlin.s0.w.d.l0.i.i.b r2) {
        super(r2);
        this.f20072h = -1;
        this.f20073i = -1;
        this.f20070f = r2.m();
    }

    /* synthetic */ o(kotlin.s0.w.d.l0.i.i.b r1, kotlin.s0.w.d.l0.f.a r2) {
        this(r1);
    }

    private o(boolean r1) {
        this.f20072h = -1;
        this.f20073i = -1;
        this.f20070f = kotlin.s0.w.d.l0.i.d.f20305f;
    }

    static /* synthetic */ List q(o r0) {
        return r0.f20071g;
    }

    static /* synthetic */ List r(o r0, List r1) {
        r0.f20071g = r1;
        return r1;
    }

    static /* synthetic */ kotlin.s0.w.d.l0.i.d s(o r0) {
        return r0.f20070f;
    }

    public static o t() {
        return f20068j;
    }

    private void w() {
        this.f20071g = Collections.emptyList();
    }

    public static b y() {
        return b.p();
    }

    public static b z(o r1) {
        b r0 = y();
        r0.y(r1);
        return r0;
    }

    public b A() {
        return y();
    }

    public b B() {
        return z(this);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a c() {
        return B();
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public void d(kotlin.s0.w.d.l0.i.f r4) {
        e();
        int r0 = 0;
    L4:
        if (r0 >= this.f20071g.size()) goto L6;
        r4.d0(1, this.f20071g.get(r0));
        r0 = r0 + 1;
        goto L4
    L6:
        r4.i0(this.f20070f);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public int e() {
        int r0 = this.f20073i;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= this.f20071g.size()) goto L9;
        r2 = r2 + kotlin.s0.w.d.l0.i.f.s(1, this.f20071g.get(r1));
        r1 = r1 + 1;
        goto L7
    L9:
        int r3 = r2 + this.f20070f.size();
        this.f20073i = r3;
        return r3;
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a f() {
        return A();
    }

    @Override // kotlin.s0.w.d.l0.i.i, kotlin.s0.w.d.l0.i.q
    public kotlin.s0.w.d.l0.i.s<o> h() {
        return f20069k;
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public final boolean isInitialized() {
        byte r0 = this.f20072h;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 0) goto L8;
        return false;
    L8:
        int r1 = 0;
    L10:
        if (r1 >= v()) goto L16;
        if (u(r1).isInitialized() == false) goto L13;
        r1 = r1 + 1;
        goto L10
    L13:
        this.f20072h = 0;
        return false;
    L16:
        this.f20072h = 1;
        return true;
    }

    public c u(int r1) {
        return this.f20071g.get(r1);
    }

    public int v() {
        return this.f20071g.size();
    }
}
