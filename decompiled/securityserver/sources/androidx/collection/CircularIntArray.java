package androidx.collection;

/* JADX INFO: loaded from: classes.dex */
public final class CircularIntArray {
    private int mCapacityBitmask;
    private int[] mElements;
    private int mHead;
    private int mTail;

    public CircularIntArray() {
        this(8);
    }

    private void doubleCapacity() {
        int[] r0 = this.mElements;
        int r1 = r0.length;
        int r2 = this.mHead;
        int r3 = r1 - r2;
        int r4 = r1 << 1;
        if (r4 < 0) goto L7;
        int[] r5 = new int[r4];
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

    public void addFirst(int r3) {
        int r0 = (this.mHead - 1) & this.mCapacityBitmask;
        this.mHead = r0;
        this.mElements[r0] = r3;
        if (r0 != this.mTail) goto L6;
        doubleCapacity();
        return;
    }

    public void addLast(int r3) {
        int[] r0 = this.mElements;
        int r1 = this.mTail;
        r0[r1] = r3;
        int r4 = this.mCapacityBitmask;
        int r5 = r4 & (r1 + 1);
        this.mTail = r5;
        if (r5 != this.mHead) goto L6;
        doubleCapacity();
        return;
    }

    public void clear() {
        this.mTail = this.mHead;
    }

    public int get(int r3) {
        if (r3 < 0) goto L8;
        if (r3 >= size()) goto L8;
        int[] r0 = this.mElements;
        int r1 = this.mHead + r3;
        return r0[this.mCapacityBitmask & r1];
    L8:
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getFirst() {
        int r0 = this.mHead;
        if (r0 == this.mTail) goto L7;
        return this.mElements[r0];
    L7:
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getLast() {
        int r0 = this.mHead;
        int r1 = this.mTail;
        if (r0 == r1) goto L7;
        return this.mElements[this.mCapacityBitmask & (r1 - 1)];
    L7:
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        if (this.mHead != this.mTail) goto L5;
        return true;
    L5:
        return false;
    }

    public int popFirst() {
        int r0 = this.mHead;
        if (r0 == this.mTail) goto L7;
        int r1 = this.mElements[r0];
        this.mHead = (r0 + 1) & this.mCapacityBitmask;
        return r1;
    L7:
        throw new ArrayIndexOutOfBoundsException();
    }

    public int popLast() {
        int r0 = this.mHead;
        int r1 = this.mTail;
        if (r0 == r1) goto L7;
        int r2 = this.mCapacityBitmask & (r1 - 1);
        int r3 = this.mElements[r2];
        this.mTail = r2;
        return r3;
    L7:
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromEnd(int r2) {
        if (r2 > 0) goto L5;
        return;
    L5:
        if (r2 > size()) goto L9;
        int r0 = this.mTail - r2;
        this.mTail = this.mCapacityBitmask & r0;
        return;
    L9:
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromStart(int r2) {
        if (r2 > 0) goto L5;
        return;
    L5:
        if (r2 > size()) goto L9;
        int r0 = this.mHead + r2;
        this.mHead = this.mCapacityBitmask & r0;
        return;
    L9:
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size() {
        int r0 = this.mTail - this.mHead;
        return this.mCapacityBitmask & r0;
    }

    public CircularIntArray(int r3) {
        if (r3 < 1) goto L14;
        if (r3 > 1073741824) goto L12;
        if (Integer.bitCount(r3) == 1) goto L9;
        r3 = Integer.highestOneBit(r3 - 1) << 1;
    L9:
        this.mCapacityBitmask = r3 - 1;
        this.mElements = new int[r3];
        return;
    L12:
        throw new IllegalArgumentException("capacity must be <= 2^30");
    L14:
        throw new IllegalArgumentException("capacity must be >= 1");
    }
}
