package androidx.collection;

/* JADX INFO: loaded from: classes.dex */
public final class CircularArray<E> {
    private int mCapacityBitmask;
    private E[] mElements;
    private int mHead;
    private int mTail;

    private void doubleCapacity() {
        E[] r0 = this.mElements;
        int r1 = r0.length;
        int r2 = this.mHead;
        int r3 = r1 - r2;
        int r4 = r1 << 1;
        if (r4 < 0) goto L7;
        E[] r5 = (E[]) new Object[r4];
        System.arraycopy(r0, r2, r5, 0, r3);
        System.arraycopy(this.mElements, 0, r5, r3, this.mHead);
        this.mElements = r5;
        this.mHead = 0;
        this.mTail = r1;
        this.mCapacityBitmask = r4 - 1;
        return;
    L7:
        throw new RuntimeException("Max array capacity exceeded");
    }

    public CircularArray() {
        this(8);
    }

    public CircularArray(int r3) {
        if (r3 < 1) goto L14;
        if (r3 > 1073741824) goto L12;
        if (Integer.bitCount(r3) == 1) goto L9;
        r3 = Integer.highestOneBit(r3 - 1) << 1;
    L9:
        this.mCapacityBitmask = r3 - 1;
        this.mElements = (E[]) new Object[r3];
        return;
    L12:
        throw new IllegalArgumentException("capacity must be <= 2^30");
    L14:
        throw new IllegalArgumentException("capacity must be >= 1");
    }

    public void addFirst(E r3) {
        int r0 = (this.mHead - 1) & this.mCapacityBitmask;
        this.mHead = r0;
        this.mElements[r0] = r3;
        if (r0 != this.mTail) goto L6;
        doubleCapacity();
        return;
    }

    public void addLast(E r3) {
        E[] r0 = this.mElements;
        int r1 = this.mTail;
        r0[r1] = r3;
        int r4 = this.mCapacityBitmask;
        int r5 = r4 & (r1 + 1);
        this.mTail = r5;
        if (r5 != this.mHead) goto L6;
        doubleCapacity();
        return;
    }

    public E popFirst() {
        int r0 = this.mHead;
        if (r0 == this.mTail) goto L7;
        E[] r1 = this.mElements;
        E r2 = r1[r0];
        r1[r0] = null;
        this.mHead = (r0 + 1) & this.mCapacityBitmask;
        return r2;
    L7:
        throw new ArrayIndexOutOfBoundsException();
    }

    public E popLast() {
        int r0 = this.mHead;
        int r1 = this.mTail;
        if (r0 == r1) goto L7;
        int r2 = this.mCapacityBitmask & (r1 - 1);
        E[] r3 = this.mElements;
        E r4 = r3[r2];
        r3[r2] = null;
        this.mTail = r2;
        return r4;
    L7:
        throw new ArrayIndexOutOfBoundsException();
    }

    public void clear() {
        removeFromStart(size());
    }

    public void removeFromStart(int r5) {
        if (r5 > 0) goto L5;
        return;
    L5:
        if (r5 > size()) goto L20;
        int r0 = this.mElements.length;
        int r1 = this.mHead;
        if (r5 >= (r0 - r1)) goto L10;
        r0 = r1 + r5;
    L10:
        if (r1 >= r0) goto L12;
        this.mElements[r1] = null;
        r1 = r1 + 1;
        goto L10
    L12:
        int r2 = this.mHead;
        int r3 = r0 - r2;
        int r6 = r5 - r3;
        int r4 = r2 + r3;
        this.mHead = this.mCapacityBitmask & r4;
        if (r6 <= 0) goto L24;
        int r7 = 0;
    L15:
        if (r7 >= r6) goto L17;
        this.mElements[r7] = null;
        r7 = r7 + 1;
        goto L15
    L17:
        this.mHead = r6;
        return;
    L24:
        return;
    L20:
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromEnd(int r5) {
        if (r5 > 0) goto L5;
        return;
    L5:
        if (r5 > size()) goto L23;
        int r0 = this.mTail;
        if (r5 >= r0) goto L9;
        int r1 = r0 - r5;
    L10:
        int r2 = r1;
    L11:
        int r3 = this.mTail;
        if (r2 >= r3) goto L14;
        this.mElements[r2] = null;
        r2 = r2 + 1;
        goto L11
    L14:
        int r4 = r3 - r1;
        int r6 = r5 - r4;
        this.mTail = r3 - r4;
        if (r6 <= 0) goto L26;
        int r7 = this.mElements.length;
        this.mTail = r7;
        int r8 = r7 - r6;
        int r9 = r8;
    L18:
        if (r9 >= this.mTail) goto L20;
        this.mElements[r9] = null;
        r9 = r9 + 1;
        goto L18
    L20:
        this.mTail = r8;
        return;
    L26:
        return;
    L9:
        r1 = 0;
        goto L10
    L23:
        throw new ArrayIndexOutOfBoundsException();
    }

    public E getFirst() {
        int r0 = this.mHead;
        if (r0 == this.mTail) goto L7;
        return this.mElements[r0];
    L7:
        throw new ArrayIndexOutOfBoundsException();
    }

    public E getLast() {
        int r0 = this.mHead;
        int r1 = this.mTail;
        if (r0 == r1) goto L7;
        return this.mElements[this.mCapacityBitmask & (r1 - 1)];
    L7:
        throw new ArrayIndexOutOfBoundsException();
    }

    public E get(int r3) {
        if (r3 < 0) goto L8;
        if (r3 >= size()) goto L8;
        E[] r0 = this.mElements;
        int r1 = this.mHead + r3;
        return r0[this.mCapacityBitmask & r1];
    L8:
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size() {
        int r0 = this.mTail - this.mHead;
        return this.mCapacityBitmask & r0;
    }

    public boolean isEmpty() {
        if (this.mHead != this.mTail) goto L5;
        return true;
    L5:
        return false;
    }
}
