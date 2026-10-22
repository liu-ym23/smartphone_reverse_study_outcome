package kotlin.reflect;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
public final class KTypeProjection {

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f344a = null;

        static {
            int[] r0 = new int[KVariance.values().length];
            r0[0] = 1;
            r0[1] = 2;
            r0[2] = 3;
            f344a = r0;
        }
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof KTypeProjection) == true) goto L8;
        return false;
    L8:
        KTypeProjection r5 = (KTypeProjection) r4;
        r5.getClass();
        r5.getClass();
        if (Intrinsics.a(null, null) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return (0 * 31) + 0;
    }

    public final String toString() {
        return "*";
    }
}
