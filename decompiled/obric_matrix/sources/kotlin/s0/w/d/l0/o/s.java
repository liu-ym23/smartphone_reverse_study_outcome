package kotlin.s0.w.d.l0.o;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<kotlin.s0.d<? extends K>, Integer> f21263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicInteger f21264b;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.d<? extends K>, Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ s<K, V> f21265f;

        a(s<K, V> r1) {
            this.f21265f = r1;
            super(1);
        }

        public final Integer a(kotlin.s0.d<? extends K> r2) {
            kotlin.n0.d.o.f(r2, "it");
            return Integer.valueOf(s.a(this.f21265f).getAndIncrement());
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Integer invoke(Object r1) {
            return a((kotlin.s0.d) r1);
        }
    }

    public s() {
        this.f21263a = new ConcurrentHashMap();
        this.f21264b = new AtomicInteger(0);
    }

    public static final /* synthetic */ AtomicInteger a(s r0) {
        return r0.f21264b;
    }

    public abstract <T extends K> int b(ConcurrentHashMap<kotlin.s0.d<? extends K>, Integer> r1, kotlin.s0.d<T> r2, kotlin.n0.c.l<? super kotlin.s0.d<? extends K>, Integer> r3);

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends V, KK extends K> n<K, V, T> c(kotlin.s0.d<KK> r2) {
        kotlin.n0.d.o.f(r2, "kClass");
        return new n(r2, d(r2));
    }

    public final <T extends K> int d(kotlin.s0.d<T> r3) {
        kotlin.n0.d.o.f(r3, "kClass");
        return b(this.f21263a, r3, new a(this));
    }

    protected final Collection<Integer> e() {
        Collection<Integer> r1 = this.f21263a.values();
        kotlin.n0.d.o.e(r1, "idPerType.values");
        return r1;
    }
}
