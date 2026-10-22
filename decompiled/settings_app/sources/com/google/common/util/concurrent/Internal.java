package com.google.common.util.concurrent;

import java.time.Duration;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class Internal {
    static long toNanosSaturated(Duration r2) {
        return r2.toNanos();
    L5:
        if (r2.isNegative() == false) goto L7;
        return Long.MIN_VALUE;
    L7:
        return Long.MAX_VALUE;
    }

    private Internal() {
    }
}
