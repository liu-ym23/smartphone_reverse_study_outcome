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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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

    public RoundedBitmapDrawable(Resources r3, Bitmap r4) {
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
        Shader.TileMode r0 = Shader.TileMode.CLAMP;
        this.mBitmapShader = new BitmapShader(r4, r0, r0);
        return;
    L8:
        this.mBitmapHeight = -1;
        this.mBitmapWidth = -1;
        this.mBitmapShader = null;
    }

    private void computeBitmapSize() {
        this.mBitmapWidth = this.mBitmap.getScaledWidth(this.mTargetDensity);
        this.mBitmapHeight = this.mBitmap.getScaledHeight(this.mTargetDensity);
    }

    private static boolean isGreaterThanZero(float r1) {
        if (r1 <= 0.05f) goto L5;
        return true;
    L5:
        return false;
    }

    private void updateCircularCornerRadius() {
        this.mCornerRadius = Math.min(this.mBitmapHeight, this.mBitmapWidth) / 2;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r4) {
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
    public int getAlpha() {
        return this.mPaint.getAlpha();
    }

    @Nullable
    public final Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.mPaint.getColorFilter();
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    public int getGravity() {
        return this.mGravity;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
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

    @NonNull
    public final Paint getPaint() {
        return this.mPaint;
    }

    public void gravityCompatApply(int r1, int r2, int r3, Rect r4, Rect r5) {
        throw new UnsupportedOperationException();
    }

    public boolean hasAntiAlias() {
        return this.mPaint.isAntiAlias();
    }

    public boolean hasMipMap() {
        throw new UnsupportedOperationException();
    }

    public boolean isCircular() {
        return this.mIsCircular;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r1) {
        super.onBoundsChange(r1);
        if (this.mIsCircular == false) goto L5;
        updateCircularCornerRadius();
    L5:
        this.mApplyGravity = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        if (r2 == this.mPaint.getAlpha()) goto L6;
        this.mPaint.setAlpha(r2);
        invalidateSelf();
        return;
    }

    public void setAntiAlias(boolean r2) {
        this.mPaint.setAntiAlias(r2);
        invalidateSelf();
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

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.mPaint.setColorFilter(r2);
        invalidateSelf();
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
    public void setDither(boolean r2) {
        this.mPaint.setDither(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean r2) {
        this.mPaint.setFilterBitmap(r2);
        invalidateSelf();
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

    public void setTargetDensity(@NonNull Canvas r1) {
        setTargetDensity(r1.getDensity());
    }

    public void updateDstRect() {
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
        Matrix r1 = this.mShaderMatrix;
        RectF r2 = this.mDstRectF;
        r1.setTranslate(r2.left, r2.top);
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

    public void setTargetDensity(@NonNull DisplayMetrics r1) {
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
}
