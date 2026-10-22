package com.bumptech.glide;

/* JADX INFO: loaded from: classes.dex */
public final enum MemoryCategory extends Enum<MemoryCategory> {
    private static final /* synthetic */ MemoryCategory[] $VALUES = null;
    public static final MemoryCategory HIGH = null;
    public static final MemoryCategory LOW = null;
    public static final MemoryCategory NORMAL = null;
    private final float multiplier;

    private static /* synthetic */ MemoryCategory[] $values() {
        return new MemoryCategory[]{LOW, NORMAL, HIGH};
    }

    public static MemoryCategory valueOf(String r1) {
        return (MemoryCategory) Enum.valueOf(MemoryCategory.class, r1);
    }

    public static MemoryCategory[] values() {
        return (MemoryCategory[]) $VALUES.clone();
    }

    static {
        LOW = new MemoryCategory("LOW", 0, 0.5f);
        NORMAL = new MemoryCategory("NORMAL", 1, 1.0f);
        HIGH = new MemoryCategory("HIGH", 2, 1.5f);
        $VALUES = $values();
    }

    private MemoryCategory(String r1, int r2, float r3) {
        super(r1, r2);
        this.multiplier = r3;
    }

    public float getMultiplier() {
        return this.multiplier;
    }
}
