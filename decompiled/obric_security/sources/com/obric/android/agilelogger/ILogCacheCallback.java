package com.obric.android.agilelogger;

import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public interface ILogCacheCallback {
    Queue<LogItem> getCachedLog();

    void notifyCacheLogConsumed();
}
