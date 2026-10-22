package com.bytedanceos.rotateview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import androidx.core.internal.view.SupportMenu;
import com.obric.olog.OLog;
import com.obric.security.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BezierBubbleView extends View implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
    private static final boolean ADJUST_CONTROL_POINT = false;
    private static final String ALPHA = "alpha";
    private static final float BEZIER_TIME_END = 1.0f;
    private static final float BEZIER_TIME_START = 0.0f;
    private static final int BEZIER_WIDTH = 10;
    private static final boolean DEBUG = false;
    private static final float DEFAULT_BEZIER_TIME_RANGE = 0.33333334f;
    private static final int DEFAULT_BUBBLE_ALPHA = 155;
    private static final int DEFAULT_BUBBLE_ALPHA_RANGE = 100;
    private static final int DEFAULT_BUBBLE_COLOR = 0;
    private static final int DEFAULT_BUBBLE_RADIUS = 5;
    private static final int DEFAULT_BUBBLE_RADIUS_RANGE = 2;
    private static final int DEFAULT_BUBBLE_SIZE = 50;
    private static final int DEFAULT_DELAY_RANGE = 200;
    private static final int DEFAULT_DURATION = 2000;
    private static final int DEFAULT_DURATION_RANGE = 400;
    private static final float DEFAULT_LOCATION_RANGE = 300.0f;
    private static final String LOCATION = "location";
    private static final int TEXT_SIZE = 40;
    private long lastTime;
    private AnimatorSet mAlphaAnimatorSet;
    private boolean mAnimatorPrepared;
    private AnimatorSet mBezierAnimatorSet;
    private BezierBubbleListener mBezierBubbleListener;
    private final BezierData mBezierData;
    private final Paint mBezierPaint;
    private final Path mBezierPath;
    private final float mBezierTimeRange;
    private final int mBubbleAlpha;
    private final int mBubbleAlphaRange;
    private final int mBubbleDelayRange;
    private final int mBubbleDuration;
    private final int mBubbleDurationRange;
    private final Paint mBubblePaint;
    private final int mBubbleRadius;
    private final int mBubbleRadiusRange;
    private final int mBubbleSize;
    private final List<Bubble> mBubbles;
    private boolean mCanAddControlPoint;
    private final Paint mControlPaint;
    private final float mControlPointLocationRange;
    private List<ControllPositionData> mControlPositions;
    private int mCurrentControlIndex;
    private boolean mDrawingBubble;
    private volatile boolean mHasCancel;
    private boolean mHasNotify;
    private volatile boolean mIsAniming;
    private final StringBuilder mLogSb;
    private PointF mTargetControlPoint;
    private final Paint mTextPaint;

    public interface BezierBubbleListener {
        void onRunning(ControllPositionData.TYPE type);
    }

    public void deleteControlPoint() {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animation) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animation) {
    }

    public BezierBubbleView(Context context) {
        this(context, null);
    }

    public BezierBubbleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BezierBubbleView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public BezierBubbleView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mBezierData = new BezierData();
        this.mBubbles = new ArrayList();
        this.mBezierPath = new Path();
        Paint r0 = new Paint();
        this.mBezierPaint = r0;
        Paint r1 = new Paint();
        this.mControlPaint = r1;
        Paint r2 = new Paint();
        this.mTextPaint = r2;
        Paint r3 = new Paint();
        this.mBubblePaint = r3;
        this.mAnimatorPrepared = false;
        this.mDrawingBubble = false;
        this.mCanAddControlPoint = false;
        this.mCurrentControlIndex = -1;
        this.mIsAniming = false;
        this.mHasCancel = false;
        this.mHasNotify = false;
        r0.setColor(SupportMenu.CATEGORY_MASK);
        r0.setStrokeWidth(10.0f);
        r0.setStyle(Paint.Style.STROKE);
        r0.setAntiAlias(true);
        r1.setColor(-16776961);
        r1.setStyle(Paint.Style.FILL);
        r1.setAntiAlias(true);
        r2.setColor(-16777216);
        r2.setTextSize(40.0f);
        r2.setAntiAlias(true);
        r3.setColor(0);
        r3.setStyle(Paint.Style.FILL);
        r3.setAntiAlias(true);
        this.lastTime = 0;
        this.mLogSb = null;
        this.mControlPositions = new ArrayList();
        TypedArray r7 = context.obtainStyledAttributes(attrs, R.styleable.BezierBubbleView, defStyleAttr, defStyleRes);
        this.mBubbleSize = r7.getDimensionPixelSize(6, 50);
        this.mBubbleRadius = r7.getDimensionPixelSize(4, 5);
        this.mBubbleRadiusRange = r7.getDimensionPixelSize(5, 2);
        r7.getColor(3, 0);
        this.mBubbleAlpha = r7.getInt(1, DEFAULT_BUBBLE_ALPHA);
        this.mBubbleAlphaRange = r7.getInt(2, 100);
        this.mBubbleDuration = r7.getInt(10, 2000);
        this.mBubbleDurationRange = r7.getInt(11, 400);
        this.mBubbleDelayRange = r7.getInt(9, 200);
        this.mControlPointLocationRange = r7.getDimension(7, DEFAULT_LOCATION_RANGE);
        this.mBezierTimeRange = r7.getFloat(0, DEFAULT_BEZIER_TIME_RANGE);
        r7.recycle();
    }

    private void initBezierData(ControllPositionData data) {
        if (data != null) goto L4;
        return;
    L4:
        this.mBezierData.clearControlPoints();
        List<ControllPositionData.Position> r5 = data.getPostions();
        if (r5 != null) goto L7;
        return;
    L7:
        if (r5.size() <= 0) goto L15;
        Iterator<ControllPositionData.Position> r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L16;
        ControllPositionData.Position r0 = r6.next();
        this.mBezierData.addControlPoint(new PointF(r0.x, r0.y));
        goto L11
    L16:
        return;
    }

    public ControllPositionData addNewControlConfig(int resid, ControllPositionData.TYPE type) {
        String[] r2 = getResources().getStringArray(resid);
        if (r2 != null) goto L6;
        return null;
    L6:
        ControllPositionData r3 = ControllPositionData.getByConfig(getContext(), r2);
        r3.setType(type);
        this.mControlPositions.add(r3);
        if (this.mCurrentControlIndex >= 0) goto L9;
        setCurrent(0);
    L9:
        return r3;
    }

    public void removeControllConfig(ControllPositionData.TYPE type) {
        Iterator<ControllPositionData> r0 = this.mControlPositions.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ControllPositionData r1 = r0.next();
        if (r1.getType() != type) goto L4;
    L9:
        if (r1 == null) goto L15;
        this.mControlPositions.remove(r1);
        setCurrent(0);
        return;
    L15:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public void setCurrent(int index) {
        if (this.mIsAniming == false) goto L5;
        return;
    L5:
        if (index >= 0) goto L7;
    L11:
        this.mCurrentControlIndex = -1;
        return;
    L7:
        if (index >= this.mControlPositions.size()) goto L11;
        this.mCurrentControlIndex = index;
        initBezierData(this.mControlPositions.get(index));
    }

    private void setupBubbles(ControllPositionData data) {
        this.mBubbles.clear();
        int r0 = 0;
    L4:
        if (r0 >= this.mBubbleSize) goto L6;
        Bubble r1 = new Bubble().setRadius(RandomUtils.getRandomValue(this.mBubbleRadius, this.mBubbleRadiusRange)).setColor(data.getColor()).setAlpha(RandomUtils.getRandomValue(this.mBubbleAlpha, this.mBubbleAlphaRange));
        this.mBubbles.add(r1);
        r0 = r0 + 1;
        goto L4
    L6:
        Iterator<Bubble> r5 = this.mBubbles.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        r5.next().setControlPoints(this.mBezierData, this.mControlPointLocationRange);
        goto L8
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mBezierData.getControlPointsCount() >= 1) goto L5;
        return;
    L5:
        canvas.save();
        if (this.mDrawingBubble == true) goto L8;
    L22:
        canvas.restore();
        return;
    L8:
        if (this.mHasCancel == true) goto L22;
        Iterator<Bubble> r0 = this.mBubbles.iterator();
    L11:
        if (r0.hasNext() == false) goto L22;
        Bubble r2 = r0.next();
        if (r2.getAlpha() <= 0) goto L11;
        this.mBubblePaint.setColor(r2.getColor());
        this.mBubblePaint.setAlpha(r2.getAlpha());
        if (r2.getX() <= 0.0f) goto L11;
        canvas.drawCircle(r2.getX(), r2.getY(), r2.getRadius(), this.mBubblePaint);
        BezierBubbleListener r3 = this.mBezierBubbleListener;
        if (r3 == null) goto L11;
        if (this.mHasNotify == true) goto L11;
        this.mHasNotify = true;
        r3.onRunning(this.mControlPositions.get(this.mCurrentControlIndex).getType());
        goto L11
    }

    private PointF getNearestControlPoint(float x, float y) {
        int r0 = this.mBezierData.getControlPointsCount();
        int r1 = 1;
        if (r0 >= 1) goto L6;
        return null;
    L6:
        PointF r2 = this.mBezierData.getControlPoint(0);
        double r3 = Math.hypot(x - r2.x, y - r2.y);
    L7:
        if (r1 >= r0) goto L12;
        PointF r5 = this.mBezierData.getControlPoint(r1);
        double r6 = Math.hypot(x - r5.x, y - r5.y);
        if (r3 <= r6) goto L11;
        r2 = r5;
        r3 = r6;
    L11:
        r1 = r1 + 1;
        goto L7
    L12:
        return r2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    public void setCanAddControlPoint(boolean canAddControlPoint) {
        this.mCanAddControlPoint = canAddControlPoint;
    }

    public boolean isCanAddControlPoint() {
        return this.mCanAddControlPoint;
    }

    public void startAnimator() {
        if (this.mIsAniming == false) goto L5;
        return;
    L5:
        if (this.mHasCancel == false) goto L8;
        return;
    L8:
        if (this.mBezierData.getControlPointsCount() >= 2) goto L10;
        return;
    L10:
        if (isOutRange() == true) goto L17;
        release();
        this.mHasNotify = false;
        ControllPositionData r0 = this.mControlPositions.get(this.mCurrentControlIndex);
        setupBubbles(r0);
        setupAnimator();
        this.mBezierAnimatorSet.setStartDelay(r0.getAnimDelayTime());
        this.mAlphaAnimatorSet.setStartDelay(r0.getAnimDelayTime());
        this.mBezierAnimatorSet.start();
        this.mAlphaAnimatorSet.start();
        return;
    }

    public void cancelAnimatior() {
        this.mHasCancel = true;
        release();
    }

    private boolean isOutRange() {
        int r0 = this.mCurrentControlIndex;
        if (r0 >= 0) goto L5;
        return true;
    L5:
        if (r0 >= this.mControlPositions.size()) goto L11;
        return false;
    L11:
        return true;
    }

    private void setupAnimator() {
        if (this.mAnimatorPrepared == false) goto L5;
        return;
    L5:
        this.mAnimatorPrepared = true;
        this.mBezierAnimatorSet.setInterpolator(new AccelerateInterpolator(0.8f));
        this.mBezierAnimatorSet.addListener(this);
        ArrayList r1 = new ArrayList(this.mBubbleSize);
        ArrayList r2 = new ArrayList(this.mBubbleSize);
        Iterator<Bubble> r3 = this.mBubbles.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        Bubble r4 = r3.next();
        float r5 = this.mBezierTimeRange;
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r4, "location", new float[]{0.0f, RandomUtils.getRandomValue(1.0f - r5, r5)});
        long r7 = RandomUtils.RAND.nextInt(this.mBubbleDelayRange);
        r6.setStartDelay(r7);
        long r9 = RandomUtils.getRandomValue(this.mBubbleDuration, this.mBubbleDurationRange);
        r6.setDuration(r9);
        r6.addUpdateListener(this);
        r1.add(r6);
        ObjectAnimator r8 = ObjectAnimator.ofInt(r4, "alpha", new int[]{0});
        r8.setInterpolator(new AccelerateInterpolator());
        long r11 = (long) (r9 * 0.1f);
        r8.setStartDelay((r7 + r9) - r11);
        r8.setDuration(r11);
        r2.add(r8);
        goto L7
    L9:
        this.mBezierAnimatorSet.playTogether(r1);
        this.mAlphaAnimatorSet.playTogether(r2);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator animation) {
        invalidate();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animation) {
        this.mIsAniming = true;
        if (animation != this.mBezierAnimatorSet) goto L6;
        this.mDrawingBubble = true;
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        if (animation != this.mBezierAnimatorSet) goto L9;
        this.mDrawingBubble = false;
        this.mIsAniming = false;
        if (this.mControlPositions.get(this.mCurrentControlIndex).isRepeat() == true) goto L7;
        setCurrent(this.mCurrentControlIndex + 1);
    L7:
        startAnimator();
        return;
    }

    private void release() {
        AnimatorSet r0 = this.mBezierAnimatorSet;
        if (r0 != null) goto L5;
    L8:
        AnimatorSet r1 = this.mAlphaAnimatorSet;
        if (r1 != null) goto L11;
    L14:
        this.mBezierAnimatorSet = new AnimatorSet();
        this.mAlphaAnimatorSet = new AnimatorSet();
        this.mAnimatorPrepared = false;
        return;
    L11:
        if (r1.isRunning() == false) goto L13;
        this.mAlphaAnimatorSet.end();
    L13:
        this.mAlphaAnimatorSet.removeAllListeners();
        goto L14
    L5:
        if (r0.isRunning() == false) goto L7;
        this.mBezierAnimatorSet.end();
    L7:
        this.mBezierAnimatorSet.removeAllListeners();
        goto L8
    }

    private static void printLog(StringBuilder sb) {
        if (sb != null) goto L4;
        return;
    L4:
        int r0 = sb.length();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        int r2 = r1 + 1000;
        OLog.d("BEZIER_BUBBLE", sb.substring(r1, Math.min(r2, r0)));
        r1 = r2;
        goto L5
    }

    public void setBezierBubbleListener(BezierBubbleListener listener) {
        this.mBezierBubbleListener = listener;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animation, boolean isReverse) {
        onAnimationStart(animation);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation, boolean isReverse) {
        onAnimationEnd(animation);
    }
}
