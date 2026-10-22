package kotlin.s0.w.d.l0.e.a.l0.l;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.i0.t0;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.e.a.n0.n;
import kotlin.s0.w.d.l0.e.a.n0.r;
import kotlin.s0.w.d.l0.e.a.n0.w;

/* JADX INFO: loaded from: classes2.dex */
public interface b {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f19393a = null;

        static {
            f19393a = new a();
        }

        private a() {
        }

        @Override // kotlin.s0.w.d.l0.e.a.l0.l.b
        public Set<kotlin.s0.w.d.l0.g.f> a() {
            return t0.b();
        }

        @Override // kotlin.s0.w.d.l0.e.a.l0.l.b
        public w b(kotlin.s0.w.d.l0.g.f r1) {
            o.f(r1, "name");
            return null;
        }

        @Override // kotlin.s0.w.d.l0.e.a.l0.l.b
        public n c(kotlin.s0.w.d.l0.g.f r1) {
            o.f(r1, "name");
            return null;
        }

        @Override // kotlin.s0.w.d.l0.e.a.l0.l.b
        public Set<kotlin.s0.w.d.l0.g.f> d() {
            return t0.b();
        }

        @Override // kotlin.s0.w.d.l0.e.a.l0.l.b
        public Set<kotlin.s0.w.d.l0.g.f> e() {
            return t0.b();
        }

        @Override // kotlin.s0.w.d.l0.e.a.l0.l.b
        public /* bridge */ /* synthetic */ Collection f(kotlin.s0.w.d.l0.g.f r1) {
            return g(r1);
        }

        public List<r> g(kotlin.s0.w.d.l0.g.f r1) {
            o.f(r1, "name");
            return kotlin.i0.r.g();
        }
    }

    Set<kotlin.s0.w.d.l0.g.f> a();

    w b(kotlin.s0.w.d.l0.g.f r1);

    n c(kotlin.s0.w.d.l0.g.f r1);

    Set<kotlin.s0.w.d.l0.g.f> d();

    Set<kotlin.s0.w.d.l0.g.f> e();

    Collection<r> f(kotlin.s0.w.d.l0.g.f r1);
}
