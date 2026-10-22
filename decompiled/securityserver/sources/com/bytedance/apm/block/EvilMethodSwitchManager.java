package com.bytedance.apm.block;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class EvilMethodSwitchManager {
    private static List<EvilMethodSwitchListener> mListeners;

    static {
        mListeners = new ArrayList(2);
    }

    public EvilMethodSwitchManager() {
    }

    public static synchronized void addListener(EvilMethodSwitchListener r2) {
        monitor-enter(EvilMethodSwitchManager.class);
        mListeners.add(r2);     // Catch: Throwable -> L7
        monitor-exit(EvilMethodSwitchManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void notify(boolean r3, long r4) {
        monitor-enter(EvilMethodSwitchManager.class);
        Iterator<EvilMethodSwitchListener> r1 = mListeners.iterator();     // Catch: Throwable -> L11
    L6:
        if (r1.hasNext() == false) goto L13;
        EvilMethodSwitchListener r2 = r1.next();     // Catch: Throwable -> L11
        if (r2 == null) goto L6;
        r2.onRefresh(r3, r4);     // Catch: Throwable -> L11
        goto L6
    L13:
        monitor-exit(EvilMethodSwitchManager.class);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static synchronized void removeListener(EvilMethodSwitchListener r2) {
        monitor-enter(EvilMethodSwitchManager.class);
        mListeners.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(EvilMethodSwitchManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
