package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Quantiles {

    /* JADX INFO: renamed from: com.google.common.math.Quantiles$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Scale {
        private final int scale;

        /* synthetic */ Scale(int r1, AnonymousClass1 r2) {
            this(r1);
        }

        private Scale(int r3) {
            if (r3 <= 0) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0, "Quantile scale must be positive");
            this.scale = r3;
            return;
        L5:
            r0 = false;
            goto L6
        }

        public ScaleAndIndex index(int r3) {
            return new ScaleAndIndex(this.scale, r3, null);
        }

        public ScaleAndIndexes indexes(int... r3) {
            return new ScaleAndIndexes(this.scale, (int[]) r3.clone(), null);
        }

        public ScaleAndIndexes indexes(Collection<Integer> r3) {
            return new ScaleAndIndexes(this.scale, Ints.toArray(r3), null);
        }
    }

    public static final class ScaleAndIndex {
        private final int index;
        private final int scale;

        /* synthetic */ ScaleAndIndex(int r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private ScaleAndIndex(int r1, int r2) {
            Quantiles.access$300(r2, r1);
            this.scale = r1;
            this.index = r2;
        }

        public double compute(Collection<? extends Number> r1) {
            return computeInPlace(Doubles.toArray(r1));
        }

        public double compute(double... r1) {
            return computeInPlace((double[]) r1.clone());
        }

        public double compute(long... r1) {
            return computeInPlace(Quantiles.access$400(r1));
        }

        public double compute(int... r1) {
            return computeInPlace(Quantiles.access$500(r1));
        }

        public double computeInPlace(double... r14) {
            if (r14.length <= 0) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.access$600(r14) == false) goto L10;
            return Double.NaN;
        L10:
            long r3 = ((long) this.index) * ((long) (r14.length - 1));
            int r1 = (int) LongMath.divide(r3, this.scale, RoundingMode.DOWN);
            int r4 = (int) (r3 - (((long) r1) * ((long) this.scale)));
            Quantiles.access$700(r1, r14, 0, r14.length - 1);
            if (r4 == 0) goto L13;
            int r2 = r1 + 1;
            Quantiles.access$700(r2, r14, r2, r14.length - 1);
            return Quantiles.access$800(r14[r1], r14[r2], r4, this.scale);
        L13:
            return r14[r1];
        L5:
            r0 = false;
            goto L6
        }
    }

    public static final class ScaleAndIndexes {
        private final int[] indexes;
        private final int scale;

        /* synthetic */ ScaleAndIndexes(int r1, int[] r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private ScaleAndIndexes(int r5, int[] r6) {
            int r0 = r6.length;
            boolean r1 = false;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L6;
            Quantiles.access$300(r6[r2], r5);
            r2 = r2 + 1;
            goto L3
        L6:
            if (r6.length <= 0) goto L8;
            r1 = true;
        L8:
            Preconditions.checkArgument(r1, "Indexes must be a non empty array");
            this.scale = r5;
            this.indexes = r6;
        }

        public Map<Integer, Double> compute(Collection<? extends Number> r1) {
            return computeInPlace(Doubles.toArray(r1));
        }

        public Map<Integer, Double> compute(double... r1) {
            return computeInPlace((double[]) r1.clone());
        }

        public Map<Integer, Double> compute(long... r1) {
            return computeInPlace(Quantiles.access$400(r1));
        }

        public Map<Integer, Double> compute(int... r1) {
            return computeInPlace(Quantiles.access$500(r1));
        }

        public Map<Integer, Double> computeInPlace(double... r20) {
            int r8 = 0;
            if (r20.length <= 0) goto L5;
            boolean r1 = true;
        L6:
            Preconditions.checkArgument(r1, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.access$600(r20) == false) goto L13;
            LinkedHashMap r2 = new LinkedHashMap();
            int[] r0 = this.indexes;
            int r3 = r0.length;
        L9:
            if (r8 >= r3) goto L12;
            r2.put(Integer.valueOf(r0[r8]), Double.valueOf(Double.NaN));
            r8 = r8 + 1;
            goto L9
        L12:
            return Collections.unmodifiableMap(r2);
        L13:
            int[] r4 = this.indexes;
            int[] r9 = new int[r4.length];
            int[] r10 = new int[r4.length];
            int[] r5 = new int[r4.length * 2];
            int r6 = 0;
            int r7 = 0;
        L14:
            int[] r11 = this.indexes;
            if (r6 >= r11.length) goto L20;
            long r12 = ((long) r11[r6]) * ((long) (r20.length - 1));
            int r13 = (int) LongMath.divide(r12, this.scale, RoundingMode.DOWN);
            int r14 = (int) (r12 - (((long) r13) * ((long) this.scale)));
            r9[r6] = r13;
            r10[r6] = r14;
            r5[r7] = r13;
            r7 = r7 + 1;
            if (r14 == 0) goto L19;
            r5[r7] = r13 + 1;
            r7 = r7 + 1;
        L19:
            r6 = r6 + 1;
            goto L14
        L20:
            Arrays.sort(r5, 0, r7);
            Quantiles.access$900(r5, 0, r7 - 1, r20, 0, r20.length - 1);
            LinkedHashMap r15 = new LinkedHashMap();
        L21:
            int[] r16 = this.indexes;
            if (r8 >= r16.length) goto L29;
            int r17 = r9[r8];
            int r18 = r10[r8];
            if (r18 != 0) goto L26;
            r15.put(Integer.valueOf(r16[r8]), Double.valueOf(r20[r17]));
        L27:
            r8 = r8 + 1;
            goto L21
        L26:
            r15.put(Integer.valueOf(r16[r8]), Double.valueOf(Quantiles.access$800(r20[r17], r20[r17 + 1], r18, this.scale)));
            goto L27
        L29:
            return Collections.unmodifiableMap(r15);
        L5:
            r1 = false;
            goto L6
        }
    }

    private static double interpolate(double r5, double r7, double r9, double r11) {
        if (r5 != Double.NEGATIVE_INFINITY) goto L10;
        if (r7 != Double.POSITIVE_INFINITY) goto L8;
        return Double.NaN;
    L8:
        return Double.NEGATIVE_INFINITY;
    L10:
        if (r7 != Double.POSITIVE_INFINITY) goto L13;
        return Double.POSITIVE_INFINITY;
    L13:
        return r5 + (((r7 - r5) * r9) / r11);
    }

    public Quantiles() {
    }

    static /* synthetic */ void access$300(int r0, int r1) {
        checkIndex(r0, r1);
    }

    static /* synthetic */ double[] access$400(long[] r0) {
        return longsToDoubles(r0);
    }

    static /* synthetic */ double[] access$500(int[] r0) {
        return intsToDoubles(r0);
    }

    static /* synthetic */ boolean access$600(double[] r0) {
        return containsNaN(r0);
    }

    static /* synthetic */ void access$700(int r0, double[] r1, int r2, int r3) {
        selectInPlace(r0, r1, r2, r3);
    }

    static /* synthetic */ double access$800(double r0, double r2, double r4, double r6) {
        return interpolate(r0, r2, r4, r6);
    }

    static /* synthetic */ void access$900(int[] r0, int r1, int r2, double[] r3, int r4, int r5) {
        selectAllInPlace(r0, r1, r2, r3, r4, r5);
    }

    public static ScaleAndIndex median() {
        return scale(2).index(1);
    }

    public static Scale quartiles() {
        return scale(4);
    }

    public static Scale percentiles() {
        return scale(100);
    }

    public static Scale scale(int r2) {
        return new Scale(r2, null);
    }

    private static boolean containsNaN(double... r5) {
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (Double.isNaN(r5[r2]) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private static void checkIndex(int r2, int r3) {
        if (r2 < 0) goto L6;
        if (r2 > r3) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(new StringBuilder(70).append("Quantile indexes must be between 0 and the scale, which is ").append(r3).toString());
    }

    private static double[] longsToDoubles(long[] r5) {
        int r0 = r5.length;
        double[] r1 = new double[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = r5[r2];
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    private static double[] intsToDoubles(int[] r5) {
        int r0 = r5.length;
        double[] r1 = new double[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = r5[r2];
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    private static void selectInPlace(int r5, double[] r6, int r7, int r8) {
        if (r5 != r7) goto L12;
        int r9 = r7 + 1;
        int r0 = r7;
    L4:
        if (r9 > r8) goto L9;
        if (r6[r0] <= r6[r9]) goto L8;
        r0 = r9;
    L8:
        r9 = r9 + 1;
        goto L4
    L9:
        if (r0 == r7) goto L27;
        swap(r6, r0, r7);
        return;
    L27:
        return;
    L12:
        if (r8 <= r7) goto L18;
        int r1 = partition(r6, r7, r8);
        if (r1 < r5) goto L16;
        r8 = r1 - 1;
    L16:
        if (r1 > r5) goto L12;
        r7 = r1 + 1;
        goto L12
    }

    private static int partition(double[] r5, int r6, int r7) {
        movePivotToStartOfSlice(r5, r6, r7);
        double r0 = r5[r6];
        int r2 = r7;
    L3:
        if (r7 <= r6) goto L8;
        if (r5[r7] <= r0) goto L7;
        swap(r5, r2, r7);
        r2 = r2 - 1;
    L7:
        r7 = r7 - 1;
        goto L3
    L8:
        swap(r5, r6, r2);
        return r2;
    }

    private static void movePivotToStartOfSlice(double[] r10, int r11, int r12) {
        boolean r1 = true;
        int r0 = (r11 + r12) >>> 1;
        double r2 = r10[r12];
        double r4 = r10[r0];
        if (r2 >= r4) goto L5;
        boolean r6 = true;
    L6:
        double r8 = r10[r11];
        if (r4 >= r8) goto L9;
        boolean r5 = true;
    L11:
        if (r2 < r8) goto L14;
        r1 = false;
    L14:
        if (r6 != r5) goto L16;
        swap(r10, r0, r11);
        return;
    L16:
        if (r6 == r1) goto L20;
        swap(r10, r11, r12);
        return;
    L20:
        return;
    L9:
        r5 = false;
        goto L11
    L5:
        r6 = false;
        goto L6
    }

    private static void selectAllInPlace(int[] r9, int r10, int r11, double[] r12, int r13, int r14) {
        int r0 = chooseNextSelection(r9, r10, r11, r13, r14);
        int r1 = r9[r0];
        selectInPlace(r1, r12, r13, r14);
        int r5 = r0 - 1;
    L3:
        if (r5 < r10) goto L7;
        if (r9[r5] != r1) goto L7;
        r5 = r5 - 1;
    L7:
        if (r5 < r10) goto L9;
        selectAllInPlace(r9, r10, r5, r12, r13, r1 - 1);
    L9:
        int r3 = r0 + 1;
    L10:
        if (r3 > r11) goto L14;
        if (r9[r3] != r1) goto L14;
        r3 = r3 + 1;
    L14:
        if (r3 > r11) goto L21;
        selectAllInPlace(r9, r3, r11, r12, r1 + 1, r14);
        return;
    }

    private static int chooseNextSelection(int[] r2, int r3, int r4, int r5, int r6) {
        if (r3 != r4) goto L4;
        return r3;
    L4:
        int r7 = r5 + r6;
        int r8 = r7 >>> 1;
    L6:
        if (r4 <= (r3 + 1)) goto L14;
        int r0 = (r3 + r4) >>> 1;
        int r1 = r2[r0];
        if (r1 > r8) goto L9;
        if (r1 >= r8) goto L12;
        r3 = r0;
        goto L6
    L12:
        return r0;
    L9:
        r4 = r0;
        goto L6
    L14:
        if (((r7 - r2[r3]) - r2[r4]) <= 0) goto L16;
        return r4;
    L16:
        return r3;
    }

    private static void swap(double[] r4, int r5, int r6) {
        double r0 = r4[r5];
        r4[r5] = r4[r6];
        r4[r6] = r0;
    }
}
