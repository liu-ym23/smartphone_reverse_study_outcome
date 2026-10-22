package obric.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class WheelTextView extends View {
    private static final String END_TEXT = "...";
    private static final float MAX_FONT_SCALE_WITH_SUBTITLE = 1.1f;
    private static int MAX_NO_ACTION_OFFSET = 0;
    private static int MIN_ACTION_OFFSET = 0;
    private static final int MSG_SET_GLOBAL_LAYOUT_LISTENER = 4096;
    private static final int SELECTOR_ADJUSTMENT_DURATION_MILLIS = 150;
    private static final String TAG = "SmartisanWheelTextView";
    private final Scroller mAdjustScroller;
    private int mClickTimeout;
    private float mContentPaddingTop;
    private int mCurrentScrollOffset;
    private String[] mDisplayedValues;
    private float mDownX;
    private float mDownY;
    private int mDrawSubtitleLen;
    private int mDrawTitleLen;
    private int mHostWidth;
    private boolean mIngonreMoveEvents;
    private int mInitialScrollOffset;
    private boolean mIsNeedRotate;
    private float mLastDownOrMoveEventY;
    private int mLeftElementsWidth;
    private View mLeftIconView;
    private View mLeftView;
    private int mMaxAvailableWidth;
    private float mMaxSubtitleSize;
    private float mMaxTitleSize;
    private float mMaxTitleSizeWithSubtitle;
    private OnValueChangeListener mOnValueChangeListener;
    private int mPaddingLeftOffset;
    private Paint mPaint;
    private int mPreviousScrollerY;
    private int mRightElementsWidth;
    private View mRightIconView;
    private List<Button> mRightViewList;
    private int mSelectorElementHeight;
    private int[] mSelectorIndices;
    private String mSubContent;
    private Paint mSubPaint;
    private float mSubtitleSize;
    private int mTextColor;
    private boolean mTitleAlignCenter;
    private float mTitleSize;
    private int mTouchSlop;
    private int mValue;

    public interface OnValueChangeListener {
        void onValueChange(WheelTextView picker, int oldVal, int newVal);
    }

    public WheelTextView(Context context) {
        this(context, null);
    }

    public WheelTextView(Context context, AttributeSet attrs) {
        this(context, attrs, R.style.TitleTextStyle);
    }

    public WheelTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mMaxTitleSize = 2.1474836E9f;
        this.mIsNeedRotate = false;
        this.mInitialScrollOffset = Integer.MIN_VALUE;
        this.mTitleAlignCenter = true;
        TypedArray r6 = context.getTheme().obtainStyledAttributes(defStyle, R.styleable.SmartisanWheelTextView);
        if (r6 == null) goto L5;
        this.mTextColor = r6.getColorStateList(R.styleable.SmartisanWheelTextView_android_textColor).getDefaultColor();
        this.mTitleSize = r6.getDimensionPixelSize(R.styleable.SmartisanWheelTextView_android_textSize, -1);
        r6.recycle();
    L5:
        MAX_NO_ACTION_OFFSET = (int) dp2px(6.6666665f);
        MIN_ACTION_OFFSET = (int) dp2px(16.666666f);
        initMaxSize();
        setWillNotDraw(false);
        setFocusable(true);
        initTitlePaint();
        initSubtitlePaint();
        this.mContentPaddingTop = TypedValue.applyDimension(1, 6.0f, getResources().getDisplayMetrics());
        this.mAdjustScroller = new Scroller(getContext(), new DecelerateInterpolator(1.0f));
        this.mClickTimeout = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private void initMaxSize() {
        Resources r0 = getResources();
        Configuration r1 = r0.getConfiguration();
        this.mMaxTitleSizeWithSubtitle = (r0.getDimensionPixelSize(R.dimen.title_bar_title_text_size) / r1.fontScale) * MAX_FONT_SCALE_WITH_SUBTITLE;
        this.mMaxSubtitleSize = (r0.getDimensionPixelSize(R.dimen.item_sub_title_size) / r1.fontScale) * MAX_FONT_SCALE_WITH_SUBTITLE;
    }

    private void initTitlePaint() {
        Paint r0 = new Paint(33);
        this.mPaint = r0;
        r0.setAntiAlias(true);
        this.mPaint.setTextSize(this.mTitleSize);
        this.mPaint.setColor(this.mTextColor);
    }

    private void initSubtitlePaint() {
        Paint r0 = new Paint();
        this.mSubPaint = r0;
        r0.setAntiAlias(true);
        float r1 = getResources().getDimensionPixelSize(R.dimen.item_sub_title_size);
        this.mSubtitleSize = r1;
        this.mSubPaint.setTextSize(r1);
        this.mSubPaint.setColor(getResources().getColor(R.color.sub_title_text_color));
    }

    public void setSubTextSize(float size) {
        this.mSubtitleSize = size;
    }

    void setTitleColor(int colorValue) {
        this.mPaint.setColor(colorValue);
    }

    void setSubtitleColor(int colorValue) {
        this.mSubPaint.setColor(colorValue);
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (changed == false) goto L5;
        initializeSelectorWheel();
        return;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int r0 = View.MeasureSpec.getMode(widthMeasureSpec);
        int r3 = View.MeasureSpec.getSize(widthMeasureSpec);
        int r4 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (r0 != 1073741824) goto L5;
        handleTextByWidth();
    L6:
        setMeasuredDimension(Math.max(r3, getMinimumWidth()), r4);
        initializeSelectorWheel();
        return;
    L5:
        r3 = handleTextByWidth();
        goto L6
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (isEnabled() == false) goto L37;
        if (isSupportRotate() == false) goto L37;
        int r0 = event.getActionMasked();
        float r1 = event.getX();
        float r2 = event.getY();
        float r3 = Math.abs(r1 - this.mDownX);
        float r4 = Math.abs(r2 - this.mDownY);
        if (r0 == 0) goto L32;
        if (r0 != 1) goto L11;
    L22:
        float r10 = event.getEventTime() - event.getDownTime();
        if (this.mIsNeedRotate == false) goto L25;
        ensureScrollWheelAdjusted();
    L25:
        int r5 = this.mTouchSlop;
        if (r4 < r5) goto L28;
    L35:
        return true;
    L28:
        if (r3 >= r5) goto L35;
        if (r10 >= this.mClickTimeout) goto L35;
        performClick();
        goto L35
    L11:
        if (r0 == 2) goto L16;
        if (r0 == 3) goto L22;
    L16:
        if (this.mIngonreMoveEvents == true) goto L35;
        float r11 = event.getY();
        int r6 = (int) (r11 - this.mLastDownOrMoveEventY);
        if (this.mIsNeedRotate == false) goto L21;
        scrollBy(0, r6);
        invalidate();
    L21:
        this.mLastDownOrMoveEventY = r11;
        goto L35
    L32:
        this.mDownX = event.getX();
        float r12 = event.getY();
        this.mDownY = r12;
        this.mLastDownOrMoveEventY = r12;
        this.mIngonreMoveEvents = false;
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.mAdjustScroller.isFinished() == true) goto L35;
        this.mAdjustScroller.forceFinished(true);
    L37:
        return super.onTouchEvent(event);
    }

    @Override // android.view.View
    public void computeScroll() {
        Scroller r0 = this.mAdjustScroller;
        if (r0.isFinished() == false) goto L5;
        return;
    L5:
        r0.computeScrollOffset();
        int r1 = r0.getCurrY();
        if (this.mPreviousScrollerY != Integer.MAX_VALUE) goto L8;
        this.mPreviousScrollerY = r0.getStartY();
    L8:
        scrollBy(0, r1 - this.mPreviousScrollerY);
        this.mPreviousScrollerY = r1;
        if (r0.isFinished() == true) goto L12;
        invalidate();
        return;
    }

    private float dp2px(float dp) {
        return TypedValue.applyDimension(1, dp, getResources().getDisplayMetrics());
    }

    @Override // android.view.View
    public void scrollBy(int x, int y) {
        int r5 = MAX_NO_ACTION_OFFSET;
        if (y <= r5) goto L5;
        y = r5;
    L5:
        int[] r6 = this.mSelectorIndices;
        int r0 = this.mCurrentScrollOffset + y;
        this.mCurrentScrollOffset = r0;
        if (Math.abs(r0 - this.mInitialScrollOffset) > MAX_NO_ACTION_OFFSET) goto L8;
        return;
    L8:
        int r7 = this.mCurrentScrollOffset;
        int r1 = this.mInitialScrollOffset;
        int r2 = r7 - r1;
        int r3 = MIN_ACTION_OFFSET;
        if (r2 <= r3) goto L15;
        if (this.mIngonreMoveEvents == true) goto L15;
        this.mCurrentScrollOffset = r7 - this.mSelectorElementHeight;
        decrementSelectorIndices(r6);
        setValueInternal(this.mValue - 1, true);
        ensureScrollWheelAdjusted();
        this.mIngonreMoveEvents = true;
        return;
    L15:
        if ((r7 - r1) < (-r3)) goto L17;
        return;
    L17:
        if (this.mIngonreMoveEvents == true) goto L21;
        this.mCurrentScrollOffset = r7 + this.mSelectorElementHeight;
        incrementSelectorIndices(r6);
        setValueInternal(this.mValue + 1, true);
        ensureScrollWheelAdjusted();
        this.mIngonreMoveEvents = true;
        return;
    }

    public void setAvailWidth(int max) {
        this.mMaxAvailableWidth = Math.max(getMinimumWidth(), max);
    }

    public void setOnValueChangedListener(OnValueChangeListener onValueChangeListener) {
        this.mOnValueChangeListener = onValueChangeListener;
    }

    public void setValue(int value) {
        setValueInternal(value, false);
    }

    public int getValue() {
        return this.mValue;
    }

    public void setDisplayedValues(String... displayedValues) {
        if (displayedValues != null) goto L4;
        return;
    L4:
        if (displayedValues.length != 0) goto L7;
        return;
    L7:
        if (displayedValues.equals(this.mDisplayedValues) == false) goto L9;
        return;
    L9:
        this.mDisplayedValues = displayedValues;
        initializeSelectorWheelIndices();
        requestLayout();
    }

    public void setSubContentText(String text) {
        this.mSubContent = text;
        requestLayout();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String[] r0 = this.mDisplayedValues;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length > 0) goto L8;
        return;
    L8:
        if (r0.length != 1) goto L10;
    L30:
        drawSingleLineText(canvas, r0[0]);
        return;
    L10:
        if (this.mIsNeedRotate == false) goto L30;
        if (this.mSelectorIndices == null) goto L29;
        if (r0 == null) goto L36;
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        int r1 = this.mCurrentScrollOffset;
        int r2 = (getRight() - getLeft()) / 2;
        int[] r3 = this.mSelectorIndices;
        int r4 = 0;
    L18:
        if (r4 >= r3.length) goto L39;
        int r5 = r3[r4];
        if (r5 >= 0) goto L22;
        int r6 = Math.abs(r5 + this.mDisplayedValues.length) % this.mDisplayedValues.length;
    L23:
        String r7 = this.mDisplayedValues[r6];
        int r8 = this.mDrawTitleLen;
        if (r8 == 0) goto L28;
        if (r8 >= r7.length()) goto L28;
        r7 = r7.substring(0, Math.max(0, this.mDrawTitleLen)) + END_TEXT;
    L28:
        canvas.drawText(r7, r2, r1, this.mPaint);
        r1 = r1 + this.mSelectorElementHeight;
        r4 = r4 + 1;
        goto L18
    L22:
        r6 = r5 % this.mDisplayedValues.length;
        goto L23
    L39:
        return;
    L36:
        return;
    }

    private void drawSingleLineText(Canvas canvas, String drawText) {
        if (TextUtils.isEmpty(drawText) == true) goto L5;
    L7:
        Paint r0 = this.mPaint;
        if (TextUtils.isEmpty(this.mSubContent) == false) goto L10;
        float r1 = Math.min(this.mTitleSize, this.mMaxTitleSize);
    L11:
        r0.setTextSize(r1);
        Paint r2 = this.mSubPaint;
        if (TextUtils.isEmpty(this.mSubContent) == false) goto L14;
        float r3 = this.mSubtitleSize;
    L15:
        r2.setTextSize(r3);
        Paint.FontMetricsInt r4 = this.mPaint.getFontMetricsInt();
        float r5 = 0.0f;
        if (TextUtils.isEmpty(drawText) == true) goto L18;
        float r6 = (getMeasuredHeight() - (r4.bottom + r4.top)) / 2;
    L20:
        if (TextUtils.isEmpty(this.mSubContent) == true) goto L25;
        Paint.FontMetricsInt r7 = this.mSubPaint.getFontMetricsInt();
        if (TextUtils.isEmpty(drawText) == true) goto L24;
        r6 = this.mContentPaddingTop - this.mPaint.getFontMetricsInt().top;
        r5 = r6 + (r7.bottom - r7.top);
        goto L25
    L24:
        r5 = ((getMeasuredHeight() - r7.bottom) - r7.top) / 2;
    L25:
        int r8 = getMeasuredWidth() / 2;
        if (TextUtils.isEmpty(drawText) == true) goto L34;
        int r9 = this.mDrawTitleLen;
        if (r9 > 0) goto L30;
    L32:
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(drawText, r8, r6, this.mPaint);
        goto L34
    L30:
        if (r9 >= drawText.length()) goto L32;
        drawText = drawText.substring(0, Math.max(0, this.mDrawTitleLen - 1)) + END_TEXT;
    L34:
        if (TextUtils.isEmpty(this.mSubContent) == true) goto L43;
        int r10 = this.mDrawSubtitleLen;
        if (r10 > 0) goto L38;
    L40:
        String r11 = this.mSubContent;
    L41:
        this.mSubPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(r11, r8, r5, this.mSubPaint);
        return;
    L38:
        if (r10 >= this.mSubContent.length()) goto L40;
        r11 = this.mSubContent.substring(0, this.mDrawSubtitleLen - 1) + END_TEXT;
        goto L41
    L43:
        return;
    L18:
        r6 = 0.0f;
        goto L20
    L14:
        r3 = Math.min(this.mSubtitleSize, this.mMaxSubtitleSize);
        goto L15
    L10:
        r1 = Math.min(this.mTitleSize, this.mMaxTitleSizeWithSubtitle);
        goto L11
    L5:
        if (TextUtils.isEmpty(this.mSubContent) == false) goto L7;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setClassName(WheelTextView.class.getName());
        event.setScrollable(true);
        event.setScrollY(this.mValue * this.mSelectorElementHeight);
    }

    private void initializeSelectorWheelIndices() {
        if (isSupportRotate() == true) goto L5;
        return;
    L5:
        this.mSelectorIndices = new int[this.mDisplayedValues.length];
        int r0 = getValue();
        int r1 = 0;
    L6:
        int[] r2 = this.mSelectorIndices;
        if (r1 >= r2.length) goto L9;
        r2[r1] = (r1 - (this.mDisplayedValues.length / 2)) + r0;
        r1 = r1 + 1;
        goto L6
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        super.onPopulateAccessibilityEvent(event);
        String[] r0 = this.mDisplayedValues;
        if (r0 == null) goto L10;
        if (r0.length <= 0) goto L10;
        if (r0.length <= this.mValue) goto L10;
        event.getText().add(this.mDisplayedValues[this.mValue]);
    L10:
        if (TextUtils.isEmpty(this.mSubContent) == true) goto L13;
        event.getText().add(this.mSubContent);
        return;
    }

    private void setValueInternal(int current, boolean notifyChange) {
        if (this.mValue != current) goto L5;
        return;
    L5:
        if (current >= 0) goto L7;
        current = Math.abs(current + this.mDisplayedValues.length);
    L7:
        int r2 = current % this.mDisplayedValues.length;
        int r0 = this.mValue;
        this.mValue = r2;
        if (notifyChange == false) goto L10;
        notifyChange(r0, r2);
    L10:
        initializeSelectorWheelIndices();
        sendAccessibilityEvent(16);
        sendAccessibilityEvent(32768);
        invalidate();
    }

    private void initializeSelectorWheel() {
        if (isSupportRotate() == true) goto L5;
        return;
    L5:
        initializeSelectorWheelIndices();
        getTitleHeight(this.mDisplayedValues[0]);
        Paint.FontMetricsInt r0 = this.mPaint.getFontMetricsInt();
        float r1 = (getMeasuredHeight() - (r0.bottom + r0.top)) / 2;
        int r2 = getMeasuredHeight();
        this.mSelectorElementHeight = r2;
        int r3 = ((int) r1) - (r2 * (this.mDisplayedValues.length / 2));
        this.mInitialScrollOffset = r3;
        this.mCurrentScrollOffset = r3;
    }

    private void incrementSelectorIndices(int[] selectorIndices) {
        int r1 = 0;
    L4:
        if (r1 >= (selectorIndices.length - 1)) goto L6;
        selectorIndices[r1] = selectorIndices[r1] + 1;
        r1 = r1 + 1;
        goto L4
    }

    private void decrementSelectorIndices(int[] selectorIndices) {
        int r1 = selectorIndices.length - 1;
    L3:
        if (r1 <= 0) goto L5;
        selectorIndices[r1] = selectorIndices[r1] - 1;
        r1 = r1 - 1;
        goto L3
    }

    private void notifyChange(int previous, int current) {
        OnValueChangeListener r3 = this.mOnValueChangeListener;
        if (r3 == null) goto L6;
        r3.onValueChange(this, previous, this.mValue);
        return;
    }

    private boolean ensureScrollWheelAdjusted() {
        int r0 = this.mInitialScrollOffset;
        int r3 = this.mCurrentScrollOffset;
        int r5 = r0 - r3;
        if (r5 == 0) goto L6;
        this.mPreviousScrollerY = Integer.MAX_VALUE;
        this.mAdjustScroller.startScroll(0, r3, 0, r5, 150);
        invalidate();
        return true;
    L6:
        return false;
    }

    public void setTextSize(float normalSize) {
        if (normalSize < 0.0f) goto L9;
        if (this.mTitleSize == normalSize) goto L10;
        this.mTitleSize = normalSize;
        this.mPaint.setTextSize(normalSize);
        invalidate();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("the text size mus be >= 0 ");
    }

    public void setTextMaxSize(float maxSize) {
        this.mMaxTitleSize = maxSize;
    }

    public void setTextColor(int normalColor) {
        if (this.mTextColor == normalColor) goto L6;
        this.mTextColor = normalColor;
        this.mPaint.setColor(normalColor);
        invalidate();
        return;
    }

    public void setIsNeedRotate(boolean isNeedRotate) {
        this.mIsNeedRotate = isNeedRotate;
    }

    private int getAvaliableDrawTitleLen(String title, int maxWidth) {
        int r0 = (int) getTitleWidth(END_TEXT);
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r1 >= title.length()) goto L8;
        r2 = (int) (r2 + getTitleWidth(title.charAt(r1) + ""));
        if ((r2 + r0) > maxWidth) goto L8;
        r3 = r1 + 1;
        r1 = r3;
    L8:
        return r3;
    }

    private int handleTextByWidth() {
        String[] r0 = this.mDisplayedValues;
        if (r0 != null) goto L5;
    L7:
        String r1 = null;
    L8:
        float r2 = getTitleWidth(r1);
        float r3 = getSubtitleWidth(this.mSubContent);
        int r4 = this.mMaxAvailableWidth;
        if (r4 > 0) goto L11;
    L13:
        if (r1 == null) goto L15;
        this.mDrawTitleLen = r1.length();
    L15:
        int r5 = (int) r2;
    L16:
        int r6 = this.mMaxAvailableWidth;
        if (r6 <= 0) goto L24;
        if (r3 <= 0.0f) goto L24;
        if (r3 < r6) goto L24;
        this.mDrawSubtitleLen = getAvaliableDrawTitleLen(this.mSubContent, r6);
        int r7 = this.mMaxAvailableWidth;
    L28:
        return Math.max(r5, r7);
    L24:
        if (r3 <= 0.0f) goto L26;
        this.mDrawSubtitleLen = this.mSubContent.length();
    L26:
        r7 = (int) r3;
        goto L28
    L11:
        if (r2 < r4) goto L13;
        this.mDrawTitleLen = getAvaliableDrawTitleLen(r1, r4);
        r5 = this.mMaxAvailableWidth;
        goto L16
    L5:
        if (r0.length <= 0) goto L7;
        r1 = r0[getDisPlayMaxIndex()];
        goto L8
    }

    private float getSubtitleWidth(String text) {
        if (TextUtils.isEmpty(text) == false) goto L7;
        return 0.0f;
    L7:
        if (TextUtils.isEmpty(this.mSubContent) == true) goto L9;
        this.mSubPaint.setTextSize(Math.min(this.mMaxSubtitleSize, this.mSubtitleSize));
    L11:
        return this.mSubPaint.measureText(text);
    L9:
        this.mSubPaint.setTextSize(this.mSubtitleSize);
        goto L11
    }

    private float getTitleWidth(String text) {
        if (TextUtils.isEmpty(text) == false) goto L7;
        return 0.0f;
    L7:
        if (TextUtils.isEmpty(this.mSubContent) == true) goto L9;
        this.mPaint.setTextSize(Math.min(this.mMaxTitleSizeWithSubtitle, this.mTitleSize));
    L11:
        return this.mPaint.measureText(text);
    L9:
        this.mPaint.setTextSize(this.mTitleSize);
        goto L11
    }

    private int getTitleHeight(String text) {
        Rect r0 = new Rect();
        if (text == null) goto L6;
        this.mPaint.getTextBounds(text, 0, text.length(), r0);
    L6:
        return r0.height();
    }

    private boolean isSupportRotate() {
        if (this.mIsNeedRotate == false) goto L10;
        String[] r1 = this.mDisplayedValues;
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.length <= 0) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    private int getDisPlayMaxIndex() {
        String[] r0 = this.mDisplayedValues;
        int r1 = 0;
        if (r0 != null) goto L5;
    L15:
        return 0;
    L5:
        if (r0.length == 0) goto L15;
        float r2 = 0.0f;
        int r3 = 0;
    L8:
        String[] r4 = this.mDisplayedValues;
        if (r1 >= r4.length) goto L14;
        float r5 = getTitleWidth(r4[r1]);
        if (r5 <= r2) goto L13;
        r3 = r1;
        r2 = r5;
    L13:
        r1 = r1 + 1;
        goto L8
    L14:
        return r3;
    }
}
