package com.bytedance.apm6.util.timetask;

/* JADX INFO: loaded from: classes.dex */
public final enum AsyncTaskManagerType extends Enum<AsyncTaskManagerType> {
    private static final /* synthetic */ AsyncTaskManagerType[] $VALUES = null;
    public static final AsyncTaskManagerType CPU = null;
    public static final AsyncTaskManagerType IO = null;
    public static final AsyncTaskManagerType LIGHT_WEIGHT = null;
    public static final AsyncTaskManagerType TIME_SENSITIVE = null;

    static {
        AsyncTaskManagerType r0 = new AsyncTaskManagerType("IO", 0);
        IO = r0;
        AsyncTaskManagerType r1 = new AsyncTaskManagerType("LIGHT_WEIGHT", 1);
        LIGHT_WEIGHT = r1;
        AsyncTaskManagerType r2 = new AsyncTaskManagerType("TIME_SENSITIVE", 2);
        TIME_SENSITIVE = r2;
        AsyncTaskManagerType r3 = new AsyncTaskManagerType("CPU", 3);
        CPU = r3;
        $VALUES = new AsyncTaskManagerType[]{r0, r1, r2, r3};
    }

    private AsyncTaskManagerType(String r1, int r2) {
        super(r1, r2);
    }

    public static AsyncTaskManagerType valueOf(String r1) {
        return (AsyncTaskManagerType) Enum.valueOf(AsyncTaskManagerType.class, r1);
    }

    public static AsyncTaskManagerType[] values() {
        return (AsyncTaskManagerType[]) $VALUES.clone();
    }
}
