package com.bytedance.bdinstall;

/* JADX INFO: loaded from: classes3.dex */
public final enum Level extends Enum<Level> {
    private static final /* synthetic */ Level[] $VALUES = null;
    public static final Level L0 = null;
    public static final Level L1 = null;
    private final int mLevel;

    private static /* synthetic */ Level[] $values() {
        return new Level[]{L0, L1};
    }

    public static Level valueOf(String r1) {
        return (Level) Enum.valueOf(Level.class, r1);
    }

    public static Level[] values() {
        return (Level[]) $VALUES.clone();
    }

    static {
        L0 = new Level("L0", 0, 0);
        L1 = new Level("L1", 1, 1);
        $VALUES = $values();
    }

    private Level(String r1, int r2, int r3) {
        super(r1, r2);
        this.mLevel = r3;
    }

    public int value() {
        return this.mLevel;
    }
}
