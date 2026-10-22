package kotlin.s0.w.d.l0.o;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<K, V> implements Iterable<V>, kotlin.n0.d.l0.a {

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.o.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0583a<K, V, T extends V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final kotlin.s0.d<? extends K> f21206a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f21207b;

        public AbstractC0583a(kotlin.s0.d<? extends K> r2, int r3) {
            kotlin.n0.d.o.f(r2, "key");
            this.f21206a = r2;
            this.f21207b = r3;
        }

        protected final T c(a<K, V> r2) {
            kotlin.n0.d.o.f(r2, "thisRef");
            return r2.a().get(this.f21207b);
        }
    }

    public a() {
    }

    protected abstract c<V> a();

    protected abstract s<K, V> b();

    public final boolean isEmpty() {
        if (a().a() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.Iterable
    public final Iterator<V> iterator() {
        return a().iterator();
    }
}
