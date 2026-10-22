package com.bytedance.sdk.account.impl;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d.b.s.a.w.a f5523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d.b.s.a.w.b f5524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f5525d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f5526e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f5527f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f5528g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f5529h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f5530i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f5531j;

    public b(d.b.s.a.w.a r4, d.b.s.a.w.b r5) {
        this.f5522a = false;
        this.f5525d = 0;
        this.f5526e = 0;
        this.f5527f = 0;
        this.f5528g = 0;
        this.f5529h = false;
        this.f5530i = false;
        this.f5531j = false;
        this.f5523b = r4;
        this.f5524c = r5;
        long r0 = System.currentTimeMillis();
        if (com.bytedance.sdk.account.settings.f.a.q() == true) goto L12;
    L9:
        d(r0);
        return;
    L12:
        String r6 = Uri.parse(r4.f14944a).getPath().toLowerCase();     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r6) == true) goto L9;
        if (com.bytedance.sdk.account.settings.f.a.z(r6) == false) goto L9;
        this.f5522a = true;     // Catch: Throwable -> L11
        goto L9
    }

    private boolean a() {
        return this.f5522a;
    }

    private void f() {
        String r0 = Uri.parse(this.f5523b.f14944a).getPath().toLowerCase();     // Catch: Throwable -> L4
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L4
        r1.put("path", r0);     // Catch: Throwable -> L4
        r1.put("logid", this.f5524c.f14966f);     // Catch: Throwable -> L4
        r1.put(WsConstants.ERROR_CODE, this.f5524c.f14962b);     // Catch: Throwable -> L4
        r1.put("error_desc", this.f5524c.f14963c);     // Catch: Throwable -> L4
        r1.put("trigger_error_handler", this.f5529h);     // Catch: Throwable -> L4
        r1.put("trigger_bdturing", this.f5531j);     // Catch: Throwable -> L4
        r1.put("trigger_retry", this.f5530i);     // Catch: Throwable -> L4
        r1.put("duration_total", this.f5528g - this.f5525d);     // Catch: Throwable -> L4
        r1.put("duration_callin_beforesend", this.f5526e - this.f5525d);     // Catch: Throwable -> L4
        r1.put("duration_send_request", this.f5527f - this.f5526e);     // Catch: Throwable -> L4
        r1.put("duration_aftersend_callout", this.f5528g - this.f5527f);     // Catch: Throwable -> L4
        com.bytedance.sdk.account.monitor.c.e(r1);     // Catch: Throwable -> L4
        return;
    }

    void b(long r2) {
        if (a() == true) goto L5;
        return;
    L5:
        this.f5527f = r2;
    }

    void c(long r2) {
        if (a() == true) goto L5;
        return;
    L5:
        this.f5526e = r2;
    }

    void d(long r2) {
        if (a() == true) goto L5;
        return;
    L5:
        this.f5525d = r2;
    }

    void e(long r2) {
        if (a() == true) goto L5;
        return;
    L5:
        this.f5528g = r2;
        f();
    }
}
