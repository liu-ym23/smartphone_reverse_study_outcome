package kotlin.collections.builders;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, KMutableMap {
    public Object[] b;
    public Object[] c;
    public int[] e;
    public int[] f;
    public int i;
    public int j;
    public int k;
    public int l;
    public MapBuilderKeys m;
    public MapBuilderValues n;
    public MapBuilderEntries o;
    public boolean p;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class EntriesItr<K, V> extends Itr<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator {
        @Override // java.util.Iterator
        public final Object next() {
            int r0 = this.c;
            MapBuilder r1 = this.b;
            if (r0 >= r1.j) goto L7;
            this.c = r0 + 1;
            this.e = r0;
            EntryRef r2 = new EntryRef(r1, r0);
            a();
            return r2;
        L7:
            throw new NoSuchElementException();
        }
    }

    @Metadata
    public static final class EntryRef<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        public final MapBuilder b;
        public final int c;

        public EntryRef(MapBuilder r2, int r3) {
            Intrinsics.f(r2, "map");
            this.b = r2;
            this.c = r3;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object r3) {
            if ((r3 instanceof Map.Entry) == false) goto L9;
            Map.Entry r4 = (Map.Entry) r3;
            if (Intrinsics.a(r4.getKey(), getKey()) == false) goto L9;
            if (Intrinsics.a(r4.getValue(), getValue()) == false) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.b.b[this.c];
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            Object[] r0 = this.b.c;
            Intrinsics.c(r0);
            return r0[this.c];
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            Object r0 = getKey();
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            Object r3 = getValue();
            if (r3 == null) goto L10;
            r1 = r3.hashCode();
        L10:
            return r2 ^ r1;
        L5:
            r2 = 0;
            goto L6
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object r3) {
            MapBuilder r0 = this.b;
            r0.b();
            Object[] r1 = r0.c;
            if (r1 != null) goto L8;
            int r2 = r0.b.length;
            if (r2 < 0) goto L11;
            r1 = new Object[r2];
            r0.c = r1;
            goto L8
        L11:
            throw new IllegalArgumentException("capacity must be non-negative.".toString());
        L8:
            int r4 = this.c;
            Object r5 = r1[r4];
            r1[r4] = r3;
            return r5;
        }

        public final String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append(getKey());
            r0.append('=');
            r0.append(getValue());
            return r0.toString();
        }
    }

    @Metadata
    public static class Itr<K, V> {
        public final MapBuilder b;
        public int c;
        public int e;

        public Itr(MapBuilder r2) {
            Intrinsics.f(r2, "map");
            this.b = r2;
            this.e = -1;
            a();
        }

        public final void a() {
        L2:
            int r0 = this.c;
            MapBuilder r1 = this.b;
            if (r0 >= r1.j) goto L7;
            if (r1.e[r0] >= 0) goto L10;
            this.c = r0 + 1;
            goto L2
        L10:
            return;
        }

        public final boolean hasNext() {
            if (this.c >= this.b.j) goto L5;
            return true;
        L5:
            return false;
        }

        public final void remove() {
            if (this.e == (-1)) goto L7;
            MapBuilder r0 = this.b;
            r0.b();
            r0.j(this.e);
            this.e = -1;
            return;
        L7:
            throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
        }
    }

    @Metadata
    public static final class KeysItr<K, V> extends Itr<K, V> implements Iterator<K>, KMutableIterator {
        @Override // java.util.Iterator
        public final Object next() {
            int r0 = this.c;
            MapBuilder r1 = this.b;
            if (r0 >= r1.j) goto L7;
            this.c = r0 + 1;
            this.e = r0;
            Object r2 = r1.b[r0];
            a();
            return r2;
        L7:
            throw new NoSuchElementException();
        }
    }

    @Metadata
    public static final class ValuesItr<K, V> extends Itr<K, V> implements Iterator<V>, KMutableIterator {
        @Override // java.util.Iterator
        public final Object next() {
            int r0 = this.c;
            MapBuilder r1 = this.b;
            if (r0 >= r1.j) goto L7;
            this.c = r0 + 1;
            this.e = r0;
            Object[] r2 = r1.c;
            Intrinsics.c(r2);
            Object r3 = r2[this.e];
            a();
            return r3;
        L7:
            throw new NoSuchElementException();
        }
    }

    static {
    }

    public MapBuilder(int r5) {
        if (r5 < 0) goto L9;
        Object[] r0 = new Object[r5];
        int[] r1 = new int[r5];
        if (r5 >= 1) goto L6;
        r5 = 1;
    L6:
        int r6 = Integer.highestOneBit(r5 * 3);
        this.b = r0;
        this.c = null;
        this.e = r1;
        this.f = new int[r6];
        this.i = 2;
        this.j = 0;
        this.k = Integer.numberOfLeadingZeros(r6) + 1;
        return;
    L9:
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    public final int a(Object r8) {
        b();
    L3:
        int r0 = h(r8);
        int r1 = this.i * 2;
        int r2 = this.f.length / 2;
        if (r1 <= r2) goto L6;
        r1 = r2;
    L6:
        int r3 = 0;
    L7:
        int[] r4 = this.f;
        int r5 = r4[r0];
        if (r5 <= 0) goto L9;
        if (Intrinsics.a(this.b[r5 - 1], r8) == true) goto L19;
        r3 = r3 + 1;
        if (r3 > r1) goto L22;
        int r6 = r0 - 1;
        if (r0 == 0) goto L25;
        r0 = r6;
        goto L7
    L25:
        r0 = this.f.length - 1;
        goto L7
    L22:
        i(this.f.length * 2);
        goto L3
    L19:
        return -r5;
    L9:
        int r7 = this.j;
        Object[] r9 = this.b;
        if (r7 < r9.length) goto L12;
        e(1);
        goto L3
    L12:
        int r10 = r7 + 1;
        this.j = r10;
        r9[r7] = r8;
        this.e[r7] = r0;
        r4[r0] = r10;
        this.l++;
        if (r3 <= this.i) goto L15;
        this.i = r3;
    L15:
        return r7;
    }

    public final void b() {
        if (this.p == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    public final boolean c(Collection r3) {
        Intrinsics.f(r3, "m");
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        Object r0 = r4.next();
        if (r0 == null) goto L9;
        if (d((Map.Entry) r0) == true) goto L4;
    L9:
        return false;
    L10:
        return true;
    }

    @Override // java.util.Map
    public final void clear() {
        b();
        IntProgressionIterator r0 = new IntRange(0, this.j - 1, 1).a();
    L4:
        if (r0.e == false) goto L8;
        int r1 = r0.nextInt();
        int[] r2 = this.e;
        int r4 = r2[r1];
        if (r4 < 0) goto L4;
        this.f[r4] = 0;
        r2[r1] = -1;
        goto L4
    L8:
        ListBuilderKt.a(this.b, 0, this.j);
        Object[] r3 = this.c;
        if (r3 == null) goto L11;
        ListBuilderKt.a(r3, 0, this.j);
    L11:
        this.l = 0;
        this.j = 0;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object r1) {
        if (f(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r1) {
        if (g(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean d(Map.Entry r2) {
        Intrinsics.f(r2, "entry");
        int r0 = f(r2.getKey());
        if (r0 >= 0) goto L6;
        return false;
    L6:
        Object[] r1 = this.c;
        Intrinsics.c(r1);
        return Intrinsics.a(r1[r0], r2.getValue());
    }

    public final void e(int r4) {
        int r0 = this.j;
        int r5 = r4 + r0;
        if (r5 < 0) goto L25;
        Object[] r1 = this.b;
        if (r5 <= r1.length) goto L21;
        int r2 = (r1.length * 3) / 2;
        if (r5 > r2) goto L10;
        r5 = r2;
    L10:
        Object[] r3 = Arrays.copyOf(r1, r5);
        Intrinsics.e(r3, "copyOf(this, newSize)");
        this.b = r3;
        Object[] r6 = this.c;
        if (r6 == null) goto L13;
        Object[] r7 = Arrays.copyOf(r6, r5);
        Intrinsics.e(r7, "copyOf(this, newSize)");
    L14:
        this.c = r7;
        int[] r8 = Arrays.copyOf(this.e, r5);
        Intrinsics.e(r8, "copyOf(this, newSize)");
        this.e = r8;
        if (r5 >= 1) goto L17;
        r5 = 1;
    L17:
        int r9 = Integer.highestOneBit(r5 * 3);
        if (r9 <= this.f.length) goto L26;
        i(r9);
        return;
    L26:
        return;
    L13:
        r7 = null;
        goto L14
    L21:
        if (((r0 + r5) - this.l) <= r1.length) goto L28;
        i(this.f.length);
        return;
    L28:
        return;
    L25:
        throw new OutOfMemoryError();
    }

    @Override // java.util.Map
    public final Set entrySet() {
        MapBuilderEntries r0 = this.o;
        if (r0 != null) goto L6;
        MapBuilderEntries r1 = new MapBuilderEntries(this);
        this.o = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // java.util.Map
    public final boolean equals(Object r3) {
        if (r3 != this) goto L4;
    L11:
        return true;
    L4:
        if ((r3 instanceof Map) == false) goto L10;
        Map r4 = (Map) r3;
        if (this.l != r4.size()) goto L10;
        if (c(r4.entrySet()) == true) goto L11;
    L10:
        return false;
    }

    public final int f(Object r6) {
        int r0 = h(r6);
        int r1 = this.i;
    L3:
        int r2 = this.f[r0];
        if (r2 == 0) goto L5;
        if (r2 <= 0) goto L10;
        int r3 = r2 - 1;
        if (Intrinsics.a(this.b[r3], r6) == false) goto L10;
        return r3;
    L10:
        r1 = r1 - 1;
        if (r1 < 0) goto L12;
        int r4 = r0 - 1;
        if (r0 == 0) goto L15;
        r0 = r4;
        goto L3
    L15:
        r0 = this.f.length - 1;
        goto L3
    L12:
        return -1;
    L5:
        return -1;
    }

    public final int g(Object r3) {
        int r0 = this.j;
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L10;
        if (this.e[r0] < 0) goto L3;
        Object[] r1 = this.c;
        Intrinsics.c(r1);
        if (Intrinsics.a(r1[r0], r3) == false) goto L3;
        return r0;
    L10:
        return -1;
    }

    @Override // java.util.Map
    public final Object get(Object r1) {
        int r2 = f(r1);
        if (r2 >= 0) goto L6;
        return null;
    L6:
        Object[] r0 = this.c;
        Intrinsics.c(r0);
        return r0[r2];
    }

    public final int h(Object r2) {
        if (r2 == null) goto L4;
        int r3 = r2.hashCode();
    L6:
        return (r3 * (-1640531527)) >>> this.k;
    L4:
        r3 = 0;
        goto L6
    }

    @Override // java.util.Map
    public final int hashCode() {
        EntriesItr r0 = new EntriesItr(this);
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L18;
        int r2 = r0.c;
        MapBuilder r3 = r0.b;
        if (r2 >= r3.j) goto L17;
        r0.c = r2 + 1;
        r0.e = r2;
        Object r4 = r3.b[r2];
        if (r4 == null) goto L10;
        int r5 = r4.hashCode();
    L11:
        Object[] r6 = r3.c;
        Intrinsics.c(r6);
        Object r7 = r6[r0.e];
        if (r7 == null) goto L14;
        int r8 = r7.hashCode();
    L15:
        r0.a();
        r1 = r1 + (r5 ^ r8);
        goto L4
    L14:
        r8 = 0;
        goto L15
    L10:
        r5 = 0;
        goto L11
    L17:
        throw new NoSuchElementException();
    L18:
        return r1;
    }

    public final void i(int r7) {
        int r2 = 0;
        if (this.j <= this.l) goto L18;
        Object[] r0 = this.c;
        int r1 = 0;
        int r3 = 0;
    L5:
        int r4 = this.j;
        if (r1 >= r4) goto L14;
        if (this.e[r1] < 0) goto L13;
        Object[] r5 = this.b;
        r5[r3] = r5[r1];
        if (r0 == null) goto L12;
        r0[r3] = r0[r1];
    L12:
        r3 = r3 + 1;
    L13:
        r1 = r1 + 1;
        goto L5
    L14:
        ListBuilderKt.a(this.b, r3, r4);
        if (r0 == null) goto L17;
        ListBuilderKt.a(r0, r3, this.j);
    L17:
        this.j = r3;
    L18:
        int[] r6 = this.f;
        if (r7 == r6.length) goto L21;
        this.f = new int[r7];
        this.k = Integer.numberOfLeadingZeros(r7) + 1;
    L23:
        if (r2 >= this.j) goto L36;
        int r8 = r2 + 1;
        int r9 = h(this.b[r2]);
        int r10 = this.i;
    L25:
        int[] r11 = this.f;
        if (r11[r9] == 0) goto L27;
        r10 = r10 - 1;
        if (r10 < 0) goto L35;
        int r12 = r9 - 1;
        if (r9 == 0) goto L32;
        r9 = r12;
        goto L25
    L32:
        r9 = r11.length - 1;
        goto L25
    L35:
        throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
    L27:
        r11[r9] = r8;
        this.e[r2] = r9;
        r2 = r8;
        goto L23
    L36:
        return;
    L21:
        Arrays.fill(r6, 0, r6.length, 0);
        goto L23
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        if (this.l != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void j(int r12) {
        Object[] r0 = this.b;
        Intrinsics.f(r0, "<this>");
        r0[r12] = null;
        int r1 = this.e[r12];
        int r2 = this.i * 2;
        int r3 = this.f.length / 2;
        if (r2 <= r3) goto L5;
        r2 = r3;
    L5:
        int r4 = r2;
        int r5 = 0;
        int r6 = r1;
    L6:
        int r7 = r1 - 1;
        if (r1 != 0) goto L9;
        r1 = this.f.length - 1;
    L10:
        r5 = r5 + 1;
        if (r5 > this.i) goto L12;
        int[] r8 = this.f;
        int r9 = r8[r1];
        if (r9 == 0) goto L15;
        if (r9 >= 0) goto L19;
        r8[r6] = -1;
    L18:
        r6 = r1;
        r5 = 0;
    L22:
        r4 = r4 - 1;
        if (r4 >= 0) goto L6;
        this.f[r6] = -1;
    L25:
        this.e[r12] = -1;
        this.l--;
        return;
    L19:
        int r10 = r9 - 1;
        int r11 = h(this.b[r10]) - r1;
        int[] r13 = this.f;
        if ((r11 & (r13.length - 1)) < r5) goto L22;
        r13[r6] = r9;
        this.e[r10] = r6;
        goto L18
    L15:
        r8[r6] = 0;
        goto L25
    L12:
        this.f[r6] = 0;
        goto L25
    L9:
        r1 = r7;
        goto L10
    }

    @Override // java.util.Map
    public final Set keySet() {
        MapBuilderKeys r0 = this.m;
        if (r0 != null) goto L6;
        MapBuilderKeys r1 = new MapBuilderKeys(this);
        this.m = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // java.util.Map
    public final Object put(Object r2, Object r3) {
        b();
        int r4 = a(r2);
        Object[] r0 = this.c;
        if (r0 != null) goto L8;
        int r1 = this.b.length;
        if (r1 < 0) goto L14;
        r0 = new Object[r1];
        this.c = r0;
        goto L8
    L14:
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    L8:
        if (r4 >= 0) goto L11;
        int r5 = (-r4) - 1;
        Object r6 = r0[r5];
        r0[r5] = r3;
        return r6;
    L11:
        r0[r4] = r3;
        return null;
    }

    @Override // java.util.Map
    public final void putAll(Map r6) {
        Intrinsics.f(r6, "from");
        b();
        Set<Map.Entry<K, V>> r7 = r6.entrySet();
        if (r7.isEmpty() == true) goto L21;
        e(r7.size());
        Iterator<Map.Entry<K, V>> r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L31;
        Map.Entry<K, V> r0 = r8.next();
        int r1 = a(r0.getKey());
        Object[] r2 = this.c;
        if (r2 != null) goto L14;
        int r3 = this.b.length;
        if (r3 < 0) goto L20;
        r2 = new Object[r3];
        this.c = r2;
        goto L14
    L20:
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    L14:
        if (r1 >= 0) goto L15;
        int r4 = (-r1) - 1;
        if (Intrinsics.a(r0.getValue(), r2[r4]) == true) goto L7;
        r2[r4] = r0.getValue();
        goto L7
    L15:
        r2[r1] = r0.getValue();
        goto L7
    L31:
        return;
    }

    @Override // java.util.Map
    public final Object remove(Object r3) {
        b();
        int r4 = f(r3);
        if (r4 >= 0) goto L5;
        r4 = -1;
    L7:
        if (r4 >= 0) goto L9;
        return null;
    L9:
        Object[] r2 = this.c;
        Intrinsics.c(r2);
        Object r1 = r2[r4];
        r2[r4] = null;
        return r1;
    L5:
        j(r4);
        goto L7
    }

    @Override // java.util.Map
    public final int size() {
        return this.l;
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder((this.l * 3) + 2);
        r0.append("{");
        EntriesItr r1 = new EntriesItr(this);
        int r6 = 0;
    L4:
        if (r1.hasNext() == false) goto L20;
        if (r6 <= 0) goto L7;
        r0.append(", ");
    L7:
        int r2 = r1.c;
        MapBuilder r3 = r1.b;
        if (r2 >= r3.j) goto L19;
        r1.c = r2 + 1;
        r1.e = r2;
        Object r4 = r3.b[r2];
        if (Intrinsics.a(r4, r3) == false) goto L12;
        r0.append("(this Map)");
    L13:
        r0.append('=');
        Object[] r5 = r3.c;
        Intrinsics.c(r5);
        Object r7 = r5[r1.e];
        if (Intrinsics.a(r7, r3) == false) goto L16;
        r0.append("(this Map)");
    L17:
        r1.a();
        r6 = r6 + 1;
        goto L4
    L16:
        r0.append(r7);
        goto L17
    L12:
        r0.append(r4);
        goto L13
    L19:
        throw new NoSuchElementException();
    L20:
        r0.append("}");
        String r8 = r0.toString();
        Intrinsics.e(r8, "sb.toString()");
        return r8;
    }

    @Override // java.util.Map
    public final Collection values() {
        MapBuilderValues r0 = this.n;
        if (r0 != null) goto L6;
        MapBuilderValues r1 = new MapBuilderValues(this);
        this.n = r1;
        return r1;
    L6:
        return r0;
    }
}
