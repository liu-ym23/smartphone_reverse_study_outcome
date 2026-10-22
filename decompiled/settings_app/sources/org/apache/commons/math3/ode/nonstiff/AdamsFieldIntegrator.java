package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.linear.Array2DRowFieldMatrix;
import org.apache.commons.math3.ode.FieldExpandableODE;
import org.apache.commons.math3.ode.FieldODEState;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.ode.MultistepFieldIntegrator;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AdamsFieldIntegrator<T extends RealFieldElement<T>> extends MultistepFieldIntegrator<T> {
    private final AdamsNordsieckFieldTransformer<T> transformer;

    @Override // org.apache.commons.math3.ode.FirstOrderFieldIntegrator
    public abstract FieldODEStateAndDerivative<T> integrate(FieldExpandableODE<T> r1, FieldODEState<T> r2, T r3) throws NumberIsTooSmallException, DimensionMismatchException, MaxCountExceededException, NoBracketingException;

    public AdamsFieldIntegrator(Field<T> r1, String r2, int r3, int r4, double r5, double r7, double r9, double r11) throws NumberIsTooSmallException {
        super(r1, r2, r3, r4, r5, r7, r9, r11);
        this.transformer = AdamsNordsieckFieldTransformer.getInstance(r1, r3);
    }

    public AdamsFieldIntegrator(Field<T> r1, String r2, int r3, int r4, double r5, double r7, double[] r9, double[] r10) throws IllegalArgumentException {
        super(r1, r2, r3, r4, r5, r7, r9, r10);
        this.transformer = AdamsNordsieckFieldTransformer.getInstance(r1, r3);
    }

    @Override // org.apache.commons.math3.ode.MultistepFieldIntegrator
    protected Array2DRowFieldMatrix<T> initializeHighOrderDerivatives(T r1, T[] r2, T[][] r3, T[][] r4) {
        return this.transformer.initializeHighOrderDerivatives(r1, r2, r3, r4);
    }

    public Array2DRowFieldMatrix<T> updateHighOrderDerivativesPhase1(Array2DRowFieldMatrix<T> r1) {
        return this.transformer.updateHighOrderDerivativesPhase1(r1);
    }

    public void updateHighOrderDerivativesPhase2(T[] r1, T[] r2, Array2DRowFieldMatrix<T> r3) {
        this.transformer.updateHighOrderDerivativesPhase2(r1, r2, r3);
    }
}
