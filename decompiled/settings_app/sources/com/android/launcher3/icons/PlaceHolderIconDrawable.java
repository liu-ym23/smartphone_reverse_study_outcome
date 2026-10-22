package com.android.launcher3.icons;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.ColorUtils;
import com.android.settingslib.R;

/* JADX INFO: loaded from: classes.dex */
public class PlaceHolderIconDrawable extends FastBitmapDrawable {
    private final Path mProgressPath;

    public PlaceHolderIconDrawable(BitmapInfo r2, Context r3) {
        super(r2);
        this.mProgressPath = GraphicsUtils.getShapePath(r3, 100);
        this.mPaint.setColor(ColorUtils.compositeColors(GraphicsUtils.getAttrColor(r3, R.attr.loadingIconColor), r2.color));
    }

    @Override // com.android.launcher3.icons.FastBitmapDrawable
    protected void drawInternal(Canvas r4, Rect r5) {
        int r0 = r4.save();
        r4.translate(r5.left, r5.top);
        r4.scale(r5.width() / 100.0f, r5.height() / 100.0f);
        r4.drawPath(this.mProgressPath, this.mPaint);
        r4.restoreToCount(r0);
    }

    public void animateIconUpdate(final Drawable r5) {
        final int r0 = this.mPaint.getColor();
        ValueAnimator r1 = ValueAnimator.ofInt(new int[]{Color.alpha(r0), 0});
        r1.setDuration(375);
        r1.addUpdateListener(new PlaceHolderIconDrawable$$ExternalSyntheticLambda0(r0, r5));
        r1.addListener(new AnonymousClass1(this, r5));
        r1.start();
    }

    static /* synthetic */ void lambda$animateIconUpdate$0(int r1, Drawable r2, ValueAnimator r3) {
        r2.setColorFilter(new PorterDuffColorFilter(ColorUtils.setAlphaComponent(r1, ((Integer) r3.getAnimatedValue()).intValue()), PorterDuff.Mode.SRC_ATOP));
    }
}
