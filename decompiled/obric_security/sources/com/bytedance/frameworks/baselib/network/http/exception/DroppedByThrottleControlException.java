package com.bytedance.frameworks.baselib.network.http.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class DroppedByThrottleControlException extends IOException {
    public DroppedByThrottleControlException() {
        super("Dropped by TTNet Throttle Control");
    }
}
