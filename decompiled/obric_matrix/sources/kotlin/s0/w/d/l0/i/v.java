package kotlin.s0.w.d.l0.i;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
class v<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f20393f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<v<K, V>.c> f20394g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<K, V> f20395h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f20396i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile v<K, V>.e f20397j;

    /* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
    static class a<FieldDescriptorType> extends v<FieldDescriptorType, Object> {
        a(int r2) {
            super(r2, null);
        }

        @Override // kotlin.s0.w.d.l0.i.v
        public void n() {
            if (m() == true) goto L17;
            int r0 = 0;
        L6:
            if (r0 >= j()) goto L11;
            Map.Entry<FieldDescriptorType, Object> r1 = i(r0);
            if (((h.b) r1.getKey()).isRepeated() == false) goto L10;
            r1.setValue(Collections.unmodifiableList((List) r1.getValue()));
        L10:
            r0 = r0 + 1;
            goto L6
        L11:
            Iterator<Map.Entry<FieldDescriptorType, Object>> r2 = k().iterator();
        L13:
            if (r2.hasNext() == false) goto L17;
            Map.Entry<FieldDescriptorType, Object> r3 = r2.next();
            if (((h.b) r3.getKey()).isRepeated() == false) goto L13;
            r3.setValue(Collections.unmodifiableList((List) r3.getValue()));
        L17:
            super.n();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object r1, Object r2) {
            return super.p((h.b) r1, r2);
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Iterator<Object> f20398a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Iterable<Object> f20399b = null;

        static class a implements Iterator<Object> {
            a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.i.v$b$b, reason: collision with other inner class name */
        static class C0552b implements Iterable<Object> {
            C0552b() {
            }

            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return b.a();
            }
        }

        static {
            f20398a = new a();
            f20399b = new C0552b();
        }

        static /* synthetic */ Iterator a() {
            return f20398a;
        }

        static <T> Iterable<T> b() {
            return (Iterable<T>) f20399b;
        }
    }

    private class c implements Comparable<v<K, V>.c>, Map.Entry<K, V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final K f20400f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private V f20401g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ v f20402h;

        c(v r1, K r2, V r3) {
            this.f20402h = r1;
            this.f20400f = r2;
            this.f20401g = r3;
        }

        c(v r2, Map.Entry<K, V> r3) {
            this(r2, r3.getKey(), r3.getValue());
        }

        private boolean b(Object r1, Object r2) {
            if (r1 != null) goto L7;
            if (r2 != null) goto L5;
            return true;
        L5:
            return false;
        L7:
            return r1.equals(r2);
        }

        public int a(v<K, V>.c r1) {
            return c().compareTo(r1.c());
        }

        public K c() {
            return this.f20400f;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r1) {
            return a((c) r1);
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if ((r5 instanceof Map.Entry) == true) goto L8;
            return false;
        L8:
            Map.Entry r6 = (Map.Entry) r5;
            if (b(this.f20400f, r6.getKey()) == false) goto L14;
            if (b(this.f20401g, r6.getValue()) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // java.util.Map.Entry
        public /* bridge */ /* synthetic */ Object getKey() {
            return c();
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f20401g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K r0 = this.f20400f;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            V r3 = this.f20401g;
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
            v.a(this.f20402h);
            V r0 = this.f20401g;
            this.f20401g = r2;
            return r0;
        }

        public String toString() {
            String r0 = String.valueOf(String.valueOf(this.f20400f));
            String r4 = String.valueOf(String.valueOf(this.f20401g));
            StringBuilder r1 = new StringBuilder((r0.length() + 1) + r4.length());
            r1.append(r0);
            r1.append("=");
            r1.append(r4);
            return r1.toString();
        }
    }

    private class d implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f20403f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f20404g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f20405h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ v f20406i;

        private d(v r1) {
            this.f20406i = r1;
            this.f20403f = -1;
        }

        /* synthetic */ d(v r1, a r2) {
            this(r1);
        }

        private Iterator<Map.Entry<K, V>> b() {
            if (this.f20405h != null) goto L6;
            this.f20405h = v.e(this.f20406i).entrySet().iterator();
        L6:
            return this.f20405h;
        }

        public Map.Entry<K, V> c() {
            this.f20404g = true;
            int r1 = this.f20403f + 1;
            this.f20403f = r1;
            if (r1 >= v.b(this.f20406i).size()) goto L7;
            Map.Entry<K, V> r2 = (Map.Entry<K, V>) v.b(this.f20406i).get(this.f20403f);
        L6:
            return r2;
        L7:
            r2 = b().next();
            goto L6
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if ((this.f20403f + 1) >= v.b(this.f20406i).size()) goto L5;
            return true;
        L5:
            if (b().hasNext() == true) goto L10;
            return false;
        L10:
            return true;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return c();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f20404g == false) goto L10;
            this.f20404g = false;
            v.a(this.f20406i);
            if (this.f20403f >= v.b(this.f20406i).size()) goto L7;
            v r0 = this.f20406i;
            int r1 = this.f20403f;
            this.f20403f = r1 - 1;
            v.c(r0, r1);
            return;
        L7:
            b().remove();
            return;
        L10:
            throw new IllegalStateException("remove() was called before next()");
        }
    }

    private class e extends AbstractSet<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ v f20407f;

        private e(v r1) {
            this.f20407f = r1;
        }

        /* synthetic */ e(v r1, a r2) {
            this(r1);
        }

        public boolean a(Map.Entry<K, V> r2) {
            if (contains(r2) == true) goto L6;
            this.f20407f.p(r2.getKey(), r2.getValue());
            return true;
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public /* bridge */ /* synthetic */ boolean add(Object r1) {
            return a((Map.Entry) r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f20407f.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r2) {
            Map.Entry r3 = (Map.Entry) r2;
            Object r1 = this.f20407f.get(r3.getKey());
            Object r4 = r3.getValue();
            if (r1 == r4) goto L9;
            if (r1 != null) goto L6;
        L8:
            return false;
        L6:
            if (r1.equals(r4) == false) goto L8;
        L9:
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d(this.f20407f, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r2) {
            Map.Entry r3 = (Map.Entry) r2;
            if (contains(r3) == false) goto L6;
            this.f20407f.remove(r3.getKey());
            return true;
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f20407f.size();
        }
    }

    private v(int r1) {
        this.f20393f = r1;
        this.f20394g = Collections.emptyList();
        this.f20395h = Collections.emptyMap();
    }

    /* synthetic */ v(int r1, a r2) {
        this(r1);
    }

    static /* synthetic */ void a(v r0) {
        r0.g();
    }

    static /* synthetic */ List b(v r0) {
        return r0.f20394g;
    }

    static /* synthetic */ Object c(v r0, int r1) {
        return r0.q(r1);
    }

    static /* synthetic */ Map e(v r0) {
        return r0.f20395h;
    }

    private int f(K r5) {
        int r0 = this.f20394g.size() - 1;
        if (r0 < 0) goto L10;
        int r1 = r5.compareTo(this.f20394g.get(r0).c());
        if (r1 > 0) goto L7;
        if (r1 != 0) goto L10;
        return r0;
    L7:
        return -(r0 + 2);
    L10:
        int r2 = 0;
    L11:
        if (r2 > r0) goto L19;
        int r3 = (r2 + r0) / 2;
        int r4 = r5.compareTo(this.f20394g.get(r3).c());
        if (r4 < 0) goto L14;
        if (r4 <= 0) goto L17;
        r2 = r3 + 1;
        goto L11
    L17:
        return r3;
    L14:
        r0 = r3 - 1;
        goto L11
    L19:
        return -(r2 + 1);
    }

    private void g() {
        if (this.f20396i == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    private void h() {
        g();
        if (this.f20394g.isEmpty() == true) goto L5;
        return;
    L5:
        if ((this.f20394g instanceof ArrayList) == true) goto L9;
        this.f20394g = new ArrayList(this.f20393f);
        return;
    }

    private SortedMap<K, V> l() {
        g();
        if (this.f20395h.isEmpty() == false) goto L8;
        if ((this.f20395h instanceof TreeMap) == true) goto L8;
        this.f20395h = new TreeMap();
    L8:
        return (SortedMap) this.f20395h;
    }

    static <FieldDescriptorType extends h.b<FieldDescriptorType>> v<FieldDescriptorType, Object> o(int r1) {
        return new a(r1);
    }

    private V q(int r5) {
        g();
        V r6 = this.f20394g.remove(r5).getValue();
        if (this.f20395h.isEmpty() == true) goto L5;
        Iterator<Map.Entry<K, V>> r0 = l().entrySet().iterator();
        this.f20394g.add(new c(this, r0.next()));
        r0.remove();
    L5:
        return r6;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        g();
        if (this.f20394g.isEmpty() == true) goto L6;
        this.f20394g.clear();
    L6:
        if (this.f20395h.isEmpty() == true) goto L9;
        this.f20395h.clear();
        return;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r2) {
        Comparable r3 = (Comparable) r2;
        if (f(r3) < 0) goto L5;
    L8:
        return true;
    L5:
        if (this.f20395h.containsKey(r3) == true) goto L8;
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f20397j != null) goto L6;
        this.f20397j = new e(this, null);
    L6:
        return this.f20397j;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r2) {
        Comparable r3 = (Comparable) r2;
        int r0 = f(r3);
        if (r0 < 0) goto L7;
        return this.f20394g.get(r0).getValue();
    L7:
        return this.f20395h.get(r3);
    }

    public Map.Entry<K, V> i(int r1) {
        return this.f20394g.get(r1);
    }

    public int j() {
        return this.f20394g.size();
    }

    public Iterable<Map.Entry<K, V>> k() {
        if (this.f20395h.isEmpty() == false) goto L6;
        return b.b();
    L6:
        return this.f20395h.entrySet();
    }

    public boolean m() {
        return this.f20396i;
    }

    public void n() {
        if (this.f20396i == false) goto L5;
        return;
    L5:
        if (this.f20395h.isEmpty() == false) goto L7;
        Map<K, V> r0 = Collections.emptyMap();
    L8:
        this.f20395h = r0;
        this.f20396i = true;
        return;
    L7:
        r0 = Collections.unmodifiableMap(this.f20395h);
        goto L8
    }

    public V p(K r5, V r6) {
        g();
        int r0 = f(r5);
        if (r0 >= 0) goto L5;
        h();
        int r1 = -(r0 + 1);
        if (r1 >= this.f20393f) goto L9;
        int r2 = this.f20394g.size();
        int r3 = this.f20393f;
        if (r2 != r3) goto L13;
        v<K, V>.c r4 = this.f20394g.remove(r3 - 1);
        l().put(r4.c(), r4.getValue());
    L13:
        this.f20394g.add(r1, new c(this, r5, r6));
        return null;
    L9:
        return l().put(r5, r6);
    L5:
        return this.f20394g.get(r0).setValue(r6);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r2) {
        g();
        Comparable r3 = (Comparable) r2;
        int r0 = f(r3);
        if (r0 < 0) goto L7;
        return q(r0);
    L7:
        if (this.f20395h.isEmpty() == false) goto L11;
        return null;
    L11:
        return this.f20395h.remove(r3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f20394g.size() + this.f20395h.size();
    }
}
