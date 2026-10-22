package d.b.u.b0;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.Gson;
import d.b.u.k;
import d.b.u.l;
import d.b.u.w.i;
import d.b.u.w.m;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements m {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final l<b> f15003j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f15004f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private l<d.b.u.b0.a> f15005g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final l<SharedPreferences> f15006h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<m> f15007i;

    static class a extends l<b> {
        a() {
        }

        @Override // d.b.u.l
        protected /* bridge */ /* synthetic */ b a(Object[] r1) {
            return c(r1);
        }

        protected b c(Object... r2) {
            return new b((Context) r2[0]);
        }
    }

    /* JADX INFO: renamed from: d.b.u.b0.b$b, reason: collision with other inner class name */
    class C0405b extends l<SharedPreferences> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f15008b;

        C0405b(b r1) {
            this.f15008b = r1;
        }

        @Proxy("getSharedPreferences")
        @TargetClass(scope = Scope.SELF, value = "android.content.Context")
        public static SharedPreferences c(Context r0, String r1, int r2) {
            return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
        }

        @Override // d.b.u.l
        protected /* bridge */ /* synthetic */ SharedPreferences a(Object[] r1) {
            return d(r1);
        }

        protected SharedPreferences d(Object... r2) {
            return c(b.b(this.f15008b), "byte_sync_settings", 0);
        L4:
            th = move-exception;
            th.printStackTrace();
            return null;
        }
    }

    private class c extends l<d.b.u.b0.a> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f15009b;

        private c(b r1) {
            this.f15009b = r1;
        }

        /* synthetic */ c(b r1, a r2) {
            this(r1);
        }

        @Override // d.b.u.l
        protected /* bridge */ /* synthetic */ d.b.u.b0.a a(Object[] r1) {
            return c(r1);
        }

        protected d.b.u.b0.a c(Object... r2) {
            SharedPreferences r1 = (SharedPreferences) b.c(this.f15009b).b(new Object[0]);
            String r3 = null;
            if (r1 == null) goto L5;
            r3 = r1.getString("server_settings", null);
        L5:
            if (r3 == null) goto L7;
            return (d.b.u.b0.a) new Gson().m(r3, d.b.u.b0.a.class);
        L10:
            th = move-exception;
            th.printStackTrace();
            return new d.b.u.b0.a();
        L7:
            return new d.b.u.b0.a();
        }
    }

    static {
        f15003j = new a();
    }

    public b(Context r3) {
        this.f15005g = new c(this, null);
        C0405b r0 = new C0405b(this);
        this.f15006h = r0;
        this.f15007i = new ArrayList();
        this.f15004f = r3;
        r0.b(new Object[0]);
    }

    static /* synthetic */ Context b(b r0) {
        return r0.f15004f;
    }

    static /* synthetic */ l c(b r0) {
        return r0.f15006h;
    }

    public static b g(Context r3) {
        return f15003j.b(new Object[]{r3});
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.b.u.w.m
    public void a(i.a r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        String r0 = null;
        Object[] r1 = 0;
    L25:
        e = e;
    L26:
        e.printStackTrace();
        k.c().a(r0, Log.getStackTraceString(e));
        return;
    L6:
        if (r6.f15120a != null) goto L9;
        k.c().a(null, "data is null");     // Catch: Exception -> L25
        return;
    L9:
        String r2 = new String(r6.f15120a);     // Catch: Exception -> L25
        new JSONObject(r2);     // Catch: Exception -> L23
        d.b.u.x.b.a("update local settings : " + r2);     // Catch: Exception -> L23
        int r3 = 0;
        SharedPreferences r4 = this.f15006h.b(new Object[0]);     // Catch: Exception -> L23
        if (r4 == null) goto L13;
        r4.edit().putString("server_settings", r2).apply();     // Catch: Exception -> L23
    L13:
        this.f15005g = new c(this, r1 == true ? 1 : 0);     // Catch: Exception -> L23
        List<m> r5 = this.f15007i;     // Catch: Exception -> L23
        monitor-enter(r5);     // Catch: Exception -> L23
        int r7 = this.f15007i.size();     // Catch: Throwable -> L20
        m[] r8 = new m[r7];     // Catch: Throwable -> L20
        this.f15007i.toArray(r8);     // Catch: Throwable -> L20
    L16:
        if (r3 >= r7) goto L18;
        r8[r3].a(r6);     // Catch: Throwable -> L20
        r3 = r3 + 1;     // Catch: Throwable -> L20
        goto L16
    L18:
        monitor-exit(r5);     // Catch: Throwable -> L20
    L33:
        return;
    L20:
        th = move-exception;
        throw th;     // Catch: Exception -> L23
    L23:
        e = e;
        r0 = r2;
        goto L26
    }

    public void d(m r2) {
        List<m> r0 = this.f15007i;
        monitor-enter(r0);
        this.f15007i.add(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public String e() {
        SharedPreferences r2 = this.f15006h.b(new Object[0]);
        if (r2 != null) goto L5;
        return null;
    L5:
        return r2.getString(WsConstants.KEY_DEVICE_ID, null);
    }

    public d.b.u.b0.a f() {
        return this.f15005g.b(new Object[0]);
    }

    public void h(m r2) {
        List<m> r0 = this.f15007i;
        monitor-enter(r0);
        this.f15007i.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void i(String r2) {
        SharedPreferences r1 = this.f15006h.b(new Object[0]);
        if (r1 == null) goto L5;
        r1.edit().putString(WsConstants.KEY_DEVICE_ID, r2).apply();
        return;
    L5:
        d.b.u.x.b.b("sp is null when save did " + r2);
    }
}
