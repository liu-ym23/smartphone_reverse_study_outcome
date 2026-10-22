package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class SortedList<T> {
    private static final int CAPACITY_GROWTH = 10;
    private static final int DELETION = 2;
    private static final int INSERTION = 1;
    public static final int INVALID_POSITION = -1;
    private static final int LOOKUP = 4;
    private static final int MIN_CAPACITY = 10;
    private BatchedCallback mBatchedCallback;
    private Callback mCallback;
    T[] mData;
    private int mNewDataStart;
    private T[] mOldData;
    private int mOldDataSize;
    private int mOldDataStart;
    private int mSize;
    private final Class<T> mTClass;

    public static class BatchedCallback<T2> extends Callback<T2> {
        private final BatchingListUpdateCallback mBatchingListUpdateCallback;
        final Callback<T2> mWrappedCallback;

        public BatchedCallback(Callback<T2> r2) {
            this.mWrappedCallback = r2;
            this.mBatchingListUpdateCallback = new BatchingListUpdateCallback(r2);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areContentsTheSame(T2 r1, T2 r2) {
            return this.mWrappedCallback.areContentsTheSame(r1, r2);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areItemsTheSame(T2 r1, T2 r2) {
            return this.mWrappedCallback.areItemsTheSame(r1, r2);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, java.util.Comparator
        public int compare(T2 r1, T2 r2) {
            return this.mWrappedCallback.compare(r1, r2);
        }

        public void dispatchLastEvent() {
            this.mBatchingListUpdateCallback.dispatchLastEvent();
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        @Nullable
        public Object getChangePayload(T2 r1, T2 r2) {
            return this.mWrappedCallback.getChangePayload(r1, r2);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public void onChanged(int r2, int r3) {
            this.mBatchingListUpdateCallback.onChanged(r2, r3, null);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int r1, int r2, Object r3) {
            this.mBatchingListUpdateCallback.onChanged(r1, r2, r3);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int r1, int r2) {
            this.mBatchingListUpdateCallback.onInserted(r1, r2);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int r1, int r2) {
            this.mBatchingListUpdateCallback.onMoved(r1, r2);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int r1, int r2) {
            this.mBatchingListUpdateCallback.onRemoved(r1, r2);
        }
    }

    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        public Callback() {
        }

        public abstract boolean areContentsTheSame(T2 r1, T2 r2);

        public abstract boolean areItemsTheSame(T2 r1, T2 r2);

        @Override // java.util.Comparator
        public abstract int compare(T2 r1, T2 r2);

        @Nullable
        public Object getChangePayload(T2 r1, T2 r2) {
            return null;
        }

        public abstract void onChanged(int r1, int r2);

        public void onChanged(int r1, int r2, Object r3) {
            onChanged(r1, r2);
        }
    }

    public SortedList(@NonNull Class<T> r2, @NonNull Callback<T> r3) {
        this(r2, r3, 10);
    }

    public SortedList(@NonNull Class<T> r1, @NonNull Callback<T> r2, int r3) {
        this.mTClass = r1;
        this.mData = (T[]) ((Object[]) Array.newInstance(r1, r3));
        this.mCallback = r2;
        this.mSize = 0;
    }

    private int add(T r7, boolean r8) {
        int r0 = findIndexOf(r7, this.mData, 0, this.mSize, 1);
        if (r0 != (-1)) goto L6;
        r0 = 0;
    L15:
        addToData(r0, r7);
        if (r8 == false) goto L18;
        this.mCallback.onInserted(r0, 1);
    L18:
        return r0;
    L6:
        if (r0 >= this.mSize) goto L15;
        T r2 = this.mData[r0];
        if (this.mCallback.areItemsTheSame(r2, r7) == false) goto L15;
        if (this.mCallback.areContentsTheSame(r2, r7) == false) goto L13;
        this.mData[r0] = r7;
        return r0;
    L13:
        this.mData[r0] = r7;
        Callback r6 = this.mCallback;
        r6.onChanged(r0, 1, r6.getChangePayload(r2, r7));
        return r0;
    }

    private void addAllInternal(T[] r3) {
        if (r3.length >= 1) goto L5;
        return;
    L5:
        int r0 = sortAndDedup(r3);
        if (this.mSize != 0) goto L8;
        this.mData = r3;
        this.mSize = r0;
        this.mCallback.onInserted(0, r0);
        return;
    L8:
        merge(r3, r0);
    }

    private void addToData(int r4, T r5) {
        int r0 = this.mSize;
        if (r4 > r0) goto L11;
        T[] r1 = this.mData;
        if (r0 != r1.length) goto L7;
        T[] r2 = (T[]) ((Object[]) Array.newInstance(this.mTClass, r1.length + 10));
        System.arraycopy(this.mData, 0, r2, 0, r4);
        r2[r4] = r5;
        System.arraycopy(this.mData, r4, r2, r4 + 1, this.mSize - r4);
        this.mData = r2;
    L8:
        this.mSize++;
        return;
    L7:
        System.arraycopy(r1, r4, r1, r4 + 1, r0 - r4);
        this.mData[r4] = r5;
        goto L8
    L11:
        throw new IndexOutOfBoundsException("cannot add item to " + r4 + " because size is " + this.mSize);
    }

    private T[] copyArray(T[] r3) {
        T[] r2 = (T[]) ((Object[]) Array.newInstance(this.mTClass, r3.length));
        System.arraycopy(r3, 0, r2, 0, r3.length);
        return r2;
    }

    private int findIndexOf(T r6, T[] r7, int r8, int r9, int r10) {
    L3:
        if (r8 >= r9) goto L19;
        int r2 = (r8 + r9) / 2;
        T r3 = r7[r2];
        int r4 = this.mCallback.compare(r3, r6);
        if (r4 < 0) goto L6;
        if (r4 == 0) goto L9;
        r9 = r2;
        goto L3
    L9:
        if (this.mCallback.areItemsTheSame(r3, r6) == false) goto L11;
        return r2;
    L11:
        int r5 = linearEqualitySearch(r6, r2, r8, r9);
        if (r10 != 1) goto L17;
        if (r5 != (-1)) goto L16;
        return r2;
    L16:
        return r5;
    L17:
        return r5;
    L6:
        r8 = r2 + 1;
        goto L3
    L19:
        if (r10 != 1) goto L22;
        return r8;
    L22:
        return -1;
    }

    private int findSameItem(T r3, T[] r4, int r5, int r6) {
    L2:
        if (r5 >= r6) goto L7;
        if (this.mCallback.areItemsTheSame(r4[r5], r3) == true) goto L5;
        r5 = r5 + 1;
        goto L2
    L5:
        return r5;
    L7:
        return -1;
    }

    private int linearEqualitySearch(T r4, int r5, int r6, int r7) {
        int r0 = r5 - 1;
    L3:
        if (r0 < r6) goto L11;
        T r1 = this.mData[r0];
        if (this.mCallback.compare(r1, r4) != 0) goto L11;
        if (this.mCallback.areItemsTheSame(r1, r4) == true) goto L9;
        r0 = r0 - 1;
        goto L3
    L9:
        return r0;
    L11:
        r5 = r5 + 1;
        if (r5 >= r7) goto L19;
        T r8 = this.mData[r5];
        if (this.mCallback.compare(r8, r4) != 0) goto L29;
        if (this.mCallback.areItemsTheSame(r8, r4) == false) goto L11;
        return r5;
    L29:
        return -1;
    L19:
        return -1;
    }

    private void merge(T[] r9, int r10) {
        boolean r0 = !(this.mCallback instanceof BatchedCallback);
        if (r0 == false) goto L5;
        beginBatchedUpdates();
    L5:
        this.mOldData = this.mData;
        int r2 = 0;
        this.mOldDataStart = 0;
        int r3 = this.mSize;
        this.mOldDataSize = r3;
        this.mData = (T[]) ((Object[]) Array.newInstance(this.mTClass, (r3 + r10) + 10));
        this.mNewDataStart = 0;
    L6:
        int r4 = this.mOldDataStart;
        int r5 = this.mOldDataSize;
        if (r4 < r5) goto L9;
        if (r2 < r10) goto L9;
    L13:
        this.mOldData = null;
        if (r0 == false) goto L41;
        endBatchedUpdates();
        return;
    L41:
        return;
    L9:
        if (r4 == r5) goto L10;
        if (r2 == r10) goto L12;
        T r6 = this.mOldData[r4];
        T r7 = r9[r2];
        int r8 = this.mCallback.compare(r6, r7);
        if (r8 > 0) goto L19;
        if (r8 != 0) goto L26;
        if (this.mCallback.areItemsTheSame(r6, r7) == false) goto L26;
        T[] r11 = this.mData;
        int r12 = this.mNewDataStart;
        this.mNewDataStart = r12 + 1;
        r11[r12] = r7;
        r2 = r2 + 1;
        this.mOldDataStart++;
        if (this.mCallback.areContentsTheSame(r6, r7) == true) goto L6;
        Callback r13 = this.mCallback;
        r13.onChanged(this.mNewDataStart - 1, 1, r13.getChangePayload(r6, r7));
    L26:
        T[] r14 = this.mData;
        int r15 = this.mNewDataStart;
        this.mNewDataStart = r15 + 1;
        r14[r15] = r6;
        this.mOldDataStart++;
        goto L6
    L19:
        T[] r16 = this.mData;
        int r17 = this.mNewDataStart;
        int r18 = r17 + 1;
        this.mNewDataStart = r18;
        r16[r17] = r7;
        this.mSize++;
        r2 = r2 + 1;
        this.mCallback.onInserted(r18 - 1, 1);
        goto L6
    L12:
        int r19 = r5 - r4;
        System.arraycopy(this.mOldData, r4, this.mData, this.mNewDataStart, r19);
        this.mNewDataStart += r19;
        goto L13
    L10:
        int r110 = r10 - r2;
        System.arraycopy(r9, r2, this.mData, this.mNewDataStart, r110);
        int r20 = this.mNewDataStart + r110;
        this.mNewDataStart = r20;
        this.mSize += r110;
        this.mCallback.onInserted(r20 - r110, r110);
        goto L13
    }

    private boolean remove(T r7, boolean r8) {
        int r9 = findIndexOf(r7, this.mData, 0, this.mSize, 2);
        if (r9 != (-1)) goto L6;
        return false;
    L6:
        removeItemAtIndex(r9, r8);
        return true;
    }

    private void removeItemAtIndex(int r5, boolean r6) {
        T[] r0 = this.mData;
        System.arraycopy(r0, r5 + 1, r0, r5, (this.mSize - r5) - 1);
        int r1 = this.mSize - 1;
        this.mSize = r1;
        this.mData[r1] = null;
        if (r6 == false) goto L6;
        this.mCallback.onRemoved(r5, 1);
        return;
    }

    private void replaceAllInsert(T r3) {
        T[] r0 = this.mData;
        int r1 = this.mNewDataStart;
        r0[r1] = r3;
        int r2 = r1 + 1;
        this.mNewDataStart = r2;
        this.mSize++;
        this.mCallback.onInserted(r2 - 1, 1);
    }

    private void replaceAllInternal(@NonNull T[] r8) {
        boolean r0 = !(this.mCallback instanceof BatchedCallback);
        if (r0 == false) goto L5;
        beginBatchedUpdates();
    L5:
        this.mOldDataStart = 0;
        this.mOldDataSize = this.mSize;
        this.mOldData = this.mData;
        this.mNewDataStart = 0;
        int r2 = sortAndDedup(r8);
        this.mData = (T[]) ((Object[]) Array.newInstance(this.mTClass, r2));
    L6:
        int r3 = this.mNewDataStart;
        if (r3 >= r2) goto L9;
    L10:
        int r4 = this.mOldDataStart;
        int r5 = this.mOldDataSize;
        if (r4 >= r5) goto L12;
        if (r3 >= r2) goto L14;
        T r6 = this.mOldData[r4];
        T r7 = r8[r3];
        int r9 = this.mCallback.compare(r6, r7);
        if (r9 < 0) goto L21;
        if (r9 > 0) goto L23;
        if (this.mCallback.areItemsTheSame(r6, r7) == false) goto L26;
        T[] r10 = this.mData;
        int r11 = this.mNewDataStart;
        r10[r11] = r7;
        this.mOldDataStart++;
        this.mNewDataStart = r11 + 1;
        if (this.mCallback.areContentsTheSame(r6, r7) == true) goto L6;
        Callback r12 = this.mCallback;
        r12.onChanged(this.mNewDataStart - 1, 1, r12.getChangePayload(r6, r7));
        goto L6
    L26:
        replaceAllRemove();
    L23:
        replaceAllInsert(r7);
        goto L6
    L21:
        replaceAllRemove();
        goto L6
    L14:
        int r13 = r5 - r4;
        this.mSize -= r13;
        this.mCallback.onRemoved(r3, r13);
    L15:
        this.mOldData = null;
        if (r0 == false) goto L44;
        endBatchedUpdates();
        return;
    L44:
        return;
    L12:
        int r14 = r2 - r3;
        System.arraycopy(r8, r3, this.mData, r3, r14);
        this.mNewDataStart += r14;
        this.mSize += r14;
        this.mCallback.onInserted(r3, r14);
        goto L15
    L9:
        if (this.mOldDataStart >= this.mOldDataSize) goto L15;
        goto L10
    }

    private void replaceAllRemove() {
        this.mSize--;
        this.mOldDataStart++;
        this.mCallback.onRemoved(this.mNewDataStart, 1);
    }

    private int sortAndDedup(@NonNull T[] r8) {
        if (r8.length != 0) goto L5;
        return 0;
    L5:
        Arrays.sort(r8, this.mCallback);
        int r0 = 1;
        int r2 = 0;
        int r1 = 1;
    L7:
        if (r0 >= r8.length) goto L20;
        T r3 = r8[r0];
        if (this.mCallback.compare(r8[r2], r3) != 0) goto L16;
        int r4 = findSameItem(r3, r8, r2, r1);
        if (r4 == (-1)) goto L13;
        r8[r4] = r3;
    L19:
        r0 = r0 + 1;
        goto L7
    L13:
        if (r1 == r0) goto L15;
        r8[r1] = r3;
    L15:
        r1 = r1 + 1;
        goto L19
    L16:
        if (r1 == r0) goto L18;
        r8[r1] = r3;
    L18:
        r2 = r1;
        r1 = r1 + 1;
        goto L19
    L20:
        return r1;
    }

    private void throwIfInMutationOperation() {
        if (this.mOldData != null) goto L6;
        return;
    L6:
        throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
    }

    public int add(T r2) {
        throwIfInMutationOperation();
        return add(r2, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(@NonNull Collection<T> r3) {
        addAll(r3.toArray((Object[]) Array.newInstance(this.mTClass, r3.size())), true);
    }

    public void addAll(@NonNull T... r2) {
        addAll(r2, false);
    }

    public void addAll(@NonNull T[] r2, boolean r3) {
        throwIfInMutationOperation();
        if (r2.length != 0) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
        addAllInternal(r2);
        return;
    L7:
        addAllInternal(copyArray(r2));
    }

    public void beginBatchedUpdates() {
        throwIfInMutationOperation();
        Callback r0 = this.mCallback;
        if ((r0 instanceof BatchedCallback) == false) goto L6;
        return;
    L6:
        if (this.mBatchedCallback != null) goto L8;
        this.mBatchedCallback = new BatchedCallback(r0);
    L8:
        this.mCallback = this.mBatchedCallback;
    }

    public void clear() {
        throwIfInMutationOperation();
        int r0 = this.mSize;
        if (r0 != 0) goto L5;
        return;
    L5:
        Arrays.fill(this.mData, 0, r0, null);
        this.mSize = 0;
        this.mCallback.onRemoved(0, r0);
    }

    public void endBatchedUpdates() {
        throwIfInMutationOperation();
        Callback r0 = this.mCallback;
        if ((r0 instanceof BatchedCallback) == false) goto L5;
        ((BatchedCallback) r0).dispatchLastEvent();
    L5:
        Callback r1 = this.mCallback;
        BatchedCallback r2 = this.mBatchedCallback;
        if (r1 != r2) goto L9;
        this.mCallback = r2.mWrappedCallback;
        return;
    }

    public T get(int r4) {
        if (r4 >= this.mSize) goto L14;
        if (r4 < 0) goto L14;
        T[] r0 = this.mOldData;
        if (r0 == null) goto L12;
        int r1 = this.mNewDataStart;
        if (r4 < r1) goto L12;
        return r0[(r4 - r1) + this.mOldDataStart];
    L12:
        return this.mData[r4];
    L14:
        throw new IndexOutOfBoundsException("Asked to get item at " + r4 + " but size is " + this.mSize);
    }

    public int indexOf(T r9) {
        if (this.mOldData == null) goto L13;
        int r0 = findIndexOf(r9, this.mData, 0, this.mNewDataStart, 4);
        if (r0 == (-1)) goto L7;
        return r0;
    L7:
        int r10 = findIndexOf(r9, this.mOldData, this.mOldDataStart, this.mOldDataSize, 4);
        if (r10 != (-1)) goto L10;
        return -1;
    L10:
        return (r10 - this.mOldDataStart) + this.mNewDataStart;
    L13:
        return findIndexOf(r9, this.mData, 0, this.mSize, 4);
    }

    public void recalculatePositionOfItemAt(int r3) {
        throwIfInMutationOperation();
        T r0 = get(r3);
        removeItemAtIndex(r3, false);
        int r1 = add(r0, false);
        if (r3 == r1) goto L6;
        this.mCallback.onMoved(r3, r1);
        return;
    }

    public boolean remove(T r2) {
        throwIfInMutationOperation();
        return remove(r2, true);
    }

    public T removeItemAt(int r3) {
        throwIfInMutationOperation();
        T r0 = get(r3);
        removeItemAtIndex(r3, true);
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void replaceAll(@NonNull Collection<T> r3) {
        replaceAll(r3.toArray((Object[]) Array.newInstance(this.mTClass, r3.size())), true);
    }

    public void replaceAll(@NonNull T... r2) {
        replaceAll(r2, false);
    }

    public void replaceAll(@NonNull T[] r1, boolean r2) {
        throwIfInMutationOperation();
        if (r2 == false) goto L5;
        replaceAllInternal(r1);
        return;
    L5:
        replaceAllInternal(copyArray(r1));
    }

    public int size() {
        return this.mSize;
    }

    public void updateItemAt(int r6, T r7) {
        throwIfInMutationOperation();
        T r0 = get(r6);
        if (r0 != r7) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r0 != r7) goto L11;
    L16:
        if (r3 == false) goto L18;
        Callback r4 = this.mCallback;
        r4.onChanged(r6, 1, r4.getChangePayload(r0, r7));
    L18:
        removeItemAtIndex(r6, false);
        int r8 = add(r7, false);
        if (r6 == r8) goto L23;
        this.mCallback.onMoved(r6, r8);
        return;
    L23:
        return;
    L11:
        if (this.mCallback.compare(r0, r7) != 0) goto L16;
        this.mData[r6] = r7;
        if (r3 == false) goto L22;
        Callback r5 = this.mCallback;
        r5.onChanged(r6, 1, r5.getChangePayload(r0, r7));
        return;
    L22:
        return;
    L5:
        if (this.mCallback.areContentsTheSame(r0, r7) == false) goto L8;
        r3 = false;
        goto L9
    }
}
