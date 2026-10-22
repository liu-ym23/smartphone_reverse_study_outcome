package com.bytedance.apm;

import com.bytedance.apm.config.FluencyConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FluencySwitchManager {
    private static List<FluencySwitchListener> mListeners;

    public FluencySwitchManager() {
    }

    static {
        mListeners = new ArrayList(2);
    }

    public static synchronized void addListener(FluencySwitchListener r2) {
        monitor-enter(FluencySwitchManager.class);
        mListeners.add(r2);     // Catch: Throwable -> L7
        monitor-exit(FluencySwitchManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void removeListener(FluencySwitchListener r2) {
        monitor-enter(FluencySwitchManager.class);
        mListeners.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(FluencySwitchManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void notify(FluencyConfig r3) {
        monitor-enter(FluencySwitchManager.class);
        Iterator<FluencySwitchListener> r1 = mListeners.iterator();     // Catch: Throwable -> L13
    L6:
        if (r1.hasNext() == false) goto L11;
        FluencySwitchListener r2 = r1.next();     // Catch: Throwable -> L13
        if (r2 == null) goto L6;
        r2.onRefresh(r3);     // Catch: Throwable -> L13
        goto L6
    L11:
        monitor-exit(FluencySwitchManager.class);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
