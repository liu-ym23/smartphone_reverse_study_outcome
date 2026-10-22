package com.google.common.util.concurrent;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class Platform {
    static boolean isInstanceOfThrowableClass(@CheckForNull Throwable r0, Class<? extends Throwable> r1) {
        return r1.isInstance(r0);
    }

    private Platform() {
    }
}
