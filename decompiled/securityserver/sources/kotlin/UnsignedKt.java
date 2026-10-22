package kotlin;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@JvmName
public final class UnsignedKt {
    public static final int a(int r1, int r2) {
        return Intrinsics.h(r1 ^ Integer.MIN_VALUE, r2 ^ Integer.MIN_VALUE);
    }

    public static final int b(long r2, long r4) {
        long r3 = r2 ^ Long.MIN_VALUE;
        long r5 = r4 ^ Long.MIN_VALUE;
        if (r3 >= r5) goto L5;
        return -1;
    L5:
        if (r3 != r5) goto L7;
        return 0;
    L7:
        return 1;
    }

    public static final long c(long r5, long r7) {
        if (r7 >= 0) goto L10;
        if (b(r5, r7) >= 0) goto L8;
        return r5;
    L8:
        return r5 - r7;
    L10:
        if (r5 >= 0) goto L12;
        long r6 = r5 - ((((r5 >>> 1) / r7) << 1) * r7);
        if (b(r6, r7) >= 0) goto L18;
        r7 = 0;
    L18:
        return r6 - r7;
    L12:
        return r5 % r7;
    }
}
