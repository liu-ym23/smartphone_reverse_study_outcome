package com.bytedance.apm.observer;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.listener.IApmLogListener;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm6.util.log.Logger;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LogObserver {
    private static final String TAG = "LogObserver";
    private static volatile LogObserver singleton;
    CopyOnWriteArraySet<IApmLogListener> logObserverList;

    private LogObserver() {
        this.logObserverList = new CopyOnWriteArraySet();
    }

    public static LogObserver getInstance() {
        if (singleton != null) goto L15;
        monitor-enter(LogObserver.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (singleton != null) goto L9;
        singleton = new LogObserver();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LogObserver.class);     // Catch: Throwable -> L11
    L15:
        return singleton;
    }

    public void notifyObservers(final String r3, final String r4, final JSONObject r5) {
        if (ApmContext.isDebugMode() == false) goto L6;
        Logger.d(TAG, "logObserverList:" + this.logObserverList.size());
    L6:
        if (this.logObserverList.size() != 0) goto L8;
        return;
    L8:
        AsyncEventManager.getInstance().submitTask(new AnonymousClass1(this, r3, r4, r5));
    }

    public void addLogObserver(IApmLogListener r1) {
        if (r1 == null) goto L8;
        this.logObserverList.add(r1);     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public void removeLogObserver(IApmLogListener r1) {
        if (r1 == null) goto L8;
        this.logObserverList.remove(r1);     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }
}
