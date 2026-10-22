package org.apache.commons.math3.transform;

import java.io.Serializable;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class FastSineTransformer implements RealTransformer, Serializable {
    static final long serialVersionUID = 20120211;
    private final DstNormalization normalization;

    public FastSineTransformer(DstNormalization r1) {
        this.normalization = r1;
    }

    @Override // org.apache.commons.math3.transform.RealTransformer
    public double[] transform(double[] r5, TransformType r6) {
        if (this.normalization != DstNormalization.ORTHOGONAL_DST_I) goto L7;
        double r0 = FastMath.sqrt(2.0d / ((double) r5.length));
        return TransformUtils.scaleArray(fst(r5), r0);
    L7:
        if (r6 == TransformType.FORWARD) goto L9;
        double r2 = 2.0d / ((double) r5.length);
        return TransformUtils.scaleArray(fst(r5), r2);
    L9:
        return fst(r5);
    }

    @Override // org.apache.commons.math3.transform.RealTransformer
    public double[] transform(UnivariateFunction r1, double r2, double r4, int r6, TransformType r7) {
        double[] r3 = FunctionUtils.sample(r1, r2, r4, r6);
        r3[0] = 0.0d;
        return transform(r3, r7);
    }

    protected double[] fst(double[] r22) throws MathIllegalArgumentException {
        double[] r1 = new double[r22.length];
        if (ArithmeticUtils.isPowerOfTwo(r22.length) == false) goto L21;
        if (r22[0] != 0.0d) goto L19;
        int r2 = r22.length;
        if (r2 != 1) goto L10;
        r1[0] = 0.0d;
        return r1;
    L10:
        double[] r5 = new double[r2];
        r5[0] = 0.0d;
        int r6 = r2 >> 1;
        r5[r6] = r22[r6] * 2.0d;
        int r9 = 1;
    L12:
        if (r9 >= r6) goto L14;
        double r12 = FastMath.sin((((double) r9) * 3.141592653589793d) / ((double) r2));
        double r14 = r22[r9];
        int r16 = r2 - r9;
        double r17 = r22[r16];
        double r13 = r12 * (r14 + r17);
        double r15 = (r14 - r17) * 0.5d;
        r5[r9] = r13 + r15;
        r5[r16] = r13 - r15;
        r9 = r9 + 1;
        goto L12
    L14:
        Complex[] r0 = new FastFourierTransformer(DftNormalization.STANDARD).transform(r5, TransformType.FORWARD);
        r1[0] = 0.0d;
        r1[1] = r0[0].getReal() * 0.5d;
        int r3 = 1;
    L15:
        if (r3 >= r6) goto L17;
        int r4 = r3 * 2;
        r1[r4] = -r0[r3].getImaginary();
        r1[r4 + 1] = r0[r3].getReal() + r1[r4 - 1];
        r3 = r3 + 1;
        goto L15
    L17:
        return r1;
    L19:
        throw new MathIllegalArgumentException(LocalizedFormats.FIRST_ELEMENT_NOT_ZERO, new Object[]{Double.valueOf(r22[0])});
    L21:
        throw new MathIllegalArgumentException(LocalizedFormats.NOT_POWER_OF_TWO_CONSIDER_PADDING, new Object[]{Integer.valueOf(r22.length)});
    }
}
