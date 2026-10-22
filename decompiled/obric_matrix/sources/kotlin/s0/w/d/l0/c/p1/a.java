package kotlin.s0.w.d.l0.c.p1;

import java.util.Collection;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.z0;
import kotlin.s0.w.d.l0.g.f;
import kotlin.s0.w.d.l0.n.e0;

/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.c.p1.a$a, reason: collision with other inner class name */
    public static final class C0502a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0502a f18946a = null;

        static {
            f18946a = new C0502a();
        }

        private C0502a() {
        }

        @Override // kotlin.s0.w.d.l0.c.p1.a
        public Collection<kotlin.s0.w.d.l0.c.d> a(kotlin.s0.w.d.l0.c.e r1) {
            o.f(r1, "classDescriptor");
            return r.g();
        }

        @Override // kotlin.s0.w.d.l0.c.p1.a
        public Collection<z0> b(f r1, kotlin.s0.w.d.l0.c.e r2) {
            o.f(r1, "name");
            o.f(r2, "classDescriptor");
            return r.g();
        }

        @Override // kotlin.s0.w.d.l0.c.p1.a
        public Collection<e0> d(kotlin.s0.w.d.l0.c.e r1) {
            o.f(r1, "classDescriptor");
            return r.g();
        }

        @Override // kotlin.s0.w.d.l0.c.p1.a
        public Collection<f> e(kotlin.s0.w.d.l0.c.e r1) {
            o.f(r1, "classDescriptor");
            return r.g();
        }
    }

    Collection<kotlin.s0.w.d.l0.c.d> a(kotlin.s0.w.d.l0.c.e r1);

    Collection<z0> b(f r1, kotlin.s0.w.d.l0.c.e r2);

    Collection<e0> d(kotlin.s0.w.d.l0.c.e r1);

    Collection<f> e(kotlin.s0.w.d.l0.c.e r1);
}
