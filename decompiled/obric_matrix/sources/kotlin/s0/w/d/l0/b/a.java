package kotlin.s0.w.d.l0.b;

import java.util.ServiceLoader;
import kotlin.i0.r;
import kotlin.n0.d.q;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.c.m0;

/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0494a f18667a = null;

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.b.a$a, reason: collision with other inner class name */
    public static final class C0494a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ C0494a f18668a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final kotlin.h<a> f18669b = null;

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.b.a$a$a, reason: collision with other inner class name */
        static final class C0495a extends q implements kotlin.n0.c.a<a> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final C0495a f18670f = null;

            static {
                f18670f = new C0495a();
            }

            C0495a() {
                super(0);
            }

            public final a a() {
                ServiceLoader r1 = ServiceLoader.load(a.class, a.class.getClassLoader());
                kotlin.n0.d.o.e(r1, "implementations");
                a r2 = (a) r.Q(r1);
                if (r2 == null) goto L6;
                return r2;
            L6:
                throw new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ a invoke() {
                return a();
            }
        }

        static {
            f18668a = new C0494a();
            f18669b = kotlin.i.a(kotlin.l.f18418g, C0495a.f18670f);
        }

        private C0494a() {
        }

        public final a a() {
            return f18669b.getValue();
        }
    }

    static {
        f18667a = C0494a.f18668a;
    }

    m0 a(kotlin.s0.w.d.l0.m.n r1, h0 r2, Iterable<? extends kotlin.s0.w.d.l0.c.p1.b> r3, kotlin.s0.w.d.l0.c.p1.c r4, kotlin.s0.w.d.l0.c.p1.a r5, boolean r6);
}
