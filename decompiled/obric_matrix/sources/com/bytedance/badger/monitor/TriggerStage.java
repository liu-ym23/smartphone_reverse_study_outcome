package com.bytedance.badger.monitor;

/* JADX INFO: loaded from: classes.dex */
public final enum TriggerStage extends Enum {
    private static final /* synthetic */ TriggerStage[] $VALUES = null;
    public static final TriggerStage login_finished = null;
    public static final TriggerStage manual = null;
    public static final TriggerStage periodic = null;
    public static final TriggerStage periodic_first = null;
    public static final TriggerStage recollect = null;

    static {
        TriggerStage r1 = new TriggerStage("login_finished", 0);
        login_finished = r1;
        TriggerStage r2 = new TriggerStage("recollect", 1);
        recollect = r2;
        TriggerStage r3 = new TriggerStage("manual", 2);
        manual = r3;
        TriggerStage r4 = new TriggerStage("periodic_first", 3);
        periodic_first = r4;
        TriggerStage r5 = new TriggerStage("periodic", 4);
        periodic = r5;
        $VALUES = new TriggerStage[]{r1, r2, r3, r4, r5};
    }

    private TriggerStage(String r1, int r2) {
        super(r1, r2);
    }

    public static TriggerStage valueOf(String r1) {
        return (TriggerStage) Enum.valueOf(TriggerStage.class, r1);
    }

    public static TriggerStage[] values() {
        return (TriggerStage[]) $VALUES.clone();
    }
}
