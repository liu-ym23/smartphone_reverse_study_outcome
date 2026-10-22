package com.bytedance.monitor.util.thread;

/* JADX INFO: loaded from: classes3.dex */
public final enum AsyncTaskType extends Enum<AsyncTaskType> {
    private static final /* synthetic */ AsyncTaskType[] $VALUES = null;
    public static final AsyncTaskType IO = null;
    public static final AsyncTaskType LIGHT_WEIGHT = null;
    public static final AsyncTaskType TIME_SENSITIVE = null;

    public static AsyncTaskType valueOf(String r1) {
        return (AsyncTaskType) Enum.valueOf(AsyncTaskType.class, r1);
    }

    public static AsyncTaskType[] values() {
        return (AsyncTaskType[]) $VALUES.clone();
    }

    static {
        AsyncTaskType r0 = new AsyncTaskType("IO", 0);
        IO = r0;
        AsyncTaskType r1 = new AsyncTaskType("TIME_SENSITIVE", 1);
        TIME_SENSITIVE = r1;
        AsyncTaskType r3 = new AsyncTaskType("LIGHT_WEIGHT", 2);
        LIGHT_WEIGHT = r3;
        $VALUES = new AsyncTaskType[]{r0, r1, r3};
    }

    private AsyncTaskType(String r1, int r2) {
        super(r1, r2);
    }
}
