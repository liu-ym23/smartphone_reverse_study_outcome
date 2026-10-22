package org.apache.commons.math3.linear;

import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class BlockFieldMatrix<T extends FieldElement<T>> extends AbstractFieldMatrix<T> implements Serializable {
    public static final int BLOCK_SIZE = 36;
    private static final long serialVersionUID = -4602336630143123183L;
    private final int blockColumns;
    private final int blockRows;
    private final T[][] blocks;
    private final int columns;
    private final int rows;

    public BlockFieldMatrix(Field<T> r2, int r3, int r4) throws NotStrictlyPositiveException {
        super(r2, r3, r4);
        this.rows = r3;
        this.columns = r4;
        this.blockRows = ((r3 + 36) - 1) / 36;
        this.blockColumns = ((r4 + 36) - 1) / 36;
        this.blocks = (T[][]) createBlocksLayout(r2, r3, r4);
    }

    public BlockFieldMatrix(T[][] r4) throws DimensionMismatchException {
        this(r4.length, r4[0].length, toBlocksLayout(r4), false);
    }

    public BlockFieldMatrix(int r6, int r7, T[][] r8, boolean r9) throws DimensionMismatchException, NotStrictlyPositiveException {
        super(extractField(r8), r6, r7);
        this.rows = r6;
        this.columns = r7;
        int r10 = ((r6 + 36) - 1) / 36;
        this.blockRows = r10;
        int r11 = ((r7 + 36) - 1) / 36;
        this.blockColumns = r11;
        if (r9 == false) goto L5;
        this.blocks = (T[][]) ((FieldElement[][]) MathArrays.buildArray(getField(), r10 * r11, -1));
    L6:
        int r12 = 0;
        int r0 = 0;
    L8:
        if (r12 >= this.blockRows) goto L20;
        int r1 = blockHeight(r12);
        int r2 = 0;
    L11:
        if (r2 >= this.blockColumns) goto L19;
        if (r8[r0].length != (blockWidth(r2) * r1)) goto L18;
        if (r9 == false) goto L16;
        ((T[][]) this.blocks)[r0] = (FieldElement[]) r8[r0].clone();
    L16:
        r2 = r2 + 1;
        r0 = r0 + 1;
        goto L11
    L18:
        throw new DimensionMismatchException(r8[r0].length, r1 * blockWidth(r2));
    L19:
        r12 = r12 + 1;
        goto L8
    L20:
        return;
    L5:
        this.blocks = r8;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends FieldElement<T>> T[][] toBlocksLayout(T[][] r19) throws DimensionMismatchException {
        int r1 = r19.length;
        int r2 = 0;
        int r3 = r19[0].length;
        int r4 = ((r1 + 36) - 1) / 36;
        int r5 = ((r3 + 36) - 1) / 36;
        int r6 = 0;
    L4:
        if (r6 >= r19.length) goto L10;
        int r7 = r19[r6].length;
        if (r7 != r3) goto L9;
        r6 = r6 + 1;
        goto L4
    L9:
        throw new DimensionMismatchException(r3, r7);
    L10:
        Field r8 = extractField(r19);
        T[][] r9 = (T[][]) ((FieldElement[][]) MathArrays.buildArray(r8, r4 * r5, -1));
        int r10 = 0;
        int r11 = 0;
    L11:
        if (r10 >= r4) goto L19;
        int r12 = r10 * 36;
        int r13 = FastMath.min(r12 + 36, r1);
        int r14 = r13 - r12;
        int r15 = r2;
    L13:
        if (r15 >= r5) goto L18;
        int r16 = r15 * 36;
        int r17 = FastMath.min(r16 + 36, r3) - r16;
        FieldElement[] r18 = (FieldElement[]) MathArrays.buildArray(r8, r14 * r17);
        r9[r11] = r18;
        int r110 = r1;
        int r111 = r3;
        int r20 = r12;
        int r21 = 0;
    L15:
        if (r20 >= r13) goto L17;
        System.arraycopy(r19[r20], r16, r18, r21, r17);
        r21 = r21 + r17;
        r20 = r20 + 1;
        r4 = r4;
        goto L15
    L17:
        r11 = r11 + 1;
        r15 = r15 + 1;
        r1 = r110;
        r3 = r111;
        goto L13
    L18:
        r10 = r10 + 1;
        r2 = 0;
        goto L11
    L19:
        return r9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends FieldElement<T>> T[][] createBlocksLayout(Field<T> r10, int r11, int r12) {
        int r0 = ((r11 + 36) - 1) / 36;
        int r1 = ((r12 + 36) - 1) / 36;
        T[][] r2 = (T[][]) ((FieldElement[][]) MathArrays.buildArray(r10, r0 * r1, -1));
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r0) goto L8;
        int r6 = r4 * 36;
        int r7 = FastMath.min(r6 + 36, r11) - r6;
        int r8 = 0;
    L5:
        if (r8 >= r1) goto L7;
        int r9 = r8 * 36;
        r2[r5] = (FieldElement[]) MathArrays.buildArray(r10, (FastMath.min(r9 + 36, r12) - r9) * r7);
        r5 = r5 + 1;
        r8 = r8 + 1;
        goto L5
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        return r2;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> createMatrix(int r2, int r3) throws NotStrictlyPositiveException {
        return new BlockFieldMatrix(getField(), r2, r3);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> copy() {
        BlockFieldMatrix r0 = new BlockFieldMatrix(getField(), this.rows, this.columns);
        int r2 = 0;
    L3:
        T[][] r3 = this.blocks;
        if (r2 >= r3.length) goto L6;
        T[] r4 = r3[r2];
        System.arraycopy(r4, 0, r0.blocks[r2], 0, r4.length);
        r2 = r2 + 1;
        goto L3
    L6:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> add(FieldMatrix<T> r17) throws MatrixDimensionMismatchException {
        return add((BlockFieldMatrix) r17);
    L5:
        checkAdditionCompatible(r17);
        BlockFieldMatrix r2 = new BlockFieldMatrix(getField(), this.rows, this.columns);
        int r4 = 0;
        int r5 = 0;
    L7:
        if (r4 >= r2.blockRows) goto L19;
        int r6 = 0;
    L10:
        if (r6 >= r2.blockColumns) goto L18;
        FieldElement[] r7 = ((T[][]) r2.blocks)[r5];
        T[] r8 = this.blocks[r5];
        int r9 = r4 * 36;
        int r10 = FastMath.min(r9 + 36, this.rows);
        int r11 = r6 * 36;
        int r12 = FastMath.min(r11 + 36, this.columns);
        int r13 = 0;
    L12:
        if (r9 >= r10) goto L17;
        int r14 = r11;
    L14:
        if (r14 >= r12) goto L16;
        r7[r13] = (FieldElement) r8[r13].add(r17.getEntry(r9, r14));
        r13 = r13 + 1;
        r14 = r14 + 1;
        goto L14
    L16:
        r9 = r9 + 1;
        goto L12
    L17:
        r5 = r5 + 1;
        r6 = r6 + 1;
        goto L10
    L18:
        r4 = r4 + 1;
        goto L7
    L19:
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BlockFieldMatrix<T> add(BlockFieldMatrix<T> r10) throws MatrixDimensionMismatchException {
        checkAdditionCompatible(r10);
        BlockFieldMatrix<T> r0 = new BlockFieldMatrix(getField(), this.rows, this.columns);
        int r2 = 0;
    L3:
        FieldElement[][] r3 = (T[][]) r0.blocks;
        if (r2 >= r3.length) goto L10;
        FieldElement[] r4 = r3[r2];
        T[] r5 = this.blocks[r2];
        T[] r6 = r10.blocks[r2];
        int r7 = 0;
    L7:
        if (r7 >= r4.length) goto L9;
        r4[r7] = (FieldElement) r5[r7].add(r6[r7]);
        r7 = r7 + 1;
        goto L7
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> subtract(FieldMatrix<T> r17) throws MatrixDimensionMismatchException {
        return subtract((BlockFieldMatrix) r17);
    L5:
        checkSubtractionCompatible(r17);
        BlockFieldMatrix r2 = new BlockFieldMatrix(getField(), this.rows, this.columns);
        int r4 = 0;
        int r5 = 0;
    L7:
        if (r4 >= r2.blockRows) goto L19;
        int r6 = 0;
    L10:
        if (r6 >= r2.blockColumns) goto L18;
        FieldElement[] r7 = ((T[][]) r2.blocks)[r5];
        T[] r8 = this.blocks[r5];
        int r9 = r4 * 36;
        int r10 = FastMath.min(r9 + 36, this.rows);
        int r11 = r6 * 36;
        int r12 = FastMath.min(r11 + 36, this.columns);
        int r13 = 0;
    L12:
        if (r9 >= r10) goto L17;
        int r14 = r11;
    L14:
        if (r14 >= r12) goto L16;
        r7[r13] = (FieldElement) r8[r13].subtract(r17.getEntry(r9, r14));
        r13 = r13 + 1;
        r14 = r14 + 1;
        goto L14
    L16:
        r9 = r9 + 1;
        goto L12
    L17:
        r5 = r5 + 1;
        r6 = r6 + 1;
        goto L10
    L18:
        r4 = r4 + 1;
        goto L7
    L19:
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BlockFieldMatrix<T> subtract(BlockFieldMatrix<T> r10) throws MatrixDimensionMismatchException {
        checkSubtractionCompatible(r10);
        BlockFieldMatrix<T> r0 = new BlockFieldMatrix(getField(), this.rows, this.columns);
        int r2 = 0;
    L3:
        FieldElement[][] r3 = (T[][]) r0.blocks;
        if (r2 >= r3.length) goto L10;
        FieldElement[] r4 = r3[r2];
        T[] r5 = this.blocks[r2];
        T[] r6 = r10.blocks[r2];
        int r7 = 0;
    L7:
        if (r7 >= r4.length) goto L9;
        r4[r7] = (FieldElement) r5[r7].subtract(r6[r7]);
        r7 = r7 + 1;
        goto L7
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> scalarAdd(T r8) {
        BlockFieldMatrix r0 = new BlockFieldMatrix(getField(), this.rows, this.columns);
        int r2 = 0;
    L3:
        FieldElement[][] r3 = (T[][]) r0.blocks;
        if (r2 >= r3.length) goto L10;
        FieldElement[] r4 = r3[r2];
        T[] r5 = this.blocks[r2];
        int r6 = 0;
    L7:
        if (r6 >= r4.length) goto L9;
        r4[r6] = (FieldElement) r5[r6].add(r8);
        r6 = r6 + 1;
        goto L7
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> scalarMultiply(T r8) {
        BlockFieldMatrix r0 = new BlockFieldMatrix(getField(), this.rows, this.columns);
        int r2 = 0;
    L3:
        FieldElement[][] r3 = (T[][]) r0.blocks;
        if (r2 >= r3.length) goto L10;
        FieldElement[] r4 = r3[r2];
        T[] r5 = this.blocks[r2];
        int r6 = 0;
    L7:
        if (r6 >= r4.length) goto L9;
        r4[r6] = (FieldElement) r5[r6].multiply(r8);
        r6 = r6 + 1;
        goto L7
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> multiply(FieldMatrix<T> r26) throws DimensionMismatchException {
        BlockFieldMatrix<T> r0 = this;
        return r0.multiply((BlockFieldMatrix) r26);
    L5:
        checkMultiplicationCompatible(r26);
        BlockFieldMatrix r2 = new BlockFieldMatrix(getField(), r0.rows, r26.getColumnDimension());
        T r3 = getField().getZero();
        int r5 = 0;
        int r6 = 0;
    L7:
        if (r5 >= r2.blockRows) goto L26;
        int r7 = r5 * 36;
        int r8 = FastMath.min(r7 + 36, r0.rows);
        int r9 = 0;
    L10:
        if (r9 >= r2.blockColumns) goto L25;
        int r10 = r9 * 36;
        int r11 = FastMath.min(r10 + 36, r26.getColumnDimension());
        FieldElement[] r12 = r2.blocks[r6];
        int r13 = 0;
    L13:
        if (r13 >= r0.blockColumns) goto L24;
        int r14 = r0.blockWidth(r13);
        T[] r4 = r0.blocks[(r0.blockColumns * r5) + r13];
        int r15 = r13 * 36;
        int r1 = r7;
        int r16 = 0;
    L15:
        if (r1 >= r8) goto L23;
        int r17 = (r1 - r7) * r14;
        T r18 = r3;
        int r19 = r17 + r14;
        int r110 = r7;
        int r20 = r10;
    L17:
        if (r20 >= r11) goto L22;
        int r21 = r8;
        int r22 = r10;
        int r23 = r11;
        int r111 = r15;
        int r24 = r17;
        FieldElement r112 = r18;
    L19:
        if (r24 >= r19) goto L21;
        int r25 = r19;
        T[] r27 = r4;
        r112 = (FieldElement) r112.add(r4[r24].multiply(r26.getEntry(r111, r20)));
        r111 = r111 + 1;
        r24 = r24 + 1;
        r19 = r25;
        r4 = r27;
        goto L19
    L21:
        int r28 = r19;
        r12[r16] = (FieldElement) r12[r16].add(r112);
        r16 = r16 + 1;
        r20 = r20 + 1;
        r8 = r21;
        r10 = r22;
        r11 = r23;
        r19 = r28;
        goto L17
    L22:
        r1 = r1 + 1;
        r3 = r18;
        r7 = r110;
        goto L15
    L23:
        r13 = r13 + 1;
        r0 = this;
        goto L13
    L24:
        r6 = r6 + 1;
        r9 = r9 + 1;
        r0 = this;
        goto L10
    L25:
        r5 = r5 + 1;
        r0 = this;
        goto L7
    L26:
        return r2;
    }

    public BlockFieldMatrix<T> multiply(BlockFieldMatrix<T> r27) throws DimensionMismatchException {
        BlockFieldMatrix<T> r0 = this;
        BlockFieldMatrix<T> r1 = r27;
        checkMultiplicationCompatible(r27);
        BlockFieldMatrix<T> r2 = new BlockFieldMatrix(getField(), r0.rows, r1.columns);
        T r3 = getField().getZero();
        int r5 = 0;
        int r6 = 0;
    L4:
        if (r5 >= r2.blockRows) goto L28;
        int r7 = r5 * 36;
        int r8 = FastMath.min(r7 + 36, r0.rows);
        int r9 = 0;
    L7:
        if (r9 >= r2.blockColumns) goto L26;
        int r10 = r2.blockWidth(r9);
        int r11 = r10 + r10;
        int r12 = r11 + r10;
        int r13 = r12 + r10;
        FieldElement[] r14 = r2.blocks[r6];
        int r15 = 0;
    L10:
        if (r15 >= r0.blockColumns) goto L25;
        int r4 = r0.blockWidth(r15);
        T r16 = r3;
        BlockFieldMatrix<T> r17 = r2;
        T[] r18 = r0.blocks[(r0.blockColumns * r5) + r15];
        T[] r19 = r1.blocks[(r1.blockColumns * r15) + r9];
        int r20 = r7;
        int r110 = 0;
    L12:
        if (r20 >= r8) goto L24;
        int r111 = (r20 - r7) * r4;
        int r21 = r111 + r4;
        int r22 = r4;
        int r23 = 0;
    L14:
        if (r23 >= r10) goto L23;
        int r24 = r23;
        int r25 = r7;
        int r26 = r8;
        FieldElement r28 = r16;
        int r29 = r111;
    L16:
        int r210 = r5;
        if (r29 >= (r21 - 3)) goto L19;
        r28 = (FieldElement) ((FieldElement) ((FieldElement) ((FieldElement) r28.add(r18[r29].multiply(r19[r24]))).add(r18[r29 + 1].multiply(r19[r24 + r10]))).add(r18[r29 + 2].multiply(r19[r24 + r11]))).add(r18[r29 + 3].multiply(r19[r24 + r12]));
        r29 = r29 + 4;
        r24 = r24 + r13;
        r5 = r210;
        r9 = r9;
        goto L16
    L19:
        int r211 = r9;
    L20:
        if (r29 >= r21) goto L22;
        r28 = (FieldElement) r28.add(r18[r29].multiply(r19[r24]));
        r24 = r24 + r10;
        r29 = r29 + 1;
        goto L20
    L22:
        r14[r110] = (FieldElement) r14[r110].add(r28);
        r110 = r110 + 1;
        r23 = r23 + 1;
        r7 = r25;
        r8 = r26;
        r5 = r210;
        r9 = r211;
        goto L14
    L23:
        r20 = r20 + 1;
        r4 = r22;
        goto L12
    L24:
        r15 = r15 + 1;
        r0 = this;
        r1 = r27;
        r3 = r16;
        r2 = r17;
        goto L10
    L25:
        r6 = r6 + 1;
        r9 = r9 + 1;
        r0 = this;
        r1 = r27;
        goto L7
    L26:
        r5 = r5 + 1;
        r0 = this;
        r1 = r27;
        goto L4
    L28:
        return r2;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T[][] getData() {
        T[][] r0 = (T[][]) ((FieldElement[][]) MathArrays.buildArray(getField(), getRowDimension(), getColumnDimension()));
        int r1 = this.columns - ((this.blockColumns - 1) * 36);
        int r4 = 0;
    L4:
        if (r4 >= this.blockRows) goto L13;
        int r5 = r4 * 36;
        int r6 = FastMath.min(r5 + 36, this.rows);
        int r7 = 0;
        int r8 = 0;
    L6:
        if (r5 >= r6) goto L12;
        T[] r9 = r0[r5];
        int r10 = this.blockColumns * r4;
        int r11 = 0;
        int r12 = 0;
    L9:
        if (r11 >= (this.blockColumns - 1)) goto L11;
        System.arraycopy(this.blocks[r10], r7, r9, r12, 36);
        r12 = r12 + 36;
        r11 = r11 + 1;
        r10 = r10 + 1;
        goto L9
    L11:
        System.arraycopy(this.blocks[r10], r8, r9, r12, r1);
        r7 = r7 + 36;
        r8 = r8 + r1;
        r5 = r5 + 1;
        goto L6
    L12:
        r4 = r4 + 1;
        goto L4
    L13:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> getSubMatrix(int r32, int r33, int r34, int r35) throws OutOfRangeException, NumberIsTooSmallException {
        checkSubMatrixIndex(r32, r33, r34, r35);
        BlockFieldMatrix r12 = new BlockFieldMatrix(getField(), (r33 - r32) + 1, (r35 - r34) + 1);
        int r13 = r32 % 36;
        int r14 = r34 / 36;
        int r15 = r34 % 36;
        int r17 = r32 / 36;
        int r10 = 0;
    L4:
        if (r10 >= r12.blockRows) goto L19;
        int r18 = r12.blockHeight(r10);
        int r8 = r14;
        int r9 = 0;
    L7:
        if (r9 >= r12.blockColumns) goto L18;
        int r19 = r12.blockWidth(r9);
        T[] r20 = r12.blocks[(r12.blockColumns * r10) + r9];
        int r21 = (this.blockColumns * r17) + r8;
        int r22 = blockWidth(r8);
        int r23 = r18 + r13;
        int r24 = r23 - 36;
        int r25 = r19 + r15;
        int r26 = r25 - 36;
        if (r24 <= 0) goto L13;
        if (r26 <= 0) goto L12;
        int r27 = blockWidth(r8 + 1);
        int r28 = r8;
        int r29 = r9;
        int r30 = r10;
        copyBlockPart(this.blocks[r21], r22, r13, 36, r15, 36, r20, r19, 0, 0);
        int r210 = r19 - r26;
        copyBlockPart(this.blocks[r21 + 1], r27, r13, 36, 0, r26, r20, r19, 0, r210);
        int r211 = r18 - r24;
        copyBlockPart(this.blocks[r21 + this.blockColumns], r22, 0, r24, r15, 36, r20, r19, r211, 0);
        copyBlockPart(this.blocks[(r21 + this.blockColumns) + 1], r27, 0, r24, 0, r26, r20, r19, r211, r210);
    L17:
        r8 = r28 + 1;
        r9 = r29 + 1;
        r10 = r30;
        goto L7
    L12:
        r28 = r8;
        r29 = r9;
        r30 = r10;
        copyBlockPart(this.blocks[r21], r22, r13, 36, r15, r25, r20, r19, 0, 0);
        copyBlockPart(this.blocks[r21 + this.blockColumns], r22, 0, r24, r15, r25, r20, r19, r18 - r24, 0);
        goto L17
    L13:
        r28 = r8;
        r29 = r9;
        r30 = r10;
        if (r26 <= 0) goto L16;
        int r212 = blockWidth(r28 + 1);
        copyBlockPart(this.blocks[r21], r22, r13, r23, r15, 36, r20, r19, 0, 0);
        copyBlockPart(this.blocks[r21 + 1], r212, r13, r23, 0, r26, r20, r19, 0, r19 - r26);
        goto L17
    L16:
        copyBlockPart(this.blocks[r21], r22, r13, r23, r15, r25, r20, r19, 0, 0);
        goto L17
    L18:
        r17 = r17 + 1;
        r10 = r10 + 1;
        goto L4
    L19:
        return r12;
    }

    private void copyBlockPart(T[] r1, int r2, int r3, int r4, int r5, int r6, T[] r7, int r8, int r9, int r10) {
        int r11 = r6 - r5;
        int r0 = (r3 * r2) + r5;
        int r12 = (r9 * r8) + r10;
    L3:
        if (r3 >= r4) goto L5;
        System.arraycopy(r1, r0, r7, r12, r11);
        r0 = r0 + r2;
        r12 = r12 + r8;
        r3 = r3 + 1;
        goto L3
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void setSubMatrix(T[][] r23, int r24, int r25) throws DimensionMismatchException, OutOfRangeException, NoDataException, NullArgumentException {
        BlockFieldMatrix<T> r0 = this;
        T[][] r1 = r23;
        int r2 = r24;
        MathUtils.checkNotNull(r23);
        int r4 = 0;
        int r5 = r1[0].length;
        if (r5 == 0) goto L22;
        int r6 = (r1.length + r2) - 1;
        int r7 = (r25 + r5) - 1;
        r0.checkSubMatrixIndex(r2, r6, r25, r7);
        int r8 = r1.length;
    L5:
        if (r4 >= r8) goto L11;
        T[] r9 = r1[r4];
        if (r9.length != r5) goto L10;
        r4 = r4 + 1;
        goto L5
    L10:
        throw new DimensionMismatchException(r5, r9.length);
    L11:
        int r10 = r2 / 36;
        int r11 = (r6 + 36) / 36;
        int r12 = r25 / 36;
        int r13 = (r7 + 36) / 36;
    L12:
        if (r10 >= r11) goto L20;
        int r14 = r0.blockHeight(r10);
        int r15 = r10 * 36;
        int r16 = FastMath.max(r2, r15);
        int r17 = FastMath.min(r6 + 1, r14 + r15);
        int r18 = r12;
    L14:
        if (r18 >= r13) goto L19;
        int r19 = r0.blockWidth(r18);
        int r110 = r18 * 36;
        int r111 = FastMath.max(r25, r110);
        int r112 = r11;
        int r113 = r6;
        int r20 = FastMath.min(r7 + 1, r110 + r19) - r111;
        int r114 = r7;
        T[] r21 = r0.blocks[(r0.blockColumns * r10) + r18];
        int r22 = r16;
    L16:
        if (r22 >= r17) goto L18;
        System.arraycopy(r1[r22 - r2], r111 - r25, r21, ((r22 - r15) * r19) + (r111 - r110), r20);
        r22 = r22 + 1;
        r1 = r23;
        r2 = r24;
        goto L16
    L18:
        r18 = r18 + 1;
        r0 = this;
        r1 = r23;
        r2 = r24;
        r11 = r112;
        r6 = r113;
        r7 = r114;
        goto L14
    L19:
        r10 = r10 + 1;
        r0 = this;
        r1 = r23;
        r2 = r24;
        goto L12
    L20:
        return;
    L22:
        throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> getRowMatrix(int r12) throws OutOfRangeException {
        checkRowIndex(r12);
        BlockFieldMatrix r0 = new BlockFieldMatrix(getField(), 1, this.columns);
        int r1 = r12 / 36;
        int r13 = r12 - (r1 * 36);
        T[] r2 = r0.blocks[0];
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L4:
        if (r4 >= this.blockColumns) goto L10;
        int r7 = blockWidth(r4);
        T[] r8 = this.blocks[(this.blockColumns * r1) + r4];
        int r9 = r2.length - r5;
        if (r7 <= r9) goto L8;
        int r10 = r13 * r7;
        System.arraycopy(r8, r10, r2, r5, r9);
        r6 = r6 + 1;
        r2 = r0.blocks[r6];
        int r11 = r7 - r9;
        System.arraycopy(r8, r10, r2, 0, r11);
        r5 = r11;
    L9:
        r4 = r4 + 1;
        goto L4
    L8:
        System.arraycopy(r8, r13 * r7, r2, r5, r7);
        r5 = r5 + r7;
        goto L9
    L10:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void setRowMatrix(int r2, FieldMatrix<T> r3) throws MatrixDimensionMismatchException, OutOfRangeException {
        setRowMatrix(r2, (BlockFieldMatrix) r3);     // Catch: ClassCastException -> L4
        return;
    L4:
        super.setRowMatrix(r2, r3);
    }

    public void setRowMatrix(int r11, BlockFieldMatrix<T> r12) throws MatrixDimensionMismatchException, OutOfRangeException {
        checkRowIndex(r11);
        int r0 = getColumnDimension();
        if (r12.getRowDimension() != 1) goto L16;
        if (r12.getColumnDimension() != r0) goto L16;
        int r1 = r11 / 36;
        int r13 = r11 - (r1 * 36);
        T[] r2 = r12.blocks[0];
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
    L8:
        if (r3 >= this.blockColumns) goto L14;
        int r6 = blockWidth(r3);
        T[] r7 = this.blocks[(this.blockColumns * r1) + r3];
        int r8 = r2.length - r4;
        if (r6 <= r8) goto L12;
        int r9 = r13 * r6;
        System.arraycopy(r2, r4, r7, r9, r8);
        r5 = r5 + 1;
        r2 = r12.blocks[r5];
        int r10 = r6 - r8;
        System.arraycopy(r2, 0, r7, r9, r10);
        r4 = r10;
    L13:
        r3 = r3 + 1;
        goto L8
    L12:
        System.arraycopy(r2, r4, r7, r13 * r6, r6);
        r4 = r4 + r6;
        goto L13
    L14:
        return;
    L16:
        throw new MatrixDimensionMismatchException(r12.getRowDimension(), r12.getColumnDimension(), 1, r0);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> getColumnMatrix(int r14) throws OutOfRangeException {
        checkColumnIndex(r14);
        BlockFieldMatrix r0 = new BlockFieldMatrix(getField(), this.rows, 1);
        int r1 = r14 / 36;
        int r15 = r14 - (r1 * 36);
        int r2 = blockWidth(r1);
        T[] r3 = r0.blocks[0];
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
    L4:
        if (r5 >= this.blockRows) goto L12;
        int r8 = blockHeight(r5);
        T[] r9 = this.blocks[(this.blockColumns * r5) + r1];
        int r10 = 0;
    L6:
        if (r10 >= r8) goto L11;
        if (r6 < r3.length) goto L10;
        r7 = r7 + 1;
        r3 = r0.blocks[r7];
        r6 = 0;
    L10:
        r3[r6] = r9[(r10 * r2) + r15];
        r10 = r10 + 1;
        r6 = r6 + 1;
        goto L6
    L11:
        r5 = r5 + 1;
        goto L4
    L12:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void setColumnMatrix(int r2, FieldMatrix<T> r3) throws MatrixDimensionMismatchException, OutOfRangeException {
        setColumnMatrix(r2, (BlockFieldMatrix) r3);     // Catch: ClassCastException -> L4
        return;
    L4:
        super.setColumnMatrix(r2, r3);
    }

    void setColumnMatrix(int r13, BlockFieldMatrix<T> r14) throws MatrixDimensionMismatchException, OutOfRangeException {
        checkColumnIndex(r13);
        int r0 = getRowDimension();
        if (r14.getRowDimension() != r0) goto L18;
        if (r14.getColumnDimension() != 1) goto L18;
        int r1 = r13 / 36;
        int r15 = r13 - (r1 * 36);
        int r2 = blockWidth(r1);
        T[] r3 = r14.blocks[0];
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L8:
        if (r4 >= this.blockRows) goto L16;
        int r7 = blockHeight(r4);
        T[] r8 = this.blocks[(this.blockColumns * r4) + r1];
        int r9 = 0;
    L10:
        if (r9 >= r7) goto L15;
        if (r5 < r3.length) goto L14;
        r6 = r6 + 1;
        r3 = r14.blocks[r6];
        r5 = 0;
    L14:
        r8[(r9 * r2) + r15] = r3[r5];
        r9 = r9 + 1;
        r5 = r5 + 1;
        goto L10
    L15:
        r4 = r4 + 1;
        goto L8
    L16:
        return;
    L18:
        throw new MatrixDimensionMismatchException(r14.getRowDimension(), r14.getColumnDimension(), r0, 1);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldVector<T> getRowVector(int r9) throws OutOfRangeException {
        checkRowIndex(r9);
        FieldElement[] r0 = (FieldElement[]) MathArrays.buildArray(getField(), this.columns);
        int r1 = r9 / 36;
        int r10 = r9 - (r1 * 36);
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r3 >= this.blockColumns) goto L7;
        int r5 = blockWidth(r3);
        System.arraycopy(this.blocks[(this.blockColumns * r1) + r3], r10 * r5, r0, r4, r5);
        r4 = r4 + r5;
        r3 = r3 + 1;
        goto L4
    L7:
        return new ArrayFieldVector(getField(), r0, false);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void setRowVector(int r2, FieldVector<T> r3) throws MatrixDimensionMismatchException, OutOfRangeException {
        setRow(r2, ((ArrayFieldVector) r3).getDataRef());     // Catch: ClassCastException -> L4
        return;
    L4:
        super.setRowVector(r2, r3);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldVector<T> getColumnVector(int r12) throws OutOfRangeException {
        checkColumnIndex(r12);
        FieldElement[] r0 = (FieldElement[]) MathArrays.buildArray(getField(), this.rows);
        int r1 = r12 / 36;
        int r13 = r12 - (r1 * 36);
        int r2 = blockWidth(r1);
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r4 >= this.blockRows) goto L10;
        int r6 = blockHeight(r4);
        T[] r7 = this.blocks[(this.blockColumns * r4) + r1];
        int r8 = 0;
    L6:
        if (r8 >= r6) goto L8;
        r0[r5] = r7[(r8 * r2) + r13];
        r8 = r8 + 1;
        r5 = r5 + 1;
        goto L6
    L8:
        r4 = r4 + 1;
        goto L4
    L10:
        return new ArrayFieldVector(getField(), r0, false);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void setColumnVector(int r2, FieldVector<T> r3) throws OutOfRangeException, MatrixDimensionMismatchException {
        setColumn(r2, ((ArrayFieldVector) r3).getDataRef());     // Catch: ClassCastException -> L4
        return;
    L4:
        super.setColumnVector(r2, r3);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T[] getRow(int r8) throws OutOfRangeException {
        checkRowIndex(r8);
        T[] r0 = (T[]) ((FieldElement[]) MathArrays.buildArray(getField(), this.columns));
        int r1 = r8 / 36;
        int r9 = r8 - (r1 * 36);
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= this.blockColumns) goto L6;
        int r4 = blockWidth(r2);
        System.arraycopy(this.blocks[(this.blockColumns * r1) + r2], r9 * r4, r0, r3, r4);
        r3 = r3 + r4;
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void setRow(int r7, T[] r8) throws OutOfRangeException, MatrixDimensionMismatchException {
        checkRowIndex(r7);
        int r0 = getColumnDimension();
        if (r8.length != r0) goto L10;
        int r1 = r7 / 36;
        int r9 = r7 - (r1 * 36);
        int r2 = 0;
        int r3 = 0;
    L6:
        if (r2 >= this.blockColumns) goto L8;
        int r4 = blockWidth(r2);
        System.arraycopy(r8, r3, this.blocks[(this.blockColumns * r1) + r2], r9 * r4, r4);
        r3 = r3 + r4;
        r2 = r2 + 1;
        goto L6
    L8:
        return;
    L10:
        throw new MatrixDimensionMismatchException(1, r8.length, 1, r0);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T[] getColumn(int r12) throws OutOfRangeException {
        checkColumnIndex(r12);
        T[] r0 = (T[]) ((FieldElement[]) MathArrays.buildArray(getField(), this.rows));
        int r1 = r12 / 36;
        int r13 = r12 - (r1 * 36);
        int r2 = blockWidth(r1);
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r4 >= this.blockRows) goto L9;
        int r6 = blockHeight(r4);
        T[] r7 = this.blocks[(this.blockColumns * r4) + r1];
        int r8 = 0;
    L6:
        if (r8 >= r6) goto L8;
        r0[r5] = r7[(r8 * r2) + r13];
        r8 = r8 + 1;
        r5 = r5 + 1;
        goto L6
    L8:
        r4 = r4 + 1;
        goto L4
    L9:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void setColumn(int r11, T[] r12) throws MatrixDimensionMismatchException, OutOfRangeException {
        checkColumnIndex(r11);
        int r0 = getRowDimension();
        if (r12.length != r0) goto L13;
        int r1 = r11 / 36;
        int r13 = r11 - (r1 * 36);
        int r2 = blockWidth(r1);
        int r3 = 0;
        int r4 = 0;
    L6:
        if (r3 >= this.blockRows) goto L11;
        int r5 = blockHeight(r3);
        T[] r6 = this.blocks[(this.blockColumns * r3) + r1];
        int r7 = 0;
    L8:
        if (r7 >= r5) goto L10;
        r6[(r7 * r2) + r13] = r12[r4];
        r7 = r7 + 1;
        r4 = r4 + 1;
        goto L8
    L10:
        r3 = r3 + 1;
        goto L6
    L11:
        return;
    L13:
        throw new MatrixDimensionMismatchException(r12.length, 1, r0, 1);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T getEntry(int r4, int r5) throws OutOfRangeException {
        checkRowIndex(r4);
        checkColumnIndex(r5);
        int r0 = r4 / 36;
        int r1 = r5 / 36;
        int r6 = ((r4 - (r0 * 36)) * blockWidth(r1)) + (r5 - (r1 * 36));
        return this.blocks[(r0 * this.blockColumns) + r1][r6];
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void setEntry(int r4, int r5, T r6) throws OutOfRangeException {
        checkRowIndex(r4);
        checkColumnIndex(r5);
        int r0 = r4 / 36;
        int r1 = r5 / 36;
        int r7 = ((r4 - (r0 * 36)) * blockWidth(r1)) + (r5 - (r1 * 36));
        this.blocks[(r0 * this.blockColumns) + r1][r7] = r6;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void addToEntry(int r4, int r5, T r6) throws OutOfRangeException {
        checkRowIndex(r4);
        checkColumnIndex(r5);
        int r0 = r4 / 36;
        int r1 = r5 / 36;
        int r7 = ((r4 - (r0 * 36)) * blockWidth(r1)) + (r5 - (r1 * 36));
        FieldElement[] r3 = this.blocks[(r0 * this.blockColumns) + r1];
        r3[r7] = (FieldElement) r3[r7].add(r6);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void multiplyEntry(int r4, int r5, T r6) throws OutOfRangeException {
        checkRowIndex(r4);
        checkColumnIndex(r5);
        int r0 = r4 / 36;
        int r1 = r5 / 36;
        int r7 = ((r4 - (r0 * 36)) * blockWidth(r1)) + (r5 - (r1 * 36));
        FieldElement[] r3 = this.blocks[(r0 * this.blockColumns) + r1];
        r3[r7] = (FieldElement) r3[r7].multiply(r6);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> transpose() {
        int r1 = getRowDimension();
        int r2 = getColumnDimension();
        BlockFieldMatrix r3 = new BlockFieldMatrix(getField(), r2, r1);
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r4 >= this.blockColumns) goto L16;
        int r6 = 0;
    L7:
        if (r6 >= this.blockRows) goto L15;
        T[] r7 = r3.blocks[r5];
        T[] r8 = this.blocks[(this.blockColumns * r6) + r4];
        int r9 = r4 * 36;
        int r10 = FastMath.min(r9 + 36, this.columns);
        int r11 = r6 * 36;
        int r12 = FastMath.min(r11 + 36, this.rows);
        int r13 = r9;
        int r14 = 0;
    L9:
        if (r13 >= r10) goto L14;
        int r15 = r10 - r9;
        int r16 = r13 - r9;
        int r17 = r11;
    L11:
        if (r17 >= r12) goto L13;
        r7[r14] = r8[r16];
        r14 = r14 + 1;
        r16 = r16 + r15;
        r17 = r17 + 1;
        goto L11
    L13:
        r13 = r13 + 1;
        goto L9
    L14:
        r5 = r5 + 1;
        r6 = r6 + 1;
        goto L7
    L15:
        r4 = r4 + 1;
        goto L4
    L16:
        return r3;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.AnyMatrix
    public int getRowDimension() {
        return this.rows;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.AnyMatrix
    public int getColumnDimension() {
        return this.columns;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T[] operate(T[] r18) throws DimensionMismatchException {
        if (r18.length != this.columns) goto L24;
        T[] r2 = (T[]) ((FieldElement[]) MathArrays.buildArray(getField(), this.rows));
        T r3 = getField().getZero();
        int r5 = 0;
    L6:
        if (r5 >= this.blockRows) goto L22;
        int r6 = r5 * 36;
        int r7 = FastMath.min(r6 + 36, this.rows);
        int r8 = 0;
    L8:
        int r9 = this.blockColumns;
        if (r8 >= r9) goto L21;
        T[] r10 = this.blocks[(r9 * r5) + r8];
        int r11 = r8 * 36;
        int r12 = FastMath.min(r11 + 36, this.columns);
        int r13 = r6;
        int r14 = 0;
    L11:
        if (r13 >= r7) goto L20;
        FieldElement r15 = r3;
        int r16 = r11;
    L14:
        if (r16 >= (r12 - 3)) goto L16;
        r15 = (FieldElement) ((FieldElement) ((FieldElement) ((FieldElement) r15.add(r10[r14].multiply(r18[r16]))).add(r10[r14 + 1].multiply(r18[r16 + 1]))).add(r10[r14 + 2].multiply(r18[r16 + 2]))).add(r10[r14 + 3].multiply(r18[r16 + 3]));
        r14 = r14 + 4;
        r16 = r16 + 4;
        r3 = r3;
        goto L14
    L16:
        T r17 = r3;
    L17:
        if (r16 >= r12) goto L19;
        int r4 = r14 + 1;
        T r19 = r10[r14];
        r15 = (FieldElement) r15.add(r19.multiply(r18[r16]));
        r16 = r16 + 1;
        r14 = r4;
        goto L17
    L19:
        r2[r13] = (FieldElement) r2[r13].add(r15);
        r13 = r13 + 1;
        r3 = r17;
        goto L11
    L20:
        r8 = r8 + 1;
        goto L8
    L21:
        r5 = r5 + 1;
        goto L6
    L22:
        return r2;
    L24:
        throw new DimensionMismatchException(r18.length, this.columns);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T[] preMultiply(T[] r22) throws DimensionMismatchException {
        if (r22.length != this.rows) goto L24;
        T[] r2 = (T[]) ((FieldElement[]) MathArrays.buildArray(getField(), this.columns));
        T r3 = getField().getZero();
        int r5 = 0;
    L6:
        if (r5 >= this.blockColumns) goto L22;
        int r6 = blockWidth(r5);
        int r7 = r6 + r6;
        int r8 = r7 + r6;
        int r9 = r8 + r6;
        int r10 = r5 * 36;
        int r11 = FastMath.min(r10 + 36, this.columns);
        int r12 = 0;
    L9:
        if (r12 >= this.blockRows) goto L21;
        T[] r13 = this.blocks[(this.blockColumns * r12) + r5];
        int r14 = r12 * 36;
        int r4 = FastMath.min(r14 + 36, this.rows);
        int r15 = r10;
    L11:
        if (r15 >= r11) goto L20;
        int r16 = r15 - r10;
        T r17 = r3;
        int r18 = r10;
        FieldElement r19 = r17;
        int r20 = r14;
    L13:
        int r110 = r11;
        if (r20 >= (r4 - 3)) goto L16;
        r19 = (FieldElement) ((FieldElement) ((FieldElement) ((FieldElement) r19.add(r13[r16].multiply(r22[r20]))).add(r13[r16 + r6].multiply(r22[r20 + 1]))).add(r13[r16 + r7].multiply(r22[r20 + 2]))).add(r13[r16 + r8].multiply(r22[r20 + 3]));
        r16 = r16 + r9;
        r20 = r20 + 4;
        r11 = r110;
        r14 = r14;
        goto L13
    L16:
        int r21 = r14;
    L17:
        if (r20 >= r4) goto L19;
        r19 = (FieldElement) r19.add(r13[r16].multiply(r22[r20]));
        r16 = r16 + r6;
        r20 = r20 + 1;
        goto L17
    L19:
        r2[r15] = (FieldElement) r2[r15].add(r19);
        r15 = r15 + 1;
        r3 = r17;
        r10 = r18;
        r11 = r110;
        r14 = r21;
        goto L11
    L20:
        r12 = r12 + 1;
        goto L9
    L21:
        r5 = r5 + 1;
        goto L6
    L22:
        return r2;
    L24:
        throw new DimensionMismatchException(r22.length, this.rows);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixChangingVisitor<T> r12) {
        int r1 = this.rows;
        int r2 = this.columns;
        r12.start(r1, r2, 0, r1 - 1, 0, r2 - 1);
        int r3 = 0;
    L4:
        if (r3 >= this.blockRows) goto L17;
        int r4 = r3 * 36;
        int r5 = FastMath.min(r4 + 36, this.rows);
        int r6 = r4;
    L6:
        if (r6 >= r5) goto L15;
        int r7 = 0;
    L9:
        if (r7 >= this.blockColumns) goto L14;
        int r8 = blockWidth(r7);
        int r9 = r7 * 36;
        int r10 = FastMath.min(r9 + 36, this.columns);
        Object[] r11 = this.blocks[(this.blockColumns * r3) + r7];
        int r13 = (r6 - r4) * r8;
    L11:
        if (r9 >= r10) goto L13;
        r11[r13] = r12.visit(r6, r9, r11[r13]);
        r13 = r13 + 1;
        r9 = r9 + 1;
        goto L11
    L13:
        r7 = r7 + 1;
        goto L9
    L14:
        r6 = r6 + 1;
        goto L6
    L15:
        r3 = r3 + 1;
        goto L4
    L17:
        return (T) r12.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixPreservingVisitor<T> r12) {
        int r1 = this.rows;
        int r2 = this.columns;
        r12.start(r1, r2, 0, r1 - 1, 0, r2 - 1);
        int r3 = 0;
    L4:
        if (r3 >= this.blockRows) goto L17;
        int r4 = r3 * 36;
        int r5 = FastMath.min(r4 + 36, this.rows);
        int r6 = r4;
    L6:
        if (r6 >= r5) goto L15;
        int r7 = 0;
    L9:
        if (r7 >= this.blockColumns) goto L14;
        int r8 = blockWidth(r7);
        int r9 = r7 * 36;
        int r10 = FastMath.min(r9 + 36, this.columns);
        T[] r11 = this.blocks[(this.blockColumns * r3) + r7];
        int r13 = (r6 - r4) * r8;
    L11:
        if (r9 >= r10) goto L13;
        r12.visit(r6, r9, r11[r13]);
        r13 = r13 + 1;
        r9 = r9 + 1;
        goto L11
    L13:
        r7 = r7 + 1;
        goto L9
    L14:
        r6 = r6 + 1;
        goto L6
    L15:
        r3 = r3 + 1;
        goto L4
    L17:
        return (T) r12.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixChangingVisitor<T> r19, int r20, int r21, int r22, int r23) throws OutOfRangeException, NumberIsTooSmallException {
        checkSubMatrixIndex(r20, r21, r22, r23);
        r19.start(this.rows, this.columns, r20, r21, r22, r23);
        int r1 = r20 / 36;
    L4:
        if (r1 >= ((r21 / 36) + 1)) goto L17;
        int r2 = r1 * 36;
        int r3 = FastMath.max(r20, r2);
        int r4 = r1 + 1;
        int r5 = FastMath.min(r4 * 36, r21 + 1);
    L6:
        if (r3 >= r5) goto L15;
        int r6 = r22 / 36;
    L9:
        if (r6 >= ((r23 / 36) + 1)) goto L14;
        int r7 = blockWidth(r6);
        int r12 = r6 * 36;
        int r13 = FastMath.max(r22, r12);
        int r14 = r6 + 1;
        int r16 = r4;
        int r8 = FastMath.min(r14 * 36, r23 + 1);
        int r17 = r5;
        Object[] r9 = this.blocks[(this.blockColumns * r1) + r6];
        int r10 = (((r3 - r2) * r7) + r13) - r12;
    L11:
        if (r13 >= r8) goto L13;
        r9[r10] = r19.visit(r3, r13, r9[r10]);
        r10 = r10 + 1;
        r13 = r13 + 1;
        goto L11
    L13:
        r6 = r14;
        r4 = r16;
        r5 = r17;
        goto L9
    L14:
        r3 = r3 + 1;
        goto L6
    L15:
        r1 = r4;
        goto L4
    L17:
        return (T) r19.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixPreservingVisitor<T> r19, int r20, int r21, int r22, int r23) throws OutOfRangeException, NumberIsTooSmallException {
        checkSubMatrixIndex(r20, r21, r22, r23);
        r19.start(this.rows, this.columns, r20, r21, r22, r23);
        int r1 = r20 / 36;
    L4:
        if (r1 >= ((r21 / 36) + 1)) goto L17;
        int r2 = r1 * 36;
        int r3 = FastMath.max(r20, r2);
        int r4 = r1 + 1;
        int r5 = FastMath.min(r4 * 36, r21 + 1);
    L6:
        if (r3 >= r5) goto L15;
        int r6 = r22 / 36;
    L9:
        if (r6 >= ((r23 / 36) + 1)) goto L14;
        int r7 = blockWidth(r6);
        int r12 = r6 * 36;
        int r13 = FastMath.max(r22, r12);
        int r14 = r6 + 1;
        int r16 = r4;
        int r8 = FastMath.min(r14 * 36, r23 + 1);
        int r17 = r5;
        T[] r9 = this.blocks[(this.blockColumns * r1) + r6];
        int r10 = (((r3 - r2) * r7) + r13) - r12;
    L11:
        if (r13 >= r8) goto L13;
        r19.visit(r3, r13, r9[r10]);
        r10 = r10 + 1;
        r13 = r13 + 1;
        goto L11
    L13:
        r6 = r14;
        r4 = r16;
        r5 = r17;
        goto L9
    L14:
        r3 = r3 + 1;
        goto L6
    L15:
        r1 = r4;
        goto L4
    L17:
        return (T) r19.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T walkInOptimizedOrder(FieldMatrixChangingVisitor<T> r14) {
        int r1 = this.rows;
        int r2 = this.columns;
        r14.start(r1, r2, 0, r1 - 1, 0, r2 - 1);
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r3 >= this.blockRows) goto L17;
        int r5 = r3 * 36;
        int r6 = FastMath.min(r5 + 36, this.rows);
        int r7 = 0;
    L7:
        if (r7 >= this.blockColumns) goto L15;
        int r8 = r7 * 36;
        int r9 = FastMath.min(r8 + 36, this.columns);
        Object[] r10 = this.blocks[r4];
        int r11 = 0;
        int r12 = r5;
    L9:
        if (r12 >= r6) goto L14;
        int r13 = r8;
    L11:
        if (r13 >= r9) goto L13;
        r10[r11] = r14.visit(r12, r13, r10[r11]);
        r11 = r11 + 1;
        r13 = r13 + 1;
        goto L11
    L13:
        r12 = r12 + 1;
        goto L9
    L14:
        r4 = r4 + 1;
        r7 = r7 + 1;
        goto L7
    L15:
        r3 = r3 + 1;
        goto L4
    L17:
        return (T) r14.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T walkInOptimizedOrder(FieldMatrixPreservingVisitor<T> r14) {
        int r1 = this.rows;
        int r2 = this.columns;
        r14.start(r1, r2, 0, r1 - 1, 0, r2 - 1);
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r3 >= this.blockRows) goto L17;
        int r5 = r3 * 36;
        int r6 = FastMath.min(r5 + 36, this.rows);
        int r7 = 0;
    L7:
        if (r7 >= this.blockColumns) goto L15;
        int r8 = r7 * 36;
        int r9 = FastMath.min(r8 + 36, this.columns);
        T[] r10 = this.blocks[r4];
        int r11 = 0;
        int r12 = r5;
    L9:
        if (r12 >= r6) goto L14;
        int r13 = r8;
    L11:
        if (r13 >= r9) goto L13;
        r14.visit(r12, r13, r10[r11]);
        r11 = r11 + 1;
        r13 = r13 + 1;
        goto L11
    L13:
        r12 = r12 + 1;
        goto L9
    L14:
        r4 = r4 + 1;
        r7 = r7 + 1;
        goto L7
    L15:
        r3 = r3 + 1;
        goto L4
    L17:
        return (T) r14.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T walkInOptimizedOrder(FieldMatrixChangingVisitor<T> r21, int r22, int r23, int r24, int r25) throws OutOfRangeException, NumberIsTooSmallException {
        BlockFieldMatrix<T> r0 = this;
        r0.checkSubMatrixIndex(r22, r23, r24, r25);
        r21.start(r0.rows, r0.columns, r22, r23, r24, r25);
        int r1 = r22 / 36;
    L4:
        if (r1 >= ((r23 / 36) + 1)) goto L17;
        int r2 = r1 * 36;
        int r3 = FastMath.max(r22, r2);
        int r4 = r1 + 1;
        int r5 = FastMath.min(r4 * 36, r23 + 1);
        int r6 = r24 / 36;
    L7:
        if (r6 >= ((r25 / 36) + 1)) goto L15;
        int r7 = r0.blockWidth(r6);
        int r12 = r6 * 36;
        int r13 = FastMath.max(r24, r12);
        int r14 = r6 + 1;
        int r16 = r3;
        int r8 = FastMath.min(r14 * 36, r25 + 1);
        int r17 = r4;
        Object[] r9 = r0.blocks[(r0.blockColumns * r1) + r6];
        int r10 = r16;
    L9:
        if (r10 >= r5) goto L14;
        int r15 = (((r10 - r2) * r7) + r13) - r12;
        int r11 = r13;
    L11:
        if (r11 >= r8) goto L13;
        int r18 = r1;
        r9[r15] = r21.visit(r10, r11, r9[r15]);
        r15 = r15 + 1;
        r11 = r11 + 1;
        r1 = r18;
        r2 = r2;
        goto L11
    L13:
        r10 = r10 + 1;
        r2 = r2;
        goto L9
    L14:
        r0 = this;
        r6 = r14;
        r3 = r16;
        r4 = r17;
        r2 = r2;
        goto L7
    L15:
        r0 = this;
        r1 = r4;
        goto L4
    L17:
        return (T) r21.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T walkInOptimizedOrder(FieldMatrixPreservingVisitor<T> r21, int r22, int r23, int r24, int r25) throws OutOfRangeException, NumberIsTooSmallException {
        BlockFieldMatrix<T> r0 = this;
        r0.checkSubMatrixIndex(r22, r23, r24, r25);
        r21.start(r0.rows, r0.columns, r22, r23, r24, r25);
        int r1 = r22 / 36;
    L4:
        if (r1 >= ((r23 / 36) + 1)) goto L17;
        int r2 = r1 * 36;
        int r3 = FastMath.max(r22, r2);
        int r4 = r1 + 1;
        int r5 = FastMath.min(r4 * 36, r23 + 1);
        int r6 = r24 / 36;
    L7:
        if (r6 >= ((r25 / 36) + 1)) goto L15;
        int r7 = r0.blockWidth(r6);
        int r12 = r6 * 36;
        int r13 = FastMath.max(r24, r12);
        int r14 = r6 + 1;
        int r16 = r3;
        int r8 = FastMath.min(r14 * 36, r25 + 1);
        int r17 = r4;
        T[] r9 = r0.blocks[(r0.blockColumns * r1) + r6];
        int r10 = r16;
    L9:
        if (r10 >= r5) goto L14;
        int r15 = (((r10 - r2) * r7) + r13) - r12;
        int r11 = r13;
    L11:
        if (r11 >= r8) goto L13;
        int r18 = r1;
        r21.visit(r10, r11, r9[r15]);
        r15 = r15 + 1;
        r11 = r11 + 1;
        r1 = r18;
        r2 = r2;
        goto L11
    L13:
        r10 = r10 + 1;
        r2 = r2;
        goto L9
    L14:
        r0 = this;
        r6 = r14;
        r3 = r16;
        r4 = r17;
        r2 = r2;
        goto L7
    L15:
        r0 = this;
        r1 = r4;
        goto L4
    L17:
        return (T) r21.end();
    }

    private int blockHeight(int r3) {
        if (r3 == (this.blockRows - 1)) goto L5;
        return 36;
    L5:
        return this.rows - (r3 * 36);
    }

    private int blockWidth(int r3) {
        if (r3 == (this.blockColumns - 1)) goto L5;
        return 36;
    L5:
        return this.columns - (r3 * 36);
    }
}
