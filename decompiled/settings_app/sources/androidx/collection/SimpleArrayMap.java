package androidx.collection;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SimpleArrayMap<K, V> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean CONCURRENT_MODIFICATION_EXCEPTIONS = true;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArrayMap";
    static Object[] mBaseCache;
    static int mBaseCacheSize;
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;
    Object[] mArray;
    int[] mHashes;
    int mSize;

    private static int binarySearchHashes(int[] r0, int r1, int r2) {
        return ContainerHelpers.binarySearch(r0, r1, r2);
    L5:
        throw new ConcurrentModificationException();
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

    private void allocArrays(int r6) {
        if (r6 != 8) goto L17;
        monitor-enter(SimpleArrayMap.class);
        Object[] r4 = mTwiceBaseCache;     // Catch: Throwable -> L13
        if (r4 == null) goto L11;
        this.mArray = r4;     // Catch: Throwable -> L13
        mTwiceBaseCache = (Object[]) r4[0];     // Catch: Throwable -> L13
        this.mHashes = (int[]) r4[1];     // Catch: Throwable -> L13
        r4[1] = null;     // Catch: Throwable -> L13
        r4[0] = null;     // Catch: Throwable -> L13
        mTwiceBaseCacheSize--;     // Catch: Throwable -> L13
        monitor-exit(SimpleArrayMap.class);     // Catch: Throwable -> L13
        return;
    L11:
        monitor-exit(SimpleArrayMap.class);     // Catch: Throwable -> L13
    L30:
        this.mHashes = new int[r6];
        this.mArray = new Object[r6 << 1];
        return;
    L13:
        th = move-exception;
        throw th;
    L17:
        if (r6 != 4) goto L30;
        monitor-enter(SimpleArrayMap.class);
        Object[] r5 = mBaseCache;     // Catch: Throwable -> L27
        if (r5 == null) goto L25;
        this.mArray = r5;     // Catch: Throwable -> L27
        mBaseCache = (Object[]) r5[0];     // Catch: Throwable -> L27
        this.mHashes = (int[]) r5[1];     // Catch: Throwable -> L27
        r5[1] = null;     // Catch: Throwable -> L27
        r5[0] = null;     // Catch: Throwable -> L27
        mBaseCacheSize--;     // Catch: Throwable -> L27
        monitor-exit(SimpleArrayMap.class);     // Catch: Throwable -> L27
        return;
    L25:
        monitor-exit(SimpleArrayMap.class);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    private static void freeArrays(int[] r7, Object[] r8, int r9) {
        if (r7.length != 8) goto L18;
        monitor-enter(SimpleArrayMap.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (mTwiceBaseCacheSize >= 10) goto L12;
        r8[0] = mTwiceBaseCache;     // Catch: Throwable -> L14
        r8[1] = r7;     // Catch: Throwable -> L14
        int r10 = (r9 << 1) - 1;     // Catch: Throwable -> L14
    L9:
        if (r10 < 2) goto L11;
        r8[r10] = null;     // Catch: Throwable -> L14
        r10 = r10 - 1;     // Catch: Throwable -> L14
        goto L9
    L11:
        mTwiceBaseCache = r8;     // Catch: Throwable -> L14
        mTwiceBaseCacheSize++;     // Catch: Throwable -> L14
    L12:
        monitor-exit(SimpleArrayMap.class);     // Catch: Throwable -> L14
        return;
    L18:
        if (r7.length == 4) goto L20;
        return;
    L20:
        monitor-enter(SimpleArrayMap.class);
    L29:
        th = move-exception;
        throw th;
    L22:
        if (mBaseCacheSize >= 10) goto L27;
        r8[0] = mBaseCache;     // Catch: Throwable -> L29
        r8[1] = r7;     // Catch: Throwable -> L29
        int r11 = (r9 << 1) - 1;     // Catch: Throwable -> L29
    L24:
        if (r11 < 2) goto L26;
        r8[r11] = null;     // Catch: Throwable -> L29
        r11 = r11 - 1;     // Catch: Throwable -> L29
        goto L24
    L26:
        mBaseCache = r8;     // Catch: Throwable -> L29
        mBaseCacheSize++;     // Catch: Throwable -> L29
    L27:
        monitor-exit(SimpleArrayMap.class);     // Catch: Throwable -> L29
    }

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

    public boolean containsKey(Object r1) {
        if (indexOfKey(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int indexOfKey(Object r2) {
        if (r2 != null) goto L5;
        return indexOfNull();
    L5:
        return indexOf(r2, r2.hashCode());
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

    public boolean containsValue(Object r1) {
        if (indexOfValue(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

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

    public K keyAt(int r1) {
        return (K) this.mArray[r1 << 1];
    }

    public V valueAt(int r1) {
        return (V) this.mArray[(r1 << 1) + 1];
    }

    public V setValueAt(int r2, V r3) {
        int r4 = (r2 << 1) + 1;
        Object[] r1 = this.mArray;
        V r0 = (V) r1[r4];
        r1[r4] = r3;
        return r0;
    }

    public boolean isEmpty() {
        if (this.mSize > 0) goto L5;
        return true;
    L5:
        return false;
    }

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
        if (r0 < r5.length) goto L26;
        int r6 = 8;
        if (r0 < 8) goto L15;
        r6 = (r0 >> 1) + r0;
    L18:
        Object[] r7 = this.mArray;
        allocArrays(r6);
        if (r0 != this.mSize) goto L25;
        int[] r8 = this.mHashes;
        if (r8.length <= 0) goto L23;
        System.arraycopy(r5, 0, r8, 0, r5.length);
        System.arraycopy(r7, 0, this.mArray, 0, r7.length);
    L23:
        freeArrays(r5, r7, r0);
        goto L26
    L25:
        throw new ConcurrentModificationException();
    L15:
        if (r0 >= 4) goto L18;
        r6 = 4;
    L26:
        if (r4 >= r0) goto L28;
        int[] r13 = this.mHashes;
        int r14 = r4 + 1;
        System.arraycopy(r13, r4, r13, r14, r0 - r4);
        Object[] r15 = this.mArray;
        System.arraycopy(r15, r4 << 1, r15, r14 << 1, (this.mSize - r4) << 1);
    L28:
        int r16 = this.mSize;
        if (r0 != r16) goto L35;
        int[] r17 = this.mHashes;
        if (r4 >= r17.length) goto L35;
        r17[r4] = r3;
        Object[] r18 = this.mArray;
        int r19 = r4 << 1;
        r18[r19] = r10;
        r18[r19 + 1] = r11;
        this.mSize = r16 + 1;
        return null;
    L35:
        throw new ConcurrentModificationException();
    L5:
        int r20 = r10.hashCode();
        r3 = r20;
        r2 = indexOf(r10, r20);
        goto L6
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> r5) {
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

    public V putIfAbsent(K r2, V r3) {
        V r0 = get(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return put(r2, r3);
    }

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
        if (r3 > 1) goto L5;
        clear();
    L25:
        return r2;
    L5:
        int r5 = r3 - 1;
        int[] r6 = this.mHashes;
        int r8 = 8;
        if (r6.length > 8) goto L8;
    L19:
        if (r11 >= r5) goto L21;
        int r4 = r11 + 1;
        int r7 = r5 - r11;
        System.arraycopy(r6, r4, r6, r11, r7);
        Object[] r12 = this.mArray;
        System.arraycopy(r12, r4 << 1, r12, r1, r7 << 1);
    L21:
        Object[] r13 = this.mArray;
        int r9 = r5 << 1;
        r13[r9] = null;
        r13[r9 + 1] = null;
    L23:
        if (r3 != this.mSize) goto L27;
        this.mSize = r5;
        goto L25
    L27:
        throw new ConcurrentModificationException();
    L8:
        if (r3 >= (r6.length / 3)) goto L19;
        if (r3 <= 8) goto L11;
        r8 = r3 + (r3 >> 1);
    L11:
        allocArrays(r8);
        if (r3 != this.mSize) goto L18;
        if (r11 <= 0) goto L15;
        System.arraycopy(r6, 0, this.mHashes, 0, r11);
        System.arraycopy(r0, 0, this.mArray, 0, r1);
    L15:
        if (r11 >= r5) goto L23;
        int r10 = r11 + 1;
        int r14 = r5 - r11;
        System.arraycopy(r6, r10, this.mHashes, r11, r14);
        System.arraycopy(r0, r10 << 1, this.mArray, r1, r14 << 1);
        goto L23
    L18:
        throw new ConcurrentModificationException();
    }

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

    public int size() {
        return this.mSize;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L46;
        return true;
    L46:
        if ((r7 instanceof SimpleArrayMap) == false) goto L26;
        SimpleArrayMap r8 = (SimpleArrayMap) r7;     // Catch: Throwable -> L45
        if (size() == r8.size()) goto L11;
        return false;
    L11:
        int r2 = 0;
    L13:
        if (r2 >= this.mSize) goto L24;
        K r3 = keyAt(r2);     // Catch: Throwable -> L45
        V r4 = valueAt(r2);     // Catch: Throwable -> L45
        Object r5 = r8.get(r3);     // Catch: Throwable -> L45
        if (r4 != null) goto L21;
        if (r5 != null) goto L19;
        if (r8.containsKey(r3) == false) goto L19;
    L23:
        r2 = r2 + 1;     // Catch: Throwable -> L45
    L19:
        return false;
    L21:
        if (r4.equals(r5) == true) goto L23;
        return false;
    L24:
        return true;
    L26:
        if ((r7 instanceof Map) == false) goto L44;
        Map r9 = (Map) r7;     // Catch: Throwable -> L45
        if (size() == r9.size()) goto L30;
        return false;
    L30:
        int r6 = 0;
    L32:
        if (r6 >= this.mSize) goto L43;
        K r10 = keyAt(r6);     // Catch: Throwable -> L45
        V r11 = valueAt(r6);     // Catch: Throwable -> L45
        Object r12 = r9.get(r10);     // Catch: Throwable -> L45
        if (r11 != null) goto L40;
        if (r12 != null) goto L38;
        if (r9.containsKey(r10) == false) goto L38;
    L42:
        r6 = r6 + 1;
    L38:
        return false;
    L40:
        if (r11.equals(r12) == true) goto L42;
        return false;
    L43:
        return true;
    L44:
        return false;
    }

    public int hashCode() {
        int[] r0 = this.mHashes;
        Object[] r1 = this.mArray;
        int r8 = this.mSize;
        int r3 = 1;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r8) goto L9;
        Object r6 = r1[r3];
        int r7 = r0[r4];
        if (r6 != null) goto L7;
        int r9 = 0;
    L8:
        r5 = r5 + (r9 ^ r7);
        r4 = r4 + 1;
        r3 = r3 + 2;
        goto L3
    L7:
        r9 = r6.hashCode();
        goto L8
    L9:
        return r5;
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
}
