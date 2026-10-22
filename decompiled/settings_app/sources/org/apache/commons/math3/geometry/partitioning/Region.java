package org.apache.commons.math3.geometry.partitioning;

import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
public interface Region<S extends Space> {

    public static final enum Location extends Enum<Location> {
        private static final /* synthetic */ Location[] $VALUES = null;
        public static final Location BOUNDARY = null;
        public static final Location INSIDE = null;
        public static final Location OUTSIDE = null;

        private Location(String r1, int r2) {
            super(r1, r2);
        }

        public static Location valueOf(String r1) {
            return (Location) Enum.valueOf(Location.class, r1);
        }

        public static Location[] values() {
            return (Location[]) $VALUES.clone();
        }

        static {
            Location r0 = new Location("INSIDE", 0);
            INSIDE = r0;
            Location r1 = new Location("OUTSIDE", 1);
            OUTSIDE = r1;
            Location r3 = new Location("BOUNDARY", 2);
            BOUNDARY = r3;
            $VALUES = new Location[]{r0, r1, r3};
        }
    }

    Region<S> buildNew(BSPTree<S> r1);

    Location checkPoint(Point<S> r1);

    boolean contains(Region<S> r1);

    Region<S> copySelf();

    Point<S> getBarycenter();

    double getBoundarySize();

    double getSize();

    BSPTree<S> getTree(boolean r1);

    SubHyperplane<S> intersection(SubHyperplane<S> r1);

    boolean isEmpty();

    boolean isEmpty(BSPTree<S> r1);

    boolean isFull();

    boolean isFull(BSPTree<S> r1);

    BoundaryProjection<S> projectToBoundary(Point<S> r1);

    @Deprecated
    Side side(Hyperplane<S> r1);
}
