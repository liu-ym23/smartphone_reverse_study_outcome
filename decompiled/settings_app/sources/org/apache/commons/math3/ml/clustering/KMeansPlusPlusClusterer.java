package org.apache.commons.math3.ml.clustering;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.ml.clustering.Clusterable;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.ml.distance.EuclideanDistance;
import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class KMeansPlusPlusClusterer<T extends Clusterable> extends Clusterer<T> {
    private final EmptyClusterStrategy emptyStrategy;
    private final int k;
    private final int maxIterations;
    private final RandomGenerator random;

    /* JADX INFO: renamed from: org.apache.commons.math3.ml.clustering.KMeansPlusPlusClusterer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$ml$clustering$KMeansPlusPlusClusterer$EmptyClusterStrategy = null;

        static {
            int[] r0 = new int[EmptyClusterStrategy.values().length];
            $SwitchMap$org$apache$commons$math3$ml$clustering$KMeansPlusPlusClusterer$EmptyClusterStrategy = r0;
            r0[EmptyClusterStrategy.LARGEST_VARIANCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$org$apache$commons$math3$ml$clustering$KMeansPlusPlusClusterer$EmptyClusterStrategy[EmptyClusterStrategy.LARGEST_POINTS_NUMBER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$apache$commons$math3$ml$clustering$KMeansPlusPlusClusterer$EmptyClusterStrategy[EmptyClusterStrategy.FARTHEST_POINT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final enum EmptyClusterStrategy extends Enum<EmptyClusterStrategy> {
        private static final /* synthetic */ EmptyClusterStrategy[] $VALUES = null;
        public static final EmptyClusterStrategy ERROR = null;
        public static final EmptyClusterStrategy FARTHEST_POINT = null;
        public static final EmptyClusterStrategy LARGEST_POINTS_NUMBER = null;
        public static final EmptyClusterStrategy LARGEST_VARIANCE = null;

        private EmptyClusterStrategy(String r1, int r2) {
            super(r1, r2);
        }

        public static EmptyClusterStrategy valueOf(String r1) {
            return (EmptyClusterStrategy) Enum.valueOf(EmptyClusterStrategy.class, r1);
        }

        public static EmptyClusterStrategy[] values() {
            return (EmptyClusterStrategy[]) $VALUES.clone();
        }

        static {
            EmptyClusterStrategy r0 = new EmptyClusterStrategy("LARGEST_VARIANCE", 0);
            LARGEST_VARIANCE = r0;
            EmptyClusterStrategy r1 = new EmptyClusterStrategy("LARGEST_POINTS_NUMBER", 1);
            LARGEST_POINTS_NUMBER = r1;
            EmptyClusterStrategy r3 = new EmptyClusterStrategy("FARTHEST_POINT", 2);
            FARTHEST_POINT = r3;
            EmptyClusterStrategy r5 = new EmptyClusterStrategy("ERROR", 3);
            ERROR = r5;
            $VALUES = new EmptyClusterStrategy[]{r0, r1, r3, r5};
        }
    }

    public KMeansPlusPlusClusterer(int r2) {
        this(r2, -1);
    }

    public KMeansPlusPlusClusterer(int r2, int r3) {
        this(r2, r3, new EuclideanDistance());
    }

    public KMeansPlusPlusClusterer(int r2, int r3, DistanceMeasure r4) {
        this(r2, r3, r4, new JDKRandomGenerator());
    }

    public KMeansPlusPlusClusterer(int r7, int r8, DistanceMeasure r9, RandomGenerator r10) {
        this(r7, r8, r9, r10, EmptyClusterStrategy.LARGEST_VARIANCE);
    }

    public KMeansPlusPlusClusterer(int r1, int r2, DistanceMeasure r3, RandomGenerator r4, EmptyClusterStrategy r5) {
        super(r3);
        this.k = r1;
        this.maxIterations = r2;
        this.random = r4;
        this.emptyStrategy = r5;
    }

    public int getK() {
        return this.k;
    }

    public int getMaxIterations() {
        return this.maxIterations;
    }

    public RandomGenerator getRandomGenerator() {
        return this.random;
    }

    public EmptyClusterStrategy getEmptyClusterStrategy() {
        return this.emptyStrategy;
    }

    @Override // org.apache.commons.math3.ml.clustering.Clusterer
    public List<CentroidCluster<T>> cluster(Collection<T> r12) throws MathIllegalArgumentException, ConvergenceException {
        MathUtils.checkNotNull(r12);
        if (r12.size() < this.k) goto L34;
        List<CentroidCluster<T>> r0 = chooseInitialCenters(r12);
        int[] r1 = new int[r12.size()];
        assignPointsToClusters(r0, r12, r1);
        int r3 = this.maxIterations;
        if (r3 >= 0) goto L7;
        r3 = Integer.MAX_VALUE;
    L7:
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L32;
        ArrayList r5 = new ArrayList();
        Iterator<CentroidCluster<T>> r6 = r0.iterator();
        boolean r7 = false;
    L11:
        if (r6.hasNext() == false) goto L28;
        CentroidCluster<T> r8 = r6.next();
        if (r8.getPoints().isEmpty() == false) goto L25;
        int r9 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$ml$clustering$KMeansPlusPlusClusterer$EmptyClusterStrategy[this.emptyStrategy.ordinal()];
        boolean r10 = true;
        if (r9 != 1) goto L17;
        Clusterable r11 = getPointFromLargestVarianceCluster(r0);
    L26:
        r5.add(new CentroidCluster(r11));
        r7 = r10;
        goto L11
    L17:
        if (r9 != 2) goto L19;
        r11 = getPointFromLargestNumberCluster(r0);
        goto L26
    L19:
        if (r9 != 3) goto L22;
        r11 = getFarthestPoint(r0);
        goto L26
    L22:
        throw new ConvergenceException(LocalizedFormats.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
    L25:
        Clusterable r13 = centroidOf(r8.getPoints(), r8.getCenter().getPoint().length);
        r10 = r7;
        r11 = r13;
        goto L26
    L28:
        if (assignPointsToClusters(r5, r12, r1) != 0) goto L31;
        if (r7 == true) goto L31;
        return r5;
    L31:
        r4 = r4 + 1;
        r0 = r5;
        goto L8
    L32:
        return r0;
    L34:
        throw new NumberIsTooSmallException(Integer.valueOf(r12.size()), Integer.valueOf(this.k), false);
    }

    private int assignPointsToClusters(List<CentroidCluster<T>> r6, Collection<T> r7, int[] r8) {
        Iterator<T> r9 = r7.iterator();
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r9.hasNext() == false) goto L9;
        T r2 = r9.next();
        int r3 = getNearestCluster(r6, r2);
        if (r3 == r8[r1]) goto L8;
        r0 = r0 + 1;
    L8:
        r6.get(r3).addPoint(r2);
        r8[r1] = r3;
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    private List<CentroidCluster<T>> chooseInitialCenters(Collection<T> r18) {
        List r1 = Collections.unmodifiableList(new ArrayList(r18));
        int r2 = r1.size();
        boolean[] r3 = new boolean[r2];
        ArrayList r4 = new ArrayList();
        int r5 = this.random.nextInt(r2);
        Clusterable r6 = (Clusterable) r1.get(r5);
        r4.add(new CentroidCluster(r6));
        r3[r5] = true;
        double[] r8 = new double[r2];
        int r10 = 0;
    L3:
        if (r10 >= r2) goto L8;
        if (r10 == r5) goto L6;
        double r11 = distance(r6, (Clusterable) r1.get(r10));
        r8[r10] = r11 * r11;
    L6:
        r10 = r10 + 1;
    L8:
        if (r4.size() >= this.k) goto L43;
        double r7 = 0.0d;
        double r12 = 0.0d;
        int r13 = 0;
    L10:
        if (r13 >= r2) goto L15;
        if (r3[r13] == true) goto L14;
        r12 = r12 + r8[r13];
    L14:
        r13 = r13 + 1;
        goto L10
    L15:
        double r14 = this.random.nextDouble() * r12;
        int r15 = 0;
    L17:
        if (r15 >= r2) goto L24;
        if (r3[r15] == true) goto L23;
        r7 = r7 + r8[r15];
        if (r7 < r14) goto L23;
    L25:
        if (r15 != (-1)) goto L32;
        int r9 = r2 - 1;
    L27:
        if (r9 < 0) goto L32;
        if (r3[r9] == false) goto L30;
        r9 = r9 - 1;
        goto L27
    L30:
        r15 = r9;
    L32:
        if (r15 < 0) goto L43;
        Clusterable r16 = (Clusterable) r1.get(r15);
        r4.add(new CentroidCluster(r16));
        r3[r15] = true;
        if (r4.size() >= this.k) goto L8;
        int r17 = 0;
    L36:
        if (r17 >= r2) goto L8;
        if (r3[r17] == true) goto L42;
        double r19 = distance(r16, (Clusterable) r1.get(r17));
        double r110 = r19 * r19;
        if (r110 >= r8[r17]) goto L42;
        r8[r17] = r110;
    L42:
        r17 = r17 + 1;
    L23:
        r15 = r15 + 1;
        goto L17
    L24:
        r15 = -1;
    L43:
        return r4;
    }

    private T getPointFromLargestVarianceCluster(Collection<CentroidCluster<T>> r10) throws ConvergenceException {
        Iterator<CentroidCluster<T>> r11 = r10.iterator();
        double r0 = Double.NEGATIVE_INFINITY;
        CentroidCluster<T> r2 = null;
    L4:
        if (r11.hasNext() == false) goto L14;
        CentroidCluster<T> r3 = r11.next();
        if (r3.getPoints().isEmpty() == true) goto L4;
        Clusterable r4 = r3.getCenter();
        Variance r5 = new Variance();
        Iterator<T> r6 = r3.getPoints().iterator();
    L9:
        if (r6.hasNext() == false) goto L11;
        r5.increment(distance(r6.next(), r4));
        goto L9
    L11:
        double r7 = r5.getResult();
        if (r7 <= r0) goto L4;
        r2 = r3;
        r0 = r7;
        goto L4
    L14:
        if (r2 == null) goto L18;
        List<T> r12 = r2.getPoints();
        return r12.remove(this.random.nextInt(r12.size()));
    L18:
        throw new ConvergenceException(LocalizedFormats.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
    }

    private T getPointFromLargestNumberCluster(Collection<? extends Cluster<T>> r6) throws ConvergenceException {
        Iterator<? extends Cluster<T>> r7 = r6.iterator();
        Cluster<T> r1 = null;
        int r2 = 0;
    L4:
        if (r7.hasNext() == false) goto L8;
        Cluster<T> r3 = r7.next();
        int r4 = r3.getPoints().size();
        if (r4 <= r2) goto L4;
        r1 = r3;
        r2 = r4;
        goto L4
    L8:
        if (r1 == null) goto L12;
        List<T> r8 = r1.getPoints();
        return r8.remove(this.random.nextInt(r8.size()));
    L12:
        throw new ConvergenceException(LocalizedFormats.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
    }

    private T getFarthestPoint(Collection<CentroidCluster<T>> r12) throws ConvergenceException {
        Iterator<CentroidCluster<T>> r13 = r12.iterator();
        double r0 = Double.NEGATIVE_INFINITY;
        CentroidCluster<T> r2 = null;
        int r3 = -1;
    L3:
        int r5 = 0;
        if (r13.hasNext() == false) goto L12;
        CentroidCluster<T> r4 = r13.next();
        Clusterable r6 = r4.getCenter();
        List<T> r7 = r4.getPoints();
    L7:
        if (r5 >= r7.size()) goto L3;
        double r8 = distance(r7.get(r5), r6);
        if (r8 <= r0) goto L11;
        r2 = r4;
        r3 = r5;
        r0 = r8;
    L11:
        r5 = r5 + 1;
        goto L7
    L12:
        if (r2 == null) goto L16;
        return r2.getPoints().remove(r3);
    L16:
        throw new ConvergenceException(LocalizedFormats.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
    }

    private int getNearestCluster(Collection<CentroidCluster<T>> r8, T r9) {
        Iterator<CentroidCluster<T>> r10 = r8.iterator();
        double r0 = Double.MAX_VALUE;
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r10.hasNext() == false) goto L9;
        double r4 = distance(r9, r10.next().getCenter());
        if (r4 >= r0) goto L8;
        r2 = r3;
        r0 = r4;
    L8:
        r3 = r3 + 1;
        goto L4
    L9:
        return r2;
    }

    private Clusterable centroidOf(Collection<T> r8, int r9) {
        double[] r7 = new double[r9];
        Iterator<T> r0 = r8.iterator();
    L3:
        int r2 = 0;
        if (r0.hasNext() == false) goto L8;
        double[] r1 = r0.next().getPoint();
    L6:
        if (r2 >= r9) goto L3;
        r7[r2] = r7[r2] + r1[r2];
        r2 = r2 + 1;
    L8:
        if (r2 >= r9) goto L11;
        r7[r2] = r7[r2] / ((double) r8.size());
        r2 = r2 + 1;
        goto L8
    L11:
        return new DoublePoint(r7);
    }
}
