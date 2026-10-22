package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.DrawableCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class DrawerArrowDrawable extends Drawable {
    public static final int ARROW_DIRECTION_END = 3;
    public static final int ARROW_DIRECTION_LEFT = 0;
    public static final int ARROW_DIRECTION_RIGHT = 1;
    public static final int ARROW_DIRECTION_START = 2;
    private static final float ARROW_HEAD_ANGLE = 0.0f;
    private float mArrowHeadLength;
    private float mArrowShaftLength;
    private float mBarGap;
    private float mBarLength;
    private int mDirection;
    private float mMaxCutForBarSize;
    private final Paint mPaint;
    private final Path mPath;
    private float mProgress;
    private final int mSize;
    private boolean mSpin;
    private boolean mVerticalMirror;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ArrowDirection {
    }

    static {
        ARROW_HEAD_ANGLE = (float) Math.toRadians(45.0d);
    }

    public DrawerArrowDrawable(Context r7) {
        Paint r0 = new Paint();
        this.mPaint = r0;
        this.mPath = new Path();
        this.mVerticalMirror = false;
        this.mDirection = 2;
        r0.setStyle(Paint.Style.STROKE);
        r0.setStrokeJoin(Paint.Join.MITER);
        r0.setStrokeCap(Paint.Cap.BUTT);
        r0.setAntiAlias(true);
        TypedArray r8 = r7.getTheme().obtainStyledAttributes(null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        setColor(r8.getColor(R.styleable.DrawerArrowToggle_color, 0));
        setBarThickness(r8.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0f));
        setSpinEnabled(r8.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true));
        setGapSize(Math.round(r8.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.mSize = r8.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.mBarLength = Math.round(r8.getDimension(R.styleable.DrawerArrowToggle_barLength, 0.0f));
        this.mArrowHeadLength = Math.round(r8.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.mArrowShaftLength = r8.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        r8.recycle();
    }

    private static float lerp(float r0, float r1, float r2) {
        return r0 + ((r1 - r0) * r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r19) {
        Rect r2 = getBounds();
        int r3 = this.mDirection;
        boolean r4 = false;
        if (r3 == 0) goto L13;
        if (r3 != 1) goto L6;
    L12:
        r4 = true;
        goto L13
    L6:
        if (r3 == 3) goto L11;
        if (DrawableCompat.getLayoutDirection(this) != 1) goto L13;
    L11:
        if (DrawableCompat.getLayoutDirection(this) == 0) goto L12;
    L13:
        float r5 = this.mArrowHeadLength;
        float r6 = lerp(this.mBarLength, (float) Math.sqrt((r5 * r5) * 2.0f), this.mProgress);
        float r7 = lerp(this.mBarLength, this.mArrowShaftLength, this.mProgress);
        float r8 = Math.round(lerp(0.0f, this.mMaxCutForBarSize, this.mProgress));
        float r9 = lerp(0.0f, ARROW_HEAD_ANGLE, this.mProgress);
        if (r4 == false) goto L16;
        float r11 = 0.0f;
    L18:
        if (r4 == false) goto L20;
        float r13 = 180.0f;
    L21:
        float r12 = lerp(r11, r13, this.mProgress);
        double r14 = r6;
        double r10 = r9;
        boolean r15 = r4;
        float r16 = Math.round(Math.cos(r10) * r14);
        float r17 = Math.round(r14 * Math.sin(r10));
        this.mPath.rewind();
        float r18 = lerp(this.mBarGap + this.mPaint.getStrokeWidth(), -this.mMaxCutForBarSize, this.mProgress);
        float r110 = (-r7) / 2.0f;
        this.mPath.moveTo(r110 + r8, 0.0f);
        this.mPath.rLineTo(r7 - (r8 * 2.0f), 0.0f);
        this.mPath.moveTo(r110, r18);
        this.mPath.rLineTo(r16, r17);
        this.mPath.moveTo(r110, -r18);
        this.mPath.rLineTo(r16, -r17);
        this.mPath.close();
        r19.save();
        float r20 = this.mPaint.getStrokeWidth();
        float r21 = r2.height() - (3.0f * r20);
        float r22 = this.mBarGap;
        r19.translate(r2.centerX(), ((((int) (r21 - (2.0f * r22))) / 4) * 2) + ((r20 * 1.5f) + r22));
        if (this.mSpin == true) goto L24;
        if (r15 == false) goto L30;
        r19.rotate(180.0f);
    L30:
        r19.drawPath(this.mPath, this.mPaint);
        r19.restore();
        return;
    L24:
        if ((this.mVerticalMirror ^ r15) == false) goto L26;
        int r23 = -1;
    L27:
        r19.rotate(r12 * r23);
        goto L30
    L26:
        r23 = 1;
        goto L27
    L20:
        r13 = 0.0f;
        goto L21
    L16:
        r11 = -180.0f;
        goto L18
    }

    public float getArrowHeadLength() {
        return this.mArrowHeadLength;
    }

    public float getArrowShaftLength() {
        return this.mArrowShaftLength;
    }

    public float getBarLength() {
        return this.mBarLength;
    }

    public float getBarThickness() {
        return this.mPaint.getStrokeWidth();
    }

    @ColorInt
    public int getColor() {
        return this.mPaint.getColor();
    }

    public int getDirection() {
        return this.mDirection;
    }

    public float getGapSize() {
        return this.mBarGap;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mSize;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mSize;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final Paint getPaint() {
        return this.mPaint;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.mProgress;
    }

    public boolean isSpinEnabled() {
        return this.mSpin;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        if (r2 == this.mPaint.getAlpha()) goto L6;
        this.mPaint.setAlpha(r2);
        invalidateSelf();
        return;
    }

    public void setArrowHeadLength(float r2) {
        if (this.mArrowHeadLength == r2) goto L6;
        this.mArrowHeadLength = r2;
        invalidateSelf();
        return;
    }

    public void setArrowShaftLength(float r2) {
        if (this.mArrowShaftLength == r2) goto L6;
        this.mArrowShaftLength = r2;
        invalidateSelf();
        return;
    }

    public void setBarLength(float r2) {
        if (this.mBarLength == r2) goto L6;
        this.mBarLength = r2;
        invalidateSelf();
        return;
    }

    public void setBarThickness(float r5) {
        if (this.mPaint.getStrokeWidth() == r5) goto L6;
        this.mPaint.setStrokeWidth(r5);
        this.mMaxCutForBarSize = (float) (((double) (r5 / 2.0f)) * Math.cos(ARROW_HEAD_ANGLE));
        invalidateSelf();
        return;
    }

    public void setColor(@ColorInt int r2) {
        if (r2 == this.mPaint.getColor()) goto L6;
        this.mPaint.setColor(r2);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.mPaint.setColorFilter(r2);
        invalidateSelf();
    }

    public void setDirection(int r2) {
        if (r2 == this.mDirection) goto L6;
        this.mDirection = r2;
        invalidateSelf();
        return;
    }

    public void setGapSize(float r2) {
        if (r2 == this.mBarGap) goto L6;
        this.mBarGap = r2;
        invalidateSelf();
        return;
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float r2) {
        if (this.mProgress == r2) goto L6;
        this.mProgress = r2;
        invalidateSelf();
        return;
    }

    public void setSpinEnabled(boolean r2) {
        if (this.mSpin == r2) goto L6;
        this.mSpin = r2;
        invalidateSelf();
        return;
    }

    public void setVerticalMirror(boolean r2) {
        if (this.mVerticalMirror == r2) goto L6;
        this.mVerticalMirror = r2;
        invalidateSelf();
        return;
    }
}
