package org.apache.commons.math3.stat.ranking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NotANumberException;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class NaturalRanking implements RankingAlgorithm {
    public static final NaNStrategy DEFAULT_NAN_STRATEGY = null;
    public static final TiesStrategy DEFAULT_TIES_STRATEGY = null;
    private final NaNStrategy nanStrategy;
    private final RandomDataGenerator randomData;
    private final TiesStrategy tiesStrategy;

    /* JADX INFO: renamed from: org.apache.commons.math3.stat.ranking.NaturalRanking$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy = null;
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$stat$ranking$TiesStrategy = null;

        static {
            int[] r0 = new int[TiesStrategy.values().length];
            $SwitchMap$org$apache$commons$math3$stat$ranking$TiesStrategy = r0;
            r0[TiesStrategy.AVERAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L31:
            $SwitchMap$org$apache$commons$math3$stat$ranking$TiesStrategy[TiesStrategy.MAXIMUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L37:
            $SwitchMap$org$apache$commons$math3$stat$ranking$TiesStrategy[TiesStrategy.MINIMUM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L47:
            $SwitchMap$org$apache$commons$math3$stat$ranking$TiesStrategy[TiesStrategy.RANDOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L33:
            $SwitchMap$org$apache$commons$math3$stat$ranking$TiesStrategy[TiesStrategy.SEQUENTIAL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L12:
            int[] r5 = new int[NaNStrategy.values().length];
            $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy = r5;
            r5[NaNStrategy.MAXIMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L39:
            $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy[NaNStrategy.MINIMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L45:
            $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy[NaNStrategy.REMOVED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L29:
            $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy[NaNStrategy.FIXED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L41:
            $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy[NaNStrategy.FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
            return;
        }
    }

    private static class IntDoublePair implements Comparable<IntDoublePair> {
        private final int position;
        private final double value;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(IntDoublePair r1) {
            return compareTo2(r1);
        }

        IntDoublePair(double r1, int r3) {
            this.value = r1;
            this.position = r3;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(IntDoublePair r3) {
            return Double.compare(this.value, r3.value);
        }

        public double getValue() {
            return this.value;
        }

        public int getPosition() {
            return this.position;
        }
    }

    static {
        DEFAULT_NAN_STRATEGY = NaNStrategy.FAILED;
        DEFAULT_TIES_STRATEGY = TiesStrategy.AVERAGE;
    }

    public NaturalRanking() {
        this.tiesStrategy = DEFAULT_TIES_STRATEGY;
        this.nanStrategy = DEFAULT_NAN_STRATEGY;
        this.randomData = null;
    }

    public NaturalRanking(TiesStrategy r1) {
        this.tiesStrategy = r1;
        this.nanStrategy = DEFAULT_NAN_STRATEGY;
        this.randomData = new RandomDataGenerator();
    }

    public NaturalRanking(NaNStrategy r1) {
        this.nanStrategy = r1;
        this.tiesStrategy = DEFAULT_TIES_STRATEGY;
        this.randomData = null;
    }

    public NaturalRanking(NaNStrategy r1, TiesStrategy r2) {
        this.nanStrategy = r1;
        this.tiesStrategy = r2;
        this.randomData = new RandomDataGenerator();
    }

    public NaturalRanking(RandomGenerator r2) {
        this.tiesStrategy = TiesStrategy.RANDOM;
        this.nanStrategy = DEFAULT_NAN_STRATEGY;
        this.randomData = new RandomDataGenerator(r2);
    }

    public NaturalRanking(NaNStrategy r1, RandomGenerator r2) {
        this.nanStrategy = r1;
        this.tiesStrategy = TiesStrategy.RANDOM;
        this.randomData = new RandomDataGenerator(r2);
    }

    public NaNStrategy getNanStrategy() {
        return this.nanStrategy;
    }

    public TiesStrategy getTiesStrategy() {
        return this.tiesStrategy;
    }

    @Override // org.apache.commons.math3.stat.ranking.RankingAlgorithm
    public double[] rank(double[] r11) {
        IntDoublePair[] r0 = new IntDoublePair[r11.length];
        int r2 = 0;
    L4:
        if (r2 >= r11.length) goto L6;
        r0[r2] = new IntDoublePair(r11[r2], r2);
        r2 = r2 + 1;
        goto L4
    L6:
        int r12 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy[this.nanStrategy.ordinal()];
        List<Integer> r3 = null;
        if (r12 != 1) goto L9;
        recodeNaNs(r0, Double.POSITIVE_INFINITY);
    L27:
        Arrays.sort(r0);
        double[] r13 = new double[r0.length];
        r13[r0[0].getPosition()] = 1;
        ArrayList r4 = new ArrayList();
        r4.add(Integer.valueOf(r0[0].getPosition()));
        int r1 = 1;
        int r5 = 1;
    L29:
        if (r1 >= r0.length) goto L39;
        if (Double.compare(r0[r1].getValue(), r0[r1 - 1].getValue()) <= 0) goto L36;
        r5 = r1 + 1;
        if (r4.size() <= 1) goto L35;
        resolveTie(r13, r4);
    L35:
        r4 = new ArrayList();
        r4.add(Integer.valueOf(r0[r1].getPosition()));
    L37:
        r13[r0[r1].getPosition()] = r5;
        r1 = r1 + 1;
        goto L29
    L36:
        r4.add(Integer.valueOf(r0[r1].getPosition()));
        goto L37
    L39:
        if (r4.size() <= 1) goto L42;
        resolveTie(r13, r4);
    L42:
        if (this.nanStrategy != NaNStrategy.FIXED) goto L44;
        restoreNaNs(r13, r3);
    L44:
        return r13;
    L9:
        if (r12 != 2) goto L11;
        recodeNaNs(r0, Double.NEGATIVE_INFINITY);
        goto L27
    L11:
        if (r12 != 3) goto L13;
        r0 = removeNaNs(r0);
        goto L27
    L13:
        if (r12 != 4) goto L15;
        r3 = getNanPositions(r0);
        goto L27
    L15:
        if (r12 != 5) goto L22;
        r3 = getNanPositions(r0);
        if (r3.size() <= 0) goto L27;
        throw new NotANumberException();
    L22:
        throw new MathInternalError();
    }

    private IntDoublePair[] removeNaNs(IntDoublePair[] r9) {
        if (containsNaNs(r9) == true) goto L5;
        return r9;
    L5:
        IntDoublePair[] r8 = new IntDoublePair[r9.length];
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= r9.length) goto L16;
        if (Double.isNaN(r9[r1].getValue()) == false) goto L14;
        int r3 = r1 + 1;
    L12:
        if (r3 >= r9.length) goto L15;
        r9[r3] = new IntDoublePair(r9[r3].getValue(), r9[r3].getPosition() - 1);
        r3 = r3 + 1;
    L15:
        r1 = r1 + 1;
        goto L7
    L14:
        r8[r2] = new IntDoublePair(r9[r1].getValue(), r9[r1].getPosition());
        r2 = r2 + 1;
        goto L15
    L16:
        IntDoublePair[] r10 = new IntDoublePair[r2];
        System.arraycopy(r8, 0, r10, 0, r2);
        return r10;
    }

    private void recodeNaNs(IntDoublePair[] r3, double r4) {
        int r2 = 0;
    L4:
        if (r2 >= r3.length) goto L9;
        if (Double.isNaN(r3[r2].getValue()) == false) goto L8;
        r3[r2] = new IntDoublePair(r4, r3[r2].getPosition());
    L8:
        r2 = r2 + 1;
        goto L4
    }

    private boolean containsNaNs(IntDoublePair[] r4) {
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L10;
        if (Double.isNaN(r4[r0].getValue()) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    private void resolveTie(double[] r10, List<Integer> r11) {
        int r0 = 0;
        double r1 = r10[r11.get(0).intValue()];
        int r3 = r11.size();
        int r4 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$stat$ranking$TiesStrategy[this.tiesStrategy.ordinal()];
        if (r4 != 1) goto L5;
        fill(r10, r11, (((r1 * 2.0d) + ((double) r3)) - 1.0d) / 2.0d);
        return;
    L5:
        if (r4 != 2) goto L7;
        fill(r10, r11, (r1 + ((double) r3)) - 1.0d);
        return;
    L7:
        if (r4 != 3) goto L9;
        fill(r10, r11, r1);
        return;
    L9:
        if (r4 != 4) goto L11;
        Iterator<Integer> r12 = r11.iterator();
        long r2 = FastMath.round(r1);
    L20:
        if (r12.hasNext() == false) goto L31;
        r10[r12.next().intValue()] = this.randomData.nextLong(r2, (((long) r3) + r2) - 1);
        goto L20
    L31:
        return;
    L11:
        if (r4 != 5) goto L17;
        Iterator<Integer> r9 = r11.iterator();
        long r5 = FastMath.round(r1);
    L14:
        if (r9.hasNext() == false) goto L30;
        r10[r9.next().intValue()] = ((long) r0) + r5;
        r0 = r0 + 1;
        goto L14
    L30:
        return;
    L17:
        throw new MathInternalError();
    }

    private void fill(double[] r1, List<Integer> r2, double r3) {
        Iterator<Integer> r0 = r2.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r1[r0.next().intValue()] = r3;
        goto L4
    }

    private void restoreNaNs(double[] r3, List<Integer> r4) {
        if (r4.size() != 0) goto L5;
        return;
    L5:
        Iterator<Integer> r2 = r4.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        r3[r2.next().intValue()] = Double.NaN;
        goto L7
    }

    private List<Integer> getNanPositions(IntDoublePair[] r4) {
        ArrayList r3 = new ArrayList();
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L9;
        if (Double.isNaN(r4[r0].getValue()) == false) goto L8;
        r3.add(Integer.valueOf(r0));
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        return r3;
    }
}
