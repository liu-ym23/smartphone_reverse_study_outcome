package com.bytedance.monitor.collector.p;

import android.app.Service;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d implements Handler.Callback {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static d f5237g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static c f5238h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Map<IBinder, Service> f5239i;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Handler.Callback f5240f;

    static {
        f5237g = new d();
    }

    private d() {
    }

    public static void a() {
        f5238h = null;
    }

    public static c b() {
        return f5238h;
    }

    public static d c() {
        return f5237g;
    }

    public synchronized String d(IBinder r4) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (f5239i == null) goto L20;
    L6:
        Map<IBinder, Service> r0 = f5239i;     // Catch: Throwable -> L14
        String r1 = null;
        if (r0 != null) goto L9;
    L12:
        monitor-exit(this);
        return r1;
    L9:
        if (r0.get(r4) == null) goto L12;
        r1 = f5239i.get(r4).getClass().getName();     // Catch: Throwable -> L14
        goto L12
    L20:
        Object r2 = d.b.l.a.a.c();     // Catch: Throwable -> L17
        f5239i = (Map) a.a(r2.getClass(), "mServices").get(r2);     // Catch: Throwable -> L17
        goto L6
    }

    public void e() {
        Handler r0 = (Handler) d.b.l.a.a.f();     // Catch: Throwable -> L4
        Field r1 = a.a(Handler.class, "mCallback");     // Catch: Throwable -> L4
        this.f5240f = (Handler.Callback) r1.get(r0);     // Catch: Throwable -> L4
        r1.set(r0, this);     // Catch: Throwable -> L4
        return;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r2) {
        if (b.a(r2) == false) goto L5;
        f5238h = c.a(r2);     // Catch: Throwable -> L11
    L5:
        Handler.Callback r1 = this.f5240f;
        if (r1 != null) goto L8;
        return false;
    L8:
        return r1.handleMessage(r2);
    }
}
