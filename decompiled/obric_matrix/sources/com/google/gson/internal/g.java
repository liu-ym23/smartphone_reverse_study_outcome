package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class g<K, V> extends AbstractMap<K, V> implements Serializable {
    private static final Comparator<Comparable> n = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Comparator<? super K> f7044f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f7045g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    e<K, V> f7046h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f7047i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f7048j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final e<K, V> f7049k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private g<K, V>.b f7050l;
    private g<K, V>.c m;

    class a implements Comparator<Comparable> {
        a() {
        }

        public int a(Comparable r1, Comparable r2) {
            return r1.compareTo(r2);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Comparable r1, Comparable r2) {
            return a(r1, r2);
        }
    }

    class b extends AbstractSet<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f7051f;

        class a extends g<K, V>.d<Map.Entry<K, V>> {
            a(b r1) {
                super(r1.f7051f);
            }

            public Map.Entry<K, V> c() {
                return b();
            }

            @Override // java.util.Iterator
            public /* bridge */ /* synthetic */ Object next() {
                return c();
            }
        }

        b(g r1) {
            this.f7051f = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f7051f.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r2) {
            if ((r2 instanceof Map.Entry) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.f7051f.c((Map.Entry) r2) == null) goto L7;
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r3) {
            if ((r3 instanceof Map.Entry) == true) goto L5;
            return false;
        L5:
            e<K, V> r4 = this.f7051f.c((Map.Entry) r3);
            if (r4 != null) goto L8;
            return false;
        L8:
            this.f7051f.g(r4, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f7051f.f7047i;
        }
    }

    final class c extends AbstractSet<K> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f7052f;

        class a extends g<K, V>.d<K> {
            a(c r1) {
                super(r1.f7052f);
            }

            @Override // java.util.Iterator
            public K next() {
                return b().f7062k;
            }
        }

        c(g r1) {
            this.f7052f = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f7052f.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return this.f7052f.containsKey(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r1) {
            if (this.f7052f.h(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f7052f.f7047i;
        }
    }

    private abstract class d<T> implements Iterator<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        e<K, V> f7053f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        e<K, V> f7054g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f7055h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ g f7056i;

        d(g r2) {
            this.f7056i = r2;
            this.f7053f = r2.f7049k.f7060i;
            this.f7054g = null;
            this.f7055h = r2.f7048j;
        }

        final e<K, V> b() {
            e<K, V> r0 = this.f7053f;
            g r1 = this.f7056i;
            if (r0 == r1.f7049k) goto L11;
            if (r1.f7048j != this.f7055h) goto L9;
            this.f7053f = r0.f7060i;
            this.f7054g = r0;
            return r0;
        L9:
            throw new ConcurrentModificationException();
        L11:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f7053f == this.f7056i.f7049k) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> r0 = this.f7054g;
            if (r0 == null) goto L7;
            this.f7056i.g(r0, true);
            this.f7054g = null;
            this.f7055h = this.f7056i.f7048j;
            return;
        L7:
            throw new IllegalStateException();
        }
    }

    static final class e<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        e<K, V> f7057f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        e<K, V> f7058g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        e<K, V> f7059h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        e<K, V> f7060i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        e<K, V> f7061j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final K f7062k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final boolean f7063l;
        V m;
        int n;

        e(boolean r2) {
            this.f7062k = null;
            this.f7063l = r2;
            this.f7061j = this;
            this.f7060i = this;
        }

        e(boolean r1, e<K, V> r2, K r3, e<K, V> r4, e<K, V> r5) {
            this.f7057f = r2;
            this.f7062k = r3;
            this.f7063l = r1;
            this.n = 1;
            this.f7060i = r4;
            this.f7061j = r5;
            r5.f7060i = this;
            r4.f7061j = this;
        }

        public e<K, V> a() {
        L2:
            e<K, V> r0 = this;
            e<K, V> this = this.f7058g;
            if (this != null) goto L2;
            return r0;
        }

        public e<K, V> b() {
        L2:
            e<K, V> r0 = this;
            e<K, V> this = this.f7059h;
            if (this != null) goto L2;
            return r0;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r4) {
            if ((r4 instanceof Map.Entry) == false) goto L20;
            Map.Entry r5 = (Map.Entry) r4;
            K r0 = this.f7062k;
            if (r0 != null) goto L10;
            if (r5.getKey() != null) goto L21;
        L11:
            V r3 = this.m;
            if (r3 != null) goto L17;
            if (r5.getValue() != null) goto L23;
        L18:
            return true;
        L23:
            return false;
        L17:
            if (r3.equals(r5.getValue()) == true) goto L18;
            return false;
        L21:
            return false;
        L10:
            if (r0.equals(r5.getKey()) == true) goto L11;
            return false;
        L20:
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f7062k;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.m;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K r0 = this.f7062k;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            V r3 = this.m;
            if (r3 == null) goto L11;
            r1 = r3.hashCode();
        L11:
            return r2 ^ r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        @Override // java.util.Map.Entry
        public V setValue(V r2) {
            if (r2 == null) goto L4;
        L8:
            V r0 = this.m;
            this.m = r2;
            return r0;
        L4:
            if (this.f7063l == true) goto L8;
            throw new NullPointerException("value == null");
        }

        public String toString() {
            return this.f7062k + "=" + this.m;
        }
    }

    static {
        n = new a();
    }

    public g() {
        this(n, true);
    }

    public g(Comparator<? super K> r2, boolean r3) {
        this.f7047i = 0;
        this.f7048j = 0;
        if (r2 != null) goto L6;
        r2 = n;
    L6:
        this.f7044f = r2;
        this.f7045g = r3;
        this.f7049k = new e(r3);
    }

    public g(boolean r2) {
        this(n, r2);
    }

    private boolean a(Object r1, Object r2) {
        return Objects.equals(r1, r2);
    }

    private void f(e<K, V> r8, boolean r9) {
    L2:
        if (r8 == null) goto L52;
        e<K, V> r0 = r8.f7058g;
        e<K, V> r1 = r8.f7059h;
        int r2 = 0;
        if (r0 == null) goto L6;
        int r3 = r0.n;
    L7:
        if (r1 == null) goto L9;
        int r4 = r1.n;
    L10:
        int r5 = r3 - r4;
        if (r5 != (-2)) goto L28;
        e<K, V> r6 = r1.f7058g;
        e<K, V> r7 = r1.f7059h;
        if (r7 == null) goto L15;
        int r10 = r7.n;
    L16:
        if (r6 == null) goto L18;
        r2 = r6.n;
    L18:
        int r11 = r2 - r10;
        if (r11 == (-1)) goto L24;
        if (r11 != 0) goto L23;
        if (r9 == false) goto L24;
    L23:
        k(r1);
    L24:
        j(r8);
        if (r9 == false) goto L51;
        return;
    L51:
        r8 = r8.f7057f;
        goto L2
    L15:
        r10 = 0;
        goto L16
    L28:
        if (r5 != 2) goto L44;
        e<K, V> r12 = r0.f7058g;
        e<K, V> r13 = r0.f7059h;
        if (r13 == null) goto L32;
        int r14 = r13.n;
    L33:
        if (r12 == null) goto L35;
        r2 = r12.n;
    L35:
        int r15 = r2 - r14;
        if (r15 == 1) goto L41;
        if (r15 != 0) goto L40;
        if (r9 == false) goto L41;
    L40:
        j(r0);
    L41:
        k(r8);
        if (r9 == false) goto L51;
        return;
    L32:
        r14 = 0;
        goto L33
    L44:
        if (r5 != 0) goto L48;
        r8.n = r3 + 1;
        if (r9 == false) goto L51;
        return;
    L48:
        r8.n = Math.max(r3, r4) + 1;
        if (r9 == true) goto L51;
        return;
    L9:
        r4 = 0;
        goto L10
    L6:
        r3 = 0;
        goto L7
    }

    private void i(e<K, V> r3, e<K, V> r4) {
        e<K, V> r0 = r3.f7057f;
        r3.f7057f = null;
        if (r4 == null) goto L5;
        r4.f7057f = r0;
    L5:
        if (r0 != null) goto L7;
        this.f7046h = r4;
        return;
    L7:
        if (r0.f7058g != r3) goto L9;
        r0.f7058g = r4;
        return;
    L9:
        r0.f7059h = r4;
    }

    private void j(e<K, V> r5) {
        e<K, V> r0 = r5.f7058g;
        e<K, V> r1 = r5.f7059h;
        e<K, V> r2 = r1.f7058g;
        e<K, V> r3 = r1.f7059h;
        r5.f7059h = r2;
        if (r2 == null) goto L5;
        r2.f7057f = r5;
    L5:
        i(r5, r1);
        r1.f7058g = r5;
        r5.f7057f = r1;
        int r4 = 0;
        if (r0 == null) goto L8;
        int r6 = r0.n;
    L9:
        if (r2 == null) goto L11;
        int r7 = r2.n;
    L12:
        int r8 = Math.max(r6, r7) + 1;
        r5.n = r8;
        if (r3 == null) goto L15;
        r4 = r3.n;
    L15:
        r1.n = Math.max(r8, r4) + 1;
        return;
    L11:
        r7 = 0;
        goto L12
    L8:
        r6 = 0;
        goto L9
    }

    private void k(e<K, V> r5) {
        e<K, V> r0 = r5.f7058g;
        e<K, V> r1 = r5.f7059h;
        e<K, V> r2 = r0.f7058g;
        e<K, V> r3 = r0.f7059h;
        r5.f7058g = r3;
        if (r3 == null) goto L5;
        r3.f7057f = r5;
    L5:
        i(r5, r0);
        r0.f7059h = r5;
        r5.f7057f = r0;
        int r4 = 0;
        if (r1 == null) goto L8;
        int r6 = r1.n;
    L9:
        if (r3 == null) goto L11;
        int r7 = r3.n;
    L12:
        int r8 = Math.max(r6, r7) + 1;
        r5.n = r8;
        if (r2 == null) goto L15;
        r4 = r2.n;
    L15:
        r0.n = Math.max(r8, r4) + 1;
        return;
    L11:
        r7 = 0;
        goto L12
    L8:
        r6 = 0;
        goto L9
    }

    e<K, V> b(K r12, boolean r13) {
        Comparator<? super K> r0 = this.f7044f;
        e<K, V> r1 = this.f7046h;
        if (r1 != null) goto L5;
        int r4 = 0;
    L21:
        if (r13 == true) goto L23;
        return null;
    L23:
        e<K, V> r9 = this.f7049k;
        if (r1 == null) goto L26;
        e<K, V> r2 = new e(this.f7045g, r1, r12, r9, r9.f7061j);
        if (r4 >= 0) goto L36;
        r1.f7058g = r2;
    L37:
        f(r1, true);
    L38:
        this.f7047i++;
        this.f7048j++;
        return r2;
    L36:
        r1.f7059h = r2;
        goto L37
    L26:
        if (r0 == n) goto L28;
    L32:
        r2 = new e(this.f7045g, r1, r12, r9, r9.f7061j);
        this.f7046h = r2;
        goto L38
    L28:
        if ((r12 instanceof Comparable) == true) goto L32;
        throw new ClassCastException(r12.getClass().getName() + " is not Comparable");
    L5:
        if (r0 != n) goto L7;
        Comparable r3 = (Comparable) r12;
    L8:
        K r5 = r1.f7062k;
        if (r3 == null) goto L11;
        r4 = r3.compareTo(r5);
    L12:
        if (r4 == 0) goto L13;
        if (r4 >= 0) goto L16;
        e<K, V> r6 = r1.f7058g;
    L17:
        if (r6 == null) goto L21;
        r1 = r6;
        goto L8
    L16:
        r6 = r1.f7059h;
        goto L17
    L13:
        return r1;
    L11:
        r4 = r0.compare(r12, r5);
        goto L12
    L7:
        r3 = null;
        goto L8
    }

    e<K, V> c(Map.Entry<?, ?> r3) {
        e<K, V> r0 = e(r3.getKey());
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L12;
        return null;
    L12:
        return r0;
    L5:
        if (a(r0.m, r3.getValue()) == false) goto L7;
        r2 = true;
        goto L8
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f7046h = null;
        this.f7047i = 0;
        this.f7048j++;
        e<K, V> r1 = this.f7049k;
        r1.f7061j = r1;
        r1.f7060i = r1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r1) {
        if (e(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    e<K, V> e(Object r3) {
        if (r3 != 0) goto L8;
        return null;
    L8:
        return b(r3, false);
    L11:
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        g<K, V>.b r0 = this.f7050l;
        if (r0 != null) goto L7;
        g<K, V>.b r1 = new b(this);
        this.f7050l = r1;
        return r1;
    L7:
        return r0;
    }

    void g(e<K, V> r6, boolean r7) {
        if (r7 == false) goto L4;
        e<K, V> r8 = r6.f7061j;
        r8.f7060i = r6.f7060i;
        r6.f7060i.f7061j = r8;
    L4:
        e<K, V> r9 = r6.f7058g;
        e<K, V> r0 = r6.f7059h;
        e<K, V> r1 = r6.f7057f;
        int r2 = 0;
        if (r9 == null) goto L20;
        if (r0 == null) goto L20;
        if (r9.n <= r0.n) goto L10;
        e<K, V> r10 = r9.b();
    L11:
        g(r10, false);
        e<K, V> r3 = r6.f7058g;
        if (r3 == null) goto L14;
        int r4 = r3.n;
        r10.f7058g = r3;
        r3.f7057f = r10;
        r6.f7058g = null;
    L15:
        e<K, V> r5 = r6.f7059h;
        if (r5 == null) goto L18;
        r2 = r5.n;
        r10.f7059h = r5;
        r5.f7057f = r10;
        r6.f7059h = null;
    L18:
        r10.n = Math.max(r4, r2) + 1;
        i(r6, r10);
        return;
    L14:
        r4 = 0;
        goto L15
    L10:
        r10 = r0.a();
    L20:
        if (r9 == null) goto L22;
        i(r6, r9);
        r6.f7058g = null;
    L25:
        f(r1, false);
        this.f7047i--;
        this.f7048j++;
        return;
    L22:
        if (r0 == null) goto L24;
        i(r6, r0);
        r6.f7059h = null;
        goto L25
    L24:
        i(r6, null);
        goto L25
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r1) {
        e<K, V> r0 = e(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.m;
    }

    e<K, V> h(Object r2) {
        e<K, V> r3 = e(r2);
        if (r3 == null) goto L5;
        g(r3, true);
    L5:
        return r3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        g<K, V>.c r0 = this.m;
        if (r0 != null) goto L7;
        g<K, V>.c r1 = new c(this);
        this.m = r1;
        return r1;
    L7:
        return r0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K r2, V r3) {
        Objects.requireNonNull(r2, "key == null");
        if (r3 == null) goto L5;
    L9:
        e<K, V> r1 = b(r2, true);
        V r4 = r1.m;
        r1.m = r3;
        return r4;
    L5:
        if (this.f7045g == true) goto L9;
        throw new NullPointerException("value == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r1) {
        e<K, V> r0 = h(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.m;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f7047i;
    }
}
