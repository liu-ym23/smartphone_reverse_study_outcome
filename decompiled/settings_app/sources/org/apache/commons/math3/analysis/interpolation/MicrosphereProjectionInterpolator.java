package org.apache.commons.math3.analysis.interpolation;

import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.random.UnitSphereRandomVectorGenerator;

/* JADX INFO: loaded from: classes6.dex */
public class MicrosphereProjectionInterpolator implements MultivariateInterpolator {
    private final double exponent;
    private final InterpolatingMicrosphere microsphere;
    private final double noInterpolationTolerance;
    private final boolean sharedSphere;

    static /* synthetic */ double access$000(MicrosphereProjectionInterpolator r2) {
        return r2.exponent;
    }

    static /* synthetic */ double access$100(MicrosphereProjectionInterpolator r2) {
        return r2.noInterpolationTolerance;
    }

    public MicrosphereProjectionInterpolator(int r12, int r13, double r14, double r16, double r18, double r20, boolean r22, double r23) {
        this(new InterpolatingMicrosphere(r12, r13, r14, r16, r18, new UnitSphereRandomVectorGenerator(r12)), r20, r22, r23);
    }

    public MicrosphereProjectionInterpolator(InterpolatingMicrosphere r3, double r4, boolean r6, double r7) throws NotPositiveException {
        if (r4 < 0.0d) goto L7;
        this.microsphere = r3;
        this.exponent = r4;
        this.sharedSphere = r6;
        this.noInterpolationTolerance = r7;
        return;
    L7:
        throw new NotPositiveException(Double.valueOf(r4));
    }

    @Override // org.apache.commons.math3.analysis.interpolation.MultivariateInterpolator
    public MultivariateFunction interpolate(final double[][] r4, final double[] r5) throws DimensionMismatchException, NoDataException, NullArgumentException {
        if (r4 == null) goto L27;
        if (r5 == null) goto L27;
        if (r4.length == 0) goto L25;
        if (r4.length != r5.length) goto L23;
        if (r4[0] == null) goto L21;
        int r1 = this.microsphere.getDimension();
        if (r1 != r4[0].length) goto L19;
        if (this.sharedSphere == false) goto L15;
        final InterpolatingMicrosphere r0 = this.microsphere;
    L17:
        return new AnonymousClass1(this, r0, r4, r5);
    L15:
        r0 = this.microsphere.copy();
        goto L17
    L19:
        throw new DimensionMismatchException(r4[0].length, r1);
    L21:
        throw new NullArgumentException();
    L23:
        throw new DimensionMismatchException(r4.length, r5.length);
    L25:
        throw new NoDataException();
    L27:
        throw new NullArgumentException();
    }
}
