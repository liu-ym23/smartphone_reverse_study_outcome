package org.apache.commons.math3.geometry.partitioning;

import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
public interface Embedding<S extends Space, T extends Space> {
    Point<S> toSpace(Point<T> r1);

    Point<T> toSubSpace(Point<S> r1);
}
