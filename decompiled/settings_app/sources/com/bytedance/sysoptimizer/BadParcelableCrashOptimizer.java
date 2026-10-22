package com.bytedance.sysoptimizer;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class BadParcelableCrashOptimizer {
    private static Context sContext;

    public BadParcelableCrashOptimizer() {
    }

    public static void fix(Context r0) {
        sContext = r0;
    }

    public static Context getContext() {
        return sContext;
    }
}
