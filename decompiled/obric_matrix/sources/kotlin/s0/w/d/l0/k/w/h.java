package kotlin.s0.w.d.l0.k.w;

import java.util.Collection;
import java.util.Set;
import kotlin.i0.t0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.z0;

/* JADX INFO: loaded from: classes2.dex */
public interface h extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20646a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f20647a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final kotlin.n0.c.l<kotlin.s0.w.d.l0.g.f, Boolean> f20648b = null;

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.k.w.h$a$a, reason: collision with other inner class name */
        static final class C0564a extends q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.f, Boolean> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final C0564a f20649f = null;

            static {
                f20649f = new C0564a();
            }

            C0564a() {
                super(1);
            }

            public final Boolean a(kotlin.s0.w.d.l0.g.f r1) {
                o.f(r1, "it");
                return Boolean.TRUE;
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ Boolean invoke(kotlin.s0.w.d.l0.g.f r1) {
                return a(r1);
            }
        }

        static {
            f20647a = new a();
            f20648b = C0564a.f20649f;
        }

        private a() {
        }

        public final kotlin.n0.c.l<kotlin.s0.w.d.l0.g.f, Boolean> a() {
            return f20648b;
        }
    }

    public static final class b extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f20650b = null;

        static {
            f20650b = new b();
        }

        private b() {
        }

        @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
        public Set<kotlin.s0.w.d.l0.g.f> b() {
            return t0.b();
        }

        @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
        public Set<kotlin.s0.w.d.l0.g.f> d() {
            return t0.b();
        }

        @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
        public Set<kotlin.s0.w.d.l0.g.f> e() {
            return t0.b();
        }
    }

    static {
        f20646a = a.f20647a;
    }

    Collection<? extends z0> a(kotlin.s0.w.d.l0.g.f r1, kotlin.s0.w.d.l0.d.b.b r2);

    Set<kotlin.s0.w.d.l0.g.f> b();

    Collection<? extends u0> c(kotlin.s0.w.d.l0.g.f r1, kotlin.s0.w.d.l0.d.b.b r2);

    Set<kotlin.s0.w.d.l0.g.f> d();

    Set<kotlin.s0.w.d.l0.g.f> e();
}
