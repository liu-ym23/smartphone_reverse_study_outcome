package com.bytedance.monitor.util.thread;

/* JADX INFO: loaded from: classes3.dex */
public interface ThreadLogListener {
    boolean isDebug();

    void onError(String r1, String r2);

    void onLog(String r1, String r2);
}
