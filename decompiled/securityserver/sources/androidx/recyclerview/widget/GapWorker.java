package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import androidx.core.os.TraceCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class GapWorker implements Runnable {
    static final ThreadLocal<GapWorker> sGapWorker = null;
    static Comparator<Task> sTaskComparator;
    long mFrameIntervalNs;
    long mPostTimeNs;
    ArrayList<RecyclerView> mRecyclerViews;
    private ArrayList<Task> mTasks;

    @SuppressLint({"VisibleForTests"})
    public static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {
        int mCount;
        int[] mPrefetchArray;
        int mPrefetchDx;
        int mPrefetchDy;

        public LayoutPrefetchRegistryImpl() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry
        public void addPosition(int r6, int r7) {
            if (r6 < 0) goto L15;
            if (r7 < 0) goto L13;
            int r0 = this.mCount;
            int r1 = r0 * 2;
            int[] r2 = this.mPrefetchArray;
            if (r2 != null) goto L8;
            int[] r3 = new int[4];
            this.mPrefetchArray = r3;
            Arrays.fill(r3, -1);
        L10:
            int[] r4 = this.mPrefetchArray;
            r4[r1] = r6;
            r4[r1 + 1] = r7;
            this.mCount++;
            return;
        L8:
            if (r1 < r2.length) goto L10;
            int[] r5 = new int[r0 * 4];
            this.mPrefetchArray = r5;
            System.arraycopy(r2, 0, r5, 0, r2.length);
            goto L10
        L13:
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        L15:
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }

        public void clearPrefetchPositions() {
            int[] r0 = this.mPrefetchArray;
            if (r0 == null) goto L5;
            Arrays.fill(r0, -1);
        L5:
            this.mCount = 0;
        }

        public void collectPrefetchPositionsFromView(RecyclerView r5, boolean r6) {
            this.mCount = 0;
            int[] r0 = this.mPrefetchArray;
            if (r0 == null) goto L5;
            Arrays.fill(r0, -1);
        L5:
            RecyclerView.LayoutManager r1 = r5.mLayout;
            if (r5.mAdapter == null) goto L21;
            if (r1 != null) goto L9;
            return;
        L9:
            if (r1.isItemPrefetchEnabled() == false) goto L23;
            if (r6 == false) goto L15;
            if (r5.mAdapterHelper.hasPendingUpdates() == true) goto L17;
            r1.collectInitialPrefetchPositions(r5.mAdapter.getItemCount(), this);
        L17:
            int r4 = this.mCount;
            if (r4 <= r1.mPrefetchMaxCountObserved) goto L24;
            r1.mPrefetchMaxCountObserved = r4;
            r1.mPrefetchMaxObservedInInitialPrefetch = r6;
            r5.mRecycler.updateViewCacheSize();
            return;
        L24:
            return;
        L15:
            if (r5.hasPendingAdapterUpdates() == true) goto L17;
            r1.collectAdjacentPrefetchPositions(this.mPrefetchDx, this.mPrefetchDy, r5.mState, this);
            goto L17
        L23:
            return;
        }

        public boolean lastPrefetchIncludedPosition(int r5) {
            if (this.mPrefetchArray == null) goto L11;
            int r0 = this.mCount * 2;
            int r2 = 0;
        L5:
            if (r2 >= r0) goto L11;
            if (this.mPrefetchArray[r2] == r5) goto L8;
            r2 = r2 + 2;
            goto L5
        L8:
            return true;
        L11:
            return false;
        }

        public void setPrefetchVector(int r1, int r2) {
            this.mPrefetchDx = r1;
            this.mPrefetchDy = r2;
        }
    }

    public static class Task {
        public int distanceToItem;
        public boolean immediate;
        public int position;
        public RecyclerView view;
        public int viewVelocity;

        public Task() {
        }

        public void clear() {
            this.immediate = false;
            this.viewVelocity = 0;
            this.distanceToItem = 0;
            this.view = null;
            this.position = 0;
        }
    }

    static {
        sGapWorker = new ThreadLocal();
        sTaskComparator = new AnonymousClass1();
    }

    public GapWorker() {
        this.mRecyclerViews = new ArrayList();
        this.mTasks = new ArrayList();
    }

    private void buildTaskList() {
        int r0 = this.mRecyclerViews.size();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L8;
        RecyclerView r4 = this.mRecyclerViews.get(r2);
        if (r4.getWindowVisibility() != 0) goto L7;
        r4.mPrefetchRegistry.collectPrefetchPositionsFromView(r4, false);
        r3 = r3 + r4.mPrefetchRegistry.mCount;
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        this.mTasks.ensureCapacity(r3);
        int r5 = 0;
        int r6 = 0;
    L9:
        if (r5 >= r0) goto L26;
        RecyclerView r7 = this.mRecyclerViews.get(r5);
        if (r7.getWindowVisibility() != 0) goto L25;
        LayoutPrefetchRegistryImpl r8 = r7.mPrefetchRegistry;
        int r9 = Math.abs(r8.mPrefetchDy) + Math.abs(r8.mPrefetchDx);
        int r10 = 0;
    L15:
        if (r10 >= (r8.mCount * 2)) goto L25;
        if (r6 < this.mTasks.size()) goto L19;
        Task r11 = new Task();
        this.mTasks.add(r11);
    L20:
        int[] r12 = r8.mPrefetchArray;
        int r13 = r12[r10 + 1];
        if (r13 > r9) goto L23;
        boolean r14 = true;
    L24:
        r11.immediate = r14;
        r11.viewVelocity = r9;
        r11.distanceToItem = r13;
        r11.view = r7;
        r11.position = r12[r10];
        r6 = r6 + 1;
        r10 = r10 + 2;
        goto L15
    L23:
        r14 = false;
        goto L24
    L19:
        r11 = this.mTasks.get(r6);
    L25:
        r5 = r5 + 1;
        goto L9
    L26:
        Collections.sort(this.mTasks, sTaskComparator);
    }

    private void flushTaskWithDeadline(Task r4, long r5) {
        if (r4.immediate == false) goto L5;
        long r0 = Long.MAX_VALUE;
    L6:
        RecyclerView.ViewHolder r6 = prefetchPositionWithDeadline(r4.view, r4.position, r0);
        if (r6 != null) goto L9;
        return;
    L9:
        if (r6.mNestedRecyclerView != null) goto L11;
        return;
    L11:
        if (r6.isBound() == true) goto L13;
        return;
    L13:
        if (r6.isInvalid() == true) goto L19;
        prefetchInnerRecyclerViewWithDeadline(r6.mNestedRecyclerView.get(), r5);
        return;
    L19:
        return;
    L5:
        r0 = r5;
        goto L6
    }

    private void flushTasksWithDeadline(long r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.mTasks.size()) goto L9;
        Task r1 = this.mTasks.get(r0);
        if (r1.view == null) goto L12;
        flushTaskWithDeadline(r1, r4);
        r1.clear();
        r0 = r0 + 1;
        goto L4
    L12:
        return;
    }

    public static boolean isPrefetchPositionAttached(RecyclerView r5, int r6) {
        int r0 = r5.mChildHelper.getUnfilteredChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        RecyclerView.ViewHolder r3 = RecyclerView.getChildViewHolderInt(r5.mChildHelper.getUnfilteredChildAt(r2));
        if (r3.mPosition != r6) goto L10;
        if (r3.isInvalid() == true) goto L10;
        return true;
    L10:
        r2 = r2 + 1;
        goto L3
    L11:
        return false;
    }

    private void prefetchInnerRecyclerViewWithDeadline(@Nullable RecyclerView r4, long r5) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.mDataSetHasChangedAfterLayout == true) goto L7;
    L9:
        LayoutPrefetchRegistryImpl r0 = r4.mPrefetchRegistry;
        r0.collectPrefetchPositionsFromView(r4, true);
        if (r0.mCount != 0) goto L22;
        return;
    L22:
        TraceCompat.beginSection("RV Nested Prefetch");     // Catch: Throwable -> L16
        r4.mState.prepareForNestedPrefetch(r4.mAdapter);     // Catch: Throwable -> L16
        int r1 = 0;
    L13:
        if (r1 >= (r0.mCount * 2)) goto L18;
        prefetchPositionWithDeadline(r4, r0.mPrefetchArray[r1], r5);     // Catch: Throwable -> L16
        r1 = r1 + 2;
        goto L13
    L18:
        TraceCompat.endSection();
        return;
    L16:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    L7:
        if (r4.mChildHelper.getUnfilteredChildCount() == 0) goto L9;
        r4.removeAndRecycleViews();
        goto L9
    }

    private RecyclerView.ViewHolder prefetchPositionWithDeadline(RecyclerView r2, int r3, long r4) {
        if (isPrefetchPositionAttached(r2, r3) == false) goto L6;
        return null;
    L6:
        RecyclerView.Recycler r1 = r2.mRecycler;
        r2.onEnterLayoutOrScroll();     // Catch: Throwable -> L14
        RecyclerView.ViewHolder r5 = r1.tryGetViewHolderForPositionByDeadline(r3, false, r4);     // Catch: Throwable -> L14
        if (r5 != null) goto L10;
    L17:
        r2.onExitLayoutOrScroll(false);
        return r5;
    L10:
        if (r5.isBound() == true) goto L12;
    L16:
        r1.addViewHolderToRecycledViewPool(r5, false);     // Catch: Throwable -> L14
        goto L17
    L12:
        if (r5.isInvalid() == true) goto L16;
        r1.recycleView(r5.itemView);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r2.onExitLayoutOrScroll(false);
        throw th;
    }

    public void add(RecyclerView r1) {
        this.mRecyclerViews.add(r1);
    }

    public void postFromTraversal(RecyclerView r5, int r6, int r7) {
        if (r5.isAttachedToWindow() == true) goto L5;
    L7:
        r5.mPrefetchRegistry.setPrefetchVector(r6, r7);
        return;
    L5:
        if (this.mPostTimeNs != 0) goto L7;
        this.mPostTimeNs = r5.getNanoTime();
        r5.post(this);
        goto L7
    }

    public void prefetch(long r1) {
        buildTaskList();
        flushTasksWithDeadline(r1);
    }

    public void remove(RecyclerView r1) {
        this.mRecyclerViews.remove(r1);
    }

    @Override // java.lang.Runnable
    public void run() {
        TraceCompat.beginSection("RV Prefetch");     // Catch: Throwable -> L12
        if (this.mRecyclerViews.isEmpty() == false) goto L7;
    L5:
        this.mPostTimeNs = 0;
        TraceCompat.endSection();
        return;
    L7:
        int r2 = this.mRecyclerViews.size();     // Catch: Throwable -> L12
        int r3 = 0;
        long r4 = 0;
    L8:
        if (r3 >= r2) goto L16;
        RecyclerView r6 = this.mRecyclerViews.get(r3);     // Catch: Throwable -> L12
        if (r6.getWindowVisibility() != 0) goto L14;
        r4 = Math.max(r6.getDrawingTime(), r4);     // Catch: Throwable -> L12
    L14:
        r3 = r3 + 1;     // Catch: Throwable -> L12
        goto L8
    L16:
        if (r4 == 0) goto L5;
        prefetch(TimeUnit.MILLISECONDS.toNanos(r4) + this.mFrameIntervalNs);     // Catch: Throwable -> L12
        this.mPostTimeNs = 0;
        TraceCompat.endSection();
        return;
    L12:
        th = move-exception;
        this.mPostTimeNs = 0;
        TraceCompat.endSection();
        throw th;
    }
}
