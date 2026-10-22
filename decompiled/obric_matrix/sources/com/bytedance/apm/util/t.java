package com.bytedance.apm.util;

import android.content.Context;
import java.io.InputStream;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Properties f2079a;

    public static String a() {
        return String.valueOf(b("release_build"));
    }

    private static Object b(String r2) {
        c();
        Properties r1 = f2079a;     // Catch: Exception -> L9
        if (r1 != null) goto L6;
        return null;
    L6:
        if (r1.containsKey(r2) == false) goto L13;
        return f2079a.get(r2);
    L13:
        return null;
    L14:
        return null;
    }

    private static void c() {
        Context r0 = com.bytedance.apm.d.h();
        if (f2079a != null) goto L15;
        f2079a = new Properties();
        InputStream r1 = r0.getApplicationContext().getAssets().open("slardar.properties");     // Catch: Throwable -> L8
        f2079a.load(r1);     // Catch: Throwable -> L16
    L10:
        d.b.b.o.d.a(r1);
        return;
    L21:
        f2079a = null;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        d.b.b.o.d.a(r1);
        throw th;
    L8:
        r1 = null;
        goto L21
    }
}
