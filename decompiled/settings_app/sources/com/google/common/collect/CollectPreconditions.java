package com.google.common.collect;

import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class CollectPreconditions {
    CollectPreconditions() {
    }

    static void checkEntryNotNull(Object r2, Object r3) {
        if (r2 == null) goto L7;
        if (r3 == null) goto L5;
        return;
    L5:
        String r4 = String.valueOf(r2);
        throw new NullPointerException(new StringBuilder(String.valueOf(r4).length() + 26).append("null value in entry: ").append(r4).append("=null").toString());
    L7:
        String r5 = String.valueOf(r3);
        throw new NullPointerException(new StringBuilder(String.valueOf(r5).length() + 24).append("null key in entry: null=").append(r5).toString());
    }

    static int checkNonnegative(int r3, String r4) {
        if (r3 < 0) goto L5;
        return r3;
    L5:
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(r4).length() + 40).append(r4).append(" cannot be negative but was: ").append(r3).toString());
    }

    static long checkNonnegative(long r3, String r5) {
        if (r3 < 0) goto L6;
        return r3;
    L6:
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(r5).length() + 49).append(r5).append(" cannot be negative but was: ").append(r3).toString());
    }

    static void checkPositive(int r3, String r4) {
        if (r3 <= 0) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(r4).length() + 38).append(r4).append(" must be positive but was: ").append(r3).toString());
    }

    static void checkRemove(boolean r1) {
        Preconditions.checkState(r1, "no calls to next() since the last call to remove()");
    }
}
