package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class PathInterpolatorCompat implements Interpolator {
    public static final double EPSILON = 1.0E-5d;
    public static final int MAX_NUM_POINTS = 3000;
    private static final float PRECISION = 0.002f;
    private float[] mX;
    private float[] mY;

    public PathInterpolatorCompat(Context r2, AttributeSet r3, XmlPullParser r4) {
        this(r2.getResources(), r2.getTheme(), r3, r4);
    }

    public PathInterpolatorCompat(Resources r2, Resources.Theme r3, AttributeSet r4, XmlPullParser r5) {
        TypedArray r6 = TypedArrayUtils.obtainAttributes(r2, r3, r4, AndroidResources.STYLEABLE_PATH_INTERPOLATOR);
        parseInterpolatorFromTypeArray(r6, r5);
        r6.recycle();
    }

    private void initCubic(float r9, float r10, float r11, float r12) {
        Path r7 = new Path();
        r7.moveTo(0.0f, 0.0f);
        r7.cubicTo(r9, r10, r11, r12, 1.0f, 1.0f);
        initPath(r7);
    }

    private void initPath(Path r11) {
        int r1 = 0;
        PathMeasure r0 = new PathMeasure(r11, false);
        float r12 = r0.getLength();
        int r2 = Math.min(MAX_NUM_POINTS, ((int) (r12 / 0.002f)) + 1);
        if (r2 <= 0) goto L30;
        this.mX = new float[r2];
        this.mY = new float[r2];
        float[] r4 = new float[2];
        int r5 = 0;
    L5:
        if (r5 >= r2) goto L8;
        r0.getPosTan((r5 * r12) / (r2 - 1), r4, null);
        this.mX[r5] = r4[0];
        this.mY[r5] = r4[1];
        r5 = r5 + 1;
        goto L5
    L8:
        if (Math.abs(this.mX[0]) <= 1.0E-5d) goto L10;
    L27:
        StringBuilder r3 = new StringBuilder();
        r3.append("The Path must start at (0,0) and end at (1,1) start: ");
        r3.append(this.mX[0]);
        r3.append(",");
        r3.append(this.mY[0]);
        r3.append(" end:");
        int r6 = r2 - 1;
        r3.append(this.mX[r6]);
        r3.append(",");
        r3.append(this.mY[r6]);
        throw new IllegalArgumentException(r3.toString());
    L10:
        if (Math.abs(this.mY[0]) > 1.0E-5d) goto L27;
        int r7 = r2 - 1;
        if (Math.abs(this.mX[r7] - 1.0f) > 1.0E-5d) goto L27;
        if (Math.abs(this.mY[r7] - 1.0f) > 1.0E-5d) goto L27;
        float r13 = 0.0f;
        int r8 = 0;
    L16:
        if (r1 >= r2) goto L23;
        float[] r9 = this.mX;
        int r10 = r8 + 1;
        float r14 = r9[r8];
        if (r14 < r13) goto L21;
        r9[r1] = r14;
        r1 = r1 + 1;
        r13 = r14;
        r8 = r10;
        goto L16
    L21:
        throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + r14);
    L23:
        if (r0.nextContour() == true) goto L26;
        return;
    L26:
        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
    L30:
        throw new IllegalArgumentException("The Path has a invalid length " + r12);
    }

    private void initQuad(float r3, float r4) {
        Path r0 = new Path();
        r0.moveTo(0.0f, 0.0f);
        r0.quadTo(r3, r4, 1.0f, 1.0f);
        initPath(r0);
    }

    private void parseInterpolatorFromTypeArray(TypedArray r8, XmlPullParser r9) {
        if (TypedArrayUtils.hasAttribute(r9, "pathData") == false) goto L10;
        String r10 = TypedArrayUtils.getNamedString(r8, r9, "pathData", 4);
        Path r11 = PathParser.createPathFromPathData(r10);
        if (r11 == null) goto L8;
        initPath(r11);
        return;
    L8:
        throw new InflateException("The path is null, which is created from " + r10);
    L10:
        if (TypedArrayUtils.hasAttribute(r9, "controlX1") == false) goto L24;
        if (TypedArrayUtils.hasAttribute(r9, "controlY1") == false) goto L22;
        float r0 = TypedArrayUtils.getNamedFloat(r8, r9, "controlX1", 0, 0.0f);
        float r1 = TypedArrayUtils.getNamedFloat(r8, r9, "controlY1", 1, 0.0f);
        boolean r4 = TypedArrayUtils.hasAttribute(r9, "controlX2");
        if (r4 != TypedArrayUtils.hasAttribute(r9, "controlY2")) goto L20;
        if (r4 == true) goto L17;
        initQuad(r0, r1);
        return;
    L17:
        initCubic(r0, r1, TypedArrayUtils.getNamedFloat(r8, r9, "controlX2", 2, 0.0f), TypedArrayUtils.getNamedFloat(r8, r9, "controlY2", 3, 0.0f));
        return;
    L20:
        throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
    L22:
        throw new InflateException("pathInterpolator requires the controlY1 attribute");
    L24:
        throw new InflateException("pathInterpolator requires the controlX1 attribute");
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r7) {
        if (r7 > 0.0f) goto L6;
        return 0.0f;
    L6:
        if (r7 < 1.0f) goto L8;
        return 1.0f;
    L8:
        int r1 = 0;
        int r2 = this.mX.length - 1;
    L10:
        if ((r2 - r1) <= 1) goto L15;
        int r4 = (r1 + r2) / 2;
        if (r7 < this.mX[r4]) goto L13;
        r1 = r4;
        goto L10
    L13:
        r2 = r4;
        goto L10
    L15:
        float[] r3 = this.mX;
        float r5 = r3[r2] - r3[r1];
        if (r5 == 0.0f) goto L18;
        float r8 = (r7 - r3[r1]) / r5;
        float[] r6 = this.mY;
        float r0 = r6[r1];
        return r0 + (r8 * (r6[r2] - r0));
    L18:
        return this.mY[r1];
    }
}
