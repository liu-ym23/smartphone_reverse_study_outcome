package io.reactivex;

/* JADX INFO: loaded from: classes2.dex */
public final enum BackpressureStrategy extends Enum<BackpressureStrategy> {
    private static final /* synthetic */ BackpressureStrategy[] $VALUES = null;
    public static final BackpressureStrategy BUFFER = null;
    public static final BackpressureStrategy DROP = null;
    public static final BackpressureStrategy ERROR = null;
    public static final BackpressureStrategy LATEST = null;
    public static final BackpressureStrategy MISSING = null;

    static {
        BackpressureStrategy r0 = new BackpressureStrategy("MISSING", 0);
        MISSING = r0;
        BackpressureStrategy r1 = new BackpressureStrategy("ERROR", 1);
        ERROR = r1;
        BackpressureStrategy r2 = new BackpressureStrategy("BUFFER", 2);
        BUFFER = r2;
        BackpressureStrategy r3 = new BackpressureStrategy("DROP", 3);
        DROP = r3;
        BackpressureStrategy r4 = new BackpressureStrategy("LATEST", 4);
        LATEST = r4;
        $VALUES = new BackpressureStrategy[]{r0, r1, r2, r3, r4};
    }

    private BackpressureStrategy(String r1, int r2) {
        super(r1, r2);
    }

    public static BackpressureStrategy valueOf(String r1) {
        return (BackpressureStrategy) Enum.valueOf(BackpressureStrategy.class, r1);
    }

    public static BackpressureStrategy[] values() {
        return (BackpressureStrategy[]) $VALUES.clone();
    }
}
