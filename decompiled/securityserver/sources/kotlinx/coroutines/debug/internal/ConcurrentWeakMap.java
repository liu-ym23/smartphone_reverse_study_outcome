package kotlinx.coroutines.debug.internal;

import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableMap;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ConcurrentWeakMap<K, V> extends AbstractMutableMap<K, V> {
    public static final AtomicIntegerFieldUpdater c = null;
    private volatile int _size;
    public final ReferenceQueue b;
    volatile Object core;

    @Metadata
    public final class Core {
        public static final AtomicIntegerFieldUpdater g = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f390a;
        public final int b;
        public final AtomicReferenceArray c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReferenceArray f391d;
        public final int e;
        public final /* synthetic */ ConcurrentWeakMap f;
        private volatile int load;

        @Metadata
        public final class KeyValueIterator<E> implements Iterator<E>, KMutableIterator {
            public int b;
            public Object c;
            public Object e;
            public final Function2 f;
            public final /* synthetic */ Core i;

            public KeyValueIterator(Core r1, Function2 r2) {
                this.i = r1;
                this.f = r2;
                this.b = -1;
                a();
            }

            public final void a() {
            L2:
                int r0 = this.b + 1;
                this.b = r0;
                Core r1 = this.i;
                if (r0 >= r1.e) goto L22;
                HashedWeakRef r2 = (HashedWeakRef) r1.c.get(r0);
                if (r2 == null) goto L2;
                T r3 = r2.get();
                if (r3 == 0) goto L2;
                this.c = r3;
                Object r4 = r1.f391d.get(this.b);
                if ((r4 instanceof Marked) == false) goto L11;
                r4 = ((Marked) r4).f395a;
            L11:
                if (r4 == null) goto L2;
                this.e = r4;
                return;
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                if (this.b >= this.i.e) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // java.util.Iterator
            public final Object next() {
                if (this.b >= this.i.e) goto L15;
                Object r0 = this.c;
                if (r0 == null) goto L12;
                Object r2 = this.e;
                if (r2 == null) goto L10;
                Object r1 = this.f.mo7invoke(r0, r2);
                a();
                return r1;
            L10:
                Intrinsics.m("value");
                throw null;
            L12:
                Intrinsics.m("key");
                throw null;
            L15:
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public final void remove() {
                throw new UnsupportedOperationException("not implemented");
            }
        }

        static {
            g = AtomicIntegerFieldUpdater.newUpdater(Core.class, "load");
        }

        public Core(ConcurrentWeakMap r1, int r2) {
            this.f = r1;
            this.e = r2;
            this.f390a = Integer.numberOfLeadingZeros(r2) + 1;
            this.b = (r2 * 2) / 3;
            this.load = 0;
            this.c = new AtomicReferenceArray(r2);
            this.f391d = new AtomicReferenceArray(r2);
        }

        public final Object a(Object r7, Object r8, HashedWeakRef r9) {
            int r0 = (r7.hashCode() * (-1640531527)) >>> this.f390a;
            boolean r1 = false;
        L3:
            HashedWeakRef r2 = (HashedWeakRef) this.c.get(r0);
            Symbol r3 = ConcurrentWeakMapKt.f392a;
            if (r2 == null) goto L6;
            Object r4 = r2.get();
            if (r7.equals(r4) == true) goto L22;
            if (r4 != null) goto L32;
            c(r0);
        L32:
            if (r0 != 0) goto L34;
            r0 = this.e;
        L34:
            r0 = r0 - 1;
            goto L3
        L22:
            if (r1 == false) goto L24;
            g.decrementAndGet(this);
        L24:
            Object r10 = this.f391d.get(r0);
            if ((r10 instanceof Marked) == true) goto L26;
            if (this.f391d.compareAndSet(r0, r10, r8) == false) goto L24;
            return r10;
        L26:
            return r3;
        L6:
            if (r8 == null) goto L7;
            if (r1 == true) goto L15;
        L9:
            int r5 = this.load;
            if (r5 >= this.b) goto L11;
            if (g.compareAndSet(this, r5, r5 + 1) == false) goto L9;
            r1 = true;
            goto L15
        L11:
            return r3;
        L15:
            if (r9 != null) goto L18;
            r9 = new HashedWeakRef(r7, this.f.b);
        L18:
            if (this.c.compareAndSet(r0, null, r9) == false) goto L3;
        L7:
            return null;
        }

        public final Core b() {
        L2:
            ConcurrentWeakMap r0 = this.f;
            int r1 = r0.c();
            if (r1 >= 4) goto L5;
            r1 = 4;
        L5:
            Core r2 = new Core(r0, Integer.highestOneBit(r1) * 4);
            int r3 = 0;
        L7:
            if (r3 >= this.e) goto L32;
            HashedWeakRef r4 = (HashedWeakRef) this.c.get(r3);
            if (r4 == null) goto L11;
            Object r5 = r4.get();
        L12:
            if (r4 == null) goto L15;
            if (r5 != null) goto L15;
            c(r3);
        L15:
            AtomicReferenceArray r6 = this.f391d;
            Object r7 = r6.get(r3);
            if ((r7 instanceof Marked) == true) goto L17;
            if (r7 != null) goto L21;
            Marked r8 = ConcurrentWeakMapKt.b;
        L25:
            if (r6.compareAndSet(r3, r7, r8) == false) goto L15;
        L26:
            if (r5 == null) goto L31;
            if (r7 == null) goto L31;
            if (r2.a(r5, r7, r4) == ConcurrentWeakMapKt.f392a) goto L2;
        L31:
            r3 = r3 + 1;
            goto L7
        L21:
            if (r7.equals(Boolean.TRUE) == false) goto L23;
            r8 = ConcurrentWeakMapKt.c;
            goto L25
        L23:
            r8 = new Marked(r7);
            goto L25
        L17:
            r7 = ((Marked) r7).f395a;
            goto L26
        L11:
            r5 = null;
            goto L12
        L32:
            return r2;
        }

        public final void c(int r4) {
        L2:
            AtomicReferenceArray r0 = this.f391d;
            Object r1 = r0.get(r4);
            if (r1 == null) goto L15;
            if ((r1 instanceof Marked) == true) goto L6;
            if (r0.compareAndSet(r4, r1, null) == false) goto L2;
            AtomicIntegerFieldUpdater r5 = ConcurrentWeakMap.c;
            ConcurrentWeakMap r3 = this.f;
            r3.getClass();
            ConcurrentWeakMap.c.decrementAndGet(r3);
            return;
        L6:
            return;
        }
    }

    @Metadata
    public static final class Entry<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        public final Object b;
        public final Object c;

        public Entry(Object r1, Object r2) {
            this.b = r1;
            this.c = r2;
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            return this.c;
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object r1) {
            throw new UnsupportedOperationException("not implemented");
        }
    }

    @Metadata
    public final class KeyValueSet<E> extends AbstractMutableSet<E> {
        public final Function2 b;
        public final /* synthetic */ ConcurrentWeakMap c;

        public KeyValueSet(ConcurrentWeakMap r1, Function2 r2) {
            this.c = r1;
            this.b = r2;
        }

        @Override // kotlin.collections.AbstractMutableSet
        public final int a() {
            return this.c.c();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean add(Object r1) {
            throw new UnsupportedOperationException("not implemented");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            Core r0 = (Core) this.c.core;
            Function2 r2 = this.b;
            r0.getClass();
            return new Core.KeyValueIterator(r0, r2);
        }
    }

    static {
        c = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size");
    }

    public ConcurrentWeakMap(boolean r3) {
        this._size = 0;
        this.core = new Core(this, 16);
        if (r3 == false) goto L5;
        ReferenceQueue r4 = new ReferenceQueue();
    L6:
        this.b = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // kotlin.collections.AbstractMutableMap
    public final Set a() {
        return new KeyValueSet(this, ConcurrentWeakMap$entries$1.b);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public final Set b() {
        return new KeyValueSet(this, ConcurrentWeakMap$keys$1.b);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public final int c() {
        return this._size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        Iterator r0 = ((KeyValueSet) b()).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        remove(r0.next());
        goto L4
    }

    public final synchronized Object d(Object r4, Object r5) {
        monitor-enter(this);
        Core r0 = (Core) this.core;     // Catch: Throwable -> L9
    L4:
        AtomicIntegerFieldUpdater r1 = Core.g;     // Catch: Throwable -> L9
        Object r2 = r0.a(r4, r5, null);     // Catch: Throwable -> L9
        if (r2 != ConcurrentWeakMapKt.f392a) goto L6;
        r0 = r0.b();     // Catch: Throwable -> L9
        this.core = r0;     // Catch: Throwable -> L9
        goto L4
    L6:
        monitor-exit(this);
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object r5) {
        if (r5 == null) goto L18;
        Core r4 = (Core) this.core;
        r4.getClass();
        int r1 = (r5.hashCode() * (-1640531527)) >>> r4.f390a;
    L5:
        HashedWeakRef r2 = (HashedWeakRef) r4.c.get(r1);
        if (r2 == null) goto L24;
        Object r3 = r2.get();
        if (r5.equals(r3) == true) goto L9;
        if (r3 != null) goto L15;
        r4.c(r1);
    L15:
        if (r1 != 0) goto L17;
        r1 = r4.e;
    L17:
        r1 = r1 - 1;
        goto L5
    L9:
        Object r6 = r4.f391d.get(r1);
        if ((r6 instanceof Marked) == false) goto L23;
        r6 = ((Marked) r6).f395a;
    L23:
        return r6;
    L24:
        return null;
    L18:
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object r3, Object r4) {
        Core r0 = (Core) this.core;
        AtomicIntegerFieldUpdater r1 = Core.g;
        Object r2 = r0.a(r3, r4, null);
        if (r2 != ConcurrentWeakMapKt.f392a) goto L5;
        r2 = d(r3, r4);
    L5:
        if (r2 != null) goto L7;
        c.incrementAndGet(this);
    L7:
        return r2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object r4) {
        if (r4 == null) goto L10;
        Core r1 = (Core) this.core;
        AtomicIntegerFieldUpdater r2 = Core.g;
        Object r3 = r1.a(r4, null, null);
        if (r3 != ConcurrentWeakMapKt.f392a) goto L7;
        r3 = d(r4, null);
    L7:
        if (r3 == null) goto L9;
        c.decrementAndGet(this);
    L9:
        return r3;
    L10:
        return null;
    }
}
