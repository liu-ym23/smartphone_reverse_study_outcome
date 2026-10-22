package org.apache.commons.math3.geometry.enclosing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
public class WelzlEncloser<S extends Space, P extends Point<S>> implements Encloser<S, P> {
    private final SupportBallGenerator<S, P> generator;
    private final double tolerance;

    public WelzlEncloser(double r1, SupportBallGenerator<S, P> r3) {
        this.tolerance = r1;
        this.generator = r3;
    }

    @Override // org.apache.commons.math3.geometry.enclosing.Encloser
    public EnclosingBall<S, P> enclose(Iterable<P> r2) {
        if (r2 == null) goto L9;
        if (r2.iterator().hasNext() == false) goto L9;
        return pivotingBall(r2);
    L9:
        return this.generator.ballOnSupport(new ArrayList());
    }

    private EnclosingBall<S, P> pivotingBall(Iterable<P> r10) {
        P r0 = r10.iterator().next();
        ArrayList r1 = new ArrayList(r0.getSpace().getDimension() + 1);
        ArrayList r2 = new ArrayList(r0.getSpace().getDimension() + 1);
        r1.add(r0);
        EnclosingBall<S, P> r3 = moveToFrontBall(r1, r1.size(), r2);
    L3:
        Point r4 = selectFarthest(r10, r3);
        if (r3.contains(r4, this.tolerance) == true) goto L5;
        r2.clear();
        r2.add(r4);
        EnclosingBall<S, P> r5 = moveToFrontBall(r1, r1.size(), r2);
        if (r5.getRadius() < r3.getRadius()) goto L10;
        r1.add(0, r4);
        r1.subList(r5.getSupportSize(), r1.size()).clear();
        r3 = r5;
        goto L3
    L10:
        throw new MathInternalError();
    L5:
        return r3;
    }

    private EnclosingBall<S, P> moveToFrontBall(List<P> r7, int r8, List<P> r9) {
        EnclosingBall<S, P> r0 = this.generator.ballOnSupport(r9);
        if (r0.getSupportSize() > r0.getCenter().getSpace().getDimension()) goto L13;
        int r2 = 0;
    L5:
        if (r2 >= r8) goto L13;
        P r3 = r7.get(r2);
        if (r0.contains(r3, this.tolerance) == true) goto L12;
        r9.add(r3);
        r0 = moveToFrontBall(r7, r2, r9);
        r9.remove(r9.size() - 1);
        int r4 = r2;
    L9:
        if (r4 <= 0) goto L11;
        r7.set(r4, r7.get(r4 - 1));
        r4 = r4 - 1;
        goto L9
    L11:
        r7.set(0, r3);
    L12:
        r2 = r2 + 1;
    L13:
        return r0;
    }

    public P selectFarthest(Iterable<P> r7, EnclosingBall<S, P> r8) {
        Point<S> r6 = r8.getCenter();
        Iterator<P> r9 = r7.iterator();
        P r10 = null;
        double r0 = -1.0d;
    L4:
        if (r9.hasNext() == false) goto L8;
        P r2 = r9.next();
        double r3 = r2.distance(r6);
        if (r3 <= r0) goto L4;
        r10 = r2;
        r0 = r3;
        goto L4
    L8:
        return r10;
    }
}
