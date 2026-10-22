package com.bytedance.applog.x;

import android.text.TextUtils;
import com.bytedance.applog.o.h;
import com.bytedance.applog.util.n;
import com.bytedance.applog.util.p;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f2490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f2494e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f2495f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f2496g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f2497h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f2498i;

    private d() {
        this.f2492c = false;
        this.f2493d = null;
        this.f2494e = false;
        this.f2495f = null;
        this.f2497h = 0;
        this.f2498i = 0;
    }

    public d(long r3) {
        this.f2492c = false;
        this.f2493d = null;
        this.f2494e = false;
        this.f2495f = null;
        this.f2497h = 0;
        this.f2498i = 0;
        this.f2490a = r3;
        this.f2491b = h.c();
        this.f2498i = h.l();
    }

    public static d b(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L10;
        return null;
    L10:
        JSONObject r1 = new JSONObject(r6);     // Catch: Throwable -> L7
        String r7 = r1.optString("session_id", "");     // Catch: Throwable -> L7
        d r3 = new d();     // Catch: Throwable -> L7
        r3.f2491b = r7;     // Catch: Throwable -> L7
        r3.f2490a = p.l(r1, "start_time");     // Catch: Throwable -> L7
        r3.f2492c = r1.optBoolean("is_front_continuous", false);     // Catch: Throwable -> L7
        r3.f2493d = r1.optString("front_session_id", "");     // Catch: Throwable -> L7
        r3.f2494e = r1.optBoolean("is_end_continuous", false);     // Catch: Throwable -> L7
        r3.f2495f = r1.optString("end_session_id", "");     // Catch: Throwable -> L7
        r3.f2496g = p.l(r1, "latest_end_time");     // Catch: Throwable -> L7
        r3.f2497h = p.l(r1, "non_task_time");     // Catch: Throwable -> L7
        r3.f2498i = p.l(r1, "tea_event_index");     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        n.c("[task] get session from string failed", th);
        return null;
    }

    public void a(long r3) {
        this.f2497h += r3;
    }

    public long c() {
        return Math.max(0, (this.f2496g - this.f2490a) - this.f2497h);
    }

    public String d() {
        return this.f2495f;
    }

    public String e() {
        return this.f2493d;
    }

    public long f() {
        return this.f2496g;
    }

    public String g() {
        return this.f2491b;
    }

    public int h() {
        boolean r0 = this.f2492c;
        boolean r1 = this.f2494e;
        if (r0 == true) goto L7;
        if (r1 == true) goto L7;
        return 1;
    L7:
        if (r0 == false) goto L11;
        if (r1 == true) goto L11;
        return 2;
    L11:
        if (r0 == true) goto L14;
        return 3;
    L14:
        return 4;
    }

    public long i() {
        return this.f2490a;
    }

    public boolean j() {
        return !TextUtils.isEmpty(this.f2495f);
    }

    public boolean k() {
        return !TextUtils.isEmpty(this.f2493d);
    }

    public void l(String r2) {
        this.f2494e = true;
        this.f2495f = r2;
    }

    public void m(String r2) {
        this.f2492c = true;
        this.f2493d = r2;
    }

    public void n(long r1) {
        this.f2496g = r1;
    }

    public String o() {
        JSONObject r0 = new JSONObject();
        r0.put("start_time", this.f2490a);     // Catch: JSONException -> L5
        r0.put("session_id", this.f2491b);     // Catch: JSONException -> L5
        r0.put("is_front_continuous", this.f2492c);     // Catch: JSONException -> L5
        r0.put("front_session_id", this.f2493d);     // Catch: JSONException -> L5
        r0.put("is_end_continuous", this.f2494e);     // Catch: JSONException -> L5
        r0.put("end_session_id", this.f2495f);     // Catch: JSONException -> L5
        r0.put("latest_end_time", this.f2496g);     // Catch: JSONException -> L5
        r0.put("non_task_time", this.f2497h);     // Catch: JSONException -> L5
        r0.put("tea_event_index", this.f2498i);     // Catch: JSONException -> L5
        return r0.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public String toString() {
        return o();
    }
}
