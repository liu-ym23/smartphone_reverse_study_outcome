package com.android.launcher3.icons;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import com.android.settingslib.R;

/* JADX INFO: loaded from: classes.dex */
public class ThemedIconDrawable extends FastBitmapDrawable {
    public static final String TAG = "ThemedIconDrawable";
    final BitmapInfo bitmapInfo;
    final int colorBg;
    final int colorFg;
    private final Bitmap mBgBitmap;
    private final ColorFilter mBgFilter;
    private final Paint mBgPaint;
    private final ColorFilter mMonoFilter;
    private final Bitmap mMonoIcon;
    private final Paint mMonoPaint;

    static class ThemedConstantState extends FastBitmapDrawable.FastBitmapConstantState {
        final BitmapInfo bitmapInfo;
        final int colorBg;
        final int colorFg;

        public ThemedConstantState(BitmapInfo r3, int r4, int r5) {
            super(r3.icon, r3.color);
            this.bitmapInfo = r3;
            this.colorBg = r4;
            this.colorFg = r5;
        }

        @Override // com.android.launcher3.icons.FastBitmapDrawable.FastBitmapConstantState
        public FastBitmapDrawable createDrawable() {
            return new ThemedIconDrawable(this);
        }
    }

    @Override // com.android.launcher3.icons.FastBitmapDrawable
    public boolean isThemed() {
        return true;
    }

    protected ThemedIconDrawable(ThemedConstantState r7) {
        super(r7.mBitmap, r7.colorFg);
        Paint r0 = new Paint(3);
        this.mMonoPaint = r0;
        Paint r2 = new Paint(3);
        this.mBgPaint = r2;
        BitmapInfo r1 = r7.bitmapInfo;
        this.bitmapInfo = r1;
        int r3 = r7.colorBg;
        this.colorBg = r3;
        int r8 = r7.colorFg;
        this.colorFg = r8;
        this.mMonoIcon = r1.mMono;
        BlendModeColorFilter r4 = new BlendModeColorFilter(r8, BlendMode.SRC_IN);
        this.mMonoFilter = r4;
        r0.setColorFilter(r4);
        this.mBgBitmap = r1.mWhiteShadowLayer;
        BlendModeColorFilter r9 = new BlendModeColorFilter(r3, BlendMode.SRC_IN);
        this.mBgFilter = r9;
        r2.setColorFilter(r9);
    }

    @Override // com.android.launcher3.icons.FastBitmapDrawable
    protected void drawInternal(Canvas r4, Rect r5) {
        r4.drawBitmap(this.mBgBitmap, null, r5, this.mBgPaint);
        r4.drawBitmap(this.mMonoIcon, null, r5, this.mMonoPaint);
    }

    @Override // com.android.launcher3.icons.FastBitmapDrawable
    protected void updateFilter() {
        super.updateFilter();
        if (this.mIsDisabled == false) goto L5;
        int r0 = (int) (this.mDisabledAlpha * 255.0f);
    L6:
        this.mBgPaint.setAlpha(r0);
        Paint r1 = this.mBgPaint;
        if (this.mIsDisabled == false) goto L9;
        ColorFilter r2 = new BlendModeColorFilter(getDisabledColor(this.colorBg), BlendMode.SRC_IN);
    L10:
        r1.setColorFilter(r2);
        this.mMonoPaint.setAlpha(r0);
        Paint r3 = this.mMonoPaint;
        if (this.mIsDisabled == false) goto L13;
        ColorFilter r4 = new BlendModeColorFilter(getDisabledColor(this.colorFg), BlendMode.SRC_IN);
    L14:
        r3.setColorFilter(r4);
        return;
    L13:
        r4 = this.mMonoFilter;
        goto L14
    L9:
        r2 = this.mBgFilter;
        goto L10
    L5:
        r0 = 255;
        goto L6
    }

    @Override // com.android.launcher3.icons.FastBitmapDrawable
    public FastBitmapDrawable.FastBitmapConstantState newConstantState() {
        return new ThemedConstantState(this.bitmapInfo, this.colorBg, this.colorFg);
    }

    public static FastBitmapDrawable newDrawable(BitmapInfo r3, Context r4) {
        int[] r5 = getColors(r4);
        return new ThemedConstantState(r3, r5[0], r5[1]).newDrawable();
    }

    public static int[] getColors(Context r3) {
        Resources r4 = r3.getResources();
        return new int[]{r4.getColor(R.color.themed_icon_background_color), r4.getColor(R.color.themed_icon_color)};
    }

    @Override // com.android.launcher3.icons.FastBitmapDrawable
    public int getIconColor() {
        return this.colorFg;
    }
}
