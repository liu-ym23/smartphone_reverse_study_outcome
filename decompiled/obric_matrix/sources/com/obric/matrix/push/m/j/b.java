package com.obric.matrix.push.m.j;

import kotlin.Metadata;
import kotlin.h;
import kotlin.i;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0004H\u0007J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/obric/matrix/push/base/monitor/MonitorEvent;", "", "()V", "MONITOR_REGISTER_METHOD", "", "MONITOR_REGISTER_SERVICE", "", "MONITOR_UNREGISTER_METHOD", "MONITOR_UNREGISTER_SERVICE", "mMonitor", "Lcom/obric/matrix/push/base/monitor/IPushMonitorService;", "getMMonitor", "()Lcom/obric/matrix/push/base/monitor/IPushMonitorService;", "mMonitor$delegate", "Lkotlin/Lazy;", "monitor", "", "serviceName", "method", "originPkgName", "reqResult", "monitorRegister", "result", "monitorUnRegister", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9712a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final h f9713b = null;

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/obric/matrix/push/base/monitor/IPushMonitorService;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements kotlin.n0.c.a<com.obric.matrix.push.m.j.a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f9714f = null;

        static {
            f9714f = new a();
        }

        a() {
            super(0);
        }

        public final com.obric.matrix.push.m.j.a a() {
            return com.obric.matrix.push.m.b.f9633a.z();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ com.obric.matrix.push.m.j.a invoke() {
            return a();
        }
    }

    static {
        f9712a = new b();
        f9713b = i.b(a.f9714f);
    }

    private b() {
    }

    private final com.obric.matrix.push.m.j.a a() {
        return (com.obric.matrix.push.m.j.a) f9713b.getValue();
    }

    private final void b(String r3, int r4, String r5, int r6) {
        JSONObject r0 = new JSONObject();
        r0.put("method", r4);
        r0.put("origin_pkg", r5);
        r0.put("result", r6);
        a().monitorEvent(r3, r0, null, null);
    }

    public static final void c(String r3, int r4) {
        o.f(r3, "originPkgName");
        f9712a.b("push_service_register", 1, r3, r4);
    }
}
