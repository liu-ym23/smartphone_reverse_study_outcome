package com.bytedance.monitor.collector;

import android.os.Message;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsLooperDispatchListener {
    public static long cpuTime;
    public static long uptime;
    public volatile boolean isHasDispatchStart;

    static {
    }

    public void dispatchEnd(String r1) {
    }

    public boolean isValid() {
        return false;
    }

    public AbsLooperDispatchListener() {
        this.isHasDispatchStart = false;
    }

    public void dispatchStart(String r1) {
        this.isHasDispatchStart = true;
    }

    public void dispatchEnd(String r1, Message r2) {
        this.isHasDispatchStart = false;
        dispatchEnd(r1);
    }
}
