package org.apache.commons.math3.geometry.euclidean.twod.hull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

/* JADX INFO: loaded from: classes6.dex */
public final class AklToussaintHeuristic {
    private AklToussaintHeuristic() {
    }

    public static Collection<Vector2D> reducePoints(Collection<Vector2D> r12) {
        Iterator<Vector2D> r0 = r12.iterator();
        Vector2D r2 = null;
        int r6 = 0;
        Vector2D r3 = null;
        Vector2D r4 = null;
        Vector2D r5 = null;
    L4:
        if (r0.hasNext() == false) goto L24;
        Vector2D r7 = r0.next();
        if (r2 != null) goto L8;
    L9:
        r2 = r7;
    L10:
        if (r4 != null) goto L12;
    L13:
        r4 = r7;
    L14:
        if (r3 != null) goto L16;
    L17:
        r3 = r7;
    L18:
        if (r5 != null) goto L20;
    L21:
        r5 = r7;
    L22:
        r6 = r6 + 1;
        goto L4
    L20:
        if (r7.getY() <= r5.getY()) goto L22;
    L16:
        if (r7.getY() >= r3.getY()) goto L18;
    L12:
        if (r7.getX() <= r4.getX()) goto L14;
    L8:
        if (r7.getX() >= r2.getX()) goto L10;
    L24:
        if (r6 >= 4) goto L26;
        return r12;
    L26:
        List<Vector2D> r1 = buildQuadrilateral(new Vector2D[]{r3, r4, r5, r2});
        if (r1.size() >= 3) goto L29;
        return r12;
    L29:
        ArrayList r8 = new ArrayList(r1);
        Iterator<Vector2D> r13 = r12.iterator();
    L31:
        if (r13.hasNext() == false) goto L35;
        Vector2D r9 = r13.next();
        if (insideQuadrilateral(r9, r1) == true) goto L31;
        r8.add(r9);
        goto L31
    L35:
        return r8;
    }

    private static List<Vector2D> buildQuadrilateral(Vector2D... r5) {
        ArrayList r0 = new ArrayList();
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        Vector2D r3 = r5[r2];
        if (r0.contains(r3) == true) goto L7;
        r0.add(r3);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        return r0;
    }

    private static boolean insideQuadrilateral(Vector2D r12, List<Vector2D> r13) {
        Vector2D r1 = r13.get(0);
        Vector2D r3 = r13.get(1);
        if (r12.equals(r1) == false) goto L5;
    L22:
        return true;
    L5:
        if (r12.equals(r3) == true) goto L22;
        double r4 = r12.crossProduct(r1, r3);
        int r2 = r13.size();
        int r6 = 1;
    L8:
        if (r6 >= r2) goto L22;
        r6 = r6 + 1;
        if (r6 != r2) goto L12;
        int r7 = 0;
    L13:
        Vector2D r8 = r13.get(r7);
        if (r12.equals(r3) == true) goto L22;
        if (r12.equals(r8) == true) goto L22;
        if ((r12.crossProduct(r3, r8) * r4) < 0.0d) goto L20;
        r3 = r8;
        goto L8
    L20:
        return false;
    L12:
        r7 = r6;
        goto L13
    }
}
