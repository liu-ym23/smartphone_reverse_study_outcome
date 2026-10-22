package org.apache.commons.math3.geometry.euclidean.twod.hull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.geometry.euclidean.twod.Line;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class MonotoneChain extends AbstractConvexHullGenerator2D {
    @Override // org.apache.commons.math3.geometry.euclidean.twod.hull.AbstractConvexHullGenerator2D, org.apache.commons.math3.geometry.euclidean.twod.hull.ConvexHullGenerator2D, org.apache.commons.math3.geometry.hull.ConvexHullGenerator
    public /* bridge */ /* synthetic */ ConvexHull2D generate(Collection r1) throws NullArgumentException, ConvergenceException {
        return super.generate(r1);
    }

    @Override // org.apache.commons.math3.geometry.euclidean.twod.hull.AbstractConvexHullGenerator2D
    public /* bridge */ /* synthetic */ double getTolerance() {
        return super.getTolerance();
    }

    @Override // org.apache.commons.math3.geometry.euclidean.twod.hull.AbstractConvexHullGenerator2D
    public /* bridge */ /* synthetic */ boolean isIncludeCollinearPoints() {
        return super.isIncludeCollinearPoints();
    }

    public MonotoneChain() {
        this(false);
    }

    public MonotoneChain(boolean r1) {
        super(r1);
    }

    public MonotoneChain(boolean r1, double r2) {
        super(r1, r2);
    }

    @Override // org.apache.commons.math3.geometry.euclidean.twod.hull.AbstractConvexHullGenerator2D
    public Collection<Vector2D> findHullVertices(Collection<Vector2D> r5) {
        ArrayList r0 = new ArrayList(r5);
        Collections.sort(r0, new AnonymousClass1(this));
        ArrayList r6 = new ArrayList();
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        updateHull((Vector2D) r1.next(), r6);
        goto L4
    L6:
        ArrayList r2 = new ArrayList();
        int r3 = r0.size() - 1;
    L7:
        if (r3 < 0) goto L9;
        updateHull((Vector2D) r0.get(r3), r2);
        r3 = r3 - 1;
        goto L7
    L9:
        ArrayList r4 = new ArrayList((r6.size() + r2.size()) - 2);
        int r7 = 0;
    L11:
        if (r7 >= (r6.size() - 1)) goto L13;
        r4.add(r6.get(r7));
        r7 = r7 + 1;
        goto L11
    L13:
        int r8 = 0;
    L15:
        if (r8 >= (r2.size() - 1)) goto L18;
        r4.add(r2.get(r8));
        r8 = r8 + 1;
        goto L15
    L18:
        if (r4.isEmpty() == true) goto L20;
    L22:
        return r4;
    L20:
        if (r6.isEmpty() == true) goto L22;
        r4.add(r6.get(0));
        goto L22
    }

    private void updateHull(Vector2D r11, List<Vector2D> r12) {
        double r0 = getTolerance();
        if (r12.size() != 1) goto L8;
        if (r12.get(0).distance(r11) >= r0) goto L8;
        return;
    L8:
        if (r12.size() < 2) goto L29;
        int r2 = r12.size();
        Vector2D r3 = r12.get(r2 - 2);
        int r4 = r2 - 1;
        Vector2D r5 = r12.get(r4);
        double r6 = new Line(r3, r5, r0).getOffset(r11);
        if (FastMath.abs(r6) < r0) goto L11;
        if (r6 <= 0.0d) goto L29;
        r12.remove(r4);
        goto L8
    L11:
        double r7 = r3.distance(r11);
        if (r7 >= r0) goto L14;
        return;
    L14:
        if (r5.distance(r11) < r0) goto L38;
        double r1 = r3.distance(r5);
        if (isIncludeCollinearPoints() == false) goto L23;
        if (r7 >= r1) goto L21;
        r2 = r4;
    L21:
        r12.add(r2, r11);
        return;
    L23:
        if (r7 <= r1) goto L37;
        r12.remove(r4);
        r12.add(r11);
        return;
    L37:
        return;
    L38:
        return;
    L29:
        r12.add(r11);
    }
}
