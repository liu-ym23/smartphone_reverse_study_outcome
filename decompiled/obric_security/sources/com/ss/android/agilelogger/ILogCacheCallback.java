package com.ss.android.agilelogger;

import java.util.Queue;

/* JADX INFO: loaded from: classes4.dex */
public interface ILogCacheCallback {
    Queue<LogItem> getCachedLog();

    void notifyCacheLogConsumed();
}
