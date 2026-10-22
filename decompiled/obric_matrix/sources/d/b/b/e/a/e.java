package d.b.b.e.a;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.common.utility.i;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e implements d.b.b.l.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile e f12590c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d.b.b.e.a.j.c f12591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f12592b;

    static {
        f12590c = new e();
    }

    private e() {
        this.f12592b = false;
    }

    private void b(JSONObject r7, boolean r8) {
    L27:
        e = move-exception;
        Log.e(a.f12571a, "addExtension", e);
        return;
    L4:
        if (TextUtils.isEmpty(d.b.b.i.c.a.s()) == true) goto L7;
        r7.put("session_id", d.b.b.i.c.a.s());     // Catch: Exception -> L27
    L7:
        if (r7.isNull("network_type") == false) goto L16;
        i.a r2 = i.j(d.b.b.o.a.b());     // Catch: Exception -> L27
        r7.put("network_type", r2.a());     // Catch: Exception -> L27
        if (r2.b() == false) goto L11;
    L12:
        int r0 = d.b.b.o.g.a(d.b.b.o.a.b());     // Catch: Exception -> L27
        if (r0 == (-10000)) goto L16;
        r7.put("network_type_code", r0);     // Catch: Exception -> L27
        goto L16
    L11:
        if (r2.c() == true) goto L12;
    L16:
        if (r7.isNull("timestamp") == false) goto L18;
    L19:
        r7.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L27
    L21:
        if (r7.isNull(WsConstants.KEY_SESSION_ID) == false) goto L23;
        r7.put(WsConstants.KEY_SESSION_ID, d.b.b.i.c.a.u());     // Catch: Exception -> L27
    L23:
        r7.put("process_name", d.b.b.i.c.a.m());     // Catch: Exception -> L27
        if (r8 == false) goto L32;
        r7.put("seq_no", d.a().b());     // Catch: Exception -> L27
        return;
    L32:
        return;
    L18:
        if (r7.optLong("timestamp") > 0) goto L21;
        goto L19
    }

    private synchronized void c() {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.f12592b == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (d.b.b.o.a.c() == false) goto L11;
        d.b.b.o.m.b.a(a.f12571a, "Initializing SlardarHandler...");     // Catch: Throwable -> L19
    L11:
        if (com.bytedance.apm.x.a.c() == null) goto L13;
        com.bytedance.apm.x.a.c().a(a.f12571a, "ensureInited");     // Catch: Throwable -> L19
    L13:
        d.b.b.e.a.i.b.f().g();     // Catch: Throwable -> L19
        d.b.b.e.a.k.h.a.a().b(d.b.b.o.a.b());     // Catch: Throwable -> L19
        d.b.b.e.a.h.b r0 = (d.b.b.e.a.h.b) d.b.b.n.c.a(d.b.b.e.a.h.b.class);     // Catch: Throwable -> L19
        if (r0 == null) goto L16;
        e(r0.getConfig());     // Catch: Throwable -> L19
    L16:
        this.f12591a = new d.b.b.e.a.j.c(d.b.b.e.a.i.d.c(), b.d(), b.b());     // Catch: Throwable -> L19
        c.h().q(this.f12591a);     // Catch: Throwable -> L19
        d.b.b.e.a.l.c.g().f(c.h());     // Catch: Throwable -> L19
        d.b.b.e.a.l.c.g().f(d.b.b.e.a.k.d.j());     // Catch: Throwable -> L19
        d.b.b.e.a.l.c.g().h();     // Catch: Throwable -> L19
        c.h().i();     // Catch: Throwable -> L19
        d.b.b.e.a.k.d.j().k();     // Catch: Throwable -> L19
        this.f12592b = true;     // Catch: Throwable -> L19
        monitor-exit(this);
    }

    public static e d() {
        return f12590c;
    }

    @Override // d.b.b.l.c
    public void a(d.b.b.l.b r5) {
        if (this.f12592b == true) goto L5;
        c();
    L5:
        JSONObject r0 = r5.c();
        if (a.f12572b.contains(r5.a()) == false) goto L8;
    L17:
        b(r0, false);
    L19:
        if (d.b.b.o.a.c() == false) goto L21;
        com.bytedance.apm.doctor.a.b(r5.a(), r0, true);
    L21:
        this.f12591a.i(r0);
        return;
    L8:
        if ("tracing".equals(r5.a()) == true) goto L17;
        if (d.b.b.e.a.k.h.a.a().d(r0, d.b.b.i.c.a.h()) == false) goto L13;
        b(r0, true);
        goto L19
    L13:
        if (d.b.b.o.a.c() == false) goto L23;
        com.bytedance.apm.doctor.a.a(r5.a(), r0);
        d.b.b.o.m.b.a(a.f12571a, "push failed: event(aid=" + d.b.b.i.c.a.h() + " is downgraded: " + r0.toString());
        return;
    }

    public synchronized void e(d.b.b.e.a.h.a r5) {
        monitor-enter(this);
        if (r5 == null) goto L6;
        d.b.b.e.a.k.c.e().t(r5);     // Catch: Throwable -> L10
        c.h().o(r5.g());     // Catch: Throwable -> L10
        c.h().p(r5.f());     // Catch: Throwable -> L10
        d.b.b.e.a.l.c.g().j(r5.d(), r5.c(), r5.e());     // Catch: Throwable -> L10
        d.b.b.e.a.k.e.l(r5.a());     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L6:
        if (d.b.b.o.a.c() == false) goto L8;
        d.b.b.o.m.b.a(a.f12571a, "setSlardarHandlerConfig:" + r5);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
    }
}
