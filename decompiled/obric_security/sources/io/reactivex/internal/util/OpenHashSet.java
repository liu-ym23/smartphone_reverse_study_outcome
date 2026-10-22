package io.reactivex.internal.util;

/* JADX INFO: loaded from: classes5.dex */
public final class OpenHashSet<T> {
    private static final int INT_PHI = -1640531527;
    T[] keys;
    final float loadFactor;
    int mask;
    int maxSize;
    int size;

    static int mix(int r1) {
        int r2 = r1 * INT_PHI;
        return r2 ^ (r2 >>> 16);
    }

    public OpenHashSet() {
        this(16, 0.75f);
    }

    public OpenHashSet(int r2) {
        this(r2, 0.75f);
    }

    public OpenHashSet(int r2, float r3) {
        this.loadFactor = r3;
        int r4 = Pow2.roundToPowerOfTwo(r2);
        this.mask = r4 - 1;
        this.maxSize = (int) (r3 * r4);
        this.keys = (T[]) new Object[r4];
    }

    public boolean add(T r7) {
        T[] r0 = this.keys;
        int r1 = this.mask;
        int r2 = mix(r7.hashCode()) & r1;
        T r3 = r0[r2];
        if (r3 != null) goto L5;
    L13:
        r0[r2] = r7;
        int r8 = this.size + 1;
        this.size = r8;
        if (r8 < this.maxSize) goto L16;
        rehash();
    L16:
        return true;
    L5:
        if (r3.equals(r7) == false) goto L7;
        return false;
    L7:
        r2 = (r2 + 1) & r1;
        T r4 = r0[r2];
        if (r4 == null) goto L13;
        if (r4.equals(r7) == false) goto L7;
        return false;
    }

    public boolean remove(T r6) {
        T[] r0 = this.keys;
        int r1 = this.mask;
        int r2 = mix(r6.hashCode()) & r1;
        T r3 = r0[r2];
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.equals(r6) == true) goto L8;
    L9:
        r2 = (r2 + 1) & r1;
        T r4 = r0[r2];
        if (r4 == null) goto L11;
        if (r4.equals(r6) == false) goto L9;
        return removeEntry(r2, r0, r1);
    L11:
        return false;
    L8:
        return removeEntry(r2, r0, r1);
    }

    boolean removeEntry(int r4, T[] r5, int r6) {
        this.size--;
    L3:
        int r3 = r4 + 1;
    L4:
        int r7 = r3 & r6;
        T r0 = r5[r7];
        if (r0 == null) goto L6;
        int r2 = mix(r0.hashCode()) & r6;
        if (r4 > r7) goto L13;
        if (r4 >= r2) goto L15;
        if (r2 > r7) goto L15;
    L16:
        r3 = r7 + 1;
    L15:
        r5[r4] = r0;
        r4 = r7;
        goto L3
    L13:
        if (r4 < r2) goto L16;
        if (r2 <= r7) goto L16;
    L6:
        r5[r4] = null;
        return true;
    }

    void rehash() {
        T[] r0 = this.keys;
        int r1 = r0.length;
        int r2 = r1 << 1;
        int r3 = r2 - 1;
        T[] r4 = (T[]) new Object[r2];
        int r5 = this.size;
    L3:
        int r6 = r5 - 1;
        if (r5 == 0) goto L13;
    L5:
        r1 = r1 - 1;
        T r7 = r0[r1];
        if (r7 == null) goto L5;
        int r8 = mix(r7.hashCode()) & r3;
        if (r4[r8] == null) goto L12;
    L10:
        r8 = (r8 + 1) & r3;
        if (r4[r8] != null) goto L10;
    L12:
        r4[r8] = r0[r1];
        r5 = r6;
        goto L3
    L13:
        this.mask = r3;
        this.maxSize = (int) (r2 * this.loadFactor);
        this.keys = r4;
    }

    public Object[] keys() {
        return this.keys;
    }

    public int size() {
        return this.size;
    }
}
