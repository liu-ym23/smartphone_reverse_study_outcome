package org.apache.commons.math3.ml.neuralnet;

/* JADX INFO: loaded from: classes6.dex */
public final enum SquareNeighbourhood extends Enum<SquareNeighbourhood> {
    private static final /* synthetic */ SquareNeighbourhood[] $VALUES = null;
    public static final SquareNeighbourhood MOORE = null;
    public static final SquareNeighbourhood VON_NEUMANN = null;

    private SquareNeighbourhood(String r1, int r2) {
        super(r1, r2);
    }

    public static SquareNeighbourhood valueOf(String r1) {
        return (SquareNeighbourhood) Enum.valueOf(SquareNeighbourhood.class, r1);
    }

    public static SquareNeighbourhood[] values() {
        return (SquareNeighbourhood[]) $VALUES.clone();
    }

    static {
        SquareNeighbourhood r0 = new SquareNeighbourhood("VON_NEUMANN", 0);
        VON_NEUMANN = r0;
        SquareNeighbourhood r1 = new SquareNeighbourhood("MOORE", 1);
        MOORE = r1;
        $VALUES = new SquareNeighbourhood[]{r0, r1};
    }
}
