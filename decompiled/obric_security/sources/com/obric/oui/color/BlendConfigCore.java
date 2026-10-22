package com.obric.oui.color;

import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import com.obric.oui.graphic.BlendMode;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class BlendConfigCore {
    private int blendMode;
    private int color;

    public BlendConfigCore(int r1, int r2) {
        this.color = r1;
        this.blendMode = r2;
    }

    public BlendConfigCore(int r1, BlendMode r2) {
        this(r1, BlendMode.mapToLegacyObricBlend(r2));
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int r1) {
        this.color = r1;
    }

    public int getBlendMode() {
        return this.blendMode;
    }

    public void setBlendMode(int r1) {
        this.blendMode = r1;
    }

    public BlendConfigCore deepCopy() {
        return deepCopy(this);
    }

    public static BlendConfigCore deepCopy(BlendConfigCore r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new BlendConfigCore(r2.color, r2.blendMode);
    }

    public static BlendConfigCore[] deepCopy(BlendConfigCore[] r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        BlendConfigCore[] r0 = new BlendConfigCore[r3.length];
        int r1 = 0;
    L7:
        if (r1 >= r3.length) goto L9;
        r0[r1] = deepCopy(r3[r1]);
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }

    public String toString() {
        return String.format(Locale.US, "BlendConfig#%d(color=#%08X, blendMode=%d)", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.color), Integer.valueOf(this.blendMode)});
    }

    public static BlendConfigCore[] fromIntArray(int[] r7) {
        int r0 = 0;
        if (r7 == null) goto L15;
        if (r7.length == 0) goto L15;
        if ((r7.length % 2) != 0) goto L15;
        BlendConfigCore[] r1 = new BlendConfigCore[r7.length / 2];
        int r2 = 0;
    L11:
        if (r0 >= (r7.length - 1)) goto L13;
        r1[r2] = new BlendConfigCore(r7[r0], BlendMode.mapToLegacyObricBlend(r7[r0 + 1]));
        r0 = r0 + 2;
        r2 = r2 + 1;
        goto L11
    L13:
        return r1;
    L15:
        return new BlendConfigCore[0];
    }

    public static BlendConfigCore lerp(BlendConfigCore r2, BlendConfigCore r3, float r4) {
        float r5 = coerceIn(r4, 0.0f, 1.0f);
        if (r5 > 0.0f) goto L7;
        return new BlendConfigCore(r2.color, r2.blendMode);
    L7:
        if (r5 >= 1.0f) goto L9;
        int r0 = ColorUtils.blendARGB(r2.color, r3.color, r5);
        int r6 = r2.blendMode;
        int r7 = r3.blendMode;
        if (r6 == r7) goto L18;
        if (r5 < 0.5f) goto L18;
        r6 = r7;
    L18:
        return new BlendConfigCore(r0, r6);
    L9:
        return new BlendConfigCore(r3.color, r3.blendMode);
    }

    public static BlendConfigCore[] lerp(BlendConfigCore[] r5, BlendConfigCore[] r6, float r7) {
        float r8 = coerceIn(r7, 0.0f, 1.0f);
        if (r8 > 0.0f) goto L7;
        return copyArray(r5);
    L7:
        if (r8 >= 1.0f) goto L9;
        int r0 = Math.max(r5.length, r6.length);
        int r1 = 0;
        if (r0 == 0) goto L13;
        BlendConfigCore[] r9 = normalize(r5, r0);
        BlendConfigCore[] r10 = normalize(r6, r0);
        BlendConfigCore[] r2 = new BlendConfigCore[r0];
    L15:
        if (r1 >= r0) goto L17;
        r2[r1] = lerp(r9[r1], r10[r1], r8);
        r1 = r1 + 1;
        goto L15
    L17:
        return r2;
    L13:
        return new BlendConfigCore[0];
    L9:
        return copyArray(r6);
    }

    public static BlendConfigCore[] alpha(BlendConfigCore[] r5, float r6) {
        float r7 = coerceIn(r6, 0.0f, 1.0f);
        BlendConfigCore[] r0 = new BlendConfigCore[r5.length];
        int r1 = 0;
    L4:
        if (r1 >= r5.length) goto L6;
        int r3 = r5[r1].color;
        r0[r1] = new BlendConfigCore(ColorUtils.setAlphaComponent(r3, (int) (Color.alpha(r3) * r7)), r5[r1].blendMode);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    private static BlendConfigCore[] copyArray(BlendConfigCore[] r5) {
        BlendConfigCore[] r0 = new BlendConfigCore[r5.length];
        int r1 = 0;
    L4:
        if (r1 >= r5.length) goto L6;
        BlendConfigCore r3 = r5[r1];
        r0[r1] = new BlendConfigCore(r3.color, r3.blendMode);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    private static BlendConfigCore[] normalize(BlendConfigCore[] r4, int r5) {
        if (r4.length != r5) goto L5;
        return r4;
    L5:
        BlendConfigCore[] r0 = (BlendConfigCore[]) Arrays.copyOf(r4, r5);
        int r6 = r4.length;
    L6:
        if (r6 >= r5) goto L8;
        r0[r6] = new BlendConfigCore(0, BlendMode.SRC_OVER);
        r6 = r6 + 1;
        goto L6
    L8:
        return r0;
    }

    private static float coerceIn(float r0, float r1, float r2) {
        return Math.max(r1, Math.min(r2, r0));
    }
}
