package org.apache.commons.math3.complex;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class ComplexUtils {
    private ComplexUtils() {
    }

    public static Complex polar2Complex(double r3, double r5) throws MathIllegalArgumentException {
        if (r3 < 0.0d) goto L7;
        return new Complex(FastMath.cos(r5) * r3, r3 * FastMath.sin(r5));
    L7:
        throw new MathIllegalArgumentException(LocalizedFormats.NEGATIVE_COMPLEX_MODULE, new Object[]{Double.valueOf(r3)});
    }

    public static Complex[] convertToComplex(double[] r7) {
        Complex[] r0 = new Complex[r7.length];
        int r1 = 0;
    L4:
        if (r1 >= r7.length) goto L6;
        r0[r1] = new Complex(r7[r1], 0.0d);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }
}
