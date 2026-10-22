package org.apache.commons.math3.stat.ranking;

/* JADX INFO: loaded from: classes6.dex */
public final enum TiesStrategy extends Enum<TiesStrategy> {
    private static final /* synthetic */ TiesStrategy[] $VALUES = null;
    public static final TiesStrategy AVERAGE = null;
    public static final TiesStrategy MAXIMUM = null;
    public static final TiesStrategy MINIMUM = null;
    public static final TiesStrategy RANDOM = null;
    public static final TiesStrategy SEQUENTIAL = null;

    private TiesStrategy(String r1, int r2) {
        super(r1, r2);
    }

    public static TiesStrategy valueOf(String r1) {
        return (TiesStrategy) Enum.valueOf(TiesStrategy.class, r1);
    }

    public static TiesStrategy[] values() {
        return (TiesStrategy[]) $VALUES.clone();
    }

    static {
        TiesStrategy r0 = new TiesStrategy("SEQUENTIAL", 0);
        SEQUENTIAL = r0;
        TiesStrategy r1 = new TiesStrategy("MINIMUM", 1);
        MINIMUM = r1;
        TiesStrategy r3 = new TiesStrategy("MAXIMUM", 2);
        MAXIMUM = r3;
        TiesStrategy r5 = new TiesStrategy("AVERAGE", 3);
        AVERAGE = r5;
        TiesStrategy r7 = new TiesStrategy("RANDOM", 4);
        RANDOM = r7;
        $VALUES = new TiesStrategy[]{r0, r1, r3, r5, r7};
    }
}
