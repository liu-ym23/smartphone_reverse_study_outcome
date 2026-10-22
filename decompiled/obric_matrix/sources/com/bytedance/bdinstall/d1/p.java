package com.bytedance.bdinstall.d1;

import android.os.SystemProperties;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Object f2740a;

    public p() {
    }

    private Object b() {
        if (f2740a != null) goto L15;
        monitor-enter(p.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2740a == null) goto L17;
    L9:
        monitor-exit(p.class);     // Catch: Throwable -> L11
        goto L15
    L17:
        f2740a = Class.forName("android.os.SystemProperties").newInstance();     // Catch: Throwable -> L16
    L15:
        return f2740a;
    }

    public String a(String r7) {
        return SystemProperties.get(r7);
    L4:
        Object r6 = b();     // Catch: Throwable -> L6 IllegalArgumentException -> L8
    L13:
        return (String) r6.getClass().getMethod("get", new Class[]{String.class}).invoke(r6, new Object[]{r7});
    L8:
        e = move-exception;
        throw e;
    L6:
        return "";
    }
}
