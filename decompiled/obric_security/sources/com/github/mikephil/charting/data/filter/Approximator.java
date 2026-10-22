package com.github.mikephil.charting.data.filter;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class Approximator {

    private class Line {
        private float dx;
        private float dy;
        private float exsy;
        private float length;
        private float[] points;
        private float sxey;
        final /* synthetic */ Approximator this$0;

        public Line(Approximator r3, float r4, float r5, float r6, float r7) {
            this.this$0 = r3;
            float r8 = r4 - r6;
            this.dx = r8;
            float r0 = r5 - r7;
            this.dy = r0;
            this.sxey = r4 * r7;
            this.exsy = r6 * r5;
            this.length = (float) Math.sqrt((r8 * r8) + (r0 * r0));
            this.points = new float[]{r4, r5, r6, r7};
        }

        public float distance(float r2, float r3) {
            return Math.abs((((this.dy * r2) - (this.dx * r3)) + this.sxey) - this.exsy) / this.length;
        }

        public float[] getPoints() {
            return this.points;
        }
    }

    public Approximator() {
    }

    public float[] reduceWithDouglasPeucker(float[] r11, float r12) {
        Line r6 = new Line(this, r11[0], r11[1], r11[r11.length - 2], r11[r11.length - 1]);
        float r0 = 0.0f;
        int r2 = 0;
        int r1 = 2;
    L4:
        if (r1 >= (r11.length - 2)) goto L10;
        float r3 = r6.distance(r11[r1], r11[r1 + 1]);
        if (r3 <= r0) goto L8;
        r2 = r1;
        r0 = r3;
    L8:
        r1 = r1 + 2;
        goto L4
    L10:
        if (r0 <= r12) goto L14;
        float[] r4 = reduceWithDouglasPeucker(Arrays.copyOfRange(r11, 0, r2 + 2), r12);
        float[] r13 = reduceWithDouglasPeucker(Arrays.copyOfRange(r11, r2, r11.length), r12);
        return concat(new float[][]{r4, Arrays.copyOfRange(r13, 2, r13.length)});
    L14:
        return r6.getPoints();
    }

    float[] concat(float[]... r9) {
        int r8 = r9.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r8) goto L5;
        r2 = r2 + r9[r1].length;
        r1 = r1 + 1;
        goto L3
    L5:
        float[] r10 = new float[r2];
        int r3 = r9.length;
        int r4 = 0;
        int r5 = 0;
    L6:
        if (r4 >= r3) goto L11;
        float[] r6 = r9[r4];
        int r7 = r6.length;
        int r11 = 0;
    L8:
        if (r11 >= r7) goto L10;
        r10[r5] = r6[r11];
        r5 = r5 + 1;
        r11 = r11 + 1;
        goto L8
    L10:
        r4 = r4 + 1;
        goto L6
    L11:
        return r10;
    }
}
