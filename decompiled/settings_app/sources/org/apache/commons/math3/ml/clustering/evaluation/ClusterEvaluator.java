package org.apache.commons.math3.ml.clustering.evaluation;

import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.ml.clustering.CentroidCluster;
import org.apache.commons.math3.ml.clustering.Cluster;
import org.apache.commons.math3.ml.clustering.Clusterable;
import org.apache.commons.math3.ml.clustering.DoublePoint;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.ml.distance.EuclideanDistance;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ClusterEvaluator<T extends Clusterable> {
    private final DistanceMeasure measure;

    public boolean isBetterScore(double r1, double r3) {
        if (r1 >= r3) goto L5;
        return true;
    L5:
        return false;
    }

    public abstract double score(List<? extends Cluster<T>> r1);

    public ClusterEvaluator() {
        this(new EuclideanDistance());
    }

    public ClusterEvaluator(DistanceMeasure r1) {
        this.measure = r1;
    }

    protected double distance(Clusterable r1, Clusterable r2) {
        return this.measure.compute(r1.getPoint(), r2.getPoint());
    }

    protected Clusterable centroidOf(Cluster<T> r10) {
        List<T> r9 = r10.getPoints();
        if (r9.isEmpty() == false) goto L7;
        return null;
    L7:
        if ((r10 instanceof CentroidCluster) == true) goto L9;
        int r11 = 0;
        int r0 = r9.get(0).getPoint().length;
        double[] r1 = new double[r0];
        Iterator<T> r2 = r9.iterator();
    L12:
        if (r2.hasNext() == false) goto L16;
        double[] r3 = r2.next().getPoint();
        int r4 = 0;
    L14:
        if (r4 >= r0) goto L12;
        r1[r4] = r1[r4] + r3[r4];
        r4 = r4 + 1;
    L16:
        if (r11 >= r0) goto L19;
        r1[r11] = r1[r11] / ((double) r9.size());
        r11 = r11 + 1;
        goto L16
    L19:
        return new DoublePoint(r1);
    L9:
        return ((CentroidCluster) r10).getCenter();
    }
}
