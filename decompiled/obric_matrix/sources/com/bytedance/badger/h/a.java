package com.bytedance.badger.h;

import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.lego.init.IdleTaskConfig;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.i0.r;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.y;
import kotlin.s0.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ l[] f2570a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile JSONObject f2571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final c f2572c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final e f2573d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final d f2574e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final d f2575f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final d f2576g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final d f2577h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final c f2578i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final d f2579j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final f f2580k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final f f2581l = null;
    private static final c m = null;
    private static final d n = null;
    private static final d o = null;
    private static final d p = null;
    private static final d q = null;
    private static final d r = null;
    private static final c s = null;
    public static final a t = null;

    static {
        f2570a = new l[]{e0.g(new y(e0.b(a.class), "enableBadger", "getEnableBadger()Z")), e0.g(new y(e0.b(a.class), "configVersion", "getConfigVersion()Ljava/lang/String;")), e0.g(new y(e0.b(a.class), "detectorFullCollectTimeout", "getDetectorFullCollectTimeout()Lcom/bytedance/badger/config/SimpleDuration;")), e0.g(new y(e0.b(a.class), "startupCompensateTimeout", "getStartupCompensateTimeout()Lcom/bytedance/badger/config/SimpleDuration;")), e0.g(new y(e0.b(a.class), "compensateExpireTimeSeconds", "getCompensateExpireTimeSeconds()Lcom/bytedance/badger/config/SimpleDuration;")), e0.g(new y(e0.b(a.class), "reportMinIntervalSeconds", "getReportMinIntervalSeconds()Lcom/bytedance/badger/config/SimpleDuration;")), e0.g(new y(e0.b(a.class), "enableReportIfLoginFailed", "getEnableReportIfLoginFailed()Z")), e0.g(new y(e0.b(a.class), "devicefp1BindTimeout", "getDevicefp1BindTimeout()Lcom/bytedance/badger/config/SimpleDuration;")), e0.g(new y(e0.b(a.class), "realTimeReportPaths", "getRealTimeReportPaths()Ljava/util/Collection;")), e0.g(new y(e0.b(a.class), "disabledFeatures", "getDisabledFeatures()Ljava/util/Collection;")), e0.g(new y(e0.b(a.class), "enableBadgerPreLoginReport", "getEnableBadgerPreLoginReport()Z")), e0.g(new y(e0.b(a.class), "badgerLoginReportInterval", "getBadgerLoginReportInterval()Lcom/bytedance/badger/config/SimpleDuration;")), e0.g(new y(e0.b(a.class), "badgerNotLoginReportInterval", "getBadgerNotLoginReportInterval()Lcom/bytedance/badger/config/SimpleDuration;")), e0.g(new y(e0.b(a.class), "badgerLoginReportDelay", "getBadgerLoginReportDelay()Lcom/bytedance/badger/config/SimpleDuration;")), e0.g(new y(e0.b(a.class), "badgerNotLoginReportDelay", "getBadgerNotLoginReportDelay()Lcom/bytedance/badger/config/SimpleDuration;")), e0.g(new y(e0.b(a.class), "badgerFirstReportTimeout", "getBadgerFirstReportTimeout()Lcom/bytedance/badger/config/SimpleDuration;")), e0.g(new y(e0.b(a.class), "badgerEnablePreLoginImmediateReport", "getBadgerEnablePreLoginImmediateReport()Z"))};
        a r0 = new a();
        t = r0;
        f2572c = r0.a("enable_badger_detector", false);
        o.g("config_version", "key");
        o.g("<default>", "defaultValue");
        f2573d = new e(r0, "config_version", "<default>");
        TimeUnit r1 = TimeUnit.MILLISECONDS;
        f2574e = r0.b("detector_full_collect_timeout", 30000, r1);
        f2575f = r0.b("startup_compensate_timeout", BDLocationConfig.sScanBleMaxInterval, r1);
        TimeUnit r4 = TimeUnit.SECONDS;
        f2576g = r0.b("compensate_expire_time_seconds", TimeUtils.SECONDS_PER_HOUR, r4);
        f2577h = r0.b("report_main_interval_seconds", 10, r4);
        f2578i = r0.a("enable_report_if_login_failed", false);
        f2579j = r0.b("devicefp1_bind_timeout", IdleTaskConfig.IDLE_START_TIME_OUT, r1);
        List r6 = r.j(new String[]{"/passport/mobile/login/", "/passport/mobile/sms_login/", "/passport/auth/login/", "/passport/user/recall_login/", "/passport/password/reset_by_ticket/", "/passport/auth/one_login_with_mask_mobile/", "/passport/auth/one_login/", "/passport/auth/share_login/"});
        o.g("detector_report_paths", "key");
        o.g(r6, "defaultValue");
        f2580k = new f(r0, "detector_report_paths", r6);
        List r7 = r.g();
        o.g("disabled_features", "key");
        o.g(r7, "defaultValue");
        f2581l = new f(r0, "disabled_features", r7);
        m = r0.a("enable_badger_pre_login_report", false);
        n = r0.b("badger_login_report_interval", 1800, r4);
        o = r0.b("badger_not_login_report_interval", 900, r4);
        p = r0.b("badger_login_report_delay", 15, r4);
        q = r0.b("badger_not_login_report_delay", 10, r4);
        r = r0.b("badger_first_report_timeout", WsConstants.EXIT_DELAY_TIME, r1);
        s = r0.a("badger_enable_pre_login_immediate_report", false);
    }

    private a() {
    }

    @Override // com.bytedance.badger.h.g
    public JSONObject c() {
        return f2571b;
    }

    public final void d(JSONObject r2) {
        StringBuilder r1 = new StringBuilder();
        r1.append("updateConfig: ");
        if (r2 == null) goto L5;
        Integer r0 = Integer.valueOf(r2.length());
    L6:
        r1.append(r0);
        com.bytedance.badger.d.f("BadgerConfig", r1.toString());
        f2571b = r2;
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final boolean e() {
        return ((Boolean) s.a(this, f2570a[16])).booleanValue();
    }

    public final h f() {
        return (h) r.a(this, f2570a[15]);
    }

    public final h g() {
        return (h) p.a(this, f2570a[13]);
    }

    public final h h() {
        return (h) n.a(this, f2570a[11]);
    }

    public final h i() {
        return (h) q.a(this, f2570a[14]);
    }

    public final h j() {
        return (h) o.a(this, f2570a[12]);
    }

    public final h k() {
        return (h) f2576g.a(this, f2570a[4]);
    }

    public final String l() {
        return (String) f2573d.a(this, f2570a[1]);
    }

    public final h m() {
        return (h) f2574e.a(this, f2570a[2]);
    }

    public final h n() {
        return (h) f2579j.a(this, f2570a[7]);
    }

    public final Collection o() {
        return (Collection) f2581l.a(this, f2570a[9]);
    }

    public final boolean p() {
        return ((Boolean) f2572c.a(this, f2570a[0])).booleanValue();
    }

    public final boolean q() {
        return ((Boolean) m.a(this, f2570a[10])).booleanValue();
    }

    public final boolean r() {
        return ((Boolean) f2578i.a(this, f2570a[6])).booleanValue();
    }

    public final Collection s() {
        return (Collection) f2580k.a(this, f2570a[8]);
    }

    public final h t() {
        return (h) f2577h.a(this, f2570a[5]);
    }

    public final h u() {
        return (h) f2575f.a(this, f2570a[3]);
    }
}
