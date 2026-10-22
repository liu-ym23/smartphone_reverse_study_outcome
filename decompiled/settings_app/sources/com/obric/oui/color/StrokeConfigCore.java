package com.obric.oui.color;

import androidx.core.graphics.ColorUtils;
import com.obric.oui.graphic.BlendMode;

/* JADX INFO: loaded from: classes4.dex */
public final class StrokeConfigCore {
    private final BlendMode blendMode;
    private final int color;
    private final float width;

    public StrokeConfigCore(float r2, int r3) {
        this(r2, r3, BlendMode.SRC_OVER);
    }

    public StrokeConfigCore(float r1, int r2, BlendMode r3) {
        this.width = r1;
        this.color = r2;
        this.blendMode = r3;
    }

    public float getWidth() {
        return this.width;
    }

    public int getColor() {
        return this.color;
    }

    public BlendMode getBlendMode() {
        return this.blendMode;
    }

    public StrokeConfigCore deepCopy() {
        return deepCopy(this);
    }

    public static StrokeConfigCore deepCopy(StrokeConfigCore r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        return new StrokeConfigCore(r3.width, r3.color, r3.blendMode);
    }

    public static StrokeConfigCore lerp(StrokeConfigCore r2, StrokeConfigCore r3, float r4) {
        if (r2 != null) goto L4;
        return r3;
    L4:
        if (r3 != null) goto L6;
        return r2;
    L6:
        float r5 = Math.max(0.0f, Math.min(1.0f, r4));
        if (r5 > 0.0f) goto L10;
        return r2;
    L10:
        if (r5 < 1.0f) goto L12;
        return r3;
    L12:
        float r0 = r2.width;
        return new StrokeConfigCore(r0 + ((r3.width - r0) * r5), ColorUtils.blendARGB(r2.color, r3.color, r5), r2.blendMode);
    }
}
