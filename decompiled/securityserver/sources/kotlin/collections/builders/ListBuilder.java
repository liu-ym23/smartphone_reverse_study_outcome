package kotlin.collections.builders;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ListBuilder<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, Serializable, KMutableList {
    public Object[] b;
    public final int c;
    public int e;
    public boolean f;
    public final ListBuilder i;
    public final ListBuilder j;

    @Metadata
    public static final class Itr<E> implements ListIterator<E>, KMutableListIterator {
        public final ListBuilder b;
        public int c;
        public int e;

        public Itr(ListBuilder r2, int r3) {
            Intrinsics.f(r2, "list");
            this.b = r2;
            this.c = r3;
            this.e = -1;
        }

        @Override // java.util.ListIterator
        public final void add(Object r3) {
            int r0 = this.c;
            this.c = r0 + 1;
            this.b.add(r0, r3);
            this.e = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            if (this.c >= this.b.e) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            if (this.c <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final Object next() {
            int r0 = this.c;
            ListBuilder r1 = this.b;
            if (r0 >= r1.e) goto L7;
            this.c = r0 + 1;
            this.e = r0;
            return r1.b[r1.c + r0];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.c;
        }

        @Override // java.util.ListIterator
        public final Object previous() {
            int r0 = this.c;
            if (r0 <= 0) goto L7;
            int r1 = r0 - 1;
            this.c = r1;
            this.e = r1;
            ListBuilder r2 = this.b;
            return r2.b[r2.c + r1];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.c - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            int r0 = this.e;
            if (r0 == (-1)) goto L7;
            this.b.b(r0);
            this.c = this.e;
            this.e = -1;
            return;
        L7:
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        }

        @Override // java.util.ListIterator
        public final void set(Object r3) {
            int r0 = this.e;
            if (r0 == (-1)) goto L7;
            this.b.set(r0, r3);
            return;
        L7:
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        }
    }

    public ListBuilder(Object[] r1, int r2, int r3, boolean r4, ListBuilder r5, ListBuilder r6) {
        this.b = r1;
        this.c = r2;
        this.e = r3;
        this.f = r4;
        this.i = r5;
        this.j = r6;
    }

    @Override // kotlin.collections.AbstractMutableList
    public final int a() {
        return this.e;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object r3) {
        e();
        d(this.c + this.e, r3);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection r4) {
        Intrinsics.f(r4, "elements");
        e();
        int r0 = r4.size();
        c(this.c + this.e, r4, r0);
        if (r0 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.collections.AbstractMutableList
    public final Object b(int r3) {
        e();
        AbstractList.Companion r0 = AbstractList.Companion;
        int r1 = this.e;
        r0.getClass();
        AbstractList.Companion.a(r3, r1);
        return g(this.c + r3);
    }

    public final void c(int r5, Collection r6, int r7) {
        ListBuilder r0 = this.i;
        if (r0 == null) goto L5;
        r0.c(r5, r6, r7);
        this.b = r0.b;
        this.e += r7;
        return;
    L5:
        f(r5, r7);
        Iterator<E> r8 = r6.iterator();
        int r1 = 0;
    L6:
        if (r1 >= r7) goto L10;
        this.b[r5 + r1] = r8.next();
        r1 = r1 + 1;
        goto L6
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        e();
        h(this.c, this.e);
    }

    public final void d(int r3, Object r4) {
        ListBuilder r1 = this.i;
        if (r1 == null) goto L5;
        r1.d(r3, r4);
        this.b = r1.b;
        this.e++;
        return;
    L5:
        f(r3, 1);
        this.b[r3] = r4;
    }

    public final void e() {
        if (this.f == true) goto L10;
        ListBuilder r1 = this.j;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.f == true) goto L10;
        return;
    L10:
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object r7) {
        if (r7 != this) goto L4;
    L14:
        return true;
    L4:
        if ((r7 instanceof List) == false) goto L18;
        List r8 = (List) r7;
        Object[] r0 = this.b;
        int r2 = this.e;
        if (r2 != r8.size()) goto L19;
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L14;
        if (Intrinsics.a(r0[this.c + r3], r8.get(r3)) == false) goto L20;
        r3 = r3 + 1;
        goto L9
    L20:
        return false;
    L19:
        return false;
    L18:
        return false;
    }

    public final void f(int r6, int r7) {
        int r0 = this.e + r7;
        if (this.i != null) goto L21;
        if (r0 < 0) goto L19;
        Object[] r1 = this.b;
        if (r0 <= r1.length) goto L16;
        int r2 = r1.length;
        int r3 = r2 + (r2 >> 1);
        if ((r3 - r0) >= 0) goto L11;
        r3 = r0;
    L11:
        if ((r3 - 2147483639) <= 0) goto L15;
        if (r0 <= 2147483639) goto L14;
        r3 = Integer.MAX_VALUE;
        goto L15
    L14:
        r3 = 2147483639;
    L15:
        Intrinsics.f(r1, "<this>");
        Object[] r4 = Arrays.copyOf(r1, r3);
        Intrinsics.e(r4, "copyOf(this, newSize)");
        this.b = r4;
    L16:
        Object[] r5 = this.b;
        ArraysKt.h(r5, r5, r6 + r7, r6, this.c + this.e);
        this.e += r7;
        return;
    L19:
        throw new OutOfMemoryError();
    L21:
        throw new IllegalStateException();
    }

    public final Object g(int r6) {
        ListBuilder r0 = this.i;
        if (r0 == null) goto L6;
        Object r7 = r0.g(r6);
        this.e--;
        return r7;
    L6:
        Object[] r1 = this.b;
        Object r2 = r1[r6];
        int r3 = this.e;
        int r4 = this.c;
        ArraysKt.h(r1, r1, r6, r6 + 1, r3 + r4);
        Object[] r8 = this.b;
        int r5 = (r4 + this.e) - 1;
        Intrinsics.f(r8, "<this>");
        r8[r5] = null;
        this.e--;
        return r2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int r3) {
        AbstractList.Companion r0 = AbstractList.Companion;
        int r1 = this.e;
        r0.getClass();
        AbstractList.Companion.a(r3, r1);
        return this.b[this.c + r3];
    }

    public final void h(int r4, int r5) {
        ListBuilder r0 = this.i;
        if (r0 == null) goto L5;
        r0.h(r4, r5);
    L6:
        this.e -= r5;
        return;
    L5:
        Object[] r1 = this.b;
        ArraysKt.h(r1, r1, r4, r4 + r5, this.e);
        Object[] r6 = this.b;
        int r2 = this.e;
        ListBuilderKt.a(r6, r2 - r5, r2);
        goto L6
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        Object[] r0 = this.b;
        int r1 = this.e;
        int r2 = 1;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L9;
        Object r5 = r0[this.c + r4];
        int r3 = r2 * 31;
        if (r5 == null) goto L7;
        int r6 = r5.hashCode();
    L8:
        r2 = r3 + r6;
        r4 = r4 + 1;
        goto L3
    L7:
        r6 = 0;
        goto L8
    L9:
        return r2;
    }

    public final int i(int r6, int r7, Collection r8, boolean r9) {
        ListBuilder r0 = this.i;
        if (r0 == null) goto L6;
        int r10 = r0.i(r6, r7, r8, r9);
        this.e -= r10;
        return r10;
    L6:
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= r7) goto L12;
        int r3 = r6 + r1;
        if (r8.contains(this.b[r3]) == r9) goto L10;
        r1 = r1 + 1;
        goto L7
    L10:
        Object[] r4 = this.b;
        r1 = r1 + 1;
        r4[r2 + r6] = r4[r3];
        r2 = r2 + 1;
        goto L7
    L12:
        int r11 = r7 - r2;
        Object[] r12 = this.b;
        ArraysKt.h(r12, r12, r6 + r2, r7 + r6, this.e);
        Object[] r13 = this.b;
        int r14 = this.e;
        ListBuilderKt.a(r13, r14 - r11, r14);
        this.e -= r11;
        return r11;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.e) goto L9;
        if (Intrinsics.a(this.b[this.c + r0], r4) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        if (this.e != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new Itr(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object r4) {
        int r0 = this.e - 1;
    L3:
        if (r0 < 0) goto L8;
        if (Intrinsics.a(this.b[this.c + r0], r4) == true) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return r0;
    L8:
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return new Itr(this, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object r1) {
        e();
        int r2 = indexOf(r1);
        if (r2 < 0) goto L5;
        b(r2);
    L5:
        if (r2 < 0) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection r4) {
        Intrinsics.f(r4, "elements");
        e();
        int r0 = this.e;
        if (i(this.c, r0, r4, false) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection r4) {
        Intrinsics.f(r4, "elements");
        e();
        int r0 = this.e;
        if (i(this.c, r0, r4, true) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int r3, Object r4) {
        e();
        AbstractList.Companion r0 = AbstractList.Companion;
        int r1 = this.e;
        r0.getClass();
        AbstractList.Companion.a(r3, r1);
        Object[] r2 = this.b;
        int r5 = this.c + r3;
        Object r6 = r2[r5];
        r2[r5] = r4;
        return r6;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int r10, int r11) {
        AbstractList.Companion r0 = AbstractList.Companion;
        int r1 = this.e;
        r0.getClass();
        AbstractList.Companion.c(r10, r11, r1);
        Object[] r3 = this.b;
        int r4 = this.c + r10;
        int r5 = r11 - r10;
        boolean r6 = this.f;
        ListBuilder<E> r12 = this.j;
        if (r12 != null) goto L5;
        ListBuilder<E> r8 = this;
    L7:
        return new ListBuilder(r3, r4, r5, r6, this, r8);
    L5:
        r8 = r12;
        goto L7
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] r5) {
        Intrinsics.f(r5, "destination");
        int r0 = r5.length;
        int r1 = this.e;
        int r2 = this.c;
        if (r0 >= r1) goto L6;
        Object[] r4 = Arrays.copyOfRange(this.b, r2, r1 + r2, r5.getClass());
        Intrinsics.e(r4, "copyOfRange(array, offse…h, destination.javaClass)");
        return r4;
    L6:
        Object[] r3 = this.b;
        Intrinsics.d(r3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.builders.ListBuilder.toArray>");
        ArraysKt.h(r3, r5, 0, r2, this.e + r2);
        int r6 = r5.length;
        int r7 = this.e;
        if (r6 <= r7) goto L9;
        r5[r7] = null;
    L9:
        return r5;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        Object[] r0 = this.b;
        int r1 = this.e;
        StringBuilder r2 = new StringBuilder((r1 * 3) + 2);
        r2.append("[");
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L7;
        if (r3 <= 0) goto L6;
        r2.append(", ");
    L6:
        r2.append(r0[this.c + r3]);
        r3 = r3 + 1;
        goto L3
    L7:
        r2.append("]");
        String r5 = r2.toString();
        Intrinsics.e(r5, "sb.toString()");
        return r5;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int r3) {
        AbstractList.Companion r0 = AbstractList.Companion;
        int r1 = this.e;
        r0.getClass();
        AbstractList.Companion.b(r3, r1);
        return new Itr(this, r3);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int r3, Object r4) {
        e();
        AbstractList.Companion r0 = AbstractList.Companion;
        int r1 = this.e;
        r0.getClass();
        AbstractList.Companion.b(r3, r1);
        d(this.c + r3, r4);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int r3, Collection r4) {
        Intrinsics.f(r4, "elements");
        e();
        AbstractList.Companion r0 = AbstractList.Companion;
        int r1 = this.e;
        r0.getClass();
        AbstractList.Companion.b(r3, r1);
        int r2 = r4.size();
        c(this.c + r3, r4, r2);
        if (r2 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        Object[] r0 = this.b;
        int r1 = this.e;
        int r2 = this.c;
        return ArraysKt.k(r0, r2, r1 + r2);
    }
}
