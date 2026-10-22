package com.bytedance.apm6.hub.b.i;

import android.text.TextUtils;
import com.bytedance.news.common.service.manager.d;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import d.b.b.o.e;
import d.b.b.o.o.c;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile a f2183i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f2184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<com.bytedance.apm6.hub.b.i.b> f2185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile JSONObject f2186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f2188e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d.b.b.o.o.a f2189f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private IConfigManager f2190g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private d.b.b.o.o.a f2191h;

    /* JADX INFO: renamed from: com.bytedance.apm6.hub.b.i.a$a, reason: collision with other inner class name */
    class C0068a extends d.b.b.o.o.a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ a f2192i;

        C0068a(a r1, long r2, long r4) {
            this.f2192i = r1;
            super(r2, r4);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(d.b.b.i.c.a.n()) == false) goto L7;
            d.b.b.o.m.b.a("APM-Config", "DeviceId not ready. try again later.");
            return;
        L7:
            if (a.a(this.f2192i) != null) goto L13;
            if (d.b.b.o.a.c() == false) goto L11;
            d.b.b.o.m.b.a("APM-Config", "DeviceId ready. initConfig with device_id=" + d.b.b.i.c.a.n());
        L11:
            a.b(this.f2192i);
        L15:
            d.b.b.o.o.b.a(c.f13067g).b(a.c(this.f2192i));
            return;
        L13:
            if (d.b.b.o.a.c() == false) goto L15;
            d.b.b.o.m.b.a("APM-Config", "config is ready");
            goto L15
        }
    }

    class b implements IConfigListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f2193a;

        /* JADX INFO: renamed from: com.bytedance.apm6.hub.b.i.a$b$a, reason: collision with other inner class name */
        class C0069a extends d.b.b.o.o.a {

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ JSONObject f2194i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            final /* synthetic */ boolean f2195j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            final /* synthetic */ b f2196k;

            C0069a(b r1, JSONObject r2, boolean r3) {
                this.f2196k = r1;
                this.f2194i = r2;
                this.f2195j = r3;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.b.o.o.b.a(c.f13067g).b(a.d(this.f2196k.f2193a));     // Catch: Exception -> L7
                a.e(this.f2196k.f2193a, null);     // Catch: Exception -> L7
                a.f(this.f2196k.f2193a, this.f2194i, this.f2195j);     // Catch: Exception -> L7
                if (d.b.b.o.a.c() == false) goto L12;
                d.b.b.o.m.b.a("APM-Config", "updateCurrentConfig:" + this.f2194i);     // Catch: Exception -> L7
                return;
            L12:
                return;
            L7:
                e = move-exception;
                d.b.b.o.m.b.c("APM-Config", "onConfigChanged", e);
            }
        }

        b(a r1) {
            this.f2193a = r1;
        }

        @Override // com.bytedance.services.slardar.config.IConfigListener
        public void onReady() {
        }

        @Override // com.bytedance.services.slardar.config.IConfigListener
        public void onRefresh(JSONObject r4, boolean r5) {
            if (r4 != null) goto L16;
            return;
        L16:
            if (d.b.b.o.a.c() == false) goto L8;
            d.b.b.o.m.b.a("APM-Config", "onRefresh:" + r5 + " " + r4);     // Catch: Exception -> L15
        L8:
            if (d.b.b.i.c.a.A() == true) goto L10;
        L13:
            a.e(this.f2193a, new C0069a(this, new JSONObject(r4.toString()), r5));     // Catch: Exception -> L15
            d.b.b.o.o.b.a(c.f13067g).c(a.d(this.f2193a));     // Catch: Exception -> L15
            return;
        L10:
            if (a.a(this.f2193a) == null) goto L13;
            if (r5 == false) goto L13;
            return;
        }
    }

    private a() {
        this.f2184a = false;
    }

    static /* synthetic */ JSONObject a(a r0) {
        return r0.f2186c;
    }

    static /* synthetic */ void b(a r0) {
        r0.i();
    }

    static /* synthetic */ d.b.b.o.o.a c(a r0) {
        return r0.f2189f;
    }

    static /* synthetic */ d.b.b.o.o.a d(a r0) {
        return r0.f2191h;
    }

    static /* synthetic */ d.b.b.o.o.a e(a r0, d.b.b.o.o.a r1) {
        r0.f2191h = r1;
        return r1;
    }

    static /* synthetic */ void f(a r0, JSONObject r1, boolean r2) {
        r0.l(r1, r2);
    }

    public static a g() {
        if (f2183i != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2183i != null) goto L9;
        f2183i = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f2183i;
    }

    private void i() {
        if (this.f2190g != null) goto L5;
        this.f2190g = (IConfigManager) d.a(IConfigManager.class);
    L5:
        IConfigManager r0 = this.f2190g;
        if (r0 != null) goto L8;
        return;
    L8:
        String r1 = r0.queryConfig();
        if (d.b.b.o.a.c() == false) goto L16;
        d.b.b.o.m.b.a("APM-Config", "initConfig:" + r1);
    L16:
        if (TextUtils.isEmpty(r1) == true) goto L18;
        l(new JSONObject(r1), true);     // Catch: Exception -> L15
        return;
    L18:
        return;
    }

    private void j(JSONObject r2, boolean r3) {
        this.f2188e = true;
        List<com.bytedance.apm6.hub.b.i.b> r1 = this.f2185b;
        if (r1 == null) goto L10;
        Iterator<com.bytedance.apm6.hub.b.i.b> r4 = r1.iterator();
    L6:
        if (r4.hasNext() == false) goto L17;
        r4.next().a(r2, r3);     // Catch: Throwable -> L11
        goto L6
    L17:
        return;
    }

    private void l(JSONObject r2, boolean r3) {
        if (e.d(r2) == false) goto L5;
        return;
    L5:
        this.f2186c = r2;
        this.f2187d = r3;
        j(r2, r3);
    }

    public synchronized void h() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f2184a == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f2184a = true;     // Catch: Throwable -> L14
        if (d.b.b.i.c.a.A() == false) goto L11;
        this.f2189f = new C0068a(this, 500, 1000);     // Catch: Throwable -> L14
        d.b.b.o.o.b.a(c.f13067g).c(this.f2189f);     // Catch: Throwable -> L14
    L11:
        IConfigManager r0 = (IConfigManager) d.a(IConfigManager.class);     // Catch: Throwable -> L14
        this.f2190g = r0;     // Catch: Throwable -> L14
        r0.registerConfigListener(new b(this));     // Catch: Throwable -> L14
        monitor-exit(this);
    }

    public void k(com.bytedance.apm6.hub.b.i.b r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (this.f2185b != null) goto L8;
        this.f2185b = new CopyOnWriteArrayList();
    L8:
        if (this.f2185b.contains(r2) == true) goto L11;
        this.f2185b.add(r2);
    L11:
        if (this.f2188e == false) goto L14;
        r2.a(this.f2186c, this.f2187d);
        return;
    }
}
