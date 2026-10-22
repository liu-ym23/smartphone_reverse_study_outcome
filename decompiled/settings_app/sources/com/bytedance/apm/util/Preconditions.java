package com.bytedance.apm.util;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public final class Preconditions {
    public static <T> T checkNotNull(T r1, String r2) {
        if (r1 == null) goto L5;
        return r1;
    L5:
        throw new NullPointerException(r2 + " must not be null");
    }

    public static String checkNotEmpty(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == true) goto L6;
        return r1;
    L6:
        throw new IllegalArgumentException(r2 + " must not be empty");
    }

    public static String checkNotEmptySafely(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        Log.w("apm", r2 + " is empty, please make sure");
    L5:
        return r1;
    }

    private Preconditions() {
        throw new AssertionError();
    }
}
