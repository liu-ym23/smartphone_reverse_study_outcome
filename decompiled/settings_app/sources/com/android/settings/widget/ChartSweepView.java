package com.android.settings.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.MathUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.android.internal.util.Preconditions;
import com.android.settings.R;

/* JADX INFO: loaded from: classes.dex */
public class ChartSweepView extends View {
    private static final boolean DRAW_OUTLINE = false;
    public static final int HORIZONTAL = 0;
    private static final int LARGE_WIDTH = 1024;
    private static final int MODE_DRAG = 1;
    private static final int MODE_LABEL = 2;
    private static final int MODE_NONE = 0;
    public static final int VERTICAL = 1;
    private ChartAxis mAxis;
    private View.OnClickListener mClickListener;
    private Rect mContentOffset;
    private long mDragInterval;
    private int mFollowAxis;
    private int mLabelColor;
    private DynamicLayout mLabelLayout;
    private int mLabelMinSize;
    private float mLabelOffset;
    private float mLabelSize;
    private SpannableStringBuilder mLabelTemplate;
    private int mLabelTemplateRes;
    private long mLabelValue;
    private OnSweepListener mListener;
    private Rect mMargins;
    private float mNeighborMargin;
    private ChartSweepView[] mNeighbors;
    private Paint mOutlinePaint;
    private int mSafeRegion;
    private Drawable mSweep;
    private Point mSweepOffset;
    private Rect mSweepPadding;
    private int mTouchMode;
    private MotionEvent mTracking;
    private float mTrackingStart;
    private long mValidAfter;
    private ChartSweepView mValidAfterDynamic;
    private long mValidBefore;
    private ChartSweepView mValidBeforeDynamic;
    private long mValue;

    public interface OnSweepListener {
        void onSweep(ChartSweepView r1, boolean r2);

        void requestEdit(ChartSweepView r1);
    }

    @Override // android.view.View
    public void addOnLayoutChangeListener(View.OnLayoutChangeListener r1) {
    }

    @Override // android.view.View
    public void removeOnLayoutChangeListener(View.OnLayoutChangeListener r1) {
    }

    static /* synthetic */ void access$000(ChartSweepView r0) {
        r0.dispatchRequestEdit();
    }

    public ChartSweepView(Context r2) {
        this(r2, null);
    }

    public ChartSweepView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ChartSweepView(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        this.mSweepPadding = new Rect();
        this.mContentOffset = new Rect();
        this.mSweepOffset = new Point();
        this.mMargins = new Rect();
        this.mOutlinePaint = new Paint();
        this.mTouchMode = 0;
        this.mDragInterval = 1;
        this.mNeighbors = new ChartSweepView[0];
        this.mClickListener = new AnonymousClass1(this);
        TypedArray r7 = r4.obtainStyledAttributes(r5, R.styleable.ChartSweepView, r6, 0);
        int r8 = r7.getColor(1, -16776961);
        setSweepDrawable(r7.getDrawable(6), r8);
        setFollowAxis(r7.getInt(0, -1));
        setNeighborMargin(r7.getDimensionPixelSize(4, 0));
        setSafeRegion(r7.getDimensionPixelSize(5, 0));
        setLabelMinSize(r7.getDimensionPixelSize(2, 0));
        setLabelTemplate(r7.getResourceId(3, 0));
        setLabelColor(r8);
        this.mOutlinePaint.setColor(SupportMenu.CATEGORY_MASK);
        this.mOutlinePaint.setStrokeWidth(1.0f);
        this.mOutlinePaint.setStyle(Paint.Style.STROKE);
        r7.recycle();
        setClickable(true);
        setOnClickListener(this.mClickListener);
        setWillNotDraw(false);
    }

    void init(ChartAxis r2) {
        this.mAxis = (ChartAxis) Preconditions.checkNotNull(r2, "missing axis");
    }

    public void setNeighbors(ChartSweepView... r1) {
        this.mNeighbors = r1;
    }

    public int getFollowAxis() {
        return this.mFollowAxis;
    }

    public Rect getMargins() {
        return this.mMargins;
    }

    public void setDragInterval(long r1) {
        this.mDragInterval = r1;
    }

    private float getTargetInset() {
        if (this.mFollowAxis != 1) goto L7;
        float r1 = this.mSweepPadding.top + (((this.mSweep.getIntrinsicHeight() - this.mSweepPadding.top) - this.mSweepPadding.bottom) / 2.0f);
        int r3 = this.mSweepOffset.y;
    L6:
        return r1 + r3;
    L7:
        r1 = this.mSweepPadding.left + (((this.mSweep.getIntrinsicWidth() - this.mSweepPadding.left) - this.mSweepPadding.right) / 2.0f);
        r3 = this.mSweepOffset.x;
        goto L6
    }

    public void addOnSweepListener(OnSweepListener r1) {
        this.mListener = r1;
    }

    private void dispatchOnSweep(boolean r2) {
        OnSweepListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onSweep(this, r2);
        return;
    }

    private void dispatchRequestEdit() {
        OnSweepListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.requestEdit(this);
        return;
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        setFocusable(r1);
        requestLayout();
    }

    public void setSweepDrawable(Drawable r3, int r4) {
        Drawable r0 = this.mSweep;
        if (r0 == null) goto L5;
        r0.setCallback(null);
        unscheduleDrawable(this.mSweep);
    L5:
        if (r3 == null) goto L14;
        r3.setCallback(this);
        if (r3.isStateful() == false) goto L10;
        r3.setState(getDrawableState());
    L10:
        if (getVisibility() != 0) goto L12;
        boolean r1 = true;
    L13:
        r3.setVisible(r1, false);
        this.mSweep = r3;
        r3.setTint(r4);
        r3.getPadding(this.mSweepPadding);
    L15:
        invalidate();
        return;
    L12:
        r1 = false;
        goto L13
    L14:
        this.mSweep = null;
        goto L15
    }

    public void setFollowAxis(int r1) {
        this.mFollowAxis = r1;
    }

    public void setLabelMinSize(int r1) {
        this.mLabelMinSize = r1;
        invalidateLabelTemplate();
    }

    public void setLabelTemplate(int r1) {
        this.mLabelTemplateRes = r1;
        invalidateLabelTemplate();
    }

    public void setLabelColor(int r1) {
        this.mLabelColor = r1;
        invalidateLabelTemplate();
    }

    private void invalidateLabelTemplate() {
        if (this.mLabelTemplateRes == 0) goto L5;
        CharSequence r0 = getResources().getText(this.mLabelTemplateRes);
        TextPaint r3 = new TextPaint(1);
        r3.density = getResources().getDisplayMetrics().density;
        r3.setCompatibilityScaling(getResources().getCompatibilityInfo().applicationScale);
        r3.setColor(this.mLabelColor);
        this.mLabelTemplate = new SpannableStringBuilder(r0);
        this.mLabelLayout = new DynamicLayout(this.mLabelTemplate, r3, 1024, Layout.Alignment.ALIGN_RIGHT, 1.0f, 0.0f, false);
        invalidateLabel();
    L6:
        invalidate();
        requestLayout();
        return;
    L5:
        this.mLabelTemplate = null;
        this.mLabelLayout = null;
        goto L6
    }

    private void invalidateLabel() {
        if (this.mLabelTemplate == null) goto L7;
        ChartAxis r0 = this.mAxis;
        if (r0 == null) goto L7;
        this.mLabelValue = r0.buildLabel(getResources(), this.mLabelTemplate, this.mValue);
        setContentDescription(this.mLabelTemplate);
        invalidateLabelOffset();
        invalidate();
        return;
    L7:
        this.mLabelValue = this.mValue;
    }

    public void invalidateLabelOffset() {
        float r2 = 0.0f;
        if (this.mFollowAxis == 1) goto L5;
    L15:
        this.mLabelSize = Math.max(this.mLabelSize, this.mLabelMinSize);
        if (r2 == this.mLabelOffset) goto L24;
        this.mLabelOffset = r2;
        invalidate();
        ChartSweepView r0 = this.mValidAfterDynamic;
        if (r0 == null) goto L20;
        r0.invalidateLabelOffset();
    L20:
        ChartSweepView r4 = this.mValidBeforeDynamic;
        if (r4 == null) goto L25;
        r4.invalidateLabelOffset();
        return;
    L25:
        return;
    L24:
        return;
    L5:
        if (this.mValidAfterDynamic == null) goto L10;
        this.mLabelSize = Math.max(getLabelWidth(this), getLabelWidth(this.mValidAfterDynamic));
        float r1 = getLabelTop(this.mValidAfterDynamic) - getLabelBottom(this);
        if (r1 >= 0.0f) goto L15;
    L8:
        r2 = r1 / 2.0f;
        goto L15
    L10:
        if (this.mValidBeforeDynamic == null) goto L14;
        this.mLabelSize = Math.max(getLabelWidth(this), getLabelWidth(this.mValidBeforeDynamic));
        float r3 = getLabelTop(this) - getLabelBottom(this.mValidBeforeDynamic);
        if (r3 >= 0.0f) goto L15;
        r1 = -r3;
        goto L8
    L14:
        this.mLabelSize = getLabelWidth(this);
        goto L15
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r0 = this.mSweep;
        if (r0 == null) goto L6;
        r0.jumpToCurrentState();
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r2) {
        super.setVisibility(r2);
        Drawable r1 = this.mSweep;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r2 != 0) goto L7;
        boolean r3 = true;
    L8:
        r1.setVisible(r3, false);
        return;
    L7:
        r3 = false;
        goto L8
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable r2) {
        if (r2 != this.mSweep) goto L5;
    L8:
        return true;
    L5:
        if (super.verifyDrawable(r2) == true) goto L8;
        return false;
    }

    public ChartAxis getAxis() {
        return this.mAxis;
    }

    public void setValue(long r1) {
        this.mValue = r1;
        invalidateLabel();
    }

    public long getValue() {
        return this.mValue;
    }

    public long getLabelValue() {
        return this.mLabelValue;
    }

    public float getPoint() {
        if (isEnabled() == true) goto L5;
        return 0.0f;
    L5:
        return this.mAxis.convertToPoint(this.mValue);
    }

    public void setValidRange(long r1, long r3) {
        this.mValidAfter = r1;
        this.mValidBefore = r3;
    }

    public void setNeighborMargin(float r1) {
        this.mNeighborMargin = r1;
    }

    public void setSafeRegion(int r1) {
        this.mSafeRegion = r1;
    }

    public void setValidRangeDynamic(ChartSweepView r1, ChartSweepView r2) {
        this.mValidAfterDynamic = r1;
        this.mValidBeforeDynamic = r2;
    }

    public boolean isTouchCloserTo(MotionEvent r1, ChartSweepView r2) {
        float r0 = getTouchDistanceFromTarget(r1);
        if (r2.getTouchDistanceFromTarget(r1) >= r0) goto L5;
        return true;
    L5:
        return false;
    }

    private float getTouchDistanceFromTarget(MotionEvent r2) {
        if (this.mFollowAxis != 0) goto L7;
        return Math.abs(r2.getX() - (getX() + getTargetInset()));
    L7:
        return Math.abs(r2.getY() - (getY() + getTargetInset()));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r12) {
        if (isEnabled() == true) goto L5;
        return false;
    L5:
        View r0 = (View) getParent();
        int r2 = r12.getAction();
        if (r2 == 0) goto L30;
        if (r2 == 1) goto L22;
        if (r2 == 2) goto L11;
        return false;
    L11:
        if (this.mTouchMode != 2) goto L13;
        return true;
    L13:
        getParent().requestDisallowInterceptTouchEvent(true);
        Rect r1 = getParentContentRect();
        Rect r3 = computeClampRect(r1);
        if (r3.isEmpty() == false) goto L17;
        return true;
    L17:
        if (this.mFollowAxis != 1) goto L19;
        float r4 = getTop() - this.mMargins.top;
        float r13 = MathUtils.constrain(this.mTrackingStart + (r12.getRawY() - this.mTracking.getRawY()), r3.top, r3.bottom);
        setTranslationY(r13 - r4);
        long r5 = this.mAxis.convertToValue(r13 - r1.top);
    L20:
        setValue(r5 - (r5 % this.mDragInterval));
        dispatchOnSweep(false);
        return true;
    L19:
        float r6 = getLeft() - this.mMargins.left;
        float r14 = MathUtils.constrain(this.mTrackingStart + (r12.getRawX() - this.mTracking.getRawX()), r3.left, r3.right);
        setTranslationX(r14 - r6);
        r5 = this.mAxis.convertToValue(r14 - r1.left);
        goto L20
    L22:
        int r15 = this.mTouchMode;
        if (r15 != 2) goto L25;
        performClick();
    L27:
        this.mTouchMode = 0;
        return true;
    L25:
        if (r15 != 1) goto L27;
        this.mTrackingStart = 0.0f;
        this.mTracking = null;
        this.mValue = this.mLabelValue;
        dispatchOnSweep(true);
        setTranslationX(0.0f);
        setTranslationY(0.0f);
        requestLayout();
        goto L27
    L30:
        if (this.mFollowAxis != 1) goto L42;
        if (r12.getX() <= (getWidth() - (this.mSweepPadding.right * 8))) goto L34;
        boolean r7 = true;
    L36:
        if (this.mLabelLayout != null) goto L38;
    L40:
        boolean r8 = false;
    L50:
        MotionEvent r9 = r12.copy();
        r9.offsetLocation(getLeft(), getTop());
        ChartSweepView[] r10 = this.mNeighbors;
        int r11 = r10.length;
        int r16 = 0;
    L51:
        if (r16 >= r11) goto L57;
        if (isTouchCloserTo(r9, r10[r16]) == true) goto L54;
        r16 = r16 + 1;
        goto L51
    L54:
        r9.recycle();
        return false;
    L57:
        r9.recycle();
        if (r7 == true) goto L60;
        if (r8 == false) goto L70;
        this.mTouchMode = 2;
        return true;
    L70:
        this.mTouchMode = 0;
        return false;
    L60:
        if (this.mFollowAxis != 1) goto L62;
        this.mTrackingStart = getTop() - this.mMargins.top;
    L63:
        this.mTracking = r12.copy();
        this.mTouchMode = 1;
        if (r0.isActivated() == true) goto L66;
        r0.setActivated(true);
    L66:
        return true;
    L62:
        this.mTrackingStart = getLeft() - this.mMargins.left;
        goto L63
    L38:
        if (r12.getX() >= this.mLabelLayout.getWidth()) goto L40;
    L39:
        r8 = true;
        goto L50
    L34:
        r7 = false;
        goto L36
    L42:
        if (r12.getY() <= (getHeight() - (this.mSweepPadding.bottom * 8))) goto L44;
        r7 = true;
    L46:
        if (this.mLabelLayout == null) goto L40;
        if (r12.getY() >= this.mLabelLayout.getHeight()) goto L40;
    L44:
        r7 = false;
        goto L46
    }

    public void updateValueFromPosition() {
        Rect r0 = getParentContentRect();
        if (this.mFollowAxis != 1) goto L5;
        setValue(this.mAxis.convertToValue((getY() - this.mMargins.top) - r0.top));
        return;
    L5:
        setValue(this.mAxis.convertToValue((getX() - this.mMargins.left) - r0.left));
    }

    public int shouldAdjustAxis() {
        return this.mAxis.shouldAdjustAxis(getValue());
    }

    private Rect getParentContentRect() {
        View r5 = (View) getParent();
        return new Rect(r5.getPaddingLeft(), r5.getPaddingTop(), r5.getWidth() - r5.getPaddingRight(), r5.getHeight() - r5.getPaddingBottom());
    }

    private long getValidAfterDynamic() {
        ChartSweepView r2 = this.mValidAfterDynamic;
        if (r2 != null) goto L5;
    L7:
        return Long.MIN_VALUE;
    L5:
        if (r2.isEnabled() == false) goto L7;
        return r2.getValue();
    }

    private long getValidBeforeDynamic() {
        ChartSweepView r2 = this.mValidBeforeDynamic;
        if (r2 != null) goto L5;
    L7:
        return Long.MAX_VALUE;
    L5:
        if (r2.isEnabled() == false) goto L7;
        return r2.getValue();
    }

    private Rect computeClampRect(Rect r9) {
        Rect r0 = buildClampRect(r9, this.mValidAfter, this.mValidBefore, 0.0f);
        if (r0.intersect(buildClampRect(r9, getValidAfterDynamic(), getValidBeforeDynamic(), this.mNeighborMargin)) == true) goto L5;
        r0.setEmpty();
    L5:
        return r0;
    }

    private Rect buildClampRect(Rect r14, long r15, long r17, float r19) {
        ChartAxis r1 = this.mAxis;
        if ((r1 instanceof InvertedChartAxis) == false) goto L5;
        long r4 = r15;
        long r2 = r17;
    L6:
        boolean r11 = false;
        if (r2 != Long.MIN_VALUE) goto L9;
    L11:
        boolean r8 = false;
    L13:
        if (r4 != Long.MIN_VALUE) goto L15;
    L17:
        float r3 = r1.convertToPoint(r2) + r19;
        float r5 = this.mAxis.convertToPoint(r4) - r19;
        Rect r6 = new Rect(r14);
        if (this.mFollowAxis != 1) goto L23;
        if (r11 == false) goto L21;
        r6.bottom = r6.top + ((int) r5);
    L21:
        if (r8 == false) goto L27;
        r6.top = (int) (r6.top + r3);
    L27:
        return r6;
    L23:
        if (r11 == false) goto L25;
        r6.right = r6.left + ((int) r5);
    L25:
        if (r8 == false) goto L27;
        r6.left = (int) (r6.left + r3);
        goto L27
    L15:
        if (r4 == Long.MAX_VALUE) goto L17;
        r11 = true;
        goto L17
    L9:
        if (r2 == Long.MAX_VALUE) goto L11;
        r8 = true;
        goto L13
    L5:
        r2 = r15;
        r4 = r17;
        goto L6
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mSweep.isStateful() == false) goto L6;
        this.mSweep.setState(getDrawableState());
        return;
    }

    @Override // android.view.View
    protected void onMeasure(int r5, int r6) {
        if (isEnabled() == true) goto L5;
    L7:
        this.mSweepOffset.x = 0;
        this.mSweepOffset.y = 0;
        setMeasuredDimension(this.mSweep.getIntrinsicWidth(), this.mSweep.getIntrinsicHeight());
    L9:
        if (this.mFollowAxis != 1) goto L11;
        int r7 = (this.mSweep.getIntrinsicHeight() - this.mSweepPadding.top) - this.mSweepPadding.bottom;
        this.mMargins.top = -(this.mSweepPadding.top + (r7 / 2));
        this.mMargins.bottom = 0;
        this.mMargins.left = -this.mSweepPadding.left;
        this.mMargins.right = this.mSweepPadding.right;
    L12:
        this.mContentOffset.set(0, 0, 0, 0);
        int r8 = getMeasuredWidth();
        int r0 = getMeasuredHeight();
        if (this.mFollowAxis != 0) goto L15;
        int r9 = r8 * 3;
        setMeasuredDimension(r9, r0);
        this.mContentOffset.left = (r9 - r8) / 2;
        int r10 = this.mSweepPadding.bottom * 2;
        this.mContentOffset.bottom -= r10;
        this.mMargins.bottom += r10;
    L16:
        this.mSweepOffset.offset(this.mContentOffset.left, this.mContentOffset.top);
        this.mMargins.offset(-this.mSweepOffset.x, -this.mSweepOffset.y);
        return;
    L15:
        int r1 = r0 * 2;
        setMeasuredDimension(r8, r1);
        this.mContentOffset.offset(0, (r1 - r0) / 2);
        int r11 = this.mSweepPadding.right * 2;
        this.mContentOffset.right -= r11;
        this.mMargins.right += r11;
        goto L16
    L11:
        int r12 = (this.mSweep.getIntrinsicWidth() - this.mSweepPadding.left) - this.mSweepPadding.right;
        this.mMargins.left = -(this.mSweepPadding.left + (r12 / 2));
        this.mMargins.right = 0;
        this.mMargins.top = -this.mSweepPadding.top;
        this.mMargins.bottom = this.mSweepPadding.bottom;
        goto L12
    L5:
        if (this.mLabelLayout == null) goto L7;
        int r13 = this.mSweep.getIntrinsicHeight();
        int r2 = this.mLabelLayout.getHeight();
        this.mSweepOffset.x = 0;
        this.mSweepOffset.y = 0;
        this.mSweepOffset.y = (int) ((r2 / 2) - getTargetInset());
        setMeasuredDimension(this.mSweep.getIntrinsicWidth(), Math.max(r13, r2));
        goto L9
    }

    @Override // android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        invalidateLabelOffset();
    }

    @Override // android.view.View
    protected void onDraw(Canvas r7) {
        super.onDraw(r7);
        int r0 = getWidth();
        int r1 = getHeight();
        if (isEnabled() == true) goto L5;
    L7:
        int r2 = 0;
    L9:
        if (this.mFollowAxis != 1) goto L11;
        this.mSweep.setBounds(r2, this.mSweepOffset.y, r0 + this.mContentOffset.right, this.mSweepOffset.y + this.mSweep.getIntrinsicHeight());
    L12:
        this.mSweep.draw(r7);
        return;
    L11:
        this.mSweep.setBounds(this.mSweepOffset.x, r2, this.mSweepOffset.x + this.mSweep.getIntrinsicWidth(), r1 + this.mContentOffset.bottom);
        goto L12
    L5:
        if (this.mLabelLayout == null) goto L7;
        int r3 = r7.save();
        r7.translate(this.mContentOffset.left + (this.mLabelSize - 1024.0f), this.mContentOffset.top + this.mLabelOffset);
        this.mLabelLayout.draw(r7);
        r7.restoreToCount(r3);
        r2 = ((int) this.mLabelSize) + this.mSafeRegion;
        goto L9
    }

    public static float getLabelTop(ChartSweepView r1) {
        return r1.getY() + r1.mContentOffset.top;
    }

    public static float getLabelBottom(ChartSweepView r1) {
        return getLabelTop(r1) + r1.mLabelLayout.getHeight();
    }

    public static float getLabelWidth(ChartSweepView r1) {
        return Layout.getDesiredWidth(r1.mLabelLayout.getText(), r1.mLabelLayout.getPaint());
    }
}
