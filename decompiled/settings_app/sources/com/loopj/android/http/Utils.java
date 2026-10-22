package com.loopj.android.http;

/* JADX INFO: loaded from: classes4.dex */
class Utils {
    private Utils() {
    }

    public static void asserts(boolean r0, String r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new AssertionError(r1);
    }

    public static <T> T notNull(T r1, String r2) {
        if (r1 == null) goto L5;
        return r1;
    L5:
        throw new IllegalArgumentException(r2 + " should not be null!");
    }
}
