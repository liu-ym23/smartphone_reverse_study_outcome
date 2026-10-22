package kotlin.s0.w.d.l0.p;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public class e<E> extends AbstractList<E> implements RandomAccess {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f21282f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object f21283g;

    static /* synthetic */ class a {
    }

    private static class b<T> implements Iterator<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final b f21284f = null;

        static {
            f21284f = new b();
        }

        private b() {
        }

        public static <T> b<T> b() {
            return f21284f;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }
    }

    private class c extends d<E> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f21285g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ e f21286h;

        public c(e r2) {
            this.f21286h = r2;
            super(null);
            this.f21285g = e.b(r2);
        }

        @Override // kotlin.s0.w.d.l0.p.e.d
        protected void b() {
            if (e.d(this.f21286h) != this.f21285g) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException("ModCount: " + e.g(this.f21286h) + "; expected: " + this.f21285g);
        }

        @Override // kotlin.s0.w.d.l0.p.e.d
        protected E c() {
            return (E) e.c(this.f21286h);
        }

        @Override // java.util.Iterator
        public void remove() {
            b();
            this.f21286h.clear();
        }
    }

    private static abstract class d<T> implements Iterator<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f21287f;

        private d() {
        }

        /* synthetic */ d(a r1) {
            this();
        }

        protected abstract void b();

        protected abstract T c();

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return !this.f21287f;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (this.f21287f == true) goto L7;
            this.f21287f = true;
            b();
            return c();
        L7:
            throw new NoSuchElementException();
        }
    }

    public e() {
    }

    private static /* synthetic */ void a(int r10) {
        if (r10 == 2) goto L9;
        if (r10 == 3) goto L9;
        if (r10 == 5) goto L9;
        if (r10 == 6) goto L9;
        if (r10 == 7) goto L9;
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L10:
        if (r10 == 2) goto L16;
        if (r10 == 3) goto L16;
        if (r10 == 5) goto L16;
        if (r10 == 6) goto L16;
        if (r10 == 7) goto L16;
        int r6 = 3;
    L17:
        Object[] r7 = new Object[r6];
        switch(r10) {
            case 2: goto L21;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L21;
            case 6: goto L21;
            case 7: goto L21;
            default: goto L19;
        };
    L19:
        r7[0] = "elements";
    L23:
        if (r10 == 2) goto L30;
        if (r10 == 3) goto L30;
        if (r10 == 5) goto L29;
        if (r10 == 6) goto L29;
        if (r10 == 7) goto L29;
        r7[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
    L31:
        switch(r10) {
            case 2: goto L34;
            case 3: goto L34;
            case 4: goto L33;
            case 5: goto L34;
            case 6: goto L34;
            case 7: goto L34;
            default: goto L32;
        };
    L32:
        r7[2] = "<init>";
        goto L34
    L33:
        r7[2] = "toArray";
    L34:
        String r8 = String.format(r5, r7);
        if (r10 == 2) goto L42;
        if (r10 == 3) goto L42;
        if (r10 == 5) goto L42;
        if (r10 == 6) goto L42;
        if (r10 == 7) goto L42;
        throw new IllegalArgumentException(r8);
    L42:
        throw new IllegalStateException(r8);
    L29:
        r7[1] = "toArray";
    L30:
        r7[1] = "iterator";
        goto L31
    L20:
        r7[0] = "a";
        goto L23
    L21:
        r7[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
    L16:
        r6 = 2;
    L9:
        r5 = "@NotNull method %s.%s must not return null";
        goto L10
    }

    static /* synthetic */ int b(e r0) {
        return ((AbstractList) r0).modCount;
    }

    static /* synthetic */ Object c(e r0) {
        return r0.f21283g;
    }

    static /* synthetic */ int d(e r0) {
        return ((AbstractList) r0).modCount;
    }

    static /* synthetic */ int g(e r0) {
        return ((AbstractList) r0).modCount;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int r6, E r7) {
        if (r6 < 0) goto L20;
        int r0 = this.f21282f;
        if (r6 > r0) goto L20;
        if (r0 != 0) goto L9;
        this.f21283g = r7;
    L17:
        this.f21282f++;
        ((AbstractList) this).modCount++;
        return;
    L9:
        if (r0 != 1) goto L12;
        if (r6 != 0) goto L12;
        this.f21283g = new Object[]{r7, this.f21283g};
    L12:
        Object[] r3 = new Object[r0 + 1];
        if (r0 != 1) goto L15;
        r3[0] = this.f21283g;
    L16:
        r3[r6] = r7;
        this.f21283g = r3;
        goto L17
    L15:
        Object[] r1 = (Object[]) this.f21283g;
        System.arraycopy(r1, 0, r3, 0, r6);
        System.arraycopy(r1, r6, r3, r6 + 1, this.f21282f - r6);
    L20:
        throw new IndexOutOfBoundsException("Index: " + r6 + ", Size: " + this.f21282f);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r8) {
        int r0 = this.f21282f;
        if (r0 != 0) goto L6;
        this.f21283g = r8;
    L15:
        this.f21282f++;
        ((AbstractList) this).modCount++;
        return true;
    L6:
        if (r0 != 1) goto L8;
        this.f21283g = new Object[]{this.f21283g, r8};
        goto L15
    L8:
        Object[] r4 = (Object[]) this.f21283g;
        int r5 = r4.length;
        if (r0 < r5) goto L14;
        int r6 = ((r5 * 3) / 2) + 1;
        int r1 = r0 + 1;
        if (r6 >= r1) goto L13;
        r6 = r1;
    L13:
        Object[] r2 = new Object[r6];
        this.f21283g = r2;
        System.arraycopy(r4, 0, r2, 0, r5);
        r4 = r2;
    L14:
        r4[this.f21282f] = r8;
        goto L15
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f21283g = null;
        this.f21282f = 0;
        ((AbstractList) this).modCount++;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractList, java.util.List
    public E get(int r4) {
        if (r4 < 0) goto L11;
        int r0 = this.f21282f;
        if (r4 >= r0) goto L11;
        E r3 = (E) this.f21283g;
        if (r0 != 1) goto L9;
        return r3;
    L9:
        return (E) ((Object[]) r3)[r4];
    L11:
        throw new IndexOutOfBoundsException("Index: " + r4 + ", Size: " + this.f21282f);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        int r0 = this.f21282f;
        if (r0 != 0) goto L10;
        b r3 = b.b();
        if (r3 == null) goto L7;
        return r3;
    L7:
        a(2);
        throw null;
    L10:
        if (r0 == 1) goto L12;
        Iterator<E> r4 = super.iterator();
        if (r4 == null) goto L16;
        return r4;
    L16:
        a(3);
        throw null;
    L12:
        return new c(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int r7) {
        if (r7 < 0) goto L19;
        int r0 = this.f21282f;
        if (r7 >= r0) goto L19;
        if (r0 != 1) goto L8;
        E r8 = (E) this.f21283g;
        this.f21283g = null;
    L16:
        this.f21282f--;
        ((AbstractList) this).modCount++;
        return r8;
    L8:
        Object[] r3 = (Object[]) this.f21283g;
        Object r4 = r3[r7];
        if (r0 != 2) goto L11;
        this.f21283g = r3[1 - r7];
    L15:
        r8 = (E) r4;
        goto L16
    L11:
        int r1 = (r0 - r7) - 1;
        if (r1 <= 0) goto L14;
        System.arraycopy(r3, r7 + 1, r3, r7, r1);
    L14:
        r3[this.f21282f - 1] = null;
    L19:
        throw new IndexOutOfBoundsException("Index: " + r7 + ", Size: " + this.f21282f);
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int r3, E r4) {
        if (r3 < 0) goto L11;
        int r0 = this.f21282f;
        if (r3 >= r0) goto L11;
        if (r0 != 1) goto L8;
        E r5 = (E) this.f21283g;
        this.f21283g = r4;
        return r5;
    L8:
        Object[] r2 = (Object[]) this.f21283g;
        E r1 = (E) r2[r3];
        r2[r3] = r4;
        return r1;
    L11:
        throw new IndexOutOfBoundsException("Index: " + r3 + ", Size: " + this.f21282f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f21282f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r6) {
        if (r6 == 0) goto L28;
        int r1 = r6.length;
        int r2 = this.f21282f;
        if (r2 != 1) goto L13;
        if (r1 == 0) goto L8;
        r6[0] = this.f21283g;
    L21:
        int r5 = this.f21282f;
        if (r1 <= r5) goto L24;
        r6[r5] = 0;
    L24:
        if (r6 == 0) goto L26;
        return r6;
    L26:
        a(7);
        throw null;
    L8:
        T[] r7 = (T[]) ((Object[]) Array.newInstance(r6.getClass().getComponentType(), 1));
        r7[0] = this.f21283g;
        if (r7 == 0) goto L11;
        return r7;
    L11:
        a(5);
        throw null;
    L13:
        if (r1 >= r2) goto L19;
        T[] r8 = (T[]) Arrays.copyOf((Object[]) this.f21283g, r2, r6.getClass());
        if (r8 == null) goto L17;
        return r8;
    L17:
        a(6);
        throw null;
    L19:
        if (r2 == 0) goto L21;
        System.arraycopy(this.f21283g, 0, r6, 0, r2);
        goto L21
    L28:
        a(4);
        throw null;
    }
}
