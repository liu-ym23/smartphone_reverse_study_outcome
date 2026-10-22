package org.apache.commons.math3.stat.clustering;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.clustering.Clusterable;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class KMeansPlusPlusClusterer<T extends Clusterable<T>> {
    private final EmptyClusterStrategy emptyStrategy;
    private final Random random;

    /* JADX INFO: renamed from: org.apache.commons.math3.stat.clustering.KMeansPlusPlusClusterer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$stat$clustering$KMeansPlusPlusClusterer$EmptyClusterStrategy = null;

        static {
            int[] r0 = new int[EmptyClusterStrategy.values().length];
            $SwitchMap$org$apache$commons$math3$stat$clustering$KMeansPlusPlusClusterer$EmptyClusterStrategy = r0;
            r0[EmptyClusterStrategy.LARGEST_VARIANCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$org$apache$commons$math3$stat$clustering$KMeansPlusPlusClusterer$EmptyClusterStrategy[EmptyClusterStrategy.LARGEST_POINTS_NUMBER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$apache$commons$math3$stat$clustering$KMeansPlusPlusClusterer$EmptyClusterStrategy[EmptyClusterStrategy.FARTHEST_POINT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
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

    public KMeansPlusPlusClusterer(Random r2) {
        this(r2, EmptyClusterStrategy.LARGEST_VARIANCE);
    }

    public KMeansPlusPlusClusterer(Random r1, EmptyClusterStrategy r2) {
        this.random = r1;
        this.emptyStrategy = r2;
    }

    public List<Cluster<T>> cluster(Collection<T> r18, int r19, int r20, int r21) throws MathIllegalArgumentException, ConvergenceException {
        List<Cluster<T>> r0 = null;
        double r1 = Double.POSITIVE_INFINITY;
        int r3 = 0;
    L4:
        if (r3 >= r20) goto L20;
        List<Cluster<T>> r9 = cluster(r18, r19, r21);
        Iterator<Cluster<T>> r10 = r9.iterator();
        double r11 = 0.0d;
    L7:
        if (r10.hasNext() == false) goto L17;
        Cluster<T> r13 = r10.next();
        if (r13.getPoints().isEmpty() == true) goto L7;
        Clusterable r14 = r13.getCenter();
        Variance r15 = new Variance();
        Iterator<T> r16 = r13.getPoints().iterator();
    L12:
        if (r16.hasNext() == false) goto L14;
        r15.increment(r16.next().distanceFrom(r14));
        goto L12
    L14:
        r11 = r11 + r15.getResult();
        goto L7
    L17:
        if (r11 > r1) goto L19;
        r0 = r9;
        r1 = r11;
    L19:
        r3 = r3 + 1;
        goto L4
    L20:
        return r0;
    }

    public List<Cluster<T>> cluster(Collection<T> r10, int r11, int r12) throws MathIllegalArgumentException, ConvergenceException {
        MathUtils.checkNotNull(r10);
        if (r10.size() < r11) goto L34;
        List<Cluster<T>> r13 = chooseInitialCenters(r10, r11, this.random);
        int[] r0 = new int[r10.size()];
        assignPointsToClusters(r13, r10, r0);
        if (r12 >= 0) goto L7;
        r12 = Integer.MAX_VALUE;
    L7:
        int r2 = 0;
    L8:
        if (r2 >= r12) goto L32;
        ArrayList r3 = new ArrayList();
        Iterator<Cluster<T>> r4 = r13.iterator();
        boolean r5 = false;
    L11:
        if (r4.hasNext() == false) goto L28;
        Cluster<T> r6 = r4.next();
        if (r6.getPoints().isEmpty() == false) goto L25;
        int r7 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$stat$clustering$KMeansPlusPlusClusterer$EmptyClusterStrategy[this.emptyStrategy.ordinal()];
        boolean r8 = true;
        if (r7 != 1) goto L17;
        Clusterable r9 = getPointFromLargestVarianceCluster(r13);
    L26:
        r3.add(new Cluster(r9));
        r5 = r8;
        goto L11
    L17:
        if (r7 != 2) goto L19;
        r9 = getPointFromLargestNumberCluster(r13);
        goto L26
    L19:
        if (r7 != 3) goto L22;
        r9 = getFarthestPoint(r13);
        goto L26
    L22:
        throw new ConvergenceException(LocalizedFormats.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
    L25:
        Clusterable r14 = (Clusterable) r6.getCenter().centroidOf(r6.getPoints());
        r8 = r5;
        r9 = r14;
        goto L26
    L28:
        if (assignPointsToClusters(r3, r10, r0) != 0) goto L31;
        if (r5 == true) goto L31;
        return r3;
    L31:
        r2 = r2 + 1;
        r13 = r3;
        goto L8
    L32:
        return r13;
    L34:
        throw new NumberIsTooSmallException(Integer.valueOf(r10.size()), Integer.valueOf(r11), false);
    }

    private static <T extends Clusterable<T>> int assignPointsToClusters(List<Cluster<T>> r5, Collection<T> r6, int[] r7) {
        Iterator<T> r8 = r6.iterator();
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r8.hasNext() == false) goto L9;
        T r2 = r8.next();
        int r3 = getNearestCluster(r5, r2);
        if (r3 == r7[r1]) goto L8;
        r0 = r0 + 1;
    L8:
        r5.get(r3).addPoint(r2);
        r7[r1] = r3;
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    private static <T extends Clusterable<T>> List<Cluster<T>> chooseInitialCenters(Collection<T> r18, int r19, Random r20) {
        List r1 = Collections.unmodifiableList(new ArrayList(r18));
        int r2 = r1.size();
        boolean[] r3 = new boolean[r2];
        ArrayList r4 = new ArrayList();
        int r6 = r20.nextInt(r2);
        Clusterable r7 = (Clusterable) r1.get(r6);
        r4.add(new Cluster(r7));
        r3[r6] = true;
        double[] r9 = new double[r2];
        int r11 = 0;
    L3:
        if (r11 >= r2) goto L8;
        if (r11 == r6) goto L6;
        double r12 = r7.distanceFrom(r1.get(r11));
        r9[r11] = r12 * r12;
    L6:
        r11 = r11 + 1;
    L8:
        if (r4.size() >= r19) goto L43;
        double r8 = 0.0d;
        double r13 = 0.0d;
        int r14 = 0;
    L10:
        if (r14 >= r2) goto L15;
        if (r3[r14] == true) goto L14;
        r13 = r13 + r9[r14];
    L14:
        r14 = r14 + 1;
        goto L10
    L15:
        double r15 = r20.nextDouble() * r13;
        int r16 = 0;
    L17:
        if (r16 >= r2) goto L24;
        if (r3[r16] == true) goto L23;
        r8 = r8 + r9[r16];
        if (r8 < r15) goto L23;
    L25:
        if (r16 != (-1)) goto L32;
        int r10 = r2 - 1;
    L27:
        if (r10 < 0) goto L32;
        if (r3[r10] == false) goto L30;
        r10 = r10 - 1;
        goto L27
    L30:
        r16 = r10;
    L32:
        if (r16 < 0) goto L43;
        Clusterable r17 = (Clusterable) r1.get(r16);
        r4.add(new Cluster(r17));
        r3[r16] = true;
        if (r4.size() >= r19) goto L8;
        int r21 = 0;
    L36:
        if (r21 >= r2) goto L8;
        if (r3[r21] == true) goto L42;
        double r110 = r17.distanceFrom(r1.get(r21));
        double r111 = r110 * r110;
        if (r111 >= r9[r21]) goto L42;
        r9[r21] = r111;
    L42:
        r21 = r21 + 1;
    L23:
        r16 = r16 + 1;
        goto L17
    L24:
        r16 = -1;
    L43:
        return r4;
    }

    private T getPointFromLargestVarianceCluster(Collection<Cluster<T>> r10) throws ConvergenceException {
        Iterator<Cluster<T>> r11 = r10.iterator();
        double r0 = Double.NEGATIVE_INFINITY;
        Cluster<T> r2 = null;
    L4:
        if (r11.hasNext() == false) goto L14;
        Cluster<T> r3 = r11.next();
        if (r3.getPoints().isEmpty() == true) goto L4;
        Clusterable r4 = r3.getCenter();
        Variance r5 = new Variance();
        Iterator<T> r6 = r3.getPoints().iterator();
    L9:
        if (r6.hasNext() == false) goto L11;
        r5.increment(r6.next().distanceFrom(r4));
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

    private T getPointFromLargestNumberCluster(Collection<Cluster<T>> r6) throws ConvergenceException {
        Iterator<Cluster<T>> r7 = r6.iterator();
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

    private T getFarthestPoint(Collection<Cluster<T>> r11) throws ConvergenceException {
        Iterator<Cluster<T>> r10 = r11.iterator();
        double r0 = Double.NEGATIVE_INFINITY;
        Cluster<T> r12 = null;
        int r2 = -1;
    L3:
        int r4 = 0;
        if (r10.hasNext() == false) goto L12;
        Cluster<T> r3 = r10.next();
        Clusterable r5 = r3.getCenter();
        List<T> r6 = r3.getPoints();
    L7:
        if (r4 >= r6.size()) goto L3;
        double r7 = r6.get(r4).distanceFrom(r5);
        if (r7 <= r0) goto L11;
        r12 = r3;
        r2 = r4;
        r0 = r7;
    L11:
        r4 = r4 + 1;
        goto L7
    L12:
        if (r12 == null) goto L16;
        return r12.getPoints().remove(r2);
    L16:
        throw new ConvergenceException(LocalizedFormats.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
    }

    private static <T extends Clusterable<T>> int getNearestCluster(Collection<Cluster<T>> r7, T r8) {
        Iterator<Cluster<T>> r9 = r7.iterator();
        double r0 = Double.MAX_VALUE;
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r9.hasNext() == false) goto L9;
        double r4 = r8.distanceFrom(r9.next().getCenter());
        if (r4 >= r0) goto L8;
        r2 = r3;
        r0 = r4;
    L8:
        r3 = r3 + 1;
        goto L4
    L9:
        return r2;
    }
}
