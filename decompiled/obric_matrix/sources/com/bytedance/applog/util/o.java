package com.bytedance.applog.util;

import com.bytedance.bdinstall.r;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.bytedance.applog.m f2433a = null;

    static {
        com.bytedance.applog.m.b r0 = new com.bytedance.applog.m.b();
        r r1 = r.m;
        r0.j(r1);
        r0.m(new String[]{"https://log.snssdk.com/service/2/app_log/", "https://applog.snssdk.com/service/2/app_log/"});
        r0.l(new String[]{"https://rtlog.snssdk.com/service/2/app_log/", "https://rtapplog.snssdk.com/service/2/app_log/"});
        r0.n("https://log.snssdk.com/service/2/log_settings/");
        f2433a = r0.h();
        com.bytedance.applog.m.b r2 = new com.bytedance.applog.m.b();
        r2.j(r1);
        r2.m(new String[]{"https://toblog.ctobsnssdk.com/service/2/app_log/", "https://tobapplog.ctobsnssdk.com/service/2/app_log/"});
        r2.n("https://toblog.ctobsnssdk.com/service/2/log_settings/");
        r2.i("https://toblog.ctobsnssdk.com/service/2/abtest_config/");
        r2.k("https://success.ctobsnssdk.com/service/2/app_log/");
        r2.h();
    }

    public static final com.bytedance.applog.m a(int r0) {
        return f2433a;
    }
}
