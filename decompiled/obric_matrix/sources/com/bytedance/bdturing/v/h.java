package com.bytedance.bdturing.v;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.wschannel.WsConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a0;
import kotlin.f0;
import kotlin.n0.d.d0;
import kotlin.n0.d.o;
import kotlin.u;
import kotlin.u0.k;
import org.json.JSONException;
import org.json.JSONObject;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes.dex */
public final class h implements g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f3206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f3207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f3208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f3209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static JSONObject f3210e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Handler f3211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static com.bytedance.bdturing.v.a f3212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final List<g.a> f3213h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final List<g.a> f3214i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Runnable f3215j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static boolean f3216k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final h f3217l = null;

    public static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.b(h.f3217l);
        }
    }

    static {
        f3217l = new h();
        f3210e = c.f3192c.b();
        f3213h = new LinkedList();
        f3214i = new LinkedList();
        f3215j = new a();
    }

    private h() {
    }

    private final void A(long r2) {
        Handler r1 = f3211f;
        if (r1 == null) goto L5;
        r1.removeCallbacks(f3215j);
    L5:
        Handler r3 = f3211f;
        if (r3 == null) goto L9;
        r3.postDelayed(f3215j, r2);
        return;
    }

    static /* synthetic */ void B(h r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        r0.A(r1);
    }

    private final void C(String r5) {
        f3210e = new JSONObject(r5);     // Catch: JSONException -> L4
        z(System.currentTimeMillis() + l());     // Catch: JSONException -> L4
        com.bytedance.bdturing.t.b.f3142b.f(r5);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.bdturing.g.e(e);
    }

    public static final /* synthetic */ void b(h r0) {
        r0.y();
    }

    private final String d(String r7) {
        StringBuilder r6 = new StringBuilder(r7);
    L55:
        e = move-exception;
        e.printStackTrace();
    L58:
        return r6.toString();
    L5:
        if (k.P(r7, '?', 0, false, 6, null) >= 0) goto L7;
        r6.append("?");     // Catch: Exception -> L55
    L8:
        HashMap r8 = new HashMap();     // Catch: Exception -> L55
        com.bytedance.bdturing.v.a r2 = f3212g;     // Catch: Exception -> L55
        if (r2 == null) goto L53;
        u r1 = a0.a(WsConstants.KEY_APP_ID, r2.getAppId());     // Catch: Exception -> L55
        r8.put(r1.c(), r1.d());     // Catch: Exception -> L55
        com.bytedance.bdturing.v.a r3 = f3212g;     // Catch: Exception -> L55
        if (r3 == null) goto L51;
        u r4 = a0.a(IBdInstall.PARAM_APP_NAME, r3.getAppName());     // Catch: Exception -> L55
        r8.put(r4.c(), r4.d());     // Catch: Exception -> L55
        com.bytedance.bdturing.v.a r5 = f3212g;     // Catch: Exception -> L55
        if (r5 == null) goto L49;
        u r9 = a0.a(WsConstants.KEY_APP_VERSION, r5.a());     // Catch: Exception -> L55
        r8.put(r9.c(), r9.d());     // Catch: Exception -> L55
        com.bytedance.bdturing.v.a r10 = f3212g;     // Catch: Exception -> L55
        if (r10 == null) goto L47;
        u r11 = a0.a("channel", r10.getChannel());     // Catch: Exception -> L55
        r8.put(r11.c(), r11.d());     // Catch: Exception -> L55
        com.bytedance.bdturing.v.a r12 = f3212g;     // Catch: Exception -> L55
        if (r12 == null) goto L45;
        u r13 = a0.a("lang", r12.g());     // Catch: Exception -> L55
        r8.put(r13.c(), r13.d());     // Catch: Exception -> L55
        com.bytedance.bdturing.v.a r14 = f3212g;     // Catch: Exception -> L55
        if (r14 == null) goto L43;
        u r15 = a0.a("sdk_version", r14.f());     // Catch: Exception -> L55
        r8.put(r15.c(), r15.d());     // Catch: Exception -> L55
        com.bytedance.bdturing.v.a r16 = f3212g;     // Catch: Exception -> L55
        if (r16 == null) goto L41;
        u r17 = a0.a("version_code", String.valueOf(r16.b()));     // Catch: Exception -> L55
        r8.put(r17.c(), r17.d());     // Catch: Exception -> L55
        com.bytedance.bdturing.v.a r18 = f3212g;     // Catch: Exception -> L55
        if (r18 == null) goto L39;
        u r19 = a0.a("version_name", r18.a());     // Catch: Exception -> L55
        r8.put(r19.c(), r19.d());     // Catch: Exception -> L55
        u r20 = a0.a("device_platform", "android");     // Catch: Exception -> L55
        r8.put(r20.c(), r20.d());     // Catch: Exception -> L55
        Iterator r21 = r8.keySet().iterator();     // Catch: Exception -> L55
    L27:
        if (r21.hasNext() == false) goto L58;
        String r22 = (String) r21.next();     // Catch: Exception -> L55
        if (r6.length() <= 0) goto L31;
        boolean r23 = true;
    L32:
        if (r23 == false) goto L34;
        r6.append("&");     // Catch: Exception -> L55
    L34:
        h r24 = f3217l;     // Catch: Exception -> L55
        String r25 = r24.g(r22);     // Catch: Exception -> L55
        String r26 = (String) r8.get(r22);     // Catch: Exception -> L55
        if (r26 == null) goto L37;
        String r27 = r24.g(r26);     // Catch: Exception -> L55
    L38:
        r6.append(r25);     // Catch: Exception -> L55
        r6.append("=");     // Catch: Exception -> L55
        r6.append(r27);     // Catch: Exception -> L55
        goto L27
    L37:
        r27 = null;
        goto L38
    L31:
        r23 = false;
        goto L32
    L39:
        o.v("configProvider");     // Catch: Exception -> L55
        throw null;
    L41:
        o.v("configProvider");     // Catch: Exception -> L55
        throw null;
    L43:
        o.v("configProvider");     // Catch: Exception -> L55
        throw null;
    L45:
        o.v("configProvider");     // Catch: Exception -> L55
        throw null;
    L47:
        o.v("configProvider");     // Catch: Exception -> L55
        throw null;
    L49:
        o.v("configProvider");     // Catch: Exception -> L55
        throw null;
    L51:
        o.v("configProvider");     // Catch: Exception -> L55
        throw null;
    L53:
        o.v("configProvider");     // Catch: Exception -> L55
        throw null;
    L7:
        r6.append("&");     // Catch: Exception -> L55
        goto L8
    }

    private final String e(String r4, String r5) {
        if (k.n(r4, "/", false, 2, null) == false) goto L7;
        StringBuilder r3 = new StringBuilder();
        r3.append(r4);
    L5:
        r3.append(r5);
        return r3.toString();
    L7:
        r3 = new StringBuilder();
        r3.append(r4);
        r3.append('/');
        goto L5
    }

    private final boolean f() {
        if (h() <= System.currentTimeMillis()) goto L5;
        return true;
    L5:
        return false;
    }

    private final String g(String r1) {
        return URLEncoder.encode(r1, "UTF-8");
    L4:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    private final long h() {
        return f3210e.optLong("available_time");
    }

    private final long l() {
        return o("common").optLong(TypedValues.CycleType.S_WAVE_PERIOD, 300000);
    }

    private final int m() {
        return o("common").optInt("retry_count", 0);
    }

    private final long n() {
        return o("common").optLong("retry_interval", 30000);
    }

    private final boolean p() {
        if (o("common").optInt("skip_launch", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private final long q(boolean r5) {
        if (r5 == true) goto L10;
        if (f3206a >= m()) goto L10;
        if (n() == 0) goto L10;
        f3206a++;
        return n();
    L10:
        return Math.max(Math.min(h() - System.currentTimeMillis(), l()), 300000);
    }

    static /* synthetic */ long r(h r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = true;
    L6:
        return r0.q(r1);
    }

    private final void y() {
        HashMap r0 = new HashMap();
        com.bytedance.bdturing.v.a r1 = f3212g;
        if (r1 == null) goto L75;
        u r2 = a0.a(WsConstants.KEY_APP_ID, r1.getAppId());
        r0.put(r2.c(), r2.d());
        com.bytedance.bdturing.v.a r3 = f3212g;
        if (r3 == null) goto L73;
        u r4 = a0.a("lang", r3.g());
        r0.put(r4.c(), r4.d());
        com.bytedance.bdturing.v.a r5 = f3212g;
        if (r5 == null) goto L71;
        u r6 = a0.a(IBdInstall.PARAM_APP_NAME, r5.getAppName());
        r0.put(r6.c(), r6.d());
        com.bytedance.bdturing.v.a r7 = f3212g;
        if (r7 == null) goto L69;
        u r8 = a0.a("channel", r7.getChannel());
        r0.put(r8.c(), r8.d());
        com.bytedance.bdturing.v.a r9 = f3212g;
        if (r9 == null) goto L67;
        u r10 = a0.a("region", r9.getRegion());
        r0.put(r10.c(), r10.d());
        u r11 = a0.a("os_type", BDLocationException.ERROR_TIMEOUT);
        r0.put(r11.c(), r11.d());
        u r12 = a0.a("datetime", String.valueOf(System.currentTimeMillis()));
        r0.put(r12.c(), r12.d());
        com.bytedance.bdturing.v.a r13 = f3212g;
        if (r13 == null) goto L65;
        u r14 = a0.a("sdk_version", r13.f());
        r0.put(r14.c(), r14.d());
        com.bytedance.bdturing.v.a r15 = f3212g;
        if (r15 == null) goto L63;
        u r16 = a0.a(WsConstants.KEY_INSTALL_ID, r15.getInstallId());
        r0.put(r16.c(), r16.d());
        com.bytedance.bdturing.v.a r17 = f3212g;
        if (r17 == null) goto L61;
        u r18 = a0.a(WsConstants.KEY_APP_VERSION, r17.a());
        r0.put(r18.c(), r18.d());
        u r19 = a0.a("device_platform", "android");
        r0.put(r19.c(), r19.d());
        com.bytedance.bdturing.v.a r20 = f3212g;
        if (r20 == null) goto L59;
        u r21 = a0.a("version_code", String.valueOf(r20.b()));
        r0.put(r21.c(), r21.d());
        com.bytedance.bdturing.v.a r22 = f3212g;
        if (r22 == null) goto L57;
        u r23 = a0.a("version_name", r22.a());
        r0.put(r23.c(), r23.d());
        u r24 = a0.a("os_name", "android");
        r0.put(r24.c(), r24.d());
        u r25 = a0.a("os_version", String.valueOf(Build.VERSION.SDK_INT));
        r0.put(r25.c(), r25.d());
        com.bytedance.bdturing.v.a r26 = f3212g;
        if (r26 == null) goto L55;
        u r27 = a0.a("did", r26.getDeviceId());
        r0.put(r27.c(), r27.d());
        String r28 = Build.BRAND;
        r28 = URLEncoder.encode(r28, "utf-8");     // Catch: UnsupportedEncodingException -> L27
    L29:
        u r29 = a0.a("device_brand", r28);
        r0.put(r29.c(), r29.d());
        String r30 = k("common");
        if (r30 == null) goto L32;
        String r31 = e(r30, "vc/setting");
    L33:
        com.bytedance.bdturing.g.a("SettingsMager", r31);
        if (r31 == null) goto L36;
    L40:
        if (r31 == null) goto L42;
        String r32 = f3217l.d(r31);
    L43:
        com.bytedance.bdturing.v.a r33 = f3212g;
        if (r33 == null) goto L53;
        com.bytedance.bdturing.ttnet.b r34 = r33.d();
        if (r34 != null) goto L48;
        return;
    L48:
        if (r32 != null) goto L51;
        r32 = "";
    L51:
        new g(r32, r0, f3217l, r34).d();
        return;
    L53:
        o.v("configProvider");
        throw null;
    L42:
        r32 = null;
        goto L43
    L36:
        if (com.bytedance.bdturing.g.d() == false) goto L40;
        throw new RuntimeException("url should not empty");
    L32:
        r31 = null;
    L27:
        e = move-exception;
        com.bytedance.bdturing.g.e(e);
        goto L29
    L55:
        o.v("configProvider");
        throw null;
    L57:
        o.v("configProvider");
        throw null;
    L59:
        o.v("configProvider");
        throw null;
    L61:
        o.v("configProvider");
        throw null;
    L63:
        o.v("configProvider");
        throw null;
    L65:
        o.v("configProvider");
        throw null;
    L67:
        o.v("configProvider");
        throw null;
    L69:
        o.v("configProvider");
        throw null;
    L71:
        o.v("configProvider");
        throw null;
    L73:
        o.v("configProvider");
        throw null;
    L75:
        o.v("configProvider");
        throw null;
    }

    private final void z(long r2) {
        f3210e.put("available_time", r2);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [T, java.util.ArrayList, java.util.List] */
    @Override // com.bytedance.bdturing.v.g.a
    public void a(int r6, String r7, long r8) {
        boolean r0 = true;
        if (r6 != 200) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L14;
        if (r7 != null) goto L9;
    L12:
        if (r0 == true) goto L14;
        com.bytedance.bdturing.g.c("SettingsMager", "pull settings success," + r7);
        C(r7);
        f3206a = 0;
    L15:
        Iterator<T> r1 = f3213h.iterator();
    L17:
        if (r1.hasNext() == false) goto L19;
        ((g.a) r1.next()).a(r6, r7, r8);
        goto L17
    L19:
        d0 r3 = new d0();
        monitor-enter(this);
        ?? r4 = new ArrayList();     // Catch: Throwable -> L29
        List<g.a> r5 = f3214i;     // Catch: Throwable -> L29
        r4.addAll(r5);     // Catch: Throwable -> L29
        r3.f18431f = r4;     // Catch: Throwable -> L29
        r5.clear();     // Catch: Throwable -> L29
        f0 r9 = f0.f18324a;     // Catch: Throwable -> L29
        monitor-exit(this);
        Iterator r10 = ((List) r3.f18431f).iterator();
    L25:
        if (r10.hasNext() == false) goto L27;
        ((g.a) r10.next()).a(r6, r7, r8);
        goto L25
    L27:
        A(q(r2));
        return;
    L29:
        th = move-exception;
        throw th;
    L9:
        if (r7.length() == 0) goto L12;
        r0 = false;
    L14:
        com.bytedance.bdturing.g.c("SettingsMager", "pull settings fail,code:" + r6 + ",content:" + r7);
        goto L15
    L5:
        r2 = false;
        goto L6
    }

    public final boolean c(g.a r1) {
        o.g(r1, "pxy");
        List<g.a> r0 = f3213h;
        monitor-enter(r0);
        boolean r2 = r0.add(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public final String i(String r2) {
        o.g(r2, "service");
        return j(r2, WsConstants.KEY_CONNECTION_URL);
    }

    public final String j(String r4, String r5) {
        o.g(r4, "service");
        o.g(r5, WsConstants.KEY_CONNECTION_TYPE);
        JSONObject r3 = o(r4).optJSONObject(r5);
        if (r3 == null) goto L9;
        com.bytedance.bdturing.v.a r2 = f3212g;
        if (r2 == null) goto L7;
        String r6 = r3.optString(r2.getRegion());
    L11:
        if (TextUtils.isEmpty(r6) == true) goto L13;
        return r6;
    L13:
        JSONObject r7 = c.f3192c.b().optJSONObject(r4);
        if (r7 == null) goto L22;
        JSONObject r8 = r7.optJSONObject(r5);
        if (r8 == null) goto L23;
        com.bytedance.bdturing.v.a r9 = f3212g;
        if (r9 != null) goto L24;
        o.v("configProvider");
        throw null;
    L24:
        return r8.optString(r9.getRegion());
    L23:
        return null;
    L22:
        return null;
    L7:
        o.v("configProvider");
        throw null;
    L9:
        r6 = null;
        goto L11
    }

    public final String k(String r2) {
        o.g(r2, "service");
        return j(r2, "host");
    }

    public final JSONObject o(String r3) {
        o.g(r3, "service");
        JSONObject r2 = f3210e.optJSONObject(r3);
        if (r2 != null) goto L6;
        r2 = c.f3192c.b().optJSONObject(r3);
    L6:
        if (r2 != null) goto L9;
        r2 = new JSONObject();
    L9:
        com.bytedance.bdturing.v.a r0 = f3212g;
        if (r0 == null) goto L15;
        f r1 = r0.e();
        if (r1 == null) goto L14;
        f3210e.put(r3, r1.a(r3, r2));
    L14:
        return r2;
    L15:
        o.v("configProvider");
        throw null;
    }

    public final int s() {
        return o("common").optInt("use_dialog_size_v2", 0);
    }

    public final boolean t() {
        if (f3208c == true) goto L7;
        if (o("common").optInt("use_jsb_request", 0) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean u() {
        return f3209d;
    }

    public final boolean v() {
        if (f3207b == true) goto L7;
        if (o("common").optInt("use_native_report", 0) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void w(Context r5, com.bytedance.bdturing.v.a r6) {
        o.g(r5, "context");
        o.g(r6, "provider");
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (f3216k == true) goto L21;
        f3212g = new b(r6);     // Catch: Throwable -> L30
        com.bytedance.bdturing.v.a r0 = f3212g;     // Catch: Throwable -> L30
        if (r0 == null) goto L28;
        f3211f = new Handler(r0.c());     // Catch: Throwable -> L30
        com.bytedance.bdturing.v.a r7 = f3212g;     // Catch: Throwable -> L30
        if (r7 == null) goto L26;
        r7.e();     // Catch: Throwable -> L30
        com.bytedance.bdturing.t.b r8 = com.bytedance.bdturing.t.b.f3142b;     // Catch: Throwable -> L30
        r8.c(r5);     // Catch: Throwable -> L30
        String r9 = r8.b();     // Catch: Throwable -> L30
        if (r9 == null) goto L14;
        f3217l.C(r9);     // Catch: Throwable -> L30
    L14:
        d r10 = d.f3194a;     // Catch: Throwable -> L30
        com.bytedance.bdturing.v.a r11 = f3212g;     // Catch: Throwable -> L30
        if (r11 == null) goto L24;
        r10.a(r11.getAppId());     // Catch: Throwable -> L30
        h r12 = f3217l;     // Catch: Throwable -> L30
        if (r12.p() == false) goto L19;
        r12.A(r(r12, false, 1, null));     // Catch: Throwable -> L30
    L20:
        f3216k = true;     // Catch: Throwable -> L30
        goto L21
    L19:
        B(r12, 0, 1, null);     // Catch: Throwable -> L30
        goto L20
    L24:
        o.v("configProvider");     // Catch: Throwable -> L30
        throw null;
    L26:
        o.v("configProvider");     // Catch: Throwable -> L30
        throw null;
    L28:
        o.v("configProvider");     // Catch: Throwable -> L30
        throw null;
    L21:
        f0 r13 = f0.f18324a;     // Catch: Throwable -> L30
        monitor-exit(this);
    }

    public final void x(boolean r6, g.a r7) {
        o.g(r7, "callback");
        if (r6 == false) goto L5;
    L7:
        monitor-enter(this);
        List<g.a> r8 = f3214i;     // Catch: Throwable -> L18
        if (r8.size() != 0) goto L11;
        boolean r3 = true;
    L12:
        r8.add(r7);     // Catch: Throwable -> L18
        if (r3 == false) goto L15;
        B(f3217l, 0, 1, null);     // Catch: Throwable -> L18
    L15:
        f0 r9 = f0.f18324a;     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L11:
        r3 = false;
    L18:
        th = move-exception;
        throw th;
    L5:
        if (f() == false) goto L7;
        r7.a(200, null, 0);
    }
}
