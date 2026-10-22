package com.android.launcher3.icons;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import androidx.core.graphics.ColorUtils;
import com.android.settingslib.R;

/* JADX INFO: loaded from: classes.dex */
public class UserBadgeDrawable extends DrawableWrapper {
    private static final float BG_RADIUS = 11.0f;
    private static final float CENTER = 12.0f;
    static final int SHADOW_COLOR = 285212672;
    private static final float SHADOW_OFFSET_Y = 0.25f;
    private static final float SHADOW_RADIUS = 11.5f;
    private static final float VIEWPORT_SIZE = 24.0f;
    private final int mBaseColor;
    private final int mBgColor;
    public final boolean mIsThemed;
    private final Paint mPaint;
    private boolean mShouldDrawBackground;

    /* JADX INFO: renamed from: com.android.launcher3.icons.UserBadgeDrawable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class MyConstantState extends Drawable.ConstantState {
        private final Drawable.ConstantState mBase;
        private final int mBaseColor;
        private final int mBgColor;
        private final boolean mShouldDrawBackground;

        MyConstantState(Drawable.ConstantState r1, int r2, int r3, boolean r4) {
            this.mBase = r1;
            this.mBgColor = r2;
            this.mBaseColor = r3;
            this.mShouldDrawBackground = r4;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mBase.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new UserBadgeDrawable(this.mBase.newDrawable(), this.mBgColor, this.mBaseColor, this.mShouldDrawBackground, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r8) {
            return new UserBadgeDrawable(this.mBase.newDrawable(r8), this.mBgColor, this.mBaseColor, this.mShouldDrawBackground, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r8, Resources.Theme r9) {
            return new UserBadgeDrawable(this.mBase.newDrawable(r8, r9), this.mBgColor, this.mBaseColor, this.mShouldDrawBackground, null);
        }
    }

    /* synthetic */ UserBadgeDrawable(Drawable r1, int r2, int r3, boolean r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }

    public UserBadgeDrawable(Context r2, int r3, int r4, boolean r5) {
        super(r2.getDrawable(r3));
        this.mPaint = new Paint(1);
        this.mShouldDrawBackground = true;
        this.mIsThemed = r5;
        if (r5 == false) goto L5;
        mutate();
        this.mBaseColor = r2.getColor(R.color.themed_badge_icon_color);
        this.mBgColor = r2.getColor(R.color.themed_badge_icon_background_color);
    L6:
        setTint(this.mBaseColor);
        return;
    L5:
        this.mBaseColor = r2.getColor(r4);
        this.mBgColor = -1;
        goto L6
    }

    private UserBadgeDrawable(Drawable r2, int r3, int r4, boolean r5) {
        super(r2);
        this.mPaint = new Paint(1);
        this.mIsThemed = false;
        this.mBgColor = r3;
        this.mBaseColor = r4;
        this.mShouldDrawBackground = r5;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas r6) {
        if (this.mShouldDrawBackground == false) goto L5;
        Rect r0 = getBounds();
        int r1 = r6.save();
        r6.translate(r0.left, r0.top);
        r6.scale(r0.width() / 24.0f, r0.height() / 24.0f);
        this.mPaint.setColor(blendDrawableAlpha(SHADOW_COLOR));
        r6.drawCircle(12.0f, 12.25f, SHADOW_RADIUS, this.mPaint);
        this.mPaint.setColor(blendDrawableAlpha(this.mBgColor));
        r6.drawCircle(12.0f, 12.0f, BG_RADIUS, this.mPaint);
        r6.restoreToCount(r1);
    L5:
        super.draw(r6);
    }

    private int blendDrawableAlpha(int r2) {
        return ColorUtils.setAlphaComponent(r2, (int) (Color.valueOf(r2).alpha() * getAlpha()));
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r6) {
        if (r6 != null) goto L5;
        super.setTint(this.mBaseColor);
        return;
    L5:
        if ((r6 instanceof ColorMatrixColorFilter) == false) goto L7;
        ColorMatrix r0 = new ColorMatrix();
        ((ColorMatrixColorFilter) r6).getColorMatrix(r0);
        ColorMatrix r7 = new ColorMatrix();
        float[] r2 = r7.getArray();
        r2[0] = Color.red(this.mBaseColor) / 255.0f;
        r2[6] = Color.green(this.mBaseColor) / 255.0f;
        r2[12] = Color.blue(this.mBaseColor) / 255.0f;
        r2[18] = Color.alpha(this.mBaseColor) / 255.0f;
        r7.postConcat(r0);
        super.setColorFilter(new ColorMatrixColorFilter(r7));
        return;
    L7:
        Paint r1 = new Paint();
        r1.setColorFilter(r6);
        Bitmap r8 = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        new Canvas(r8).drawPaint(r1);
        super.setTint(r8.getPixel(0, 0));
    }

    public void setShouldDrawBackground(boolean r1) {
        mutate();
        this.mShouldDrawBackground = r1;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return new MyConstantState(getDrawable().getConstantState(), this.mBgColor, this.mBaseColor, this.mShouldDrawBackground);
    }
}
