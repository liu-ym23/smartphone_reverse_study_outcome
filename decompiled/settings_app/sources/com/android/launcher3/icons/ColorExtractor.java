package com.android.launcher3.icons;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.SparseArray;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ColorExtractor {
    private final int NUM_SAMPLES;
    private final float[] mTmpHsv;
    private final float[] mTmpHueScoreHistogram;
    private final int[] mTmpPixels;
    private final SparseArray<Float> mTmpRgbScores;

    public ColorExtractor() {
        this.NUM_SAMPLES = 20;
        this.mTmpHsv = new float[3];
        this.mTmpHueScoreHistogram = new float[360];
        this.mTmpPixels = new int[20];
        this.mTmpRgbScores = new SparseArray();
    }

    public int findDominantColorByHue(Bitmap r2) {
        return findDominantColorByHue(r2, 20);
    }

    protected int findDominantColorByHue(Bitmap r20, int r21) {
        int r2 = r20.getHeight();
        int r3 = r20.getWidth();
        int r4 = (int) Math.sqrt((r2 * r3) / r21);
        if (r4 >= 1) goto L5;
        r4 = 1;
    L5:
        float[] r6 = this.mTmpHsv;
        Arrays.fill(r6, 0.0f);
        float[] r8 = this.mTmpHueScoreHistogram;
        Arrays.fill(r8, 0.0f);
        int[] r7 = this.mTmpPixels;
        int r9 = 0;
        Arrays.fill(r7, 0);
        int r11 = -1;
        int r12 = 0;
        int r13 = 0;
        float r14 = -1.0f;
    L6:
        int r16 = -16777216;
        if (r12 >= r2) goto L25;
        int r10 = r9;
    L9:
        if (r10 >= r3) goto L24;
        int r17 = r20.getPixel(r10, r12);
        if (((r17 >> 24) & 255) >= 128) goto L13;
        int r18 = r2;
    L23:
        r10 = r10 + r4;
        r2 = r18;
        goto L9
    L13:
        int r5 = r17 | (-16777216);
        Color.colorToHSV(r5, r6);
        r18 = r2;
        int r15 = (int) r6[0];
        if (r15 < 0) goto L23;
        if (r15 >= r8.length) goto L23;
        if (r13 >= r21) goto L20;
        r7[r13] = r5;
        r13 = r13 + 1;
    L20:
        float r19 = r8[r15] + (r6[1] * r6[2]);
        r8[r15] = r19;
        if (r19 <= r14) goto L23;
        r11 = r15;
        r14 = r19;
        goto L23
    L24:
        r12 = r12 + r4;
        r9 = 0;
        goto L6
    L25:
        SparseArray<Float> r0 = this.mTmpRgbScores;
        r0.clear();
        int r22 = 0;
        float r110 = -1.0f;
    L26:
        if (r22 >= r13) goto L38;
        int r1 = r7[r22];
        Color.colorToHSV(r1, r6);
        if (((int) r6[0]) != r11) goto L37;
        float r23 = r6[1];
        float r24 = r6[2];
        int r111 = ((int) (100.0f * r23)) + ((int) (10000.0f * r24));
        float r25 = r23 * r24;
        Float r26 = r0.get(r111);
        if (r26 == null) goto L33;
        r25 = r25 + r26.floatValue();
    L33:
        r0.put(r111, Float.valueOf(r25));
        if (r25 <= r110) goto L37;
        r16 = r1;
        r110 = r25;
    L37:
        r22 = r22 + 1;
        goto L26
    L38:
        return r16;
    }
}
