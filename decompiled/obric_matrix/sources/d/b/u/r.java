package d.b.u;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.Npth;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile com.bytedance.framwork.core.sdkmonitor.k f15072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f15073b;

    public static final class a implements com.bytedance.framwork.core.sdkmonitor.k.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f15074a;

        a(e r1) {
            this.f15074a = r1;
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.k.m
        public Map<String, String> getCommonParams() {
            h r0 = this.f15074a.f15024b;
            kotlin.n0.d.o.b(r0, "configuration.commonParamProvider");
            Map<String, String> r1 = r0.getCommonParams();
            kotlin.n0.d.o.b(r1, "commonParam");
            if (this.f15074a.f15031i == false) goto L5;
            String r2 = LocationInfoConst.ALLOW_USE_LOCATION;
        L6:
            r1.put("oversea", r2);
            r1.remove(WsConstants.KEY_APP_ID);
            r1.put("host_aid", this.f15074a.f15023a);
            return r1;
        L5:
            r2 = BDLocationException.ERROR_TIMEOUT;
            goto L6
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.k.m
        public String getSessionId() {
            return null;
        }
    }

    static {
    }

    public static final void a(Context r4, e r5, String r6) {
        kotlin.n0.d.o.g(r5, "configuration");
        if (TextUtils.isEmpty(r5.f15030h) == false) goto L5;
        return;
    L5:
        f15073b = true;
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L23
        r2.put(WsConstants.KEY_DEVICE_ID, r6);     // Catch: JSONException -> L9 Exception -> L23
        r2.put("host_aid", r5.f15023a);     // Catch: JSONException -> L9 Exception -> L23
        r2.put("sdk_version", "1.1.0-alpha.27");     // Catch: JSONException -> L9 Exception -> L23
    L11:
        SDKMonitorUtils.e("4119", kotlin.i0.r.d(r5.f15030h + "/monitor/collect/"));     // Catch: Exception -> L23
        SDKMonitorUtils.d("4119", kotlin.i0.r.d(r5.f15030h + "/monitor/appmonitor/v2/settings"));     // Catch: Exception -> L23
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L23
    L18:
        if (r4 == null) goto L20;
        SDKMonitorUtils.c(r4, "4119", r2, new a(r5));     // Catch: Exception -> L23
        f15072a = SDKMonitorUtils.b("4119");     // Catch: Exception -> L23
        return;
    L20:
        kotlin.n0.d.o.p();     // Catch: Exception -> L23
        throw null;
    L13:
        if (r5.f15033k == false) goto L18;
        h r7 = r5.f15024b;     // Catch: Exception -> L16
        kotlin.n0.d.o.b(r7, "configuration.commonParamProvider");     // Catch: Exception -> L16
        r2.put("channel", r7.getCommonParams().get("channel"));     // Catch: Exception -> L16
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
        f15073b = false;
    }

    public static final void b() {
        Npth.registerSdk("4119", "1.1.0-alpha.27");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public static final void c(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        kotlin.n0.d.o.g(r2, "serviceName");
        if (f15073b == false) goto L9;
        d.b.u.x.b.e("[Monitor] " + r2 + ", " + r3 + ", " + r4 + ", " + r5);
        com.bytedance.framwork.core.sdkmonitor.k r0 = f15072a;
        if (r0 == null) goto L7;
        r0.X(r2, r3, r4, r5);
        return;
    L7:
        kotlin.n0.d.o.p();
        throw null;
    }

    public static /* synthetic */ void d(String r1, JSONObject r2, JSONObject r3, JSONObject r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = null;
    L11:
        c(r1, r2, r3, r4);
    }

    public static final void e(int r6, int r7, int r8) {
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L4
        r1.put("compress_ratio", r6 / r7);     // Catch: Exception -> L4
        r1.put("compress_msg_type", r8);     // Catch: Exception -> L4
        d("sync_sdk_compress", r1, null, null, 12, null);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        g(e, null, 2, null);
    }

    public static final void f(Throwable r4, String r5) {
        kotlin.n0.d.o.g(r4, "e");
        JSONObject r0 = new JSONObject();
        d.b.u.d0.a.c(r0, "errMsg", r5);
        JSONObject r1 = new JSONObject();
        d.b.u.d0.a.c(r1, "stack", Log.getStackTraceString(r4));
        d.b.u.d0.a.c(r1, WsConstants.KEY_CONNECTION_TYPE, r4.getClass().getName());
        d.b.u.x.b.a("[Monitor] -> syncsdk_exception," + r0);
        EnsureManager.ensureNotReachHere(r4, r5);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public static /* synthetic */ void g(Throwable r0, String r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = null;
    L5:
        f(r0, r1);
    }

    public static final void h(Context r10) {
        kotlin.n0.d.o.g(r10, "context");
        long r0 = r10.getDatabasePath("bd_sync_sdk_v2.db").length();     // Catch: Exception -> L5
        com.ss.android.ug.bus.a r11 = com.ss.android.ug.bus.b.a(d.b.u.w.c.class);     // Catch: Exception -> L5
        kotlin.n0.d.o.b(r11, "UgBusFramework.getServic…CacheService::class.java)");     // Catch: Exception -> L5
        long r2 = ((d.b.u.w.c) r11).K().length();     // Catch: Exception -> L5
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L5
        r6.put("db_size", s.a(r0));     // Catch: Exception -> L5
        r6.put("file_size", s.a(r2));     // Catch: Exception -> L5
        r6.put("size", s.a(r0 + r2));     // Catch: Exception -> L5
        d("sync_sdk_storage_size", null, r6, null, 10, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        g(e, null, 2, null);
    }

    public static final void i(long r8) {
        long r0 = System.currentTimeMillis() - r8;     // Catch: Exception -> L4
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L4
        r4.put("sync_cost", r0);     // Catch: Exception -> L4
        d("sync_sdk_sync_cost", null, r4, null, 10, null);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        g(e, null, 2, null);
    }
}
