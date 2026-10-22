package com.bytedance.apm.trace.api.wrapper;

/* JADX INFO: loaded from: classes.dex */
public final enum TracingWrapperMode extends Enum<TracingWrapperMode> {
    private static final /* synthetic */ TracingWrapperMode[] $VALUES = null;
    public static final TracingWrapperMode PARALLEL_WRAPPER_MODE = null;
    public static final TracingWrapperMode SERIAL_WRAPPER_MODE = null;

    static {
        TracingWrapperMode r0 = new TracingWrapperMode("PARALLEL_WRAPPER_MODE", 0);
        PARALLEL_WRAPPER_MODE = r0;
        TracingWrapperMode r1 = new TracingWrapperMode("SERIAL_WRAPPER_MODE", 1);
        SERIAL_WRAPPER_MODE = r1;
        $VALUES = new TracingWrapperMode[]{r0, r1};
    }

    private TracingWrapperMode(String r1, int r2) {
        super(r1, r2);
    }

    public static TracingWrapperMode valueOf(String r1) {
        return (TracingWrapperMode) Enum.valueOf(TracingWrapperMode.class, r1);
    }

    public static TracingWrapperMode[] values() {
        return (TracingWrapperMode[]) $VALUES.clone();
    }
}
