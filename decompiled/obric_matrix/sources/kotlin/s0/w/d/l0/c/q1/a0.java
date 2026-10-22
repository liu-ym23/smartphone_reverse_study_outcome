package kotlin.s0.w.d.l0.c.q1;

import kotlin.s0.w.d.l0.c.q0;

/* JADX INFO: loaded from: classes2.dex */
public interface a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18959a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f18960a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final kotlin.s0.w.d.l0.c.g0<a0> f18961b = null;

        static {
            f18960a = new a();
            f18961b = new kotlin.s0.w.d.l0.c.g0("PackageViewDescriptorFactory");
        }

        private a() {
        }

        public final kotlin.s0.w.d.l0.c.g0<a0> a() {
            return f18961b;
        }
    }

    public static final class b implements a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f18962b = null;

        static {
            f18962b = new b();
        }

        private b() {
        }

        @Override // kotlin.s0.w.d.l0.c.q1.a0
        public q0 a(x r1, kotlin.s0.w.d.l0.g.c r2, kotlin.s0.w.d.l0.m.n r3) {
            kotlin.n0.d.o.f(r1, "module");
            kotlin.n0.d.o.f(r2, "fqName");
            kotlin.n0.d.o.f(r3, "storageManager");
            return new r(r1, r2, r3);
        }
    }

    static {
        f18959a = a.f18960a;
    }

    q0 a(x r1, kotlin.s0.w.d.l0.g.c r2, kotlin.s0.w.d.l0.m.n r3);
}
