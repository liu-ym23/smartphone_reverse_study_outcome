package com.bytedance.apm.q;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.bytedance.apm.a0.k.h;
import com.bytedance.apm.core.ActivityLifeObserver;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.bytedance.apm.a0.a implements com.bytedance.apm.q.k.a.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1696g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f1697h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f1698i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ConcurrentHashMap<String, C0053b> f1699j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Object f1700k;

    class a implements d.i.c.b {
    }

    /* JADX INFO: renamed from: com.bytedance.apm.q.b$b, reason: collision with other inner class name */
    public class C0053b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f1701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f1702b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f1703c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f1704d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        StringBuilder f1705e;

        long a() {
            return this.f1702b;
        }

        public long b() {
            return this.f1704d;
        }

        float c() {
            return this.f1701a;
        }

        String d() {
            return this.f1705e.toString();
        }

        long e() {
            return this.f1703c;
        }
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f1706a = null;

        static {
            f1706a = new b(null);
        }

        static /* synthetic */ b a() {
            return f1706a;
        }
    }

    private b() {
        this.f1699j = new ConcurrentHashMap();
        this.f1700k = new Object();
        h.e();
        new CopyOnWriteArrayList();
        this.f1122e = "battery";
    }

    /* synthetic */ b(a r1) {
        this();
    }

    private void o() {
        if (TextUtils.isEmpty(this.f1698i) == true) goto L6;
        this.f1698i = null;
        com.bytedance.apm.f0.b.f().m(this);
        d.i.c.a.a();
        q();
        return;
    }

    public static b p() {
        return c.a();
    }

    private void q() {
    }

    @Override // com.bytedance.apm.q.k.a.b
    public void a(boolean r1) {
        if (r1 == false) goto L11;
        Object r2 = this.f1700k;
        monitor-enter(r2);
        o();     // Catch: Throwable -> L8
        monitor-exit(r2);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.a0.a
    protected void c(JSONObject r5) {
        boolean r1 = true;
        if (Build.VERSION.SDK_INT >= 21) goto L5;
    L7:
        r1 = false;
    L8:
        this.f1696g = r1;
        if (r1 == false) goto L11;
        r5.optInt("battery_energy_sample_interval", PathInterpolatorCompat.MAX_NUM_POINTS);
        this.f1697h = r5.optLong("battery_energy_upload_interval", 120000);
        return;
    L11:
        ActivityLifeObserver.getInstance().unregister(this);
        com.bytedance.apm.f0.b.f().m(this);
        return;
    L5:
        if (r5.optInt("energy_enable", 0) != 1) goto L7;
        goto L7
    }

    @Override // com.bytedance.apm.a0.a
    protected boolean f() {
        return !e();
    }

    @Override // com.bytedance.apm.a0.a
    protected void h() {
        com.bytedance.apm.q.k.a.e(com.bytedance.apm.d.h(), this);
    }

    @Override // com.bytedance.apm.a0.a
    protected void i() {
        super.i();
        Iterator<Map.Entry<String, C0053b>> r0 = this.f1699j.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry<String, C0053b> r1 = r0.next();
        JSONObject r5 = new JSONObject();     // Catch: JSONException -> L10
        JSONObject r6 = new JSONObject();     // Catch: JSONException -> L10
        r6.put("scene", r1.getKey());     // Catch: JSONException -> L10
        r5.put("current", r1.getValue().c());     // Catch: JSONException -> L10
        r5.put("capacity", r1.getValue().b());     // Catch: JSONException -> L10
        JSONObject r7 = new JSONObject();     // Catch: JSONException -> L10
        r7.put("cpu_time", r1.getValue().a());     // Catch: JSONException -> L10
        r7.put("traffic", r1.getValue().e());     // Catch: JSONException -> L10
        r7.put("loc", r1.getValue().d());     // Catch: JSONException -> L10
        com.bytedance.apm.t.d.e r2 = new com.bytedance.apm.t.d.e("battery", "", r5, r6, r7);     // Catch: JSONException -> L10
        com.bytedance.apm.a0.b.a(r2, false);     // Catch: JSONException -> L10
        com.bytedance.apm.t.c.a.p().e(r2);     // Catch: JSONException -> L10
        goto L4
    L8:
        this.f1699j.clear();
    }

    @Override // com.bytedance.apm.a0.a
    protected void j() {
        super.j();
    }

    @Override // com.bytedance.apm.a0.a
    protected long n() {
        return this.f1697h;
    }

    @Override // com.bytedance.apm.a0.a, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r1) {
        super.onBackground(r1);
        com.bytedance.apm.f0.b.f().m(this);
        Object r2 = this.f1700k;
        monitor-enter(r2);
        o();     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.a0.a, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r1) {
        super.onFront(r1);
    }
}
