package com.obric.dejavu.library;

import kotlin.Metadata;

/* JADX INFO: compiled from: IndexUpgradeStrategy.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/dejavu/library/IndexUpgradeStrategy;", "", "data", "", "(Ljava/lang/String;II)V", "getData", "()I", "NoUpgrade", "Open", "Insert", "Manual", "BackgroundThread", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum IndexUpgradeStrategy extends Enum<IndexUpgradeStrategy> {
    private static final /* synthetic */ IndexUpgradeStrategy[] $VALUES = null;
    public static final IndexUpgradeStrategy BackgroundThread = null;
    public static final IndexUpgradeStrategy Insert = null;
    public static final IndexUpgradeStrategy Manual = null;
    public static final IndexUpgradeStrategy NoUpgrade = null;
    public static final IndexUpgradeStrategy Open = null;
    private final int data;

    private static final /* synthetic */ IndexUpgradeStrategy[] $values() {
        return new IndexUpgradeStrategy[]{NoUpgrade, Open, Insert, Manual, BackgroundThread};
    }

    public static IndexUpgradeStrategy valueOf(String r1) {
        return (IndexUpgradeStrategy) Enum.valueOf(IndexUpgradeStrategy.class, r1);
    }

    public static IndexUpgradeStrategy[] values() {
        return (IndexUpgradeStrategy[]) $VALUES.clone();
    }

    private IndexUpgradeStrategy(String r1, int r2, int r3) {
        super(r1, r2);
        this.data = r3;
    }

    public final int getData() {
        return this.data;
    }

    static {
        NoUpgrade = new IndexUpgradeStrategy("NoUpgrade", 0, 0);
        Open = new IndexUpgradeStrategy("Open", 1, 1);
        Insert = new IndexUpgradeStrategy("Insert", 2, 2);
        Manual = new IndexUpgradeStrategy("Manual", 3, 4);
        BackgroundThread = new IndexUpgradeStrategy("BackgroundThread", 4, 8);
        $VALUES = $values();
    }
}
