package kotlin.random;

import kotlin.Metadata;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlatformRandom.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\t\u0010\u0000\u001a\u00020\u0001H\u0081\b\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0001H\u0007\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\bH\u0007¨\u0006\n"}, d2 = {"defaultPlatformRandom", "Lkotlin/random/Random;", "doubleFromParts", "", "hi26", "", "low27", "asJavaRandom", "Ljava/util/Random;", "asKotlinRandom", "kotlin-stdlib"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PlatformRandomKt {
    public static final double doubleFromParts(int r2, int r3) {
        return ((((long) r2) << 27) + ((long) r3)) / 9.007199254740992E15d;
    }

    public static final java.util.Random asJavaRandom(Random r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof AbstractPlatformRandom) == false) goto L5;
        AbstractPlatformRandom r0 = (AbstractPlatformRandom) r1;
    L6:
        if (r0 == null) goto L10;
        java.util.Random r2 = r0.getImpl();
        if (r2 == null) goto L10;
        return r2;
    L10:
        return new KotlinRandom(r1);
    L5:
        r0 = null;
        goto L6
    }

    public static final Random asKotlinRandom(java.util.Random r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof KotlinRandom) == false) goto L5;
        KotlinRandom r0 = (KotlinRandom) r1;
    L6:
        if (r0 == null) goto L10;
        Random r2 = r0.getImpl();
        if (r2 == null) goto L10;
        return r2;
    L10:
        return new PlatformRandom(r1);
    L5:
        r0 = null;
        goto L6
    }

    private static final Random defaultPlatformRandom() {
        return PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
    }
}
