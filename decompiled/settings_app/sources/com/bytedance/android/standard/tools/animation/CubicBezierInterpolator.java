package com.bytedance.android.standard.tools.animation;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes3.dex */
public class CubicBezierInterpolator implements Interpolator {
    public static final int CUBICEASEIN = 7;
    public static final int CUBICEASEINOUT = 9;
    public static final int CUBICEASEOUT = 8;
    public static final int EXPOEASEIN = 16;
    public static final int EXPOEASEINOUT = 18;
    public static final int EXPOEASEOUT = 17;
    private static final int INT_3 = 3;
    public static final int LINEAR = 0;
    public static final int QUADEASEIN = 4;
    public static final int QUADEASEINOUT = 6;
    public static final int QUADEASEOUT = 5;
    public static final int QUARTEASEIN = 10;
    public static final int QUARTEASEINOUT = 12;
    public static final int QUARTEASEOUT = 11;
    public static final int QUINTEASEIN = 13;
    public static final int QUINTEASEINOUT = 15;
    public static final int QUINTEASEOUT = 14;
    public static final int SINEEASEIN = 1;
    public static final int SINEEASEINOUT = 3;
    public static final int SINEEASEOUT = 2;
    protected PointF a;
    protected PointF b;
    protected PointF c;
    protected PointF end;
    protected PointF start;

    public CubicBezierInterpolator(PointF r4, PointF r5) throws IllegalArgumentException {
        this.a = new PointF();
        this.b = new PointF();
        this.c = new PointF();
        if (r4.x < 0.0f) goto L15;
        if (r4.x > 1.0f) goto L15;
        if (r5.x < 0.0f) goto L13;
        if (r5.x > 1.0f) goto L13;
        this.start = r4;
        this.end = r5;
        return;
    L13:
        throw new IllegalArgumentException("endX value must be in the range [0, 1]");
    L15:
        throw new IllegalArgumentException("startX value must be in the range [0, 1]");
    }

    public CubicBezierInterpolator(float r2, float r3, float r4, float r5) {
        this(new PointF(r2, r3), new PointF(r4, r5));
    }

    public CubicBezierInterpolator(double r1, double r3, double r5, double r7) {
        this((float) r1, (float) r3, (float) r5, (float) r7);
    }

    public CubicBezierInterpolator(int r5) {
        this(getCurveParameters(r5)[0], getCurveParameters(r5)[1], getCurveParameters(r5)[2], getCurveParameters(r5)[3]);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r1) {
        return getBezierCoordinateY(getXForTime(r1));
    }

    protected float getBezierCoordinateY(float r5) {
        PointF r0 = this.c;
        r0.y = this.start.y * 3.0f;
        PointF r1 = this.b;
        r1.y = ((this.end.y - this.start.y) * 3.0f) - this.c.y;
        PointF r2 = this.a;
        r2.y = (1.0f - this.c.y) - this.b.y;
        return r5 * (this.c.y + ((this.b.y + (this.a.y * r5)) * r5));
    }

    protected float getXForTime(float r8) {
        int r0 = 1;
        float r1 = r8;
    L4:
        if (r0 >= 14) goto L9;
        float r2 = getBezierCoordinateX(r1) - r8;
        if (Math.abs(r2) < 0.001d) goto L9;
        r1 = r1 - (r2 / getXDerivate(r1));
        r0 = r0 + 1;
    L9:
        return r1;
    }

    protected static float[] getCurveParameters(int r1) {
        switch(r1) {
            case 0: goto L43;
            case 1: goto L41;
            case 2: goto L39;
            case 3: goto L37;
            case 4: goto L35;
            case 5: goto L33;
            case 6: goto L31;
            case 7: goto L29;
            case 8: goto L27;
            case 9: goto L25;
            case 10: goto L23;
            case 11: goto L21;
            case 12: goto L19;
            case 13: goto L17;
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            case 17: goto L9;
            case 18: goto L7;
            default: goto L5;
        };
    L5:
        return new float[]{0.9f, 0.0f, 0.1f, 1.1f};
    L7:
        return new float[]{0.9f, 0.0f, 0.1f, 1.0f};
    L9:
        return new float[]{0.14f, 1.0f, 0.34f, 1.0f};
    L11:
        return new float[]{0.66f, 0.0f, 0.86f, 0.0f};
    L13:
        return new float[]{0.84f, 0.0f, 0.16f, 1.0f};
    L15:
        return new float[]{0.22f, 1.0f, 0.36f, 1.0f};
    L17:
        return new float[]{0.64f, 0.0f, 0.78f, 0.0f};
    L19:
        return new float[]{0.76f, 0.0f, 0.24f, 1.0f};
    L21:
        return new float[]{0.26f, 1.0f, 0.48f, 1.0f};
    L23:
        return new float[]{0.52f, 0.0f, 0.74f, 0.0f};
    L25:
        return new float[]{0.66f, 0.0f, 0.34f, 1.0f};
    L27:
        return new float[]{0.32f, 0.94f, 0.6f, 1.0f};
    L29:
        return new float[]{0.4f, 0.0f, 0.68f, 0.06f};
    L31:
        return new float[]{0.48f, 0.04f, 0.52f, 0.96f};
    L33:
        return new float[]{0.4f, 0.8f, 0.74f, 1.0f};
    L35:
        return new float[]{0.26f, 0.0f, 0.6f, 0.2f};
    L37:
        return new float[]{0.445f, 0.05f, 0.55f, 0.95f};
    L39:
        return new float[]{0.39f, 0.575f, 0.565f, 1.0f};
    L41:
        return new float[]{0.47f, 0.0f, 0.745f, 0.715f};
    L43:
        return new float[]{0.0f, 0.0f, 1.0f, 1.0f};
    }

    private float getXDerivate(float r4) {
        return this.c.x + (r4 * ((this.b.x * 2.0f) + ((this.a.x * 3.0f) * r4)));
    }

    private float getBezierCoordinateX(float r5) {
        PointF r0 = this.c;
        r0.x = this.start.x * 3.0f;
        PointF r1 = this.b;
        r1.x = ((this.end.x - this.start.x) * 3.0f) - this.c.x;
        PointF r2 = this.a;
        r2.x = (1.0f - this.c.x) - this.b.x;
        return r5 * (this.c.x + ((this.b.x + (this.a.x * r5)) * r5));
    }
}
