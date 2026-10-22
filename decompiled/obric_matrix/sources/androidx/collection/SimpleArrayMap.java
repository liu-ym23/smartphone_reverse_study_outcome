package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SimpleArrayMap<K, V> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean CONCURRENT_MODIFICATION_EXCEPTIONS = true;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArrayMap";

    @Nullable
    static Object[] mBaseCache;
    static int mBaseCacheSize;

    @Nullable
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;
    Object[] mArray;
    int[] mHashes;
    int mSize;

    public SimpleArrayMap() {
        this.mHashes = ContainerHelpers.EMPTY_INTS;
        this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        this.mSize = 0;
    }

    public SimpleArrayMap(int r1) {
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
    public SimpleArrayMap(SimpleArrayMap<K, V> r1) {
        this();
        if (r1 == 0) goto L6;
        putAll(r1);
        return;
    }

    private void allocArrays(int r6) {
        if (r6 != 8) goto L16;
        monitor-enter(SimpleArrayMap.class);
        Object[] r4 = mTwiceBaseCache;     // Catch: Throwable -> L12
        if (r4 == null) goto L10;
        this.mArray = r4;     // Catch: Throwable -> L12
        mTwiceBaseCache = (Object[]) r4[0];     // Catch: Throwable -> L12
        this.mHashes = (int[]) r4[1];     // Catch: Throwable -> L12
        r4[1] = null;     // Catch: Throwable -> L12
        r4[0] = null;     // Catch: Throwable -> L12
        mTwiceBaseCacheSize--;     // Catch: Throwable -> L12
        monitor-exit(SimpleArrayMap.class);     // Catch: Throwable -> L12
        return;
    L10:
        monitor-exit(SimpleArrayMap.class);     // Catch: Throwable -> L12
    L28:
        this.mHashes = new int[r6];
        this.mArray = new Object[r6 << 1];
        return;
    L12:
        th = move-exception;
        throw th;
    L16:
        if (r6 != 4) goto L28;
        monitor-enter(SimpleArrayMap.class);
        Object[] r5 = mBaseCache;     // Catch: Throwable -> L25
        if (r5 == null) goto L23;
        this.mArray = r5;     // Catch: Throwable -> L25
        mBaseCache = (Object[]) r5[0];     // Catch: Throwable -> L25
        this.mHashes = (int[]) r5[1];     // Catch: Throwable -> L25
        r5[1] = null;     // Catch: Throwable -> L25
        r5[0] = null;     // Catch: Throwable -> L25
        mBaseCacheSize--;     // Catch: Throwable -> L25
        monitor-exit(SimpleArrayMap.class);     // Catch: Throwable -> L25
        return;
    L23:
        monitor-exit(SimpleArrayMap.class);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    private static int binarySearchHashes(int[] r0, int r1, int r2) {
        return ContainerHelpers.binarySearch(r0, r1, r2);
    L5:
        throw new ConcurrentModificationException();
    }

    private static void freeArrays(int[] r8, Object[] r9, int r10) {
        if (r8.length != 8) goto L17;
        monitor-enter(SimpleArrayMap.class);
    L13:
        th = move-exception;
        throw th;
    L6:
        if (mTwiceBaseCacheSize >= 10) goto L11;
        r9[0] = mTwiceBaseCache;     // Catch: Throwable -> L13
        r9[1] = r8;     // Catch: Throwable -> L13
        int r11 = (r10 << 1) - 1;     // Catch: Throwable -> L13
    L8:
        if (r11 < 2) goto L10;
        r9[r11] = null;     // Catch: Throwable -> L13
        r11 = r11 - 1;     // Catch: Throwable -> L13
        goto L8
    L10:
        mTwiceBaseCache = r9;     // Catch: Throwable -> L13
        mTwiceBaseCacheSize++;     // Catch: Throwable -> L13
    L11:
        monitor-exit(SimpleArrayMap.class);     // Catch: Throwable -> L13
        return;
    L17:
        if (r8.length != 4) goto L37;
        monitor-enter(SimpleArrayMap.class);
    L27:
        th = move-exception;
        throw th;
    L20:
        if (mBaseCacheSize >= 10) goto L25;
        r9[0] = mBaseCache;     // Catch: Throwable -> L27
        r9[1] = r8;     // Catch: Throwable -> L27
        int r12 = (r10 << 1) - 1;     // Catch: Throwable -> L27
    L22:
        if (r12 < 2) goto L24;
        r9[r12] = null;     // Catch: Throwable -> L27
        r12 = r12 - 1;     // Catch: Throwable -> L27
        goto L22
    L24:
        mBaseCache = r9;     // Catch: Throwable -> L27
        mBaseCacheSize++;     // Catch: Throwable -> L27
    L25:
        monitor-exit(SimpleArrayMap.class);     // Catch: Throwable -> L27
        return;
    }

    public void clear() {
        int r0 = this.mSize;
        if (r0 <= 0) goto L6;
        int[] r1 = this.mHashes;
        Object[] r2 = this.mArray;
        this.mHashes = ContainerHelpers.EMPTY_INTS;
        this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        this.mSize = 0;
        freeArrays(r1, r2, r0);
    L6:
        if (this.mSize > 0) goto L9;
        return;
    L9:
        throw new ConcurrentModificationException();
    }

    public boolean containsKey(@Nullable Object r1) {
        if (indexOfKey(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean containsValue(Object r1) {
        if (indexOfValue(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void ensureCapacity(int r6) {
        int r0 = this.mSize;
        int[] r1 = this.mHashes;
        if (r1.length >= r6) goto L9;
        Object[] r2 = this.mArray;
        allocArrays(r6);
        if (this.mSize <= 0) goto L7;
        System.arraycopy(r1, 0, this.mHashes, 0, r0);
        System.arraycopy(r2, 0, this.mArray, 0, r0 << 1);
    L7:
        freeArrays(r1, r2, r0);
    L9:
        if (this.mSize != r0) goto L12;
        return;
    L12:
        throw new ConcurrentModificationException();
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if ((r7 instanceof SimpleArrayMap) == false) goto L26;
        SimpleArrayMap r8 = (SimpleArrayMap) r7;
        if (size() == r8.size()) goto L10;
        return false;
    L10:
        int r1 = 0;
    L48:
        if (r1 >= this.mSize) goto L23;
        K r3 = keyAt(r1);     // Catch: Throwable -> L24
        V r4 = valueAt(r1);     // Catch: Throwable -> L24
        Object r5 = r8.get(r3);     // Catch: Throwable -> L24
        if (r4 != null) goto L20;
        if (r5 != null) goto L18;
        if (r8.containsKey(r3) == false) goto L18;
    L22:
        r1 = r1 + 1;
    L18:
        return false;
    L20:
        if (r4.equals(r5) == true) goto L22;
        return false;
    L23:
        return true;
    L24:
        return false;
    L26:
        if ((r7 instanceof Map) == false) goto L44;
        Map r9 = (Map) r7;
        if (size() == r9.size()) goto L30;
        return false;
    L30:
        int r2 = 0;
    L46:
        if (r2 >= this.mSize) goto L43;
        K r6 = keyAt(r2);     // Catch: Throwable -> L45
        V r10 = valueAt(r2);     // Catch: Throwable -> L45
        Object r11 = r9.get(r6);     // Catch: Throwable -> L45
        if (r10 != null) goto L40;
        if (r11 != null) goto L38;
        if (r9.containsKey(r6) == false) goto L38;
    L42:
        r2 = r2 + 1;
    L38:
        return false;
    L40:
        if (r10.equals(r11) == true) goto L42;
        return false;
    L43:
        return true;
    L44:
        return false;
    }

    @Nullable
    public V get(Object r2) {
        return getOrDefault(r2, null);
    }

    public V getOrDefault(Object r1, V r2) {
        int r3 = indexOfKey(r1);
        if (r3 >= 0) goto L5;
        return r2;
    L5:
        return (V) this.mArray[(r3 << 1) + 1];
    }

    public int hashCode() {
        int[] r0 = this.mHashes;
        Object[] r1 = this.mArray;
        int r8 = this.mSize;
        int r2 = 1;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r8) goto L9;
        Object r6 = r1[r2];
        int r7 = r0[r4];
        if (r6 != null) goto L7;
        int r9 = 0;
    L8:
        r5 = r5 + (r9 ^ r7);
        r4 = r4 + 1;
        r2 = r2 + 2;
        goto L3
    L7:
        r9 = r6.hashCode();
        goto L8
    L9:
        return r5;
    }

    int indexOf(Object r6, int r7) {
        int r0 = this.mSize;
        if (r0 != 0) goto L6;
        return -1;
    L6:
        int r1 = binarySearchHashes(this.mHashes, r0, r7);
        if (r1 >= 0) goto L10;
        return r1;
    L10:
        if (r6.equals(this.mArray[r1 << 1]) == false) goto L12;
        return r1;
    L12:
        int r2 = r1 + 1;
    L13:
        if (r2 >= r0) goto L20;
        if (this.mHashes[r2] != r7) goto L20;
        if (r6.equals(this.mArray[r2 << 1]) == true) goto L18;
        r2 = r2 + 1;
        goto L13
    L18:
        return r2;
    L20:
        int r3 = r1 - 1;
    L21:
        if (r3 < 0) goto L29;
        if (this.mHashes[r3] != r7) goto L29;
        if (r6.equals(this.mArray[r3 << 1]) == true) goto L26;
        r3 = r3 - 1;
        goto L21
    L26:
        return r3;
    L29:
        return ~r2;
    }

    public int indexOfKey(@Nullable Object r2) {
        if (r2 != null) goto L5;
        return indexOfNull();
    L5:
        return indexOf(r2, r2.hashCode());
    }

    int indexOfNull() {
        int r0 = this.mSize;
        if (r0 != 0) goto L6;
        return -1;
    L6:
        int r1 = binarySearchHashes(this.mHashes, r0, 0);
        if (r1 >= 0) goto L10;
        return r1;
    L10:
        if (this.mArray[r1 << 1] != null) goto L12;
        return r1;
    L12:
        int r2 = r1 + 1;
    L13:
        if (r2 >= r0) goto L20;
        if (this.mHashes[r2] != 0) goto L20;
        if (this.mArray[r2 << 1] == null) goto L18;
        r2 = r2 + 1;
        goto L13
    L18:
        return r2;
    L20:
        int r3 = r1 - 1;
    L21:
        if (r3 < 0) goto L29;
        if (this.mHashes[r3] != 0) goto L29;
        if (this.mArray[r3 << 1] == null) goto L26;
        r3 = r3 - 1;
        goto L21
    L26:
        return r3;
    L29:
        return ~r2;
    }

    int indexOfValue(Object r5) {
        int r0 = this.mSize * 2;
        Object[] r4 = this.mArray;
        if (r5 != null) goto L11;
        int r6 = 1;
    L5:
        if (r6 >= r0) goto L18;
        if (r4[r6] == null) goto L9;
        r6 = r6 + 2;
        goto L5
    L9:
        return r6 >> 1;
    L18:
        return -1;
    L11:
        int r2 = 1;
    L12:
        if (r2 >= r0) goto L24;
        if (r5.equals(r4[r2]) == true) goto L16;
        r2 = r2 + 2;
        goto L12
    L16:
        return r2 >> 1;
    L24:
        return -1;
    }

    public boolean isEmpty() {
        if (this.mSize > 0) goto L5;
        return true;
    L5:
        return false;
    }

    public K keyAt(int r1) {
        return (K) this.mArray[r1 << 1];
    }

    @Nullable
    public V put(K r10, V r11) {
        int r0 = this.mSize;
        if (r10 != null) goto L5;
        int r2 = indexOfNull();
        int r3 = 0;
    L6:
        if (r2 < 0) goto L9;
        int r12 = (r2 << 1) + 1;
        Object[] r9 = this.mArray;
        V r1 = (V) r9[r12];
        r9[r12] = r11;
        return r1;
    L9:
        int r4 = ~r2;
        int[] r5 = this.mHashes;
        if (r0 < r5.length) goto L24;
        int r6 = 4;
        if (r0 < 8) goto L14;
        r6 = (r0 >> 1) + r0;
    L16:
        Object[] r7 = this.mArray;
        allocArrays(r6);
        if (r0 != this.mSize) goto L23;
        int[] r8 = this.mHashes;
        if (r8.length <= 0) goto L21;
        System.arraycopy(r5, 0, r8, 0, r5.length);
        System.arraycopy(r7, 0, this.mArray, 0, r7.length);
    L21:
        freeArrays(r5, r7, r0);
        goto L24
    L23:
        throw new ConcurrentModificationException();
    L14:
        if (r0 < 4) goto L16;
        r6 = 8;
    L24:
        if (r4 >= r0) goto L26;
        int[] r13 = this.mHashes;
        int r14 = r4 + 1;
        System.arraycopy(r13, r4, r13, r14, r0 - r4);
        Object[] r15 = this.mArray;
        System.arraycopy(r15, r4 << 1, r15, r14 << 1, (this.mSize - r4) << 1);
    L26:
        int r16 = this.mSize;
        if (r0 != r16) goto L33;
        int[] r17 = this.mHashes;
        if (r4 >= r17.length) goto L33;
        r17[r4] = r3;
        Object[] r18 = this.mArray;
        int r19 = r4 << 1;
        r18[r19] = r10;
        r18[r19 + 1] = r11;
        this.mSize = r16 + 1;
        return null;
    L33:
        throw new ConcurrentModificationException();
    L5:
        int r20 = r10.hashCode();
        r3 = r20;
        r2 = indexOf(r10, r20);
        goto L6
    }

    public void putAll(@NonNull SimpleArrayMap<? extends K, ? extends V> r5) {
        int r0 = r5.mSize;
        ensureCapacity(this.mSize + r0);
        int r2 = 0;
        if (this.mSize != 0) goto L6;
        if (r0 <= 0) goto L8;
        System.arraycopy(r5.mHashes, 0, this.mHashes, 0, r0);
        System.arraycopy(r5.mArray, 0, this.mArray, 0, r0 << 1);
        this.mSize = r0;
        return;
    L8:
        return;
    L6:
        if (r2 >= r0) goto L11;
        put(r5.keyAt(r2), r5.valueAt(r2));
        r2 = r2 + 1;
        goto L6
    }

    @Nullable
    public V putIfAbsent(K r2, V r3) {
        V r0 = get(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return put(r2, r3);
    }

    @Nullable
    public V remove(Object r1) {
        int r2 = indexOfKey(r1);
        if (r2 >= 0) goto L5;
        return null;
    L5:
        return removeAt(r2);
    }

    public boolean remove(Object r2, Object r3) {
        int r4 = indexOfKey(r2);
        if (r4 < 0) goto L11;
        V r0 = valueAt(r4);
        if (r3 == r0) goto L9;
        if (r3 != null) goto L8;
        return false;
    L8:
        if (r3.equals(r0) == true) goto L9;
        return false;
    L9:
        removeAt(r4);
        return true;
    L11:
        return false;
    }

    public V removeAt(int r11) {
        Object[] r0 = this.mArray;
        int r1 = r11 << 1;
        V r2 = (V) r0[r1 + 1];
        int r3 = this.mSize;
        int r4 = 0;
        if (r3 > 1) goto L5;
        freeArrays(this.mHashes, r0, r3);
        this.mHashes = ContainerHelpers.EMPTY_INTS;
        this.mArray = ContainerHelpers.EMPTY_OBJECTS;
    L24:
        if (r3 != this.mSize) goto L28;
        this.mSize = r4;
        return r2;
    L28:
        throw new ConcurrentModificationException();
    L5:
        int r6 = r3 - 1;
        int[] r7 = this.mHashes;
        int r9 = 8;
        if (r7.length > 8) goto L8;
    L19:
        if (r11 >= r6) goto L21;
        int r5 = r11 + 1;
        int r8 = r6 - r11;
        System.arraycopy(r7, r5, r7, r11, r8);
        Object[] r12 = this.mArray;
        System.arraycopy(r12, r5 << 1, r12, r1, r8 << 1);
    L21:
        Object[] r13 = this.mArray;
        int r10 = r6 << 1;
        r13[r10] = null;
        r13[r10 + 1] = null;
    L22:
        r4 = r6;
        goto L24
    L8:
        if (r3 >= (r7.length / 3)) goto L19;
        if (r3 <= 8) goto L11;
        r9 = r3 + (r3 >> 1);
    L11:
        allocArrays(r9);
        if (r3 != this.mSize) goto L18;
        if (r11 <= 0) goto L15;
        System.arraycopy(r7, 0, this.mHashes, 0, r11);
        System.arraycopy(r0, 0, this.mArray, 0, r1);
    L15:
        if (r11 >= r6) goto L22;
        int r14 = r11 + 1;
        int r15 = r6 - r11;
        System.arraycopy(r7, r14, this.mHashes, r11, r15);
        System.arraycopy(r0, r14 << 1, this.mArray, r1, r15 << 1);
        goto L22
    L18:
        throw new ConcurrentModificationException();
    }

    @Nullable
    public V replace(K r1, V r2) {
        int r3 = indexOfKey(r1);
        if (r3 >= 0) goto L5;
        return null;
    L5:
        return setValueAt(r3, r2);
    }

    public boolean replace(K r2, V r3, V r4) {
        int r5 = indexOfKey(r2);
        if (r5 < 0) goto L11;
        V r0 = valueAt(r5);
        if (r0 == r3) goto L9;
        if (r3 != null) goto L8;
        return false;
    L8:
        if (r3.equals(r0) == true) goto L9;
        return false;
    L9:
        setValueAt(r5, r4);
        return true;
    L11:
        return false;
    }

    public V setValueAt(int r2, V r3) {
        int r4 = (r2 << 1) + 1;
        Object[] r1 = this.mArray;
        V r0 = (V) r1[r4];
        r1[r4] = r3;
        return r0;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        if (isEmpty() == false) goto L6;
        return "{}";
    L6:
        StringBuilder r0 = new StringBuilder(this.mSize * 28);
        r0.append('{');
        int r1 = 0;
    L8:
        if (r1 >= this.mSize) goto L20;
        if (r1 <= 0) goto L11;
        r0.append(", ");
    L11:
        K r2 = keyAt(r1);
        if (r2 == this) goto L14;
        r0.append(r2);
    L15:
        r0.append('=');
        V r3 = valueAt(r1);
        if (r3 == this) goto L18;
        r0.append(r3);
    L19:
        r1 = r1 + 1;
        goto L8
    L18:
        r0.append("(this Map)");
        goto L19
    L14:
        r0.append("(this Map)");
        goto L15
    L20:
        r0.append('}');
        return r0.toString();
    }

    public V valueAt(int r1) {
        return (V) this.mArray[(r1 << 1) + 1];
    }
}
