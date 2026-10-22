package com.bytedance.sysoptimizer;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class EnterTransitionCrashOptimizer {
    private static Context sContext;

    public EnterTransitionCrashOptimizer() {
    }

    public static void fix(Context r0) {
        sContext = r0;
    }

    public static Context getContext() {
        return sContext;
    }
}
