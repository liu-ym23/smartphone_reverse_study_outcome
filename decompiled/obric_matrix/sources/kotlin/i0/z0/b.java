package kotlin.i0.z0;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.i0.h;
import kotlin.i0.i;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0001VB\u0007\b\u0016¢\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bBM\b\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0002\u0010\u0014J\u0015\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u001d\u0010\u001b\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0016\u0010!\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J&\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010&\u001a\u00020\nH\u0002J\u001d\u0010'\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010 J\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000)J\b\u0010*\u001a\u00020\u001eH\u0002J\b\u0010+\u001a\u00020\u001eH\u0016J\u0014\u0010,\u001a\u00020\u00112\n\u0010-\u001a\u0006\u0012\u0002\b\u00030)H\u0002J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\nH\u0002J\u0010\u00100\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\nH\u0002J\u0013\u00101\u001a\u00020\u00112\b\u0010-\u001a\u0004\u0018\u000102H\u0096\u0002J\u0016\u00103\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\nH\u0096\u0002¢\u0006\u0002\u00104J\b\u00105\u001a\u00020\nH\u0016J\u0015\u00106\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00107J\u0018\u00108\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0002J\b\u00109\u001a\u00020\u0011H\u0016J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000;H\u0096\u0002J\u0015\u0010<\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00107J\u000e\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000>H\u0016J\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000>2\u0006\u0010\u001f\u001a\u00020\nH\u0016J\u0015\u0010?\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0016\u0010@\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0015\u0010A\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\nH\u0016¢\u0006\u0002\u00104J\u0015\u0010B\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\nH\u0002¢\u0006\u0002\u00104J\u0018\u0010C\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\nH\u0002J\u0016\u0010F\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J.\u0010G\u001a\u00020\n2\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010H\u001a\u00020\u0011H\u0002J\u001e\u0010I\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010JJ\u001e\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020\nH\u0016J\u0015\u0010N\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\rH\u0016¢\u0006\u0002\u0010OJ'\u0010N\u001a\b\u0012\u0004\u0012\u0002HP0\r\"\u0004\b\u0001\u0010P2\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002HP0\rH\u0016¢\u0006\u0002\u0010RJ\b\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u000202H\u0002R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006W"}, d2 = {"Lkotlin/collections/builders/ListBuilder;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "initialCapacity", "", "(I)V", "array", "", TypedValues.CycleType.S_WAVE_OFFSET, "length", "isReadOnly", "", "backing", "root", "([Ljava/lang/Object;IIZLkotlin/collections/builders/ListBuilder;Lkotlin/collections/builders/ListBuilder;)V", "[Ljava/lang/Object;", "isEffectivelyReadOnly", "()Z", "size", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "addAllInternal", "i", "n", "addAtInternal", "build", "", "checkIsMutable", "clear", "contentEquals", "other", "ensureCapacity", "minCapacity", "ensureExtraCapacity", "equals", "", "get", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "insertAtInternal", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainAll", "retainOrRemoveAllInternal", "retain", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "toArray", "()[Ljava/lang/Object;", "T", "destination", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "writeReplace", "Itr", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b<E> extends kotlin.i0.e<E> implements List<E>, RandomAccess, Serializable, kotlin.n0.d.l0.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private E[] f18366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f18367g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f18368h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f18369i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final b<E> f18370j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final b<E> f18371k;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ\t\u0010\r\u001a\u00020\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0010\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\r\u0010\u0013\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lkotlin/collections/builders/ListBuilder$Itr;", "E", "", "list", "Lkotlin/collections/builders/ListBuilder;", "index", "", "(Lkotlin/collections/builders/ListBuilder;I)V", "lastIndex", "add", "", "element", "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class a<E> implements ListIterator<E>, Object {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final b<E> f18372f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f18373g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f18374h;

        public a(b<E> r2, int r3) {
            o.f(r2, "list");
            this.f18372f = r2;
            this.f18373g = r3;
            this.f18374h = -1;
        }

        @Override // java.util.ListIterator
        public void add(E r4) {
            b<E> r0 = this.f18372f;
            int r1 = this.f18373g;
            this.f18373g = r1 + 1;
            r0.add(r1, r4);
            this.f18374h = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            if (this.f18373g >= b.b(this.f18372f)) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.f18373g <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            if (this.f18373g >= b.b(this.f18372f)) goto L7;
            int r0 = this.f18373g;
            this.f18373g = r0 + 1;
            this.f18374h = r0;
            return (E) b.a(this.f18372f)[b.c(this.f18372f) + this.f18374h];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f18373g;
        }

        @Override // java.util.ListIterator
        public E previous() {
            int r0 = this.f18373g;
            if (r0 <= 0) goto L7;
            int r1 = r0 - 1;
            this.f18373g = r1;
            this.f18374h = r1;
            return (E) b.a(this.f18372f)[b.c(this.f18372f) + this.f18374h];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f18373g - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int r0 = this.f18374h;
            if (r0 == (-1)) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L10;
            this.f18372f.remove(r0);
            this.f18373g = this.f18374h;
            this.f18374h = -1;
            return;
        L10:
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        L5:
            r2 = false;
            goto L6
        }

        @Override // java.util.ListIterator
        public void set(E r3) {
            int r0 = this.f18374h;
            if (r0 == (-1)) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L10;
            this.f18372f.set(r0, r3);
            return;
        L10:
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        L5:
            r1 = false;
            goto L6
        }
    }

    public b() {
        this(10);
    }

    public b(int r8) {
        this(c.d(r8), 0, 0, false, null, null);
    }

    private b(E[] r1, int r2, int r3, boolean r4, b<E> r5, b<E> r6) {
        this.f18366f = r1;
        this.f18367g = r2;
        this.f18368h = r3;
        this.f18369i = r4;
        this.f18370j = r5;
        this.f18371k = r6;
    }

    public static final /* synthetic */ Object[] a(b r0) {
        return r0.f18366f;
    }

    public static final /* synthetic */ int b(b r0) {
        return r0.f18368h;
    }

    public static final /* synthetic */ int c(b r0) {
        return r0.f18367g;
    }

    private final void g(int r5, Collection<? extends E> r6, int r7) {
        b<E> r0 = this.f18370j;
        if (r0 == null) goto L5;
        r0.g(r5, r6, r7);
        this.f18366f = this.f18370j.f18366f;
        this.f18368h += r7;
        return;
    L5:
        r(r5, r7);
        int r1 = 0;
        Iterator<? extends E> r8 = r6.iterator();
    L6:
        if (r1 >= r7) goto L10;
        this.f18366f[r5 + r1] = r8.next();
        r1 = r1 + 1;
        goto L6
    }

    private final void l(int r3, E r4) {
        b<E> r0 = this.f18370j;
        if (r0 == null) goto L5;
        r0.l(r3, r4);
        this.f18366f = this.f18370j.f18366f;
        this.f18368h++;
        return;
    L5:
        r(r3, 1);
        this.f18366f[r3] = r4;
    }

    private final void n() {
        if (s() == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    private final boolean o(List<?> r3) {
        return c.a(this.f18366f, this.f18367g, this.f18368h, r3);
    }

    private final void p(int r3) {
        if (this.f18370j != null) goto L12;
        if (r3 < 0) goto L10;
        E[] r0 = this.f18366f;
        if (r3 <= r0.length) goto L13;
        int r4 = h.f18347i.a(r0.length, r3);
        this.f18366f = (E[]) c.e(this.f18366f, r4);
        return;
    L13:
        return;
    L10:
        throw new OutOfMemoryError();
    L12:
        throw new IllegalStateException();
    }

    private final void q(int r2) {
        p(this.f18368h + r2);
    }

    private final void r(int r4, int r5) {
        q(r5);
        E[] r0 = this.f18366f;
        i.f(r0, r0, r4 + r5, r4, this.f18367g + this.f18368h);
        this.f18368h += r5;
    }

    private final boolean s() {
        if (this.f18369i == true) goto L10;
        b<E> r1 = this.f18371k;
        if (r1 != null) goto L7;
    L9:
        return false;
    L7:
        if (r1.f18369i == false) goto L9;
    L10:
        return true;
    }

    private final E t(int r6) {
        b<E> r0 = this.f18370j;
        if (r0 == null) goto L6;
        E r7 = r0.t(r6);
        this.f18368h--;
        return r7;
    L6:
        E[] r1 = this.f18366f;
        E r2 = r1[r6];
        i.f(r1, r1, r6, r6 + 1, this.f18367g + this.f18368h);
        c.f(this.f18366f, (this.f18367g + this.f18368h) - 1);
        this.f18368h--;
        return r2;
    }

    private final void u(int r4, int r5) {
        b<E> r0 = this.f18370j;
        if (r0 == null) goto L5;
        r0.u(r4, r5);
    L6:
        this.f18368h -= r5;
        return;
    L5:
        E[] r1 = this.f18366f;
        i.f(r1, r1, r4, r4 + r5, this.f18368h);
        E[] r6 = this.f18366f;
        int r2 = this.f18368h;
        c.g(r6, r2 - r5, r2);
        goto L6
    }

    private final int v(int r6, int r7, Collection<? extends E> r8, boolean r9) {
        b<E> r0 = this.f18370j;
        if (r0 == null) goto L6;
        int r10 = r0.v(r6, r7, r8, r9);
        this.f18368h -= r10;
        return r10;
    L6:
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= r7) goto L12;
        int r3 = r6 + r1;
        if (r8.contains(this.f18366f[r3]) == r9) goto L10;
        r1 = r1 + 1;
        goto L7
    L10:
        E[] r4 = this.f18366f;
        r1 = r1 + 1;
        r4[r2 + r6] = r4[r3];
        r2 = r2 + 1;
        goto L7
    L12:
        int r11 = r7 - r2;
        E[] r12 = this.f18366f;
        i.f(r12, r12, r6 + r2, r7 + r6, this.f18368h);
        E[] r13 = this.f18366f;
        int r14 = this.f18368h;
        c.g(r13, r14 - r11, r14);
        this.f18368h -= r11;
        return r11;
    }

    @Override // kotlin.i0.e, java.util.AbstractList, java.util.List
    public void add(int r3, E r4) {
        n();
        kotlin.i0.c.Companion.b(r3, this.f18368h);
        l(this.f18367g + r3, r4);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r3) {
        n();
        l(this.f18367g + this.f18368h, r3);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r3, Collection<? extends E> r4) {
        o.f(r4, "elements");
        n();
        kotlin.i0.c.Companion.b(r3, this.f18368h);
        int r0 = r4.size();
        g(this.f18367g + r3, r4, r0);
        if (r0 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> r4) {
        o.f(r4, "elements");
        n();
        int r0 = r4.size();
        g(this.f18367g + this.f18368h, r4, r0);
        if (r0 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        n();
        u(this.f18367g, this.f18368h);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r2) {
        if (r2 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r2 instanceof List) == true) goto L6;
    L8:
        return false;
    L6:
        if (o((List) r2) == false) goto L8;
        goto L8
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r3) {
        kotlin.i0.c.Companion.a(r3, this.f18368h);
        return this.f18366f[this.f18367g + r3];
    }

    @Override // kotlin.i0.e
    public int getSize() {
        return this.f18368h;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return c.b(this.f18366f, this.f18367g, this.f18368h);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.f18368h) goto L9;
        if (o.a(this.f18366f[this.f18367g + r0], r4) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        if (this.f18368h != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new a(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r4) {
        int r0 = this.f18368h - 1;
    L3:
        if (r0 < 0) goto L8;
        if (o.a(this.f18366f[this.f18367g + r0], r4) == true) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return r0;
    L8:
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return new a(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int r3) {
        kotlin.i0.c.Companion.b(r3, this.f18368h);
        return new a(this, r3);
    }

    public final List<E> m() {
        if (this.f18370j != null) goto L7;
        n();
        this.f18369i = true;
        return this;
    L7:
        throw new IllegalStateException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r1) {
        n();
        int r2 = indexOf(r1);
        if (r2 < 0) goto L5;
        remove(r2);
    L5:
        if (r2 < 0) goto L7;
        return true;
    L7:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> r4) {
        o.f(r4, "elements");
        n();
        if (v(this.f18367g, this.f18368h, r4, false) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // kotlin.i0.e
    public E removeAt(int r3) {
        n();
        kotlin.i0.c.Companion.a(r3, this.f18368h);
        return t(this.f18367g + r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> r4) {
        o.f(r4, "elements");
        n();
        if (v(this.f18367g, this.f18368h, r4, true) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // kotlin.i0.e, java.util.AbstractList, java.util.List
    public E set(int r3, E r4) {
        n();
        kotlin.i0.c.Companion.a(r3, this.f18368h);
        E[] r0 = this.f18366f;
        int r2 = this.f18367g;
        E r1 = r0[r2 + r3];
        r0[r2 + r3] = r4;
        return r1;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int r10, int r11) {
        kotlin.i0.c.Companion.c(r10, r11, this.f18368h);
        E[] r3 = this.f18366f;
        int r4 = this.f18367g + r10;
        int r5 = r11 - r10;
        boolean r6 = this.f18369i;
        b<E> r12 = this.f18371k;
        if (r12 != null) goto L5;
        b<E> r8 = this;
    L7:
        return new b(r3, r4, r5, r6, this, r8);
    L5:
        r8 = r12;
        goto L7
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        E[] r0 = this.f18366f;
        int r1 = this.f18367g;
        Object[] r2 = i.j(r0, r1, this.f18368h + r1);
        o.d(r2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        return r2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r5) {
        o.f(r5, "destination");
        int r0 = r5.length;
        int r1 = this.f18368h;
        if (r0 >= r1) goto L6;
        E[] r2 = this.f18366f;
        int r4 = this.f18367g;
        T[] r6 = (T[]) Arrays.copyOfRange(r2, r4, r1 + r4, r5.getClass());
        o.e(r6, "copyOfRange(array, offse…h, destination.javaClass)");
        return r6;
    L6:
        E[] r3 = this.f18366f;
        o.d(r3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.builders.ListBuilder.toArray>");
        int r7 = this.f18367g;
        i.f(r3, r5, 0, r7, this.f18368h + r7);
        int r8 = r5.length;
        int r9 = this.f18368h;
        if (r8 <= r9) goto L9;
        r5[r9] = null;
    L9:
        return r5;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return c.c(this.f18366f, this.f18367g, this.f18368h);
    }
}
