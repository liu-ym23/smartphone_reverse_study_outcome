package com.bytedance.sdk.account.monitor;

import androidx.core.app.NotificationCompat;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.y;
import kotlin.s0.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ l[] f5647a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlin.p0.c f5648b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f5649c = null;

    static {
        f5647a = new l[]{e0.g(new y(e0.b(a.class), "monitorService", "getMonitorService()Lcom/bytedance/sdk/account/monitor/IAccountSdkMonitorService;"))};
        f5649c = new a();
        f5648b = new d.b.s.a.g0.a.b(IAccountSdkMonitorService.class);
    }

    private a() {
    }

    private final IAccountSdkMonitorService a() {
        return (IAccountSdkMonitorService) f5648b.a(this, f5647a[0]);
    }

    public static final boolean b(String r2, kotlin.n0.c.a<? extends JSONObject> r3) {
        o.g(r2, NotificationCompat.CATEGORY_EVENT);
        o.g(r3, "lazyParams");
        IAccountSdkMonitorService r0 = f5649c.a();
        return d.f5653d.i(r2, r0, r3);
    }

    public static final boolean c(String r1, JSONObject r2) {
        o.g(r1, NotificationCompat.CATEGORY_EVENT);
        return d(r1, r2, true);
    }

    public static final boolean d(String r2, JSONObject r3, boolean r4) {
        o.g(r2, NotificationCompat.CATEGORY_EVENT);
        IAccountSdkMonitorService r0 = f5649c.a();
        d r1 = d.f5653d;
        if (r3 != null) goto L7;
        r3 = new JSONObject();
    L7:
        return r1.k(r2, r3, r0, r4);
    }
}
