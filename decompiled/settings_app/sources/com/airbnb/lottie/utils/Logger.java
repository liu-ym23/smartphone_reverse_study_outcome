package com.airbnb.lottie.utils;

import com.airbnb.lottie.LottieLogger;

/* JADX INFO: loaded from: classes.dex */
public class Logger {
    private static LottieLogger INSTANCE;

    public Logger() {
    }

    static {
        INSTANCE = new LogcatLogger();
    }

    public static void setInstance(LottieLogger r0) {
        INSTANCE = r0;
    }

    public static void debug(String r1) {
        INSTANCE.debug(r1);
    }

    public static void debug(String r1, Throwable r2) {
        INSTANCE.debug(r1, r2);
    }

    public static void warning(String r1) {
        INSTANCE.warning(r1);
    }

    public static void warning(String r1, Throwable r2) {
        INSTANCE.warning(r1, r2);
    }

    public static void error(String r1, Throwable r2) {
        INSTANCE.error(r1, r2);
    }
}
