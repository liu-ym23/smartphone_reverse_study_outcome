package kotlin.s0.w.d.m0;

/* JADX INFO: loaded from: classes2.dex */
final class d<V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d<Object> f21311b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c<V> f21312a;

    static {
        f21311b = new d(c.f21305f);
    }

    private d(c<V> r1) {
        this.f21312a = r1;
    }

    public static <V> d<V> a() {
        return (d<V>) f21311b;
    }

    private d<V> d(c<V> r2) {
        if (r2 != this.f21312a) goto L6;
        return this;
    L6:
        return new d(r2);
    }

    public V b(int r3) {
        return this.f21312a.a(r3);
    }

    public d<V> c(int r4, V r5) {
        return d(this.f21312a.b(r4, r5));
    }
}
