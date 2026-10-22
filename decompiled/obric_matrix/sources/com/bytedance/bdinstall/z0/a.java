package com.bytedance.bdinstall.z0;

import android.annotation.SuppressLint;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f2908b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2909a;

    static {
    }

    private a() {
        if (f() == false) goto L8;
        String r0 = b();
        this.f2909a = r0;
        if (TextUtils.isEmpty(r0) == false) goto L9;
        this.f2909a = c();
        return;
    L9:
        return;
    }

    private static String b() {
        return d("ro.aliyun.clouduuid", "false");
    }

    private static String c() {
        return d("ro.sys.aliyun.clouduuid", "false");
    }

    private static String d(String r7, String r8) {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{r7, r8});
    L5:
        return r8;
    }

    public static a e() {
        if (f2908b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2908b != null) goto L9;
        f2908b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f2908b;
    }

    @SuppressLint({"DefaultLocale"})
    private static boolean f() {
        if (System.getProperty("java.vm.name") != null) goto L6;
    L7:
        if (System.getProperty("ro.yunos.version") != null) goto L16;
        return false;
    L16:
        return true;
    L6:
        if (System.getProperty("java.vm.name").toLowerCase().contains("lemur") == false) goto L7;
        return true;
    L17:
        return false;
    }

    public String a() {
        return this.f2909a;
    }
}
