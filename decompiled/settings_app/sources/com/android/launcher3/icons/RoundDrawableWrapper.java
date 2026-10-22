package com.android.launcher3.icons;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;

/* JADX INFO: loaded from: classes.dex */
public class RoundDrawableWrapper extends DrawableWrapper {
    private final Path mClipPath;
    private final float mRoundedCornersRadius;
    private final RectF mTempRect;

    public RoundDrawableWrapper(Drawable r1, float r2) {
        super(r1);
        this.mTempRect = new RectF();
        this.mClipPath = new Path();
        this.mRoundedCornersRadius = r2;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r5) {
        this.mTempRect.set(getBounds());
        this.mClipPath.reset();
        Path r0 = this.mClipPath;
        RectF r1 = this.mTempRect;
        float r2 = this.mRoundedCornersRadius;
        r0.addRoundRect(r1, r2, r2, Path.Direction.CCW);
        super.onBoundsChange(r5);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public final void draw(Canvas r3) {
        int r0 = r3.save();
        r3.clipPath(this.mClipPath);
        super.draw(r3);
        r3.restoreToCount(r0);
    }
}
