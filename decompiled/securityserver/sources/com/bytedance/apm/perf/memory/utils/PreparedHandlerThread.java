package com.bytedance.apm.perf.memory.utils;

import android.os.HandlerThread;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class PreparedHandlerThread extends HandlerThread {
    private PreparedCallBack preparedCallBack;

    public interface PreparedCallBack {
        void onLooperPrepared();
    }

    public PreparedHandlerThread(String r1) {
        super(r1);
    }

    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        super.onLooperPrepared();
        monitor-enter(PreparedHandlerThread.class);
        PreparedCallBack r1 = this.preparedCallBack;     // Catch: Throwable -> L7
        if (r1 == null) goto L9;
        r1.onLooperPrepared();     // Catch: Throwable -> L7
    L9:
        monitor-exit(PreparedHandlerThread.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setPreparedCallBack(PreparedCallBack r1) {
        this.preparedCallBack = r1;
    }

    public PreparedHandlerThread(String r1, int r2) {
        super(r1, r2);
    }
}
