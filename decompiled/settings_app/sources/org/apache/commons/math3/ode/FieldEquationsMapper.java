package org.apache.commons.math3.ode;

import java.io.Serializable;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class FieldEquationsMapper<T extends RealFieldElement<T>> implements Serializable {
    private static final long serialVersionUID = 20151114;
    private final int[] start;

    FieldEquationsMapper(FieldEquationsMapper<T> r4, int r5) {
        if (r4 != null) goto L5;
        int r1 = 0;
    L6:
        int[] r2 = new int[r1 + 2];
        this.start = r2;
        if (r4 != null) goto L9;
        r2[0] = 0;
    L10:
        r2[r1 + 1] = r2[r1] + r5;
        return;
    L9:
        System.arraycopy(r4.start, 0, r2, 0, r1 + 1);
        goto L10
    L5:
        r1 = r4.getNumberOfEquations();
        goto L6
    }

    public int getNumberOfEquations() {
        return this.start.length - 1;
    }

    public int getTotalDimension() {
        int[] r1 = this.start;
        return r1[r1.length - 1];
    }

    public T[] mapState(FieldODEState<T> r4) {
        T[] r0 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(r4.getTime().getField(), getTotalDimension()));
        int r2 = 0;
        insertEquationData(0, r4.getState(), r0);
    L3:
        r2 = r2 + 1;
        if (r2 >= getNumberOfEquations()) goto L6;
        insertEquationData(r2, r4.getSecondaryState(r2), r0);
        goto L3
    L6:
        return r0;
    }

    public T[] mapDerivative(FieldODEStateAndDerivative<T> r4) {
        T[] r0 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(r4.getTime().getField(), getTotalDimension()));
        int r2 = 0;
        insertEquationData(0, r4.getDerivative(), r0);
    L3:
        r2 = r2 + 1;
        if (r2 >= getNumberOfEquations()) goto L6;
        insertEquationData(r2, r4.getSecondaryDerivative(r2), r0);
        goto L3
    L6:
        return r0;
    }

    public FieldODEStateAndDerivative<T> mapStateAndDerivative(T r9, T[] r10, T[] r11) throws DimensionMismatchException {
        if (r10.length != getTotalDimension()) goto L19;
        if (r11.length != getTotalDimension()) goto L17;
        int r0 = getNumberOfEquations();
        int r1 = 0;
        RealFieldElement[] r4 = extractEquationData(0, r10);
        RealFieldElement[] r5 = extractEquationData(0, r11);
        if (r0 < 2) goto L9;
        int r2 = r0 - 1;
        RealFieldElement[][] r6 = (RealFieldElement[][]) MathArrays.buildArray(r9.getField(), r2, -1);
        RealFieldElement[][] r7 = (RealFieldElement[][]) MathArrays.buildArray(r9.getField(), r2, -1);
    L11:
        r1 = r1 + 1;
        if (r1 >= getNumberOfEquations()) goto L15;
        int r3 = r1 - 1;
        r6[r3] = extractEquationData(r1, r10);
        r7[r3] = extractEquationData(r1, r11);
        goto L11
    L15:
        return new FieldODEStateAndDerivative(r9, r4, r5, r6, r7);
    L9:
        return new FieldODEStateAndDerivative(r9, r4, r5);
    L17:
        throw new DimensionMismatchException(r11.length, getTotalDimension());
    L19:
        throw new DimensionMismatchException(r10.length, getTotalDimension());
    }

    public T[] extractEquationData(int r3, T[] r4) throws MathIllegalArgumentException, DimensionMismatchException {
        checkIndex(r3);
        int[] r2 = this.start;
        int r0 = r2[r3];
        int r5 = r2[r3 + 1];
        if (r4.length < r5) goto L7;
        int r6 = r5 - r0;
        T[] r1 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(r4[0].getField(), r6));
        System.arraycopy(r4, r0, r1, 0, r6);
        return r1;
    L7:
        throw new DimensionMismatchException(r4.length, r5);
    }

    public void insertEquationData(int r3, T[] r4, T[] r5) throws DimensionMismatchException {
        checkIndex(r3);
        int[] r2 = this.start;
        int r0 = r2[r3];
        int r6 = r2[r3 + 1];
        int r7 = r6 - r0;
        if (r5.length < r6) goto L11;
        if (r4.length != r7) goto L9;
        System.arraycopy(r4, 0, r5, r0, r7);
        return;
    L9:
        throw new DimensionMismatchException(r4.length, r7);
    L11:
        throw new DimensionMismatchException(r5.length, r6);
    }

    private void checkIndex(int r6) throws MathIllegalArgumentException {
        if (r6 < 0) goto L8;
        if (r6 > (this.start.length - 2)) goto L8;
        return;
    L8:
        throw new MathIllegalArgumentException(LocalizedFormats.ARGUMENT_OUTSIDE_DOMAIN, new Object[]{Integer.valueOf(r6), 0, Integer.valueOf(this.start.length - 2)});
    }
}
