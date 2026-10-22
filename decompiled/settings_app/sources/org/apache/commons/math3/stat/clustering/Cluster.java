package org.apache.commons.math3.stat.clustering;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.stat.clustering.Clusterable;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class Cluster<T extends Clusterable<T>> implements Serializable {
    private static final long serialVersionUID = -3442297081515880464L;
    private final T center;
    private final List<T> points;

    public Cluster(T r1) {
        this.center = r1;
        this.points = new ArrayList();
    }

    public void addPoint(T r1) {
        this.points.add(r1);
    }

    public List<T> getPoints() {
        return this.points;
    }

    public T getCenter() {
        return this.center;
    }
}
