package kotlin.s0.w.d.l0.o;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final i f21224f = null;

    public static final class a implements Iterator, kotlin.n0.d.l0.a {
        a() {
        }

        public Void b() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            b();
            throw null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    static {
        f21224f = new i();
    }

    private i() {
        super(null);
    }

    @Override // kotlin.s0.w.d.l0.o.c
    public int a() {
        return 0;
    }

    @Override // kotlin.s0.w.d.l0.o.c
    public /* bridge */ /* synthetic */ void b(int r1, Object r2) {
        g(r1, (Void) r2);
        throw null;
    }

    public Void c(int r1) {
        return null;
    }

    public void g(int r1, Void r2) {
        kotlin.n0.d.o.f(r2, "value");
        throw new IllegalStateException();
    }

    @Override // kotlin.s0.w.d.l0.o.c
    public /* bridge */ /* synthetic */ Object get(int r1) {
        return c(r1);
    }

    @Override // kotlin.s0.w.d.l0.o.c, java.lang.Iterable
    public Iterator iterator() {
        return new a();
    }
}
