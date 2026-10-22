package kotlin.s0.w.d.l0.o;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class o<T> extends c<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final T f21233f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f21234g;

    public static final class a implements Iterator<T>, kotlin.n0.d.l0.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f21235f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ o<T> f21236g;

        a(o<T> r1) {
            this.f21236g = r1;
            this.f21235f = true;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21235f;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f21235f == false) goto L7;
            this.f21235f = false;
            return this.f21236g.g();
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public o(T r2, int r3) {
        kotlin.n0.d.o.f(r2, "value");
        super(null);
        this.f21233f = r2;
        this.f21234g = r3;
    }

    @Override // kotlin.s0.w.d.l0.o.c
    public int a() {
        return 1;
    }

    @Override // kotlin.s0.w.d.l0.o.c
    public void b(int r1, T r2) {
        kotlin.n0.d.o.f(r2, "value");
        throw new IllegalStateException();
    }

    public final int c() {
        return this.f21234g;
    }

    public final T g() {
        return this.f21233f;
    }

    @Override // kotlin.s0.w.d.l0.o.c
    public T get(int r2) {
        if (r2 == this.f21234g) goto L7;
        return null;
    L7:
        return this.f21233f;
    }

    @Override // kotlin.s0.w.d.l0.o.c, java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this);
    }
}
