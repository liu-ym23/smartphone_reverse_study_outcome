package d.b.s.a.i0;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a0;
import kotlin.f0;
import kotlin.n0.c.p;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.u;
import kotlin.u0.k;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Map<String, d> f14794f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile int f14795g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static c f14796h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f14797i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile d.b.s.a.i0.a f14798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f14799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f14800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile SharedPreferences f14801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f14802e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }

        public final d a() {
            return d.f14797i.b("_Default");
        }

        public final d b(String r3) {
            o.g(r3, "name");
            d r2 = (d) d.b().get(r3);
            if (r2 == null) goto L5;
            return r2;
        L5:
            Map r4 = d.b();
            monitor-enter(r4);
            d r0 = (d) d.b().get(r3);     // Catch: Throwable -> L14
            if (r0 == null) goto L11;
            monitor-exit(r4);
            return r0;
        L11:
            d r1 = new d(r3);     // Catch: Throwable -> L14
            d.b().put(r3, r1);     // Catch: Throwable -> L14
            monitor-exit(r4);
            return r1;
        L14:
            th = move-exception;
            throw th;
        }
    }

    static final class b extends q implements p<Long, Integer, d.b.s.a.i0.b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f14803f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f14804g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f14805h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f14806i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ boolean f14807j;

        b(d r1, long r2, int r4, long r5, boolean r7) {
            this.f14803f = r1;
            this.f14804g = r2;
            this.f14805h = r4;
            this.f14806i = r5;
            this.f14807j = r7;
            super(2);
        }

        public final d.b.s.a.i0.b a(long r15, int r17) {
            long r4 = this.f14804g;
            int r11 = this.f14805h;
            d.b.s.a.i0.b r10 = new d.b.s.a.i0.b(r15, r4, r17, r11);
            if (r11 == d.c()) goto L6;
            d.d(this.f14805h);
            StringBuilder r1 = new StringBuilder();
            r1.append("getCurrentTime finish, result: ");
            r1.append(r15);
            r1.append(", ");
            r1.append("timeSource: ");
            r1.append(r17);
            r1.append("， flag: ");
            String r3 = Integer.toBinaryString(this.f14805h);
            o.b(r3, "Integer.toBinaryString(reportFlags)");
            r1.append(k.a0(r3, 8, '0'));
            d.b.s.a.a0.a.a("RealTimeManager", r1.toString());
        L6:
            long r5 = Math.abs(r15 - this.f14806i);
            if (r5 <= 3600000) goto L11;
            d.b.s.a.a0.a.h("RealTimeManager", "Get time failed. System time: " + this.f14806i + ", Calibrated time: " + r15 + ", diff: " + r5);
            if (this.f14807j == false) goto L11;
            e.f14809b.e(this.f14803f.i(), r15, r17, this.f14804g, this.f14806i, this.f14805h);
        L11:
            return r10;
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ d.b.s.a.i0.b invoke(Long r3, Integer r4) {
            return a(r3.longValue(), r4.intValue());
        }
    }

    static {
        f14797i = new a(null);
        f14794f = new ConcurrentHashMap();
    }

    public d(String r2) {
        o.g(r2, "instanceName");
        this.f14802e = r2;
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    public static final /* synthetic */ Map b() {
        return f14794f;
    }

    public static final /* synthetic */ int c() {
        return f14795g;
    }

    public static final /* synthetic */ void d(int r0) {
        f14795g = r0;
    }

    private final int f(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        if (r1 == false) goto L4;
        int r0 = 1;
    L5:
        if (r2 == false) goto L7;
        r0 = r0 | 8;
    L7:
        if (r3 == false) goto L9;
        r0 = r0 | 2;
    L9:
        if (r4 == false) goto L11;
        r0 = r0 | 4;
    L11:
        if (r5 == false) goto L13;
        r0 = r0 | 16;
    L13:
        if (r6 == false) goto L15;
        r0 = r0 | 32;
    L15:
        if (r7 == false) goto L17;
        r0 = r0 | 64;
    L17:
        if (r8 == true) goto L19;
        return r0;
    L19:
        return r0 | 128;
    L4:
        r0 = 0;
        goto L5
    }

    public static final d h() {
        return f14797i.a();
    }

    private final String j() {
        if (o.a(this.f14802e, "_Default") == false) goto L6;
        return "tt_token_time";
    L6:
        return "tt_token_time_instance_" + this.f14802e;
    }

    private final u<Boolean, Integer> l(Context r1, boolean r2, d.b.s.a.i0.a r3, boolean r4, long r5) {
        if (r4 == true) goto L17;
        int r6 = f.f14823d.a(r1);
        if (r3 == null) goto L14;
        if (r6 == (-1)) goto L14;
        if (r3.c() != r6) goto L14;
        if (r5 < r3.a()) goto L14;
        boolean r0 = false;
    L16:
        return a0.a(Boolean.valueOf(r0), Integer.valueOf(r6));
    L14:
        r0 = true;
        goto L16
    L17:
        return a0.a(Boolean.FALSE, -1);
    }

    private final boolean m(long r1, long r3, long r5, long r7) {
        if (Math.abs((r1 - r3) - (r5 - r7)) <= 60000) goto L5;
        return true;
    L5:
        return false;
    }

    private final void n(Context r12) {
        SharedPreferences r13 = p(r12);
        if (r13 == null) goto L12;
        long r4 = r13.getLong("serverTimeMillis", 0);
        long r6 = r13.getLong("systemTimeMillis", 0);
        long r8 = r13.getLong("elapsedRealTimeMillis", 0);
        int r10 = r13.getInt("systemBootTimes", -1);
        if (r4 > 0) goto L7;
        return;
    L7:
        if (r6 > 0) goto L9;
        return;
    L9:
        if (r8 <= 0) goto L15;
        this.f14798a = new d.b.s.a.i0.a(r4, r6, r8, r10);
        return;
    L15:
        return;
    }

    private final void o(Context r4) {
        SharedPreferences r5 = p(r4);
        if (r5 == null) goto L10;
        d.b.s.a.i0.a r3 = this.f14798a;
        if (r3 != null) goto L9;
        SharedPreferences.Editor r6 = r5.edit().clear();
    L7:
        r6.apply();
        return;
    L9:
        r6 = r5.edit().putLong("serverTimeMillis", r3.b()).putLong("systemTimeMillis", r3.d()).putLong("elapsedRealTimeMillis", r3.a()).putInt("systemBootTimes", r3.c());
        goto L7
    }

    private final SharedPreferences p(Context r3) {
        if (this.f14801d != null) goto L15;
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (this.f14801d != null) goto L8;
        this.f14801d = a(r3, j(), 0);     // Catch: Throwable -> L11
    L8:
        f0 r4 = f0.f18324a;     // Catch: Throwable -> L11
        monitor-exit(this);
    L15:
        return this.f14801d;
    }

    private final void q(Context r2) {
        if (this.f14800c == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.f14800c == false) goto L10;
        monitor-exit(this);
        return;
    L10:
        n(r2);     // Catch: Throwable -> L13
        this.f14800c = true;     // Catch: Throwable -> L13
        f0 r3 = f0.f18324a;     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    public final void e(Context r17, long r18, long r20, long r22, boolean r24) {
        o.g(r17, "context");
        f r2 = f.f14823d;
        int r14 = r2.a(r17);
        boolean r15 = r2.b(r17, r20);
        monitor-enter(this);
        this.f14799b = true;     // Catch: Throwable -> L9
        this.f14798a = new d.b.s.a.i0.a(r18, r20, r22, r14);     // Catch: Throwable -> L9
        f0 r0 = f0.f18324a;     // Catch: Throwable -> L9
        monitor-exit(this);
        d.b.s.a.a0.a.d("RealTimeManager", "[Time Calibration] System time is quicker by " + (r20 - r18) + " ms");
        o(r17);
        d.b.s.a.a0.a.d("RealTimeManager", "calibrateTime\nserverTimeMillis=" + r18 + "\ncurrentSystemTimeMillis=" + r20 + "\nelapsedRealTimeMillis=" + r22 + "\nsystemBootTimes=" + r14 + "\nisSystemTimeSyncWithNetwork=" + r15 + '\n');
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final d.b.s.a.i0.b g(Context r26, boolean r27, boolean r28) {
        o.g(r26, "context");
        q(r26);
        monitor-enter(this);
        long r11 = System.currentTimeMillis();     // Catch: Throwable -> L65
        long r13 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L65
        d.b.s.a.i0.a r15 = this.f14798a;     // Catch: Throwable -> L65
        c r1 = f14796h;     // Catch: Throwable -> L65
        if (r1 == null) goto L7;
        long r8 = r1.a();     // Catch: Throwable -> L65
    L8:
        boolean r6 = this.f14799b;     // Catch: Throwable -> L65
        f0 r2 = f0.f18324a;     // Catch: Throwable -> L65
        monitor-exit(this);
        boolean r16 = f.f14823d.b(r26, r11);
        if (r15 == null) goto L13;
        long r17 = r15.b();
    L14:
        u<Boolean, Integer> r3 = l(r26, r27, r15, r6, r13);
        boolean r19 = r3.a().booleanValue();
        int r4 = r3.b().intValue();
        if (r19 == false) goto L26;
        if (r15 != null) goto L18;
    L21:
        boolean r5 = false;
    L22:
        if (r5 == false) goto L25;
        if (r27 == false) goto L25;
        e.f14809b.d(this.f14802e);
    L25:
        r13 = r13;
        boolean r7 = false;
        r8 = r8;
        boolean r9 = r5;
    L31:
        if (r8 <= 1000000000000L) goto L33;
        boolean r23 = true;
    L35:
        if (r8 <= 0) goto L40;
        if (r23 == true) goto L40;
        d.b.s.a.a0.a.b("RealTimeManager", "Invalid third paty time, please check if this is in milliseconds: " + r8);
        if (r27 == false) goto L40;
        e.f14809b.g(this.f14802e);
    L40:
        if (r15 == null) goto L42;
        boolean r10 = true;
    L43:
        b r0 = new b(this, r17, f(r10, r16, r23, r19, r6, r7, r9, r28), r11, r27);
        if (r15 != null) goto L50;
        if (r16 == true) goto L70;
        if (r23 == false) goto L70;
        return r0.a(r8, 3);
    L70:
        return r0.a(r11, 4);
    L50:
        if (r28 == false) goto L54;
        if (r16 == false) goto L54;
        return r0.a(r11, 4);
    L54:
        if (r19 == true) goto L58;
        long r12 = r15.b() + (r13 - r15.a());
        int r14 = 1;
    L57:
        return r0.a(r12, r14);
    L58:
        if (r16 == true) goto L60;
        if (r23 == true) goto L63;
        r12 = r15.b() + (r11 - r15.d());
        r14 = 2;
        goto L57
    L63:
        return r0.a(r8, 3);
    L60:
        return r0.a(r11, 4);
    L42:
        r10 = false;
        goto L43
    L33:
        r23 = false;
        goto L35
    L18:
        if (r15.c() <= r4) goto L21;
        if (r4 <= 0) goto L21;
        r5 = true;
        goto L22
    L26:
        if (r15 == null) goto L28;
        boolean r18 = m(r11, r13, r15.d(), r15.a());
    L29:
        r7 = r18;
        r9 = false;
        goto L31
    L28:
        r18 = false;
        goto L29
    L13:
        r17 = -1;
        goto L14
    L7:
        r8 = -1;
    L65:
        th = move-exception;
        throw th;
    }

    public final String i() {
        return this.f14802e;
    }

    public final boolean k() {
        if (this.f14798a == null) goto L5;
        return true;
    L5:
        return false;
    }
}
