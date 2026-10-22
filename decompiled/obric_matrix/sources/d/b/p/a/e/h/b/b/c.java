package d.b.p.a.e.h.b.b;

import d.b.p.a.h.d;
import d.b.p.a.h.h;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c extends d.b.p.a.e.h.a.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f14268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d.b.p.a.e.h.a.a.c f14269b;

    public c(String r1, d.b.p.a.e.h.a.a.c r2) {
        this.f14268a = r1;
        this.f14269b = r2;
    }

    public void a() {
        Class<?> r0 = Class.forName("android.os.ServiceManager");     // Catch: Exception -> L10
        Object r1 = d.c(r0, "getService", new Object[]{this.f14268a});     // Catch: Exception -> L10
        if (r1 == null) goto L13;
        Object r2 = d.b.p.a.h.a.d(r0, "sCache");     // Catch: Exception -> L10
        if (r2 != null) goto L7;
        return;
    L7:
        if ((r2 instanceof Map) == false) goto L15;
        this.f14269b.h(r1);     // Catch: Exception -> L10
        ((Map) r2).put(this.f14268a, h.a(r1, this.f14269b));     // Catch: Exception -> L10
        return;
    L15:
        return;
    L13:
        return;
    }
}
