package kotlin.s0.w.d.l0.c;

import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public interface d1 {

    public static final class a implements d1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f18858a = null;

        static {
            f18858a = new a();
        }

        private a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.s0.w.d.l0.c.d1
        public Collection<kotlin.s0.w.d.l0.n.e0> a(kotlin.s0.w.d.l0.n.e1 r1, Collection<? extends kotlin.s0.w.d.l0.n.e0> r2, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.n.e1, ? extends Iterable<? extends kotlin.s0.w.d.l0.n.e0>> r3, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.n.e0, kotlin.f0> r4) {
            kotlin.n0.d.o.f(r1, "currentTypeConstructor");
            kotlin.n0.d.o.f(r2, "superTypes");
            kotlin.n0.d.o.f(r3, "neighbors");
            kotlin.n0.d.o.f(r4, "reportLoop");
            return r2;
        }
    }

    Collection<kotlin.s0.w.d.l0.n.e0> a(kotlin.s0.w.d.l0.n.e1 r1, Collection<? extends kotlin.s0.w.d.l0.n.e0> r2, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.n.e1, ? extends Iterable<? extends kotlin.s0.w.d.l0.n.e0>> r3, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.n.e0, kotlin.f0> r4);
}
