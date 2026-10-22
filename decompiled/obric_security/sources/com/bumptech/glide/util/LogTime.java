package com.bumptech.glide.util;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class LogTime {
    private static final double MILLIS_MULTIPLIER = 0.0d;

    static {
        MILLIS_MULTIPLIER = 1.0d / Math.pow(10.0d, 6.0d);
    }

    private LogTime() {
    }

    public static long getLogTime() {
        return SystemClock.elapsedRealtimeNanos();
    }

    public static double getElapsedMillis(long r2) {
        return (getLogTime() - r2) * MILLIS_MULTIPLIER;
    }
}
