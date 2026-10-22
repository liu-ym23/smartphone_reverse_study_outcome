package org.apache.commons.math3.geometry.partitioning;

import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
public interface Transform<S extends Space, T extends Space> {
    Point<S> apply(Point<S> r1);

    Hyperplane<S> apply(Hyperplane<S> r1);

    SubHyperplane<T> apply(SubHyperplane<T> r1, Hyperplane<S> r2, Hyperplane<S> r3);
}
