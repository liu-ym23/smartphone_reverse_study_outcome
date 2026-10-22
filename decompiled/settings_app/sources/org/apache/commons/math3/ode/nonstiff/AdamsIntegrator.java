package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.ode.ExpandableStatefulODE;
import org.apache.commons.math3.ode.MultistepIntegrator;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AdamsIntegrator extends MultistepIntegrator {
    private final AdamsNordsieckTransformer transformer;

    @Override // org.apache.commons.math3.ode.nonstiff.AdaptiveStepsizeIntegrator, org.apache.commons.math3.ode.AbstractIntegrator
    public abstract void integrate(ExpandableStatefulODE r1, double r2) throws NumberIsTooSmallException, DimensionMismatchException, MaxCountExceededException, NoBracketingException;

    public AdamsIntegrator(String r1, int r2, int r3, double r4, double r6, double r8, double r10) throws NumberIsTooSmallException {
        super(r1, r2, r3, r4, r6, r8, r10);
        this.transformer = AdamsNordsieckTransformer.getInstance(r2);
    }

    public AdamsIntegrator(String r1, int r2, int r3, double r4, double r6, double[] r8, double[] r9) throws IllegalArgumentException {
        super(r1, r2, r3, r4, r6, r8, r9);
        this.transformer = AdamsNordsieckTransformer.getInstance(r2);
    }

    @Override // org.apache.commons.math3.ode.MultistepIntegrator
    protected Array2DRowRealMatrix initializeHighOrderDerivatives(double r7, double[] r9, double[][] r10, double[][] r11) {
        return this.transformer.initializeHighOrderDerivatives(r7, r9, r10, r11);
    }

    public Array2DRowRealMatrix updateHighOrderDerivativesPhase1(Array2DRowRealMatrix r1) {
        return this.transformer.updateHighOrderDerivativesPhase1(r1);
    }

    public void updateHighOrderDerivativesPhase2(double[] r1, double[] r2, Array2DRowRealMatrix r3) {
        this.transformer.updateHighOrderDerivativesPhase2(r1, r2, r3);
    }
}
