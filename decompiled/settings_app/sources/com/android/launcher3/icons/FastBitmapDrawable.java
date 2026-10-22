package com.android.launcher3.icons;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.FloatProperty;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: classes.dex */
public class FastBitmapDrawable extends Drawable implements Drawable.Callback {
    private static final Interpolator ACCEL = null;
    public static final int CLICK_FEEDBACK_DURATION = 200;
    private static final Interpolator DEACCEL = null;
    private static final float DISABLED_BRIGHTNESS = 0.5f;
    private static final float DISABLED_DESATURATION = 1.0f;
    protected static final int FULLY_OPAQUE = 255;
    protected static final float HOVERED_SCALE = 1.1f;
    private static final Interpolator HOVER_EMPHASIZED_DECELERATE_INTERPOLATOR = null;
    public static final int HOVER_FEEDBACK_DURATION = 300;
    protected static final float PRESSED_SCALE = 1.1f;
    protected static final FloatProperty<FastBitmapDrawable> SCALE = null;
    public static final int WHITE_SCRIM_ALPHA = 138;
    private static boolean sFlagHoverEnabled;
    private int mAlpha;
    private Drawable mBadge;
    protected final Bitmap mBitmap;
    private ColorFilter mColorFilter;
    int mCreationFlags;
    float mDisabledAlpha;
    protected final int mIconColor;
    protected boolean mIsDisabled;
    protected boolean mIsHovered;
    protected boolean mIsPressed;
    protected final Paint mPaint;
    private float mScale;
    protected ObjectAnimator mScaleAnimation;

    protected static class FastBitmapConstantState extends Drawable.ConstantState {
        private Drawable.ConstantState mBadgeConstantState;
        protected final Bitmap mBitmap;
        int mCreationFlags;
        protected final int mIconColor;
        protected boolean mIsDisabled;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        static /* synthetic */ Drawable.ConstantState access$102(FastBitmapConstantState r0, Drawable.ConstantState r1) {
            r0.mBadgeConstantState = r1;
            return r1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public /* bridge */ /* synthetic */ Drawable newDrawable() {
            return newDrawable();
        }

        public FastBitmapConstantState(Bitmap r2, int r3) {
            this.mCreationFlags = 0;
            this.mBitmap = r2;
            this.mIconColor = r3;
        }

        protected FastBitmapDrawable createDrawable() {
            return new FastBitmapDrawable(this.mBitmap, this.mIconColor);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final FastBitmapDrawable newDrawable() {
            FastBitmapDrawable r0 = createDrawable();
            r0.setIsDisabled(this.mIsDisabled);
            Drawable.ConstantState r1 = this.mBadgeConstantState;
            if (r1 == null) goto L5;
            r0.setBadge(r1.newDrawable());
        L5:
            r0.mCreationFlags = this.mCreationFlags;
            return r0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    public boolean isThemed() {
        return false;
    }

    static /* synthetic */ float access$000(FastBitmapDrawable r0) {
        return r0.mScale;
    }

    static /* synthetic */ float access$002(FastBitmapDrawable r0, float r1) {
        r0.mScale = r1;
        return r1;
    }

    static {
        ACCEL = new AccelerateInterpolator();
        DEACCEL = new DecelerateInterpolator();
        HOVER_EMPHASIZED_DECELERATE_INTERPOLATOR = new PathInterpolator(0.05f, 0.7f, 0.1f, 1.0f);
        sFlagHoverEnabled = false;
        final String r1 = "scale";
        SCALE = new AnonymousClass1(r1);
    }

    public FastBitmapDrawable(Bitmap r2) {
        this(r2, 0);
    }

    public FastBitmapDrawable(BitmapInfo r2) {
        this(r2.icon, r2.color);
    }

    protected FastBitmapDrawable(Bitmap r3, int r4) {
        this.mPaint = new Paint(3);
        this.mDisabledAlpha = 1.0f;
        this.mCreationFlags = 0;
        this.mScale = 1.0f;
        this.mAlpha = 255;
        this.mBitmap = r3;
        this.mIconColor = r4;
        setFilterBitmap(true);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r1) {
        super.onBoundsChange(r1);
        updateBadgeBounds(r1);
    }

    private void updateBadgeBounds(Rect r1) {
        Drawable r0 = this.mBadge;
        if (r0 == null) goto L6;
        setBadgeBounds(r0, r1);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r6) {
        if (this.mScale == 1.0f) goto L8;
        int r0 = r6.save();
        Rect r1 = getBounds();
        float r2 = this.mScale;
        r6.scale(r2, r2, r1.exactCenterX(), r1.exactCenterY());
        drawInternal(r6, r1);
        Drawable r5 = this.mBadge;
        if (r5 == null) goto L7;
        r5.draw(r6);
    L7:
        r6.restoreToCount(r0);
        return;
    L8:
        drawInternal(r6, getBounds());
        Drawable r7 = this.mBadge;
        if (r7 == null) goto L13;
        r7.draw(r6);
        return;
    }

    protected void drawInternal(Canvas r3, Rect r4) {
        r3.drawBitmap(this.mBitmap, null, r4, this.mPaint);
    }

    public int getIconColor() {
        return ColorUtils.compositeColors(GraphicsUtils.setColorAlphaBound(-1, 138), this.mIconColor);
    }

    public boolean isCreatedForTheme() {
        if (isThemed() == false) goto L5;
        return true;
    L5:
        if ((this.mCreationFlags & 1) != 0) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
        this.mColorFilter = r1;
        updateFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        if (this.mAlpha == r2) goto L8;
        this.mAlpha = r2;
        this.mPaint.setAlpha(r2);
        invalidateSelf();
        Drawable r1 = this.mBadge;
        if (r1 == null) goto L9;
        r1.setAlpha(r2);
        return;
    L9:
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean r2) {
        this.mPaint.setFilterBitmap(r2);
        this.mPaint.setAntiAlias(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    public void resetScale() {
        ObjectAnimator r0 = this.mScaleAnimation;
        if (r0 == null) goto L5;
        r0.cancel();
        this.mScaleAnimation = null;
    L5:
        this.mScale = 1.0f;
        invalidateSelf();
    }

    public float getAnimatedScale() {
        if (this.mScaleAnimation != null) goto L6;
        return 1.0f;
    L6:
        return this.mScale;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mBitmap.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mBitmap.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return getBounds().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return getBounds().height();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.mPaint.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] r9) {
        int r0 = r9.length;
        int r2 = 0;
        boolean r3 = false;
    L4:
        if (r2 >= r0) goto L14;
        int r5 = r9[r2];
        if (r5 == 16842919) goto L7;
        if (sFlagHoverEnabled == false) goto L13;
        if (r5 != 16843623) goto L13;
        r3 = true;
    L13:
        r2 = r2 + 1;
        goto L4
    L7:
        boolean r10 = true;
    L16:
        if (this.mIsPressed == r10) goto L18;
    L21:
        ObjectAnimator r1 = this.mScaleAnimation;
        if (r1 == null) goto L24;
        r1.cancel();
    L24:
        float r4 = 1.1f;
        if (r10 == true) goto L31;
        if (r3 == true) goto L31;
        r4 = 1.0f;
    L31:
        if (this.mScale != r4) goto L33;
    L45:
        this.mIsPressed = r10;
        this.mIsHovered = r3;
        return true;
    L33:
        if (isVisible() == false) goto L44;
        boolean r6 = this.mIsPressed;
        if (r10 == r6) goto L39;
        if (r10 == false) goto L38;
        Interpolator r7 = ACCEL;
    L40:
        if (r10 == r6) goto L42;
        int r8 = 200;
    L43:
        ObjectAnimator r11 = ObjectAnimator.ofFloat(this, SCALE, new float[]{r4});
        this.mScaleAnimation = r11;
        r11.setDuration(r8);
        this.mScaleAnimation.setInterpolator(r7);
        this.mScaleAnimation.start();
        goto L45
    L42:
        r8 = 300;
        goto L43
    L38:
        r7 = DEACCEL;
        goto L40
    L39:
        r7 = HOVER_EMPHASIZED_DECELERATE_INTERPOLATOR;
        goto L40
    L44:
        this.mScale = r4;
        invalidateSelf();
        goto L45
    L18:
        if (this.mIsHovered != r3) goto L21;
        return false;
    L14:
        r10 = false;
        goto L16
    }

    public void setIsDisabled(boolean r2) {
        if (this.mIsDisabled == r2) goto L6;
        this.mIsDisabled = r2;
        updateFilter();
        return;
    }

    protected boolean isDisabled() {
        return this.mIsDisabled;
    }

    public void setBadge(Drawable r3) {
        Drawable r0 = this.mBadge;
        if (r0 == null) goto L5;
        r0.setCallback(null);
    L5:
        this.mBadge = r3;
        if (r3 == null) goto L8;
        r3.setCallback(this);
    L8:
        updateBadgeBounds(getBounds());
        updateFilter();
    }

    public Drawable getBadge() {
        return this.mBadge;
    }

    protected void updateFilter() {
        Paint r0 = this.mPaint;
        if (this.mIsDisabled == false) goto L5;
        ColorFilter r1 = getDisabledColorFilter(this.mDisabledAlpha);
    L6:
        r0.setColorFilter(r1);
        Drawable r2 = this.mBadge;
        if (r2 == null) goto L9;
        r2.setColorFilter(getColorFilter());
    L9:
        invalidateSelf();
        return;
    L5:
        r1 = this.mColorFilter;
        goto L6
    }

    protected FastBitmapConstantState newConstantState() {
        return new FastBitmapConstantState(this.mBitmap, this.mIconColor);
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        FastBitmapConstantState r0 = newConstantState();
        r0.mIsDisabled = this.mIsDisabled;
        Drawable r1 = this.mBadge;
        if (r1 == null) goto L5;
        FastBitmapConstantState.access$102(r0, r1.getConstantState());
    L5:
        r0.mCreationFlags = this.mCreationFlags;
        return r0;
    }

    public static ColorFilter getDisabledColorFilter() {
        return getDisabledColorFilter(1.0f);
    }

    public boolean hasBadge() {
        if ((this.mCreationFlags & 2) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static ColorFilter getDisabledColorFilter(float r5) {
        ColorMatrix r0 = new ColorMatrix();
        ColorMatrix r1 = new ColorMatrix();
        r1.setSaturation(0.0f);
        float[] r2 = r0.getArray();
        r2[0] = 0.5f;
        r2[6] = 0.5f;
        r2[12] = 0.5f;
        float r3 = 127;
        r2[4] = r3;
        r2[9] = r3;
        r2[14] = r3;
        r2[18] = r5;
        r1.preConcat(r0);
        return new ColorMatrixColorFilter(r1);
    }

    protected static final int getDisabledColor(int r2) {
        int r3 = Math.min(Math.round(((((Color.red(r2) + Color.green(r2)) + Color.blue(r2)) / 3) * 0.5f) + 127), 255);
        return Color.rgb(r3, r3, r3);
    }

    public static void setBadgeBounds(Drawable r3, Rect r4) {
        int r0 = BaseIconFactory.getBadgeSizeForIconSize(r4.width());
        r3.setBounds(r4.right - r0, r4.bottom - r0, r4.right, r4.bottom);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r2) {
        if (r2 != this.mBadge) goto L6;
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable r2, Runnable r3, long r4) {
        if (r2 != this.mBadge) goto L6;
        scheduleSelf(r3, r4);
        return;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable r1, Runnable r2) {
        unscheduleSelf(r2);
    }

    public static void setFlagHoverEnabled(boolean r0) {
        sFlagHoverEnabled = r0;
    }
}
