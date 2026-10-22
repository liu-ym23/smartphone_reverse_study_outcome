package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FallbackThreadLocalRandom extends AbstractPlatformRandom {
    public final FallbackThreadLocalRandom$implStorage$1 e;

    public FallbackThreadLocalRandom() {
        this.e = new FallbackThreadLocalRandom$implStorage$1();
    }

    @Override // kotlin.random.AbstractPlatformRandom
    public final java.util.Random c() {
        java.util.Random r1 = this.e.get();
        Intrinsics.e(r1, "implStorage.get()");
        return r1;
    }
}
