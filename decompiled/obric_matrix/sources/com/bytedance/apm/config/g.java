package com.bytedance.apm.config;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.apm.util.i;
import com.bytedance.apm.util.l;
import com.bytedance.apm.util.q;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.obric.matrix.common_api.INetworkApi;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.GZIPOutputStream;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g implements com.bytedance.apm.f0.b.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f1450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f1451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile JSONObject f1452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile JSONObject f1453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile JSONObject f1454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<String> f1455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile long f1456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile SharedPreferences f1457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.bytedance.apm.core.d f1458i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private JSONObject f1459j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f1460k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f1461l;
    private long m;
    private long n;
    private volatile boolean o;
    private boolean p;
    private boolean q;
    private volatile long r;
    private volatile long s;
    private List<IConfigListener> t;

    class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f1462a;

        /* JADX INFO: renamed from: com.bytedance.apm.config.g$a$a, reason: collision with other inner class name */
        class RunnableC0043a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ a f1463f;

            RunnableC0043a(a r1) {
                this.f1463f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                g.c(this.f1463f.f1462a);     // Catch: Throwable -> L4
                return;
            }
        }

        a(g r1) {
            this.f1462a = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r5, Intent r6) {
            if (r6 == null) goto L17;
            String r7 = r6.getStringExtra("PROCESS_NAME");     // Catch: Throwable -> L14
            String r8 = q.a(com.bytedance.apm.d.h());     // Catch: Throwable -> L14
            if (com.bytedance.apm.d.C() == false) goto L7;
            com.bytedance.apm.x.e.d("apm_initializing", new String[]{"BroadcastReceiver.onReceive, processName:", r7, "currentProcessName:", r8});     // Catch: Throwable -> L14
        L7:
            if (TextUtils.isEmpty(r7) == false) goto L9;
            return;
        L9:
            if (TextUtils.isEmpty(r8) == false) goto L11;
            return;
        L11:
            if (r7.equals(r8) == true) goto L20;
            com.bytedance.apm.f0.b.f().i(new RunnableC0043a(this));     // Catch: Throwable -> L14
            return;
        L20:
            return;
        L21:
            return;
        }
    }

    class b implements Runnable {
        b(g r1) {
        }

        @Override // java.lang.Runnable
        public void run() {
            Intent r2 = new Intent("com.apm.setting.update.action");     // Catch: Exception -> L6
            r2.putExtra("PROCESS_NAME", q.a(com.bytedance.apm.d.h()));     // Catch: Exception -> L6
            com.bytedance.apm.d.h().sendBroadcast(r2);     // Catch: Exception -> L6
            if (com.bytedance.apm.d.C() == false) goto L9;
            com.bytedance.apm.x.e.d("apm_initializing", new String[]{"BroadcastReceiver.sendBroadUpdateSetting"});     // Catch: Exception -> L6
            return;
        L9:
            return;
        }
    }

    class c implements com.bytedance.monitor.collector.h.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f1464a;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ long f1465f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ c f1466g;

            a(c r1, long r2) {
                this.f1466g = r1;
                this.f1465f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
                r0.put("looper_monitor", this.f1465f);     // Catch: JSONException -> L4
                JSONObject r1 = new JSONObject();     // Catch: JSONException -> L4
                r1.put("is_main_process", g.d(this.f1466g.f1464a));     // Catch: JSONException -> L4
                com.bytedance.apm.c.l("apm_cost", r1, r0, null);     // Catch: JSONException -> L4
                return;
            }
        }

        c(g r1) {
            this.f1464a = r1;
        }

        @Override // com.bytedance.monitor.collector.h.c
        public void a(long r3) {
            com.bytedance.apm.f0.b.f().i(new a(this, r3));
        }
    }

    g() {
        this.f1451b = false;
        this.f1455f = com.bytedance.apm.s.a.f1952a;
        this.f1456g = 1200;
        this.f1461l = -1;
        this.m = 60000;
        this.n = -1;
        this.o = false;
    }

    private void A(boolean r13) {
        if (com.bytedance.apm.d.C() == false) goto L6;
        com.bytedance.apm.x.e.d("apm_initializing", new String[]{"SlardarConfigFetcher.queryFromNet." + u() + " " + v(System.currentTimeMillis())});
        DoctorManager r0 = DoctorManager.getInstance();
        StringBuilder r5 = new StringBuilder();
        r5.append("queryFromNet:");
        r5.append(r13);
        r0.b("APM_SETTING_UPDATE_FROM_NET", r5.toString());
    L6:
        if (u() == false) goto L11;
        if (r13 == false) goto L9;
    L10:
        boolean r14 = true;
    L12:
        if (r14 == true) goto L15;
        return;
    L15:
        if (l.b(com.bytedance.apm.d.h()) == false) goto L17;
        com.bytedance.apm.core.d r15 = this.f1458i;
        if (r15 == null) goto L60;
        if (r15.a() == null) goto L60;
        if (this.f1458i.a().isEmpty() == true) goto L60;
        if (this.r != 0) goto L31;
        this.r = this.f1457h.getLong("monitor_last_calculate_timestamp_v5", 0);
    L31:
        if (this.s != 0) goto L33;
        this.s = this.f1457h.getLong("monitor_last_full_calculate_timestamp_v5", 0);
    L33:
        this.n = System.currentTimeMillis();
        Iterator<String> r16 = this.f1455f.iterator();
        boolean r6 = false;
    L35:
        if (r16.hasNext() == false) goto L54;
        String r7 = r16.next();
        JSONObject r8 = E();     // Catch: Throwable -> L50
        String r9 = com.bytedance.apm.d.k().optString(WsConstants.KEY_APP_ID);     // Catch: Throwable -> L50
        HashMap r10 = new HashMap();     // Catch: Throwable -> L50
        r10.put(INetworkApi.CONTENT_TYPE, INetworkApi.DEFAULT_CONTENT_TYPE);     // Catch: Throwable -> L50
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L50
        if (TextUtils.isEmpty(r9) == false) goto L40;
    L42:
        com.bytedance.apm.impl.a r12 = new com.bytedance.apm.impl.a(r7, r10, f(r11.toString().getBytes(), r10));     // Catch: Throwable -> L50
        HttpResponse r17 = com.bytedance.apm.d.d(r12.f1597a, r12.f1599c, r12.f1598b);     // Catch: Throwable -> L50
        if (com.bytedance.apm.d.C() == false) goto L45;
        DoctorManager.getInstance().b("APM_SETTING_UPDATE_FROM_NET_REQUEST", r12.f1597a);     // Catch: Throwable -> L50
    L45:
        r6 = p(r17);     // Catch: Throwable -> L50
        if (com.bytedance.apm.d.C() == false) goto L48;
        com.bytedance.apm.x.e.d("apm_initializing", new String[]{"SlardarConfigFetcher.queryFromNet.fetchResult: " + r17.getResponseBytes().length + " " + r6});     // Catch: Throwable -> L50
    L48:
        if (r6 == false) goto L35;
    L40:
        if (r9.equals(BDLocationException.ERROR_TIMEOUT) == true) goto L42;
        r11.put(r9, r8);     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        if (com.bytedance.apm.d.C() == false) goto L35;
        DoctorManager.getInstance().b("APM_SETTING_UPDATE_FROM_NET_ERROR", "queFromNetError:" + th);
    L54:
        if (r6 == true) goto L56;
        long r1 = Math.min(this.m * 2, 600000);
    L57:
        this.m = r1;
        return;
    L56:
        r1 = 60000;
    L60:
        if (com.bytedance.apm.d.C() == false) goto L74;
        com.bytedance.apm.x.e.d("apm_initializing", new String[]{"SlardarConfigFetcher.queryFromNet.ParamsEmpty"});
        DoctorManager.getInstance().b("APM_SETTING_UPDATE_FROM_NET_ERROR", "mQueryParams not available");
        return;
    L74:
        return;
    L17:
        if (com.bytedance.apm.d.C() == false) goto L73;
        com.bytedance.apm.x.e.d("apm_initializing", new String[]{"SlardarConfigFetcher.queryFromNet.NetworkUnavailable"});
        DoctorManager.getInstance().b("APM_SETTING_UPDATE_FROM_NET_ERROR", "network not available");
        return;
    L73:
        return;
    L9:
        if (v(System.currentTimeMillis()) == true) goto L10;
    L11:
        r14 = false;
        goto L12
    }

    private long B() {
        return this.f1457h.getLong("monitor_configure_refresh_time", 0);
    }

    private void C() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction("com.apm.setting.update.action");
        a r1 = new a(this);
        if (com.bytedance.apm.d.h() == null) goto L16;
    L9:
        th = move-exception;
        d.b.b.o.m.b.c("SlardarConfigFetcher", "registerBroadUpdateSetting", th);
        return;
    L5:
        if (Build.VERSION.SDK_INT <= 33) goto L7;
        b(com.bytedance.apm.d.h(), r1, r0, 2);     // Catch: Throwable -> L9
    L12:
        return;
    L7:
        a(com.bytedance.apm.d.h(), r1, r0);     // Catch: Throwable -> L9
        goto L12
    }

    private void F(JSONObject r7) {
        JSONObject r6 = r7.optJSONObject("general");
        boolean r0 = true;
        if (r6 == null) goto L5;
        com.bytedance.apm.internal.a.i(32, !r6.optBoolean("enable_salvage_log", true));
    L5:
        JSONObject r1 = com.bytedance.apm.util.h.f(r7, "performance_modules", "smooth");
        if (r1 != null) goto L8;
    L20:
        JSONObject r8 = com.bytedance.apm.util.h.f(r7, "performance_modules", "start_trace");
        if (r8 != null) goto L23;
    L35:
        if (r1 != null) goto L37;
        if (r8 != null) goto L37;
        return;
    L37:
        com.bytedance.apm.internal.a.f();
        return;
    L23:
        if (r8.optInt("enable_perf_data_collect", 0) != 1) goto L25;
        boolean r3 = true;
    L26:
        com.bytedance.apm.internal.a.i(4, r3);
        if (r8.optInt("enable_lock_data_collect", 0) != 1) goto L29;
        boolean r4 = true;
    L30:
        com.bytedance.apm.internal.a.i(8, r4);
        if (r8.optInt("enable_long_sleep_data_collect", 0) == 1) goto L34;
        r0 = false;
    L34:
        com.bytedance.apm.internal.a.i(16, r0);
        goto L35
    L29:
        r4 = false;
        goto L30
    L25:
        r3 = false;
        goto L26
    L8:
        if (r1.optInt("block_enable_upload", 0) != 1) goto L10;
        boolean r5 = true;
    L11:
        com.bytedance.apm.internal.a.i(1, r5);
        if (r1.optInt("enable_trace", 0) != 1) goto L14;
        boolean r9 = true;
    L15:
        com.bytedance.apm.internal.a.i(2, r9);
        if (r1.optInt("enable_stack_sampling", 0) != 1) goto L18;
        boolean r10 = true;
    L19:
        com.bytedance.apm.internal.a.i(64, r10);
        com.bytedance.apm.internal.a.g(r1.optLong("atrace_tag", 0));
        com.bytedance.apm.internal.a.h(-536870912, com.bytedance.apm.r.g.c(r7) << 29);
        goto L20
    L18:
        r10 = false;
        goto L19
    L14:
        r9 = false;
        goto L15
    L10:
        r5 = false;
        goto L11
    }

    private void G() {
        com.bytedance.apm.f0.b.f().k(new b(this), 1000);
    }

    private void H(JSONObject r5) {
        if (com.bytedance.apm.util.h.c(r5) == false) goto L5;
        return;
    L5:
        JSONObject r0 = com.bytedance.apm.util.h.f(r5, "general", "slardar_api_settings");
        if (r0 == null) goto L13;
        JSONObject r1 = r0.optJSONObject("fetch_setting");
        if (r1 == null) goto L11;
        this.f1456g = r1.optLong("fetch_setting_interval", 1200);
    L11:
        if (this.f1456g >= 600) goto L13;
        this.f1456g = 600;
    L13:
        JSONObject r2 = r5.optJSONObject("custom_event_settings");
        if (r2 == null) goto L16;
        this.f1452c = r2.optJSONObject("allow_log_type");
        this.f1453d = r2.optJSONObject("allow_metric_type");
        this.f1454e = r2.optJSONObject("allow_service_name");
    L16:
        this.f1459j = r5;
        JSONObject r6 = k("exception_modules");
        if (r6 == null) goto L26;
        JSONObject r7 = r6.optJSONObject("exception");
        if (r7 == null) goto L26;
        if (r7.optInt("enable_upload") != 1) goto L23;
        boolean r8 = true;
    L24:
        this.f1451b = r8;
        goto L26
    L23:
        r8 = false;
    L26:
        if (n("apm_cost") == false) goto L29;
        com.bytedance.monitor.collector.h.m(new c(this));
        com.bytedance.monitor.collector.h.e(true);
        return;
    }

    private boolean I() {
        String r0 = z();
        if (com.bytedance.apm.x.a.c() == null) goto L6;
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L29
        r1.put("updateFromLocal", TextUtils.isEmpty(r0));     // Catch: Exception -> L29
        com.bytedance.apm.x.a.c().a("SlardarConfigFetcher", r1.toString());     // Catch: Exception -> L29
    L6:
        if (com.bytedance.apm.d.C() == false) goto L9;
        d.b.b.o.m.b.a("SlardarConfigFetcher", "configStr:" + r0);
    L9:
        if (com.bytedance.apm.d.C() == false) goto L12;
        com.bytedance.apm.x.e.d("apm_initializing", new String[]{"SlardarConfigFetcher.updateFromLocal, configStr=" + r0});
    L12:
        if (TextUtils.isEmpty(r0) == false) goto L30;
    L24:
        boolean r10 = true;
    L26:
        if (com.bytedance.apm.d.C() == false) goto L28;
        com.bytedance.apm.x.e.d("apm_initializing", new String[]{"SlardarConfigFetcher.updateFromLocal, isForceRefreshFromNet=" + r10});
        DoctorManager.getInstance().b("APM_SETTING_UPDATE_FROM_LOCAL", "needForceRefreshFromNet:" + r10 + " localConfig:" + r0);
    L28:
        return r10;
    L30:
        JSONObject r2 = new JSONObject(r0);     // Catch: Exception -> L23
        this.f1460k = true;     // Catch: Exception -> L23
        int r6 = this.f1457h.getInt("setting_version", 0);     // Catch: Exception -> L23
        if (com.bytedance.apm.d.C() == false) goto L17;
        com.bytedance.apm.x.e.d("apm_initializing", new String[]{"SlardarConfigFetcher.updateFromLocal, settingVersion=" + r6});     // Catch: Exception -> L23
    L17:
        if (r6 != 5) goto L24;
        this.f1461l = B();     // Catch: Exception -> L23
        this.r = this.f1457h.getLong("monitor_last_calculate_timestamp_v5", 0);     // Catch: Exception -> L23
        this.s = this.f1457h.getLong("monitor_last_full_calculate_timestamp_v5", 0);     // Catch: Exception -> L23
        if (com.bytedance.apm.d.C() == false) goto L21;
        d.b.b.o.m.b.a("SlardarConfigFetcher", "lastCalculateTimestamp:" + this.r);     // Catch: Exception -> L23
    L21:
        com.bytedance.apm.d.e("config_time", this.f1461l + "");     // Catch: Exception -> L23
        d.b.b.i.c.a.C(this.f1461l);     // Catch: Exception -> L23
        H(r2);     // Catch: Exception -> L23
        y(r2, true);     // Catch: Exception -> L23
        x();     // Catch: Exception -> L23
        r10 = false;
    L23:
        com.bytedance.apm.x.e.c(com.bytedance.apm.x.b.f2125a, new String[]{"config read error"});
        goto L24
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent a(Context r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    @Proxy("registerReceiver")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @RequiresApi(api = 26)
    public static Intent b(Context r1, BroadcastReceiver r2, IntentFilter r3, int r4) {
        return r1.registerReceiver(r2, r3, r4);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4);
    }

    static /* synthetic */ boolean c(g r0) {
        return r0.I();
    }

    static /* synthetic */ boolean d(g r0) {
        return r0.q;
    }

    public static byte[] f(byte[] r2, Map<String, String> r3) {
        if (r2.length <= 128) goto L14;
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r1 = new GZIPOutputStream(r0);
        r1.write(r2);     // Catch: Throwable -> L7 IOException -> L9
        r1.close();
        byte[] r4 = r0.toByteArray();
        r3.put("Content-Encoding", "gzip");
        return r4;
    L7:
        th = move-exception;
        r1.close();
        throw th;
    L9:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "SlardarConfigFetcher->compress");     // Catch: Throwable -> L7
        throw e;     // Catch: Throwable -> L7
    L14:
        return r2;
    }

    private List<String> g(List<String> r6) {
        if (i.b(r6) == true) goto L14;
        ArrayList r5 = new ArrayList(2);     // Catch: MalformedURLException -> L15
        int r0 = r6.size();     // Catch: MalformedURLException -> L15
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L12;
        String r2 = new URL(r6.get(r1)).getHost();     // Catch: MalformedURLException -> L15
        if (TextUtils.isEmpty(r2) == true) goto L11;
        if (r2.indexOf(46) <= 0) goto L11;
        r5.add("https://" + r2 + "/monitor/appmonitor/v5/batch_settings");     // Catch: MalformedURLException -> L15
    L11:
        r1 = r1 + 1;
        goto L5
    L12:
        return r5;
    L14:
        return Collections.emptyList();
    }

    private boolean p(HttpResponse r5) {
        if (r5 == null) goto L18;
        if (r5.getStatusCode() != 200) goto L18;
        byte[] r6 = r5.getResponseBytes();
        if (r6 != null) goto L9;
        return false;
    L9:
        JSONObject r1 = new JSONObject(new String(r6));
        if (com.bytedance.apm.d.C() == false) goto L12;
        d.b.b.o.m.b.a("SlardarConfigFetcher", "resultJSON:" + r1);
        DoctorManager.getInstance().b("APM_SETTING_UPDATE_FROM_NET_RESULT", r1.toString());
    L12:
        JSONObject r7 = r1.optJSONObject(com.bytedance.apm.d.k().optString(WsConstants.KEY_APP_ID));
        if (r7 != null) goto L16;
        return false;
    L16:
        return J(r7);
    L18:
        if (com.bytedance.apm.d.C() == false) goto L24;
        DoctorManager r4 = DoctorManager.getInstance();
        StringBuilder r2 = new StringBuilder();
        r2.append("statusCode error:");
        if (r5 != null) goto L22;
        Object r8 = "null";
    L23:
        r2.append(r8);
        r4.b("APM_SETTING_UPDATE_FROM_NET_ERROR", r2.toString());
        goto L24
    L22:
        r8 = Integer.valueOf(r5.getStatusCode());
    L24:
        return false;
    }

    private void s() {
        if (this.o == true) goto L9;
        this.o = true;
        if (u() == false) goto L7;
        com.bytedance.apm.f0.b.f().c(this);
    L7:
        C();
        return;
    }

    private void t() {
        if (this.f1457h != null) goto L13;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f1457h != null) goto L8;
        this.f1457h = com.bytedance.apm.core.e.h(com.bytedance.apm.d.h(), "monitor_config");     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    }

    private boolean u() {
        if (this.q == false) goto L5;
    L8:
        return true;
    L5:
        if (this.p == true) goto L8;
        return false;
    }

    private boolean v(long r8) {
        long r0 = this.m;
        if (r0 <= 60000) goto L10;
        if ((r8 - this.n) <= r0) goto L8;
        return true;
    L8:
        return false;
    L10:
        if ((r8 - this.f1461l) <= (this.f1456g * 1000)) goto L13;
        return true;
    L13:
        return false;
    }

    private void x() {
        if (this.f1450a == true) goto L17;
        this.f1450a = true;
        List<IConfigListener> r2 = this.t;
        if (r2 == null) goto L24;
        Iterator<IConfigListener> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L25;
        r3.next().onReady();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (com.bytedance.apm.d.C() == false) goto L16;
        th.printStackTrace();
    L16:
        EnsureManager.ensureNotReachHere(th);
        goto L8
    L25:
        return;
    L24:
        return;
    }

    private void y(JSONObject r3, boolean r4) {
        List<IConfigListener> r2 = this.t;
        if (r2 == null) goto L15;
        Iterator<IConfigListener> r5 = r2.iterator();
    L6:
        if (r5.hasNext() == false) goto L22;
        r5.next().onRefresh(r3, r4);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (com.bytedance.apm.d.C() == false) goto L14;
        th.printStackTrace();
    L14:
        EnsureManager.ensureNotReachHere(th);
        goto L6
    L22:
        return;
    }

    void D(IConfigListener r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        List<IConfigListener> r0 = this.t;
        if (r0 == null) goto L8;
        r0.remove(r1);
        return;
    }

    public JSONObject E() {
        com.bytedance.apm.core.d r0 = this.f1458i;
        if (r0 != null) goto L5;
    L7:
        Map<String, String> r1 = null;
    L9:
        if (r1 == null) goto L11;
        HashMap r2 = new HashMap(r1);
    L12:
        r2.put("last_calculate_timestamp", String.valueOf(this.r / 1000));
        r2.put("last_full_calculate_timestamp", String.valueOf(this.s / 1000));
        if ((System.currentTimeMillis() - this.r) < 345600000) goto L15;
        r2.put("force_refresh", String.valueOf(1));
    L15:
        r2.put("minor_version", LocationInfoConst.ALLOW_USE_LOCATION);
        return new JSONObject(r2);
    L11:
        r2 = new HashMap();
        goto L12
    L5:
        if (r0.a() == null) goto L7;
        r1 = this.f1458i.a();
        goto L9
    }

    public boolean J(JSONObject r15) {
        int r0 = r15.optInt("code", -1);
        if (r0 != (-1)) goto L6;
        return false;
    L6:
        if (r0 != 1) goto L9;
        this.f1461l = System.currentTimeMillis();
        this.r = ((long) r15.optInt("last_calculate_timestamp", 0)) * 1000;
        this.s = ((long) r15.optInt("last_full_calculate_timestamp", 0)) * 1000;
        SharedPreferences.Editor r16 = this.f1457h.edit();
        r16.putLong("monitor_configure_refresh_time", this.f1461l);
        r16.putLong("monitor_last_calculate_timestamp_v5", this.r);
        r16.putLong("monitor_last_full_calculate_timestamp_v5", this.s);
        r16.commit();
        return true;
    L9:
        if (r0 != 0) goto L11;
    L14:
        JSONObject r1 = null;
        JSONObject r10 = r15.optJSONObject("data");
        if (r10 == null) goto L17;
        r1 = r10;
    L26:
        if (r1 != null) goto L48;
        return false;
    L48:
        JSONObject r11 = r15.optJSONObject("data_to_merge");     // Catch: JSONException -> L32
        if (r11 == null) goto L46;
        d.b.b.o.e.e(r1, r11);     // Catch: JSONException -> L32
    L46:
        JSONObject r12 = r15.optJSONObject("data_to_delete");     // Catch: JSONException -> L40
        if (r12 == null) goto L44;
        d.b.b.o.e.b(r1, r12);     // Catch: JSONException -> L40
    L44:
        this.r = ((long) r15.optInt("last_calculate_timestamp", 0)) * 1000;
        this.s = ((long) r15.optInt("last_full_calculate_timestamp", 0)) * 1000;
        this.f1461l = System.currentTimeMillis();
        this.f1460k = false;
        H(r1);
        F(r1);
        SharedPreferences.Editor r17 = this.f1457h.edit();
        r17.putString("monitor_net_config", r1.toString());
        r17.putInt("setting_version", 5);
        r17.putLong("monitor_configure_refresh_time", this.f1461l);
        r17.putLong("monitor_last_calculate_timestamp_v5", this.r);
        r17.putLong("monitor_last_full_calculate_timestamp_v5", this.s);
        r17.commit();
        y(r1, false);
        x();
        com.bytedance.apm.d.e("config_time", this.f1461l + "");
        d.b.b.i.c.a.C(this.f1461l);
        G();
        com.bytedance.apm.x.a.d("apm_debug", "APM_SETTING_READY");
        return true;
    L40:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "SlardarConfigFetcher->updateWithSpecificAidResult 3");
        if (com.bytedance.apm.d.C() == false) goto L44;
        d.b.b.o.m.b.b("SlardarConfigFetcher", "error nested data: dataToDelete");
    L32:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "SlardarConfigFetcher->updateWithSpecificAidResult 2");
        if (com.bytedance.apm.d.C() == false) goto L46;
        d.b.b.o.m.b.b("SlardarConfigFetcher", "error nested data: dataToMerge");
        goto L46
    L17:
        String r13 = z();
        if (TextUtils.isEmpty(r13) == false) goto L50;
        r13 = "{}";
    L50:
        r1 = new JSONObject(r13);     // Catch: JSONException -> L22
    L22:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "SlardarConfigFetcher->updateWithSpecificAidResult");
        if (com.bytedance.apm.d.C() == false) goto L26;
        d.b.b.o.m.b.b("SlardarConfigFetcher", "error parse configStr:" + r13);
        goto L26
    L11:
        if (r0 == 2) goto L14;
        return false;
    }

    void e(IConfigListener r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.t != null) goto L8;
        this.t = new CopyOnWriteArrayList();
    L8:
        if (this.t.contains(r5) == true) goto L11;
        this.t.add(r5);
    L11:
        if (com.bytedance.apm.d.C() == false) goto L14;
        com.bytedance.apm.x.e.d("apm_initializing", new String[]{"addConfigListener, mReady=" + this.f1450a});
    L14:
        if (this.f1450a == false) goto L17;
        r5.onRefresh(this.f1459j, this.f1460k);
        r5.onReady();
        return;
    }

    @WorkerThread
    public void h(@Nullable com.bytedance.apm.core.d r1, @Nullable List<String> r2) {
        I();
        if (r1 == null) goto L6;
        this.f1458i = r1;
    L6:
        if (i.b(r2) == true) goto L8;
        this.f1455f = new ArrayList(r2);
    L8:
        A(true);
    }

    public JSONObject i() {
        return this.f1459j;
    }

    int j(String r2, int r3) {
        if (TextUtils.isEmpty(r2) == true) goto L9;
        JSONObject r1 = this.f1459j;
        if (r1 == null) goto L9;
        return r1.optInt(r2, r3);
    L9:
        return r3;
    }

    JSONObject k(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L10;
        JSONObject r1 = this.f1459j;
        if (r1 == null) goto L10;
        return r1.optJSONObject(r2);
    L10:
        return new JSONObject();
    }

    public boolean l(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return false;
    L6:
        if (TextUtils.equals(r3, "block_monitor") == false) goto L9;
        r3 = "caton_monitor";
    L9:
        if (TextUtils.equals(r3, "core_exception_monitor") == false) goto L13;
        return this.f1451b;
    L13:
        if (this.f1452c != null) goto L16;
        return false;
    L16:
        if (this.f1452c.optInt(r3) == 1) goto L18;
        return false;
    L18:
        return true;
    }

    boolean m(String r3) {
        if (this.f1453d != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (this.f1453d.optInt(r3) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    boolean n(String r3) {
        if (this.f1454e != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (this.f1454e.optInt(r3) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    boolean o(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L9;
        JSONObject r1 = this.f1459j;
        if (r1 != null) goto L8;
        return false;
    L8:
        return r1.optBoolean(r2);
    L9:
        return false;
    }

    @Override // com.bytedance.apm.f0.b.e
    public void onTimeEvent(long r1) {
        A(false);
    }

    @WorkerThread
    void q() {
        boolean r0 = I();
        if (com.bytedance.apm.d.G() == true) goto L5;
        return;
    L5:
        if (this.f1461l <= System.currentTimeMillis()) goto L7;
        r0 = true;
    L7:
        A(r0);
    }

    public void r(boolean r1, com.bytedance.apm.core.d r2, List<String> r3) {
        this.p = r1;
        this.q = com.bytedance.apm.d.G();
        t();
        this.f1458i = r2;
        if (i.b(r3) == true) goto L5;
        this.f1455f = g(r3);
    L5:
        s();
    }

    boolean w() {
        return this.f1450a;
    }

    String z() {
        t();
        return this.f1457h.getString("monitor_net_config", "");
    }
}
