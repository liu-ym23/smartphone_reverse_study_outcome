package kotlin.s0.w.d.l0.c;

import kotlin.s0.w.d.l0.k.w.h;

/* JADX INFO: loaded from: classes2.dex */
public final class y0<T extends kotlin.s0.w.d.l0.k.w.h> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f19174e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final /* synthetic */ kotlin.s0.l<Object>[] f19175f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f19176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.n0.c.l<kotlin.s0.w.d.l0.n.t1.g, T> f19177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.n.t1.g f19178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i f19179d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final <T extends kotlin.s0.w.d.l0.k.w.h> y0<T> a(e r7, kotlin.s0.w.d.l0.m.n r8, kotlin.s0.w.d.l0.n.t1.g r9, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.n.t1.g, ? extends T> r10) {
            kotlin.n0.d.o.f(r7, "classDescriptor");
            kotlin.n0.d.o.f(r8, "storageManager");
            kotlin.n0.d.o.f(r9, "kotlinTypeRefinerForOwnerModule");
            kotlin.n0.d.o.f(r10, "scopeFactory");
            return new y0(r7, r8, r10, r9, null);
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.a<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ y0<T> f19180f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.n.t1.g f19181g;

        b(y0<T> r1, kotlin.s0.w.d.l0.n.t1.g r2) {
            this.f19180f = r1;
            this.f19181g = r2;
            super(0);
        }

        public final T a() {
            return (T) y0.b(this.f19180f).invoke(this.f19181g);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Object invoke() {
            return a();
        }
    }

    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.a<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ y0<T> f19182f;

        c(y0<T> r1) {
            this.f19182f = r1;
            super(0);
        }

        public final T a() {
            return (T) y0.b(this.f19182f).invoke(y0.a(this.f19182f));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Object invoke() {
            return a();
        }
    }

    static {
        f19175f = new kotlin.s0.l[]{kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(y0.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
        f19174e = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private y0(e r1, kotlin.s0.w.d.l0.m.n r2, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.n.t1.g, ? extends T> r3, kotlin.s0.w.d.l0.n.t1.g r4) {
        this.f19176a = r1;
        this.f19177b = r3;
        this.f19178c = r4;
        this.f19179d = r2.d(new c(this));
    }

    public /* synthetic */ y0(e r1, kotlin.s0.w.d.l0.m.n r2, kotlin.n0.c.l r3, kotlin.s0.w.d.l0.n.t1.g r4, kotlin.n0.d.g r5) {
        this(r1, r2, r3, r4);
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.n.t1.g a(y0 r0) {
        return r0.f19178c;
    }

    public static final /* synthetic */ kotlin.n0.c.l b(y0 r0) {
        return r0.f19177b;
    }

    private final T d() {
        return (T) kotlin.s0.w.d.l0.m.m.a(this.f19179d, this, f19175f[0]);
    }

    public final T c(kotlin.s0.w.d.l0.n.t1.g r3) {
        kotlin.n0.d.o.f(r3, "kotlinTypeRefiner");
        if (r3.d(kotlin.s0.w.d.l0.k.t.a.l(this.f19176a)) == false) goto L5;
        kotlin.s0.w.d.l0.n.e1 r0 = this.f19176a.k();
        kotlin.n0.d.o.e(r0, "classDescriptor.typeConstructor");
        if (r3.e(r0) == true) goto L11;
        return (T) d();
    L11:
        return (T) r3.c(this.f19176a, new b(this, r3));
    L5:
        return (T) d();
    }
}
