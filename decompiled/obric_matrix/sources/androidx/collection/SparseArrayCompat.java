package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class SparseArrayCompat<E> implements Cloneable {
    private static final Object DELETED = null;
    private boolean mGarbage;
    private int[] mKeys;
    private int mSize;
    private Object[] mValues;

    static {
        DELETED = new Object();
    }

    public SparseArrayCompat() {
        this(10);
    }

    public SparseArrayCompat(int r2) {
        this.mGarbage = false;
        if (r2 != 0) goto L5;
        this.mKeys = ContainerHelpers.EMPTY_INTS;
        this.mValues = ContainerHelpers.EMPTY_OBJECTS;
        return;
    L5:
        int r3 = ContainerHelpers.idealIntArraySize(r2);
        this.mKeys = new int[r3];
        this.mValues = new Object[r3];
    }

    private void gc() {
        int r0 = this.mSize;
        int[] r1 = this.mKeys;
        Object[] r2 = this.mValues;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r0) goto L10;
        Object r6 = r2[r4];
        if (r6 == DELETED) goto L9;
        if (r4 == r5) goto L8;
        r1[r5] = r1[r4];
        r2[r5] = r6;
        r2[r4] = null;
    L8:
        r5 = r5 + 1;
    L9:
        r4 = r4 + 1;
        goto L3
    L10:
        this.mGarbage = false;
        this.mSize = r5;
    }

    public void append(int r7, E r8) {
        int r0 = this.mSize;
        if (r0 == 0) goto L9;
        if (r7 > this.mKeys[r0 - 1]) goto L9;
        put(r7, r8);
        return;
    L9:
        if (this.mGarbage == true) goto L11;
    L13:
        int r1 = this.mSize;
        if (r1 < this.mKeys.length) goto L16;
        int r2 = ContainerHelpers.idealIntArraySize(r1 + 1);
        int[] r3 = new int[r2];
        Object[] r4 = new Object[r2];
        int[] r5 = this.mKeys;
        System.arraycopy(r5, 0, r3, 0, r5.length);
        Object[] r6 = this.mValues;
        System.arraycopy(r6, 0, r4, 0, r6.length);
        this.mKeys = r3;
        this.mValues = r4;
    L16:
        this.mKeys[r1] = r7;
        this.mValues[r1] = r8;
        this.mSize = r1 + 1;
        return;
    L11:
        if (r0 < this.mKeys.length) goto L13;
        gc();
        goto L13
    }

    public void clear() {
        int r0 = this.mSize;
        Object[] r1 = this.mValues;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1[r3] = null;
        r3 = r3 + 1;
        goto L3
    L5:
        this.mSize = 0;
        this.mGarbage = false;
    }

    public SparseArrayCompat<E> clone() {
        SparseArrayCompat<E> r0 = (SparseArrayCompat) super.clone();     // Catch: CloneNotSupportedException -> L4
        r0.mKeys = (int[]) this.mKeys.clone();     // Catch: CloneNotSupportedException -> L4
        r0.mValues = (Object[]) this.mValues.clone();     // Catch: CloneNotSupportedException -> L4
        return r0;
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m6clone() {
        return clone();
    }

    public boolean containsKey(int r1) {
        if (indexOfKey(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean containsValue(E r1) {
        if (indexOfValue(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Deprecated
    public void delete(int r1) {
        remove(r1);
    }

    @Nullable
    public E get(int r2) {
        return get(r2, null);
    }

    public E get(int r3, E r4) {
        int r5 = ContainerHelpers.binarySearch(this.mKeys, this.mSize, r3);
        if (r5 < 0) goto L9;
        Object[] r2 = this.mValues;
        if (r2[r5] == DELETED) goto L9;
        return (E) r2[r5];
    L9:
        return r4;
    }

    public int indexOfKey(int r2) {
        if (this.mGarbage == false) goto L6;
        gc();
    L6:
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, r2);
    }

    public int indexOfValue(E r3) {
        if (this.mGarbage == false) goto L5;
        gc();
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.mSize) goto L12;
        if (this.mValues[r0] == r3) goto L10;
        r0 = r0 + 1;
        goto L7
    L10:
        return r0;
    L12:
        return -1;
    }

    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int keyAt(int r2) {
        if (this.mGarbage == false) goto L6;
        gc();
    L6:
        return this.mKeys[r2];
    }

    public void put(int r7, E r8) {
        int r0 = ContainerHelpers.binarySearch(this.mKeys, this.mSize, r7);
        if (r0 < 0) goto L5;
        this.mValues[r0] = r8;
        return;
    L5:
        int r1 = ~r0;
        int r2 = this.mSize;
        if (r1 >= r2) goto L12;
        Object[] r3 = this.mValues;
        if (r3[r1] != DELETED) goto L12;
        this.mKeys[r1] = r7;
        r3[r1] = r8;
        return;
    L12:
        if (this.mGarbage == true) goto L14;
    L16:
        int r4 = this.mSize;
        if (r4 < this.mKeys.length) goto L19;
        int r5 = ContainerHelpers.idealIntArraySize(r4 + 1);
        int[] r6 = new int[r5];
        Object[] r9 = new Object[r5];
        int[] r10 = this.mKeys;
        System.arraycopy(r10, 0, r6, 0, r10.length);
        Object[] r11 = this.mValues;
        System.arraycopy(r11, 0, r9, 0, r11.length);
        this.mKeys = r6;
        this.mValues = r9;
    L19:
        int r12 = this.mSize;
        if ((r12 - r1) == 0) goto L22;
        int[] r13 = this.mKeys;
        int r14 = r1 + 1;
        System.arraycopy(r13, r1, r13, r14, r12 - r1);
        Object[] r15 = this.mValues;
        System.arraycopy(r15, r1, r15, r14, this.mSize - r1);
    L22:
        this.mKeys[r1] = r7;
        this.mValues[r1] = r8;
        this.mSize++;
        return;
    L14:
        if (r2 < this.mKeys.length) goto L16;
        gc();
        r1 = ~ContainerHelpers.binarySearch(this.mKeys, this.mSize, r7);
        goto L16
    }

    public void putAll(@NonNull SparseArrayCompat<? extends E> r5) {
        int r0 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        put(r5.keyAt(r1), r5.valueAt(r1));
        r1 = r1 + 1;
        goto L3
    }

    @Nullable
    public E putIfAbsent(int r2, E r3) {
        E r0 = get(r2);
        if (r0 != null) goto L5;
        put(r2, r3);
    L5:
        return r0;
    }

    public void remove(int r4) {
        int r5 = ContainerHelpers.binarySearch(this.mKeys, this.mSize, r4);
        if (r5 < 0) goto L8;
        Object[] r0 = this.mValues;
        Object r1 = r0[r5];
        Object r2 = DELETED;
        if (r1 == r2) goto L9;
        r0[r5] = r2;
        this.mGarbage = true;
        return;
    L9:
        return;
    }

    public boolean remove(int r2, Object r3) {
        int r4 = indexOfKey(r2);
        if (r4 < 0) goto L11;
        E r0 = valueAt(r4);
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

    public void removeAt(int r4) {
        Object[] r0 = this.mValues;
        Object r1 = r0[r4];
        Object r2 = DELETED;
        if (r1 == r2) goto L6;
        r0[r4] = r2;
        this.mGarbage = true;
        return;
    }

    public void removeAtRange(int r2, int r3) {
        int r4 = Math.min(this.mSize, r3 + r2);
    L3:
        if (r2 >= r4) goto L5;
        removeAt(r2);
        r2 = r2 + 1;
        goto L3
    }

    @Nullable
    public E replace(int r2, E r3) {
        int r4 = indexOfKey(r2);
        if (r4 < 0) goto L6;
        Object[] r1 = this.mValues;
        E r0 = (E) r1[r4];
        r1[r4] = r3;
        return r0;
    L6:
        return null;
    }

    public boolean replace(int r2, E r3, E r4) {
        int r5 = indexOfKey(r2);
        if (r5 < 0) goto L11;
        Object r0 = this.mValues[r5];
        if (r0 == r3) goto L9;
        if (r3 != null) goto L8;
        return false;
    L8:
        if (r3.equals(r0) == true) goto L9;
        return false;
    L9:
        this.mValues[r5] = r4;
        return true;
    L11:
        return false;
    }

    public void setValueAt(int r2, E r3) {
        if (this.mGarbage == false) goto L5;
        gc();
    L5:
        this.mValues[r2] = r3;
    }

    public int size() {
        if (this.mGarbage == false) goto L6;
        gc();
    L6:
        return this.mSize;
    }

    public String toString() {
        if (size() > 0) goto L6;
        return "{}";
    L6:
        StringBuilder r0 = new StringBuilder(this.mSize * 28);
        r0.append('{');
        int r1 = 0;
    L8:
        if (r1 >= this.mSize) goto L16;
        if (r1 <= 0) goto L11;
        r0.append(", ");
    L11:
        r0.append(keyAt(r1));
        r0.append('=');
        E r2 = valueAt(r1);
        if (r2 == this) goto L14;
        r0.append(r2);
    L15:
        r1 = r1 + 1;
        goto L8
    L14:
        r0.append("(this Map)");
        goto L15
    L16:
        r0.append('}');
        return r0.toString();
    }

    public E valueAt(int r2) {
        if (this.mGarbage == false) goto L6;
        gc();
    L6:
        return (E) this.mValues[r2];
    }
}
