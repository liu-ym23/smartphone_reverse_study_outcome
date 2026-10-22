package coil.decode;

import kotlin.Metadata;

/* JADX INFO: compiled from: DataSource.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcoil/decode/DataSource;", "", "(Ljava/lang/String;I)V", "MEMORY_CACHE", "MEMORY", "DISK", "NETWORK", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum DataSource extends Enum<DataSource> {
    private static final /* synthetic */ DataSource[] $VALUES = null;
    public static final DataSource DISK = null;
    public static final DataSource MEMORY = null;
    public static final DataSource MEMORY_CACHE = null;
    public static final DataSource NETWORK = null;

    private static final /* synthetic */ DataSource[] $values() {
        return new DataSource[]{MEMORY_CACHE, MEMORY, DISK, NETWORK};
    }

    public static DataSource valueOf(String r1) {
        return (DataSource) Enum.valueOf(DataSource.class, r1);
    }

    public static DataSource[] values() {
        return (DataSource[]) $VALUES.clone();
    }

    private DataSource(String r1, int r2) {
        super(r1, r2);
    }

    static {
        MEMORY_CACHE = new DataSource("MEMORY_CACHE", 0);
        MEMORY = new DataSource("MEMORY", 1);
        DISK = new DataSource("DISK", 2);
        NETWORK = new DataSource("NETWORK", 3);
        $VALUES = $values();
    }
}
