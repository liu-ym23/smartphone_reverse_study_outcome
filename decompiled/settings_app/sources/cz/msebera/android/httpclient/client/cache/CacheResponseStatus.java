package cz.msebera.android.httpclient.client.cache;

/* JADX INFO: loaded from: classes5.dex */
public final enum CacheResponseStatus extends Enum<CacheResponseStatus> {
    private static final /* synthetic */ CacheResponseStatus[] $VALUES = null;
    public static final CacheResponseStatus CACHE_HIT = null;
    public static final CacheResponseStatus CACHE_MISS = null;
    public static final CacheResponseStatus CACHE_MODULE_RESPONSE = null;
    public static final CacheResponseStatus VALIDATED = null;

    private CacheResponseStatus(String r1, int r2) {
        super(r1, r2);
    }

    public static CacheResponseStatus valueOf(String r1) {
        return (CacheResponseStatus) Enum.valueOf(CacheResponseStatus.class, r1);
    }

    public static CacheResponseStatus[] values() {
        return (CacheResponseStatus[]) $VALUES.clone();
    }

    static {
        CacheResponseStatus r0 = new CacheResponseStatus("CACHE_MODULE_RESPONSE", 0);
        CACHE_MODULE_RESPONSE = r0;
        CacheResponseStatus r1 = new CacheResponseStatus("CACHE_HIT", 1);
        CACHE_HIT = r1;
        CacheResponseStatus r3 = new CacheResponseStatus("CACHE_MISS", 2);
        CACHE_MISS = r3;
        CacheResponseStatus r5 = new CacheResponseStatus("VALIDATED", 3);
        VALIDATED = r5;
        $VALUES = new CacheResponseStatus[]{r0, r1, r3, r5};
    }
}
