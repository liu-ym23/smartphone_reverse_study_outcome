package androidx.collection;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class ArraySet<E> implements Collection<E>, Set<E> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArraySet";
    private static Object[] sBaseCache;
    private static final Object sBaseCacheLock = null;
    private static int sBaseCacheSize;
    private static Object[] sTwiceBaseCache;
    private static final Object sTwiceBaseCacheLock = null;
    private static int sTwiceBaseCacheSize;
    Object[] mArray;
    private int[] mHashes;
    int mSize;

    private class ElementIterator extends IndexBasedArrayIterator<E> {
        final /* synthetic */ ArraySet this$0;

        ElementIterator(ArraySet r1) {
            this.this$0 = r1;
            super(r1.mSize);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        protected E elementAt(int r1) {
            return (E) this.this$0.valueAt(r1);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        protected void removeAt(int r1) {
            this.this$0.removeAt(r1);
        }
    }

    static {
        sBaseCacheLock = new Object();
        sTwiceBaseCacheLock = new Object();
    }

    private int binarySearch(int r2) {
        return ContainerHelpers.binarySearch(this.mHashes, this.mSize, r2);
    L5:
        throw new ConcurrentModificationException();
    }

    private int indexOf(Object r5, int r6) {
        int r0 = this.mSize;
        if (r0 != 0) goto L6;
        return -1;
    L6:
        int r1 = binarySearch(r6);
        if (r1 >= 0) goto L10;
        return r1;
    L10:
        if (r5.equals(this.mArray[r1]) == false) goto L12;
        return r1;
    L12:
        int r2 = r1 + 1;
    L13:
        if (r2 >= r0) goto L20;
        if (this.mHashes[r2] != r6) goto L20;
        if (r5.equals(this.mArray[r2]) == true) goto L18;
        r2 = r2 + 1;
        goto L13
    L18:
        return r2;
    L20:
        int r3 = r1 - 1;
    L21:
        if (r3 < 0) goto L29;
        if (this.mHashes[r3] != r6) goto L29;
        if (r5.equals(this.mArray[r3]) == true) goto L26;
        r3 = r3 - 1;
        goto L21
    L26:
        return r3;
    L29:
        return ~r2;
    }

    private int indexOfNull() {
        int r0 = this.mSize;
        if (r0 != 0) goto L6;
        return -1;
    L6:
        int r1 = binarySearch(0);
        if (r1 >= 0) goto L10;
        return r1;
    L10:
        if (this.mArray[r1] != null) goto L12;
        return r1;
    L12:
        int r2 = r1 + 1;
    L13:
        if (r2 >= r0) goto L20;
        if (this.mHashes[r2] != 0) goto L20;
        if (this.mArray[r2] == null) goto L18;
        r2 = r2 + 1;
        goto L13
    L18:
        return r2;
    L20:
        int r3 = r1 - 1;
    L21:
        if (r3 < 0) goto L29;
        if (this.mHashes[r3] != 0) goto L29;
        if (this.mArray[r3] == null) goto L26;
        r3 = r3 - 1;
        goto L21
    L26:
        return r3;
    L29:
        return ~r2;
    }

    private void allocArrays(int r9) {
        if (r9 != 8) goto L20;
        Object r2 = sTwiceBaseCacheLock;
        monitor-enter(r2);
        Object[] r0 = sTwiceBaseCache;     // Catch: Throwable -> L16
        if (r0 != null) goto L44;
    L14:
        monitor-exit(r2);     // Catch: Throwable -> L16
    L36:
        this.mHashes = new int[r9];
        this.mArray = new Object[r9];
        return;
    L44:
        this.mArray = r0;     // Catch: ClassCastException -> L38 Throwable -> L16
        sTwiceBaseCache = (Object[]) r0[0];     // Catch: ClassCastException -> L38 Throwable -> L16
        int[] r6 = (int[]) r0[1];     // Catch: ClassCastException -> L38 Throwable -> L16
        this.mHashes = r6;     // Catch: ClassCastException -> L38 Throwable -> L16
        if (r6 == null) goto L13;
        r0[1] = null;     // Catch: ClassCastException -> L38 Throwable -> L16
        r0[0] = null;     // Catch: ClassCastException -> L38 Throwable -> L16
        sTwiceBaseCacheSize--;     // Catch: ClassCastException -> L38 Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        return;
    L13:
        System.out.println("ArraySet Found corrupt ArraySet cache: [0]=" + r0[0] + " [1]=" + r0[1]);     // Catch: Throwable -> L16
        sTwiceBaseCache = null;     // Catch: Throwable -> L16
        sTwiceBaseCacheSize = 0;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L20:
        if (r9 != 4) goto L36;
        Object r1 = sBaseCacheLock;
        monitor-enter(r1);
        Object[] r3 = sBaseCache;     // Catch: Throwable -> L33
        if (r3 != null) goto L42;
    L31:
        monitor-exit(r1);     // Catch: Throwable -> L33
        goto L36
    L42:
        this.mArray = r3;     // Catch: ClassCastException -> L39 Throwable -> L33
        sBaseCache = (Object[]) r3[0];     // Catch: ClassCastException -> L39 Throwable -> L33
        int[] r7 = (int[]) r3[1];     // Catch: ClassCastException -> L39 Throwable -> L33
        this.mHashes = r7;     // Catch: ClassCastException -> L39 Throwable -> L33
        if (r7 == null) goto L30;
        r3[1] = null;     // Catch: ClassCastException -> L39 Throwable -> L33
        r3[0] = null;     // Catch: ClassCastException -> L39 Throwable -> L33
        sBaseCacheSize--;     // Catch: ClassCastException -> L39 Throwable -> L33
        monitor-exit(r1);     // Catch: Throwable -> L33
        return;
    L30:
        System.out.println("ArraySet Found corrupt ArraySet cache: [0]=" + r3[0] + " [1]=" + r3[1]);     // Catch: Throwable -> L33
        sBaseCache = null;     // Catch: Throwable -> L33
        sBaseCacheSize = 0;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    }

    private static void freeArrays(int[] r7, Object[] r8, int r9) {
        if (r7.length != 8) goto L18;
        Object r0 = sTwiceBaseCacheLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (sTwiceBaseCacheSize >= 10) goto L12;
        r8[0] = sTwiceBaseCache;     // Catch: Throwable -> L14
        r8[1] = r7;     // Catch: Throwable -> L14
        int r10 = r9 - 1;     // Catch: Throwable -> L14
    L9:
        if (r10 < 2) goto L11;
        r8[r10] = null;     // Catch: Throwable -> L14
        r10 = r10 - 1;     // Catch: Throwable -> L14
        goto L9
    L11:
        sTwiceBaseCache = r8;     // Catch: Throwable -> L14
        sTwiceBaseCacheSize++;     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L18:
        if (r7.length != 4) goto L39;
        Object r1 = sBaseCacheLock;
        monitor-enter(r1);
    L29:
        th = move-exception;
        throw th;
    L22:
        if (sBaseCacheSize >= 10) goto L27;
        r8[0] = sBaseCache;     // Catch: Throwable -> L29
        r8[1] = r7;     // Catch: Throwable -> L29
        int r11 = r9 - 1;     // Catch: Throwable -> L29
    L24:
        if (r11 < 2) goto L26;
        r8[r11] = null;     // Catch: Throwable -> L29
        r11 = r11 - 1;     // Catch: Throwable -> L29
        goto L24
    L26:
        sBaseCache = r8;     // Catch: Throwable -> L29
        sBaseCacheSize++;     // Catch: Throwable -> L29
    L27:
        monitor-exit(r1);     // Catch: Throwable -> L29
        return;
    }

    public ArraySet() {
        this(0);
    }

    public ArraySet(int r1) {
        if (r1 != 0) goto L5;
        this.mHashes = ContainerHelpers.EMPTY_INTS;
        this.mArray = ContainerHelpers.EMPTY_OBJECTS;
    L6:
        this.mSize = 0;
        return;
    L5:
        allocArrays(r1);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(ArraySet<E> r1) {
        this();
        if (r1 == 0) goto L6;
        addAll(r1);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(Collection<E> r1) {
        this();
        if (r1 == 0) goto L6;
        addAll(r1);
        return;
    }

    public ArraySet(E[] r4) {
        this();
        if (r4 == null) goto L7;
        int r0 = r4.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        add(r4[r1]);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int r0 = this.mSize;
        if (r0 == 0) goto L6;
        int[] r1 = this.mHashes;
        Object[] r2 = this.mArray;
        this.mHashes = ContainerHelpers.EMPTY_INTS;
        this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        this.mSize = 0;
        freeArrays(r1, r2, r0);
    L6:
        if (this.mSize != 0) goto L9;
        return;
    L9:
        throw new ConcurrentModificationException();
    }

    public void ensureCapacity(int r6) {
        int r0 = this.mSize;
        int[] r1 = this.mHashes;
        if (r1.length >= r6) goto L9;
        Object[] r2 = this.mArray;
        allocArrays(r6);
        int r7 = this.mSize;
        if (r7 <= 0) goto L7;
        System.arraycopy(r1, 0, this.mHashes, 0, r7);
        System.arraycopy(r2, 0, this.mArray, 0, this.mSize);
    L7:
        freeArrays(r1, r2, this.mSize);
    L9:
        if (this.mSize != r0) goto L12;
        return;
    L12:
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object r1) {
        if (indexOf(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int indexOf(Object r2) {
        if (r2 != null) goto L5;
        return indexOfNull();
    L5:
        return indexOf(r2, r2.hashCode());
    }

    public E valueAt(int r1) {
        return (E) this.mArray[r1];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        if (this.mSize > 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E r10) {
        int r0 = this.mSize;
        if (r10 != null) goto L5;
        int r2 = indexOfNull();
        int r3 = 0;
    L6:
        if (r2 < 0) goto L8;
        return false;
    L8:
        int r4 = ~r2;
        int[] r5 = this.mHashes;
        if (r0 < r5.length) goto L25;
        int r6 = 8;
        if (r0 < 8) goto L14;
        r6 = (r0 >> 1) + r0;
    L17:
        Object[] r7 = this.mArray;
        allocArrays(r6);
        if (r0 != this.mSize) goto L24;
        int[] r8 = this.mHashes;
        if (r8.length <= 0) goto L22;
        System.arraycopy(r5, 0, r8, 0, r5.length);
        System.arraycopy(r7, 0, this.mArray, 0, r7.length);
    L22:
        freeArrays(r5, r7, r0);
        goto L25
    L24:
        throw new ConcurrentModificationException();
    L14:
        if (r0 >= 4) goto L17;
        r6 = 4;
    L25:
        if (r4 >= r0) goto L27;
        int[] r1 = this.mHashes;
        int r9 = r4 + 1;
        int r11 = r0 - r4;
        System.arraycopy(r1, r4, r1, r9, r11);
        Object[] r12 = this.mArray;
        System.arraycopy(r12, r4, r12, r9, r11);
    L27:
        int r13 = this.mSize;
        if (r0 != r13) goto L34;
        int[] r14 = this.mHashes;
        if (r4 >= r14.length) goto L34;
        r14[r4] = r3;
        this.mArray[r4] = r10;
        this.mSize = r13 + 1;
        return true;
    L34:
        throw new ConcurrentModificationException();
    L5:
        int r15 = r10.hashCode();
        r3 = r15;
        r2 = indexOf(r10, r15);
        goto L6
    }

    public void addAll(ArraySet<? extends E> r5) {
        int r0 = r5.mSize;
        ensureCapacity(this.mSize + r0);
        int r2 = 0;
        if (this.mSize != 0) goto L10;
        if (r0 <= 0) goto L12;
        System.arraycopy(r5.mHashes, 0, this.mHashes, 0, r0);
        System.arraycopy(r5.mArray, 0, this.mArray, 0, r0);
        if (this.mSize != 0) goto L9;
        this.mSize = r0;
        return;
    L9:
        throw new ConcurrentModificationException();
    L12:
        return;
    L10:
        if (r2 >= r0) goto L15;
        add(r5.valueAt(r2));
        r2 = r2 + 1;
        goto L10
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object r1) {
        int r2 = indexOf(r1);
        if (r2 < 0) goto L6;
        removeAt(r2);
        return true;
    L6:
        return false;
    }

    public E removeAt(int r9) {
        int r0 = this.mSize;
        Object[] r1 = this.mArray;
        E r2 = (E) r1[r9];
        if (r0 > 1) goto L5;
        clear();
    L22:
        return r2;
    L5:
        int r3 = r0 - 1;
        int[] r4 = this.mHashes;
        int r6 = 8;
        if (r4.length > 8) goto L8;
    L16:
        if (r9 >= r3) goto L18;
        int r5 = r9 + 1;
        int r7 = r3 - r9;
        System.arraycopy(r4, r5, r4, r9, r7);
        Object[] r8 = this.mArray;
        System.arraycopy(r8, r5, r8, r9, r7);
    L18:
        this.mArray[r3] = null;
    L20:
        if (r0 != this.mSize) goto L24;
        this.mSize = r3;
        goto L22
    L24:
        throw new ConcurrentModificationException();
    L8:
        if (r0 >= (r4.length / 3)) goto L16;
        if (r0 <= 8) goto L11;
        r6 = r0 + (r0 >> 1);
    L11:
        allocArrays(r6);
        if (r9 <= 0) goto L14;
        System.arraycopy(r4, 0, this.mHashes, 0, r9);
        System.arraycopy(r1, 0, this.mArray, 0, r9);
    L14:
        if (r9 >= r3) goto L20;
        int r10 = r9 + 1;
        int r11 = r3 - r9;
        System.arraycopy(r4, r10, this.mHashes, r9, r11);
        System.arraycopy(r1, r10, this.mArray, r9, r11);
        goto L20
    }

    public boolean removeAll(ArraySet<? extends E> r6) {
        int r0 = r6.mSize;
        int r1 = this.mSize;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L6;
        remove(r6.valueAt(r3));
        r3 = r3 + 1;
        goto L3
    L6:
        if (r1 == this.mSize) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.mSize;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int r0 = this.mSize;
        Object[] r1 = new Object[r0];
        System.arraycopy(this.mArray, 0, r1, 0, r0);
        return r1;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] r4) {
        if (r4.length >= this.mSize) goto L5;
        r4 = (T[]) ((Object[]) Array.newInstance(r4.getClass().getComponentType(), this.mSize));
    L5:
        T[] r5 = r4;
        System.arraycopy(this.mArray, 0, r5, 0, this.mSize);
        int r0 = r4.length;
        int r3 = this.mSize;
        if (r0 <= r3) goto L8;
        r4[r3] = null;
    L8:
        return r4;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Set) == false) goto L18;
        Set r6 = (Set) r5;
        if (size() == r6.size()) goto L10;
        return false;
    L10:
        int r1 = 0;
    L20:
        if (r1 >= this.mSize) goto L17;
        if (r6.contains(valueAt(r1)) == false) goto L15;
        r1 = r1 + 1;
        goto L20
    L15:
        return false;
    L17:
        return true;
    L18:
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] r0 = this.mHashes;
        int r4 = this.mSize;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r4) goto L5;
        r2 = r2 + r0[r1];
        r1 = r1 + 1;
        goto L3
    L5:
        return r2;
    }

    public String toString() {
        if (isEmpty() == false) goto L6;
        return "{}";
    L6:
        StringBuilder r0 = new StringBuilder(this.mSize * 14);
        r0.append('{');
        int r1 = 0;
    L8:
        if (r1 >= this.mSize) goto L16;
        if (r1 <= 0) goto L11;
        r0.append(", ");
    L11:
        E r2 = valueAt(r1);
        if (r2 == this) goto L14;
        r0.append(r2);
    L15:
        r1 = r1 + 1;
        goto L8
    L14:
        r0.append("(this Set)");
        goto L15
    L16:
        r0.append('}');
        return r0.toString();
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new ElementIterator(this);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> r2) {
        Iterator<?> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (contains(r3.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> r3) {
        ensureCapacity(this.mSize + r3.size());
        Iterator<? extends E> r4 = r3.iterator();
        boolean r0 = false;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 | add(r4.next());
        goto L4
    L6:
        return r0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> r3) {
        Iterator<?> r4 = r3.iterator();
        boolean r0 = false;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 | remove(r4.next());
        goto L4
    L6:
        return r0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> r5) {
        int r0 = this.mSize - 1;
        boolean r2 = false;
    L3:
        if (r0 < 0) goto L8;
        if (r5.contains(this.mArray[r0]) == true) goto L7;
        removeAt(r0);
        r2 = true;
    L7:
        r0 = r0 - 1;
        goto L3
    L8:
        return r2;
    }
}
