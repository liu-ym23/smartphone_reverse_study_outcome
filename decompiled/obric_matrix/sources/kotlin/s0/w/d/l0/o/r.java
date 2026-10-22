package kotlin.s0.w.d.l0.o;

import kotlin.s0.w.d.l0.c.y;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.m0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.n0.c.l<kotlin.s0.w.d.l0.b.h, e0> f21255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f21256c;

    public static final class a extends r {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f21257d = null;

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.o.r$a$a, reason: collision with other inner class name */
        static final class C0584a extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.b.h, e0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final C0584a f21258f = null;

            static {
                f21258f = new C0584a();
            }

            C0584a() {
                super(1);
            }

            public final e0 a(kotlin.s0.w.d.l0.b.h r1) {
                kotlin.n0.d.o.f(r1, "$this$null");
                m0 r0 = r1.n();
                kotlin.n0.d.o.e(r0, "booleanType");
                return r0;
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ e0 invoke(kotlin.s0.w.d.l0.b.h r1) {
                return a(r1);
            }
        }

        static {
            f21257d = new a();
        }

        private a() {
            String r1 = "Boolean";
            super(r1, C0584a.f21258f, null);
        }
    }

    public static final class b extends r {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f21259d = null;

        static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.b.h, e0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final a f21260f = null;

            static {
                f21260f = new a();
            }

            a() {
                super(1);
            }

            public final e0 a(kotlin.s0.w.d.l0.b.h r1) {
                kotlin.n0.d.o.f(r1, "$this$null");
                m0 r0 = r1.D();
                kotlin.n0.d.o.e(r0, "intType");
                return r0;
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ e0 invoke(kotlin.s0.w.d.l0.b.h r1) {
                return a(r1);
            }
        }

        static {
            f21259d = new b();
        }

        private b() {
            String r1 = "Int";
            super(r1, a.f21260f, null);
        }
    }

    public static final class c extends r {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f21261d = null;

        static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.b.h, e0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final a f21262f = null;

            static {
                f21262f = new a();
            }

            a() {
                super(1);
            }

            public final e0 a(kotlin.s0.w.d.l0.b.h r1) {
                kotlin.n0.d.o.f(r1, "$this$null");
                m0 r0 = r1.Z();
                kotlin.n0.d.o.e(r0, "unitType");
                return r0;
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ e0 invoke(kotlin.s0.w.d.l0.b.h r1) {
                return a(r1);
            }
        }

        static {
            f21261d = new c();
        }

        private c() {
            String r1 = "Unit";
            super(r1, a.f21262f, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private r(String r2, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.b.h, ? extends e0> r3) {
        this.f21254a = r2;
        this.f21255b = r3;
        this.f21256c = "must return " + r2;
    }

    public /* synthetic */ r(String r1, kotlin.n0.c.l r2, kotlin.n0.d.g r3) {
        this(r1, r2);
    }

    @Override // kotlin.s0.w.d.l0.o.f
    public String a(y r1) {
        return f.a.a(this, r1);
    }

    @Override // kotlin.s0.w.d.l0.o.f
    public boolean b(y r2) {
        kotlin.n0.d.o.f(r2, "functionDescriptor");
        return kotlin.n0.d.o.a(r2.getReturnType(), this.f21255b.invoke(kotlin.s0.w.d.l0.k.t.a.f(r2)));
    }

    @Override // kotlin.s0.w.d.l0.o.f
    public String getDescription() {
        return this.f21256c;
    }
}
