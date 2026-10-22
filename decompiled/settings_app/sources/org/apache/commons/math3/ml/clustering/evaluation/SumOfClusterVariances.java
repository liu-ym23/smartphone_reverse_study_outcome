package org.apache.commons.math3.ml.clustering.evaluation;

import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.ml.clustering.Cluster;
import org.apache.commons.math3.ml.clustering.Clusterable;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.stat.descriptive.moment.Variance;

/* JADX INFO: loaded from: classes6.dex */
public class SumOfClusterVariances<T extends Clusterable> extends ClusterEvaluator<T> {
    public SumOfClusterVariances(DistanceMeasure r1) {
        super(r1);
    }

    @Override // org.apache.commons.math3.ml.clustering.evaluation.ClusterEvaluator
    public double score(List<? extends Cluster<T>> r8) {
        Iterator<? extends Cluster<T>> r9 = r8.iterator();
        double r0 = 0.0d;
    L4:
        if (r9.hasNext() == false) goto L12;
        Cluster<T> r2 = r9.next();
        if (r2.getPoints().isEmpty() == true) goto L4;
        Clusterable r3 = centroidOf(r2);
        Variance r4 = new Variance();
        Iterator<T> r5 = r2.getPoints().iterator();
    L9:
        if (r5.hasNext() == false) goto L11;
        r4.increment(distance(r5.next(), r3));
        goto L9
    L11:
        r0 = r0 + r4.getResult();
        goto L4
    L12:
        return r0;
    }
}
