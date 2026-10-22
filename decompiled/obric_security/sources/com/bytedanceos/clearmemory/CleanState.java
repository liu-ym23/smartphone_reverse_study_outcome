package com.bytedanceos.clearmemory;

/* JADX INFO: loaded from: classes2.dex */
public final enum CleanState extends Enum<CleanState> {
    private static final /* synthetic */ CleanState[] $VALUES = null;
    public static final CleanState CLEANED = null;
    public static final CleanState CLEANING = null;
    public static final CleanState IDLE = null;

    private static /* synthetic */ CleanState[] $values() {
        return new CleanState[]{IDLE, CLEANING, CLEANED};
    }

    private CleanState(String $enum$name, int $enum$ordinal) {
        super($enum$name, $enum$ordinal);
    }

    public static CleanState valueOf(String name) {
        return (CleanState) Enum.valueOf(CleanState.class, name);
    }

    public static CleanState[] values() {
        return (CleanState[]) $VALUES.clone();
    }

    static {
        IDLE = new CleanState("IDLE", 0);
        CLEANING = new CleanState("CLEANING", 1);
        CLEANED = new CleanState("CLEANED", 2);
        $VALUES = $values();
    }
}
