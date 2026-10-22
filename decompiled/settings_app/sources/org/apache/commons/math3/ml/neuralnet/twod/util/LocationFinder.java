package org.apache.commons.math3.ml.neuralnet.twod.util;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.ml.neuralnet.Neuron;
import org.apache.commons.math3.ml.neuralnet.twod.NeuronSquareMesh2D;

/* JADX INFO: loaded from: classes6.dex */
public class LocationFinder {
    private final Map<Long, Location> locations;

    public static class Location {
        private final int column;
        private final int row;

        public Location(int r1, int r2) {
            this.row = r1;
            this.column = r2;
        }

        public int getRow() {
            return this.row;
        }

        public int getColumn() {
            return this.column;
        }
    }

    public LocationFinder(NeuronSquareMesh2D r9) {
        this.locations = new HashMap();
        int r0 = r9.getNumberOfRows();
        int r1 = r9.getNumberOfColumns();
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L12;
        int r4 = 0;
    L5:
        if (r4 >= r1) goto L11;
        Long r5 = Long.valueOf(r9.getNeuron(r3, r4).getIdentifier());
        if (this.locations.get(r5) != null) goto L10;
        this.locations.put(r5, new Location(r3, r4));
        r4 = r4 + 1;
        goto L5
    L10:
        throw new MathIllegalStateException();
    L11:
        r3 = r3 + 1;
        goto L3
    }

    public Location getLocation(Neuron r3) {
        return this.locations.get(Long.valueOf(r3.getIdentifier()));
    }
}
