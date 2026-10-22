package kotlinx.android.extensions;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum CacheImplementation extends Enum<CacheImplementation> {
    public static final CacheImplementation b = null;
    public static final /* synthetic */ CacheImplementation[] c = null;

    @Metadata
    public static final class Companion {
    }

    static {
        CacheImplementation r0 = new CacheImplementation("SPARSE_ARRAY", 0);
        CacheImplementation r1 = new CacheImplementation("HASH_MAP", 1);
        b = r1;
        c = new CacheImplementation[]{r0, r1, new CacheImplementation("NO_CACHE", 2)};
    }

    public static CacheImplementation valueOf(String r1) {
        return (CacheImplementation) Enum.valueOf(CacheImplementation.class, r1);
    }

    public static CacheImplementation[] values() {
        return (CacheImplementation[]) c.clone();
    }
}
