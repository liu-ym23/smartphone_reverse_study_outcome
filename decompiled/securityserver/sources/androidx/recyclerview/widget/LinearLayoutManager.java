package androidx.recyclerview.widget;

import a.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.fragment.app.FragmentTransaction;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler, RecyclerView.SmoothScroller.ScrollVectorProvider {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final AnchorInfo mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final LayoutChunkResult mLayoutChunkResult;
    private LayoutState mLayoutState;
    int mOrientation;
    OrientationHelper mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    public static class AnchorInfo {
        int mCoordinate;
        boolean mLayoutFromEnd;
        OrientationHelper mOrientationHelper;
        int mPosition;
        boolean mValid;

        public AnchorInfo() {
            reset();
        }

        public void assignCoordinateFromPadding() {
            if (this.mLayoutFromEnd == false) goto L5;
            int r0 = this.mOrientationHelper.getEndAfterPadding();
        L6:
            this.mCoordinate = r0;
            return;
        L5:
            r0 = this.mOrientationHelper.getStartAfterPadding();
            goto L6
        }

        public void assignFromView(View r2, int r3) {
            if (this.mLayoutFromEnd == false) goto L5;
            int r4 = this.mOrientationHelper.getDecoratedEnd(r2);
            this.mCoordinate = this.mOrientationHelper.getTotalSpaceChange() + r4;
        L6:
            this.mPosition = r3;
            return;
        L5:
            this.mCoordinate = this.mOrientationHelper.getDecoratedStart(r2);
            goto L6
        }

        public void assignFromViewAndKeepVisibleRect(View r5, int r6) {
            int r0 = this.mOrientationHelper.getTotalSpaceChange();
            if (r0 < 0) goto L6;
            assignFromView(r5, r6);
            return;
        L6:
            this.mPosition = r6;
            if (this.mLayoutFromEnd == false) goto L13;
            int r7 = (this.mOrientationHelper.getEndAfterPadding() - r0) - this.mOrientationHelper.getDecoratedEnd(r5);
            this.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - r7;
            if (r7 <= 0) goto L19;
            int r2 = this.mCoordinate - this.mOrientationHelper.getDecoratedMeasurement(r5);
            int r1 = this.mOrientationHelper.getStartAfterPadding();
            int r3 = r2 - (Math.min(this.mOrientationHelper.getDecoratedStart(r5) - r1, 0) + r1);
            if (r3 >= 0) goto L20;
            this.mCoordinate = Math.min(r7, -r3) + this.mCoordinate;
            return;
        L20:
            return;
        L19:
            return;
        L13:
            int r8 = this.mOrientationHelper.getDecoratedStart(r5);
            int r4 = r8 - this.mOrientationHelper.getStartAfterPadding();
            this.mCoordinate = r8;
            if (r4 <= 0) goto L22;
            int r9 = (this.mOrientationHelper.getEndAfterPadding() - Math.min(0, (this.mOrientationHelper.getEndAfterPadding() - r0) - this.mOrientationHelper.getDecoratedEnd(r5))) - (this.mOrientationHelper.getDecoratedMeasurement(r5) + r8);
            if (r9 >= 0) goto L23;
            this.mCoordinate -= Math.min(r4, -r9);
            return;
        L23:
            return;
        }

        public boolean isViewValidAsAnchor(View r1, RecyclerView.State r2) {
            RecyclerView.LayoutParams r0 = (RecyclerView.LayoutParams) r1.getLayoutParams();
            if (r0.isItemRemoved() == false) goto L5;
        L9:
            return false;
        L5:
            if (r0.getViewLayoutPosition() < 0) goto L9;
            if (r0.getViewLayoutPosition() >= r2.getItemCount()) goto L9;
            return true;
        }

        public void reset() {
            this.mPosition = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mLayoutFromEnd = false;
            this.mValid = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.mCoordinate + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + '}';
        }
    }

    public static class LayoutChunkResult {
        public int mConsumed;
        public boolean mFinished;
        public boolean mFocusable;
        public boolean mIgnoreConsumed;

        public LayoutChunkResult() {
        }

        public void resetInternal() {
            this.mConsumed = 0;
            this.mFinished = false;
            this.mIgnoreConsumed = false;
            this.mFocusable = false;
        }
    }

    public static class LayoutState {
        static final int INVALID_LAYOUT = Integer.MIN_VALUE;
        static final int ITEM_DIRECTION_HEAD = -1;
        static final int ITEM_DIRECTION_TAIL = 1;
        static final int LAYOUT_END = 1;
        static final int LAYOUT_START = -1;
        static final int SCROLLING_OFFSET_NaN = Integer.MIN_VALUE;
        static final String TAG = "LLM#LayoutState";
        int mAvailable;
        int mCurrentPosition;
        int mExtraFillSpace;
        boolean mInfinite;
        boolean mIsPreLayout;
        int mItemDirection;
        int mLastScrollDelta;
        int mLayoutDirection;
        int mNoRecycleSpace;
        int mOffset;
        boolean mRecycle;
        List<RecyclerView.ViewHolder> mScrapList;
        int mScrollingOffset;

        public LayoutState() {
            this.mRecycle = true;
            this.mExtraFillSpace = 0;
            this.mNoRecycleSpace = 0;
            this.mIsPreLayout = false;
            this.mScrapList = null;
        }

        private View nextViewFromScrapList() {
            int r0 = this.mScrapList.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L12;
            View r2 = this.mScrapList.get(r1).itemView;
            RecyclerView.LayoutParams r3 = (RecyclerView.LayoutParams) r2.getLayoutParams();
            if (r3.isItemRemoved() == true) goto L11;
            if (this.mCurrentPosition != r3.getViewLayoutPosition()) goto L11;
            assignPositionFromScrapList(r2);
            return r2;
        L11:
            r1 = r1 + 1;
            goto L3
        L12:
            return null;
        }

        public void assignPositionFromScrapList() {
            assignPositionFromScrapList(null);
        }

        public boolean hasMore(RecyclerView.State r1) {
            int r0 = this.mCurrentPosition;
            if (r0 >= 0) goto L5;
        L7:
            return false;
        L5:
            if (r0 >= r1.getItemCount()) goto L7;
            return true;
        }

        public void log() {
            Log.d(TAG, "avail:" + this.mAvailable + ", ind:" + this.mCurrentPosition + ", dir:" + this.mItemDirection + ", offset:" + this.mOffset + ", layoutDir:" + this.mLayoutDirection);
        }

        public View next(RecyclerView.Recycler r3) {
            if (this.mScrapList != null) goto L5;
            View r4 = r3.getViewForPosition(this.mCurrentPosition);
            this.mCurrentPosition += this.mItemDirection;
            return r4;
        L5:
            return nextViewFromScrapList();
        }

        public View nextViewInLimitedList(View r8) {
            int r0 = this.mScrapList.size();
            View r1 = null;
            int r2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int r3 = 0;
        L3:
            if (r3 >= r0) goto L18;
            View r4 = this.mScrapList.get(r3).itemView;
            RecyclerView.LayoutParams r5 = (RecyclerView.LayoutParams) r4.getLayoutParams();
            if (r4 == r8) goto L17;
            if (r5.isItemRemoved() == true) goto L17;
            int r6 = (r5.getViewLayoutPosition() - this.mCurrentPosition) * this.mItemDirection;
            if (r6 < 0) goto L17;
            if (r6 >= r2) goto L17;
            r1 = r4;
            if (r6 == 0) goto L18;
            r2 = r6;
        L17:
            r3 = r3 + 1;
        L18:
            return r1;
        }

        public void assignPositionFromScrapList(View r1) {
            View r2 = nextViewInLimitedList(r1);
            if (r2 != null) goto L5;
            this.mCurrentPosition = -1;
            return;
        L5:
            this.mCurrentPosition = ((RecyclerView.LayoutParams) r2.getLayoutParams()).getViewLayoutPosition();
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean mAnchorLayoutFromEnd;
        int mAnchorOffset;
        int mAnchorPosition;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean hasValidAnchor() {
            if (this.mAnchorPosition < 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeInt(this.mAnchorPosition);
            r1.writeInt(this.mAnchorOffset);
            r1.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
        }

        public SavedState(Parcel r2) {
            this.mAnchorPosition = r2.readInt();
            this.mAnchorOffset = r2.readInt();
            boolean r0 = true;
            if (r2.readInt() == 1) goto L6;
            r0 = false;
        L6:
            this.mAnchorLayoutFromEnd = r0;
        }

        public SavedState(SavedState r2) {
            this.mAnchorPosition = r2.mAnchorPosition;
            this.mAnchorOffset = r2.mAnchorOffset;
            this.mAnchorLayoutFromEnd = r2.mAnchorLayoutFromEnd;
        }
    }

    public LinearLayoutManager(Context r3) {
        this(r3, 1, false);
    }

    private int computeScrollExtent(RecyclerView.State r7) {
        if (getChildCount() != 0) goto L6;
        return 0;
    L6:
        ensureLayoutState();
        return ScrollbarHelper.computeScrollExtent(r7, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.State r8) {
        if (getChildCount() != 0) goto L6;
        return 0;
    L6:
        ensureLayoutState();
        return ScrollbarHelper.computeScrollOffset(r8, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.State r7) {
        if (getChildCount() != 0) goto L6;
        return 0;
    L6:
        ensureLayoutState();
        return ScrollbarHelper.computeScrollRange(r7, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findFirstReferenceChild(RecyclerView.Recycler r7, RecyclerView.State r8) {
        return findReferenceChild(r7, r8, 0, getChildCount(), r8.getItemCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    private View findLastReferenceChild(RecyclerView.Recycler r8, RecyclerView.State r9) {
        return findReferenceChild(r8, r9, getChildCount() - 1, -1, r9.getItemCount());
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        if (this.mShouldReverseLayout == false) goto L6;
        return findFirstPartiallyOrCompletelyInvisibleChild();
    L6:
        return findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        if (this.mShouldReverseLayout == false) goto L6;
        return findLastPartiallyOrCompletelyInvisibleChild();
    L6:
        return findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private View findReferenceChildClosestToEnd(RecyclerView.Recycler r2, RecyclerView.State r3) {
        if (this.mShouldReverseLayout == false) goto L6;
        return findFirstReferenceChild(r2, r3);
    L6:
        return findLastReferenceChild(r2, r3);
    }

    private View findReferenceChildClosestToStart(RecyclerView.Recycler r2, RecyclerView.State r3) {
        if (this.mShouldReverseLayout == false) goto L6;
        return findLastReferenceChild(r2, r3);
    L6:
        return findFirstReferenceChild(r2, r3);
    }

    private int fixLayoutEndGap(int r2, RecyclerView.Recycler r3, RecyclerView.State r4, boolean r5) {
        int r0 = this.mOrientationHelper.getEndAfterPadding() - r2;
        if (r0 <= 0) goto L11;
        int r6 = -scrollBy(-r0, r3, r4);
        int r7 = r2 + r6;
        if (r5 == false) goto L10;
        int r8 = this.mOrientationHelper.getEndAfterPadding() - r7;
        if (r8 <= 0) goto L10;
        this.mOrientationHelper.offsetChildren(r8);
        return r8 + r6;
    L10:
        return r6;
    L11:
        return 0;
    }

    private int fixLayoutStartGap(int r2, RecyclerView.Recycler r3, RecyclerView.State r4, boolean r5) {
        int r0 = r2 - this.mOrientationHelper.getStartAfterPadding();
        if (r0 <= 0) goto L10;
        int r6 = -scrollBy(r0, r3, r4);
        int r7 = r2 + r6;
        if (r5 == false) goto L12;
        int r8 = r7 - this.mOrientationHelper.getStartAfterPadding();
        if (r8 <= 0) goto L13;
        this.mOrientationHelper.offsetChildren(-r8);
        return r6 - r8;
    L13:
        return r6;
    L12:
        return r6;
    L10:
        return 0;
    }

    private View getChildClosestToEnd() {
        if (this.mShouldReverseLayout == false) goto L5;
        int r0 = 0;
    L7:
        return getChildAt(r0);
    L5:
        r0 = getChildCount() - 1;
        goto L7
    }

    private View getChildClosestToStart() {
        if (this.mShouldReverseLayout == false) goto L5;
        int r0 = getChildCount() - 1;
    L7:
        return getChildAt(r0);
    L5:
        r0 = 0;
        goto L7
    }

    private void layoutForPredictiveAnimations(RecyclerView.Recycler r11, RecyclerView.State r12, int r13, int r14) {
        if (r12.willRunPredictiveAnimations() == true) goto L5;
        return;
    L5:
        if (getChildCount() != 0) goto L7;
        return;
    L7:
        if (r12.isPreLayout() == false) goto L9;
        return;
    L9:
        if (supportsPredictiveItemAnimations() == false) goto L39;
        List<RecyclerView.ViewHolder> r0 = r11.getScrapList();
        int r1 = r0.size();
        int r3 = getPosition(getChildAt(0));
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L12:
        if (r4 >= r1) goto L25;
        RecyclerView.ViewHolder r7 = r0.get(r4);
        if (r7.isRemoved() == true) goto L24;
        if (r7.getLayoutPosition() >= r3) goto L19;
        boolean r8 = true;
    L21:
        if (r8 == this.mShouldReverseLayout) goto L23;
        r5 = r5 + this.mOrientationHelper.getDecoratedMeasurement(r7.itemView);
        goto L24
    L23:
        r6 = r6 + this.mOrientationHelper.getDecoratedMeasurement(r7.itemView);
        goto L24
    L19:
        r8 = false;
    L24:
        r4 = r4 + 1;
        goto L12
    L25:
        this.mLayoutState.mScrapList = r0;
        if (r5 <= 0) goto L28;
        updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), r13);
        LayoutState r15 = this.mLayoutState;
        r15.mExtraFillSpace = r5;
        r15.mAvailable = 0;
        r15.assignPositionFromScrapList();
        fill(r11, this.mLayoutState, r12, false);
    L28:
        if (r6 <= 0) goto L30;
        updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), r14);
        LayoutState r16 = this.mLayoutState;
        r16.mExtraFillSpace = r6;
        r16.mAvailable = 0;
        r16.assignPositionFromScrapList();
        fill(r11, this.mLayoutState, r12, false);
    L30:
        this.mLayoutState.mScrapList = null;
        return;
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        int r0 = 0;
    L4:
        if (r0 >= getChildCount()) goto L6;
        View r2 = getChildAt(r0);
        Log.d(TAG, "item " + getPosition(r2) + ", coord:" + this.mOrientationHelper.getDecoratedStart(r2));
        r0 = r0 + 1;
        goto L4
    L6:
        Log.d(TAG, "==============");
    }

    private void recycleByLayoutState(RecyclerView.Recycler r4, LayoutState r5) {
        if (r5.mRecycle == true) goto L5;
        return;
    L5:
        if (r5.mInfinite == true) goto L14;
        int r0 = r5.mScrollingOffset;
        int r1 = r5.mNoRecycleSpace;
        if (r5.mLayoutDirection != (-1)) goto L10;
        recycleViewsFromEnd(r4, r0, r1);
        return;
    L10:
        recycleViewsFromStart(r4, r0, r1);
        return;
    }

    private void recycleChildren(RecyclerView.Recycler r1, int r2, int r3) {
        if (r2 != r3) goto L4;
        return;
    L4:
        if (r3 <= r2) goto L8;
        int r4 = r3 - 1;
    L6:
        if (r4 < r2) goto L10;
        removeAndRecycleViewAt(r4, r1);
        r4 = r4 - 1;
        goto L6
    L10:
        return;
    L8:
        if (r2 <= r3) goto L13;
        removeAndRecycleViewAt(r2, r1);
        r2 = r2 - 1;
        goto L8
    }

    private void recycleViewsFromEnd(RecyclerView.Recycler r5, int r6, int r7) {
        int r0 = getChildCount();
        if (r6 >= 0) goto L5;
        return;
    L5:
        int r1 = (this.mOrientationHelper.getEnd() - r6) + r7;
        if (this.mShouldReverseLayout == false) goto L17;
        int r8 = 0;
    L8:
        if (r8 >= r0) goto L33;
        View r2 = getChildAt(r8);
        if (this.mOrientationHelper.getDecoratedStart(r2) < r1) goto L15;
        if (this.mOrientationHelper.getTransformedStartWithDecoration(r2) < r1) goto L15;
        r8 = r8 + 1;
    L15:
        recycleChildren(r5, 0, r8);
        return;
    L33:
        return;
    L17:
        int r3 = r0 - 1;
        int r9 = r3;
    L18:
        if (r9 < 0) goto L34;
        View r10 = getChildAt(r9);
        if (this.mOrientationHelper.getDecoratedStart(r10) < r1) goto L25;
        if (this.mOrientationHelper.getTransformedStartWithDecoration(r10) < r1) goto L25;
        r9 = r9 - 1;
    L25:
        recycleChildren(r5, r3, r9);
        return;
    }

    private void recycleViewsFromStart(RecyclerView.Recycler r5, int r6, int r7) {
        if (r6 >= 0) goto L4;
        return;
    L4:
        int r8 = r6 - r7;
        int r9 = getChildCount();
        if (this.mShouldReverseLayout == false) goto L16;
        int r10 = r9 - 1;
        int r0 = r10;
    L7:
        if (r0 < 0) goto L32;
        View r1 = getChildAt(r0);
        if (this.mOrientationHelper.getDecoratedEnd(r1) > r8) goto L14;
        if (this.mOrientationHelper.getTransformedEndWithDecoration(r1) > r8) goto L14;
        r0 = r0 - 1;
    L14:
        recycleChildren(r5, r10, r0);
        return;
    L32:
        return;
    L16:
        int r2 = 0;
    L17:
        if (r2 >= r9) goto L33;
        View r3 = getChildAt(r2);
        if (this.mOrientationHelper.getDecoratedEnd(r3) > r8) goto L24;
        if (this.mOrientationHelper.getTransformedEndWithDecoration(r3) > r8) goto L24;
        r2 = r2 + 1;
    L24:
        recycleChildren(r5, 0, r2);
        return;
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation != 1) goto L5;
    L8:
        this.mShouldReverseLayout = this.mReverseLayout;
        return;
    L5:
        if (isLayoutRTL() == false) goto L8;
        this.mShouldReverseLayout = !this.mReverseLayout;
    }

    private boolean updateAnchorFromChildren(RecyclerView.Recycler r5, RecyclerView.State r6, AnchorInfo r7) {
        if (getChildCount() != 0) goto L5;
        return false;
    L5:
        View r0 = getFocusedChild();
        if (r0 == null) goto L12;
        if (r7.isViewValidAsAnchor(r0, r6) == false) goto L12;
        r7.assignFromViewAndKeepVisibleRect(r0, getPosition(r0));
        return true;
    L12:
        if (this.mLastStackFromEnd == this.mStackFromEnd) goto L15;
        return false;
    L15:
        if (r7.mLayoutFromEnd == false) goto L17;
        View r8 = findReferenceChildClosestToEnd(r5, r6);
    L18:
        if (r8 == null) goto L33;
        r7.assignFromView(r8, getPosition(r8));
        if (r6.isPreLayout() == false) goto L22;
    L32:
        return true;
    L22:
        if (supportsPredictiveItemAnimations() == false) goto L32;
        if (this.mOrientationHelper.getDecoratedStart(r8) >= this.mOrientationHelper.getEndAfterPadding()) goto L28;
        if (this.mOrientationHelper.getDecoratedEnd(r8) >= this.mOrientationHelper.getStartAfterPadding()) goto L32;
    L28:
        if (r7.mLayoutFromEnd == false) goto L30;
        int r4 = this.mOrientationHelper.getEndAfterPadding();
    L31:
        r7.mCoordinate = r4;
        goto L32
    L30:
        r4 = this.mOrientationHelper.getStartAfterPadding();
        goto L31
    L33:
        return false;
    L17:
        r8 = findReferenceChildClosestToStart(r5, r6);
        goto L18
    }

    private boolean updateAnchorFromPendingData(RecyclerView.State r5, AnchorInfo r6) {
        boolean r1 = false;
        if (r5.isPreLayout() == true) goto L60;
        int r0 = this.mPendingScrollPosition;
        if (r0 == (-1)) goto L60;
        if (r0 >= 0) goto L10;
    L59:
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        goto L60
    L10:
        if (r0 >= r5.getItemCount()) goto L59;
        r6.mPosition = this.mPendingScrollPosition;
        SavedState r7 = this.mPendingSavedState;
        if (r7 == null) goto L22;
        if (r7.hasValidAnchor() == false) goto L22;
        boolean r8 = this.mPendingSavedState.mAnchorLayoutFromEnd;
        r6.mLayoutFromEnd = r8;
        if (r8 == false) goto L19;
        r6.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset;
    L20:
        return true;
    L19:
        r6.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset;
    L22:
        if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) goto L54;
        View r9 = findViewByPosition(this.mPendingScrollPosition);
        if (r9 == null) goto L43;
        if (this.mOrientationHelper.getDecoratedMeasurement(r9) <= this.mOrientationHelper.getTotalSpace()) goto L30;
        r6.assignCoordinateFromPadding();
        return true;
    L30:
        if ((this.mOrientationHelper.getDecoratedStart(r9) - this.mOrientationHelper.getStartAfterPadding()) >= 0) goto L34;
        r6.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
        r6.mLayoutFromEnd = false;
        return true;
    L34:
        if ((this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(r9)) >= 0) goto L38;
        r6.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
        r6.mLayoutFromEnd = true;
        return true;
    L38:
        if (r6.mLayoutFromEnd == false) goto L40;
        int r4 = this.mOrientationHelper.getTotalSpaceChange() + this.mOrientationHelper.getDecoratedEnd(r9);
    L41:
        r6.mCoordinate = r4;
    L53:
        return true;
    L40:
        r4 = this.mOrientationHelper.getDecoratedStart(r9);
        goto L41
    L43:
        if (getChildCount() > 0) goto L45;
    L52:
        r6.assignCoordinateFromPadding();
        goto L53
    L45:
        if (this.mPendingScrollPosition >= getPosition(getChildAt(0))) goto L47;
        boolean r10 = true;
    L49:
        if (r10 != this.mShouldReverseLayout) goto L51;
        r1 = true;
    L51:
        r6.mLayoutFromEnd = r1;
        goto L52
    L47:
        r10 = false;
        goto L49
    L54:
        boolean r11 = this.mShouldReverseLayout;
        r6.mLayoutFromEnd = r11;
        if (r11 == false) goto L57;
        r6.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset;
    L58:
        return true;
    L57:
        r6.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
    L60:
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView.Recycler r2, RecyclerView.State r3, AnchorInfo r4) {
        if (updateAnchorFromPendingData(r3, r4) == false) goto L6;
        return;
    L6:
        if (updateAnchorFromChildren(r2, r3, r4) == false) goto L8;
        return;
    L8:
        r4.assignCoordinateFromPadding();
        if (this.mStackFromEnd == false) goto L11;
        int r1 = r3.getItemCount() - 1;
    L12:
        r4.mPosition = r1;
        return;
    L11:
        r1 = 0;
        goto L12
    }

    private void updateLayoutState(int r5, int r6, boolean r7, RecyclerView.State r8) {
        this.mLayoutState.mInfinite = resolveIsInfinite();
        this.mLayoutState.mLayoutDirection = r5;
        int[] r0 = this.mReusableIntPair;
        boolean r1 = false;
        r0[0] = 0;
        int r2 = 1;
        r0[1] = 0;
        calculateExtraLayoutSpace(r8, r0);
        int r9 = Math.max(0, this.mReusableIntPair[0]);
        int r3 = Math.max(0, this.mReusableIntPair[1]);
        if (r5 != 1) goto L5;
        r1 = true;
    L5:
        LayoutState r10 = this.mLayoutState;
        if (r1 == false) goto L8;
        int r4 = r3;
    L9:
        r10.mExtraFillSpace = r4;
        if (r1 == true) goto L13;
        r9 = r3;
    L13:
        r10.mNoRecycleSpace = r9;
        if (r1 == false) goto L19;
        r10.mExtraFillSpace = this.mOrientationHelper.getEndPadding() + r4;
        View r11 = getChildClosestToEnd();
        LayoutState r12 = this.mLayoutState;
        if (this.mShouldReverseLayout == false) goto L18;
        r2 = -1;
    L18:
        r12.mItemDirection = r2;
        int r13 = getPosition(r11);
        LayoutState r14 = this.mLayoutState;
        r12.mCurrentPosition = r13 + r14.mItemDirection;
        r14.mOffset = this.mOrientationHelper.getDecoratedEnd(r11);
        int r15 = this.mOrientationHelper.getDecoratedEnd(r11) - this.mOrientationHelper.getEndAfterPadding();
    L24:
        LayoutState r16 = this.mLayoutState;
        r16.mAvailable = r6;
        if (r7 == false) goto L27;
        r16.mAvailable = r6 - r15;
    L27:
        r16.mScrollingOffset = r15;
        return;
    L19:
        View r17 = getChildClosestToStart();
        LayoutState r18 = this.mLayoutState;
        r18.mExtraFillSpace = this.mOrientationHelper.getStartAfterPadding() + r18.mExtraFillSpace;
        LayoutState r19 = this.mLayoutState;
        if (this.mShouldReverseLayout == true) goto L23;
        r2 = -1;
    L23:
        r19.mItemDirection = r2;
        int r20 = getPosition(r17);
        LayoutState r21 = this.mLayoutState;
        r19.mCurrentPosition = r20 + r21.mItemDirection;
        r21.mOffset = this.mOrientationHelper.getDecoratedStart(r17);
        r15 = (-this.mOrientationHelper.getDecoratedStart(r17)) + this.mOrientationHelper.getStartAfterPadding();
        goto L24
    L8:
        r4 = r9;
        goto L9
    }

    private void updateLayoutStateToFillEnd(AnchorInfo r2) {
        updateLayoutStateToFillEnd(r2.mPosition, r2.mCoordinate);
    }

    private void updateLayoutStateToFillStart(AnchorInfo r2) {
        updateLayoutStateToFillStart(r2.mPosition, r2.mCoordinate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String r2) {
        if (this.mPendingSavedState != null) goto L6;
        super.assertNotInLayoutOrScroll(r2);
        return;
    }

    public void calculateExtraLayoutSpace(@NonNull RecyclerView.State r3, @NonNull int[] r4) {
        int r5 = getExtraLayoutSpace(r3);
        if (this.mLayoutState.mLayoutDirection != (-1)) goto L5;
        int r2 = 0;
    L6:
        r4[0] = r5;
        r4[1] = r2;
        return;
    L5:
        r2 = r5;
        r5 = 0;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.mOrientation != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.mOrientation == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectAdjacentPrefetchPositions(int r2, int r3, RecyclerView.State r4, RecyclerView.LayoutManager.LayoutPrefetchRegistry r5) {
        if (this.mOrientation == 0) goto L7;
        r2 = r3;
    L7:
        if (getChildCount() == 0) goto L16;
        if (r2 == 0) goto L17;
        ensureLayoutState();
        if (r2 <= 0) goto L13;
        int r0 = 1;
    L14:
        updateLayoutState(r0, Math.abs(r2), true, r4);
        collectPrefetchPositionsForLayoutState(r4, this.mLayoutState, r5);
        return;
    L13:
        r0 = -1;
        goto L14
    L17:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectInitialPrefetchPositions(int r6, RecyclerView.LayoutManager.LayoutPrefetchRegistry r7) {
        SavedState r0 = this.mPendingSavedState;
        int r1 = -1;
        if (r0 != null) goto L5;
    L7:
        resolveShouldLayoutReverse();
        boolean r3 = this.mShouldReverseLayout;
        int r2 = this.mPendingScrollPosition;
        if (r2 != (-1)) goto L12;
        if (r3 == false) goto L11;
        r2 = r6 - 1;
        goto L12
    L11:
        r2 = 0;
    L12:
        if (r3 == true) goto L15;
        r1 = 1;
    L15:
        int r4 = 0;
    L17:
        if (r4 >= this.mInitialPrefetchItemCount) goto L21;
        if (r2 < 0) goto L25;
        if (r2 >= r6) goto L26;
        r7.addPosition(r2, 0);
        r2 = r2 + r1;
        r4 = r4 + 1;
        goto L17
    L26:
        return;
    L25:
        return;
    L21:
        return;
    L5:
        if (r0.hasValidAnchor() == false) goto L7;
        SavedState r5 = this.mPendingSavedState;
        r3 = r5.mAnchorLayoutFromEnd;
        r2 = r5.mAnchorPosition;
        goto L12
    }

    public void collectPrefetchPositionsForLayoutState(RecyclerView.State r1, LayoutState r2, RecyclerView.LayoutManager.LayoutPrefetchRegistry r3) {
        int r0 = r2.mCurrentPosition;
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (r0 >= r1.getItemCount()) goto L9;
        r3.addPosition(r0, Math.max(0, r2.mScrollingOffset));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State r1) {
        return computeScrollExtent(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State r1) {
        return computeScrollOffset(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State r1) {
        return computeScrollRange(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int r4) {
        if (getChildCount() != 0) goto L6;
        return null;
    L6:
        boolean r0 = false;
        int r2 = 1;
        if (r4 >= getPosition(getChildAt(0))) goto L10;
        r0 = true;
    L10:
        if (r0 == this.mShouldReverseLayout) goto L13;
        r2 = -1;
    L13:
        if (this.mOrientation != 0) goto L17;
        return new PointF(r2, 0.0f);
    L17:
        return new PointF(0.0f, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State r1) {
        return computeScrollExtent(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State r1) {
        return computeScrollOffset(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State r1) {
        return computeScrollRange(r1);
    }

    public int convertFocusDirectionToLayoutDirection(int r5) {
        if (r5 == 1) goto L43;
        if (r5 == 2) goto L36;
        if (r5 == 17) goto L31;
        if (r5 == 33) goto L26;
        if (r5 == 66) goto L21;
        if (r5 == 130) goto L16;
        return Integer.MIN_VALUE;
    L16:
        if (this.mOrientation != 1) goto L19;
        return 1;
    L19:
        return Integer.MIN_VALUE;
    L21:
        if (this.mOrientation != 0) goto L24;
        return 1;
    L24:
        return Integer.MIN_VALUE;
    L26:
        if (this.mOrientation != 1) goto L29;
        return -1;
    L29:
        return Integer.MIN_VALUE;
    L31:
        if (this.mOrientation != 0) goto L34;
        return -1;
    L34:
        return Integer.MIN_VALUE;
    L36:
        if (this.mOrientation != 1) goto L39;
        return 1;
    L39:
        if (isLayoutRTL() == false) goto L41;
        return -1;
    L41:
        return 1;
    L43:
        if (this.mOrientation != 1) goto L46;
        return -1;
    L46:
        if (isLayoutRTL() == false) goto L48;
        return 1;
    L48:
        return -1;
    }

    public LayoutState createLayoutState() {
        return new LayoutState();
    }

    public void ensureLayoutState() {
        if (this.mLayoutState != null) goto L6;
        this.mLayoutState = createLayoutState();
        return;
    }

    public int fill(RecyclerView.Recycler r8, LayoutState r9, RecyclerView.State r10, boolean r11) {
        int r0 = r9.mAvailable;
        int r1 = r9.mScrollingOffset;
        if (r1 == Integer.MIN_VALUE) goto L7;
        if (r0 >= 0) goto L6;
        r9.mScrollingOffset = r1 + r0;
    L6:
        recycleByLayoutState(r8, r9);
    L7:
        int r2 = r9.mAvailable + r9.mExtraFillSpace;
        LayoutChunkResult r3 = this.mLayoutChunkResult;
    L9:
        if (r9.mInfinite == true) goto L12;
        if (r2 > 0) goto L12;
    L33:
        return r0 - r9.mAvailable;
    L12:
        if (r9.hasMore(r10) == false) goto L33;
        r3.resetInternal();
        layoutChunk(r8, r10, r9, r3);
        if (r3.mFinished == true) goto L33;
        int r4 = r9.mOffset;
        r9.mOffset = (r3.mConsumed * r9.mLayoutDirection) + r4;
        if (r3.mIgnoreConsumed == true) goto L19;
    L22:
        int r5 = r9.mAvailable;
        int r6 = r3.mConsumed;
        r9.mAvailable = r5 - r6;
        r2 = r2 - r6;
    L23:
        int r7 = r9.mScrollingOffset;
        if (r7 == Integer.MIN_VALUE) goto L29;
        int r12 = r7 + r3.mConsumed;
        r9.mScrollingOffset = r12;
        int r13 = r9.mAvailable;
        if (r13 >= 0) goto L28;
        r9.mScrollingOffset = r12 + r13;
    L28:
        recycleByLayoutState(r8, r9);
    L29:
        if (r11 == false) goto L9;
        if (r3.mFocusable == false) goto L9;
    L19:
        if (r9.mScrapList != null) goto L22;
        if (r10.isPreLayout() == true) goto L23;
        goto L22
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View r0 = findOneVisibleChild(0, getChildCount(), true, false);
        if (r0 != null) goto L6;
        return -1;
    L6:
        return getPosition(r0);
    }

    public View findFirstVisibleChildClosestToEnd(boolean r3, boolean r4) {
        if (this.mShouldReverseLayout == false) goto L7;
        return findOneVisibleChild(0, getChildCount(), r3, r4);
    L7:
        return findOneVisibleChild(getChildCount() - 1, -1, r3, r4);
    }

    public View findFirstVisibleChildClosestToStart(boolean r3, boolean r4) {
        if (this.mShouldReverseLayout == false) goto L7;
        return findOneVisibleChild(getChildCount() - 1, -1, r3, r4);
    L7:
        return findOneVisibleChild(0, getChildCount(), r3, r4);
    }

    public int findFirstVisibleItemPosition() {
        View r0 = findOneVisibleChild(0, getChildCount(), false, true);
        if (r0 != null) goto L6;
        return -1;
    L6:
        return getPosition(r0);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View r0 = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (r0 != null) goto L6;
        return -1;
    L6:
        return getPosition(r0);
    }

    public int findLastVisibleItemPosition() {
        View r0 = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (r0 != null) goto L6;
        return -1;
    L6:
        return getPosition(r0);
    }

    public View findOnePartiallyOrCompletelyInvisibleChild(int r4, int r5) {
        ensureLayoutState();
        if (r5 > r4) goto L7;
        if (r5 < r4) goto L7;
        return getChildAt(r4);
    L7:
        if (this.mOrientationHelper.getDecoratedStart(getChildAt(r4)) >= this.mOrientationHelper.getStartAfterPadding()) goto L9;
        int r0 = 16644;
        int r1 = 16388;
    L11:
        if (this.mOrientation != 0) goto L14;
        return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(r4, r5, r0, r1);
    L14:
        return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(r4, r5, r0, r1);
    L9:
        r0 = 4161;
        r1 = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        goto L11
    }

    public View findOneVisibleChild(int r2, int r3, boolean r4, boolean r5) {
        ensureLayoutState();
        int r0 = 320;
        if (r4 == false) goto L5;
        int r6 = 24579;
    L6:
        if (r5 == true) goto L10;
        r0 = 0;
    L10:
        if (this.mOrientation != 0) goto L13;
        return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(r2, r3, r6, r0);
    L13:
        return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(r2, r3, r6, r0);
    L5:
        r6 = 320;
        goto L6
    }

    public View findReferenceChild(RecyclerView.Recycler r6, RecyclerView.State r7, int r8, int r9, int r10) {
        ensureLayoutState();
        int r11 = this.mOrientationHelper.getStartAfterPadding();
        int r12 = this.mOrientationHelper.getEndAfterPadding();
        if (r9 <= r8) goto L5;
        int r0 = 1;
    L6:
        View r1 = null;
        View r2 = null;
    L7:
        if (r8 == r9) goto L24;
        View r3 = getChildAt(r8);
        int r4 = getPosition(r3);
        if (r4 < 0) goto L23;
        if (r4 >= r10) goto L23;
        if (((RecyclerView.LayoutParams) r3.getLayoutParams()).isItemRemoved() == false) goto L16;
        if (r2 != null) goto L23;
        r2 = r3;
        goto L23
    L16:
        if (this.mOrientationHelper.getDecoratedStart(r3) < r12) goto L18;
    L21:
        if (r1 != null) goto L23;
        r1 = r3;
        goto L23
    L18:
        if (this.mOrientationHelper.getDecoratedEnd(r3) < r11) goto L21;
        return r3;
    L23:
        r8 = r8 + r0;
        goto L7
    L24:
        if (r1 == null) goto L27;
        return r1;
    L27:
        return r2;
    L5:
        r0 = -1;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View findViewByPosition(int r3) {
        int r0 = getChildCount();
        if (r0 != 0) goto L6;
        return null;
    L6:
        int r1 = r3 - getPosition(getChildAt(0));
        if (r1 < 0) goto L13;
        if (r1 >= r0) goto L13;
        View r2 = getChildAt(r1);
        if (getPosition(r2) != r3) goto L13;
        return r2;
    L13:
        return super.findViewByPosition(r3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.State r1) {
        if (r1.hasTargetScrollPosition() == true) goto L5;
        return 0;
    L5:
        return this.mOrientationHelper.getTotalSpace();
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    public void layoutChunk(RecyclerView.Recycler r8, RecyclerView.State r9, LayoutState r10, LayoutChunkResult r11) {
        View r12 = r10.next(r8);
        if (r12 != null) goto L6;
        r11.mFinished = true;
        return;
    L6:
        RecyclerView.LayoutParams r6 = (RecyclerView.LayoutParams) r12.getLayoutParams();
        if (r10.mScrapList != null) goto L15;
        boolean r0 = this.mShouldReverseLayout;
        if (r10.mLayoutDirection != (-1)) goto L11;
        boolean r3 = true;
    L12:
        if (r0 != r3) goto L14;
        addView(r12);
    L22:
        measureChildWithMargins(r12, 0, 0);
        r11.mConsumed = this.mOrientationHelper.getDecoratedMeasurement(r12);
        if (this.mOrientation == 1) goto L25;
        int r1 = getPaddingTop();
        int r2 = this.mOrientationHelper.getDecoratedMeasurementInOther(r12) + r1;
        if (r10.mLayoutDirection != (-1)) goto L35;
        int r13 = r10.mOffset;
        int r4 = r13;
        int r5 = r1;
        int r7 = r2;
        int r14 = r13 - r11.mConsumed;
    L36:
        layoutDecoratedWithMargins(r12, r14, r5, r4, r7);
        if (r6.isItemRemoved() == false) goto L39;
    L40:
        r11.mIgnoreConsumed = true;
    L41:
        r11.mFocusable = r12.hasFocusable();
        return;
    L39:
        if (r6.isItemChanged() == false) goto L41;
    L35:
        int r15 = r10.mOffset;
        r5 = r1;
        r4 = r11.mConsumed + r15;
        r7 = r2;
        r14 = r15;
        goto L36
    L25:
        if (isLayoutRTL() == false) goto L27;
        int r16 = getWidth() - getPaddingRight();
        r14 = r16 - this.mOrientationHelper.getDecoratedMeasurementInOther(r12);
    L29:
        if (r10.mLayoutDirection != (-1)) goto L31;
        int r17 = r10.mOffset;
        r7 = r17;
        r4 = r16;
        r5 = r17 - r11.mConsumed;
        goto L36
    L31:
        int r18 = r10.mOffset;
        r5 = r18;
        r4 = r16;
        r7 = r11.mConsumed + r18;
        goto L36
    L27:
        r14 = getPaddingLeft();
        r16 = this.mOrientationHelper.getDecoratedMeasurementInOther(r12) + r14;
        goto L29
    L14:
        addView(r12, 0);
        goto L22
    L11:
        r3 = false;
        goto L12
    L15:
        boolean r19 = this.mShouldReverseLayout;
        if (r10.mLayoutDirection != (-1)) goto L18;
        boolean r20 = true;
    L19:
        if (r19 != r20) goto L21;
        addDisappearingView(r12);
        goto L22
    L21:
        addDisappearingView(r12, 0);
        goto L22
    L18:
        r20 = false;
        goto L19
    }

    public void onAnchorReady(RecyclerView.Recycler r1, RecyclerView.State r2, AnchorInfo r3, int r4) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView r1, RecyclerView.Recycler r2) {
        super.onDetachedFromWindow(r1, r2);
        if (this.mRecycleChildrenOnDetach == false) goto L6;
        removeAndRecycleAllViews(r2);
        r2.clear();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View r4, int r5, RecyclerView.Recycler r6, RecyclerView.State r7) {
        resolveShouldLayoutReverse();
        if (getChildCount() != 0) goto L5;
        return null;
    L5:
        int r8 = convertFocusDirectionToLayoutDirection(r5);
        if (r8 != Integer.MIN_VALUE) goto L8;
        return null;
    L8:
        ensureLayoutState();
        updateLayoutState(r8, (int) (this.mOrientationHelper.getTotalSpace() * MAX_SCROLL_FACTOR), false, r7);
        LayoutState r1 = this.mLayoutState;
        r1.mScrollingOffset = Integer.MIN_VALUE;
        r1.mRecycle = false;
        fill(r6, r1, r7, true);
        if (r8 != (-1)) goto L11;
        View r9 = findPartiallyOrCompletelyInvisibleChildClosestToStart();
    L12:
        if (r8 != (-1)) goto L14;
        View r3 = getChildClosestToStart();
    L16:
        if (r3.hasFocusable() == false) goto L20;
        if (r9 != null) goto L19;
        return null;
    L19:
        return r3;
    L20:
        return r9;
    L14:
        r3 = getChildClosestToEnd();
        goto L16
    L11:
        r9 = findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        goto L12
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent r2) {
        super.onInitializeAccessibilityEvent(r2);
        if (getChildCount() <= 0) goto L6;
        r2.setFromIndex(findFirstVisibleItemPosition());
        r2.setToIndex(findLastVisibleItemPosition());
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler r9, RecyclerView.State r10) {
        int r1 = -1;
        if (this.mPendingSavedState != null) goto L7;
        if (this.mPendingScrollPosition != (-1)) goto L7;
    L10:
        SavedState r0 = this.mPendingSavedState;
        if (r0 != null) goto L13;
    L15:
        ensureLayoutState();
        this.mLayoutState.mRecycle = false;
        resolveShouldLayoutReverse();
        View r2 = getFocusedChild();
        AnchorInfo r3 = this.mAnchorInfo;
        if (r3.mValid == true) goto L18;
    L28:
        r3.reset();
        AnchorInfo r4 = this.mAnchorInfo;
        r4.mLayoutFromEnd = this.mShouldReverseLayout ^ this.mStackFromEnd;
        updateAnchorInfoForLayout(r9, r10, r4);
        this.mAnchorInfo.mValid = true;
    L29:
        LayoutState r5 = this.mLayoutState;
        if (r5.mLastScrollDelta < 0) goto L32;
        int r6 = 1;
    L33:
        r5.mLayoutDirection = r6;
        int[] r7 = this.mReusableIntPair;
        r7[0] = 0;
        r7[1] = 0;
        calculateExtraLayoutSpace(r10, r7);
        int r8 = this.mOrientationHelper.getStartAfterPadding() + Math.max(0, this.mReusableIntPair[0]);
        int r11 = this.mOrientationHelper.getEndPadding() + Math.max(0, this.mReusableIntPair[1]);
        if (r10.isPreLayout() == false) goto L49;
        int r12 = this.mPendingScrollPosition;
        if (r12 == (-1)) goto L49;
        if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) goto L49;
        View r13 = findViewByPosition(r12);
        if (r13 == null) goto L49;
        if (this.mShouldReverseLayout == false) goto L45;
        int r14 = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(r13);
        int r15 = this.mPendingScrollPositionOffset;
    L44:
        int r16 = r14 - r15;
        if (r16 <= 0) goto L48;
        r8 = r8 + r16;
        goto L49
    L48:
        r11 = r11 - r16;
        goto L49
    L45:
        r15 = this.mOrientationHelper.getDecoratedStart(r13) - this.mOrientationHelper.getStartAfterPadding();
        r14 = this.mPendingScrollPositionOffset;
    L49:
        AnchorInfo r17 = this.mAnchorInfo;
        if (r17.mLayoutFromEnd == false) goto L55;
        if (this.mShouldReverseLayout == false) goto L56;
    L53:
        r1 = 1;
    L56:
        onAnchorReady(r9, r10, r17, r1);
        detachAndScrapAttachedViews(r9);
        this.mLayoutState.mInfinite = resolveIsInfinite();
        this.mLayoutState.mIsPreLayout = r10.isPreLayout();
        this.mLayoutState.mNoRecycleSpace = 0;
        AnchorInfo r18 = this.mAnchorInfo;
        if (r18.mLayoutFromEnd == false) goto L64;
        updateLayoutStateToFillStart(r18);
        LayoutState r19 = this.mLayoutState;
        r19.mExtraFillSpace = r8;
        fill(r9, r19, r10, false);
        LayoutState r20 = this.mLayoutState;
        int r21 = r20.mOffset;
        int r22 = r20.mCurrentPosition;
        int r23 = r20.mAvailable;
        if (r23 <= 0) goto L61;
        r11 = r11 + r23;
    L61:
        updateLayoutStateToFillEnd(this.mAnchorInfo);
        LayoutState r24 = this.mLayoutState;
        r24.mExtraFillSpace = r11;
        r24.mCurrentPosition += r24.mItemDirection;
        fill(r9, r24, r10, false);
        LayoutState r25 = this.mLayoutState;
        int r26 = r25.mOffset;
        int r27 = r25.mAvailable;
        if (r27 <= 0) goto L72;
        updateLayoutStateToFillStart(r22, r21);
        LayoutState r28 = this.mLayoutState;
        r28.mExtraFillSpace = r27;
        fill(r9, r28, r10, false);
        r21 = this.mLayoutState.mOffset;
    L72:
        if (getChildCount() > 0) goto L74;
    L78:
        layoutForPredictiveAnimations(r9, r10, r21, r26);
        if (r10.isPreLayout() == true) goto L81;
        this.mOrientationHelper.onLayoutComplete();
    L82:
        this.mLastStackFromEnd = this.mStackFromEnd;
        return;
    L81:
        this.mAnchorInfo.reset();
        goto L82
    L74:
        if ((this.mShouldReverseLayout ^ this.mStackFromEnd) == false) goto L77;
        int r29 = fixLayoutEndGap(r26, r9, r10, true);
        int r30 = r21 + r29;
        int r31 = r26 + r29;
        int r32 = fixLayoutStartGap(r30, r9, r10, false);
    L76:
        r21 = r30 + r32;
        r26 = r31 + r32;
        goto L78
    L77:
        int r33 = fixLayoutStartGap(r21, r9, r10, true);
        r30 = r21 + r33;
        r31 = r26 + r33;
        r32 = fixLayoutEndGap(r31, r9, r10, false);
        goto L76
    L64:
        updateLayoutStateToFillEnd(r18);
        LayoutState r34 = this.mLayoutState;
        r34.mExtraFillSpace = r11;
        fill(r9, r34, r10, false);
        LayoutState r35 = this.mLayoutState;
        r26 = r35.mOffset;
        int r36 = r35.mCurrentPosition;
        int r37 = r35.mAvailable;
        if (r37 <= 0) goto L67;
        r8 = r8 + r37;
    L67:
        updateLayoutStateToFillStart(this.mAnchorInfo);
        LayoutState r38 = this.mLayoutState;
        r38.mExtraFillSpace = r8;
        r38.mCurrentPosition += r38.mItemDirection;
        fill(r9, r38, r10, false);
        LayoutState r39 = this.mLayoutState;
        int r40 = r39.mOffset;
        int r41 = r39.mAvailable;
        if (r41 <= 0) goto L70;
        updateLayoutStateToFillEnd(r36, r26);
        LayoutState r42 = this.mLayoutState;
        r42.mExtraFillSpace = r41;
        fill(r9, r42, r10, false);
        r26 = this.mLayoutState.mOffset;
    L70:
        r21 = r40;
        goto L72
    L55:
        if (this.mShouldReverseLayout == false) goto L53;
    L32:
        r6 = -1;
        goto L33
    L18:
        if (this.mPendingScrollPosition != (-1)) goto L28;
        if (this.mPendingSavedState != null) goto L28;
        if (r2 == null) goto L29;
        if (this.mOrientationHelper.getDecoratedStart(r2) < this.mOrientationHelper.getEndAfterPadding()) goto L26;
    L27:
        this.mAnchorInfo.assignFromViewAndKeepVisibleRect(r2, getPosition(r2));
        goto L29
    L26:
        if (this.mOrientationHelper.getDecoratedEnd(r2) > this.mOrientationHelper.getStartAfterPadding()) goto L29;
    L13:
        if (r0.hasValidAnchor() == false) goto L15;
        this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
    L7:
        if (r10.getItemCount() != 0) goto L10;
        removeAndRecycleAllViews(r9);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State r1) {
        super.onLayoutCompleted(r1);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.reset();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable r2) {
        if ((r2 instanceof SavedState) == false) goto L6;
        this.mPendingSavedState = (SavedState) r2;
        requestLayout();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) goto L5;
        SavedState r0 = new SavedState();
        if (getChildCount() <= 0) goto L12;
        ensureLayoutState();
        boolean r1 = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
        r0.mAnchorLayoutFromEnd = r1;
        if (r1 == false) goto L11;
        View r2 = getChildClosestToEnd();
        r0.mAnchorOffset = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(r2);
        r0.mAnchorPosition = getPosition(r2);
    L13:
        return r0;
    L11:
        View r3 = getChildClosestToStart();
        r0.mAnchorPosition = getPosition(r3);
        r0.mAnchorOffset = this.mOrientationHelper.getDecoratedStart(r3) - this.mOrientationHelper.getStartAfterPadding();
        goto L13
    L12:
        r0.invalidateAnchor();
        goto L13
    L5:
        return new SavedState(this.mPendingSavedState);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.ViewDropHandler
    public void prepareForDrop(@NonNull View r4, @NonNull View r5, int r6, int r7) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int r8 = getPosition(r4);
        int r9 = getPosition(r5);
        if (r8 >= r9) goto L5;
        byte r10 = 1;
    L7:
        if (this.mShouldReverseLayout == false) goto L11;
        if (r10 != 1) goto L10;
        scrollToPositionWithOffset(r9, this.mOrientationHelper.getEndAfterPadding() - (this.mOrientationHelper.getDecoratedMeasurement(r4) + this.mOrientationHelper.getDecoratedStart(r5)));
        return;
    L10:
        scrollToPositionWithOffset(r9, this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(r5));
        return;
    L11:
        if (r10 != (-1)) goto L13;
        scrollToPositionWithOffset(r9, this.mOrientationHelper.getDecoratedStart(r5));
        return;
    L13:
        scrollToPositionWithOffset(r9, this.mOrientationHelper.getDecoratedEnd(r5) - this.mOrientationHelper.getDecoratedMeasurement(r4));
        return;
    L5:
        r10 = -1;
        goto L7
    }

    public boolean resolveIsInfinite() {
        if (this.mOrientationHelper.getMode() == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.mOrientationHelper.getEnd() != 0) goto L7;
        return true;
    }

    public int scrollBy(int r6, RecyclerView.Recycler r7, RecyclerView.State r8) {
        if (getChildCount() == 0) goto L17;
        if (r6 == 0) goto L17;
        ensureLayoutState();
        this.mLayoutState.mRecycle = true;
        if (r6 <= 0) goto L9;
        int r0 = 1;
    L10:
        int r3 = Math.abs(r6);
        updateLayoutState(r0, r3, true, r8);
        LayoutState r2 = this.mLayoutState;
        int r9 = fill(r7, r2, r8, false) + r2.mScrollingOffset;
        if (r9 >= 0) goto L13;
        return 0;
    L13:
        if (r3 <= r9) goto L15;
        r6 = r0 * r9;
    L15:
        this.mOrientationHelper.offsetChildren(-r6);
        this.mLayoutState.mLastScrollDelta = r6;
        return r6;
    L9:
        r0 = -1;
    L17:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int r3, RecyclerView.Recycler r4, RecyclerView.State r5) {
        if (this.mOrientation != 1) goto L7;
        return 0;
    L7:
        return scrollBy(r3, r4, r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int r1) {
        this.mPendingScrollPosition = r1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState r2 = this.mPendingSavedState;
        if (r2 == null) goto L5;
        r2.invalidateAnchor();
    L5:
        requestLayout();
    }

    public void scrollToPositionWithOffset(int r1, int r2) {
        this.mPendingScrollPosition = r1;
        this.mPendingScrollPositionOffset = r2;
        SavedState r3 = this.mPendingSavedState;
        if (r3 == null) goto L5;
        r3.invalidateAnchor();
    L5:
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int r2, RecyclerView.Recycler r3, RecyclerView.State r4) {
        if (this.mOrientation != 0) goto L7;
        return 0;
    L7:
        return scrollBy(r2, r3, r4);
    }

    public void setInitialPrefetchItemCount(int r1) {
        this.mInitialPrefetchItemCount = r1;
    }

    public void setOrientation(int r3) {
        if (r3 != 0) goto L4;
    L8:
        assertNotInLayoutOrScroll(null);
        if (r3 == this.mOrientation) goto L11;
    L12:
        OrientationHelper r0 = OrientationHelper.createOrientationHelper(this, r3);
        this.mOrientationHelper = r0;
        this.mAnchorInfo.mOrientationHelper = r0;
        this.mOrientation = r3;
        requestLayout();
        return;
    L11:
        if (this.mOrientationHelper == null) goto L12;
        return;
    L4:
        if (r3 == 1) goto L8;
        throw new IllegalArgumentException(a.e(r3, "invalid orientation:"));
    }

    public void setRecycleChildrenOnDetach(boolean r1) {
        this.mRecycleChildrenOnDetach = r1;
    }

    public void setReverseLayout(boolean r2) {
        assertNotInLayoutOrScroll(null);
        if (r2 != this.mReverseLayout) goto L5;
        return;
    L5:
        this.mReverseLayout = r2;
        requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean r1) {
        this.mSmoothScrollbarEnabled = r1;
    }

    public void setStackFromEnd(boolean r2) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd != r2) goto L5;
        return;
    L5:
        this.mStackFromEnd = r2;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean shouldMeasureTwice() {
        if (getHeightMode() != 1073741824) goto L5;
    L9:
        return false;
    L5:
        if (getWidthMode() == 1073741824) goto L9;
        if (hasFlexibleChildInBothOrientations() == false) goto L9;
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView r1, RecyclerView.State r2, int r3) {
        LinearSmoothScroller r4 = new LinearSmoothScroller(r1.getContext());
        r4.setTargetPosition(r3);
        startSmoothScroll(r4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState == null) goto L5;
    L7:
        return false;
    L5:
        if (this.mLastStackFromEnd != this.mStackFromEnd) goto L7;
        return true;
    }

    public void validateChildOrder() {
        Log.d(TAG, "validating child count " + getChildCount());
        boolean r1 = true;
        if (getChildCount() >= 1) goto L5;
        return;
    L5:
        int r2 = getPosition(getChildAt(0));
        int r3 = this.mOrientationHelper.getDecoratedStart(getChildAt(0));
        if (this.mShouldReverseLayout == false) goto L22;
        int r4 = 1;
    L9:
        if (r4 >= getChildCount()) goto L37;
        View r7 = getChildAt(r4);
        int r8 = getPosition(r7);
        int r9 = this.mOrientationHelper.getDecoratedStart(r7);
        if (r8 < r2) goto L12;
        if (r9 > r3) goto L20;
        r4 = r4 + 1;
        goto L9
    L20:
        logChildren();
        throw new RuntimeException("detected invalid location");
    L12:
        logChildren();
        StringBuilder r5 = new StringBuilder("detected invalid position. loc invalid? ");
        if (r9 < r3) goto L16;
        r1 = false;
    L16:
        r5.append(r1);
        throw new RuntimeException(r5.toString());
    L37:
        return;
    L22:
        int r6 = 1;
    L24:
        if (r6 >= getChildCount()) goto L44;
        View r10 = getChildAt(r6);
        int r11 = getPosition(r10);
        int r12 = this.mOrientationHelper.getDecoratedStart(r10);
        if (r11 < r2) goto L27;
        if (r12 < r3) goto L35;
        r6 = r6 + 1;
        goto L24
    L35:
        logChildren();
        throw new RuntimeException("detected invalid location");
    L27:
        logChildren();
        StringBuilder r13 = new StringBuilder("detected invalid position. loc invalid? ");
        if (r12 < r3) goto L31;
        r1 = false;
    L31:
        r13.append(r1);
        throw new RuntimeException(r13.toString());
    }

    public LinearLayoutManager(Context r2, int r3, boolean r4) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(r3);
        setReverseLayout(r4);
    }

    private void updateLayoutStateToFillEnd(int r3, int r4) {
        this.mLayoutState.mAvailable = this.mOrientationHelper.getEndAfterPadding() - r4;
        LayoutState r0 = this.mLayoutState;
        if (this.mShouldReverseLayout == false) goto L5;
        int r2 = -1;
    L6:
        r0.mItemDirection = r2;
        r0.mCurrentPosition = r3;
        r0.mLayoutDirection = 1;
        r0.mOffset = r4;
        r0.mScrollingOffset = Integer.MIN_VALUE;
        return;
    L5:
        r2 = 1;
        goto L6
    }

    private void updateLayoutStateToFillStart(int r3, int r4) {
        this.mLayoutState.mAvailable = r4 - this.mOrientationHelper.getStartAfterPadding();
        LayoutState r0 = this.mLayoutState;
        r0.mCurrentPosition = r3;
        if (this.mShouldReverseLayout == false) goto L5;
        int r2 = 1;
    L6:
        r0.mItemDirection = r2;
        r0.mLayoutDirection = -1;
        r0.mOffset = r4;
        r0.mScrollingOffset = Integer.MIN_VALUE;
        return;
    L5:
        r2 = -1;
        goto L6
    }

    public LinearLayoutManager(Context r3, AttributeSet r4, int r5, int r6) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.LayoutManager.Properties r7 = RecyclerView.LayoutManager.getProperties(r3, r4, r5, r6);
        setOrientation(r7.orientation);
        setReverseLayout(r7.reverseLayout);
        setStackFromEnd(r7.stackFromEnd);
    }
}
