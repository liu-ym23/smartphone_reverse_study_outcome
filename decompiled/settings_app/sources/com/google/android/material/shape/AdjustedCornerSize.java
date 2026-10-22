package com.google.android.material.shape;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class AdjustedCornerSize implements CornerSize {
    private final float adjustment;
    private final CornerSize other;

    public AdjustedCornerSize(float r2, CornerSize r3) {
    L4:
        if ((r3 instanceof AdjustedCornerSize) == false) goto L6;
        r3 = ((AdjustedCornerSize) r3).other;
        r2 = r2 + ((AdjustedCornerSize) r3).adjustment;
        goto L4
    L6:
        this.other = r3;
        this.adjustment = r2;
    }

    @Override // com.google.android.material.shape.CornerSize
    public float getCornerSize(RectF r2) {
        return Math.max(0.0f, this.other.getCornerSize(r2) + this.adjustment);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AdjustedCornerSize) == true) goto L8;
        return false;
    L8:
        AdjustedCornerSize r6 = (AdjustedCornerSize) r5;
        if (this.other.equals(r6.other) == false) goto L14;
        if (this.adjustment != r6.adjustment) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.other, Float.valueOf(this.adjustment)});
    }
}
