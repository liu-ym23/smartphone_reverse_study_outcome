package kotlin.s0.w.d.l0.c.p1;

import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.z0;

/* JADX INFO: loaded from: classes2.dex */
public interface c {

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f18947a = null;

        static {
            f18947a = new a();
        }

        private a() {
        }

        @Override // kotlin.s0.w.d.l0.c.p1.c
        public boolean c(kotlin.s0.w.d.l0.c.e r1, z0 r2) {
            o.f(r1, "classDescriptor");
            o.f(r2, "functionDescriptor");
            return true;
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f18948a = null;

        static {
            f18948a = new b();
        }

        private b() {
        }

        @Override // kotlin.s0.w.d.l0.c.p1.c
        public boolean c(kotlin.s0.w.d.l0.c.e r1, z0 r2) {
            o.f(r1, "classDescriptor");
            o.f(r2, "functionDescriptor");
            return !r2.getAnnotations().k(d.a());
        }
    }

    boolean c(kotlin.s0.w.d.l0.c.e r1, z0 r2);
}
