package d.b.b.e.a.i;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm.w.e;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.wschannel.WsConstants;
import d.b.b.e.a.f;
import d.b.b.o.h;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile b f12617f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, d.b.b.e.a.i.a> f12618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d.b.b.e.a.i.a f12619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f12620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f12621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d.b.b.o.o.a f12622e;

    class a extends d.b.b.o.o.a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ e f12623i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ b f12624j;

        a(b r1, e r2) {
            this.f12624j = r1;
            this.f12623i = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            long r0 = this.f12623i.a();
            if (r0 == (-1)) goto L6;
            b.a(this.f12624j, r0);
            b.b(this.f12624j, System.currentTimeMillis() - r0);
        L6:
            monitor-enter(b.class);
            d.b.b.o.o.b.a(d.b.b.o.o.c.f13067g).b(b.c(this.f12624j));     // Catch: Throwable -> L10
            b.d(this.f12624j, null);     // Catch: Throwable -> L10
            monitor-exit(b.class);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    public b() {
        this.f12618a = new ConcurrentHashMap();
        this.f12620c = -1;
        this.f12621d = -1;
    }

    static /* synthetic */ long a(b r0, long r1) {
        r0.f12621d = r1;
        return r1;
    }

    static /* synthetic */ long b(b r0, long r1) {
        r0.f12620c = r1;
        return r1;
    }

    static /* synthetic */ d.b.b.o.o.a c(b r0) {
        return r0.f12622e;
    }

    static /* synthetic */ d.b.b.o.o.a d(b r0, d.b.b.o.o.a r1) {
        r0.f12622e = r1;
        return r1;
    }

    public static b f() {
        if (f12617f != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12617f != null) goto L9;
        f12617f = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f12617f;
    }

    private void h(d.b.b.e.a.i.a r3) {
        String r0 = String.valueOf(d.c());
        this.f12618a.put(r0, r3);
        this.f12619b = r3;
        c.d().f(r0, r3);
    }

    private void i(d.b.b.e.a.i.a r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r5.h()) == false) goto L7;
        r5.M(d.b.b.i.c.a.n());
    L7:
        d.b.b.i.c.b r0 = d.b.b.i.c.a.i();
        if (r0 == null) goto L10;
        r5.Q(r0.e());
    L10:
        long r1 = this.f12621d;
        if (r1 == (-1)) goto L13;
        r5.V(r1);
        r5.U(this.f12620c);
    L26:
        if (d.b.b.o.a.c() == false) goto L28;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "nptTime:" + this.f12621d + " nptOffset:" + this.f12620c);
    L28:
        r5.f0(d.b.b.i.c.a.x());
        r5.J(d.b.b.i.c.a.l());
        d.b.b.e.a.i.a r4 = this.f12619b;
        if (r4 == null) goto L34;
        r5.K(r4.B());
        return;
    L34:
        return;
    L13:
        e r2 = d.b.b.i.c.a.q();
        if (r2 == null) goto L26;
        if (this.f12622e != null) goto L26;
        monitor-enter(b.class);
        this.f12622e = new a(this, r2);     // Catch: Throwable -> L22
        d.b.b.o.o.b.a(d.b.b.o.o.c.f13067g).c(this.f12622e);     // Catch: Throwable -> L22
        monitor-exit(b.class);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public d.b.b.e.a.i.a e(String r3) {
        if (this.f12618a.containsKey(r3) == false) goto L5;
        d.b.b.e.a.i.a r4 = this.f12618a.get(r3);
    L8:
        i(r4);
        return r4;
    L5:
        d.b.b.e.a.i.a r0 = c.d().c(r3);
        if (r0 == null) goto L11;
        this.f12618a.put(r3, r0);
        r4 = r0;
        goto L8
    L11:
        return this.f12619b;
    }

    public void g() {
        d.b.b.e.a.i.a r5 = new d.b.b.e.a.i.a();
        r5.W(LocationInfoConst.SYSTEM);
        r5.P("android");
        r5.X(Build.VERSION.RELEASE);
        r5.G(Build.VERSION.SDK_INT);
        r5.O(Build.MODEL);
        r5.L(Build.BRAND);
        r5.N(Build.MANUFACTURER);
        r5.a0(d.b.b.i.c.a.m());
        r5.d0(d.b.b.i.c.a.u());
        r5.c0(h.l());
        r5.h0(f.a());
        r5.Z(d.b.b.i.c.a.o());
        r5.I(d.b.b.i.c.a.k());
        r5.F(d.b.b.i.c.a.h());
        r5.f0(d.b.b.i.c.a.x());
        r5.g0(String.valueOf(d.b.b.i.c.a.v()));
        r5.j0(d.b.b.i.c.a.z());
        r5.i0(String.valueOf(d.b.b.i.c.a.y()));
        r5.H(d.b.b.i.c.a.j());
        r5.b0(d.b.b.i.c.a.r());
        r5.Y(d.b.b.o.a.b().getPackageName());
        r5.K(r5.B());
        r5.S(d.b.b.i.c.a.p());
        r5.J(d.b.b.i.c.a.l());
        JSONObject r6 = new JSONObject();
        d.b.b.o.e.a(r6, d.b.b.i.c.a.t());     // Catch: Exception -> L19
        if (r6.has("version_code") == false) goto L7;
        r6.remove("version_code");     // Catch: Exception -> L19
    L7:
        if (r6.has(WsConstants.KEY_APP_VERSION) == false) goto L10;
        r6.remove(WsConstants.KEY_APP_VERSION);     // Catch: Exception -> L19
    L10:
        if (r6.has("uid") == false) goto L13;
        r6.remove("uid");     // Catch: Exception -> L19
    L13:
        if (r6.has("update_version_code") == false) goto L16;
        r6.remove("update_version_code");     // Catch: Exception -> L19
    L16:
        if (r6.has("manifest_version_code") == false) goto L21;
        r6.remove("manifest_version_code");     // Catch: Exception -> L19
    L21:
        r5.e0(r6);
        r5.T("5.0.21.21");
        if (d.b.b.i.c.a.A() == false) goto L24;
        c.d().a();
    L24:
        h(r5);
        return;
    L19:
        e = move-exception;
        d.b.b.o.m.b.b("APM", "header json exception" + e.toString());
        goto L21
    }
}
