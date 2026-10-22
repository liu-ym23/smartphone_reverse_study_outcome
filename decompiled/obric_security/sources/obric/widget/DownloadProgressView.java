package obric.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/* JADX INFO: loaded from: classes5.dex */
public class DownloadProgressView extends View {
    protected static final int DEF_ALPHA_ANIM_DURATION = 300;
    protected static int DEF_BACK_RING_WIDTH = 6;
    protected static final float DEF_BACK_RING_WIDTH_DP = 2.0f;
    protected static int DEF_FORE_RING_WIDTH = 4;
    protected static final float DEF_FORE_RING_WIDTH_DP = 1.3333334f;
    protected static int DEF_INNER_CIRCLE_RADIUS = 0;
    protected static final int DEF_PROGRESS = 0;
    protected static int DEF_VIEW_WIDTH = 0;
    protected static final int MAX_ALPHA = 255;
    protected static final int MIN_ALPHA = 0;
    public static final int STATE_PAUSED = 1;
    public static final int STATE_PROCESSING = 4;
    public static final int STATE_RESUMED = 2;
    public static final int STATE_RETRY = 3;
    protected ValueAnimator mAlphaAnim;
    protected long mAlphaAnimDuration;
    private RectF mArcRectF;
    protected int mBackProgressEndColor;
    private Shader mBackProgressShader;
    protected int mBackProgressStartColor;
    protected int mBackRingWidth;
    protected int mCurrentState;
    protected int mCurrentStateDrawableAlpha;
    protected Drawable mDownloadDrawable;
    protected int mFailedProgressColor;
    protected int mForeProgressEndColor;
    private Shader mForeProgressShader;
    protected int mForeProgressStartColor;
    protected int mForeRingWidth;
    protected int mInnerBackRingColor;
    protected int mInnerCircleRadius;
    protected int mInnerForeRingColor;
    protected int mLastState;
    private Paint mPaint;
    protected Drawable mPauseDrawable;
    protected int mProcessingDegree;
    protected Drawable mProcessingDrawable;
    protected int mProgress;
    protected Drawable mRetryDrawable;
    protected int mWidth;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int currentState;
        int progress;

        /* synthetic */ SavedState(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.progress = in.readInt();
            this.currentState = in.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.progress);
            out.writeInt(this.currentState);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    static {
    }

    public DownloadProgressView(Context context) {
        this(context, null);
    }

    public DownloadProgressView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DownloadProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public DownloadProgressView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mCurrentState = 1;
        this.mLastState = 1;
        this.mCurrentStateDrawableAlpha = 255;
        this.mAlphaAnimDuration = 300;
        this.mDownloadDrawable = null;
        this.mPauseDrawable = null;
        this.mRetryDrawable = null;
        this.mProcessingDrawable = null;
        DEF_INNER_CIRCLE_RADIUS = dp2px(context, 15.0f);
        DEF_VIEW_WIDTH = dp2px(context, 36.0f);
        DEF_BACK_RING_WIDTH = dp2px(context, 2.0f);
        DEF_FORE_RING_WIDTH = dp2px(context, DEF_FORE_RING_WIDTH_DP);
        initAttributes(context, attrs, defStyleAttr, defStyleRes);
        if (this.mBackRingWidth < this.mForeRingWidth) goto L7;
        initDefaultDrawable();
        return;
    L7:
        throw new IllegalArgumentException("the ring width should match mBackRingWidth >= mForeRingWidth, mBackRingWidth:" + this.mBackRingWidth + " mForeRingWidth:" + this.mForeRingWidth);
    }

    protected void initAttributes(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray r2 = context.obtainStyledAttributes(attrs, R.styleable.DownloadProgressView, defStyleAttr, defStyleRes);
        initAttributes(r2);
        r2.recycle();
    }

    protected void initAttributes(TypedArray a2) {
        this.mInnerCircleRadius = a2.getDimensionPixelSize(R.styleable.DownloadProgressView_inner_circle_radius, DEF_INNER_CIRCLE_RADIUS);
        this.mForeRingWidth = a2.getDimensionPixelSize(R.styleable.DownloadProgressView_fore_ring_width, DEF_FORE_RING_WIDTH);
        this.mBackRingWidth = a2.getDimensionPixelOffset(R.styleable.DownloadProgressView_back_ring_width, DEF_BACK_RING_WIDTH);
        this.mProgress = a2.getInt(R.styleable.DownloadProgressView_smt_progress, 0);
        this.mForeProgressStartColor = a2.getColor(R.styleable.DownloadProgressView_fore_progress_start_color, getResources().getColor(R.color.def_fore_progress_start_color));
        this.mForeProgressEndColor = a2.getColor(R.styleable.DownloadProgressView_fore_progress_end_color, getResources().getColor(R.color.def_fore_progress_end_color));
        this.mBackProgressStartColor = a2.getColor(R.styleable.DownloadProgressView_back_progress_start_color, getResources().getColor(R.color.def_back_progress_start_color));
        this.mBackProgressEndColor = a2.getColor(R.styleable.DownloadProgressView_back_progress_end_color, getResources().getColor(R.color.def_back_progress_end_color));
        this.mFailedProgressColor = a2.getColor(R.styleable.DownloadProgressView_failed_progress_color, getResources().getColor(R.color.def_failed_progress_color));
        this.mDownloadDrawable = a2.getDrawable(R.styleable.DownloadProgressView_smt_download_drawable);
        this.mPauseDrawable = a2.getDrawable(R.styleable.DownloadProgressView_smt_pause_drawable);
        this.mRetryDrawable = a2.getDrawable(R.styleable.DownloadProgressView_smt_redo_drawable);
        this.mProcessingDrawable = a2.getDrawable(R.styleable.DownloadProgressView_smt_processing_drawable);
        this.mInnerForeRingColor = a2.getColor(R.styleable.DownloadProgressView_smt_fore_ring_bg_color, getResources().getColor(R.color.smt_def_fore_ring_bg_color));
        this.mInnerBackRingColor = a2.getColor(R.styleable.DownloadProgressView_smt_back_ring_bg_color, getResources().getColor(R.color.smt_def_back_ring_bg_color));
    }

    protected void initDefaultDrawable() {
        if (this.mDownloadDrawable != null) goto L6;
        this.mDownloadDrawable = getResources().getDrawable(R.drawable.circular_progress_download_2);
    L6:
        if (this.mPauseDrawable != null) goto L9;
        this.mPauseDrawable = getResources().getDrawable(R.drawable.circular_progress_pause_2);
    L9:
        if (this.mRetryDrawable != null) goto L12;
        this.mRetryDrawable = getResources().getDrawable(R.drawable.circular_progress_redo);
    L12:
        if (this.mProcessingDrawable != null) goto L15;
        this.mProcessingDrawable = getResources().getDrawable(R.drawable.circular_progress_processing);
        return;
    }

    public void setCurrentState(int state) {
        if (state != 1) goto L5;
    L13:
        int r0 = this.mCurrentState;
        if (r0 != state) goto L16;
        return;
    L16:
        this.mLastState = r0;
        this.mCurrentState = state;
        startShadowAlphaAnimation();
        invalidate();
        return;
    L5:
        if (state == 2) goto L13;
        if (state == 3) goto L13;
        if (state == 4) goto L13;
        throw new IllegalArgumentException("invalid state value:" + state);
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public int getLastState() {
        return this.mLastState;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setProgress(int progress) {
        if (this.mProgress != progress) goto L5;
        return;
    L5:
        this.mProgress = progress;
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int r3 = View.MeasureSpec.getMode(widthMeasureSpec);
        int r2 = View.MeasureSpec.getSize(widthMeasureSpec);
        if (r3 == Integer.MIN_VALUE) goto L7;
        if (r2 <= 0) goto L7;
        this.mWidth = r2;
    L8:
        int r4 = this.mWidth;
        if (r4 < ((this.mInnerCircleRadius + this.mBackRingWidth) * 2)) goto L13;
        setMeasuredDimension(r4, r4);
        return;
    L13:
        throw new IllegalArgumentException("illegal custom values, the view width should match: width >= 2*(inner_circle_radius + back_ring_width) , current width:" + this.mWidth + " inner_circle_radius:" + this.mInnerCircleRadius + " back_ring_width:" + this.mBackRingWidth);
    L7:
        this.mWidth = DEF_VIEW_WIDTH;
        goto L8
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int r8 = this.mForeRingWidth;
        int r9 = this.mBackRingWidth;
        if (this.mPaint != null) goto L5;
        this.mPaint = new Paint();
    L5:
        this.mPaint.reset();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(0);
        int r1 = this.mWidth;
        canvas.drawRect(0.0f, 0.0f, r1, r1, this.mPaint);
        int r2 = this.mWidth;
        int r3 = r2 / 2;
        int r11 = r2 / 2;
        this.mPaint.setColor(-1);
        Drawable r4 = getLastStateDrawable();
        if (r4 != null) goto L8;
    L10:
        Drawable r5 = getCurrentStateDrawable();
        if (r5 == null) goto L22;
        int r6 = r5.getIntrinsicWidth();
        int r7 = r5.getIntrinsicHeight();
        int r10 = this.mWidth;
        r5.setBounds((r10 - r6) / 2, (r10 - r7) / 2, (r6 + r10) / 2, (r10 + r7) / 2);
        r5.setAlpha(this.mCurrentStateDrawableAlpha);
        if (this.mCurrentState != 4) goto L17;
        int r12 = this.mProcessingDegree + 5;
        this.mProcessingDegree = r12;
        if (r12 < 360) goto L18;
        this.mProcessingDegree = r12 - 360;
    L18:
        canvas.rotate(this.mProcessingDegree, r3, r11);
        r5.draw(canvas);
        if (this.mCurrentState != 4) goto L22;
        invalidate();
        return;
    L17:
        this.mProcessingDegree = 0;
    L22:
        float r13 = r9;
        this.mPaint.setStrokeWidth(r13);
        this.mPaint.setColor(this.mInnerBackRingColor);
        float r14 = r3;
        float r15 = r11;
        canvas.drawCircle(r14, r15, this.mInnerCircleRadius, this.mPaint);
        float r16 = r8;
        this.mPaint.setStrokeWidth(r16);
        this.mPaint.setColor(this.mInnerForeRingColor);
        canvas.drawCircle(r14, r15, this.mInnerCircleRadius, this.mPaint);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        if (this.mArcRectF != null) goto L25;
        int r17 = this.mInnerCircleRadius;
        this.mArcRectF = new RectF(r3 - r17, r11 - r17, r3 + r17, r17 + r11);
    L25:
        this.mPaint.setStrokeWidth(r13);
        if (this.mCurrentState != 3) goto L29;
        this.mPaint.setColor(this.mFailedProgressColor);
    L32:
        float r18 = (this.mProgress * 360.0f) / 100.0f;
        canvas.drawArc(this.mArcRectF, -90.0f, r18, false, this.mPaint);
        this.mPaint.setStrokeWidth(r16);
        if (this.mCurrentState != 3) goto L36;
        this.mPaint.setColor(this.mFailedProgressColor);
    L39:
        canvas.drawArc(this.mArcRectF, -90.0f, r18, false, this.mPaint);
        return;
    L36:
        if (this.mForeProgressShader != null) goto L38;
        int r19 = this.mInnerCircleRadius;
        int r20 = this.mForeRingWidth;
        this.mForeProgressShader = new LinearGradient(0.0f, (r11 - r19) - r20, 0.0f, (r11 + r19) + r20, this.mForeProgressStartColor, this.mForeProgressEndColor, Shader.TileMode.CLAMP);
    L38:
        this.mPaint.setShader(this.mForeProgressShader);
        goto L39
    L29:
        if (this.mBackProgressShader != null) goto L31;
        int r21 = this.mInnerCircleRadius;
        int r22 = this.mBackRingWidth;
        this.mBackProgressShader = new LinearGradient(0.0f, (r11 - r21) - r22, 0.0f, (r21 + r11) + r22, this.mBackProgressStartColor, this.mBackProgressEndColor, Shader.TileMode.CLAMP);
    L31:
        this.mPaint.setShader(this.mBackProgressShader);
        goto L32
    L8:
        if (this.mCurrentStateDrawableAlpha == 255) goto L10;
        int r23 = r4.getIntrinsicWidth();
        int r24 = r4.getIntrinsicHeight();
        int r25 = this.mWidth;
        r4.setBounds((r25 - r23) / 2, (r25 - r24) / 2, (r23 + r25) / 2, (r25 + r24) / 2);
        r4.setAlpha(255 - this.mCurrentStateDrawableAlpha);
        r4.draw(canvas);
        goto L10
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        cancelAlphaAnim();
        super.onDetachedFromWindow();
    }

    private Drawable getCurrentStateDrawable() {
        return getStateDrawable(this.mCurrentState);
    }

    private Drawable getLastStateDrawable() {
        return getStateDrawable(this.mLastState);
    }

    private Drawable getStateDrawable(int state) {
        if (state == 1) goto L15;
        if (state == 2) goto L19;
        if (state == 3) goto L18;
        if (state == 4) goto L17;
        return null;
    L17:
        return this.mProcessingDrawable;
    L18:
        return this.mRetryDrawable;
    L19:
        return this.mPauseDrawable;
    L15:
        return this.mDownloadDrawable;
    }

    private void startShadowAlphaAnimation() {
        if (this.mAlphaAnimDuration > 0) goto L6;
        return;
    L6:
        if (this.mAlphaAnim != null) goto L9;
        ValueAnimator r0 = ValueAnimator.ofInt(new int[]{0, 255});
        this.mAlphaAnim = r0;
        r0.addUpdateListener(new AnonymousClass1(this));
        this.mAlphaAnim.setDuration(this.mAlphaAnimDuration);
    L9:
        if (isAlphaAnimRunning() == false) goto L11;
        cancelAlphaAnim();
    L11:
        this.mAlphaAnim.start();
    }

    public void setAlphaAnimationDuration(long duration) {
        this.mAlphaAnimDuration = duration;
    }

    private boolean isAlphaAnimRunning() {
        ValueAnimator r0 = this.mAlphaAnim;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isRunning() == false) goto L7;
        return true;
    }

    private void cancelAlphaAnim() {
        if (isAlphaAnimRunning() == false) goto L5;
        this.mAlphaAnim.cancel();
    L5:
        this.mCurrentStateDrawableAlpha = 255;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.progress = this.mProgress;
        r1.currentState = this.mCurrentState;
        return r1;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        SavedState r2 = (SavedState) state;
        super.onRestoreInstanceState(r2.getSuperState());
        setCurrentState(r2.currentState);
        setProgress(r2.progress);
    }

    private static int dp2px(Context context, float dp) {
        float r1 = TypedValue.applyDimension(1, dp, context.getResources().getDisplayMetrics());
        if (r1 < 0.0f) goto L5;
        float r2 = r1 + 0.9f;
    L7:
        return (int) r2;
    L5:
        r2 = r1 - 0.9f;
        goto L7
    }

    public void setInnerForeRingColor(int colorId) {
        this.mInnerForeRingColor = getResources().getColor(colorId);
    }

    public void setInnerBackRingColor(int colorId) {
        this.mInnerBackRingColor = getResources().getColor(colorId);
    }

    public void setStateDrawable(int drawableId, int state) {
        Drawable r2 = getResources().getDrawable(drawableId);
        if (state != 1) goto L5;
        this.mDownloadDrawable = r2;
        return;
    L5:
        if (state != 2) goto L7;
        this.mPauseDrawable = r2;
        return;
    L7:
        if (state != 3) goto L9;
        this.mRetryDrawable = r2;
        return;
    L9:
        if (state != 4) goto L19;
        this.mProcessingDrawable = r2;
        return;
    }
}
