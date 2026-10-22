package coil.request;

import kotlin.Metadata;

/* JADX INFO: compiled from: CachePolicy.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcoil/request/CachePolicy;", "", "readEnabled", "", "writeEnabled", "(Ljava/lang/String;IZZ)V", "getReadEnabled", "()Z", "getWriteEnabled", "ENABLED", "READ_ONLY", "WRITE_ONLY", "DISABLED", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum CachePolicy extends Enum<CachePolicy> {
    private static final /* synthetic */ CachePolicy[] $VALUES = null;
    public static final CachePolicy DISABLED = null;
    public static final CachePolicy ENABLED = null;
    public static final CachePolicy READ_ONLY = null;
    public static final CachePolicy WRITE_ONLY = null;
    private final boolean readEnabled;
    private final boolean writeEnabled;

    private static final /* synthetic */ CachePolicy[] $values() {
        return new CachePolicy[]{ENABLED, READ_ONLY, WRITE_ONLY, DISABLED};
    }

    public static CachePolicy valueOf(String r1) {
        return (CachePolicy) Enum.valueOf(CachePolicy.class, r1);
    }

    public static CachePolicy[] values() {
        return (CachePolicy[]) $VALUES.clone();
    }

    private CachePolicy(String r1, int r2, boolean r3, boolean r4) {
        super(r1, r2);
        this.readEnabled = r3;
        this.writeEnabled = r4;
    }

    public final boolean getReadEnabled() {
        return this.readEnabled;
    }

    public final boolean getWriteEnabled() {
        return this.writeEnabled;
    }

    static {
        ENABLED = new CachePolicy("ENABLED", 0, true, true);
        READ_ONLY = new CachePolicy("READ_ONLY", 1, true, false);
        WRITE_ONLY = new CachePolicy("WRITE_ONLY", 2, false, true);
        DISABLED = new CachePolicy("DISABLED", 3, false, false);
        $VALUES = $values();
    }
}
