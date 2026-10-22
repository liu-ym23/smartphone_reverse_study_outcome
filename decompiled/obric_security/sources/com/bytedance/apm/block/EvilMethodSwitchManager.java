package com.bytedance.apm.block;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class EvilMethodSwitchManager {
    private static List<EvilMethodSwitchListener> mListeners;

    public EvilMethodSwitchManager() {
    }

    static {
        mListeners = new ArrayList(2);
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

    public static synchronized void removeListener(EvilMethodSwitchListener r2) {
        monitor-enter(EvilMethodSwitchManager.class);
        mListeners.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(EvilMethodSwitchManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void notify(boolean r3, long r4) {
        monitor-enter(EvilMethodSwitchManager.class);
        Iterator<EvilMethodSwitchListener> r1 = mListeners.iterator();     // Catch: Throwable -> L13
    L6:
        if (r1.hasNext() == false) goto L11;
        EvilMethodSwitchListener r2 = r1.next();     // Catch: Throwable -> L13
        if (r2 == null) goto L6;
        r2.onRefresh(r3, r4);     // Catch: Throwable -> L13
        goto L6
    L11:
        monitor-exit(EvilMethodSwitchManager.class);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
