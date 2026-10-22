package kotlin.s0.w.d.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class b<K, V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final b<Object, Object> f21302c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d<a<e<K, V>>> f21303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21304b;

    static {
        f21302c = new b(d.a(), 0);
    }

    private b(d<a<e<K, V>>> r1, int r2) {
        this.f21303a = r1;
        this.f21304b = r2;
    }

    private static /* synthetic */ void a(int r3) {
        Object[] r0 = new Object[2];
        r0[0] = "kotlin/reflect/jvm/internal/pcollections/HashPMap";
        if (r3 == 1) goto L5;
        r0[1] = "empty";
    L7:
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", r0));
    L5:
        r0[1] = "minus";
        goto L7
    }

    public static <K, V> b<K, V> b() {
        b<K, V> r0 = (b<K, V>) f21302c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        a(0);
        throw null;
    }

    private a<e<K, V>> d(int r1) {
        a<e<K, V>> r0 = this.f21303a.b(r1);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return a.b();
    }

    private static <K, V> int e(a<e<K, V>> r2, Object r3) {
        int r0 = 0;
    L3:
        if (r2 == null) goto L10;
        if (r2.size() <= 0) goto L15;
        if (r2.f21298f.f21313f.equals(r3) == true) goto L8;
        r2 = r2.f21299g;
        r0 = r0 + 1;
        goto L3
    L8:
        return r0;
    L15:
        return -1;
    L10:
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V c(Object r3) {
        a r2 = d(r3.hashCode());
    L3:
        if (r2 == null) goto L11;
        if (r2.size() <= 0) goto L16;
        e r0 = (e) r2.f21298f;
        if (r0.f21313f.equals(r3) == true) goto L9;
        r2 = r2.f21299g;
        goto L3
    L9:
        return r0.f21314g;
    L16:
        return null;
    L11:
        return null;
    }

    public b<K, V> f(K r5, V r6) {
        a<e<K, V>> r0 = d(r5.hashCode());
        int r1 = r0.size();
        int r2 = e(r0, r5);
        if (r2 == (-1)) goto L5;
        r0 = r0.d(r2);
    L5:
        a<e<K, V>> r7 = r0.l(new e(r5, r6));
        return new b(this.f21303a.c(r5.hashCode(), r7), (this.f21304b - r1) + r7.size());
    }
}
