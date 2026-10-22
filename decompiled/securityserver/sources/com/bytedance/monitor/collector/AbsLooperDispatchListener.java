package com.bytedance.monitor.collector;

import android.os.Message;
import androidx.annotation.CallSuper;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsLooperDispatchListener {
    public static long cpuTime;
    public static long uptime;
    public volatile boolean isHasDispatchStart;

    public AbsLooperDispatchListener() {
        this.isHasDispatchStart = false;
    }

    @CallSuper
    public void dispatchEnd(String r1) {
    }

    @CallSuper
    public void dispatchStart(String r1) {
        this.isHasDispatchStart = true;
    }

    public boolean isValid() {
        return false;
    }

    @CallSuper
    public void dispatchEnd(String r1, Message r2) {
        this.isHasDispatchStart = false;
        dispatchEnd(r1);
    }
}
