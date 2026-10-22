package com.facebook.common.time;

import android.os.SystemClock;
import d.c.c.d.d;

/* JADX INFO: loaded from: classes.dex */
@d
public class AwakeTimeSinceBootClock implements b {

    @d
    private static final AwakeTimeSinceBootClock INSTANCE = null;

    static {
        INSTANCE = new AwakeTimeSinceBootClock();
    }

    private AwakeTimeSinceBootClock() {
    }

    @d
    public static AwakeTimeSinceBootClock get() {
        return INSTANCE;
    }

    @Override // com.facebook.common.time.b
    @d
    public long now() {
        return SystemClock.uptimeMillis();
    }
}
