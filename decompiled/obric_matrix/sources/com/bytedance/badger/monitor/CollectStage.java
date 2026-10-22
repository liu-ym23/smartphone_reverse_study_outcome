package com.bytedance.badger.monitor;

import androidx.core.os.EnvironmentCompat;

/* JADX INFO: loaded from: classes.dex */
public final enum CollectStage extends Enum {
    private static final /* synthetic */ CollectStage[] $VALUES = null;
    public static final CollectStage collect_finished = null;
    public static final CollectStage collect_pre = null;
    public static final CollectStage report_finished = null;
    public static final CollectStage unknown = null;

    static {
        CollectStage r1 = new CollectStage("collect_pre", 0);
        collect_pre = r1;
        CollectStage r2 = new CollectStage("collect_finished", 1);
        collect_finished = r2;
        CollectStage r3 = new CollectStage("report_finished", 2);
        report_finished = r3;
        CollectStage r4 = new CollectStage(EnvironmentCompat.MEDIA_UNKNOWN, 3);
        unknown = r4;
        $VALUES = new CollectStage[]{r1, r2, r3, r4};
    }

    private CollectStage(String r1, int r2) {
        super(r1, r2);
    }

    public static CollectStage valueOf(String r1) {
        return (CollectStage) Enum.valueOf(CollectStage.class, r1);
    }

    public static CollectStage[] values() {
        return (CollectStage[]) $VALUES.clone();
    }
}
