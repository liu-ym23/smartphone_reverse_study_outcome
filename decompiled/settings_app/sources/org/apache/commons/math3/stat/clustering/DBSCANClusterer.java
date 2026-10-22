package org.apache.commons.math3.stat.clustering;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.stat.clustering.Clusterable;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class DBSCANClusterer<T extends Clusterable<T>> {
    private final double eps;
    private final int minPts;

    private static final enum PointStatus extends Enum<PointStatus> {
        private static final /* synthetic */ PointStatus[] $VALUES = null;
        public static final PointStatus NOISE = null;
        public static final PointStatus PART_OF_CLUSTER = null;

        private PointStatus(String r1, int r2) {
            super(r1, r2);
        }

        public static PointStatus valueOf(String r1) {
            return (PointStatus) Enum.valueOf(PointStatus.class, r1);
        }

        public static PointStatus[] values() {
            return (PointStatus[]) $VALUES.clone();
        }

        static {
            PointStatus r0 = new PointStatus("NOISE", 0);
            NOISE = r0;
            PointStatus r1 = new PointStatus("PART_OF_CLUSTER", 1);
            PART_OF_CLUSTER = r1;
            $VALUES = new PointStatus[]{r0, r1};
        }
    }

    public DBSCANClusterer(double r3, int r5) throws NotPositiveException {
        if (r3 < 0.0d) goto L10;
        if (r5 < 0) goto L8;
        this.eps = r3;
        this.minPts = r5;
        return;
    L8:
        throw new NotPositiveException(Integer.valueOf(r5));
    L10:
        throw new NotPositiveException(Double.valueOf(r3));
    }

    public double getEps() {
        return this.eps;
    }

    public int getMinPts() {
        return this.minPts;
    }

    public List<Cluster<T>> cluster(Collection<T> r10) throws NullArgumentException {
        MathUtils.checkNotNull(r10);
        ArrayList r0 = new ArrayList();
        HashMap r7 = new HashMap();
        Iterator<T> r8 = r10.iterator();
    L4:
        if (r8.hasNext() == false) goto L12;
        T r3 = r8.next();
        if (r7.get(r3) != null) goto L4;
        List<T> r4 = getNeighbors(r3, r10);
        if (r4.size() >= this.minPts) goto L10;
        r7.put(r3, PointStatus.NOISE);
        goto L4
    L10:
        r0.add(expandCluster(new Cluster(null), r3, r4, r10, r7));
        goto L4
    L12:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Cluster<T> expandCluster(Cluster<T> r6, T r7, List<T> r8, Collection<T> r9, Map<Clusterable<T>, PointStatus> r10) {
        r6.addPoint(r7);
        r10.put(r7, PointStatus.PART_OF_CLUSTER);
        List<T> r11 = new ArrayList(r8);
        int r12 = 0;
    L4:
        if (r12 >= r11.size()) goto L14;
        T r0 = r11.get(r12);
        PointStatus r1 = (PointStatus) r10.get(r0);
        if (r1 != null) goto L11;
        List<T> r2 = getNeighbors(r0, r9);
        if (r2.size() < this.minPts) goto L11;
        r11 = merge(r11, r2);
    L11:
        if (r1 == PointStatus.PART_OF_CLUSTER) goto L13;
        r10.put(r0, PointStatus.PART_OF_CLUSTER);
        r6.addPoint(r0);
    L13:
        r12 = r12 + 1;
        goto L4
    L14:
        return r6;
    }

    private List<T> getNeighbors(T r7, Collection<T> r8) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L10;
        T r1 = r9.next();
        if (r7 == r1) goto L4;
        if (r1.distanceFrom(r7) > this.eps) goto L4;
        r0.add(r1);
        goto L4
    L10:
        return r0;
    }

    private List<T> merge(List<T> r3, List<T> r4) {
        HashSet r2 = new HashSet(r3);
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        T r0 = r5.next();
        if (r2.contains(r0) == true) goto L4;
        r3.add(r0);
        goto L4
    L8:
        return r3;
    }
}
