package kotlin.i0;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\b\b'\u0018\u0000 \u001c*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004\u001c\u001d\u001e\u001fB\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\u0016\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u0006H¦\u0002¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0096\u0002J\u0015\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0016R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006 "}, d2 = {"Lkotlin/collections/AbstractList;", "E", "Lkotlin/collections/AbstractCollection;", "", "()V", "size", "", "getSize", "()I", "equals", "", "other", "", "get", "index", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "element", "(Ljava/lang/Object;)I", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "Companion", "IteratorImpl", "ListIteratorImpl", "SubList", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class c<E> extends kotlin.i0.a<E> implements List<E>, kotlin.n0.d.l0.a {
    public static final a Companion = null;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\tJ\u001d\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\fJ\u001d\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u000eJ%\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0012J%\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00162\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0000¢\u0006\u0002\b\u0018J\u0019\u0010\u0019\u001a\u00020\u00062\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0000¢\u0006\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lkotlin/collections/AbstractList$Companion;", "", "()V", "checkBoundsIndexes", "", "startIndex", "", "endIndex", "size", "checkBoundsIndexes$kotlin_stdlib", "checkElementIndex", "index", "checkElementIndex$kotlin_stdlib", "checkPositionIndex", "checkPositionIndex$kotlin_stdlib", "checkRangeIndexes", "fromIndex", "toIndex", "checkRangeIndexes$kotlin_stdlib", "orderedEquals", "", "c", "", "other", "orderedEquals$kotlin_stdlib", "orderedHashCode", "orderedHashCode$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final void a(int r3, int r4) {
            if (r3 < 0) goto L6;
            if (r3 >= r4) goto L6;
            return;
        L6:
            throw new IndexOutOfBoundsException("index: " + r3 + ", size: " + r4);
        }

        public final void b(int r3, int r4) {
            if (r3 < 0) goto L6;
            if (r3 > r4) goto L6;
            return;
        L6:
            throw new IndexOutOfBoundsException("index: " + r3 + ", size: " + r4);
        }

        public final void c(int r3, int r4, int r5) {
            if (r3 < 0) goto L10;
            if (r4 > r5) goto L10;
            if (r3 > r4) goto L8;
            return;
        L8:
            throw new IllegalArgumentException("fromIndex: " + r3 + " > toIndex: " + r4);
        L10:
            throw new IndexOutOfBoundsException("fromIndex: " + r3 + ", toIndex: " + r4 + ", size: " + r5);
        }

        public final boolean d(Collection<?> r3, Collection<?> r4) {
            kotlin.n0.d.o.f(r3, "c");
            kotlin.n0.d.o.f(r4, "other");
            if (r3.size() == r4.size()) goto L5;
            return false;
        L5:
            Iterator<?> r2 = r4.iterator();
            Iterator<?> r5 = r3.iterator();
        L7:
            if (r5.hasNext() == false) goto L11;
            if (kotlin.n0.d.o.a(r5.next(), r2.next()) == true) goto L7;
            return false;
        L11:
            return true;
        }

        public final int e(Collection<?> r2) {
            kotlin.n0.d.o.f(r2, "c");
            Iterator<?> r1 = r2.iterator();
            int r3 = 1;
        L4:
            if (r1.hasNext() == false) goto L10;
            Object r0 = r1.next();
            int r4 = r3 * 31;
            if (r0 == null) goto L8;
            int r5 = r0.hashCode();
        L9:
            r3 = r4 + r5;
            goto L4
        L8:
            r5 = 0;
            goto L9
        L10:
            return r3;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0092\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u000e\u0010\u000b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lkotlin/collections/AbstractList$IteratorImpl;", "", "(Lkotlin/collections/AbstractList;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private class b implements Iterator<E>, kotlin.n0.d.l0.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f18333f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ c<E> f18334g;

        public b(c r1) {
            this.f18334g = r1;
        }

        protected final int b() {
            return this.f18333f;
        }

        protected final void c(int r1) {
            this.f18333f = r1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f18333f >= this.f18334g.size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext() == false) goto L7;
            c<E> r0 = this.f18334g;
            int r1 = this.f18333f;
            this.f18333f = r1 + 1;
            return r0.get(r1);
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: renamed from: kotlin.i0.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010*\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0092\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\r\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\r"}, d2 = {"Lkotlin/collections/AbstractList$ListIteratorImpl;", "Lkotlin/collections/AbstractList$IteratorImpl;", "Lkotlin/collections/AbstractList;", "", "index", "", "(Lkotlin/collections/AbstractList;I)V", "hasPrevious", "", "nextIndex", "previous", "()Ljava/lang/Object;", "previousIndex", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private class C0473c extends c<E>.b implements ListIterator<E>, kotlin.n0.d.l0.a {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ c<E> f18335h;

        public C0473c(c r2, int r3) {
            this.f18335h = r2;
            super(r2);
            c.Companion.b(r3, r2.size());
            c(r3);
        }

        @Override // java.util.ListIterator
        public void add(E r1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (b() <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return b();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (hasPrevious() == false) goto L7;
            c<E> r0 = this.f18335h;
            c(b() - 1);
            return r0.get(b());
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return b() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E r1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B#\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0016\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0002\u0010\u0010R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lkotlin/collections/AbstractList$SubList;", "E", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "list", "fromIndex", "", "toIndex", "(Lkotlin/collections/AbstractList;II)V", "_size", "size", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class d<E> extends c<E> implements RandomAccess {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final c<E> f18336f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f18337g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f18338h;

        /* JADX WARN: Multi-variable type inference failed */
        public d(c<? extends E> r2, int r3, int r4) {
            kotlin.n0.d.o.f(r2, "list");
            this.f18336f = r2;
            this.f18337g = r3;
            c.Companion.c(r3, r4, r2.size());
            this.f18338h = r4 - r3;
        }

        @Override // kotlin.i0.c, java.util.List
        public E get(int r3) {
            c.Companion.a(r3, this.f18338h);
            return this.f18336f.get(this.f18337g + r3);
        }

        @Override // kotlin.i0.c, kotlin.i0.a
        public int getSize() {
            return this.f18338h;
        }
    }

    static {
        Companion = new a(null);
    }

    protected c() {
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
    public boolean equals(Object r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if ((r2 instanceof List) == true) goto L10;
        return false;
    L10:
        return Companion.d(this, (Collection) r2);
    }

    public abstract E get(int r1);

    @Override // kotlin.i0.a
    public abstract int getSize();

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return Companion.e(this);
    }

    @Override // java.util.List
    public int indexOf(E r3) {
        Iterator<E> r2 = iterator();
        int r0 = 0;
    L4:
        if (r2.hasNext() == false) goto L9;
        if (kotlin.n0.d.o.a(r2.next(), r3) == true) goto L13;
        r0 = r0 + 1;
        goto L4
    L13:
        return r0;
    L9:
        return -1;
    }

    @Override // kotlin.i0.a, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new b(this);
    }

    @Override // java.util.List
    public int lastIndexOf(E r2) {
        ListIterator<E> r1 = listIterator(size());
    L4:
        if (r1.hasPrevious() == false) goto L8;
        if (kotlin.n0.d.o.a(r1.previous(), r2) == false) goto L4;
        return r1.nextIndex();
    L8:
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new C0473c(this, 0);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int r2) {
        return new C0473c(this, r2);
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
    public List<E> subList(int r2, int r3) {
        return new d(this, r2, r3);
    }
}
