package kotlin.s0.w.d.m0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class a<E> implements Iterable<E> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final a<Object> f21297i = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final E f21298f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final a<E> f21299g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f21300h;

    /* JADX INFO: renamed from: kotlin.s0.w.d.m0.a$a, reason: collision with other inner class name */
    private static class C0587a<E> implements Iterator<E> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private a<E> f21301f;

        public C0587a(a<E> r1) {
            this.f21301f = r1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (a.a(this.f21301f) <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            a<E> r0 = this.f21301f;
            E r1 = r0.f21298f;
            this.f21301f = r0.f21299g;
            return r1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    static {
        f21297i = new a();
    }

    private a() {
        this.f21300h = 0;
        this.f21298f = null;
        this.f21299g = null;
    }

    private a(E r1, a<E> r2) {
        this.f21298f = r1;
        this.f21299g = r2;
        this.f21300h = r2.f21300h + 1;
    }

    static /* synthetic */ int a(a r0) {
        return r0.f21300h;
    }

    public static <E> a<E> b() {
        return (a<E>) f21297i;
    }

    private Iterator<E> c(int r2) {
        return new C0587a(m(r2));
    }

    private a<E> g(Object r2) {
        if (this.f21300h != 0) goto L6;
        return this;
    L6:
        if (this.f21298f.equals(r2) == true) goto L8;
        a<E> r3 = this.f21299g.g(r2);
        if (r3 != this.f21299g) goto L13;
        return this;
    L13:
        return new a(this.f21298f, r3);
    L8:
        return this.f21299g;
    }

    private a<E> m(int r2) {
        if (r2 < 0) goto L10;
        if (r2 > this.f21300h) goto L10;
        if (r2 != 0) goto L8;
        return this;
    L8:
        return this.f21299g.m(r2 - 1);
    L10:
        throw new IndexOutOfBoundsException();
    }

    public a<E> d(int r1) {
        return g(get(r1));
    }

    public E get(int r3) {
        if (r3 < 0) goto L10;
        if (r3 > this.f21300h) goto L10;
        return c(r3).next();
    L8:
        throw new IndexOutOfBoundsException("Index: " + r3);
    L10:
        throw new IndexOutOfBoundsException();
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return c(0);
    }

    public a<E> l(E r2) {
        return new a(r2, this);
    }

    public int size() {
        return this.f21300h;
    }
}
