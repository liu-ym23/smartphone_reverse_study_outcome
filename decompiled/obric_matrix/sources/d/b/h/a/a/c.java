package d.b.h.a.a;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static volatile CopyOnWriteArrayList<InterfaceC0354c> c0;
    private static AtomicBoolean d0;
    public static volatile c e0;
    public long A;
    public long B;
    public long C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f13224J;
    public long K;
    public String L;
    public long M;
    public long N;
    public long O;
    public long P;
    public long Q;
    public long R;
    public long S;
    public long T;
    public long U;
    public long V;
    public long W;
    public long X;
    public long Y;
    public long Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f13225a;
    public long a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13226b;
    public long b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f13228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f13229e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f13230f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f13231g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f13232h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f13233i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f13234j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f13235k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f13236l;
    public long m;
    public long n;
    public long o;
    public long p;
    public long q;
    public long r;
    public long s;
    public long t;
    public long u;
    public long v;
    public long w;
    public long x;
    public long y;
    public long z;

    class a extends com.bytedance.common.utility.m.c {
        a(String r1) {
            super(r1);
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            Iterator r1 = c.a().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ((InterfaceC0354c) r1.next()).a();
            goto L4
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f13237g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f13238h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f13239i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final b f13240j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final b f13241k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final b f13242l = null;
        public static final b m = null;
        public static final b n = null;
        public static final b o = null;
        private static final /* synthetic */ b[] p = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f13243f;

        static {
            b r0 = new b("NONE", 0, 0);
            f13237g = r0;
            b r1 = new b("LAZY_INIT", 1, 1);
            f13238h = r1;
            b r3 = new b("PRE_INIT", 2, 2);
            f13239i = r3;
            b r5 = new b("FORCE_INIT", 3, 3);
            f13240j = r5;
            b r7 = new b("DEPRECATED_API", 4, 4);
            f13241k = r7;
            b r9 = new b("BIZ_HTTPDNS_API", 5, 5);
            f13242l = r9;
            b r11 = new b("ZSTD_API", 6, 6);
            m = r11;
            b r13 = new b("COOKIE_INIT_COMPLETE_API", 7, 7);
            n = r13;
            b r15 = new b("ACTIVITY_RESUME_SUSPEND", 8, 8);
            o = r15;
            p = new b[]{r0, r1, r3, r5, r7, r9, r11, r13, r15};
        }

        private b(String r1, int r2, int r3) {
            super(r1, r2);
            this.f13243f = r3;
        }

        public static b valueOf(String r1) {
            return (b) Enum.valueOf(b.class, r1);
        }

        public static b[] values() {
            return (b[]) p.clone();
        }
    }

    /* JADX INFO: renamed from: d.b.h.a.a.c$c, reason: collision with other inner class name */
    public interface InterfaceC0354c {
        void a();
    }

    static {
        c0 = new CopyOnWriteArrayList();
        d0 = new AtomicBoolean(false);
    }

    public c() {
        this.f13225a = b.f13237g;
        this.f13226b = true;
        this.f13228d = 0;
        this.f13229e = 0;
        this.f13230f = 0;
        this.f13231g = 0;
        this.f13232h = 0;
        this.f13233i = 0;
        this.f13234j = 0;
        this.f13235k = 0;
        this.f13236l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.K = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.a0 = 0;
        this.b0 = 0;
    }

    static /* synthetic */ CopyOnWriteArrayList a() {
        return c0;
    }

    private long e(long r3) {
        return (this.f13228d + r3) - this.f13229e;
    }

    private static long f(long r1, long r3) {
        long r2 = g(r1, r3);
        if (r2 != (-1)) goto L6;
        return -1;
    L6:
        return r2 / 1000;
    }

    private static long g(long r5, long r7) {
        if (r5 != 0) goto L5;
    L12:
        return -1;
    L5:
        if (r7 == 0) goto L12;
        if (r5 <= r7) goto L11;
        return -1;
    L11:
        return (r7 - r5) / 1000;
    }

    private static String h(long r0, long r2) {
        return String.valueOf(g(r0, r2));
    }

    public static c k() {
        if (e0 != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (e0 != null) goto L9;
        e0 = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return e0;
    }

    public static boolean l() {
        return d0.get();
    }

    private boolean n(Context r8, List<Long> r9) {
        HashMap r7 = null;
        Class<?> r0 = Class.forName("com.bytedance.mobsec.metasec.ml.MSB");     // Catch: ClassNotFoundException -> L5
    L6:
        if (r0 != null) goto L9;
        r0 = Class.forName("com.bytedance.mobsec.metasec.ov.MSB");     // Catch: ClassNotFoundException -> L19
    L9:
        if (r0 != null) goto L12;
        return false;
    L12:
        if (r9 != null) goto L22;
    L16:
        r0.getMethod("a", new Class[]{Context.class, Integer.TYPE, Map.class}).invoke(r0, new Object[]{r8, 1, r7});     // Catch: Throwable -> L18
        return true;
    L18:
        return false;
    L22:
        if (r9.size() != 2) goto L16;
        r7 = new HashMap();     // Catch: Throwable -> L18
        r7.put("http_callback", String.valueOf(r9.get(0)));     // Catch: Throwable -> L18
        r7.put("ws_callback", String.valueOf(r9.get(1)));     // Catch: Throwable -> L18
    L5:
        r0 = null;
        goto L6
    }

    public static void o(boolean r1) {
        d0.set(r1);
        if (c0.isEmpty() == false) goto L5;
        return;
    L5:
        new a("ttnet-init").b();
    }

    public boolean b() {
        if (this.f13228d != 0) goto L5;
    L57:
        return false;
    L5:
        if (this.f13229e == 0) goto L57;
        if (this.f13230f == 0) goto L57;
        if (this.f13231g == 0) goto L57;
        if (this.f13232h == 0) goto L57;
        if (this.f13233i == 0) goto L57;
        if (this.f13234j == 0) goto L57;
        if (this.f13235k == 0) goto L57;
        if (this.f13236l == 0) goto L57;
        if (this.n == 0) goto L57;
        if (this.o == 0) goto L57;
        if (this.p == 0) goto L57;
        if (this.q == 0) goto L57;
        if (this.r == 0) goto L57;
        if (this.s == 0) goto L57;
        if (this.t == 0) goto L57;
        if (this.u == 0) goto L57;
        if (this.v == 0) goto L57;
        if (this.w == 0) goto L57;
        if (this.x == 0) goto L57;
        if (this.y == 0) goto L57;
        if (this.z == 0) goto L57;
        if (this.A == 0) goto L57;
        if (this.B == 0) goto L57;
        if (this.C == 0) goto L57;
        if (this.D == 0) goto L57;
        if (this.E == 0) goto L57;
        return true;
    }

    public JSONObject c() {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();
        r0.put("mode", this.f13225a.f13243f);     // Catch: JSONException -> L14
        r0.put("is_main_process", this.f13226b);     // Catch: JSONException -> L14
        r0.put("net_thread_priority", this.f13227c);     // Catch: JSONException -> L14
        r1.put("ttnet_start", this.f13228d);     // Catch: JSONException -> L14
        r1.put("ttnet_end", e(this.f13232h));     // Catch: JSONException -> L14
        r1.put("engine_start", e(this.n));     // Catch: JSONException -> L14
        r1.put("engine_end", e(this.E));     // Catch: JSONException -> L14
        r1.put("init_start", e(this.F));     // Catch: JSONException -> L14
        r1.put("init_end", e(this.G));     // Catch: JSONException -> L14
        r1.put("preconnect_start", this.M);     // Catch: JSONException -> L14
        r2.put("builder_build", f(this.A, this.B));     // Catch: JSONException -> L14
        r2.put("load_cronet", f(this.H, this.I));     // Catch: JSONException -> L14
        r2.put("init_metasec", f(this.f13230f, this.f13231g));     // Catch: JSONException -> L14
        r2.put("init_ttnet", f(this.f13229e, this.f13232h));     // Catch: JSONException -> L14
        r2.put("init_mssdk", f(this.C, this.D));     // Catch: JSONException -> L14
        r2.put("create_engine", f(this.n, this.E));     // Catch: JSONException -> L14
        r2.put("init_thread", f(this.F, this.G));     // Catch: JSONException -> L14
        r2.put("init_total", f(Math.min(this.f13228d, this.m) * TimeUtils.NANOSECONDS_PER_MILLISECOND, this.O * TimeUtils.NANOSECONDS_PER_MILLISECOND));     // Catch: JSONException -> L14
        r2.put("init_preconnect", f(this.f13228d, this.M));     // Catch: JSONException -> L14
        long r4 = this.N;     // Catch: JSONException -> L14
        long r6 = this.O;     // Catch: JSONException -> L14
        long r9 = -1;
        if (r4 <= r6) goto L6;
        long r7 = -1;
    L7:
        r2.put("network_thread", r7);     // Catch: JSONException -> L14
        long r5 = this.O;     // Catch: JSONException -> L14
        long r8 = this.P;     // Catch: JSONException -> L14
        if (r5 > r8) goto L11;
        r9 = r8 - r5;     // Catch: JSONException -> L14
    L11:
        r2.put("exec_tasks", r9);     // Catch: JSONException -> L14
        r2.put("nqe_init", this.Q);     // Catch: JSONException -> L14
        r2.put("prefs_init", this.R);     // Catch: JSONException -> L14
        r2.put("channel_init", this.S);     // Catch: JSONException -> L14
        r2.put("context_build", this.T);     // Catch: JSONException -> L14
        r2.put("tnc_config", this.U);     // Catch: JSONException -> L14
        r2.put("update_appinfo", this.V);     // Catch: JSONException -> L14
        r2.put("netlog_init", this.W);     // Catch: JSONException -> L14
        r2.put("nqe_detect", this.X);     // Catch: JSONException -> L14
        r2.put("preconnect", this.Y);     // Catch: JSONException -> L14
        r2.put("ssl_session", this.Z);     // Catch: JSONException -> L14
        r2.put("ttnet_config", this.a0);     // Catch: JSONException -> L14
        r2.put("install_cert", this.b0);     // Catch: JSONException -> L14
        r0.put("ttnet_timestamp", r1);     // Catch: JSONException -> L14
        r0.put("ttnet_duration", r2);     // Catch: JSONException -> L14
        r0.put("ab_test", this.L);     // Catch: JSONException -> L14
        goto L12
    L6:
        r7 = r6 - r4;     // Catch: JSONException -> L14
    L12:
        Logger.debug();
        return r0;
    }

    public JSONObject d(long r12) {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L8
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L8
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L8
        r3.put("mssdk", h(this.C, this.D));     // Catch: Exception -> L8
        r3.put("app_info_subset", h(this.q, this.r));     // Catch: Exception -> L8
        r3.put("thread_config_list", h(this.s, this.t));     // Catch: Exception -> L8
        r3.put("sla_samp_setting", h(this.w, this.x));     // Catch: Exception -> L8
        r3.put("build_ctx_config", h(this.y, this.z));     // Catch: Exception -> L8
        r3.put("init_total", h(Math.min(this.f13228d, this.m) * TimeUtils.NANOSECONDS_PER_MILLISECOND, this.O * TimeUtils.NANOSECONDS_PER_MILLISECOND));     // Catch: Exception -> L8
        String r4 = "-1";
        if (r12 == (-1)) goto L6;
        r4 = h(r12, this.f13229e);     // Catch: Exception -> L8
    L6:
        r3.put("app_init_time", r4);     // Catch: Exception -> L8
        r2.put("cross_plfm", r3);     // Catch: Exception -> L8
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L8
        r13.put("ttnet_init", h(this.f13229e, this.f13232h));     // Catch: Exception -> L8
        r13.put("init_stack_config", h(this.f13235k, this.f13236l));     // Catch: Exception -> L8
        r13.put("get_stack_config", h(this.o, this.p));     // Catch: Exception -> L8
        r13.put("init_cookie_mgr", h(this.f13233i, this.f13234j));     // Catch: Exception -> L8
        r13.put("pre_init_mssdk", h(this.f13230f, this.f13231g));     // Catch: Exception -> L8
        r13.put("builder_build", h(this.A, this.B));     // Catch: Exception -> L8
        r13.put("create_engine", h(this.n, this.E));     // Catch: Exception -> L8
        r13.put("cronet_init_thread", h(this.F, this.G));     // Catch: Exception -> L8
        r13.put("cronet_load_so", h(this.H, this.I));     // Catch: Exception -> L8
        r13.put("thread_config_callback", h(this.u, this.v));     // Catch: Exception -> L8
        r2.put("android_spec", r13);     // Catch: Exception -> L8
        r1.put("durations_us", r2);     // Catch: Exception -> L8
        r1.put("cronet_init_mode", this.f13225a.f13243f);     // Catch: Exception -> L8
        r0.put("ttnet_layer", r1);     // Catch: Exception -> L8
        r0.put("cronet_layer", new JSONObject(this.f13224J));     // Catch: Exception -> L8
        r0.put("ab_test", this.L);     // Catch: Exception -> L8
    L7:
        return r0;
    }

    public void i(Context r3, List<Long> r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.size() != 2) goto L12;
        Logger.debug();
        this.C = System.nanoTime();
        if (n(r3, r4) == true) goto L9;
        Logger.debug();
    L9:
        this.D = System.nanoTime();
        return;
    }

    public void j(Context r3) {
        this.f13230f = System.nanoTime();
        n(r3, null);
        this.f13231g = System.nanoTime();
    }

    public boolean m() {
        b r1 = this.f13225a;
        if (r1 != b.f13239i) goto L5;
    L8:
        return true;
    L5:
        if (r1 == b.f13240j) goto L8;
        return false;
    }
}
