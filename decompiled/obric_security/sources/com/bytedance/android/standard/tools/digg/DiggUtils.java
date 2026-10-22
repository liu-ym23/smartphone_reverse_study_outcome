package com.bytedance.android.standard.tools.digg;

/* JADX INFO: loaded from: classes.dex */
public final class DiggUtils {
    private DiggUtils() {
    }

    public static int getSafeCount(boolean r1, int r2) {
        int r3 = Math.max(0, r2);
        if (r1 == false) goto L7;
        return r3 + 1;
    L7:
        return Math.max(0, r3 - 1);
    }
}
