package org.apache.commons.math3.linear;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class BlockRealMatrix extends AbstractRealMatrix implements Serializable {
    public static final int BLOCK_SIZE = 52;
    private static final long serialVersionUID = 4991895511313664478L;
    private final int blockColumns;
    private final int blockRows;
    private final double[][] blocks;
    private final int columns;
    private final int rows;

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public /* bridge */ /* synthetic */ RealMatrix add(RealMatrix r1) throws MatrixDimensionMismatchException {
        return add(r1);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public /* bridge */ /* synthetic */ RealMatrix copy() {
        return copy();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public /* bridge */ /* synthetic */ RealMatrix createMatrix(int r1, int r2) throws NotStrictlyPositiveException {
        return createMatrix(r1, r2);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public /* bridge */ /* synthetic */ RealMatrix getColumnMatrix(int r1) throws OutOfRangeException {
        return getColumnMatrix(r1);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public /* bridge */ /* synthetic */ RealMatrix getRowMatrix(int r1) throws OutOfRangeException {
        return getRowMatrix(r1);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public /* bridge */ /* synthetic */ RealMatrix getSubMatrix(int r1, int r2, int r3, int r4) throws OutOfRangeException, NumberIsTooSmallException {
        return getSubMatrix(r1, r2, r3, r4);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public /* bridge */ /* synthetic */ RealMatrix multiply(RealMatrix r1) throws DimensionMismatchException {
        return multiply(r1);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public /* bridge */ /* synthetic */ RealMatrix scalarAdd(double r1) {
        return scalarAdd(r1);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public /* bridge */ /* synthetic */ RealMatrix subtract(RealMatrix r1) throws MatrixDimensionMismatchException {
        return subtract(r1);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public /* bridge */ /* synthetic */ RealMatrix transpose() {
        return transpose();
    }

    public BlockRealMatrix(int r2, int r3) throws NotStrictlyPositiveException {
        super(r2, r3);
        this.rows = r2;
        this.columns = r3;
        this.blockRows = ((r2 + 52) - 1) / 52;
        this.blockColumns = ((r3 + 52) - 1) / 52;
        this.blocks = createBlocksLayout(r2, r3);
    }

    public BlockRealMatrix(double[][] r4) throws DimensionMismatchException, NotStrictlyPositiveException {
        this(r4.length, r4[0].length, toBlocksLayout(r4), false);
    }

    public BlockRealMatrix(int r6, int r7, double[][] r8, boolean r9) throws DimensionMismatchException, NotStrictlyPositiveException {
        super(r6, r7);
        this.rows = r6;
        this.columns = r7;
        int r10 = ((r6 + 52) - 1) / 52;
        this.blockRows = r10;
        int r11 = ((r7 + 52) - 1) / 52;
        this.blockColumns = r11;
        if (r9 == false) goto L5;
        this.blocks = new double[r10 * r11][];
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
        this.blocks[r0] = (double[]) r8[r0].clone();
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

    public static double[][] toBlocksLayout(double[][] r18) throws DimensionMismatchException {
        int r1 = r18.length;
        int r2 = 0;
        int r3 = r18[0].length;
        int r4 = ((r1 + 52) - 1) / 52;
        int r5 = ((r3 + 52) - 1) / 52;
        int r6 = 0;
    L4:
        if (r6 >= r18.length) goto L10;
        int r7 = r18[r6].length;
        if (r7 != r3) goto L9;
        r6 = r6 + 1;
        goto L4
    L9:
        throw new DimensionMismatchException(r3, r7);
    L10:
        double[][] r8 = new double[r4 * r5][];
        int r9 = 0;
        int r10 = 0;
    L11:
        if (r9 >= r4) goto L19;
        int r11 = r9 * 52;
        int r12 = FastMath.min(r11 + 52, r1);
        int r13 = r12 - r11;
        int r14 = r2;
    L13:
        if (r14 >= r5) goto L18;
        int r15 = r14 * 52;
        int r16 = FastMath.min(r15 + 52, r3) - r15;
        double[] r17 = new double[r13 * r16];
        r8[r10] = r17;
        int r19 = r1;
        int r20 = r2;
        int r21 = r11;
    L15:
        if (r21 >= r12) goto L17;
        System.arraycopy(r18[r21], r15, r17, r20, r16);
        r20 = r20 + r16;
        r21 = r21 + 1;
        r3 = r3;
        goto L15
    L17:
        r10 = r10 + 1;
        r14 = r14 + 1;
        r1 = r19;
        r2 = 0;
        goto L13
    L18:
        r9 = r9 + 1;
        r2 = 0;
        goto L11
    L19:
        return r8;
    }

    public static double[][] createBlocksLayout(int r10, int r11) {
        int r0 = ((r10 + 52) - 1) / 52;
        int r1 = ((r11 + 52) - 1) / 52;
        double[][] r2 = new double[r0 * r1][];
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r0) goto L8;
        int r6 = r4 * 52;
        int r7 = FastMath.min(r6 + 52, r10) - r6;
        int r8 = 0;
    L5:
        if (r8 >= r1) goto L7;
        int r9 = r8 * 52;
        r2[r5] = new double[(FastMath.min(r9 + 52, r11) - r9) * r7];
        r5 = r5 + 1;
        r8 = r8 + 1;
        goto L5
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        return r2;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public BlockRealMatrix createMatrix(int r1, int r2) throws NotStrictlyPositiveException {
        return new BlockRealMatrix(r1, r2);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public BlockRealMatrix copy() {
        BlockRealMatrix r0 = new BlockRealMatrix(this.rows, this.columns);
        int r2 = 0;
    L3:
        double[][] r3 = this.blocks;
        if (r2 >= r3.length) goto L6;
        double[] r4 = r3[r2];
        System.arraycopy(r4, 0, r0.blocks[r2], 0, r4.length);
        r2 = r2 + 1;
        goto L3
    L6:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public BlockRealMatrix add(RealMatrix r20) throws MatrixDimensionMismatchException {
        return add((BlockRealMatrix) r20);
    L5:
        MatrixUtils.checkAdditionCompatible(this, r20);
        BlockRealMatrix r2 = new BlockRealMatrix(this.rows, this.columns);
        int r4 = 0;
        int r5 = 0;
    L7:
        if (r4 >= r2.blockRows) goto L19;
        int r6 = 0;
    L10:
        if (r6 >= r2.blockColumns) goto L18;
        double[] r7 = r2.blocks[r5];
        double[] r8 = this.blocks[r5];
        int r9 = r4 * 52;
        int r10 = FastMath.min(r9 + 52, this.rows);
        int r11 = r6 * 52;
        int r12 = FastMath.min(r11 + 52, this.columns);
        int r13 = 0;
    L12:
        if (r9 >= r10) goto L17;
        int r14 = r11;
    L14:
        if (r14 >= r12) goto L16;
        r7[r13] = r8[r13] + r20.getEntry(r9, r14);
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

    public BlockRealMatrix add(BlockRealMatrix r12) throws MatrixDimensionMismatchException {
        MatrixUtils.checkAdditionCompatible(this, r12);
        BlockRealMatrix r0 = new BlockRealMatrix(this.rows, this.columns);
        int r2 = 0;
    L3:
        double[][] r3 = r0.blocks;
        if (r2 >= r3.length) goto L10;
        double[] r4 = r3[r2];
        double[] r5 = this.blocks[r2];
        double[] r6 = r12.blocks[r2];
        int r7 = 0;
    L7:
        if (r7 >= r4.length) goto L9;
        r4[r7] = r5[r7] + r6[r7];
        r7 = r7 + 1;
        goto L7
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public BlockRealMatrix subtract(RealMatrix r20) throws MatrixDimensionMismatchException {
        return subtract((BlockRealMatrix) r20);
    L5:
        MatrixUtils.checkSubtractionCompatible(this, r20);
        BlockRealMatrix r2 = new BlockRealMatrix(this.rows, this.columns);
        int r4 = 0;
        int r5 = 0;
    L7:
        if (r4 >= r2.blockRows) goto L19;
        int r6 = 0;
    L10:
        if (r6 >= r2.blockColumns) goto L18;
        double[] r7 = r2.blocks[r5];
        double[] r8 = this.blocks[r5];
        int r9 = r4 * 52;
        int r10 = FastMath.min(r9 + 52, this.rows);
        int r11 = r6 * 52;
        int r12 = FastMath.min(r11 + 52, this.columns);
        int r13 = 0;
    L12:
        if (r9 >= r10) goto L17;
        int r14 = r11;
    L14:
        if (r14 >= r12) goto L16;
        r7[r13] = r8[r13] - r20.getEntry(r9, r14);
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

    public BlockRealMatrix subtract(BlockRealMatrix r12) throws MatrixDimensionMismatchException {
        MatrixUtils.checkSubtractionCompatible(this, r12);
        BlockRealMatrix r0 = new BlockRealMatrix(this.rows, this.columns);
        int r2 = 0;
    L3:
        double[][] r3 = r0.blocks;
        if (r2 >= r3.length) goto L10;
        double[] r4 = r3[r2];
        double[] r5 = this.blocks[r2];
        double[] r6 = r12.blocks[r2];
        int r7 = 0;
    L7:
        if (r7 >= r4.length) goto L9;
        r4[r7] = r5[r7] - r6[r7];
        r7 = r7 + 1;
        goto L7
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public BlockRealMatrix scalarAdd(double r9) {
        BlockRealMatrix r0 = new BlockRealMatrix(this.rows, this.columns);
        int r2 = 0;
    L3:
        double[][] r3 = r0.blocks;
        if (r2 >= r3.length) goto L10;
        double[] r4 = r3[r2];
        double[] r5 = this.blocks[r2];
        int r6 = 0;
    L7:
        if (r6 >= r4.length) goto L9;
        r4[r6] = r5[r6] + r9;
        r6 = r6 + 1;
        goto L7
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public RealMatrix scalarMultiply(double r9) {
        BlockRealMatrix r0 = new BlockRealMatrix(this.rows, this.columns);
        int r2 = 0;
    L3:
        double[][] r3 = r0.blocks;
        if (r2 >= r3.length) goto L10;
        double[] r4 = r3[r2];
        double[] r5 = this.blocks[r2];
        int r6 = 0;
    L7:
        if (r6 >= r4.length) goto L9;
        r4[r6] = r5[r6] * r9;
        r6 = r6 + 1;
        goto L7
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public BlockRealMatrix multiply(RealMatrix r28) throws DimensionMismatchException {
        BlockRealMatrix r0 = this;
        return r0.multiply((BlockRealMatrix) r28);
    L5:
        MatrixUtils.checkMultiplicationCompatible(this, r28);
        BlockRealMatrix r2 = new BlockRealMatrix(r0.rows, r28.getColumnDimension());
        int r4 = 0;
        int r5 = 0;
    L7:
        if (r4 >= r2.blockRows) goto L26;
        int r6 = r4 * 52;
        int r7 = FastMath.min(r6 + 52, r0.rows);
        int r8 = 0;
    L10:
        if (r8 >= r2.blockColumns) goto L25;
        int r9 = r8 * 52;
        int r10 = FastMath.min(r9 + 52, r28.getColumnDimension());
        double[] r11 = r2.blocks[r5];
        int r12 = 0;
    L13:
        if (r12 >= r0.blockColumns) goto L24;
        int r13 = r0.blockWidth(r12);
        double[] r14 = r0.blocks[(r0.blockColumns * r4) + r12];
        int r15 = r12 * 52;
        int r3 = r6;
        int r16 = 0;
    L15:
        if (r3 >= r7) goto L23;
        int r17 = (r3 - r6) * r13;
        int r1 = r17 + r13;
        int r18 = r6;
        int r19 = r9;
    L17:
        if (r19 >= r10) goto L22;
        double r110 = 0.0d;
        int r21 = r7;
        int r22 = r9;
        int r20 = r15;
        int r23 = r17;
    L19:
        if (r23 >= r1) goto L21;
        r110 = r110 + (r14[r23] * r28.getEntry(r20, r19));
        r20 = r20 + 1;
        r23 = r23 + 1;
        goto L19
    L21:
        r11[r16] = r11[r16] + r110;
        r16 = r16 + 1;
        r19 = r19 + 1;
        r7 = r21;
        r9 = r22;
        goto L17
    L22:
        r3 = r3 + 1;
        r6 = r18;
        goto L15
    L23:
        r12 = r12 + 1;
        r0 = this;
        goto L13
    L24:
        r5 = r5 + 1;
        r8 = r8 + 1;
        r0 = this;
        goto L10
    L25:
        r4 = r4 + 1;
        r0 = this;
        goto L7
    L26:
        return r2;
    }

    public BlockRealMatrix multiply(BlockRealMatrix r32) throws DimensionMismatchException {
        BlockRealMatrix r0 = this;
        BlockRealMatrix r1 = r32;
        MatrixUtils.checkMultiplicationCompatible(this, r32);
        BlockRealMatrix r2 = new BlockRealMatrix(r0.rows, r1.columns);
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r4 >= r2.blockRows) goto L27;
        int r6 = r4 * 52;
        int r7 = FastMath.min(r6 + 52, r0.rows);
        int r8 = 0;
    L7:
        if (r8 >= r2.blockColumns) goto L25;
        int r9 = r2.blockWidth(r8);
        int r10 = r9 + r9;
        int r11 = r10 + r9;
        int r12 = r11 + r9;
        double[] r13 = r2.blocks[r5];
        int r14 = 0;
    L10:
        if (r14 >= r0.blockColumns) goto L24;
        int r15 = r0.blockWidth(r14);
        BlockRealMatrix r16 = r2;
        double[] r3 = r0.blocks[(r0.blockColumns * r4) + r14];
        double[] r17 = r1.blocks[(r1.blockColumns * r14) + r8];
        int r18 = r6;
        int r19 = 0;
    L12:
        if (r18 >= r7) goto L23;
        int r110 = (r18 - r6) * r15;
        int r20 = r110 + r15;
        int r111 = r6;
        int r21 = 0;
    L14:
        if (r21 >= r9) goto L22;
        double r22 = 0.0d;
        int r23 = r21;
        int r24 = r7;
        int r25 = r110;
    L16:
        int r26 = r15;
        if (r25 >= (r20 - 3)) goto L19;
        r22 = r22 + ((((r3[r25] * r17[r23]) + (r3[r25 + 1] * r17[r23 + r9])) + (r3[r25 + 2] * r17[r23 + r10])) + (r3[r25 + 3] * r17[r23 + r11]));
        r25 = r25 + 4;
        r23 = r23 + r12;
        r15 = r26;
    L19:
        if (r25 >= r20) goto L21;
        r22 = r22 + (r3[r25] * r17[r23]);
        r23 = r23 + r9;
        r25 = r25 + 1;
        goto L19
    L21:
        r13[r19] = r13[r19] + r22;
        r19 = r19 + 1;
        r21 = r21 + 1;
        r7 = r24;
        r15 = r26;
        goto L14
    L22:
        r18 = r18 + 1;
        r6 = r111;
        goto L12
    L23:
        r14 = r14 + 1;
        r0 = this;
        r1 = r32;
        r2 = r16;
        goto L10
    L24:
        r5 = r5 + 1;
        r8 = r8 + 1;
        r0 = this;
        r1 = r32;
        goto L7
    L25:
        r4 = r4 + 1;
        r0 = this;
        r1 = r32;
        goto L4
    L27:
        return r2;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double[][] getData() {
        double[][] r1 = (double[][]) Array.newInstance(Double.TYPE, new int[]{getRowDimension(), getColumnDimension()});
        int r3 = this.columns - ((this.blockColumns - 1) * 52);
        int r5 = 0;
    L4:
        if (r5 >= this.blockRows) goto L13;
        int r7 = r5 * 52;
        int r8 = FastMath.min(r7 + 52, this.rows);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r7 >= r8) goto L12;
        double[] r11 = r1[r7];
        int r12 = this.blockColumns * r5;
        int r13 = 0;
        int r14 = 0;
    L9:
        if (r13 >= (this.blockColumns - 1)) goto L11;
        System.arraycopy(this.blocks[r12], r9, r11, r14, 52);
        r14 = r14 + 52;
        r13 = r13 + 1;
        r12 = r12 + 1;
        goto L9
    L11:
        System.arraycopy(this.blocks[r12], r10, r11, r14, r3);
        r9 = r9 + 52;
        r10 = r10 + r3;
        r7 = r7 + 1;
        goto L6
    L12:
        r5 = r5 + 1;
        goto L4
    L13:
        return r1;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double getNorm() {
        double[] r1 = new double[52];
        double r6 = 0.0d;
        int r5 = 0;
    L4:
        if (r5 >= this.blockColumns) goto L19;
        int r8 = blockWidth(r5);
        Arrays.fill(r1, 0, r8, 0.0d);
        int r9 = 0;
    L7:
        if (r9 >= this.blockRows) goto L15;
        int r10 = blockHeight(r9);
        double[] r11 = this.blocks[(this.blockColumns * r9) + r5];
        int r12 = 0;
    L9:
        if (r12 >= r8) goto L14;
        double r14 = 0.0d;
        int r13 = 0;
    L11:
        if (r13 >= r10) goto L13;
        r14 = r14 + FastMath.abs(r11[(r13 * r8) + r12]);
        r13 = r13 + 1;
        goto L11
    L13:
        r1[r12] = r1[r12] + r14;
        r12 = r12 + 1;
        goto L9
    L14:
        r9 = r9 + 1;
        goto L7
    L15:
        int r15 = 0;
    L16:
        if (r15 >= r8) goto L18;
        r6 = FastMath.max(r6, r1[r15]);
        r15 = r15 + 1;
        goto L16
    L18:
        r5 = r5 + 1;
        goto L4
    L19:
        return r6;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double getFrobeniusNorm() {
        double r0 = 0.0d;
        int r3 = 0;
    L3:
        double[][] r4 = this.blocks;
        if (r3 >= r4.length) goto L10;
        double[] r5 = r4[r3];
        int r6 = r5.length;
        int r7 = 0;
    L6:
        if (r7 >= r6) goto L8;
        double r8 = r5[r7];
        r0 = r0 + (r8 * r8);
        r7 = r7 + 1;
        goto L6
    L8:
        r3 = r3 + 1;
        goto L3
    L10:
        return FastMath.sqrt(r0);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public BlockRealMatrix getSubMatrix(int r32, int r33, int r34, int r35) throws OutOfRangeException, NumberIsTooSmallException {
        MatrixUtils.checkSubMatrixIndex(this, r32, r33, r34, r35);
        BlockRealMatrix r12 = new BlockRealMatrix((r33 - r32) + 1, (r35 - r34) + 1);
        int r13 = r32 % 52;
        int r14 = r34 / 52;
        int r15 = r34 % 52;
        int r17 = r32 / 52;
        int r10 = 0;
    L4:
        if (r10 >= r12.blockRows) goto L19;
        int r18 = r12.blockHeight(r10);
        int r8 = r14;
        int r9 = 0;
    L7:
        if (r9 >= r12.blockColumns) goto L18;
        int r19 = r12.blockWidth(r9);
        double[] r20 = r12.blocks[(r12.blockColumns * r10) + r9];
        int r21 = (this.blockColumns * r17) + r8;
        int r22 = blockWidth(r8);
        int r23 = r18 + r13;
        int r24 = r23 - 52;
        int r25 = r19 + r15;
        int r26 = r25 - 52;
        if (r24 <= 0) goto L13;
        if (r26 <= 0) goto L12;
        int r27 = blockWidth(r8 + 1);
        int r28 = r8;
        int r29 = r9;
        int r30 = r10;
        copyBlockPart(this.blocks[r21], r22, r13, 52, r15, 52, r20, r19, 0, 0);
        int r210 = r19 - r26;
        copyBlockPart(this.blocks[r21 + 1], r27, r13, 52, 0, r26, r20, r19, 0, r210);
        int r211 = r18 - r24;
        copyBlockPart(this.blocks[r21 + this.blockColumns], r22, 0, r24, r15, 52, r20, r19, r211, 0);
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
        copyBlockPart(this.blocks[r21], r22, r13, 52, r15, r25, r20, r19, 0, 0);
        copyBlockPart(this.blocks[r21 + this.blockColumns], r22, 0, r24, r15, r25, r20, r19, r18 - r24, 0);
        goto L17
    L13:
        r28 = r8;
        r29 = r9;
        r30 = r10;
        if (r26 <= 0) goto L16;
        int r212 = blockWidth(r28 + 1);
        copyBlockPart(this.blocks[r21], r22, r13, r23, r15, 52, r20, r19, 0, 0);
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

    private void copyBlockPart(double[] r1, int r2, int r3, int r4, int r5, int r6, double[] r7, int r8, int r9, int r10) {
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

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setSubMatrix(double[][] r23, int r24, int r25) throws OutOfRangeException, NoDataException, NullArgumentException, DimensionMismatchException {
        BlockRealMatrix r0 = this;
        double[][] r1 = r23;
        int r2 = r24;
        MathUtils.checkNotNull(r23);
        int r4 = 0;
        int r5 = r1[0].length;
        if (r5 == 0) goto L22;
        int r6 = (r1.length + r2) - 1;
        int r7 = (r25 + r5) - 1;
        MatrixUtils.checkSubMatrixIndex(r0, r2, r6, r25, r7);
        int r8 = r1.length;
    L5:
        if (r4 >= r8) goto L11;
        double[] r9 = r1[r4];
        if (r9.length != r5) goto L10;
        r4 = r4 + 1;
        goto L5
    L10:
        throw new DimensionMismatchException(r5, r9.length);
    L11:
        int r10 = r2 / 52;
        int r11 = (r6 + 52) / 52;
        int r12 = r25 / 52;
        int r13 = (r7 + 52) / 52;
    L12:
        if (r10 >= r11) goto L20;
        int r14 = r0.blockHeight(r10);
        int r15 = r10 * 52;
        int r16 = FastMath.max(r2, r15);
        int r17 = FastMath.min(r6 + 1, r14 + r15);
        int r18 = r12;
    L14:
        if (r18 >= r13) goto L19;
        int r19 = r0.blockWidth(r18);
        int r110 = r18 * 52;
        int r111 = FastMath.max(r25, r110);
        int r112 = r11;
        int r113 = r6;
        int r20 = FastMath.min(r7 + 1, r110 + r19) - r111;
        int r114 = r7;
        double[] r21 = r0.blocks[(r0.blockColumns * r10) + r18];
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

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public BlockRealMatrix getRowMatrix(int r12) throws OutOfRangeException {
        MatrixUtils.checkRowIndex(this, r12);
        BlockRealMatrix r0 = new BlockRealMatrix(1, this.columns);
        int r1 = r12 / 52;
        int r13 = r12 - (r1 * 52);
        double[] r2 = r0.blocks[0];
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L4:
        if (r4 >= this.blockColumns) goto L10;
        int r7 = blockWidth(r4);
        double[] r8 = this.blocks[(this.blockColumns * r1) + r4];
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

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setRowMatrix(int r2, RealMatrix r3) throws OutOfRangeException, MatrixDimensionMismatchException {
        setRowMatrix(r2, (BlockRealMatrix) r3);     // Catch: ClassCastException -> L4
        return;
    L4:
        super.setRowMatrix(r2, r3);
    }

    public void setRowMatrix(int r11, BlockRealMatrix r12) throws OutOfRangeException, MatrixDimensionMismatchException {
        MatrixUtils.checkRowIndex(this, r11);
        int r0 = getColumnDimension();
        if (r12.getRowDimension() != 1) goto L16;
        if (r12.getColumnDimension() != r0) goto L16;
        int r1 = r11 / 52;
        int r13 = r11 - (r1 * 52);
        double[] r2 = r12.blocks[0];
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
    L8:
        if (r3 >= this.blockColumns) goto L14;
        int r6 = blockWidth(r3);
        double[] r7 = this.blocks[(this.blockColumns * r1) + r3];
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

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public BlockRealMatrix getColumnMatrix(int r15) throws OutOfRangeException {
        MatrixUtils.checkColumnIndex(this, r15);
        BlockRealMatrix r0 = new BlockRealMatrix(this.rows, 1);
        int r1 = r15 / 52;
        int r16 = r15 - (r1 * 52);
        int r2 = blockWidth(r1);
        double[] r3 = r0.blocks[0];
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
    L4:
        if (r5 >= this.blockRows) goto L12;
        int r8 = blockHeight(r5);
        double[] r9 = this.blocks[(this.blockColumns * r5) + r1];
        int r10 = 0;
    L6:
        if (r10 >= r8) goto L11;
        if (r6 < r3.length) goto L10;
        r7 = r7 + 1;
        r3 = r0.blocks[r7];
        r6 = 0;
    L10:
        r3[r6] = r9[(r10 * r2) + r16];
        r10 = r10 + 1;
        r6 = r6 + 1;
        goto L6
    L11:
        r5 = r5 + 1;
        goto L4
    L12:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setColumnMatrix(int r2, RealMatrix r3) throws OutOfRangeException, MatrixDimensionMismatchException {
        setColumnMatrix(r2, (BlockRealMatrix) r3);     // Catch: ClassCastException -> L4
        return;
    L4:
        super.setColumnMatrix(r2, r3);
    }

    void setColumnMatrix(int r18, BlockRealMatrix r19) throws OutOfRangeException, MatrixDimensionMismatchException {
        MatrixUtils.checkColumnIndex(this, r18);
        int r2 = getRowDimension();
        if (r19.getRowDimension() != r2) goto L18;
        if (r19.getColumnDimension() != 1) goto L18;
        int r3 = r18 / 52;
        int r4 = r18 - (r3 * 52);
        int r5 = blockWidth(r3);
        double[] r6 = r19.blocks[0];
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
    L8:
        if (r7 >= this.blockRows) goto L16;
        int r10 = blockHeight(r7);
        double[] r11 = this.blocks[(this.blockColumns * r7) + r3];
        int r12 = 0;
    L10:
        if (r12 >= r10) goto L15;
        if (r8 < r6.length) goto L14;
        r9 = r9 + 1;
        r6 = r19.blocks[r9];
        r8 = 0;
    L14:
        r11[(r12 * r5) + r4] = r6[r8];
        r12 = r12 + 1;
        r8 = r8 + 1;
        goto L10
    L15:
        r7 = r7 + 1;
        goto L8
    L16:
        return;
    L18:
        throw new MatrixDimensionMismatchException(r19.getRowDimension(), r19.getColumnDimension(), r2, 1);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public RealVector getRowVector(int r9) throws OutOfRangeException {
        MatrixUtils.checkRowIndex(this, r9);
        double[] r0 = new double[this.columns];
        int r1 = r9 / 52;
        int r10 = r9 - (r1 * 52);
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
        return new ArrayRealVector(r0, false);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setRowVector(int r2, RealVector r3) throws OutOfRangeException, MatrixDimensionMismatchException {
        setRow(r2, ((ArrayRealVector) r3).getDataRef());     // Catch: ClassCastException -> L4
        return;
    L4:
        super.setRowVector(r2, r3);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public RealVector getColumnVector(int r13) throws OutOfRangeException {
        MatrixUtils.checkColumnIndex(this, r13);
        double[] r0 = new double[this.rows];
        int r1 = r13 / 52;
        int r14 = r13 - (r1 * 52);
        int r2 = blockWidth(r1);
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r4 >= this.blockRows) goto L10;
        int r6 = blockHeight(r4);
        double[] r7 = this.blocks[(this.blockColumns * r4) + r1];
        int r8 = 0;
    L6:
        if (r8 >= r6) goto L8;
        r0[r5] = r7[(r8 * r2) + r14];
        r8 = r8 + 1;
        r5 = r5 + 1;
        goto L6
    L8:
        r4 = r4 + 1;
        goto L4
    L10:
        return new ArrayRealVector(r0, false);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setColumnVector(int r2, RealVector r3) throws OutOfRangeException, MatrixDimensionMismatchException {
        setColumn(r2, ((ArrayRealVector) r3).getDataRef());     // Catch: ClassCastException -> L4
        return;
    L4:
        super.setColumnVector(r2, r3);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double[] getRow(int r8) throws OutOfRangeException {
        MatrixUtils.checkRowIndex(this, r8);
        double[] r0 = new double[this.columns];
        int r1 = r8 / 52;
        int r9 = r8 - (r1 * 52);
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

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setRow(int r7, double[] r8) throws OutOfRangeException, MatrixDimensionMismatchException {
        MatrixUtils.checkRowIndex(this, r7);
        int r0 = getColumnDimension();
        if (r8.length != r0) goto L10;
        int r1 = r7 / 52;
        int r9 = r7 - (r1 * 52);
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

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double[] getColumn(int r13) throws OutOfRangeException {
        MatrixUtils.checkColumnIndex(this, r13);
        double[] r0 = new double[this.rows];
        int r1 = r13 / 52;
        int r14 = r13 - (r1 * 52);
        int r2 = blockWidth(r1);
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r4 >= this.blockRows) goto L9;
        int r6 = blockHeight(r4);
        double[] r7 = this.blocks[(this.blockColumns * r4) + r1];
        int r8 = 0;
    L6:
        if (r8 >= r6) goto L8;
        r0[r5] = r7[(r8 * r2) + r14];
        r8 = r8 + 1;
        r5 = r5 + 1;
        goto L6
    L8:
        r4 = r4 + 1;
        goto L4
    L9:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setColumn(int r13, double[] r14) throws OutOfRangeException, MatrixDimensionMismatchException {
        MatrixUtils.checkColumnIndex(this, r13);
        int r0 = getRowDimension();
        if (r14.length != r0) goto L13;
        int r1 = r13 / 52;
        int r15 = r13 - (r1 * 52);
        int r2 = blockWidth(r1);
        int r3 = 0;
        int r4 = 0;
    L6:
        if (r3 >= this.blockRows) goto L11;
        int r5 = blockHeight(r3);
        double[] r6 = this.blocks[(this.blockColumns * r3) + r1];
        int r7 = 0;
    L8:
        if (r7 >= r5) goto L10;
        r6[(r7 * r2) + r15] = r14[r4];
        r7 = r7 + 1;
        r4 = r4 + 1;
        goto L8
    L10:
        r3 = r3 + 1;
        goto L6
    L11:
        return;
    L13:
        throw new MatrixDimensionMismatchException(r14.length, 1, r0, 1);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double getEntry(int r4, int r5) throws OutOfRangeException {
        MatrixUtils.checkMatrixIndex(this, r4, r5);
        int r0 = r4 / 52;
        int r1 = r5 / 52;
        int r6 = ((r4 - (r0 * 52)) * blockWidth(r1)) + (r5 - (r1 * 52));
        return this.blocks[(r0 * this.blockColumns) + r1][r6];
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setEntry(int r4, int r5, double r6) throws OutOfRangeException {
        MatrixUtils.checkMatrixIndex(this, r4, r5);
        int r0 = r4 / 52;
        int r1 = r5 / 52;
        int r7 = ((r4 - (r0 * 52)) * blockWidth(r1)) + (r5 - (r1 * 52));
        this.blocks[(r0 * this.blockColumns) + r1][r7] = r6;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void addToEntry(int r4, int r5, double r6) throws OutOfRangeException {
        MatrixUtils.checkMatrixIndex(this, r4, r5);
        int r0 = r4 / 52;
        int r1 = r5 / 52;
        int r7 = ((r4 - (r0 * 52)) * blockWidth(r1)) + (r5 - (r1 * 52));
        double[] r3 = this.blocks[(r0 * this.blockColumns) + r1];
        r3[r7] = r3[r7] + r6;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void multiplyEntry(int r4, int r5, double r6) throws OutOfRangeException {
        MatrixUtils.checkMatrixIndex(this, r4, r5);
        int r0 = r4 / 52;
        int r1 = r5 / 52;
        int r7 = ((r4 - (r0 * 52)) * blockWidth(r1)) + (r5 - (r1 * 52));
        double[] r3 = this.blocks[(r0 * this.blockColumns) + r1];
        r3[r7] = r3[r7] * r6;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public BlockRealMatrix transpose() {
        int r1 = getRowDimension();
        BlockRealMatrix r3 = new BlockRealMatrix(getColumnDimension(), r1);
        int r2 = 0;
        int r4 = 0;
    L4:
        if (r2 >= this.blockColumns) goto L16;
        int r5 = 0;
    L7:
        if (r5 >= this.blockRows) goto L15;
        double[] r6 = r3.blocks[r4];
        double[] r7 = this.blocks[(this.blockColumns * r5) + r2];
        int r8 = r2 * 52;
        int r9 = FastMath.min(r8 + 52, this.columns);
        int r10 = r5 * 52;
        int r11 = FastMath.min(r10 + 52, this.rows);
        int r12 = r8;
        int r13 = 0;
    L9:
        if (r12 >= r9) goto L14;
        int r14 = r9 - r8;
        int r15 = r12 - r8;
        int r16 = r10;
    L11:
        if (r16 >= r11) goto L13;
        r6[r13] = r7[r15];
        r13 = r13 + 1;
        r15 = r15 + r14;
        r16 = r16 + 1;
        goto L11
    L13:
        r12 = r12 + 1;
        goto L9
    L14:
        r4 = r4 + 1;
        r5 = r5 + 1;
        goto L7
    L15:
        r2 = r2 + 1;
        goto L4
    L16:
        return r3;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
    public int getRowDimension() {
        return this.rows;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
    public int getColumnDimension() {
        return this.columns;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double[] operate(double[] r23) throws DimensionMismatchException {
        if (r23.length != this.columns) goto L23;
        double[] r2 = new double[this.rows];
        int r4 = 0;
    L6:
        if (r4 >= this.blockRows) goto L21;
        int r5 = r4 * 52;
        int r6 = FastMath.min(r5 + 52, this.rows);
        int r7 = 0;
    L8:
        int r8 = this.blockColumns;
        if (r7 >= r8) goto L20;
        double[] r9 = this.blocks[(r8 * r4) + r7];
        int r10 = r7 * 52;
        int r11 = FastMath.min(r10 + 52, this.columns);
        int r12 = r5;
        int r13 = 0;
    L11:
        if (r12 >= r6) goto L19;
        double r14 = 0.0d;
        int r15 = r10;
    L14:
        if (r15 >= (r11 - 3)) goto L16;
        r14 = r14 + ((((r9[r13] * r23[r15]) + (r9[r13 + 1] * r23[r15 + 1])) + (r9[r13 + 2] * r23[r15 + 2])) + (r9[r13 + 3] * r23[r15 + 3]));
        r13 = r13 + 4;
        r15 = r15 + 4;
    L16:
        if (r15 >= r11) goto L18;
        r14 = r14 + (r9[r13] * r23[r15]);
        r15 = r15 + 1;
        r13 = r13 + 1;
        goto L16
    L18:
        r2[r12] = r2[r12] + r14;
        r12 = r12 + 1;
        goto L11
    L19:
        r7 = r7 + 1;
        goto L8
    L20:
        r4 = r4 + 1;
        goto L6
    L21:
        return r2;
    L23:
        throw new DimensionMismatchException(r23.length, this.columns);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double[] preMultiply(double[] r27) throws DimensionMismatchException {
        if (r27.length != this.rows) goto L23;
        double[] r2 = new double[this.columns];
        int r4 = 0;
    L6:
        if (r4 >= this.blockColumns) goto L21;
        int r5 = blockWidth(r4);
        int r6 = r5 + r5;
        int r7 = r6 + r5;
        int r8 = r7 + r5;
        int r9 = r4 * 52;
        int r10 = FastMath.min(r9 + 52, this.columns);
        int r11 = 0;
    L9:
        if (r11 >= this.blockRows) goto L20;
        double[] r12 = this.blocks[(this.blockColumns * r11) + r4];
        int r13 = r11 * 52;
        int r14 = FastMath.min(r13 + 52, this.rows);
        int r15 = r9;
    L11:
        if (r15 >= r10) goto L19;
        int r16 = r15 - r9;
        double r17 = 0.0d;
        int r3 = r13;
    L13:
        int r19 = r9;
        if (r3 >= (r14 - 3)) goto L16;
        r17 = r17 + ((((r12[r16] * r27[r3]) + (r12[r16 + r5] * r27[r3 + 1])) + (r12[r16 + r6] * r27[r3 + 2])) + (r12[r16 + r7] * r27[r3 + 3]));
        r16 = r16 + r8;
        r3 = r3 + 4;
        r9 = r19;
    L16:
        if (r3 >= r14) goto L18;
        r17 = r17 + (r12[r16] * r27[r3]);
        r16 = r16 + r5;
        r3 = r3 + 1;
        goto L16
    L18:
        r2[r15] = r2[r15] + r17;
        r15 = r15 + 1;
        r9 = r19;
        goto L11
    L19:
        r11 = r11 + 1;
        goto L9
    L20:
        r4 = r4 + 1;
        goto L6
    L21:
        return r2;
    L23:
        throw new DimensionMismatchException(r27.length, this.rows);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double walkInRowOrder(RealMatrixChangingVisitor r14) {
        int r1 = this.rows;
        int r2 = this.columns;
        r14.start(r1, r2, 0, r1 - 1, 0, r2 - 1);
        int r3 = 0;
    L4:
        if (r3 >= this.blockRows) goto L17;
        int r4 = r3 * 52;
        int r5 = FastMath.min(r4 + 52, this.rows);
        int r6 = r4;
    L6:
        if (r6 >= r5) goto L15;
        int r7 = 0;
    L9:
        if (r7 >= this.blockColumns) goto L14;
        int r8 = blockWidth(r7);
        int r9 = r7 * 52;
        int r10 = FastMath.min(r9 + 52, this.columns);
        double[] r11 = this.blocks[(this.blockColumns * r3) + r7];
        int r12 = (r6 - r4) * r8;
    L11:
        if (r9 >= r10) goto L13;
        r11[r12] = r14.visit(r6, r9, r11[r12]);
        r12 = r12 + 1;
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
        return r14.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double walkInRowOrder(RealMatrixPreservingVisitor r14) {
        int r1 = this.rows;
        int r2 = this.columns;
        r14.start(r1, r2, 0, r1 - 1, 0, r2 - 1);
        int r3 = 0;
    L4:
        if (r3 >= this.blockRows) goto L17;
        int r4 = r3 * 52;
        int r5 = FastMath.min(r4 + 52, this.rows);
        int r6 = r4;
    L6:
        if (r6 >= r5) goto L15;
        int r7 = 0;
    L9:
        if (r7 >= this.blockColumns) goto L14;
        int r8 = blockWidth(r7);
        int r9 = r7 * 52;
        int r10 = FastMath.min(r9 + 52, this.columns);
        double[] r11 = this.blocks[(this.blockColumns * r3) + r7];
        int r12 = (r6 - r4) * r8;
    L11:
        if (r9 >= r10) goto L13;
        r14.visit(r6, r9, r11[r12]);
        r12 = r12 + 1;
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
        return r14.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double walkInRowOrder(RealMatrixChangingVisitor r19, int r20, int r21, int r22, int r23) throws OutOfRangeException, NumberIsTooSmallException {
        BlockRealMatrix r0 = this;
        MatrixUtils.checkSubMatrixIndex(r0, r20, r21, r22, r23);
        r19.start(r0.rows, r0.columns, r20, r21, r22, r23);
        int r1 = r20 / 52;
    L4:
        if (r1 >= ((r21 / 52) + 1)) goto L17;
        int r2 = r1 * 52;
        int r3 = FastMath.max(r20, r2);
        int r4 = r1 + 1;
        int r5 = FastMath.min(r4 * 52, r21 + 1);
    L6:
        if (r3 >= r5) goto L15;
        int r6 = r22 / 52;
    L9:
        if (r6 >= ((r23 / 52) + 1)) goto L14;
        int r7 = r0.blockWidth(r6);
        int r12 = r6 * 52;
        int r13 = FastMath.max(r22, r12);
        int r14 = r6 + 1;
        int r16 = r4;
        int r8 = FastMath.min(r14 * 52, r23 + 1);
        int r17 = r5;
        double[] r9 = r0.blocks[(r0.blockColumns * r1) + r6];
        int r10 = (((r3 - r2) * r7) + r13) - r12;
    L11:
        if (r13 >= r8) goto L13;
        r9[r10] = r19.visit(r3, r13, r9[r10]);
        r10 = r10 + 1;
        r13 = r13 + 1;
        r1 = r1;
        goto L11
    L13:
        r0 = this;
        r6 = r14;
        r4 = r16;
        r5 = r17;
        goto L9
    L14:
        r3 = r3 + 1;
        r0 = this;
        goto L6
    L15:
        r0 = this;
        r1 = r4;
        goto L4
    L17:
        return r19.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double walkInRowOrder(RealMatrixPreservingVisitor r19, int r20, int r21, int r22, int r23) throws OutOfRangeException, NumberIsTooSmallException {
        BlockRealMatrix r0 = this;
        MatrixUtils.checkSubMatrixIndex(r0, r20, r21, r22, r23);
        r19.start(r0.rows, r0.columns, r20, r21, r22, r23);
        int r1 = r20 / 52;
    L4:
        if (r1 >= ((r21 / 52) + 1)) goto L17;
        int r2 = r1 * 52;
        int r3 = FastMath.max(r20, r2);
        int r4 = r1 + 1;
        int r5 = FastMath.min(r4 * 52, r21 + 1);
    L6:
        if (r3 >= r5) goto L15;
        int r6 = r22 / 52;
    L9:
        if (r6 >= ((r23 / 52) + 1)) goto L14;
        int r7 = r0.blockWidth(r6);
        int r12 = r6 * 52;
        int r13 = FastMath.max(r22, r12);
        int r14 = r6 + 1;
        int r16 = r4;
        int r8 = FastMath.min(r14 * 52, r23 + 1);
        int r17 = r5;
        double[] r9 = r0.blocks[(r0.blockColumns * r1) + r6];
        int r10 = (((r3 - r2) * r7) + r13) - r12;
    L11:
        if (r13 >= r8) goto L13;
        r19.visit(r3, r13, r9[r10]);
        r10 = r10 + 1;
        r13 = r13 + 1;
        r1 = r1;
        goto L11
    L13:
        r0 = this;
        r6 = r14;
        r4 = r16;
        r5 = r17;
        goto L9
    L14:
        r3 = r3 + 1;
        r0 = this;
        goto L6
    L15:
        r0 = this;
        r1 = r4;
        goto L4
    L17:
        return r19.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double walkInOptimizedOrder(RealMatrixChangingVisitor r15) {
        int r1 = this.rows;
        int r2 = this.columns;
        r15.start(r1, r2, 0, r1 - 1, 0, r2 - 1);
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r3 >= this.blockRows) goto L17;
        int r5 = r3 * 52;
        int r6 = FastMath.min(r5 + 52, this.rows);
        int r7 = 0;
    L7:
        if (r7 >= this.blockColumns) goto L15;
        int r8 = r7 * 52;
        int r9 = FastMath.min(r8 + 52, this.columns);
        double[] r10 = this.blocks[r4];
        int r11 = 0;
        int r12 = r5;
    L9:
        if (r12 >= r6) goto L14;
        int r13 = r8;
    L11:
        if (r13 >= r9) goto L13;
        r10[r11] = r15.visit(r12, r13, r10[r11]);
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
        return r15.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double walkInOptimizedOrder(RealMatrixPreservingVisitor r15) {
        int r1 = this.rows;
        int r2 = this.columns;
        r15.start(r1, r2, 0, r1 - 1, 0, r2 - 1);
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r3 >= this.blockRows) goto L17;
        int r5 = r3 * 52;
        int r6 = FastMath.min(r5 + 52, this.rows);
        int r7 = 0;
    L7:
        if (r7 >= this.blockColumns) goto L15;
        int r8 = r7 * 52;
        int r9 = FastMath.min(r8 + 52, this.columns);
        double[] r10 = this.blocks[r4];
        int r11 = 0;
        int r12 = r5;
    L9:
        if (r12 >= r6) goto L14;
        int r13 = r8;
    L11:
        if (r13 >= r9) goto L13;
        r15.visit(r12, r13, r10[r11]);
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
        return r15.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double walkInOptimizedOrder(RealMatrixChangingVisitor r22, int r23, int r24, int r25, int r26) throws OutOfRangeException, NumberIsTooSmallException {
        BlockRealMatrix r0 = this;
        MatrixUtils.checkSubMatrixIndex(r0, r23, r24, r25, r26);
        r22.start(r0.rows, r0.columns, r23, r24, r25, r26);
        int r1 = r23 / 52;
    L4:
        if (r1 >= ((r24 / 52) + 1)) goto L17;
        int r2 = r1 * 52;
        int r3 = FastMath.max(r23, r2);
        int r4 = r1 + 1;
        int r5 = FastMath.min(r4 * 52, r24 + 1);
        int r6 = r25 / 52;
    L7:
        if (r6 >= ((r26 / 52) + 1)) goto L15;
        int r7 = r0.blockWidth(r6);
        int r12 = r6 * 52;
        int r13 = FastMath.max(r25, r12);
        int r14 = r6 + 1;
        int r16 = r3;
        int r8 = FastMath.min(r14 * 52, r26 + 1);
        int r17 = r4;
        double[] r9 = r0.blocks[(r0.blockColumns * r1) + r6];
        int r10 = r16;
    L9:
        if (r10 >= r5) goto L14;
        int r15 = (((r10 - r2) * r7) + r13) - r12;
        int r11 = r13;
    L11:
        if (r11 >= r8) goto L13;
        int r18 = r1;
        r9[r15] = r22.visit(r10, r11, r9[r15]);
        r15 = r15 + 1;
        r11 = r11 + 1;
        r1 = r18;
        r2 = r2;
        r8 = r8;
        goto L11
    L13:
        r10 = r10 + 1;
        r8 = r8;
        goto L9
    L14:
        r0 = this;
        r6 = r14;
        r3 = r16;
        r4 = r17;
        goto L7
    L15:
        r0 = this;
        r1 = r4;
        goto L4
    L17:
        return r22.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double walkInOptimizedOrder(RealMatrixPreservingVisitor r22, int r23, int r24, int r25, int r26) throws OutOfRangeException, NumberIsTooSmallException {
        BlockRealMatrix r0 = this;
        MatrixUtils.checkSubMatrixIndex(r0, r23, r24, r25, r26);
        r22.start(r0.rows, r0.columns, r23, r24, r25, r26);
        int r1 = r23 / 52;
    L4:
        if (r1 >= ((r24 / 52) + 1)) goto L17;
        int r2 = r1 * 52;
        int r3 = FastMath.max(r23, r2);
        int r4 = r1 + 1;
        int r5 = FastMath.min(r4 * 52, r24 + 1);
        int r6 = r25 / 52;
    L7:
        if (r6 >= ((r26 / 52) + 1)) goto L15;
        int r7 = r0.blockWidth(r6);
        int r12 = r6 * 52;
        int r13 = FastMath.max(r25, r12);
        int r14 = r6 + 1;
        int r16 = r3;
        int r8 = FastMath.min(r14 * 52, r26 + 1);
        int r17 = r4;
        double[] r9 = r0.blocks[(r0.blockColumns * r1) + r6];
        int r10 = r16;
    L9:
        if (r10 >= r5) goto L14;
        int r15 = (((r10 - r2) * r7) + r13) - r12;
        int r11 = r13;
    L11:
        if (r11 >= r8) goto L13;
        int r18 = r1;
        r22.visit(r10, r11, r9[r15]);
        r15 = r15 + 1;
        r11 = r11 + 1;
        r1 = r18;
        r2 = r2;
        r8 = r8;
        goto L11
    L13:
        r10 = r10 + 1;
        r8 = r8;
        goto L9
    L14:
        r0 = this;
        r6 = r14;
        r3 = r16;
        r4 = r17;
        goto L7
    L15:
        r0 = this;
        r1 = r4;
        goto L4
    L17:
        return r22.end();
    }

    private int blockHeight(int r3) {
        if (r3 == (this.blockRows - 1)) goto L5;
        return 52;
    L5:
        return this.rows - (r3 * 52);
    }

    private int blockWidth(int r3) {
        if (r3 == (this.blockColumns - 1)) goto L5;
        return 52;
    L5:
        return this.columns - (r3 * 52);
    }
}
