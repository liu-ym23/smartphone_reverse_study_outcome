package w5;

import android.app.Activity;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.agent.v2.instrumentation.BatteryAgent;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.j;
import com.bytedance.services.apm.api.IEnsure;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import ym.k;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends s6.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Object f22720v = null;
    public final ConcurrentHashMap f;
    public volatile long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f22721h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f22722i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile long f22723j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile long f22724k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile long f22725l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f22726m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f22727n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f22728o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String[] f22729p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final HashMap f22730q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final HashMap f22731r;
    public final HashMap s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final b f22732t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b f22733u;

    static {
        f22720v = new Object();
    }

    public d() {
        this.f = new ConcurrentHashMap();
        this.g = -1;
        this.f22722i = false;
        this.f22724k = 30;
        this.f22725l = -1;
        this.f22727n = 32;
        this.f22729p = new String[2];
        new ArrayList();
        this.f22730q = new HashMap();
        this.f22731r = new HashMap();
        this.s = new HashMap();
        this.f22732t = new b(this, 0);
        this.f22733u = new b(this, 1);
        this.d = "battery";
    }

    public static void l(d r10) {
        HashMap r5 = r10.f22730q;
        if (r5.isEmpty() == true) goto L32;
        LinkedList r11 = k.j(Process.myPid());
        if (r11 != null) goto L8;
        return;
    L8:
        if (r11.isEmpty() == true) goto L33;
        Iterator r12 = r11.iterator();
    L12:
        if (r12.hasNext() == false) goto L34;
        u6.a r13 = (u6.a) r12.next();
        boolean r14 = r5.containsKey(Integer.valueOf(r13.f22261a));
        int r15 = r13.f22261a;
        if (r14 == false) goto L16;
        long r16 = r13.f22263c - ((u6.a) r5.get(Integer.valueOf(r15))).f22263c;
    L18:
        if (r16 <= 0) goto L12;
        long r17 = (long) ((r16 / 0) * 1000.0d);
        HashMap r18 = r10.f22731r;
        if (r18.containsKey(Integer.valueOf(r15)) == true) goto L21;
        r18.put(Integer.valueOf(r15), new u6.a(r15, r13.f22262b, r17));
        goto L12
    L21:
        ((u6.a) r18.get(Integer.valueOf(r15))).f22263c = r17;
        goto L12
    L16:
        r16 = r13.f22263c;
        goto L18
    L34:
        return;
    L33:
        return;
    }

    @Override // s6.a, oj.c
    public final void b(Activity r5) {
        String[] r10 = this.f22729p;
        r10[0] = r10[1];
        r10[1] = r5.getClass().getName();
        if (TextUtils.equals(r5.getClass().getName(), this.f22728o) == false) goto L5;
    L10:
        this.f22728o = null;
        return;
    L5:
        if (TextUtils.isEmpty(r10[0]) == true) goto L10;
        String r11 = r10[0];
        if (Build.VERSION.SDK_INT > this.f22727n) goto L10;
        a6.b.f112a.f113a = r11;
        z6.b.f23409a.b(new a(this, 0));
        goto L10
    }

    @Override // s6.a, oj.c
    public final void c(Activity r5) {
        super.c(r5);
        this.f22728o = r5.getClass().getName();
        String r10 = ActivityLifeObserver.getInstance().getTopActivityClassName();
        if (Build.VERSION.SDK_INT > this.f22727n) goto L7;
        a6.b.f112a.f113a = r10;
        z6.b.f23409a.b(new a(this, 0));
        return;
    }

    @Override // s6.a, pj.a
    public final void e() {
        super.e();
        if (j.d() == true) goto L5;
        return;
    L5:
        if (this.f22722i == false) goto L9;
        a6.c r5 = a6.b.f112a;
        z6.b.f23409a.d(new a6.a(r5, 0));
        this.f22725l = SystemClock.elapsedRealtime();
        return;
    }

    @Override // s6.a, oj.c
    public final void f(Activity r5) {
        super.f(r5);
        if (Build.VERSION.SDK_INT > this.f22727n) goto L7;
        a6.c r10 = a6.b.f112a;
        r10.f113a = ActivityLifeObserver.getInstance().getTopActivityClassName();
        z6.b.f23409a.b(new a(this, 1));
        return;
    }

    @Override // s6.a
    public final void g(JSONObject r10) {
        this.f22723j = r10.optLong("battery_record_interval", 10);
        this.f22724k = r10.optLong("battery_report_interval", 30);
        int r5 = r10.optInt("enable_upload", 0);
        if (r5 == 1) goto L5;
    L7:
        boolean r11 = false;
    L8:
        this.f22722i = r11;
        this.f22727n = r10.optInt("support_max_api_level", this.f22727n);
        if (j.f3887a == false) goto L12;
        Log.e("<monitor><battery>", com.bytedance.android.anniex.base.service.f.o(new String[]{"mRecordInterval:" + this.f22723j + ",mBatteryCollectEnabled" + r5}));
    L12:
        if (this.f22722i == true) goto L20;
        this.f.clear();
        ActivityLifeObserver.getInstance().unregister(this);
        ArrayList r12 = c6.a.f1125a;
        r12.remove(this);
        if (r12.isEmpty() == false) goto L23;
        throw null;     // Catch: Throwable -> L18
    L18:
        c6.a.f1126b = false;
    L23:
        if (r10.optInt("trace_enable", 0) != 1) goto L25;
        boolean r13 = true;
    L26:
        this.f22726m = r13;
        if (this.f22726m == false) goto L29;
        r10.optLong("max_single_wake_lock_hold_time_second", 120);
        r10.optInt("max_total_wake_lock_acquire_count", 5);
        r10.optLong("max_total_wake_lock_hold_time_second", 240);
        r10.optInt("max_wake_up_alarm_invoke_count", 5);
        r10.optInt("max_normal_alarm_invoke_count", 10);
        r10.optLong("max_single_loc_request_time_second", 120);
        r10.optInt("max_total_loc_request_count", 5);
        r10.optLong("max_total_loc_request_time_second", 240);
    L29:
        JSONObject r14 = r10.optJSONObject("cpu_monitor_config");
        if (r14 == null) goto L40;
        Iterator<String> r15 = r14.keys();
    L33:
        if (r15.hasNext() == false) goto L40;
        String r16 = r15.next();
        if ("cpu_monitor_enable".equals(r16) == true) goto L36;
        int r17 = r14.optInt(r16, 0);
        if (r17 <= 0) goto L33;
        this.s.put(r16, Integer.valueOf(r17));
        goto L33
    L36:
        this.s.put(r16, Integer.valueOf(r14.optInt(r16, 1)));
    L40:
        wn.h.n("scene_black_list", r10);
        if (m() == false) goto L54;
        z6.b.f23409a.b(this.f22733u);
        o();
        return;
    L54:
        return;
    L25:
        r13 = false;
        goto L26
    L20:
        if (r10.optInt("battery_net_for_all_interface_enable", 0) != 1) goto L23;
        b6.a r18 = new b6.a("traffic_all_interface");
        r18.f885c = false;
        this.f.put("traffic_all_interface", r18);
        goto L23
    L5:
        if (this.f22723j <= 0) goto L7;
        r11 = true;
        goto L8
    }

    @Override // s6.a
    public final boolean h() {
        return false;
    }

    @Override // s6.a
    public final void i() {
        if (Build.VERSION.SDK_INT <= this.f22727n) goto L6;
        return;
    L6:
        if (this.f.isEmpty() == false) goto L8;
        return;
    L8:
        long r5 = k();
        if (r5 <= 0) goto L16;
        mg.b r10 = (mg.b) z6.b.f23409a.f23411b;
        if (r10 == null) goto L16;
        b r11 = this.f22732t;
        if (r11 == null) goto L16;
        r10.g(r11, r5);
    L16:
        a6.c r12 = a6.b.f112a;
        r12.f113a = ActivityLifeObserver.getInstance().getTopActivityClassName();
        z6.b.f23409a.b(new a(this, 2));
    }

    @Override // s6.a
    public final long k() {
        return this.f22723j * 60000;
    }

    public final boolean m() {
        if (BatteryAgent.hasHook() == false) goto L9;
        HashMap r5 = this.s;
        if (r5.containsKey("cpu_monitor_enable") == true) goto L7;
    L8:
        return true;
    L7:
        if (((Integer) r5.get("cpu_monitor_enable")).intValue() != 0) goto L8;
    L9:
        return false;
    }

    public final boolean n(boolean r22) {
        long r5 = SystemClock.elapsedRealtime();
        long r10 = r5 - this.g;
        boolean r16 = true;
        if (r10 <= 2000) goto L5;
        boolean r17 = true;
    L7:
        if (this.g == (-1)) goto L43;
        if (r17 == false) goto L43;
        a6.c r11 = a6.b.f112a;
        m6.a r14 = new m6.a(this.f22721h, System.currentTimeMillis(), "ground_record", false, r10, null);
        if (TextUtils.isEmpty(r11.f114b) == false) goto L12;
        r11.f114b = String.valueOf(System.currentTimeMillis());
    L12:
        r14.f20014h = j.d();
        r14.g = j.a();
        r14.f20015i = r11.f114b;
        boolean r12 = r14.f20011a;
        if (r12 == false) goto L15;
        String r13 = r11.f113a;
    L17:
        if (TextUtils.isEmpty(r14.e) == true) goto L20;
        r13 = androidx.constraintlayout.motion.widget.a.t(new StringBuilder(), r14.e, "#", r13);
    L20:
        r14.e = r13;
        if (Build.VERSION.SDK_INT < 34) goto L103;
        if (r12 == true) goto L103;
        r14.d = false;
    L103:
    L29:
        e = move-exception;
        oo.j.h(e, "saveBatteryLog");
    L35:
        if (this.f22721h == false) goto L43;
        if (r10 <= 7200000) goto L43;
        HashMap r15 = new HashMap();
        r15.put("duration", String.valueOf(r10));
        IEnsure r18 = oo.j.f20816a;
        if (r18 == null) goto L43;
        r18.ensureNotReachHere("BatterErrorDuration", r15);
        goto L43
    L27:
        if (j.f3887a == false) goto L31;
        Log.i("<monitor><battery>", com.bytedance.android.anniex.base.service.f.o(new String[]{"saveBatteryLog into db: " + r14}));     // Catch: Exception -> L29
    L31:
        a6.c.i(r14);     // Catch: Exception -> L29
        r11.e();     // Catch: Exception -> L29
        z5.a r19 = null;
        r19.r(r14);     // Catch: Exception -> L29
        goto L35
    L15:
        r13 = "background";
    L43:
        if (this.g == (-1)) goto L101;
        if (r22 == false) goto L101;
        if (m() == false) goto L101;
        int r20 = 5;
        if (this.f22721h == true) goto L57;
        if (TextUtils.isEmpty(null) == false) goto L57;
        if (this.s.containsKey("cpu_monitor_function_background_threshold") == false) goto L55;
        int r21 = ((Integer) this.s.get("cpu_monitor_function_background_threshold")).intValue();
    L60:
        Map<String, u5.a> r23 = BatteryAgent.filterResultAndClear((((long) r21) * r10) / 100);
        if (this.f22721h == false) goto L70;
        if (this.s.containsKey("cpu_monitor_front_valid_duration") == false) goto L65;
        int r24 = ((Integer) this.s.get("cpu_monitor_front_valid_duration")).intValue();
    L67:
        if (r10 > (r24 * 1000)) goto L75;
    L100:
        o();
    L75:
        JSONObject r25 = new JSONObject();
        if (r23.isEmpty() == true) goto L82;
        JSONArray r26 = new JSONArray();
        Iterator<Map.Entry<String, u5.a>> r27 = r23.entrySet().iterator();
    L79:
        if (r27.hasNext() == false) goto L81;
        Map.Entry<String, u5.a> r110 = r27.next();
        JSONObject r111 = new JSONObject();
        r111.putOpt("method", r110.getKey());
        r111.putOpt("exe_count", Integer.valueOf(r110.getValue().f22253a));
        r111.putOpt("cpu_cost", Integer.valueOf(r110.getValue().f22254b));
        r26.put(r111);
        goto L79
    L81:
        r25.putOpt("functions", r26);
        boolean r28 = true;
    L84:
        if (this.f22731r.isEmpty() == true) goto L93;
        ArrayList r29 = new ArrayList(this.f22731r.values());
        Collections.sort(r29, new org.threeten.bp.format.c(3));
        JSONArray r30 = new JSONArray();
        if (this.s.containsKey("cpu_monitor_thread_count") == false) goto L88;
        r20 = ((Integer) this.s.get("cpu_monitor_thread_count")).intValue();
    L88:
        int r112 = 0;
    L90:
        if (r112 >= Math.min(r29.size(), r20)) goto L92;
        u6.a r113 = (u6.a) r29.get(r112);
        JSONObject r114 = new JSONObject();
        r112 = r112 + 1;
        r114.putOpt("rank", Integer.valueOf(r112));
        r114.putOpt("thread_name", r113.f22262b);
        r114.putOpt("cpu_cost", Long.valueOf(r113.f22263c));
        r30.put(r114);
        goto L90
    L92:
        r25.putOpt("threads", r30);
    L94:
        if (r16 == false) goto L100;
        if (this.f22721h == false) goto L98;
        String r31 = a6.b.f112a.f113a;
    L99:
        JSONObject r32 = new JSONObject();
        r32.putOpt("scene", r31);
        JSONObject r33 = new JSONObject();
        r33.putOpt("stay_duration", Long.valueOf(r10));
        r25.toString();
        ApmAgent.monitorEvent("monitor_expend_function", r32, r33, r25);
        goto L100
    L98:
        r31 = "background";
        goto L99
    L93:
        r16 = r28;
        goto L94
    L82:
        r28 = false;
        goto L84
    L65:
        r24 = 20;
        goto L67
    L70:
        if (this.s.containsKey("cpu_monitor_background_duration") == false) goto L72;
        int r34 = ((Integer) this.s.get("cpu_monitor_background_duration")).intValue();
    L74:
        if (r10 <= (r34 * 1000)) goto L100;
    L72:
        r34 = 60;
        goto L74
    L55:
        r21 = 2;
    L57:
        if (this.s.containsKey("cpu_monitor_function_front_threshold") == false) goto L59;
        r21 = ((Integer) this.s.get("cpu_monitor_function_front_threshold")).intValue();
        goto L60
    L59:
        r21 = 5;
    L101:
        this.g = r5;
        return r17;
    L5:
        r17 = false;
        goto L7
    }

    public final void o() {
        HashMap r5 = this.f22730q;
        r5.clear();
        this.f22731r.clear();
        LinkedList r10 = k.j(Process.myPid());
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isEmpty() == true) goto L13;
        Iterator r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L14;
        u6.a r12 = (u6.a) r11.next();
        r5.put(Integer.valueOf(r12.f22261a), r12);
        goto L9
    L14:
        return;
    }
}
