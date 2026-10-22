package io.reactivex.internal.util;

/* JADX INFO: loaded from: classes2.dex */
public final class Pow2 {
    private Pow2() {
        throw new IllegalStateException("No instances!");
    }

    public static boolean isPowerOfTwo(int r1) {
        if ((r1 & (r1 - 1)) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static int roundToPowerOfTwo(int r1) {
        return 1 << (32 - Integer.numberOfLeadingZeros(r1 - 1));
    }
}
