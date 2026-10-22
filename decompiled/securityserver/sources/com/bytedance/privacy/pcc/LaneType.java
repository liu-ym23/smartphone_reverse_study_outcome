package com.bytedance.privacy.pcc;

/* JADX INFO: loaded from: classes.dex */
public final enum LaneType extends Enum<LaneType> {
    private static final /* synthetic */ LaneType[] $VALUES = null;
    public static final LaneType CPU_NORMAL = null;
    public static final LaneType CPU_TEE = null;
    public static final LaneType GPU_TEE = null;
    public static final LaneType IGNORE = null;
    private final int value;

    private static /* synthetic */ LaneType[] $values() {
        return new LaneType[]{IGNORE, CPU_NORMAL, CPU_TEE, GPU_TEE};
    }

    static {
        IGNORE = new LaneType("IGNORE", 0, 0);
        CPU_NORMAL = new LaneType("CPU_NORMAL", 1, 1);
        CPU_TEE = new LaneType("CPU_TEE", 2, 2);
        GPU_TEE = new LaneType("GPU_TEE", 3, 3);
        $VALUES = $values();
    }

    private LaneType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static LaneType fromValue(int r5) {
        LaneType[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        LaneType r3 = r0[r2];
        if (r3.value == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        return CPU_NORMAL;
    }

    public static boolean isValid(int r1) {
        if (r1 >= 0) goto L4;
    L6:
        return false;
    L4:
        if (r1 > 3) goto L6;
        return true;
    }

    public static LaneType min(LaneType r2, LaneType r3) {
        if (r2.value > r3.value) goto L6;
        return r2;
    L6:
        return r3;
    }

    public static LaneType negotiate(LaneType r1, LaneType r2) {
        LaneType r0 = IGNORE;
        if (r1 != r0) goto L7;
        if (r2 != r0) goto L7;
        return CPU_NORMAL;
    L7:
        if (r1 != r0) goto L9;
        return r2;
    L9:
        if (r2 != r0) goto L12;
        return r1;
    L12:
        return min(r1, r2);
    }

    public static LaneType valueOf(String r1) {
        return (LaneType) Enum.valueOf(LaneType.class, r1);
    }

    public static LaneType[] values() {
        return (LaneType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }
}
