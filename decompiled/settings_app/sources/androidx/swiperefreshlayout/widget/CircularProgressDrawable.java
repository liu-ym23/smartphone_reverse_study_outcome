package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.util.Preconditions;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class CircularProgressDrawable extends Drawable implements Animatable {
    private static final int ANIMATION_DURATION = 1332;
    private static final int ARROW_HEIGHT = 5;
    private static final int ARROW_HEIGHT_LARGE = 6;
    private static final int ARROW_WIDTH = 10;
    private static final int ARROW_WIDTH_LARGE = 12;
    private static final float CENTER_RADIUS = 7.5f;
    private static final float CENTER_RADIUS_LARGE = 11.0f;
    private static final int[] COLORS = null;
    private static final float COLOR_CHANGE_OFFSET = 0.75f;
    public static final int DEFAULT = 1;
    private static final float GROUP_FULL_ROTATION = 216.0f;
    public static final int LARGE = 0;
    private static final Interpolator LINEAR_INTERPOLATOR = null;
    private static final Interpolator MATERIAL_INTERPOLATOR = null;
    private static final float MAX_PROGRESS_ARC = 0.8f;
    private static final float MIN_PROGRESS_ARC = 0.01f;
    private static final float RING_ROTATION = 0.20999998f;
    private static final float SHRINK_OFFSET = 0.5f;
    private static final float STROKE_WIDTH = 2.5f;
    private static final float STROKE_WIDTH_LARGE = 3.0f;
    private Animator mAnimator;
    boolean mFinishing;
    private Resources mResources;
    private final Ring mRing;
    private float mRotation;
    float mRotationCount;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ProgressDrawableSize {
    }

    private static class Ring {
        int mAlpha;
        Path mArrow;
        int mArrowHeight;
        final Paint mArrowPaint;
        float mArrowScale;
        int mArrowWidth;
        final Paint mCirclePaint;
        int mColorIndex;
        int[] mColors;
        int mCurrentColor;
        float mEndTrim;
        final Paint mPaint;
        float mRingCenterRadius;
        float mRotation;
        boolean mShowArrow;
        float mStartTrim;
        float mStartingEndTrim;
        float mStartingRotation;
        float mStartingStartTrim;
        float mStrokeWidth;
        final RectF mTempBounds;

        Ring() {
            this.mTempBounds = new RectF();
            Paint r0 = new Paint();
            this.mPaint = r0;
            Paint r1 = new Paint();
            this.mArrowPaint = r1;
            Paint r2 = new Paint();
            this.mCirclePaint = r2;
            this.mStartTrim = 0.0f;
            this.mEndTrim = 0.0f;
            this.mRotation = 0.0f;
            this.mStrokeWidth = 5.0f;
            this.mArrowScale = 1.0f;
            this.mAlpha = 255;
            r0.setStrokeCap(Paint.Cap.SQUARE);
            r0.setAntiAlias(true);
            r0.setStyle(Paint.Style.STROKE);
            r1.setStyle(Paint.Style.FILL);
            r1.setAntiAlias(true);
            r2.setColor(0);
        }

        void setArrowDimensions(float r1, float r2) {
            this.mArrowWidth = (int) r1;
            this.mArrowHeight = (int) r2;
        }

        void setStrokeCap(Paint.Cap r1) {
            this.mPaint.setStrokeCap(r1);
        }

        Paint.Cap getStrokeCap() {
            return this.mPaint.getStrokeCap();
        }

        float getArrowWidth() {
            return this.mArrowWidth;
        }

        float getArrowHeight() {
            return this.mArrowHeight;
        }

        void draw(Canvas r9, Rect r10) {
            RectF r6 = this.mTempBounds;
            float r0 = this.mRingCenterRadius;
            float r1 = (this.mStrokeWidth / 2.0f) + r0;
            if (r0 > 0.0f) goto L5;
            r1 = (Math.min(r10.width(), r10.height()) / 2.0f) - Math.max((this.mArrowWidth * this.mArrowScale) / 2.0f, this.mStrokeWidth / 2.0f);
        L5:
            r6.set(r10.centerX() - r1, r10.centerY() - r1, r10.centerX() + r1, r10.centerY() + r1);
            float r11 = this.mStartTrim;
            float r2 = this.mRotation;
            float r12 = (r11 + r2) * 360.0f;
            float r7 = ((this.mEndTrim + r2) * 360.0f) - r12;
            this.mPaint.setColor(this.mCurrentColor);
            this.mPaint.setAlpha(this.mAlpha);
            float r3 = this.mStrokeWidth / 2.0f;
            r6.inset(r3, r3);
            r9.drawCircle(r6.centerX(), r6.centerY(), r6.width() / 2.0f, this.mCirclePaint);
            float r4 = -r3;
            r6.inset(r4, r4);
            r9.drawArc(r6, r12, r7, false, this.mPaint);
            drawTriangle(r9, r12, r7, r6);
        }

        void drawTriangle(Canvas r8, float r9, float r10, RectF r11) {
            if (this.mShowArrow == false) goto L10;
            Path r0 = this.mArrow;
            if (r0 != null) goto L7;
            Path r1 = new Path();
            this.mArrow = r1;
            r1.setFillType(Path.FillType.EVEN_ODD);
        L8:
            float r2 = Math.min(r11.width(), r11.height()) / 2.0f;
            float r3 = (this.mArrowWidth * this.mArrowScale) / 2.0f;
            this.mArrow.moveTo(0.0f, 0.0f);
            this.mArrow.lineTo(this.mArrowWidth * this.mArrowScale, 0.0f);
            Path r4 = this.mArrow;
            float r5 = this.mArrowWidth;
            float r6 = this.mArrowScale;
            r4.lineTo((r5 * r6) / 2.0f, this.mArrowHeight * r6);
            this.mArrow.offset((r2 + r11.centerX()) - r3, r11.centerY() + (this.mStrokeWidth / 2.0f));
            this.mArrow.close();
            this.mArrowPaint.setColor(this.mCurrentColor);
            this.mArrowPaint.setAlpha(this.mAlpha);
            r8.save();
            r8.rotate(r9 + r10, r11.centerX(), r11.centerY());
            r8.drawPath(this.mArrow, this.mArrowPaint);
            r8.restore();
            return;
        L7:
            r0.reset();
            goto L8
        }

        void setColors(int[] r1) {
            this.mColors = r1;
            setColorIndex(0);
        }

        int[] getColors() {
            return this.mColors;
        }

        void setColor(int r1) {
            this.mCurrentColor = r1;
        }

        void setBackgroundColor(int r1) {
            this.mCirclePaint.setColor(r1);
        }

        int getBackgroundColor() {
            return this.mCirclePaint.getColor();
        }

        void setColorIndex(int r2) {
            this.mColorIndex = r2;
            this.mCurrentColor = this.mColors[r2];
        }

        int getNextColor() {
            return this.mColors[getNextColorIndex()];
        }

        int getNextColorIndex() {
            return (this.mColorIndex + 1) % this.mColors.length;
        }

        void goToNextColor() {
            setColorIndex(getNextColorIndex());
        }

        void setColorFilter(ColorFilter r1) {
            this.mPaint.setColorFilter(r1);
        }

        void setAlpha(int r1) {
            this.mAlpha = r1;
        }

        int getAlpha() {
            return this.mAlpha;
        }

        void setStrokeWidth(float r1) {
            this.mStrokeWidth = r1;
            this.mPaint.setStrokeWidth(r1);
        }

        float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        void setStartTrim(float r1) {
            this.mStartTrim = r1;
        }

        float getStartTrim() {
            return this.mStartTrim;
        }

        float getStartingStartTrim() {
            return this.mStartingStartTrim;
        }

        float getStartingEndTrim() {
            return this.mStartingEndTrim;
        }

        int getStartingColor() {
            return this.mColors[this.mColorIndex];
        }

        void setEndTrim(float r1) {
            this.mEndTrim = r1;
        }

        float getEndTrim() {
            return this.mEndTrim;
        }

        void setRotation(float r1) {
            this.mRotation = r1;
        }

        float getRotation() {
            return this.mRotation;
        }

        void setCenterRadius(float r1) {
            this.mRingCenterRadius = r1;
        }

        float getCenterRadius() {
            return this.mRingCenterRadius;
        }

        void setShowArrow(boolean r2) {
            if (this.mShowArrow == r2) goto L6;
            this.mShowArrow = r2;
            return;
        }

        boolean getShowArrow() {
            return this.mShowArrow;
        }

        void setArrowScale(float r2) {
            if (r2 == this.mArrowScale) goto L6;
            this.mArrowScale = r2;
            return;
        }

        float getArrowScale() {
            return this.mArrowScale;
        }

        float getStartingRotation() {
            return this.mStartingRotation;
        }

        void storeOriginals() {
            this.mStartingStartTrim = this.mStartTrim;
            this.mStartingEndTrim = this.mEndTrim;
            this.mStartingRotation = this.mRotation;
        }

        void resetOriginals() {
            this.mStartingStartTrim = 0.0f;
            this.mStartingEndTrim = 0.0f;
            this.mStartingRotation = 0.0f;
            setStartTrim(0.0f);
            setEndTrim(0.0f);
            setRotation(0.0f);
        }
    }

    private int evaluateColorChange(float r6, int r7, int r8) {
        int r5 = (r7 >> 24) & 255;
        int r0 = (r7 >> 16) & 255;
        int r1 = (r7 >> 8) & 255;
        int r9 = r7 & 255;
        return ((((r5 + ((int) ((((r8 >> 24) & 255) - r5) * r6))) << 24) | ((r0 + ((int) ((((r8 >> 16) & 255) - r0) * r6))) << 16)) | ((r1 + ((int) ((((r8 >> 8) & 255) - r1) * r6))) << 8)) | (r9 + ((int) (r6 * ((r8 & 255) - r9))));
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    static {
        LINEAR_INTERPOLATOR = new LinearInterpolator();
        MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();
        COLORS = new int[]{-16777216};
    }

    public CircularProgressDrawable(Context r2) {
        this.mResources = ((Context) Preconditions.checkNotNull(r2)).getResources();
        Ring r3 = new Ring();
        this.mRing = r3;
        r3.setColors(COLORS);
        setStrokeWidth(STROKE_WIDTH);
        setupAnimators();
    }

    private void setSizeParameters(float r2, float r3, float r4, float r5) {
        Ring r0 = this.mRing;
        float r1 = this.mResources.getDisplayMetrics().density;
        r0.setStrokeWidth(r3 * r1);
        r0.setCenterRadius(r2 * r1);
        r0.setColorIndex(0);
        r0.setArrowDimensions(r4 * r1, r5 * r1);
    }

    public void setStyle(int r4) {
        if (r4 != 0) goto L4;
        setSizeParameters(CENTER_RADIUS_LARGE, 3.0f, 12.0f, 6.0f);
    L5:
        invalidateSelf();
        return;
    L4:
        setSizeParameters(CENTER_RADIUS, STROKE_WIDTH, 10.0f, 5.0f);
        goto L5
    }

    public float getStrokeWidth() {
        return this.mRing.getStrokeWidth();
    }

    public void setStrokeWidth(float r2) {
        this.mRing.setStrokeWidth(r2);
        invalidateSelf();
    }

    public float getCenterRadius() {
        return this.mRing.getCenterRadius();
    }

    public void setCenterRadius(float r2) {
        this.mRing.setCenterRadius(r2);
        invalidateSelf();
    }

    public void setStrokeCap(Paint.Cap r2) {
        this.mRing.setStrokeCap(r2);
        invalidateSelf();
    }

    public Paint.Cap getStrokeCap() {
        return this.mRing.getStrokeCap();
    }

    public float getArrowWidth() {
        return this.mRing.getArrowWidth();
    }

    public float getArrowHeight() {
        return this.mRing.getArrowHeight();
    }

    public void setArrowDimensions(float r2, float r3) {
        this.mRing.setArrowDimensions(r2, r3);
        invalidateSelf();
    }

    public boolean getArrowEnabled() {
        return this.mRing.getShowArrow();
    }

    public void setArrowEnabled(boolean r2) {
        this.mRing.setShowArrow(r2);
        invalidateSelf();
    }

    public float getArrowScale() {
        return this.mRing.getArrowScale();
    }

    public void setArrowScale(float r2) {
        this.mRing.setArrowScale(r2);
        invalidateSelf();
    }

    public float getStartTrim() {
        return this.mRing.getStartTrim();
    }

    public float getEndTrim() {
        return this.mRing.getEndTrim();
    }

    public void setStartEndTrim(float r2, float r3) {
        this.mRing.setStartTrim(r2);
        this.mRing.setEndTrim(r3);
        invalidateSelf();
    }

    public float getProgressRotation() {
        return this.mRing.getRotation();
    }

    public void setProgressRotation(float r2) {
        this.mRing.setRotation(r2);
        invalidateSelf();
    }

    public int getBackgroundColor() {
        return this.mRing.getBackgroundColor();
    }

    public void setBackgroundColor(int r2) {
        this.mRing.setBackgroundColor(r2);
        invalidateSelf();
    }

    public int[] getColorSchemeColors() {
        return this.mRing.getColors();
    }

    public void setColorSchemeColors(int... r2) {
        this.mRing.setColors(r2);
        this.mRing.setColorIndex(0);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r5) {
        Rect r0 = getBounds();
        r5.save();
        r5.rotate(this.mRotation, r0.exactCenterX(), r0.exactCenterY());
        this.mRing.draw(r5, r0);
        r5.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        this.mRing.setAlpha(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mRing.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.mRing.setColorFilter(r2);
        invalidateSelf();
    }

    private void setRotation(float r1) {
        this.mRotation = r1;
    }

    private float getRotation() {
        return this.mRotation;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mAnimator.isRunning();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.mAnimator.cancel();
        this.mRing.storeOriginals();
        if (this.mRing.getEndTrim() == this.mRing.getStartTrim()) goto L5;
        this.mFinishing = true;
        this.mAnimator.setDuration(666);
        this.mAnimator.start();
        return;
    L5:
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
        this.mAnimator.setDuration(1332);
        this.mAnimator.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.mAnimator.cancel();
        setRotation(0.0f);
        this.mRing.setShowArrow(false);
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
        invalidateSelf();
    }

    void updateRingColor(float r3, Ring r4) {
        if (r3 <= 0.75f) goto L5;
        r4.setColor(evaluateColorChange((r3 - 0.75f) / 0.25f, r4.getStartingColor(), r4.getNextColor()));
        return;
    L5:
        r4.setColor(r4.getStartingColor());
    }

    private void applyFinishTranslation(float r5, Ring r6) {
        updateRingColor(r5, r6);
        float r4 = (float) (Math.floor(r6.getStartingRotation() / 0.8f) + 1.0d);
        r6.setStartTrim(r6.getStartingStartTrim() + (((r6.getStartingEndTrim() - 0.01f) - r6.getStartingStartTrim()) * r5));
        r6.setEndTrim(r6.getStartingEndTrim());
        r6.setRotation(r6.getStartingRotation() + ((r4 - r6.getStartingRotation()) * r5));
    }

    void applyTransformation(float r8, Ring r9, boolean r10) {
        if (this.mFinishing == false) goto L6;
        applyFinishTranslation(r8, r9);
        return;
    L6:
        if (r8 != 1.0f) goto L8;
        if (r10 == true) goto L8;
        return;
    L8:
        float r11 = r9.getStartingRotation();
        if (r8 >= 0.5f) goto L11;
        float r1 = r9.getStartingStartTrim();
        Interpolator r2 = MATERIAL_INTERPOLATOR;
        float r0 = ((r2.getInterpolation(r8 / 0.5f) * 0.79f) + 0.01f) + r1;
    L12:
        float r12 = r11 + (RING_ROTATION * r8);
        float r13 = (r8 + this.mRotationCount) * GROUP_FULL_ROTATION;
        r9.setStartTrim(r1);
        r9.setEndTrim(r0);
        r9.setRotation(r12);
        setRotation(r13);
        return;
    L11:
        float r3 = r9.getStartingStartTrim() + 0.79f;
        Interpolator r5 = MATERIAL_INTERPOLATOR;
        r1 = r3 - (((1.0f - r5.getInterpolation((r8 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
        r0 = r3;
        goto L12
    }

    private void setupAnimators() {
        final Ring r0 = this.mRing;
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r1.addUpdateListener(new AnonymousClass1(this, r0));
        r1.setRepeatCount(-1);
        r1.setRepeatMode(1);
        r1.setInterpolator(LINEAR_INTERPOLATOR);
        r1.addListener(new AnonymousClass2(this, r0));
        this.mAnimator = r1;
    }
}
