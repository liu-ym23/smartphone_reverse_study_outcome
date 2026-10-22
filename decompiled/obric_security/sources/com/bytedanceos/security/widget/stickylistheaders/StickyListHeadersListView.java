package com.bytedanceos.security.widget.stickylistheaders;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.SectionIndexer;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import bytedanceos.util.LogTag;
import com.bytedanceos.security.Utils;
import com.bytedanceos.security.widget.SlideListView;
import com.obric.olog.OLog;
import com.obric.oui.bouncelayout.OListView;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.security.R;

/* JADX INFO: loaded from: classes2.dex */
public class StickyListHeadersListView extends FrameLayout {
    private static final int SCROLLBAR_HORIZONTAL_VALUE = 256;
    private static final int SCROLLBAR_VERTICAL_VALUE = 512;
    private String TAG;
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
    private int mHeight;
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

        private AdapterWrapperDataSetObserver(final StickyListHeadersListView this$0) {
            this.this$0 = this$0;
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

        private AdapterWrapperHeaderClickHandler(final StickyListHeadersListView this$0) {
            this.this$0 = this$0;
        }

        /* synthetic */ AdapterWrapperHeaderClickHandler(StickyListHeadersListView r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.bytedanceos.security.widget.stickylistheaders.AdapterWrapper.OnHeaderClickListener
        public void onHeaderClick(View header, int itemPosition, long headerId) {
            StickyListHeadersListView.access$500(this.this$0).onHeaderClick(this.this$0, header, itemPosition, headerId, false);
        }
    }

    public interface OnHeaderClickListener {
        void onHeaderClick(StickyListHeadersListView l, View header, int itemPosition, long headerId, boolean currentlySticky);
    }

    public interface OnStickyHeaderChangedListener {
        void onStickyHeaderChanged(StickyListHeadersListView l, View header, int itemPosition, long headerId);
    }

    public interface OnStickyHeaderOffsetChangedListener {
        void onStickyHeaderOffsetChanged(StickyListHeadersListView l, View header, int offset);
    }

    private class WrapperListScrollListener implements AbsListView.OnScrollListener {
        final /* synthetic */ StickyListHeadersListView this$0;

        private WrapperListScrollListener(final StickyListHeadersListView this$0) {
            this.this$0 = this$0;
        }

        /* synthetic */ WrapperListScrollListener(StickyListHeadersListView r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            if (StickyListHeadersListView.access$700(this.this$0) == null) goto L5;
            StickyListHeadersListView.access$700(this.this$0).onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
        L5:
            StickyListHeadersListView r1 = this.this$0;
            StickyListHeadersListView.access$900(r1, StickyListHeadersListView.access$800(r1).getFixedFirstVisibleItem());
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            if (StickyListHeadersListView.access$700(this.this$0) == null) goto L6;
            StickyListHeadersListView.access$700(this.this$0).onScrollStateChanged(view, scrollState);
            return;
        }
    }

    private class WrapperViewListLifeCycleListener implements WrapperViewList.LifeCycleListener {
        final /* synthetic */ StickyListHeadersListView this$0;

        private WrapperViewListLifeCycleListener(final StickyListHeadersListView this$0) {
            this.this$0 = this$0;
        }

        /* synthetic */ WrapperViewListLifeCycleListener(StickyListHeadersListView r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.bytedanceos.security.widget.stickylistheaders.WrapperViewList.LifeCycleListener
        public void onDispatchDrawOccurred(Canvas canvas) {
            if (StickyListHeadersListView.access$200(this.this$0) != null) goto L5;
            return;
        L5:
            if (StickyListHeadersListView.access$1000(this.this$0) == false) goto L7;
            canvas.save();
            canvas.clipRect(0, StickyListHeadersListView.access$1100(this.this$0), this.this$0.getRight(), this.this$0.getBottom());
            StickyListHeadersListView r6 = this.this$0;
            StickyListHeadersListView.access$1200(r6, canvas, StickyListHeadersListView.access$200(r6), 0);
            canvas.restore();
            return;
        L7:
            StickyListHeadersListView r7 = this.this$0;
            StickyListHeadersListView.access$1300(r7, canvas, StickyListHeadersListView.access$200(r7), 0);
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

    public StickyListHeadersListView(Context context) {
        this(context, null);
    }

    public StickyListHeadersListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StickyListHeadersListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.TAG = "StickyListHeadersListView";
        this.mAreHeadersSticky = true;
        this.mClippingToPadding = true;
        this.mIsDrawingListUnderStickyHeader = true;
        this.mStickyHeaderTopOffset = 0;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mHeight = 24;
        WrapperViewList r2 = new WrapperViewList(context, attrs);
        this.mList = r2;
        this.mDivider = r2.getDivider();
        this.mDividerHeight = this.mList.getDividerHeight();
        AnonymousClass1 r3 = null;
        this.mList.setDivider(null);
        this.mList.setDividerHeight(0);
        super.setClipToPadding(false);
        this.mList.setClipToPadding(false);
        setmHeader(24);
        if (attrs == null) goto L31;
        TypedArray r8 = context.getTheme().obtainStyledAttributes(attrs, R.styleable.StickyListHeadersListView, 0, 0);
        int r1 = r8.getDimensionPixelSize(1, 0);     // Catch: Throwable -> L28
        this.mPaddingLeft = r8.getDimensionPixelSize(2, r1);     // Catch: Throwable -> L28
        this.mPaddingTop = r8.getDimensionPixelSize(3, r1);     // Catch: Throwable -> L28
        this.mPaddingRight = r8.getDimensionPixelSize(4, r1);     // Catch: Throwable -> L28
        int r4 = r8.getDimensionPixelSize(5, r1);     // Catch: Throwable -> L28
        this.mPaddingBottom = r4;     // Catch: Throwable -> L28
        setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, r4);     // Catch: Throwable -> L28
        this.mClippingToPadding = r8.getBoolean(8, true);     // Catch: Throwable -> L28
        int r5 = r8.getInt(6, 512);     // Catch: Throwable -> L28
        if (Utils.isDesktop(context) == false) goto L8;
        setVerticalScrollBarEnabled(false);     // Catch: Throwable -> L28
    L13:
        this.mList.setOverScrollMode(r8.getInt(18, 0));     // Catch: Throwable -> L28
        WrapperViewList r7 = this.mList;     // Catch: Throwable -> L28
        r7.setFadingEdgeLength(r8.getDimensionPixelSize(7, r7.getVerticalFadingEdgeLength()));     // Catch: Throwable -> L28
        int r9 = r8.getInt(20, 0);     // Catch: Throwable -> L28
        if (r9 != 4096) goto L17;
        this.mList.setVerticalFadingEdgeEnabled(false);     // Catch: Throwable -> L28
        this.mList.setHorizontalFadingEdgeEnabled(true);     // Catch: Throwable -> L28
    L20:
        WrapperViewList r10 = this.mList;     // Catch: Throwable -> L28
        r10.setCacheColorHint(r8.getColor(13, r10.getCacheColorHint()));     // Catch: Throwable -> L28
        WrapperViewList r11 = this.mList;     // Catch: Throwable -> L28
        r11.setChoiceMode(r8.getInt(16, r11.getChoiceMode()));     // Catch: Throwable -> L28
        this.mList.setDrawSelectorOnTop(r8.getBoolean(10, false));     // Catch: Throwable -> L28
        WrapperViewList r12 = this.mList;     // Catch: Throwable -> L28
        r12.setFastScrollEnabled(r8.getBoolean(17, r12.isFastScrollEnabled()));     // Catch: Throwable -> L28
        WrapperViewList r13 = this.mList;     // Catch: Throwable -> L28
        r13.setFastScrollAlwaysVisible(r8.getBoolean(19, r13.isFastScrollAlwaysVisible()));     // Catch: Throwable -> L28
        this.mList.setScrollBarStyle(r8.getInt(0, 0));     // Catch: Throwable -> L28
        if (r8.hasValue(9) == false) goto L23;
        this.mList.setSelector(r8.getDrawable(9));     // Catch: Throwable -> L28
    L23:
        WrapperViewList r14 = this.mList;     // Catch: Throwable -> L28
        r14.setScrollingCacheEnabled(r8.getBoolean(11, r14.isScrollingCacheEnabled()));     // Catch: Throwable -> L28
        if (r8.hasValue(14) == false) goto L26;
        this.mDivider = r8.getDrawable(14);     // Catch: Throwable -> L28
    L26:
        this.mDividerHeight = r8.getDimensionPixelSize(15, this.mDividerHeight);     // Catch: Throwable -> L28
        this.mList.setTranscriptMode(r8.getInt(12, 0));     // Catch: Throwable -> L28
        this.mAreHeadersSticky = r8.getBoolean(21, true);     // Catch: Throwable -> L28
        this.mIsDrawingListUnderStickyHeader = r8.getBoolean(22, true);     // Catch: Throwable -> L28
        r8.recycle();
        goto L31
    L17:
        if (r9 != 8192) goto L19;
        this.mList.setVerticalFadingEdgeEnabled(true);     // Catch: Throwable -> L28
        this.mList.setHorizontalFadingEdgeEnabled(false);     // Catch: Throwable -> L28
        goto L20
    L19:
        this.mList.setVerticalFadingEdgeEnabled(false);     // Catch: Throwable -> L28
        this.mList.setHorizontalFadingEdgeEnabled(false);     // Catch: Throwable -> L28
        goto L20
    L8:
        this.mList.setVerticalScrollBarEnabled(false);     // Catch: Throwable -> L28
        WrapperViewList r15 = this.mList;     // Catch: Throwable -> L28
        if ((r5 & 256) == 0) goto L11;
        boolean r6 = true;
    L12:
        r15.setHorizontalScrollBarEnabled(r6);     // Catch: Throwable -> L28
        goto L13
    L11:
        r6 = false;
    L28:
        th = move-exception;
        r8.recycle();
        throw th;
    L31:
        this.mList.setLifeCycleListener(new WrapperViewListLifeCycleListener(this, r3));
        this.mList.setOnScrollListener(new WrapperListScrollListener(this, r3));
        addView(this.mList);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureHeader(this.mHeader);
    }

    private void ensureHeaderHasCorrectLayoutParams(View header) {
        ViewGroup.LayoutParams r3 = header.getLayoutParams();
        if (r3 != null) goto L6;
        header.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return;
    L6:
        if (r3.height != (-1)) goto L8;
    L9:
        r3.height = -2;
        r3.width = -1;
        header.setLayoutParams(r3);
        return;
    L8:
        if (r3.width == (-2)) goto L9;
    }

    private void measureHeader(View header) {
        if (header == null) goto L5;
        measureChild(header, View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - this.mPaddingLeft) - this.mPaddingRight, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        WrapperViewList r1 = this.mList;
        r1.layout(0, 0, r1.getMeasuredWidth(), getHeight());
        View r2 = this.mHeader;
        if (r2 == null) goto L6;
        int r3 = ((ViewGroup.MarginLayoutParams) r2.getLayoutParams()).topMargin + stickyHeaderTop();
        View r4 = this.mHeader;
        r4.layout(this.mPaddingLeft, r3, r4.getMeasuredWidth() + this.mPaddingLeft, this.mHeader.getMeasuredHeight() + r3);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mList.getVisibility() != 0) goto L5;
    L6:
        drawChild(canvas, this.mList, 0);
        return;
    L5:
        if (this.mList.getAnimation() != null) goto L6;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchWindowFocusChanged(boolean hasFocus) {
        super.dispatchWindowFocusChanged(hasFocus);     // Catch: Exception -> L4
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

    private void updateOrClearHeader(int firstVisiblePosition) {
        AdapterWrapper r0 = this.mAdapter;
        boolean r1 = false;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        if (r2 != 0) goto L8;
        return;
    L8:
        if (this.mAreHeadersSticky == false) goto L43;
        int r7 = firstVisiblePosition - this.mList.getHeaderViewsCount();
        if (this.mList.getChildCount() <= 0) goto L18;
        View r3 = this.mList.getChildAt(0);
        if (r3 == null) goto L18;
        if (r3.getBottom() >= stickyHeaderTop()) goto L18;
        r7 = r7 + 1;
    L18:
        if (this.mList.getChildCount() == 0) goto L20;
        boolean r4 = true;
    L21:
        if (r4 == true) goto L23;
    L29:
        boolean r5 = false;
    L31:
        if (r7 > (r2 - 1)) goto L33;
        if (r7 < 0) goto L33;
    L34:
        if (r4 == false) goto L40;
        if (r1 == true) goto L40;
        if (r5 == true) goto L40;
        updateHeader(r7);
        return;
    L40:
        clearHeader();
        return;
    L33:
        r1 = true;
        goto L34
    L23:
        if (this.mList.getFirstVisiblePosition() != 0) goto L29;
        if (this.mList.getChildAt(0) == null) goto L29;
        if (this.mList.getChildAt(0).getTop() < stickyHeaderTop()) goto L29;
        r5 = true;
        goto L31
    L20:
        r4 = false;
        goto L21
    L43:
        return;
    L5:
        r2 = r0.getCount();
        goto L6
    }

    private void updateHeader(int headerPosition) {
        Integer r0 = this.mHeaderPosition;
        if (r0 != null) goto L5;
    L6:
        this.mHeaderPosition = Integer.valueOf(headerPosition);
        long r1 = this.mAdapter.getHeaderId(headerPosition);
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
        r4.onStickyHeaderChanged(this, this.mHeader, headerPosition, this.mHeaderId.longValue());
    L19:
        this.mHeaderOffset = null;
    L20:
        int r8 = this.mHeader.getMeasuredHeight() + stickyHeaderTop();
        int r5 = 0;
        int r6 = 0;
    L22:
        if (r6 >= this.mList.getChildCount()) goto L38;
        View r7 = this.mList.getChildAt(r6);
        if (r7 == null) goto L37;
        if ((r7 instanceof WrapperView) == true) goto L29;
    L31:
        boolean r9 = false;
    L32:
        boolean r10 = this.mList.containsFooterView(r7);
        if (r7.getTop() < stickyHeaderTop()) goto L37;
        if (r9 == true) goto L36;
        if (r10 == false) goto L37;
    L36:
        r5 = Math.min(r7.getTop() - r8, 0);
        goto L38
    L29:
        if (((WrapperView) r7).hasHeader() == false) goto L31;
        r9 = true;
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
        if (r0.intValue() == headerPosition) goto L20;
        goto L6
    }

    private void swapHeader(View newHeader) {
        View r0 = this.mHeader;
        if (r0 == null) goto L5;
        removeView(r0);
    L5:
        this.mHeader = newHeader;
        addView(newHeader);
        if (this.mOnHeaderClickListener == null) goto L8;
        this.mHeader.setOnClickListener(new AnonymousClass1(this));
    L8:
        this.mHeader.setClickable(true);
    }

    private void updateHeaderVisibilities() {
        int r0 = this.mList.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        View r2 = this.mList.getChildAt(r1);
        if ((r2 instanceof WrapperView) == false) goto L8;
        ((WrapperView) r2).hasHeader();
    L8:
        r1 = r1 + 1;
        goto L3
    }

    private void setHeaderOffet(int offset) {
        Integer r0 = this.mHeaderOffset;
        if (r0 != null) goto L5;
    L6:
        this.mHeaderOffset = Integer.valueOf(offset);
        this.mHeader.setTranslationY(this.mHeaderOffset.intValue());
        OnStickyHeaderOffsetChangedListener r3 = this.mOnStickyHeaderOffsetChangedListener;
        if (r3 == null) goto L11;
        r3.onStickyHeaderOffsetChanged(this, this.mHeader, -this.mHeaderOffset.intValue());
        return;
    L11:
        return;
    L5:
        if (r0.intValue() != offset) goto L6;
    }

    private boolean isStartOfSection(int position) {
        if (position != 0) goto L5;
        return true;
    L5:
        if (this.mAdapter.getHeaderId(position) != this.mAdapter.getHeaderId(position - 1)) goto L10;
        return false;
    L10:
        return true;
    }

    public int getHeaderOverlap(int position) {
        if (isStartOfSection(Math.max(0, position - getHeaderViewsCount())) == true) goto L10;
        View r4 = this.mAdapter.getHeaderView(position, null, this.mList);
        if (r4 == null) goto L9;
        ensureHeaderHasCorrectLayoutParams(r4);
        measureHeader(r4);
        return r4.getMeasuredHeight();
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

    public void setAreHeadersSticky(boolean areHeadersSticky) {
        this.mAreHeadersSticky = areHeadersSticky;
        if (areHeadersSticky == true) goto L5;
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

    public void setStickyHeaderTopOffset(int stickyHeaderTopOffset) {
        this.mStickyHeaderTopOffset = stickyHeaderTopOffset;
        updateOrClearHeader(this.mList.getFixedFirstVisibleItem());
    }

    public int getStickyHeaderTopOffset() {
        return this.mStickyHeaderTopOffset;
    }

    public void setDrawingListUnderStickyHeader(boolean drawingListUnderStickyHeader) {
        this.mIsDrawingListUnderStickyHeader = drawingListUnderStickyHeader;
        this.mList.setTopClippingLength(0);
    }

    public boolean isDrawingListUnderStickyHeader() {
        return this.mIsDrawingListUnderStickyHeader;
    }

    public void setOnHeaderClickListener(OnHeaderClickListener listener) {
        this.mOnHeaderClickListener = listener;
        AdapterWrapper r0 = this.mAdapter;
        if (r0 == null) goto L11;
        AnonymousClass1 r1 = null;
        if (listener == null) goto L9;
        r0.setOnHeaderClickListener(new AdapterWrapperHeaderClickHandler(this, r1));
        View r3 = this.mHeader;
        if (r3 == null) goto L12;
        r3.setOnClickListener(new AnonymousClass2(this));
        return;
    L12:
        return;
    L9:
        r0.setOnHeaderClickListener(null);
        return;
    }

    public void setOnStickyHeaderOffsetChangedListener(OnStickyHeaderOffsetChangedListener listener) {
        this.mOnStickyHeaderOffsetChangedListener = listener;
    }

    public void setOnStickyHeaderChangedListener(OnStickyHeaderChangedListener listener) {
        this.mOnStickyHeaderChangedListener = listener;
    }

    public View getListChildAt(int index) {
        return this.mList.getChildAt(index);
    }

    public int getListChildCount() {
        return this.mList.getChildCount();
    }

    public OListView getWrappedList() {
        return this.mList;
    }

    private boolean requireSdkVersion(int versionCode) {
        if (Build.VERSION.SDK_INT >= versionCode) goto L6;
        OLog.e("StickyListHeaders", "Api lvl must be at least " + versionCode + " to call this method");
        return false;
    L6:
        return true;
    }

    public void setAdapter(StickyListHeadersAdapter adapter) {
        AnonymousClass1 r0 = null;
        if (adapter != null) goto L6;
        this.mList.setAdapter(null);
        clearHeader();
        return;
    L6:
        AdapterWrapper r1 = this.mAdapter;
        if (r1 == null) goto L10;
        r1.unregisterDataSetObserver(this.mDataSetObserver);
    L10:
        if ((adapter instanceof SectionIndexer) == false) goto L12;
        this.mAdapter = new SectionIndexerAdapterWrapper(getContext(), adapter);
    L13:
        AdapterWrapperDataSetObserver r4 = new AdapterWrapperDataSetObserver(this, r0);
        this.mDataSetObserver = r4;
        this.mAdapter.registerDataSetObserver(r4);
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
        this.mAdapter = new AdapterWrapper(getContext(), adapter);
        goto L13
    }

    public StickyListHeadersAdapter getAdapter() {
        AdapterWrapper r0 = this.mAdapter;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.mDelegate;
    }

    public void setDivider(Drawable divider) {
        this.mDivider = divider;
        AdapterWrapper r0 = this.mAdapter;
        if (r0 == null) goto L6;
        r0.setDivider(divider, this.mDividerHeight);
        return;
    }

    public void setDividerHeight(int dividerHeight) {
        this.mDividerHeight = dividerHeight;
        AdapterWrapper r0 = this.mAdapter;
        if (r0 == null) goto L6;
        r0.setDivider(this.mDivider, dividerHeight);
        return;
    }

    public Drawable getDivider() {
        return this.mDivider;
    }

    public int getDividerHeight() {
        return this.mDividerHeight;
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mOnScrollListenerDelegate = onScrollListener;
    }

    @Override // android.view.View
    public void setOnTouchListener(final View.OnTouchListener l) {
        if (l == null) goto L4;
        this.mList.setOnTouchListener(new AnonymousClass3(this, l));
        return;
    L4:
        this.mList.setOnTouchListener(null);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        this.mList.setOnItemClickListener(listener);
    }

    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener listener) {
        this.mList.setOnItemLongClickListener(listener);
    }

    public void setSlideListener(SlideListView.Listener listener) {
        this.mList.setSlideListener(listener);
    }

    public void setSlideEnable(boolean enable) {
        this.mList.setSlideEnable(enable);
    }

    public void addHeaderView(View v, Object data, boolean isSelectable) {
        this.mList.addHeaderView(v, data, isSelectable);
    }

    public void addHeaderView(View v) {
        this.mList.addHeaderView(v);
    }

    public void removeHeaderView(View v) {
        this.mList.removeHeaderView(v);
    }

    public int getHeaderViewsCount() {
        return this.mList.getHeaderViewsCount();
    }

    public void addFooterView(View v, Object data, boolean isSelectable) {
        this.mList.addFooterView(v, data, isSelectable);
    }

    public void addFooterView(View v) {
        this.mList.addFooterView(v);
    }

    public void removeFooterView(View v) {
        this.mList.removeFooterView(v);
    }

    public int getFooterViewsCount() {
        return this.mList.getFooterViewsCount();
    }

    public void setEmptyView(View v) {
        this.mList.setEmptyView(v);
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
    public void setVerticalScrollBarEnabled(boolean verticalScrollBarEnabled) {
        this.mList.setVerticalScrollBarEnabled(verticalScrollBarEnabled);
    }

    @Override // android.view.View
    public void setHorizontalScrollBarEnabled(boolean horizontalScrollBarEnabled) {
        this.mList.setHorizontalScrollBarEnabled(horizontalScrollBarEnabled);
    }

    @Override // android.view.View
    public int getOverScrollMode() {
        if (requireSdkVersion(9) == true) goto L5;
        return 0;
    L5:
        return this.mList.getOverScrollMode();
    }

    @Override // android.view.View
    public void setOverScrollMode(int mode) {
        if (requireSdkVersion(9) == false) goto L8;
        WrapperViewList r1 = this.mList;
        if (r1 == null) goto L9;
        r1.setOverScrollMode(mode);
        return;
    L9:
        return;
    }

    public void smoothScrollBy(int distance, int duration) {
        if (requireSdkVersion(8) == false) goto L6;
        this.mList.smoothScrollBy(distance, duration);
        return;
    }

    public void smoothScrollByOffset(int offset) {
        if (requireSdkVersion(11) == false) goto L6;
        this.mList.smoothScrollByOffset(offset);
        return;
    }

    public void smoothScrollToPosition(int position) {
        if (requireSdkVersion(8) == false) goto L14;
        int r1 = 0;
        if (this.mAdapter != null) goto L7;
        int r0 = 0;
    L9:
        if (this.mClippingToPadding == true) goto L12;
        r1 = this.mPaddingTop;
    L12:
        this.mList.smoothScrollToPositionFromTop(position, r0 - r1);
        return;
    L7:
        r0 = getHeaderOverlap(position);
        goto L9
    }

    public void smoothScrollToPosition(int position, int boundPosition) {
        if (requireSdkVersion(8) == false) goto L6;
        this.mList.smoothScrollToPosition(position, boundPosition);
        return;
    }

    public void smoothScrollToPositionFromTop(int position, int offset) {
        if (requireSdkVersion(11) == false) goto L14;
        int r1 = 0;
        if (this.mAdapter != null) goto L7;
        int r0 = 0;
    L8:
        int r4 = offset + r0;
        if (this.mClippingToPadding == true) goto L12;
        r1 = this.mPaddingTop;
    L12:
        this.mList.smoothScrollToPositionFromTop(position, r4 - r1);
        return;
    L7:
        r0 = getHeaderOverlap(position);
        goto L8
    }

    public void smoothScrollToPositionFromTop(int position, int offset, int duration) {
        if (requireSdkVersion(11) == false) goto L14;
        int r1 = 0;
        if (this.mAdapter != null) goto L7;
        int r0 = 0;
    L8:
        int r4 = offset + r0;
        if (this.mClippingToPadding == true) goto L12;
        r1 = this.mPaddingTop;
    L12:
        this.mList.smoothScrollToPositionFromTop(position, r4 - r1, duration);
        return;
    L7:
        r0 = getHeaderOverlap(position);
        goto L8
    }

    public void setSelection(int position) {
        setSelectionFromTop(position, 104);
    }

    public void setSelectionAfterHeaderView() {
        this.mList.setSelectionAfterHeaderView();
    }

    public void setSelectionFromTop(int position, int y) {
        int r1 = 0;
        if (this.mAdapter != null) goto L5;
        int r0 = 0;
    L6:
        int r4 = y + r0;
        if (this.mClippingToPadding == true) goto L10;
        r1 = this.mPaddingTop;
    L10:
        this.mList.setSelectionFromTop(position, r4 - r1);
        return;
    L5:
        r0 = getHeaderOverlap(position);
        goto L6
    }

    public void setRealSelectionFromTop(int position, int y) {
        this.mList.setSelectionFromTop(position, y);
    }

    public void setSelector(Drawable sel) {
        this.mList.setSelector(sel);
    }

    public void setSelector(int resID) {
        this.mList.setSelector(resID);
    }

    public int getFirstVisiblePosition() {
        return this.mList.getFirstVisiblePosition();
    }

    public int getLastVisiblePosition() {
        return this.mList.getLastVisiblePosition();
    }

    public void setChoiceMode(int choiceMode) {
        this.mList.setChoiceMode(choiceMode);
    }

    public void setItemChecked(int position, boolean value) {
        this.mList.setItemChecked(position, value);
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

    public Object getItemAtPosition(int position) {
        return this.mList.getItemAtPosition(position);
    }

    public long getItemIdAtPosition(int position) {
        return this.mList.getItemIdAtPosition(position);
    }

    @Override // android.view.View
    public void setOnCreateContextMenuListener(View.OnCreateContextMenuListener l) {
        this.mList.setOnCreateContextMenuListener(l);
    }

    @Override // android.view.View
    public boolean showContextMenu() {
        return this.mList.showContextMenu();
    }

    public void invalidateViews() {
        this.mList.invalidateViews();
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean clipToPadding) {
        WrapperViewList r0 = this.mList;
        if (r0 == null) goto L5;
        r0.setClipToPadding(clipToPadding);
    L5:
        this.mClippingToPadding = clipToPadding;
    }

    @Override // android.view.View
    public void setPadding(int left, int top, int right, int bottom) {
        this.mPaddingLeft = left;
        this.mPaddingTop = top;
        this.mPaddingRight = right;
        this.mPaddingBottom = bottom;
        WrapperViewList r0 = this.mList;
        if (r0 == null) goto L5;
        r0.setPadding(left, top, right, bottom);
        setmHeader(this.mHeight);
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

    public void setFastScrollEnabled(boolean fastScrollEnabled) {
        this.mList.setFastScrollEnabled(fastScrollEnabled);
    }

    public void setFastScrollAlwaysVisible(boolean alwaysVisible) {
        if (requireSdkVersion(11) == false) goto L6;
        this.mList.setFastScrollAlwaysVisible(alwaysVisible);
        return;
    }

    public boolean isFastScrollAlwaysVisible() {
        return this.mList.isFastScrollAlwaysVisible();
    }

    @Override // android.view.View
    public void setScrollBarStyle(int style) {
        this.mList.setScrollBarStyle(style);
    }

    @Override // android.view.View
    public int getScrollBarStyle() {
        return this.mList.getScrollBarStyle();
    }

    public int getPositionForView(View view) {
        return this.mList.getPositionForView(view);
    }

    public void setMultiChoiceModeListener(AbsListView.MultiChoiceModeListener listener) {
        if (requireSdkVersion(11) == false) goto L6;
        this.mList.setMultiChoiceModeListener(listener);
        return;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
    L6:
        e = move-exception;
        LogTag.d(this.TAG, e.toString());
    L9:
        return this.mList.onSaveInstanceState();
    L3:
        if (super.onSaveInstanceState() == View.BaseSavedState.EMPTY_STATE) goto L9;
        LogTag.d(this.TAG, "Handling non empty state of parent class is not implemented");     // Catch: Exception -> L6
        goto L9
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(View.BaseSavedState.EMPTY_STATE);
        this.mList.onRestoreInstanceState(state);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int direction) {
        return this.mList.canScrollVertically(direction);
    }

    public void setTranscriptMode(int mode) {
        this.mList.setTranscriptMode(mode);
    }

    public void setBlockLayoutChildren(boolean blockLayoutChildren) {
        this.mList.setBlockLayoutChildren(blockLayoutChildren);
    }

    public void setmHeader(int size) {
        this.mHeight = size;
        ViewCompat.setOnApplyWindowInsetsListener(this.mList, new StickyListHeadersListView$$ExternalSyntheticLambda0(this));
        ViewCompat.requestApplyInsets(this.mList);
    }

    /* JADX INFO: renamed from: lambda$setmHeader$0$com-bytedanceos-security-widget-stickylistheaders-StickyListHeadersListView, reason: not valid java name */
    /* synthetic */ WindowInsetsCompat m131x5971e64b(View r6, WindowInsetsCompat r7) {
        Insets r0 = r7.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        r6.setPadding(this.mPaddingLeft, r6.getPaddingTop(), this.mPaddingRight, (this.mPaddingBottom + r0.bottom) + OUnitExtensionKt.dp2px(this.mHeight));
        return r7;
    }
}
