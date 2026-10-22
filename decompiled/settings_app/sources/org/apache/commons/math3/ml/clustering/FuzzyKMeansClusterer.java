package org.apache.commons.math3.ml.clustering;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.ml.clustering.Clusterable;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.ml.distance.EuclideanDistance;
import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class FuzzyKMeansClusterer<T extends Clusterable> extends Clusterer<T> {
    private static final double DEFAULT_EPSILON = 0.001d;
    private List<CentroidCluster<T>> clusters;
    private final double epsilon;
    private final double fuzziness;
    private final int k;
    private final int maxIterations;
    private double[][] membershipMatrix;
    private List<T> points;
    private final RandomGenerator random;

    public FuzzyKMeansClusterer(int r7, double r8) throws NumberIsTooSmallException {
        this(r7, r8, -1, new EuclideanDistance());
    }

    public FuzzyKMeansClusterer(int r10, double r11, int r13, DistanceMeasure r14) throws NumberIsTooSmallException {
        this(r10, r11, r13, r14, DEFAULT_EPSILON, new JDKRandomGenerator());
    }

    public FuzzyKMeansClusterer(int r3, double r4, int r6, DistanceMeasure r7, double r8, RandomGenerator r10) throws NumberIsTooSmallException {
        super(r7);
        if (r4 <= 1.0d) goto L7;
        this.k = r3;
        this.fuzziness = r4;
        this.maxIterations = r6;
        this.epsilon = r8;
        this.random = r10;
        double[][] r5 = (double[][]) null;
        this.membershipMatrix = null;
        this.points = null;
        this.clusters = null;
        return;
    L7:
        throw new NumberIsTooSmallException(Double.valueOf(r4), Double.valueOf(1.0d), false);
    }

    public int getK() {
        return this.k;
    }

    public double getFuzziness() {
        return this.fuzziness;
    }

    public int getMaxIterations() {
        return this.maxIterations;
    }

    public double getEpsilon() {
        return this.epsilon;
    }

    public RandomGenerator getRandomGenerator() {
        return this.random;
    }

    public RealMatrix getMembershipMatrix() {
        double[][] r0 = this.membershipMatrix;
        if (r0 == null) goto L7;
        return MatrixUtils.createRealMatrix(r0);
    L7:
        throw new MathIllegalStateException();
    }

    public List<T> getDataPoints() {
        return this.points;
    }

    public List<CentroidCluster<T>> getClusters() {
        return this.clusters;
    }

    public double getObjectiveFunctionValue() {
        List<T> r0 = this.points;
        if (r0 == null) goto L16;
        if (this.clusters == null) goto L16;
        Iterator<T> r1 = r0.iterator();
        double r2 = 0.0d;
        int r4 = 0;
    L8:
        if (r1.hasNext() == false) goto L14;
        T r5 = r1.next();
        Iterator<CentroidCluster<T>> r6 = this.clusters.iterator();
        int r7 = 0;
    L11:
        if (r6.hasNext() == false) goto L13;
        double r8 = distance(r5, r6.next().getCenter());
        r2 = r2 + ((r8 * r8) * FastMath.pow(this.membershipMatrix[r4][r7], this.fuzziness));
        r7 = r7 + 1;
        goto L11
    L13:
        r4 = r4 + 1;
        goto L8
    L14:
        return r2;
    L16:
        throw new MathIllegalStateException();
    }

    @Override // org.apache.commons.math3.ml.clustering.Clusterer
    public List<CentroidCluster<T>> cluster(Collection<T> r10) throws MathIllegalArgumentException {
        MathUtils.checkNotNull(r10);
        int r0 = r10.size();
        int r2 = 0;
        if (r0 < this.k) goto L22;
        this.points = Collections.unmodifiableList(new ArrayList(r10));
        this.clusters = new ArrayList();
        this.membershipMatrix = (double[][]) Array.newInstance(Double.TYPE, new int[]{r0, this.k});
        double[][] r11 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r0, this.k});
        if (r0 == 0) goto L7;
        initializeMembershipMatrix();
        int r1 = this.points.get(0).getPoint().length;
        int r3 = 0;
    L10:
        if (r3 >= this.k) goto L12;
        this.clusters.add(new CentroidCluster(new DoublePoint(new double[r1])));
        r3 = r3 + 1;
        goto L10
    L12:
        int r4 = this.maxIterations;
        if (r4 >= 0) goto L15;
        r4 = Integer.MAX_VALUE;
    L15:
        saveMembershipMatrix(r11);
        updateClusterCenters();
        updateMembershipMatrix();
        if (calculateMaxMembershipChange(r11) <= this.epsilon) goto L20;
        r2 = r2 + 1;
        if (r2 < r4) goto L15;
    L20:
        return this.clusters;
    L7:
        return this.clusters;
    L22:
        throw new NumberIsTooSmallException(Integer.valueOf(r0), Integer.valueOf(this.k), false);
    }

    private void updateClusterCenters() {
        ArrayList r1 = new ArrayList(this.k);
        Iterator<CentroidCluster<T>> r2 = this.clusters.iterator();
        int r4 = 0;
    L4:
        if (r2.hasNext() == false) goto L13;
        int r5 = r2.next().getCenter().getPoint().length;
        double[] r6 = new double[r5];
        Iterator<T> r7 = this.points.iterator();
        double r8 = 0.0d;
        int r10 = 0;
    L7:
        if (r7.hasNext() == false) goto L12;
        T r11 = r7.next();
        double r12 = FastMath.pow(this.membershipMatrix[r10][r4], this.fuzziness);
        double[] r13 = r11.getPoint();
        int r14 = 0;
    L9:
        if (r14 >= r5) goto L11;
        r6[r14] = r6[r14] + (r13[r14] * r12);
        r14 = r14 + 1;
        goto L9
    L11:
        r8 = r8 + r12;
        r10 = r10 + 1;
        goto L7
    L12:
        MathArrays.scaleInPlace(1.0d / r8, r6);
        r1.add(new CentroidCluster(new DoublePoint(r6)));
        r4 = r4 + 1;
        goto L4
    L13:
        this.clusters.clear();
        this.clusters = r1;
    }

    private void updateMembershipMatrix() {
        int r2 = 0;
    L4:
        if (r2 >= this.points.size()) goto L31;
        T r3 = this.points.get(r2);
        double r4 = Double.MIN_VALUE;
        int r6 = -1;
        int r7 = 0;
    L7:
        if (r7 >= this.clusters.size()) goto L30;
        double r8 = FastMath.abs(distance(r3, this.clusters.get(r7).getCenter()));
        double r10 = 0.0d;
        if (r8 == 0.0d) goto L18;
        Iterator<CentroidCluster<T>> r12 = this.clusters.iterator();
        double r17 = 0.0d;
    L12:
        if (r12.hasNext() == false) goto L17;
        double r20 = FastMath.abs(distance(r3, r12.next().getCenter()));
        if (r20 == r10) goto L15;
        r17 = r17 + FastMath.pow(r8 / r20, 2.0d / (this.fuzziness - 1.0d));
        r10 = 0.0d;
        goto L12
    L15:
        double r9 = r10;
        r17 = Double.POSITIVE_INFINITY;
    L20:
        if (r17 != r9) goto L23;
        double r11 = 1.0d;
    L26:
        this.membershipMatrix[r2][r7] = r11;
        if (r11 <= r4) goto L29;
        r6 = r7;
        r4 = r11;
    L29:
        r7 = r7 + 1;
        goto L7
    L23:
        if (r17 != Double.POSITIVE_INFINITY) goto L25;
        r11 = r9;
        goto L26
    L25:
        r11 = 1.0d / r17;
        goto L26
    L17:
        r9 = r10;
        goto L20
    L18:
        r9 = 0.0d;
        r17 = 0.0d;
        goto L20
    L30:
        this.clusters.get(r6).addPoint(r3);
        r2 = r2 + 1;
        goto L4
    }

    private void initializeMembershipMatrix() {
        int r1 = 0;
    L4:
        if (r1 >= this.points.size()) goto L10;
        int r2 = 0;
    L7:
        if (r2 >= this.k) goto L9;
        this.membershipMatrix[r1][r2] = this.random.nextDouble();
        r2 = r2 + 1;
        goto L7
    L9:
        double[][] r3 = this.membershipMatrix;
        r3[r1] = MathArrays.normalizeArray(r3[r1], 1.0d);
        r1 = r1 + 1;
        goto L4
    }

    private double calculateMaxMembershipChange(double[][] r10) {
        double r0 = 0.0d;
        int r3 = 0;
    L4:
        if (r3 >= this.points.size()) goto L10;
        int r4 = 0;
    L7:
        if (r4 >= this.clusters.size()) goto L9;
        r0 = FastMath.max(FastMath.abs(this.membershipMatrix[r3][r4] - r10[r3][r4]), r0);
        r4 = r4 + 1;
        goto L7
    L9:
        r3 = r3 + 1;
        goto L4
    L10:
        return r0;
    }

    private void saveMembershipMatrix(double[][] r6) {
        int r1 = 0;
    L4:
        if (r1 >= this.points.size()) goto L6;
        System.arraycopy(this.membershipMatrix[r1], 0, r6[r1], 0, this.clusters.size());
        r1 = r1 + 1;
        goto L4
    }
}
