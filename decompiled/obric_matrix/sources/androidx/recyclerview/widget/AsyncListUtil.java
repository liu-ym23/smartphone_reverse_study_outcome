package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;

/* JADX INFO: loaded from: classes.dex */
public class AsyncListUtil<T> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncListUtil";
    boolean mAllowScrollHints;
    private final ThreadUtil.BackgroundCallback<T> mBackgroundCallback;
    final ThreadUtil.BackgroundCallback<T> mBackgroundProxy;
    final DataCallback<T> mDataCallback;
    int mDisplayedGeneration;
    int mItemCount;
    private final ThreadUtil.MainThreadCallback<T> mMainThreadCallback;
    final ThreadUtil.MainThreadCallback<T> mMainThreadProxy;
    final SparseIntArray mMissingPositions;
    final int[] mPrevRange;
    int mRequestedGeneration;
    private int mScrollHint;
    final Class<T> mTClass;
    final TileList<T> mTileList;
    final int mTileSize;
    final int[] mTmpRange;
    final int[] mTmpRangeExtended;
    final ViewCallback mViewCallback;

    public static abstract class DataCallback<T> {
        public DataCallback() {
        }

        @WorkerThread
        public abstract void fillData(@NonNull T[] r1, int r2, int r3);

        @WorkerThread
        public int getMaxCachedTiles() {
            return 10;
        }

        @WorkerThread
        public void recycleData(@NonNull T[] r1, int r2) {
        }

        @WorkerThread
        public abstract int refreshData();
    }

    public static abstract class ViewCallback {
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE = 0;

        public ViewCallback() {
        }

        @UiThread
        public void extendRangeInto(@NonNull int[] r6, @NonNull int[] r7, int r8) {
            int r0 = (r6[1] - r6[0]) + 1;
            int r2 = r0 / 2;
            int r3 = r6[0];
            if (r8 != 1) goto L5;
            int r4 = r0;
        L6:
            r7[0] = r3 - r4;
            int r9 = r6[1];
            if (r8 == 2) goto L10;
            r0 = r2;
        L10:
            r7[1] = r9 + r0;
            return;
        L5:
            r4 = r2;
            goto L6
        }

        @UiThread
        public abstract void getItemRangeInto(@NonNull int[] r1);

        @UiThread
        public abstract void onDataRefresh();

        @UiThread
        public abstract void onItemLoaded(int r1);
    }

    public AsyncListUtil(@NonNull Class<T> r3, int r4, @NonNull DataCallback<T> r5, @NonNull ViewCallback r6) {
        this.mTmpRange = new int[2];
        this.mPrevRange = new int[2];
        this.mTmpRangeExtended = new int[2];
        this.mScrollHint = 0;
        this.mItemCount = 0;
        this.mDisplayedGeneration = 0;
        this.mRequestedGeneration = 0;
        this.mMissingPositions = new SparseIntArray();
        ThreadUtil.MainThreadCallback<T> r0 = new AnonymousClass1(this);
        this.mMainThreadCallback = r0;
        ThreadUtil.BackgroundCallback<T> r1 = new AnonymousClass2(this);
        this.mBackgroundCallback = r1;
        this.mTClass = r3;
        this.mTileSize = r4;
        this.mDataCallback = r5;
        this.mViewCallback = r6;
        this.mTileList = new TileList(r4);
        MessageThreadUtil r7 = new MessageThreadUtil();
        this.mMainThreadProxy = r7.getMainThreadProxy(r0);
        this.mBackgroundProxy = r7.getBackgroundProxy(r1);
        refresh();
    }

    private boolean isRefreshPending() {
        if (this.mRequestedGeneration == this.mDisplayedGeneration) goto L5;
        return true;
    L5:
        return false;
    }

    @Nullable
    public T getItem(int r3) {
        if (r3 < 0) goto L12;
        if (r3 >= this.mItemCount) goto L12;
        T r0 = this.mTileList.getItemAt(r3);
        if (r0 == null) goto L8;
    L10:
        return r0;
    L8:
        if (isRefreshPending() == true) goto L10;
        this.mMissingPositions.put(r3, 0);
    L12:
        throw new IndexOutOfBoundsException(r3 + " is not within 0 and " + this.mItemCount);
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    void log(String r2, Object... r3) {
        Log.d(TAG, "[MAIN] " + String.format(r2, r3));
    }

    public void onRangeChanged() {
        if (isRefreshPending() == false) goto L5;
        return;
    L5:
        updateRange();
        this.mAllowScrollHints = true;
    }

    public void refresh() {
        this.mMissingPositions.clear();
        ThreadUtil.BackgroundCallback<T> r0 = this.mBackgroundProxy;
        int r1 = this.mRequestedGeneration + 1;
        this.mRequestedGeneration = r1;
        r0.refresh(r1);
    }

    void updateRange() {
        this.mViewCallback.getItemRangeInto(this.mTmpRange);
        int[] r0 = this.mTmpRange;
        if (r0[0] <= r0[1]) goto L5;
        return;
    L5:
        if (r0[0] >= 0) goto L8;
        return;
    L8:
        if (r0[1] < this.mItemCount) goto L11;
        return;
    L11:
        if (this.mAllowScrollHints == true) goto L13;
    L12:
        this.mScrollHint = 0;
    L24:
        int[] r2 = this.mPrevRange;
        r2[0] = r0[0];
        r2[1] = r0[1];
        this.mViewCallback.extendRangeInto(r0, this.mTmpRangeExtended, this.mScrollHint);
        int[] r1 = this.mTmpRangeExtended;
        r1[0] = Math.min(this.mTmpRange[0], Math.max(r1[0], 0));
        int[] r3 = this.mTmpRangeExtended;
        r3[1] = Math.max(this.mTmpRange[1], Math.min(r3[1], this.mItemCount - 1));
        ThreadUtil.BackgroundCallback<T> r4 = this.mBackgroundProxy;
        int[] r5 = this.mTmpRange;
        int r6 = r5[0];
        int r7 = r5[1];
        int[] r8 = this.mTmpRangeExtended;
        r4.updateRange(r6, r7, r8[0], r8[1], this.mScrollHint);
        return;
    L13:
        int r9 = r0[0];
        int[] r10 = this.mPrevRange;
        if (r9 > r10[1]) goto L12;
        if (r10[0] > r0[1]) goto L12;
        if (r0[0] >= r10[0]) goto L22;
        this.mScrollHint = 1;
        goto L24
    L22:
        if (r0[0] <= r10[0]) goto L24;
        this.mScrollHint = 2;
        goto L24
    }
}
