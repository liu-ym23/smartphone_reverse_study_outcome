package com.bytedance.apm.a0.i;

import android.app.Application;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f1185a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f1186b = false;

    static {
        f1185a = new a();
    }

    public a() {
    }

    public static void a(Application r1, com.bytedance.apm.config.a r2) {
        if (r1 == null) goto L10;
        if (r2 != null) goto L6;
        return;
    L6:
        if (f1186b == false) goto L8;
        return;
    L8:
        f1186b = true;
        f1185a.b(r1, r2);
        throw null;
    }

    public void b(Application r1, com.bytedance.apm.config.a r2) {
        r2.a();
        throw null;
    }
}
