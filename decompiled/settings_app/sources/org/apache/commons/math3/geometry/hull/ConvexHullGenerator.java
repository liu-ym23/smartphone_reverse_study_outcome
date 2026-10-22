package org.apache.commons.math3.geometry.hull;

import java.util.Collection;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
public interface ConvexHullGenerator<S extends Space, P extends Point<S>> {
    ConvexHull<S, P> generate(Collection<P> r1) throws NullArgumentException, ConvergenceException;
}
