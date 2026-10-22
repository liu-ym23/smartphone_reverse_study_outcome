package com.android.settings.bluetooth;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.google.android.material.timepicker.TimeModel;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class BluetoothNumberPicker extends LinearLayout {
    private static final boolean DBG = false;
    private static final int DEFAULT_TEXT_SIZE = 45;
    private static final int DEFAUlT_TEXT_COLOR = 0;
    private static final int SELECTOR_ADJUSTMENT_DURATION_MILLIS = 800;
    private static final int SELECTOR_MAX_FLING_VELOCITY_ADJUSTMENT = 8;
    private static final int SELECTOR_MIDDLE_ITEM_INDEX = 2;
    private static final int SELECTOR_WHEEL_ITEM_COUNT = 5;
    private static final int SIZE_UNSPECIFIED = -1;
    private static final int SNAP_SCROLL_DURATION = 300;
    private static final String TAG = "BluetoothNumberPicker";
    private static final float TOP_AND_BOTTOM_FADING_EDGE_STRENGTH = 0.0f;
    private static final TwoDigitFormatter mTwoDigitFormatter = null;
    private final Scroller mAdjustScroller;
    private int mBottomSelectionDividerBottom;
    private final boolean mComputeMaxWidth;
    private int mCurrentScrollOffset;
    private String[] mDisplayedValues;
    private final Scroller mFlingScroller;
    private Formatter mFormatter;
    private final boolean mHasSelectorWheel;
    private int mHighlightColor;
    private int mHighlightSize;
    private boolean mIngonreMoveEvents;
    private int mInitialScrollOffset;
    private long mLastDownEventTime;
    private float mLastDownEventY;
    private float mLastDownOrMoveEventY;
    private final int mMaxHeight;
    private int mMaxValue;
    private int mMaxWidth;
    private int mMaximumFlingVelocity;
    private int mMiddleScrollOffset;
    private final int mMinHeight;
    private int mMinValue;
    private final int mMinWidth;
    private int mMinimumFlingVelocity;
    private int mNormalColor;
    private int mNormalSize;
    private OnScrollListener mOnScrollListener;
    private OnValueChangeListener mOnValueChangeListener;
    private int mPreviousScrollerY;
    private int mScrollState;
    private int mSelectorElementHeight;
    private final SparseArray<String> mSelectorIndexToStringCache;
    private final int[] mSelectorIndices;
    private int mSelectorTextGapHeight;
    private final Paint mSelectorWheelPaint;
    private boolean mShowSoftInputOnTap;
    private int mTopSelectionDividerTop;
    private int mTouchSlop;
    private int mValue;
    private VelocityTracker mVelocityTracker;
    private boolean mWrapSelectorWheel;

    public interface Formatter {
        String format(int r1);
    }

    public interface OnScrollListener {
        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;

        void onScrollStateChange(BluetoothNumberPicker r1, int r2);
    }

    public interface OnValueChangeListener {
        void onValueChange(BluetoothNumberPicker r1, int r2, int r3);
    }

    private static class TwoDigitFormatter implements Formatter {
        final Object[] mArgs;
        final StringBuilder mBuilder;
        java.util.Formatter mFmt;
        char mZeroDigit;

        private static char getZeroDigit(Locale r0) {
            return '0';
        }

        TwoDigitFormatter() {
            this.mBuilder = new StringBuilder();
            this.mArgs = new Object[1];
            init(Locale.getDefault());
        }

        private void init(Locale r2) {
            this.mFmt = createFormatter(r2);
            this.mZeroDigit = getZeroDigit(r2);
        }

        @Override // com.android.settings.bluetooth.BluetoothNumberPicker.Formatter
        public String format(int r4) {
            Locale r0 = Locale.getDefault();
            if (this.mZeroDigit == getZeroDigit(r0)) goto L5;
            init(r0);
        L5:
            this.mArgs[0] = Integer.valueOf(r4);
            StringBuilder r5 = this.mBuilder;
            r5.delete(0, r5.length());
            this.mFmt.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, this.mArgs);
            return this.mFmt.toString();
        }

        private java.util.Formatter createFormatter(Locale r2) {
            return new java.util.Formatter(this.mBuilder, r2);
        }
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        return 0.0f;
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        return 0.0f;
    }

    static {
        DEFAUlT_TEXT_COLOR = Color.parseColor("#545454");
        mTwoDigitFormatter = new TwoDigitFormatter();
    }

    public static final Formatter getTwoDigitFormatter() {
        return mTwoDigitFormatter;
    }

    public BluetoothNumberPicker(Context r2) {
        this(r2, null);
    }

    public BluetoothNumberPicker(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public BluetoothNumberPicker(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.mSelectorIndexToStringCache = new SparseArray();
        this.mSelectorIndices = new int[5];
        this.mNormalSize = 45;
        this.mHighlightSize = 45;
        int r5 = DEFAUlT_TEXT_COLOR;
        this.mNormalColor = r5;
        this.mHighlightColor = r5;
        this.mInitialScrollOffset = Integer.MIN_VALUE;
        this.mScrollState = 0;
        this.mHasSelectorWheel = true;
        this.mMinHeight = -1;
        this.mMaxHeight = -1;
        this.mMinWidth = -1;
        this.mMaxWidth = -1;
        this.mComputeMaxWidth = true;
        setWillNotDraw(!true);
        ViewConfiguration r6 = ViewConfiguration.get(r2.getApplicationContext());
        this.mTouchSlop = r6.getScaledTouchSlop();
        this.mMinimumFlingVelocity = r6.getScaledMinimumFlingVelocity();
        this.mMaximumFlingVelocity = r6.getScaledMaximumFlingVelocity() / 8;
        Paint r7 = new Paint();
        r7.setAntiAlias(true);
        r7.setTextAlign(Paint.Align.CENTER);
        r7.setTextSize(this.mNormalSize);
        r7.setColor(this.mNormalColor);
        this.mSelectorWheelPaint = r7;
        this.mFlingScroller = new Scroller(getContext(), null, true);
        this.mAdjustScroller = new Scroller(getContext(), new DecelerateInterpolator(2.5f));
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        if (this.mHasSelectorWheel == true) goto L6;
        super.onLayout(r2, r3, r4, r5, r6);
        return;
    L6:
        if (r2 == false) goto L9;
        initializeSelectorWheel();
        initializeFadingEdges();
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r3, int r4) {
        if (this.mHasSelectorWheel == true) goto L6;
        super.onMeasure(r3, r4);
        return;
    L6:
        super.onMeasure(makeMeasureSpec(r3, this.mMaxWidth), makeMeasureSpec(r4, this.mMaxHeight));
        setMeasuredDimension(resolveSizeAndStateRespectingMinSize(this.mMinWidth, getMeasuredWidth(), r3), resolveSizeAndStateRespectingMinSize(this.mMinHeight, getMeasuredHeight(), r4));
    }

    private boolean moveToFinalScrollerPosition(Scroller r7) {
        r7.forceFinished(true);
        int r1 = r7.getFinalY() - r7.getCurrY();
        int r8 = (this.mCurrentScrollOffset + r1) % this.mSelectorElementHeight;
        int r2 = this.mInitialScrollOffset - r8;
        if (r2 == 0) goto L11;
        int r3 = Math.abs(r2);
        int r4 = this.mSelectorElementHeight;
        if (r3 <= (r4 / 2)) goto L9;
        if (r2 <= 0) goto L8;
        r2 = r2 - r4;
        goto L9
    L8:
        r2 = r2 + r4;
    L9:
        scrollBy(0, r1 + r2);
        return true;
    L11:
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r5) {
        if (this.mHasSelectorWheel == true) goto L5;
    L24:
        return false;
    L5:
        if (isEnabled() == false) goto L24;
        if (r5.getActionMasked() == 0) goto L10;
        return false;
    L10:
        float r0 = r5.getY();
        this.mLastDownEventY = r0;
        this.mLastDownOrMoveEventY = r0;
        this.mLastDownEventTime = r5.getEventTime();
        this.mIngonreMoveEvents = false;
        this.mShowSoftInputOnTap = false;
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.mFlingScroller.isFinished() == true) goto L14;
        this.mFlingScroller.forceFinished(true);
        this.mAdjustScroller.forceFinished(true);
        onScrollStateChange(0);
    L23:
        return true;
    L14:
        if (this.mAdjustScroller.isFinished() == true) goto L16;
        this.mFlingScroller.forceFinished(true);
        this.mAdjustScroller.forceFinished(true);
        goto L23
    L16:
        float r6 = this.mLastDownEventY;
        if (r6 < this.mTopSelectionDividerTop) goto L23;
        if (r6 > this.mBottomSelectionDividerBottom) goto L23;
        this.mShowSoftInputOnTap = true;
        goto L23
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (isEnabled() == true) goto L5;
    L43:
        return false;
    L5:
        if (this.mHasSelectorWheel == false) goto L43;
        if (this.mVelocityTracker != null) goto L10;
        this.mVelocityTracker = VelocityTracker.obtain();
    L10:
        this.mVelocityTracker.addMovement(r10);
        int r0 = r10.getActionMasked();
        if (r0 == 1) goto L24;
        if (r0 == 2) goto L15;
    L42:
        return true;
    L15:
        if (this.mIngonreMoveEvents == true) goto L42;
        float r11 = r10.getY();
        if (this.mScrollState != 1) goto L20;
        scrollBy(0, (int) (r11 - this.mLastDownOrMoveEventY));
        invalidate();
    L23:
        this.mLastDownOrMoveEventY = r11;
        goto L42
    L20:
        if (((int) Math.abs(r11 - this.mLastDownEventY)) <= this.mTouchSlop) goto L23;
        onScrollStateChange(1);
        goto L23
    L24:
        VelocityTracker r1 = this.mVelocityTracker;
        r1.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
        int r2 = (int) r1.getYVelocity();
        if (Math.abs(r2) <= this.mMinimumFlingVelocity) goto L27;
        fling(r2);
        onScrollStateChange(2);
    L41:
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
        goto L42
    L27:
        int r3 = (int) r10.getY();
        int r4 = (int) Math.abs(r3 - this.mLastDownEventY);
        long r5 = r10.getEventTime() - this.mLastDownEventTime;
        if (r4 <= this.mTouchSlop) goto L30;
    L39:
        ensureScrollWheelAdjusted();
    L40:
        onScrollStateChange(0);
        goto L41
    L30:
        if (r5 >= ViewConfiguration.getTapTimeout()) goto L39;
        if (this.mShowSoftInputOnTap == false) goto L34;
        this.mShowSoftInputOnTap = false;
        goto L40
    L34:
        int r6 = (r3 / this.mSelectorElementHeight) - 2;
        if (r6 <= 0) goto L37;
        changeValueByOne(true);
        goto L40
    L37:
        if (r6 >= 0) goto L40;
        changeValueByOne(false);
        goto L40
    }

    @Override // android.view.View
    public void computeScroll() {
        Scroller r0 = this.mFlingScroller;
        if (r0.isFinished() == false) goto L7;
        r0 = this.mAdjustScroller;
        if (r0.isFinished() == false) goto L7;
        return;
    L7:
        r0.computeScrollOffset();
        int r1 = r0.getCurrY();
        if (this.mPreviousScrollerY != 0) goto L10;
        this.mPreviousScrollerY = r0.getStartY();
    L10:
        scrollBy(0, r1 - this.mPreviousScrollerY);
        this.mPreviousScrollerY = r1;
        if (r0.isFinished() == false) goto L13;
        onScrollerFinished(r0);
        return;
    L13:
        invalidate();
    }

    @Override // android.view.View
    public void scrollBy(int r5, int r6) {
        int[] r7 = this.mSelectorIndices;
        boolean r0 = this.mWrapSelectorWheel;
        if (r0 == true) goto L9;
        if (r6 <= 0) goto L9;
        if (r7[2] > this.mMinValue) goto L9;
        this.mCurrentScrollOffset = this.mInitialScrollOffset;
        return;
    L9:
        if (r0 == true) goto L15;
        if (r6 >= 0) goto L15;
        if (r7[2] < this.mMaxValue) goto L15;
        this.mCurrentScrollOffset = this.mInitialScrollOffset;
        return;
    L15:
        this.mCurrentScrollOffset += r6;
    L16:
        int r8 = this.mCurrentScrollOffset;
        if ((r8 - this.mInitialScrollOffset) <= this.mSelectorTextGapHeight) goto L23;
        this.mCurrentScrollOffset = r8 - this.mSelectorElementHeight;
        decrementSelectorIndices(r7);
        setValueInternal(r7[2], true);
        if (this.mWrapSelectorWheel == true) goto L16;
        if (r7[2] > this.mMinValue) goto L16;
        this.mCurrentScrollOffset = this.mInitialScrollOffset;
    L23:
        int r9 = this.mCurrentScrollOffset;
        if ((r9 - this.mInitialScrollOffset) >= (-this.mSelectorTextGapHeight)) goto L30;
        this.mCurrentScrollOffset = r9 + this.mSelectorElementHeight;
        incrementSelectorIndices(r7);
        setValueInternal(r7[2], true);
        if (this.mWrapSelectorWheel == true) goto L23;
        if (r7[2] < this.mMaxValue) goto L23;
        this.mCurrentScrollOffset = this.mInitialScrollOffset;
        goto L23
    }

    public void setOnValueChangedListener(OnValueChangeListener r1) {
        this.mOnValueChangeListener = r1;
    }

    public void setOnScrollListener(OnScrollListener r1) {
        this.mOnScrollListener = r1;
    }

    public void setFormatter(Formatter r2) {
        if (r2 != this.mFormatter) goto L5;
        return;
    L5:
        this.mFormatter = r2;
        initializeSelectorWheelIndices();
    }

    public void setValue(int r2) {
        setValueInternal(r2, false);
    }

    private void tryComputeMaxWidth() {
        if (this.mComputeMaxWidth == true) goto L5;
        return;
    L5:
        String[] r0 = this.mDisplayedValues;
        int r1 = 0;
        if (r0 != null) goto L17;
        float r2 = 0.0f;
    L9:
        if (r1 > 9) goto L14;
        float r3 = this.mSelectorWheelPaint.measureText(formatNumberWithLocale(r1));
        if (r3 <= r2) goto L13;
        r2 = r3;
    L13:
        r1 = r1 + 1;
        goto L9
    L14:
        int r5 = this.mMaxValue;
    L15:
        if (r5 <= 0) goto L23;
        r5 = r5 / 10;
        goto L15
    L23:
        return;
    L17:
        int r4 = r0.length;
        int r6 = 0;
    L18:
        if (r1 >= r4) goto L31;
        float r7 = this.mSelectorWheelPaint.measureText(this.mDisplayedValues[r1]);
        if (r7 <= r6) goto L22;
        r6 = (int) r7;
    L22:
        r1 = r1 + 1;
        goto L18
    }

    public boolean getWrapSelectorWheel() {
        return this.mWrapSelectorWheel;
    }

    public void setWrapSelectorWheel(boolean r3) {
        if ((this.mMaxValue - this.mMinValue) < this.mSelectorIndices.length) goto L5;
        boolean r0 = true;
    L6:
        if (r3 == false) goto L9;
        if (r0 == true) goto L9;
        return;
    L9:
        if (r3 == this.mWrapSelectorWheel) goto L13;
        this.mWrapSelectorWheel = r3;
        return;
    L13:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public int getValue() {
        return this.mValue;
    }

    public int getMinValue() {
        return this.mMinValue;
    }

    public void setMinValue(int r2) {
        if (this.mMinValue != r2) goto L5;
        return;
    L5:
        if (r2 < 0) goto L16;
        this.mMinValue = r2;
        if (r2 <= this.mValue) goto L10;
        this.mValue = r2;
    L10:
        if ((this.mMaxValue - r2) <= this.mSelectorIndices.length) goto L12;
        boolean r3 = true;
    L13:
        setWrapSelectorWheel(r3);
        initializeSelectorWheelIndices();
        tryComputeMaxWidth();
        invalidate();
        return;
    L12:
        r3 = false;
        goto L13
    L16:
        throw new IllegalArgumentException("minValue must be >= 0");
    }

    public int getMaxValue() {
        return this.mMaxValue;
    }

    public void setMaxValue(int r2) {
        if (this.mMaxValue != r2) goto L5;
        return;
    L5:
        if (r2 < 0) goto L16;
        this.mMaxValue = r2;
        if (r2 >= this.mValue) goto L10;
        this.mValue = r2;
    L10:
        if ((r2 - this.mMinValue) <= this.mSelectorIndices.length) goto L12;
        boolean r3 = true;
    L13:
        setWrapSelectorWheel(r3);
        initializeSelectorWheelIndices();
        tryComputeMaxWidth();
        invalidate();
        return;
    L12:
        r3 = false;
        goto L13
    L16:
        throw new IllegalArgumentException("maxValue must be >= 0");
    }

    public void setTextSize(int r1, int r2) {
        if (r1 < 0) goto L7;
        if (r2 < 0) goto L7;
        this.mNormalSize = r1;
        this.mHighlightSize = r2;
        return;
    L7:
        throw new IllegalArgumentException("the text size mus be >= 0 ");
    }

    private float getTextSizeByOffset(int r10) {
        int r0 = this.mMiddleScrollOffset;
        int r1 = this.mSelectorElementHeight;
        if (r10 <= (r0 - r1)) goto L17;
        if (r10 >= (r0 + r1)) goto L17;
        if (r10 >= r0) goto L11;
        int r4 = this.mNormalSize;
        return (float) (((double) r4) + (((((double) (r10 - (r0 - r1))) * 1.0d) / ((double) r1)) * ((double) (this.mHighlightSize - r4))));
    L11:
        if (r10 < r0) goto L15;
        int r5 = this.mNormalSize;
        return (float) (((double) r5) + (((((double) ((r0 + r1) - r10)) * 1.0d) / ((double) r1)) * ((double) (this.mHighlightSize - r5))));
    L15:
        return this.mNormalSize;
    L17:
        return this.mNormalSize;
    }

    public void setTextColor(int r1, int r2) {
        this.mNormalColor = r1;
        this.mHighlightColor = r2;
    }

    private int getTextColorByOffset(int r8) {
        int r0 = this.mMiddleScrollOffset;
        int r1 = this.mSelectorElementHeight;
        if (r8 <= (r0 - r1)) goto L19;
        if (r8 >= (r0 + r1)) goto L19;
        if (r8 != r0) goto L11;
        return this.mHighlightColor;
    L11:
        if (r8 >= r0) goto L13;
        float r3 = ((r8 - (r0 - r1)) * 1.0f) / r1;
    L14:
        if (r8 < r0) goto L16;
        r3 = (((r0 + r1) - r8) * 1.0f) / r1;
    L16:
        int r9 = this.mNormalColor;
        int r2 = r9 & 16777215;
        int r7 = this.mHighlightColor;
        int r4 = 16777215 & r7;
        int r5 = r2 & 255;
        int r6 = (r2 >> 8) & 255;
        int r10 = (r2 >> 16) & 255;
        int r11 = r9 >> 24;
        return (((int) (r11 + (((r7 >> 24) - r11) * r3))) << 24) | ((((int) (r10 + ((((r4 >> 16) & 255) - r10) * r3))) << 16) | ((((int) (r5 + (((r4 & 255) - r5) * r3))) | 0) | (((int) (r6 + ((((r4 >> 8) & 255) - r6) * r3))) << 8)));
    L13:
        r3 = 1.0f;
    L19:
        return this.mNormalColor;
    }

    public String[] getDisplayedValues() {
        return this.mDisplayedValues;
    }

    public void setDisplayedValues(String[] r2) {
        if (this.mDisplayedValues != r2) goto L5;
        return;
    L5:
        this.mDisplayedValues = r2;
        initializeSelectorWheelIndices();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas r9) {
        if (this.mHasSelectorWheel == true) goto L6;
        super.onDraw(r9);
        return;
    L6:
        int r0 = this.mCurrentScrollOffset;
        int r1 = (getRight() - getLeft()) / 2;
        int[] r2 = this.mSelectorIndices;
        int r3 = 0;
    L8:
        if (r3 >= r2.length) goto L13;
        String r4 = this.mSelectorIndexToStringCache.get(r2[r3]);
        this.mSelectorWheelPaint.setTextSize(getTextSizeByOffset(r0));
        this.mSelectorWheelPaint.setColor(getTextColorByOffset(r0));
        if (r4 == null) goto L12;
        r9.drawText(r4, r1, r0, this.mSelectorWheelPaint);
    L12:
        r0 = r0 + this.mSelectorElementHeight;
        r3 = r3 + 1;
        goto L8
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r3) {
        super.onInitializeAccessibilityEvent(r3);
        r3.setClassName(BluetoothNumberPicker.class.getName());
        r3.setScrollable(true);
        r3.setScrollY((this.mMinValue + this.mValue) * this.mSelectorElementHeight);
    }

    private int makeMeasureSpec(int r4, int r5) {
        if (r5 != (-1)) goto L5;
        return r4;
    L5:
        int r3 = View.MeasureSpec.getSize(r4);
        int r0 = View.MeasureSpec.getMode(r4);
        if (r0 == Integer.MIN_VALUE) goto L15;
        if (r0 == 0) goto L13;
        if (r0 != 1073741824) goto L11;
        return r4;
    L11:
        throw new IllegalArgumentException("Unknown measure mode: " + r0);
    L13:
        return View.MeasureSpec.makeMeasureSpec(r5, 1073741824);
    L15:
        return View.MeasureSpec.makeMeasureSpec(Math.min(r3, r5), 1073741824);
    }

    private int resolveSizeAndStateRespectingMinSize(int r1, int r2, int r3) {
        if (r1 != (-1)) goto L5;
        return r2;
    L5:
        return resolveSizeAndState(Math.max(r1, r2), r3, 0);
    }

    private void initializeSelectorWheelIndices() {
        this.mSelectorIndexToStringCache.clear();
        int[] r0 = this.mSelectorIndices;
        int r1 = getValue();
        int r2 = 0;
    L4:
        if (r2 >= this.mSelectorIndices.length) goto L9;
        int r3 = (r2 - 2) + r1;
        if (this.mWrapSelectorWheel == false) goto L8;
        r3 = getWrappedSelectorIndex(r3);
    L8:
        r0[r2] = r3;
        ensureCachedScrollSelectorValue(r3);
        r2 = r2 + 1;
        goto L4
    }

    private void setValueInternal(int r2, boolean r3) {
        if (this.mValue != r2) goto L6;
        return;
    L6:
        if (this.mWrapSelectorWheel == false) goto L8;
        int r4 = getWrappedSelectorIndex(r2);
    L9:
        int r0 = this.mValue;
        this.mValue = r4;
        if (r3 == false) goto L12;
        notifyChange(r0, r4);
    L12:
        initializeSelectorWheelIndices();
        invalidate();
        return;
    L8:
        r4 = Math.min(Math.max(r2, this.mMinValue), this.mMaxValue);
        goto L9
    }

    private void changeValueByOne(boolean r14) {
        if (this.mHasSelectorWheel == false) goto L13;
        if (moveToFinalScrollerPosition(this.mFlingScroller) == true) goto L7;
        moveToFinalScrollerPosition(this.mAdjustScroller);
    L7:
        this.mPreviousScrollerY = 0;
        if (r14 == false) goto L10;
        this.mFlingScroller.startScroll(0, 0, 0, -this.mSelectorElementHeight, 300);
    L11:
        invalidate();
        return;
    L10:
        this.mFlingScroller.startScroll(0, 0, 0, this.mSelectorElementHeight, 300);
        goto L11
    L13:
        if (r14 == false) goto L15;
        setValueInternal(this.mValue + 1, true);
        return;
    L15:
        setValueInternal(this.mValue - 1, true);
    }

    private void initializeSelectorWheel() {
        initializeSelectorWheelIndices();
        int[] r0 = this.mSelectorIndices;
        int r1 = (int) ((((getBottom() - getTop()) - (r0.length * this.mNormalSize)) / r0.length) + 0.5f);
        this.mSelectorTextGapHeight = r1;
        this.mSelectorElementHeight = this.mNormalSize + r1;
        int r2 = (getHeight() + this.mNormalSize) / 2;
        int r3 = this.mSelectorElementHeight;
        int r4 = r2 - (r3 * 2);
        this.mInitialScrollOffset = r4;
        this.mMiddleScrollOffset = (r3 * 2) + r4;
        this.mCurrentScrollOffset = r4;
    }

    private void initializeFadingEdges() {
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(((getBottom() - getTop()) - this.mNormalSize) / 2);
    }

    private void onScrollerFinished(Scroller r2) {
        if (r2 != this.mFlingScroller) goto L6;
        ensureScrollWheelAdjusted();
        onScrollStateChange(0);
        return;
    }

    private void onScrollStateChange(int r2) {
        if (this.mScrollState != r2) goto L5;
        return;
    L5:
        this.mScrollState = r2;
        OnScrollListener r0 = this.mOnScrollListener;
        if (r0 == null) goto L9;
        r0.onScrollStateChange(this, r2);
        return;
    }

    private void fling(int r11) {
        this.mPreviousScrollerY = 0;
        if (r11 <= 0) goto L5;
        this.mFlingScroller.fling(0, 0, 0, r11, 0, 0, 0, Integer.MAX_VALUE);
    L6:
        invalidate();
        return;
    L5:
        this.mFlingScroller.fling(0, Integer.MAX_VALUE, 0, r11, 0, 0, 0, Integer.MAX_VALUE);
        goto L6
    }

    private int getWrappedSelectorIndex(int r2) {
        int r0 = this.mMaxValue;
        if (r2 > r0) goto L5;
        int r1 = this.mMinValue;
        if (r2 < r1) goto L9;
        return r2;
    L9:
        return (r0 - ((r1 - r2) % (r0 - r1))) + 1;
    L5:
        return (this.mMinValue + ((r2 - r0) % r0)) - 1;
    }

    private void incrementSelectorIndices(int[] r4) {
        int r0 = 0;
    L4:
        if (r0 >= (r4.length - 1)) goto L6;
        int r1 = r0 + 1;
        r4[r0] = r4[r1];
        r0 = r1;
        goto L4
    L6:
        int r2 = r4[r4.length - 2] + 1;
        if (this.mWrapSelectorWheel == true) goto L9;
    L11:
        r4[r4.length - 1] = r2;
        ensureCachedScrollSelectorValue(r2);
        return;
    L9:
        if (r2 <= this.mMaxValue) goto L11;
        r2 = this.mMinValue;
        goto L11
    }

    private void decrementSelectorIndices(int[] r4) {
        int r0 = r4.length - 1;
    L3:
        if (r0 <= 0) goto L5;
        r4[r0] = r4[r0 - 1];
        r0 = r0 - 1;
        goto L3
    L5:
        int r1 = r4[1] - 1;
        if (this.mWrapSelectorWheel == true) goto L8;
    L10:
        r4[0] = r1;
        ensureCachedScrollSelectorValue(r1);
        return;
    L8:
        if (r1 >= this.mMinValue) goto L10;
        r1 = this.mMaxValue;
        goto L10
    }

    private void ensureCachedScrollSelectorValue(int r4) {
        SparseArray<String> r0 = this.mSelectorIndexToStringCache;
        if (r0.get(r4) == null) goto L5;
        return;
    L5:
        int r1 = this.mMinValue;
        if (r4 >= r1) goto L8;
    L14:
        String r3 = "";
    L15:
        r0.put(r4, r3);
        return;
    L8:
        if (r4 > this.mMaxValue) goto L14;
        String[] r2 = this.mDisplayedValues;
        if (r2 == null) goto L13;
        r3 = r2[r4 - r1];
        goto L15
    L13:
        r3 = formatNumber(r4);
        goto L15
    }

    private String formatNumber(int r1) {
        Formatter r0 = this.mFormatter;
        if (r0 == null) goto L6;
        return r0.format(r1);
    L6:
        return formatNumberWithLocale(r1);
    }

    private void notifyChange(int r2, int r3) {
        OnValueChangeListener r4 = this.mOnValueChangeListener;
        if (r4 == null) goto L6;
        r4.onValueChange(this, r2, this.mValue);
        return;
    }

    private boolean ensureScrollWheelAdjusted() {
        int r0 = this.mInitialScrollOffset - this.mCurrentScrollOffset;
        if (r0 == 0) goto L11;
        this.mPreviousScrollerY = 0;
        int r1 = Math.abs(r0);
        int r2 = this.mSelectorElementHeight;
        if (r1 <= (r2 / 2)) goto L9;
        if (r0 <= 0) goto L8;
        r2 = -r2;
    L8:
        r0 = r0 + r2;
    L9:
        Scroller r3 = this.mAdjustScroller;
        r3.startScroll(0, 0, 0, r0, 800);
        invalidate();
        return true;
    L11:
        return false;
    }

    private static String formatNumberWithLocale(int r3) {
        return String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(r3)});
    }
}
