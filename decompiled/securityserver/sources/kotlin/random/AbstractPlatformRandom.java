package kotlin.random;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class AbstractPlatformRandom extends Random {
    public AbstractPlatformRandom() {
    }

    @Override // kotlin.random.Random
    public final int a(int r2) {
        return (c().nextInt() >>> (32 - r2)) & ((-r2) >> 31);
    }

    @Override // kotlin.random.Random
    public final int b() {
        return c().nextInt();
    }

    public abstract java.util.Random c();
}
