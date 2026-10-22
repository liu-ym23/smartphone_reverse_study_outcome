package com.obric.matrix.q.f;

import com.obric.matrix.r.c.c;
import com.obric.matrix.r.c.e;
import kotlin.Metadata;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016J6\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/matrix/base/monitor/AppMonitorManager;", "Lcom/obric/matrix/base/monitor/IMonitor;", "()V", "TAG", "", "monitorEvent", "", "serviceName", "category", "Lorg/json/JSONObject;", "metric", "extraLog", "monitorStatusAndEvent", "status", "", "monitorStatusRate", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9854a = null;

    static {
        f9854a = new a();
    }

    private a() {
    }

    public void a(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        o.f(r2, "serviceName");
        e.a("AppMonitorManager", "monitorEvent, serviceName=" + r2 + ", category=" + r3 + ", metric=" + r4 + ", extraLog=" + r5);
    }

    public void b(String r2, int r3, JSONObject r4, JSONObject r5, JSONObject r6) {
        o.f(r2, "serviceName");
        c.b("AppMonitorManager", "monitorStatusAndEvent, serviceName=" + r2 + ", status=" + r3 + ", category=" + r4 + ", metric=" + r5 + ", extraLog=" + r6);
    }
}
