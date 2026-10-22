package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class ArraySet<E> implements Collection<E>, Set<E> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean DEBUG = false;
    private static final int[] INT = null;
    private static final Object[] OBJECT = null;
    private static final String TAG = "ArraySet";

    @Nullable
    private static Object[] sBaseCache;
    private static int sBaseCacheSize;

    @Nullable
    private static Object[] sTwiceBaseCache;
    private static int sTwiceBaseCacheSize;
    Object[] mArray;
    private MapCollections<E, E> mCollections;
    private int[] mHashes;
    int mSize;

    static {
        INT = new int[0];
        OBJECT = new Object[0];
    }

    public ArraySet() {
        this(0);
    }

    private void allocArrays(int r6) {
        if (r6 != 8) goto L18;
        monitor-enter(ArraySet.class);
        Object[] r4 = sTwiceBaseCache;     // Catch: Throwable -> L11
        if (r4 == null) goto L13;
        this.mArray = r4;     // Catch: Throwable -> L11
        sTwiceBaseCache = (Object[]) r4[0];     // Catch: Throwable -> L11
        this.mHashes = (int[]) r4[1];     // Catch: Throwable -> L11
        r4[1] = null;     // Catch: Throwable -> L11
        r4[0] = null;     // Catch: Throwable -> L11
        sTwiceBaseCacheSize--;     // Catch: Throwable -> L11
        monitor-exit(ArraySet.class);     // Catch: Throwable -> L11
        return;
    L13:
        monitor-exit(ArraySet.class);     // Catch: Throwable -> L11
    L32:
        this.mHashes = new int[r6];
        this.mArray = new Object[r6];
        return;
    L11:
        th = move-exception;
        throw th;
    L18:
        if (r6 != 4) goto L32;
        monitor-enter(ArraySet.class);
        Object[] r5 = sBaseCache;     // Catch: Throwable -> L26
        if (r5 == null) goto L28;
        this.mArray = r5;     // Catch: Throwable -> L26
        sBaseCache = (Object[]) r5[0];     // Catch: Throwable -> L26
        this.mHashes = (int[]) r5[1];     // Catch: Throwable -> L26
        r5[1] = null;     // Catch: Throwable -> L26
        r5[0] = null;     // Catch: Throwable -> L26
        sBaseCacheSize--;     // Catch: Throwable -> L26
        monitor-exit(ArraySet.class);     // Catch: Throwable -> L26
        return;
    L28:
        monitor-exit(ArraySet.class);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    private static void freeArrays(int[] r7, Object[] r8, int r9) {
        if (r7.length != 8) goto L19;
        monitor-enter(ArraySet.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sTwiceBaseCacheSize >= 10) goto L14;
        r8[0] = sTwiceBaseCache;     // Catch: Throwable -> L11
        r8[1] = r7;     // Catch: Throwable -> L11
        int r10 = r9 - 1;     // Catch: Throwable -> L11
    L9:
        if (r10 < 2) goto L13;
        r8[r10] = null;     // Catch: Throwable -> L11
        r10 = r10 - 1;     // Catch: Throwable -> L11
        goto L9
    L13:
        sTwiceBaseCache = r8;     // Catch: Throwable -> L11
        sTwiceBaseCacheSize++;     // Catch: Throwable -> L11
    L14:
        monitor-exit(ArraySet.class);     // Catch: Throwable -> L11
        return;
    L19:
        if (r7.length == 4) goto L21;
        return;
    L21:
        monitor-enter(ArraySet.class);
    L27:
        th = move-exception;
        throw th;
    L23:
        if (sBaseCacheSize >= 10) goto L30;
        r8[0] = sBaseCache;     // Catch: Throwable -> L27
        r8[1] = r7;     // Catch: Throwable -> L27
        int r11 = r9 - 1;     // Catch: Throwable -> L27
    L25:
        if (r11 < 2) goto L29;
        r8[r11] = null;     // Catch: Throwable -> L27
        r11 = r11 - 1;     // Catch: Throwable -> L27
        goto L25
    L29:
        sBaseCache = r8;     // Catch: Throwable -> L27
        sBaseCacheSize++;     // Catch: Throwable -> L27
    L30:
        monitor-exit(ArraySet.class);     // Catch: Throwable -> L27
    }

    private MapCollections<E, E> getCollection() {
        if (this.mCollections != null) goto L6;
        this.mCollections = new AnonymousClass1(this);
    L6:
        return this.mCollections;
    }

    private int indexOf(Object r5, int r6) {
        int r0 = this.mSize;
        if (r0 != 0) goto L6;
        return -1;
    L6:
        int r1 = ContainerHelpers.binarySearch(this.mHashes, r0, r6);
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
        int r1 = ContainerHelpers.binarySearch(this.mHashes, r0, 0);
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

    @Override // java.util.Collection, java.util.Set
    public boolean add(@Nullable E r9) {
        if (r9 != null) goto L5;
        int r1 = indexOfNull();
        int r2 = 0;
    L6:
        if (r1 < 0) goto L8;
        return false;
    L8:
        int r3 = ~r1;
        int r4 = this.mSize;
        int[] r5 = this.mHashes;
        if (r4 < r5.length) goto L21;
        int r6 = 8;
        if (r4 < 8) goto L14;
        r6 = (r4 >> 1) + r4;
    L17:
        Object[] r7 = this.mArray;
        allocArrays(r6);
        int[] r8 = this.mHashes;
        if (r8.length <= 0) goto L20;
        System.arraycopy(r5, 0, r8, 0, r5.length);
        System.arraycopy(r7, 0, this.mArray, 0, r7.length);
    L20:
        freeArrays(r5, r7, this.mSize);
        goto L21
    L14:
        if (r4 >= 4) goto L17;
        r6 = 4;
    L21:
        int r0 = this.mSize;
        if (r3 >= r0) goto L24;
        int[] r10 = this.mHashes;
        int r11 = r3 + 1;
        System.arraycopy(r10, r3, r10, r11, r0 - r3);
        Object[] r12 = this.mArray;
        System.arraycopy(r12, r3, r12, r11, this.mSize - r3);
    L24:
        this.mHashes[r3] = r2;
        this.mArray[r3] = r9;
        this.mSize++;
        return true;
    L5:
        int r13 = r9.hashCode();
        r2 = r13;
        r1 = indexOf(r9, r13);
        goto L6
    }

    public void addAll(@NonNull ArraySet<? extends E> r5) {
        int r0 = r5.mSize;
        ensureCapacity(this.mSize + r0);
        int r2 = 0;
        if (this.mSize != 0) goto L6;
        if (r0 <= 0) goto L8;
        System.arraycopy(r5.mHashes, 0, this.mHashes, 0, r0);
        System.arraycopy(r5.mArray, 0, this.mArray, 0, r0);
        this.mSize = r0;
        return;
    L8:
        return;
    L6:
        if (r2 >= r0) goto L11;
        add(r5.valueAt(r2));
        r2 = r2 + 1;
        goto L6
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int r0 = this.mSize;
        if (r0 == 0) goto L6;
        freeArrays(this.mHashes, this.mArray, r0);
        this.mHashes = INT;
        this.mArray = OBJECT;
        this.mSize = 0;
        return;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(@Nullable Object r1) {
        if (indexOf(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(@NonNull Collection<?> r2) {
        Iterator<?> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (contains(r3.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public void ensureCapacity(int r5) {
        int[] r0 = this.mHashes;
        if (r0.length >= r5) goto L9;
        Object[] r1 = this.mArray;
        allocArrays(r5);
        int r6 = this.mSize;
        if (r6 <= 0) goto L7;
        System.arraycopy(r0, 0, this.mHashes, 0, r6);
        System.arraycopy(r1, 0, this.mArray, 0, this.mSize);
    L7:
        freeArrays(r0, r1, this.mSize);
        return;
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

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        if (this.mSize > 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return getCollection().getKeySet().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(@Nullable Object r1) {
        int r2 = indexOf(r1);
        if (r2 < 0) goto L6;
        removeAt(r2);
        return true;
    L6:
        return false;
    }

    public boolean removeAll(@NonNull ArraySet<? extends E> r6) {
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

    public E removeAt(int r9) {
        Object[] r0 = this.mArray;
        E r1 = (E) r0[r9];
        int r2 = this.mSize;
        if (r2 > 1) goto L5;
        freeArrays(this.mHashes, r0, r2);
        this.mHashes = INT;
        this.mArray = OBJECT;
        this.mSize = 0;
    L21:
        return r1;
    L5:
        int[] r5 = this.mHashes;
        int r7 = 8;
        if (r5.length > 8) goto L8;
    L17:
        int r3 = r2 - 1;
        this.mSize = r3;
        if (r9 >= r3) goto L20;
        int r4 = r9 + 1;
        System.arraycopy(r5, r4, r5, r9, r3 - r9);
        Object[] r6 = this.mArray;
        System.arraycopy(r6, r4, r6, r9, this.mSize - r9);
    L20:
        this.mArray[this.mSize] = null;
        goto L21
    L8:
        if (r2 >= (r5.length / 3)) goto L17;
        if (r2 <= 8) goto L11;
        r7 = r2 + (r2 >> 1);
    L11:
        allocArrays(r7);
        this.mSize--;
        if (r9 <= 0) goto L14;
        System.arraycopy(r5, 0, this.mHashes, 0, r9);
        System.arraycopy(r0, 0, this.mArray, 0, r9);
    L14:
        int r8 = this.mSize;
        if (r9 >= r8) goto L21;
        int r10 = r9 + 1;
        System.arraycopy(r5, r10, this.mHashes, r9, r8 - r9);
        System.arraycopy(r0, r10, this.mArray, r9, this.mSize - r9);
        goto L21
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(@NonNull Collection<?> r5) {
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

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.mSize;
    }

    @Override // java.util.Collection, java.util.Set
    @NonNull
    public Object[] toArray() {
        int r0 = this.mSize;
        Object[] r1 = new Object[r0];
        System.arraycopy(this.mArray, 0, r1, 0, r0);
        return r1;
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

    @Nullable
    public E valueAt(int r1) {
        return (E) this.mArray[r1];
    }

    public ArraySet(int r1) {
        if (r1 != 0) goto L5;
        this.mHashes = INT;
        this.mArray = OBJECT;
    L6:
        this.mSize = 0;
        return;
    L5:
        allocArrays(r1);
        goto L6
    }

    @Override // java.util.Collection, java.util.Set
    @NonNull
    public <T> T[] toArray(@NonNull T[] r4) {
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
    public boolean removeAll(@NonNull Collection<?> r3) {
        Iterator<?> r4 = r3.iterator();
        boolean r0 = false;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 | remove(r4.next());
        goto L4
    L6:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(@Nullable ArraySet<E> r1) {
        this();
        if (r1 == 0) goto L6;
        addAll(r1);
        return;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(@NonNull Collection<? extends E> r3) {
        int r0 = this.mSize;
        ensureCapacity(r3.size() + r0);
        Iterator<? extends E> r4 = r3.iterator();
        boolean r1 = false;
    L4:
        if (r4.hasNext() == false) goto L6;
        r1 = r1 | add(r4.next());
        goto L4
    L6:
        return r1;
    }

    public int indexOf(@Nullable Object r2) {
        if (r2 != null) goto L5;
        return indexOfNull();
    L5:
        return indexOf(r2, r2.hashCode());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(@Nullable Collection<E> r1) {
        this();
        if (r1 == 0) goto L6;
        addAll(r1);
        return;
    }
}
