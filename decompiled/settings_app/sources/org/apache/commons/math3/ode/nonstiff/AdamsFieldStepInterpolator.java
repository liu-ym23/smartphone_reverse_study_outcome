package org.apache.commons.math3.ode.nonstiff;

import java.util.Arrays;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.linear.Array2DRowFieldMatrix;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
class AdamsFieldStepInterpolator<T extends RealFieldElement<T>> extends AbstractFieldStepInterpolator<T> {
    private final Array2DRowFieldMatrix<T> nordsieck;
    private final FieldODEStateAndDerivative<T> reference;
    private final T[] scaled;
    private T scalingH;

    @Override // org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator
    protected /* bridge */ /* synthetic */ AbstractFieldStepInterpolator create(boolean r1, FieldODEStateAndDerivative r2, FieldODEStateAndDerivative r3, FieldODEStateAndDerivative r4, FieldODEStateAndDerivative r5, FieldEquationsMapper r6) {
        return create(r1, r2, r3, r4, r5, r6);
    }

    AdamsFieldStepInterpolator(T r12, FieldODEStateAndDerivative<T> r13, T[] r14, Array2DRowFieldMatrix<T> r15, boolean r16, FieldODEStateAndDerivative<T> r17, FieldODEStateAndDerivative<T> r18, FieldEquationsMapper<T> r19) {
        this(r12, r13, r14, r15, r16, r17, r18, r17, r18, r19);
    }

    private AdamsFieldStepInterpolator(T r9, FieldODEStateAndDerivative<T> r10, T[] r11, Array2DRowFieldMatrix<T> r12, boolean r13, FieldODEStateAndDerivative<T> r14, FieldODEStateAndDerivative<T> r15, FieldODEStateAndDerivative<T> r16, FieldODEStateAndDerivative<T> r17, FieldEquationsMapper<T> r18) {
        super(r13, r14, r15, r16, r17, r18);
        this.scalingH = r9;
        this.reference = r10;
        this.scaled = (T[]) ((RealFieldElement[]) r11.clone());
        this.nordsieck = new Array2DRowFieldMatrix(r12.getData(), false);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator
    protected AdamsFieldStepInterpolator<T> create(boolean r13, FieldODEStateAndDerivative<T> r14, FieldODEStateAndDerivative<T> r15, FieldODEStateAndDerivative<T> r16, FieldODEStateAndDerivative<T> r17, FieldEquationsMapper<T> r18) {
        return new AdamsFieldStepInterpolator(this.scalingH, this.reference, this.scaled, this.nordsieck, r13, r14, r15, r16, r17, r18);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator
    protected FieldODEStateAndDerivative<T> computeInterpolatedStateAndDerivatives(FieldEquationsMapper<T> r1, T r2, T r3, T r4, T r5) {
        return taylor(this.reference, r2, this.scalingH, this.scaled, this.nordsieck);
    }

    public static <S extends RealFieldElement<S>> FieldODEStateAndDerivative<S> taylor(FieldODEStateAndDerivative<S> r10, S r11, S r12, S[] r13, Array2DRowFieldMatrix<S> r14) {
        RealFieldElement r0 = (RealFieldElement) r11.subtract(r10.getTime());
        RealFieldElement r15 = (RealFieldElement) r0.divide(r12);
        RealFieldElement[] r1 = (RealFieldElement[]) MathArrays.buildArray(r11.getField(), r13.length);
        Arrays.fill(r1, r11.getField().getZero());
        RealFieldElement[] r2 = (RealFieldElement[]) MathArrays.buildArray(r11.getField(), r13.length);
        Arrays.fill(r2, r11.getField().getZero());
        RealFieldElement[][] r16 = (RealFieldElement[][]) r14.getDataRef();
        int r3 = r16.length;
    L3:
        r3 = r3 - 1;
        int r4 = 0;
        if (r3 < 0) goto L10;
        int r5 = r3 + 2;
        RealFieldElement[] r6 = r16[r3];
        RealFieldElement r7 = (RealFieldElement) r15.pow(r5);
    L7:
        if (r4 >= r6.length) goto L3;
        RealFieldElement r8 = (RealFieldElement) r6[r4].multiply(r7);
        r1[r4] = (RealFieldElement) r1[r4].add(r8);
        r2[r4] = (RealFieldElement) r2[r4].add(r8.multiply(r5));
        r4 = r4 + 1;
        goto L7
    L10:
        S[] r17 = r10.getState();
    L12:
        if (r4 >= r1.length) goto L15;
        RealFieldElement r18 = (RealFieldElement) r1[r4].add(r13[r4].multiply(r15));
        r1[r4] = r18;
        r17[r4] = (RealFieldElement) r17[r4].add(r18);
        r2[r4] = (RealFieldElement) ((RealFieldElement) r2[r4].add(r13[r4].multiply(r15))).divide(r0);
        r4 = r4 + 1;
        goto L12
    L15:
        return new FieldODEStateAndDerivative(r11, r17, r2);
    }
}
