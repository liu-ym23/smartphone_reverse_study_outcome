package d.h.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e extends d.c.i.m.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
    private static ExecutorService f16998c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, g> f16999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.facebook.net.b f17000b;

    static class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable r2) {
            return new Thread(r2, "fresco-trace-monitor");
        }
    }

    class b implements com.facebook.net.b {
        b(e r1) {
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d.c.i.q.b f17001f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f17002g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f17003h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ e f17004i;

        c(e r1, d.c.i.q.b r2, String r3, long r4) {
            this.f17004i = r1;
            this.f17001f = r2;
            this.f17002g = r3;
            this.f17003h = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.m(this.f17004i, this.f17001f, this.f17002g, this.f17003h);
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d.c.i.q.b f17005f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f17006g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f17007h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Throwable f17008i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ e f17009j;

        d(e r1, d.c.i.q.b r2, String r3, long r4, Throwable r6) {
            this.f17009j = r1;
            this.f17005f = r2;
            this.f17006g = r3;
            this.f17007h = r4;
            this.f17008i = r6;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.n(this.f17009j, this.f17005f, this.f17006g, this.f17007h, this.f17008i);
        }
    }

    /* JADX INFO: renamed from: d.h.a.e$e, reason: collision with other inner class name */
    class RunnableC0448e implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f17010f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f17011g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ e f17012h;

        RunnableC0448e(e r1, String r2, long r3) {
            this.f17012h = r1;
            this.f17010f = r2;
            this.f17011g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.o(this.f17012h, this.f17010f, this.f17011g);
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d.c.i.q.b f17013f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f17014g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f17015h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f17016i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ e f17017j;

        f(e r1, d.c.i.q.b r2, String r3, boolean r4, long r5) {
            this.f17017j = r1;
            this.f17013f = r2;
            this.f17014g = r3;
            this.f17015h = r4;
            this.f17016i = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.p(this.f17017j, this.f17013f, this.f17014g, this.f17015h, this.f17016i);
        }
    }

    class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f17018a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Map<String, Long> f17019b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        JSONObject f17020c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f17021d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f17022e;

        g(e r1) {
            this.f17019b = new HashMap();
            this.f17022e = true;
        }
    }

    static {
        f16998c = Executors.newFixedThreadPool(1, new a());
    }

    public e() {
        this.f17000b = new b(this);
        this.f16999a = new ConcurrentHashMap();
        com.facebook.net.a.f(this.f17000b);
    }

    private JSONObject A(JSONObject r4) {
        JSONObject r3 = new JSONObject();
        Iterator<String> r0 = r4.keys();
    L4:
        if (r0.hasNext() == false) goto L8;
        String r1 = r0.next();
        r3.put(r1, r4.opt(r1));     // Catch: JSONException -> L9
        goto L4
    L8:
        return r3;
    }

    static /* synthetic */ void m(e r0, d.c.i.q.b r1, String r2, long r3) {
        r0.z(r1, r2, r3);
    }

    static /* synthetic */ void n(e r0, d.c.i.q.b r1, String r2, long r3, Throwable r5) {
        r0.x(r1, r2, r3, r5);
    }

    static /* synthetic */ void o(e r0, String r1, long r2) {
        r0.w(r1, r2);
    }

    static /* synthetic */ void p(e r0, d.c.i.q.b r1, String r2, boolean r3, long r4) {
        r0.y(r1, r2, r3, r4);
    }

    private static String q(String r1, Object... r2) {
        return String.format(null, r1, r2);
    }

    private long r(@Nullable Long r1, long r2) {
        if (r1 != null) goto L4;
        return -1;
    L4:
        return r2 - r1.longValue();
    }

    private long t() {
        return System.currentTimeMillis();
    }

    private boolean u(d.c.i.q.b r13, String r14, Object r15, JSONObject r16, boolean r17, boolean r18, boolean r19) {
        JSONObject r8 = A(r16);
        d.h.a.f r1 = d.h.a.d.b();
        if (r1 == null) goto L14;
        Pair<Boolean, Map<String, Object>> r7 = null;
        r7 = r1.a(r13, r15, r14, r8, r17);     // Catch: Exception -> L36
    L6:
        if (r7 == null) goto L14;
        boolean r2 = ((Boolean) r7.first).booleanValue();
        Map r3 = (Map) r7.second;
        if (r3 != null) goto L39;
    L15:
        List<d.h.a.g> r9 = d.h.a.d.f16993c;
        monitor-enter(r9);
        Iterator<d.h.a.g> r10 = r9.iterator();     // Catch: Throwable -> L33
        boolean r11 = r2;
    L19:
        if (r10.hasNext() == false) goto L31;
        Pair<Boolean, Map<String, Object>> r4 = r10.next().a(r13, r15, r14, r8, r17, r19);     // Catch: Throwable -> L33
        if (r4 == null) goto L19;
        if (r11 == true) goto L24;
        r11 = ((Boolean) r4.first).booleanValue();     // Catch: Throwable -> L33
    L24:
        Map r5 = (Map) r4.second;     // Catch: Throwable -> L33
        if (r5 == null) goto L19;
        Iterator r6 = r5.keySet().iterator();     // Catch: JSONException -> L38 Throwable -> L33
    L28:
        if (r6.hasNext() == false) goto L19;
        String r12 = (String) r6.next();     // Catch: JSONException -> L38 Throwable -> L33
        r16.put(r12, r5.get(r12));     // Catch: JSONException -> L38 Throwable -> L33
    L31:
        monitor-exit(r9);     // Catch: Throwable -> L33
        return r11;
    L33:
        th = move-exception;
        throw th;
    L39:
        Iterator r20 = r3.keySet().iterator();     // Catch: JSONException -> L37
    L11:
        if (r20.hasNext() == false) goto L15;
        String r21 = (String) r20.next();     // Catch: JSONException -> L37
        r16.put(r21, r3.get(r21));     // Catch: JSONException -> L37
    L14:
        r2 = r18;
        goto L15
    }

    private static boolean v(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        if (r2.contains("Canceled") == false) goto L8;
    L9:
        return true;
    L8:
        if (r2.contains("canceled") == true) goto L9;
        return false;
    }

    private void w(String r12, long r13) {
        g r2 = this.f16999a.remove(r12);
        if (r2 != null) goto L5;
        return;
    L5:
        int r6 = 1;
        if (d.h.a.d.c() == false) goto L8;
        d.i.a.a.a.e("Fresco", q("time %d: onRequestCancellation: {requestId: %s, elapsedTime: %d ms}", new Object[]{Long.valueOf(r13), r12, Long.valueOf(r(Long.valueOf(r2.f17018a), r13))}));
    L8:
        JSONObject r8 = r2.f17020c;
        r8.put("load_status", "cancel");     // Catch: JSONException -> L15
        r8.put(TypedValues.TransitionType.S_DURATION, r(Long.valueOf(r2.f17018a), r13));     // Catch: JSONException -> L15
        r8.put("timestamp", Long.valueOf(r2.f17018a));     // Catch: JSONException -> L15
        if (com.facebook.net.d.a().b() == true) goto L13;
        r6 = 0;
    L13:
        r8.put("retry_open", r6);     // Catch: JSONException -> L15
    L17:
        u(null, r12, r2.f17021d, r8, false, r8.optBoolean("is_request_network", false), true);
        return;
    L15:
        e = move-exception;
        d.c.c.e.a.m("FrescoTraceListener", e, "", new Object[0]);
        goto L17
    }

    private void x(d.c.i.q.b r27, String r28, long r29, Throwable r31) {
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("FrescoMonitor#onRequestFailure");
    L5:
        g r15 = this.f16999a.remove(r28);
        if (r15 != null) goto L8;
        return;
    L8:
        JSONObject r8 = r15.f17020c;
        if (d.h.a.d.c() == false) goto L16;
        if (r31 == null) goto L12;
        String r0 = r31.toString();
    L13:
        String r19 = "";
        String r1 = q("time %d: onRequestFailure: {url: %s, requestId: %s, elapsedTime: %d ms, throwable: %s}", new Object[]{Long.valueOf(r29), r27.v().toString(), r28, Long.valueOf(r(Long.valueOf(r15.f17018a), r29)), r0});
        if (v(r0) == true) goto L18;
        d.i.a.a.a.g("Fresco", r1, r31);
    L18:
        if (d.h.a.d.e() == true) goto L20;
        boolean r2 = r8.optBoolean("is_request_network", false);
    L24:
        boolean r21 = r2;
        if (r31 != null) goto L27;
        int r3 = 200;
    L28:
        int r5 = r3;
        Object r4 = r15.f17021d;     // Catch: JSONException -> L42
        if ((r4 instanceof String) == false) goto L32;
        r8.put("scene_tag", r4);     // Catch: JSONException -> L42
    L32:
        r8.put("load_status", "fail");     // Catch: JSONException -> L42
        r8.put(TypedValues.TransitionType.S_DURATION, r(Long.valueOf(r15.f17018a), r29));     // Catch: JSONException -> L42
        r8.put(LocationMonitorConst.ERR_CODE, r5);     // Catch: JSONException -> L42
        r8.put("err_desc", Log.getStackTraceString(r31));     // Catch: JSONException -> L42
        r8.put("timestamp", Long.valueOf(r15.f17018a));     // Catch: JSONException -> L42
        r8.put("log_type", "image_monitor_v2");     // Catch: JSONException -> L42
        r8.put("log_version", 1);     // Catch: JSONException -> L40
        r8.put("uri", r27.v().toString());     // Catch: JSONException -> L40
        r8.put("image_sdk_version", "1.13.23.4");     // Catch: JSONException -> L40
        if (com.facebook.net.d.a().b() == false) goto L37;
        int r6 = 1;
    L38:
        r8.put("retry_open", r6);     // Catch: JSONException -> L40
        String r7 = r19;
    L45:
        String r23 = r7;
        u(r27, r28, r15.f17021d, r8, false, r21, false);
        if (r21 == false) goto L64;
        int r9 = h.b(r31);
        JSONObject r10 = r8.optJSONObject("image_monitor_data");     // Catch: JSONException -> L60
        if (r10 == null) goto L59;
        r10.put("image_status", r9);     // Catch: JSONException -> L60
        char r11 = 1;
        if (r5 == 1) goto L54;
        boolean r12 = true;
    L79:
        r10.put("image_load_error_code", h.a(r31, r12));     // Catch: JSONException -> L57
        r10.put("disk_cache_type", h.c(r27.d()));     // Catch: JSONException -> L57
    L63:
        char r13 = 0;
        d.h.a.d.g(false, r28, r8);
    L66:
        if (d.h.a.d.c() == false) goto L74;
        if (r31 == null) goto L69;
        String r14 = r31.toString();
    L70:
        Object[] r16 = new Object[6];
        r16[r13] = Long.valueOf(r29);
        r16[r11] = r27.v().toString();
        r16[2] = r28;
        r16[3] = Long.valueOf(r(Long.valueOf(r15.f17018a), r29));
        r16[4] = r14;
        r16[5] = r8.optString("scene_tag");
        String r17 = q("time %d: onRequestFailure: {url: %s, requestId: %s, elapsedTime: %d ms, throwable: %s, scene_tag: %s}", r16);
        if (v(r14) == true) goto L74;
        d.i.a.a.a.g("Fresco", r17, r31);
        goto L74
    L69:
        r14 = r23;
    L74:
        if (d.c.i.r.b.d() == false) goto L85;
        d.c.i.r.b.b();
        return;
    L85:
        return;
    L57:
        e = e;
    L62:
        e.printStackTrace();
        goto L63
    L54:
        r12 = false;
        goto L79
    L59:
        r11 = 1;
    L60:
        e = e;
        r11 = 1;
        goto L62
    L64:
        r13 = 0;
        r11 = 1;
        goto L66
    L37:
        r6 = 0;
    L40:
        e = e;
    L44:
        r7 = r19;
        d.c.c.e.a.m("FrescoTraceListener", e, r7, new Object[0]);
    L42:
        e = e;
        goto L44
    L27:
        r3 = com.facebook.net.c.a(r31, null);
        goto L28
    L20:
        if (r27.w() != 0) goto L22;
        r2 = true;
        goto L24
    L22:
        r2 = false;
        goto L24
    L12:
        r0 = "";
        goto L13
    L16:
        r19 = "";
        goto L18
    }

    private void y(d.c.i.q.b r3, String r4, boolean r5, long r6) {
        g r7 = this.f16999a.get(r4);
        if (r7 != null) goto L6;
        return;
    L6:
        if (r7.f17022e == false) goto L15;
        r7.f17022e = false;
        JSONObject r8 = r7.f17020c;
        if (r8 != null) goto L13;
        return;
    L13:
        r8.put("first_intermediate_result", r(Long.valueOf(r7.f17018a), r6));     // Catch: JSONException -> L12
        return;
    L16:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [boolean] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    private void z(d.c.i.q.b r27, String r28, long r29) {
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("FrescoMonitor#onImageLoaded");
    L5:
        g r7 = this.f16999a.remove(r28);
        if (r7 != null) goto L8;
        return;
    L8:
        JSONObject r6 = r7.f17020c;
        if (d.h.a.d.e() == true) goto L11;
        boolean r0 = r6.optBoolean("is_request_network", false);
    L15:
        boolean r16 = r0;
        if (r6.optBoolean("is_request_network", false) == true) goto L18;
    L85:
        Object r1 = r7.f17021d;     // Catch: JSONException -> L36
        if ((r1 instanceof String) == true) goto L87;
    L26:
        r6.put(TypedValues.TransitionType.S_DURATION, r(Long.valueOf(r7.f17018a), r29));     // Catch: JSONException -> L36
        r6.put("load_status", "success");     // Catch: JSONException -> L36
        r6.put("timestamp", Long.valueOf(r7.f17018a));     // Catch: JSONException -> L36
        r6.put("log_type", "image_monitor_v2");     // Catch: JSONException -> L36
        r6.put("log_version", 1);     // Catch: JSONException -> L34
        r6.put("uri", r27.v().toString());     // Catch: JSONException -> L34
        r6.put("image_sdk_version", "1.13.23.4");     // Catch: JSONException -> L34
        if (com.facebook.net.d.a().b() == false) goto L31;
        int r3 = 1;
    L32:
        r6.put("retry_open", r3);     // Catch: JSONException -> L34
    L41:
        if (u(r27, r28, r7.f17021d, r6, true, r16, false) == true) goto L43;
        return;
    L43:
        if (r16 == true) goto L45;
        JSONObject r2 = r6;
        char r4 = 1;
        ?? r5 = 0;
    L71:
        if (r2.optBoolean("is_request_network", r5) == false) goto L76;
        if (d.h.a.d.c() == false) goto L76;
        Object[] r8 = new Object[5];
        r8[r5] = Long.valueOf(r29);
        r8[r4] = r27.v().toString();
        r8[2] = r28;
        r8[3] = Long.valueOf(r(Long.valueOf(r7.f17018a), r29));
        r8[4] = r2.optString("scene_tag");
        d.i.a.a.a.e("Fresco", q("time %d: onRequestSuccess: {url: %s, requestId: %s, elapsedTime: %d ms, scene_tag: %s}", r8));
    L76:
        if (d.c.i.r.b.d() == false) goto L89;
        d.c.i.r.b.b();
        return;
    L89:
        return;
    L45:
        JSONObject r9 = r6;
        JSONObject r10 = r9.optJSONObject("image_monitor_data");     // Catch: JSONException -> L58
        if (r10 != null) goto L49;
        int r11 = 0;
    L65:
        if (d.h.a.c.f() == false) goto L68;
        d.h.a.c.a(r27, r9.optString("applied_image_size"), r9.optLong("file_size"), r9.optString("image_ram_size"));
    L68:
        r4 = 1;
        d.h.a.d.g(true, r28, r9);
        r2 = r9;
        r5 = r11;
        goto L71
    L49:
        int r12 = 0;
        r11 = 0;
        r10.put("image_status", 0);     // Catch: JSONException -> L55
        if (r10.opt("image_origin") != null) goto L53;
        r10.put("image_origin", 7);     // Catch: JSONException -> L55
    L53:
        r10.put("disk_cache_type", h.c(r27.d()));     // Catch: JSONException -> L55
    L55:
        e = e;
    L63:
        d.c.c.e.a.m("FrescoTraceListener", e, "", new Object[r12]);
        r11 = r12;
    L58:
        e = e;
        r12 = 0;
        goto L63
    L31:
        r3 = 0;
    L34:
        e = e;
    L38:
        int r13 = 0;
    L39:
        d.c.c.e.a.m("FrescoTraceListener", e, "", new Object[r13]);
        goto L41
    L87:
        r6.put("scene_tag", r1);     // Catch: JSONException -> L24
    L24:
        e = e;
        r13 = 0;
    L36:
        e = e;
        goto L38
    L18:
        if (d.h.a.d.c() == false) goto L85;
        d.i.a.a.a.e("Fresco", q("time %d: onRequestSuccess: {url: %s, requestId: %s, elapsedTime: %d ms}", new Object[]{Long.valueOf(r29), r27.v().toString(), r28, Long.valueOf(r(Long.valueOf(r7.f17018a), r29))}));
        goto L85
    L11:
        if (r27.w() != 0) goto L13;
        r0 = true;
        goto L15
    L13:
        r0 = false;
        goto L15
    }

    @Override // d.c.i.m.b, d.c.i.m.d
    public void a(d.c.i.q.b r3, Object r4, String r5, boolean r6) {
        long r0 = t();
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("FrescoMonitor#onRequestStart");
    L5:
        g r7 = new g(this);
        r7.f17018a = r0;
        r7.f17021d = r4;
        if (TextUtils.isEmpty(r5) == true) goto L14;
        JSONObject r8 = new JSONObject();
        if (d.h.a.d.f() == true) goto L18;
    L13:
        r7.f17020c = r8;
        goto L14
    L18:
        r8.put("image_monitor_data", new JSONObject());     // Catch: JSONException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
    L14:
        this.f16999a.put(r5, r7);
        if (d.c.i.r.b.d() == false) goto L20;
        d.c.i.r.b.b();
        return;
    }

    @Override // d.c.i.m.b, d.c.i.p.n0
    public void b(String r4, String r5) {
        long r0 = t();
        g r3 = this.f16999a.get(r4);
        if (r3 != null) goto L5;
        return;
    L5:
        StringBuilder r2 = new StringBuilder(r4);
        Map<String, Long> r6 = r3.f17019b;
        r2.append(r5);
        r6.put(r2.toString(), Long.valueOf(r0));
        JSONObject r7 = r3.f17020c;
        if (r7 == null) goto L16;
        JSONObject r8 = r7.optJSONObject("image_monitor_data");     // Catch: JSONException -> L11
        if (r8 == null) goto L17;
        r8.put(r5, new JSONObject());     // Catch: JSONException -> L11
        return;
    L17:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // d.c.i.m.b, d.c.i.m.d
    public void c(d.c.i.q.b r8, String r9, boolean r10) {
        long r4 = t();
        f16998c.submit(new c(this, r8, r9, r4));
    }

    @Override // d.c.i.m.b, d.c.i.p.n0
    public void d(String r1, String r2, @Nullable Map<String, String> r3) {
    }

    @Override // d.c.i.m.b, d.c.i.p.n0
    public void e(String r1, String r2, boolean r3) {
        g r0 = this.f16999a.get(r1);
        if (r0 != null) goto L5;
        return;
    L5:
        JSONObject r4 = r0.f17020c;
        if (r4 != null) goto L15;
        return;
    L15:
        JSONObject r5 = r4.optJSONObject("image_monitor_data");     // Catch: JSONException -> L12
        if (r5 == null) goto L17;
        r5.put("image_origin", h.d(r2));     // Catch: JSONException -> L12
        return;
    L17:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // d.c.i.m.b, d.c.i.p.n0
    public boolean f(String r1) {
        return true;
    }

    @Override // d.c.i.m.b, d.c.i.m.d
    public void g(d.c.i.q.b r9, String r10, Throwable r11, boolean r12) {
        long r4 = t();
        f16998c.submit(new d(this, r9, r10, r4, r11));
    }

    @Override // d.c.i.m.b, d.c.i.p.n0
    public void h(String r1, String r2, String r3) {
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // d.c.i.m.b, d.c.i.p.n0
    public void i(String r33, String r34, @Nullable Map<String, String> r35) {
        long r21 = t();
        g r9 = this.f16999a.get(r33);
        if (r9 != null) goto L5;
        return;
    L5:
        Map<String, Long> r15 = r9.f17019b;
        if (r15.isEmpty() == false) goto L8;
        return;
    L8:
        Long r7 = r15.remove(r33 + r34);
        JSONObject r16 = r9.f17020c;
        if (r16 != null) goto L11;
        return;
    L11:
        JSONObject r26 = null;
        JSONObject r10 = r16.optJSONObject("image_monitor_data");     // Catch: JSONException -> L33
        if (r10 != null) goto L94;
    L31:
        JSONObject r32 = r10;
        String r31 = EnvironmentCompat.MEDIA_UNKNOWN;
        String r30 = "isCrop";
    L32:
        JSONObject r11 = r32;
    L39:
        if (r35 != null) goto L89;
        return;
    L89:
        if ("NetworkFetchProducer".equals(r34) == false) goto L61;
        String r0 = r35.get("content_length");     // Catch: NumberFormatException -> L56 JSONException -> L58
        String r1 = r35.get("image_size");     // Catch: NumberFormatException -> L56 JSONException -> L58
        long r12 = -1;
        if (TextUtils.isEmpty(r0) == true) goto L46;
        long r13 = Long.parseLong(r0);     // Catch: NumberFormatException -> L56 JSONException -> L58
    L48:
        if (TextUtils.isEmpty(r1) == true) goto L50;
        r12 = Long.parseLong(r1);     // Catch: NumberFormatException -> L56 JSONException -> L58
    L50:
        r16.put("file_size", r12);     // Catch: NumberFormatException -> L56 JSONException -> L58
        r16.put("content_length", r13);     // Catch: NumberFormatException -> L56 JSONException -> L58
        if (r13 != r12) goto L53;
        String r2 = LocationInfoConst.ALLOW_USE_LOCATION;
    L54:
        r16.put("file_consistent", r2);     // Catch: NumberFormatException -> L56 JSONException -> L58
        r16.put("hit_cdn_cache", r35.get("hit_cdn_cache"));     // Catch: NumberFormatException -> L56 JSONException -> L58
        r16.put("x_response_cache", r35.get("x_response_cache"));     // Catch: NumberFormatException -> L56 JSONException -> L58
        r16.put("imagex_demotion", r35.get("imagex_demotion"));     // Catch: NumberFormatException -> L56 JSONException -> L58
        r16.put("imagex_want_fmt", r35.get("imagex_want_fmt"));     // Catch: NumberFormatException -> L56 JSONException -> L58
        r16.put("imagex_true_fmt", r35.get("imagex_true_fmt"));     // Catch: NumberFormatException -> L56 JSONException -> L58
        r16.put("imagex_consistency", r35.get("imagex_consistency"));     // Catch: NumberFormatException -> L56 JSONException -> L58
        return;
    L53:
        r2 = BDLocationException.ERROR_TIMEOUT;
        goto L54
    L46:
        r13 = -1;
        goto L48
    L61:
        if ("DiskCacheWriteProducer".equals(r34) == false) goto L65;
        r16.put("image_type", r35.get("imageType"));     // Catch: JSONException -> L58
        return;
    L65:
        if ("DecodeProducer".equals(r34) == false) goto L80;
        String r3 = r35.get("requestedImageSize");     // Catch: NumberFormatException -> L56 JSONException -> L58
        String r4 = r31;
        if (r4.equals(r3) == false) goto L69;
        r3 = "0x0";
    L69:
        r16.put("intended_image_size", r3);     // Catch: NumberFormatException -> L56 JSONException -> L58
        String r5 = r35.get("encodedImageSize");     // Catch: NumberFormatException -> L56 JSONException -> L58
        if ("-1x-1".equals(r5) == false) goto L72;
    L73:
        r5 = r35.get("bitmapSize");     // Catch: NumberFormatException -> L56 JSONException -> L58
    L74:
        String r6 = r30;
        r16.put(r6, r35.get(r6));     // Catch: NumberFormatException -> L56 JSONException -> L58
        r16.put("regionToDecode", r35.get("regionToDecode"));     // Catch: NumberFormatException -> L56 JSONException -> L58
        r16.put("sampleSize", r35.get("sampleSize"));     // Catch: NumberFormatException -> L56 JSONException -> L58
        r16.put("applied_image_size", r5);     // Catch: NumberFormatException -> L56 JSONException -> L58
        r16.put("decode_duration", r21 - r7.longValue());     // Catch: NumberFormatException -> L56 JSONException -> L58
        r16.put("image_type", r35.get("imageFormat"));     // Catch: NumberFormatException -> L56 JSONException -> L58
        r16.put("image_ram_size", r35.get("bitmapRamSize"));     // Catch: NumberFormatException -> L56 JSONException -> L58
        r16.put("image_count", Integer.parseInt(r35.get("imageCount")));     // Catch: NumberFormatException -> L56 JSONException -> L58
        if (r11 == null) goto L77;
        r11.put("decode_queue_duration", Long.parseLong(r35.get("queueTime")));     // Catch: NumberFormatException -> L56 JSONException -> L58
    L77:
        r16.put("image_quality", r35.get("imageQuality"));     // Catch: NumberFormatException -> L56 JSONException -> L58
        return;
    L72:
        if (r4.equals(r5) == false) goto L74;
    L80:
        if ("BackgroundThreadHandoffProducer".equals(r34) == false) goto L85;
        if (r11 == null) goto L100;
        r11.put("pause_time", r35.get("pendingTime"));     // Catch: JSONException -> L58
        return;
    L100:
        return;
    L85:
        if ("PostprocessorProducer".equals(r34) == true) goto L87;
        return;
    L87:
        r16.put("sr_type", r35.get("sr_type"));     // Catch: JSONException -> L58
        r16.put("sr_status", r35.get("sr_status"));     // Catch: JSONException -> L58
        r16.put("sr_duration", r35.get("sr_duration"));     // Catch: JSONException -> L58
        r16.put("sr_width", r35.get("sr_width"));     // Catch: JSONException -> L58
        r16.put("sr_height", r35.get("sr_height"));     // Catch: JSONException -> L58
        r16.put("sr_stretch", r35.get("sr_stretch"));     // Catch: JSONException -> L58
        r16.put("sr_err", r35.get("sr_err"));     // Catch: JSONException -> L58
        return;
    L58:
        e = move-exception;
        e.printStackTrace();
        return;
    L56:
        e = move-exception;
        e.printStackTrace();
        return;
    L94:
        JSONObject r8 = r10.optJSONObject(r34);     // Catch: JSONException -> L27
        if (r8 == null) goto L31;
        r32 = r10;
        long r28 = r7.longValue();     // Catch: JSONException -> L25
        r31 = EnvironmentCompat.MEDIA_UNKNOWN;
        r30 = "isCrop";
        r8.put("producer_start", r28 - Long.valueOf(r9.f17018a).longValue());     // Catch: JSONException -> L23
        r8.put("producer_end", r21 - r9.f17018a);     // Catch: JSONException -> L23
    L23:
        e = e;
    L30:
        r26 = r32;
    L38:
        e.printStackTrace();
        r11 = r26;
    L25:
        e = e;
    L29:
        r31 = EnvironmentCompat.MEDIA_UNKNOWN;
        r30 = "isCrop";
    L27:
        e = e;
        r32 = r10;
    L33:
        e = e;
        r31 = EnvironmentCompat.MEDIA_UNKNOWN;
        r30 = "isCrop";
        goto L38
    }

    @Override // d.c.i.m.b, d.c.i.p.n0
    public void j(String r23, String r24, Throwable r25, @Nullable Map<String, String> r26) {
        long r5 = t();
        g r7 = this.f16999a.get(r23);
        if (r7 != null) goto L5;
        return;
    L5:
        JSONObject r8 = r7.f17020c;
        if (r8 != null) goto L9;
        return;
    L9:
        if (r26 != null) goto L11;
        Map<String, String> r12 = new HashMap();
        r12.put("image_size", "-1");
        r12.put("queue_time", "-1");
        r12.put("fetch_time", "-1");
    L12:
        JSONObject r13 = r8.optJSONObject("image_monitor_data");
        if ("NetworkFetchProducer".equals(r24) == true) goto L66;
        long r18 = r5;
        if ("DecodeProducer".equals(r24) == false) goto L44;
        r8.put("fail_phase", "decode");     // Catch: NumberFormatException -> L29 JSONException -> L31
        r8.put("download_duration", Long.parseLong(r12.get("fetch_time")));     // Catch: NumberFormatException -> L29 JSONException -> L31
        if (r13 == null) goto L44;
        r13.put("decode_queue_duration", Long.parseLong(r12.get("queueTime")));     // Catch: NumberFormatException -> L29 JSONException -> L31
    L44:
        StringBuilder r0 = new StringBuilder(r23);
        Map<String, Long> r4 = r7.f17019b;
        if (r4.isEmpty() == false) goto L47;
        return;
    L47:
        r0.append(r24);
        Long r1 = r4.remove(r0.toString());
        if (d.h.a.d.c() == false) goto L54;
        String r6 = r25.toString();
        long r9 = r18;
        String r2 = q("time %d: onProducerFinishWithFailure: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s, throwable: %s}", new Object[]{Long.valueOf(r18), r23, r24, Long.valueOf(r(r1, r9)), r12, r6});
        if (v(r6) == false) goto L52;
        d.i.a.a.a.f("Fresco", r2);
        Throwable r3 = r25;
    L53:
        d.c.c.e.a.k("Fresco", r2, r3);
    L55:
        if (r13 == null) goto L68;
        JSONObject r10 = r13.optJSONObject(r24);     // Catch: JSONException -> L60
        if (r10 == null) goto L69;
        r10.put("producer_start", r1.longValue() - Long.valueOf(r7.f17018a).longValue());     // Catch: JSONException -> L60
        r10.put("producer_end", r9 - r7.f17018a);     // Catch: JSONException -> L60
        return;
    L69:
        return;
    L60:
        e = move-exception;
        e.printStackTrace();
        return;
    L68:
        return;
    L52:
        r3 = r25;
        d.i.a.a.a.g("Fresco", r2, r3);
        goto L53
    L54:
        r9 = r18;
        goto L55
    L66:
        r8.put("fail_phase", "download");     // Catch: NumberFormatException -> L33 JSONException -> L36
        r8.put("download_duration", -1);     // Catch: NumberFormatException -> L33 JSONException -> L36
        String r11 = r12.get("content_length");     // Catch: NumberFormatException -> L33 JSONException -> L36
        String r14 = r12.get("image_size");     // Catch: NumberFormatException -> L33 JSONException -> L36
        String r15 = r12.get("queue_time");     // Catch: NumberFormatException -> L33 JSONException -> L36
        if (TextUtils.isEmpty(r11) == true) goto L17;
        long r16 = Long.parseLong(r11);     // Catch: NumberFormatException -> L33 JSONException -> L36
    L19:
        if (TextUtils.isEmpty(r14) == true) goto L22;
        long r17 = Long.parseLong(r14);     // Catch: NumberFormatException -> L33 JSONException -> L36
        r18 = r5;
    L24:
        if (TextUtils.isEmpty(r15) == true) goto L26;
        long r19 = Long.parseLong(r15);     // Catch: NumberFormatException -> L29 JSONException -> L31
    L27:
        r8.put("file_size", r17);     // Catch: NumberFormatException -> L29 JSONException -> L31
        r8.put("content_length", r16);     // Catch: NumberFormatException -> L29 JSONException -> L31
        r8.put("queue_duration", r19);     // Catch: NumberFormatException -> L29 JSONException -> L31
        goto L44
    L26:
        r19 = -1;
        goto L27
    L22:
        r18 = r5;
        r17 = -1;
        goto L24
    L17:
        r16 = -1;
    L33:
        e = e;
        r18 = r5;
    L35:
        e.printStackTrace();
    L36:
        e = e;
        r18 = r5;
    L38:
        e.printStackTrace();
    L29:
        e = e;
    L31:
        e = e;
        goto L38
    L11:
        r12 = r26;
        goto L12
    }

    @Override // d.c.i.m.b, d.c.i.m.d
    public void k(String r5) {
        long r0 = t();
        f16998c.submit(new RunnableC0448e(this, r5, r0));
    }

    @Override // d.c.i.m.b
    public void l(d.c.i.q.b r10, String r11, boolean r12) {
        long r5 = t();
        f16998c.submit(new f(this, r10, r11, r12, r5));
    }

    public com.facebook.net.b s() {
        return this.f17000b;
    }
}
