package kotlin.random.jdk8;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.AbstractPlatformRandom;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class PlatformThreadLocalRandom extends AbstractPlatformRandom {
    @Override // kotlin.random.AbstractPlatformRandom
    public final Random c() {
        ThreadLocalRandom r1 = ThreadLocalRandom.current();
        Intrinsics.e(r1, "current()");
        return r1;
    }
}
