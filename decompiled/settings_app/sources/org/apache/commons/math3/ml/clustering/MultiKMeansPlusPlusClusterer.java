package org.apache.commons.math3.ml.clustering;

import java.util.Collection;
import java.util.List;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.ml.clustering.Clusterable;
import org.apache.commons.math3.ml.clustering.evaluation.ClusterEvaluator;
import org.apache.commons.math3.ml.clustering.evaluation.SumOfClusterVariances;

/* JADX INFO: loaded from: classes6.dex */
public class MultiKMeansPlusPlusClusterer<T extends Clusterable> extends Clusterer<T> {
    private final KMeansPlusPlusClusterer<T> clusterer;
    private final ClusterEvaluator<T> evaluator;
    private final int numTrials;

    public MultiKMeansPlusPlusClusterer(KMeansPlusPlusClusterer<T> r3, int r4) {
        this(r3, r4, new SumOfClusterVariances(r3.getDistanceMeasure()));
    }

    public MultiKMeansPlusPlusClusterer(KMeansPlusPlusClusterer<T> r2, int r3, ClusterEvaluator<T> r4) {
        super(r2.getDistanceMeasure());
        this.clusterer = r2;
        this.numTrials = r3;
        this.evaluator = r4;
    }

    public KMeansPlusPlusClusterer<T> getClusterer() {
        return this.clusterer;
    }

    public int getNumTrials() {
        return this.numTrials;
    }

    public ClusterEvaluator<T> getClusterEvaluator() {
        return this.evaluator;
    }

    @Override // org.apache.commons.math3.ml.clustering.Clusterer
    public List<CentroidCluster<T>> cluster(Collection<T> r9) throws MathIllegalArgumentException, ConvergenceException {
        List<CentroidCluster<T>> r0 = null;
        double r1 = Double.POSITIVE_INFINITY;
        int r3 = 0;
    L4:
        if (r3 >= this.numTrials) goto L9;
        List<CentroidCluster<T>> r4 = this.clusterer.cluster(r9);
        double r5 = this.evaluator.score(r4);
        if (this.evaluator.isBetterScore(r5, r1) == false) goto L8;
        r0 = r4;
        r1 = r5;
    L8:
        r3 = r3 + 1;
        goto L4
    L9:
        return r0;
    }
}
