package com.google.zxing.common;

import com.google.zxing.NotFoundException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class GridSampler {
    private static GridSampler gridSampler;

    public abstract BitMatrix sampleGrid(BitMatrix r1, int r2, int r3, float r4, float r5, float r6, float r7, float r8, float r9, float r10, float r11, float r12, float r13, float r14, float r15, float r16, float r17, float r18, float r19) throws NotFoundException;

    public abstract BitMatrix sampleGrid(BitMatrix r1, int r2, int r3, PerspectiveTransform r4) throws NotFoundException;

    public GridSampler() {
    }

    static {
        gridSampler = new DefaultGridSampler();
    }

    public static void setGridSampler(GridSampler r0) {
        gridSampler = r0;
    }

    public static GridSampler getInstance() {
        return gridSampler;
    }

    protected static void checkAndNudgePoints(BitMatrix r9, float[] r10) throws NotFoundException {
        int r0 = r9.getWidth();
        int r11 = r9.getHeight();
        boolean r4 = true;
        int r3 = 0;
    L4:
        if (r3 >= r10.length) goto L25;
        if (r4 == false) goto L25;
        int r5 = (int) r10[r3];
        int r6 = r3 + 1;
        int r8 = (int) r10[r6];
        if (r5 < (-1)) goto L24;
        if (r5 > r0) goto L24;
        if (r8 < (-1)) goto L24;
        if (r8 > r11) goto L24;
        if (r5 != (-1)) goto L14;
        r10[r3] = 0.0f;
    L13:
        r4 = true;
    L17:
        if (r8 != (-1)) goto L20;
        r10[r6] = 0.0f;
    L19:
        r4 = true;
    L22:
        r3 = r3 + 2;
        goto L4
    L20:
        if (r8 != r11) goto L22;
        r10[r6] = r11 - 1;
        goto L19
    L14:
        if (r5 != r0) goto L16;
        r10[r3] = r0 - 1;
        goto L13
    L16:
        r4 = false;
    L24:
        throw NotFoundException.getNotFoundInstance();
    L25:
        int r7 = r10.length - 2;
        boolean r12 = true;
    L26:
        if (r7 < 0) goto L47;
        if (r12 == false) goto L64;
        int r13 = (int) r10[r7];
        int r14 = r7 + 1;
        int r15 = (int) r10[r14];
        if (r13 < (-1)) goto L46;
        if (r13 > r0) goto L46;
        if (r15 < (-1)) goto L46;
        if (r15 > r11) goto L46;
        if (r13 != (-1)) goto L36;
        r10[r7] = 0.0f;
    L35:
        r12 = true;
    L39:
        if (r15 != (-1)) goto L42;
        r10[r14] = 0.0f;
    L41:
        r12 = true;
    L44:
        r7 = r7 - 2;
        goto L26
    L42:
        if (r15 != r11) goto L44;
        r10[r14] = r11 - 1;
        goto L41
    L36:
        if (r13 != r0) goto L38;
        r10[r7] = r0 - 1;
        goto L35
    L38:
        r12 = false;
    L46:
        throw NotFoundException.getNotFoundInstance();
    L64:
        return;
    }
}
