package org.apache.commons.math3.ode.nonstiff;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.linear.Array2DRowFieldMatrix;
import org.apache.commons.math3.linear.ArrayFieldVector;
import org.apache.commons.math3.linear.FieldDecompositionSolver;
import org.apache.commons.math3.linear.FieldLUDecomposition;
import org.apache.commons.math3.linear.FieldMatrix;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class AdamsNordsieckFieldTransformer<T extends RealFieldElement<T>> {
    private static final Map<Integer, Map<Field<? extends RealFieldElement<?>>, AdamsNordsieckFieldTransformer<? extends RealFieldElement<?>>>> CACHE = null;
    private final T[] c1;
    private final Field<T> field;
    private final Array2DRowFieldMatrix<T> update;

    static {
        CACHE = new HashMap();
    }

    private AdamsNordsieckFieldTransformer(Field<T> r6, int r7) {
        this.field = r6;
        int r8 = r7 - 1;
        FieldMatrix<T> r0 = buildP(r8);
        FieldDecompositionSolver r1 = new FieldLUDecomposition(r0).getSolver();
        RealFieldElement[] r2 = (RealFieldElement[]) MathArrays.buildArray(r6, r8);
        Arrays.fill(r2, r6.getOne());
        this.c1 = (T[]) ((RealFieldElement[]) r1.solve(new ArrayFieldVector(r2, false)).toArray());
        RealFieldElement[][] r3 = (RealFieldElement[][]) r0.getData();
        int r4 = r3.length - 1;
    L3:
        if (r4 <= 0) goto L5;
        r3[r4] = r3[r4 - 1];
        r4 = r4 - 1;
        goto L3
    L5:
        RealFieldElement[] r9 = (RealFieldElement[]) MathArrays.buildArray(r6, r8);
        r3[0] = r9;
        Arrays.fill(r9, r6.getZero());
        this.update = new Array2DRowFieldMatrix(r1.solve(new Array2DRowFieldMatrix(r3, false)).getData());
    }

    public static <T extends RealFieldElement<T>> AdamsNordsieckFieldTransformer<T> getInstance(Field<T> r3, int r4) {
        Map<Integer, Map<Field<? extends RealFieldElement<?>>, AdamsNordsieckFieldTransformer<? extends RealFieldElement<?>>>> r0 = CACHE;
        monitor-enter(r0);
        Map r1 = r0.get(Integer.valueOf(r4));     // Catch: Throwable -> L12
        if (r1 != null) goto L7;
        r1 = new HashMap();     // Catch: Throwable -> L12
        r0.put(Integer.valueOf(r4), (Map<Field<? extends RealFieldElement<?>>, AdamsNordsieckFieldTransformer<? extends RealFieldElement<?>>>) r1);     // Catch: Throwable -> L12
    L7:
        AdamsNordsieckFieldTransformer<T> r2 = (AdamsNordsieckFieldTransformer) r1.get(r3);     // Catch: Throwable -> L12
        if (r2 != null) goto L10;
        r2 = new AdamsNordsieckFieldTransformer(r3, r4);     // Catch: Throwable -> L12
        r1.put(r3, r2);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L12:
        th = move-exception;
        throw th;
    }

    private FieldMatrix<T> buildP(int r9) {
        RealFieldElement[][] r10 = (RealFieldElement[][]) MathArrays.buildArray(this.field, r9, r9);
        int r1 = 1;
    L4:
        if (r1 > r10.length) goto L11;
        RealFieldElement[] r2 = r10[r1 - 1];
        int r3 = -r1;
        RealFieldElement r4 = (RealFieldElement) this.field.getZero().add(r3);
        int r5 = 1;
    L7:
        if (r5 > r2.length) goto L9;
        int r6 = r5 - 1;
        r5 = r5 + 1;
        r2[r6] = (RealFieldElement) r4.multiply(r5);
        r4 = (RealFieldElement) r4.multiply(r3);
        goto L7
    L9:
        r1 = r1 + 1;
        goto L4
    L11:
        return new Array2DRowFieldMatrix(r10, false);
    }

    public Array2DRowFieldMatrix<T> initializeHighOrderDerivatives(T r18, T[] r19, T[][] r20, T[][] r21) {
        Field<T> r2 = this.field;
        T[] r3 = this.c1;
        int r5 = 1;
        RealFieldElement[][] r4 = (RealFieldElement[][]) MathArrays.buildArray(r2, r3.length + 1, r3.length + 1);
        int r6 = 0;
        RealFieldElement[][] r7 = (RealFieldElement[][]) MathArrays.buildArray(this.field, this.c1.length + 1, r20[0].length);
        T[] r8 = r20[0];
        T[] r9 = r21[0];
        int r10 = 1;
    L4:
        if (r10 >= r20.length) goto L26;
        RealFieldElement r11 = (RealFieldElement) r19[r10].subtract(r19[r6]);
        RealFieldElement r12 = (RealFieldElement) r11.divide(r18);
        RealFieldElement r13 = (RealFieldElement) r18.reciprocal();
        int r14 = r10 * 2;
        int r15 = r14 - 2;
        RealFieldElement[] r16 = r4[r15];
        int r17 = r14 - r5;
        RealFieldElement[] r110 = null;
        if (r17 >= r4.length) goto L8;
        RealFieldElement[] r22 = r4[r17];
    L10:
        if (r6 >= r16.length) goto L15;
        r13 = (RealFieldElement) r13.multiply(r12);
        r16[r6] = (RealFieldElement) r11.multiply(r13);
        if (r22 == null) goto L14;
        r22[r6] = (RealFieldElement) r13.multiply(r6 + 2);
    L14:
        r6 = r6 + 1;
        goto L10
    L15:
        T[] r23 = r20[r10];
        T[] r24 = r21[r10];
        RealFieldElement[] r111 = r7[r15];
        if (r17 >= r7.length) goto L18;
        r110 = r7[r17];
    L18:
        int r112 = 0;
    L20:
        if (r112 >= r23.length) goto L25;
        r111[r112] = (RealFieldElement) ((RealFieldElement) r23[r112].subtract(r8[r112])).subtract(r11.multiply(r9[r112]));
        if (r110 == null) goto L24;
        r110[r112] = (RealFieldElement) r24[r112].subtract(r9[r112]);
    L24:
        r112 = r112 + 1;
        goto L20
    L25:
        r10 = r10 + 1;
        r5 = 1;
        r6 = 0;
        goto L4
    L8:
        r22 = null;
        goto L10
    L26:
        FieldMatrix r1 = new FieldLUDecomposition(new Array2DRowFieldMatrix(r4, false)).getSolver().solve(new Array2DRowFieldMatrix(r7, false));
        Array2DRowFieldMatrix<T> r25 = new Array2DRowFieldMatrix(this.field, r1.getRowDimension() - 1, r1.getColumnDimension());
        int r0 = 0;
    L28:
        if (r0 >= r25.getRowDimension()) goto L34;
        int r26 = 0;
    L31:
        if (r26 >= r25.getColumnDimension()) goto L33;
        r25.setEntry(r0, r26, r1.getEntry(r0, r26));
        r26 = r26 + 1;
        goto L31
    L33:
        r0 = r0 + 1;
        goto L28
    L34:
        return r25;
    }

    public Array2DRowFieldMatrix<T> updateHighOrderDerivativesPhase1(Array2DRowFieldMatrix<T> r1) {
        return (Array2DRowFieldMatrix<T>) this.update.multiply(r1);
    }

    public void updateHighOrderDerivativesPhase2(T[] r9, T[] r10, Array2DRowFieldMatrix<T> r11) {
        RealFieldElement[][] r12 = (RealFieldElement[][]) r11.getDataRef();
        int r1 = 0;
    L4:
        if (r1 >= r12.length) goto L10;
        RealFieldElement[] r2 = r12[r1];
        T r3 = this.c1[r1];
        int r4 = 0;
    L7:
        if (r4 >= r2.length) goto L9;
        r2[r4] = (RealFieldElement) r2[r4].add(r3.multiply(r9[r4].subtract(r10[r4])));
        r4 = r4 + 1;
        goto L7
    L9:
        r1 = r1 + 1;
        goto L4
    }
}
