package d.e.b.a.l.c;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
final class d<T> implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentMap<T, d.e.b.a.g> f16647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c<T> f16648b;

    class a implements c<String> {
        a() {
        }

        @Override // d.e.b.a.l.c.d.c
        public /* bridge */ /* synthetic */ String a(d.e.b.a.g r1) {
            return b(r1);
        }

        public String b(d.e.b.a.g r1) {
            return r1.d();
        }
    }

    class b implements c<Integer> {
        b() {
        }

        @Override // d.e.b.a.l.c.d.c
        public /* bridge */ /* synthetic */ Integer a(d.e.b.a.g r1) {
            return b(r1);
        }

        public Integer b(d.e.b.a.g r1) {
            return Integer.valueOf(r1.a());
        }
    }

    interface c<T> {
        T a(d.e.b.a.g r1);
    }

    private d(c<T> r2) {
        this.f16647a = new ConcurrentHashMap();
        this.f16648b = r2;
    }

    static d<Integer> b() {
        return new d(new b());
    }

    static d<String> c() {
        return new d(new a());
    }

    @Override // d.e.b.a.l.c.f
    public void a(d.e.b.a.g r2) {
        this.f16647a.put(this.f16648b.a(r2), r2);
    }

    c<T> d() {
        return this.f16648b;
    }

    d.e.b.a.g e(T r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return this.f16647a.get(r1);
    }
}
