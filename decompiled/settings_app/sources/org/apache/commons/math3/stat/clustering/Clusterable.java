package org.apache.commons.math3.stat.clustering;

import java.util.Collection;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public interface Clusterable<T> {
    T centroidOf(Collection<T> r1);

    double distanceFrom(T r1);
}
