package org.apache.commons.math3.ode;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class FieldExpandableODE<T extends RealFieldElement<T>> {
    private List<FieldSecondaryEquations<T>> components;
    private FieldEquationsMapper<T> mapper;
    private final FirstOrderFieldDifferentialEquations<T> primary;

    public FieldExpandableODE(FirstOrderFieldDifferentialEquations<T> r3) {
        this.primary = r3;
        this.components = new ArrayList();
        this.mapper = new FieldEquationsMapper(null, r3.getDimension());
    }

    public FieldEquationsMapper<T> getMapper() {
        return this.mapper;
    }

    public int addSecondaryEquations(FieldSecondaryEquations<T> r3) {
        this.components.add(r3);
        this.mapper = new FieldEquationsMapper(this.mapper, r3.getDimension());
        return this.components.size();
    }

    public void init(T r6, T[] r7, T r8) {
        int r1 = 0;
        RealFieldElement[] r0 = this.mapper.extractEquationData(0, r7);
        this.primary.init(r6, r0, r8);
    L3:
        r1 = r1 + 1;
        if (r1 >= this.mapper.getNumberOfEquations()) goto L6;
        this.components.get(r1 - 1).init(r6, r0, this.mapper.extractEquationData(r1, r7), r8);
        goto L3
    }

    public T[] computeDerivatives(T r8, T[] r9) throws MaxCountExceededException, DimensionMismatchException {
        T[] r0 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(r8.getField(), this.mapper.getTotalDimension()));
        int r2 = 0;
        RealFieldElement[] r1 = this.mapper.extractEquationData(0, r9);
        RealFieldElement[] r3 = this.primary.computeDerivatives(r8, r1);
        this.mapper.insertEquationData(0, r3, r0);
    L3:
        r2 = r2 + 1;
        if (r2 >= this.mapper.getNumberOfEquations()) goto L6;
        this.mapper.insertEquationData(r2, this.components.get(r2 - 1).computeDerivatives(r8, r1, r3, this.mapper.extractEquationData(r2, r9)), r0);
        goto L3
    L6:
        return r0;
    }
}
