package com.bytedance.ttnet.j;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaBuilder;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class f implements com.bytedance.frameworks.baselib.network.http.cronet.e.j.c {
    private static volatile f m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f6367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile int f6370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f6371e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f6372f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Keva f6373g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f6374h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f6375i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f6376j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Context f6377k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.bytedance.frameworks.baselib.network.http.cronet.c.b f6378l;

    private f(Context r5) {
        this.f6368b = false;
        this.f6369c = true;
        this.f6370d = -1;
        this.f6371e = 0;
        this.f6372f = 10800;
        this.f6375i = false;
        this.f6376j = false;
        this.f6378l = com.bytedance.frameworks.baselib.network.http.cronet.c.b.f4697h;
        KevaBuilder.getInstance().setContext(r5);
        this.f6367a = d.b.h.a.a.h.s.h.h(r5);
        this.f6373g = Keva.getRepo("tt_stack_config", 1);
        this.f6377k = r5;
    }

    private String a(String r2) {
        return this.f6374h + "_" + r2;
    }

    public static f b(Context r2) {
        if (m != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (m != null) goto L9;
        m = new f(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return m;
    }

    public void c(boolean r3, boolean r4, int r5) {
        if (this.f6367a == false) goto L6;
        this.f6373g.storeBoolean("enable_stack_opt", r3);     // Catch: Exception -> L11
        this.f6373g.storeBoolean("enable_stack_opt_fallback_fix", r4);     // Catch: Exception -> L11
        this.f6373g.storeLong("stack_opt_fallback_fix_interval_s", Long.valueOf(r5).longValue());     // Catch: Exception -> L11
    L6:
        if (this.f6375i == true) goto L8;
        return;
    L8:
        if (this.f6376j == false) goto L15;
        this.f6373g.storeInt(a("stack_opt_failures"), 0);     // Catch: Exception -> L11
        this.f6373g.storeLong(a("stack_opt_failure_timestamp"), 0);     // Catch: Exception -> L11
        return;
    L15:
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.e.j.c
    public String getThreadStackInitReason() {
        return this.f6378l.toString();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.e.j.c
    public boolean isCronetThreadStackOptFailureExpected() {
    L33:
        this.f6378l = com.bytedance.frameworks.baselib.network.http.cronet.c.b.f4701l;
        return false;
    L4:
        if (this.f6375i == false) goto L7;
        this.f6378l = com.bytedance.frameworks.baselib.network.http.cronet.c.b.f4695f;     // Catch: Exception -> L33
        return false;
    L7:
        String r3 = d.b.h.a.a.h.s.h.a(this.f6377k);     // Catch: Exception -> L33
        this.f6374h = r3;     // Catch: Exception -> L33
        if (TextUtils.isEmpty(r3) == false) goto L11;
        this.f6378l = com.bytedance.frameworks.baselib.network.http.cronet.c.b.f4696g;     // Catch: Exception -> L33
        return false;
    L11:
        this.f6375i = true;     // Catch: Exception -> L33
        this.f6368b = this.f6373g.getBoolean("enable_stack_opt", false);     // Catch: Exception -> L33
        this.f6369c = this.f6373g.getBoolean("enable_stack_opt_fallback_fix", true);     // Catch: Exception -> L33
        this.f6372f = this.f6373g.getLong("stack_opt_fallback_fix_interval_s", 10800);     // Catch: Exception -> L33
        this.f6370d = this.f6373g.getInt(a("stack_opt_failures"), 0);     // Catch: Exception -> L33
        this.f6371e = this.f6373g.getLong(a("stack_opt_failure_timestamp"), 0);     // Catch: Exception -> L33
        if (this.f6369c == false) goto L19;
        if (this.f6370d <= 0) goto L19;
        if ((System.currentTimeMillis() - this.f6371e) <= TimeUnit.SECONDS.toMillis(this.f6372f)) goto L19;
        this.f6378l = com.bytedance.frameworks.baselib.network.http.cronet.c.b.f4700k;     // Catch: Exception -> L33
        this.f6370d = 0;     // Catch: Exception -> L33
    L19:
        if (this.f6368b == false) goto L27;
        if (this.f6370d != 0) goto L27;
        this.f6373g.storeInt(a("stack_opt_failures"), this.f6370d + 1);     // Catch: Exception -> L33
        this.f6373g.storeLong(a("stack_opt_failure_timestamp"), System.currentTimeMillis());     // Catch: Exception -> L33
        this.f6376j = true;     // Catch: Exception -> L33
        if (this.f6378l == com.bytedance.frameworks.baselib.network.http.cronet.c.b.f4700k) goto L25;
        this.f6378l = com.bytedance.frameworks.baselib.network.http.cronet.c.b.f4699j;     // Catch: Exception -> L33
    L25:
        return true;
    L27:
        if (this.f6368b == true) goto L30;
        com.bytedance.frameworks.baselib.network.http.cronet.c.b r0 = com.bytedance.frameworks.baselib.network.http.cronet.c.b.f4697h;     // Catch: Exception -> L33
    L29:
        this.f6378l = r0;     // Catch: Exception -> L33
        return false;
    L30:
        r0 = com.bytedance.frameworks.baselib.network.http.cronet.c.b.f4698i;     // Catch: Exception -> L33
        goto L29
    }
}
