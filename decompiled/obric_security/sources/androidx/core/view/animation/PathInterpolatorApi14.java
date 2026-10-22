package androidx.core.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
class PathInterpolatorApi14 implements Interpolator {
    private static final float PRECISION = 0.002f;
    private final float[] mX;
    private final float[] mY;

    PathInterpolatorApi14(Path r9) {
        PathMeasure r0 = new PathMeasure(r9, false);
        float r10 = r0.getLength();
        int r2 = ((int) (r10 / 0.002f)) + 1;
        this.mX = new float[r2];
        this.mY = new float[r2];
        float[] r4 = new float[2];
        int r5 = 0;
    L3:
        if (r5 >= r2) goto L5;
        r0.getPosTan((r5 * r10) / (r2 - 1), r4, null);
        this.mX[r5] = r4[0];
        this.mY[r5] = r4[1];
        r5 = r5 + 1;
        goto L3
    }

    PathInterpolatorApi14(float r1, float r2) {
        this(createQuad(r1, r2));
    }

    PathInterpolatorApi14(float r1, float r2, float r3, float r4) {
        this(createCubic(r1, r2, r3, r4));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r7) {
        if (r7 > 0.0f) goto L6;
        return 0.0f;
    L6:
        if (r7 < 1.0f) goto L8;
        return 1.0f;
    L8:
        int r1 = this.mX.length - 1;
        int r3 = 0;
    L10:
        if ((r1 - r3) <= 1) goto L15;
        int r4 = (r3 + r1) / 2;
        if (r7 < this.mX[r4]) goto L13;
        r3 = r4;
        goto L10
    L13:
        r1 = r4;
        goto L10
    L15:
        float[] r2 = this.mX;
        float r5 = r2[r1];
        float r6 = r2[r3];
        float r8 = r5 - r6;
        if (r8 == 0.0f) goto L18;
        float[] r9 = this.mY;
        float r0 = r9[r3];
        return r0 + (((r7 - r6) / r8) * (r9[r1] - r0));
    L18:
        return this.mY[r3];
    }

    private static Path createQuad(float r2, float r3) {
        Path r0 = new Path();
        r0.moveTo(0.0f, 0.0f);
        r0.quadTo(r2, r3, 1.0f, 1.0f);
        return r0;
    }

    private static Path createCubic(float r8, float r9, float r10, float r11) {
        Path r7 = new Path();
        r7.moveTo(0.0f, 0.0f);
        r7.cubicTo(r8, r9, r10, r11, 1.0f, 1.0f);
        return r7;
    }
}
