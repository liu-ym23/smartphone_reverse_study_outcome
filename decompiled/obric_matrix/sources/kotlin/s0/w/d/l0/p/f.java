package kotlin.s0.w.d.l0.p;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.i0.i;
import kotlin.i0.t0;
import kotlin.n0.d.j0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class f<T> extends AbstractSet<T> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f21288h = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f21289f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f21290g;

    private static final class a<T> implements Iterator<T>, Object {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Iterator<T> f21291f;

        public a(T[] r2) {
            o.f(r2, "array");
            this.f21291f = kotlin.n0.d.b.a(r2);
        }

        public Void b() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21291f.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.f21291f.next();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            b();
            throw null;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.n0.d.g r1) {
            this();
        }

        public final <T> f<T> a() {
            return new f(null);
        }

        public final <T> f<T> b(Collection<? extends T> r2) {
            o.f(r2, "set");
            f<T> r1 = new f(null);
            r1.addAll(r2);
            return r1;
        }
    }

    private static final class c<T> implements Iterator<T>, Object {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final T f21292f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f21293g;

        public c(T r1) {
            this.f21292f = r1;
            this.f21293g = true;
        }

        public Void b() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21293g;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f21293g == false) goto L7;
            this.f21293g = false;
            return this.f21292f;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            b();
            throw null;
        }
    }

    static {
        f21288h = new b(null);
    }

    private f() {
    }

    public /* synthetic */ f(kotlin.n0.d.g r1) {
        this();
    }

    public static final <T> f<T> a() {
        return f21288h.a();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T r5) {
        if (size() != 0) goto L6;
        this.f21289f = r5;
    L24:
        c(size() + 1);
        return true;
    L6:
        if (size() != 1) goto L12;
        if (o.a(this.f21289f, r5) == false) goto L10;
        return false;
    L10:
        this.f21289f = new Object[]{this.f21289f, r5};
        goto L24
    L12:
        if (size() >= 5) goto L21;
        Object r0 = this.f21289f;
        o.d(r0, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        Object[] r1 = (Object[]) r0;
        if (i.s(r1, r5) == false) goto L17;
        return false;
    L17:
        if (size() != 4) goto L19;
        LinkedHashSet r2 = t0.c(Arrays.copyOf(r1, r1.length));
        r2.add(r5);
        Object r3 = r2;
    L20:
        this.f21289f = r3;
        goto L24
    L19:
        Object[] r4 = Arrays.copyOf(r1, size() + 1);
        o.e(r4, "copyOf(this, newSize)");
        r4[r4.length - 1] = r5;
        r3 = r4;
        goto L20
    L21:
        Object r6 = this.f21289f;
        o.d(r6, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        if (j0.d(r6).add(r5) == true) goto L24;
        return false;
    }

    public int b() {
        return this.f21290g;
    }

    public void c(int r1) {
        this.f21290g = r1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f21289f = null;
        c(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r3) {
        if (size() != 0) goto L6;
        return false;
    L6:
        if (size() == 1) goto L14;
        int r0 = size();
        Object r2 = this.f21289f;
        if (r0 >= 5) goto L11;
        o.d(r2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        return i.s((Object[]) r2, r3);
    L11:
        o.d(r2, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ((Set) r2).contains(r3);
    L14:
        return o.a(this.f21289f, r3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<T> iterator() {
        if (size() != 0) goto L7;
        Set r2 = Collections.emptySet();
    L14:
        return r2.iterator();
    L7:
        if (size() != 1) goto L11;
        Iterator<T> r0 = new c(this.f21289f);
    L15:
        return r0;
    L11:
        if (size() >= 5) goto L13;
        Object r3 = this.f21289f;
        o.d(r3, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        r0 = new a((Object[]) r3);
        goto L15
    L13:
        Object r4 = this.f21289f;
        o.d(r4, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        r2 = j0.d(r4);
        goto L14
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return b();
    }
}
