package kotlin.s0.w.d.l0.c;

import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface h0 extends m {

    public static final class a {
        public static <R, D> R a(h0 r1, o<R, D> r2, D r3) {
            kotlin.n0.d.o.f(r2, "visitor");
            return r2.j(r1, r3);
        }

        public static m b(h0 r0) {
            return null;
        }
    }

    <T> T I0(g0<T> r1);

    q0 N(kotlin.s0.w.d.l0.g.c r1);

    boolean e0(h0 r1);

    kotlin.s0.w.d.l0.b.h o();

    Collection<kotlin.s0.w.d.l0.g.c> p(kotlin.s0.w.d.l0.g.c r1, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r2);

    List<h0> t0();
}
