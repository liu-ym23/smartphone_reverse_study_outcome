package com.bytedance.ttnet.o;

import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.b;
import com.bytedance.ttnet.e;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements d.b.h.a.a.h.o.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f6495c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ICronetAppProvider f6496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e f6497b;

    private a() {
    }

    public static a d() {
        if (f6495c != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f6495c != null) goto L9;
        f6495c = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f6495c;
    }

    @Override // d.b.h.a.a.h.o.a
    public String a() {
        e r1 = this.f6497b;
        if (r1 != null) goto L5;
        return null;
    L5:
        return r1.j().get(TTNetInit.DOMAIN_HTTPDNS_KEY);
    }

    @Override // d.b.h.a.a.h.o.a
    public String[] b() {
        Object r1 = this.f6497b;
        if ((r1 instanceof b) == true) goto L5;
        return null;
    L5:
        return ((b) r1).a();
    }

    @Override // d.b.h.a.a.h.o.a
    public String[] c() {
        Object r1 = this.f6497b;
        if ((r1 instanceof b) == true) goto L5;
        return null;
    L5:
        return ((b) r1).b();
    }

    public void e(ICronetAppProvider r1) {
        this.f6496a = r1;
    }

    public void f(e r1) {
        this.f6497b = r1;
    }

    @Override // d.b.h.a.a.h.o.a
    public List<String> getAbSdkVersion() {
        ICronetAppProvider r0 = this.f6496a;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getAbSdkVersion();
    }

    @Override // d.b.h.a.a.h.o.a
    public int getAid() {
        e r0 = this.f6497b;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getAppId();
    }

    @Override // d.b.h.a.a.h.o.a
    public void sendAppMonitorEvent(String r1, String r2) {
        ICronetAppProvider r0 = this.f6496a;
        if (r0 == null) goto L6;
        r0.sendAppMonitorEvent(r1, r2);
        return;
    }
}
