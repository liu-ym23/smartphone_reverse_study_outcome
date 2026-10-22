package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

/* JADX INFO: loaded from: classes.dex */
public abstract class RoundedBitmapDrawable extends Drawable {
    private static final int DEFAULT_PAINT_FLAGS = 3;
    private boolean mApplyGravity;
    final Bitmap mBitmap;
    private int mBitmapHeight;
    private final BitmapShader mBitmapShader;
    private int mBitmapWidth;
    private float mCornerRadius;
    final Rect mDstRect;
    private final RectF mDstRectF;
    private int mGravity;
    private boolean mIsCircular;
    private final Paint mPaint;
    private final Matrix mShaderMatrix;
    private int mTargetDensity;

    private static boolean isGreaterThanZero(float r1) {
        if (r1 <= 0.05f) goto L5;
        return true;
    L5:
        return false;
    }

    public final Paint getPaint() {
        return this.mPaint;
    }

    public final Bitmap getBitmap() {
        return this.mBitmap;
    }

    private void computeBitmapSize() {
        this.mBitmapWidth = this.mBitmap.getScaledWidth(this.mTargetDensity);
        this.mBitmapHeight = this.mBitmap.getScaledHeight(this.mTargetDensity);
    }

    public void setTargetDensity(Canvas r1) {
        setTargetDensity(r1.getDensity());
    }

    public void setTargetDensity(DisplayMetrics r1) {
        setTargetDensity(r1.densityDpi);
    }

    public void setTargetDensity(int r2) {
        if (this.mTargetDensity == r2) goto L11;
        if (r2 != 0) goto L6;
        r2 = 160;
    L6:
        this.mTargetDensity = r2;
        if (this.mBitmap == null) goto L9;
        computeBitmapSize();
    L9:
        invalidateSelf();
        return;
    }

    public int getGravity() {
        return this.mGravity;
    }

    public void setGravity(int r2) {
        if (this.mGravity == r2) goto L6;
        this.mGravity = r2;
        this.mApplyGravity = true;
        invalidateSelf();
        return;
    }

    public void setMipMap(boolean r1) {
        throw new UnsupportedOperationException();
    }

    public boolean hasMipMap() {
        throw new UnsupportedOperationException();
    }

    public void setAntiAlias(boolean r2) {
        this.mPaint.setAntiAlias(r2);
        invalidateSelf();
    }

    public boolean hasAntiAlias() {
        return this.mPaint.isAntiAlias();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean r2) {
        this.mPaint.setFilterBitmap(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean r2) {
        this.mPaint.setDither(r2);
        invalidateSelf();
    }

    void gravityCompatApply(int r1, int r2, int r3, Rect r4, Rect r5) {
        throw new UnsupportedOperationException();
    }

    void updateDstRect() {
        if (this.mApplyGravity == true) goto L5;
        return;
    L5:
        if (this.mIsCircular == false) goto L7;
        int r6 = Math.min(this.mBitmapWidth, this.mBitmapHeight);
        gravityCompatApply(this.mGravity, r6, r6, getBounds(), this.mDstRect);
        int r0 = Math.min(this.mDstRect.width(), this.mDstRect.height());
        this.mDstRect.inset(Math.max(0, (this.mDstRect.width() - r0) / 2), Math.max(0, (this.mDstRect.height() - r0) / 2));
        this.mCornerRadius = r0 * 0.5f;
    L8:
        this.mDstRectF.set(this.mDstRect);
        if (this.mBitmapShader == null) goto L11;
        this.mShaderMatrix.setTranslate(this.mDstRectF.left, this.mDstRectF.top);
        this.mShaderMatrix.preScale(this.mDstRectF.width() / this.mBitmap.getWidth(), this.mDstRectF.height() / this.mBitmap.getHeight());
        this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
        this.mPaint.setShader(this.mBitmapShader);
    L11:
        this.mApplyGravity = false;
        return;
    L7:
        gravityCompatApply(this.mGravity, this.mBitmapWidth, this.mBitmapHeight, getBounds(), this.mDstRect);
        goto L8
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r4) {
        Bitmap r0 = this.mBitmap;
        if (r0 != null) goto L5;
        return;
    L5:
        updateDstRect();
        if (this.mPaint.getShader() != null) goto L8;
        r4.drawBitmap(r0, null, this.mDstRect, this.mPaint);
        return;
    L8:
        RectF r1 = this.mDstRectF;
        float r2 = this.mCornerRadius;
        r4.drawRoundRect(r1, r2, r2, this.mPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        if (r2 == this.mPaint.getAlpha()) goto L6;
        this.mPaint.setAlpha(r2);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mPaint.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.mPaint.setColorFilter(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.mPaint.getColorFilter();
    }

    public void setCircular(boolean r2) {
        this.mIsCircular = r2;
        this.mApplyGravity = true;
        if (r2 == false) goto L5;
        updateCircularCornerRadius();
        this.mPaint.setShader(this.mBitmapShader);
        invalidateSelf();
        return;
    L5:
        setCornerRadius(0.0f);
    }

    private void updateCircularCornerRadius() {
        this.mCornerRadius = Math.min(this.mBitmapHeight, this.mBitmapWidth) / 2;
    }

    public boolean isCircular() {
        return this.mIsCircular;
    }

    public void setCornerRadius(float r3) {
        if (this.mCornerRadius != r3) goto L5;
        return;
    L5:
        this.mIsCircular = false;
        if (isGreaterThanZero(r3) == false) goto L8;
        this.mPaint.setShader(this.mBitmapShader);
    L9:
        this.mCornerRadius = r3;
        invalidateSelf();
        return;
    L8:
        this.mPaint.setShader(null);
        goto L9
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r1) {
        super.onBoundsChange(r1);
        if (this.mIsCircular == false) goto L5;
        updateCircularCornerRadius();
    L5:
        this.mApplyGravity = true;
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.mGravity == 119) goto L5;
        return -3;
    L5:
        if (this.mIsCircular == true) goto L22;
        Bitmap r0 = this.mBitmap;
        if (r0 != null) goto L10;
        return -3;
    L10:
        if (r0.hasAlpha() == false) goto L12;
        return -3;
    L12:
        if (this.mPaint.getAlpha() >= 255) goto L14;
        return -3;
    L14:
        if (isGreaterThanZero(this.mCornerRadius) == true) goto L23;
        return -1;
    L23:
        return -3;
    L22:
        return -3;
    }

    RoundedBitmapDrawable(Resources r3, Bitmap r4) {
        this.mTargetDensity = 160;
        this.mGravity = 119;
        this.mPaint = new Paint(3);
        this.mShaderMatrix = new Matrix();
        this.mDstRect = new Rect();
        this.mDstRectF = new RectF();
        this.mApplyGravity = true;
        if (r3 == null) goto L5;
        this.mTargetDensity = r3.getDisplayMetrics().densityDpi;
    L5:
        this.mBitmap = r4;
        if (r4 == null) goto L8;
        computeBitmapSize();
        this.mBitmapShader = new BitmapShader(r4, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        return;
    L8:
        this.mBitmapHeight = -1;
        this.mBitmapWidth = -1;
        this.mBitmapShader = null;
    }
}
