package com.obric.oui.progress;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewKt;
import com.obric.common.oui.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public class ODownloadProgressView extends View {
    private static final int DEF_ALPHA_ANIM_DURATION = 300;
    private static final int MAX_ALPHA = 255;
    private static final int MIN_ALPHA = 0;
    private ValueAnimator mAlphaAnim;
    private long mAlphaAnimDuration;
    private int mCenterIconSize;
    private int mCurrentState;
    private int mCurrentStateDrawableAlpha;
    private Drawable mDownloadDrawable;
    private Drawable mFailedDrawable;
    private int mLastState;
    private Paint mPaint;
    private Drawable mPauseDrawable;
    private final ValueAnimator mProcessingAnimator;
    private Drawable mProcessingDrawable;
    private int mProcessingDuration;
    private int mProgress;
    private final ValueAnimator mProgressAnimator;
    private int mProgressBackgroundColor;
    private Drawable mProgressBgDrawable;
    private int mProgressColor;
    private int mProgressDuration;
    private final PorterDuffXfermode mProgressGapMode;
    private final Path mProgressPath;
    private Drawable mRetryDrawable;
    private int mStandardSize;
    private Drawable mSucceedDrawable;
    private int mWidth;

    private static class GapBitmap {
        private static final SparseArray<Bitmap> sBitmaps = null;

        private GapBitmap() {
        }

        static {
            sBitmaps = new SparseArray(3);
        }

        public static Bitmap get(Context r3, int r4) {
            SparseArray<Bitmap> r0 = sBitmaps;
            Bitmap r1 = r0.get(r4);
            if (r1 == null) goto L5;
            return r1;
        L5:
            Drawable r5 = ResourcesCompat.getDrawable(r3.getResources(), R.drawable.o_ic_download_progress_gap, null);
            if (r5 != null) goto L8;
            return null;
        L8:
            r5.setBounds(0, 0, r4, r4);
            Bitmap r2 = Bitmap.createBitmap(r4, r4, Bitmap.Config.ARGB_8888);
            r5.draw(new Canvas(r2));
            r0.put(r4, r2);
            return r2;
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int currentState;
        int progress;

        /* synthetic */ SavedState(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        SavedState(Parcelable r1) {
            super(r1);
        }

        private SavedState(Parcel r2) {
            super(r2);
            this.progress = r2.readInt();
            this.currentState = r2.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.progress);
            r1.writeInt(this.currentState);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Size {
        public static final int LARGE = 0;
        public static final int MEDIUM = 1;
        public static final int SMALL = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
        public static final int EMPTY = 10;
        public static final int FAILED = 5;
        public static final int PAUSED = 1;
        public static final int PROCESSING = 0;
        public static final int RESUMED = 2;
        public static final int RETRY = 3;
        public static final int SUCCEED = 4;
    }

    private boolean noProgress(int r1) {
        if (r1 != 0) goto L4;
    L9:
        return true;
    L4:
        if (r1 == 4) goto L9;
        if (r1 == 5) goto L9;
        return false;
    }

    static /* synthetic */ int access$000(ODownloadProgressView r0) {
        return r0.mCurrentState;
    }

    static /* synthetic */ void access$100(ODownloadProgressView r0) {
        r0.cancelProcessingAnim();
    }

    static /* synthetic */ ValueAnimator access$200(ODownloadProgressView r0) {
        return r0.mProcessingAnimator;
    }

    static /* synthetic */ int access$300(ODownloadProgressView r0) {
        return r0.mProcessingDuration;
    }

    static /* synthetic */ int access$402(ODownloadProgressView r0, int r1) {
        r0.mCurrentStateDrawableAlpha = r1;
        return r1;
    }

    public Drawable getProcessingDrawable() {
        return this.mProcessingDrawable;
    }

    public void setProcessingDrawable(Drawable r1) {
        this.mProcessingDrawable = r1;
    }

    public Drawable getProgressBgDrawable() {
        return this.mProgressBgDrawable;
    }

    public void setProgressBgDrawable(Drawable r1) {
        this.mProgressBgDrawable = r1;
    }

    public Drawable getDownloadDrawable() {
        return this.mDownloadDrawable;
    }

    public void setDownloadDrawable(Drawable r1) {
        this.mDownloadDrawable = r1;
    }

    public Drawable getPauseDrawable() {
        return this.mPauseDrawable;
    }

    public void setPauseDrawable(Drawable r1) {
        this.mPauseDrawable = r1;
    }

    public Drawable getRetryDrawable() {
        return this.mRetryDrawable;
    }

    public void setRetryDrawable(Drawable r1) {
        this.mRetryDrawable = r1;
    }

    public Drawable getSucceedDrawable() {
        return this.mSucceedDrawable;
    }

    public void setSucceedDrawable(Drawable r1) {
        this.mSucceedDrawable = r1;
    }

    public Drawable getFailedDrawable() {
        return this.mFailedDrawable;
    }

    public void setFailedDrawable(Drawable r1) {
        this.mFailedDrawable = r1;
    }

    public ODownloadProgressView(Context r2) {
        this(r2, null);
    }

    public ODownloadProgressView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ODownloadProgressView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public ODownloadProgressView(Context r4, AttributeSet r5, int r6, int r7) {
        super(r4, r5, r6, r7);
        this.mCurrentState = 0;
        this.mLastState = 0;
        this.mCurrentStateDrawableAlpha = 255;
        this.mAlphaAnimDuration = 300;
        this.mProgressAnimator = new ValueAnimator();
        this.mProcessingDuration = 1200;
        this.mProgressDuration = 2000;
        this.mProgressPath = new Path();
        this.mProgressGapMode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.mProcessingAnimator = new ValueAnimator();
        TypedArray r8 = r4.obtainStyledAttributes(r5, R.styleable.ODownloadProgressView, r6, r7);
        int r9 = r8.getInt(R.styleable.ODownloadProgressView_oui_progress_view_size, 1);
        this.mProgress = r8.getInt(R.styleable.ODownloadProgressView_oui_progress, 0);
        this.mProgressColor = r8.getColor(R.styleable.ODownloadProgressView_oui_progress_color, ContextCompat.getColor(r4, R.color.oui_accent_6_bg));
        this.mProgressBackgroundColor = r8.getColor(R.styleable.ODownloadProgressView_oui_progress_background_color, ContextCompat.getColor(r4, R.color.oui_basic_line_2));
        int r10 = r8.getColor(R.styleable.ODownloadProgressView_oui_progressing_action_color, ContextCompat.getColor(r4, R.color.oui_accent_6_bg));
        int r11 = r8.getColor(R.styleable.ODownloadProgressView_oui_download_action_color, ContextCompat.getColor(r4, R.color.oui_accent_6_bg));
        r8.recycle();
        this.mProcessingDrawable = ResourcesCompat.getDrawable(getResources(), R.drawable.o_ic_progress_processing, null);
        this.mProgressBgDrawable = ResourcesCompat.getDrawable(getResources(), R.drawable.o_ic_download_progress_bg, null);
        this.mDownloadDrawable = ResourcesCompat.getDrawable(getResources(), R.drawable.o_ic_arrow_down_download, null);
        this.mPauseDrawable = ResourcesCompat.getDrawable(getResources(), R.drawable.o_ic_pause_download, null);
        this.mRetryDrawable = ResourcesCompat.getDrawable(getResources(), R.drawable.o_ic_download_retry, null);
        if (r10 == 0) goto L5;
        setProcessingColor(r10);
    L5:
        if (r11 == 0) goto L7;
        setActionColor(r11);
    L7:
        this.mSucceedDrawable = ResourcesCompat.getDrawable(getResources(), R.drawable.o_ic_download_succeed, null);
        this.mFailedDrawable = ResourcesCompat.getDrawable(getResources(), R.drawable.o_ic_download_failed, null);
        setSize(r9);
        startProcessingAnim();
    }

    public void setProgressColor(int r1) {
        this.mProgressColor = r1;
    }

    public void setProgressBackgroundColor(int r1) {
        this.mProgressBackgroundColor = r1;
    }

    public void setProcessingColor(int r2) {
        Drawable r0 = this.mProcessingDrawable.mutate();
        this.mProcessingDrawable = r0;
        DrawableCompat.setTint(r0, r2);
    }

    public void setActionColor(int r2) {
        this.mDownloadDrawable = this.mDownloadDrawable.mutate();
        this.mPauseDrawable = this.mPauseDrawable.mutate();
        this.mRetryDrawable = this.mRetryDrawable.mutate();
        DrawableCompat.setTint(this.mDownloadDrawable, r2);
        DrawableCompat.setTint(this.mPauseDrawable, r2);
        DrawableCompat.setTint(this.mRetryDrawable, r2);
    }

    private int dp2px(float r1) {
        return (int) (r1 * Resources.getSystem().getDisplayMetrics().density);
    }

    public void setSize(int r3) {
        if (r3 != 0) goto L5;
        this.mStandardSize = dp2px(48.0f);
        this.mCenterIconSize = dp2px(24.0f);
    L9:
        Drawable r4 = this.mProgressBgDrawable;
        int r0 = this.mStandardSize;
        r4.setBounds(0, 0, r0, r0);
        invalidate();
        return;
    L5:
        if (r3 == 2) goto L7;
        this.mStandardSize = dp2px(36.0f);
        this.mCenterIconSize = dp2px(16.0f);
        goto L9
    L7:
        this.mStandardSize = dp2px(24.0f);
        this.mCenterIconSize = dp2px(12.0f);
        goto L9
    }

    public void setCurrentState(int r2) {
        int r0 = this.mCurrentState;
        if (r0 != r2) goto L5;
        return;
    L5:
        this.mLastState = r0;
        this.mCurrentState = r2;
        invalidate();
        startProcessingAnim();
    }

    private void startProcessingAnim() {
        if (this.mCurrentState == 0) goto L6;
        cancelProcessingAnim();
        return;
    L6:
        ViewKt.doOnPreDraw(this, new AnonymousClass1(this));
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public int getLastState() {
        return this.mLastState;
    }

    public void setProcessingDuration(int r1) {
        this.mProcessingDuration = r1;
    }

    public void setProgressDuration(int r1) {
        this.mProgressDuration = r1;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setProgress(int r2) {
        setProgress(r2, false);
    }

    public void setProgress(int r7, boolean r8) {
        if (this.mProgress != r7) goto L5;
        return;
    L5:
        this.mProgressAnimator.cancel();
        int r0 = this.mProgress;
        int r9 = Math.max(Math.min(r7, 100), 0);
        this.mProgress = r9;
        if (r0 > r9) goto L11;
        if (r8 == false) goto L11;
        this.mProgressAnimator.setInterpolator(new LinearInterpolator());
        this.mProgressAnimator.setDuration((((long) Math.abs(this.mProgress - r0)) * ((long) this.mProgressDuration)) / 100);
        this.mProgressAnimator.setFloatValues(new float[]{r0, this.mProgress});
        this.mProgressAnimator.addUpdateListener(new AnonymousClass2(this));
        this.mProgressAnimator.start();
        return;
    L11:
        invalidate();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View r1, int r2) {
        super.onVisibilityChanged(r1, r2);
        if (r2 != 0) goto L5;
        startProcessingAnim();
        return;
    L5:
        cancelProcessingAnim();
    }

    @Override // android.view.View
    protected void onMeasure(int r2, int r3) {
        int r4 = View.MeasureSpec.getMode(r2);
        int r5 = View.MeasureSpec.getSize(r2);
        if (r4 == Integer.MIN_VALUE) goto L7;
        if (r5 <= 0) goto L7;
        this.mWidth = r5;
    L8:
        int r6 = this.mWidth;
        setMeasuredDimension(r6, r6);
        return;
    L7:
        this.mWidth = this.mStandardSize;
        goto L8
    }

    @Override // android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.view.View
    protected void onDraw(Canvas r11) {
        super.onDraw(r11);
        if (this.mPaint != null) goto L5;
        this.mPaint = new Paint();
    L5:
        this.mPaint.reset();
        this.mPaint.setAntiAlias(true);
        int r0 = this.mWidth;
        int r1 = r0 / 2;
        int r2 = r0 / 2;
        r11.save();
        Drawable r3 = getLastStateDrawable();
        if (r3 != null) goto L8;
    L14:
        Drawable r4 = getCurrentStateDrawable();
        if (r4 != null) goto L17;
    L31:
        r11.restore();
        if (this.mProgressAnimator.isRunning() == true) goto L34;
    L36:
        float r5 = this.mProgress;
    L37:
        float r6 = (r5 * 360.0f) / 100.0f;
        r11.save();
        if (r6 < 360.0f) goto L40;
        this.mProgressBgDrawable.setColorFilter(this.mProgressColor, PorterDuff.Mode.SRC_IN);
        this.mProgressBgDrawable.draw(r11);
    L41:
        r11.restore();
        return;
    L40:
        this.mProgressBgDrawable.setColorFilter(this.mProgressBackgroundColor, PorterDuff.Mode.SRC_IN);
        this.mProgressBgDrawable.draw(r11);
        this.mProgressPath.reset();
        this.mProgressPath.moveTo(getWidth() / 2.0f, getHeight() / 2.0f);
        this.mProgressPath.arcTo(0.0f, 0.0f, getWidth(), getHeight(), -90.0f, r6, false);
        r11.save();
        r11.clipPath(this.mProgressPath);
        this.mProgressBgDrawable.setColorFilter(this.mProgressColor, PorterDuff.Mode.SRC_IN);
        this.mProgressBgDrawable.draw(r11);
        r11.restore();
        goto L41
    L34:
        if (this.mProgressAnimator.getAnimatedValue() == null) goto L36;
        r5 = ((Float) this.mProgressAnimator.getAnimatedValue()).floatValue();
        goto L37
    L17:
        if (noProgress(this.mCurrentState) == false) goto L19;
        int r7 = this.mWidth;
        r4.setBounds(0, 0, r7, r7);
    L21:
        if (this.mCurrentState == 0) goto L23;
    L27:
        r4.setAlpha(this.mCurrentStateDrawableAlpha);
        r4.draw(r11);
        if (noProgress(this.mCurrentState) == false) goto L31;
        invalidate();
        return;
    L23:
        if (this.mProcessingAnimator.isRunning() == false) goto L27;
        if (this.mProcessingAnimator.getAnimatedValue() == null) goto L27;
        r11.save();
        Drawable r8 = this.mProgressBgDrawable;
        r8.setBounds(r4.getBounds());
        r8.setColorFilter(this.mProgressBackgroundColor, PorterDuff.Mode.SRC_IN);
        r8.draw(r11);
        r11.restore();
        r11.rotate(((Float) this.mProcessingAnimator.getAnimatedValue()).floatValue(), r1, r2);
        goto L27
    L19:
        int r9 = this.mWidth;
        int r10 = this.mCenterIconSize;
        r4.setBounds((r9 - r10) / 2, (r9 - r10) / 2, (r9 + r10) / 2, (r9 + r10) / 2);
        goto L21
    L8:
        if (this.mCurrentStateDrawableAlpha == 255) goto L14;
        if (noProgress(this.mLastState) == false) goto L12;
        int r12 = this.mWidth;
        r3.setBounds(0, 0, r12, r12);
    L13:
        r3.setAlpha(255 - this.mCurrentStateDrawableAlpha);
        r3.draw(r11);
        goto L14
    L12:
        int r13 = Math.min(r3.getIntrinsicWidth(), this.mCenterIconSize);
        int r14 = Math.min(r3.getIntrinsicHeight(), this.mCenterIconSize);
        int r15 = this.mWidth;
        r3.setBounds((r15 - r13) / 2, (r15 - r14) / 2, (r13 + r15) / 2, (r15 + r14) / 2);
        goto L13
    }

    @Override // android.view.View
    public void setPressed(boolean r1) {
        super.setPressed(r1);
        invalidate();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startProcessingAnim();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        cancelAlphaAnim();
        cancelProgressAnim();
        cancelProcessingAnim();
        super.onDetachedFromWindow();
    }

    private Drawable getCurrentStateDrawable() {
        return getStateDrawable(this.mCurrentState);
    }

    private Drawable getLastStateDrawable() {
        return getStateDrawable(this.mLastState);
    }

    private Drawable getStateDrawable(int r2) {
        if (r2 == 0) goto L20;
        if (r2 == 1) goto L26;
        if (r2 == 2) goto L25;
        if (r2 == 3) goto L24;
        if (r2 == 4) goto L23;
        if (r2 == 5) goto L22;
        return null;
    L22:
        return this.mFailedDrawable;
    L23:
        return this.mSucceedDrawable;
    L24:
        return this.mRetryDrawable;
    L25:
        return this.mPauseDrawable;
    L26:
        return this.mDownloadDrawable;
    L20:
        return this.mProcessingDrawable;
    }

    private void startShadowAlphaAnimation() {
        if (this.mAlphaAnimDuration > 0) goto L6;
        return;
    L6:
        if (this.mAlphaAnim != null) goto L9;
        ValueAnimator r0 = ValueAnimator.ofInt(new int[]{0, 255});
        this.mAlphaAnim = r0;
        r0.addUpdateListener(new AnonymousClass3(this));
        this.mAlphaAnim.setDuration(this.mAlphaAnimDuration);
    L9:
        if (isAlphaAnimRunning() == false) goto L11;
        cancelAlphaAnim();
    L11:
        this.mAlphaAnim.start();
    }

    public void setAlphaAnimationDuration(long r1) {
        this.mAlphaAnimDuration = r1;
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

    private void cancelProgressAnim() {
        this.mProgressAnimator.removeAllUpdateListeners();
        this.mProgressAnimator.cancel();
    }

    private void cancelProcessingAnim() {
        this.mProcessingAnimator.removeAllUpdateListeners();
        this.mProcessingAnimator.cancel();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.progress = this.mProgress;
        r1.currentState = this.mCurrentState;
        return r1;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r2) {
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        setCurrentState(r3.currentState);
        setProgress(r3.progress);
    }
}
