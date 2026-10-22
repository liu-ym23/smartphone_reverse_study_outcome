package com.google.common.collect;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final enum BoundType extends Enum<BoundType> {
    private static final /* synthetic */ BoundType[] $VALUES = null;
    public static final BoundType CLOSED = null;
    public static final BoundType OPEN = null;
    final boolean inclusive;

    private static /* synthetic */ BoundType[] $values() {
        return new BoundType[]{OPEN, CLOSED};
    }

    public static BoundType valueOf(String r1) {
        return (BoundType) Enum.valueOf(BoundType.class, r1);
    }

    public static BoundType[] values() {
        return (BoundType[]) $VALUES.clone();
    }

    static {
        OPEN = new BoundType("OPEN", 0, false);
        CLOSED = new BoundType("CLOSED", 1, true);
        $VALUES = $values();
    }

    private BoundType(String r1, int r2, boolean r3) {
        super(r1, r2);
        this.inclusive = r3;
    }

    static BoundType forBoolean(boolean r0) {
        if (r0 == false) goto L5;
        return CLOSED;
    L5:
        return OPEN;
    }
}
