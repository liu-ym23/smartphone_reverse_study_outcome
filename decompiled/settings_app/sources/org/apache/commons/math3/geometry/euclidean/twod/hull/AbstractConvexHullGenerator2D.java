package org.apache.commons.math3.geometry.euclidean.twod.hull;

import java.util.Collection;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.geometry.hull.ConvexHull;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
abstract class AbstractConvexHullGenerator2D implements ConvexHullGenerator2D {
    private static final double DEFAULT_TOLERANCE = 1.0E-10d;
    private final boolean includeCollinearPoints;
    private final double tolerance;

    protected abstract Collection<Vector2D> findHullVertices(Collection<Vector2D> r1);

    @Override // org.apache.commons.math3.geometry.hull.ConvexHullGenerator
    public /* bridge */ /* synthetic */ ConvexHull generate(Collection r1) throws NullArgumentException, ConvergenceException {
        return generate(r1);
    }

    protected AbstractConvexHullGenerator2D(boolean r3) {
        this(r3, 1.0E-10d);
    }

    protected AbstractConvexHullGenerator2D(boolean r1, double r2) {
        this.includeCollinearPoints = r1;
        this.tolerance = r2;
    }

    public double getTolerance() {
        return this.tolerance;
    }

    public boolean isIncludeCollinearPoints() {
        return this.includeCollinearPoints;
    }

    @Override // org.apache.commons.math3.geometry.euclidean.twod.hull.ConvexHullGenerator2D, org.apache.commons.math3.geometry.hull.ConvexHullGenerator
    public ConvexHull2D generate(Collection<Vector2D> r4) throws NullArgumentException, ConvergenceException {
        MathUtils.checkNotNull(r4);
        if (r4.size() < 2) goto L10;
        r4 = findHullVertices(r4);
    L10:
        return new ConvexHull2D((Vector2D[]) r4.toArray(new Vector2D[r4.size()]), this.tolerance);
    L9:
        throw new ConvergenceException();
    }
}
