package com.bytedance.apm6.cpu.exception;

/* JADX INFO: loaded from: classes3.dex */
public final enum StateType extends Enum<StateType> {
    private static final /* synthetic */ StateType[] $VALUES = null;
    public static final StateType COOL_DOWN = null;
    public static final StateType IDLE = null;
    public static final StateType PROCESS_DETECT = null;
    public static final StateType PROCESS_DOUBLE_DETECT = null;
    public static final StateType THREAD_DETECT = null;

    private StateType(String r1, int r2) {
        super(r1, r2);
    }

    public static StateType valueOf(String r1) {
        return (StateType) Enum.valueOf(StateType.class, r1);
    }

    public static StateType[] values() {
        return (StateType[]) $VALUES.clone();
    }

    static {
        StateType r0 = new StateType("PROCESS_DETECT", 0);
        PROCESS_DETECT = r0;
        StateType r1 = new StateType("PROCESS_DOUBLE_DETECT", 1);
        PROCESS_DOUBLE_DETECT = r1;
        StateType r3 = new StateType("THREAD_DETECT", 2);
        THREAD_DETECT = r3;
        StateType r5 = new StateType("COOL_DOWN", 3);
        COOL_DOWN = r5;
        StateType r7 = new StateType("IDLE", 4);
        IDLE = r7;
        $VALUES = new StateType[]{r0, r1, r3, r5, r7};
    }
}
