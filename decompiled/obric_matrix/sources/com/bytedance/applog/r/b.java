package com.bytedance.applog.r;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.client.BDLocationConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class b implements Handler.Callback {
    private static volatile long o;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f2323f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f2324g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Handler f2325h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile com.bytedance.applog.r.a f2326i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Context f2327j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Map<String, Map<String, c>> f2328k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.bytedance.applog.r.d f2329l;
    private final String m;
    private long n;

    public static final enum a extends Enum<a> {
        public static final a A = null;
        public static final a B = null;
        public static final a C = null;
        public static final a D = null;
        private static final /* synthetic */ a[] E = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f2330f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f2331g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f2332h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f2333i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f2334j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f2335k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final a f2336l = null;
        public static final a m = null;
        public static final a n = null;
        public static final a o = null;
        public static final a p = null;
        public static final a q = null;
        public static final a r = null;
        public static final a s = null;
        public static final a t = null;
        public static final a u = null;
        public static final a v = null;
        public static final a w = null;
        public static final a x = null;
        public static final a y = null;
        public static final a z = null;

        static {
            a r0 = new a("monitor_default", 0);
            f2330f = r0;
            a r1 = new a(NotificationCompat.CATEGORY_EVENT, 1);
            f2331g = r1;
            a r3 = new a("event_v3", 2);
            f2332h = r3;
            a r5 = new a("log_data", 3);
            f2333i = r5;
            a r7 = new a("item_impression", 4);
            f2334j = r7;
            a r9 = new a("launch", 5);
            f2335k = r9;
            a r11 = new a("terminate", 6);
            f2336l = r11;
            a r13 = new a("real_event", 7);
            m = r13;
            a r15 = new a("pack", 8);
            n = r15;
            a r14 = new a("database", 9);
            o = r14;
            a r12 = new a("register", 10);
            p = r12;
            a r10 = new a("active", 11);
            q = r10;
            a r8 = new a("config", 12);
            r = r8;
            a r6 = new a("ab_config", 13);
            s = r6;
            a r4 = new a("engine", 14);
            t = r4;
            a r2 = new a("f_cache_event", 15);
            u = r2;
            a r16 = new a("filtered_event", 16);
            v = r16;
            a r17 = new a("f_db_insert_event", 17);
            w = r17;
            a r18 = new a("f_to_pack_event", 18);
            x = r18;
            a r19 = new a("sampling_event", 19);
            y = r19;
            a r20 = new a("f_to_bytes_event", 20);
            z = r20;
            a r21 = new a("f_to_bytes_encrypt_event", 21);
            A = r21;
            a r22 = new a("large_event", 22);
            B = r22;
            a r23 = new a("f_expire_event", 23);
            C = r23;
            a r24 = new a("f_oom_event", 24);
            D = r24;
            E = new a[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) E.clone();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.applog.r.b$b, reason: collision with other inner class name */
    static class C0072b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f2337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f2338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2339c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f2340d;

        public C0072b(String r1, String r2, int r3, long r4) {
            this.f2337a = r1;
            this.f2338b = r2;
            this.f2339c = r3;
            this.f2340d = r4;
        }
    }

    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f2342b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f2343c;

        public c() {
            this.f2343c = System.currentTimeMillis();
        }

        public c(long r1) {
            this.f2343c = r1;
        }
    }

    public static final enum d extends Enum<d> {
        public static final d A = null;
        public static final d B = null;
        public static final d C = null;
        public static final d D = null;
        public static final d E = null;
        public static final d F = null;
        public static final d G = null;
        public static final d H = null;
        public static final d I = null;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public static final d f2344J = null;
        public static final d K = null;
        public static final d L = null;
        public static final d M = null;
        public static final d N = null;
        public static final d O = null;
        public static final d P = null;
        public static final d Q = null;
        public static final d R = null;
        public static final d S = null;
        public static final d T = null;
        public static final d U = null;
        public static final d V = null;
        public static final d W = null;
        public static final d X = null;
        public static final d Y = null;
        public static final d Z = null;
        public static final d a0 = null;
        public static final d b0 = null;
        public static final d c0 = null;
        public static final d d0 = null;
        public static final d e0 = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f2345f = null;
        public static final d f0 = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final d f2346g = null;
        public static final d g0 = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final d f2347h = null;
        public static final d h0 = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final d f2348i = null;
        public static final d i0 = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final d f2349j = null;
        public static final d j0 = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final d f2350k = null;
        public static final d k0 = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final d f2351l = null;
        private static final /* synthetic */ d[] l0 = null;
        public static final d m = null;
        public static final d n = null;
        public static final d o = null;
        public static final d p = null;
        public static final d q = null;
        public static final d r = null;
        public static final d s = null;
        public static final d t = null;
        public static final d u = null;
        public static final d v = null;
        public static final d w = null;
        public static final d x = null;
        public static final d y = null;
        public static final d z = null;

        static {
            f2345f = new d("monitor_default", 0);
            f2346g = new d("init", 1);
            f2347h = new d("f_block", 2);
            f2348i = new d("f_cache", 3);
            f2349j = new d("f_filter", 4);
            f2350k = new d("f_sampling", 5);
            f2351l = new d("f_db_insert", 6);
            m = new d("f_db_delete", 7);
            n = new d("f_to_pack", 8);
            o = new d("success", 9);
            p = new d("f_net", 10);
            q = new d("f_to_bytes", 11);
            r = new d("f_to_bytes_null", 12);
            s = new d("f_to_bytes_compress", 13);
            t = new d("f_to_bytes_encrypt", 14);
            u = new d("f_send_check", 15);
            v = new d("f_split_terminate", 16);
            w = new d("f_filter_terminate", 17);
            x = new d("f_congestion_control", 18);
            y = new d("f_backoff_ratio", 19);
            z = new d("f_device_none", 20);
            A = new d("f_resp_error", 21);
            B = new d("f_load", 22);
            C = new d("f_not_init", 23);
            D = new d("f_no_session", 24);
            E = new d("s_rt_net", 25);
            F = new d("f_rt_to_bytes", 26);
            G = new d("f_size_limit", 27);
            H = new d("f_log_size_limit", 28);
            I = new d("f_overflow", 29);
            f2344J = new d("f_log_overflow", 30);
            K = new d("f_stop", 31);
            L = new d("f_expire", 32);
            M = new d("f_no_network", 33);
            N = new d("f_exception", 34);
            O = new d("f_lost_impression", 35);
            P = new d("total_success", 36);
            Q = new d("f_net_minus", 37);
            R = new d("f_net_zero", 38);
            S = new d("f_net_10", 39);
            T = new d("f_net_11", 40);
            U = new d("f_net_12", 41);
            V = new d("f_net_13", 42);
            W = new d("f_net_14", 43);
            X = new d("f_net_15", 44);
            Y = new d("f_net_1xx", 45);
            Z = new d("f_net_2xx", 46);
            a0 = new d("f_net_3xx", 47);
            b0 = new d("f_net_4xx", 48);
            c0 = new d("f_net_5xx", 49);
            d0 = new d("is_first_launch", 50);
            e0 = new d("repeat_first_launch", 51);
            f0 = new d("increase_cursor_window_size", 52);
            g0 = new d("cursor_window_size_overflow", 53);
            h0 = new d("bdinstall_lost_header_ready_callback", 54);
            i0 = new d("engine_event_cache_overflow", 55);
            j0 = new d("break_pack_misc_other_exception", 56);
            k0 = new d("f_oom", 57);
            l0 = new d[]{f2345f, f2346g, f2347h, f2348i, f2349j, f2350k, f2351l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, f2344J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, a0, b0, c0, d0, e0, f0, g0, h0, i0, j0, k0};
        }

        private d(String r1, int r2) {
            super(r1, r2);
        }

        public static d valueOf(String r1) {
            return (d) Enum.valueOf(d.class, r1);
        }

        public static d[] values() {
            return (d[]) l0.clone();
        }
    }

    static {
        int r0 = a.values().length;
        o = 86400000;
    }

    public b(Looper r2, com.bytedance.applog.r.a r3) {
        this(r2, r3, "bdtracker_");
    }

    public b(Looper r3, com.bytedance.applog.r.a r4, String r5) {
        this.f2328k = new ConcurrentHashMap();
        this.n = 0;
        this.m = r5;
        this.f2326i = r4;
        if (r3 != null) goto L5;
        HandlerThread r6 = new HandlerThread("bd_monitor_wt");
        r6.start();
        r3 = r6.getLooper();
    L5:
        this.f2325h = new Handler(r3, this);
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private void b(Message r9) {
        if (this.f2327j != null) goto L5;
    L7:
        C0072b r0 = (C0072b) r9.obj;
        String r3 = r0.f2337a;
        String r4 = r0.f2338b;
        int r5 = r0.f2339c;
        long r6 = r0.f2340d;
        Map<String, c> r1 = this.f2328k.get(r3);
        if (r1 != null) goto L10;
        r1 = new HashMap(4);
        this.f2328k.put(r3, r1);
    L10:
        c r8 = r1.get(r4);
        if (r8 != null) goto L13;
        r8 = new c();
    L13:
        int r10 = r9.what;
        if (r10 != 2) goto L17;
        r8.f2341a += r5;
        r8.f2342b = -1;
    L19:
        r1.put(r4, r8);
        return;
    L17:
        if (r10 != 3) goto L19;
        r8.f2342b += r6;
        r8.f2341a++;
        goto L19
    L5:
        if (this.f2324g == true) goto L7;
        this.f2324g = true;
        this.f2325h.removeMessages(4);
        this.f2325h.sendEmptyMessageDelayed(4, BDLocationConfig.sScanBleMaxInterval);
        goto L7
    }

    private void c() {
        com.bytedance.applog.r.d r0 = this.f2329l;
        if (r0 != null) goto L5;
        this.f2329l = new com.bytedance.applog.r.d(this.f2327j, this.m);
    L7:
        if (this.f2328k.isEmpty() == false) goto L9;
        return;
    L9:
        this.f2329l.e(this.f2323f, e.c(this.f2328k));
        return;
    L5:
        r0.b();
        goto L7
    }

    private void d() {
        if (this.f2327j != null) goto L6;
        return;
    L6:
        if (this.f2329l != null) goto L8;
        this.f2329l = new com.bytedance.applog.r.d(this.f2327j, this.m);
    L8:
        com.bytedance.applog.r.d.a r0 = this.f2329l.c();
        this.f2328k = e.d(new Map[]{e.b(r0.f2357b), this.f2328k});
        this.f2323f = r0.f2356a;
        e();
    }

    private void e() {
        SharedPreferences r0 = a(this.f2327j, this.m + "monitor", 0);     // Catch: Throwable -> L8
        long r4 = r0.getLong("monitor_install_time3", 0);     // Catch: Throwable -> L8
        this.n = r4;     // Catch: Throwable -> L8
        if (r4 > 0) goto L5;
    L6:
        this.n = System.currentTimeMillis();     // Catch: Throwable -> L8
        r0.edit().putLong("monitor_install_time3", this.n).apply();     // Catch: Throwable -> L8
        return;
    L5:
        if (r4 > System.currentTimeMillis()) goto L6;
        return;
    }

    private boolean l() {
        List<com.bytedance.applog.r.c> r0 = e.a(this.f2328k);
        if (this.f2326i != null) goto L5;
        return false;
    L5:
        if (r0.size() != 0) goto L8;
        return false;
    L8:
        return this.f2326i.a(r0);
    }

    private void m() {
        if (this.f2327j != null) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis();
        if (Math.abs(r0 - this.f2323f) >= o) goto L8;
    L10:
        this.f2324g = false;
        c();
        return;
    L8:
        if (l() == false) goto L10;
        this.f2323f = r0;
        this.f2328k.clear();
        goto L10
    }

    public void f(a r2, d r3) {
        g(r2, r3, 1);
    }

    public void g(a r1, d r2, int r3) {
        if (r1 == null) goto L8;
        if (r2 == null) goto L9;
        if (r3 <= 0) goto L10;
        h(r1.name(), r2.name(), r3);
        return;
    L10:
        return;
    L9:
        return;
    }

    public void h(String r9, String r10, int r11) {
        if (r9 == null) goto L8;
        if (r10 == null) goto L9;
        if (r11 <= 0) goto L10;
        this.f2325h.obtainMessage(2, new C0072b(r9, r10, r11, -1)).sendToTarget();
        return;
    L10:
        return;
    L9:
        return;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r4) {
        int r0 = r4.what;
        if (r0 != 1) goto L5;
        d();
    L14:
        return true;
    L5:
        if (r0 != 2) goto L7;
    L12:
        b(r4);
        goto L14
    L7:
        if (r0 == 3) goto L12;
        if (r0 != 4) goto L14;
        m();
        goto L14
    }

    public void i(a r2, String r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        h(r2.name(), r3, 1);
    }

    public void j(String r9, String r10, long r11) {
        if (r9 == null) goto L9;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r11 <= 0) goto L11;
        this.f2325h.obtainMessage(3, new C0072b(r9, r10, 0, r11)).sendToTarget();
        return;
    L11:
        return;
    }

    public void k(a r3, d r4, long r5) {
        if (r3 == null) goto L9;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r5 <= 0) goto L11;
        j(r3.name(), r4.name(), r5);
        return;
    L11:
        return;
    }
}
