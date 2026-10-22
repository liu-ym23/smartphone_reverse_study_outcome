package org.apache.commons.math3.transform;

import java.io.Serializable;
import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class FastFourierTransformer implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final double[] W_SUB_N_I = null;
    private static final double[] W_SUB_N_R = null;
    static final long serialVersionUID = 20120210;
    private final DftNormalization normalization;

    /* JADX INFO: renamed from: org.apache.commons.math3.transform.FastFourierTransformer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$transform$DftNormalization = null;

        static {
            int[] r0 = new int[DftNormalization.values().length];
            $SwitchMap$org$apache$commons$math3$transform$DftNormalization = r0;
            r0[DftNormalization.STANDARD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$org$apache$commons$math3$transform$DftNormalization[DftNormalization.UNITARY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    @Deprecated
    private static class MultiDimensionalComplexMatrix implements Cloneable {
        protected int[] dimensionSize;
        protected Object multiDimensionalComplexArray;

        MultiDimensionalComplexMatrix(Object r6) {
            this.multiDimensionalComplexArray = r6;
            Object r1 = r6;
            int r2 = 0;
        L4:
            if ((r1 instanceof Object[]) == false) goto L6;
            r2 = r2 + 1;
            r1 = r1[0];
            goto L4
        L6:
            this.dimensionSize = new int[r2];
            int r3 = 0;
        L8:
            if ((r6 instanceof Object[]) == false) goto L10;
            Object[] r7 = r6;
            this.dimensionSize[r3] = r7.length;
            r6 = r7[0];
            r3 = r3 + 1;
            goto L8
        }

        public Complex get(int... r4) throws DimensionMismatchException {
            int r0 = 0;
            if (r4 != null) goto L11;
            if (this.dimensionSize.length > 0) goto L9;
            return null;
        L9:
            throw new DimensionMismatchException(0, this.dimensionSize.length);
        L11:
            if (r4.length != this.dimensionSize.length) goto L19;
            Object r1 = this.multiDimensionalComplexArray;
        L14:
            if (r0 >= this.dimensionSize.length) goto L17;
            r1 = ((Object[]) r1)[r4[r0]];
            r0 = r0 + 1;
            goto L14
        L17:
            return (Complex) r1;
        L19:
            throw new DimensionMismatchException(r4.length, this.dimensionSize.length);
        }

        public Complex set(Complex r5, int... r6) throws DimensionMismatchException {
            int r0 = 0;
            if (r6 != null) goto L11;
            if (this.dimensionSize.length > 0) goto L9;
            return null;
        L9:
            throw new DimensionMismatchException(0, this.dimensionSize.length);
        L11:
            if (r6.length != this.dimensionSize.length) goto L19;
            Object[] r1 = (Object[]) this.multiDimensionalComplexArray;
        L13:
            int[] r2 = this.dimensionSize;
            if (r0 >= (r2.length - 1)) goto L16;
            r1 = (Object[]) r1[r6[r0]];
            r0 = r0 + 1;
            goto L13
        L16:
            Complex r4 = (Complex) r1[r6[r2.length - 1]];
            r1[r6[r2.length - 1]] = r5;
            return r4;
        L19:
            throw new DimensionMismatchException(r6.length, this.dimensionSize.length);
        }

        public int[] getDimensionSizes() {
            return (int[]) this.dimensionSize.clone();
        }

        public Object getArray() {
            return this.multiDimensionalComplexArray;
        }

        public Object clone() {
            MultiDimensionalComplexMatrix r0 = new MultiDimensionalComplexMatrix(Array.newInstance(Complex.class, this.dimensionSize));
            clone(r0);
            return r0;
        }

        private void clone(MultiDimensionalComplexMatrix r10) {
            int[] r0 = new int[this.dimensionSize.length];
            int r2 = 0;
            int r4 = 1;
            int r3 = 0;
        L3:
            int[] r5 = this.dimensionSize;
            if (r3 >= r5.length) goto L6;
            r4 = r4 * r5[r3];
            r3 = r3 + 1;
            goto L3
        L6:
            int[][] r6 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r4, r5.length});
            int r7 = r6.length;
            int r8 = 0;
        L7:
            if (r8 >= r7) goto L16;
            System.arraycopy(r0, 0, r6[r8], 0, this.dimensionSize.length);
            int r9 = 0;
        L9:
            int[] r11 = this.dimensionSize;
            if (r9 >= r11.length) goto L15;
            int r12 = r0[r9] + 1;
            r0[r9] = r12;
            if (r12 < r11[r9]) goto L15;
            r0[r9] = 0;
            r9 = r9 + 1;
        L15:
            r8 = r8 + 1;
            goto L7
        L16:
            int r1 = r6.length;
        L17:
            if (r2 >= r1) goto L19;
            int[] r13 = r6[r2];
            r10.set(get(r13), r13);
            r2 = r2 + 1;
            goto L17
        }
    }

    static {
        W_SUB_N_R = new double[]{1.0d, -1.0d, 6.123233995736766E-17d, 0.7071067811865476d, 0.9238795325112867d, 0.9807852804032304d, 0.9951847266721969d, 0.9987954562051724d, 0.9996988186962042d, 0.9999247018391445d, 0.9999811752826011d, 0.9999952938095762d, 0.9999988234517019d, 0.9999997058628822d, 0.9999999264657179d, 0.9999999816164293d, 0.9999999954041073d, 0.9999999988510269d, 0.9999999997127567d, 0.9999999999281892d, 0.9999999999820472d, 0.9999999999955118d, 0.999999999998878d, 0.9999999999997194d, 0.9999999999999298d, 0.9999999999999825d, 0.9999999999999957d, 0.9999999999999989d, 0.9999999999999998d, 0.9999999999999999d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d};
        W_SUB_N_I = new double[]{2.4492935982947064E-16d, -1.2246467991473532E-16d, -1.0d, -0.7071067811865475d, -0.3826834323650898d, -0.19509032201612825d, -0.0980171403295606d, -0.049067674327418015d, -0.024541228522912288d, -0.012271538285719925d, -0.006135884649154475d, -0.003067956762965976d, -0.0015339801862847655d, -7.669903187427045E-4d, -3.8349518757139556E-4d, -1.917475973107033E-4d, -9.587379909597734E-5d, -4.793689960306688E-5d, -2.396844980841822E-5d, -1.1984224905069705E-5d, -5.9921124526424275E-6d, -2.996056226334661E-6d, -1.4980281131690111E-6d, -7.490140565847157E-7d, -3.7450702829238413E-7d, -1.8725351414619535E-7d, -9.362675707309808E-8d, -4.681337853654909E-8d, -2.340668926827455E-8d, -1.1703344634137277E-8d, -5.8516723170686385E-9d, -2.9258361585343192E-9d, -1.4629180792671596E-9d, -7.314590396335798E-10d, -3.657295198167899E-10d, -1.8286475990839495E-10d, -9.143237995419748E-11d, -4.571618997709874E-11d, -2.285809498854937E-11d, -1.1429047494274685E-11d, -5.714523747137342E-12d, -2.857261873568671E-12d, -1.4286309367843356E-12d, -7.143154683921678E-13d, -3.571577341960839E-13d, -1.7857886709804195E-13d, -8.928943354902097E-14d, -4.4644716774510487E-14d, -2.2322358387255243E-14d, -1.1161179193627622E-14d, -5.580589596813811E-15d, -2.7902947984069054E-15d, -1.3951473992034527E-15d, -6.975736996017264E-16d, -3.487868498008632E-16d, -1.743934249004316E-16d, -8.71967124502158E-17d, -4.35983562251079E-17d, -2.179917811255395E-17d, -1.0899589056276974E-17d, -5.449794528138487E-18d, -2.7248972640692436E-18d, -1.3624486320346218E-18d};
    }

    public FastFourierTransformer(DftNormalization r1) {
        this.normalization = r1;
    }

    private static void bitReversalShuffle2(double[] r8, double[] r9) {
        int r0 = r8.length;
        int r1 = r0 >> 1;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L11;
        if (r2 >= r3) goto L6;
        double r4 = r8[r2];
        r8[r2] = r8[r3];
        r8[r3] = r4;
        double r5 = r9[r2];
        r9[r2] = r9[r3];
        r9[r3] = r5;
    L6:
        int r6 = r1;
    L7:
        if (r6 > r3) goto L10;
        if (r6 <= 0) goto L10;
        r3 = r3 - r6;
        r6 = r6 >> 1;
    L10:
        r3 = r3 + r6;
        r2 = r2 + 1;
        goto L3
    }

    private static void normalizeTransformedData(double[][] r6, DftNormalization r7, TransformType r8) {
        int r0 = 0;
        double[] r1 = r6[0];
        double[] r9 = r6[1];
        int r3 = r1.length;
        int r10 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$transform$DftNormalization[r7.ordinal()];
        if (r10 == 1) goto L12;
        if (r10 != 2) goto L10;
        double r4 = 1.0d / FastMath.sqrt(r3);
    L7:
        if (r0 >= r3) goto L19;
        r1[r0] = r1[r0] * r4;
        r9[r0] = r9[r0] * r4;
        r0 = r0 + 1;
        goto L7
    L19:
        return;
    L10:
        throw new MathIllegalStateException();
    L12:
        if (r8 != TransformType.INVERSE) goto L16;
        double r5 = 1.0d / ((double) r3);
    L14:
        if (r0 >= r3) goto L20;
        r1[r0] = r1[r0] * r5;
        r9[r0] = r9[r0] * r5;
        r0 = r0 + 1;
        goto L14
    L20:
        return;
    }

    public static void transformInPlace(double[][] r37, DftNormalization r38, TransformType r39) {
        int r3 = 2;
        if (r37.length != 2) goto L40;
        int r2 = 0;
        double[] r4 = r37[0];
        double[] r6 = r37[1];
        if (r4.length != r6.length) goto L38;
        int r7 = r4.length;
        if (ArithmeticUtils.isPowerOfTwo(r7) == false) goto L36;
        if (r7 != 1) goto L10;
        return;
    L10:
        if (r7 != 2) goto L13;
        double r8 = r4[0];
        double r9 = r6[0];
        double r11 = r4[1];
        double r13 = r6[1];
        r4[0] = r8 + r11;
        r6[0] = r9 + r13;
        r4[1] = r8 - r11;
        r6[1] = r9 - r13;
        normalizeTransformedData(r37, r38, r39);
        return;
    L13:
        bitReversalShuffle2(r4, r6);
        if (r39 != TransformType.INVERSE) goto L18;
        int r10 = 0;
    L16:
        if (r10 >= r7) goto L21;
        int r12 = r10 + 1;
        int r14 = r10 + 2;
        int r15 = r10 + 3;
        double r16 = r4[r10];
        double r17 = r6[r10];
        double r18 = r4[r14];
        double r19 = r6[r14];
        double r20 = r4[r12];
        double r22 = r6[r12];
        double r24 = r4[r15];
        double r26 = r6[r15];
        r4[r10] = ((r16 + r18) + r20) + r24;
        r6[r10] = ((r17 + r19) + r22) + r26;
        double r28 = r16 - r20;
        r4[r12] = r28 + (r26 - r19);
        double r30 = r17 - r22;
        r6[r12] = r30 + (r18 - r24);
        r4[r14] = ((r16 - r18) + r20) - r24;
        r6[r14] = ((r17 - r19) + r22) - r26;
        r4[r15] = r28 + (r19 - r26);
        r6[r15] = r30 + (r24 - r18);
        r10 = r10 + 4;
    L21:
        int r21 = 4;
    L22:
        if (r21 >= r7) goto L33;
        int r23 = r21 << 1;
        r3 = r3 + 1;
        double r110 = W_SUB_N_R[r3];
        double r111 = W_SUB_N_I[r3];
        if (r39 != TransformType.INVERSE) goto L26;
        r111 = -r111;
    L26:
        int r112 = r2;
    L27:
        if (r112 >= r7) goto L32;
        int r113 = r112 + r21;
        double r114 = 1.0d;
        double r115 = 0.0d;
    L29:
        if (r2 >= r21) goto L31;
        int r25 = r112 + r2;
        double r27 = r4[r25];
        double r29 = r6[r25];
        int r210 = r113 + r2;
        double r211 = r4[r210];
        double r212 = r6[r210];
        double r31 = r114 * r211;
        double r35 = r115 * r212;
        r4[r25] = (r27 + r31) - r35;
        double r213 = r212 * r114;
        double r214 = r211 * r115;
        r6[r25] = (r29 + r213) + r214;
        r4[r210] = r27 - (r31 - r35);
        r6[r210] = r29 - (r213 + r214);
        double r215 = (r114 * r110) - (r115 * r111);
        r115 = (r114 * r111) + (r115 * r110);
        r2 = r2 + 1;
        r114 = r215;
        goto L29
    L31:
        r112 = r112 + r23;
        r2 = 0;
        goto L27
    L32:
        r21 = r23;
        goto L22
    L33:
        normalizeTransformedData(r37, r38, r39);
        return;
    L18:
        int r32 = 0;
    L19:
        if (r32 >= r7) goto L21;
        int r33 = r32 + 1;
        int r116 = r32 + 2;
        int r117 = r32 + 3;
        double r118 = r4[r32];
        double r119 = r6[r32];
        double r120 = r4[r116];
        double r121 = r6[r116];
        double r216 = r4[r33];
        double r217 = r6[r33];
        double r218 = r4[r117];
        double r219 = r6[r117];
        r4[r32] = ((r118 + r120) + r216) + r218;
        r6[r32] = ((r119 + r121) + r217) + r219;
        double r220 = r118 - r216;
        r4[r33] = r220 + (r121 - r219);
        double r34 = r119 - r217;
        r6[r33] = r34 + (r218 - r120);
        r4[r116] = ((r118 - r120) + r216) - r218;
        r6[r116] = ((r119 - r121) + r217) - r219;
        r4[r117] = r220 + (r219 - r121);
        r6[r117] = r34 + (r120 - r218);
        r32 = r32 + 4;
        goto L19
    L36:
        throw new MathIllegalArgumentException(LocalizedFormats.NOT_POWER_OF_TWO_CONSIDER_PADDING, new Object[]{Integer.valueOf(r7)});
    L38:
        throw new DimensionMismatchException(r6.length, r4.length);
    L40:
        throw new DimensionMismatchException(r37.length, 2);
    }

    public Complex[] transform(double[] r4, TransformType r5) {
        double[][] r0 = {MathArrays.copyOf(r4, r4.length), new double[r4.length]};
        transformInPlace(r0, this.normalization, r5);
        return TransformUtils.createComplexArray(r0);
    }

    public Complex[] transform(UnivariateFunction r1, double r2, double r4, int r6, TransformType r7) {
        return transform(FunctionUtils.sample(r1, r2, r4, r6), r7);
    }

    public Complex[] transform(Complex[] r1, TransformType r2) {
        double[][] r3 = TransformUtils.createRealImaginaryArray(r1);
        transformInPlace(r3, this.normalization, r2);
        return TransformUtils.createComplexArray(r3);
    }

    @Deprecated
    public Object mdfft(Object r5, TransformType r6) {
        MultiDimensionalComplexMatrix r7 = (MultiDimensionalComplexMatrix) new MultiDimensionalComplexMatrix(r5).clone();
        int[] r0 = r7.getDimensionSizes();
        int r2 = 0;
    L4:
        if (r2 >= r0.length) goto L7;
        mdfft(r7, r6, r2, new int[0]);
        r2 = r2 + 1;
        goto L4
    L7:
        return r7.getArray();
    }

    @Deprecated
    private void mdfft(MultiDimensionalComplexMatrix r6, TransformType r7, int r8, int[] r9) {
        int[] r0 = r6.getDimensionSizes();
        int r3 = 0;
        if (r9.length != r0.length) goto L12;
        Complex[] r1 = new Complex[r0[r8]];
        int r2 = 0;
    L6:
        if (r2 >= r0[r8]) goto L8;
        r9[r8] = r2;
        r1[r2] = r6.get(r9);
        r2 = r2 + 1;
        goto L6
    L8:
        Complex[] r5 = transform(r1, r7);
    L10:
        if (r3 >= r0[r8]) goto L22;
        r9[r8] = r3;
        r6.set(r5[r3], r9);
        r3 = r3 + 1;
        goto L10
    L22:
        return;
    L12:
        int[] r4 = new int[r9.length + 1];
        System.arraycopy(r9, 0, r4, 0, r9.length);
        if (r9.length != r8) goto L16;
        r4[r8] = 0;
        mdfft(r6, r7, r8, r4);
        return;
    L16:
        if (r3 >= r0[r9.length]) goto L23;
        r4[r9.length] = r3;
        mdfft(r6, r7, r8, r4);
        r3 = r3 + 1;
        goto L16
    }
}
