package kotlin.collections;

import a.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E>, KMappedMarker {

    @NotNull
    public static final Companion Companion = null;

    @Metadata
    public static final class Companion {
        public static void a(int r3, int r4) {
            if (r3 < 0) goto L6;
            if (r3 >= r4) goto L6;
            return;
        L6:
            throw new IndexOutOfBoundsException("index: " + r3 + ", size: " + r4);
        }

        public static void b(int r3, int r4) {
            if (r3 < 0) goto L6;
            if (r3 > r4) goto L6;
            return;
        L6:
            throw new IndexOutOfBoundsException("index: " + r3 + ", size: " + r4);
        }

        public static void c(int r4, int r5, int r6) {
            if (r4 < 0) goto L9;
            if (r5 > r6) goto L9;
            if (r4 > r5) goto L8;
            return;
        L8:
            throw new IllegalArgumentException("fromIndex: " + r4 + " > toIndex: " + r5);
        L9:
            StringBuilder r7 = a.r("fromIndex: ", r4, ", toIndex: ", r5, ", size: ");
            r7.append(r6);
            throw new IndexOutOfBoundsException(r7.toString());
        }
    }

    @Metadata
    public class IteratorImpl implements Iterator<E>, KMappedMarker {
        public int b;
        public final /* synthetic */ AbstractList c;

        public IteratorImpl(AbstractList r1) {
            this.c = r1;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.b >= this.c.size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (hasNext() == false) goto L7;
            int r0 = this.b;
            this.b = r0 + 1;
            return this.c.get(r0);
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Metadata
    public class ListIteratorImpl extends AbstractList<E>.IteratorImpl implements ListIterator<E>, KMappedMarker {
        public final /* synthetic */ AbstractList e;

        public ListIteratorImpl(AbstractList r2, int r3) {
            this.e = r2;
            super(r2);
            Companion r0 = AbstractList.Companion;
            int r4 = r2.size();
            r0.getClass();
            Companion.b(r3, r4);
            this.b = r3;
        }

        @Override // java.util.ListIterator
        public final void add(Object r1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            if (this.b <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.b;
        }

        @Override // java.util.ListIterator
        public final Object previous() {
            if (hasPrevious() == false) goto L7;
            int r0 = this.b - 1;
            this.b = r0;
            return this.e.get(r0);
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.b - 1;
        }

        @Override // java.util.ListIterator
        public final void set(Object r1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Metadata
    public static final class SubList<E> extends AbstractList<E> implements RandomAccess {
        public final AbstractList b;
        public final int c;
        public final int e;

        public SubList(AbstractList r2, int r3, int r4) {
            Intrinsics.f(r2, "list");
            this.b = r2;
            this.c = r3;
            Companion r0 = AbstractList.Companion;
            int r5 = r2.size();
            r0.getClass();
            Companion.c(r3, r4, r5);
            this.e = r4 - r3;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final Object get(int r3) {
            Companion r0 = AbstractList.Companion;
            int r1 = this.e;
            r0.getClass();
            Companion.a(r3, r1);
            int r2 = this.c + r3;
            return this.b.get(r2);
        }

        @Override // kotlin.collections.AbstractCollection
        public final int getSize() {
            return this.e;
        }
    }

    static {
        Companion = new Companion();
    }

    @Override // java.util.List
    public void add(int r1, E r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int r1, Collection<? extends E> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@Nullable Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof List) == true) goto L8;
        return false;
    L8:
        Collection r6 = (Collection) r5;
        Companion.getClass();
        Intrinsics.f(r6, "other");
        if (size() != r6.size()) goto L17;
        Iterator<E> r7 = r6.iterator();
        Iterator<E> r4 = iterator();
    L13:
        if (r4.hasNext() == false) goto L21;
        if (Intrinsics.a(r4.next(), r7.next()) == true) goto L13;
    L21:
        return true;
    L17:
        return false;
    }

    @Override // java.util.List
    public abstract Object get(int r1);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        Companion.getClass();
        Iterator<E> r2 = iterator();
        int r0 = 1;
    L4:
        if (r2.hasNext() == false) goto L10;
        E r1 = r2.next();
        int r3 = r0 * 31;
        if (r1 == null) goto L8;
        int r4 = r1.hashCode();
    L9:
        r0 = r3 + r4;
        goto L4
    L8:
        r4 = 0;
        goto L9
    L10:
        return r0;
    }

    @Override // java.util.List
    public int indexOf(Object r3) {
        Iterator<E> r2 = iterator();
        int r0 = 0;
    L4:
        if (r2.hasNext() == false) goto L9;
        if (Intrinsics.a(r2.next(), r3) == true) goto L13;
        r0 = r0 + 1;
        goto L4
    L13:
        return r0;
    L9:
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<E> iterator() {
        return new IteratorImpl(this);
    }

    @Override // java.util.List
    public int lastIndexOf(Object r2) {
        ListIterator<E> r1 = listIterator(size());
    L4:
        if (r1.hasPrevious() == false) goto L8;
        if (Intrinsics.a(r1.previous(), r2) == false) goto L4;
        return r1.nextIndex();
    L8:
        return -1;
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<E> listIterator() {
        return new ListIteratorImpl(this, 0);
    }

    @Override // java.util.List
    public E remove(int r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int r1, E r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    @NotNull
    public List<E> subList(int r2, int r3) {
        return new SubList(this, r2, r3);
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<E> listIterator(int r2) {
        return new ListIteratorImpl(this, r2);
    }
}
