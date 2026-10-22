package com.bytedance.news.common.settings.h;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Context f5323a;

    private a() {
    }

    public static void a() {
        if (f5323a == null) goto L5;
        return;
    L5:
        monitor-enter(a.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (f5323a == null) goto L11;
        monitor-exit(a.class);     // Catch: Throwable -> L12
        return;
    L11:
        throw new IllegalStateException("SettingsManager尚未被配置");     // Catch: Throwable -> L12
    }

    public static Context b() {
        a();
        return f5323a;
    }

    public static synchronized void c(Context r2) {
        monitor-enter(a.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f5323a == null) goto L7;
    L11:
        monitor-exit(a.class);
        return;
    L7:
        if ((r2 instanceof Application) == false) goto L9;
    L8:
        f5323a = r2;     // Catch: Throwable -> L13
        goto L11
    L9:
        r2 = r2.getApplicationContext();     // Catch: Throwable -> L13
        goto L8
    }
}
