package org.apache.commons.math3.ml.clustering;

import java.util.Collection;
import java.util.List;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.ml.clustering.Clusterable;
import org.apache.commons.math3.ml.distance.DistanceMeasure;

/* JADX INFO: loaded from: classes6.dex */
public abstract class Clusterer<T extends Clusterable> {
    private DistanceMeasure measure;

    public abstract List<? extends Cluster<T>> cluster(Collection<T> r1) throws MathIllegalArgumentException, ConvergenceException;

    protected Clusterer(DistanceMeasure r1) {
        this.measure = r1;
    }

    public DistanceMeasure getDistanceMeasure() {
        return this.measure;
    }

    protected double distance(Clusterable r1, Clusterable r2) {
        return this.measure.compute(r1.getPoint(), r2.getPoint());
    }
}
