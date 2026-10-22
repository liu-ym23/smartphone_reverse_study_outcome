package com.facebook.common.time;

import android.os.SystemClock;
import d.c.c.d.d;

/* JADX INFO: loaded from: classes.dex */
@d
public class RealtimeSinceBootClock implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final RealtimeSinceBootClock f6624a = null;

    static {
        f6624a = new RealtimeSinceBootClock();
    }

    private RealtimeSinceBootClock() {
    }

    @d
    public static RealtimeSinceBootClock get() {
        return f6624a;
    }

    @Override // com.facebook.common.time.b
    public long now() {
        return SystemClock.elapsedRealtime();
    }
}
