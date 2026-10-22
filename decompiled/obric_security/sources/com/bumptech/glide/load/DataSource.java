package com.bumptech.glide.load;

/* JADX INFO: loaded from: classes.dex */
public final enum DataSource extends Enum<DataSource> {
    private static final /* synthetic */ DataSource[] $VALUES = null;
    public static final DataSource DATA_DISK_CACHE = null;
    public static final DataSource LOCAL = null;
    public static final DataSource MEMORY_CACHE = null;
    public static final DataSource REMOTE = null;
    public static final DataSource RESOURCE_DISK_CACHE = null;

    private static /* synthetic */ DataSource[] $values() {
        return new DataSource[]{LOCAL, REMOTE, DATA_DISK_CACHE, RESOURCE_DISK_CACHE, MEMORY_CACHE};
    }

    private DataSource(String r1, int r2) {
        super(r1, r2);
    }

    public static DataSource valueOf(String r1) {
        return (DataSource) Enum.valueOf(DataSource.class, r1);
    }

    public static DataSource[] values() {
        return (DataSource[]) $VALUES.clone();
    }

    static {
        LOCAL = new DataSource("LOCAL", 0);
        REMOTE = new DataSource("REMOTE", 1);
        DATA_DISK_CACHE = new DataSource("DATA_DISK_CACHE", 2);
        RESOURCE_DISK_CACHE = new DataSource("RESOURCE_DISK_CACHE", 3);
        MEMORY_CACHE = new DataSource("MEMORY_CACHE", 4);
        $VALUES = $values();
    }
}
