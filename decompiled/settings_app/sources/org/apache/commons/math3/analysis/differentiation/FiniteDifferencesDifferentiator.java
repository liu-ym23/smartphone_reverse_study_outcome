package org.apache.commons.math3.analysis.differentiation;

import java.io.Serializable;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateMatrixFunction;
import org.apache.commons.math3.analysis.UnivariateVectorFunction;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class FiniteDifferencesDifferentiator implements UnivariateFunctionDifferentiator, UnivariateVectorFunctionDifferentiator, UnivariateMatrixFunctionDifferentiator, Serializable {
    private static final long serialVersionUID = 20120917;
    private final double halfSampleSpan;
    private final int nbPoints;
    private final double stepSize;
    private final double tMax;
    private final double tMin;

    static /* synthetic */ int access$000(FiniteDifferencesDifferentiator r0) {
        return r0.nbPoints;
    }

    static /* synthetic */ double access$100(FiniteDifferencesDifferentiator r2) {
        return r2.tMax;
    }

    static /* synthetic */ double access$200(FiniteDifferencesDifferentiator r2) {
        return r2.tMin;
    }

    static /* synthetic */ double access$300(FiniteDifferencesDifferentiator r2) {
        return r2.halfSampleSpan;
    }

    static /* synthetic */ double access$400(FiniteDifferencesDifferentiator r2) {
        return r2.stepSize;
    }

    static /* synthetic */ DerivativeStructure access$500(FiniteDifferencesDifferentiator r0, DerivativeStructure r1, double r2, double[] r4) throws NumberIsTooLargeException {
        return r0.evaluate(r1, r2, r4);
    }

    public FiniteDifferencesDifferentiator(int r9, double r10) throws NotPositiveException, NumberIsTooSmallException {
        this(r9, r10, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public FiniteDifferencesDifferentiator(int r8, double r9, double r11, double r13) throws NotPositiveException, NumberIsTooSmallException, NumberIsTooLargeException {
        if (r8 <= 1) goto L15;
        this.nbPoints = r8;
        if (r9 <= 0.0d) goto L13;
        this.stepSize = r9;
        double r10 = (r9 * 0.5d) * ((double) (r8 - 1));
        this.halfSampleSpan = r10;
        double r5 = r13 - r11;
        if ((r10 * 2.0d) >= r5) goto L11;
        double r0 = FastMath.ulp(r10);
        this.tMin = (r11 + r10) + r0;
        this.tMax = (r13 - r10) - r0;
        return;
    L11:
        throw new NumberIsTooLargeException(Double.valueOf(r10 * 2.0d), Double.valueOf(r5), false);
    L13:
        throw new NotPositiveException(Double.valueOf(r9));
    L15:
        throw new NumberIsTooSmallException(Double.valueOf(r9), 1, false);
    }

    public int getNbPoints() {
        return this.nbPoints;
    }

    public double getStepSize() {
        return this.stepSize;
    }

    private DerivativeStructure evaluate(DerivativeStructure r16, double r17, double[] r19) throws NumberIsTooLargeException {
        int r1 = this.nbPoints;
        double[] r2 = new double[r1];
        double[] r3 = new double[r1];
        int r4 = 0;
    L4:
        if (r4 >= this.nbPoints) goto L9;
        r3[r4] = r19[r4];
        int r5 = 1;
    L6:
        if (r5 > r4) goto L8;
        int r6 = r4 - r5;
        r3[r6] = (r3[r6 + 1] - r3[r6]) / (((double) r5) * this.stepSize);
        r5 = r5 + 1;
        goto L6
    L8:
        r2[r4] = r3[0];
        r4 = r4 + 1;
        goto L4
    L9:
        int r7 = r16.getOrder();
        int r8 = r16.getFreeParameters();
        double[] r9 = r16.getAllDerivatives();
        double r10 = r16.getValue() - r17;
        DerivativeStructure r11 = new DerivativeStructure(r8, r7, 0.0d);
        DerivativeStructure r12 = null;
        int r13 = 0;
    L11:
        if (r13 >= this.nbPoints) goto L16;
        if (r13 != 0) goto L14;
        r12 = new DerivativeStructure(r8, r7, 1.0d);
    L15:
        r11 = r11.add(r12.multiply2(r2[r13]));
        r13 = r13 + 1;
        goto L11
    L14:
        r9[0] = r10 - (((double) (r13 - 1)) * this.stepSize);
        r12 = r12.multiply(new DerivativeStructure(r8, r7, r9));
        goto L15
    L16:
        return r11;
    }

    @Override // org.apache.commons.math3.analysis.differentiation.UnivariateFunctionDifferentiator
    public UnivariateDifferentiableFunction differentiate(final UnivariateFunction r2) {
        return new AnonymousClass1(this, r2);
    }

    @Override // org.apache.commons.math3.analysis.differentiation.UnivariateVectorFunctionDifferentiator
    public UnivariateDifferentiableVectorFunction differentiate(final UnivariateVectorFunction r2) {
        return new AnonymousClass2(this, r2);
    }

    @Override // org.apache.commons.math3.analysis.differentiation.UnivariateMatrixFunctionDifferentiator
    public UnivariateDifferentiableMatrixFunction differentiate(final UnivariateMatrixFunction r2) {
        return new AnonymousClass3(this, r2);
    }
}
