package com.squareup.leakcanary;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes5.dex */
public final class LeakCanary {
    public static boolean isInAnalyzerProcess(Context r0) {
        return false;
    }

    public static RefWatcher install(Application r0) {
        return RefWatcher.DISABLED;
    }

    public static RefWatcher installedRefWatcher() {
        return RefWatcher.DISABLED;
    }

    private LeakCanary() {
        throw new AssertionError();
    }
}
