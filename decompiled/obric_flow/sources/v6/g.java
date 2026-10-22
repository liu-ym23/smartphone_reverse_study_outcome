package v6;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.j;
import com.bytedance.salamander.anniex.b0;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.time.DurationKt;
import okhttp3.internal.ws.RealWebSocket;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends s6.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static String f22531u = "bg_never_front";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final b0 f22532v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final b0 f22533w = null;
    public long f;
    public long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f22534h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f22535i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f22536j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f22537k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f22538l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f22539m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f22540n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f22541o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public HashMap f22542p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public HashMap f22543q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public HashMap f22544r;
    public r6.a s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public JSONObject f22545t;

    static {
        f22532v = new b0(20, 9);
        f22533w = new b0(20, 9);
    }

    @Override // s6.a, oj.c
    public final void c(Activity r5) {
        super.c(r5);
        f22531u = "bg_ever_front";
        this.s.m(false);
    }

    @Override // s6.a, oj.c
    public final void f(Activity r5) {
        super.f(r5);
        this.s.m(true);
    }

    @Override // s6.a
    public final void g(JSONObject r10) {
        if (r10.optInt("cause_analysis", 0) != 1) goto L5;
        c r5 = b.f22516a;
        r5.f22517a = true;
        r5.f22518b = true;
        i6.b.f17505a.f17515p = new wc.f(16);
        i6.a.i().f17504c = new com.bytedance.frameworks.baselib.network.http.cronet.b(17);
        this.f = r10.optInt("exception_threshold_mb", 500) * DurationKt.NANOS_IN_MILLIS;
        this.f22534h = r10.optInt("exception_threshold_bg_mb", 500) * DurationKt.NANOS_IN_MILLIS;
        this.f22541o = r10.optInt("high_freq_threshold", 200);
        r5.f22524l = (r10.optDouble("large_usage_threshold_mb", 10.0d) * 1000.0d) * 1000.0d;
        r5.f22525m = r10.optDouble("alog_record_threshold", 100.0d);
    L5:
        this.g = r10.optLong("record_usage_kb", 1) * RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
    L6:
        b0 r11 = f22532v;
        if (((ConcurrentLinkedQueue) r11.f7247c).isEmpty() == true) goto L24;
        j7.b r12 = (j7.b) ((ConcurrentLinkedQueue) r11.f7247c).poll();
        String r13 = (String) ((ConcurrentLinkedQueue) f22533w.f7247c).poll();
        if (r10.optInt(r13, 0) != 1) goto L15;
        b0 r14 = h7.a.f17285a;
        if (r12 == null) goto L18;
        p7.a.a(r12);
    L18:
        if (j.f3887a == false) goto L6;
        StringBuilder r15 = new StringBuilder("isSample:key:");
        if (r10.optInt(r13, 0) != 1) goto L22;
        boolean r16 = true;
    L23:
        r15.append(r16);
        Log.d("Traffic", com.bytedance.android.anniex.base.service.f.o(new String[]{r15.toString()}));
        goto L6
    L22:
        r16 = false;
        goto L23
    L15:
        if (j.f3887a == false) goto L18;
        l6.a.a(r12.f18267a, r12.f18268b);
        goto L18
    L24:
        this.f22545t = r10;
    }

    @Override // s6.a
    public final boolean h() {
        return true;
    }

    @Override // s6.a
    public final void i() {
        if (this.f21823b == true) goto L5;
        f22531u = "bg_ever_front";
    L5:
        long r5 = System.currentTimeMillis();
        long r10 = this.s.h();
        e r11 = (e) this.s.f21695a;
        r11.b();
        long r12 = r11.f22529c;
        e r13 = (e) this.s.f21695a;
        r13.b();
        long r14 = r13.e;
        e r15 = (e) this.s.f21695a;
        r15.b();
        long r16 = r15.f22528b;
        e r17 = (e) this.s.f21695a;
        r17.b();
        long r18 = r17.d;
        if (this.f22535i != (-1)) goto L9;
        this.f22535i = r10;
        this.f22536j = r12;
        this.f22537k = r14;
        this.f22538l = r16;
        this.f22539m = r18;
        this.f22540n = r5;
        return;
    L9:
        JSONArray r19 = new JSONArray();
        long r110 = r10 - this.f22535i;
        long r20 = r12 - this.f22536j;
        long r21 = r14 - this.f22537k;
        long r22 = r16 - this.f22538l;
        long r23 = r18 - this.f22539m;
        long r24 = this.f;
        if (r24 > 0) goto L12;
    L14:
        long r25 = this.f22534h;
        if (r25 > 0) goto L17;
    L22:
        c r26 = b.f22516a;
        sg.a r27 = r26.f22521i;
        if (r27 == null) goto L28;
        if (((PriorityQueue) r27.f21902a).size() <= 0) goto L28;
        r19.put("large_request");
    L28:
        if (d.f22526a.f19562c <= this.f22541o) goto L30;
        r19.put("high_feq_request");
    L30:
        this.f22535i = r10;
        this.f22539m = r18;
        this.f22538l = r16;
        this.f22536j = r12;
        this.f22537k = r14;
        JSONArray r28 = new JSONArray();
        l(r26.f22519c, "usage_10_minutes", r28);
        l(r26.e, "wifi_front", r28);
        l(r26.d, "wifi_back", r28);
        l(r26.g, "mobile_front", r28);
        l(r26.f, "mobile_back", r28);
        JSONObject r29 = new JSONObject();
        if (r28.length() <= 0) goto L69;
        r29.put("usage", r28);     // Catch: Exception -> L63
    L69:
        JSONObject r30 = new JSONObject();     // Catch: JSONException -> L64
        r30.put("usage_10_minutes", r110);     // Catch: JSONException -> L64
        r30.put("mobile_back", r20);     // Catch: JSONException -> L64
        r30.put("mobile_front", r21);     // Catch: JSONException -> L64
        r30.put("wifi_back", r22);     // Catch: JSONException -> L64
        r30.put("wifi_front", r23);     // Catch: JSONException -> L64
        JSONObject r31 = new JSONObject();     // Catch: JSONException -> L64
        j6.e r32 = new j6.e();     // Catch: JSONException -> L64
        JSONObject r33 = new JSONObject();     // Catch: JSONException -> L64
        r33.put("detail", r29);     // Catch: JSONException -> L64
        r33.put("biz_usage", b.f22516a.f22522j);     // Catch: JSONException -> L64
        r33.put("init_ts", this.f22540n);     // Catch: JSONException -> L64
        r33.put("usage_ts", r5);     // Catch: JSONException -> L64
        r32.f18259a = this.d;     // Catch: JSONException -> L64
        r32.f18261c = r31;     // Catch: JSONException -> L64
        r32.f18260b = r30;     // Catch: JSONException -> L64
        r32.e = r33;     // Catch: JSONException -> L64
        s6.a.j(r32);     // Catch: JSONException -> L64
        this.f22540n = r5;     // Catch: JSONException -> L64
        if (r19.length() <= 0) goto L61;
        JSONObject r34 = new JSONObject();     // Catch: JSONException -> L64
        r34.put("exception", true);     // Catch: JSONException -> L64
        r34.put("exception_type", r19);     // Catch: JSONException -> L64
        l9.g r35 = d.f22526a;     // Catch: JSONException -> L64
        monitor-enter(r35);     // Catch: JSONException -> L64
        HashMap r36 = (HashMap) r35.d;     // Catch: Throwable -> L59
        monitor-exit(r35);     // Catch: JSONException -> L64
        if (r36 == null) goto L47;
        Iterator r37 = r36.entrySet().iterator();     // Catch: JSONException -> L64
        JSONArray r38 = new JSONArray();     // Catch: JSONException -> L64
    L42:
        if (r37.hasNext() == false) goto L46;
        Map.Entry r39 = (Map.Entry) r37.next();     // Catch: JSONException -> L64
        if (((i) r39.getValue()).d <= this.f22541o) goto L42;
        JSONObject r40 = new JSONObject();     // Catch: JSONException -> L64
        r40.put(SVGRenderEngine.PATH, ((i) r39.getValue()).f22547a);     // Catch: JSONException -> L64
        r40.put("freq", ((i) r39.getValue()).d);     // Catch: JSONException -> L64
        r40.put("biz", ((i) r39.getValue()).f22548b);     // Catch: JSONException -> L64
        r38.put(r40);     // Catch: JSONException -> L64
        goto L42
    L46:
        r29.put("high_freq", r38);     // Catch: JSONException -> L64
    L47:
        if (r27 == null) goto L55;
        ArrayList r41 = new ArrayList((PriorityQueue) r27.f21902a);     // Catch: JSONException -> L64
        Collections.sort(r41);     // Catch: JSONException -> L64
        if (r41.size() <= 0) goto L55;
        JSONArray r42 = new JSONArray();     // Catch: JSONException -> L64
        Iterator r43 = r41.iterator();     // Catch: JSONException -> L64
    L52:
        if (r43.hasNext() == false) goto L54;
        i r44 = (i) r43.next();     // Catch: JSONException -> L64
        JSONObject r45 = new JSONObject();     // Catch: JSONException -> L64
        r45.put(SVGRenderEngine.PATH, r44.f22547a);     // Catch: JSONException -> L64
        r45.put("usage", r44.f22549c);     // Catch: JSONException -> L64
        r45.put("biz", r44.f22548b);     // Catch: JSONException -> L64
        r42.put(r45);     // Catch: JSONException -> L64
        goto L52
    L54:
        r29.put("large_usage", r42);     // Catch: JSONException -> L64
    L55:
        r34.put("biz_usage", b.f22516a.f22522j);     // Catch: JSONException -> L64
        r34.put("detail", r29);     // Catch: JSONException -> L64
        j6.e r46 = new j6.e();     // Catch: JSONException -> L64
        r46.f18259a = this.d;     // Catch: JSONException -> L64
        r46.f18261c = r31;     // Catch: JSONException -> L64
        r46.f18260b = r30;     // Catch: JSONException -> L64
        r46.e = r34;     // Catch: JSONException -> L64
        s6.a.j(r46);     // Catch: JSONException -> L64
        goto L61
    L59:
        th = move-exception;
        throw th;     // Catch: JSONException -> L64
    L61:
        boolean r47 = j.f3887a;
        throw null;
    L17:
        if ((r20 + r22) <= r25) goto L22;
        if (TextUtils.equals(f22531u, "bg_never_front") == false) goto L21;
        r19.put("never_front_usage_abnormal");
        goto L22
    L21:
        r19.put("bg_usage_abnormal");
        goto L22
    L12:
        if (r110 <= r24) goto L14;
        r19.put("total_usage_abnormal");
        goto L22
    }

    @Override // s6.a
    public final long k() {
        return 600000;
    }

    public final void l(HashMap r5, String r10, JSONArray r11) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.size() != 0) goto L17;
        return;
    L17:
        Iterator r12 = r5.entrySet().iterator();     // Catch: Exception -> L16
    L8:
        if (r12.hasNext() == false) goto L24;
        JSONObject r13 = ((a) ((Map.Entry) r12.next()).getValue()).c(this.g);     // Catch: Exception -> L16
        if (TextUtils.isEmpty(r10) == true) goto L13;
        r13.put("traffic_category", r10);     // Catch: Exception -> L16
    L13:
        r11.put(r13);     // Catch: Exception -> L16
        goto L8
    L24:
        return;
    }
}
