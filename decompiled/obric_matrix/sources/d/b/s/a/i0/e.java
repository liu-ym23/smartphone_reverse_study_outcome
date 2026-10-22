package d.b.s.a.i0;

import android.os.SystemClock;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.u;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Long> f14808a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f14809b = null;

    static final class a extends q implements kotlin.n0.c.a<JSONObject> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f14810f;

        a(String r1) {
            this.f14810f = r1;
            super(0);
        }

        public final JSONObject a() {
            return e.a(e.f14809b, new u[]{a0.a("instance_name", this.f14810f)});
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ JSONObject invoke() {
            return a();
        }
    }

    static final class b extends q implements kotlin.n0.c.a<JSONObject> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f14811f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f14812g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f14813h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f14814i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ long f14815j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f14816k;

        b(String r1, long r2, int r4, long r5, long r7, int r9) {
            this.f14811f = r1;
            this.f14812g = r2;
            this.f14813h = r4;
            this.f14814i = r5;
            this.f14815j = r7;
            this.f14816k = r9;
            super(0);
        }

        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v16, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r2v22 */
        /* JADX WARN: Type inference failed for: r2v23, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r2v30 */
        /* JADX WARN: Type inference failed for: r2v31 */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v2, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r5v13 */
        /* JADX WARN: Type inference failed for: r5v14, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r5v19 */
        /* JADX WARN: Type inference failed for: r5v20, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r5v25 */
        /* JADX WARN: Type inference failed for: r5v26, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r5v29 */
        /* JADX WARN: Type inference failed for: r5v30 */
        /* JADX WARN: Type inference failed for: r5v31 */
        /* JADX WARN: Type inference failed for: r5v32 */
        /* JADX WARN: Type inference failed for: r5v6 */
        /* JADX WARN: Type inference failed for: r5v7, types: [boolean, int] */
        public final JSONObject a() {
            e r0 = e.f14809b;
            u[] r1 = new u[13];
            ?? r3 = 0;
            r1[0] = a0.a("instance_name", this.f14811f);
            r1[1] = a0.a("result_time", Long.valueOf(this.f14812g));
            r1[2] = a0.a("time_source", Integer.valueOf(this.f14813h));
            r1[3] = a0.a("time_diff", Long.valueOf(Math.abs(this.f14812g - this.f14814i)));
            r1[4] = a0.a("current_system_time", Long.valueOf(this.f14814i));
            r1[5] = a0.a("server_time", Long.valueOf(this.f14815j));
            if ((this.f14816k & 2) == 0) goto L5;
            ?? r2 = 1;
        L6:
            e.b(r0, r2);
            r1[6] = a0.a("has_third_party_time", Integer.valueOf(r2));
            if ((this.f14816k & 4) == 0) goto L9;
            ?? r5 = 1;
        L10:
            e.b(r0, r5);
            r1[7] = a0.a("is_system_rebooted", Integer.valueOf(r5));
            if ((this.f14816k & 8) == 0) goto L13;
            ?? r4 = 1;
        L14:
            e.b(r0, r4);
            r1[8] = a0.a("is_system_time_reliable", Integer.valueOf(r4));
            if ((this.f14816k & 16) == 0) goto L17;
            ?? r6 = 1;
        L18:
            e.b(r0, r6);
            r1[9] = a0.a("is_process_still_running", Integer.valueOf(r6));
            if ((this.f14816k & 32) == 0) goto L21;
            ?? r7 = 1;
        L22:
            e.b(r0, r7);
            r1[10] = a0.a("is_time_probably_changed", Integer.valueOf(r7));
            if ((this.f14816k & 64) == 0) goto L25;
            ?? r8 = 1;
        L26:
            e.b(r0, r8);
            r1[11] = a0.a("is_device_probably_changed", Integer.valueOf(r8));
            if ((this.f14816k & 128) == 0) goto L29;
            r3 = 1;
        L29:
            e.b(r0, r3);
            r1[12] = a0.a("is_loose_mode", Integer.valueOf(r3));
            return e.a(r0, r1);
        L25:
            r8 = 0;
            goto L26
        L21:
            r7 = 0;
            goto L22
        L17:
            r6 = 0;
            goto L18
        L13:
            r4 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ JSONObject invoke() {
            return a();
        }
    }

    static final class c extends q implements kotlin.n0.c.a<JSONObject> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f14817f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f14818g;

        c(long r1, String r3) {
            this.f14817f = r1;
            this.f14818g = r3;
            super(0);
        }

        public final JSONObject a() {
            return e.a(e.f14809b, new u[]{a0.a("request_duration", Long.valueOf(this.f14817f)), a0.a("source", this.f14818g)});
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ JSONObject invoke() {
            return a();
        }
    }

    static final class d extends q implements kotlin.n0.c.a<JSONObject> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f14819f;

        d(String r1) {
            this.f14819f = r1;
            super(0);
        }

        public final JSONObject a() {
            return e.a(e.f14809b, new u[]{a0.a("instance_name", this.f14819f)});
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ JSONObject invoke() {
            return a();
        }
    }

    static {
        f14809b = new e();
        f14808a = new ConcurrentHashMap();
    }

    private e() {
    }

    public static final /* synthetic */ JSONObject a(e r0, u... r1) {
        return r0.c(r1);
    }

    public static final /* synthetic */ int b(e r0, boolean r1) {
        r0.i(r1);
        return r1 ? 1 : 0;
    }

    private final JSONObject c(u<String, ? extends Object>... r5) {
        JSONObject r4 = new JSONObject();     // Catch: JSONException -> L6
        int r0 = r5.length;     // Catch: JSONException -> L6
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        u<String, ? extends Object> r2 = r5[r1];     // Catch: JSONException -> L6
        r4.put(r2.c(), r2.d());     // Catch: JSONException -> L6
        r1 = r1 + 1;
        goto L3
    L11:
        return r4;
    L7:
        return new JSONObject();
    }

    private final void h(String r8, long r9, kotlin.n0.c.a<? extends JSONObject> r11) {
        long r0 = SystemClock.elapsedRealtime();
        Map<String, Long> r7 = f14808a;
        Long r2 = r7.get(r8);
        if (r2 == null) goto L5;
        long r5 = r2.longValue();
    L7:
        if (r9 > 0) goto L9;
    L13:
        if (r9 <= 0) goto L20;
        r7.put(r8, Long.valueOf(r0));
    L20:
        com.bytedance.sdk.account.monitor.a.b(r8, r11);     // Catch: JSONException -> L17
        return;
    L17:
        e = move-exception;
        d.b.s.a.a0.a.c("RealTimeMonitor", "Error assembling report params", e);
        return;
    L9:
        if (r0 <= r5) goto L13;
        if ((r0 - r5) >= r9) goto L13;
        return;
    L5:
        r5 = 0;
        goto L7
    }

    private final int i(boolean r1) {
        return r1 ? 1 : 0;
    }

    public final void d(String r4) {
        o.g(r4, "instanceName");
        h("passport_time_device_probably_changed", 3600000, new a(r4));
    }

    public final void e(String r12, long r13, int r15, long r16, long r18, int r20) {
        o.g(r12, "instanceName");
        h("passport_time_anomaly", 600000, new b(r12, r13, r15, r18, r16, r20));
    }

    public final void f(long r2, String r4) {
        o.g(r4, "source");
        h("passport_time_request_takes_too_long", 600000, new c(r2, r4));
    }

    public final void g(String r4) {
        o.g(r4, "instanceName");
        h("passport_time_third_party_time_invalid", 600000, new d(r4));
    }
}
