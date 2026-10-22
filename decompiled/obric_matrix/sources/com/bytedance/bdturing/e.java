package com.bytedance.bdturing;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.trace.TraceCons;
import java.text.SimpleDateFormat;
import java.util.Date;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f3043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f3044b;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f3045g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f3046h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f3047i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f3048j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f3049k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final a f3050l = null;
        public static final a m = null;
        public static final a n = null;
        private static final /* synthetic */ a[] o = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f3051f;

        static {
            a r0 = new a("CLOSE_REASON_MASK", 0, "mask_click_close");
            f3045g = r0;
            a r1 = new a("CLOSE_REASON_BACK", 1, "back_close");
            f3046h = r1;
            a r3 = new a("CLOSE_REASON_APP", 2, "app_close");
            f3047i = r3;
            a r5 = new a("CLOSE_REASON_PAGE_LOAD_FAILED", 3, "page_load_failed_close");
            f3048j = r5;
            a r7 = new a("CLOSE_FB_MASK", 4, "close_fb_mask");
            f3049k = r7;
            a r9 = new a("CLOSE_FB_CLOSE", 5, "close_fb_close");
            f3050l = r9;
            a r11 = new a("CLOSE_FB_FEEDBACK", 6, "close_fb_feedback");
            m = r11;
            a r13 = new a("CLOSE_FB_SYSTEM", 7, "close_fb_system");
            n = r13;
            o = new a[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        private a(String r1, int r2, String r3) {
            super(r1, r2);
            this.f3051f = r3;
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) o.clone();
        }

        public String a() {
            return this.f3051f;
        }
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    public static void b(int r2) {
        JSONObject r0 = new JSONObject();
        r0.put("result", r2);     // Catch: JSONException -> L6
        r0.put("key", "agree");     // Catch: JSONException -> L6
        r0.put("shark_log_id", f3044b);     // Catch: JSONException -> L6
        g("turing_verify_sdk", r0);
        return;
    L6:
        e = move-exception;
        g.e(e);
    }

    public static void c(int r2) {
        JSONObject r0 = new JSONObject();
        r0.put(LocationMonitorConst.IS_SUCCESS, r2);     // Catch: JSONException -> L6
        r0.put("key", "front_pop");     // Catch: JSONException -> L6
        r0.put("shark_log_id", f3044b);     // Catch: JSONException -> L6
        g("turing_verify_sdk", r0);
        return;
    L6:
        e = move-exception;
        g.e(e);
    }

    public static void d(int r2) {
        JSONObject r0 = new JSONObject();
        r0.put(LocationMonitorConst.IS_SUCCESS, r2);     // Catch: JSONException -> L6
        r0.put("key", "load_real_name");     // Catch: JSONException -> L6
        r0.put("shark_log_id", f3044b);     // Catch: JSONException -> L6
        g("turing_verify_sdk", r0);
        return;
    L6:
        e = move-exception;
        g.e(e);
    }

    private static boolean e() {
    L14:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (b.f().e() == null) goto L6;
        Context r2 = b.f().e().getApplicationContext();     // Catch: Throwable -> L14
    L7:
        if (r2 == null) goto L19;
        SharedPreferences r3 = a(r2, "turing_log_config", 0);     // Catch: Throwable -> L14
        String r4 = r3.getString("turing_init_date", "");     // Catch: Throwable -> L14
        String r5 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());     // Catch: Throwable -> L14
        g.a("EventReport", "isFirstInit cacheDateStr=" + r4 + ":dateStr=" + r5);     // Catch: Throwable -> L14
        if (r4 != null) goto L11;
        return false;
    L11:
        if (r4.equals(r5) == true) goto L21;
        SharedPreferences.Editor r6 = r3.edit();     // Catch: Throwable -> L14
        r6.putString("turing_init_date", r5);     // Catch: Throwable -> L14
        r6.commit();     // Catch: Throwable -> L14
        return true;
    L21:
        return false;
    L19:
        return false;
    L6:
        r2 = null;
        goto L7
    }

    private static boolean f() {
    L14:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (b.f().e() == null) goto L6;
        Context r2 = b.f().e().getApplicationContext();     // Catch: Throwable -> L14
    L7:
        if (r2 == null) goto L19;
        SharedPreferences r3 = a(r2, "turing_log_config", 0);     // Catch: Throwable -> L14
        String r4 = r3.getString("turing_setting_request_date", "");     // Catch: Throwable -> L14
        String r5 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());     // Catch: Throwable -> L14
        g.a("EventReport", "isFirstSetting cacheDateStr=" + r4 + ":dateStr=" + r5);     // Catch: Throwable -> L14
        if (r4 != null) goto L11;
        return false;
    L11:
        if (r4.equals(r5) == true) goto L21;
        SharedPreferences.Editor r6 = r3.edit();     // Catch: Throwable -> L14
        r6.putString("turing_setting_request_date", r5);     // Catch: Throwable -> L14
        r6.commit();     // Catch: Throwable -> L14
        return true;
    L21:
        return false;
    L19:
        return false;
    L6:
        r2 = null;
        goto L7
    }

    public static void g(String r3, JSONObject r4) {
        if (TextUtils.isEmpty(r3) == false) goto L20;
        return;
    L20:
        BdTuringConfig r0 = b.f().e();     // Catch: Exception -> L17
        r4.put("params_for_special", "turing");     // Catch: Exception -> L17
        if (r0 == null) goto L8;
        r4.put("sdk_version", r0.getSdkVersion());     // Catch: Exception -> L17
        r4.put("host_app_id", r0.getAppId());     // Catch: Exception -> L17
    L8:
        if (r0 == null) goto L10;
        d r1 = r0.getEventClient();     // Catch: Exception -> L17
    L11:
        if (r1 == null) goto L14;
        r1.onEvent(r3, r4);     // Catch: Exception -> L17
    L14:
        if (g.d() == false) goto L22;
        g.a(NotificationCompat.CATEGORY_EVENT, r4.toString());     // Catch: Exception -> L17
        return;
    L22:
        return;
    L10:
        r1 = null;
    L17:
        e = move-exception;
        g.e(e);
    }

    public static void h(com.bytedance.bdturing.verify.b.a r0) {
        if (r0 == null) goto L4;
        String r1 = r0.f();
    L5:
        f3044b = r1;
        return;
    L4:
        r1 = "";
        goto L5
    }

    public static void i(a r6) {
        JSONObject r0 = new JSONObject();
        r0.put(TypedValues.TransitionType.S_DURATION, System.currentTimeMillis() - f3043a);     // Catch: JSONException -> L6
        r0.put("result", r6.a());     // Catch: JSONException -> L6
        r0.put("key", "close");     // Catch: JSONException -> L6
        r0.put("shark_log_id", f3044b);     // Catch: JSONException -> L6
        g("turing_verify_sdk", r0);
        return;
    L6:
        e = move-exception;
        g.e(e);
    }

    public static void j() {
        JSONObject r0 = new JSONObject();
        r0.put("key", TraceCons.METRIC_BACKGROUND);     // Catch: JSONException -> L5
        r0.put("shark_log_id", f3044b);     // Catch: JSONException -> L5
    L7:
        g("turing_verify_sdk", r0);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void k() {
        JSONObject r0 = new JSONObject();
        r0.put("key", "pop");     // Catch: JSONException -> L6
        r0.put("shark_log_id", f3044b);     // Catch: JSONException -> L6
        g("turing_verify_sdk", r0);
        return;
    L6:
        e = move-exception;
        g.e(e);
    }

    public static void l(int r6, String r7) {
        JSONObject r0 = new JSONObject();
        r0.put(TypedValues.TransitionType.S_DURATION, System.currentTimeMillis() - f3043a);     // Catch: JSONException -> L6
        r0.put("result", r6);     // Catch: JSONException -> L6
        r0.put("custom", r7);     // Catch: JSONException -> L6
        r0.put("key", "load_webview");     // Catch: JSONException -> L6
        r0.put("shark_log_id", f3044b);     // Catch: JSONException -> L6
        g("turing_verify_sdk", r0);
        return;
    L6:
        e = move-exception;
        g.e(e);
    }

    public static void m(int r2) {
        JSONObject r0 = new JSONObject();
        r0.put("result", r2);     // Catch: JSONException -> L6
        r0.put("key", "orientation");     // Catch: JSONException -> L6
        r0.put("shark_log_id", f3044b);     // Catch: JSONException -> L6
        g("turing_verify_sdk", r0);
        return;
    L6:
        e = move-exception;
        g.e(e);
    }

    public static void n(int r2) {
        JSONObject r0 = new JSONObject();
        r0.put("result", r2);     // Catch: JSONException -> L6
        r0.put("key", "orientation_change");     // Catch: JSONException -> L6
        r0.put("shark_log_id", f3044b);     // Catch: JSONException -> L6
        g("turing_verify_sdk", r0);
        return;
    L6:
        e = move-exception;
        g.e(e);
    }

    public static void o(long r2) {
        JSONObject r0 = new JSONObject();
        r0.put(TypedValues.TransitionType.S_DURATION, r2);     // Catch: JSONException -> L6
        r0.put("key", "pre_create_load_success");     // Catch: JSONException -> L6
        r0.put("shark_log_id", f3044b);     // Catch: JSONException -> L6
        g("turing_verify_sdk", r0);
        return;
    L6:
        e = move-exception;
        g.e(e);
    }

    public static void p(long r2) {
        JSONObject r0 = new JSONObject();
        r0.put(TypedValues.TransitionType.S_DURATION, r2);     // Catch: JSONException -> L6
        r0.put("key", "pre_create_success");     // Catch: JSONException -> L6
        r0.put("shark_log_id", f3044b);     // Catch: JSONException -> L6
        g("turing_verify_sdk", r0);
        return;
    L6:
        e = move-exception;
        g.e(e);
    }

    public static void q(long r2) {
        if (e() == false) goto L12;
        JSONObject r0 = new JSONObject();
        r0.put(TypedValues.TransitionType.S_DURATION, r2);     // Catch: JSONException -> L7
        r0.put("key", "init");     // Catch: JSONException -> L7
        g("turing_verify_sdk", r0);
        return;
    L7:
        e = move-exception;
        g.e(e);
        return;
    }

    public static void r(long r2, int r4) {
        if (f() == false) goto L12;
        JSONObject r0 = new JSONObject();
        r0.put(TypedValues.TransitionType.S_DURATION, r2);     // Catch: JSONException -> L7
        r0.put("result", r4);     // Catch: JSONException -> L7
        r0.put("key", "setting");     // Catch: JSONException -> L7
        g("turing_verify_sdk", r0);
        return;
    L7:
        e = move-exception;
        g.e(e);
        return;
    }

    public static void s() {
        JSONObject r0 = new JSONObject();
        r0.put("key", "system_low");     // Catch: JSONException -> L6
        r0.put("shark_log_id", f3044b);     // Catch: JSONException -> L6
        g("turing_verify_sdk", r0);
        return;
    L6:
        e = move-exception;
        g.e(e);
    }

    public static void t(int r7) {
        JSONObject r1 = new JSONObject();
        r1.put(TypedValues.TransitionType.S_DURATION, System.currentTimeMillis() - f3043a);     // Catch: JSONException -> L6
        r1.put("result", r7);     // Catch: JSONException -> L6
        r1.put("key", "result");     // Catch: JSONException -> L6
        r1.put("shark_log_id", f3044b);     // Catch: JSONException -> L6
        g("turing_verify_sdk", r1);
        return;
    L6:
        e = move-exception;
        g.e(e);
    }

    public static void u() {
        f3043a = System.currentTimeMillis();
    }
}
