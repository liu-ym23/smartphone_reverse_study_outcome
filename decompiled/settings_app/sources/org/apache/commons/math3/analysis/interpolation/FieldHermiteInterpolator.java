package org.apache.commons.math3.analysis.interpolation;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class FieldHermiteInterpolator<T extends FieldElement<T>> {
    private final List<T> abscissae;
    private final List<T[]> bottomDiagonal;
    private final List<T[]> topDiagonal;

    public FieldHermiteInterpolator() {
        this.abscissae = new ArrayList();
        this.topDiagonal = new ArrayList();
        this.bottomDiagonal = new ArrayList();
    }

    public void addSamplePoint(T r14, T[]... r15) throws ZeroException, MathArithmeticException, DimensionMismatchException, NullArgumentException {
        MathUtils.checkNotNull(r14);
        FieldElement r0 = (FieldElement) r14.getField().getOne();
        int r2 = 0;
    L4:
        if (r2 >= r15.length) goto L23;
        FieldElement[] r3 = (FieldElement[]) r15[r2].clone();
        if (r2 <= 1) goto L11;
        r0 = (FieldElement) r0.multiply(r2);
        FieldElement r5 = (FieldElement) r0.reciprocal();
        int r6 = 0;
    L9:
        if (r6 >= r3.length) goto L11;
        r3[r6] = (FieldElement) r3[r6].multiply(r5);
        r6 = r6 + 1;
    L11:
        int r7 = this.abscissae.size();
        this.bottomDiagonal.add(r7 - r2, (T[]) r3);
        int r8 = r2;
        FieldElement[] r9 = r3;
    L12:
        if (r8 >= r7) goto L22;
        r8 = r8 + 1;
        int r10 = r7 - r8;
        T[] r11 = this.bottomDiagonal.get(r10);
        if (r14.equals(this.abscissae.get(r10)) == true) goto L21;
        FieldElement r12 = (FieldElement) ((FieldElement) r14.subtract(this.abscissae.get(r10))).reciprocal();
        int r13 = 0;
    L17:
        if (r13 >= r3.length) goto L19;
        r11[r13] = (FieldElement) r12.multiply(r9[r13].subtract(r11[r13]));
        r13 = r13 + 1;
        goto L17
    L19:
        r9 = r11;
        goto L12
    L21:
        throw new ZeroException(LocalizedFormats.DUPLICATED_ABSCISSA_DIVISION_BY_ZERO, new Object[]{r14});
    L22:
        this.topDiagonal.add((T[]) r9.clone());
        this.abscissae.add(r14);
        r2 = r2 + 1;
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T[] value(T r9) throws NoDataException, NullArgumentException {
        MathUtils.checkNotNull(r9);
        if (this.abscissae.isEmpty() == true) goto L14;
        T[] r0 = (T[]) ((FieldElement[]) MathArrays.buildArray(r9.getField(), this.topDiagonal.get(0).length));
        FieldElement r1 = (FieldElement) r9.getField().getOne();
        int r3 = 0;
    L6:
        if (r3 >= this.topDiagonal.size()) goto L12;
        T[] r4 = this.topDiagonal.get(r3);
        int r5 = 0;
    L9:
        if (r5 >= r0.length) goto L11;
        r0[r5] = (FieldElement) r0[r5].add(r4[r5].multiply(r1));
        r5 = r5 + 1;
        goto L9
    L11:
        r1 = (FieldElement) r1.multiply((FieldElement) r9.subtract(this.abscissae.get(r3)));
        r3 = r3 + 1;
        goto L6
    L12:
        return r0;
    L14:
        throw new NoDataException(LocalizedFormats.EMPTY_INTERPOLATION_SAMPLE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T[][] derivatives(T r14, int r15) throws NoDataException, NullArgumentException {
        MathUtils.checkNotNull(r14);
        if (this.abscissae.isEmpty() == true) goto L23;
        FieldElement r0 = (FieldElement) r14.getField().getZero();
        FieldElement r1 = (FieldElement) r14.getField().getOne();
        int r3 = r15 + 1;
        FieldElement[] r2 = (FieldElement[]) MathArrays.buildArray(r14.getField(), r3);
        r2[0] = r0;
        int r4 = 0;
    L5:
        if (r4 >= r15) goto L7;
        int r5 = r4 + 1;
        r2[r5] = (FieldElement) r2[r4].add(r1);
        r4 = r5;
        goto L5
    L7:
        T[][] r6 = (T[][]) ((FieldElement[][]) MathArrays.buildArray(r14.getField(), r3, this.topDiagonal.get(0).length));
        FieldElement[] r7 = (FieldElement[]) MathArrays.buildArray(r14.getField(), r3);
        r7[0] = (FieldElement) r14.getField().getOne();
        int r8 = 0;
    L9:
        if (r8 >= this.topDiagonal.size()) goto L21;
        T[] r9 = this.topDiagonal.get(r8);
        FieldElement r10 = (FieldElement) r14.subtract(this.abscissae.get(r8));
        int r11 = r15;
    L11:
        if (r11 < 0) goto L20;
        int r12 = 0;
    L13:
        FieldElement[] r13 = r6[r11];
        if (r12 >= r13.length) goto L16;
        r13[r12] = (FieldElement) r13[r12].add(r9[r12].multiply(r7[r11]));
        r12 = r12 + 1;
        goto L13
    L16:
        FieldElement r16 = (FieldElement) r7[r11].multiply(r10);
        r7[r11] = r16;
        if (r11 <= 0) goto L19;
        r7[r11] = (FieldElement) r16.add(r2[r11].multiply(r7[r11 - 1]));
    L19:
        r11 = r11 - 1;
        goto L11
    L20:
        r8 = r8 + 1;
        goto L9
    L21:
        return r6;
    L23:
        throw new NoDataException(LocalizedFormats.EMPTY_INTERPOLATION_SAMPLE);
    }
}
