package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    static final boolean DEBUG = false;

    @Deprecated
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "StaggeredGridLManager";
    public static final int VERTICAL = 1;
    private final AnchorInfo mAnchorInfo;
    private final Runnable mCheckForGapsRunnable;
    private int mFullSizeSpec;
    private int mGapStrategy;
    private boolean mLaidOutInvalidFullSpan;
    private boolean mLastLayoutFromEnd;
    private boolean mLastLayoutRTL;
    private final LayoutState mLayoutState;
    LazySpanLookup mLazySpanLookup;
    private int mOrientation;
    private SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private int[] mPrefetchDistances;
    OrientationHelper mPrimaryOrientation;
    private BitSet mRemainingSpans;
    boolean mReverseLayout;
    OrientationHelper mSecondaryOrientation;
    boolean mShouldReverseLayout;
    private int mSizePerSpan;
    private boolean mSmoothScrollbarEnabled;
    private int mSpanCount;
    Span[] mSpans;
    private final Rect mTmpRect;

    class AnchorInfo {
        boolean mInvalidateOffsets;
        boolean mLayoutFromEnd;
        int mOffset;
        int mPosition;
        int[] mSpanReferenceLines;
        boolean mValid;
        final /* synthetic */ StaggeredGridLayoutManager this$0;

        AnchorInfo(StaggeredGridLayoutManager r1) {
            this.this$0 = r1;
            reset();
        }

        void reset() {
            this.mPosition = -1;
            this.mOffset = Integer.MIN_VALUE;
            this.mLayoutFromEnd = false;
            this.mInvalidateOffsets = false;
            this.mValid = false;
            int[] r2 = this.mSpanReferenceLines;
            if (r2 == null) goto L6;
            Arrays.fill(r2, -1);
            return;
        }

        void saveSpanReferenceLines(Span[] r6) {
            int r0 = r6.length;
            int[] r1 = this.mSpanReferenceLines;
            if (r1 != null) goto L5;
        L6:
            this.mSpanReferenceLines = new int[this.this$0.mSpans.length];
        L7:
            int r2 = 0;
        L8:
            if (r2 >= r0) goto L10;
            this.mSpanReferenceLines[r2] = r6[r2].getStartLine(Integer.MIN_VALUE);
            r2 = r2 + 1;
            goto L8
        L10:
            return;
        L5:
            if (r1.length >= r0) goto L7;
            goto L6
        }

        void assignCoordinateFromPadding() {
            if (this.mLayoutFromEnd == false) goto L5;
            int r0 = this.this$0.mPrimaryOrientation.getEndAfterPadding();
        L6:
            this.mOffset = r0;
            return;
        L5:
            r0 = this.this$0.mPrimaryOrientation.getStartAfterPadding();
            goto L6
        }

        void assignCoordinateFromPadding(int r2) {
            if (this.mLayoutFromEnd == false) goto L5;
            this.mOffset = this.this$0.mPrimaryOrientation.getEndAfterPadding() - r2;
            return;
        L5:
            this.mOffset = this.this$0.mPrimaryOrientation.getStartAfterPadding() + r2;
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        boolean mFullSpan;
        Span mSpan;

        public LayoutParams(Context r1, AttributeSet r2) {
            super(r1, r2);
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
        }

        public LayoutParams(RecyclerView.LayoutParams r1) {
            super(r1);
        }

        public void setFullSpan(boolean r1) {
            this.mFullSpan = r1;
        }

        public boolean isFullSpan() {
            return this.mFullSpan;
        }

        public final int getSpanIndex() {
            Span r0 = this.mSpan;
            if (r0 != null) goto L7;
            return -1;
        L7:
            return r0.mIndex;
        }
    }

    static class LazySpanLookup {
        private static final int MIN_SIZE = 10;
        int[] mData;
        List<FullSpanItem> mFullSpanItems;

        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = null;
            int mGapDir;
            int[] mGapPerSpan;
            boolean mHasUnwantedGapAfter;
            int mPosition;

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            FullSpanItem(Parcel r3) {
                this.mPosition = r3.readInt();
                this.mGapDir = r3.readInt();
                boolean r1 = true;
                if (r3.readInt() == 1) goto L6;
                r1 = false;
            L6:
                this.mHasUnwantedGapAfter = r1;
                int r0 = r3.readInt();
                if (r0 <= 0) goto L10;
                int[] r2 = new int[r0];
                this.mGapPerSpan = r2;
                r3.readIntArray(r2);
                return;
            }

            FullSpanItem() {
            }

            int getGapForSpan(int r1) {
                int[] r0 = this.mGapPerSpan;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0[r1];
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel r2, int r3) {
                r2.writeInt(this.mPosition);
                r2.writeInt(this.mGapDir);
                r2.writeInt(this.mHasUnwantedGapAfter ? 1 : 0);
                int[] r4 = this.mGapPerSpan;
                if (r4 != null) goto L5;
            L7:
                r2.writeInt(0);
                return;
            L5:
                if (r4.length <= 0) goto L7;
                r2.writeInt(r4.length);
                r2.writeIntArray(this.mGapPerSpan);
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.mGapDir + ", mHasUnwantedGapAfter=" + this.mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(this.mGapPerSpan) + '}';
            }

            static {
                CREATOR = new AnonymousClass1();
            }
        }

        LazySpanLookup() {
        }

        int forceInvalidateAfter(int r3) {
            List<FullSpanItem> r0 = this.mFullSpanItems;
            if (r0 == null) goto L11;
            int r1 = r0.size() - 1;
        L5:
            if (r1 < 0) goto L11;
            if (this.mFullSpanItems.get(r1).mPosition < r3) goto L9;
            this.mFullSpanItems.remove(r1);
        L9:
            r1 = r1 - 1;
        L11:
            return invalidateAfter(r3);
        }

        int invalidateAfter(int r4) {
            int[] r0 = this.mData;
            if (r0 != null) goto L6;
            return -1;
        L6:
            if (r4 < r0.length) goto L8;
            return -1;
        L8:
            int r1 = invalidateFullSpansAfter(r4);
            if (r1 != (-1)) goto L12;
            int[] r2 = this.mData;
            Arrays.fill(r2, r4, r2.length, -1);
            return this.mData.length;
        L12:
            int r3 = Math.min(r1 + 1, this.mData.length);
            Arrays.fill(this.mData, r4, r3, -1);
            return r3;
        }

        int getSpan(int r2) {
            int[] r1 = this.mData;
            if (r1 != null) goto L5;
            return -1;
        L5:
            if (r2 < r1.length) goto L8;
            return -1;
        L8:
            return r1[r2];
        }

        void setSpan(int r1, Span r2) {
            ensureSize(r1);
            this.mData[r1] = r2.mIndex;
        }

        int sizeForPosition(int r1) {
            int r0 = this.mData.length;
        L3:
            if (r0 > r1) goto L5;
            r0 = r0 * 2;
            goto L3
        L5:
            return r0;
        }

        void ensureSize(int r5) {
            int[] r0 = this.mData;
            if (r0 != null) goto L6;
            int[] r6 = new int[Math.max(r5, 10) + 1];
            this.mData = r6;
            Arrays.fill(r6, -1);
            return;
        L6:
            if (r5 < r0.length) goto L10;
            int[] r7 = new int[sizeForPosition(r5)];
            this.mData = r7;
            System.arraycopy(r0, 0, r7, 0, r0.length);
            int[] r4 = this.mData;
            Arrays.fill(r4, r0.length, r4.length, -1);
            return;
        }

        void clear() {
            int[] r0 = this.mData;
            if (r0 == null) goto L5;
            Arrays.fill(r0, -1);
        L5:
            this.mFullSpanItems = null;
        }

        void offsetForRemoval(int r5, int r6) {
            int[] r0 = this.mData;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r5 >= r0.length) goto L10;
            int r1 = r5 + r6;
            ensureSize(r1);
            int[] r2 = this.mData;
            System.arraycopy(r2, r1, r2, r5, (r2.length - r5) - r6);
            int[] r3 = this.mData;
            Arrays.fill(r3, r3.length - r6, r3.length, -1);
            offsetFullSpansForRemoval(r5, r6);
            return;
        }

        private void offsetFullSpansForRemoval(int r5, int r6) {
            List<FullSpanItem> r0 = this.mFullSpanItems;
            if (r0 != null) goto L5;
            return;
        L5:
            int r1 = r5 + r6;
            int r2 = r0.size() - 1;
        L6:
            if (r2 < 0) goto L15;
            FullSpanItem r3 = this.mFullSpanItems.get(r2);
            if (r3.mPosition < r5) goto L14;
            if (r3.mPosition >= r1) goto L13;
            this.mFullSpanItems.remove(r2);
            goto L14
        L13:
            r3.mPosition -= r6;
        L14:
            r2 = r2 - 1;
            goto L6
        }

        void offsetForAddition(int r4, int r5) {
            int[] r0 = this.mData;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r4 >= r0.length) goto L10;
            int r1 = r4 + r5;
            ensureSize(r1);
            int[] r2 = this.mData;
            System.arraycopy(r2, r4, r2, r1, (r2.length - r4) - r5);
            Arrays.fill(this.mData, r4, r1, -1);
            offsetFullSpansForAddition(r4, r5);
            return;
        }

        private void offsetFullSpansForAddition(int r4, int r5) {
            List<FullSpanItem> r0 = this.mFullSpanItems;
            if (r0 != null) goto L5;
            return;
        L5:
            int r1 = r0.size() - 1;
        L6:
            if (r1 < 0) goto L12;
            FullSpanItem r2 = this.mFullSpanItems.get(r1);
            if (r2.mPosition < r4) goto L11;
            r2.mPosition += r5;
        L11:
            r1 = r1 - 1;
            goto L6
        }

        private int invalidateFullSpansAfter(int r5) {
            if (this.mFullSpanItems != null) goto L5;
            return -1;
        L5:
            FullSpanItem r0 = getFullSpanItem(r5);
            if (r0 == null) goto L8;
            this.mFullSpanItems.remove(r0);
        L8:
            int r1 = this.mFullSpanItems.size();
            int r2 = 0;
        L9:
            if (r2 >= r1) goto L14;
            if (this.mFullSpanItems.get(r2).mPosition >= r5) goto L15;
            r2 = r2 + 1;
        L15:
            if (r2 == (-1)) goto L18;
            FullSpanItem r6 = this.mFullSpanItems.get(r2);
            this.mFullSpanItems.remove(r2);
            return r6.mPosition;
        L18:
            return -1;
        L14:
            r2 = -1;
            goto L15
        }

        public void addFullSpanItem(FullSpanItem r6) {
            if (this.mFullSpanItems != null) goto L5;
            this.mFullSpanItems = new ArrayList();
        L5:
            int r0 = this.mFullSpanItems.size();
            int r1 = 0;
        L6:
            if (r1 >= r0) goto L15;
            FullSpanItem r2 = this.mFullSpanItems.get(r1);
            if (r2.mPosition != r6.mPosition) goto L11;
            this.mFullSpanItems.remove(r1);
        L11:
            if (r2.mPosition >= r6.mPosition) goto L12;
            r1 = r1 + 1;
            goto L6
        L12:
            this.mFullSpanItems.add(r1, r6);
            return;
        L15:
            this.mFullSpanItems.add(r6);
        }

        public FullSpanItem getFullSpanItem(int r5) {
            List<FullSpanItem> r0 = this.mFullSpanItems;
            if (r0 != null) goto L5;
            return null;
        L5:
            int r1 = r0.size() - 1;
        L6:
            if (r1 < 0) goto L11;
            FullSpanItem r2 = this.mFullSpanItems.get(r1);
            if (r2.mPosition == r5) goto L9;
            r1 = r1 - 1;
            goto L6
        L9:
            return r2;
        L11:
            return null;
        }

        public FullSpanItem getFirstFullSpanItemInRange(int r6, int r7, int r8, boolean r9) {
            List<FullSpanItem> r0 = this.mFullSpanItems;
            if (r0 != null) goto L5;
            return null;
        L5:
            int r1 = r0.size();
            int r2 = 0;
        L6:
            if (r2 >= r1) goto L20;
            FullSpanItem r3 = this.mFullSpanItems.get(r2);
            if (r3.mPosition >= r7) goto L9;
            if (r3.mPosition < r6) goto L19;
            if (r8 == 0) goto L18;
            if (r3.mGapDir == r8) goto L18;
            if (r9 == false) goto L19;
            if (r3.mHasUnwantedGapAfter == false) goto L19;
        L18:
            return r3;
        L19:
            r2 = r2 + 1;
            goto L6
        L9:
            return null;
        L20:
            return null;
        }
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean mAnchorLayoutFromEnd;
        int mAnchorPosition;
        List<LazySpanLookup.FullSpanItem> mFullSpanItems;
        boolean mLastLayoutRTL;
        boolean mReverseLayout;
        int[] mSpanLookup;
        int mSpanLookupSize;
        int[] mSpanOffsets;
        int mSpanOffsetsSize;
        int mVisibleAnchorPosition;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SavedState() {
        }

        SavedState(Parcel r4) {
            this.mAnchorPosition = r4.readInt();
            this.mVisibleAnchorPosition = r4.readInt();
            int r0 = r4.readInt();
            this.mSpanOffsetsSize = r0;
            if (r0 <= 0) goto L5;
            int[] r1 = new int[r0];
            this.mSpanOffsets = r1;
            r4.readIntArray(r1);
        L5:
            int r2 = r4.readInt();
            this.mSpanLookupSize = r2;
            if (r2 <= 0) goto L8;
            int[] r3 = new int[r2];
            this.mSpanLookup = r3;
            r4.readIntArray(r3);
        L8:
            boolean r5 = false;
            if (r4.readInt() != 1) goto L11;
            boolean r6 = true;
        L12:
            this.mReverseLayout = r6;
            if (r4.readInt() != 1) goto L15;
            boolean r7 = true;
        L16:
            this.mAnchorLayoutFromEnd = r7;
            if (r4.readInt() != 1) goto L19;
            r5 = true;
        L19:
            this.mLastLayoutRTL = r5;
            this.mFullSpanItems = r4.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
            return;
        L15:
            r7 = false;
            goto L16
        L11:
            r6 = false;
            goto L12
        }

        public SavedState(SavedState r2) {
            this.mSpanOffsetsSize = r2.mSpanOffsetsSize;
            this.mAnchorPosition = r2.mAnchorPosition;
            this.mVisibleAnchorPosition = r2.mVisibleAnchorPosition;
            this.mSpanOffsets = r2.mSpanOffsets;
            this.mSpanLookupSize = r2.mSpanLookupSize;
            this.mSpanLookup = r2.mSpanLookup;
            this.mReverseLayout = r2.mReverseLayout;
            this.mAnchorLayoutFromEnd = r2.mAnchorLayoutFromEnd;
            this.mLastLayoutRTL = r2.mLastLayoutRTL;
            this.mFullSpanItems = r2.mFullSpanItems;
        }

        void invalidateSpanInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mSpanLookupSize = 0;
            this.mSpanLookup = null;
            this.mFullSpanItems = null;
        }

        void invalidateAnchorPositionInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mAnchorPosition = -1;
            this.mVisibleAnchorPosition = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeInt(this.mAnchorPosition);
            r1.writeInt(this.mVisibleAnchorPosition);
            r1.writeInt(this.mSpanOffsetsSize);
            if (this.mSpanOffsetsSize <= 0) goto L5;
            r1.writeIntArray(this.mSpanOffsets);
        L5:
            r1.writeInt(this.mSpanLookupSize);
            if (this.mSpanLookupSize <= 0) goto L8;
            r1.writeIntArray(this.mSpanLookup);
        L8:
            r1.writeInt(this.mReverseLayout ? 1 : 0);
            r1.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
            r1.writeInt(this.mLastLayoutRTL ? 1 : 0);
            r1.writeList(this.mFullSpanItems);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    class Span {
        static final int INVALID_LINE = Integer.MIN_VALUE;
        int mCachedEnd;
        int mCachedStart;
        int mDeletedSize;
        final int mIndex;
        ArrayList<View> mViews;
        final /* synthetic */ StaggeredGridLayoutManager this$0;

        Span(StaggeredGridLayoutManager r1, int r2) {
            this.this$0 = r1;
            this.mViews = new ArrayList();
            this.mCachedStart = Integer.MIN_VALUE;
            this.mCachedEnd = Integer.MIN_VALUE;
            this.mDeletedSize = 0;
            this.mIndex = r2;
        }

        int getStartLine(int r3) {
            int r0 = this.mCachedStart;
            if (r0 == Integer.MIN_VALUE) goto L6;
            return r0;
        L6:
            if (this.mViews.size() != 0) goto L8;
            return r3;
        L8:
            calculateCachedStart();
            return this.mCachedStart;
        }

        void calculateCachedStart() {
            View r0 = this.mViews.get(0);
            LayoutParams r1 = getLayoutParams(r0);
            this.mCachedStart = this.this$0.mPrimaryOrientation.getDecoratedStart(r0);
            if (r1.mFullSpan == false) goto L10;
            LazySpanLookup.FullSpanItem r2 = this.this$0.mLazySpanLookup.getFullSpanItem(r1.getViewLayoutPosition());
            if (r2 != null) goto L7;
            return;
        L7:
            if (r2.mGapDir != (-1)) goto L12;
            this.mCachedStart -= r2.getGapForSpan(this.mIndex);
            return;
        L12:
            return;
        }

        int getStartLine() {
            int r0 = this.mCachedStart;
            if (r0 == Integer.MIN_VALUE) goto L5;
            return r0;
        L5:
            calculateCachedStart();
            return this.mCachedStart;
        }

        int getEndLine(int r3) {
            int r0 = this.mCachedEnd;
            if (r0 == Integer.MIN_VALUE) goto L6;
            return r0;
        L6:
            if (this.mViews.size() != 0) goto L8;
            return r3;
        L8:
            calculateCachedEnd();
            return this.mCachedEnd;
        }

        void calculateCachedEnd() {
            ArrayList<View> r0 = this.mViews;
            View r1 = r0.get(r0.size() - 1);
            LayoutParams r2 = getLayoutParams(r1);
            this.mCachedEnd = this.this$0.mPrimaryOrientation.getDecoratedEnd(r1);
            if (r2.mFullSpan == false) goto L10;
            LazySpanLookup.FullSpanItem r3 = this.this$0.mLazySpanLookup.getFullSpanItem(r2.getViewLayoutPosition());
            if (r3 != null) goto L7;
            return;
        L7:
            if (r3.mGapDir != 1) goto L12;
            this.mCachedEnd += r3.getGapForSpan(this.mIndex);
            return;
        L12:
            return;
        }

        int getEndLine() {
            int r0 = this.mCachedEnd;
            if (r0 == Integer.MIN_VALUE) goto L5;
            return r0;
        L5:
            calculateCachedEnd();
            return this.mCachedEnd;
        }

        void prependToSpan(View r5) {
            LayoutParams r0 = getLayoutParams(r5);
            r0.mSpan = this;
            this.mViews.add(0, r5);
            this.mCachedStart = Integer.MIN_VALUE;
            if (this.mViews.size() != 1) goto L6;
            this.mCachedEnd = Integer.MIN_VALUE;
        L6:
            if (r0.isItemRemoved() == false) goto L8;
        L9:
            this.mDeletedSize += this.this$0.mPrimaryOrientation.getDecoratedMeasurement(r5);
            return;
        L8:
            if (r0.isItemChanged() == true) goto L9;
        }

        void appendToSpan(View r5) {
            LayoutParams r0 = getLayoutParams(r5);
            r0.mSpan = this;
            this.mViews.add(r5);
            this.mCachedEnd = Integer.MIN_VALUE;
            if (this.mViews.size() != 1) goto L6;
            this.mCachedStart = Integer.MIN_VALUE;
        L6:
            if (r0.isItemRemoved() == false) goto L8;
        L9:
            this.mDeletedSize += this.this$0.mPrimaryOrientation.getDecoratedMeasurement(r5);
            return;
        L8:
            if (r0.isItemChanged() == true) goto L9;
        }

        void cacheReferenceLineAndClear(boolean r4, int r5) {
            if (r4 == false) goto L5;
            int r1 = getEndLine(Integer.MIN_VALUE);
        L6:
            clear();
            if (r1 != Integer.MIN_VALUE) goto L9;
            return;
        L9:
            if (r4 == true) goto L11;
        L12:
            if (r4 == false) goto L14;
        L16:
            if (r5 == Integer.MIN_VALUE) goto L18;
            r1 = r1 + r5;
        L18:
            this.mCachedEnd = r1;
            this.mCachedStart = r1;
            return;
        L14:
            if (r1 <= this.this$0.mPrimaryOrientation.getStartAfterPadding()) goto L16;
            return;
        L11:
            if (r1 >= this.this$0.mPrimaryOrientation.getEndAfterPadding()) goto L12;
            return;
        L5:
            r1 = getStartLine(Integer.MIN_VALUE);
            goto L6
        }

        void clear() {
            this.mViews.clear();
            invalidateCache();
            this.mDeletedSize = 0;
        }

        void invalidateCache() {
            this.mCachedStart = Integer.MIN_VALUE;
            this.mCachedEnd = Integer.MIN_VALUE;
        }

        void setLine(int r1) {
            this.mCachedStart = r1;
            this.mCachedEnd = r1;
        }

        void popEnd() {
            int r0 = this.mViews.size();
            View r1 = this.mViews.remove(r0 - 1);
            LayoutParams r2 = getLayoutParams(r1);
            r2.mSpan = null;
            if (r2.isItemRemoved() == false) goto L5;
        L6:
            this.mDeletedSize -= this.this$0.mPrimaryOrientation.getDecoratedMeasurement(r1);
        L8:
            if (r0 != 1) goto L10;
            this.mCachedStart = Integer.MIN_VALUE;
        L10:
            this.mCachedEnd = Integer.MIN_VALUE;
            return;
        L5:
            if (r2.isItemChanged() == false) goto L8;
            goto L6
        }

        void popStart() {
            View r0 = this.mViews.remove(0);
            LayoutParams r1 = getLayoutParams(r0);
            r1.mSpan = null;
            if (this.mViews.size() != 0) goto L6;
            this.mCachedEnd = Integer.MIN_VALUE;
        L6:
            if (r1.isItemRemoved() == false) goto L8;
        L9:
            this.mDeletedSize -= this.this$0.mPrimaryOrientation.getDecoratedMeasurement(r0);
        L10:
            this.mCachedStart = Integer.MIN_VALUE;
            return;
        L8:
            if (r1.isItemChanged() == false) goto L10;
            goto L9
        }

        public int getDeletedSize() {
            return this.mDeletedSize;
        }

        LayoutParams getLayoutParams(View r1) {
            return (LayoutParams) r1.getLayoutParams();
        }

        void onOffset(int r3) {
            int r0 = this.mCachedStart;
            if (r0 == Integer.MIN_VALUE) goto L5;
            this.mCachedStart = r0 + r3;
        L5:
            int r1 = this.mCachedEnd;
            if (r1 == Integer.MIN_VALUE) goto L9;
            this.mCachedEnd = r1 + r3;
            return;
        }

        public int findFirstVisibleItemPosition() {
            if (this.this$0.mReverseLayout == false) goto L6;
            return findOneVisibleChild(this.mViews.size() - 1, -1, false);
        L6:
            return findOneVisibleChild(0, this.mViews.size(), false);
        }

        public int findFirstPartiallyVisibleItemPosition() {
            if (this.this$0.mReverseLayout == false) goto L6;
            return findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true);
        L6:
            return findOnePartiallyVisibleChild(0, this.mViews.size(), true);
        }

        public int findFirstCompletelyVisibleItemPosition() {
            if (this.this$0.mReverseLayout == false) goto L6;
            return findOneVisibleChild(this.mViews.size() - 1, -1, true);
        L6:
            return findOneVisibleChild(0, this.mViews.size(), true);
        }

        public int findLastVisibleItemPosition() {
            if (this.this$0.mReverseLayout == false) goto L6;
            return findOneVisibleChild(0, this.mViews.size(), false);
        L6:
            return findOneVisibleChild(this.mViews.size() - 1, -1, false);
        }

        public int findLastPartiallyVisibleItemPosition() {
            if (this.this$0.mReverseLayout == false) goto L6;
            return findOnePartiallyVisibleChild(0, this.mViews.size(), true);
        L6:
            return findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true);
        }

        public int findLastCompletelyVisibleItemPosition() {
            if (this.this$0.mReverseLayout == false) goto L6;
            return findOneVisibleChild(0, this.mViews.size(), true);
        L6:
            return findOneVisibleChild(this.mViews.size() - 1, -1, true);
        }

        int findOnePartiallyOrCompletelyVisibleChild(int r11, int r12, boolean r13, boolean r14, boolean r15) {
            int r0 = this.this$0.mPrimaryOrientation.getStartAfterPadding();
            int r1 = this.this$0.mPrimaryOrientation.getEndAfterPadding();
            if (r12 <= r11) goto L5;
            int r4 = 1;
        L6:
            if (r11 == r12) goto L35;
            View r5 = this.mViews.get(r11);
            int r6 = this.this$0.mPrimaryOrientation.getDecoratedStart(r5);
            int r7 = this.this$0.mPrimaryOrientation.getDecoratedEnd(r5);
            boolean r8 = false;
            if (r15 == false) goto L11;
            if (r6 <= r1) goto L12;
        L13:
            boolean r9 = false;
        L14:
            if (r15 == false) goto L17;
            if (r7 >= r0) goto L18;
        L19:
            if (r9 == false) goto L34;
            if (r8 == false) goto L34;
            if (r13 == false) goto L27;
            if (r14 == false) goto L27;
            if (r6 < r0) goto L34;
            if (r7 > r1) goto L34;
            return this.this$0.getPosition(r5);
        L27:
            if (r14 == true) goto L29;
            if (r6 < r0) goto L33;
            if (r7 <= r1) goto L34;
        L33:
            return this.this$0.getPosition(r5);
        L29:
            return this.this$0.getPosition(r5);
        L34:
            r11 = r11 + r4;
        L18:
            r8 = true;
            goto L19
        L17:
            if (r7 <= r0) goto L19;
        L12:
            r9 = true;
            goto L14
        L11:
            if (r6 >= r1) goto L13;
        L35:
            return -1;
        L5:
            r4 = -1;
            goto L6
        }

        int findOneVisibleChild(int r7, int r8, boolean r9) {
            return findOnePartiallyOrCompletelyVisibleChild(r7, r8, r9, true, false);
        }

        int findOnePartiallyVisibleChild(int r7, int r8, boolean r9) {
            return findOnePartiallyOrCompletelyVisibleChild(r7, r8, false, false, r9);
        }

        public View getFocusableViewAfter(int r5, int r6) {
            View r1 = null;
            if (r6 != (-1)) goto L18;
            int r7 = this.mViews.size();
            int r0 = 0;
        L5:
            if (r0 >= r7) goto L32;
            View r2 = this.mViews.get(r0);
            if (this.this$0.mReverseLayout == false) goto L11;
            if (this.this$0.getPosition(r2) <= r5) goto L32;
        L11:
            if (this.this$0.mReverseLayout == true) goto L16;
            if (this.this$0.getPosition(r2) >= r5) goto L32;
        L16:
            if (r2.hasFocusable() == false) goto L32;
            r0 = r0 + 1;
            r1 = r2;
        L32:
            return r1;
        L18:
            int r8 = this.mViews.size() - 1;
        L19:
            if (r8 < 0) goto L32;
            View r3 = this.mViews.get(r8);
            if (this.this$0.mReverseLayout == false) goto L25;
            if (this.this$0.getPosition(r3) >= r5) goto L32;
        L25:
            if (this.this$0.mReverseLayout == true) goto L30;
            if (this.this$0.getPosition(r3) <= r5) goto L32;
        L30:
            if (r3.hasFocusable() == false) goto L32;
            r8 = r8 - 1;
            r1 = r3;
            goto L19
        }
    }

    public StaggeredGridLayoutManager(Context r3, AttributeSet r4, int r5, int r6) {
        this.mSpanCount = -1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mLazySpanLookup = new LazySpanLookup();
        this.mGapStrategy = 2;
        this.mTmpRect = new Rect();
        this.mAnchorInfo = new AnchorInfo(this);
        this.mLaidOutInvalidFullSpan = false;
        this.mSmoothScrollbarEnabled = true;
        this.mCheckForGapsRunnable = new AnonymousClass1(this);
        RecyclerView.LayoutManager.Properties r7 = getProperties(r3, r4, r5, r6);
        setOrientation(r7.orientation);
        setSpanCount(r7.spanCount);
        setReverseLayout(r7.reverseLayout);
        this.mLayoutState = new LayoutState();
        createOrientationHelpers();
    }

    public StaggeredGridLayoutManager(int r3, int r4) {
        this.mSpanCount = -1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mLazySpanLookup = new LazySpanLookup();
        this.mGapStrategy = 2;
        this.mTmpRect = new Rect();
        this.mAnchorInfo = new AnchorInfo(this);
        this.mLaidOutInvalidFullSpan = false;
        this.mSmoothScrollbarEnabled = true;
        this.mCheckForGapsRunnable = new AnonymousClass1(this);
        this.mOrientation = r4;
        setSpanCount(r3);
        this.mLayoutState = new LayoutState();
        createOrientationHelpers();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        if (this.mGapStrategy == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void createOrientationHelpers() {
        this.mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, this.mOrientation);
        this.mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
    }

    boolean checkForGaps() {
        if (getChildCount() != 0) goto L5;
    L36:
        return false;
    L5:
        if (this.mGapStrategy == 0) goto L36;
        if (isAttachedToWindow() == false) goto L36;
        if (this.mShouldReverseLayout == false) goto L12;
        int r0 = getLastChildPosition();
        int r2 = getFirstChildPosition();
    L14:
        if (r0 != 0) goto L20;
        if (hasGapsToFix() == null) goto L20;
        this.mLazySpanLookup.clear();
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    L20:
        if (this.mLaidOutInvalidFullSpan == true) goto L23;
        return false;
    L23:
        if (this.mShouldReverseLayout == false) goto L25;
        int r4 = -1;
    L26:
        int r3 = r2 + 1;
        LazySpanLookup.FullSpanItem r6 = this.mLazySpanLookup.getFirstFullSpanItemInRange(r0, r3, r4, true);
        if (r6 != null) goto L30;
        this.mLaidOutInvalidFullSpan = false;
        this.mLazySpanLookup.forceInvalidateAfter(r3);
        return false;
    L30:
        LazySpanLookup.FullSpanItem r1 = this.mLazySpanLookup.getFirstFullSpanItemInRange(r0, r6.mPosition, r4 * (-1), true);
        if (r1 != null) goto L33;
        this.mLazySpanLookup.forceInvalidateAfter(r6.mPosition);
    L34:
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    L33:
        this.mLazySpanLookup.forceInvalidateAfter(r1.mPosition + 1);
        goto L34
    L25:
        r4 = 1;
        goto L26
    L12:
        r0 = getFirstChildPosition();
        r2 = getLastChildPosition();
        goto L14
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int r1) {
        if (r1 != 0) goto L5;
        checkForGaps();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView r2, RecyclerView.Recycler r3) {
        super.onDetachedFromWindow(r2, r3);
        removeCallbacks(this.mCheckForGapsRunnable);
        int r4 = 0;
    L4:
        if (r4 >= this.mSpanCount) goto L6;
        this.mSpans[r4].clear();
        r4 = r4 + 1;
        goto L4
    L6:
        r2.requestLayout();
    }

    View hasGapsToFix() {
        int r0 = getChildCount() - 1;
        BitSet r2 = new BitSet(this.mSpanCount);
        r2.set(0, this.mSpanCount, true);
        int r5 = -1;
        if (this.mOrientation == 1) goto L5;
    L7:
        byte r3 = -1;
    L9:
        if (this.mShouldReverseLayout == false) goto L11;
        int r6 = -1;
    L12:
        if (r0 >= r6) goto L14;
        r5 = 1;
    L14:
        if (r0 == r6) goto L50;
        View r7 = getChildAt(r0);
        LayoutParams r8 = (LayoutParams) r7.getLayoutParams();
        if (r2.get(r8.mSpan.mIndex) == false) goto L22;
        if (checkSpanForGap(r8.mSpan) == true) goto L19;
        r2.clear(r8.mSpan.mIndex);
        goto L22
    L19:
        return r7;
    L22:
        if (r8.mFullSpan == true) goto L49;
        int r9 = r0 + r5;
        if (r9 == r6) goto L49;
        View r10 = getChildAt(r9);
        if (this.mShouldReverseLayout == false) goto L33;
        int r11 = this.mPrimaryOrientation.getDecoratedEnd(r7);
        int r12 = this.mPrimaryOrientation.getDecoratedEnd(r10);
        if (r11 < r12) goto L30;
        if (r11 == r12) goto L37;
    L38:
        boolean r13 = false;
    L39:
        if (r13 == false) goto L49;
        if ((r8.mSpan.mIndex - ((LayoutParams) r10.getLayoutParams()).mSpan.mIndex) >= 0) goto L43;
        boolean r14 = true;
    L44:
        if (r3 >= 0) goto L46;
        boolean r15 = true;
    L47:
        if (r14 == r15) goto L49;
        return r7;
    L46:
        r15 = false;
        goto L47
    L43:
        r14 = false;
    L37:
        r13 = true;
        goto L39
    L30:
        return r7;
    L33:
        int r16 = this.mPrimaryOrientation.getDecoratedStart(r7);
        int r17 = this.mPrimaryOrientation.getDecoratedStart(r10);
        if (r16 > r17) goto L35;
        if (r16 != r17) goto L38;
    L35:
        return r7;
    L49:
        r0 = r0 + r5;
        goto L14
    L50:
        return null;
    L11:
        r6 = r0 + 1;
        r0 = 0;
        goto L12
    L5:
        if (isLayoutRTL() == false) goto L7;
        r3 = 1;
        goto L9
    }

    private boolean checkSpanForGap(Span r3) {
        if (this.mShouldReverseLayout == false) goto L9;
        if (r3.getEndLine() < this.mPrimaryOrientation.getEndAfterPadding()) goto L7;
    L12:
        return false;
    L7:
        return !r3.getLayoutParams(r3.mViews.get(r3.mViews.size() - 1)).mFullSpan;
    L9:
        if (r3.getStartLine() <= this.mPrimaryOrientation.getStartAfterPadding()) goto L12;
        return !r3.getLayoutParams(r3.mViews.get(0)).mFullSpan;
    }

    public void setSpanCount(int r3) {
        assertNotInLayoutOrScroll(null);
        if (r3 == this.mSpanCount) goto L11;
        invalidateSpanAssignments();
        this.mSpanCount = r3;
        this.mRemainingSpans = new BitSet(this.mSpanCount);
        this.mSpans = new Span[this.mSpanCount];
        int r4 = 0;
    L6:
        if (r4 >= this.mSpanCount) goto L8;
        this.mSpans[r4] = new Span(this, r4);
        r4 = r4 + 1;
        goto L6
    L8:
        requestLayout();
        return;
    }

    public void setOrientation(int r2) {
        if (r2 != 0) goto L4;
    L8:
        assertNotInLayoutOrScroll(null);
        if (r2 != this.mOrientation) goto L11;
        return;
    L11:
        this.mOrientation = r2;
        OrientationHelper r3 = this.mPrimaryOrientation;
        this.mPrimaryOrientation = this.mSecondaryOrientation;
        this.mSecondaryOrientation = r3;
        requestLayout();
        return;
    L4:
        if (r2 == 1) goto L8;
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void setReverseLayout(boolean r2) {
        assertNotInLayoutOrScroll(null);
        SavedState r0 = this.mPendingSavedState;
        if (r0 != null) goto L5;
    L7:
        this.mReverseLayout = r2;
        requestLayout();
        return;
    L5:
        if (r0.mReverseLayout == r2) goto L7;
        this.mPendingSavedState.mReverseLayout = r2;
        goto L7
    }

    public int getGapStrategy() {
        return this.mGapStrategy;
    }

    public void setGapStrategy(int r2) {
        assertNotInLayoutOrScroll(null);
        if (r2 != this.mGapStrategy) goto L5;
        return;
    L5:
        if (r2 != 0) goto L7;
    L11:
        this.mGapStrategy = r2;
        requestLayout();
        return;
    L7:
        if (r2 == 2) goto L11;
        throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String r2) {
        if (this.mPendingSavedState != null) goto L6;
        super.assertNotInLayoutOrScroll(r2);
        return;
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public void invalidateSpanAssignments() {
        this.mLazySpanLookup.clear();
        requestLayout();
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

    boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect r5, int r6, int r7) {
        int r0 = getPaddingLeft() + getPaddingRight();
        int r1 = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation != 1) goto L5;
        int r8 = chooseSize(r7, r5.height() + r1, getMinimumHeight());
        int r9 = chooseSize(r6, (this.mSizePerSpan * this.mSpanCount) + r0, getMinimumWidth());
    L6:
        setMeasuredDimension(r9, r8);
        return;
    L5:
        r9 = chooseSize(r6, r5.width() + r0, getMinimumWidth());
        r8 = chooseSize(r7, (this.mSizePerSpan * this.mSpanCount) + r1, getMinimumHeight());
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler r2, RecyclerView.State r3) {
        onLayoutChildren(r2, r3, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter r1, RecyclerView.Adapter r2) {
        this.mLazySpanLookup.clear();
        int r3 = 0;
    L4:
        if (r3 >= this.mSpanCount) goto L6;
        this.mSpans[r3].clear();
        r3 = r3 + 1;
        goto L4
    }

    private void onLayoutChildren(RecyclerView.Recycler r9, RecyclerView.State r10, boolean r11) {
        AnchorInfo r0 = this.mAnchorInfo;
        if (this.mPendingSavedState != null) goto L7;
        if (this.mPendingScrollPosition != (-1)) goto L7;
    L10:
        boolean r4 = true;
        if (r0.mValid == true) goto L13;
    L18:
        boolean r1 = true;
    L19:
        if (r1 == false) goto L26;
        r0.reset();
        if (this.mPendingSavedState == null) goto L23;
        applyPendingSavedState(r0);
    L24:
        updateAnchorInfoForLayout(r10, r0);
        r0.mValid = true;
        goto L26
    L23:
        resolveShouldLayoutReverse();
        r0.mLayoutFromEnd = this.mShouldReverseLayout;
    L26:
        if (this.mPendingSavedState != null) goto L35;
        if (this.mPendingScrollPosition != (-1)) goto L35;
        if (r0.mLayoutFromEnd == this.mLastLayoutFromEnd) goto L32;
    L33:
        this.mLazySpanLookup.clear();
        r0.mInvalidateOffsets = true;
        goto L35
    L32:
        if (isLayoutRTL() != this.mLastLayoutRTL) goto L33;
    L35:
        if (getChildCount() <= 0) goto L62;
        SavedState r5 = this.mPendingSavedState;
        if (r5 == null) goto L41;
        if (r5.mSpanOffsetsSize >= 1) goto L62;
    L41:
        if (r0.mInvalidateOffsets == false) goto L49;
        int r2 = 0;
    L44:
        if (r2 >= this.mSpanCount) goto L62;
        this.mSpans[r2].clear();
        if (r0.mOffset == Integer.MIN_VALUE) goto L48;
        this.mSpans[r2].setLine(r0.mOffset);
    L48:
        r2 = r2 + 1;
        goto L44
    L49:
        if (r1 == false) goto L51;
    L57:
        int r3 = 0;
    L59:
        if (r3 >= this.mSpanCount) goto L61;
        this.mSpans[r3].cacheReferenceLineAndClear(this.mShouldReverseLayout, r0.mOffset);
        r3 = r3 + 1;
        goto L59
    L61:
        this.mAnchorInfo.saveSpanReferenceLines(this.mSpans);
        goto L62
    L51:
        if (this.mAnchorInfo.mSpanReferenceLines == null) goto L57;
        int r6 = 0;
    L55:
        if (r6 >= this.mSpanCount) goto L62;
        Span r7 = this.mSpans[r6];
        r7.clear();
        r7.setLine(this.mAnchorInfo.mSpanReferenceLines[r6]);
        r6 = r6 + 1;
    L62:
        detachAndScrapAttachedViews(r9);
        this.mLayoutState.mRecycle = false;
        this.mLaidOutInvalidFullSpan = false;
        updateMeasureSpecs(this.mSecondaryOrientation.getTotalSpace());
        updateLayoutState(r0.mPosition, r10);
        if (r0.mLayoutFromEnd == false) goto L65;
        setLayoutStateDirection(-1);
        fill(r9, this.mLayoutState, r10);
        setLayoutStateDirection(1);
        this.mLayoutState.mCurrentPosition = r0.mPosition + this.mLayoutState.mItemDirection;
        fill(r9, this.mLayoutState, r10);
    L66:
        repositionToWrapContentIfNecessary();
        if (getChildCount() > 0) goto L69;
    L72:
        if (r11 == true) goto L74;
    L89:
        r4 = false;
    L91:
        if (r10.isPreLayout() == false) goto L93;
        this.mAnchorInfo.reset();
    L93:
        this.mLastLayoutFromEnd = r0.mLayoutFromEnd;
        this.mLastLayoutRTL = isLayoutRTL();
        if (r4 == false) goto L102;
        this.mAnchorInfo.reset();
        onLayoutChildren(r9, r10, false);
        return;
    L102:
        return;
    L74:
        if (r10.isPreLayout() == true) goto L89;
        if (this.mGapStrategy != 0) goto L78;
    L84:
        boolean r12 = false;
    L85:
        if (r12 == false) goto L89;
        removeCallbacks(this.mCheckForGapsRunnable);
        if (checkForGaps() == false) goto L89;
    L78:
        if (getChildCount() <= 0) goto L84;
        if (this.mLaidOutInvalidFullSpan == false) goto L82;
    L83:
        r12 = true;
        goto L85
    L82:
        if (hasGapsToFix() == null) goto L84;
    L69:
        if (this.mShouldReverseLayout == false) goto L71;
        fixEndGap(r9, r10, true);
        fixStartGap(r9, r10, false);
        goto L72
    L71:
        fixStartGap(r9, r10, true);
        fixEndGap(r9, r10, false);
        goto L72
    L65:
        setLayoutStateDirection(1);
        fill(r9, this.mLayoutState, r10);
        setLayoutStateDirection(-1);
        this.mLayoutState.mCurrentPosition = r0.mPosition + this.mLayoutState.mItemDirection;
        fill(r9, this.mLayoutState, r10);
        goto L66
    L13:
        if (this.mPendingScrollPosition != (-1)) goto L18;
        if (this.mPendingSavedState != null) goto L18;
        r1 = false;
    L7:
        if (r10.getItemCount() != 0) goto L10;
        removeAndRecycleAllViews(r9);
        r0.reset();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State r1) {
        super.onLayoutCompleted(r1);
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo.reset();
    }

    private void repositionToWrapContentIfNecessary() {
        if (this.mSecondaryOrientation.getMode() != 1073741824) goto L5;
        return;
    L5:
        int r0 = getChildCount();
        int r1 = 0;
        float r2 = 0.0f;
        int r3 = 0;
    L6:
        if (r3 >= r0) goto L15;
        View r4 = getChildAt(r3);
        float r5 = this.mSecondaryOrientation.getDecoratedMeasurement(r4);
        if (r5 < r2) goto L14;
        if (((LayoutParams) r4.getLayoutParams()).isFullSpan() == false) goto L13;
        r5 = (r5 * 1.0f) / this.mSpanCount;
    L13:
        r2 = Math.max(r2, r5);
    L14:
        r3 = r3 + 1;
        goto L6
    L15:
        int r6 = this.mSizePerSpan;
        int r7 = Math.round(r2 * this.mSpanCount);
        if (this.mSecondaryOrientation.getMode() != Integer.MIN_VALUE) goto L18;
        r7 = Math.min(r7, this.mSecondaryOrientation.getTotalSpace());
    L18:
        updateMeasureSpecs(r7);
        if (this.mSizePerSpan != r6) goto L21;
        return;
    L21:
        if (r1 >= r0) goto L35;
        View r8 = getChildAt(r1);
        LayoutParams r9 = (LayoutParams) r8.getLayoutParams();
        if (r9.mFullSpan == true) goto L34;
        if (isLayoutRTL() == true) goto L28;
    L30:
        int r10 = r9.mSpan.mIndex * this.mSizePerSpan;
        int r11 = r9.mSpan.mIndex * r6;
        if (this.mOrientation != 1) goto L33;
        r8.offsetLeftAndRight(r10 - r11);
        goto L34
    L33:
        r8.offsetTopAndBottom(r10 - r11);
        goto L34
    L28:
        if (this.mOrientation != 1) goto L30;
        r8.offsetLeftAndRight(((-((this.mSpanCount - 1) - r9.mSpan.mIndex)) * this.mSizePerSpan) - ((-((this.mSpanCount - 1) - r9.mSpan.mIndex)) * r6));
    L34:
        r1 = r1 + 1;
        goto L21
    }

    private void applyPendingSavedState(AnchorInfo r4) {
        if (this.mPendingSavedState.mSpanOffsetsSize > 0) goto L5;
    L18:
        this.mLastLayoutRTL = this.mPendingSavedState.mLastLayoutRTL;
        setReverseLayout(this.mPendingSavedState.mReverseLayout);
        resolveShouldLayoutReverse();
        if (this.mPendingSavedState.mAnchorPosition == (-1)) goto L21;
        this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
        r4.mLayoutFromEnd = this.mPendingSavedState.mAnchorLayoutFromEnd;
    L23:
        if (this.mPendingSavedState.mSpanLookupSize <= 1) goto L29;
        LazySpanLookup r5 = this.mLazySpanLookup;
        r5.mData = this.mPendingSavedState.mSpanLookup;
        LazySpanLookup r6 = this.mLazySpanLookup;
        r6.mFullSpanItems = this.mPendingSavedState.mFullSpanItems;
        return;
    L29:
        return;
    L21:
        r4.mLayoutFromEnd = this.mShouldReverseLayout;
        goto L23
    L5:
        if (this.mPendingSavedState.mSpanOffsetsSize != this.mSpanCount) goto L17;
        int r0 = 0;
    L8:
        if (r0 >= this.mSpanCount) goto L18;
        this.mSpans[r0].clear();
        int r1 = this.mPendingSavedState.mSpanOffsets[r0];
        if (r1 == Integer.MIN_VALUE) goto L16;
        if (this.mPendingSavedState.mAnchorLayoutFromEnd == false) goto L14;
        int r2 = this.mPrimaryOrientation.getEndAfterPadding();
    L15:
        r1 = r1 + r2;
        goto L16
    L14:
        r2 = this.mPrimaryOrientation.getStartAfterPadding();
    L16:
        this.mSpans[r0].setLine(r1);
        r0 = r0 + 1;
        goto L8
    L17:
        this.mPendingSavedState.invalidateSpanInfo();
        SavedState r3 = this.mPendingSavedState;
        r3.mAnchorPosition = r3.mVisibleAnchorPosition;
        goto L18
    }

    void updateAnchorInfoForLayout(RecyclerView.State r2, AnchorInfo r3) {
        if (updateAnchorFromPendingData(r2, r3) == false) goto L6;
        return;
    L6:
        if (updateAnchorFromChildren(r2, r3) == false) goto L8;
        return;
    L8:
        r3.assignCoordinateFromPadding();
        r3.mPosition = 0;
    }

    private boolean updateAnchorFromChildren(RecyclerView.State r2, AnchorInfo r3) {
        if (this.mLastLayoutFromEnd == false) goto L5;
        int r1 = findLastReferenceChildPosition(r2.getItemCount());
    L6:
        r3.mPosition = r1;
        r3.mOffset = Integer.MIN_VALUE;
        return true;
    L5:
        r1 = findFirstReferenceChildPosition(r2.getItemCount());
        goto L6
    }

    boolean updateAnchorFromPendingData(RecyclerView.State r5, AnchorInfo r6) {
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
        SavedState r7 = this.mPendingSavedState;
        if (r7 != null) goto L15;
    L20:
        View r8 = findViewByPosition(this.mPendingScrollPosition);
        if (r8 != null) goto L23;
        r6.mPosition = this.mPendingScrollPosition;
        int r9 = this.mPendingScrollPositionOffset;
        if (r9 == Integer.MIN_VALUE) goto L53;
        r6.assignCoordinateFromPadding(r9);
    L57:
        r6.mInvalidateOffsets = true;
    L58:
        return true;
    L53:
        if (calculateScrollDirectionForPosition(r6.mPosition) != 1) goto L55;
        r1 = true;
    L55:
        r6.mLayoutFromEnd = r1;
        r6.assignCoordinateFromPadding();
        goto L57
    L23:
        if (this.mShouldReverseLayout == false) goto L25;
        int r2 = getLastChildPosition();
    L26:
        r6.mPosition = r2;
        if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) goto L34;
        if (r6.mLayoutFromEnd == false) goto L31;
        r6.mOffset = (this.mPrimaryOrientation.getEndAfterPadding() - this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedEnd(r8);
    L32:
        return true;
    L31:
        r6.mOffset = (this.mPrimaryOrientation.getStartAfterPadding() + this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedStart(r8);
        goto L32
    L34:
        if (this.mPrimaryOrientation.getDecoratedMeasurement(r8) > this.mPrimaryOrientation.getTotalSpace()) goto L36;
        int r3 = this.mPrimaryOrientation.getDecoratedStart(r8) - this.mPrimaryOrientation.getStartAfterPadding();
        if (r3 >= 0) goto L45;
        r6.mOffset = -r3;
        return true;
    L45:
        int r4 = this.mPrimaryOrientation.getEndAfterPadding() - this.mPrimaryOrientation.getDecoratedEnd(r8);
        if (r4 >= 0) goto L49;
        r6.mOffset = r4;
        return true;
    L49:
        r6.mOffset = Integer.MIN_VALUE;
        goto L58
    L36:
        if (r6.mLayoutFromEnd == false) goto L38;
        int r10 = this.mPrimaryOrientation.getEndAfterPadding();
    L39:
        r6.mOffset = r10;
        return true;
    L38:
        r10 = this.mPrimaryOrientation.getStartAfterPadding();
        goto L39
    L25:
        r2 = getFirstChildPosition();
        goto L26
    L15:
        if (r7.mAnchorPosition == (-1)) goto L20;
        if (this.mPendingSavedState.mSpanOffsetsSize < 1) goto L20;
        r6.mOffset = Integer.MIN_VALUE;
        r6.mPosition = this.mPendingScrollPosition;
    L60:
        return false;
    }

    void updateMeasureSpecs(int r2) {
        this.mSizePerSpan = r2 / this.mSpanCount;
        this.mFullSizeSpec = View.MeasureSpec.makeMeasureSpec(r2, this.mSecondaryOrientation.getMode());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState != null) goto L5;
        return true;
    L5:
        return false;
    }

    public int[] findFirstVisibleItemPositions(int[] r4) {
        if (r4 != null) goto L5;
        r4 = new int[this.mSpanCount];
    L6:
        int r0 = 0;
    L8:
        if (r0 >= this.mSpanCount) goto L10;
        r4[r0] = this.mSpans[r0].findFirstVisibleItemPosition();
        r0 = r0 + 1;
        goto L8
    L10:
        return r4;
    L5:
        if (r4.length >= this.mSpanCount) goto L6;
        throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + r4.length);
    }

    public int[] findFirstCompletelyVisibleItemPositions(int[] r4) {
        if (r4 != null) goto L5;
        r4 = new int[this.mSpanCount];
    L6:
        int r0 = 0;
    L8:
        if (r0 >= this.mSpanCount) goto L10;
        r4[r0] = this.mSpans[r0].findFirstCompletelyVisibleItemPosition();
        r0 = r0 + 1;
        goto L8
    L10:
        return r4;
    L5:
        if (r4.length >= this.mSpanCount) goto L6;
        throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + r4.length);
    }

    public int[] findLastVisibleItemPositions(int[] r4) {
        if (r4 != null) goto L5;
        r4 = new int[this.mSpanCount];
    L6:
        int r0 = 0;
    L8:
        if (r0 >= this.mSpanCount) goto L10;
        r4[r0] = this.mSpans[r0].findLastVisibleItemPosition();
        r0 = r0 + 1;
        goto L8
    L10:
        return r4;
    L5:
        if (r4.length >= this.mSpanCount) goto L6;
        throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + r4.length);
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] r4) {
        if (r4 != null) goto L5;
        r4 = new int[this.mSpanCount];
    L6:
        int r0 = 0;
    L8:
        if (r0 >= this.mSpanCount) goto L10;
        r4[r0] = this.mSpans[r0].findLastCompletelyVisibleItemPosition();
        r0 = r0 + 1;
        goto L8
    L10:
        return r4;
    L5:
        if (r4.length >= this.mSpanCount) goto L6;
        throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + r4.length);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State r1) {
        return computeScrollOffset(r1);
    }

    private int computeScrollOffset(RecyclerView.State r8) {
        if (getChildCount() != 0) goto L7;
        return 0;
    L7:
        return ScrollbarHelper.computeScrollOffset(r8, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State r1) {
        return computeScrollOffset(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State r1) {
        return computeScrollExtent(r1);
    }

    private int computeScrollExtent(RecyclerView.State r7) {
        if (getChildCount() != 0) goto L7;
        return 0;
    L7:
        return ScrollbarHelper.computeScrollExtent(r7, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State r1) {
        return computeScrollExtent(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State r1) {
        return computeScrollRange(r1);
    }

    private int computeScrollRange(RecyclerView.State r7) {
        if (getChildCount() != 0) goto L7;
        return 0;
    L7:
        return ScrollbarHelper.computeScrollRange(r7, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State r1) {
        return computeScrollRange(r1);
    }

    private void measureChildWithDecorationsAndMargin(View r7, LayoutParams r8, boolean r9) {
        if (r8.mFullSpan == false) goto L9;
        if (this.mOrientation != 1) goto L7;
        measureChildWithDecorationsAndMargin(r7, this.mFullSizeSpec, getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), r8.height, true), r9);
        return;
    L7:
        measureChildWithDecorationsAndMargin(r7, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), r8.width, true), this.mFullSizeSpec, r9);
        return;
    L9:
        if (this.mOrientation != 1) goto L11;
        measureChildWithDecorationsAndMargin(r7, getChildMeasureSpec(this.mSizePerSpan, getWidthMode(), 0, r8.width, false), getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), r8.height, true), r9);
        return;
    L11:
        measureChildWithDecorationsAndMargin(r7, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), r8.width, true), getChildMeasureSpec(this.mSizePerSpan, getHeightMode(), 0, r8.height, false), r9);
    }

    private void measureChildWithDecorationsAndMargin(View r5, int r6, int r7, boolean r8) {
        calculateItemDecorationsForChild(r5, this.mTmpRect);
        LayoutParams r0 = (LayoutParams) r5.getLayoutParams();
        int r9 = updateSpecWithExtra(r6, r0.leftMargin + this.mTmpRect.left, r0.rightMargin + this.mTmpRect.right);
        int r10 = updateSpecWithExtra(r7, r0.topMargin + this.mTmpRect.top, r0.bottomMargin + this.mTmpRect.bottom);
        if (r8 == false) goto L5;
        boolean r4 = shouldReMeasureChild(r5, r9, r10, r0);
    L6:
        if (r4 == false) goto L9;
        r5.measure(r9, r10);
        return;
    L9:
        return;
    L5:
        r4 = shouldMeasureChild(r5, r9, r10, r0);
        goto L6
    }

    private int updateSpecWithExtra(int r2, int r3, int r4) {
        if (r3 != 0) goto L5;
        if (r4 != 0) goto L5;
        return r2;
    L5:
        int r1 = View.MeasureSpec.getMode(r2);
        if (r1 == Integer.MIN_VALUE) goto L12;
        if (r1 == 1073741824) goto L12;
        return r2;
    L12:
        return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(r2) - r3) - r4), r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable r3) {
        if ((r3 instanceof SavedState) == false) goto L9;
        SavedState r4 = (SavedState) r3;
        this.mPendingSavedState = r4;
        if (this.mPendingScrollPosition == (-1)) goto L7;
        r4.invalidateAnchorPositionInfo();
        this.mPendingSavedState.invalidateSpanInfo();
    L7:
        requestLayout();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) goto L5;
        SavedState r0 = new SavedState();
        r0.mReverseLayout = this.mReverseLayout;
        r0.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
        r0.mLastLayoutRTL = this.mLastLayoutRTL;
        LazySpanLookup r1 = this.mLazySpanLookup;
        int r2 = 0;
        if (r1 != null) goto L9;
    L11:
        r0.mSpanLookupSize = 0;
    L13:
        if (getChildCount() > 0) goto L15;
        r0.mAnchorPosition = -1;
        r0.mVisibleAnchorPosition = -1;
        r0.mSpanOffsetsSize = 0;
    L32:
        return r0;
    L15:
        if (this.mLastLayoutFromEnd == false) goto L17;
        int r3 = getLastChildPosition();
    L18:
        r0.mAnchorPosition = r3;
        r0.mVisibleAnchorPosition = findFirstVisibleItemPositionInt();
        r0.mSpanOffsetsSize = this.mSpanCount;
        r0.mSpanOffsets = new int[this.mSpanCount];
    L20:
        if (r2 >= this.mSpanCount) goto L32;
        if (this.mLastLayoutFromEnd == false) goto L26;
        int r4 = this.mSpans[r2].getEndLine(Integer.MIN_VALUE);
        if (r4 == Integer.MIN_VALUE) goto L30;
        int r5 = this.mPrimaryOrientation.getEndAfterPadding();
    L29:
        r4 = r4 - r5;
    L30:
        r0.mSpanOffsets[r2] = r4;
        r2 = r2 + 1;
        goto L20
    L26:
        r4 = this.mSpans[r2].getStartLine(Integer.MIN_VALUE);
        if (r4 == Integer.MIN_VALUE) goto L30;
        r5 = this.mPrimaryOrientation.getStartAfterPadding();
        goto L29
    L17:
        r3 = getFirstChildPosition();
        goto L18
    L9:
        if (r1.mData == null) goto L11;
        r0.mSpanLookup = this.mLazySpanLookup.mData;
        r0.mSpanLookupSize = r0.mSpanLookup.length;
        r0.mFullSpanItems = this.mLazySpanLookup.mFullSpanItems;
        goto L13
    L5:
        return new SavedState(this.mPendingSavedState);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent r3) {
        super.onInitializeAccessibilityEvent(r3);
        if (getChildCount() <= 0) goto L13;
        View r1 = findFirstVisibleItemClosestToStart(false);
        View r0 = findFirstVisibleItemClosestToEnd(false);
        if (r1 == null) goto L14;
        if (r0 == null) goto L16;
        int r2 = getPosition(r1);
        int r4 = getPosition(r0);
        if (r2 >= r4) goto L11;
        r3.setFromIndex(r2);
        r3.setToIndex(r4);
        return;
    L11:
        r3.setFromIndex(r4);
        r3.setToIndex(r2);
        return;
    L16:
        return;
    L14:
        return;
    }

    int findFirstVisibleItemPositionInt() {
        if (this.mShouldReverseLayout == false) goto L5;
        View r0 = findFirstVisibleItemClosestToEnd(true);
    L6:
        if (r0 != null) goto L9;
        return -1;
    L9:
        return getPosition(r0);
    L5:
        r0 = findFirstVisibleItemClosestToStart(true);
        goto L6
    }

    View findFirstVisibleItemClosestToStart(boolean r9) {
        int r0 = this.mPrimaryOrientation.getStartAfterPadding();
        int r1 = this.mPrimaryOrientation.getEndAfterPadding();
        int r2 = getChildCount();
        View r3 = null;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L15;
        View r5 = getChildAt(r4);
        int r6 = this.mPrimaryOrientation.getDecoratedStart(r5);
        if (this.mPrimaryOrientation.getDecoratedEnd(r5) <= r0) goto L14;
        if (r6 >= r1) goto L14;
        if (r6 >= r0) goto L13;
        if (r9 == false) goto L13;
        if (r3 != null) goto L14;
        r3 = r5;
    L13:
        return r5;
    L14:
        r4 = r4 + 1;
        goto L3
    L15:
        return r3;
    }

    View findFirstVisibleItemClosestToEnd(boolean r8) {
        int r0 = this.mPrimaryOrientation.getStartAfterPadding();
        int r1 = this.mPrimaryOrientation.getEndAfterPadding();
        int r2 = getChildCount() - 1;
        View r3 = null;
    L3:
        if (r2 < 0) goto L15;
        View r4 = getChildAt(r2);
        int r5 = this.mPrimaryOrientation.getDecoratedStart(r4);
        int r6 = this.mPrimaryOrientation.getDecoratedEnd(r4);
        if (r6 <= r0) goto L14;
        if (r5 >= r1) goto L14;
        if (r6 <= r1) goto L13;
        if (r8 == false) goto L13;
        if (r3 != null) goto L14;
        r3 = r4;
    L13:
        return r4;
    L14:
        r2 = r2 - 1;
        goto L3
    L15:
        return r3;
    }

    private void fixEndGap(RecyclerView.Recycler r3, RecyclerView.State r4, boolean r5) {
        int r1 = getMaxEnd(Integer.MIN_VALUE);
        if (r1 != Integer.MIN_VALUE) goto L5;
        return;
    L5:
        int r0 = this.mPrimaryOrientation.getEndAfterPadding() - r1;
        if (r0 <= 0) goto L12;
        int r2 = r0 - (-scrollBy(-r0, r3, r4));
        if (r5 == false) goto L13;
        if (r2 <= 0) goto L14;
        this.mPrimaryOrientation.offsetChildren(r2);
        return;
    L14:
        return;
    L13:
        return;
    }

    private void fixStartGap(RecyclerView.Recycler r3, RecyclerView.State r4, boolean r5) {
        int r1 = getMinStart(Integer.MAX_VALUE);
        if (r1 != Integer.MAX_VALUE) goto L5;
        return;
    L5:
        int r2 = r1 - this.mPrimaryOrientation.getStartAfterPadding();
        if (r2 <= 0) goto L12;
        int r6 = r2 - scrollBy(r2, r3, r4);
        if (r5 == false) goto L13;
        if (r6 <= 0) goto L14;
        this.mPrimaryOrientation.offsetChildren(-r6);
        return;
    L14:
        return;
    L13:
        return;
    }

    private void updateLayoutState(int r5, RecyclerView.State r6) {
        boolean r1 = false;
        this.mLayoutState.mAvailable = 0;
        this.mLayoutState.mCurrentPosition = r5;
        if (isSmoothScrolling() == false) goto L13;
        int r7 = r6.getTargetScrollPosition();
        if (r7 == (-1)) goto L13;
        boolean r0 = this.mShouldReverseLayout;
        if (r7 >= r5) goto L9;
        boolean r8 = true;
    L10:
        if (r0 != r8) goto L12;
        int r9 = this.mPrimaryOrientation.getTotalSpace();
        int r10 = 0;
    L15:
        if (getClipToPadding() == false) goto L17;
        this.mLayoutState.mStartLine = this.mPrimaryOrientation.getStartAfterPadding() - r10;
        this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEndAfterPadding() + r9;
    L18:
        this.mLayoutState.mStopInFocusable = false;
        this.mLayoutState.mRecycle = true;
        LayoutState r11 = this.mLayoutState;
        if (this.mPrimaryOrientation.getMode() == 0) goto L21;
    L23:
        r11.mInfinite = r1;
        return;
    L21:
        if (this.mPrimaryOrientation.getEnd() != 0) goto L23;
        r1 = true;
        goto L23
    L17:
        this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEnd() + r9;
        this.mLayoutState.mStartLine = -r10;
        goto L18
    L12:
        r10 = this.mPrimaryOrientation.getTotalSpace();
        r9 = 0;
        goto L15
    L9:
        r8 = false;
    L13:
        r9 = 0;
        r10 = 0;
        goto L15
    }

    private void setLayoutStateDirection(int r4) {
        this.mLayoutState.mLayoutDirection = r4;
        LayoutState r0 = this.mLayoutState;
        boolean r3 = this.mShouldReverseLayout;
        int r1 = 1;
        if (r4 != (-1)) goto L5;
        boolean r5 = true;
    L6:
        if (r3 == r5) goto L9;
        r1 = -1;
    L9:
        r0.mItemDirection = r1;
        return;
    L5:
        r5 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenHorizontal(int r3) {
        super.offsetChildrenHorizontal(r3);
        int r0 = 0;
    L4:
        if (r0 >= this.mSpanCount) goto L6;
        this.mSpans[r0].onOffset(r3);
        r0 = r0 + 1;
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenVertical(int r3) {
        super.offsetChildrenVertical(r3);
        int r0 = 0;
    L4:
        if (r0 >= this.mSpanCount) goto L6;
        this.mSpans[r0].onOffset(r3);
        r0 = r0 + 1;
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView r1, int r2, int r3) {
        handleUpdate(r2, r3, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView r1, int r2, int r3) {
        handleUpdate(r2, r3, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView r1) {
        this.mLazySpanLookup.clear();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView r1, int r2, int r3, int r4) {
        handleUpdate(r2, r3, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView r1, int r2, int r3, Object r4) {
        handleUpdate(r2, r3, 4);
    }

    private void handleUpdate(int r7, int r8, int r9) {
        if (this.mShouldReverseLayout == false) goto L5;
        int r0 = getLastChildPosition();
    L7:
        if (r9 != 8) goto L11;
        if (r7 >= r8) goto L10;
        int r2 = r8 + 1;
    L12:
        int r3 = r7;
    L13:
        this.mLazySpanLookup.invalidateAfter(r3);
        if (r9 != 1) goto L16;
        this.mLazySpanLookup.offsetForAddition(r7, r8);
    L22:
        if (r2 > r0) goto L25;
        return;
    L25:
        if (this.mShouldReverseLayout == false) goto L27;
        int r10 = getFirstChildPosition();
    L28:
        if (r3 > r10) goto L31;
        requestLayout();
        return;
    L31:
        return;
    L27:
        r10 = getLastChildPosition();
        goto L28
    L16:
        if (r9 == 2) goto L20;
        if (r9 != 8) goto L22;
        this.mLazySpanLookup.offsetForRemoval(r7, 1);
        this.mLazySpanLookup.offsetForAddition(r8, 1);
        goto L22
    L20:
        this.mLazySpanLookup.offsetForRemoval(r7, r8);
        goto L22
    L10:
        r2 = r7 + 1;
        r3 = r8;
        goto L13
    L11:
        r2 = r7 + r8;
        goto L12
    L5:
        r0 = getFirstChildPosition();
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r16v0, types: [androidx.recyclerview.widget.StaggeredGridLayoutManager] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int fill(RecyclerView.Recycler r17, LayoutState r18, RecyclerView.State r19) {
        ?? r9 = 0;
        this.mRemainingSpans.set(0, this.mSpanCount, true);
        if (this.mLayoutState.mInfinite == false) goto L9;
        if (r18.mLayoutDirection != 1) goto L7;
        int r0 = Integer.MAX_VALUE;
    L12:
        int r11 = r0;
        updateAllRemainingSpans(r18.mLayoutDirection, r11);
        if (this.mShouldReverseLayout == false) goto L15;
        int r1 = this.mPrimaryOrientation.getEndAfterPadding();
    L16:
        int r12 = r1;
        ?? r2 = false;
    L18:
        if (r18.hasMore(r19) == false) goto L108;
        if (this.mLayoutState.mInfinite == false) goto L22;
    L23:
        View r13 = r18.next(r17);
        LayoutParams r14 = (LayoutParams) r13.getLayoutParams();
        int r3 = r14.getViewLayoutPosition();
        int r4 = this.mLazySpanLookup.getSpan(r3);
        if (r4 != (-1)) goto L26;
        ?? r5 = 1;
    L27:
        if (r5 != 0) goto L29;
        Span r6 = this.mSpans[r4];
    L34:
        Span r15 = r6;
        r14.mSpan = r15;
        if (r18.mLayoutDirection != 1) goto L37;
        addView(r13);
    L38:
        measureChildWithDecorationsAndMargin(r13, r14, r9);
        if (r18.mLayoutDirection != 1) goto L51;
        if (r14.mFullSpan == false) goto L43;
        int r7 = getMaxEnd(r12);
    L44:
        int r8 = this.mPrimaryOrientation.getDecoratedMeasurement(r13) + r7;
        if (r5 != 0) goto L47;
    L49:
        int r10 = r8;
        int r16 = r7;
    L61:
        if (r14.mFullSpan == true) goto L63;
    L76:
        attachViewToSpans(r13, r14, r18);
        if (isLayoutRTL() == false) goto L86;
        if (this.mOrientation != 1) goto L86;
        if (r14.mFullSpan == false) goto L83;
        int r20 = this.mSecondaryOrientation.getEndAfterPadding();
    L84:
        int r21 = r20;
        int r22 = r20 - this.mSecondaryOrientation.getDecoratedMeasurement(r13);
    L91:
        if (this.mOrientation != 1) goto L93;
        layoutDecoratedWithMargins(r13, r22, r16, r21, r10);
    L95:
        if (r14.mFullSpan == false) goto L97;
        updateAllRemainingSpans(this.mLayoutState.mLayoutDirection, r11);
    L98:
        recycle(r17, this.mLayoutState);
        if (this.mLayoutState.mStopInFocusable == true) goto L101;
    L106:
        boolean r23 = false;
    L107:
        r9 = r23;
        r2 = true;
        goto L18
    L101:
        if (r13.hasFocusable() == false) goto L106;
        if (r14.mFullSpan == false) goto L105;
        this.mRemainingSpans.clear();
        goto L106
    L105:
        r23 = false;
        this.mRemainingSpans.set(r15.mIndex, false);
        goto L107
    L97:
        updateRemainingSpans(r15, this.mLayoutState.mLayoutDirection, r11);
        goto L98
    L93:
        layoutDecoratedWithMargins(r13, r16, r22, r10, r21);
        goto L95
    L83:
        r20 = this.mSecondaryOrientation.getEndAfterPadding() - (((this.mSpanCount - 1) - r15.mIndex) * this.mSizePerSpan);
    L86:
        if (r14.mFullSpan == false) goto L88;
        int r24 = this.mSecondaryOrientation.getStartAfterPadding();
    L89:
        r22 = r24;
        r21 = this.mSecondaryOrientation.getDecoratedMeasurement(r13) + r24;
        goto L91
    L88:
        r24 = (r15.mIndex * this.mSizePerSpan) + this.mSecondaryOrientation.getStartAfterPadding();
        goto L89
    L63:
        if (r18.mItemDirection != (-1)) goto L76;
        if (r5 == 0) goto L67;
        this.mLaidOutInvalidFullSpan = true;
        goto L76
    L67:
        if (r18.mLayoutDirection != 1) goto L69;
        boolean r25 = areAllEndsEqual();
    L71:
        if ((!r25) == false) goto L76;
        LazySpanLookup.FullSpanItem r26 = this.mLazySpanLookup.getFullSpanItem(r3);
        if (r26 == null) goto L75;
        r26.mHasUnwantedGapAfter = true;
    L75:
        this.mLaidOutInvalidFullSpan = true;
        goto L76
    L69:
        r25 = areAllStartsEqual();
        goto L71
    L47:
        if (r14.mFullSpan == false) goto L49;
        LazySpanLookup.FullSpanItem r27 = createFullSpanItemFromEnd(r7);
        r27.mGapDir = -1;
        r27.mPosition = r3;
        this.mLazySpanLookup.addFullSpanItem(r27);
        goto L49
    L43:
        r7 = r15.getEndLine(r12);
        goto L44
    L51:
        if (r14.mFullSpan == false) goto L53;
        int r28 = getMinStart(r12);
    L54:
        r16 = r28 - this.mPrimaryOrientation.getDecoratedMeasurement(r13);
        if (r5 != 0) goto L57;
    L59:
        r10 = r28;
        goto L61
    L57:
        if (r14.mFullSpan == false) goto L59;
        LazySpanLookup.FullSpanItem r29 = createFullSpanItemFromStart(r28);
        r29.mGapDir = 1;
        r29.mPosition = r3;
        this.mLazySpanLookup.addFullSpanItem(r29);
        goto L59
    L53:
        r28 = r15.getStartLine(r12);
        goto L54
    L37:
        addView(r13, r9);
        goto L38
    L29:
        if (r14.mFullSpan == false) goto L31;
        r6 = this.mSpans[r9];
    L32:
        this.mLazySpanLookup.setSpan(r3, r6);
        goto L34
    L31:
        r6 = getNextSpan(r18);
        goto L32
    L26:
        r5 = r9;
        goto L27
    L22:
        if (this.mRemainingSpans.isEmpty() == false) goto L23;
    L108:
        ?? r30 = r9;
        if (r2 == true) goto L112;
        recycle(r17, this.mLayoutState);
    L112:
        if (this.mLayoutState.mLayoutDirection != (-1)) goto L114;
        int r31 = this.mPrimaryOrientation.getStartAfterPadding() - getMinStart(this.mPrimaryOrientation.getStartAfterPadding());
    L115:
        if (r31 <= 0) goto L118;
        return Math.min(r18.mAvailable, r31);
    L118:
        return r30 == true ? 1 : 0;
    L114:
        r31 = getMaxEnd(this.mPrimaryOrientation.getEndAfterPadding()) - this.mPrimaryOrientation.getEndAfterPadding();
        goto L115
    L15:
        r1 = this.mPrimaryOrientation.getStartAfterPadding();
        goto L16
    L7:
        r0 = Integer.MIN_VALUE;
        goto L12
    L9:
        if (r18.mLayoutDirection != 1) goto L11;
        r0 = r18.mEndLine + r18.mAvailable;
        goto L12
    L11:
        r0 = r18.mStartLine - r18.mAvailable;
        goto L12
    }

    private LazySpanLookup.FullSpanItem createFullSpanItemFromEnd(int r5) {
        LazySpanLookup.FullSpanItem r0 = new LazySpanLookup.FullSpanItem();
        r0.mGapPerSpan = new int[this.mSpanCount];
        int r1 = 0;
    L4:
        if (r1 >= this.mSpanCount) goto L6;
        r0.mGapPerSpan[r1] = r5 - this.mSpans[r1].getEndLine(r5);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    private LazySpanLookup.FullSpanItem createFullSpanItemFromStart(int r5) {
        LazySpanLookup.FullSpanItem r0 = new LazySpanLookup.FullSpanItem();
        r0.mGapPerSpan = new int[this.mSpanCount];
        int r1 = 0;
    L4:
        if (r1 >= this.mSpanCount) goto L6;
        r0.mGapPerSpan[r1] = this.mSpans[r1].getStartLine(r5) - r5;
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    private void attachViewToSpans(View r2, LayoutParams r3, LayoutState r4) {
        if (r4.mLayoutDirection != 1) goto L9;
        if (r3.mFullSpan == false) goto L7;
        appendViewToAllSpans(r2);
        return;
    L7:
        r3.mSpan.appendToSpan(r2);
        return;
    L9:
        if (r3.mFullSpan == false) goto L11;
        prependViewToAllSpans(r2);
        return;
    L11:
        r3.mSpan.prependToSpan(r2);
    }

    private void recycle(RecyclerView.Recycler r3, LayoutState r4) {
        if (r4.mRecycle == true) goto L5;
        return;
    L5:
        if (r4.mInfinite == false) goto L8;
        return;
    L8:
        if (r4.mAvailable != 0) goto L14;
        if (r4.mLayoutDirection != (-1)) goto L12;
        recycleFromEnd(r3, r4.mEndLine);
        return;
    L12:
        recycleFromStart(r3, r4.mStartLine);
        return;
    L14:
        if (r4.mLayoutDirection != (-1)) goto L20;
        int r0 = r4.mStartLine - getMaxStart(r4.mStartLine);
        if (r0 >= 0) goto L18;
        int r5 = r4.mEndLine;
    L19:
        recycleFromEnd(r3, r5);
        return;
    L18:
        r5 = r4.mEndLine - Math.min(r0, r4.mAvailable);
        goto L19
    L20:
        int r1 = getMinEnd(r4.mEndLine) - r4.mEndLine;
        if (r1 >= 0) goto L23;
        int r6 = r4.mStartLine;
    L24:
        recycleFromStart(r3, r6);
        return;
    L23:
        int r2 = r4.mStartLine;
        r6 = Math.min(r1, r4.mAvailable) + r2;
        goto L24
    }

    private void appendViewToAllSpans(View r3) {
        int r0 = this.mSpanCount - 1;
    L3:
        if (r0 < 0) goto L5;
        this.mSpans[r0].appendToSpan(r3);
        r0 = r0 - 1;
        goto L3
    }

    private void prependViewToAllSpans(View r3) {
        int r0 = this.mSpanCount - 1;
    L3:
        if (r0 < 0) goto L5;
        this.mSpans[r0].prependToSpan(r3);
        r0 = r0 - 1;
        goto L3
    }

    private void updateAllRemainingSpans(int r3, int r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.mSpanCount) goto L10;
        if (this.mSpans[r0].mViews.isEmpty() == true) goto L9;
        updateRemainingSpans(this.mSpans[r0], r3, r4);
    L9:
        r0 = r0 + 1;
        goto L4
    }

    private void updateRemainingSpans(Span r4, int r5, int r6) {
        int r0 = r4.getDeletedSize();
        if (r5 != (-1)) goto L8;
        if ((r4.getStartLine() + r0) > r6) goto L11;
        this.mRemainingSpans.set(r4.mIndex, false);
        return;
    L11:
        return;
    L8:
        if ((r4.getEndLine() - r0) < r6) goto L13;
        this.mRemainingSpans.set(r4.mIndex, false);
        return;
    }

    private int getMaxStart(int r4) {
        int r0 = this.mSpans[0].getStartLine(r4);
        int r1 = 1;
    L4:
        if (r1 >= this.mSpanCount) goto L9;
        int r2 = this.mSpans[r1].getStartLine(r4);
        if (r2 <= r0) goto L8;
        r0 = r2;
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    private int getMinStart(int r4) {
        int r0 = this.mSpans[0].getStartLine(r4);
        int r1 = 1;
    L4:
        if (r1 >= this.mSpanCount) goto L9;
        int r2 = this.mSpans[r1].getStartLine(r4);
        if (r2 >= r0) goto L8;
        r0 = r2;
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    boolean areAllEndsEqual() {
        int r0 = this.mSpans[0].getEndLine(Integer.MIN_VALUE);
        int r4 = 1;
    L4:
        if (r4 >= this.mSpanCount) goto L9;
        if (this.mSpans[r4].getEndLine(Integer.MIN_VALUE) != r0) goto L7;
        r4 = r4 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    boolean areAllStartsEqual() {
        int r0 = this.mSpans[0].getStartLine(Integer.MIN_VALUE);
        int r4 = 1;
    L4:
        if (r4 >= this.mSpanCount) goto L9;
        if (this.mSpans[r4].getStartLine(Integer.MIN_VALUE) != r0) goto L7;
        r4 = r4 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    private int getMaxEnd(int r4) {
        int r0 = this.mSpans[0].getEndLine(r4);
        int r1 = 1;
    L4:
        if (r1 >= this.mSpanCount) goto L9;
        int r2 = this.mSpans[r1].getEndLine(r4);
        if (r2 <= r0) goto L8;
        r0 = r2;
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    private int getMinEnd(int r4) {
        int r0 = this.mSpans[0].getEndLine(r4);
        int r1 = 1;
    L4:
        if (r1 >= this.mSpanCount) goto L9;
        int r2 = this.mSpans[r1].getEndLine(r4);
        if (r2 >= r0) goto L8;
        r0 = r2;
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    private void recycleFromStart(RecyclerView.Recycler r6, int r7) {
    L3:
        if (getChildCount() <= 0) goto L25;
        int r0 = 0;
        View r1 = getChildAt(0);
        if (this.mPrimaryOrientation.getDecoratedEnd(r1) > r7) goto L34;
        if (this.mPrimaryOrientation.getTransformedEndWithDecoration(r1) > r7) goto L35;
        LayoutParams r2 = (LayoutParams) r1.getLayoutParams();
        if (r2.mFullSpan == false) goto L21;
        int r3 = 0;
    L12:
        if (r3 >= this.mSpanCount) goto L18;
        if (this.mSpans[r3].mViews.size() == 1) goto L15;
        r3 = r3 + 1;
        goto L12
    L15:
        return;
    L18:
        if (r0 >= this.mSpanCount) goto L24;
        this.mSpans[r0].popStart();
        r0 = r0 + 1;
    L24:
        removeAndRecycleView(r1, r6);
        goto L3
    L21:
        if (r2.mSpan.mViews.size() == 1) goto L22;
        r2.mSpan.popStart();
        goto L24
    L22:
        return;
    L35:
        return;
    L34:
        return;
    }

    private void recycleFromEnd(RecyclerView.Recycler r7, int r8) {
        int r0 = getChildCount() - 1;
    L3:
        if (r0 < 0) goto L25;
        View r2 = getChildAt(r0);
        if (this.mPrimaryOrientation.getDecoratedStart(r2) < r8) goto L34;
        if (this.mPrimaryOrientation.getTransformedStartWithDecoration(r2) < r8) goto L35;
        LayoutParams r3 = (LayoutParams) r2.getLayoutParams();
        if (r3.mFullSpan == false) goto L21;
        int r4 = 0;
        int r5 = 0;
    L12:
        if (r5 >= this.mSpanCount) goto L18;
        if (this.mSpans[r5].mViews.size() == 1) goto L15;
        r5 = r5 + 1;
        goto L12
    L15:
        return;
    L18:
        if (r4 >= this.mSpanCount) goto L24;
        this.mSpans[r4].popEnd();
        r4 = r4 + 1;
    L24:
        removeAndRecycleView(r2, r7);
        r0 = r0 - 1;
        goto L3
    L21:
        if (r3.mSpan.mViews.size() == 1) goto L22;
        r3.mSpan.popEnd();
        goto L24
    L22:
        return;
    L35:
        return;
    L34:
        return;
    }

    private boolean preferLastSpan(int r5) {
        if (this.mOrientation != 0) goto L12;
        if (r5 != (-1)) goto L6;
        boolean r6 = true;
    L8:
        if (r6 == this.mShouldReverseLayout) goto L11;
        return true;
    L11:
        return false;
    L6:
        r6 = false;
        goto L8
    L12:
        if (r5 != (-1)) goto L14;
        boolean r7 = true;
    L16:
        if (r7 != this.mShouldReverseLayout) goto L18;
        boolean r8 = true;
    L20:
        if (r8 != isLayoutRTL()) goto L23;
        return true;
    L23:
        return false;
    L18:
        r8 = false;
        goto L20
    L14:
        r7 = false;
        goto L16
    }

    private Span getNextSpan(LayoutState r8) {
        if (preferLastSpan(r8.mLayoutDirection) == false) goto L5;
        int r0 = this.mSpanCount - 1;
        int r2 = -1;
        int r3 = -1;
    L6:
        Span r4 = null;
        if (r8.mLayoutDirection != 1) goto L15;
        int r9 = this.mPrimaryOrientation.getStartAfterPadding();
        int r1 = Integer.MAX_VALUE;
    L9:
        if (r0 == r2) goto L14;
        Span r5 = this.mSpans[r0];
        int r6 = r5.getEndLine(r9);
        if (r6 >= r1) goto L13;
        r4 = r5;
        r1 = r6;
    L13:
        r0 = r0 + r3;
        goto L9
    L14:
        return r4;
    L15:
        int r10 = this.mPrimaryOrientation.getEndAfterPadding();
        int r7 = Integer.MIN_VALUE;
    L16:
        if (r0 == r2) goto L21;
        Span r11 = this.mSpans[r0];
        int r12 = r11.getStartLine(r10);
        if (r12 <= r7) goto L20;
        r4 = r11;
        r7 = r12;
    L20:
        r0 = r0 + r3;
        goto L16
    L21:
        return r4;
    L5:
        r2 = this.mSpanCount;
        r0 = 0;
        r3 = 1;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.mOrientation == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.mOrientation != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int r1, RecyclerView.Recycler r2, RecyclerView.State r3) {
        return scrollBy(r1, r2, r3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int r1, RecyclerView.Recycler r2, RecyclerView.State r3) {
        return scrollBy(r1, r2, r3);
    }

    private int calculateScrollDirectionForPosition(int r4) {
        if (getChildCount() != 0) goto L9;
        if (this.mShouldReverseLayout == true) goto L7;
        return -1;
    L7:
        return 1;
    L9:
        if (r4 >= getFirstChildPosition()) goto L11;
        boolean r5 = true;
    L13:
        if (r5 == this.mShouldReverseLayout) goto L16;
        return -1;
    L16:
        return 1;
    L11:
        r5 = false;
        goto L13
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int r3) {
        int r4 = calculateScrollDirectionForPosition(r3);
        PointF r0 = new PointF();
        if (r4 != 0) goto L7;
        return null;
    L7:
        if (this.mOrientation != 0) goto L9;
        r0.x = r4;
        r0.y = 0.0f;
    L10:
        return r0;
    L9:
        r0.x = 0.0f;
        r0.y = r4;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView r1, RecyclerView.State r2, int r3) {
        LinearSmoothScroller r4 = new LinearSmoothScroller(r1.getContext());
        r4.setTargetPosition(r3);
        startSmoothScroll(r4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int r2) {
        SavedState r0 = this.mPendingSavedState;
        if (r0 != null) goto L5;
    L7:
        this.mPendingScrollPosition = r2;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        requestLayout();
        return;
    L5:
        if (r0.mAnchorPosition == r2) goto L7;
        this.mPendingSavedState.invalidateAnchorPositionInfo();
        goto L7
    }

    public void scrollToPositionWithOffset(int r2, int r3) {
        SavedState r0 = this.mPendingSavedState;
        if (r0 == null) goto L5;
        r0.invalidateAnchorPositionInfo();
    L5:
        this.mPendingScrollPosition = r2;
        this.mPendingScrollPositionOffset = r3;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectAdjacentPrefetchPositions(int r5, int r6, RecyclerView.State r7, RecyclerView.LayoutManager.LayoutPrefetchRegistry r8) {
        if (this.mOrientation == 0) goto L7;
        r5 = r6;
    L7:
        if (getChildCount() == 0) goto L31;
        if (r5 == 0) goto L37;
        prepareLayoutStateForDelta(r5, r7);
        int[] r9 = this.mPrefetchDistances;
        if (r9 != null) goto L13;
    L14:
        this.mPrefetchDistances = new int[this.mSpanCount];
    L15:
        int r10 = 0;
        int r11 = 0;
        int r0 = 0;
    L17:
        if (r11 >= this.mSpanCount) goto L26;
        if (this.mLayoutState.mItemDirection != (-1)) goto L21;
        int r1 = this.mLayoutState.mStartLine;
        int r2 = this.mSpans[r11].getStartLine(this.mLayoutState.mStartLine);
    L22:
        int r3 = r1 - r2;
        if (r3 < 0) goto L25;
        this.mPrefetchDistances[r0] = r3;
        r0 = r0 + 1;
    L25:
        r11 = r11 + 1;
        goto L17
    L21:
        r1 = this.mSpans[r11].getEndLine(this.mLayoutState.mEndLine);
        r2 = this.mLayoutState.mEndLine;
        goto L22
    L26:
        Arrays.sort(this.mPrefetchDistances, 0, r0);
    L27:
        if (r10 >= r0) goto L38;
        if (this.mLayoutState.hasMore(r7) == false) goto L39;
        r8.addPosition(this.mLayoutState.mCurrentPosition, this.mPrefetchDistances[r10]);
        this.mLayoutState.mCurrentPosition += this.mLayoutState.mItemDirection;
        r10 = r10 + 1;
        goto L27
    L39:
        return;
    L38:
        return;
    L13:
        if (r9.length >= this.mSpanCount) goto L15;
    L37:
        return;
    }

    void prepareLayoutStateForDelta(int r5, RecyclerView.State r6) {
        if (r5 <= 0) goto L5;
        int r1 = getLastChildPosition();
        int r2 = 1;
    L6:
        this.mLayoutState.mRecycle = true;
        updateLayoutState(r1, r6);
        setLayoutStateDirection(r2);
        LayoutState r7 = this.mLayoutState;
        r7.mCurrentPosition = r1 + r7.mItemDirection;
        this.mLayoutState.mAvailable = Math.abs(r5);
        return;
    L5:
        r1 = getFirstChildPosition();
        r2 = -1;
        goto L6
    }

    int scrollBy(int r3, RecyclerView.Recycler r4, RecyclerView.State r5) {
        if (getChildCount() == 0) goto L14;
        if (r3 == 0) goto L14;
        prepareLayoutStateForDelta(r3, r5);
        int r6 = fill(r4, this.mLayoutState, r5);
        if (this.mLayoutState.mAvailable < r6) goto L12;
        if (r3 >= 0) goto L11;
        r3 = -r6;
        goto L12
    L11:
        r3 = r6;
    L12:
        this.mPrimaryOrientation.offsetChildren(-r3);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        this.mLayoutState.mAvailable = 0;
        recycle(r4, this.mLayoutState);
        return r3;
    L14:
        return 0;
    }

    int getLastChildPosition() {
        int r0 = getChildCount();
        if (r0 != 0) goto L6;
        return 0;
    L6:
        return getPosition(getChildAt(r0 - 1));
    }

    int getFirstChildPosition() {
        if (getChildCount() != 0) goto L6;
        return 0;
    L6:
        return getPosition(getChildAt(0));
    }

    private int findFirstReferenceChildPosition(int r5) {
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        int r3 = getPosition(getChildAt(r2));
        if (r3 < 0) goto L8;
        if (r3 >= r5) goto L8;
        return r3;
    L8:
        r2 = r2 + 1;
        goto L3
    L9:
        return 0;
    }

    private int findLastReferenceChildPosition(int r3) {
        int r0 = getChildCount() - 1;
    L3:
        if (r0 < 0) goto L9;
        int r1 = getPosition(getChildAt(r0));
        if (r1 < 0) goto L8;
        if (r1 >= r3) goto L8;
        return r1;
    L8:
        r0 = r0 - 1;
        goto L3
    L9:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation != 0) goto L7;
        return new LayoutParams(-2, -1);
    L7:
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context r1, AttributeSet r2) {
        return new LayoutParams(r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r1);
    L7:
        return new LayoutParams(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams r1) {
        return r1 instanceof LayoutParams;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View r9, int r10, RecyclerView.Recycler r11, RecyclerView.State r12) {
        if (getChildCount() != 0) goto L5;
        return null;
    L5:
        View r13 = findContainingItemView(r9);
        if (r13 != null) goto L8;
        return null;
    L8:
        resolveShouldLayoutReverse();
        int r14 = convertFocusDirectionToLayoutDirection(r10);
        if (r14 != Integer.MIN_VALUE) goto L11;
        return null;
    L11:
        LayoutParams r0 = (LayoutParams) r13.getLayoutParams();
        boolean r2 = r0.mFullSpan;
        Span r1 = r0.mSpan;
        if (r14 != 1) goto L14;
        int r4 = getLastChildPosition();
    L15:
        updateLayoutState(r4, r12);
        setLayoutStateDirection(r14);
        LayoutState r5 = this.mLayoutState;
        r5.mCurrentPosition = r5.mItemDirection + r4;
        this.mLayoutState.mAvailable = (int) (this.mPrimaryOrientation.getTotalSpace() * MAX_SCROLL_FACTOR);
        this.mLayoutState.mStopInFocusable = true;
        int r6 = 0;
        this.mLayoutState.mRecycle = false;
        fill(r11, this.mLayoutState, r12);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        if (r2 == true) goto L22;
        View r15 = r1.getFocusableViewAfter(r4, r14);
        if (r15 == null) goto L22;
        if (r15 == r13) goto L22;
        return r15;
    L22:
        if (preferLastSpan(r14) == false) goto L30;
        int r16 = this.mSpanCount - 1;
    L24:
        if (r16 < 0) goto L38;
        View r17 = this.mSpans[r16].getFocusableViewAfter(r4, r14);
        if (r17 == null) goto L29;
        if (r17 == r13) goto L29;
        return r17;
    L29:
        r16 = r16 - 1;
    L38:
        boolean r18 = !this.mReverseLayout;
        if (r14 != (-1)) goto L41;
        boolean r19 = true;
    L42:
        if (r18 != r19) goto L44;
        boolean r110 = true;
    L45:
        if (r2 == true) goto L54;
        if (r110 == false) goto L48;
        int r111 = r1.findFirstPartiallyVisibleItemPosition();
    L49:
        View r112 = findViewByPosition(r111);
        if (r112 == null) goto L54;
        if (r112 == r13) goto L54;
        return r112;
    L48:
        r111 = r1.findLastPartiallyVisibleItemPosition();
    L54:
        if (preferLastSpan(r14) == false) goto L69;
        int r113 = this.mSpanCount - 1;
    L56:
        if (r113 < 0) goto L78;
        if (r113 == r1.mIndex) goto L67;
        if (r110 == false) goto L62;
        int r114 = this.mSpans[r113].findFirstPartiallyVisibleItemPosition();
    L63:
        View r115 = findViewByPosition(r114);
        if (r115 == null) goto L67;
        if (r115 == r13) goto L67;
        return r115;
    L62:
        r114 = this.mSpans[r113].findLastPartiallyVisibleItemPosition();
    L67:
        r113 = r113 - 1;
    L78:
        return null;
    L69:
        if (r6 >= this.mSpanCount) goto L78;
        if (r110 == false) goto L72;
        int r116 = this.mSpans[r6].findFirstPartiallyVisibleItemPosition();
    L73:
        View r117 = findViewByPosition(r116);
        if (r117 == null) goto L77;
        if (r117 == r13) goto L77;
        return r117;
    L77:
        r6 = r6 + 1;
        goto L69
    L72:
        r116 = this.mSpans[r6].findLastPartiallyVisibleItemPosition();
        goto L73
    L44:
        r110 = false;
        goto L45
    L41:
        r19 = false;
        goto L42
    L30:
        int r118 = 0;
    L32:
        if (r118 >= this.mSpanCount) goto L38;
        View r119 = this.mSpans[r118].getFocusableViewAfter(r4, r14);
        if (r119 == null) goto L37;
        if (r119 == r13) goto L37;
        return r119;
    L37:
        r118 = r118 + 1;
        goto L32
    L14:
        r4 = getFirstChildPosition();
        goto L15
    }

    private int convertFocusDirectionToLayoutDirection(int r5) {
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
}
