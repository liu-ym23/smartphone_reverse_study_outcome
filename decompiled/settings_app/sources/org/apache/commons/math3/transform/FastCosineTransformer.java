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
public class FastCosineTransformer implements RealTransformer, Serializable {
    static final long serialVersionUID = 20120212;
    private final DctNormalization normalization;

    public FastCosineTransformer(DctNormalization r1) {
        this.normalization = r1;
    }

    @Override // org.apache.commons.math3.transform.RealTransformer
    public double[] transform(double[] r6, TransformType r7) throws MathIllegalArgumentException {
        if (r7 == TransformType.FORWARD) goto L5;
        double r1 = 2.0d / ((double) (r6.length - 1));
        if (this.normalization != DctNormalization.ORTHOGONAL_DCT_I) goto L14;
        r1 = FastMath.sqrt(r1);
    L14:
        return TransformUtils.scaleArray(fct(r6), r1);
    L5:
        if (this.normalization != DctNormalization.ORTHOGONAL_DCT_I) goto L9;
        return TransformUtils.scaleArray(fct(r6), FastMath.sqrt(2.0d / ((double) (r6.length - 1))));
    L9:
        return fct(r6);
    }

    @Override // org.apache.commons.math3.transform.RealTransformer
    public double[] transform(UnivariateFunction r1, double r2, double r4, int r6, TransformType r7) throws MathIllegalArgumentException {
        return transform(FunctionUtils.sample(r1, r2, r4, r6), r7);
    }

    protected double[] fct(double[] r23) throws MathIllegalArgumentException {
        double[] r1 = new double[r23.length];
        int r2 = r23.length - 1;
        if (ArithmeticUtils.isPowerOfTwo(r2) == false) goto L17;
        double r6 = 0.5d;
        if (r2 != 1) goto L8;
        double r8 = r23[0];
        double r10 = r23[1];
        r1[0] = (r8 + r10) * 0.5d;
        r1[1] = (r23[0] - r10) * 0.5d;
        return r1;
    L8:
        double[] r4 = new double[r2];
        r4[0] = (r23[0] + r23[r2]) * 0.5d;
        int r9 = r2 >> 1;
        r4[r9] = r23[r9];
        double r11 = (r23[0] - r23[r2]) * 0.5d;
        int r12 = 1;
    L9:
        if (r12 >= r9) goto L11;
        int r14 = r2 - r12;
        double r13 = (r23[r12] + r23[r14]) * r6;
        double[] r17 = r4;
        double r7 = (((double) r12) * 3.141592653589793d) / ((double) r2);
        double r3 = FastMath.sin(r7) * (r23[r12] - r23[r14]);
        double r15 = FastMath.cos(r7) * (r23[r12] - r23[r14]);
        r17[r12] = r13 - r3;
        r17[r14] = r13 + r3;
        r11 = r11 + r15;
        r12 = r12 + 1;
        r4 = r17;
        r6 = 0.5d;
        goto L9
    L11:
        Complex[] r0 = new FastFourierTransformer(DftNormalization.STANDARD).transform(r4, TransformType.FORWARD);
        r1[0] = r0[0].getReal();
        int r5 = 1;
        r1[1] = r11;
        int r16 = 1;
    L12:
        if (r16 >= r9) goto L14;
        int r18 = r16 * 2;
        r1[r18] = r0[r16].getReal();
        r1[r18 + 1] = r1[r18 - r5] - r0[r16].getImaginary();
        r16 = r16 + 1;
        r5 = 1;
        goto L12
    L14:
        r1[r2] = r0[r9].getReal();
        return r1;
    L17:
        throw new MathIllegalArgumentException(LocalizedFormats.NOT_POWER_OF_TWO_PLUS_ONE, new Object[]{Integer.valueOf(r23.length)});
    }
}
