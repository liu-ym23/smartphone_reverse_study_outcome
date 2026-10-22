package org.apache.commons.math3.linear;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class FieldLUDecomposition<T extends FieldElement<T>> {
    private FieldMatrix<T> cachedL;
    private FieldMatrix<T> cachedP;
    private FieldMatrix<T> cachedU;
    private boolean even;
    private final Field<T> field;
    private T[][] lu;
    private int[] pivot;
    private boolean singular;

    /* JADX INFO: renamed from: org.apache.commons.math3.linear.FieldLUDecomposition$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class Solver<T extends FieldElement<T>> implements FieldDecompositionSolver<T> {
        private final Field<T> field;
        private final T[][] lu;
        private final int[] pivot;
        private final boolean singular;

        /* synthetic */ Solver(Field r1, FieldElement[][] r2, int[] r3, boolean r4, AnonymousClass1 r5) {
            this(r1, r2, r3, r4);
        }

        private Solver(Field<T> r1, T[][] r2, int[] r3, boolean r4) {
            this.field = r1;
            this.lu = r2;
            this.pivot = r3;
            this.singular = r4;
        }

        @Override // org.apache.commons.math3.linear.FieldDecompositionSolver
        public boolean isNonSingular() {
            return !this.singular;
        }

        @Override // org.apache.commons.math3.linear.FieldDecompositionSolver
        public FieldVector<T> solve(FieldVector<T> r9) {
            return solve((ArrayFieldVector) r9);
        L4:
            int r0 = this.pivot.length;
            if (r9.getDimension() != r0) goto L28;
            if (this.singular == true) goto L26;
            FieldElement[] r1 = (FieldElement[]) MathArrays.buildArray(this.field, r0);
            int r3 = 0;
        L9:
            if (r3 >= r0) goto L11;
            r1[r3] = r9.getEntry(this.pivot[r3]);
            r3 = r3 + 1;
            goto L9
        L11:
            int r10 = 0;
        L12:
            if (r10 >= r0) goto L17;
            FieldElement r4 = r1[r10];
            int r5 = r10 + 1;
            int r6 = r5;
        L14:
            if (r6 >= r0) goto L16;
            r1[r6] = (FieldElement) r1[r6].subtract(r4.multiply(this.lu[r6][r10]));
            r6 = r6 + 1;
            goto L14
        L16:
            r10 = r5;
            goto L12
        L17:
            int r2 = r0 - 1;
        L18:
            if (r2 < 0) goto L24;
            FieldElement r11 = (FieldElement) r1[r2].divide(this.lu[r2][r2]);
            r1[r2] = r11;
            int r7 = 0;
        L20:
            if (r7 >= r2) goto L22;
            r1[r7] = (FieldElement) r1[r7].subtract(r11.multiply(this.lu[r7][r2]));
            r7 = r7 + 1;
            goto L20
        L22:
            r2 = r2 - 1;
            goto L18
        L24:
            return new ArrayFieldVector(this.field, r1, false);
        L26:
            throw new SingularMatrixException();
        L28:
            throw new DimensionMismatchException(r9.getDimension(), r0);
        }

        public ArrayFieldVector<T> solve(ArrayFieldVector<T> r9) {
            int r0 = this.pivot.length;
            int r1 = r9.getDimension();
            if (r1 != r0) goto L26;
            if (this.singular == true) goto L24;
            FieldElement[] r2 = (FieldElement[]) MathArrays.buildArray(this.field, r0);
            int r3 = 0;
        L7:
            if (r3 >= r0) goto L9;
            r2[r3] = r9.getEntry(this.pivot[r3]);
            r3 = r3 + 1;
            goto L7
        L9:
            int r10 = 0;
        L10:
            if (r10 >= r0) goto L15;
            FieldElement r4 = r2[r10];
            int r5 = r10 + 1;
            int r6 = r5;
        L12:
            if (r6 >= r0) goto L14;
            r2[r6] = (FieldElement) r2[r6].subtract(r4.multiply(this.lu[r6][r10]));
            r6 = r6 + 1;
            goto L12
        L14:
            r10 = r5;
            goto L10
        L15:
            int r7 = r0 - 1;
        L16:
            if (r7 < 0) goto L22;
            FieldElement r11 = (FieldElement) r2[r7].divide(this.lu[r7][r7]);
            r2[r7] = r11;
            int r8 = 0;
        L18:
            if (r8 >= r7) goto L20;
            r2[r8] = (FieldElement) r2[r8].subtract(r11.multiply(this.lu[r8][r7]));
            r8 = r8 + 1;
            goto L18
        L20:
            r7 = r7 - 1;
            goto L16
        L22:
            return new ArrayFieldVector(r2, false);
        L24:
            throw new SingularMatrixException();
        L26:
            throw new DimensionMismatchException(r1, r0);
        }

        @Override // org.apache.commons.math3.linear.FieldDecompositionSolver
        public FieldMatrix<T> solve(FieldMatrix<T> r13) {
            int r0 = this.pivot.length;
            if (r13.getRowDimension() != r0) goto L38;
            if (this.singular == true) goto L36;
            int r1 = r13.getColumnDimension();
            FieldElement[][] r2 = (FieldElement[][]) MathArrays.buildArray(this.field, r0, r1);
            int r4 = 0;
        L7:
            if (r4 >= r0) goto L12;
            FieldElement[] r5 = r2[r4];
            int r6 = this.pivot[r4];
            int r7 = 0;
        L9:
            if (r7 >= r1) goto L11;
            r5[r7] = r13.getEntry(r6, r7);
            r7 = r7 + 1;
            goto L9
        L11:
            r4 = r4 + 1;
            goto L7
        L12:
            int r14 = 0;
        L13:
            if (r14 >= r0) goto L21;
            FieldElement[] r8 = r2[r14];
            int r9 = r14 + 1;
            int r10 = r9;
        L15:
            if (r10 >= r0) goto L20;
            FieldElement[] r11 = r2[r10];
            T r12 = this.lu[r10][r14];
            int r15 = 0;
        L17:
            if (r15 >= r1) goto L19;
            r11[r15] = (FieldElement) r11[r15].subtract(r8[r15].multiply(r12));
            r15 = r15 + 1;
            goto L17
        L19:
            r10 = r10 + 1;
            goto L15
        L20:
            r14 = r9;
            goto L13
        L21:
            int r3 = r0 - 1;
        L22:
            if (r3 < 0) goto L34;
            FieldElement[] r16 = r2[r3];
            T r17 = this.lu[r3][r3];
            int r18 = 0;
        L24:
            if (r18 >= r1) goto L26;
            r16[r18] = (FieldElement) r16[r18].divide(r17);
            r18 = r18 + 1;
            goto L24
        L26:
            int r19 = 0;
        L27:
            if (r19 >= r3) goto L32;
            FieldElement[] r20 = r2[r19];
            T r21 = this.lu[r19][r3];
            int r22 = 0;
        L29:
            if (r22 >= r1) goto L31;
            r20[r22] = (FieldElement) r20[r22].subtract(r16[r22].multiply(r21));
            r22 = r22 + 1;
            goto L29
        L31:
            r19 = r19 + 1;
            goto L27
        L32:
            r3 = r3 - 1;
            goto L22
        L34:
            return new Array2DRowFieldMatrix(this.field, r2, false);
        L36:
            throw new SingularMatrixException();
        L38:
            throw new DimensionMismatchException(r13.getRowDimension(), r0);
        }

        @Override // org.apache.commons.math3.linear.FieldDecompositionSolver
        public FieldMatrix<T> getInverse() {
            int r0 = this.pivot.length;
            T r1 = this.field.getOne();
            Array2DRowFieldMatrix r2 = new Array2DRowFieldMatrix(this.field, r0, r0);
            int r3 = 0;
        L3:
            if (r3 >= r0) goto L6;
            r2.setEntry(r3, r3, r1);
            r3 = r3 + 1;
            goto L3
        L6:
            return solve(r2);
        }
    }

    public FieldLUDecomposition(FieldMatrix<T> r11) {
        if (r11.isSquare() == false) goto L38;
        int r0 = r11.getColumnDimension();
        this.field = r11.getField();
        this.lu = (T[][]) r11.getData();
        this.pivot = new int[r0];
        this.cachedL = null;
        this.cachedU = null;
        this.cachedP = null;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        this.pivot[r1] = r1;
        r1 = r1 + 1;
        goto L5
    L7:
        this.even = true;
        this.singular = false;
        int r2 = 0;
    L8:
        if (r2 >= r0) goto L36;
        T r3 = this.field.getZero();
        int r4 = 0;
    L10:
        if (r4 >= r2) goto L15;
        FieldElement[] r5 = this.lu[r4];
        FieldElement r6 = r5[r2];
        int r7 = 0;
    L12:
        if (r7 >= r4) goto L14;
        r6 = (FieldElement) r6.subtract(r5[r7].multiply(this.lu[r7][r2]));
        r7 = r7 + 1;
        goto L12
    L14:
        r5[r2] = r6;
        r4 = r4 + 1;
        goto L10
    L15:
        int r8 = r2;
        int r9 = r8;
    L16:
        if (r8 >= r0) goto L24;
        FieldElement[] r10 = this.lu[r8];
        FieldElement r12 = r10[r2];
        int r13 = 0;
    L18:
        if (r13 >= r2) goto L20;
        r12 = (FieldElement) r12.subtract(r10[r13].multiply(this.lu[r13][r2]));
        r13 = r13 + 1;
        goto L18
    L20:
        r10[r2] = r12;
        if (this.lu[r9][r2].equals(this.field.getZero()) == false) goto L23;
        r9 = r9 + 1;
    L23:
        r8 = r8 + 1;
        goto L16
    L24:
        if (r9 >= r0) goto L25;
        if (r9 == r2) goto L32;
        T r14 = this.field.getZero();
        int r15 = 0;
    L29:
        if (r15 >= r0) goto L31;
        T[][] r16 = this.lu;
        T[] r17 = r16[r9];
        T r18 = r17[r15];
        r17[r15] = r16[r2][r15];
        r16[r2][r15] = r18;
        r15 = r15 + 1;
        goto L29
    L31:
        int[] r19 = this.pivot;
        int r20 = r19[r9];
        r19[r9] = r19[r2];
        r19[r2] = r20;
        this.even = !this.even;
    L32:
        T r21 = this.lu[r2][r2];
        int r22 = r2 + 1;
        int r23 = r22;
    L33:
        if (r23 >= r0) goto L35;
        FieldElement[] r24 = this.lu[r23];
        r24[r2] = (FieldElement) r24[r2].divide(r21);
        r23 = r23 + 1;
        goto L33
    L35:
        r2 = r22;
        goto L8
    L25:
        this.singular = true;
        return;
    L36:
        return;
    L38:
        throw new NonSquareMatrixException(r11.getRowDimension(), r11.getColumnDimension());
    }

    public FieldMatrix<T> getL() {
        if (this.cachedL != null) goto L13;
        if (this.singular == true) goto L13;
        int r0 = this.pivot.length;
        this.cachedL = new Array2DRowFieldMatrix(this.field, r0, r0);
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L13;
        T[] r3 = this.lu[r2];
        int r4 = 0;
    L9:
        if (r4 >= r2) goto L11;
        this.cachedL.setEntry(r2, r4, r3[r4]);
        r4 = r4 + 1;
        goto L9
    L11:
        this.cachedL.setEntry(r2, r2, this.field.getOne());
        r2 = r2 + 1;
    L13:
        return this.cachedL;
    }

    public FieldMatrix<T> getU() {
        if (this.cachedU != null) goto L13;
        if (this.singular == true) goto L13;
        int r0 = this.pivot.length;
        this.cachedU = new Array2DRowFieldMatrix(this.field, r0, r0);
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L13;
        T[] r2 = this.lu[r1];
        int r3 = r1;
    L9:
        if (r3 >= r0) goto L11;
        this.cachedU.setEntry(r1, r3, r2[r3]);
        r3 = r3 + 1;
        goto L9
    L11:
        r1 = r1 + 1;
    L13:
        return this.cachedU;
    }

    public FieldMatrix<T> getP() {
        if (this.cachedP != null) goto L10;
        if (this.singular == true) goto L10;
        int r0 = this.pivot.length;
        this.cachedP = new Array2DRowFieldMatrix(this.field, r0, r0);
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L10;
        this.cachedP.setEntry(r1, this.pivot[r1], this.field.getOne());
        r1 = r1 + 1;
    L10:
        return this.cachedP;
    }

    public int[] getPivot() {
        return (int[]) this.pivot.clone();
    }

    public T getDeterminant() {
        if (this.singular == true) goto L5;
        int r0 = this.pivot.length;
        if (this.even == false) goto L9;
        Object r1 = this.field.getOne();
    L10:
        T r2 = (T) r1;
        int r3 = 0;
    L11:
        if (r3 >= r0) goto L13;
        r2 = (T) r2.multiply(this.lu[r3][r3]);
        r3 = r3 + 1;
        goto L11
    L13:
        return r2;
    L9:
        r1 = this.field.getZero().subtract(this.field.getOne());
        goto L10
    L5:
        return this.field.getZero();
    }

    public FieldDecompositionSolver<T> getSolver() {
        return new Solver(this.field, this.lu, this.pivot, this.singular, null);
    }
}
