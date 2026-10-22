package org.apache.commons.math3.analysis.interpolation;

import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.random.UnitSphereRandomVectorGenerator;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class MicrosphereInterpolator implements MultivariateInterpolator {
    public static final int DEFAULT_BRIGHTNESS_EXPONENT = 2;
    public static final int DEFAULT_MICROSPHERE_ELEMENTS = 2000;
    private final int brightnessExponent;
    private final int microsphereElements;

    public MicrosphereInterpolator() {
        this(2000, 2);
    }

    public MicrosphereInterpolator(int r1, int r2) throws NotPositiveException, NotStrictlyPositiveException {
        if (r2 < 0) goto L10;
        if (r1 <= 0) goto L8;
        this.microsphereElements = r1;
        this.brightnessExponent = r2;
        return;
    L8:
        throw new NotStrictlyPositiveException(Integer.valueOf(r1));
    L10:
        throw new NotPositiveException(Integer.valueOf(r2));
    }

    @Override // org.apache.commons.math3.analysis.interpolation.MultivariateInterpolator
    public MultivariateFunction interpolate(double[][] r8, double[] r9) throws DimensionMismatchException, NoDataException, NullArgumentException {
        UnitSphereRandomVectorGenerator r5 = new UnitSphereRandomVectorGenerator(r8[0].length);
        return new MicrosphereInterpolatingFunction(r8, r9, this.brightnessExponent, this.microsphereElements, r5);
    }
}
