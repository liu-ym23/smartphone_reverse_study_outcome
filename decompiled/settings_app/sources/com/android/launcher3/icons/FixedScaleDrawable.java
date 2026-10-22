package com.android.launcher3.icons;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.DrawableWrapper;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class FixedScaleDrawable extends DrawableWrapper {
    private static final float LEGACY_ICON_SCALE = 0.46669f;
    private float mScaleX;
    private float mScaleY;

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r1, XmlPullParser r2, AttributeSet r3) {
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void inflate(Resources r1, XmlPullParser r2, AttributeSet r3, Resources.Theme r4) {
    }

    public FixedScaleDrawable() {
        super(new ColorDrawable());
        this.mScaleX = LEGACY_ICON_SCALE;
        this.mScaleY = LEGACY_ICON_SCALE;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas r6) {
        int r0 = r6.save();
        r6.scale(this.mScaleX, this.mScaleY, getBounds().exactCenterX(), getBounds().exactCenterY());
        super.draw(r6);
        r6.restoreToCount(r0);
    }

    public void setScale(float r5) {
        float r0 = getIntrinsicHeight();
        float r1 = getIntrinsicWidth();
        float r6 = r5 * LEGACY_ICON_SCALE;
        this.mScaleX = r6;
        this.mScaleY = r6;
        if (r0 <= r1) goto L8;
        if (r1 <= 0.0f) goto L8;
        this.mScaleX = r6 * (r1 / r0);
        return;
    L8:
        if (r1 > r0) goto L10;
        return;
    L10:
        if (r0 <= 0.0f) goto L15;
        this.mScaleY = r6 * (r0 / r1);
        return;
    }
}
