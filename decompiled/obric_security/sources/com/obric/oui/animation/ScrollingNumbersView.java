package com.obric.oui.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.bytedanceos.rotateview.ColorAnimateHelper;
import com.bytedanceos.security.Utils;
import com.bytedanceos.security.widget.DefaultAnimatorListener;
import com.obric.security.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ScrollingNumbersView extends View implements ValueAnimator.AnimatorUpdateListener, ColorAnimateHelper.ColorUpdateListener {
    public static final int ALIGNMENT_CENTER = 0;
    public static final int ALIGNMENT_LEFT = 1;
    public static final int ALIGNMENT_RIGHT = 2;
    public static final float DEFAULT_LINE_SPACING_MULTIPLIER = 1.5f;
    public static final float DEFAULT_SINGLE_NUMBER_WIDTH_MULTIPLIER = 1.2f;
    public static final float DEFAULT_SUB_TEXT_SIZE = 36.0f;
    public static final float DEFAULT_TEXT_SIZE = 105.0f;
    public static final int NO_ADJUST_SUBTEXT = Integer.MAX_VALUE;
    private boolean isLanguageZH;
    private final int[] mAdjacentNumbers;
    private int mAdjacentValue;
    private int mAdjustSubTextThreshold;
    private int mAlignment;
    private boolean mAnimatorCanceled;
    private final AnimatorSet mAnimatorSet;
    private final ArrayList<Animator> mAnimators;
    private final int[] mCurrentNumbers;
    private int mCurrentPauseIndex;
    private int mCurrentValue;
    private final Rect mDrawingArea;
    private boolean mFinishDispatched;
    private volatile boolean mIsPause;
    private float mLineSpacingMult;
    private final int mMaxDigits;
    private volatile boolean mNeedPause;
    private final ArrayList<ScrollingNumber> mNumbers;
    private final Paint mPaint;
    private List<Integer> mPauseNumbers;
    private ScrollNumberListener mScrollNumberListener;
    private boolean mShowSubTextByLanguage;
    private int mShowingCount;
    private float mSingleNumberWidthMult;
    private int[] mSourceData;
    private final Point mSubLocation;
    private String mSubText;
    private float mSubTextSize;
    private final Point mSubWidthHeight;
    private final Point mTextWidthHeight;

    public interface ScrollNumberListener {
        void onFinish();

        void onPause();

        void onResume();
    }

    private class ScrollingNumber extends DefaultAnimatorListener implements ValueAnimator.AnimatorUpdateListener {
        private boolean mCanShowZero;
        private final int mDigit;
        private int mLastAnimatedValue;
        private int mLineSpacing;
        private int mLocationX;
        private int mLocationY;
        private int mNextNumber;
        private boolean mNotifyAdjacentNumberStartShowing;
        private int mNumber;
        private final int mPower;
        private int mPreNumber;
        private int mScrollYAccumulation;
        private int mScrollingY;
        private final ValueAnimator mValueAnimator;
        final /* synthetic */ ScrollingNumbersView this$0;

        @Override // com.bytedanceos.security.widget.DefaultAnimatorListener, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // com.bytedanceos.security.widget.DefaultAnimatorListener, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
        }

        @Override // com.bytedanceos.security.widget.DefaultAnimatorListener, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        public ScrollingNumber(final ScrollingNumbersView this$0, int digit) {
            this.this$0 = this$0;
            this.mDigit = digit;
            this.mPower = (int) Math.pow(10.0d, digit);
            ValueAnimator r3 = new ValueAnimator();
            this.mValueAnimator = r3;
            r3.setInterpolator(new AccelerateDecelerateInterpolator());
            r3.addUpdateListener(this);
            r3.addListener(this);
        }

        public int getDigit() {
            return this.mDigit;
        }

        private void setNumber(int number) {
            this.this$0.onNumberChanged(this, this.mNextNumber, number);
            this.mNotifyAdjacentNumberStartShowing = true;
            this.mNumber = number;
            this.mPreNumber = (number + 9) % 10;
            this.mNextNumber = (number + 1) % 10;
        }

        public void setNumberWithValue(int value) {
            setNumber((value / this.mPower) % 10);
        }

        private boolean isVisible(int number) {
            if (number != this.mPreNumber) goto L10;
            if ((this.mScrollingY - this.mLineSpacing) <= 0) goto L8;
            return true;
        L8:
            return false;
        L10:
            if (number != this.mNumber) goto L19;
            int r4 = this.mScrollingY;
            if (r4 <= 0) goto L14;
            return true;
        L14:
            if ((r4 - ScrollingNumbersView.access$200(this.this$0).y) >= ScrollingNumbersView.access$300(this.this$0).height()) goto L17;
            return true;
        L17:
            return false;
        L19:
            if (number == this.mNextNumber) goto L21;
            return false;
        L21:
            if (((this.mScrollingY + this.mLineSpacing) - ScrollingNumbersView.access$200(this.this$0).y) >= ScrollingNumbersView.access$300(this.this$0).height()) goto L24;
            return true;
        L24:
            return false;
        }

        public void setLocation(int newX, int newY) {
            this.mLocationX = newX;
            int r1 = newY - this.mLocationY;
            this.mLocationY = newY;
            this.mScrollingY += r1;
            this.mLineSpacing = (int) (ScrollingNumbersView.access$200(this.this$0).y * ScrollingNumbersView.access$400(this.this$0));
        }

        private void scrollYBy(int offsetY) {
            if (offsetY != 0) goto L4;
            return;
        L4:
            this.mScrollingY += offsetY;
            int r0 = this.mScrollYAccumulation + offsetY;
            this.mScrollYAccumulation = r0;
            int r1 = r0 / this.mLineSpacing;
            if (r1 == 0) goto L11;
            int r2 = (this.mNumber - r1) % 10;
            if (r2 >= 0) goto L9;
            r2 = r2 + 10;
        L9:
            setNumber(r2);
            int r3 = this.mScrollingY;
            int r4 = this.mLineSpacing;
            this.mScrollingY = r3 - (r1 * r4);
            this.mScrollYAccumulation %= r4;
        L11:
            if (this.mNotifyAdjacentNumberStartShowing == false) goto L19;
            if (offsetY <= 0) goto L14;
            int r5 = this.mPreNumber;
        L16:
            if (isVisible(r5) == false) goto L20;
            this.this$0.onAdjacentNumberStartShowing(this, r5);
            this.mNotifyAdjacentNumberStartShowing = false;
            return;
        L20:
            return;
        L14:
            r5 = this.mNextNumber;
            goto L16
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            if (animation.getAnimatedValue() != null) goto L5;
            return;
        L5:
            int r2 = ((Integer) animation.getAnimatedValue()).intValue();
            scrollYBy(r2 - this.mLastAnimatedValue);
            this.mLastAnimatedValue = r2;
        }

        public void setCanShowZero(boolean canShowZero) {
            this.mCanShowZero = canShowZero;
        }

        public void drawOnCanvas(Canvas canvas, Paint paint) {
            int r0 = (int) (ScrollingNumbersView.access$200(this.this$0).y * ScrollingNumbersView.access$400(this.this$0));
            int r1 = this.mPreNumber;
            if (r1 != 0) goto L7;
            if (this.mCanShowZero == true) goto L7;
        L9:
            int r2 = this.mNumber;
            if (r2 != 0) goto L14;
            if (this.mCanShowZero == true) goto L14;
        L16:
            int r3 = this.mNextNumber;
            if (r3 != 0) goto L21;
            if (this.mCanShowZero == true) goto L21;
            return;
        L21:
            if (isVisible(r3) == false) goto L25;
            canvas.drawText("" + this.mNextNumber, this.mLocationX, this.mScrollingY + r0, paint);
            return;
        L25:
            return;
        L14:
            if (isVisible(r2) == false) goto L16;
            canvas.drawText("" + this.mNumber, this.mLocationX, this.mScrollingY, paint);
        L7:
            if (isVisible(r1) == false) goto L9;
            canvas.drawText("" + this.mPreNumber, this.mLocationX, this.mScrollingY - r0, paint);
            goto L9
        }

        public ValueAnimator getValueAnimator() {
            return this.mValueAnimator;
        }

        public void setAnimatorValues(int currentValue, int... targetValues) {
            int r0 = (int) (ScrollingNumbersView.access$200(this.this$0).y * ScrollingNumbersView.access$400(this.this$0));
            int r2 = 1;
            int r1 = targetValues.length + 1;
            int[] r3 = new int[r1];
        L3:
            if (r2 >= r1) goto L5;
            int r4 = this.mPower;
            r3[r2] = ((currentValue / r4) - (targetValues[r2 - 1] / r4)) * r0;
            r2 = r2 + 1;
            goto L3
        L5:
            this.mValueAnimator.setIntValues(r3);
        }

        public void setAnimatorValues(int currentValue, Integer... targetValues) {
            int r0 = (int) (ScrollingNumbersView.access$200(this.this$0).y * ScrollingNumbersView.access$400(this.this$0));
            int r2 = 1;
            int r1 = targetValues.length + 1;
            int[] r3 = new int[r1];
        L3:
            if (r2 >= r1) goto L5;
            r3[r2] = ((currentValue / this.mPower) - (targetValues[r2 - 1].intValue() / this.mPower)) * r0;
            r2 = r2 + 1;
            goto L3
        L5:
            this.mValueAnimator.setIntValues(r3);
        }

        @Override // com.bytedanceos.security.widget.DefaultAnimatorListener, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            this.mScrollingY = this.mLocationY;
            this.mScrollYAccumulation = 0;
            this.mLastAnimatedValue = 0;
        }
    }

    @Override // com.bytedanceos.rotateview.ColorAnimateHelper.ColorUpdateListener
    public void onColorUpdateEnd() {
    }

    static /* synthetic */ boolean access$000(ScrollingNumbersView r0) {
        return r0.mAnimatorCanceled;
    }

    static /* synthetic */ boolean access$002(ScrollingNumbersView r0, boolean r1) {
        r0.mAnimatorCanceled = r1;
        return r1;
    }

    static /* synthetic */ void access$100(ScrollingNumbersView r0) {
        r0.dispatchFinishIfNeeded();
    }

    static /* synthetic */ Point access$200(ScrollingNumbersView r0) {
        return r0.mTextWidthHeight;
    }

    static /* synthetic */ Rect access$300(ScrollingNumbersView r0) {
        return r0.mDrawingArea;
    }

    static /* synthetic */ float access$400(ScrollingNumbersView r0) {
        return r0.mLineSpacingMult;
    }

    public ScrollingNumbersView(Context context) {
        this(context, null);
    }

    public ScrollingNumbersView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScrollingNumbersView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public ScrollingNumbersView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mAdjustSubTextThreshold = Integer.MAX_VALUE;
        this.mPaint = new Paint(1);
        this.mTextWidthHeight = new Point();
        this.mSubWidthHeight = new Point();
        this.mSubLocation = new Point();
        this.mDrawingArea = new Rect();
        this.mNumbers = new ArrayList();
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimators = new ArrayList();
        this.mCurrentPauseIndex = 0;
        this.mIsPause = false;
        this.mNeedPause = true;
        this.mShowSubTextByLanguage = false;
        this.mFinishDispatched = false;
        this.mAnimatorCanceled = false;
        TypedArray r12 = context.obtainStyledAttributes(attrs, R.styleable.ScrollingNumbersView, defStyleAttr, defStyleRes);
        this.mPauseNumbers = new ArrayList();
        int r13 = r12.getInt(4, 3);
        int r3 = r12.getInt(2, 0);
        int r4 = r12.getColor(8, getResources().getColor(R.color.oui_functional_green_6));
        float r5 = r12.getDimension(9, 105.0f);
        int r6 = r12.getInt(1, 0);
        float r14 = r12.getFloat(3, 1.5f);
        float r7 = r12.getFloat(5, 1.2f);
        float r8 = r12.getDimension(7, 36.0f);
        String r9 = r12.getString(6);
        int r0 = r12.getInt(0, Integer.MAX_VALUE);
        r12.recycle();
        this.isLanguageZH = Utils.isLanguageZH(context);
        this.mMaxDigits = r13;
        this.mCurrentNumbers = new int[r13];
        this.mAdjacentNumbers = new int[r13];
        int r11 = 0;
    L4:
        if (r11 >= this.mMaxDigits) goto L6;
        addScrollingNumber(new ScrollingNumber(this, r11), true);
        r11 = r11 + 1;
        goto L4
    L6:
        this.mAnimatorSet.addListener(new AnonymousClass1(this));
        setPaintColor(r4);
        this.mPaint.setTypeface(Typeface.create(null, 500, false));
        setPaintTextSize(r5);
        setAlignment(r6);
        setLineSpacingMultiplier(r14);
        setSingleNumberWidthMultiplier(r7);
        setSubTextSize(r8);
        setSubText(r9);
        setAdjustSubTextThresholdWhenCentered(r0);
        setInitialValue(r3);
    }

    private void dispatchFinishIfNeeded() {
        if (this.mFinishDispatched == true) goto L8;
        ScrollNumberListener r0 = this.mScrollNumberListener;
        if (r0 == null) goto L9;
        this.mFinishDispatched = true;
        r0.onFinish();
        return;
    L9:
        return;
    }

    public void addPauseNumber(int number) {
        this.mPauseNumbers.add(Integer.valueOf(number));
    }

    public void addPauseNumber(List<Integer> numbers) {
        this.mPauseNumbers.addAll(numbers);
    }

    public void setNeedPause(boolean needPause) {
        this.mNeedPause = needPause;
    }

    public void setShowSubTextByLanguage(boolean bylanguage) {
        this.mShowSubTextByLanguage = bylanguage;
    }

    private int getCurrentPauseNumber() {
        if (this.mPauseNumbers.isEmpty() == true) goto L11;
        int r0 = this.mCurrentPauseIndex;
        if (r0 >= 0) goto L7;
        return Integer.MAX_VALUE;
    L7:
        if (r0 < this.mPauseNumbers.size()) goto L10;
        return Integer.MAX_VALUE;
    L10:
        return this.mPauseNumbers.get(this.mCurrentPauseIndex).intValue();
    L11:
        return Integer.MAX_VALUE;
    }

    private void addScrollingNumber(ScrollingNumber sn, boolean toLeft) {
        if (toLeft == false) goto L4;
        this.mNumbers.add(0, sn);
    L5:
        ValueAnimator r2 = sn.getValueAnimator();
        r2.addUpdateListener(this);
        this.mAnimators.add(r2);
        this.mAnimatorSet.playTogether(this.mAnimators);
        return;
    L4:
        this.mNumbers.add(sn);
        goto L5
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int r0 = View.MeasureSpec.getMode(widthMeasureSpec);
        int r1 = View.MeasureSpec.getMode(heightMeasureSpec);
        int r8 = View.MeasureSpec.getSize(widthMeasureSpec);
        int r9 = View.MeasureSpec.getSize(heightMeasureSpec);
        int r2 = (int) ((this.mMaxDigits * this.mTextWidthHeight.x) * this.mSingleNumberWidthMult);
        int r3 = (int) this.mPaint.getTextSize();
        int r4 = (r3 - this.mTextWidthHeight.y) / 2;
        setPadding(getPaddingLeft(), r4, getPaddingRight(), r4);
        int r5 = ((getPaddingLeft() + r2) + this.mSubWidthHeight.x) + getPaddingRight();
        if (r0 != Integer.MIN_VALUE) goto L6;
        if (r1 != Integer.MIN_VALUE) goto L6;
    L10:
        r9 = r3;
    L11:
        r8 = r5;
    L12:
        setMeasuredDimension(r8, r9);
        return;
    L6:
        if (r0 == Integer.MIN_VALUE) goto L11;
        if (r1 != Integer.MIN_VALUE) goto L10;
        r9 = r3;
        goto L12
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        updateNumberLocation();
        this.mDrawingArea.set(0, 0, getWidth(), getHeight());
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAnimatorSet.cancel();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        int r0 = getHeight();
        int r1 = this.mPaint.getColor();
        float r8 = r0;
        float r3 = 0.65f - ((this.mTextWidthHeight.y * 0.65f) / r8);
        this.mPaint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, r8, new int[]{0, r1, r1, 0}, new float[]{0.0f, r3, 1.0f - r3, 1.0f}, Shader.TileMode.CLAMP));
        drawNumberOnCanvas(canvas, this.mPaint);
        this.mPaint.setShader(null);
        boolean r2 = this.mShowSubTextByLanguage;
        if (r2 == true) goto L5;
    L6:
        if (r2 == false) goto L8;
    L15:
        canvas.restore();
        return;
    L8:
        if (TextUtils.isEmpty(this.mSubText) == true) goto L15;
        float r4 = this.mPaint.getTextSize();
        this.mPaint.setTextSize(this.mSubTextSize);
        this.mPaint.setFakeBoldText(true);
        if (this.mSubText.equals("%") == false) goto L12;
    L14:
        canvas.drawText(this.mSubText, this.mSubLocation.x + 12, this.mSubLocation.y, this.mPaint);
        this.mPaint.setFakeBoldText(false);
        this.mPaint.setTextSize(r4);
        goto L15
    L12:
        if (this.isLanguageZH == true) goto L14;
        this.mPaint.setAlpha(0);
        goto L14
    L5:
        if (this.isLanguageZH == true) goto L8;
        goto L6
    }

    private void drawNumberOnCanvas(Canvas canvas, Paint paint) {
        Iterator<ScrollingNumber> r1 = this.mNumbers.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().drawOnCanvas(canvas, paint);
        goto L4
    }

    public void setPaintTextSize(float textSize) {
        this.mPaint.setTextSize(textSize);
        updateTextWidthHeight();
        updateSubWidthHeight();
    }

    private void updateTextWidthHeight() {
        Rect r0 = new Rect();
        this.mPaint.getTextBounds("0", 0, 1, r0);
        this.mTextWidthHeight.set(r0.width(), r0.height());
        updateNumberLocation();
    }

    public void setPaintColor(int color) {
        this.mPaint.setColor(color);
    }

    public void setPaintTypeface(Typeface tf) {
        this.mPaint.setTypeface(tf);
    }

    public void setAlignment(int alignment) {
        this.mAlignment = alignment;
        updateNumberLocation();
    }

    public void setLineSpacingMultiplier(float lineSpacingMult) {
        this.mLineSpacingMult = lineSpacingMult;
    }

    public void setSingleNumberWidthMultiplier(float singleNumberWidthMult) {
        this.mSingleNumberWidthMult = singleNumberWidthMult;
        updateNumberLocation();
    }

    public void setSubText(String text) {
        if (text != null) goto L4;
        String r1 = "";
    L5:
        this.mSubText = r1;
        updateSubWidthHeight();
        return;
    L4:
        r1 = text.trim();
        goto L5
    }

    public void setSubTextSize(float subTextSize) {
        this.mSubTextSize = subTextSize;
        updateSubWidthHeight();
    }

    private void updateSubWidthHeight() {
        if (this.mSubTextSize >= 0.001f) goto L6;
        this.mSubText = "";
    L6:
        if (TextUtils.isEmpty(this.mSubText) == false) goto L8;
        this.mSubWidthHeight.set(0, 0);
    L9:
        updateNumberLocation();
        return;
    L8:
        float r0 = this.mPaint.getTextSize();
        this.mPaint.setTextSize(this.mSubTextSize);
        Rect r2 = new Rect();
        this.mPaint.getTextBounds(this.mSubText, 0, 1, r2);
        this.mSubWidthHeight.set(r2.width(), r2.height());
        this.mPaint.setTextSize(r0);
        goto L9
    }

    public void setInitialValue(int initValue) {
        this.mCurrentValue = initValue;
        this.mAdjacentValue = initValue;
        valueToArray(initValue, this.mCurrentNumbers);
        valueToArray(this.mAdjacentValue, this.mAdjacentNumbers);
        setNumberWithValue(initValue);
        invalidate();
    }

    private void setNumberWithValue(int value) {
        Iterator<ScrollingNumber> r0 = this.mNumbers.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().setNumberWithValue(value);
        goto L4
    L6:
        updateShowingNumberCount(updateNumberCanShowZero() + 1);
    }

    private int updateNumberCanShowZero() {
        int r0 = 0;
        int r1 = 0;
        boolean r2 = false;
    L3:
        int[] r3 = this.mAdjacentNumbers;
        if (r0 >= (r3.length - 1)) goto L11;
        this.mNumbers.get(r0).setCanShowZero(r2);
        if (r2 == true) goto L10;
        int[] r4 = this.mAdjacentNumbers;
        if (r4[r0] == 0) goto L10;
        r1 = r4.length - (r0 + 1);
        r2 = true;
    L10:
        r0 = r0 + 1;
        goto L3
    L11:
        this.mNumbers.get(r3.length - 1).setCanShowZero(true);
        return r1;
    }

    private void updateShowingNumberCount(int newCount) {
        if (newCount != this.mShowingCount) goto L5;
        return;
    L5:
        this.mShowingCount = newCount;
        updateNumberLocation();
    }

    public void setAdjustSubTextThresholdWhenCentered(int adjustSubTextThreshold) {
        this.mAdjustSubTextThreshold = adjustSubTextThreshold;
        updateNumberLocation();
    }

    private void updateNumberLocation() {
        int r0 = getPaddingLeft();
        int r1 = getPaddingRight();
        int r2 = getPaddingTop();
        int r3 = (int) (this.mTextWidthHeight.x * this.mSingleNumberWidthMult);
        int r4 = this.mMaxDigits * r3;
        int r5 = this.mShowingCount;
        int r6 = r5 * r3;
        int r7 = r4 - r6;
        int r8 = this.mAlignment;
        if (r8 == 0) goto L12;
        if (r8 != 1) goto L7;
    L10:
        r0 = r0 - r7;
    L16:
        this.mSubLocation.set(r4 + r0, this.mSubWidthHeight.y + r2);
        int r9 = r2 + this.mTextWidthHeight.y;
        Iterator<ScrollingNumber> r10 = this.mNumbers.iterator();
    L18:
        if (r10.hasNext() == false) goto L20;
        r10.next().setLocation(r0, r9);
        r0 = r0 + r3;
        goto L18
    L20:
        return;
    L7:
        if (r8 != 2) goto L16;
        r0 = ((getWidth() - r1) - this.mSubWidthHeight.x) - r4;
        goto L16
    L12:
        if (r5 < this.mAdjustSubTextThreshold) goto L14;
        int r11 = this.mSubWidthHeight.x;
    L15:
        r0 = (int) (((getWidth() - r6) - r11) / 2.0f);
        goto L10
    L14:
        r11 = 0;
        goto L15
    }

    public void setNumberAnimatorValues(int... targetValues) {
        this.mSourceData = targetValues;
        Iterator<ScrollingNumber> r0 = this.mNumbers.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().setAnimatorValues(this.mCurrentValue, targetValues);
        goto L4
    }

    public void setNumberAnimatorDuration(long duration) {
        this.mAnimatorSet.setDuration(duration);
    }

    public void startNumberAnimator() {
        this.mFinishDispatched = false;
        this.mAnimatorCanceled = false;
        this.mAnimatorSet.start();
    }

    public void cancelNumberAnimator() {
        this.mAnimatorSet.cancel();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator animation) {
        invalidate();
    }

    @Override // com.bytedanceos.rotateview.ColorAnimateHelper.ColorUpdateListener
    public void onColorUpdate(int color) {
        setPaintColor(color);
        invalidate();
    }

    public void pause() {
        post(new ScrollingNumbersView$$ExternalSyntheticLambda1(this));
    }

    /* JADX INFO: renamed from: lambda$pause$0$com-obric-oui-animation-ScrollingNumbersView, reason: not valid java name */
    /* synthetic */ void m200lambda$pause$0$comobricouianimationScrollingNumbersView() {
        this.mIsPause = true;
        this.mAnimatorSet.pause();
        ScrollNumberListener r1 = this.mScrollNumberListener;
        if (r1 == null) goto L6;
        r1.onPause();
        return;
    }

    public boolean isPause() {
        return this.mIsPause;
    }

    public void resume() {
        post(new ScrollingNumbersView$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: lambda$resume$1$com-obric-oui-animation-ScrollingNumbersView, reason: not valid java name */
    /* synthetic */ void m201lambda$resume$1$comobricouianimationScrollingNumbersView() {
        this.mIsPause = false;
        this.mNeedPause = false;
        this.mAnimatorSet.resume();
        ScrollNumberListener r1 = this.mScrollNumberListener;
        if (r1 == null) goto L6;
        r1.onResume();
        return;
    }

    public void destory() {
        this.mAnimatorSet.removeAllListeners();
        this.mAnimatorSet.cancel();
    }

    private static int[] valueToArray(int value, int length) {
        int[] r1 = new int[length];
        valueToArray(value, r1);
        return r1;
    }

    private static void valueToArray(int value, int[] array) {
        int r0 = array.length - 1;
    L3:
        if (r0 < 0) goto L5;
        array[r0] = value % 10;
        value = value / 10;
        r0 = r0 - 1;
        goto L3
    }

    private static int arrayToValue(int[] array) {
        int r1 = 1;
        int r0 = array.length - 1;
        int r2 = 0;
    L3:
        if (r0 < 0) goto L5;
        r2 = r2 + (array[r0] * r1);
        r1 = r1 * 10;
        r0 = r0 - 1;
        goto L3
    L5:
        return r2;
    }

    private boolean needPause(int currentValue) {
        if (this.mNeedPause == false) goto L23;
        int[] r0 = this.mSourceData;
        if (r0 == null) goto L23;
        if (r0.length < 1) goto L23;
        int r1 = r0.length;
        int r2 = getCurrentPauseNumber();
        if (currentValue >= r2) goto L12;
        return false;
    L12:
        int r7 = 0;
    L13:
        if (r7 >= r1) goto L23;
        int[] r4 = this.mSourceData;
        if (r4[r7] != r2) goto L22;
        if (r7 == (r1 - 1)) goto L20;
        if (r4[r7 + 1] == r2) goto L22;
    L20:
        this.mCurrentPauseIndex++;
        return true;
    L22:
        r7 = r7 + 1;
    L23:
        return false;
    }

    private boolean isLastNumber() {
        int[] r0 = this.mSourceData;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.length >= 1) goto L8;
        return false;
    L8:
        if (this.mCurrentValue == r0[r0.length - 1]) goto L10;
        return false;
    L10:
        return true;
    }

    public void onNumberChanged(ScrollingNumber sn, int oldNumber, int newNumber) {
        this.mCurrentNumbers[(this.mMaxDigits - sn.getDigit()) - 1] = newNumber;
        int r2 = arrayToValue(this.mCurrentNumbers);
        this.mCurrentValue = r2;
        if (needPause(r2) == false) goto L6;
        pause();
    L6:
        if (isLastNumber() == false) goto L9;
        dispatchFinishIfNeeded();
        return;
    }

    public void onAdjacentNumberStartShowing(ScrollingNumber sn, int adjacentNumber) {
        this.mAdjacentNumbers[(this.mMaxDigits - sn.getDigit()) - 1] = adjacentNumber;
        updateShowingNumberCount(updateNumberCanShowZero() + 1);
        this.mAdjacentValue = arrayToValue(this.mAdjacentNumbers);
    }

    public void setScrollNumberListener(ScrollNumberListener listener) {
        this.mScrollNumberListener = listener;
    }
}
