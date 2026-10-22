package d.a.a.k;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class b<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a<V>[] f12535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f12536b;

    protected static final class a<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f12537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public V f12538b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a<V> f12539c;

        public a(Type r1, V r2, int r3, a<V> r4) {
            this.f12537a = r1;
            this.f12538b = r2;
            this.f12539c = r4;
        }
    }

    public b(int r2) {
        this.f12536b = r2 - 1;
        this.f12535a = new a[r2];
    }

    public final V a(Type r3) {
        int r0 = System.identityHashCode(r3) & this.f12536b;
        a<V> r2 = this.f12535a[r0];
    L3:
        if (r2 == null) goto L9;
        if (r3 == r2.f12537a) goto L7;
        r2 = r2.f12539c;
        goto L3
    L7:
        return r2.f12538b;
    L9:
        return null;
    }

    public boolean b(Type r5, V r6) {
        int r0 = System.identityHashCode(r5);
        int r1 = this.f12536b & r0;
        a<V> r2 = this.f12535a[r1];
    L3:
        if (r2 == null) goto L9;
        if (r5 == r2.f12537a) goto L6;
        r2 = r2.f12539c;
        goto L3
    L6:
        r2.f12538b = r6;
        return true;
    L9:
        a<V>[] r4 = this.f12535a;
        r4[r1] = new a(r5, r6, r0, r4[r1]);
        return false;
    }
}
