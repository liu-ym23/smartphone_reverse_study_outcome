package kotlin.s0.w.d.l0.o;

import java.util.Arrays;
import java.util.Collection;
import kotlin.s0.w.d.l0.c.y;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.g.f f21216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.u0.i f21217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Collection<kotlin.s0.w.d.l0.g.f> f21218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.n0.c.l<y, String> f21219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final f[] f21220e;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f21221f = null;

        static {
            f21221f = new a();
        }

        a() {
            super(1);
        }

        public final Void a(y r1) {
            kotlin.n0.d.o.f(r1, "$this$null");
            return null;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((y) r1);
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.l {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f21222f = null;

        static {
            f21222f = new b();
        }

        b() {
            super(1);
        }

        public final Void a(y r1) {
            kotlin.n0.d.o.f(r1, "$this$null");
            return null;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((y) r1);
        }
    }

    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.l {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f21223f = null;

        static {
            f21223f = new c();
        }

        c() {
            super(1);
        }

        public final Void a(y r1) {
            kotlin.n0.d.o.f(r1, "$this$null");
            return null;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((y) r1);
        }
    }

    public h(Collection<kotlin.s0.w.d.l0.g.f> r7, f[] r8, kotlin.n0.c.l<? super y, String> r9) {
        kotlin.n0.d.o.f(r7, "nameList");
        kotlin.n0.d.o.f(r8, "checks");
        kotlin.n0.d.o.f(r9, "additionalChecks");
        this(null, null, r7, r9, (f[]) Arrays.copyOf(r8, r8.length));
    }

    public /* synthetic */ h(Collection r1, f[] r2, kotlin.n0.c.l r3, int r4, kotlin.n0.d.g r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = c.f21223f;
    L5:
        this(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private h(kotlin.s0.w.d.l0.g.f r1, kotlin.u0.i r2, Collection<kotlin.s0.w.d.l0.g.f> r3, kotlin.n0.c.l<? super y, String> r4, f... r5) {
        this.f21216a = r1;
        this.f21217b = r2;
        this.f21218c = r3;
        this.f21219d = r4;
        this.f21220e = r5;
    }

    public h(kotlin.s0.w.d.l0.g.f r7, f[] r8, kotlin.n0.c.l<? super y, String> r9) {
        kotlin.n0.d.o.f(r7, "name");
        kotlin.n0.d.o.f(r8, "checks");
        kotlin.n0.d.o.f(r9, "additionalChecks");
        this(r7, null, null, r9, (f[]) Arrays.copyOf(r8, r8.length));
    }

    public /* synthetic */ h(kotlin.s0.w.d.l0.g.f r1, f[] r2, kotlin.n0.c.l r3, int r4, kotlin.n0.d.g r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = a.f21221f;
    L5:
        this(r1, r2, r3);
    }

    public h(kotlin.u0.i r7, f[] r8, kotlin.n0.c.l<? super y, String> r9) {
        kotlin.n0.d.o.f(r7, "regex");
        kotlin.n0.d.o.f(r8, "checks");
        kotlin.n0.d.o.f(r9, "additionalChecks");
        this(null, r7, null, r9, (f[]) Arrays.copyOf(r8, r8.length));
    }

    public /* synthetic */ h(kotlin.u0.i r1, f[] r2, kotlin.n0.c.l r3, int r4, kotlin.n0.d.g r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = b.f21222f;
    L5:
        this(r1, r2, r3);
    }

    public final g a(y r5) {
        kotlin.n0.d.o.f(r5, "functionDescriptor");
        f[] r0 = this.f21220e;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        String r3 = r0[r2].a(r5);
        if (r3 != null) goto L7;
        r2 = r2 + 1;
        goto L3
    L7:
        return new g.b(r3);
    L9:
        String r4 = this.f21219d.invoke(r5);
        if (r4 == null) goto L14;
        return new g.b(r4);
    L14:
        return g.c.f21215b;
    }

    public final boolean b(y r4) {
        kotlin.n0.d.o.f(r4, "functionDescriptor");
        if (this.f21216a == null) goto L8;
        if (kotlin.n0.d.o.a(r4.getName(), this.f21216a) == true) goto L8;
        return false;
    L8:
        if (this.f21217b == null) goto L12;
        String r0 = r4.getName().b();
        kotlin.n0.d.o.e(r0, "functionDescriptor.name.asString()");
        if (this.f21217b.d(r0) == true) goto L12;
        return false;
    L12:
        Collection<kotlin.s0.w.d.l0.g.f> r3 = this.f21218c;
        if (r3 != null) goto L15;
        return true;
    L15:
        if (r3.contains(r4.getName()) == true) goto L19;
        return false;
    L19:
        return true;
    }
}
