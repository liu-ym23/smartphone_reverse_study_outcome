package com.android.settings.stickylistheaders;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SectionIndexer;
import com.android.settings.R;
import com.android.settings.widget.HorizontalScrollListView;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class StickyListHeadersListView extends FrameLayout {
    private AdapterWrapper mAdapter;
    private boolean mAreHeadersSticky;
    private boolean mClippingToPadding;
    private AdapterWrapperDataSetObserver mDataSetObserver;
    private Drawable mDivider;
    private int mDividerHeight;
    private View mHeader;
    private Long mHeaderId;
    private Integer mHeaderOffset;
    private Integer mHeaderPosition;
    private boolean mIsDrawingListUnderStickyHeader;
    private WrapperViewList mList;
    private OnHeaderClickListener mOnHeaderClickListener;
    private AbsListView.OnScrollListener mOnScrollListenerDelegate;
    private OnStickyHeaderChangedListener mOnStickyHeaderChangedListener;
    private OnStickyHeaderOffsetChangedListener mOnStickyHeaderOffsetChangedListener;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private int mStickyHeaderTopOffset;

    private class AdapterWrapperDataSetObserver extends DataSetObserver {
        final /* synthetic */ StickyListHeadersListView this$0;

        private AdapterWrapperDataSetObserver(StickyListHeadersListView r1) {
            this.this$0 = r1;
        }

        /* synthetic */ AdapterWrapperDataSetObserver(StickyListHeadersListView r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            StickyListHeadersListView.access$600(this.this$0);
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            StickyListHeadersListView.access$600(this.this$0);
        }
    }

    private class AdapterWrapperHeaderClickHandler implements AdapterWrapper.OnHeaderClickListener {
        final /* synthetic */ StickyListHeadersListView this$0;

        private AdapterWrapperHeaderClickHandler(StickyListHeadersListView r1) {
            this.this$0 = r1;
        }

        /* synthetic */ AdapterWrapperHeaderClickHandler(StickyListHeadersListView r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.stickylistheaders.AdapterWrapper.OnHeaderClickListener
        public void onHeaderClick(View r9, int r10, long r11) {
            StickyListHeadersListView.access$500(this.this$0).onHeaderClick(this.this$0, r9, r10, r11, false);
        }
    }

    public interface OnHeaderClickListener {
        void onHeaderClick(StickyListHeadersListView r1, View r2, int r3, long r4, boolean r6);
    }

    public interface OnStickyHeaderChangedListener {
        void onStickyHeaderChanged(StickyListHeadersListView r1, View r2, int r3, long r4);
    }

    public interface OnStickyHeaderOffsetChangedListener {
        void onStickyHeaderOffsetChanged(StickyListHeadersListView r1, View r2, int r3);
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        private Parcelable wrappedState;

        /* synthetic */ SavedState(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ Parcelable access$1700(SavedState r0) {
            return r0.wrappedState;
        }

        SavedState(Parcelable r1, Parcelable r2) {
            super(r1);
            this.wrappedState = r2;
        }

        private SavedState(Parcel r2) {
            super(r2);
            this.wrappedState = r2.readParcelable(getClass().getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeParcelable(this.wrappedState, r2);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    private class WrapperListScrollListener implements AbsListView.OnScrollListener {
        final /* synthetic */ StickyListHeadersListView this$0;

        private WrapperListScrollListener(StickyListHeadersListView r1) {
            this.this$0 = r1;
        }

        /* synthetic */ WrapperListScrollListener(StickyListHeadersListView r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView r2, int r3, int r4, int r5) {
            if (StickyListHeadersListView.access$700(this.this$0) == null) goto L5;
            StickyListHeadersListView.access$700(this.this$0).onScroll(r2, r3, r4, r5);
        L5:
            StickyListHeadersListView r1 = this.this$0;
            StickyListHeadersListView.access$900(r1, StickyListHeadersListView.access$800(r1).getFixedFirstVisibleItem());
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView r2, int r3) {
            if (StickyListHeadersListView.access$700(this.this$0) == null) goto L6;
            StickyListHeadersListView.access$700(this.this$0).onScrollStateChanged(r2, r3);
            return;
        }
    }

    private class WrapperViewListLifeCycleListener implements WrapperViewList.LifeCycleListener {
        final /* synthetic */ StickyListHeadersListView this$0;

        private WrapperViewListLifeCycleListener(StickyListHeadersListView r1) {
            this.this$0 = r1;
        }

        /* synthetic */ WrapperViewListLifeCycleListener(StickyListHeadersListView r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.stickylistheaders.WrapperViewList.LifeCycleListener
        public void onDispatchDrawOccurred(Canvas r7) {
            if (StickyListHeadersListView.access$200(this.this$0) != null) goto L5;
            return;
        L5:
            if (StickyListHeadersListView.access$1000(this.this$0) == false) goto L7;
            r7.save();
            r7.clipRect(0, StickyListHeadersListView.access$1100(this.this$0), this.this$0.getRight(), this.this$0.getBottom());
            StickyListHeadersListView r6 = this.this$0;
            StickyListHeadersListView.access$1200(r6, r7, StickyListHeadersListView.access$200(r6), 0);
            r7.restore();
            return;
        L7:
            StickyListHeadersListView r8 = this.this$0;
            StickyListHeadersListView.access$1300(r8, r7, StickyListHeadersListView.access$200(r8), 0);
        }
    }

    static /* synthetic */ boolean access$1000(StickyListHeadersListView r0) {
        return r0.mClippingToPadding;
    }

    static /* synthetic */ int access$1100(StickyListHeadersListView r0) {
        return r0.mPaddingTop;
    }

    static /* synthetic */ boolean access$1200(StickyListHeadersListView r0, Canvas r1, View r2, long r3) {
        return r0.drawChild(r1, r2, r3);
    }

    static /* synthetic */ boolean access$1300(StickyListHeadersListView r0, Canvas r1, View r2, long r3) {
        return r0.drawChild(r1, r2, r3);
    }

    static /* synthetic */ View access$200(StickyListHeadersListView r0) {
        return r0.mHeader;
    }

    static /* synthetic */ Integer access$300(StickyListHeadersListView r0) {
        return r0.mHeaderPosition;
    }

    static /* synthetic */ Long access$400(StickyListHeadersListView r0) {
        return r0.mHeaderId;
    }

    static /* synthetic */ OnHeaderClickListener access$500(StickyListHeadersListView r0) {
        return r0.mOnHeaderClickListener;
    }

    static /* synthetic */ void access$600(StickyListHeadersListView r0) {
        r0.clearHeader();
    }

    static /* synthetic */ AbsListView.OnScrollListener access$700(StickyListHeadersListView r0) {
        return r0.mOnScrollListenerDelegate;
    }

    static /* synthetic */ WrapperViewList access$800(StickyListHeadersListView r0) {
        return r0.mList;
    }

    static /* synthetic */ void access$900(StickyListHeadersListView r0, int r1) {
        r0.updateOrClearHeader(r1);
    }

    public StickyListHeadersListView(Context r2) {
        this(r2, null);
    }

    public StickyListHeadersListView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public StickyListHeadersListView(Context r6, AttributeSet r7, int r8) {
        super(r6, r7, r8);
        this.mAreHeadersSticky = true;
        this.mClippingToPadding = true;
        this.mIsDrawingListUnderStickyHeader = true;
        this.mStickyHeaderTopOffset = 0;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        WrapperViewList r1 = new WrapperViewList(r6);
        this.mList = r1;
        r1.setScrollEnabled(true);
        this.mList.setScrollHandleId(R.id.scroll_handle_layout);
        this.mList.setLeftBtnsId(R.id.scroll_del_btn);
        this.mDivider = this.mList.getDivider();
        this.mDividerHeight = this.mList.getDividerHeight();
        AnonymousClass1 r2 = null;
        this.mList.setDivider(null);
        this.mList.setDividerHeight(0);
        if (r7 == null) goto L31;
        TypedArray r9 = r6.getTheme().obtainStyledAttributes(r7, R.styleable.StickyListHeadersListView, 0, 0);
        int r10 = r9.getDimensionPixelSize(1, 0);     // Catch: Throwable -> L28
        this.mPaddingLeft = r9.getDimensionPixelSize(2, r10);     // Catch: Throwable -> L28
        this.mPaddingTop = r9.getDimensionPixelSize(3, r10);     // Catch: Throwable -> L28
        this.mPaddingRight = r9.getDimensionPixelSize(4, r10);     // Catch: Throwable -> L28
        int r11 = r9.getDimensionPixelSize(5, r10);     // Catch: Throwable -> L28
        this.mPaddingBottom = r11;     // Catch: Throwable -> L28
        setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, r11);     // Catch: Throwable -> L28
        this.mClippingToPadding = r9.getBoolean(8, true);     // Catch: Throwable -> L28
        super.setClipToPadding(true);     // Catch: Throwable -> L28
        this.mList.setClipToPadding(this.mClippingToPadding);     // Catch: Throwable -> L28
        int r12 = r9.getInt(6, 512);     // Catch: Throwable -> L28
        WrapperViewList r3 = this.mList;     // Catch: Throwable -> L28
        if ((r12 & 512) == 0) goto L8;
        boolean r4 = true;
    L9:
        r3.setVerticalScrollBarEnabled(r4);     // Catch: Throwable -> L28
        WrapperViewList r5 = this.mList;     // Catch: Throwable -> L28
        if ((r12 & 256) == 0) goto L12;
        boolean r13 = true;
    L13:
        r5.setHorizontalScrollBarEnabled(r13);     // Catch: Throwable -> L28
        this.mList.setOverScrollMode(r9.getInt(18, 0));     // Catch: Throwable -> L28
        WrapperViewList r14 = this.mList;     // Catch: Throwable -> L28
        r14.setFadingEdgeLength(r9.getDimensionPixelSize(7, r14.getVerticalFadingEdgeLength()));     // Catch: Throwable -> L28
        int r15 = r9.getInt(20, 0);     // Catch: Throwable -> L28
        if (r15 != 4096) goto L17;
        this.mList.setVerticalFadingEdgeEnabled(false);     // Catch: Throwable -> L28
        this.mList.setHorizontalFadingEdgeEnabled(true);     // Catch: Throwable -> L28
    L20:
        WrapperViewList r16 = this.mList;     // Catch: Throwable -> L28
        r16.setCacheColorHint(r9.getColor(13, r16.getCacheColorHint()));     // Catch: Throwable -> L28
        WrapperViewList r17 = this.mList;     // Catch: Throwable -> L28
        r17.setChoiceMode(r9.getInt(16, r17.getChoiceMode()));     // Catch: Throwable -> L28
        this.mList.setDrawSelectorOnTop(r9.getBoolean(10, false));     // Catch: Throwable -> L28
        WrapperViewList r18 = this.mList;     // Catch: Throwable -> L28
        r18.setFastScrollEnabled(r9.getBoolean(17, r18.isFastScrollEnabled()));     // Catch: Throwable -> L28
        WrapperViewList r19 = this.mList;     // Catch: Throwable -> L28
        r19.setFastScrollAlwaysVisible(r9.getBoolean(19, r19.isFastScrollAlwaysVisible()));     // Catch: Throwable -> L28
        this.mList.setScrollBarStyle(r9.getInt(0, 0));     // Catch: Throwable -> L28
        if (r9.hasValue(9) == false) goto L23;
        this.mList.setSelector(r9.getDrawable(9));     // Catch: Throwable -> L28
    L23:
        WrapperViewList r20 = this.mList;     // Catch: Throwable -> L28
        r20.setScrollingCacheEnabled(r9.getBoolean(11, r20.isScrollingCacheEnabled()));     // Catch: Throwable -> L28
        if (r9.hasValue(14) == false) goto L26;
        this.mDivider = r9.getDrawable(14);     // Catch: Throwable -> L28
    L26:
        this.mDividerHeight = r9.getDimensionPixelSize(15, this.mDividerHeight);     // Catch: Throwable -> L28
        this.mList.setTranscriptMode(r9.getInt(12, 0));     // Catch: Throwable -> L28
        this.mAreHeadersSticky = r9.getBoolean(21, true);     // Catch: Throwable -> L28
        this.mIsDrawingListUnderStickyHeader = r9.getBoolean(22, true);     // Catch: Throwable -> L28
        r9.recycle();
        goto L31
    L17:
        if (r15 != 8192) goto L19;
        this.mList.setVerticalFadingEdgeEnabled(true);     // Catch: Throwable -> L28
        this.mList.setHorizontalFadingEdgeEnabled(false);     // Catch: Throwable -> L28
        goto L20
    L19:
        this.mList.setVerticalFadingEdgeEnabled(false);     // Catch: Throwable -> L28
        this.mList.setHorizontalFadingEdgeEnabled(false);     // Catch: Throwable -> L28
        goto L20
    L12:
        r13 = false;
        goto L13
    L8:
        r4 = false;
    L28:
        th = move-exception;
        r9.recycle();
        throw th;
    L31:
        this.mList.setLifeCycleListener(new WrapperViewListLifeCycleListener(this, r2));
        this.mList.setOnScrollListener(new WrapperListScrollListener(this, r2));
        addView(this.mList);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        measureHeader(this.mHeader);
    }

    private void ensureHeaderHasCorrectLayoutParams(View r4) {
        ViewGroup.LayoutParams r3 = r4.getLayoutParams();
        if (r3 != null) goto L6;
        r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return;
    L6:
        if (r3.height != (-1)) goto L8;
    L9:
        r3.height = -2;
        r3.width = -1;
        r4.setLayoutParams(r3);
        return;
    L8:
        if (r3.width == (-2)) goto L9;
    }

    private void measureHeader(View r3) {
        if (r3 == null) goto L5;
        measureChild(r3, View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - this.mPaddingLeft) - this.mPaddingRight, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        WrapperViewList r6 = this.mList;
        r6.layout(0, 0, r6.getMeasuredWidth(), getHeight());
        View r7 = this.mHeader;
        if (r7 == null) goto L6;
        int r8 = ((ViewGroup.MarginLayoutParams) r7.getLayoutParams()).topMargin + stickyHeaderTop();
        View r9 = this.mHeader;
        r9.layout(this.mPaddingLeft, r8, r9.getMeasuredWidth() + this.mPaddingLeft, this.mHeader.getMeasuredHeight() + r8);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r4) {
        if (this.mList.getVisibility() != 0) goto L5;
    L6:
        drawChild(r4, this.mList, 0);
        return;
    L5:
        if (this.mList.getAnimation() != null) goto L6;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchWindowFocusChanged(boolean r1) {
        super.dispatchWindowFocusChanged(r1);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private void clearHeader() {
        View r0 = this.mHeader;
        if (r0 == null) goto L6;
        removeView(r0);
        this.mHeader = null;
        this.mHeaderId = null;
        this.mHeaderPosition = null;
        this.mHeaderOffset = null;
        this.mList.setTopClippingLength(0);
        updateHeaderVisibilities();
        return;
    }

    private void updateOrClearHeader(int r7) {
        AdapterWrapper r0 = this.mAdapter;
        boolean r1 = false;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        if (r2 != 0) goto L8;
        return;
    L8:
        if (this.mAreHeadersSticky == false) goto L39;
        int r8 = r7 - this.mList.getHeaderViewsCount();
        if (this.mList.getChildCount() <= 0) goto L16;
        if (this.mList.getChildAt(0).getBottom() >= stickyHeaderTop()) goto L16;
        r8 = r8 + 1;
    L16:
        if (this.mList.getChildCount() == 0) goto L18;
        boolean r3 = true;
    L19:
        if (r3 == true) goto L21;
    L25:
        boolean r4 = false;
    L27:
        if (r8 > (r2 - 1)) goto L29;
        if (r8 < 0) goto L29;
    L30:
        if (r3 == false) goto L36;
        if (r1 == true) goto L36;
        if (r4 == true) goto L36;
        updateHeader(r8);
        return;
    L36:
        clearHeader();
        return;
    L29:
        r1 = true;
        goto L30
    L21:
        if (this.mList.getFirstVisiblePosition() != 0) goto L25;
        if (this.mList.getChildAt(0).getTop() < stickyHeaderTop()) goto L25;
        r4 = true;
        goto L27
    L18:
        r3 = false;
        goto L19
    L39:
        return;
    L5:
        r2 = r0.getCount();
        goto L6
    }

    private void updateHeader(int r8) {
        Integer r0 = this.mHeaderPosition;
        if (r0 != null) goto L5;
    L6:
        this.mHeaderPosition = Integer.valueOf(r8);
        long r1 = this.mAdapter.getHeaderId(r8);
        Long r2 = this.mHeaderId;
        if (r2 != null) goto L9;
    L10:
        this.mHeaderId = Long.valueOf(r1);
        View r3 = this.mAdapter.getHeaderView(this.mHeaderPosition.intValue(), this.mHeader, this);
        if (this.mHeader == r3) goto L16;
        if (r3 == null) goto L15;
        swapHeader(r3);
        goto L16
    L15:
        throw new NullPointerException("header may not be null");
    L16:
        ensureHeaderHasCorrectLayoutParams(this.mHeader);
        measureHeader(this.mHeader);
        OnStickyHeaderChangedListener r4 = this.mOnStickyHeaderChangedListener;
        if (r4 == null) goto L19;
        r4.onStickyHeaderChanged(this, this.mHeader, r8, this.mHeaderId.longValue());
    L19:
        this.mHeaderOffset = null;
    L20:
        int r9 = this.mHeader.getMeasuredHeight() + stickyHeaderTop();
        int r5 = 0;
        int r6 = 0;
    L22:
        if (r6 >= this.mList.getChildCount()) goto L38;
        View r7 = this.mList.getChildAt(r6);
        if (r7 == null) goto L37;
        if ((r7 instanceof WrapperView) == true) goto L29;
    L31:
        boolean r10 = false;
    L32:
        boolean r11 = this.mList.containsFooterView(r7);
        if (r7.getTop() < stickyHeaderTop()) goto L37;
        if (r10 == true) goto L36;
        if (r11 == false) goto L37;
    L36:
        r5 = Math.min(r7.getTop() - r9, 0);
        goto L38
    L29:
        if (((WrapperView) r7).hasHeader() == false) goto L31;
        r10 = true;
    L37:
        r6 = r6 + 1;
    L38:
        setHeaderOffet(r5);
        if (this.mIsDrawingListUnderStickyHeader == true) goto L41;
        this.mList.setTopClippingLength(this.mHeader.getMeasuredHeight() + this.mHeaderOffset.intValue());
    L41:
        updateHeaderVisibilities();
        return;
    L9:
        if (r2.longValue() == r1) goto L20;
    L5:
        if (r0.intValue() == r8) goto L20;
        goto L6
    }

    private void swapHeader(View r2) {
        View r0 = this.mHeader;
        if (r0 == null) goto L5;
        removeView(r0);
    L5:
        this.mHeader = r2;
        addView(r2);
        if (this.mOnHeaderClickListener == null) goto L8;
        this.mHeader.setOnClickListener(new AnonymousClass1(this));
    L8:
        this.mHeader.setClickable(true);
    }

    private void updateHeaderVisibilities() {
        View r0 = this.mHeader;
        if (r0 == null) goto L9;
        int r1 = r0.getMeasuredHeight();
        Integer r2 = this.mHeaderOffset;
        if (r2 == null) goto L7;
        int r3 = r2.intValue();
    L8:
        int r4 = (r1 + r3) + this.mStickyHeaderTopOffset;
    L10:
        int r5 = this.mList.getChildCount();
        int r6 = 0;
    L11:
        if (r6 >= r5) goto L27;
        View r7 = this.mList.getChildAt(r6);
        if ((r7 instanceof WrapperView) == false) goto L26;
        WrapperView r8 = (WrapperView) r7;
        if (r8.hasHeader() == false) goto L26;
        View r9 = r8.mHeader;
        if (r8.getTop() >= r4) goto L24;
        if (r9.getVisibility() != 0) goto L26;
        r9.setVisibility(4);
        goto L26
    L24:
        if (r9.getVisibility() != 4) goto L26;
        r9.setVisibility(0);
    L26:
        r6 = r6 + 1;
        goto L11
    L27:
        return;
    L7:
        r3 = 0;
        goto L8
    L9:
        r4 = stickyHeaderTop();
        goto L10
    }

    private void setHeaderOffet(int r3) {
        Integer r0 = this.mHeaderOffset;
        if (r0 != null) goto L5;
    L6:
        this.mHeaderOffset = Integer.valueOf(r3);
        this.mHeader.setTranslationY(this.mHeaderOffset.intValue());
        OnStickyHeaderOffsetChangedListener r4 = this.mOnStickyHeaderOffsetChangedListener;
        if (r4 == null) goto L11;
        r4.onStickyHeaderOffsetChanged(this, this.mHeader, -this.mHeaderOffset.intValue());
        return;
    L11:
        return;
    L5:
        if (r0.intValue() != r3) goto L6;
    }

    private boolean isStartOfSection(int r4) {
        if (r4 != 0) goto L5;
        return true;
    L5:
        if (this.mAdapter.getHeaderId(r4) != this.mAdapter.getHeaderId(r4 - 1)) goto L10;
        return false;
    L10:
        return true;
    }

    public int getHeaderOverlap(int r4) {
        if (isStartOfSection(Math.max(0, r4 - getHeaderViewsCount())) == true) goto L10;
        View r5 = this.mAdapter.getHeaderView(r4, null, this.mList);
        if (r5 == null) goto L9;
        ensureHeaderHasCorrectLayoutParams(r5);
        measureHeader(r5);
        return r5.getMeasuredHeight();
    L9:
        throw new NullPointerException("header may not be null");
    L10:
        return 0;
    }

    private int stickyHeaderTop() {
        int r0 = this.mStickyHeaderTopOffset;
        if (this.mClippingToPadding == false) goto L5;
        int r2 = this.mPaddingTop;
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public void setAreHeadersSticky(boolean r1) {
        this.mAreHeadersSticky = r1;
        if (r1 == true) goto L5;
        clearHeader();
    L6:
        this.mList.invalidate();
        return;
    L5:
        updateOrClearHeader(this.mList.getFixedFirstVisibleItem());
        goto L6
    }

    public boolean areHeadersSticky() {
        return this.mAreHeadersSticky;
    }

    @Deprecated
    public boolean getAreHeadersSticky() {
        return areHeadersSticky();
    }

    public void setStickyHeaderTopOffset(int r1) {
        this.mStickyHeaderTopOffset = r1;
        updateOrClearHeader(this.mList.getFixedFirstVisibleItem());
    }

    public int getStickyHeaderTopOffset() {
        return this.mStickyHeaderTopOffset;
    }

    public void setDrawingListUnderStickyHeader(boolean r1) {
        this.mIsDrawingListUnderStickyHeader = r1;
        this.mList.setTopClippingLength(0);
    }

    public boolean isDrawingListUnderStickyHeader() {
        return this.mIsDrawingListUnderStickyHeader;
    }

    public void setOnHeaderClickListener(OnHeaderClickListener r3) {
        this.mOnHeaderClickListener = r3;
        AdapterWrapper r0 = this.mAdapter;
        if (r0 == null) goto L11;
        AnonymousClass1 r1 = null;
        if (r3 == null) goto L9;
        r0.setOnHeaderClickListener(new AdapterWrapperHeaderClickHandler(this, r1));
        View r4 = this.mHeader;
        if (r4 == null) goto L12;
        r4.setOnClickListener(new AnonymousClass2(this));
        return;
    L12:
        return;
    L9:
        r0.setOnHeaderClickListener(null);
        return;
    }

    public void setOnStickyHeaderOffsetChangedListener(OnStickyHeaderOffsetChangedListener r1) {
        this.mOnStickyHeaderOffsetChangedListener = r1;
    }

    public void setOnStickyHeaderChangedListener(OnStickyHeaderChangedListener r1) {
        this.mOnStickyHeaderChangedListener = r1;
    }

    public View getListChildAt(int r1) {
        return this.mList.getChildAt(r1);
    }

    public int getListChildCount() {
        return this.mList.getChildCount();
    }

    public ListView getWrappedList() {
        return this.mList;
    }

    public void setHorizontalScrollEnabled(boolean r1) {
        this.mList.setScrollEnabled(r1);
    }

    private boolean requireSdkVersion(int r2) {
        if (Build.VERSION.SDK_INT >= r2) goto L6;
        OLog.e("StickyListHeaders", "Api lvl must be at least " + r2 + " to call this method");
        return false;
    L6:
        return true;
    }

    public void setAdapter(StickyListHeadersAdapter r4) {
        AnonymousClass1 r0 = null;
        if (r4 != null) goto L6;
        this.mList.setAdapter(null);
        clearHeader();
        return;
    L6:
        AdapterWrapper r1 = this.mAdapter;
        if (r1 == null) goto L10;
        r1.unregisterDataSetObserver(this.mDataSetObserver);
    L10:
        if ((r4 instanceof SectionIndexer) == false) goto L12;
        this.mAdapter = new SectionIndexerAdapterWrapper(getContext(), r4);
    L13:
        AdapterWrapperDataSetObserver r5 = new AdapterWrapperDataSetObserver(this, r0);
        this.mDataSetObserver = r5;
        this.mAdapter.registerDataSetObserver(r5);
        if (this.mOnHeaderClickListener == null) goto L16;
        this.mAdapter.setOnHeaderClickListener(new AdapterWrapperHeaderClickHandler(this, r0));
    L17:
        this.mAdapter.setDivider(this.mDivider, this.mDividerHeight);
        this.mList.setAdapter(this.mAdapter);
        clearHeader();
        return;
    L16:
        this.mAdapter.setOnHeaderClickListener(null);
        goto L17
    L12:
        this.mAdapter = new AdapterWrapper(getContext(), r4);
        goto L13
    }

    public StickyListHeadersAdapter getAdapter() {
        AdapterWrapper r0 = this.mAdapter;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.mDelegate;
    }

    public void setDivider(Drawable r2) {
        this.mDivider = r2;
        AdapterWrapper r0 = this.mAdapter;
        if (r0 == null) goto L6;
        r0.setDivider(r2, this.mDividerHeight);
        return;
    }

    public void setDividerHeight(int r2) {
        this.mDividerHeight = r2;
        AdapterWrapper r0 = this.mAdapter;
        if (r0 == null) goto L6;
        r0.setDivider(this.mDivider, r2);
        return;
    }

    public void setWrapClipChildren(boolean r1) {
        AdapterWrapper r0 = this.mAdapter;
        if (r0 == null) goto L6;
        r0.setWrapClipChildren(r1);
        return;
    }

    public Drawable getDivider() {
        return this.mDivider;
    }

    public int getDividerHeight() {
        return this.mDividerHeight;
    }

    public void setOnScrollListener(AbsListView.OnScrollListener r1) {
        this.mOnScrollListenerDelegate = r1;
    }

    public void setOnScrollStateChangeListener(HorizontalScrollListView.ScrollStateListener r1) {
        WrapperViewList r0 = this.mList;
        if (r0 == null) goto L6;
        r0.setOnScrollStateChangeListener(r1);
        return;
    }

    @Override // android.view.View
    public void setOnTouchListener(final View.OnTouchListener r3) {
        if (r3 == null) goto L4;
        this.mList.setOnTouchListener(new AnonymousClass3(this, r3));
        return;
    L4:
        this.mList.setOnTouchListener(null);
    }

    public int pointToPosition(int r1, int r2) {
        return this.mList.pointToPosition(r1, r2);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener r1) {
        this.mList.setOnItemClickListener(r1);
    }

    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener r1) {
        this.mList.setOnItemLongClickListener(r1);
    }

    public void addHeaderView(View r1, Object r2, boolean r3) {
        this.mList.addHeaderView(r1, r2, r3);
    }

    public void addHeaderView(View r1) {
        this.mList.addHeaderView(r1);
    }

    public void removeHeaderView(View r1) {
        this.mList.removeHeaderView(r1);
    }

    public int getHeaderViewsCount() {
        return this.mList.getHeaderViewsCount();
    }

    public void addFooterView(View r1, Object r2, boolean r3) {
        this.mList.addFooterView(r1, r2, r3);
    }

    public void addFooterView(View r1) {
        this.mList.addFooterView(r1);
    }

    public void removeFooterView(View r1) {
        this.mList.removeFooterView(r1);
    }

    public int getFooterViewsCount() {
        return this.mList.getFooterViewsCount();
    }

    public void setEmptyView(View r1) {
        this.mList.setEmptyView(r1);
    }

    public View getEmptyView() {
        return this.mList.getEmptyView();
    }

    @Override // android.view.View
    public boolean isVerticalScrollBarEnabled() {
        return this.mList.isVerticalScrollBarEnabled();
    }

    @Override // android.view.View
    public boolean isHorizontalScrollBarEnabled() {
        return this.mList.isHorizontalScrollBarEnabled();
    }

    @Override // android.view.View
    public void setVerticalScrollBarEnabled(boolean r1) {
        this.mList.setVerticalScrollBarEnabled(r1);
    }

    @Override // android.view.View
    public void setHorizontalScrollBarEnabled(boolean r1) {
        this.mList.setHorizontalScrollBarEnabled(r1);
    }

    @Override // android.view.View
    public int getOverScrollMode() {
        if (requireSdkVersion(9) == true) goto L5;
        return 0;
    L5:
        return this.mList.getOverScrollMode();
    }

    @Override // android.view.View
    public void setOverScrollMode(int r2) {
        if (requireSdkVersion(9) == false) goto L8;
        WrapperViewList r1 = this.mList;
        if (r1 == null) goto L9;
        r1.setOverScrollMode(r2);
        return;
    L9:
        return;
    }

    public void smoothScrollBy(int r2, int r3) {
        if (requireSdkVersion(8) == false) goto L6;
        this.mList.smoothScrollBy(r2, r3);
        return;
    }

    public void smoothScrollByOffset(int r2) {
        if (requireSdkVersion(11) == false) goto L6;
        this.mList.smoothScrollByOffset(r2);
        return;
    }

    public void smoothScrollToPosition(int r4) {
        if (requireSdkVersion(8) == false) goto L14;
        int r1 = 0;
        if (this.mAdapter != null) goto L7;
        int r0 = 0;
    L9:
        if (this.mClippingToPadding == true) goto L12;
        r1 = this.mPaddingTop;
    L12:
        this.mList.smoothScrollToPositionFromTop(r4, r0 - r1);
        return;
    L7:
        r0 = getHeaderOverlap(r4);
        goto L9
    }

    public void smoothScrollToPosition(int r2, int r3) {
        if (requireSdkVersion(8) == false) goto L6;
        this.mList.smoothScrollToPosition(r2, r3);
        return;
    }

    public void smoothScrollToPositionFromTop(int r3, int r4) {
        if (requireSdkVersion(11) == false) goto L14;
        int r1 = 0;
        if (this.mAdapter != null) goto L7;
        int r0 = 0;
    L8:
        int r5 = r4 + r0;
        if (this.mClippingToPadding == true) goto L12;
        r1 = this.mPaddingTop;
    L12:
        this.mList.smoothScrollToPositionFromTop(r3, r5 - r1);
        return;
    L7:
        r0 = getHeaderOverlap(r3);
        goto L8
    }

    public void smoothScrollToPositionFromTop(int r3, int r4, int r5) {
        if (requireSdkVersion(11) == false) goto L14;
        int r1 = 0;
        if (this.mAdapter != null) goto L7;
        int r0 = 0;
    L8:
        int r6 = r4 + r0;
        if (this.mClippingToPadding == true) goto L12;
        r1 = this.mPaddingTop;
    L12:
        this.mList.smoothScrollToPositionFromTop(r3, r6 - r1, r5);
        return;
    L7:
        r0 = getHeaderOverlap(r3);
        goto L8
    }

    public void setSelection(int r2) {
        setSelectionFromTop(r2, 0);
    }

    public void setSelectionAfterHeaderView() {
        this.mList.setSelectionAfterHeaderView();
    }

    public void setSelectionFromTop(int r3, int r4) {
        int r1 = 0;
        if (this.mAdapter != null) goto L5;
        int r0 = 0;
    L6:
        int r5 = r4 + r0;
        if (this.mClippingToPadding == true) goto L10;
        r1 = this.mPaddingTop;
    L10:
        this.mList.setSelectionFromTop(r3, r5 - r1);
        return;
    L5:
        r0 = getHeaderOverlap(r3);
        goto L6
    }

    public void setSelector(Drawable r1) {
        this.mList.setSelector(r1);
    }

    public void setSelector(int r1) {
        this.mList.setSelector(r1);
    }

    public int getFirstVisiblePosition() {
        return this.mList.getFirstVisiblePosition();
    }

    public int getLastVisiblePosition() {
        return this.mList.getLastVisiblePosition();
    }

    public int getListPaddingTop() {
        return this.mList.getPaddingTop();
    }

    public int getListPaddingBottom() {
        return this.mList.getPaddingBottom();
    }

    public int getListHeight() {
        return this.mList.getHeight();
    }

    public void setChoiceMode(int r1) {
        this.mList.setChoiceMode(r1);
    }

    public void setItemChecked(int r1, boolean r2) {
        this.mList.setItemChecked(r1, r2);
    }

    public int getCheckedItemCount() {
        if (requireSdkVersion(11) == true) goto L5;
        return 0;
    L5:
        return this.mList.getCheckedItemCount();
    }

    public long[] getCheckedItemIds() {
        if (requireSdkVersion(8) == true) goto L5;
        return null;
    L5:
        return this.mList.getCheckedItemIds();
    }

    public int getCheckedItemPosition() {
        return this.mList.getCheckedItemPosition();
    }

    public SparseBooleanArray getCheckedItemPositions() {
        return this.mList.getCheckedItemPositions();
    }

    public int getCount() {
        return this.mList.getCount();
    }

    public Object getItemAtPosition(int r1) {
        return this.mList.getItemAtPosition(r1);
    }

    public long getItemIdAtPosition(int r1) {
        return this.mList.getItemIdAtPosition(r1);
    }

    @Override // android.view.View
    public void setOnCreateContextMenuListener(View.OnCreateContextMenuListener r1) {
        this.mList.setOnCreateContextMenuListener(r1);
    }

    @Override // android.view.View
    public boolean showContextMenu() {
        return this.mList.showContextMenu();
    }

    public void invalidateViews() {
        this.mList.invalidateViews();
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean r2) {
        WrapperViewList r0 = this.mList;
        if (r0 == null) goto L5;
        r0.setClipToPadding(r2);
    L5:
        this.mClippingToPadding = r2;
    }

    @Override // android.view.View
    public void setPadding(int r2, int r3, int r4, int r5) {
        this.mPaddingLeft = r2;
        this.mPaddingTop = r3;
        this.mPaddingRight = r4;
        this.mPaddingBottom = r5;
        WrapperViewList r0 = this.mList;
        if (r0 == null) goto L5;
        r0.setPadding(r2, r3, r4, r5);
    L5:
        super.setPadding(0, 0, 0, 0);
        requestLayout();
    }

    protected void recomputePadding() {
        setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public void setFastScrollEnabled(boolean r1) {
        this.mList.setFastScrollEnabled(r1);
    }

    public void setFastScrollAlwaysVisible(boolean r2) {
        if (requireSdkVersion(11) == false) goto L6;
        this.mList.setFastScrollAlwaysVisible(r2);
        return;
    }

    public boolean isFastScrollAlwaysVisible() {
        return this.mList.isFastScrollAlwaysVisible();
    }

    @Override // android.view.View
    public void setScrollBarStyle(int r1) {
        this.mList.setScrollBarStyle(r1);
    }

    @Override // android.view.View
    public int getScrollBarStyle() {
        return this.mList.getScrollBarStyle();
    }

    public int getPositionForView(View r1) {
        return this.mList.getPositionForView(r1);
    }

    public void setMultiChoiceModeListener(AbsListView.MultiChoiceModeListener r2) {
        if (requireSdkVersion(11) == false) goto L6;
        this.mList.setMultiChoiceModeListener(r2);
        return;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.mList.onSaveInstanceState());
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r2) {
        if ((r2 instanceof SavedState) == false) goto L5;
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        this.mList.onRestoreInstanceState(SavedState.access$1700(r3));
        return;
    L5:
        super.onRestoreInstanceState(r2);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int r1) {
        return this.mList.canScrollVertically(r1);
    }

    public void setTranscriptMode(int r1) {
        this.mList.setTranscriptMode(r1);
    }

    public void setBlockLayoutChildren(boolean r1) {
        this.mList.setBlockLayoutChildren(r1);
    }

    public boolean restoreScrollState(boolean r1) {
        return this.mList.restoreScrollState(r1);
    }

    public void playDeleteItemAnimation(Animator.AnimatorListener r1) {
        this.mList.playDeleteItemAnimation(r1);
    }

    public View getHintView() {
        return this.mList.getHintView();
    }

    public void saveHintViewPosition(int r1) {
        this.mList.saveHintViewPosition(r1);
    }
}
