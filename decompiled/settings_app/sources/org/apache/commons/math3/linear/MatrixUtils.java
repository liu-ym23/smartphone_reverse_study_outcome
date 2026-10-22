package org.apache.commons.math3.linear;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.fraction.BigFraction;
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class MatrixUtils {
    public static final RealMatrixFormat DEFAULT_FORMAT = null;
    public static final RealMatrixFormat OCTAVE_FORMAT = null;

    private static class BigFractionMatrixConverter extends DefaultFieldMatrixPreservingVisitor<BigFraction> {
        private double[][] data;

        @Override // org.apache.commons.math3.linear.DefaultFieldMatrixPreservingVisitor, org.apache.commons.math3.linear.FieldMatrixPreservingVisitor
        public /* bridge */ /* synthetic */ void visit(int r1, int r2, FieldElement r3) {
            visit(r1, r2, (BigFraction) r3);
        }

        BigFractionMatrixConverter() {
            super(BigFraction.ZERO);
        }

        @Override // org.apache.commons.math3.linear.DefaultFieldMatrixPreservingVisitor, org.apache.commons.math3.linear.FieldMatrixPreservingVisitor
        public void start(int r1, int r2, int r3, int r4, int r5, int r6) {
            this.data = (double[][]) Array.newInstance(Double.TYPE, new int[]{r1, r2});
        }

        public void visit(int r3, int r4, BigFraction r5) {
            this.data[r3][r4] = r5.doubleValue();
        }

        Array2DRowRealMatrix getConvertedMatrix() {
            return new Array2DRowRealMatrix(this.data, false);
        }
    }

    private static class FractionMatrixConverter extends DefaultFieldMatrixPreservingVisitor<Fraction> {
        private double[][] data;

        @Override // org.apache.commons.math3.linear.DefaultFieldMatrixPreservingVisitor, org.apache.commons.math3.linear.FieldMatrixPreservingVisitor
        public /* bridge */ /* synthetic */ void visit(int r1, int r2, FieldElement r3) {
            visit(r1, r2, (Fraction) r3);
        }

        FractionMatrixConverter() {
            super(Fraction.ZERO);
        }

        @Override // org.apache.commons.math3.linear.DefaultFieldMatrixPreservingVisitor, org.apache.commons.math3.linear.FieldMatrixPreservingVisitor
        public void start(int r1, int r2, int r3, int r4, int r5, int r6) {
            this.data = (double[][]) Array.newInstance(Double.TYPE, new int[]{r1, r2});
        }

        public void visit(int r3, int r4, Fraction r5) {
            this.data[r3][r4] = r5.doubleValue();
        }

        Array2DRowRealMatrix getConvertedMatrix() {
            return new Array2DRowRealMatrix(this.data, false);
        }
    }

    static {
        DEFAULT_FORMAT = RealMatrixFormat.getInstance();
        OCTAVE_FORMAT = new RealMatrixFormat("[", "]", "", "", VectorFormat.DEFAULT_SEPARATOR, ", ");
    }

    private MatrixUtils() {
    }

    public static RealMatrix createRealMatrix(int r2, int r3) {
        if ((r2 * r3) > 4096) goto L6;
        return new Array2DRowRealMatrix(r2, r3);
    L6:
        return new BlockRealMatrix(r2, r3);
    }

    public static <T extends FieldElement<T>> FieldMatrix<T> createFieldMatrix(Field<T> r2, int r3, int r4) {
        if ((r3 * r4) > 4096) goto L6;
        return new Array2DRowFieldMatrix(r2, r3, r4);
    L6:
        return new BlockFieldMatrix(r2, r3, r4);
    }

    public static RealMatrix createRealMatrix(double[][] r2) throws NullArgumentException, DimensionMismatchException, NoDataException {
        if (r2 == null) goto L11;
        double[] r0 = r2[0];
        if (r0 == null) goto L11;
        if ((r2.length * r0.length) > 4096) goto L9;
        return new Array2DRowRealMatrix(r2);
    L9:
        return new BlockRealMatrix(r2);
    L11:
        throw new NullArgumentException();
    }

    public static <T extends FieldElement<T>> FieldMatrix<T> createFieldMatrix(T[][] r2) throws DimensionMismatchException, NoDataException, NullArgumentException {
        if (r2 == null) goto L11;
        T[] r0 = r2[0];
        if (r0 == null) goto L11;
        if ((r2.length * r0.length) > 4096) goto L9;
        return new Array2DRowFieldMatrix(r2);
    L9:
        return new BlockFieldMatrix(r2);
    L11:
        throw new NullArgumentException();
    }

    public static RealMatrix createRealIdentityMatrix(int r4) {
        RealMatrix r0 = createRealMatrix(r4, r4);
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L5;
        r0.setEntry(r1, r1, 1.0d);
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    public static <T extends FieldElement<T>> FieldMatrix<T> createFieldIdentityMatrix(Field<T> r6, int r7) {
        T r0 = r6.getZero();
        T r1 = r6.getOne();
        FieldElement[][] r2 = (FieldElement[][]) MathArrays.buildArray(r6, r7, r7);
        int r4 = 0;
    L3:
        if (r4 >= r7) goto L6;
        FieldElement[] r5 = r2[r4];
        Arrays.fill(r5, r0);
        r5[r4] = r1;
        r4 = r4 + 1;
        goto L3
    L6:
        return new Array2DRowFieldMatrix(r6, r2, false);
    }

    public static RealMatrix createRealDiagonalMatrix(double[] r4) {
        RealMatrix r0 = createRealMatrix(r4.length, r4.length);
        int r1 = 0;
    L4:
        if (r1 >= r4.length) goto L6;
        r0.setEntry(r1, r1, r4[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static <T extends FieldElement<T>> FieldMatrix<T> createFieldDiagonalMatrix(T[] r4) {
        int r0 = 0;
        FieldMatrix<T> r1 = createFieldMatrix(r4[0].getField(), r4.length, r4.length);
    L4:
        if (r0 >= r4.length) goto L6;
        r1.setEntry(r0, r0, r4[r0]);
        r0 = r0 + 1;
        goto L4
    L6:
        return r1;
    }

    public static RealVector createRealVector(double[] r2) throws NoDataException, NullArgumentException {
        if (r2 == null) goto L6;
        return new ArrayRealVector(r2, true);
    L6:
        throw new NullArgumentException();
    }

    public static <T extends FieldElement<T>> FieldVector<T> createFieldVector(T[] r3) throws NoDataException, NullArgumentException, ZeroException {
        if (r3 == null) goto L10;
        if (r3.length == 0) goto L8;
        return new ArrayFieldVector(r3[0].getField(), r3, true);
    L8:
        throw new ZeroException(LocalizedFormats.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT, new Object[0]);
    L10:
        throw new NullArgumentException();
    }

    public static RealMatrix createRowRealMatrix(double[] r6) throws NoDataException, NullArgumentException {
        if (r6 == null) goto L8;
        int r0 = r6.length;
        RealMatrix r1 = createRealMatrix(1, r0);
        int r3 = 0;
    L4:
        if (r3 >= r0) goto L6;
        r1.setEntry(0, r3, r6[r3]);
        r3 = r3 + 1;
        goto L4
    L6:
        return r1;
    L8:
        throw new NullArgumentException();
    }

    public static <T extends FieldElement<T>> FieldMatrix<T> createRowFieldMatrix(T[] r5) throws NoDataException, NullArgumentException {
        if (r5 == null) goto L12;
        int r0 = r5.length;
        if (r0 == 0) goto L10;
        FieldMatrix<T> r2 = createFieldMatrix(r5[0].getField(), 1, r0);
        int r3 = 0;
    L6:
        if (r3 >= r0) goto L8;
        r2.setEntry(0, r3, r5[r3]);
        r3 = r3 + 1;
        goto L6
    L8:
        return r2;
    L10:
        throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
    L12:
        throw new NullArgumentException();
    }

    public static RealMatrix createColumnRealMatrix(double[] r6) throws NoDataException, NullArgumentException {
        if (r6 == null) goto L8;
        int r0 = r6.length;
        RealMatrix r1 = createRealMatrix(r0, 1);
        int r3 = 0;
    L4:
        if (r3 >= r0) goto L6;
        r1.setEntry(r3, 0, r6[r3]);
        r3 = r3 + 1;
        goto L4
    L6:
        return r1;
    L8:
        throw new NullArgumentException();
    }

    public static <T extends FieldElement<T>> FieldMatrix<T> createColumnFieldMatrix(T[] r5) throws NoDataException, NullArgumentException {
        if (r5 == null) goto L12;
        int r0 = r5.length;
        if (r0 == 0) goto L10;
        FieldMatrix<T> r2 = createFieldMatrix(r5[0].getField(), r0, 1);
        int r3 = 0;
    L6:
        if (r3 >= r0) goto L8;
        r2.setEntry(r3, 0, r5[r3]);
        r3 = r3 + 1;
        goto L6
    L8:
        return r2;
    L10:
        throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
    L12:
        throw new NullArgumentException();
    }

    private static boolean isSymmetricInternal(RealMatrix r11, double r12, boolean r14) {
        int r0 = r11.getRowDimension();
        if (r0 == r11.getColumnDimension()) goto L8;
        if (r14 == true) goto L7;
        return false;
    L7:
        throw new NonSquareMatrixException(r0, r11.getColumnDimension());
    L8:
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L20;
        int r3 = r1 + 1;
        int r4 = r3;
    L11:
        if (r4 >= r0) goto L19;
        double r5 = r11.getEntry(r1, r4);
        double r7 = r11.getEntry(r4, r1);
        if (FastMath.abs(r5 - r7) > (FastMath.max(FastMath.abs(r5), FastMath.abs(r7)) * r12)) goto L14;
        r4 = r4 + 1;
        goto L11
    L14:
        if (r14 == true) goto L17;
        return false;
    L17:
        throw new NonSymmetricMatrixException(r1, r4, r12);
    L19:
        r1 = r3;
        goto L9
    L20:
        return true;
    }

    public static void checkSymmetric(RealMatrix r1, double r2) {
        isSymmetricInternal(r1, r2, true);
    }

    public static boolean isSymmetric(RealMatrix r1, double r2) {
        return isSymmetricInternal(r1, r2, false);
    }

    public static void checkMatrixIndex(AnyMatrix r0, int r1, int r2) throws OutOfRangeException {
        checkRowIndex(r0, r1);
        checkColumnIndex(r0, r2);
    }

    public static void checkRowIndex(AnyMatrix r3, int r4) throws OutOfRangeException {
        if (r4 < 0) goto L7;
        if (r4 >= r3.getRowDimension()) goto L7;
        return;
    L7:
        throw new OutOfRangeException(LocalizedFormats.ROW_INDEX, Integer.valueOf(r4), 0, Integer.valueOf(r3.getRowDimension() - 1));
    }

    public static void checkColumnIndex(AnyMatrix r3, int r4) throws OutOfRangeException {
        if (r4 < 0) goto L7;
        if (r4 >= r3.getColumnDimension()) goto L7;
        return;
    L7:
        throw new OutOfRangeException(LocalizedFormats.COLUMN_INDEX, Integer.valueOf(r4), 0, Integer.valueOf(r3.getColumnDimension() - 1));
    }

    public static void checkSubMatrixIndex(AnyMatrix r1, int r2, int r3, int r4, int r5) throws NumberIsTooSmallException, OutOfRangeException {
        checkRowIndex(r1, r2);
        checkRowIndex(r1, r3);
        if (r3 < r2) goto L10;
        checkColumnIndex(r1, r4);
        checkColumnIndex(r1, r5);
        if (r5 < r4) goto L8;
        return;
    L8:
        throw new NumberIsTooSmallException(LocalizedFormats.INITIAL_COLUMN_AFTER_FINAL_COLUMN, Integer.valueOf(r5), Integer.valueOf(r4), false);
    L10:
        throw new NumberIsTooSmallException(LocalizedFormats.INITIAL_ROW_AFTER_FINAL_ROW, Integer.valueOf(r3), Integer.valueOf(r2), false);
    }

    public static void checkSubMatrixIndex(AnyMatrix r4, int[] r5, int[] r6) throws NoDataException, NullArgumentException, OutOfRangeException {
        if (r5 == null) goto L22;
        if (r6 == null) goto L20;
        if (r5.length == 0) goto L18;
        if (r6.length == 0) goto L16;
        int r0 = r5.length;
        int r1 = 0;
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L11;
        checkRowIndex(r4, r5[r2]);
        r2 = r2 + 1;
        goto L9
    L11:
        int r7 = r6.length;
    L12:
        if (r1 >= r7) goto L14;
        checkColumnIndex(r4, r6[r1]);
        r1 = r1 + 1;
        goto L12
    L14:
        return;
    L16:
        throw new NoDataException(LocalizedFormats.EMPTY_SELECTED_COLUMN_INDEX_ARRAY);
    L18:
        throw new NoDataException(LocalizedFormats.EMPTY_SELECTED_ROW_INDEX_ARRAY);
    L20:
        throw new NullArgumentException();
    L22:
        throw new NullArgumentException();
    }

    public static void checkAdditionCompatible(AnyMatrix r3, AnyMatrix r4) throws MatrixDimensionMismatchException {
        if (r3.getRowDimension() != r4.getRowDimension()) goto L8;
        if (r3.getColumnDimension() != r4.getColumnDimension()) goto L8;
        return;
    L8:
        throw new MatrixDimensionMismatchException(r3.getRowDimension(), r3.getColumnDimension(), r4.getRowDimension(), r4.getColumnDimension());
    }

    public static void checkSubtractionCompatible(AnyMatrix r3, AnyMatrix r4) throws MatrixDimensionMismatchException {
        if (r3.getRowDimension() != r4.getRowDimension()) goto L8;
        if (r3.getColumnDimension() != r4.getColumnDimension()) goto L8;
        return;
    L8:
        throw new MatrixDimensionMismatchException(r3.getRowDimension(), r3.getColumnDimension(), r4.getRowDimension(), r4.getColumnDimension());
    }

    public static void checkMultiplicationCompatible(AnyMatrix r2, AnyMatrix r3) throws DimensionMismatchException {
        if (r2.getColumnDimension() != r3.getRowDimension()) goto L6;
        return;
    L6:
        throw new DimensionMismatchException(r2.getColumnDimension(), r3.getRowDimension());
    }

    public static Array2DRowRealMatrix fractionMatrixToRealMatrix(FieldMatrix<Fraction> r1) {
        FractionMatrixConverter r0 = new FractionMatrixConverter();
        r1.walkInOptimizedOrder(r0);
        return r0.getConvertedMatrix();
    }

    public static Array2DRowRealMatrix bigFractionMatrixToRealMatrix(FieldMatrix<BigFraction> r1) {
        BigFractionMatrixConverter r0 = new BigFractionMatrixConverter();
        r1.walkInOptimizedOrder(r0);
        return r0.getConvertedMatrix();
    }

    public static void serializeRealVector(RealVector r4, ObjectOutputStream r5) throws IOException {
        int r0 = r4.getDimension();
        r5.writeInt(r0);
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5.writeDouble(r4.getEntry(r1));
        r1 = r1 + 1;
        goto L3
    }

    public static void deserializeRealVector(Object r6, String r7, ObjectInputStream r8) throws ClassNotFoundException, IOException {
        int r0 = r8.readInt();     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L10
        double[] r1 = new double[r0];     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L10
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1[r3] = r8.readDouble();     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L10
        r3 = r3 + 1;     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L10
        goto L3
    L5:
        ArrayRealVector r9 = new ArrayRealVector(r1, false);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L10
        java.lang.reflect.Field r10 = r6.getClass().getDeclaredField(r7);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L10
        r10.setAccessible(true);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L10
        r10.set(r6, r9);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L10
        return;
    L7:
        e = move-exception;
        IOException r11 = new IOException();
        r11.initCause(e);
        throw r11;
    L10:
        e = move-exception;
        IOException r12 = new IOException();
        r12.initCause(e);
        throw r12;
    }

    public static void serializeRealMatrix(RealMatrix r7, ObjectOutputStream r8) throws IOException {
        int r0 = r7.getRowDimension();
        int r1 = r7.getColumnDimension();
        r8.writeInt(r0);
        r8.writeInt(r1);
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L8;
        int r4 = 0;
    L5:
        if (r4 >= r1) goto L7;
        r8.writeDouble(r7.getEntry(r3, r4));
        r4 = r4 + 1;
        goto L5
    L7:
        r3 = r3 + 1;
        goto L3
    }

    public static void deserializeRealMatrix(Object r10, String r11, ObjectInputStream r12) throws ClassNotFoundException, IOException {
        int r0 = r12.readInt();     // Catch: IllegalAccessException -> L10 NoSuchFieldException -> L13
        int r1 = r12.readInt();     // Catch: IllegalAccessException -> L10 NoSuchFieldException -> L13
        double[][] r2 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r0, r1});     // Catch: IllegalAccessException -> L10 NoSuchFieldException -> L13
        int r5 = 0;
    L3:
        if (r5 >= r0) goto L8;
        double[] r6 = r2[r5];     // Catch: IllegalAccessException -> L10 NoSuchFieldException -> L13
        int r7 = 0;
    L5:
        if (r7 >= r1) goto L7;
        r6[r7] = r12.readDouble();     // Catch: IllegalAccessException -> L10 NoSuchFieldException -> L13
        r7 = r7 + 1;     // Catch: IllegalAccessException -> L10 NoSuchFieldException -> L13
        goto L5
    L7:
        r5 = r5 + 1;     // Catch: IllegalAccessException -> L10 NoSuchFieldException -> L13
        goto L3
    L8:
        Array2DRowRealMatrix r13 = new Array2DRowRealMatrix(r2, false);     // Catch: IllegalAccessException -> L10 NoSuchFieldException -> L13
        java.lang.reflect.Field r14 = r10.getClass().getDeclaredField(r11);     // Catch: IllegalAccessException -> L10 NoSuchFieldException -> L13
        r14.setAccessible(true);     // Catch: IllegalAccessException -> L10 NoSuchFieldException -> L13
        r14.set(r10, r13);     // Catch: IllegalAccessException -> L10 NoSuchFieldException -> L13
        return;
    L10:
        e = move-exception;
        IOException r15 = new IOException();
        r15.initCause(e);
        throw r15;
    L13:
        e = move-exception;
        IOException r16 = new IOException();
        r16.initCause(e);
        throw r16;
    }

    public static void solveLowerTriangularSystem(RealMatrix r11, RealVector r12) throws DimensionMismatchException, MathArithmeticException, NonSquareMatrixException {
        int r0 = 0;
        if (r11 == null) goto L24;
        if (r12 == null) goto L24;
        if (r11.getRowDimension() != r12.getDimension()) goto L24;
        if (r11.getColumnDimension() != r11.getRowDimension()) goto L22;
        int r1 = r11.getRowDimension();
        int r2 = 0;
    L11:
        if (r2 >= r1) goto L20;
        double r3 = r11.getEntry(r2, r2);
        if (FastMath.abs(r3) < Precision.SAFE_MIN) goto L19;
        double r5 = r12.getEntry(r2) / r3;
        r12.setEntry(r2, r5);
        int r4 = r2 + 1;
        int r6 = r4;
    L15:
        if (r6 >= r1) goto L17;
        r12.setEntry(r6, r12.getEntry(r6) - (r11.getEntry(r6, r2) * r5));
        r6 = r6 + 1;
        goto L15
    L17:
        r2 = r4;
        goto L11
    L19:
        throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR, new Object[0]);
    L20:
        return;
    L22:
        throw new NonSquareMatrixException(r11.getRowDimension(), r11.getColumnDimension());
    L24:
        if (r11 != null) goto L26;
        int r13 = 0;
    L27:
        if (r12 == null) goto L31;
        r0 = r12.getDimension();
    L31:
        throw new DimensionMismatchException(r13, r0);
    L26:
        r13 = r11.getRowDimension();
        goto L27
    }

    public static void solveUpperTriangularSystem(RealMatrix r11, RealVector r12) throws DimensionMismatchException, MathArithmeticException, NonSquareMatrixException {
        int r0 = 0;
        if (r11 == null) goto L25;
        if (r12 == null) goto L25;
        if (r11.getRowDimension() != r12.getDimension()) goto L25;
        if (r11.getColumnDimension() != r11.getRowDimension()) goto L23;
        int r1 = r11.getRowDimension();
    L11:
        r1 = r1 - 1;
        if (r1 <= (-1)) goto L21;
        double r3 = r11.getEntry(r1, r1);
        if (FastMath.abs(r3) < Precision.SAFE_MIN) goto L20;
        double r5 = r12.getEntry(r1) / r3;
        r12.setEntry(r1, r5);
        int r4 = r1 - 1;
    L16:
        if (r4 <= (-1)) goto L11;
        r12.setEntry(r4, r12.getEntry(r4) - (r11.getEntry(r4, r1) * r5));
        r4 = r4 - 1;
        goto L16
    L20:
        throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR, new Object[0]);
    L21:
        return;
    L23:
        throw new NonSquareMatrixException(r11.getRowDimension(), r11.getColumnDimension());
    L25:
        if (r11 != null) goto L27;
        int r13 = 0;
    L28:
        if (r12 == null) goto L32;
        r0 = r12.getDimension();
    L32:
        throw new DimensionMismatchException(r13, r0);
    L27:
        r13 = r11.getRowDimension();
        goto L28
    }

    public static RealMatrix blockInverse(RealMatrix r9, int r10) {
        int r0 = r9.getRowDimension();
        if (r9.getColumnDimension() != r0) goto L23;
        int r1 = r10 + 1;
        RealMatrix r3 = r9.getSubMatrix(0, r10, 0, r10);
        int r4 = r0 - 1;
        RealMatrix r5 = r9.getSubMatrix(0, r10, r1, r4);
        RealMatrix r11 = r9.getSubMatrix(r1, r4, 0, r10);
        RealMatrix r12 = r9.getSubMatrix(r1, r4, r1, r4);
        DecompositionSolver r6 = new SingularValueDecomposition(r3).getSolver();
        if (r6.isNonSingular() == false) goto L21;
        RealMatrix r7 = r6.getInverse();
        DecompositionSolver r8 = new SingularValueDecomposition(r12).getSolver();
        if (r8.isNonSingular() == false) goto L19;
        RealMatrix r13 = r8.getInverse();
        DecompositionSolver r14 = new SingularValueDecomposition(r3.subtract(r5.multiply(r13).multiply(r11))).getSolver();
        if (r14.isNonSingular() == false) goto L17;
        RealMatrix r15 = r14.getInverse();
        DecompositionSolver r16 = new SingularValueDecomposition(r12.subtract(r11.multiply(r7).multiply(r5))).getSolver();
        if (r16.isNonSingular() == false) goto L15;
        RealMatrix r17 = r16.getInverse();
        RealMatrix r18 = r7.multiply(r5).multiply(r17).scalarMultiply(-1.0d);
        RealMatrix r19 = r13.multiply(r11).multiply(r15).scalarMultiply(-1.0d);
        Array2DRowRealMatrix r20 = new Array2DRowRealMatrix(r0, r0);
        r20.setSubMatrix(r15.getData(), 0, 0);
        r20.setSubMatrix(r18.getData(), 0, r1);
        r20.setSubMatrix(r19.getData(), r1, 0);
        r20.setSubMatrix(r17.getData(), r1, r1);
        return r20;
    L15:
        throw new SingularMatrixException();
    L17:
        throw new SingularMatrixException();
    L19:
        throw new SingularMatrixException();
    L21:
        throw new SingularMatrixException();
    L23:
        throw new NonSquareMatrixException(r9.getRowDimension(), r9.getColumnDimension());
    }

    public static RealMatrix inverse(RealMatrix r2) throws NullArgumentException, SingularMatrixException, NonSquareMatrixException {
        return inverse(r2, 0.0d);
    }

    public static RealMatrix inverse(RealMatrix r1, double r2) throws NullArgumentException, SingularMatrixException, NonSquareMatrixException {
        MathUtils.checkNotNull(r1);
        if (r1.isSquare() == false) goto L11;
        if ((r1 instanceof DiagonalMatrix) == false) goto L9;
        return ((DiagonalMatrix) r1).inverse(r2);
    L9:
        return new QRDecomposition(r1, r2).getSolver().getInverse();
    L11:
        throw new NonSquareMatrixException(r1.getRowDimension(), r1.getColumnDimension());
    }
}
