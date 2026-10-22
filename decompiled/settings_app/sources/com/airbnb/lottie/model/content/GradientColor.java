package com.airbnb.lottie.model.content;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;

/* JADX INFO: loaded from: classes.dex */
public class GradientColor {
    private final int[] colors;
    private final float[] positions;

    public GradientColor(float[] r1, int[] r2) {
        this.positions = r1;
        this.colors = r2;
    }

    public float[] getPositions() {
        return this.positions;
    }

    public int[] getColors() {
        return this.colors;
    }

    public int getSize() {
        return this.colors.length;
    }

    public void lerp(GradientColor r5, GradientColor r6, float r7) {
        if (r5.colors.length != r6.colors.length) goto L10;
        int r0 = 0;
    L6:
        if (r0 >= r5.colors.length) goto L8;
        this.positions[r0] = MiscUtils.lerp(r5.positions[r0], r6.positions[r0], r7);
        this.colors[r0] = GammaEvaluator.evaluate(r7, r5.colors[r0], r6.colors[r0]);
        r0 = r0 + 1;
        goto L6
    L8:
        return;
    L10:
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + r5.colors.length + " vs " + r6.colors.length + ")");
    }
}
