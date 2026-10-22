package com.android.settings.utils;

/* JADX INFO: loaded from: classes2.dex */
public class CrashInfo {
    public CrashInfo() {
    }

    public static void crashInfo() {
        Thread.setDefaultUncaughtExceptionHandler(new AnonymousClass1());
    }
}
